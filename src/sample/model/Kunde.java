package sample.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Kunde {

    private int kundeID;
    private String navn;

    public Kunde(int kundeID) {
        this.kundeID = kundeID;
    }

    public Kunde(int kundeID, String navn) {
        this.kundeID = kundeID;
        this.navn = navn;
    }

    // Gettere & settere
    public int getKundeID() {
        return kundeID;
    }

    public void setKundeID(int kundeID) {
        this.kundeID = kundeID;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
}
