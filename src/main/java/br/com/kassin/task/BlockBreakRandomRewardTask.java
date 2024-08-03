package br.com.kassin.task;

import br.com.kassin.BlockCashPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockBreakRandomRewardTask extends BukkitRunnable {

    public static int RANDOM_NUMBER;

    private BlockBreakRandomRewardTask() {
    }

    public static void start(int delay,int period) {
        BlockBreakRandomRewardTask task = new BlockBreakRandomRewardTask();
        task.runTaskTimer(BlockCashPlugin.getInstance(), delay, period);
    }

    @Override
    public void run() {
        RANDOM_NUMBER = (int) (Math.random() * 100);
    }

}
