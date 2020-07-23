package com.geekpower14.quake.stuff.hoe;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/*
 * This file is part of Quake.
 *
 * Quake is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Quake is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Quake.  If not, see <http://www.gnu.org/licenses/>.
 */
public class BlasterHoe extends HoeBasic {

    public BlasterHoe() {
        super(87,
                ChatColor.BLUE + "Blaster DL-22",
                secondToTick(1.1),
                FireworkEffect.builder().withColor(Color.FUCHSIA).with(FireworkEffect.Type.CREEPER).build());
        //this.aim = 1.2;
    }

    public ItemStack getItem() {
        return setItemNameAndLore(new ItemStack(Material.DIAMOND_BARDING), ChatColor.BLUE + "Blaster DL-22", new String[]{
                ChatColor.DARK_GRAY + "Recharge en " + ChatColor.GOLD + "1.1" + ChatColor.DARK_GRAY + " secondes."
        }, false);
    }
}
