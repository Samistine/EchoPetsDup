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

package com.samistine.echopet.compat.api.entity.type.pet;

import com.samistine.echopet.compat.api.entity.IAgeablePet;
import org.bukkit.entity.Villager;

public interface IVillagerPet extends IAgeablePet {

    public Villager.Profession getProfession();

    public int getProfessionId();

    public void setProfession(Villager.Profession prof);
}