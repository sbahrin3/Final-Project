package com.example.pc05.AplikasiPermarkahanPelajar.info.androidhive.sqlite.helper;

public class Pelajar {
    String No_Matrik;
    String Nama;
    Integer Kohort;
    Integer Sem;

    //constructors
    public Pelajar(){

    }

    public Pelajar (String No_Matrik,String Nama,int Kohort, int Sem) {
        this.No_Matrik = No_Matrik;
        this.Nama = Nama;
        this.Kohort = Kohort;
        this.Sem = Sem;
    }

    //setters
    public void setNo_Matrik(String No_Matrik){
        this.No_Matrik = No_Matrik;
    }

    public void setNama(String Nama){
        this.Nama = Nama;
    }

    public void setKohort(int Kohort){
        this.Kohort = Kohort;
    }

    public void setSem(int Sem){
        this.Sem = Sem;
    }

    //getters
    public String getNo_Matrik(){
        return this.No_Matrik;
    }

    public String Nama(){
        return this.Nama;
    }

    public int Kohort(){
        return this.Kohort;
    }

    public int Sem(){
        return this.Sem;
    }
}
