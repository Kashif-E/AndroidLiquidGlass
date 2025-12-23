package com.kyant.backdrop.effects

import android.graphics.RenderEffect
import com.kyant.backdrop.BackdropEffectScope
import com.kyant.backdrop.platform.PlatformCapabilities
import com.kyant.backdrop.platform.PlatformRenderEffect

fun BackdropEffectScope.effect(effect: RenderEffect) {
    if (!PlatformCapabilities.supportsRenderEffect) return
    applyPlatformEffect(PlatformRenderEffect.Android(effect))
}

// TODO: When Compose Multiplatform exposes a platform-agnostic RenderEffect bridge,
// add an overload that accepts androidx.compose.ui.graphics.RenderEffect again.
