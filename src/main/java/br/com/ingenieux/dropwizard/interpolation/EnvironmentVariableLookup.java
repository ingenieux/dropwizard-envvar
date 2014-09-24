package br.com.ingenieux.dropwizard.interpolation;

import org.apache.commons.lang.text.StrLookup;

public class EnvironmentVariableLookup extends StrLookup {

  @Override
  public String lookup(String param) {
    String key = param;
    String defaultValue = null;

    if (-1 != param.indexOf(':')) {
      String[] args = param.split("\\:", 2);

      key = args[0];
      defaultValue = args[1];
    }

    String value = defaultValue;

    if (null != System.getenv(key)) {
      value = System.getenv(key);
    }

    if (value == null) {
      throw new EnvironmentException("The environment variable '" + key
                                     + "' is not defined; could not substitute the expression '${"
                                     + key + "}'.");
    }

    return value;
  }
}