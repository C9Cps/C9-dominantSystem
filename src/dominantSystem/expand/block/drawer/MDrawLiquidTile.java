package dominantSystem.expand.block.drawer;

import mindustry.gen.Building;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.blocks.liquid.LiquidBlock;
import mindustry.world.draw.DrawBlock;

public class MDrawLiquidTile extends DrawBlock {
        public float y;
        public float x;
        public Liquid drawLiquid;
        public float padding;
        public float padLeft = -1, padRight = -1, padTop = -1, padBottom = -1;
        public float alpha = 1f;

        public MDrawLiquidTile(Liquid drawLiquid, float padding){
            this.drawLiquid = drawLiquid;
            this.padding = padding;
        }

        public MDrawLiquidTile(Liquid drawLiquid){
            this.drawLiquid = drawLiquid;
        }

        public MDrawLiquidTile(){
        }

        @Override
        public void draw(Building build){
            Liquid drawn = drawLiquid != null ? drawLiquid : build.liquids.current();
            LiquidBlock.drawTiledFrames(build.block.size, build.x + x, build.y + y, padLeft, padRight, padTop, padBottom, drawn, build.liquids.get(drawn) / build.block.liquidCapacity * alpha);
        }

        @Override
        public void load(Block block){
            if(padLeft < 0) padLeft = padding;
            if(padRight < 0) padRight = padding;
            if(padTop < 0) padTop = padding;
            if(padBottom < 0) padBottom = padding;
        }
    }
