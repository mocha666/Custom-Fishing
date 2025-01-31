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

package net.momirealms.customfishing.competition;

import net.momirealms.customfishing.competition.bossbar.BossBarConfig;
import net.momirealms.customfishing.object.action.ActionInterface;

import java.util.HashMap;
import java.util.List;

public class CompetitionConfig {

    private final int duration;
    private final int minPlayers;
    private final List<String> startMessage;
    private final List<String> endMessage;
    private final List<String> startCommand;
    private final List<String> endCommand;
    private final List<String> joinCommand;
    private final CompetitionGoal goal;
    private final BossBarConfig bossBarConfig;
    private final boolean enableBossBar;
    private final HashMap<String, ActionInterface[]> rewards;

    public CompetitionConfig(int duration, int minPlayers, List<String> startMessage, List<String> endMessage, List<String> startCommand, List<String> endCommand, List<String> joinCommand, CompetitionGoal goal, BossBarConfig bossBarConfig, boolean enableBossBar, HashMap<String, ActionInterface[]> rewards) {
        this.duration = duration;
        this.minPlayers = minPlayers;
        this.startMessage = startMessage;
        this.endMessage = endMessage;
        this.startCommand = startCommand;
        this.endCommand = endCommand;
        this.joinCommand = joinCommand;
        this.goal = goal;
        this.bossBarConfig = bossBarConfig;
        this.enableBossBar = enableBossBar;
        this.rewards = rewards;
    }

    public int getDuration() {
        return duration;
    }

    public int getMinPlayers() {
        return minPlayers;
    }

    public List<String> getStartMessage() {
        return startMessage;
    }

    public List<String> getEndMessage() {
        return endMessage;
    }

    public List<String> getStartCommand() {
        return startCommand;
    }

    public List<String> getEndCommand() {
        return endCommand;
    }

    public List<String> getJoinCommand() {
        return joinCommand;
    }

    public CompetitionGoal getGoal() {
        return goal;
    }

    public BossBarConfig getBossBarConfig() {
        return bossBarConfig;
    }

    public boolean isEnableBossBar() {
        return enableBossBar;
    }

    public HashMap<String, ActionInterface[]> getRewards() {
        return rewards;
    }
}
