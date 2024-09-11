package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class CafeScreen implements Screen {

  private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

  @Override
  public void start() {
    println("카페 어플을 시작합니다!");
  }

  @Override
  public void finish() {
    println("카페 어플 종료하겠습니다!");
  }

  @Override
  public void showFunction() {
    println("☆★☆★ Starting CafeApplication ☆★☆★");
    println("1. 주문하기");
    println("2. 취소하기");
    println("3. 결제하기");
    println("4. 끝내기");
    print("몇 번을 선택하시겠습니까? ");
  }

  @Override
  public void showMenu() {
    println("☆★☆★ SHOW MENU ☆★☆★");
    println("1. 아메리카노\t3800원");
    println("2. 에스프레소\t2400원");
    println("3. 카페라떼\t4200원");
    println("4. 밀크티\t5100원");
    print("몇 번을 선택하시겠습니까? ");
  }

  @Override
  public void showOrderedMenu(List<String> menus) {
    StringBuilder builder = new StringBuilder();
    int count = 1;
    println("☆★☆★ SHOW ORDERED ☆★☆★");
    for (String menu : menus) {
      builder.append(count++).append(". ").append(menu).append("\n");
    }
    println(builder.toString());
  }

  @Override
  public int inputFunctionNumber() throws IOException {
    return Integer.parseInt(READER.readLine());
  }

  @Override
  public List<Integer> inputMenuNumbers() throws IOException {
    String numbers = READER.readLine();
    String[] stNumber = numbers.split(" ");

    return Arrays.stream(stNumber)
        .mapToInt(Integer::parseInt)
        .boxed()
        .toList();
  }

  @Override
  public BigDecimal inputMoney() throws IOException {
    return new BigDecimal(READER.readLine());
  }

  @Override
  public void showMoney(BigDecimal money) {
    println("money : " + money.toString());
  }

  private void print(String message) {
    System.out.print(message);
  }

  private void println(String message) {
    System.out.println(message);
  }
}
