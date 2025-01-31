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

package net.momirealms.customfishing.object.loot;

import net.momirealms.customfishing.object.action.ActionInterface;
import net.momirealms.customfishing.object.fishing.Difficulty;
import net.momirealms.customfishing.object.fishing.Layout;
import net.momirealms.customfishing.object.requirements.RequirementInterface;

public class Loot {

    public static Loot EMPTY = new Loot("empty", new Difficulty(1,1), 5000, 10);

    protected String key;
    protected String nick;
    protected Difficulty difficulty;
    protected String group;
    protected boolean showInFinder;
    protected Layout[] layout;
    protected ActionInterface[] successActions;
    protected ActionInterface[] failureActions;
    protected ActionInterface[] hookActions;
    protected int weight;
    protected int time;
    protected RequirementInterface[] requirements;
    protected double score;

    public Loot(String key, Difficulty difficulty, int time, int weight) {
        this.key = key;
        this.difficulty = difficulty;
        this.time = time;
        this.weight = weight;
    }

    public String getKey() {
        return key;
    }
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public boolean isShowInFinder() {
        return showInFinder;
    }

    public void setShowInFinder(boolean showInFinder) {
        this.showInFinder = showInFinder;
    }

    public Layout[] getLayout() {
        return layout;
    }

    public void setLayout(Layout[] layout) {
        this.layout = layout;
    }

    public ActionInterface[] getSuccessActions() {
        return successActions;
    }

    public void setSuccessActions(ActionInterface[] successActions) {
        this.successActions = successActions;
    }

    public ActionInterface[] getFailureActions() {
        return failureActions;
    }

    public void setFailureActions(ActionInterface[] failureActions) {
        this.failureActions = failureActions;
    }

    public ActionInterface[] getHookActions() {
        return hookActions;
    }

    public void setHookActions(ActionInterface[] hookActions) {
        this.hookActions = hookActions;
    }

    public int getWeight() {
        return weight;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public RequirementInterface[] getRequirements() {
        return requirements;
    }

    public void setRequirements(RequirementInterface[] requirements) {
        this.requirements = requirements;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
