package com.example.springbootcrud.exception;

public class SensorException extends Exception {
    public SensorException(String error_saving_sensor) {
        super(error_saving_sensor);
    }
}
