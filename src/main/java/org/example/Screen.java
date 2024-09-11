package org.example;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface Screen {

  void start();

  void finish();

  void showFunction();

  void showMenu();

  void showOrderedMenu(List<String> menus);

  int inputFunctionNumber() throws IOException;

  List<Integer> inputMenuNumbers() throws IOException;

  BigDecimal inputMoney() throws IOException;

  void showMoney(BigDecimal money);
}
