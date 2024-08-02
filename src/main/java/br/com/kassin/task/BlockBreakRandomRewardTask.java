package br.com.kassin.task;

import br.com.kassin.BlockCashPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockBreakRandomRewardTask extends BukkitRunnable {

    public static int RANDOM_NUMBER;

    private BlockBreakRandomRewardTask() {
    }

    public static void start() {
        BlockBreakRandomRewardTask task = new BlockBreakRandomRewardTask();
        task.runTaskTimer(BlockCashPlugin.getInstance(), 0, 10);
    }

    @Override
    public void run() {
        RANDOM_NUMBER = (int) (Math.random() * 100);
    }

}
