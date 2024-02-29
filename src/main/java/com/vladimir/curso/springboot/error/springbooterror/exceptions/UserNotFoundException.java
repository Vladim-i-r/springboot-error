package com.vladimir.curso.springboot.error.springbooterror.exceptions;

public class UserNotFoundException extends RuntimeException {   //!  Si extendemos de Exceptions, nos obliga a usar try catch y con este no. 

    public UserNotFoundException(String message) {
        super(message);
    }

}
