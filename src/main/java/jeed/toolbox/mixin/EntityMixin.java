package jeed.toolbox.mixin;

import jeed.toolbox.ToolboxConfig;
import jeed.toolbox.ToolboxOptions;
import net.minecraft.core.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityMixin {

//	@Unique
//	public boolean doSneakFix = true;

	@Shadow
	public boolean onGround;

	@Shadow
	public abstract boolean isSneaking();

	@Shadow
	public double xd, zd;

	@Inject(method = "move", at = @At("HEAD"))
	private void saferSneak(double xd, double yd, double zd, CallbackInfo ci) {
		if (this.onGround && this.isSneaking() && ToolboxOptions.saferSneak.value) { // if you're actually on the ground and sneaking, and setting enabled
			if (Math.abs(this.xd) < 0.01) { // if your X axis movement is already very low just make it 0
				this.xd = 0;
			}
			if (Math.abs(this.zd) < 0.01) { // if your Y axis movement is already very low just make it 0
				this.zd = 0;
			}
		}
	}
}
