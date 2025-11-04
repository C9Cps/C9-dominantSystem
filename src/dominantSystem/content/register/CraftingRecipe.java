package dominantSystem.content.register;

import arc.func.Cons;
import dominantSystem.content.blocks.ModuleBlock;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.type.PayloadStack;
import mindustry.world.Block;
import dominantSystem.content.dsItems;
import dominantSystem.content.dsLiquids;
import dominantSystem.content.blocks.CraftingBlock;
import dominantSystem.expand.block.production.factory.RecipeCrafter;
import dominantSystem.expand.type.Recipe;

public class CraftingRecipe {
    public static void load(){
        recipe(CraftingBlock.crusher, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.scrap, 1);
            recipe.outputItem = ItemStack.list(dsItems.sand, 3);
            recipe.craftTime = 90f;
            recipe.priority = 1;
        });
        recipe(CraftingBlock.crusher, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.copper, 2, dsItems.lead, 1);
            recipe.outputItem = ItemStack.list(dsItems.sand, 6);
            recipe.craftTime = 80f;
            recipe.priority = 2;
        });
        recipe(CraftingBlock.crusher, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.thirium, 1);
            recipe.outputItem = ItemStack.list(dsItems.sand, 6);
            recipe.craftTime = 60f;
            recipe.priority = 3;
        });

        recipe(CraftingBlock.smeltingFacility, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.coal, 3, dsItems.sand, 5);
            recipe.outputItem = ItemStack.list(dsItems.silicon, 3);
            recipe.craftTime = (60/0.6f);
            recipe.priority = 1;
        });
        recipe(CraftingBlock.smeltingFacility, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.coal, 4, dsItems.sand, 5, dsItems.pyratite, 1);
            recipe.inputLiquid = LiquidStack.list(dsLiquids.runiy, 10f/60);
            recipe.outputItem = ItemStack.list(dsItems.silicon, 6);
            recipe.craftTime = (60/0.75f);
            recipe.priority = 2;
        });
        recipe(CraftingBlock.smeltingFacility, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.coal, 9, dsItems.sand, 14);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 1);
            recipe.outputItem = ItemStack.list(dsItems.silicon, 16);
            recipe.craftTime = (60/0.4f);
            recipe.priority = 3;
        });

        recipe(CraftingBlock.oxidativeFacility, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.beryllium, 3);
            recipe.inputLiquid = LiquidStack.list(dsLiquids.ozone, 3f/60);
            recipe.outputItem = ItemStack.list(dsItems.oxide, 2);
            recipe.craftTime = (60/0.75f);
            recipe.priority = 1;
        });
        recipe(CraftingBlock.oxidativeFacility, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.beryllium, 5, dsItems.silicon, 1);
            recipe.inputLiquid = LiquidStack.list(dsLiquids.ozone, 4f/60);
            recipe.outputItem = ItemStack.list(dsItems.oxide, 4);
            recipe.craftTime = (60/0.8f);
            recipe.priority = 2;
        });
        recipe(CraftingBlock.refractoryCrucible, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.tungsten, 2, dsItems.graphite, 3, dsItems.silicon, 1);
            recipe.outputItem = ItemStack.list(dsItems.carbide, 3);
            recipe.craftTime = (3/2f*60);
            recipe.priority = 1;
        });
        recipe(CraftingBlock.refractoryCrucible, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.tungsten, 3, dsItems.graphite, 4, dsItems.silicon, 3);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 1);
            recipe.outputItem = ItemStack.list(dsItems.carbide, 8);
            recipe.craftTime = (4/3f*60);
            recipe.priority = 1;
        });

        recipe(CraftingBlock.thiriumArcSmelter, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.beryllium, 3, dsItems.titanium, 2);
            recipe.outputItem = ItemStack.list(dsItems.thirium, 2);
            recipe.craftTime = (4/3f*60);
            recipe.priority = 1;
        });
        recipe(CraftingBlock.thiriumArcSmelter, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.beryllium, 15, dsItems.titanium, 9);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 1);
            recipe.outputItem = ItemStack.list(dsItems.thirium, 18);
            recipe.craftTime = (9/3f*60);
            recipe.priority = 2;
        });

        recipe(CraftingBlock.etheroniumSmelter, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.graphite, 1, dsItems.silicon, 2, dsItems.tungsten, 1);
            recipe.outputItem = ItemStack.list(dsItems.etheronium, 3);
            recipe.craftTime = (3/1.8f*60f);
            recipe.priority = 1;
        });
        recipe(CraftingBlock.etheroniumSmelter, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.graphite, 3, dsItems.silicon, 6, dsItems.tungsten, 3);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 1);
            recipe.outputItem = ItemStack.list(dsItems.etheronium, 12);
            recipe.craftTime = (12/5.4f*60f);
            recipe.priority = 1;
        });

        recipe(CraftingBlock.fiberglassSynthesizer, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.metaglass, 5, dsItems.oxide, 2);
            recipe.outputItem = ItemStack.list(dsItems.fiberglass, 2);
            recipe.craftTime = (5/3f*60f);
            recipe.priority = 1;
        });
        recipe(CraftingBlock.fiberglassSynthesizer, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.metaglass, 8, dsItems.oxide, 4);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 1);
            recipe.outputItem = ItemStack.list(dsItems.fiberglass, 6);
            recipe.craftTime = (7.5f/6*60f);
            recipe.priority = 2;
        });

        recipe(CraftingBlock.mycondiumCrucible, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.silicon, 4, dsItems.tungsten, 3, dsItems.thorium, 2);
            recipe.inputLiquid = LiquidStack.list(dsLiquids.runiy, 8 / 60f);
            recipe.outputItem = ItemStack.list(dsItems.mycondium, 2);
            recipe.craftTime = (2f/0.4f*60f);
            recipe.priority = 1;
        });
        recipe(CraftingBlock.mycondiumCrucible, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.carbide, 2, dsItems.surgeAlloy, 1);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 1);
            recipe.outputItem = ItemStack.list(dsItems.mycondium, 3);
            recipe.craftTime = (3/0.8f*60f);
            recipe.priority = 2;
        });


        /*recipe(CraftingBlock.ammunitionFabricator, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.copper, 6, dsItems.lead, 3);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.defaultAmmo, 3);
            recipe.craftTime = 60/0.5f * 3;
        });*/

        recipe(CraftingBlock.armorFabricator, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.thirium, 6, dsItems.graphite, 4);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 1);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.lightArmor, 1);
            recipe.craftTime = 1/0.20f * 60;
        });
        recipe(CraftingBlock.armorFabricator, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.tungsten, 8, dsItems.plastanium, 4);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.volcanicGel, 1);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.reinforcedArmor, 1);
            recipe.craftTime = 1/0.20f * 60;
        });
        recipe(CraftingBlock.armorFabricator, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.carbide, 10, dsItems.mycondium, 4);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.volcanicGel, 1);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.heavyArmor, 1);
            recipe.craftTime = 1/0.20f * 60;
        });

        recipe(CraftingBlock.coreFabricator, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.graphite, 4, dsItems.titanium, 6);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.plasmaFuelCell, 1);
            recipe.craftTime = 1/0.1f * 60;
        });
        recipe(CraftingBlock.coreFabricator, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.etheronium, 8, dsItems.thorium, 6, dsItems.phaseFabric, 4);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.nuclearFuelCell, 1);
            recipe.craftTime = 1/0.1f * 60;
        });

        recipe(CraftingBlock.gelSynthesizer, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.silicon, 4, dsItems.lead, 2);
            recipe.inputLiquid = LiquidStack.list(dsLiquids.runiy, 20 / 60f);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.mechanicalGel, 2);
            recipe.craftTime = 120f;
        });
        recipe(CraftingBlock.gelSynthesizer, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.coal, 3);
            recipe.inputLiquid = LiquidStack.list(dsLiquids.runiy, 20 / 60f);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.thermoGel, 2);
            recipe.craftTime = 120f;
        });

        recipe(CraftingBlock.gelСentrifuge, recipe -> {
            recipe.inputItem = ItemStack.list( dsItems.plastanium, 3, dsItems.etheronium, 4);
            recipe.inputLiquid = LiquidStack.list(dsLiquids.water, 10f/60);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.mechanicalGel, 2);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.pneumaticGel, 2);
            recipe.craftTime = 120f;
        });
        recipe(CraftingBlock.gelСentrifuge, recipe -> {
            recipe.inputItem = ItemStack.list( dsItems.fiberglass, 2, dsItems.etheronium, 4);
            recipe.inputLiquid = LiquidStack.list(dsLiquids.slag, 10f/60);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 2);
            recipe.outputPayload = PayloadStack.list(ModuleBlock.volcanicGel, 2);
            recipe.craftTime = 120f;
        });
    }

    public static void recipe(Block block, Cons<Recipe> recipe) {
        if (block instanceof RecipeCrafter crafter) {
            Recipe r = new Recipe();
            recipe.get(r);
            crafter.recipes.add(r);
        }
    }

}
