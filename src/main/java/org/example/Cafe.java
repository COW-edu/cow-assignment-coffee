package org.example;

import java.util.Scanner;

public class Cafe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("☆★☆★ Cafe ☆★☆★");
			System.out.println("1. 주문하기");
			System.out.println("2. 취소하기");
			System.out.println("3. 결제하기");
			System.out.println("4. 끝내기");
			System.out.print("입력: ");
			int num = sc.nextInt();

			if (num == 1) {
				System.out.println("1. 아메리카노\t3800원");
				System.out.println("2. 에스프레소\t2400원");
				System.out.println("3. 카페라떼\t4200원");
				System.out.println("4. 밀크티\t5100원");
				// TODO: 주문 로직을 구현하세요.
			} else if (num == 2) {
				// TODO: 취소 로직을 구현하세요.
			} else if (num == 3) {
				// TODO: 결제 로직을 구현하세요.

			} else if (num == 4) {
				System.out.println("반복 종료!");
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}

		sc.close();
	}
}
