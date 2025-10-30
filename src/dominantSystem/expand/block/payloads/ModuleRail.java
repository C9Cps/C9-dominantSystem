package dominantSystem.expand.block.payloads;

import arc.math.geom.Geometry;
import dominantSystem.expand.block.inner.LinkBlock;
import dominantSystem.expand.block.production.factory.AdaptCrafter;
import mindustry.gen.Building;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.blocks.payloads.PayloadConveyor;
import mindustry.world.meta.Stat;


public class ModuleRail extends PayloadConveyor {
    public ModuleRail(String name) {
        super(name);
        size = 1;
        moveTime = 60;
    }
    @Override
    public void setStats(){
        super.setStats();
        stats.remove(Stat.payloadCapacity);

        stats.add(Stat.speed, moveTime);
    }

    public class ModuleRailBuild extends PayloadConveyorBuild {
        @Override
        public boolean acceptPayload(Building source, Payload payload) {
            if (front() == source) return false;
            return super.acceptPayload(source, payload) && payload.content() instanceof ModulePayload;
        }
        @Override
        protected boolean blends(int direction){
            if(direction == rotation){
                return !blocked || next != null;
            }

            Building accept = nearby(Geometry.d4(direction).x, Geometry.d4(direction).y);
            if (accept instanceof AdaptCrafter.AdaptCrafterBuild) return true;
            if (accept instanceof LinkBlock.LinkBuild) return true;
            return mindustry.world.blocks.payloads.PayloadBlock.blends(this, direction);
        }
    }
}
