package me.glaremasters.multieconomyexpansion;

import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.glaremasters.multieconomy.MultiEconomy;
import me.glaremasters.multieconomy.api.API;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public final class MultiEconomyExpansion extends PlaceholderExpansion {

    @Override
    public boolean canRegister() {
        MultiEconomy economy = (MultiEconomy) Bukkit.getPluginManager().getPlugin(getRequiredPlugin());
        return economy != null;
    }

    @Override
    public String getAuthor() {
        return "blockslayer22";
    }

    @Override
    public String getIdentifier() {
        return "multieconomy";
    }

    @Override
    public String getRequiredPlugin() {
        return "MultiEconomy";
    }

    @Override
    public String getVersion() {
        return "1.0.1";
    }

    @Override
    public String onPlaceholderRequest(final Player player, @NotNull final String identifier) {

        if (player == null) {
            return "";
        }
        if (identifier.startsWith("amount_")) {
            final String string = identifier.split("_")[1];
            if (string == null || string.isEmpty()) {
                return "";
            }
            return API.getAmount(player.getUniqueId().toString(), string);
        }

        return null;
    }
}
