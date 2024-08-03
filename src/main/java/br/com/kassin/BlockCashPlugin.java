package br.com.kassin;

import br.com.kassin.handler.BlockBreakListener;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockCashPlugin extends JavaPlugin {

    public static Economy economy;

    public static Plugin getInstance() {
        return JavaPlugin.getPlugin(BlockCashPlugin.class);
    }

    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            getLogger().severe(String.format("[%s] - Desativado porque nenhuma dependência do Vault foi encontrada!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        registerListeners(
            new BlockBreakListener()
        );

    }

    @Override
    public void onDisable() {

    }

    private void registerListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }

    private boolean setupEconomy() {
        if (!(getServer().getPluginManager().isPluginEnabled("Vault"))) return false;
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return false;
        economy = rsp.getProvider();
        return true;
    }

}
