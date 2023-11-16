package homework4.task2;

public abstract class KeywordAnalyzer implements TextAnalyzer{
  public abstract String[] getKeywords();
  public abstract Label getLabel();
  @Override
  public Label processText(String text) {
    for (String keyword : getKeywords()) {
      if(text.contains(keyword)) {
        return getLabel();
      }
    }
    return Label.OK;
  }
}
