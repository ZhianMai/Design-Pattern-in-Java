package johnston.design_pattern.behavior.command.order;

public class DigitalProduct implements PurchaseOrder {
  private String productName;
  private int price;

  public DigitalProduct(String productName, int price) {
    this.productName = productName;
    this.price = price;
  }

  @Override
  public void purchase() {
    System.out.println("Buying " + productName + " at price $" + price);
  }
}
