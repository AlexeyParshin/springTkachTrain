package com.epam.spring.core.loggers;

import java.util.ArrayList;
import java.util.List;

public class CacheFileLogger extends FileEventLogger {
  private int cacheSize;
  private List<String> cache = new ArrayList<>();

  public CacheFileLogger(String filename, int cacheSize) {
    super(filename);
    this.cacheSize = cacheSize;
  }


  @Override
  public void logEvent(String msg) {
    cache.add(msg);

    if(cache.size() == cacheSize) {
      cache.forEach(super::logEvent);
      cache.clear();
    }
  }

  public void destroy(){
    if(!cache.isEmpty()){
      cache.forEach(super::logEvent);
    }
  }
}
