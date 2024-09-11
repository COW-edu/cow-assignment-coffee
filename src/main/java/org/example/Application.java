package org.example;

public class Application {

    public static void main(String[] args) {
        Screen screen = new CafeScreen();
        Service service = new CafeService(new OrderReceipts());
        ApplicationManager applicationManager = new CafeApplicationManager(service, screen);
        new CafeApplication(screen, applicationManager).run();
    }
}
