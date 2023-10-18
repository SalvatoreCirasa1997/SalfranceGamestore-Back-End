package it.Salfrance.SalfranceGamestore.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.Salfrance.SalfranceGamestore.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table(name="Utente")
@Data
public class Utente implements UserDetails {
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

    @Length(min = 3, max = 50)
    @NotBlank(message="è obbligatorio inserire la tua email")
    private String email;

    @Length(min = 3, max = 15)
    @NotBlank(message="è obbligatorio inserire il tuo username")
    private String username;

    @NotBlank(message="è obbligatorio inserire la password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
