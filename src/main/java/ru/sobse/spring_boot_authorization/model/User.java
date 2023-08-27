package ru.sobse.spring_boot_authorization.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

public class User {
    @NotBlank(message = "user can not be empty")
    @Size(min = 3, max = 20, message = "user must be between 3 and 20 characters")
    private String name;
    @Size(min = 4, max = 10, message = "password must be between 4 and 10 characters")
    @NotNull(message = "password can not be empty")
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password);
    }
}
