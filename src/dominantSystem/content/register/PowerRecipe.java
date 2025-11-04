package dominantSystem.content.register;

import arc.func.Cons;
import dominantSystem.content.blocks.ModuleBlock;
import dominantSystem.content.blocks.PowerBlock;
import dominantSystem.content.dsItems;
import dominantSystem.expand.block.production.factory.RecipeCrafter;
import dominantSystem.expand.type.Recipe;
import mindustry.type.ItemStack;
import mindustry.type.PayloadStack;
import mindustry.world.Block;

public class PowerRecipe {
/*thermoisotopeGenerator;
*/
    public static void load(){
        recipe(PowerBlock.thermoisotopeGenerator, recipe -> {
            recipe.inputItem = ItemStack.list(dsItems.thorium, 3);
            recipe.inputPayload = PayloadStack.list(ModuleBlock.thermoGel, 1);
            recipe.craftTime = (4/3f*60);
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
