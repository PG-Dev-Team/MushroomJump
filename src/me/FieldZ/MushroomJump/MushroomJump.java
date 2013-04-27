package me.FieldZ.MushroomJump;

import java.util.logging.Logger;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MushroomJump extends JavaPlugin{
	
	Logger log = Logger.getLogger("Minecraft");
	
	private final MushroomJumpPlayerListener playerListener = new MushroomJumpPlayerListener(this);
	private final MushroomJumpEntityListener entityListener = new MushroomJumpEntityListener(this);
	
	/**
	 * Method for when the plugin disables
	 */
	@Override
	public void onDisable(){
		log.info("MushroomJump is disabled!");
	}
	
	/**
	 * Method for when MushroomJump is enabled; PlayerListeners are ready upped!
	 */
	@Override
	public void onEnable(){
		// Registering events
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(playerListener, this);
		pm.registerEvents(entityListener, this);
		
		PluginDescriptionFile pdfFile = this.getDescription();
		log.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!");
	}

}
