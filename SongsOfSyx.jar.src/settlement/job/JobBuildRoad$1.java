/*     */ package settlement.job;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GButt.Panel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  98 */     super($anonymous0);
/*     */   }
/*     */   protected void clickA() {
/* 101 */     JobBuildRoad.this.showRoads = !JobBuildRoad.this.showRoads;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 106 */     selectedSet(JobBuildRoad.this.showRoads);
/* 107 */     if (JobBuildRoad.this.showRoads) {
/* 108 */       (SETT.OVERLAY()).ROADING.add();
/*     */     }
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 113 */     text.title((SETT.OVERLAY()).ROADING.name);
/* 114 */     text.text((SETT.OVERLAY()).ROADING.desc);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\JobBuildRoad$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */