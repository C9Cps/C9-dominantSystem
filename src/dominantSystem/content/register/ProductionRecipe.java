package dominantSystem.content.register;

import arc.func.Cons;
import dominantSystem.content.blocks.CraftingBlock;
import dominantSystem.content.blocks.ModuleBlock;
import dominantSystem.content.blocks.ProductionBlock;
import dominantSystem.content.dsItems;
import dominantSystem.content.dsLiquids;
import dominantSystem.expand.block.production.factory.RecipeCrafter;
import dominantSystem.expand.type.Recipe;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.type.PayloadStack;
import mindustry.world.Block;

public class ProductionRecipe {
    /*
    resourseConverter
    filterFacility
    resourseConverter
     */
    public static void load(){
        recipe(ProductionBlock.resourseConverter, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.copper, 1);
            recipe.outputItem = ItemStack.list(dsItems.beryllium, 1);
            recipe.craftTime = 3/3f*60;
            recipe.priority = 1;
        });
        recipe(ProductionBlock.resourseConverter, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.lead, 2);
            recipe.outputItem = ItemStack.list(dsItems.beryllium, 1);
            recipe.craftTime = 4/3f*60;
            recipe.priority = 1;
        });
        recipe(ProductionBlock.resourseConverter, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.titanium, 2);
            recipe.outputItem = ItemStack.list(dsItems.tungsten, 1);
            recipe.craftTime = 4/3f*60;
            recipe.priority = 1;
        });

        recipe(ProductionBlock.filterFacility, recipe -> {
            recipe.inputLiquid = LiquidStack.list(dsLiquids.runiy, 18f /60);
            recipe.outputLiquid = LiquidStack.list(dsLiquids.water, 6f /60);
            recipe.craftTime = (60/0.5f);
            recipe.priority = 1;
        });
        recipe(ProductionBlock.filterFacility, recipe -> {
            recipe.inputLiquid = LiquidStack.list(dsLiquids.runiy, 18f /60);
            recipe.inputItem = ItemStack.list(dsItems.sand, 1);
            recipe.outputLiquid = LiquidStack.list(dsLiquids.water, 18f /60);
            recipe.craftTime = (60/0.5f);
            recipe.priority = 1;
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
