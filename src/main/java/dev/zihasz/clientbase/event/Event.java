package dev.zihasz.clientbase.event;

public abstract class Event extends net.minecraftforge.fml.common.eventhandler.Event {

    /**
     * The era of the Event.
     */
    EventEra era;

    /**
     * Initializes a new event.
     * @param era The era of the event (PRE/POST)
     */
    public Event(EventEra era) { this.era = era; }

    /**
     * Gets the era of an event.
     * @return The era
     */
    public EventEra getEra() { return era; }

}
