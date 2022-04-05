package com.example.backend.Personal;

public class Personal {
    private int idUser;
    private String tel_number;
    private String email;
    private String bank;
    private String banknummer;
    private String user_name;
    private String password;
    private String cinema_name;

    public Personal(int idUser, String tel_number, String email, String bank, String banknummer, String user_name, String password, String cinema_name) {
        this.idUser = idUser;
        this.tel_number = tel_number;
        this.email = email;
        this.bank = bank;
        this.banknummer = banknummer;
        this.user_name = user_name;
        this.password = password;
        this.cinema_name = cinema_name;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTel_number() {
        return tel_number;
    }

    public void setTel_number(String tel_number) {
        this.tel_number = tel_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getBanknummer() {
        return banknummer;
    }

    public void setBanknummer(String banknummer) {
        this.banknummer = banknummer;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
    }
}
