package Homework4.Task2;

public class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
  private final String[] keywords;
  private final Label label = Label.Spam;
  public SpamAnalyzer(String[] keywords) {
    this.keywords = keywords;
  }

  @Override
  public String[] getKeywords() {
    return keywords;
  }

  @Override
  public Label getLabel() {
    return label;
  }
}
