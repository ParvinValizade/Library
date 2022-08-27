package com.company.library.dto.request;

public class CreateLibrarianRequest {
    private String name;
    private String surname;
    private String email;
    private String password;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
