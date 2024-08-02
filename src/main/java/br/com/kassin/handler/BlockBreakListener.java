package br.com.kassin.handler;

import br.com.kassin.service.provider.DefaultBlockBreakService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public final class BlockBreakListener implements Listener {

    private final DefaultBlockBreakService defaultBlockBreakService;

    public BlockBreakListener() {
        defaultBlockBreakService = new DefaultBlockBreakService();
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onBreak(final BlockBreakEvent event) {
        defaultBlockBreakService.blockBreak(event);

    }

}
