package com.example.backend.Cinema;

public class Cinema {
    private String name;
    private String adress;
    private String tel_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public Cinema(String name, String adress, String tel_number) {
        this.name = name;
        this.adress = adress;
        this.tel_number = tel_number;


    }
}
