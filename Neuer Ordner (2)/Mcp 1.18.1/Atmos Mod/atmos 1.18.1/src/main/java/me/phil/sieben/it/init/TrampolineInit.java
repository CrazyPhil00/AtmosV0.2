package me.phil.sieben.it.init;

import java.util.function.Function;
import com.google.common.base.Supplier;

import me.phil.sieben.it.Main;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TrampolineInit {
	
	
	

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Main.MOD_ID);
	
	public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;
	
	public static final RegistryObject<Block> TRAMPOLINE_BLOCK = register("trampoline",
			() -> new Block(BlockBehaviour.Properties.of(Material.PISTON , MaterialColor.COLOR_PURPLE)
					.strength(1.5f)
					.sound(SoundType.METAL)
					.jumpFactor(1.5f)),
			object -> () -> new BlockItem(object.get() ,new Item.Properties()
					.tab(Main.TUTORIAL_TAB)));
	
	private static <T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
		return BLOCKS.register(name, block);
	}
	
	private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
			Function<RegistryObject<T>, Supplier <? extends Item>> item) {
		RegistryObject<T> obj = registerBlock(name, block);
		ITEMS.register(name , item.apply(obj));
		return obj;
	}
}