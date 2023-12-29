// MyBundle.java
package com.github.kakaroto33.ucsimgui;

import com.intellij.DynamicBundle;
import java.util.Arrays;
import java.util.function.Supplier;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.PropertyKey;

//@Metadata(
//        mv = {1, 9, 0},
//        k = 1,
//        d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\f0\u0004¢\u0006\u0002\b\u0005¢\u0006\u0002\b\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0007¢\u0006\u0002\u0010\u000bJH\u0010\f\u001a\u001f\u0012\u0016\u0012\u0014 \u000e*\t\u0018\u00010\u0004¢\u0006\u0002\b\u00060\u0004¢\u0006\u0002\b\u00060\r¢\u0006\u0002\b\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\"\u00020\nH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"},
//        d2 = {"Lcom/github/kakaroto33/ucsimgui/MyBundle;", "Lcom/intellij/DynamicBundle;", "()V", "message", "", "Lorg/jetbrains/annotations/NotNull;", "Lorg/jetbrains/annotations/Nls;", "key", "params", "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "messagePointer", "Ljava/util/function/Supplier;", "kotlin.jvm.PlatformType", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/util/function/Supplier;", "ucsimgui"}
//)
public final class UgBundle extends DynamicBundle {
    @NotNull
    public static final UgBundle INSTANCE;

    @NotNull
    public static String message(@PropertyKey(resourceBundle = "messages.UgBundle") @NotNull String key, @NotNull Object... params) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(params, "params");
        String var10000 = INSTANCE.getMessage(key, Arrays.copyOf(params, params.length));
        Intrinsics.checkNotNullExpressionValue(var10000, "getMessage(key, *params)");
        return var10000;
    }

    @NotNull
    public static Supplier messagePointer(@PropertyKey(resourceBundle = "messages.UgBundle") @NotNull String key, @NotNull Object... params) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(params, "params");
        Supplier var10000 = INSTANCE.getLazyMessage(key, Arrays.copyOf(params, params.length));
        Intrinsics.checkNotNullExpressionValue(var10000, "getLazyMessage(key, *params)");
        return var10000;
    }

    private UgBundle() {
        super("messages.UgBundle");
    }

    static {
        UgBundle var0 = new UgBundle();
        INSTANCE = var0;
    }
}
