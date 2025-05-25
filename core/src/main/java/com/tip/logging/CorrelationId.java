package com.tip.logging;

import org.slf4j.MDC;

public class CorrelationId {
    public static final String HEADER_NAME = "X-Correlation-ID";
    private static final String MDC_KEY = "correlationId";

    public static void set(String id) {
        if (id != null && !id.isBlank()) {
            MDC.put(MDC_KEY, id);
        }
    }

    public static String get() {
        return MDC.get(MDC_KEY);
    }

    public static void clear() {
        MDC.remove(MDC_KEY);
    }

}

