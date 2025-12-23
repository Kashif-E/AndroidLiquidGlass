package com.kyant.backdrop.effects

import com.kyant.backdrop.BackdropEffectScope
import com.kyant.backdrop.platform.PlatformRenderEffect
import com.kyant.backdrop.platform.asSkiaImageFilter
import org.jetbrains.skia.ImageFilter

/**
 * Apply an ImageFilter effect directly to the backdrop.
 */
fun BackdropEffectScope.effect(effect: ImageFilter) {
    applyEffect(PlatformRenderEffect.Skia(effect))
}

/**
 * Apply a PlatformRenderEffect to the backdrop.
 */
fun BackdropEffectScope.effect(effect: PlatformRenderEffect) {
    applyEffect(effect)
}
