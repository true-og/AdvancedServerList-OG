/*
 * MIT License
 *
 * Copyright (c) 2022-2023 Andre_601
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package ch.andre601.advancedserverlist.core.profiles.players;

import ch.andre601.advancedserverlist.core.AdvancedServerList;
import ch.andre601.advancedserverlist.core.interfaces.PluginLogger;
import ch.andre601.advancedserverlist.core.objects.CachedPlayer;
import java.util.UUID;

public class PlayerHandler {

    private final AdvancedServerList<?> core;
    private final PluginLogger logger;

    // UUID of MHF_Question
    private final UUID defaultUUID = UUID.fromString("606e2ff0-ed77-4842-9d6c-e1d3321c7838");

    private CachedPlayer defaultPlayer = null;

    public PlayerHandler(AdvancedServerList<?> core) {
        this.core = core;
        this.logger = core.getPlugin().getPluginLogger();
    }

    public void load() {
        logger.info("Player cache is disabled in AdvancedServerList-OG. Skipping...");
    }

    public CachedPlayer getCachedPlayer(String key) {
        return getDefaultPlayer();
    }

    public CachedPlayer getCachedPlayer(UUID uuid) {
        return getDefaultPlayer();
    }

    public void clearCache() {
        defaultPlayer = null;
    }

    private CachedPlayer getDefaultPlayer() {
        if (defaultPlayer != null) return defaultPlayer;

        return (defaultPlayer = new CachedPlayer("0.0.0.0", "Anonymous", defaultUUID));
    }
}
