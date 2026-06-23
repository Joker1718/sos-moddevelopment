/*     */ package world.battle;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import world.WORLD;
/*     */ import world.battle.spec.WBattleSpec;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends PlacableSimpleTile
/*     */ {
/*     */   null(CharSequence $anonymous0) {
/* 129 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty) {
/* 134 */     final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */     
/* 136 */     WBattleUnit ss = new WBattleUnit()
/*     */       {
/*     */         public CharSequence name()
/*     */         {
/* 140 */           return (CharSequence)reg.info.name();
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 145 */           return (RD.MILITARY()).garrison.get(reg);
/*     */         }
/*     */ 
/*     */         
/*     */         public int lossesRetreat() {
/* 150 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int losses() {
/* 155 */           return (int)(men() * 0.5D);
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE icon() {
/* 160 */           return (SPRITE)(UI.icons()).m.building;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX box) {
/* 165 */           box.title(Dic.¤¤Region);
/*     */         }
/*     */ 
/*     */         
/*     */         public double defences() {
/* 170 */           return 0.0D;
/*     */         }
/*     */       };
/*     */     
/* 174 */     WBattleSpec s = Tests.this.spec(tx, ty, ss, null);
/* 175 */     (VIEW.world()).UI.battle.battleSally(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 181 */     return WORLD.REGIONS().centreTile().is(tx, ty) ? null : E;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Tests$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */