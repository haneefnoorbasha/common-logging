package com.tip.logging.spring;

import com.tip.logging.CorrelationId;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

public class CorrelationIdFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
                         FilterChain chain) throws IOException, ServletException {
        try {
            String id = UUID.randomUUID().toString();
            CorrelationId.set(id);
            
            if (response instanceof HttpServletResponse httpResponse) {
                httpResponse.setHeader(CorrelationId.HEADER_NAME, id);
            }
            
            chain.doFilter(request, response);
        } finally {
            CorrelationId.clear();
        }
    }
}