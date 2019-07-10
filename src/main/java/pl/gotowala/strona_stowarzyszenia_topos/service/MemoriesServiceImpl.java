package pl.gotowala.strona_stowarzyszenia_topos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pl.gotowala.strona_stowarzyszenia_topos.model.Memory;
import pl.gotowala.strona_stowarzyszenia_topos.repository.MemoriesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoriesServiceImpl implements MemoriesService {

    private MemoriesRepository memoriesRepository;
    @Autowired
    public MemoriesServiceImpl(MemoriesRepository memoriesRepository) {
        this.memoriesRepository = memoriesRepository;
    }

    @Override
    public void removeById(Long id) {
        memoriesRepository.deleteById(id);
    }

    @Override
    public void addMemories(Memory memory) {
        memoriesRepository.save(memory);
    }
    private static final int PAGE_SIZE_MEMORY = 10;

    @Override
    public Page<Memory> getAllMemoriesPageable(String pageNo) {
        int goToPageNo = Integer.parseInt(pageNo);
        return memoriesRepository.findAll(PageRequest.of(goToPageNo,PAGE_SIZE_MEMORY));
    }

    @Override
    public List<Integer> getPageNumberList(int listCount) {
        List<Integer> pageNumbersList = new ArrayList<>();
        int lastPageNo;
        if(listCount%PAGE_SIZE_MEMORY != 0){
            lastPageNo = (listCount / PAGE_SIZE_MEMORY) +1;
        }else lastPageNo = (listCount / PAGE_SIZE_MEMORY);

        for(int i = 1; i <= lastPageNo ; i++ ){
            pageNumbersList.add(i);
        }
        return pageNumbersList;
    }

    @Override
    public int getListSize() {
       return (int) memoriesRepository.count();
    }


}
