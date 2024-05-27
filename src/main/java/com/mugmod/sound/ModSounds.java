package com.mugmod.sound;

import com.mugmod.MugMod;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent WOWZERS_SOUND = registerSoundEvent("wowzers_sound");
    public static final SoundEvent FUCK_SOUND = registerSoundEvent("fuck_sound");

    public static final SoundEvent RICKROLL = registerSoundEvent("rickroll");


    public static final BlockSoundGroup WOWZERS_BLOCK_SOUNDS = new BlockSoundGroup(1f,1.5f,
            ModSounds.FUCK_SOUND, ModSounds.WOWZERS_SOUND, ModSounds.WOWZERS_SOUND,
            ModSounds.WOWZERS_SOUND, ModSounds.FUCK_SOUND);


    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(MugMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        MugMod.LOGGER.info("Registering Sounds for " + MugMod.MOD_ID);
    }
}
