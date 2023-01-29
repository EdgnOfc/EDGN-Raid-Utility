package net.edgn.keybinds;

import net.edgn.commands.raids.TnaSpeedrun;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.edgn.commands.raids.ShowPartyRaidCompletions;
import net.edgn.main.Main;
import net.edgn.utils.ChatUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class Keybinder {
	@SubscribeEvent
	public void onEvent(KeyInputEvent event) { 
		
		EntityPlayer player = Minecraft.getMinecraft().player;
		String tag = ChatFormatting.BLACK + "[" + ChatFormatting.AQUA + "EDGN" + ChatFormatting.BLACK + "] ";
	
		KeyBinding[] keyBindings = Main.keyBindings;
	
		 if (keyBindings[0].isPressed()) {
	
			 if (ShowPartyRaidCompletions.partyBool) {
				 ChatUtils.message(player, tag  + ChatFormatting.GOLD + ChatFormatting.BOLD + "Party stats module deactivated");
				 ShowPartyRaidCompletions.partyBool = false;
			 } else {
				 ChatUtils.message(player, tag + ChatFormatting.GOLD + ChatFormatting.BOLD + "Party stats module activated");
				 ShowPartyRaidCompletions.partyBool = true;
			 }
		   
		 }
	
		 if (keyBindings[1].isPressed()) {
	
			 if ( TnaSpeedrun.tnaSpeedrunBool) {
				 ChatUtils.message(player, tag + ChatFormatting.GOLD + ChatFormatting.BOLD +  "Tna speedrun module deactivated <!> Don't use not working yet");
				 TnaSpeedrun.tnaSpeedrunBool = false;
			 } else {
				 ChatUtils.message(player,  tag + ChatFormatting.GOLD + ChatFormatting.BOLD + "Tna speedrun module activated <!> Don't use not working yet ");
				 TnaSpeedrun.tnaSpeedrunBool = true;
				 new TnaSpeedrun();
			 }
	
		 }

	}

}
