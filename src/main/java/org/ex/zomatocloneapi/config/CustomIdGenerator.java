package org.ex.zomatocloneapi.config;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.time.Year;
import java.util.UUID;

public class CustomIdGenerator implements IdentifierGenerator {

    @Override
    public Object generate(SharedSessionContractImplementor session, Object object) {
        UUID uuid = UUID.randomUUID();

        return "zomato" + Year.now() + uuid.toString().substring(0, 6);
    }
}
