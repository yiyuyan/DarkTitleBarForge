package cn.ksmcbrigade.dtbf.mixin;

import cn.ksmcbrigade.dtbf.DarkTitleBarForge;
import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.Minecraft;
import net.minecraft.client.main.GameConfig;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public abstract class MinecraftMixin {

    @Shadow public abstract Window getWindow();

    @Inject(method = "<init>",at = @At("TAIL"))
    public void init(GameConfig p_91084_, CallbackInfo ci){
        DarkTitleBarForge.setDarkTitlebar(this.getWindow());
    }
}
