package philipp.it.me.phil.Me.module.render;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;
import philipp.it.me.phil.Me.utils.RenderUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayerEsp extends Module {
    public PlayerEsp() {
        super("PlayerESP", "You can see player", Category.RENDER, false, "Custom", "Custom");

    }

    private transient List<Entity> ENTITIES = new ArrayList<Entity>();
    private transient int BOX = 0;


    @Override
    public void onEnable() {
        BOX = GL11.glGenLists(1);
        GL11.glNewList(BOX, GL11.GL_COMPILE);
        RenderUtil.drawOutlinedBox(new AxisAlignedBB(-0.5, 0, -0.5, 0.5, 1, 0.5));
        GL11.glEndList();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        GL11.glDeleteLists(BOX, 1);
    }

    @Override
    public void onLocalPlayerUpdate() {
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

    @Override
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

        RenderUtil.drawESPBoxes(ENTITIES, BOX, partialTicks);


        GL11.glPopMatrix();

        GL11.glPopAttrib();
    }
}
