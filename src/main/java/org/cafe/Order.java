package org.cafe;

import java.util.Scanner;

public class Order implements OrderSystem {
    String name;
    int price;
    int count = 0;
    User user = new User();
    KioskSystem kioskSystem = new KioskSystem();

    @Override
    public void order() {
        int number = kioskSystem.askNumber();
        switch (number) {
            case 1 -> {
                name = "아메리카노";
                price = 3800;
            }
            case 2 -> {
                name = "에스프레소";
                price = 2400;
            }
            case 3 -> {
                name = "카페라떼";
                price = 4200;
            }
            case 4 -> {
                name = "밀크티";
                price = 5100;
            }
            default -> {
                kioskSystem.faultValue();
                count--;
            }

        }
        count++;
        User.orders.add(count - 1, name);
        System.out.println("현재 주문량: " + count);
        user.total += price;
    }

    @Override
    public void cancel() {
        System.out.println(User.orders);
        System.out.println("삭제할 메뉴번호를 적어주세요.");
        int number;
        do {
            number = kioskSystem.askNumber();
            if (number > User.orders.size()) {
                System.out.println("삭제할 번호를 다시 입력하세요");
            }
        } while (number > User.orders.size());
        //넘버, 빠지는 글자와 일치하는거 빼고, 가격도 뺀다.
        String remove = User.orders.remove(number -1);
        switch (remove) {
            case "아메리카노" -> {
                user.total -= 3800;
            }
            case "에스프레소" -> {
                user.total -= 2400;
            }
            case "카페라떼" -> {
                user.total -= 4200;
            }
            case "밀크티" -> {
                user.total -= 5100;
            }
        }
        count--;
        System.out.println("현재 메뉴");
        System.out.println(User.orders);
    }

    @Override
    public void pay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(user.total + "원");
        System.out.println("지불할 금액을 입력하세요.");
        int paid = scanner.nextInt();
        if (paid < user.total) {
            System.out.println("금액이 부족합니다");
            pay();
        } else {
            System.out.println("잔돈: " + (paid - user.total) + "원");
        }
        user.total = 0;
        User.orders.clear();
    }

    public void close() {
        kioskSystem.end();
        System.exit(0);
    }

    public void faultNumber() {
        System.out.println("잘못된 번호 입력입니다.");
    }
}
