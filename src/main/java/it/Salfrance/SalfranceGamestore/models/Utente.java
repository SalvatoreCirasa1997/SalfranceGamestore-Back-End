package it.Salfrance.SalfranceGamestore.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Entity
@Table(name="Utente")
@Data
public class Utente {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //@NotBlank(message="la data di nascita deve essere per forza inserita")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDiNascita;

    @NotBlank(message="è obbligatorio inserire il nome")
    @Length(min = 3, max = 20)
    private String nome;

    @NotBlank(message="è obbligatorio inserire il cognome")
    @Length(min = 3, max = 20)
    private String cognome;

    @Length(min = 3, max = 20)
    @NotBlank(message="è obbligatorio inserire la tua email")
    private String email;

    @Length(min = 3, max = 15)
    @NotBlank(message="è obbligatorio inserire il tuo username")
    private String username;

    @Length(min = 3, max = 15)
    @NotBlank(message="è obbligatorio inserire la password")
    private String password;


}
