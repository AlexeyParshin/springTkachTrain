package com.epam.spring.core.loggers;

import java.util.Collection;

public class CombinedEventLogger implements EventLogger {

  private Collection<EventLogger> collection;

  public CombinedEventLogger(
      Collection<EventLogger> collection) {
    this.collection = collection;
  }

  @Override
  public void logEvent(String msg) {
    collection.forEach(eventLogger -> eventLogger.logEvent(msg));
  }
}
