/*     */ package game.battle.util;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.constant.Config;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ECollision;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.projectiles.Projectile;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.VectorImp;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ public final class FightingUtil {
/*  22 */   private final VectorImp vec = new VectorImp();
/*  23 */   private ECollision coll = new ECollision();
/*     */   
/*  25 */   private final double CHANCE_MIN = 1.0D / (Config.battle()).DAMAGE_REDUCTION;
/*  26 */   private final double CHANCE_SPAN = (Config.battle()).DAMAGE_REDUCTION - this.CHANCE_MIN;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void attack(Humanoid a, ENTITY enemy) {
/*  32 */     DIR od = enemy.speed.dir();
/*  33 */     this.vec.set(a.body(), enemy.body());
/*  34 */     this.coll.other = (ENTITY)a;
/*     */     
/*  36 */     double dot = (1.0D - od.xN() * this.vec.nX() - od.yN() * this.vec.nY()) * 0.5D;
/*     */     
/*  38 */     this.coll.norX = this.vec.nX();
/*  39 */     this.coll.norY = this.vec.nY();
/*  40 */     this.coll.dirDot = dot;
/*  41 */     this.coll.dirDotOther = dot;
/*  42 */     this.coll.speedHasChanged = false;
/*  43 */     this.coll.tileMomentum = 0.0D;
/*     */ 
/*     */ 
/*     */     
/*  47 */     if (dodge((BOOSTABLES.BATTLE()).OFFENCE.get((BOOSTABLE_O)a.indu()), enemy.getDefenceSkill(dot, this.coll.norX, this.coll.norY))) {
/*     */       
/*  49 */       this.coll.damagetileStrength = 0.0D;
/*  50 */       this.coll.tileMomentum = 0.0D;
/*     */       
/*  52 */       enemy.collide(this.coll);
/*     */       
/*     */       return;
/*     */     } 
/*  56 */     setDamage(this.coll, a);
/*     */     
/*  58 */     if (enemy instanceof Humanoid) {
/*  59 */       Humanoid e = (Humanoid)enemy;
/*  60 */       if (!doesNotBlock((BOOSTABLES.BATTLE()).DEXTERITY.get((BOOSTABLE_O)a.indu()), e, dot, this.coll.norX, this.coll.norY)) {
/*  61 */         blockDamage(this.coll, e);
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  67 */     (AI.modules()).battle.soundSword.rnd(a);
/*     */     
/*  69 */     double nY = enemy.speed.y() + this.vec.nY() * this.coll.tileMomentum * enemy.physics.getMassI();
/*  70 */     double nX = enemy.speed.x() + this.vec.nX() * this.coll.tileMomentum * enemy.physics.getMassI();
/*  71 */     this.coll.speedHasChanged = true;
/*  72 */     enemy.speed.setRaw(nX, nY);
/*     */ 
/*     */     
/*  75 */     enemy.collide(this.coll);
/*  76 */     if (enemy.isRemoved()) {
/*  77 */       STATS.BATTLE().makeAKill(a);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dodge(double attackSpeed, double defenceAgility) {
/*  84 */     if (defenceAgility <= 0.0D) {
/*  85 */       return false;
/*     */     }
/*  87 */     if (attackSpeed <= 0.0D) {
/*  88 */       return true;
/*     */     }
/*  90 */     double r = attackSpeed / defenceAgility * (this.CHANCE_MIN + RND.rFloat() * this.CHANCE_SPAN);
/*  91 */     if (r > RND.rFloat())
/*  92 */       return false; 
/*  93 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean doesNotBlock(double attackSkill, Humanoid enemy, double dot, double adx, double ady) {
/*  99 */     if (attackSkill <= 0.0D) {
/* 100 */       return false;
/*     */     }
/* 102 */     double def = HPoll.Handler.parrySkill(enemy, dot, adx, ady);
/*     */     
/* 104 */     if (def <= 0.0D) {
/* 105 */       return true;
/*     */     }
/* 107 */     if (enemy.division() == null) {
/* 108 */       def *= 0.25D;
/*     */     }
/*     */     
/* 111 */     double r = attackSkill / def * (this.CHANCE_MIN + RND.rFloat() * this.CHANCE_SPAN);
/* 112 */     if (r > RND.rFloat())
/* 113 */       return true; 
/* 114 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private double formationValue(Humanoid a, double ax, double ay) {
/* 120 */     Div div = a.division();
/* 121 */     if (div != null) {
/* 122 */       DIR dd = div.position().dir();
/* 123 */       double dot = ax * dd.xN() + ay * dd.yN();
/* 124 */       dot = (1.0D + dot) * 0.5D;
/* 125 */       dot = (int)(dot * 4.0D) * 0.25D;
/*     */       
/* 127 */       if (dot > 0.0D) {
/* 128 */         return dot * (BOOSTABLES.BATTLE()).FORMATION.get((BOOSTABLE_O)a.division());
/*     */       }
/*     */     } 
/* 131 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   private void setDamage(ECollision e, Humanoid a) {
/* 136 */     double h = 1.0D + ((Terrain.TerrainTile)SETT.TERRAIN().get(a.tc())).heightEnt(a.tc().x(), a.tc().y()) / 10.0D;
/* 137 */     e.damagetileStrength = (BOOSTABLES.BATTLE()).BLUNT_ATTACK.get((BOOSTABLE_O)a.indu()) * h;
/*     */     
/* 139 */     for (int i = 0; i < e.damage.length; i++) {
/* 140 */       double da = ((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(i)).attack.get((BOOSTABLE_O)a.indu());
/* 141 */       e.damage[i] = da;
/*     */     } 
/* 143 */     this.coll.tileMomentum = 64.0D * h * (BOOSTABLES.BATTLE()).BLUNT_ATTACK.get((BOOSTABLE_O)a.indu()) * (0.5D + (RND.rFloat() * 2.0F));
/*     */   }
/*     */   
/*     */   private void blockDamage(ECollision e, Humanoid blocker) {
/* 147 */     e.damagetileStrength /= (BOOSTABLES.BATTLE()).BLUNT_DEFENCE_DIR.get((BOOSTABLE_O)blocker.indu());
/* 148 */     for (int i = 0; i < e.damage.length; i++) {
/* 149 */       e.damage[i] = e.damage[i] / (1.0D + ((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(i)).defenceDir.get((BOOSTABLE_O)blocker.indu()));
/*     */     }
/*     */   }
/*     */   
/*     */   public double valueDefenceSkill(Humanoid a, double attackDot, double angleOfAttackX, double angleOfAttackY) {
/* 154 */     double def = (BOOSTABLES.BATTLE()).DEFENCE.get((BOOSTABLE_O)a.indu());
/* 155 */     double res = (0.1D + 0.9D * attackDot) * def;
/* 156 */     res += formationValue(a, angleOfAttackX, angleOfAttackY);
/* 157 */     return res;
/*     */   }
/*     */   
/*     */   public double valueParrySkill(Humanoid a, double attackDot, double angleOfattackX, double angleOfAttackY) {
/* 161 */     double def = (BOOSTABLES.BATTLE()).PARRY.get((BOOSTABLE_O)a.indu());
/* 162 */     def = attackDot * def;
/* 163 */     def += formationValue(a, angleOfattackX, angleOfAttackY);
/* 164 */     return def;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getDamageDone(ECollision coll, Humanoid a) {
/* 169 */     double dam = 1.0D;
/* 170 */     dam /= 1.0D + ((Terrain.TerrainTile)SETT.TERRAIN().get(a.tc())).heightEnt(a.tc().x(), a.tc().y()) / 10.0D;
/*     */     
/* 172 */     for (int i = 0; i < (BOOSTABLES.BATTLE()).DAMAGES.size(); i++) {
/* 173 */       dam += coll.damage[i] / (1.0D + ((BOOSTABLES.BDamage)(BOOSTABLES.BATTLE()).DAMAGES.get(i)).defence.get((BOOSTABLE_O)a.indu()));
/*     */     }
/*     */     
/* 176 */     dam *= coll.damagetileStrength;
/* 177 */     dam /= (this.CHANCE_MIN + RND.rFloat() * this.CHANCE_SPAN) * (BOOSTABLES.BATTLE()).BLUNT_DEFENCE.get((BOOSTABLE_O)a.indu());
/*     */     
/* 179 */     double ch = RND.rFloat();
/* 180 */     if (a.division() == null)
/* 181 */       ch *= 0.25D; 
/* 182 */     if (dam > ch)
/*     */     {
/* 184 */       return dam;
/*     */     }
/*     */ 
/*     */     
/* 188 */     return 0.0D;
/*     */   }
/*     */   
/* 191 */   double bb = 0.0D;
/* 192 */   double am = 0.0D;
/*     */   
/*     */   public boolean projectileAttack(ENTITY e, double angleX, double angleY, double speed, Projectile type, double ref) {
/* 195 */     int sp = (int)speed;
/* 196 */     DIR od = e.speed.dir();
/*     */     
/* 198 */     double dot = od.xN() * angleX + od.yN() * angleY;
/* 199 */     dot = (1.0D + dot) * 0.5D;
/*     */     
/* 201 */     if (dodge(sp, e.getDefenceSkill(dot, angleX, angleY))) {
/* 202 */       return false;
/*     */     }
/*     */     
/* 205 */     this.coll.norX = angleX;
/* 206 */     this.coll.norY = angleY;
/* 207 */     this.coll.dirDot = dot;
/* 208 */     this.coll.dirDotOther = dot;
/* 209 */     this.coll.leave = CAUSE_LEAVES.SLAYED();
/* 210 */     this.coll.other = null;
/* 211 */     this.coll.damagetileStrength = type.mass(ref) * sp * 0.015625D;
/* 212 */     for (int i = 0; i < this.coll.damage.length; i++) {
/* 213 */       this.coll.damage[i] = type.damage(i, ref);
/*     */     }
/*     */     
/* 216 */     double mom = type.mass(ref) * speed;
/* 217 */     mom *= (1.0F + RND.rFloat(8.0D));
/* 218 */     this.coll.tileMomentum = mom;
/* 219 */     mom *= e.physics.getMassI();
/* 220 */     double nX = angleX * mom;
/* 221 */     double nY = angleY * mom;
/* 222 */     e.speed.setRaw(e.speed.x() + nX, e.speed.y() + nY);
/*     */     
/* 224 */     this.am++;
/* 225 */     if (e instanceof Humanoid) {
/* 226 */       Humanoid eh = (Humanoid)e;
/* 227 */       if (!doesNotBlock(type.skill(ref) + 1.0D, eh, dot, angleX, angleY)) {
/*     */ 
/*     */         
/* 230 */         this.bb++;
/* 231 */         blockDamage(this.coll, eh);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 241 */     e.collide(this.coll);
/*     */     
/* 243 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImpactDamage(Humanoid a, ECollision coll, ECollision damage) {
/* 250 */     double speed = a.speed.magnitude();
/*     */ 
/*     */     
/* 253 */     damage.damagetileStrength = 0.0D;
/*     */     
/* 255 */     if (dodge((BOOSTABLES.BATTLE()).DEXTERITY.get((BOOSTABLE_O)a.indu()) + speed, coll.other.getDefenceSkill(coll.dirDotOther, coll.norX, coll.norY))) {
/*     */       return;
/*     */     }
/*     */     
/* 259 */     setDamage(damage, a);
/*     */     
/* 261 */     speed = speed * 0.015625D - 2.0D;
/* 262 */     if (speed < 0.0D) {
/* 263 */       speed = 0.0D;
/*     */     }
/* 265 */     (STATS.NEEDS()).EXHASTION.indu().incD(a.indu(), -speed * 0.25D);
/*     */     
/* 267 */     double bonus = speed * coll.dirDot;
/* 268 */     bonus *= (BOOSTABLES.BATTLE()).CHARGE.get((BOOSTABLE_O)a.indu());
/*     */     
/* 270 */     damage.damagetileStrength *= bonus;
/*     */     
/* 272 */     if (coll.other instanceof Humanoid) {
/* 273 */       Humanoid e = (Humanoid)coll.other;
/* 274 */       if (doesNotBlock((BOOSTABLES.BATTLE()).OFFENCE.get((BOOSTABLE_O)a.indu()), e, coll.dirDotOther, coll.norX, coll.norY))
/* 275 */         blockDamage(damage, e); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\FightingUtil.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */