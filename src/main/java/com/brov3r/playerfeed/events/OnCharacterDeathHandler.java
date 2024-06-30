package com.brov3r.playerfeed.events;

import com.avrix.events.OnCharacterDeathEvent;
import com.avrix.utils.ChatUtils;
import com.brov3r.playerfeed.LineFormatter;
import com.brov3r.playerfeed.Main;
import zombie.characters.IsoGameCharacter;
import zombie.characters.IsoPlayer;

/**
 * Event Handling
 */
public class OnCharacterDeathHandler extends OnCharacterDeathEvent {
    @Override
    public void handleEvent(IsoGameCharacter character) {
        if (character == null) return;

        if (character instanceof IsoPlayer player) {
            IsoGameCharacter attacker = player.getAttackedBy();

            String message;
            if (attacker instanceof IsoPlayer enemyPlayer) {
                message = LineFormatter.formatLine(
                        Main.getInstance().getDefaultConfig().getString("chatMessage.killText"),
                        player
                ).replace("<PLAYER_ENEMY>", enemyPlayer.username);
            } else {
                message = LineFormatter.formatLine(
                        Main.getInstance().getDefaultConfig().getString("chatMessage.deathText"),
                        player
                );
            }

            ChatUtils.sendMessageToAll(message);
        }
    }
}