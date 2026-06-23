/*     */ package view.ui.div;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.STATS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends EntityIterator.Humans
/*     */ {
/*     */   protected boolean processAndShouldBreakH(Humanoid h, int ie) {
/* 301 */     if ((h.indu().clas()).player)
/* 302 */       count(h); 
/* 303 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private void count(Humanoid h) {
/* 308 */     Div div = (Div)(STATS.BATTLE()).DIV.get(h);
/* 309 */     if (div != null) {
/* 310 */       if (h.indu().hType() == HTYPES.RECRUIT()) {
/* 311 */         UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] + 1;
/* 312 */         UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */       } else {
/* 314 */         for (ROOM_M_TRAINER<?> tra : (Iterable<ROOM_M_TRAINER<?>>)ROOM_M_TRAINER.ALL()) {
/* 315 */           if (tra.training().shouldTrain(h.indu(), div.info.training(tra.training()), false)) {
/* 316 */             UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } else {
/* 323 */       div = (Div)(STATS.BATTLE()).RECRUIT.get(h);
/* 324 */       if (div != null && 
/* 325 */         h.indu().hType() == HTYPES.RECRUIT()) {
/* 326 */         UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] + 1;
/* 327 */         UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardSett$TrainingSpec$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */