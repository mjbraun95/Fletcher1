package fletcher1;

import java.awt.Graphics;

import org.osbot.rs07.api.Inventory;
import org.osbot.rs07.script.*;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "mjbraun95", info = "fletches bows", logo = "", name = "fletcher1", version = 0)
public class fletcher extends Script {
	
	// Code executed at beginning
	public void onStart() {
		getInventory();
		
	}
	
	public int onLoop() {
		
		if(!getInventory().isFull()) {
			
		}
		
		//Returns ms delay
		return 50;
	}
	
	// Code executed at end
	public void onExit() {
		
	}
	
	// paint
	public void onPaint(Graphics g) {
		
	}
}
