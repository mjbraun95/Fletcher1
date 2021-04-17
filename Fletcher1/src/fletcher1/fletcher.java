package fletcher1;

//import java.awt.Graphics;
import java.awt.Graphics2D;

import org.osbot.rs07.api.Bank;
import org.osbot.rs07.api.Inventory;
import org.osbot.rs07.api.model.RS2Object;
import org.osbot.rs07.script.Script;
import org.osbot.rs07.script.ScriptManifest;

@ScriptManifest(author = "mjbraun95", info = "fletches bows", logo = "", name = "fletcher1", version = 1.0)
public class fletcher extends Script {
	public Inventory inv;
	public String logType;
	public String bowType;
	public RS2Object banker;
	public Bank bank;
	public void getInv() {
		inv = getInventory();
	}
	
	@Override
	public void onStart() {
		
		log("started!");
		banker = getObjects().closest("Banker");
		if (banker != null) {
		  log("banker is present!");
		  bank.getBank();
		}
		else {
			log("banker is not present. Exiting");
			System.exit(1);
		}
	}
	
	@Override
	public int onLoop() throws InterruptedException {
//		banker.interact("Bank");
		bank.open();
		bank.depositAll();
		bank.withdraw("Knife", 1);
		bank.withdraw(logType, 27);
		getInv();
		if (!inv.contains(logType) || !inv.contains("Knife")) {
			log("did not successfully withdraw. Exiting");
			System.exit(1);
		}
		else {
			log("Withdrew items successfully!");
		}
		if(!inv.isFull()) {
			log("Inventory full");
		}
		else {
			log("Inventory not full");
		}
		
		//Returns ms delay
		return 4000;
	}
	
	@Override
	public void onExit() {
		
	}
	
	@Override
	public void onPaint(Graphics2D g) {
		g.drawString("Hello World", 50, 50);
	}
}
