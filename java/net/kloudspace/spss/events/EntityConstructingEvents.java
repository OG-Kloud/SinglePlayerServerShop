package net.kloudspace.spss.events;

import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class EntityConstructingEvents {
	
	@SubscribeEvent
	public void onConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && PlayerBank.get((EntityPlayer) event.entity) == null) {
			PlayerBank.register((EntityPlayer) event.entity);
		}
	}

}
