package com.example.springbootcrud.exception;

public class CityException extends Exception {
    public CityException (String error_creating_city){
        super(error_creating_city);
    }

}
