package com.brov3r.playerfeed.events;

import com.avrix.events.OnPlayerFullyConnectedEvent;
import com.avrix.utils.ChatUtils;
import com.avrix.utils.PlayerUtils;
import com.brov3r.playerfeed.LineFormatter;
import com.brov3r.playerfeed.Main;
import zombie.core.raknet.UdpConnection;

import java.nio.ByteBuffer;

/**
 * Event Handling
 */
public class OnPlayerConnectHandler extends OnPlayerFullyConnectedEvent {
    @Override
    public void handleEvent(ByteBuffer byteBuffer, UdpConnection udpConnection, String s) {
        if (udpConnection == null) return;

        String message = LineFormatter.formatLine(Main.getInstance().getDefaultConfig().getString("chatMessage.connectText"), PlayerUtils.getPlayerByUdpConnection(udpConnection));
        ChatUtils.sendMessageToAll(message);
    }
}