package dominantSystem.content.blocks;

import dominantSystem.expand.block.payloads.ModuleRail;
import dominantSystem.expand.block.payloads.ModuleSource;
import mindustry.gen.Building;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.UnitType;
import mindustry.world.Block;
import mindustry.world.blocks.payloads.Payload;
import mindustry.world.blocks.payloads.PayloadRouter;
import mindustry.world.meta.BuildVisibility;
import dominantSystem.content.dsItems;
import dominantSystem.expand.block.payloads.ModulePayload;

import static mindustry.type.ItemStack.with;

public class PayloadBlock {
    public static Block payloadRail, payloadRouter, moduleSource;

    public static void load() {
        payloadRail = new ModuleRail("module-rail") {{
            requirements(Category.units, BuildVisibility.shown, ItemStack.with(dsItems.thirium, 5));
            moveTime = 60/3f;
            acceptsUnitPayloads = false;
            payloadLimit = 1;
        }
        };

        payloadRouter = new PayloadRouter("module-router") {{
            requirements(Category.units, BuildVisibility.shown, ItemStack.with(dsItems.thirium, 10));
            size = 1;
            moveTime = 60/3f;
            acceptsUnitPayloads = false;
            payloadLimit = 1;
            buildType = () -> new PayloadRouterBuild(){
                @Override
                public boolean acceptPayload(Building source, Payload payload) {
                    if (front() == source) return false;
                    return super.acceptPayload(source, payload) && payload.content() instanceof ModulePayload;
                }
            };
        }
            @Override
            public boolean canSort(Block b){
                return ModuleBlock.modules.contains(modulePayload -> modulePayload == b);
            }

            @Override
            public boolean canSort(UnitType t) {
                return false;
            }
        };

        moduleSource = new ModuleSource("module-source"){{
            requirements(Category.units, with());
            buildVisibility = BuildVisibility.sandboxOnly;
            regionSuffix = "-special";
        }};
    }
}
