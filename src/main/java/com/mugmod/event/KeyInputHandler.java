package com.mugmod.event;

import com.mugmod.MugMod;
import com.mugmod.sound.ModSounds;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_MUGMOD = "key.category.mugmod.mugmod";

    public static final String TEST_KEY = "key.mugmod.test_key";

    public static final String KEY_KAZOO_NOTE_1 = "key.mugmod.kazoo_note_1";
    public static final String KEY_KAZOO_NOTE_2 = "key.mugmod.kazoo_note_2";
    public static final String KEY_KAZOO_NOTE_3 = "key.mugmod.kazoo_note_3";
    public static final String KEY_KAZOO_NOTE_4 = "key.mugmod.kazoo_note_4";
    public static final String KEY_KAZOO_NOTE_5 = "key.mugmod.kazoo_note_5";
    public static final String KEY_KAZOO_NOTE_6 = "key.mugmod.kazoo_note_6";
    public static final String KEY_KAZOO_NOTE_7 = "key.mugmod.kazoo_note_7";
    public static final String KEY_KAZOO_NOTE_8 = "key.mugmod.kazoo_note_8";

    public static KeyBinding testkey;

    public static KeyBinding kazooKey1;
    public static KeyBinding kazooKey2;
    public static KeyBinding kazooKey3;
    public static KeyBinding kazooKey4;
    public static KeyBinding kazooKey5;
    public static KeyBinding kazooKey6;
    public static KeyBinding kazooKey7;
    public static KeyBinding kazooKey8;


    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {

            if(testkey.wasPressed()){

                MugMod.LOGGER.info("test");
//                client.player.sendMessage(Text.of("Hi!")));

            }

            if(kazooKey1.wasPressed()){

                MugMod.LOGGER.info("Used Kazoo 1");

//               PlayerEntity.getWorld().playSound(null, PlayerEntity.getBlockPos, ModSounds.WOWZERS_SOUND, SoundCategory.BLOCKS, 1f, 1f);

            }
            if(kazooKey2.wasPressed()){
                MugMod.LOGGER.info("Used Kazoo 2");
            }
            if(kazooKey3.wasPressed()){
                MugMod.LOGGER.info("Used Kazoo 3");
            }
            if(kazooKey4.wasPressed()){
                MugMod.LOGGER.info("Used Kazoo 4");
            }
            if(kazooKey5.wasPressed()){
                MugMod.LOGGER.info("Used Kazoo 5");
            }
            if(kazooKey6.wasPressed()){
                MugMod.LOGGER.info("Used Kazoo 6");
            }
            if(kazooKey7.wasPressed()){
                MugMod.LOGGER.info("Used Kazoo 7");
            }
            if(kazooKey8.wasPressed()){
                MugMod.LOGGER.info("Used Kazoo 8");
            }
        });
    }

    public static void register(){
        testkey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                TEST_KEY, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_9, KEY_CATEGORY_MUGMOD
        ));

        kazooKey1 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_KAZOO_NOTE_1, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_1, KEY_CATEGORY_MUGMOD
        ));
        kazooKey2 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_KAZOO_NOTE_2, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_2, KEY_CATEGORY_MUGMOD
        ));
        kazooKey3 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_KAZOO_NOTE_3, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_3, KEY_CATEGORY_MUGMOD
        ));
        kazooKey4 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_KAZOO_NOTE_4, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_4, KEY_CATEGORY_MUGMOD
        ));
        kazooKey5 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_KAZOO_NOTE_5, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_5, KEY_CATEGORY_MUGMOD
        ));
        kazooKey6 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_KAZOO_NOTE_6, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_6, KEY_CATEGORY_MUGMOD
        ));
        kazooKey7 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_KAZOO_NOTE_7, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_7, KEY_CATEGORY_MUGMOD
        ));
        kazooKey8 = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_KAZOO_NOTE_8, InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_KP_8, KEY_CATEGORY_MUGMOD
        ));


        registerKeyInputs();
    }

}
