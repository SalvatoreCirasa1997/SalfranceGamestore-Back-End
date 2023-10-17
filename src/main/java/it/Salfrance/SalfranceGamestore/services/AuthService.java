package it.Salfrance.SalfranceGamestore.services;

import it.Salfrance.SalfranceGamestore.enums.Role;
import it.Salfrance.SalfranceGamestore.models.AuthenticationResponse;
import it.Salfrance.SalfranceGamestore.models.LoginModel;
import it.Salfrance.SalfranceGamestore.models.SignUpModel;
import it.Salfrance.SalfranceGamestore.models.Utente;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final UtenteService utenteService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService, PasswordEncoder passwordEncoder,  UtenteService utenteService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.utenteService = utenteService;
    }

    public AuthenticationResponse login(LoginModel loginModel){
        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginModel.getUsername(),
                        loginModel.getPassword()
                )
        );
        UserDetails userModel = this.utenteService.loadUserByUsername(loginModel.getUsername());
        String jwtToken = this.jwtService.generateToken(userModel);
        return new AuthenticationResponse(jwtToken);
    }

    public AuthenticationResponse signUp(SignUpModel signUpModel){
        Utente userModel = new Utente();
        userModel.setNome(signUpModel.getNome());
        userModel.setUsername(signUpModel.getUsername());
        userModel.setPassword(passwordEncoder.encode(signUpModel.getPassword()));
        userModel.setCognome(signUpModel.getCognome());
        userModel.setEmail(signUpModel.getEmail());
        userModel.setRole(Role.USER);

        Utente userNew = this.utenteService.addUtente(userModel);
        String jwtToken = this.jwtService.generateToken((UserDetails) userNew);
        return new AuthenticationResponse(jwtToken);
    }
}
