package me.benrobson.zander.events;

import me.benrobson.zander.ZanderBungeeMain;
import me.benrobson.zander.discord.DiscordMain;
import me.leoko.advancedban.bungee.event.PunishmentEvent;
import me.leoko.advancedban.bungee.event.RevokePunishmentEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

import java.awt.*;

public class PlayerOnPunish implements Listener {
    private ZanderBungeeMain plugin = ZanderBungeeMain.getInstance();

    @EventHandler
    public void PlayerOnPunish(PunishmentEvent event) {
        String punisheduser = event.getPunishment().getName();
        String punisher = event.getPunishment().getOperator();
        String reason = event.getPunishment().getReason();

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Punishment Logged");
        embed.setColor(Color.ORANGE);
        embed.addField("Punished User", punisheduser, true);
        embed.addField("Punished By", punisher, true);
        embed.addField("Reason", reason, true);
        embed.setFooter("zander // AdvancedBan Hook");

        TextChannel textChannel = (TextChannel) DiscordMain.jda.getTextChannelsByName(plugin.configurationManager.getConfig().getString("discord.punishmentlog"), true);
        textChannel.sendMessage(embed.build()).queue();
    }

    @EventHandler
    public void PlayerOnPunishRevoke(RevokePunishmentEvent event) {
        String punisheduser = event.getPunishment().getName();
        String punisher = event.getPunishment().getOperator();
        String reason = event.getPunishment().getReason();

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("Punishment Revoked");
        embed.setColor(Color.YELLOW);
        embed.addField("Punished User", punisheduser, true);
        embed.addField("Punished By", punisher, true);
        embed.addField("Reason", reason, true);
        embed.setFooter("zander // AdvancedBan Hook");

        TextChannel textChannel = (TextChannel) DiscordMain.jda.getTextChannelsByName(plugin.configurationManager.getConfig().getString("discord.punishmentlog"), true);
        textChannel.sendMessage(embed.build()).queue();
    }
}