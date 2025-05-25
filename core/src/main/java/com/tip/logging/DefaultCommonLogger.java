package com.tip.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DefaultCommonLogger implements CommonLogger {

    private final Logger log;

    public DefaultCommonLogger(Class<?> clazz) {
        this.log = LoggerFactory.getLogger(clazz);
    }

    @Override
    public void info(String code, String message, Object... args) {
        log.info("[{}] {}", code, String.format(message, args));
    }

    @Override
    public void warn(String code, String message, Object... args) {
        log.warn("[{}] {}", code, String.format(message, args));
    }

    @Override
    public void error(String code, String message, Object... args) {
        log.error("[{}] {}", code, String.format(message, args));
    }

    @Override
    public void error(String code, String message, Throwable throwable) {
        log.error("[{}] {}", code, String.format(message, throwable));
    }

    @Override
    public void debug(String code, String message, Object... args) {
        log.debug("[{}] {}", code, String.format(message, args));
    }
}
