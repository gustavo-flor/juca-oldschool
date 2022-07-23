package com.github.gustavoflor.juca.event;

import java.time.LocalDateTime;

public interface Event {
    String OUT_PREFIX = "-out-0";

    String bindingName();

    Object partitionKey();

    LocalDateTime occurredAt();

    default String outBindingName() {
        return bindingName() + OUT_PREFIX;
    }
}
