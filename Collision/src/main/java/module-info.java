import dk.sdu.mmmi.cbse.Colission.Collision;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;


module Colission {
    requires Common;
    provides IPostEntityProcessingService with Collision;
}