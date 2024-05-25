package com.mugmod.painting;

import com.mugmod.MugMod;
import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.entity.decoration.painting.PaintingVariants;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModPaintings {

    public static final PaintingVariant TiniBlaze = registerPainting("tini_blaze", new PaintingVariant(32,32));
    public static final PaintingVariant Bigrat = registerPainting("bigrat", new PaintingVariant(64,48));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant){
        return Registry.register(Registries.PAINTING_VARIANT, new Identifier(MugMod.MOD_ID, name), paintingVariant);
    }


    public static void registerPaintings(){
        MugMod.LOGGER.debug("Registering Paintings for" + MugMod.MOD_ID);
    }
}
