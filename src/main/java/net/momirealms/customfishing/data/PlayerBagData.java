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

package net.momirealms.customfishing.data;

import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.Inventory;

public class PlayerBagData {

    private final OfflinePlayer player;
    private Inventory inventory;

    public PlayerBagData(OfflinePlayer player, Inventory inventory) {
        this.player = player;
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public OfflinePlayer getPlayer() {
        return player;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
