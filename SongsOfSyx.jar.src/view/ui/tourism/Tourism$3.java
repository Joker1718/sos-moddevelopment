/*     */ package view.ui.tourism;
/*     */ 
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 110 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 115 */     ENTITY[] all = SETT.ENTITIES().getAllEnts();
/* 116 */     int mm = Tourism.this.hovered + 1;
/* 117 */     for (int i = 1; i <= all.length; i++) {
/* 118 */       int ei = MATH.mod(i + mm, all.length);
/* 119 */       ENTITY e = all[ei];
/* 120 */       if (e instanceof Humanoid) {
/* 121 */         Humanoid a = (Humanoid)e;
/* 122 */         if (a.indu().hType() == HTYPES.TOURIST()) {
/* 123 */           Tourism.this.hovered = ei;
/* 124 */           (VIEW.UI()).manager.close();
/* 125 */           (VIEW.s().getWindow()).centerer.set(a.body().cX(), a.body().cY());
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/* 130 */     Tourism.this.hovered = -1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 135 */     activeSet((STATS.POP().pop(HTYPES.TOURIST()) > 0));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\tourism\Tourism$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */