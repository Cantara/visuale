package no.cantara.tools.visuale.status;

import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.Node;
import no.cantara.tools.visuale.domain.Service;

import java.time.Instant;
import java.util.Objects;

public class Event {

    private final Instant registered;
    private final EventType eventType;
    private final Object eventObject;

    public Event(Instant registered, Object eventObject) {
        Objects.requireNonNull(registered);
        Objects.requireNonNull(eventObject);
        this.registered = registered;
        if (eventObject instanceof ControlEventData) {
            this.eventType = EventType.CONTROL;
        } else if (eventObject instanceof Environment) {
            this.eventType = EventType.ENVIRONMENT;
        } else if (eventObject instanceof NodeHealthData) {
            this.eventType = EventType.NODE;
        } else {
            throw new IllegalArgumentException("eventObject must be an instance one of the domain classes");
        }
        this.eventObject = eventObject;
    }

    public Instant getRegistered() {
        return registered;
    }

    public EventType getEventType() {
        return eventType;
    }

    public ControlEventData control() {
        return (ControlEventData) eventObject;
    }

    public Health health() {
        return (Health) eventObject;
    }

    public Node node() {
        return (Node) eventObject;
    }

    public Environment environment() {
        return (Environment) eventObject;
    }

    public NodeHealthData environmentUpdateHolder() {
        return (NodeHealthData) eventObject;
    }

    public Service service() {
        return (Service) eventObject;
    }
}
