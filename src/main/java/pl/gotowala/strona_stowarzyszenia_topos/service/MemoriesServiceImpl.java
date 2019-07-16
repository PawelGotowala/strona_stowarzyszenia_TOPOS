package pl.gotowala.strona_stowarzyszenia_topos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gotowala.strona_stowarzyszenia_topos.model.AppUser;
import pl.gotowala.strona_stowarzyszenia_topos.model.Memory;
import pl.gotowala.strona_stowarzyszenia_topos.repository.AppUserRepository;
import pl.gotowala.strona_stowarzyszenia_topos.repository.MemoriesRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoriesServiceImpl implements MemoriesService {

    private MemoriesRepository memoriesRepository;
    private AppUserRepository appUserRepository;
    @Autowired
    public MemoriesServiceImpl(MemoriesRepository memoriesRepository, AppUserRepository appUserRepository) {
        this.memoriesRepository = memoriesRepository;
        this.appUserRepository = appUserRepository;
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

    @Transactional
    @Override
    public void saveAndAddMemoriesToLoggedUser(Memory memory) {
      Memory savedMemory = memoriesRepository.save(memory);
      String userName = SecurityContextHolder.getContext().getAuthentication().getName();
      Optional<AppUser> appUserUpdateOptional = appUserRepository.findByEmail(userName);
      AppUser appUserUpdate = appUserUpdateOptional.get();
      appUserUpdate.getMemories().add(savedMemory);
      appUserRepository.save(appUserUpdate);
    }


}
