package com.tip.logging;

public interface CommonLogger {
    void info(String code, String message, Object... args);
    void warn(String code, String message, Object... args);
    void error(String code, String message, Object... args);
    void error(String code,  String message, Throwable throwable);
    void debug(String code, String message, Object... args);
}
