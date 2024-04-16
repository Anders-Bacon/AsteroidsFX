package dk.sdu.mmmi.cbse.Colission;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dk.sdu.mmmi.cbse.common.data.Entity;

import static org.junit.jupiter.api.Assertions.*;

class CollisionTest {

    

    @Test
    void testCollision() {
        Collision collision = new Collision();
        Entity entity1 = new Entity();
        Entity entity2 = new Entity();

        //They should collide when they are this close
        entity1.setX(1);
        entity1.setY(1);
        entity2.setX(2);
        entity2.setY(2);

        assertTrue(collision.collision(entity1, entity2));

        //They should not collide when they are this far apart
        entity1.setX(5);
        entity1.setY(5);
        entity2.setX(20);
        entity2.setY(20);

        assertFalse(collision.collision(entity1, entity2));


    }
}