package bowling.domain;

public class Strike implements State {

  static final String STRIKE = "X";
  
  private Pins first;

  public Strike(Pins first) {
    this.first = first;
  }

  @Override
  public State roll(int second) {
    throw new UnsupportedOperationException();
  }

  @Override
  public String symbol() {
    return STRIKE;
  }


  @Override
  public String toString() {
    return "Strike{" + "first=" + first + '}';
  }
}
