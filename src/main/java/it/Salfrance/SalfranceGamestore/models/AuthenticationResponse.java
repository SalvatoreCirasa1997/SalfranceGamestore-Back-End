package it.Salfrance.SalfranceGamestore.models;

import lombok.Data;

@Data
public class AuthenticationResponse {
    private String token;

    public AuthenticationResponse(String jwtToken) {
        this.token = jwtToken;
    }
}
