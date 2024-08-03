package br.com.kassin.service;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

public interface BlockBreakService {
    void blockBreak(final Player event, final Block block);
}
