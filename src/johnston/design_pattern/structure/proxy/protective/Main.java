package johnston.design_pattern.structure.proxy.protective;

public class Main {
  public static void main(String[] args) {
    Drinker bob = new Drinker("Bob");
    Drinker flash = new Drinker("Flash");
    Liquor fstShot = new ProxyDrinkerAgeCheck(bob, 50);
    Liquor secShot = new ProxyDrinkerAgeCheck(flash, 18);

    fstShot.drink();
    secShot.drink();
  }
}
