package me.phil.sieben.it.listeners;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class VodooListener extends Item {
	
	public VodooListener(Properties properties) {
		super(properties);
	}
	
	LocalPlayer player = Minecraft.getInstance().player;
	
	
	@Override
	public InteractionResult interactLivingEntity(ItemStack p_41398_, Player p_41399_, LivingEntity p_41400_,
			InteractionHand p_41401_) {
		// TODO Auto-generated method stub
		return super.interactLivingEntity(p_41398_, p_41399_, p_41400_, p_41401_);
	}
	
}
