package org.example;

import java.io.IOException;

public class CafeApplication implements Runnable{

  private final Screen screen;
  private final ApplicationManager applicationManager;
  private boolean isRunning;
  private int EXIT_NUMBER = 4;

  public CafeApplication(Screen screen, ApplicationManager applicationManager) {
    this.screen = screen;
    this.applicationManager = applicationManager;
    isRunning = true;
  }

  @Override
  public void run() {
    screen.start();
    while (isRunning) {
      try {
        screen.showFunction();
        int selectedNumber = screen.inputFunctionNumber();

        if (selectedNumber == EXIT_NUMBER) {
          isRunning = false;
          break;
        }

        applicationManager.manage(selectedNumber);
      } catch (RuntimeException | IOException e) {
        System.out.println(e.getMessage());
      }
    }
    screen.finish();
  }
}
