package me.phil.sieben.it;

import me.phil.sieben.it.init.BlockInit;
import me.phil.sieben.it.init.ItemInit;
import me.phil.sieben.it.init.TrampolineInit;
import me.phil.sieben.it.init.VodooInit;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("atmos")
public class Main {
	
	public static final String MOD_ID = "atmos";
	
	public static final CreativeModeTab TUTORIAL_TAB = new CreativeModeTab(MOD_ID) {
		
		@Override
		@OnlyIn(Dist.CLIENT)
		public ItemStack makeIcon() {
			// TODO Auto-generated method stub
			return new ItemStack(ItemInit.EXAMPLE_ITEM.get());
		}
	};
	
	
    
	public Main(){
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		ItemInit.ITEMS.register(bus);
		VodooInit.ITEMS.register(bus);
		
		BlockInit.BLOCKS.register(bus);
		TrampolineInit.BLOCKS.register(bus);
		
		MinecraftForge.EVENT_BUS.register(this);

	}
}
