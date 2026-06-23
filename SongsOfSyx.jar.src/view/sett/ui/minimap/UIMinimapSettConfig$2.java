/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIMinimapSettConfig
/*     */ {
/*     */   public COLOR col(ENTITY e) {
/* 137 */     return NORMAL.col(e);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean halfEnts() {
/* 143 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean room(RoomBlueprintIns<?> b) {
/* 148 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderGrowable() {
/* 153 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderMinable() {
/* 158 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderPack() {
/* 163 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public OPACITY shade() {
/* 168 */     return OPACITY.O25;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderDivs() {
/* 173 */     return (KEYS.BATTLE()).SHOW_DIVISIONS.isPressed();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapSettConfig$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */