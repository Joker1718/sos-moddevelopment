/*     */ package game.battle.setting;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DIV_FORMATION;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.ThreadLocalRandom;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipRange;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ 
/*     */ 
/*     */ public final class DivSettings
/*     */ {
/*     */   private final Div div;
/*     */   private boolean mustering = false;
/*     */   public boolean guard = true;
/*     */   private boolean mopping = false;
/*     */   public boolean charging = false;
/*     */   public boolean running;
/*     */   public boolean fireAtWill;
/*     */   public boolean shouldNotMoveToFire;
/*  27 */   public short ammoI = 0;
/*  28 */   public DIV_FORMATION formation = DIV_FORMATION.TIGHT;
/*     */   
/*  30 */   private double speed = 25.6D;
/*     */   
/*     */   public boolean shouldFire;
/*     */   public boolean shouldbreak = true;
/*     */   public boolean chargeSpeed = false;
/*  35 */   private float chargeSound = 0.0F;
/*     */   private float power;
/*  37 */   private double aref = 0.0D;
/*     */   
/*     */   DivSettings(Div div) {
/*  40 */     this.div = div;
/*     */   }
/*     */   
/*     */   public boolean mustering() {
/*  44 */     return this.mustering;
/*     */   }
/*     */   
/*     */   public boolean moppingUp() {
/*  48 */     return this.mopping;
/*     */   }
/*     */   
/*     */   public boolean shouldFire() {
/*  52 */     return (ammo() != null && BattleTrajectories.trajectories(this.div) > 0);
/*     */   }
/*     */   
/*     */   public void musteringSet(boolean must) {
/*  56 */     this.div.current().init(this.div.menNrOf());
/*  57 */     this.mustering = must;
/*     */   }
/*     */   
/*     */   public void moppingSet(boolean must) {
/*  61 */     if (must) {
/*  62 */       musteringSet(must);
/*     */     }
/*  64 */     this.mopping = must;
/*     */   }
/*     */   
/*     */   public EquipRange ammo() {
/*  68 */     if (((EquipRange)STATS.EQUIP().RANGED().get(this.ammoI)).stat().div().get(this.div) > 0 && ((EquipRange)STATS.EQUIP().RANGED().get(this.ammoI)).ammoD(this.div) > 0.0D)
/*  69 */       return (EquipRange)STATS.EQUIP().RANGED().get(this.ammoI); 
/*  70 */     this.aref = 0.0D;
/*  71 */     for (int k = 0; k < STATS.EQUIP().RANGED().size(); k++) {
/*  72 */       EquipRange a = (EquipRange)STATS.EQUIP().RANGED().get(k);
/*  73 */       if (a.stat().div().get(this.div) > 0 && a.ammoD(this.div) > 0.0D) {
/*  74 */         setAmmoI(a.tIndex);
/*  75 */         return a;
/*     */       } 
/*     */     } 
/*  78 */     return null;
/*     */   }
/*     */   
/*     */   public void setBestAmmo() {
/*  82 */     int i = ThreadLocalRandom.current().nextInt(STATS.EQUIP().RANGED().size());
/*  83 */     for (int k = 0; k < STATS.EQUIP().RANGED().size(); k++) {
/*  84 */       EquipRange a = (EquipRange)STATS.EQUIP().RANGED().getC(i + k);
/*  85 */       if (a.stat().div().get(this.div) > 0 && a.ammoD(this.div) > 0.0D) {
/*  86 */         setAmmoI(a.tIndex);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void update() {
/*  93 */     if (this.div.menNrOf() == 0) {
/*  94 */       this.power = 0.0F;
/*  95 */       this.aref = 0.0D;
/*  96 */       this.speed = 25.6D;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 101 */     EquipRange a = ammo();
/* 102 */     if (a != null) {
/* 103 */       this.aref = a.ref(this.div);
/*     */     } else {
/* 105 */       this.aref = 0.0D;
/*     */     } 
/* 107 */     this.power = (float)(GAME.battle()).power.get(this.div);
/*     */     
/* 109 */     if (this.speed < 0.9D) {
/* 110 */       this.chargeSound--;
/* 111 */       if (this.chargeSound < 0.0F) {
/* 112 */         this.chargeSound = 0.0F;
/*     */       }
/*     */     } 
/* 115 */     double speed = 0.4D;
/*     */     
/* 117 */     if (this.charging || this.chargeSpeed) {
/* 118 */       if (this.chargeSound <= 0.0F) {
/* 119 */         (GAME.ARMIES()).sound.chargeHorn.play(this.div.race(), this.div.centre().cX(), this.div.centre().cY());
/* 120 */         this.chargeSound = 10.0F;
/*     */       } 
/* 122 */       speed = 0.9D;
/*     */     }
/* 124 */     else if (this.running) {
/* 125 */       speed = 0.7D;
/* 126 */     }  if ((GAME.ARMIES()).factors.shouldRun(this.div) || this.div.status().isFighting())
/* 127 */       speed *= 0.75D; 
/* 128 */     speed *= (BOOSTABLES.PHYSICS()).SPEED.get((BOOSTABLE_O)this.div) * 64.0D;
/*     */     
/* 130 */     this.speed = speed;
/*     */   }
/*     */   
/*     */   private void setAmmoI(int i) {
/* 134 */     if (this.ammoI != i) {
/* 135 */       this.ammoI = (short)i;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean fireAtWill() {
/* 140 */     if (ammo() == null) {
/* 141 */       this.fireAtWill = false;
/*     */     }
/* 143 */     return this.fireAtWill;
/*     */   }
/*     */   
/*     */   public double ammoRef() {
/* 147 */     return this.aref;
/*     */   }
/*     */   
/*     */   void save(FilePutter file) {
/* 151 */     file.bool(this.running);
/* 152 */     file.bool(this.guard);
/* 153 */     file.b((byte)this.formation.ordinal());
/* 154 */     file.bool(this.fireAtWill);
/* 155 */     file.s(this.ammoI);
/* 156 */     file.bool(this.mustering);
/* 157 */     file.bool(this.mopping);
/* 158 */     file.bool(this.shouldFire);
/* 159 */     file.bool(this.shouldNotMoveToFire);
/* 160 */     file.bool(this.charging);
/* 161 */     file.bool(this.shouldbreak);
/* 162 */     file.bool(this.chargeSpeed);
/* 163 */     file.f(getPower());
/* 164 */     file.d(this.aref);
/* 165 */     file.d(this.speed);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/* 169 */     this.running = file.bool();
/* 170 */     this.guard = file.bool();
/* 171 */     this.formation = (DIV_FORMATION)DIV_FORMATION.all.get(file.b());
/* 172 */     this.fireAtWill = file.bool();
/* 173 */     this.ammoI = file.s();
/* 174 */     this.mustering = file.bool();
/* 175 */     this.mopping = file.bool();
/* 176 */     this.shouldFire = file.bool();
/* 177 */     this.shouldNotMoveToFire = file.bool();
/* 178 */     this.charging = file.bool();
/* 179 */     this.shouldbreak = file.bool();
/* 180 */     this.chargeSpeed = file.bool();
/* 181 */     this.power = file.f();
/* 182 */     this.aref = file.d();
/* 183 */     this.speed = file.d();
/*     */   }
/*     */   
/*     */   public void clear() {
/* 187 */     this.running = false;
/* 188 */     this.guard = true;
/* 189 */     this.fireAtWill = false;
/* 190 */     this.formation = DIV_FORMATION.LOOSE;
/* 191 */     this.ammoI = 0;
/* 192 */     this.mustering = false;
/* 193 */     this.mopping = false;
/* 194 */     this.shouldFire = false;
/* 195 */     this.shouldNotMoveToFire = false;
/* 196 */     this.charging = false;
/* 197 */     this.shouldbreak = false;
/* 198 */     this.chargeSpeed = false;
/* 199 */     this.power = 0.0F;
/* 200 */     this.speed = 25.6D;
/*     */   }
/*     */   
/*     */   public float getPower() {
/* 204 */     return this.power;
/*     */   }
/*     */   
/*     */   public double speed() {
/* 208 */     return this.speed;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\setting\DivSettings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */