/*     */ package world.army;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.util.DIV_SETTING;
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.battle.util.DivGeneration;
/*     */ import game.battle.util.DivType;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.Faction;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.Dic;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ public final class WDivRegional
/*     */   extends ADDiv {
/*  31 */   public static int DAYS_TO_TRAIN = 3;
/*  32 */   private static final COLOR col = (COLOR)COLOR.ORANGE100.makeSaturated(0.5D).shade(0.75D);
/*     */   
/*     */   static final int type = 0;
/*     */   private short men;
/*     */   private short menTarget;
/*     */   private short ri;
/*  38 */   private final float[] training = new float[(STATS.BATTLE()).TRAINING_ALL.size()];
/*  39 */   private final byte[] trainingTarget = Alloc.bb((STATS.BATTLE()).TRAINING_ALL.size());
/*     */   private float experience;
/*     */   private byte trainingDay;
/*     */   private short bannerI;
/*  43 */   private final byte[] targets = Alloc.bb(STATS.EQUIP().BATTLE_ALL().size());
/*     */   public final DIV_SPEC.DIV_SPECE target;
/*     */   
/*     */   WDivRegional(int index) {
/*  47 */     super(index);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 325 */     this.target = new DIV_SPEC.DIV_SPECE()
/*     */       {
/*     */         public double training(StatsBattle.StatTraining tr)
/*     */         {
/* 329 */           return WDivRegional.this.trainingTarget[tr.tIndex] * 0.06666666666666667D;
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 334 */           return WDivRegional.this.menTarget;
/*     */         }
/*     */ 
/*     */         
/*     */         public double equip(EquipBattle e) {
/* 339 */           return WDivRegional.this.targets[e.indexMilitary()] / e.equipMax;
/*     */         }
/*     */ 
/*     */         
/*     */         public void trainingSet(StatsBattle.StatTraining tr, double d) {
/* 344 */           WDivRegional.this.trainingTarget[tr.tIndex] = (byte)(int)Math.round(15.0D * CLAMP.d(d, 0.0D, 1.0D));
/*     */         }
/*     */ 
/*     */         
/*     */         public void equipSet(EquipBattle tr, double am) {
/* 349 */           WDivRegional.this.report(-1);
/* 350 */           WDivRegional.this.targets[tr.indexMilitary()] = (byte)(int)Math.round(am * tr.max());
/* 351 */           WDivRegional.this.report(1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void menSet(int am) {
/* 357 */           WDivRegional.this.report(-1);
/* 358 */           WDivRegional.this.menTarget = (short)CLAMP.i(am, 0, (Config.battle()).MEN_PER_DIVISION);
/* 359 */           WDivRegional.this.trainingDay = 0;
/* 360 */           WDivRegional.this.men = (short)CLAMP.i(WDivRegional.this.men, 0, WDivRegional.this.menTarget);
/* 361 */           WDivRegional.this.report(1);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public double experience() {
/* 367 */           return WDivRegional.this.experience;
/*     */         }
/*     */ 
/*     */         
/*     */         public Faction faction() {
/* 372 */           return (WDivRegional.this.army() == null) ? null : WDivRegional.this.army().faction();
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence name() {
/* 377 */           return WDivRegional.this.name();
/*     */         }
/*     */ 
/*     */         
/*     */         public int bannerI() {
/* 382 */           return WDivRegional.this.bannerI();
/*     */         }
/*     */ 
/*     */         
/*     */         public Race race() {
/* 387 */           return WDivRegional.this.race();
/*     */         }
/*     */ 
/*     */         
/*     */         public void raceSet(Race race) {
/* 392 */           WDivRegional.this.report(-1);
/* 393 */           WDivRegional.this.ri = (short)race.index;
/* 394 */           WDivRegional.this.report(1);
/*     */         }
/*     */ 
/*     */         
/*     */         public void experienceSet(double experience) {
/* 399 */           WDivRegional.this.experience = (float)experience;
/*     */         }
/*     */ 
/*     */         
/*     */         public Str nameE() {
/* 404 */           return null;
/*     */         }
/*     */         
/*     */         public void bannerISet(int bannerI)
/*     */         {
/* 409 */           WDivRegional.this.bannerI = (short)bannerI;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void factionSet(Faction faction) {}
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DIV_SETTING target() {
/* 423 */     return (DIV_SETTING)this.target;
/*     */   }
/*     */   
/*     */   public void init(Race race, double amount, WArmy a) {
/*     */     this.menTarget = (short)CLAMP.i((int)Math.round(amount * (Config.battle()).MEN_PER_DIVISION), 0, (Config.battle()).MEN_PER_DIVISION);
/*     */     this.men = 0;
/*     */     this.ri = (short)race.index;
/*     */     Arrays.fill(this.training, 0.0F);
/*     */     Arrays.fill(this.trainingTarget, (byte)0);
/*     */     this.experience = 0.0F;
/*     */     this.trainingDay = 0;
/*     */     Arrays.fill(this.targets, (byte)0);
/*     */     bannerSet(RND.rInt((GAME.ARMIES()).banners.size()));
/*     */     reassign(a);
/*     */   }
/*     */   
/*     */   public void randomize(double training, double gear) {
/*     */     report(-1);
/*     */     DivType type = (GAME.battle()).types.rnd(race(), faction(), RND.rFloat());
/*     */     for (EquipBattle m : STATS.EQUIP().BATTLE_ALL())
/*     */       this.targets[m.indexMilitary()] = (byte)(int)CLAMP.d(type.equip(m) * gear * m.max(), 0.0D, m.max()); 
/*     */     for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL) {
/*     */       this.training[t.tIndex] = (byte)(int)CLAMP.d(type.training(t) * training * 15.0D, 0.0D, 15.0D);
/*     */       this.trainingTarget[t.tIndex] = (byte)(int)Math.round(15.0D * CLAMP.d(type.training(t) * training, 0.0D, 1.0D));
/*     */     } 
/*     */     bannerSet(RND.rInt((GAME.ARMIES()).banners.size()));
/*     */     report(1);
/*     */   }
/*     */   
/*     */   public void copyFrom(DIV_SPEC div) {
/*     */     report(-1);
/*     */     for (EquipBattle m : STATS.EQUIP().BATTLE_ALL())
/*     */       this.targets[m.indexMilitary()] = (byte)div.equipI(m); 
/*     */     for (StatsBattle.StatTraining t : (STATS.BATTLE()).TRAINING_ALL)
/*     */       this.training[t.tIndex] = ((byte)(int)div.training(t) * 15); 
/*     */     report(1);
/*     */   }
/*     */   
/*     */   public void save(FilePutter file) {
/*     */     super.save(file);
/*     */     file.s(this.men);
/*     */     file.s(this.menTarget);
/*     */     file.s(this.ri);
/*     */     file.bs(this.trainingTarget);
/*     */     file.fs(this.training);
/*     */     file.f(this.experience);
/*     */     file.b(this.trainingDay);
/*     */     file.s(this.bannerI);
/*     */     file.bs(this.targets);
/*     */   }
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*     */     super.load(file);
/*     */     this.men = file.s();
/*     */     this.menTarget = file.s();
/*     */     this.ri = file.s();
/*     */     file.bs(this.trainingTarget);
/*     */     file.fs(this.training);
/*     */     this.experience = file.f();
/*     */     this.trainingDay = file.b();
/*     */     this.bannerI = file.s();
/*     */     file.bs(this.targets);
/*     */   }
/*     */   
/*     */   public int men() {
/*     */     return this.men;
/*     */   }
/*     */   
/*     */   public int menTarget() {
/*     */     return this.menTarget;
/*     */   }
/*     */   
/*     */   public void resolve(Induvidual[] hs) {
/*     */     double exp = 0.0D;
/*     */     byte b;
/*     */     int i;
/*     */     Induvidual[] arrayOfInduvidual;
/*     */     for (i = (arrayOfInduvidual = hs).length, b = 0; b < i; ) {
/*     */       Induvidual induvidual = arrayOfInduvidual[b];
/*     */       exp += (STATS.BATTLE()).COMBAT_EXPERIENCE.indu().getD(induvidual);
/*     */       b++;
/*     */     } 
/*     */     if (hs.length > 0)
/*     */       exp /= hs.length; 
/*     */     resolve(hs.length, exp);
/*     */   }
/*     */   
/*     */   public void resolve(int surviviors, double experiencePerMan) {
/*     */     int death = this.men - surviviors;
/*     */     menSet(surviviors);
/*     */     AD.conscripts().kill(race(), faction(), death);
/*     */     report(-1);
/*     */     this.experience = (float)CLAMP.d(experiencePerMan, 0.0D, 1.0D);
/*     */     report(1);
/*     */   }
/*     */   
/*     */   public void menSet(int amount) {
/*     */     report(-1);
/*     */     double exp = (this.experience * this.men);
/*     */     amount = CLAMP.i(amount, 0, (Config.battle()).MEN_PER_DIVISION);
/*     */     this.men = (short)amount;
/*     */     this.experience = 0.0F;
/*     */     if (this.men > 0)
/*     */       this.experience = (float)CLAMP.d(exp / this.men, 0.0D, 1.0D); 
/*     */     report(1);
/*     */   }
/*     */   
/*     */   protected void armyChange(WArmy old, WArmy newW) {
/*     */     if (newW == null)
/*     */       AD.regional().retire(this); 
/*     */   }
/*     */   
/*     */   public Race race() {
/*     */     return (Race)RACES.all().get(this.ri);
/*     */   }
/*     */   
/*     */   public double training(StatsBattle.StatTraining tr) {
/*     */     return this.training[tr.tIndex] * 0.06666666666666667D;
/*     */   }
/*     */   
/*     */   public double equip(EquipBattle e) {
/*     */     if (army() == null)
/*     */       return 0.0D; 
/*     */     return AD.supplies().get(e).amountValue(army()) * this.targets[e.indexMilitary()] / e.equipMax;
/*     */   }
/*     */   
/*     */   public void equipTargetset(EquipBattle e, int t) {
/*     */     report(-1);
/*     */     this.targets[e.indexMilitary()] = (byte)t;
/*     */     report(1);
/*     */   }
/*     */   
/*     */   public double experience() {
/*     */     return this.experience;
/*     */   }
/*     */   
/*     */   public int daysUntilMenArrives() {
/*     */     return DAYS_TO_TRAIN - this.trainingDay;
/*     */   }
/*     */   
/*     */   public void updateDay() {
/*     */     if (!army().recruiting())
/*     */       return; 
/*     */     if (men() < menTarget()) {
/*     */       int ava = AD.conscripts().canTrainI(race(), faction());
/*     */       if (ava > 0) {
/*     */         this.trainingDay = (byte)(this.trainingDay + 1);
/*     */         if (this.trainingDay >= DAYS_TO_TRAIN) {
/*     */           this.trainingDay = 0;
/*     */           int men = menTarget() - men();
/*     */           if (faction() != null)
/*     */             men = CLAMP.i(men, 0, ava); 
/*     */           if (men > 0) {
/*     */             double vv = men();
/*     */             vv /= (men() + men);
/*     */             menSet(men() + men);
/*     */             report(-1);
/*     */             this.experience = (float)(this.experience * vv);
/*     */             for (int i = 0; i < this.training.length; i++)
/*     */               this.training[i] = (float)CLAMP.d(this.training[i] * vv, 0.0D, 15.0D); 
/*     */             report(1);
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } else {
/*     */         this.trainingDay = 0;
/*     */       } 
/*     */     } 
/*     */     for (int ti = 0; ti < (STATS.BATTLE()).TRAINING_ALL.size(); ti++) {
/*     */       StatsBattle.StatTraining st = (StatsBattle.StatTraining)(STATS.BATTLE()).TRAINING_ALL.get(ti);
/*     */       double tr = this.training[ti];
/*     */       double ta = this.trainingTarget[ti];
/*     */       if (tr < ta) {
/*     */         double bo = (faction() == null) ? (st.room.bonus()).baseValue : st.room.bonus().get((BOOSTABLE_O)faction());
/*     */         double n = tr + 11.25D * bo / st.room.TRAINING_DAYS;
/*     */         n = CLAMP.d(n, 0.0D, ta);
/*     */         report(-1);
/*     */         this.training[ti] = (float)n;
/*     */         report(1);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int trainingDays(StatsBattle.StatTraining tr, double delta, Faction faction) {
/*     */     if (delta <= 0.0D)
/*     */       return 0; 
/*     */     double div = 0.75D;
/*     */     if (faction != null)
/*     */       div *= tr.room.bonus().get((BOOSTABLE_O)faction); 
/*     */     return (int)Math.ceil(delta * tr.room.TRAINING_DAYS / 0.75D * div);
/*     */   }
/*     */   
/*     */   public static double tD(StatsBattle.StatTraining tr, double delta, Faction faction) {
/*     */     return delta * tr.room.TRAINING_DAYS / 0.75D * tr.room.bonus().get((BOOSTABLE_O)faction);
/*     */   }
/*     */   
/*     */   public int type() {
/*     */     return 0;
/*     */   }
/*     */   
/*     */   public CharSequence name() {
/*     */     return (CharSequence)Str.TMP.clear().add(Dic.¤¤Regional).insert(0, Dic.¤¤Division);
/*     */   }
/*     */   
/*     */   public boolean needSupplies() {
/*     */     return true;
/*     */   }
/*     */   
/*     */   public DivGeneration generate() {
/*     */     return new DivGeneration(this, (DIV_SETTING)this.target);
/*     */   }
/*     */   
/*     */   public boolean needConscripts() {
/*     */     return true;
/*     */   }
/*     */   
/*     */   public int bannerI() {
/*     */     return this.bannerI;
/*     */   }
/*     */   
/*     */   public void bannerSet(int bi) {
/*     */     this.bannerI = (short)bi;
/*     */   }
/*     */   
/*     */   public COLOR color() {
/*     */     return col;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDivRegional.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */