package com.nekokittygames.thaumictinkerer.client.misc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.IResource;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.util.Objects;

/**
 * Helper class to load enchanter icons
 * Created by nekosune on 26/07/18.
 */
@SideOnly(Side.CLIENT)
public class EnchantmentGui {

    /**
     * Gets the appropriate ResourceLocation for an enchantment, or the default unknown location if none
     *
     * @param enchantment enchantment to get icon for
     * @return ResourceLocation containign the appropriate icon
     */
    public static ResourceLocation getEnchantmentIcon(Enchantment enchantment) {

        ResourceLocation object = Enchantment.REGISTRY.getNameForObject(enchantment);
        ResourceLocation iconLoc = new ResourceLocation(Objects.requireNonNull(object).getResourceDomain(), "textures/enchant_icons/" + object.getResourcePath() + ".png");

        try {
            IResource res = Minecraft.getMinecraft().getResourceManager().getResource(iconLoc);
            if (res == null)
                iconLoc = new ResourceLocation("thaumictinkerer", "textures/enchant_icons/unknown.png");
        } catch (IOException e) {
            iconLoc = new ResourceLocation("thaumictinkerer", "textures/enchant_icons/unknown.png");
        }

        return iconLoc;
    }
}
