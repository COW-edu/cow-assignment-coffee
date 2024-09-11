package org.example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderReceipts {

  private final List<String> orderedMenus = new ArrayList<>();
  private BigDecimal totalCost = BigDecimal.ZERO;

  public void addMenu(String menu) {
    orderedMenus.add(menu);
  }

  public void removeMenu(String menu) {
    if (!orderedMenus.contains(menu)) {
      throw new RuntimeException("Menu not found: " + menu);
    }
    orderedMenus.remove(menu);
  }

  public void plusCost(BigDecimal cost) {
    totalCost = totalCost.add(cost);
  }

  public void minusCost(BigDecimal cost) {
    totalCost = totalCost.subtract(cost);
  }

  public List<String> getOrderedMenus() {
    return orderedMenus;
  }

  public BigDecimal getTotalCost() {
    return totalCost;
  }

  public void clear() {
    orderedMenus.clear();
    totalCost = BigDecimal.ZERO;
  }
}
