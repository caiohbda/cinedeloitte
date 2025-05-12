package com.example.cinedeloitte.exception;

public class InvalidReservationPeriodException extends RuntimeException {
  public InvalidReservationPeriodException(String message) {
    super(message);
  }
}
