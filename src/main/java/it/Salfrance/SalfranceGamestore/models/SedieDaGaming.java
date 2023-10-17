package it.Salfrance.SalfranceGamestore.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name="SedieDaGaming")
@Data
public class SedieDaGaming {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   @NotBlank(message = "devi per forza inserire la marca")
    private String marca;
    @NotBlank(message = "devi per forza inserire il modello")
    private String modello;
    @NotBlank(message = "devi per forza inserire il colore")
    private String colore;
    private boolean ruoto;
    private boolean regolabile;
    @Min(value = 0, message = "Il valore deve essere maggiore di zero")
    private int quantitaDisponibili;
}
