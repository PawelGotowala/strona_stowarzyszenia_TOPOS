package pl.gotowala.strona_stowarzyszenia_topos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Memory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String oneMemory;

    private String signature;

    public Memory(String oneMemory,String signature) {
        this.oneMemory = oneMemory;
        this.signature = signature;
    }
}
