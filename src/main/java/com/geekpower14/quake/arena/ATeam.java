package com.geekpower14.quake.arena;

import net.samagames.tools.scoreboards.TeamHandler;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
public class ATeam {

    private final String name;

    private final ChatColor color;

    private final Color Scolor;

    private final DyeColor dc;

    private final Arena aren;
    private final List<OfflinePlayer> players = new ArrayList<>();
    private int Score = 0;
    private boolean isActive = false;

    public ATeam(Arena aren, String name, ChatColor color, Color scolor, DyeColor dc) {
        this.name = name;
        this.color = color;
        this.aren = aren;
        Scolor = scolor;
        this.dc = dc;

        createTeam();
    }

    public void createTeam() {
        ArenaTeam arenaTeam = (ArenaTeam) aren;
        TeamHandler.VTeam team = arenaTeam.getTeamHandler().createNewTeam(name, "");
        team.setRealName(name);
        team.setPrefix("" + color);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean a) {
        isActive = a;
    }

    public Arena getArena() {
        return aren;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int s) {
        Score = s;
    }

    public void addScore(int s) {
        Score += s;
    }

    public String getName() {
        return name;
    }

    public void addPlayer(Player p) {
        players.add(p);
        ArenaTeam arenaTeam = (ArenaTeam) aren;
        arenaTeam.getTeamHandler().getTeamByName(name).addPlayer(p);
    }

    public void removePlayer(Player p) {
        players.remove(p);
        ArenaTeam arenaTeam = (ArenaTeam) aren;
        arenaTeam.getTeamHandler().getTeamByName(name).removePlayer(p);
    }

    public Boolean hasPlayer(Player p) {
        for (OfflinePlayer op : players) {
            if (op.getUniqueId().equals(p.getUniqueId()))
                return true;
        }
        return false;
    }

    public void giveChestplate(Player p) {
        ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
        meta.setDisplayName(color + "Team " + name);
        List<String> l = new ArrayList<>();
        l.add(ChatColor.RESET + "A beautiful leather dress!");
        meta.setLore(l);
        meta.setColor(Scolor);
        item.setItemMeta(meta);

        p.getInventory().setChestplate(item);
    }

    public List<OfflinePlayer> getPlayers() {
        return players;
    }

    public Collection<Player> getTalkPlayers() {
        return getPlayers().stream().map(OfflinePlayer::getPlayer).collect(Collectors.toList());
    }

    @SuppressWarnings("deprecation")
    public boolean isBlockTeam(Block b) {
        return b.getData() == getDyeColor().getWoolData();
    }

    public int getSize() {
        return players.size();
    }

    public ChatColor getColor() {
        return color;
    }

    public DyeColor getDyeColor() {
        return dc;
    }

}
