package johnston.design_pattern.structure.proxy.protective;

public class ProxyDrinkerAgeCheck implements Liquor {
  private Drinker drinker;
  private boolean over21;

  public ProxyDrinkerAgeCheck(Drinker drinker, int age) {
    this.drinker = drinker;
    over21 = age > 20 ? true : false;
  }

  @Override
  public void drink() {
    if (over21) {
      drinker.drink();
    } else {
      System.out.println("Under 21 is not allowed to drink!");
    }
  }
}
