package pl.gotowala.strona_stowarzyszenia_topos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SequenceGenerator(name= "seqMem")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "seqMem")
    private Long id;

    private int albumNumber;
    private String albumNumberOut;
    private String firstName;
    private String secondName;
    private String lastName;
    private String familyName;

    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private String birthDate;

    private String birthPlace;
    private String familyAddressDuringBirth;
    private String actualAddress;

    public Member(int albumNumber, String albumNumberOut, String firstName, String secondName, String lastName, String familyName, String birthDate, String birthPlace, String familyAddressDuringBirth, String actualAddress) {
        this.albumNumber = albumNumber;
        this.albumNumberOut = albumNumberOut;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.familyName = familyName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.familyAddressDuringBirth = familyAddressDuringBirth;
        this.actualAddress = actualAddress;
    }
}
