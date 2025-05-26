package com.tip.logging.spring;

import com.tip.logging.CommonLogger;
import com.tip.logging.CorrelationId;
import com.tip.logging.LoggingCode;
import com.tip.logging.TIPLogger;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

public class CorrelationIdFilter implements Filter {

    private static final CommonLogger log = TIPLogger.getLogger(CorrelationIdFilter.class);
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;

            // ✅ Use incoming header or generate new UUID
            String correlationId = httpRequest.getHeader(CorrelationId.HEADER_NAME);
            log.info(LoggingCode.PROCESS_INTERMEDIATE,
                    "CorrelationIdFilter.doFilter",
                    "CorrelationId: " + correlationId);
            if (correlationId == null || correlationId.isBlank()) {
                correlationId = UUID.randomUUID().toString();
                log.info(LoggingCode.PROCESS_INTERMEDIATE,
                        "CorrelationIdFilter.doFilter",
                        "It was null or empty, generating new UUID: " + correlationId);
            }

            // ✅ Set in MDC and expose to response
            CorrelationId.set(correlationId);
            httpResponse.setHeader(CorrelationId.HEADER_NAME, correlationId);

            chain.doFilter(request, response);
        } finally {
            CorrelationId.clear();
        }
    }
}