package com.kukelekuuk.yawlock.mixin;

import com.kukelekuuk.yawlock.YawLock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin( MinecraftClient.class )
public class YawLockMixin
{
    @Inject( method = "tick", at = @At( value = "HEAD" ) )
    private void tick( CallbackInfo info )
    {
        if ( YawLock.isEnabled )
        {
            MinecraftClient client = MinecraftClient.getInstance();
            World world = client.world;
            ClientPlayerEntity player = client.player;
            if ( world != null && player != null )
            {
                float yaw = Math.abs( Math.round( player.yaw ) % 360 );
                int division = ( int ) Math.floor( yaw / 90 );
                int remainder = ( int ) ( yaw % 90 );
                if ( remainder < 45 )
                {
                    yaw = 90 * division;
                }
                else
                {
                    yaw = 90 * ( division + 1 );
                }
                player.setYaw( yaw );
                player.yaw = yaw;
            }
        }
    }
}
