package com.william.usersservice.users.domain.model;

import com.william.usersservice.users.domain.exception.DomainException;
import lombok.Getter;

@Getter
public class User {

    private String userName;

    private String email;

    private String firstName;


    public User(String userName, String email, String firstName) {
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        validate();
    }

    public static User newUser(String userName, String email, String firstName) {
        final var userNameALterado = "Novo userName [%s]".formatted(userName);
        return new User(email,firstName, userNameALterado);
    }

    public void validate() {
        checkUserNameConstraint();
        checkEmailConstraint();
        checkFirstNameConstraint();
    }

    private void checkUserNameConstraint() {
        if (userName == null) {
            throw new DomainException("'UserName' should not be null");
        }
        if (email.isEmpty()) {
            throw new DomainException("'email' should not be empty");
        }
    }

    private void checkFirstNameConstraint() {
        if (firstName == null) {
            throw new DomainException("'Firstname' should not be null");
        }
        if (firstName.isEmpty()) {
            throw new DomainException("'FirstName' should not be empty");
        }
    }

    private void checkEmailConstraint() {
        if (email == null) {
            throw new DomainException("'email' should not be null");
        }
        if (email.isEmpty()) {
            throw new DomainException("'email' should not be empty");
        }
    }


}

