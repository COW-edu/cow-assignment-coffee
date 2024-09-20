package org.cafe;

public class Kiosk {
    public static void main(String[] args) {
        KioskSystem kioskSystem = new KioskSystem();
        Order order = new Order();
        kioskSystem.start();

        while (kioskSystem.isActive()) {
            kioskSystem.introduceFunction();
            int number = kioskSystem.askNumber();
            if (User.orders.size() == 5) {
                if (number == 1) {
                    System.out.println("추가 주문이 불가능합니다. 결제해주세요!");
                    continue;
                }
            }

            switch (number) {
                case 1 -> {
                    kioskSystem.introduceMenu();
                    order.order();
                    if (User.orders.size() == 5) {
                        System.out.println("추가 주문이 불가능합니다.");
                    }
                }
                case 2 -> {
                    order.cancel();
                }
                case 3 -> {
                    order.pay();
                }
                case 4 -> {
                    order.close();
                }
                default -> {
                    order.faultNumber();
                }
            }
        }
    }
}
