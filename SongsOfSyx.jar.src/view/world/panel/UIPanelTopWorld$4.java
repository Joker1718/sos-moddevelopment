/*     */ package view.world.panel;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.ui.top.UIPanelTopButtS;
/*     */ import world.WORLD;
/*     */ import world.entity.haven.WHavenType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPanelTopButtS
/*     */ {
/*     */   null(SPRITE $anonymous0) {
/* 249 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected double valueNext() {
/* 254 */     return -1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double value() {
/* 259 */     return -1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean isActive() {
/* 265 */     return (getNumber() > 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getNumber() {
/* 270 */     int am = 0;
/* 271 */     for (WHavenType r : (WORLD.camps()).types)
/* 272 */       am += WORLD.camps().camps((Faction)FACTIONS.player(), r); 
/* 273 */     return am;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void renAction() {
/* 278 */     selectedSet((VIEW.world()).panels.added((ISidePanel)(VIEW.world()).UI.camps));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 283 */     if ((VIEW.world()).panels.added((ISidePanel)(VIEW.world()).UI.camps)) {
/* 284 */       (VIEW.world()).panels.remove((ISidePanel)(VIEW.world()).UI.camps);
/*     */     } else {
/* 286 */       (VIEW.world()).panels.add((ISidePanel)(VIEW.world()).UI.camps, true);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 291 */     GBox b = (GBox)text;
/* 292 */     b.add((WORLD.camps()).info);
/*     */ 
/*     */     
/* 295 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIPanelTopWorld$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */