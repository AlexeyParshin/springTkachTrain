package com.epam.spring.core;

import com.epam.spring.core.beans.Client;
import com.epam.spring.core.loggers.EventLogger;
import com.epam.spring.core.loggers.EventType;
import java.util.Map;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

  private Client client;
  private EventLogger eventLogger;
  private Map<EventType, EventLogger> loggers;

  public void logEvent(EventType type, String msg){
    EventLogger logger = loggers.get(type);
    if(logger == null) {
      logger = eventLogger;
    }
    logger.logEvent(msg);
  }

  public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
    this.client = client;
    this.eventLogger = eventLogger;
    this.loggers = loggers;
  }

  public static void main(String[] args) {
    ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    App app = ctx.getBean(App.class);
    app.logEvent(EventType.INFO,"AHAHAHAHAHAHAHOHOHOOHOHHOOOWWWWYEAAAA1");
    app.logEvent(EventType.ERROR,"AHAHAHAHAHAHAHOHOHOOHOHHOOOWWWWYEAAAA2");

    ctx.close();
  }
}
