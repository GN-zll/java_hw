package Homework4.Task5;

public class Test {
  static boolean singUp (String login, String password, String confirmPassword) {
    try {
    if(!login.matches("^[a-zA-Z0-9_]+$") || login.length()>=20) {
        throw new WrongLoginException();
    }
    if(!password.matches("^[a-zA-Z0-9_]+$") || password.length()>=20 || !password.equals(confirmPassword)){
      throw new WrongPasswordException();
    }
    return true;
    } catch (WrongLoginException | WrongPasswordException e){
      return false;
    }
  }
}
