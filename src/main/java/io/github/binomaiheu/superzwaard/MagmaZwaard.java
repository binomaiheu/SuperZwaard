package io.github.binomaiheu.superzwaard;

import io.github.binomaiheu.superzwaard.init.ModItemGroup;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;

import net.minecraft.item.SwordItem;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MagmaZwaard extends SwordItem {

	public static final Logger LOGGER = LogManager.getLogger(MagmaZwaard.class);
	public int fireballStrength = 3;
	
	public MagmaZwaard () {
	        super(ItemTier.IRON, 6, -3.1F, new Item.Properties().group(ModItemGroup.MOD_ITEM_GROUP));
	}
	
	public MagmaZwaard (IItemTier tier, int attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(tier, attackDamageIn, attackSpeedIn, builder);
	}

	public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand handIn) {

		FireballEntity fireballentity = new FireballEntity(world, player,player.getLookVec().x,player.getLookVec().y,player.getLookVec().z);

		fireballentity.explosionPower = fireballStrength;
	    fireballentity.rotationPitch  = player.rotationPitch;
	    fireballentity.rotationYaw    = player.rotationYaw;	    
	    fireballentity.setPosition(player.getPosX(), player.getPosY()+2, player.getPosZ());
	    
	    // overwrite the random vector, probably set by the constructor, here we explicitly point it in the right direction... 
		fireballentity.accelerationX = player.getLookVec().x;
		fireballentity.accelerationY = player.getLookVec().y;
		fireballentity.accelerationZ = player.getLookVec().z;

	    world.addEntity(fireballentity);

	    LOGGER.info("********** Magic Axe swing **************");
	    return super.onItemRightClick(world, player, handIn);
	}
	
}
