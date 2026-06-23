/*     */ package world.battle;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import world.battle.spec.WBattleUnit;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements WBattleUnit
/*     */ {
/*     */   public CharSequence name() {
/*  84 */     return (CharSequence)reg.info.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/*  89 */     return (RD.MILITARY()).garrison.get(reg);
/*     */   }
/*     */ 
/*     */   
/*     */   public int lossesRetreat() {
/*  94 */     return men();
/*     */   }
/*     */ 
/*     */   
/*     */   public int losses() {
/*  99 */     return men();
/*     */   }
/*     */ 
/*     */   
/*     */   public SPRITE icon() {
/* 104 */     return (SPRITE)(UI.icons()).m.building;
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box) {
/* 109 */     box.title(Dic.¤¤Region);
/*     */   }
/*     */ 
/*     */   
/*     */   public double defences() {
/* 114 */     return (RD.MILITARY()).fort.getD(reg);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Tests$3$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */