package net.edgn.commands.raids;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShowPartyRaidCompletions {
	@SubscribeEvent
	public void ignoreChatMessage(ClientChatReceivedEvent event) throws InterruptedException {
		final Thread Threaded = new Thread() {
			public void run() {
				Minecraft mc = Minecraft.getMinecraft();
				EntityPlayer player = mc.player;
				String message = event.getMessage().getUnformattedText();
				if (message.contains("Party members:")) {
					Matcher matcher = Pattern.compile("([^Party members][^:, ][A-Za-z0-9_]*)").matcher(message);
					while (matcher.find()) {
						System.out.println("VRAI GAMING");
						ClientCommandHandler.instance.executeCommand(player, "/edr " + matcher.group(1));
						System.out.println(matcher.group(1));
						try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		};
		Threaded.start();
	}
}
// System.out.println(WynnApiUtils.getStringFromURL("https://api.wynncraft.com/v2/player/EDGN/stats"));