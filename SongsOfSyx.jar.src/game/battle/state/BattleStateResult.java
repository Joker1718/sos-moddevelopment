/*     */ package game.battle.state;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import init.race.RACES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import world.battle.spec.BATTLE_RESULT;
/*     */ 
/*     */ 
/*     */ public final class BattleStateResult
/*     */ {
/*  21 */   public final Induvidual[][] playerSurvivors = new Induvidual[(Config.battle()).DIVISIONS_PER_ARMY][];
/*  22 */   public final int[] enemySurvivors = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*  23 */   public final int[] enemyCaptured = Alloc.ii(RACES.all().size());
/*     */   public final BATTLE_RESULT result;
/*     */   public final int playerLosses;
/*     */   public final int enemyLosses;
/*     */   
/*     */   BattleStateResult(BATTLE_RESULT result, int enemydead, int playerdead) {
/*  29 */     this.result = result;
/*  30 */     int[] count = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*  31 */     this.playerLosses = playerdead;
/*  32 */     this.enemyLosses = enemydead;
/*  33 */     if (result != BATTLE_RESULT.VICTORY) {
/*  34 */       int losses = (int)Math.ceil(GAME.ARMIES().enemy().men() * 0.4D);
/*  35 */       double dlosses = losses / (GAME.ARMIES().player().men() + 1.0D);
/*  36 */       for (Div d : GAME.ARMIES().player().divisions()) {
/*  37 */         int am = (int)((STATS.BATTLE()).DIV.stat().div().get(d) * dlosses);
/*  38 */         if (d.status().isFighting())
/*  39 */           am = (int)(am + (STATS.BATTLE()).DIV.stat().div().get(d) * 0.75D); 
/*  40 */         am = CLAMP.i(am, 0, (STATS.BATTLE()).DIV.stat().div().get(d));
/*  41 */         count[d.indexArmy()] = am;
/*     */       } 
/*  43 */       for (Div d : GAME.ARMIES().player().divisions()) {
/*  44 */         this.playerSurvivors[d.indexArmy()] = new Induvidual[(STATS.BATTLE()).DIV.stat().div().get(d) - count[d.indexArmy()]];
/*  45 */         count[d.indexArmy()] = 0;
/*     */       } 
/*     */     } else {
/*  48 */       for (Div d : GAME.ARMIES().player().divisions()) {
/*  49 */         this.playerSurvivors[d.indexArmy()] = new Induvidual[(STATS.BATTLE()).DIV.stat().div().get(d)];
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  55 */     ENTITY[] es = SETT.ENTITIES().getAllEnts(); byte b; int i; ENTITY[] arrayOfENTITY1;
/*  56 */     for (i = (arrayOfENTITY1 = es).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY1[b];
/*  57 */       if (e instanceof Humanoid) {
/*  58 */         Humanoid h = (Humanoid)e;
/*  59 */         Div d = (Div)(STATS.BATTLE()).DIV.get(h);
/*  60 */         if (d == null) {
/*  61 */           if (h.indu().hType() == HTYPES.ENEMY()) {
/*  62 */             this.enemyCaptured[(h.race()).index] = this.enemyCaptured[(h.race()).index] + 1;
/*     */           
/*     */           }
/*     */         }
/*  66 */         else if (d.index() >= (Config.battle()).DIVISIONS_PER_ARMY) {
/*     */           
/*  68 */           if (result == BATTLE_RESULT.VICTORY && RND.rBoolean()) {
/*  69 */             this.enemyCaptured[(h.race()).index] = this.enemyCaptured[(h.race()).index] + 1;
/*     */           } else {
/*  71 */             this.enemySurvivors[d.indexArmy()] = this.enemySurvivors[d.indexArmy()] + 1;
/*     */           }
/*     */         
/*     */         }
/*  75 */         else if (count[d.indexArmy()] < (this.playerSurvivors[d.indexArmy()]).length) {
/*     */ 
/*     */           
/*  78 */           count[d.indexArmy()] = count[d.indexArmy()] + 1; this.playerSurvivors[d.indexArmy()][count[d.indexArmy()]] = h.indu();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*     */       b++; }
/*     */ 
/*     */     
/*  86 */     wash();
/*     */   }
/*     */   
/*     */   private void wash() {
/*  90 */     for (Div d : GAME.ARMIES().player().divisions()) {
/*  91 */       wash(d);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void wash(Div div) {
/*  97 */     Induvidual[] ins = this.playerSurvivors[div.indexArmy()];
/*  98 */     int am = 0; byte b; int i; Induvidual[] arrayOfInduvidual1;
/*  99 */     for (i = (arrayOfInduvidual1 = ins).length, b = 0; b < i; ) { Induvidual ii = arrayOfInduvidual1[b];
/* 100 */       if (ii != null)
/* 101 */         am++; 
/*     */       b++; }
/*     */     
/* 104 */     if (am == ins.length) {
/*     */       return;
/*     */     }
/* 107 */     Induvidual[] nins = new Induvidual[ins.length];
/* 108 */     am = 0;
/* 109 */     System.err.println("BattleResult");
/* 110 */     System.err.println(this.result);
/* 111 */     System.err.println(div.indexArmy());
/* 112 */     System.err.println((STATS.BATTLE()).DIV.stat().div().get(div));
/*     */     
/* 114 */     System.err.println("" + ins.length + " " + ins.length);
/*     */     
/*     */     Induvidual[] arrayOfInduvidual2;
/* 117 */     for (int j = (arrayOfInduvidual2 = ins).length; i < j; ) { Induvidual ii = arrayOfInduvidual2[i];
/* 118 */       if (ii != null)
/* 119 */         nins[am++] = ii; 
/*     */       i++; }
/*     */     
/* 122 */     this.playerSurvivors[div.indexArmy()] = nins;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\state\BattleStateResult.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */