package com.brenodiogo.configuration;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class AddResponseHeaderFilter implements Filter {

    public static final String X_CORRELATION_ID = "X-Correlation-ID";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        String uuid = UUID.randomUUID().toString();
        httpServletResponse.setHeader(
                X_CORRELATION_ID, uuid);
        MDC.put(X_CORRELATION_ID, uuid);
        chain.doFilter(request, response);
        MDC.clear();
    }

}
