package jeed.playground.mixin;

import net.minecraft.core.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

	@Shadow
	public boolean onGround;

	@Shadow
	public abstract boolean isSneaking();

	@Shadow
	public double xd, zd;

	@Shadow
	public boolean slide;

	@Shadow
	public boolean isWalking;

	@Inject(method = "move", at = @At("HEAD"))
	private void saferShrinkStep(double xd, double yd, double zd, CallbackInfo ci) {
		if (this.onGround && this.isSneaking()) {
			if (Math.abs(this.xd) < 0.01) {
				this.xd = 0;
			}
			if (Math.abs(this.zd) < 0.01) {
				this.zd = 0;
			}
		}
	}
}
