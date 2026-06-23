/*     */ package util.text;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends Inserter<Induvidual>.II
/*     */ {
/*     */   null(Inserter paramInserter, String $anonymous0) {
/*  96 */     super($anonymous0);
/*     */   }
/*     */   public void set(Induvidual a, Str str) {
/*  99 */     double def = (BOOSTABLES.PHYSICS()).HEALTH.baseValue;
/* 100 */     if ((BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)a) < def) {
/* 101 */       str.add(InsertIndu.¤¤poor);
/* 102 */     } else if ((BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)a) < 1.5D) {
/* 103 */       str.add(InsertIndu.¤¤good);
/*     */     } else {
/* 105 */       str.add(InsertIndu.¤¤excellent);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertIndu$8.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */