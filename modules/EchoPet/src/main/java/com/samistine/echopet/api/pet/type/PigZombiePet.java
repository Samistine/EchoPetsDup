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

package com.samistine.echopet.api.pet.type;

import com.samistine.echopet.api.pet.Pet;
import com.samistine.echopet.compat.api.entity.EntityPetType;
import com.samistine.echopet.compat.api.entity.IEntityPet;
import com.samistine.echopet.compat.api.entity.PetType;
import com.samistine.echopet.compat.api.entity.type.nms.IEntityPigZombiePet;
import com.samistine.echopet.compat.api.entity.type.pet.IPigZombiePet;
import org.bukkit.entity.Player;

import java.util.UUID;

@EntityPetType(petType = PetType.PIGZOMBIE)
public class PigZombiePet extends Pet implements IPigZombiePet {

    boolean baby = false;
    boolean villager = false;
    boolean equipment = false;

    public PigZombiePet(Player owner) {
        super(owner);
    }

    @Override
    public void setBaby(boolean flag) {
        ((IEntityPigZombiePet) getEntityPet()).setBaby(flag);
        this.baby = flag;
    }

    @Override
    public boolean isBaby() {
        return this.baby;
    }

    @Override
    public void setVillager(boolean flag) {
        ((IEntityPigZombiePet) getEntityPet()).setVillager(flag);
        this.villager = flag;
    }

    @Override
    public boolean isVillager() {
        return this.villager;
    }

}
