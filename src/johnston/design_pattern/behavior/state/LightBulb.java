package johnston.design_pattern.behavior.state;

public class LightBulb {
  private boolean isOn = false;

  public void flipSwitch() {
    this.isOn = !this.isOn;
  }

  public void getState() {
    if (isOn) {
      System.out.println("The light bulb is on.");
    } else {
      System.out.println("The light bulb is off.");
    }
  }
}
