package org.example;

import java.math.BigDecimal;
import java.util.List;

public interface Service {

    BigDecimal pay(BigDecimal payMoney);

    void cancel(List<Integer> selectedMenus);

    void order(List<Integer> selectedMenus);

    List<String> getOrderedMenus();

    BigDecimal getTotalCost();
}
