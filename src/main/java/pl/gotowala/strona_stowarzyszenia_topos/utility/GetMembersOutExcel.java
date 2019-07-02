package pl.gotowala.strona_stowarzyszenia_topos.utility;

import pl.gotowala.strona_stowarzyszenia_topos.model.Member;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class GetMembersOutExcel {
    public List<Member> creatListOfMemberFromExcelFile(String sciezka) throws IOException {
        List<Member> members = new ArrayList<>();
        File excelFile = new File(sciezka);
        FileInputStream fis = new FileInputStream(excelFile);

        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // we get first sheet
        XSSFSheet sheet = workbook.getSheetAt(0);
        // we iterate on rows
        Iterator<Row> rowIt = sheet.iterator();
        
        while(rowIt.hasNext()) {
            Row row = rowIt.next();

            Iterator<Cell> cellIterator = row.cellIterator();
            List<String> member = new ArrayList<>();

            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                member.add(cell.toString());
            }

           double parseDouble = Double.parseDouble(member.get(0));
            int albumN = (int) parseDouble;

            LocalDate birthDate;
            if(member.get(6).equals("#")){
             birthDate = LocalDate.parse("1000-01-01");
            }else {
                birthDate = LocalDate.parse(member.get(6), DateTimeFormatter.ofPattern("d-MMM-yyyy")); }

            Member trueMember = new Member(albumN,member.get(1),member.get(2),member.get(3),member.get(4),member.get(5),birthDate,member.get(7),member.get(8),member.get(9));
             members.add(trueMember);
        }
        workbook.close();
        fis.close();
        return members;
    }

    private GetMembersOutExcel() {
    }
}

