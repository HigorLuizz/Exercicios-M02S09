package tech.devinhouse.entity;


import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Se o nome da coluna do banco de dados não for igual ao nome do atributo, colocar o @Column
    @Column(name = "name")
    @NotNull
    private String name;

    @NotNull
    private String email;


    private Boolean status;
}
