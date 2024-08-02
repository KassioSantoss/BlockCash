package br.com.kassin.service.provider;

import br.com.kassin.BlockCashPlugin;
import br.com.kassin.service.BlockBreakService;
import br.com.kassin.task.BlockBreakRandomRewardTask;
import br.com.kassin.utils.MessageUtils;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public final class DefaultBlockBreakService implements BlockBreakService {

    private final Economy economy = BlockCashPlugin.economy;

    @Override
    public void blockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack itemInHand = player.getInventory().getItemInMainHand();

        if (!isPickaxe(itemInHand.getType())) {
            MessageUtils.Chat.sendMessage(player, "&bVocê precisa quebrar com uma picareta para ganhar dinheiro.");
            return;
        }

        if (!(block.getType() == Material.STONE)) return;

        int random = BlockBreakRandomRewardTask.RANDOM_NUMBER;

        if (!(random < 10)) return;

        giveMoney(event);
    }

    public void giveMoney(BlockBreakEvent event) {
        economy.depositPlayer(event.getPlayer(), 10);
        MessageUtils.ActionBar.sendActionBar(event.getPlayer(), "&aVocê recebeu: 10$");
    }

    private boolean isPickaxe(Material material) {
        return material == Material.NETHERITE_PICKAXE ||
                material == Material.DIAMOND_PICKAXE ||
                material == Material.GOLDEN_PICKAXE ||
                material == Material.IRON_PICKAXE ||
                material == Material.STONE_PICKAXE ||
                material == Material.WOODEN_PICKAXE;
    }

}
