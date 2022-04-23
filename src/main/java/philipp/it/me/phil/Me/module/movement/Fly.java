package philipp.it.me.phil.Me.module.movement;

import org.lwjgl.input.Keyboard;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;
import philipp.it.me.phil.Me.settings.ModeSetting;

import javax.swing.plaf.SpinnerUI;

public class Fly extends Module {

    public ModeSetting modes = new ModeSetting("Fly", "Vanilla", "Vanilla", "Hover", "Better Vanilla");

    public Fly() {
        super("Fly" , "You can fly" , Category.MOVEMENT, false, "Test" , "Vanilla", "Test");

        this.setKey(Keyboard.KEY_F);
    }

    public void onEnable() {

        mc.player.capabilities.allowFlying = true;
        mc.player.capabilities.isFlying = true;
    }

    public void onDisable() {

        mc.player.capabilities.allowFlying = false;
        mc.player.capabilities.isFlying = false;

    }

    int t = 0;

}
