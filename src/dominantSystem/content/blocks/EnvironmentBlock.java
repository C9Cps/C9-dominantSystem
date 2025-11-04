package dominantSystem.content.blocks;

import arc.graphics.Color;
import dominantSystem.content.dsItems;
import dominantSystem.content.dsLiquids;
import dominantSystem.expand.block.env.*;
import dominantSystem.expand.block.production.drill.AdaptiveDrill;
import mindustry.content.Items;
import mindustry.graphics.CacheLayer;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.meta.Attribute;

import static mindustry.type.ItemStack.with;

public class EnvironmentBlock {
    public static Block
    //liquid
    runiyLiquid, runiyTile, darkSandRuniy,
    runiyStone, runiyStoneWall,
    //metal
    darknessPlasma, darknessPlate,
    darkTiles, carvedSlab,
    //staticWalls
    darkTilesWall,
    darkTilesPropWall,
    //ore
    sandyDarkTiles, darkTilesGraphiticWall,
    //runes
    runeHeatCharged, runeHeat, runeHeatSmoldering,
    runeSporeCharged, runeSpore, runeSporeSmoldering,
    runeWaterCharged, runeWater, runeWaterSmoldering,
    runeOilCharged, runeOil, runeOilSmoldering,
    runeBiomassCharged, runeBiomass, runeBiomassSmoldering;
    public static void load() {
        boolean sf = false;
        //liquid
        runiyLiquid = new Floor("runiy-liquid", 3){{
            speedMultiplier = 0.5f;
            isLiquid = true;

            albedo = 0.9f;
            supportsOverlay = true;
            liquidMultiplier = 1f;
            statusDuration = 120f;
            drownTime = 200f;
            liquidDrop = dsLiquids.runiy;
            cacheLayer = CacheLayer.water;
        }};
        runiyTile = new Floor("runiy-tile", 5){{
            speedMultiplier = 0.8f;
            isLiquid = true;

            albedo = 0.9f;
            supportsOverlay = true;
            liquidMultiplier = 0.5f;
            statusDuration = 120f;
            liquidDrop = dsLiquids.runiy;
            cacheLayer = CacheLayer.water;
        }};
        darkSandRuniy = new Floor("darksand-runiy", 3){{
            speedMultiplier = 0.8f;
            isLiquid = true;

            albedo = 0.9f;
            supportsOverlay = true;
            liquidMultiplier = 0.5f;
            statusDuration = 120f;
            liquidDrop = dsLiquids.runiy;
            cacheLayer = CacheLayer.water;
        }};
        //floor
        runiyStone = new Floor("runiy-stone"){{
            attributes.set(Attribute.water, -1f);
        }};
        runiyStoneWall = new StaticWall("runiy-stone-wall");
        darknessPlasma = new Floor4x4("darkness-plasma"){{
            attributes.set(Attribute.water, -1f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        darknessPlasma = new Floor4x4("darkness-plate"){{
            attributes.set(Attribute.water, -1f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        darkTiles = new Floor("dark-tiles"){{
            variants = 5;
            attributes.set(Attribute.water, -1f);
            mapColor = new Color(63/255f, 64/255f, 73/255f, 1);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        carvedSlab = new Floor("carved-slab"){{
            variants = 0;
            attributes.set(Attribute.water, -1f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        //walls
        darkTilesWall = new StaticWall("dark-tiles-wall"){{
            variants = 2;
            mapColor = new Color(36/255f, 37/255f, 47/255f, 1);
        }};
        darkTilesPropWall = new StaticWall("dark-tiles-prop-wall"){{
            variants = 3;
        }};
        //ore
        sandyDarkTiles = new Floor("sandy-dark-tiles", 4){{
            attributes.set(Attribute.water, -0.5f);
            attributes.set(Attribute.oil, 0.35f);
            drawEdgeIn = drawEdgeOut = sf;
            itemDrop = dsItems.sand;
        }};
        darkTilesGraphiticWall = new StaticWall("dark-tiles-graphitic-wall"){{
            variants = 2;
            itemDrop = dsItems.graphite;
        }};

        runeHeatCharged = new Floor("rune-heat-charged"){{
            variants = 3;
            attributes.set(Attribute.heat, 1.0f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeHeat = new Floor("rune-heat"){{
            variants = 3;
            attributes.set(Attribute.heat, 0.5f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeHeatSmoldering = new Floor("rune-heat-smoldering"){{
            variants = 3;
            attributes.set(Attribute.heat, 0.25f);
            drawEdgeIn = drawEdgeOut = sf;
        }};

        runeSporeCharged = new Floor("rune-spore-charged"){{
            variants = 3;
            attributes.set(Attribute.spores, 1.0f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeSpore = new Floor("rune-spore"){{
            variants = 3;
            attributes.set(Attribute.spores, 0.5f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeSporeSmoldering = new Floor("rune-spore-smoldering"){{
            variants = 3;
            attributes.set(Attribute.spores, 0.25f);
            drawEdgeIn = drawEdgeOut = sf;
        }};

        runeWaterCharged = new Floor("rune-water-charged"){{
            variants = 3;
            attributes.set(Attribute.water, 1.0f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeWater = new Floor("rune-water"){{
            variants = 3;
            attributes.set(Attribute.water, 0.5f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeWaterSmoldering = new Floor("rune-water-smoldering"){{
            variants = 3;
            attributes.set(Attribute.water, 0.25f);
            drawEdgeIn = drawEdgeOut = sf;
        }};

        runeOilCharged = new Floor("rune-oil-charged"){{
            variants = 3;
            attributes.set(Attribute.oil, 1.0f * 2);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeOil = new Floor("rune-oil"){{
            variants = 3;
            attributes.set(Attribute.oil, 0.5f * 2);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeOilSmoldering = new Floor("rune-oil-smoldering"){{
            variants = 3;
            attributes.set(Attribute.oil, 0.25f * 2);
            drawEdgeIn = drawEdgeOut = sf;
        }};

        runeBiomassCharged = new Floor("rune-biomass-charged"){{
            variants = 3;
            attributes.set(Attribute.add("biomass"), 1.0f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeBiomass = new Floor("rune-biomass"){{
            variants = 3;
            attributes.set(Attribute.add("biomass"), 0.5f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
        runeBiomassSmoldering = new Floor("rune-biomass-smoldering"){{
            variants = 3;
            attributes.set(Attribute.add("biomass"), 0.25f);
            drawEdgeIn = drawEdgeOut = sf;
        }};
    }
}
