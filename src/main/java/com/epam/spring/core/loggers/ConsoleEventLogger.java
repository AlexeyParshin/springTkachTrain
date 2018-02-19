package com.epam.spring.core.loggers;

import com.epam.spring.core.loggers.EventLogger;

public class ConsoleEventLogger implements EventLogger {

  @Override
  public void logEvent(String msg) {
    System.out.println(msg);
  }
}
