package net.edgn.commands.raids;

import net.edgn.utils.ChatUtils;
import net.edgn.utils.WynnApiUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import java.util.List;
import java.util.regex.*;

import org.apache.commons.lang3.StringUtils;

import com.mojang.realmsclient.gui.ChatFormatting;

import java.util.ArrayList;
import java.util.Arrays;

public class ShowRaidCompletions extends CommandBase {
	@Override
	public String getName() {
		return "edr";
	}

	@Override
	public String getUsage(ICommandSender sender) {

		return "Montre les completions de raids";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		final Thread Threaded = new Thread() {
			public void run() {
				String tag = ChatFormatting.BLACK + "[" + ChatFormatting.AQUA + "EDGN" + ChatFormatting.BLACK + "] ";
				EntityPlayer player = Minecraft.getMinecraft().player;
				List<String> raid_name = Arrays.asList("The Nameless Anomaly", "The Canyon Colossus",
						"Orphion's Nexus of Light", "Nest of the Grootslangs");
				List<String> raid_libelle = Arrays.asList("TNA", "TCC", "NOL", "NOTG");
				List<Integer> FinalCompletion = new ArrayList<>();
				String pseudo = player.getName();
				if (args.length == 1)
					pseudo = args[0];
				ChatUtils.message(player, tag + " " + ChatFormatting.GOLD + " " + "Raid completions of : " + " "
						+ ChatFormatting.RED + ChatFormatting.BOLD + pseudo);
				ChatUtils.message(player, " ");
				String result = WynnApiUtils
						.getStringFromURL("https://api.wynncraft.com/v2/player/" + pseudo + "/stats");
				int completion = 0;
				for (int i = 0; i < raid_name.size(); i++) {
					completion = 0;

					String regex = raid_name.get(i) + "\",\"completed\":([0-9]*)";
					Matcher matcher = Pattern.compile(regex).matcher(result);
					while (matcher.find()) {
						completion += Integer.valueOf(matcher.group(1));
					}

					FinalCompletion.add(completion);

					ChatUtils.message(player,
							tag + " " + ChatFormatting.AQUA + ChatFormatting.BOLD + raid_libelle.get(i) + " : "
									+ ChatFormatting.GOLD + FinalCompletion.get(i) + " " + ChatFormatting.YELLOW
									+ " times.");
				}
				int sum = FinalCompletion.stream().mapToInt(i -> i).sum();
				ChatUtils.message(player, tag + " " + ChatFormatting.AQUA + ChatFormatting.BOLD + "Total : "
						+ ChatFormatting.GOLD + sum + " " + ChatFormatting.YELLOW + " Times.");
				ChatUtils.message(player, StringUtils.repeat("§m ", 60));
			}
		};
		Threaded.start();
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 0;
	}
}

// System.out.println(WynnApiUtils.getStringFromURL("https://api.wynncraft.com/v2/player/EDGN/stats"));
