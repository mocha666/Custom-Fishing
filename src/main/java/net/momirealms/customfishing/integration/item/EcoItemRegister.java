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

package net.momirealms.customfishing.integration.item;

import com.willfp.eco.core.items.CustomItem;
import de.tr7zw.changeme.nbtapi.NBTCompound;
import de.tr7zw.changeme.nbtapi.NBTItem;
import net.momirealms.customfishing.CustomFishing;
import net.momirealms.customfishing.manager.BonusManager;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class EcoItemRegister {

    public static void registerItems() {
        // Rods
        for (Map.Entry<String, ItemStack> entry : BonusManager.RODITEMS.entrySet()) {
            new CustomItem(
                    new NamespacedKey(CustomFishing.plugin, "rod_" + entry.getKey()),
                    itemStack -> {
                        try {
                            NBTItem nbtItem = new NBTItem(itemStack);
                            NBTCompound nbtCompound = nbtItem.getCompound("CustomFishing");
                            return  nbtCompound != null
                                    && nbtCompound.getString("type").equalsIgnoreCase("rod")
                                    && nbtCompound.getString("id").equalsIgnoreCase(entry.getKey());
                        } catch (Exception e) {
                            return false;
                        }
                    },
                    entry.getValue()
            ).register();
        }
        // Baits
        for (Map.Entry<String, ItemStack> entry : BonusManager.BAITITEMS.entrySet()) {
            new CustomItem(
                    new NamespacedKey(CustomFishing.plugin, "bait_" + entry.getKey()),
                    itemStack -> {
                        try {
                            NBTItem nbtItem = new NBTItem(itemStack);
                            NBTCompound nbtCompound = nbtItem.getCompound("CustomFishing");
                            return  nbtCompound != null
                                    && nbtCompound.getString("type").equalsIgnoreCase("bait")
                                    && nbtCompound.getString("id").equalsIgnoreCase(entry.getKey());
                        } catch (Exception e) {
                            return false;
                        }
                    },
                    entry.getValue()
            ).register();
        }
        // Utils
        for (Map.Entry<String, ItemStack> entry : BonusManager.UTILITEMS.entrySet()) {
            new CustomItem(
                    new NamespacedKey(CustomFishing.plugin, "util_" + entry.getKey()),
                    itemStack -> {
                        try {
                            NBTItem nbtItem = new NBTItem(itemStack);
                            NBTCompound nbtCompound = nbtItem.getCompound("CustomFishing");
                            return  nbtCompound != null
                                    && nbtCompound.getString("type").equalsIgnoreCase("util")
                                    && nbtCompound.getString("id").equalsIgnoreCase(entry.getKey());
                        } catch (Exception e) {
                            return false;
                        }
                    },
                    entry.getValue()
            ).register();
        }
    }
}
