package philipp.it.me.phil.Me.module.render;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;

import java.awt.*;

public class Tracer extends Module {
    public Tracer() {
        super("Tracers" , "Tracers" , Category.RENDER, false, "Test" , "Vanilla", "Test");
        this.setKey(Keyboard.KEY_8);
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
    public void onTick(TickEvent.ServerTickEvent event) {
        if (this.isToggled()) {

        }
    }

    public void drawPlayer(EntityLivingBase entity) {

        float red = 0.5f;
        float green = 0.5f;
        float blue = 1f;

        double xpos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosX;
        double ypos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosY;
        double zpos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosZ;

        render(red, green , blue , xpos , ypos, zpos);
    }

    public void drawAnimal(EntityLivingBase entity) {

        float red = 0.5f;
        float green = 1f;
        float blue = 0.5f;

        double xpos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosX;
        double ypos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosY;
        double zpos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosZ;

        render(red, green , blue , xpos , ypos, zpos);
    }

    public void drawMob(EntityLivingBase entity) {

        float red = 1f;
        float green = 0.5f;
        float blue = 0.5f;

        double xpos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosX;
        double ypos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosY;
        double zpos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosZ;

        render(red, green , blue , xpos , ypos, zpos);
    }

    public void drawOther(EntityLivingBase entity) {

        float red = 0.5f;
        float green = 0.5f;
        float blue = 0.5f;

        double xpos = (entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosX;
        double ypos = (entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosY;
        double zpos = (entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * mc.getRenderPartialTicks()) - mc.getRenderManager().viewerPosZ;

        render(red, green , blue , xpos , ypos, zpos);
    }

    public void render(float red, float green, float blue , double x, double y, double z) {

    }


    public static int rainbows(int delay) {
        double rainbowstate = Math.ceil(System.currentTimeMillis() + delay) /20.0;
        rainbowstate %= 360;
        return Color.getHSBColor((float) (rainbowstate /360.0f) , 0.5f , 1f).getRGB();
    }
}
