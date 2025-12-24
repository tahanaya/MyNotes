package com.example.mynotes2.models;

import java.io.Serializable;

public class Note implements Serializable {
    private String nom;
    private String description;
    private String date;
    private String priorite;
    private String photoPath;

    public Note(String nom, String description, String date, String priorite) {
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.priorite = priorite;
        this.photoPath = "";
    }

    // Getters
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
    public String getPriorite() { return priorite; }
    public String getPhotoPath() { return photoPath; }

    // Setters
    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setDate(String date) { this.date = date; }
    public void setPriorite(String priorite) { this.priorite = priorite; }
    public void setPhotoPath(String photoPath) { this.photoPath = photoPath; }
}