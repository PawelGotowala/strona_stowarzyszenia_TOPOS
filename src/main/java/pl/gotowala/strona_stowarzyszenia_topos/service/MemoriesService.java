package pl.gotowala.strona_stowarzyszenia_topos.service;


import org.springframework.data.domain.Page;
import pl.gotowala.strona_stowarzyszenia_topos.model.Memory;

import java.util.List;

public interface MemoriesService {

    void removeById(Long id);
    void addMemories(Memory memory);
    Page<Memory> getAllMemoriesPageable(String pageNo);
    List<Integer> getPageNumberList(int listCount);

    int getListSize();

    void saveAndAddMemoriesToLoggedUser(Memory memory);

    void update(Long memoryId, String oneMemoryUpdate, String signatureUpdate);
}
