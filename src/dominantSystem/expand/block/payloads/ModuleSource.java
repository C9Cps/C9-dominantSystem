package dominantSystem.expand.block.payloads;

import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.PayloadSource;

import static mindustry.Vars.state;


public class ModuleSource extends PayloadSource {

    public ModuleSource(String name) {
        super(name);
        size = 3;

    }
    public boolean canProduce(Block b){
        return b.isVisible() && b.size < size && (b instanceof ModulePayload)  && !state.rules.isBanned(b) && b.environmentBuildable();
    }

    @Override
    public boolean canProduce(UnitType t){
        return false;
    }
}
