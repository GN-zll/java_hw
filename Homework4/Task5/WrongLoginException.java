package Homework4.Task5;

public class WrongLoginException extends Exception{

  public WrongLoginException() {
  }

  public WrongLoginException(String message) {
    super(message);
  }
}
