package Homework4.Task2;

public class TooLongTextAnalyzer implements TextAnalyzer{
  int maxLength;
  public TooLongTextAnalyzer(int maxLength) {
    this.maxLength = maxLength;
  }


  @Override
  public Label processText(String text) {
    if(text.length() > maxLength) {
      return Label.TooLongText;
    }
    return Label.OK;
  }
}
