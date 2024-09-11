package org.example;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class CafeApplicationManager implements ApplicationManager {

  private final Service service;
  private final Screen screen;

  private static final int ORDER_NUMBER = 1;
  private static final int CANCEL_NUMBER = 2;
  private static final int PAY_NUMBER = 3;

  public CafeApplicationManager(Service service, Screen screen) {
    this.service = service;
    this.screen = screen;
  }

  @Override
  public void manage(int number) throws IOException {
    switch (number) {
      case ORDER_NUMBER -> {
        screen.showMenu();
        List<Integer> selectedMenus = screen.inputMenuNumbers();
        service.order(selectedMenus);
      }

      case CANCEL_NUMBER -> {
        List<String> orderedMenus = service.getOrderedMenus();
        screen.showOrderedMenu(orderedMenus);
        List<Integer> selectedMenus = screen.inputMenuNumbers();
        service.cancel(selectedMenus);
      }

      case PAY_NUMBER -> {
        BigDecimal totalAmount = service.getTotalCost();
        screen.showMoney(totalAmount);
        BigDecimal payMoney = screen.inputMoney();
        BigDecimal remainMoney = service.pay(payMoney);
        screen.showMoney(remainMoney);
      }

      default -> throw new IllegalStateException("Unexpected value: " + number);
    }
  }
}
