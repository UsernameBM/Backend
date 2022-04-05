package com.example.backend;

public class Personal {
    private int idUser;
    private String tel_number;
    private String email;
    private String bank;
    private String banknumber;
    private String cinema_name;
    private String user_name;
    private String password;

    public Personal(int idUser, String tel_number, String email, String bank,
                    String banknumber, String cinema_name, String user_name, String password) {
        this.idUser = idUser;
        this.tel_number = tel_number;
        this.email = email;
        this.bank = bank;
        this.banknumber = banknumber;
        this.cinema_name = cinema_name;
        this.user_name = user_name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "idUser=" + idUser +
                ", tel_number='" + tel_number + '\'' +
                ", email='" + email + '\'' +
                ", bank='" + bank + '\'' +
                ", banknumber='" + banknumber + '\'' +
                ", cinema_name='" + cinema_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                '}';
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

    public String getBanknumber() {
        return banknumber;
    }

    public void setBanknumber(String banknumber) {
        this.banknumber = banknumber;
    }

    public String getCinema_name() {
        return cinema_name;
    }

    public void setCinema_name(String cinema_name) {
        this.cinema_name = cinema_name;
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

}
