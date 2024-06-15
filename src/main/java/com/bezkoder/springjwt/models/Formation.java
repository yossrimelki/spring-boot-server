package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Formation")
@Data
public class Formation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ecole;

    private String title;

    private String fabrication;

    private String critereQualite;

    @ManyToOne
    @JoinColumn(name = "programF_id")
    private ProgramF programF;

    // Many-to-Many relationship with Metier
    @ManyToMany
    @JoinTable(
            name = "formation_metier",
            joinColumns = @JoinColumn(name = "formation_id"),
            inverseJoinColumns = @JoinColumn(name = "metier_id")
    )
    private Set<Metier> metiers = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFabrication() {
        return fabrication;
    }

    public void setFabrication(String fabrication) {
        this.fabrication = fabrication;
    }

    public String getCritereQualite() {
        return critereQualite;
    }

    public void setCritereQualite(String critereQualite) {
        this.critereQualite = critereQualite;
    }

    public ProgramF getProgramF() {
        return programF;
    }

    public void setProgramF(ProgramF programF) {
        this.programF = programF;
    }

}
