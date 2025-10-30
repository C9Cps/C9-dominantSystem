package dominantSystem.util.graphic;

import arc.graphics.Color;
import arc.graphics.g2d.*;
import arc.math.Mathf;
import arc.math.geom.Position;
import arc.math.geom.Vec2;
import arc.scene.ui.layout.Scl;
import arc.util.Align;
import arc.util.Time;
import arc.util.Tmp;
import arc.util.pooling.Pools;
import mindustry.gen.Building;
import mindustry.graphics.Drawf;
import mindustry.graphics.Pal;
import mindustry.ui.Fonts;
import static mindustry.Vars.tilesize;

public class DrawFunc {
    public static final Color bottomColor = Pal.gray;
    public static final float sinScl = 1f;
    public static final int[] oneArr = {1};
    private static final Vec2
            vec1 = new Vec2();

    public static void circlePercent(float x, float y, float rad, float percent, float angle) {
        float p = Mathf.clamp(percent);

        int sides = Lines.circleVertices(rad);

        float space = 360.0F / (float) sides;
        float len = 2 * rad * Mathf.sinDeg(space / 2);
        float hstep = Lines.getStroke() / 2.0F / Mathf.cosDeg(space / 2.0F);
        float r1 = rad - hstep;
        float r2 = rad + hstep;

        int i;

        for (i = 0; i < sides * p - 1; ++i) {
            float a = space * (float) i + angle;
            float cos = Mathf.cosDeg(a);
            float sin = Mathf.sinDeg(a);
            float cos2 = Mathf.cosDeg(a + space);
            float sin2 = Mathf.sinDeg(a + space);
            Fill.quad(x + r1 * cos, y + r1 * sin, x + r1 * cos2, y + r1 * sin2, x + r2 * cos2, y + r2 * sin2, x + r2 * cos, y + r2 * sin);
        }

        float a = space * i + angle;
        float cos = Mathf.cosDeg(a);
        float sin = Mathf.sinDeg(a);
        float cos2 = Mathf.cosDeg(a + space);
        float sin2 = Mathf.sinDeg(a + space);
        float f = sides * p - i;
        vec1.trns(a, 0, len * (f - 1));
        Fill.quad(x + r1 * cos, y + r1 * sin, x + r1 * cos2 + vec1.x, y + r1 * sin2 + vec1.y, x + r2 * cos2 + vec1.x, y + r2 * sin2 + vec1.y, x + r2 * cos, y + r2 * sin);
    }

    public static void link(Building from, Building to, Color color) {
        float
                sin = Mathf.absin(Time.time * sinScl, 6f, 1f),
                r1 = from.block.size / 2f * tilesize + sin,
                x1 = from.getX(), x2 = to.getX(), y1 = from.getY(), y2 = to.getY(),
                r2 = to.block.size / 2f * tilesize + sin;

        Draw.color(color);

        Lines.square(x2, y2, to.block.size * tilesize / 2f + 1.0f);

        Tmp.v1.trns(from.angleTo(to), r1);
        Tmp.v2.trns(to.angleTo(from), r2);
        int signs = (int) (from.dst(to) / tilesize);

        Lines.stroke(4, Pal.gray);
        Lines.dashLine(x1 + Tmp.v1.x, y1 + Tmp.v1.y, x2 + Tmp.v2.x, y2 + Tmp.v2.y, signs);
        Lines.stroke(2, color);
        Lines.dashLine(x1 + Tmp.v1.x, y1 + Tmp.v1.y, x2 + Tmp.v2.x, y2 + Tmp.v2.y, signs);

        Drawf.arrow(x1, y1, x2, y2, from.block.size * tilesize / 2f + sin, 4 + sin, color);

        Drawf.circles(x2, y2, r2, color);
    }

    public static void posSquareLinkArr(Color color, float stroke, float size, boolean drawBottom, boolean linkLine, Position... pos) {
        if (pos.length < 2 || (!linkLine && pos[0] == null)) return;

        for (int c : drawBottom ? Mathf.signs : oneArr) {
            for (int i = 1; i < pos.length; i++) {
                if (pos[i] == null) continue;
                Position p1 = pos[i - 1], p2 = pos[i];
                Lines.stroke(stroke + 1 - c, c == 1 ? color : bottomColor);
                if (linkLine) {
                    if (p1 == null) continue;
                    Lines.line(p2.getX(), p2.getY(), p1.getX(), p1.getY());
                } else {
                    Lines.line(p2.getX(), p2.getY(), pos[0].getX(), pos[0].getY());
                }
                Draw.reset();
            }

            for (Position p : pos) {
                if (p == null) continue;
                Draw.color(c == 1 ? color : bottomColor);
                Fill.square(p.getX(), p.getY(), size + 1 - c / 1.5f, 45);
                Draw.reset();
            }
        }
    }

    public static void posSquareLink(Color color, float stroke, float size, boolean drawBottom, Position from, Position to) {
        posSquareLinkArr(color, stroke, size, drawBottom, false, from, to);
    }
    public static void drawText(String text, float x, float y, float size) {
        Font font = Fonts.outline;
        GlyphLayout layout = Pools.obtain(GlyphLayout.class, GlyphLayout::new);
        boolean ints = font.usesIntegerPositions();
        font.setUseIntegerPositions(false);
        font.getData().setScale(size / 6f / Scl.scl(1f));

        layout.setText(font, text);
        font.draw(text, x, y, Align.center);

        font.setUseIntegerPositions(ints);
        font.setColor(Color.white);
        font.getData().setScale(1f);
        Draw.reset();
        Pools.free(layout);
    }
}
