import dk.sdu.mmmi.cbse.Colission.Collision;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;


module Colission {
    requires Common;
    requires java.net.http;
    provides IPostEntityProcessingService with Collision;
}