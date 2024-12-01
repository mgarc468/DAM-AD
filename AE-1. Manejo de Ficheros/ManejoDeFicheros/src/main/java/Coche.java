import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Coche implements Serializable {
    private int id;
    private String matricula;
    private String marca;
    private String modelo;
    private String color;

    public int getId() {
        return id;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Coche [ID=" + id + ", Matrícula=" + matricula + ", Marca=" + marca +
                ", Modelo=" + modelo + ", Color=" + color + "]";
    }
}
