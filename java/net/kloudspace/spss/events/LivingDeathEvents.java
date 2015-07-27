package net.kloudspace.spss.events;

import net.kloudspace.spss.Common;
import net.kloudspace.spss.properties.PlayerBank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class LivingDeathEvents {
	Common proxy = new Common();
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = new NBTTagCompound();
			((PlayerBank)(event.entity.getExtendedProperties(PlayerBank.PLAYER_BANK))).saveNBTData(playerData);
			proxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName(), playerData);
			PlayerBank.saveProxyData((EntityPlayer) event.entity);
		}
	}
	@SubscribeEvent
	public void onRespawn(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer)event.entity;
			NBTTagCompound data = proxy.getEntityData(((EntityPlayer)event.entity).getDisplayName());
			if(data != null) {
				int current = data.getInteger("currentBank");
				PlayerBank.get(player).set(player, current);
			}
		}
	}

}
