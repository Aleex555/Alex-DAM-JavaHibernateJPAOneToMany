package com.project;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Ciutat")
public class Ciutat implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ciutatId", unique = true, nullable = false)
    private long ciutatId;
   
    @Column(name = "nom")
    private String nom;  

    @Column(name = "pais")
    private String pais;

    @Column(name = "codiPostal")
    private int codiPostal;

    public Ciutat() {}

    public Ciutat(String nom, String pais, int codiPostal) {
        this.nom = nom;
        this.pais = pais;
        this.codiPostal = codiPostal;
    }

    public long getCiutatId() {
        return ciutatId;
    }

    public void setCiutatId(long ciutatId) {
        this.ciutatId = ciutatId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public List<Object[]> queryCiutadans() {
        long id = this.getCiutatId();
        return Manager.queryTable("SELECT DISTINCT c.ciutatId, c.nom FROM Ciutada c WHERE c.ciutatId = " + id);
    }

    @Override
    public String toString() {
        return "Ciutat " + ciutatId + ": " + nom + ", " + pais + ", " + codiPostal ;
    }
}
