package dk.sdu.mmmi.cbse.Colission;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

public class Collision implements IPostEntityProcessingService {

    final private float COLLISION_DISTANCE = 2;

    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {

                // if the two entities are identical, skip the iteration
                if (entity1.getID().equals(entity2.getID())) {
                    continue;
                }

                // CollisionDetection
                if (this.collision(entity1, entity2)) {
                    world.removeEntity(entity1);
                    world.removeEntity(entity2);
                }
            }
        }

    }

    public boolean collision (Entity entity1, Entity entity2){
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();

        /*
        Are here to check positions if it should break
        float e1X = (float) entity1.getX();
        float e1Y = (float) entity1.getY();
        float e2X = (float) entity1.getX();
        float e2Y = (float) entity1.getY();
        */

        float distanceBetweenEntities = (float) Math.sqrt(dx * dx + dy * dy);
        return distanceBetweenEntities < COLLISION_DISTANCE;
    }

}


