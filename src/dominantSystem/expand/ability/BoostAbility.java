package dominantSystem.expand.ability;

import arc.Core;
import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.math.Angles;
import arc.math.Mathf;
import arc.math.geom.Vec2;
import arc.scene.ui.layout.Table;
import arc.struct.Queue;
import arc.struct.Seq;
import arc.util.Interval;
import arc.util.Strings;
import arc.util.Time;
import arc.util.Tmp;
import mindustry.Vars;
import mindustry.content.Fx;
import mindustry.entities.Effect;
import mindustry.entities.abilities.Ability;
import mindustry.gen.Unit;
import mindustry.graphics.Layer;
import mindustry.graphics.Trail;
import mindustry.type.UnitType;
import dominantSystem.util.func.PositionOffset;

import static mindustry.Vars.tilesize;

public class BoostAbility extends Ability {
    public float minVelocity = 0.08f;
    public float interval = 3f, chance = 0f;
    public int amount = 1;
    public float x, y, rotation, rangeX, rangeY, rangeLengthMin, rangeLengthMax;
    public boolean rotateEffect = false;
    public float effectParam = 3f;
    public boolean teamColor = false;
    public boolean parentizeEffects;
    public Color color = Color.white;
    public Effect effect = Fx.missileTrail;

    protected float counter;

    public static final int maxSize = 8;

    public boolean drawAirFlow = true;

    public float angleMaxDst = 90f;
    public float velocityMultiple = 3f;
    public int trailLength = 8;

    public float angleCone = 5f;
    protected Seq<Trail> trails;
    protected Queue<Float> seq = new Queue<>(maxSize + 1);
    protected Interval timer = new Interval();

    public BoostAbility(boolean drawAirFlow, float velocityMultiple, float angleCone) {
        this.drawAirFlow = drawAirFlow;
        this.velocityMultiple = velocityMultiple;
        this.angleCone = angleCone;
    }

    public BoostAbility() {
        this(3);
    }

    public BoostAbility(float velocityMultiple, float angleCone) {
        this.velocityMultiple = velocityMultiple;
        this.angleCone = angleCone;
    }

    public BoostAbility(float velocityMultiple) {
        this.velocityMultiple = velocityMultiple;
    }

    @Override
    public void addStats(Table t){
        super.addStats(t);
        t.add(abilityStat("speedMultiplier", Strings.autoFixed(velocityMultiple, 2)));
        t.row();
    }
    public boolean allSame(float angle, float lookAng) {
        if (seq.size < maxSize - 1 || !Angles.within(angle, lookAng, angleMaxDst)) return false;
        for (float f : seq) {
            if (!Angles.within(angle, f, angleCone)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void update(Unit unit) {
        float angle = unit.vel.angle();
        float speed = unit.vel.len();
        boolean same = allSame(angle, unit.rotation());

        if (speed < 0.01f && !seq.isEmpty()) {
            seq.removeFirst();
        }

        if (same) {
            unit.speedMultiplier(unit.speedMultiplier() * velocityMultiple);
        }

        if (seq.size > maxSize) seq.removeFirst();
        if (timer.get(12f) && speed > 0.1f) seq.add(angle);

        if (Vars.headless) return;

        for (int i = 0; i < trails.size; i++) {
            Trail trail = trails.get(i);
            if (i >= unit.type.engines.size) continue;
            UnitType.UnitEngine engine = unit.type.engines.get(i);

            Vec2 vec2 = PositionOffset.unitEngineOffset(unit, engine);
            trail.update(unit.x + vec2.x, unit.y + vec2.y, same ? 1 : 0);
        }
    }

    @Override
    public void draw(Unit unit) {
        float z = Draw.z();
        Draw.z(unit.type.engineLayer > 0 ? unit.type.engineLayer : unit.type.lowAltitude ? Layer.flyingUnitLow - 0.001f : Layer.flyingUnit - 0.001f);
        Color color = unit.type.engineColor == null ? unit.team.color : unit.type.engineColor;
        for (int i = 0; i < trails.size; i++) {
            if (i >= unit.type.engines.size) continue;
            trails.get(i).draw(color, unit.type.engines.get(i).radius / 1.25f);
        }
        Draw.z(z);

//		if(!drawAirFlow)return;
//
//		int particles = (int)unit.type.hitSize;
//		float particleLife = 40f, particleRad = unit.type.hitSize, particleStroke = 1.1f, particleLen = unit.hitSize / 8f;
//		Rand rand = new Rand();
//		float base = (Time.time / particleLife);
//		rand.setSeed(unit.id);
//
//		float warmup = warmup(unit.rotation) * Mathf.clamp(unit.vel.len() / unit.speed());
//		Tmp.v1.trns(unit.rotation, unit.type.engineOffset * 1.25f);
//
//		Draw.blend(Blending.additive);
//
//		Draw.color(Color.white, warmup * 0.6f);
//
//		for(int i = 0; i < particles; i++){
//			float fin = (rand.random(1f) + base) % 1f * warmup, fout = 1f - fin;
//			float angle = unit.rotation + rand.range(60f) - 180;
//			float len = particleRad * Interp.pow2Out.apply(fin);
//			Lines.lineAngle(unit.x + Angles.trnsx(angle, len) + Tmp.v1.x, unit.y + Angles.trnsy(angle, len) + Tmp.v1.y, angle, particleLen * fout * warmup);
//		}
//
//		Draw.blend();
    }
}
