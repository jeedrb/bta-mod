package jeed.toolbox.mixin;

import jeed.toolbox.ToolboxOptions;
import net.minecraft.core.entity.animal.MobDeer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MobDeer.class)
public class DeerMixin {

	// deer living/ambient/whatever sound(s)
	@Inject(method = "getLivingSound", at = @At("HEAD"), cancellable = true)
	private void deerLivingSound(CallbackInfoReturnable<String> cir) {
		if (ToolboxOptions.deerSounds.value) {
			cir.setReturnValue("mob.deer");
		}
	}

	// deer hurt sound(s)
	@Inject(method = "getHurtSound", at = @At("HEAD"), cancellable = true)
	private void deerHurtSound(CallbackInfoReturnable<String> cir) {
		if (ToolboxOptions.deerSounds.value) {
			cir.setReturnValue("mob.deerhurt");
		}
	}

	// deer death sound(s)
	@Inject(method = "getDeathSound", at = @At("HEAD"), cancellable = true)
	private void deerDeathSound(CallbackInfoReturnable<String> cir) {
		if (ToolboxOptions.deerSounds.value) {
			cir.setReturnValue("mob.deerdeath");
		}
	}
}
