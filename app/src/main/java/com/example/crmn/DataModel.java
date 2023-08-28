package com.example.crmn;

public class DataModel {
    private String nom;
    private String grade;
    private String etablissement;
    private String num;
    private String email;

    private String date;
    private String heur_entre;
    private String heur_sortie;
    private String responsable;
    private String platforme;

    public DataModel(String nom, String grade, String etablissement, String num, String email,String date,String heur_entre,String heur_sortie,String responsable ,String platforme) {
        this.nom = nom;
        this.grade = grade;
        this.etablissement = etablissement;
        this.num = num;
        this.email = email;


        this.date=date;
        this.heur_entre =heur_entre;
        this.heur_sortie=heur_sortie;
        this.responsable=responsable;
        this.platforme=platforme;
    }

    public String getNom() {
        return nom;
    }

    public String getGrade() {
        return grade;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public String getNum() {
        return num;
    }

    public String getEmail() {
        return email;
    }



    public String getDate(){return date;}
    public String getHeur_entre() {return heur_entre;}
    public String getHeur_sortie() {return heur_sortie;}
    public String getResponsable() {return responsable;}
    public String getPlatforme() {return platforme;}
}
