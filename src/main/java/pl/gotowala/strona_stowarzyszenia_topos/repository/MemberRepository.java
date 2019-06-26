package pl.gotowala.strona_stowarzyszenia_topos.repository;


import pl.gotowala.strona_stowarzyszenia_topos.model.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member , Long> {


    void deleteMemberByAlbumNumber(String albumNumber);

    Optional<Member> findMemberByAlbumNumber(String albumNumber);

    List<Member> findByLastNameLike(String lastName, Pageable pageable);



}
