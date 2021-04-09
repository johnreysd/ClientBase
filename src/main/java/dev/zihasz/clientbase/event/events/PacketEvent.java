package dev.zihasz.clientbase.event.events;

import dev.zihasz.clientbase.event.Event;
import dev.zihasz.clientbase.event.EventEra;
import net.minecraft.network.Packet;

public class PacketEvent extends Event {

    private Packet<?> packet;

    public PacketEvent(EventEra era, Packet<?> packet) {
        super(era);
        this.packet = packet;
    }

    public static class Receive extends PacketEvent { public Receive(EventEra era, Packet packet) { super(era, packet); }}
    public static class Send extends PacketEvent    { public Send(EventEra era, Packet packet) { super(era, packet); }}

    public Packet<?> getPacket() { return packet; }
}
