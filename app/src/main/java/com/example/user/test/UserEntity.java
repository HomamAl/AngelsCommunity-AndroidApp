package com.example.user.test;

public class UserEntity {
    private Integer id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private Integer level;
    private Integer points;
    private Integer badges;

    private String number;

    public UserEntity(Integer id, String name, String surname, String email, String password, Integer level, Integer points, Integer badges, String number) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
        this.level = level;
        this.points = points;
        this.badges = badges;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getPoints() {
        return points;
    }

    public Integer getBadges() {
        return badges;
    }

    public String getNumber() {
        return number;
    }

}
