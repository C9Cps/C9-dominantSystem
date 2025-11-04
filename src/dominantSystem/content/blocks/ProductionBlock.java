package dominantSystem.content.blocks;

import dominantSystem.content.dsItems;
import dominantSystem.content.dsLiquids;
import dominantSystem.expand.block.drawer.*;
import dominantSystem.expand.block.production.drill.AdaptiveDrill;
import dominantSystem.expand.block.production.factory.RecipeCrafter;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class ProductionBlock {
    public static Block
            adaptiveDrill,
            filterFacility,
            resourseConverter,
            n;
    public static void load() {
        adaptiveDrill = new AdaptiveDrill("adaptive-drill"){{
            requirements(Category.production, with(dsItems.thirium, 40, dsItems.etheronium, 24, dsItems.mycondium, 15, dsItems.plastanium, 10));
            tier = 5;
            drillTime = (60/0.25f)/(this.size*this.size);
            size = 2;
            consumePower(20f / 60f);
            consumeLiquid(dsLiquids.water, 6.6f/60).boost();
            liquidBoostIntensity = 3.5f/2;
            drillMultipliers.put(Items.beryllium, 1.2f);
        }};
        filterFacility = new RecipeCrafter("filter-facility") {{
            requirements(Category.production, with(dsItems.thirium, 30, dsItems.graphite, 20));
            size = 2;

            itemCapacity = 10;
            consumePower(24f / 60f);
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(){{drawLiquid = dsLiquids.runiy; padding = 2;}},
                    new DrawLiquidTile(){{drawLiquid = dsLiquids.water; padding = 2;}},
                    new DrawDefault());
            rot = false;
        }};
        resourseConverter = new RecipeCrafter("resourse-converter") {{
            requirements(Category.production, with(dsItems.graphite, 40, dsItems.silicon, 75));
            size = 2;
            itemCapacity = 10;
            consumePower(45f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawArcSmelt(),
                    new DrawDefault());
            rot = false;
        }};
    }};