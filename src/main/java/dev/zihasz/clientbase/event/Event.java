package dev.zihasz.clientbase.event;

public abstract class Event extends net.minecraftforge.fml.common.eventhandler.Event {

    EventEra era;
    public Event(EventEra era) { this.era = era; }
    public EventEra getEra() { return era; }

}
