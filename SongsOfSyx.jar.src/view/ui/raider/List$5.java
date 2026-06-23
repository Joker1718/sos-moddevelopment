/*     */ package view.ui.raider;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.raiding.Raider;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.gui.table.GScrollRows;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GScrollRows
/*     */ {
/*     */   null(Iterable<? extends RENDEROBJ> $anonymous0, int $anonymous1) {
/*  93 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   protected boolean passesFilter(int i, RENDEROBJ o) {
/*  97 */     if (List.this.all)
/*  98 */       return true; 
/*  99 */     Raider rr = (Raider)GAME.raiders().ALL().get(i);
/* 100 */     if (UIRaiding.statsVisible(rr))
/* 101 */       return true; 
/* 102 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\raider\List$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */