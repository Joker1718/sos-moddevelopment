/*     */ package view.ui.div;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import init.type.HTYPES;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.Alloc;
/*     */ import world.army.AD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class TrainingSpec
/*     */ {
/* 292 */   private int upI = -1;
/*     */   
/* 294 */   private final int[] needsTraining = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/* 295 */   private final int[] training = Alloc.ii((Config.battle()).DIVISIONS_PER_ARMY);
/*     */   
/* 297 */   private final EntityIterator.Humans iter = new EntityIterator.Humans()
/*     */     {
/*     */       protected boolean processAndShouldBreakH(Humanoid h, int ie)
/*     */       {
/* 301 */         if ((h.indu().clas()).player)
/* 302 */           count(h); 
/* 303 */         return false;
/*     */       }
/*     */ 
/*     */       
/*     */       private void count(Humanoid h) {
/* 308 */         Div div = (Div)(STATS.BATTLE()).DIV.get(h);
/* 309 */         if (div != null) {
/* 310 */           if (h.indu().hType() == HTYPES.RECRUIT()) {
/* 311 */             UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] + 1;
/* 312 */             UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */           } else {
/* 314 */             for (ROOM_M_TRAINER<?> tra : (Iterable<ROOM_M_TRAINER<?>>)ROOM_M_TRAINER.ALL()) {
/* 315 */               if (tra.training().shouldTrain(h.indu(), div.info.training(tra.training()), false)) {
/* 316 */                 UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } else {
/* 323 */           div = (Div)(STATS.BATTLE()).RECRUIT.get(h);
/* 324 */           if (div != null && 
/* 325 */             h.indu().hType() == HTYPES.RECRUIT()) {
/* 326 */             UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.training[div.indexArmy()] + 1;
/* 327 */             UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] = UIDivCardSett.TrainingSpec.this.needsTraining[div.indexArmy()] + 1;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void init() {
/* 344 */     if (GAME.updateI() == this.upI) {
/*     */       return;
/*     */     }
/* 347 */     for (int di = 0; di < GAME.ARMIES().player().divisions().size(); di++) {
/* 348 */       Div d = (Div)GAME.ARMIES().player().divisions().get(di);
/*     */       
/* 350 */       this.needsTraining[di] = d.info.men() - (STATS.BATTLE()).DIV.stat().div().get(d) + (STATS.BATTLE()).RECRUIT.inDiv(d);
/* 351 */       if (AD.cityDivs().attachedArmy(d) != null) {
/* 352 */         this.needsTraining[di] = this.needsTraining[di] - AD.cityDivs().get(d).men();
/*     */       }
/*     */     } 
/*     */     
/* 356 */     Arrays.fill(this.training, 0);
/* 357 */     this.iter.iterate();
/* 358 */     this.upI = GAME.updateI();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardSett$TrainingSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */