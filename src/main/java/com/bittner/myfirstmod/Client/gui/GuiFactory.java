package com.bittner.myfirstmod.Client.gui;

import cpw.mods.fml.client.IModGuiFactory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

import java.util.Set;

/**
 * Created by William on 5/23/2015.
 */
public class GuiFactory implements IModGuiFactory
{

    @Override
    public void initialize(Minecraft minecraftInstance)
    {

    }

    //At the moment, only worry about this one
    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass()
    {
        return com.bittner.myfirstmod.Client.gui.ModGuiConfig.class;
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories()
    {
        return null;
    }

    @Override
    public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element)
    {
        return null;
    }
}
