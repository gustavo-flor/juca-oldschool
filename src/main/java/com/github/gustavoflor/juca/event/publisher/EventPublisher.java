package com.github.gustavoflor.juca.event.publisher;

import com.github.gustavoflor.juca.event.Event;

public interface EventPublisher {
    void send(Event event);
}
