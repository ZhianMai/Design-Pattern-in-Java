package johnston.design_pattern.behavior.command;

import johnston.design_pattern.behavior.command.order.Appliance;
import johnston.design_pattern.behavior.command.order.DigitalProduct;
import johnston.design_pattern.behavior.command.order.Grocery;
import johnston.design_pattern.behavior.command.order.PurchaseOrder;

import java.util.LinkedList;
import java.util.List;

public class OrderExecution {
  public static void main(String[] args) {
    List<PurchaseOrder> orderList = new LinkedList<>();

    orderList.add(new Appliance("TV", 300));
    orderList.add(new DigitalProduct("iPhone99", 999));
    orderList.add(new Grocery("Potato", 1));

    for (PurchaseOrder order : orderList) {
      order.purchase();
    }
  }
}
