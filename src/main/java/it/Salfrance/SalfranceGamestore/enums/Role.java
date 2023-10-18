package it.Salfrance.SalfranceGamestore.enums;

public enum Role  {
    USER("ROLE_USER"),ADMIN("ROLE_ADMIN");
    private final String ruolo;

    Role(String ruolo) {
        this.ruolo = ruolo;
    }


    public String getRuolo() {
        return ruolo;
    }

    public String getRuoloTrimmed() {return ruolo.substring(5);}

}
