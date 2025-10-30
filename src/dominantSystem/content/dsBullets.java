package dominantSystem.content;

import dominantSystem.content.bullets.*;
import mindustry.content.Fx;
import mindustry.entities.bullet.*;
import mindustry.graphics.Pal;

public class dsBullets {
    public static BulletType
            payBullet, homingPay;
    public static void load() {
        payBullet = new PayloadBullet(1.6f){{
            hitEffect = Fx.mineBig;
            despawnEffect = Fx.none;
            hitColor = Pal.engine;

            lifetime = 80f;
            trailSize = 6f;
            splashDamageRadius = 30f;
        }};
        homingPay = new HomingPayloadBullet(1.6f){{
            hitEffect = Fx.mineBig;
            despawnEffect = Fx.none;
            hitColor = Pal.engine;

            lifetime = 80f;
            trailSize = 6f;
            splashDamageRadius = 30f;

            homingPower = 0.03f;
            homingRange = 120f;
        }};


    }
}
