package pl.gotowala.strona_stowarzyszenia_topos.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import pl.gotowala.strona_stowarzyszenia_topos.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.gotowala.strona_stowarzyszenia_topos.utility.MemberSpecification;

import java.util.List;
import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member , Long>, JpaSpecificationExecutor<Member> {


    void deleteMemberByAlbumNumber(int albumNumber);

    Optional<Member> findMemberByAlbumNumber(int albumNumber);

}
