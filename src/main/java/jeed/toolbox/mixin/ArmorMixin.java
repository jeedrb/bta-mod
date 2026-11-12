package jeed.toolbox.mixin;


import jeed.toolbox.ToolboxOptions;
import net.minecraft.client.render.entity.MobRendererBipedArmored;
import net.minecraft.core.entity.IArmorWearing;
import net.minecraft.core.entity.Mob;
import net.minecraft.core.entity.player.Player;
import net.minecraft.core.enums.HumanArmorShape;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.useless.dragonfly.models.entity.StaticEntityModel;

@Mixin(MobRendererBipedArmored.class)
public abstract class ArmorMixin<T extends Mob & IArmorWearing<HumanArmorShape>> {

	@Inject(method = "getAndSetupModelForLayer", at = @At("HEAD"), cancellable = true)
	private void hideArmor(@NotNull T entity, float brightness, float partialTick, int layer, CallbackInfoReturnable<StaticEntityModel> cir) {
		if (entity instanceof Player && ToolboxOptions.hideArmor.value) { // if it's a player and setting enabled
			cir.setReturnValue(null); // just immediately quit the method lol
		}
	}

}
