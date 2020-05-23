package io.github.binomaiheu.superzwaard.init;

import io.github.binomaiheu.superzwaard.SuperZwaard;
import java.util.function.Supplier;

import net.minecraft.item.*;


public class ModItemGroup extends ItemGroup {

	private final Supplier<ItemStack> iconSupplier;

	public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroup(SuperZwaard.MODID, () -> new ItemStack(Items.LIGHT_BLUE_BANNER));
	
	public ModItemGroup(final String name, final Supplier<ItemStack> iconSupplier) {
		super(name);
		this.iconSupplier = iconSupplier;
	}

	@Override
	public ItemStack createIcon() {
		return iconSupplier.get();
	}
	
}
