package it.Salfrance.SalfranceGamestore.models;

import it.Salfrance.SalfranceGamestore.enums.TipologiaAccessorio;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@Table(name = "Accessori")

public class Accessorio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Length(min = 1 , max = 20)
    @NotBlank(message = "inserire un nome")
    private String nome;

    @Column
    @Enumerated(EnumType.STRING) //enum
    private TipologiaAccessorio tipologia;

    @Column
    @Length(min = 1 , max = 20)
    @NotBlank(message = "inserire una marca")
    private String marca;

    @Column(nullable = false)
    @Min(0)
    @Max(300)
    private double prezzo;

    @Column
    @Length(min = 1 , max = 3000)
    @NotBlank(message = "descrizione vuota o troppo lunga")
    private String descrizione;


    @Column(nullable = false)
    @Min(0)
    @Max(400)
    private int quantita_disponibili;
}
