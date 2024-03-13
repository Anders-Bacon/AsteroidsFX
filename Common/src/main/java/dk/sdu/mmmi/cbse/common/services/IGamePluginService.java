package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    /**
     * This service is a contract for when the world starts and stops
     * When the game should start it creates the game window
     * When the scene is created it signals to other contracts that they now can begin their service
     * The IEntityProcessingService cant draw and add entities to the scene
     *
     *
     * @param gameData
     * @param world
     */
    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
