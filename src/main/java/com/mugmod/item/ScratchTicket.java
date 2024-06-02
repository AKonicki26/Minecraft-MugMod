package com.mugmod.item;

import com.mugmod.MugMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MinecartItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.Random;

public class ScratchTicket extends ModItem {
    public ScratchTicket(Settings settings) {
        super(settings, "scratch_ticket");
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(this));
    }

    public int dedication = 0;

    //Test Function

    /*
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(world.isClient) return super.use(world, user, hand);

        MugMod.LOGGER.info("4");
        SnowballEntity testEntity = new SnowballEntity(world, user);
        testEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
        world.spawnEntity(testEntity);

        return super.use(world, user, hand);
    }
    */

    //Full Function

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(world.isClient) return super.use(world, user, hand);


    int itemGroup = 0;
    int result = 0;

        if (user.totalExperience>=5 || user.isCreative())
        {
            if (dedication <= 5) {
                itemGroup = new Random().nextInt(0, 3);
            } else if (dedication <= 10) {
                itemGroup = new Random().nextInt(1, 4);
            } else {
                itemGroup = new Random().nextInt(2, 5);
            }

            switch (itemGroup) {

                case 0:

                    result = new Random().nextInt(1, 3);

                    switch (result) {

                        case 1:

                            user.getInventory().clear();
                            user.kill();
                            break;

                        case 2:

                            user.kill();
                            break;

                        default:
                            break;
                    }

                    break;

                case 1:

                    result = new Random().nextInt(1, 4);

                    switch (result) {

                        case 1:

                            user.getInventory().dropAll();
                            break;

                        case 2:

                            user.kill();
                            break;

                        case 3:

                            user.setPos(user.getX() + 0, user.getY() + 200, user.getZ() + 0);
                            break;

                        default:
                            break;
                    }

                    break;

                case 2:

                    result = new Random().nextInt(1, 4);

                    switch (result) {

                        case 1:

                            break;

                        case 2:

                            break;

                        case 3:

                            user.heal(20);
                            break;

                        default:
                            break;
                    }

                    break;

                case 3:

                    result = new Random().nextInt(1, 3);

                    switch (result) {

                        case 1:

                            MugMod.LOGGER.info("Result = 1");
                            break;

                        case 2:

                            MugMod.LOGGER.info("Result = 2");
                            break;

                        case 3:

                            MugMod.LOGGER.info("Result = 3");
                            break;

                        default:
                            break;
                    }

                    break;

                case 4:

                    result = new Random().nextInt(1, 4);

                    switch (result) {

                        case 1:

                            break;

                        case 2:

                            break;

                        case 3:

                            break;

                        default:
                            break;
                    }

                    dedication = 0;
                    break;

                default:

                    break;

            }
            dedication = dedication + 1;

            MugMod.LOGGER.info("Item Group = " + itemGroup);
            MugMod.LOGGER.info("Action = " + result);
            MugMod.LOGGER.info("Dedication = " + dedication);

            user.getItemCooldownManager().set(this, 10);
            return super.use(world, user, hand);
        }

        else
        {
            MugMod.LOGGER.info("EXP is only " + user.totalExperience);
            user.getItemCooldownManager().set(this, 10);
            return super.use(world, user, hand);
        }
    }
}
