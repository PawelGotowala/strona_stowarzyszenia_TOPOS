package pl.gotowala.strona_stowarzyszenia_topos.utility;

import org.springframework.data.jpa.domain.Specification;
import pl.gotowala.strona_stowarzyszenia_topos.model.Member;
import pl.gotowala.strona_stowarzyszenia_topos.model.SearchParams;

import javax.persistence.criteria.*;
import java.lang.reflect.WildcardType;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MemberSpecification implements Specification<Member> {
    private SearchParams params;
    private static final String WILDCARD = "%";

    public MemberSpecification(SearchParams params) {
        this.params = params;
    }

    @Override
    public Predicate toPredicate(Root<Member> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        Predicate firstLikePredicate = criteriaBuilder.like(root.get("firstName"), params.getFirstName()+ WILDCARD);
        Predicate secondLikePredicate = criteriaBuilder.like(root.get("secondName"), params.getSecondName()+ WILDCARD);
        Predicate lastLikePredicate = criteriaBuilder.like(root.get("lastName"), params.getLastName()+ '%');
        Predicate familyNLikePredicate = criteriaBuilder.like(root.get("familyName"), params.getFamilyName()+ WILDCARD);

        Predicate birthDatePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("birthDate"),LocalDate.parse("1000-01-01"));
        switch (params.getBirthDate()){
            case "opcja1":
                birthDatePredicate = criteriaBuilder.lessThanOrEqualTo(root.get("birthDate"), LocalDate.parse("1945-12-12"));
                break;
            case "opcja2":
                birthDatePredicate = criteriaBuilder.between(root.get("birthDate"),LocalDate.parse("1946-01-01"),LocalDate.parse("1959-12-12"));
                break;
            case "opcja3":
                birthDatePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("birthDate"),LocalDate.parse("1960-01-01"));
                break;
        }

        Predicate birthPLikePredicate = criteriaBuilder.like(root.<String>get("birthPlace"), params.getBirthPlace()+ WILDCARD);
        Predicate familyALikePredicate = criteriaBuilder.like(root.<String>get("familyAddressDuringBirth"), params.getFamilyAddress() + WILDCARD);

       return  criteriaBuilder.and(firstLikePredicate,secondLikePredicate,lastLikePredicate,familyNLikePredicate,birthDatePredicate,birthPLikePredicate,familyALikePredicate);

    }

}
