package it.Salfrance.SalfranceGamestore.models;

import lombok.Data;

@Data
public class SignUpModel {
    private String nome;
    private String username;
    private String password;
    private String cognome;
    private String email;
}
