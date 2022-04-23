package me.phil.sieben.it.init;

import com.google.common.base.Supplier;

import me.phil.sieben.it.Main;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class VodooInit {

public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Main.MOD_ID);
	
	public static final RegistryObject<Item> VODOO_GLACE = register("vodoo_glace", () -> new Item(new Item
			.Properties()
			.tab(Main.TUTORIAL_TAB)
			.stacksTo(1)
			.setNoRepair()
			.defaultDurability(50)
			.durability(49)
			.fireResistant()
			.rarity(Rarity.EPIC)));
	
	
	private static <T extends Item> RegistryObject<T> register(final String name, final Supplier<T> item) {
		return ITEMS.register(name, item);
	}

}
