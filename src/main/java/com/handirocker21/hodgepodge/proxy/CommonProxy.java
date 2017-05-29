package com.handirocker21.hodgepodge.proxy;

public interface CommonProxy {	
	public void preInit();
	public void init();
	public void registerTileEntities();
	public String localize(String unlocalized, Object... args);
	public void registerRenderers();
}
