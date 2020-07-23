package com.geekpower14.quake.stuff.grenade;

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
public class FragGrenade extends GrenadeBasic {
    public FragGrenade(int id, int nb) {
        super(id,
                "" + ChatColor.RED + ChatColor.BOLD + "Grenade à Fragmentation",
                0L,
                FireworkEffect.builder().withColor(Color.RED).with(FireworkEffect.Type.BALL_LARGE).build());
        setNB(nb);
    }

    @Override
    public ItemStack getItem() {
        ItemStack coucou = setItemNameAndLore(new ItemStack(Material.CLAY_BALL), "" + ChatColor.RED + ChatColor.BOLD + "Grenade à Fragmentation", new String[]{
                ChatColor.DARK_GRAY + "Explose au bout de " + ChatColor.GOLD + "3" + ChatColor.DARK_GRAY + " secondes.",
                ChatColor.DARK_GRAY + "Élimine les joueurs " + ChatColor.GOLD + "3" + ChatColor.DARK_GRAY + " blocs autour."
        }, true);
        coucou.setAmount(this.nb);
        return coucou;
    }
}
