package it.Salfrance.SalfranceGamestore.models;
import it.Salfrance.SalfranceGamestore.enums.TipologiaVideogioco;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "videogiochi")
public class Videogioco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Length(min = 2, max = 45)
    private String nome;

    @Column(nullable = false)
    @Min(3)
    @Max(18)
    private int pegi;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) //enum
    private TipologiaVideogioco tipologia;

    @Column(nullable = false)
    private boolean digitale;

    @Column(nullable = false)
    @Min(0)
    @Max(300)
    private double prezzo;

    @Column
    private boolean online;

    @Column(nullable = false)
    private String icona;

    @Column
    @Min(0)
    @Max(500)
    private int quantita_disponibili;

    @Column(nullable = false)
    @Length(min = 0,max = 4000)
    private String descrizione;

}
