package org.sabana.core.configs;

import java.io.IOException;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
public class TenantContext implements Filter {

    private static final String LOGGER_TENANT_ID = "tenant";
    public static final String PRIVATE_TENANT_HEADER = "X-Tenant";
    private static final String DEFAULT_TENANT = "adempiere";

    private static final ThreadLocal<String> currentTenant = new InheritableThreadLocal<>();


    public static String getCurrent() {
        String tenant = currentTenant.get();
        return Objects.requireNonNullElse(tenant, DEFAULT_TENANT);
    }

    public static void setCurrent(String tenant) {
        MDC.put(LOGGER_TENANT_ID, tenant);
        currentTenant.set(tenant);
    }

    public static void clear() {
        MDC.clear();
        currentTenant.remove();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String privateTenant = httpRequest.getHeader(PRIVATE_TENANT_HEADER);
        if (privateTenant != null) {
            TenantContext.setCurrent(privateTenant);
        }
        chain.doFilter(request, response);
    }
}
