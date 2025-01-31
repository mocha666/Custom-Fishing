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

package net.momirealms.customfishing.manager;

import net.momirealms.customfishing.object.Function;
import net.momirealms.customfishing.object.fishing.Layout;
import net.momirealms.customfishing.util.AdventureUtil;
import net.momirealms.customfishing.util.ConfigUtil;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.HashMap;
import java.util.Objects;
import java.util.Set;

public class LayoutManager extends Function {

    public static HashMap<String, Layout> LAYOUTS;

    @Override
    public void load() {
        LAYOUTS = new HashMap<>();
        YamlConfiguration config = ConfigUtil.getConfig("bars.yml");
        Set<String> keys = config.getKeys(false);
        for (String key : keys) {
            int range = config.getInt(key + ".range");
            Set<String> rates = Objects.requireNonNull(config.getConfigurationSection(key + ".layout")).getKeys(false);
            double[] successRate = new double[rates.size()];
            for(int i = 0; i < rates.size(); i++)
                successRate[i] = config.getDouble(key + ".layout." + (i + 1));
            int size = rates.size() * range - 1;
            Layout layout = new Layout(
                    range,
                    successRate,
                    size,
                    config.getString(key + ".subtitle.start","<font:customfishing:default>"),
                    config.getString(key + ".subtitle.bar","뀃"),
                    config.getString(key + ".subtitle.pointer","뀄"),
                    config.getString(key + ".subtitle.offset","뀁"),
                    config.getString(key + ".subtitle.end","</font>"),
                    config.getString(key + ".subtitle.pointer_offset","뀂"),
                    config.getString(key + ".title"," ")
            );
            LAYOUTS.put(key, layout);
        }
        AdventureUtil.consoleMessage("[CustomFishing] Loaded <green>" + LAYOUTS.size() + " <gray>bars");
    }

    @Override
    public void unload() {
        if (LAYOUTS != null) LAYOUTS.clear();
    }
}
