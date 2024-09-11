package org.example;

import java.math.BigDecimal;
import java.util.Arrays;

public enum CafeMenu {
  AMERICANO(1, "아메리카노", BigDecimal.valueOf(3800)),
  ESPRESSO(2, "에스프레소", BigDecimal.valueOf(2400)),
  CAFE_LATTE(3, "카페 라떼", BigDecimal.valueOf(4200)),
  MILK_TEA(4, "밀크티", BigDecimal.valueOf(5100));

  private int menuNumber;
  private String name;
  private BigDecimal price;

  CafeMenu(int menuNumber, String name, BigDecimal price) {
    this.menuNumber = menuNumber;
    this.name = name;
    this.price = price;
  }

  public int getMenuNumber() {
    return menuNumber;
  }
  public String getName() {
    return name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public static CafeMenu findCafeMenu(int menuNumber) {
    return Arrays.stream(CafeMenu.values())
        .filter(menu -> menu.getMenuNumber() == menuNumber)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("Invalid menu number: " + menuNumber));
  }
}
