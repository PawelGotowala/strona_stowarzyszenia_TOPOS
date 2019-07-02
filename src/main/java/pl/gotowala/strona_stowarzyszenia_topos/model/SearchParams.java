package pl.gotowala.strona_stowarzyszenia_topos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchParams {
    private String firstName;
    private String secondName;
    private String lastName;
    private String familyName;
    private String birthDate;
    private String birthPlace;
    private String familyAddress;
}
