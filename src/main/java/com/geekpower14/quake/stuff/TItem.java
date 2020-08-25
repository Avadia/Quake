package com.geekpower14.quake.stuff;

import com.geekpower14.quake.Quake;
import com.geekpower14.quake.arena.APlayer;
import com.geekpower14.quake.utils.ItemSlot;
import net.samagames.tools.GlowEffect;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

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
public abstract class TItem implements Cloneable {
    protected static Quake plugin;
    private final String alias;
    protected int id;
    protected long reloadTime;
    protected int nb;

    public TItem(int id, String display, int nb, long l) {
        this.id = id;
        this.alias = display;
        this.reloadTime = l;

        this.nb = nb;

        plugin = Quake.getPlugin();
    }

    public static ItemStack setItemNameAndLore(ItemStack item, String name, String[] lore, boolean glow) {
        ItemMeta im = item.getItemMeta();
        if (im == null)
            return item;
        if (!name.isEmpty())
            im.setDisplayName(name);
        if (lore != null)
            im.setLore(Arrays.asList(lore));
        item.setItemMeta(im);
        try {
            if (glow)
                item = GlowEffect.addGlow(item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public static long secondToTick(double second) {
        return (long) (second * 20);
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return alias;
    }

    public Object clone() {
        Object o = null;
        try {
            // On récupère l'instance à renvoyer par l'appel de la
            // méthode super.clone()
            o = super.clone();
        } catch (CloneNotSupportedException cnse) {
            // Ne devrait jamais arriver car nous implémentons
            // l'interface Cloneable
            cnse.printStackTrace(System.err);
        }
        // on renvoie le clone
        return o;
    }

    public int getNB() {
        return nb;
    }

    public void setNB(int nb) {
        this.nb = nb;
    }

    public abstract ItemStack getItem();

    public abstract void rightAction(APlayer ap, ItemSlot slot);

    public abstract void leftAction(APlayer p, ItemSlot slot);

    //public abstract void onItemTouchGround(arena arena, Item item);
}
