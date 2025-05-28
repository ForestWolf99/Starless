package me.forestwolf99.starbegone.mixin;

import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.mob.HostileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(HostileEntity.class)
public class StarRemover {
    @Inject(method = {"shouldDropLoot"}, at = {@At("HEAD")}, cancellable = true)
    public void removeStar(CallbackInfoReturnable<Boolean> cir) {
        if ((HostileEntity) (Object) this instanceof WitherEntity) {
            cir.setReturnValue(false);
        }
    }
}
