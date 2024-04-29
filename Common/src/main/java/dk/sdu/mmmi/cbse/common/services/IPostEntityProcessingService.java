package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService {

    /**
     * This is used after IEntityProcessingService and
     * controls what should happen to the entities post drawing
     * As an example playersystem collision or score.
     * Things that happen during or after the game.
     *
     * @param gameData
     * @param world
     */
    void process(GameData gameData, World world);
}
