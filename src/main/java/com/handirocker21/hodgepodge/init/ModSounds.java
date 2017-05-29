package com.handirocker21.hodgepodge.init;

import com.handirocker21.hodgepodge.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public final class ModSounds {
	
	public static SoundEvent cisternWhispers;
	public static SoundEvent nightsbanePh;
	public static SoundEvent nightsbaneKill;
	
	private static int size = 0;
	
	/**
	 * Initialize all of the mod's sounds.
	 */
	public static void init() {
		size = SoundEvent.REGISTRY.getKeys().size();
		
		cisternWhispers = register("cistern_whispers");
		nightsbanePh = register("nightsbane_ph");
		nightsbaneKill = register("nightsbane_kill");
	}
	
	/**
	 * Register a sound with the given name.
	 * The name is the name specified in the sounds.json file.
	 * @param name
	 * @return sEvent
	 */
	public static SoundEvent register(String name) {
		ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
		SoundEvent sEvent = new SoundEvent(location);
		SoundEvent.REGISTRY.register(size, location, sEvent);
		size++;
		
		return sEvent;
	}
}
