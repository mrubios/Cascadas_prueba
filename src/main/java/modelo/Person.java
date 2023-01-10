package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@NoArgsConstructor@AllArgsConstructor@Builder@Data
@Entity
public class Person {

    @Id
    String dni;
    String name;
    String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    IdCard tarjeta;



}