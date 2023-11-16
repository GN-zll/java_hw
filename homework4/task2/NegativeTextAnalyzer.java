package homework4.task2;

public class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
  private final String[] keywords = {":(", "=(", ":|"};
  private final Label label = Label.NEGATIVE_TEXT;

  @Override
  public String[] getKeywords() {
    return keywords;
  }
  @Override
  public Label getLabel() {
    return label;
  }
}
