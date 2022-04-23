package me.phil.sieben.it.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LogoRenderer {
	
	public static final Minecraft mc = Minecraft.getInstance();

	private static final ResourceLocation logo = new ResourceLocation("atmos.textures.client" , "Glace.png");
	
	@SubscribeEvent
	@OnlyIn(Dist.CLIENT)
	public void onRender(RenderGameOverlayEvent event) {
		if (event.getType() == ElementType.TEXT) {
		
	        
	        
	       
	        
		}
	}
}
