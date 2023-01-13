package modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Asociacion {
    @Id
    int id;
    String nombre;

    @OneToMany(mappedBy = "asociacion",cascade = CascadeType.MERGE)
    List<Club> clubes;

    @Override
    public String toString() {
        return "Asociacion{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
