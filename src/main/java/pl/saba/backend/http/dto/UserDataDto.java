package pl.saba.backend.http.dto;

public class UserDataDto {
    private String name;
    private String surname;

    public UserDataDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
