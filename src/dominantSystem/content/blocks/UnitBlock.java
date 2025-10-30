package dominantSystem.content.blocks;

import dominantSystem.expand.units.unitType.dsUnitType;
import mindustry.type.Category;
import mindustry.type.PayloadStack;
import mindustry.world.Block;
import dominantSystem.content.dsItems;
import dominantSystem.content.dsUnitTypes;
import mindustry.world.blocks.units.Reconstructor;
import mindustry.world.blocks.units.UnitAssembler;
import mindustry.world.blocks.units.UnitFactory;

import static mindustry.type.ItemStack.with;

public class UnitBlock {
    public static Block specialFabricator, specialRefabricator, duplicateRefabricator, quadronRefabricator, specialMechAssembler;

    public static void load() {
        specialFabricator = new UnitFactory("special-fabricator"){{
            requirements(Category.units, with(dsItems.thirium, 90, dsItems.silicon, 120));
            researchCost = with(dsItems.thirium, 900, dsItems.silicon, 1200);
            regionSuffix = "-special";

            size = 3;
            fogRadius = 3;
            consumePower(90f / 60);
            plans.add(new UnitPlan(dsUnitTypes.madness, 30f * 60, with(dsItems.silicon, 30, dsItems.thirium, 45)));
            plans.add(new UnitPlan(dsUnitTypes.spear, 25f * 60, with(dsItems.silicon, 20, dsItems.thirium, 30)));
        }};

        specialRefabricator = new Reconstructor("special-refabricator"){{
            requirements(Category.units, with(dsItems.thirium, 150, dsItems.silicon, 180, dsItems.tungsten, 90));
            regionSuffix = "-special";

            size = 3;
            consumePower(190f / 60);
            consumeItems(with(dsItems.silicon, 60, dsItems.tungsten, 40));

            constructTime = 40f * 60;

            upgrades.addAll(
                    new dsUnitType[]{dsUnitTypes.madness, dsUnitTypes.chaos}
            );
        }};

        duplicateRefabricator = new Reconstructor("duplicate-refabricator"){{
            requirements(Category.units, with(dsItems.thirium, 380, dsItems.etheronium, 220, dsItems.tungsten, 210));
            regionSuffix = "-special";

            size = 5;
            consumePower(420f / 60);
            consumeItems(with( dsItems.thirium, 110 ,dsItems.etheronium, 90, dsItems.thorium, 70));

            constructTime = 50f * 60;

            upgrades.addAll(
                    new dsUnitType[]{dsUnitTypes.chaos, dsUnitTypes.anarchy}
            );
        }};

        quadronRefabricator = new Reconstructor("quadron-refabricator"){{
            requirements(Category.units, with(dsItems.surgeAlloy, 140, dsItems.etheronium, 250, dsItems.fiberglass, 290, dsItems.carbide, 110));
            regionSuffix = "-special";

            size = 7;
            consumePower(900f / 60);
            consumeItems(with(dsItems.etheronium, 210, dsItems.thorium, 180, dsItems.plastanium, 140));

            constructTime = 70f * 60;

            upgrades.addAll(
                    new dsUnitType[]{dsUnitTypes.anarchy, dsUnitTypes.anger}
            );
        }};
        specialMechAssembler = new UnitAssembler("special-mech-assembler"){{
            requirements(Category.units, with(dsItems.thirium, 480, dsItems.etheronium, 320, dsItems.tungsten, 290));

            size = 7;
            consumePower(480f / 60);
            plans.add(
                    new AssemblerUnitPlan(
                            dsUnitTypes.rage,
                            230f * 60,
                            PayloadStack.list(
                            dsUnitTypes.chaos, 6,
                            ModuleBlock.lightArmor, 20,
                            ModuleBlock.plasmaFuelCell, 5)
                    ),
                    new AssemblerUnitPlan(
                             dsUnitTypes.catastrophe,
                            410f * 60,
                            PayloadStack.list(
                            dsUnitTypes.anarchy, 12,
                            ModuleBlock.reinforcedArmor, 42,
                            ModuleBlock.nuclearFuelCell, 12)
                    )
            );
            areaSize = 14;
        }};

    }
}
