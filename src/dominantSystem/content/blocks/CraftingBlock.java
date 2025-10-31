package dominantSystem.content.blocks;

import arc.graphics.Color;
import dominantSystem.content.dsLiquids;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.draw.*;
import dominantSystem.expand.block.production.factory.RecipeCrafter;
import dominantSystem.expand.block.drawer.*;
import dominantSystem.content.dsItems;

import static mindustry.type.ItemStack.with;

public class CraftingBlock {
    public static Block
            //smelters
            etheroniumSmelter,
            refractoryCrucible, oxidativeFacility,
            mycondiumCrucible,
            gelSynthesizer, gelСentrifuge,
            crusher, smeltingFacility, thiriumArcSmelter, fiberglassSynthesizer, resourseConverter,
            //|?|
            filterFacility,
            //none used
            ammunitionFabricator,
            //For assembling units
            armorFabricator, coreFabricator, testAddLink, testRot;
    public static void load() {
        thiriumArcSmelter = new RecipeCrafter("thirium-arc-smelter") {{
            requirements(Category.crafting, with(dsItems.copper, 40, dsItems.beryllium, 25, dsItems.silicon, 25));
            size = 2;
            itemCapacity = 10;
            consumePower(45f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawArcSmelt(),
                    new DrawDefault(),
                    new DrawFade());
            rotate = rotateDraw = false;
        }};
        etheroniumSmelter = new RecipeCrafter("etheronium-smelter") {{
            requirements(Category.crafting, with(dsItems.thirium, 70, dsItems.silicon, 55, dsItems.plastanium, 35));
            size = 2; addLink(2, 0, 1, 2, 1, 1, -1, 0, 1, -1, 1, 1);

            itemCapacity = 30;
            consumePower(145f / 60f);
            drawer = new DrawMulti(new DrawRegionFlip("-bottom"), new DrawCrucibleFlameRotated() {{flameX = 32/4f; flameRad = 0.125f*8;}}, new DrawCrucibleFlameRotated() {{flameX = -32/4f; flameRad = 0.125f*8;}}, new DrawRegionFlip());
        }};

        crusher = new RecipeCrafter("crusher") {{
            requirements(Category.crafting, with(dsItems.copper, 60, dsItems.beryllium, 40, dsItems.graphite, 25));
            size = 2; addLink(2, 0, 1, 2, 1, 1, -1, 0, 1, -1, 1, 1);

            itemCapacity = 30;
            consumePower(120f / 60f);
            drawer = new DrawMulti(
                    new DrawRegionFlip("-bottom"),
                    new DrawRegionFlip("-rot"));
        }};
        smeltingFacility = new RecipeCrafter("smelting-facility") {{
            requirements(Category.crafting, with(dsItems.lead, 90, dsItems.thirium, 90, dsItems.silicon, 75));
            size = 2; addLink(2, 0, 1, 2, 1, 1, -1, 0, 1, -1, 1, 1);
            itemCapacity = 30;
            consumePower(120f / 60f);
            int FR = 2;
        drawer = new DrawMulti(
            new DrawRegionFlip("-rot"),
            new DrawFlameRotated(),
            new DrawFlameRotated(){{//left
                    drawFlame = false;
                    flameX = 44f/4;
                    flameColor = Color.valueOf("FFEF99");
                    flameRadius = FR;

                flameRadiusIn = (this.flameRadius/3) * 1.9f;
                flameRadiusMag = this.flameRadius/3 * 2;
                flameRadiusInMag = this.flameRadius/3;
            }},
            new DrawFlameRotated(){{//center
                    drawFlame = false;
                    flameColor = Color.valueOf("FFEF99");
                    flameRadius = FR * 1.5f;

                flameRadiusIn = (this.flameRadius/3) * 1.9f;
                flameRadiusMag = this.flameRadius/3 * 2;
                flameRadiusInMag = this.flameRadius/3;
                    }},
            new DrawFlameRotated(){{//right
                    drawFlame = false;
                    flameX = -44f/4;
                    flameColor = Color.valueOf("FFEF99");
                    flameRadius = FR;

                flameRadiusIn = (this.flameRadius/3) * 1.9f;
                flameRadiusMag = this.flameRadius/3 * 2;
                flameRadiusInMag = this.flameRadius/3;
            }});
        }};

        fiberglassSynthesizer = new RecipeCrafter("fiberglass-synthesizer") {{
            requirements(Category.crafting, with(dsItems.thirium, 230, dsItems.etheronium, 160, dsItems.thorium, 80));
            size = 3;

            addLink(2, -1, 1, 2, 0, 1, 2, 1, 1,
                    -1, 2, 1,   0, 2, 1,    1, 2, 1);

            itemCapacity = 30;
            consumePower(210 / 60f);
            drawer = new DrawMulti(new DrawRegionRotated(){{oneSprite = true;}}, new DrawWeave(), new DrawRegionRotated("-rot"));
         }};
        /*
        oxidativeFacility = new RecipeCrafter("oxidative-facility") {{
            requirements(Category.crafting, with(dsItems.tungsten, 120, dsItems.thirium, 140, dsItems.silicon, 110, dsItems.thorium, 90, dsItems.plastanium, 70));
            size = 3; addLink(
                    -1,2,1, 0,2,1, 1,2,1,
                    -1,-2,1, 0,-2,1,  1,-2,1,
                    2,1,1, 2,0,1, 2,-1,1,
                    -2,1,1, -2,0,1, -2,-1,1);

            itemCapacity = 30;
            consumePower(210f / 60f);
            drawer = new DrawMulti(
                    new DrawRegion("bottom"),
                    new DrawDefault());
            rotate = rotateDraw = false;
        }};

         */
        mycondiumCrucible = new RecipeCrafter("mycondium-crucible") {{
            requirements(Category.crafting, with(dsItems.thirium, 180, dsItems.silicon, 150, dsItems.plastanium, 130, dsItems.carbide, 110));
            size = 2;

            addLink(2, 0, 1, 2, 1, 1, 0, 2, 1, 1, 2, 1);
            rotations = new int[]{1, 0, 3, 2, 3, 2, 1, 0};
            canMirror = true;

            itemCapacity = 30;
            consumePower(225f / 60f);
            drawer = new DrawMulti(new DrawRegionRotated(){{oneSprite = true;}}, new DrawArcSmeltRotated() {{flameX = (9f/4); flameY = (9/4);}}, new DrawRegionRotated("-rot"));
        }};
        refractoryCrucible = new RecipeCrafter("refractory-crucible") {{
            requirements(Category.crafting, with(dsItems.tungsten, 120, dsItems.thirium, 140, dsItems.silicon, 110, dsItems.thorium, 90, dsItems.plastanium, 70));
            size = 2; addLink(2, 2, 1, 1, 2, 1, 2, 1, 1, -1, 0, 1, -1, -1, 1, 0, -1, 1);
            rotations = new int[]{1, 0, 1, 0, 3, 2, 3, 2};
            canMirror = true;

            itemCapacity = 30;
            consumePower(180f / 60f);
            int FR = 7/2;
            drawer = new DrawMulti(
                    new DrawRegionRotated("bottom"),
                    new DrawRegionRotatedDiagonal(),
                    new DrawFlameRotated(){{//center
                        drawFlame = false;
                        flameX = 0/4;
                        flameColor = Color.valueOf("FFEF99");
                        flameRadius = FR;

                        flameRadiusIn = (this.flameRadius/3) * 1.9f;
                        flameRadiusMag = this.flameRadius/3 * 2;
                        flameRadiusInMag = this.flameRadius/3;
                    }});
        }};
        resourseConverter = new RecipeCrafter("resourse-converter") {{
            requirements(Category.production, with(dsItems.graphite, 40, dsItems.silicon, 75));
            size = 2;
            itemCapacity = 10;
            consumePower(45f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                    new DrawArcSmelt(),
                    new DrawDefault());
            rotate = rotateDraw = false;
        }};
        filterFacility = new RecipeCrafter("filter-facility") {{
            requirements(Category.production, with(dsItems.thirium, 30, dsItems.graphite, 20));
            size = 1; addLink(0, 1, 1,   1, 0, 1);

            itemCapacity = 30;
            consumePower(12f / 60f);
            drawer = new DrawMulti(
                    new DrawRegion("-bottom"),
                    new DrawLiquidTile(){{drawLiquid = dsLiquids.runiy;}},
                    new DrawLiquidTile(){{drawLiquid = dsLiquids.water;}},
                    new DrawRegionRotated("-rot"));
        }};
        /*ammunitionFabricator = new RecipeCrafter("ammunition-fabricator") {{
            requirements(Category.crafting, with(dsItems.silicon, 180, dsItems.graphite, 190, dsItems.thorium, 160));
            size = 2;

            addLink(2, 0, 1, 2, 1, 1, -1, 0, 1, -1, 1, 1, 0, 2, 1, 1, 2, 1, 0, -1, 1, 1, -1, 1, -1, 2, 1, 2, -1, 1);
            rotations = new int[]{1, 0, 1, 0, 3, 2, 3, 2};
            canMirror = true;

            itemCapacity = 30;
            consumePower(210f / 60f);
            drawer = new DrawMulti(new DrawRegionRotated("-bottom"){{oneSprite = true;}}, new DrawRegionRotatedDiagonal());
        }};*/
        gelSynthesizer = new RecipeCrafter("gel-synthesizer") {{
            requirements(Category.crafting, with(dsItems.thirium, 120, dsItems.silicon, 100, dsItems.lead, 90));
            size = 2;

            addLink(2, 0, 1, 2, 1, 1, -1, 0, 1, -1, 1, 1, 0, 2, 1, 1, 2, 1, 0, -1, 1, 1, -1, 1, -1, 2, 1, 2, -1, 1);
            rotations = new int[]{1, 0, 1, 0, 3, 2, 3, 2};
            canMirror = true;

            itemCapacity = 30;
            consumePower(110f / 60f);
            drawer = new DrawMulti(new DrawRegionRotated("-bottom"){{oneSprite = true;}}, new DrawLiquidRegionRotated(){{drawLiquid = dsLiquids.runiy;}} , new DrawRegionRotatedDiagonal());
        }};
        gelСentrifuge = new RecipeCrafter("gel-centrifuge") {{
            requirements(Category.crafting, with(dsItems.thirium, 230, dsItems.etheronium, 160, dsItems.thorium, 80, dsItems.plastanium, 110));
            size = 3; addLink(2, -1, 1, 2, 0, 1, 2, 1, 1, 2, -1, 1, -2, 0, 1, -2, 1, 1, -1, -2, 1, 0, -2, 1, 1, -2, 1, -1, 2, 1, 0, 2, 1, 1, 2, 1);

            itemCapacity = 30;
            consumePower(130f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault(), new DrawPistons(), new DrawRegion("-top"));
            rotate = rotateDraw = false;
        }};
        armorFabricator = new RecipeCrafter("armor-fabricator") {{
            requirements(Category.crafting, with(dsItems.etheronium, 180, dsItems.thirium, 210));
            size = 4;
            addLink(0, 3, 2,    3, 0, 2,    0, -3, 2, -3, 0, 2);

            itemCapacity = 45;
            consumePower(130f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault());
            rotate = rotateDraw = false;
        }};
        coreFabricator = new RecipeCrafter("core-fabricator") {{
            requirements(Category.crafting, with(dsItems.etheronium, 180, dsItems.thirium, 210));
            size = 4;
            addLink(0, 3, 2,    3, 0, 2,    0, -3, 2, -3, 0, 2);

            itemCapacity = 45;
            consumePower(130f / 60f);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawDefault());
            rotate = rotateDraw = false;
            genLightning = true;
            insulated = true;
        }};
    }};