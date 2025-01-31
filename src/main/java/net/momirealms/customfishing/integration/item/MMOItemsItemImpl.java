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

import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.Type;
import net.Indyuce.mmoitems.api.item.mmoitem.MMOItem;
import net.momirealms.customfishing.integration.ItemInterface;
import org.apache.commons.lang.StringUtils;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.Nullable;

public class MMOItemsItemImpl implements ItemInterface {

    @Nullable
    @Override
    public ItemStack build(String material) {
        if (!material.startsWith("MMOItems:")) return null;
        material = material.substring(9);
        String[] split = StringUtils.split(material, ":");
        MMOItem mmoItem = MMOItems.plugin.getMMOItem(Type.get(split[0]), split[1]);
        return mmoItem == null ? null : mmoItem.newBuilder().getItemStack();
    }
}
