package com.handirocker21.hodgepodge.proxy;

public interface CommonProxy {
	public void init();
	public void registerTileEntities();
	public void registerModelBakery(); // Get baked.
	public String localize(String unlocalized, Object... args);
	public void registerRenderers();
}
