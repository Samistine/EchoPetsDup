package io.github.dsh105.echopet.entity.living.type.chicken;


import io.github.dsh105.echopet.entity.PetType;
import io.github.dsh105.echopet.entity.living.IAgeablePet;
import io.github.dsh105.echopet.entity.living.LivingPet;
import org.bukkit.entity.Player;

public class ChickenPet extends LivingPet implements IAgeablePet {

    boolean baby;

    public ChickenPet(Player owner, PetType petType) {
        super(owner, petType);
    }

    @Override
    public void setBaby(boolean flag) {
        ((EntityChickenPet) getEntityPet()).setBaby(flag);
        this.baby = flag;
    }

    @Override
    public boolean isBaby() {
        return this.baby;
    }
}