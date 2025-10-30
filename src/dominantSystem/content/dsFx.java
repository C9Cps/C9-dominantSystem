package dominantSystem.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import dominantSystem.util.graphic.dsPal;
import mindustry.entities.*;
import mindustry.graphics.*;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;

public class dsFx{
    public static final Rand rand = new Rand();
    public static final Vec2 v = new Vec2();

    public static final Effect

            none = new Effect(0, 0f, e -> {}),
            shootSmallToxicFlame = new Effect(32f, 80f, e -> {
            color(Color.valueOf("bf92f9"), Color.valueOf("bf92f9"), Color.gray, e.fin());

        randLenVectors(e.id, 13, e.finpow() * 60f, e.rotation, 10f, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 0.65f + e.fout() * 1.5f);
        });
    }),

            hitToxicFlameSmall = new Effect(14, e -> {
            color(Color.valueOf("bf92f9"), Color.valueOf("bf92f9"), e.fin());
        stroke(0.5f + e.fout());

        randLenVectors(e.id, 2, 1f + e.fin() * 15f, e.rotation, 50f, (x, y) -> {
            float ang = Mathf.angle(x, y);
            lineAngle(e.x + x, e.y + y, ang, e.fout() * 3 + 1f);
        });
    }),

    toxicBurning = new Effect(35f, e -> {
        color(Color.valueOf("bf92f9"), Color.valueOf("bf92f9"), e.fin());

        randLenVectors(e.id, 3, 2f + e.fin() * 7f, (x, y) -> {
            Fill.circle(e.x + x, e.y + y, 0.1f + e.fout() * 1.4f);
        });
    }),

    shareDamage = new Effect(45f, e -> {
        if (!(e.data instanceof Number)) return;
        Draw.color(e.color);
        Draw.alpha(((Number) e.data()).floatValue() * e.fout());
        Fill.square(e.x, e.y, e.rotation);
    }),

    hitToxicBulletBig = new Effect(16, e -> {
        color(Color.white, Color.valueOf("bf92f9"), e.fin());
        stroke(0.5f + e.fout() * 2f);

        randLenVectors(e.id, 8, e.finpow() * 30f, e.rotation, 50f, (x, y) -> {
            float ang = Mathf.angle(x, y);
            lineAngle(e.x + x, e.y + y, ang, e.fout() * 4 + 1.5f);
        });
    }),

    instToxicShoot = new Effect(24f, e -> {
        e.scaled(10f, b -> {
            color(Color.white, Pal.sapBulletBack, b.fin());
            stroke(b.fout() * 3f + 0.2f);
            Lines.circle(b.x, b.y, b.fin() * 50f);
        });

        color(Pal.sapBulletBack);

        for(int i : Mathf.signs){
            Drawf.tri(e.x, e.y, 13f * e.fout(), 85f, e.rotation + 90f * i);
            Drawf.tri(e.x, e.y, 13f * e.fout(), 50f, e.rotation + 20f * i);
        }

        Drawf.light(e.x, e.y, 180f, Pal.sapBulletBack, 0.9f * e.fout());
    }),

    instToxicHit = new Effect(20f, 200f, e -> {
        color(Pal.sapBulletBack);

        for(int i = 0; i < 2; i++){
            color(i == 0 ? Pal.sapBulletBack : Pal.sapBullet);

            float m = i == 0 ? 1f : 0.5f;

            for(int j = 0; j < 5; j++){
                float rot = e.rotation + Mathf.randomSeedRange(e.id + j, 50f);
                float w = 23f * e.fout() * m;
                Drawf.tri(e.x, e.y, w, (80f + Mathf.randomSeedRange(e.id + j, 40f)) * m, rot);
                Drawf.tri(e.x, e.y, w, 20f * m, rot + 180f);
            }
        }

        e.scaled(10f, c -> {
            color(Pal.bulletYellow);
            stroke(c.fout() * 2f + 0.2f);
            Lines.circle(e.x, e.y, c.fin() * 30f);
        });

        e.scaled(12f, c -> {
            color(Pal.bulletYellowBack);
            randLenVectors(e.id, 25, 5f + e.fin() * 80f, e.rotation, 60f, (x, y) -> {
                Fill.square(e.x + x, e.y + y, c.fout() * 3f, 45f);
            });
        });
    }),

    instToxicTrail = new Effect(30, e -> {
        for(int i = 0; i < 2; i++){
            color(i == 0 ? Pal.sapBulletBack : Pal.sapBullet);

            float m = i == 0 ? 1f : 0.5f;

            float rot = e.rotation + 180f;
            float w = 15f * e.fout() * m;
            Drawf.tri(e.x, e.y, w, (30f + Mathf.randomSeedRange(e.id, 15f)) * m, rot);
            Drawf.tri(e.x, e.y, w, 10f * m, rot + 180f);
        }

        Drawf.light(e.x, e.y, 60f, Pal.bulletYellowBack, 0.6f * e.fout());
    }),

    ToxicRailHit = new Effect(18f, 200f, e -> {
        color(dsPal.toxic);

        for(int i : Mathf.signs){
            Drawf.tri(e.x, e.y, 10f * e.fout(), 60f, e.rotation + 140f * i);
        }
    });

}
