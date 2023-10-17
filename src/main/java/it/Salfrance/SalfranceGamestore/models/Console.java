package it.Salfrance.SalfranceGamestore.models;

import it.Salfrance.SalfranceGamestore.enums.TipologiaColore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Console")
@Data//abbiamo usato l'annotazione di lombook
public class Console {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "è obbligatorio inserire la marca")
    @Length(min=3,max = 30)
    private String marca;

    @NotBlank(message = "è obbligatorio inserire il modello")
    @Length(min=3,max = 30)
    private String modello;

    @Min(value = 1, message = "Il valore deve essere maggiore di zero")
    private double prezzo;

    @Enumerated(EnumType.STRING)
    private TipologiaColore colore;

    @Min(value = 100, message = "Il valore deve essere maggiore di zero")
    private int hardDisk;

    private String urlImmagine;

    private String descrizione;

    @Min(value = 0, message = "Il valore deve essere maggiore di zero")
    private int quantitaDisponibile;

}
