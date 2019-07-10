package pl.gotowala.strona_stowarzyszenia_topos.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.gotowala.strona_stowarzyszenia_topos.model.Memory;

public interface MemoriesRepository extends JpaRepository<Memory,Long> {
}
