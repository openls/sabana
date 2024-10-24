package org.sabana.core.configs;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CurrentTenantImplemantation implements CurrentTenantIdentifierResolver<String> {

    @Override
    public String resolveCurrentTenantIdentifier() {
        String tenant = TenantContext.getCurrent();
        return Objects.requireNonNullElse(tenant, "adempiere");
    }

    @Override
    public boolean validateExistingCurrentSessions() {
        return true;
    }
}
