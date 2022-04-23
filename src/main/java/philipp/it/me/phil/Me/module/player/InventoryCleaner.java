package philipp.it.me.phil.Me.module.player;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.input.Keyboard;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;

import java.awt.*;

public class InventoryCleaner extends Module {
    public InventoryCleaner() {
        super("InvCleaner" , "Clean's your Inventory", Category.PLAYER, false, "Test" , "Vanilla", "Test");
    }

    @Override
    public void onEnable() throws AWTException {
        EntityPlayer player = Minecraft.getMinecraft().player;
        PlayerControllerMP controller = Minecraft.getMinecraft().playerController;
        for (int i = 0; i < 50; i++) {
            controller.pickItem(i);
            Robot robot = new Robot();
            robot.keyRelease(Keyboard.KEY_Q);
        }
    }
}
