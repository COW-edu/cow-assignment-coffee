package org.example;


import java.math.BigDecimal;
import java.util.List;

public class CafeService implements Service {

  private final OrderReceipts orderReceipts;

  public CafeService(OrderReceipts orderReceipts) {
    this.orderReceipts = orderReceipts;
  }

  @Override
  public BigDecimal pay(BigDecimal payMoney) {
    BigDecimal totalCost = orderReceipts.getTotalCost();

    if (payMoney.compareTo(totalCost) < 0) {
      throw new IllegalArgumentException("지불 금액이 총 비용보다 적습니다.");
    }

    BigDecimal remainMoney = payMoney.subtract(totalCost);
    orderReceipts.clear();
    return remainMoney;
  }

  @Override
  public void cancel(List<Integer> selectedMenus) {
    for(int selectedMenuNumber : selectedMenus) {
      CafeMenu cafeMenu = CafeMenu.findCafeMenu(selectedMenuNumber);
      orderReceipts.removeMenu(cafeMenu.getName());
      orderReceipts.minusCost(cafeMenu.getPrice());
    }
  }

  @Override
  public void order(List<Integer> selectedMenus) {
    if (selectedMenus.size() > 5) {
      throw new RuntimeException("Too many selected menus.");
    }

    for(int selectedMenuNumber : selectedMenus) {
      CafeMenu cafeMenu = CafeMenu.findCafeMenu(selectedMenuNumber);
      orderReceipts.addMenu(cafeMenu.getName());
      orderReceipts.plusCost(cafeMenu.getPrice());
    }
  }

  @Override
  public List<String> getOrderedMenus() {
    return orderReceipts.getOrderedMenus();
  }

  @Override
  public BigDecimal getTotalCost() {
    return orderReceipts.getTotalCost();
  }
}
