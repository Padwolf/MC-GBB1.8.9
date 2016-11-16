package com.padwolf.minecraft.gbb.entities;

import com.padwolf.minecraft.gbb.GBB;
import com.padwolf.minecraft.gbb.network.messages.EntityUpdateMessage;
import com.padwolf.minecraft.gbb.refs.Functions;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityTARDIS extends EntityLiving{
	
	private int dimension = 0;

	private EntityPlayer owner, rider;
	int ridingTicks = 0;
	
	public EntityTARDIS(World world){
		super(world);
		System.out.println(world);
		setSize((float) 1.5, (float) 3);
	}
	
	public EntityTARDIS(World world, EntityPlayer owner) {
		super(world);
		this.owner = owner;
		setSize((float) 1.5, (float) 3);
		
	}

	@Override
	public void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte)0));
		//this.dataWatcher.addObject(16, object);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		//dimension = nbt.getInteger("dimension");
		//owner = world.getPlayerEntityByName(nbt.getString("owner"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
		//nbt.setInteger("dimension", dimension);
		//nbt.setString("owner", owner.getDisplayName().getUnformattedText());
	}
	
	@Override
	protected boolean interact(EntityPlayer player) {
		if (!player.isSneaking()){
			if (riddenByEntity == null){
				player.mountEntity(this);
				player.setInvisible(true);
				//rider = player;
				//ridingEntity = rider;
				//rider.setInvisible(true);
				//rider.mountEntity(this);
			} else {
				if (this.worldObj.isRemote) Functions.sendChatMessage(player, "This TARDIS is already being driven.");
			}
		} else {
			if (this.worldObj.isRemote) Functions.sendChatMessage(player, "This TARDIS has no linked dimension.");
		}
		return super.interact(player);
	}
	
	@Override
	public void onUpdate() {
		super.onUpdate();
		if (riddenByEntity != null){
			if (riddenByEntity.isSneaking()) riddenByEntity.setInvisible(false);
			else {
				if (worldObj.isRemote){
				this.prevPosX = this.posX;
		        this.prevPosY = this.posY;
		        this.prevPosZ = this.posZ;
		        this.prevRotationPitch = this.rotationPitch;
		        this.prevRotationYaw = this.rotationYaw;
				
				if (riddenByEntity instanceof EntityLiving)
					this.rotationYaw = riddenByEntity.getRotationYawHead();
				this.moveEntity(motionX = MathHelper.clamp_double(this.motionX + riddenByEntity.motionX, -20, 20), 0, motionZ = MathHelper.clamp_double(this.motionZ + riddenByEntity.motionZ, -20, 20));
				//setPositionAndUpdate(posX+=motionX, posY+=motionY, posZ+=motionZ);
				
				System.out.println("            " +
						((worldObj.isRemote) ? "Client" : "Server") + " World | " +
						"X:" + this.getPosition().getX() + " | Y:" + this.getPosition().getY() + " | Z:" + this.getPosition().getZ());
					
				NBTTagCompound update = new NBTTagCompound();
				update.setDouble("x", posX);
				update.setDouble("y", posY);
				update.setDouble("z", posZ);
					
				GBB.CHANNEL.sendToServer(new EntityUpdateMessage(this.getEntityId(), update));
				}
			}
		}
		
		super.onUpdate();
	}
	
	@Override
	public boolean shouldDismountInWater(Entity rider) {
		return false;
	}
	
	@Override
	public double getMountedYOffset() {
		if (riddenByEntity != null) return -0.15;
		return super.getMountedYOffset();
	}
	
	@Override
	public boolean isEntityInvulnerable(DamageSource source) {
		if (source == DamageSource.outOfWorld) return false;
		return true;
	}
	
	@Override
	public boolean canRenderOnFire() {
		return false;
	}
	
	@Override
	public boolean canBePushed() {
		return false;
	}
	


	public void setSyncDataCompound(NBTTagCompound tag) {
		if (!worldObj.isRemote){
			setPositionAndUpdate(tag.getDouble("x"), tag.getDouble("y"), tag.getDouble("z"));
			
			System.out.println((worldObj.isRemote) ? "Client" : "Server" + " World | " +
					"X:" + this.getPosition().getX() + " | Y:" + this.getPosition().getY() + " | Z:" + this.getPosition().getZ());
		}
	}
	
	//Getters and Setters
	//Dimension
	public int getDimension() {
		return dimension;
	}

	public void setDimension(int dimension) {
		this.dimension = dimension;
	}
	
	//Rider
	public EntityPlayer getRider(){
		return rider;
	}
	
	public EntityPlayer getOwner(){
		return owner;
	}

}
