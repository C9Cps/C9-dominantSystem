package dominantSystem.expand.block.defense;

import arc.Core;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.TextureRegion;
import arc.math.geom.Point2;
import arc.struct.Seq;
import mindustry.Vars;
import mindustry.gen.Building;
import mindustry.graphics.Layer;
import mindustry.world.blocks.defense.Wall;
import dominantSystem.util.graphic.SpriteUtil;

import static mindustry.Vars.*;
import static dominantSystem.util.graphic.SpriteUtil.*;

public class DamageReductionWall extends Wall {
    private final Seq<Building> toDamage = new Seq<>();
    public TextureRegion[] atlasRegion;
    public DamageReductionWall(String name) {
        super(name);
        size = 1;
        crushDamageMultiplier = 0.5f;
        clipSize = tilesize * 2;
        teamPassable = true;
    }

    @Override
    public void load() {
        super.load();
        atlasRegion = SpriteUtil.splitRegionArray(Core.atlas.find(name + "-autotile"), 32, 32, 1, ATLAS_INDEX_4_12);
    }
    public class DamageReductionWallBuild extends Building {
        public Seq<DamageReductionWallBuild> connectedWalls = new Seq<>();
        public int drawIndex = 0;

        public void updateDrawRegion() {
            drawIndex = 0;

            for (int i = 0; i < orthogonalPos.length; i++) {
                Point2 pos = orthogonalPos[i];
                Building build = Vars.world.build(tileX() + pos.x, tileY() + pos.y);
                if (checkWall(build)) {
                    drawIndex += 1 << i;
                }
            }
            for (int i = 0; i < diagonalPos.length; i++) {
                Point2[] posArray = diagonalPos[i];
                boolean out = true;
                for (Point2 pos : posArray) {
                    Building build = Vars.world.build(tileX() + pos.x, tileY() + pos.y);
                    if (!(checkWall(build))) {
                        out = false;
                        break;
                    }
                }
                if (out) {
                    drawIndex += 1 << i + 4;

                }
            }

            drawIndex = ATLAS_INDEX_4_12_MAP.get(drawIndex);
        }
        public boolean checkWall(Building build) {
            return build != null && build.block == this.block;
        }

        @Override
        public void drawSelect() {
            super.drawSelect();
            for (Building wall : toDamage) {
                Draw.color(team.color);
                Draw.alpha(0.5f);
                Fill.square(wall.x, wall.y, 2);
            }
            Draw.reset();
        }

        public void updateProximityWall() {
            connectedWalls.clear();

            for (Point2 point : proximityPos) {
                Building other = world.build(tile.x + point.x, tile.y + point.y);
                if (other == null || other.team != team) continue;
                if (checkWall(other)) {
                    connectedWalls.add((DamageReductionWallBuild) other);
                }
            }

            updateDrawRegion();
        }

        public void drawTeam() {
            Draw.color(team.color);
            Draw.alpha(0.25f);
            Draw.z(Layer.blockUnder);
            Fill.square(x, y, 5f);
            Draw.color();
        }

        @Override
        public boolean checkSolid() {
            return false;
        }
        @Override
        public void draw() {
            Draw.z(Layer.block + 1f);
            Draw.rect(atlasRegion[drawIndex], x, y);
        }

        public void updateProximity() {
            super.updateProximity();

            updateProximityWall();
            for (DamageReductionWallBuild other : connectedWalls) {
                other.updateProximityWall();
            }
        }

        @Override
        public void onRemoved() {
            for (DamageReductionWallBuild other : connectedWalls) {
                other.updateProximityWall();
            }
            super.onRemoved();
        }
    }
}