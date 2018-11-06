package com.example.pc05.AplikasiPermarkahanPelajar.info.androidhive.sqlite.helper;

public class Markah {

    int Id_Markah;
    String No_Matrik;
    int Markah;
    String Subjek;

    //constructors
    public Markah(){

    }

    public Markah(int Id_Markah,String No_Matrik, int Markah, String Subjek){
        this.Id_Markah = Id_Markah;
        this.No_Matrik = No_Matrik;
        this.Markah = Markah;
        this.Subjek = Subjek;
    }

    //setters
    public void setId_Markah(int Id_Markah){
        this.Id_Markah = Id_Markah;
    }

    public void setNo_Matrik(String No_Matrik){
        this.No_Matrik = No_Matrik;
    }

    public void setMarkah(int Markah){
        this.Markah = Markah;
    }

    public void setSubjek(String Subjek){
        this.Subjek = Subjek;
    }

    //getter

    public int getId_Markah() {
        return Id_Markah;
    }

    public String getNo_Matrik() {
        return No_Matrik;
    }

    public int getMarkah() {
        return Markah;
    }

    public String getSubjek() {
        return Subjek;
    }
}
