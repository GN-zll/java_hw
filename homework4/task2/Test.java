package homework4.task2;

public class Test {

  public static void main(String[] args) {
    String comment1 = "Этот комментарий не фигня";
    String comment2 = "Реклама носков";
    String comment3  = "Как же так :(";
    String comment4 = "ggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggggg";

    String[] spamKeyWords = {"Реклама", "авиасейлс", "орифлейм"};
    int maxLength = 30;

    System.out.println(checkLabels(comment1, spamKeyWords, maxLength));
    System.out.println(checkLabels(comment2, spamKeyWords, maxLength));
    System.out.println(checkLabels(comment3, spamKeyWords, maxLength));
    System.out.println(checkLabels(comment4, spamKeyWords, maxLength));
  }
  public static Label checkLabels(String text, String[] spamKeywords, int maxLengthText) {
    SpamAnalyzer spamAnalyzer = new SpamAnalyzer(spamKeywords);
    NegativeTextAnalyzer negativeTextAnalyzer = new NegativeTextAnalyzer();
    TooLongTextAnalyzer tooLongTextAnalyzer = new TooLongTextAnalyzer(maxLengthText);
    if(spamAnalyzer.processText(text) != Label.OK) {
      return Label.Spam;
    }
    if(negativeTextAnalyzer.processText(text) != Label.OK) {
      return Label.NegativeText;
    }
    if(tooLongTextAnalyzer.processText(text) != Label.OK) {
      return Label.TooLongText;
    }
    return Label.OK;
  }
}
