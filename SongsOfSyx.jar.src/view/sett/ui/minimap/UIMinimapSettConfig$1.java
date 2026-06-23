/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.stats.STATS;
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
/*     */ class null
/*     */   extends UIMinimapSettConfig
/*     */ {
/*     */   public COLOR col(ENTITY e) {
/*  80 */     if (e instanceof Humanoid) {
/*  81 */       Humanoid a = (Humanoid)e;
/*  82 */       if (a.indu().hostile()) {
/*  83 */         if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 0)
/*  84 */           return colHostile; 
/*  85 */         return colHostileRout;
/*  86 */       }  if (a.division() != null) {
/*  87 */         if (a.division().settings().mustering())
/*  88 */           return colMustered; 
/*  89 */         return colNormal;
/*     */       } 
/*  91 */       return colAnimal;
/*     */     } 
/*  93 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean halfEnts() {
/*  99 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean room(RoomBlueprintIns<?> b) {
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderGrowable() {
/* 109 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderMinable() {
/* 114 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderPack() {
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public OPACITY shade() {
/* 124 */     return OPACITY.O25;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderDivs() {
/* 129 */     return (KEYS.BATTLE()).SHOW_DIVISIONS.isPressed();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapSettConfig$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */