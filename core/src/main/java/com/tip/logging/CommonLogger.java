package com.tip.logging;

public interface CommonLogger {
    void info(LoggingCode code, String subCode, String message, Object... args);
    void debug(LoggingCode code, String subCode, String message, Object... args);
    void warn(LoggingCode code, String subCode, String message, Object... args);
    void error(LoggingCode code, String subCode, String message, Object... args);
    void error(LoggingCode code, String subCode, String message, Throwable throwable);
}
