package net.edgn.commands.help;

import org.apache.commons.lang3.StringUtils;

import com.mojang.realmsclient.gui.ChatFormatting;

import net.edgn.utils.ChatUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;

public class HelpPage1 extends CommandBase {
	@Override
	public String getName() {
		return "edh";
	}

	@Override
	public String getUsage(ICommandSender sender) {

		return "Montre toutes les commandes du mod EDGN";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayer player = Minecraft.getMinecraft().player;
		
		String tag = ChatFormatting.BLACK + "[" + ChatFormatting.AQUA +"EDGN" +  ChatFormatting.BLACK +"]";
		ChatUtils.message(player, StringUtils.repeat("§m ", 60));
		
		ChatUtils.message(player, tag + ChatFormatting.GREEN + " /edrhelp <page> : overall commands");
		ChatUtils.message(player, tag + ChatFormatting.GREEN + " /raidinfo {player name} : shows raid stats ");
		ChatUtils.message(player, tag + ChatFormatting.GREEN + " Do /pa list since the /pl command hasn't been made yet");
		
		ChatUtils.message(player, StringUtils.repeat("§m ", 60));
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
}

// System.out.println(WynnApiUtils.getStringFromURL("https://api.wynncraft.com/v2/player/EDGN/stats"));
