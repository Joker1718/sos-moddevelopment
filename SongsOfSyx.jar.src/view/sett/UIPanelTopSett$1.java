/*     */ package view.sett;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.HCLASSES;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.SettUI;
/*     */ import view.ui.top.UIPanelTopButtL;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPanelTopButtL
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/*  68 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected double valueNext() {
/*  72 */     return value();
/*     */   }
/*     */ 
/*     */   
/*     */   protected double value() {
/*  77 */     return 1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getNumber() {
/*  82 */     return GAME.NOBLE().active().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/*  87 */     text.title((HCLASSES.NOBLE()).names);
/*  88 */     text.text((HCLASSES.NOBLE()).desc);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isActive() {
/*  93 */     return (getNumber() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/*  98 */     selectedSet((ui.nobles != null && (VIEW.s()).panels.added((ISidePanel)ui.nobles)));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 103 */     if (ui.nobles != null)
/* 104 */       (VIEW.s()).panels.add((ISidePanel)ui.nobles, true); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\UIPanelTopSett$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */