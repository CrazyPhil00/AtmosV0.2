package philipp.it.me.phil.Me.module.player;

import net.minecraft.network.play.client.CPacketKeepAlive;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerFlyableFallEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import philipp.it.me.phil.Me.events.Events;
import philipp.it.me.phil.Me.listener.EventUpdate;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;

import java.awt.*;

public class NoFall extends Module {
    public NoFall() {
        super("Nofall" , "You get no fall damage" , Category.PLAYER, false, "Test" , "Vanilla", "Test");
        this.setKey(Keyboard.KEY_B);
    }

    @Override
    public void onEnable() throws AWTException {
        super.onEnable();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @SubscribeEvent
    public void onEvent(TickEvent.PlayerTickEvent e) {
        if (this.isToggled()) {
            if (mc.player.fallDistance >= 4) {
                mc.getConnection().sendPacket(new CPacketKeepAlive());
            }else return;
        }
    }
}
