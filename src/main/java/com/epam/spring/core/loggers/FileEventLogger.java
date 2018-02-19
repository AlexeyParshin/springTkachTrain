package com.epam.spring.core.loggers;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class FileEventLogger implements EventLogger {

  private String filename;
  private File file;


  public FileEventLogger(String filename) {
    this.filename = filename;
  }

  private void init() throws IOException {
    this.file = new File(filename);
    if (!file.exists()) {
      file.createNewFile();
    }

    if (!file.canWrite()) {
      throw new IOException("Can't get access to file " + filename);
    }
  }

  @Override
  public void logEvent(String msg) {
    try {
      FileUtils.writeStringToFile(new File(filename), msg + '\n', true);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
