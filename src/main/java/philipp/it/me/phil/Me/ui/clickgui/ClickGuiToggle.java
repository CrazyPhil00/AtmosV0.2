package philipp.it.me.phil.Me.ui.clickgui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;
import philipp.it.me.phil.Me.Mod;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;

import java.io.IOException;

public class ClickGuiToggle extends Module {


    public ClickGuiToggle() {
        super("ClickGui", "Gui", Category.CLIENT, false, "Test" , "Vanilla", "Test");
        this.setKey(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
        Minecraft.getMinecraft().displayGuiScreen(new ClickGui());

    }
}
