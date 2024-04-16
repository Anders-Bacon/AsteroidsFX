package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;


public interface IEntityProcessingService {

    /**
     * This service is a contract for the entities.
     * It draws and spawns them into the scene,
     * and it keeps doing that for all the new entities that needs to be
     * created before or during game like the playersystem, bullets or asteroids.
     *
     * @param gameData
     * @param world
     *
     * @throws
     */
    void process(GameData gameData, World world);
}
