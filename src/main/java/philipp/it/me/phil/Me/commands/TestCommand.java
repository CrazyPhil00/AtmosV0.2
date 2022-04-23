package philipp.it.me.phil.Me.commands;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentString;

public class TestCommand extends CommandBase {
    @Override
    public String getName() {
        return "test";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/test";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        double firstattackspeed = getAttackSpeed(Minecraft.getMinecraft().player.getHeldItem(EnumHand.MAIN_HAND).getItem());
        double attackspeedinTicks = (firstattackspeed * 100) / 2 /2 ;
        String realattackspeed = String.valueOf(attackspeedinTicks).replace("-", "");
        double attackspeed = Double.parseDouble(realattackspeed);
        sender.sendMessage(new TextComponentString(realattackspeed));
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }


    public double getAttackSpeed(Item item) {
        double x = 0;
        double y = 0;
        if (item.getAttributeModifiers(EntityEquipmentSlot.MAINHAND, new ItemStack(item)).containsKey("generic.attackSpeed")) {
            for (AttributeModifier mod : item.getAttributeModifiers(EntityEquipmentSlot.MAINHAND, new ItemStack(item)).get("generic.attackSpeed")) {
                if (mod.getOperation() == 0) {
                    x += mod.getAmount();
                }
            }

            y = x;

            for (AttributeModifier mod : item.getAttributeModifiers(EntityEquipmentSlot.MAINHAND, new ItemStack(item)).get("generic.attackSpeed")) {
                if (mod.getOperation() == 1) {
                    y += x * mod.getAmount();
                }
            }

            for (AttributeModifier mod : item.getAttributeModifiers(EntityEquipmentSlot.MAINHAND, new ItemStack(item)).get("generic.attackSpeed")) {
                if (mod.getOperation() == 2) {
                    y += y * mod.getAmount();
                }
            }
        }

        return y;
    }
}
