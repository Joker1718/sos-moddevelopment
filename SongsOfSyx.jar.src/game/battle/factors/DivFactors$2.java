/*     */ package game.battle.factors;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.status.DivStatus;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends IUpdater
/*     */ {
/*     */   private double speed;
/*     */   private final ArrayListGrower<DivFactors.DataDiv> player;
/*     */   
/*     */   null(int $anonymous0, double $anonymous1) {
/*  60 */     super($anonymous0, $anonymous1);
/*     */     
/*  62 */     this.speed = (Config.battle()).MORALE_HOLDOUT / 120.0D;
/*     */     
/*  64 */     this.player = new ArrayListGrower();
/*     */     
/*  66 */     this.player.add(paramDivFactors.casulties);
/*  67 */     this.player.add(paramDivFactors.routing);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(int i, double ds) {
/*  73 */     Div div = GAME.ARMIES().division((short)i);
/*  74 */     if (div.men() == 0 || (GAME.ARMIES().enemy().men() == 0 && !div.army().player())) {
/*  75 */       for (DivFactors.DataDiv d : DivFactors.this.datas) {
/*  76 */         if (d != DivFactors.this.kills) {
/*  77 */           d.setD(div, 0.0D);
/*     */         }
/*     */       } 
/*     */     } else {
/*  81 */       if (GAME.ARMIES().enemy().men() == 0) {
/*     */         
/*  83 */         double w = DivFactors.this.weariness.getD(div);
/*  84 */         w -= ds * this.speed;
/*  85 */         w = CLAMP.d(w, 0.0D, 1.0E7D);
/*  86 */         DivFactors.this.weariness.setD(div, w);
/*  87 */         if (DivFactors.this.weariness.getD(div) == 0.0D) {
/*  88 */           DivFactors.this.kills.setD(div, 0.0D);
/*     */         }
/*     */ 
/*     */         
/*  92 */         for (DivFactors.DataDiv dataDiv : this.player) {
/*  93 */           double am = dataDiv.getD(div) - 10.0D * ds * TIME.secondsPerDayI();
/*  94 */           am = CLAMP.d(am, 0.0D, 10000.0D);
/*  95 */           dataDiv.setD(div, am);
/*     */         } 
/*     */       } else {
/*  98 */         DivStatus s = div.status();
/*  99 */         double w = DivFactors.this.weariness.getD(div);
/*     */         
/* 101 */         double cc = s.engagements() / div.men();
/* 102 */         if (cc > 0.0D) {
/* 103 */           w += ds * cc * this.speed;
/*     */         }
/* 105 */         w = CLAMP.d(w, 0.0D, 1.0E7D);
/* 106 */         DivFactors.this.weariness.setD(div, w);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 111 */       double d = DivFactors.this.projectiles.getD(div);
/* 112 */       d -= div.men() * ds / 10.0D;
/* 113 */       d = CLAMP.d(d, 0.0D, (div.men() * 4));
/* 114 */       DivFactors.this.projectiles.setD(div, d);
/* 115 */       DivFactors.this.set(div, ds);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\factors\DivFactors$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */