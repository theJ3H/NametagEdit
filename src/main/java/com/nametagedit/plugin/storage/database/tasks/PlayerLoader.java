package com.nametagedit.plugin.storage.database.tasks;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.nametagedit.plugin.NametagHandler;
import com.zaxxer.hikari.HikariDataSource;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PlayerLoader extends BukkitRunnable {

	private UUID uuid;
	private Plugin plugin;
	private NametagHandler handler;
	private HikariDataSource hikari;

	@Override
	public void run(){
		new BukkitRunnable() {

			@Override
			public void run(){
				Player player = Bukkit.getPlayer(uuid);
				if (player != null) {

					handler.applyTagToPlayer(player);
				}
			}
		}.runTask(plugin);

	}

}