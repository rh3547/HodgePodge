package com.handirocker21.hodgepodge;

import net.minecraft.util.IStringSerializable;

public class Reference {
	
	/*
	 * General Mod Settings
	 */
	// Mod details
	public static final String MOD_ID = "hodgepodge";
	public static final String NAME = "Hodge Podge";
	public static final String VERSION = "1.0";
	public static final String ACCEPTED_VERSIONS = "[1.11.2]";
	
	// Proxy details
	public static final String CLIENT_PROXY_CLASS = "com.handirocker21.hodgepodge.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.handirocker21.hodgepodge.proxy.ServerProxy";
	
	/*
	 * Item Names
	 */
	public static enum HodgePodgeItems {
		OBSIDIAN_INGOT("obsidianingot", "ItemObsidianIngot"),
		RUBY("ruby", "ItemRuby"),
		RUBY_GUMMY("rubygummy", "ItemRubyGummy"),
		RUBIDIAN("rubidian", "ItemRubidian"),
		SOUL("soul", "ItemSoul"),
		SOUL_STEALER("soulstealer", "ItemSoulStealer"),
		SOUL_CISTERN("soulcistern", "ItemSoulCistern");
		
		private String unlocalizedName;
		private String registryName;
		
		HodgePodgeItems(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
		
		public String getRegistryName() {
			return this.registryName;
		}
	}
	
	
	/*
	 * Block Names
	 */
	public static enum HodgePodgeBlocks {
		RUBY_BLOCK("rubyblock", "BlockRuby"),
		PEDESTAL_BLOCK("pedestal", "pedestal");
		
		private String unlocalizedName;
		private String registryName;
		
		HodgePodgeBlocks(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
		
		public String getRegistryName() {
			return this.registryName;
		}
	}
	
	/*
	 * Tool Names
	 */
	public static enum HodgePodgeTools {
		OBSIDIAN_PICKAXE("obsidianpickaxe", "obsidianpickaxe"),
		OBSIDIAN_AXE("obsidianaxe", "obsidianaxe"),
		OBSIDIAN_HOE("obsidianhoe", "obsidianhoe"),
		OBSIDIAN_SPADE("obsidianspade", "obsidianspade"),
		OBSIDIAN_SWORD("obsidiansword", "obsidiansword"),
		RUBIDIAN_SWORD("rubidiansword", "rubidiansword");
		
		private String unlocalizedName;
		private String registryName;
		
		HodgePodgeTools(String unlocalizedName, String registryName) {
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}
		
		public String getRegistryName() {
			return this.registryName;
		}
	}
	
	/*
	 * Chip types for different block/item "levels"
	 */
	public static enum ChipTypes implements IStringSerializable {
		BASIC("basic", 0),
		ADVANCED("advanced", 1);
		
		private int id;
		private String name;
		
		private ChipTypes(String name, int id){
			this.id = id;
			this.name = name;
			
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int getID() {
			return id;
		}
		
		@Override
		public String toString() {
			return getName();
		}
	}
}
