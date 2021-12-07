package johnston.design_pattern.behavior.state;

public class Main {
  public static void main(String[] args) {
    LightBulb lightBulb = new LightBulb();
    lightBulb.getState();

    lightBulb.flipSwitch();
    lightBulb.getState();

    lightBulb.flipSwitch();
    lightBulb.getState();
  }
}
