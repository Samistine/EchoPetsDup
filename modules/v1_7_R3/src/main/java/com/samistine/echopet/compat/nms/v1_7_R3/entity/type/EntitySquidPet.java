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

package com.samistine.echopet.compat.nms.v1_7_R3.entity.type;

import com.samistine.echopet.compat.api.entity.*;
import com.samistine.echopet.compat.api.entity.type.nms.IEntitySquidPet;
import com.samistine.echopet.compat.api.util.ParticleUtil;
import com.samistine.echopet.compat.api.util.protocol.wrapper.WrapperPacketWorldParticles;
import com.samistine.echopet.compat.nms.v1_7_R3.entity.EntityPet;
import net.minecraft.server.v1_7_R3.World;

@EntitySize(width = 0.95F, height = 0.95F)
@EntityPetType(petType = PetType.SQUID)
public class EntitySquidPet extends EntityPet implements IEntitySquidPet {

    public EntitySquidPet(World world) {
        super(world);
    }

    public EntitySquidPet(World world, IPet pet) {
        super(world, pet);
    }

    @Override
    protected String getIdleSound() {
        return "";
    }

    @Override
    protected String getDeathSound() {
        return null;
    }

    @Override
    public SizeCategory getSizeCategory() {
        return SizeCategory.REGULAR;
    }

    @Override
    public void onLive() {
        super.onLive();
        if (this.random.nextBoolean() && particle <= 0 && !this.isInvisible()) {
            if (this.L()) {
                ParticleUtil.show(WrapperPacketWorldParticles.ParticleType.BUBBLE, this.getLocation());
            }
            ParticleUtil.show(WrapperPacketWorldParticles.ParticleType.SPLASH, this.getLocation());
        }
    }
}