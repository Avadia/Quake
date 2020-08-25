package com.geekpower14.quake.utils;

import com.geekpower14.quake.Quake;
import net.minecraft.server.v1_12_R1.EntityFireworks;
import org.bukkit.Bukkit;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_12_R1.CraftWorld;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftFirework;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
public class Utils {
    public static void launchfw(final Location loc, final FireworkEffect effect) {
        final Firework fw = (Firework) loc.getWorld().spawnEntity(loc, EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();
        fwm.addEffect(effect);
        fwm.setPower(0);
        fw.setFireworkMeta(fwm);
        ((CraftFirework) fw).getHandle().setInvisible(true);
        Bukkit.getScheduler().runTaskLater(Quake.getPlugin(), () -> {
            net.minecraft.server.v1_12_R1.World w = (((CraftWorld) loc.getWorld()).getHandle());
            EntityFireworks fireworks = ((CraftFirework) fw).getHandle();
            w.broadcastEntityEffect(fireworks, (byte) 17);
            fireworks.die();
        }, 1);
    }

    public static String poToStr(PotionEffect popo) {
        return popo.getType().getName() + ":" + popo.getAmplifier();
    }

    public static PotionEffect strToPo(String popo) {
        String[] list = popo.split(":");
        return new PotionEffect(PotionEffectType.getByName(list[0]), Integer.MAX_VALUE, Integer.parseInt(list[1]));
    }
}
