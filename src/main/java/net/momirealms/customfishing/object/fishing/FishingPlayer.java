/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customfishing.object.fishing;

import net.momirealms.customfishing.CustomFishing;
import net.momirealms.customfishing.manager.FishingManager;
import net.momirealms.customfishing.manager.MessageManager;
import net.momirealms.customfishing.util.AdventureUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class FishingPlayer extends BukkitRunnable {

    private final long deadline;
    private final Player player;
    private final Difficulty difficulty;
    private final FishingManager fishingManager;
    private int progress;
    private int internalTimer;
    private final int size;
    private boolean face;
    private final String start;
    private final String bar;
    private final String pointer;
    private final String offset;
    private final String end;
    private final String pointerOffset;
    private final String title;
    private final double[] successRate;
    private final int range;
    private final boolean isDouble;
    private final double scoreMultiplier;

    public FishingPlayer(long deadline, Player player, Layout layout, Difficulty difficulty, FishingManager fishingManager, boolean isDouble, double scoreMultiplier) {
        this.deadline = deadline;
        this.player = player;
        this.difficulty = difficulty;
        this.fishingManager = fishingManager;
        this.size = layout.getSize();
        this.start = layout.getStart();
        this.bar = layout.getBar();
        this.pointer = layout.getPointer();
        this.offset = layout.getOffset();
        this.end = layout.getEnd();
        this.pointerOffset = layout.getPointerOffset();;
        this.title = layout.getTitle();
        this.range = layout.getRange();
        this.successRate = layout.getSuccessRate();
        this.isDouble = isDouble;
        this.scoreMultiplier = scoreMultiplier;
    }

    @Override
    public void run() {

        if (System.currentTimeMillis() > deadline) {
            AdventureUtil.playerMessage(player, MessageManager.prefix + MessageManager.escape);
            fishingManager.removeFishingPlayer(player);
            cancel();
            return;
        }

        if (internalTimer < difficulty.timer() - 1) {
            internalTimer++;
            return;
        } else {
            if (face) {
                progress += difficulty.speed();
            }
            else {
                progress -= difficulty.speed();
            }
            if (progress > size) {
                face = !face;
                progress = 2 * size - progress;
            }
            else if (progress < 0) {
                face = !face;
                progress = -progress;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(start + bar + pointerOffset);
        for (int index = 0; index <= size; index++) {
            if (index == progress){
                stringBuilder.append(pointer);
            } else {
                stringBuilder.append(offset);
            }
        }
        stringBuilder.append(end);
        AdventureUtil.playerTitle(player, title, stringBuilder.toString(),0,500,0);

        PlayerInventory playerInventory = player.getInventory();
        if (playerInventory.getItemInMainHand().getType() != Material.FISHING_ROD && playerInventory.getItemInOffHand().getType() != Material.FISHING_ROD) {
            fishingManager.removeFishingPlayer(player);
            cancel();
            Bukkit.getScheduler().runTask(CustomFishing.plugin, () -> player.removePotionEffect(PotionEffectType.SLOW));
        }
    }


    public boolean isSuccess() {
        int last = progress / range;
        return (Math.random() < successRate[last]);
    }

    public boolean isDouble() {
        return isDouble;
    }

    public double getScoreMultiplier() {
        return scoreMultiplier;
    }
}
