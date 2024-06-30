package com.brov3r.playerfeed;

import com.avrix.utils.ChatUtils;
import zombie.characters.IsoPlayer;
import zombie.network.GameServer;
import zombie.network.ServerOptions;

/**
 * String Formatting Tools
 */
public class LineFormatter {
    /**
     * Formatting a string
     *
     * @param line line
     * @param player player object
     * @return corrected string
     */
    public static String formatLine(String line, IsoPlayer player) {
        return line.replaceAll("<PLAYER>", player.getDisplayName())
                .replaceAll("<SPACE>", ChatUtils.SPACE_SYMBOL)
                .replaceAll("<MAX_PLAYER>", String.valueOf(ServerOptions.getInstance().getMaxPlayers()))
                .replaceAll("<CURRENT_PLAYERS>", String.valueOf(GameServer.getPlayers().size()));
    }
}
