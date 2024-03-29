package com.kukelekuuk.yawlock;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class YawLock implements ModInitializer {
	private static final String MOD_ID = "yawlock";
	private static final String KEY_BINDING_CATEGORY = "key.categories." + MOD_ID;
	public static FabricKeyBinding keyBinding;
	public static boolean isEnabled = false;

	@Override
	public void onInitialize()
	{
		keyBinding = FabricKeyBinding.Builder.create(
				new Identifier( MOD_ID, "enabledisable" ),
				InputUtil.Type.KEYSYM,
				GLFW.GLFW_KEY_LEFT_BRACKET,
				KEY_BINDING_CATEGORY ).build();
		KeyBindingRegistry.INSTANCE.addCategory( KEY_BINDING_CATEGORY );
		KeyBindingRegistry.INSTANCE.register( keyBinding );
	}
}
