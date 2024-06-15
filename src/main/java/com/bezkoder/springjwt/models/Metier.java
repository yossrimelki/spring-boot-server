package com.bezkoder.springjwt.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Metier")
public class Metier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private long id;

    @NotBlank
    @Size(max = 20)
    @Column(unique = true, nullable = false)
    private String title;

    @NotBlank
    @Size(max = 255)
    private String description;

    // Many-to-Many relationship with Formation
    // One-to-Many relationship with Formation

    // One-to-Many relationship with GrillePolyvalence
    @OneToMany(mappedBy = "metier")
    @JsonIgnore
    private Set<GrillePolyvalence> grillePolyvalences = new HashSet<>();

    // Constructors, getters, setters...

    public Metier() {}

    public Metier(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Set<GrillePolyvalence> getGrillePolyvalences() {
        return grillePolyvalences;
    }

    public void setGrillePolyvalences(Set<GrillePolyvalence> grillePolyvalences) {
        this.grillePolyvalences = grillePolyvalences;
    }
}
