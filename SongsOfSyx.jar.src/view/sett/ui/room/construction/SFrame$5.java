/*     */ package view.sett.ui.room.construction;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
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
/*     */ class null
/*     */   extends GButt.Panel
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  90 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void clickA() {
/*  94 */     CharSequence s = (SETT.ROOMS()).placement.placer.createProblem();
/*  95 */     if (s != null) {
/*  96 */       if ((SETT.ROOMS()).placement.placer.createProblemItem() != null) {
/*  97 */         SFrame.this.state.problemGroup = (SETT.ROOMS()).placement.placer.createProblemItem();
/*  98 */         SFrame.this.state.problemTimer = VIEW.renderSecond() + 4.0D;
/*  99 */       }  if ((SETT.ROOMS()).placement.placer.createProblemWalls()) {
/* 100 */         SFrame.this.state.problemTimer = VIEW.renderSecond() + 4.0D;
/* 101 */         SFrame.this.state.problemneedDoor = true;
/*     */       } 
/*     */     } else {
/* 104 */       CharSequence warn = (SETT.ROOMS()).placement.placer.createWarning();
/* 105 */       if (warn != null) {
/* 106 */         (VIEW.inters()).yesNo.activate(warn, create, ACTION.NOP, true);
/*     */       }
/* 108 */       else if (!SFrame.this.message && SFrame.this.state.b.constructor().mustBeIndoors() && SFrame.this.state.placement.placer.cost().support() > 0.0D) {
/* 109 */         SFrame.this.message = true;
/* 110 */         (VIEW.inters()).yesNo.activate(SFrame.this.sexpensive, create, ACTION.NOP, true);
/*     */       } else {
/*     */         
/* 113 */         create.exe();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 121 */     text.title(cc);
/* 122 */     CharSequence s = (SETT.ROOMS()).placement.placer.createProblem();
/* 123 */     if (s != null) {
/* 124 */       GBox b = (GBox)text;
/* 125 */       b.error(s);
/*     */     } 
/* 127 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SFrame$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */