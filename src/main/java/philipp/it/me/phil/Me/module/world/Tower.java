package philipp.it.me.phil.Me.module.world;


import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;

public class Tower extends Module {
    public Tower() {
        super("Tower", "Build's up really fast", Category.WORLD, false, "Vanilla" , "Vanilla", "Test");
    }

    @Override
    public void onEnable() {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    int t = 0;

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = Minecraft.getMinecraft().player;
        if (t >= 5) {
            player.rotationPitch = 90;
            PlayerControllerMP controller = Minecraft.getMinecraft().playerController;

            for (int i = 0; i < 10; i++) {
                controller.pickItem(i);
                

            }
            

            t = 0;
        }
        t ++;
    }
}
