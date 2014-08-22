/*
 * This file is part of EchoPet.
 *
 * EchoPet is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * EchoPet is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with EchoPet.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.samistine.echopet.compat.api.util;

import com.samistine.echopet.compat.api.entity.PetData;
import com.samistine.echopet.compat.api.entity.PetType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum Perm {

    ADMIN("echopet2.petadmin"),
    ADMIN_CALL("echopet.petadmin.call"),
    ADMIN_DEFAULT_REMOVE("echopet2.petadmin.default.remove"),
    ADMIN_DEFAULT_SET_CURRENT("echopet2.petadmin.default.set.current"),
    ADMIN_DEFAULT_SET_PETTYPE("echopet2.petadmin!default.set.type"),
    ADMIN_HAT("echopet2.petadmin!hat"),
    ADMIN_RIDE("echopet2.petadmin!ride"),
    ADMIN_HIDE("echopet2.petadmin.hide"),
    ADMIN_INFO("echopet2.petadmin.info"),
    ADMIN_MENU("echopet2.petadmin.menu"),
    ADMIN_NAME("echopet2.petadmin.name"),
    ADMIN_PETTYPE("echopet2.petadmin!type"),
    ADMIN_RELOAD("echopet2.petadmin.reload"),
    ADMIN_REMOVE("echopet2.petadmin.remove"),
    ADMIN_SHOW("echopet2.petadmin.show"),
    ADMIN_SELECT("echopet2.petadmin.select"),
    ADMIN_SELECTOR("echopet2.petadmin.selector"),

    BASE("echopet2.pet"),
    LIST("echopet2.pet.list"),
    BASE_CALL("echopet2.pet.call"),
    BASE_DEFAULT_REMOVE("echopet2.pet.default.remove"),
    BASE_DEFAULT_SET_CURRENT("echopet2.pet.default.set.current"),
    BASE_DEFAULT_SET_PETTYPE("echopet2.pet!default.set.type"),
    BASE_HAT("echopet2.pet!hat"),
    BASE_HIDE("echopet2.pet.hide"),
    BASE_RIDE("echopet2.pet!ride"),
    BASE_INFO("echopet2.pet.info"),
    BASE_MENU("echopet2.pet.menu"),
    BASE_NAME("echopet2.pet.name"),
    BASE_PETTYPE("echopet2.pet!type"),
    BASE_REMOVE("echopet2.pet.remove"),
    BASE_SHOW("echopet2.pet.show"),
    BASE_SELECT("echopet2.pet.select"),
    BASE_SELECTOR("echopet2.pet.selector"),
    BASE_TOGGLE("echopet2.pet.toggle");

    String perm;

    Perm(String perm) {
        this.perm = perm;
    }

    public boolean hasPerm(CommandSender sender, boolean sendMessage, boolean allowConsole) {
        if (sender instanceof Player) {
            return hasPerm(((Player) sender), sendMessage);
        } else {
            if (!allowConsole && sendMessage) {
                Lang.sendTo(sender, Lang.IN_GAME_ONLY.toString());
            }
            return allowConsole;
        }
    }

    public static boolean hasPerm(CommandSender sender, String perm, boolean sendMessage, boolean allowConsole) {
        if (sender instanceof Player) {
            return hasPerm(((Player) sender), perm, sendMessage);
        } else {
            if (!allowConsole && sendMessage) {
                Lang.sendTo(sender, Lang.IN_GAME_ONLY.toString());
            }
            return allowConsole;
        }
    }

    public static boolean hasTypePerm(CommandSender sender, boolean sendMessage, Perm base, boolean allowConsole, PetType petType) {
        if (sender instanceof Player) {
            return hasTypePerm(((Player) sender), sendMessage, base, petType);
        } else {
            if (!allowConsole && sendMessage) {
                Lang.sendTo(sender, Lang.IN_GAME_ONLY.toString());
            }
            return allowConsole;
        }
    }

    public static boolean hasDataPerm(CommandSender sender, boolean sendMessage, PetType petType, PetData petData, boolean allowConsole) {
        if (sender instanceof Player) {
            return hasDataPerm(((Player) sender), sendMessage, petType, petData);
        } else {
            if (!allowConsole && sendMessage) {
                Lang.sendTo(sender, Lang.IN_GAME_ONLY.toString());
            }
            return allowConsole;
        }
    }

    private boolean hasPerm(CommandSender player, boolean sendMessage) {
        if (player.hasPermission(this.perm)) {
            return true;
        }
        if (sendMessage) {
            Lang.sendTo(player, Lang.NO_PERMISSION.toString().replace("%perm%", this.perm));
        }
        //ConsoleLogger.log(Logger.LogLevel.NORMAL, player.getName() + " was denied access to command. " + perm + " permission needed.");
        return false;
    }

    private static boolean hasPerm(Player player, String perm, boolean sendMessage) {
        if (player.hasPermission(perm)) {
            return true;
        }
        if (sendMessage) {
            Lang.sendTo(player, Lang.NO_PERMISSION.toString().replace("%perm%", perm));
        }
        //ConsoleLogger.log(Logger.LogLevel.NORMAL, player.getName() + " was denied access to command. " + perm + " permission needed.");
        return false;
    }

    private static boolean hasTypePerm(Player player, boolean sendMessage, Perm base, PetType petType) {
        String perm = "echopet2.pet." + base.perm.split("!")[1] + "." + petType.toString().toLowerCase();
        if (player.hasPermission(perm)) {
            return true;
        }
        if (sendMessage) {
            Lang.sendTo(player, Lang.NO_PERMISSION.toString().replace("%perm%", perm));
        }
        //ConsoleLogger.log(Logger.LogLevel.NORMAL, player.getName() + " was denied access to command. " + perm + " permission needed.");
        return false;
    }

    private static boolean hasDataPerm(Player player, boolean sendMessage, PetType petType, PetData petData) {
        boolean hasTypePerm = hasTypePerm(player, sendMessage, Perm.BASE_PETTYPE, petType);
        if (!hasTypePerm) {
            return false;
        }
        String dataPerm = "echopet2.pet.type." + petType.toString().toLowerCase() + "." + petData.getConfigOptionString().toLowerCase();
        if (player.hasPermission(dataPerm)) {
            return true;
        }

        if (sendMessage) {
            Lang.sendTo(player, Lang.NO_PERMISSION.toString().replace("%perm%", dataPerm));
        }
        //ConsoleLogger.log(Logger.LogLevel.NORMAL, player.getName() + " was denied access to command. " + dataPerm + " permission needed.");
        return false;
    }
}