package Homework4.Task5;

public class WrongPasswordException extends Exception{

  public WrongPasswordException() {
  }

  public WrongPasswordException(String message) {
    super(message);
  }
}
