package br.com.kassin.handler;

import br.com.kassin.service.BlockBreakService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class BlockBreakListener implements Listener {

    private final BlockBreakService blockBreakService;

    public BlockBreakListener(BlockBreakService blockBreakService) {
        this.blockBreakService = blockBreakService;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBreak(final BlockBreakEvent event) {
        blockBreakService.blockBreak(event);

    }

}
