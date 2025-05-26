package com.tip.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TIPLogger implements CommonLogger {

    private final Logger log;

    private TIPLogger(Class<?> clazz) {
        this.log = LoggerFactory.getLogger(clazz);
    }

    public static CommonLogger getLogger(Class<?> clazz) {
        return new TIPLogger(clazz);
    }

    private String format(LoggingCode code, String subCode, String message, Object... args) {
        return String.format("[code=%s] [subCode=%s] %s", code.name(), subCode, String.format(message, args));
    }

    @Override
    public void info(LoggingCode code, String subCode, String message, Object... args) {
        log.info(format(code, subCode, message, args));
    }

    @Override
    public void warn(LoggingCode code, String subCode, String message, Object... args) {
        log.warn(format(code, subCode, message, args));
    }

    @Override
    public void error(LoggingCode code, String subCode, String message, Object... args) {
        log.error(format(code, subCode, message, args));
    }

    @Override
    public void error(LoggingCode code, String subCode, String message, Throwable throwable) {
        log.error(String.format("[code=%s] [subCode=%s] %s", code.name(), subCode, message), throwable);
    }

    @Override
    public void debug(LoggingCode code, String subCode, String message, Object... args) {
        log.debug(format(code, subCode, message, args));
    }
}
