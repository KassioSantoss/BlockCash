package br.com.kassin.handler;

import br.com.kassin.BlockCashPlugin;
import br.com.kassin.service.BlockBreakService;
import br.com.kassin.utils.MessageUtils;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public final class BlockBreakListener implements Listener, BlockBreakService {

    private final Economy economy = BlockCashPlugin.economy;

    @EventHandler(priority = EventPriority.HIGH)
    public void onBreak(BlockBreakEvent event) {
        blockBreak(event.getPlayer(), event.getBlock());
    }

    @Override
    public void blockBreak(final Player player, final Block block) {
        final ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (!(block.getType() == Material.STONE)) return;

        if (!isPickaxe(itemInHand.getType())) {
            MessageUtils.Chat.sendMessage(player, "&bVocê precisa quebrar com uma picareta para ganhar dinheiro.");
            return;
        }

        final int random = (int) (Math.random() * 100);

        player.sendMessage("random number: " + random);

        if (!(random < 10)) return;

        giveRewards(player);
    }

    private void giveRewards(final Player player) {
        economy.depositPlayer(player, 10);
        MessageUtils.ActionBar.sendActionBar(player, "&f&l| &aVocê recebeu: &610$ &f&l|");
    }

    private boolean isPickaxe(final Material material) {
        return material == Material.NETHERITE_PICKAXE ||
                material == Material.DIAMOND_PICKAXE ||
                material == Material.GOLDEN_PICKAXE ||
                material == Material.IRON_PICKAXE ||
                material == Material.STONE_PICKAXE ||
                material == Material.WOODEN_PICKAXE;
    }

}

