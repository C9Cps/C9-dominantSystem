package dominantSystem.content;

import arc.func.Cons;
import arc.graphics.Color;
import dominantSystem.expand.block.env.Floor4x12;
import dominantSystem.expand.block.env.Floor4x4;
import dominantSystem.expand.block.production.drill.AdaptiveDrill;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.ctype.Content;
import mindustry.graphics.CacheLayer;
import mindustry.type.Category;
import mindustry.world.Block;
import dominantSystem.expand.block.defense.DamageReductionWall;
import mindustry.world.blocks.environment.Floor;
import mindustry.world.blocks.environment.StaticWall;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.meta.Attribute;

import static mindustry.type.ItemStack.with;

public class dsContent {
    public static Block
            //production
            adaptiveDrill,
            //wall
            thiriumWall;

    private static void overrideContent(Content content, Cons<Content> modifier) {
        modifier.get(content);
    }
    public static void defenseLoad() {
        int wallHealthMultiplier = 4;
        thiriumWall = new DamageReductionWall("thirium-wall"){{
            requirements(Category.defense, with(dsItems.thirium, 6));
            size = 1;
            health = 150 * wallHealthMultiplier;
            armor = 3f;
            buildCostMultiplier = 8f;
            absorbLasers = true;
            insulated = true;
        }};
    }
}
