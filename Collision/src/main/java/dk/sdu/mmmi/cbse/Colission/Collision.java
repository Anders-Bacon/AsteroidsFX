package dk.sdu.mmmi.cbse.Colission;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;

public class Collision implements IPostEntityProcessingService {

    final private float COLLISION_DISTANCE = 2;
    private boolean scoreUpdate;
    private long scoreAddition = 0;

    @Override
    public void process(GameData gameData, World world) {

        if (scoreUpdate) {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://localhost:8080/attributes/score/update/1" + scoreAddition))
                    .GET()
                    .build();
            try {
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            } catch (IOException | InterruptedException e){}
        }

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


