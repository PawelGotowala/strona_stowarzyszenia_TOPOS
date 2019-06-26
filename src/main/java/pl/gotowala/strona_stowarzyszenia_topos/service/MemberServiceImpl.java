package pl.gotowala.strona_stowarzyszenia_topos.service;


import pl.gotowala.strona_stowarzyszenia_topos.model.Member;
import pl.gotowala.strona_stowarzyszenia_topos.repository.AppUserRepository;
import pl.gotowala.strona_stowarzyszenia_topos.repository.MemberRepository;
import pl.gotowala.strona_stowarzyszenia_topos.utility.GetMembersOutExcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService {
//todo: wyswietlanie listy nie uporzadkowane
//todo: obslurzyc jakos ten wyjatek lepiej
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private GetMembersOutExcel getMembersOutExcel;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserService userService;

    @Override
    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    // Dzielenie stron
    private static final int PAGE_SIZE = 50;

    @Override
    public Page<Member> getAllMembersPageable(String pageNo) {
        int goToPageNo = Integer.parseInt(pageNo);

        return memberRepository.findAll(PageRequest.of(goToPageNo,PAGE_SIZE));
    }

    @Override
    public List<Integer> getPageNumberList() {
        List<Integer> pageNumbersList = new ArrayList<>();
        int lastPageNo;
        int totalMembersCount = (int) memberRepository.count();

        if(totalMembersCount%PAGE_SIZE != 0){
            lastPageNo = (totalMembersCount / PAGE_SIZE) +1;
        }else lastPageNo = (totalMembersCount / PAGE_SIZE);

        for(int i = 1; i <= lastPageNo ; i++ ){
            pageNumbersList.add(i);
        }

        return pageNumbersList;
    }
//


    @Transactional
    @Override
    public void addMembersListFromExcel(String sciezka)  {
        List<Member> memberList = null;
        try {
            memberList = getMembersOutExcel.creatListOfMemberFromExcelFile(sciezka);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(!(memberList == null)) {
            appUserRepository.deleteAppUserByIdAfter(4L);
            memberRepository.deleteAll();

            for (Member member : memberList) {
               String userName = String.valueOf(member.getAlbumNumber());
               String password = member.getFirstName();
                userService.registerUser(userName,password,password);
            }
            memberRepository.saveAll(memberList);
        }
    }

    @Transactional
    @Override
    public void addMember(Member member) {
        String userName = String.valueOf(member.getAlbumNumber());
        String password = member.getFirstName();
        userService.registerUser(userName,password,password);
        memberRepository.save(member);
    }

    @Transactional
    @Override
    public void removeMemberByAlbumNumber(String albumNumber) {
        memberRepository.deleteMemberByAlbumNumber(albumNumber);
    }

    @Override
    public void update(String albumNumber, Member memberUpdate) {
        Optional<Member> optionalMember = memberRepository.findMemberByAlbumNumber(albumNumber);
        if(!optionalMember.isPresent()){
            throw new EntityNotFoundException("Nie ma takiego numeru albumu");
        }

        Member member = optionalMember.get();
        if(!memberUpdate.getActualAddress().isEmpty()){
        member.setActualAddress(memberUpdate.getActualAddress());}
       /* if(!memberUpdate.getAlbumNumber().isEmpty()){
        member.setAlbumNumberOut(memberUpdate.getAlbumNumberOut());}
       */
       if(!memberUpdate.getBirthDate().isEmpty()){
        member.setBirthDate(memberUpdate.getBirthDate());}
        if(!memberUpdate.getBirthPlace().isEmpty()){
        member.setBirthPlace(memberUpdate.getBirthPlace());}
        if(!memberUpdate.getFamilyAddressDuringBirth().isEmpty()){
        member.setFamilyAddressDuringBirth(memberUpdate.getFamilyAddressDuringBirth());}
        if(!memberUpdate.getFamilyName().isEmpty()){
        member.setFamilyName(memberUpdate.getFamilyName());}
        if(!memberUpdate.getFirstName().isEmpty()){
        member.setFirstName(memberUpdate.getFirstName());}
        if(!memberUpdate.getSecondName().isEmpty()){
        member.setSecondName(memberUpdate.getSecondName());}
        if(!memberUpdate.getLastName().isEmpty()){
        member.setLastName(memberUpdate.getLastName());}

        memberRepository.save(member);
    }


}
