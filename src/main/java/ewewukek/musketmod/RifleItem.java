package ewewukek.musketmod;

import net.minecraftforge.registries.*;
import net.minecraft.world.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.block.*;
import net.minecraft.util.math.*;

public class MusketItem extends Item
{
    public static final int DURABILITY = 250;
    public static final int LOADING_STAGE_1 = 5;
    public static final int LOADING_STAGE_2 = 10;
    public static final int LOADING_STAGE_3 = 20;
    public static final int RELOAD_DURATION = 30;
    public static float bulletStdDev;
    public static double bulletSpeed;
    @ObjectHolder("musketmod:cartridge")
    public static Item CARTRIDGE;
    @ObjectHolder("musketmod:musket_load0")
    public static SoundEvent SOUND_MUSKET_LOAD_0;
    @ObjectHolder("musketmod:musket_load1")
    public static SoundEvent SOUND_MUSKET_LOAD_1;
    @ObjectHolder("musketmod:musket_load2")
    public static SoundEvent SOUND_MUSKET_LOAD_2;
    @ObjectHolder("musketmod:musket_ready")
    public static SoundEvent SOUND_MUSKET_READY;
    @ObjectHolder("musketmod:musket_fire")
    public static SoundEvent SOUND_MUSKET_FIRE;
    
    public MusketItem(final Item.Properties properties);
    
    public ActionResult<ItemStack> func_77659_a(final World worldIn, final PlayerEntity player, final Hand hand);
    
    public void func_77615_a(final ItemStack stack, final World worldIn, final LivingEntity entityLiving, final int timeLeft);
    
    public void func_219972_a(final World world, final LivingEntity entity, final ItemStack stack, final int timeLeft);
    
    public void onUsingTick(final ItemStack stack, final LivingEntity entityLiving, final int timeLeft);
    
    public boolean func_179218_a(final ItemStack stack, final World worldIn, final BlockState state, final BlockPos pos, final LivingEntity entityLiving);
    
    public static void damageItem(final ItemStack stack, final PlayerEntity player);
    
    public int func_77626_a(final ItemStack stack);
    
    public static boolean isLoaded(final ItemStack stack);
    
    public static boolean isReady(final ItemStack stack);
    
    private boolean isAmmo(final ItemStack stack);
    
    private ItemStack findAmmo(final PlayerEntity player);
    
    private Vec3d getPlayerFiringPoint(final PlayerEntity player);
    
    private void fireBullet(final World worldIn, final PlayerEntity player);
    
    private void setLoaded(final ItemStack stack, final boolean loaded);
    
    private void setReady(final ItemStack stack, final boolean ready);
    
    private void setLoadingStage(final ItemStack stack, final int loadingStage);
    
    private int getLoadingStage(final ItemStack stack);
}