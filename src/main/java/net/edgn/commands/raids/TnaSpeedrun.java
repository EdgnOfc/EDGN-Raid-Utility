package net.edgn.commands.raids;

import net.edgn.utils.ChatUtils;
import net.edgn.utils.Chronometer.Chrono;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class TnaSpeedrun {
	public static boolean tnaSpeedrunBool = false;
	public static long tempsDepart = 0;

	
	public TnaSpeedrun() {
		final Thread Threaded = new Thread() {
			public void run() {
				boolean room1 = true;
				boolean wroom1 = false;
				boolean room2 = false;
				boolean wroom2 = false;
				boolean room3 = false;
				boolean wroom3 = false;
				boolean boss = false;
				boolean raidEnd = false;
				
				Minecraft mc = Minecraft.getMinecraft();
				EntityPlayer player = mc.player;
				
				if (tnaSpeedrunBool == false) return;
				
				while (Minecraft.getMinecraft().player.getPosition().getX() != 1120.000 && Minecraft.getMinecraft().player.getPosition().getZ() != -853.000) {
					if (room1) {
						if (Minecraft.getMinecraft().player.getPosition().getX() == 27775.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -22049.000
								|| Minecraft.getMinecraft().player.getPosition().getX() == 24494.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -22682.000) {
							
							room1 = false;
							
							ChatUtils.message(player, "Room 1");
							 tempsDepart = System.currentTimeMillis();

							
						}
						wroom1 = true;
					}
					
					if (wroom1) {
						if (Minecraft.getMinecraft().player.getPosition().getX() == 24907.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -23984.000) {
							wroom1 = false;
							
					        long minutes = (int) (tempsDepart % (1000 * 60 * 60)) / (1000 * 60);
					        long seconds = (int) ((tempsDepart % (1000 * 60 * 60)));
							
							long timeRoom1 = 0;
							ChatUtils.message(player, "Temps room 1 : %02d:%02d.%03d" + String.valueOf(minutes) + String.valueOf(seconds));
							
							
							ChatUtils.message(player, "Waiting room 1");
							//ins
						}
						room2 = true;
					}
					
					if(room2) {
						if (Minecraft.getMinecraft().player.getPosition().getX() == 24251.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -22259.000
								|| Minecraft.getMinecraft().player.getPosition().getX() == -12718.000 && Minecraft.getMinecraft().player.getPosition().getZ() == 8374.000) {
							room2 = false;
							ChatUtils.message(player, "Room 2");
							//ins
						}
						wroom2 = true;
					}
					
					if(wroom2) {
						if (Minecraft.getMinecraft().player.getPosition().getX() == 24907.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -23772.000) {
							wroom2 = false;
							ChatUtils.message(player, "Waiting room 2");
							//ins
						}
						room3 = true;
					}
					
					if(room3) {
						if (Minecraft.getMinecraft().player.getPosition().getX() == 25582.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -23534.000
								|| Minecraft.getMinecraft().player.getPosition().getX() == 23482.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -22035.000) {
							room3 = false;
							ChatUtils.message(player, "Room 3");
							//ins
						}
						wroom3 = true;
					}
					
					if(wroom3) {
						if (Minecraft.getMinecraft().player.getPosition().getX() == 24907.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -23772.000) {
							wroom3 = false;
							ChatUtils.message(player, "Waiting room 3");
							//ins
						}
						boss = true;
					}
					
					if(boss) {
						if (Minecraft.getMinecraft().player.getPosition().getX() == 24907.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -23772.000) {
							boss = false;
							ChatUtils.message(player, "Boss room");
							//ins
						}
						raidEnd = true;
					}
					
					
					if (raidEnd) {
						if (Minecraft.getMinecraft().player.getPosition().getX() == -24528.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -23829.000) {
							raidEnd = false;
							ChatUtils.message(player, "Raid end");
							//montre le temps face au boss puis addition du temps de toutes les salles ( + le boss ) et montre le temps final. 
						}
					}
				}
				
				if (Minecraft.getMinecraft().player.getPosition().getX() == 1120.000 && Minecraft.getMinecraft().player.getPosition().getZ() == -853.000) {
					ChatUtils.message(player, "Skill Issue");
				}
				
				
			}
		};
		Threaded.start();
	}
}
