package jeed.playground.mixin;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.util.helper.MathHelper;
import org.jetbrains.annotations.NotNull;
import org.joml.primitives.AABBd;
import org.joml.primitives.AABBdc;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Player.class)
public abstract class PlayerMixin {

//	@ModifyConstant(method = "getMaxHealth", constant = @Constant(intValue = 20))
//	private int changeHealth(int original) {
////		System.out.println("hi");
//		return 20;
//	}

//	@Inject(method = "getBoundsForState", at = @At("RETURN"))
//	private void saferSneak(int state, CallbackInfoReturnable<AABBd> cir) {
//		if (state == 1) {
//			System.out.println("hi");
//		}
//	}
}
