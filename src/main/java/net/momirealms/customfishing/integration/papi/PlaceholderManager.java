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

package net.momirealms.customfishing.integration.papi;

import me.clip.placeholderapi.PlaceholderAPI;
import net.momirealms.customfishing.object.Function;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaceholderManager extends Function {

    private final Pattern placeholderPattern = Pattern.compile("%([^%]*)%");
    private final CompetitionPapi competitionPapi;

    public PlaceholderManager() {
        this.competitionPapi = new CompetitionPapi();
        load();
    }

    public String parse(Player player, String text) {
        return PlaceholderAPI.setPlaceholders(player, text);
    }

    public String parse(OfflinePlayer offlinePlayer, String text) {
        return PlaceholderAPI.setPlaceholders(offlinePlayer, text);
    }

    @Override
    public void load() {
        competitionPapi.register();
    }

    @Override
    public void unload() {
        if (this.competitionPapi != null) competitionPapi.unregister();
    }

    public List<String> detectPlaceholders(String text){
        if (text == null || !text.contains("%")) return Collections.emptyList();
        List<String> placeholders = new ArrayList<>();
        Matcher matcher = placeholderPattern.matcher(text);
        while (matcher.find()) placeholders.add(matcher.group());
        return placeholders;
    }
}
