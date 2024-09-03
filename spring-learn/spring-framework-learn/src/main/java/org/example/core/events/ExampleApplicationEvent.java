package org.example.core.events;

import org.springframework.context.ApplicationEvent;

import java.time.Clock;

public class ExampleApplicationEvent extends ApplicationEvent {
    public ExampleApplicationEvent(Object source) {
        super(source);
    }

    public ExampleApplicationEvent(Object source, Clock clock) {
        super(source, clock);
    }
}
