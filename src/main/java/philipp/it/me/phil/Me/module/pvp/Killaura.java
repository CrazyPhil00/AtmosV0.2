package philipp.it.me.phil.Me.module.pvp;

import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;
import javafx.print.PageLayout;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;
import philipp.it.me.phil.Me.module.Category;
import philipp.it.me.phil.Me.module.Module;
import philipp.it.me.phil.Me.settings.BooleanSetting;
import philipp.it.me.phil.Me.settings.ModeSetting;
import philipp.it.me.phil.Me.settings.NumberSetting;
import philipp.it.me.phil.Me.utils.RotationsUtil;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class Killaura extends Module {


    boolean animals,mobs,player;
    double range = this.getRange();

    public Killaura() {
        super("Killaura" , "Automatically attacks Entities in distance" , Category.COMBAT, false, "NCP" , "Vanilla", "NCP", "Custom", "AAC");
        this.setKey(Keyboard.KEY_K);
        this.setRangeSetting(true);
        this.setModeSetting(true);
        this.setDelaySetting(true);
    }

    private float yaw;

    private float pitch;

    int t = 0;
    // ATTACKSPEED:
    // Sword: 60
    // AXE: 75
    int attackspeed = 65;



    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (t >= this.getDelay()) {
            t = 0;
            if (this.isToggled()) {
                for (Entity o : Minecraft.getMinecraft().world.getLoadedEntityList()) {
                    if (o instanceof EntityLivingBase) {
                        EntityPlayer player = Minecraft.getMinecraft().player;
                        if (player.getDistance(o) <= range) {
                            if (!(o == player)) {

                                //player.rotationYaw = rotations(o) [0];
                                //player.rotationPitch = rotations(o) [1];
                                //player.getEntityBoundingBox().getCenter();

                                Minecraft.getMinecraft().playerController.attackEntity(player, o);
                                    //player.rotationYaw = (player.rotationYaw -o.rotationYaw);
                                player.swingArm(EnumHand.MAIN_HAND);
                                //final float[] rotation = executeRotations(o, mc.player);

                                //mc.player.rotationYaw = rotation[0];
                                //mc.player.rotationPitch = rotation[1];




                            }
                        }
                    }
                }
            }
        }
        t ++;
    }


    public float[] executeRotations(Entity entity, EntityPlayer player) {
        double d0 = player.posX - entity.posX;
        double d1 = player.posY - (entity.posY + (double)entity.getEyeHeight());
        double d2 = player.posZ - entity.posZ;
        double d3 = MathHelper.sqrt(d0 * d0 + d2 * d2);
        float f = (float) (MathHelper.atan2(d2, d0) * 180.00 / Math.PI) - 90.0F;
        float f1 = (float) (-(MathHelper.atan2(d1, d3) * 180.00 / Math.PI));

        return new float[] {f , f1};
    }

}