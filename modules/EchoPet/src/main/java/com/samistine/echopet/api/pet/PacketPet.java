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

package com.samistine.echopet.api.pet;

import com.samistine.echopet.compat.api.entity.IEntityPacketPet;
import com.samistine.echopet.compat.api.entity.IEntityPet;
import com.samistine.echopet.compat.api.entity.IPacketPet;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PacketPet extends Pet implements IPacketPet {

    public PacketPet(Player owner) {
        super(owner);
    }

    @Override
    public IEntityPacketPet getEntityPet() {
        return (IEntityPacketPet) super.getEntityPet();
    }
}