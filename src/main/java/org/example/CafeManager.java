package org.example;

import java.util.Scanner;

public class CafeManager {

  public void introduceFunction() {
    System.out.println("☆★☆★ Talking CafeManager ☆★☆★");
    System.out.println("1. 주문하기");
    System.out.println("2. 취소하기");
    System.out.println("3. 결제하기");
    System.out.println("4. 끝내기");
    System.out.print("몇 번을 선택하시겠습니까? ");
  }

  public void introduceMenu() {
    System.out.println("1. 아메리카노\t3800원");
    System.out.println("2. 에스프레소\t2400원");
    System.out.println("3. 카페라떼\t4200원");
    System.out.println("4. 밀크티\t5100원");
    System.out.print("몇 번을 선택하시겠습니까? ");
  }

  public void finish() {
    System.out.println("대화 종료!");
  }

  public void faultValue() {
    System.out.println("번호를 잘못 입력하셨습니다!");
  }

  public int askNumber() {
    Scanner sc = new Scanner(System.in);
    int value = sc.nextInt();
    sc.close();
    return value;
  }
}
