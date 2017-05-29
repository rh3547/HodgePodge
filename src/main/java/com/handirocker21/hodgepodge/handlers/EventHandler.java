package com.handirocker21.hodgepodge.handlers;

import com.handirocker21.hodgepodge.events.SoulStealerEvent;

import net.minecraftforge.common.MinecraftForge;

public class EventHandler {
	
	public void registerEvents() {
		MinecraftForge.EVENT_BUS.register(new SoulStealerEvent());
	}
}
