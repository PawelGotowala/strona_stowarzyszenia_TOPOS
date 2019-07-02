package pl.gotowala.strona_stowarzyszenia_topos.service;


import pl.gotowala.strona_stowarzyszenia_topos.model.Member;
import org.springframework.data.domain.Page;
import pl.gotowala.strona_stowarzyszenia_topos.utility.MemberSpecification;

import java.io.IOException;
import java.util.List;

public interface MemberService {

    List<Member> getAllMembers();
    Page<Member> getAllMembersPageable(String pageNo);
    List<Integer> getPageNumberList(int listCount);

    void addMembersListFromExcel(String sciezka) throws IOException;

    void addMember(Member member);

    void removeMemberByAlbumNumber(int albumNumber);

    void update(int albumNumber, Member memberUpdate);

    int getListSize();

    Page<Member> find(MemberSpecification memberSpecification, String pageNo);
}
