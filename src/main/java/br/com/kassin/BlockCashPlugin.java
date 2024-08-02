package br.com.kassin;

import br.com.kassin.handler.BlockBreakListener;
import br.com.kassin.task.BlockBreakRandomRewardTask;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class BlockCashPlugin extends JavaPlugin {

    public static Economy economy;

    @Override
    public void onEnable() {
        if (!setupEconomy()) {
            getLogger().severe(String.format("[%s] - Desativado porque nenhuma dependência do Vault foi encontrada!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        BlockBreakRandomRewardTask.start();
        registerEvents();
    }

    @Override
    public void onDisable() {

    }

    private void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new BlockBreakListener(), this);
    }

    private boolean setupEconomy() {
        if (!(getServer().getPluginManager().isPluginEnabled("Vault"))) return false;
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) return false;
        economy = rsp.getProvider();
        return true;
    }

}
