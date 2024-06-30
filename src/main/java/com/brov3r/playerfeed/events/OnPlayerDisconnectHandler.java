package com.brov3r.playerfeed.events;

import com.avrix.events.OnPlayerDisconnectEvent;
import com.avrix.utils.ChatUtils;
import com.brov3r.playerfeed.LineFormatter;
import com.brov3r.playerfeed.Main;
import zombie.characters.IsoPlayer;
import zombie.core.raknet.UdpConnection;

/**
 * Event Handling
 */
public class OnPlayerDisconnectHandler extends OnPlayerDisconnectEvent {
    @Override
    public void handleEvent(IsoPlayer isoPlayer, UdpConnection udpConnection) {
        if (udpConnection == null) return;

        String message = LineFormatter.formatLine(Main.getInstance().getDefaultConfig().getString("chatMessage.disconnectText"), isoPlayer);
        ChatUtils.sendMessageToAll(message);
    }
}
