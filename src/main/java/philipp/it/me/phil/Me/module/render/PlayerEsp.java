package philipp.it.me.phil.Me.module.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;
import philipp.it.me.phil.Me.utils.RenderUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerEsp extends Module {
    public PlayerEsp() {
        super("PlayerESP", "You can see player", Category.RENDER, false, "Custom", "Custom");

    }

    private transient int BOX = 0;
    private transient List<Entity> ENTITIES = new ArrayList<Entity>();

    @Override
    public void onEnable() throws AWTException {
        super.onEnable();
        BOX = GL11.glGenLists(1);
        GL11.glNewList(BOX, GL11.GL_COMPILE);
        RenderUtils.drawOutlinedBox(new AxisAlignedBB(-0.5, 0, -0.5, 0.5, 1, 0.5));
        GL11.glEndList();
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        GL11.glDeleteLists(BOX, 1);
        MinecraftForge.EVENT_BUS.unregister(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent e) {
        ENTITIES.clear();
        for (EntityPlayer entity : Minecraft.getMinecraft().world.playerEntities) {
            if (entity.isDead || entity.getHealth() < 0)
                continue;
            if (entity == Minecraft.getMinecraft().player)
                continue;
            if (entity.isInvisible())
                continue;
            ENTITIES.add(entity);
        }
    }



    public void onRenderWorldLast(float partialTicks) {
        GL11.glPushAttrib(GL11.GL_ENABLE_BIT | GL11.GL_COLOR_BUFFER_BIT | GL11.GL_LINE_BIT | GL11.GL_CURRENT_BIT);

        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glLineWidth(2);

        GL11.glPushMatrix();
        GL11.glTranslated(-Minecraft.getMinecraft().getRenderManager().viewerPosX,
                -Minecraft.getMinecraft().getRenderManager().viewerPosY,
                -Minecraft.getMinecraft().getRenderManager().viewerPosZ);

        RenderUtils.drawESPBoxes(ENTITIES, BOX, partialTicks);
        //if (tracers.value)
            RenderUtils.drawESPTracers(ENTITIES);

        GL11.glPopMatrix();

        GL11.glPopAttrib();
    }
}
