/*     */ package world.battle;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PlacableSimpleTile;
/*     */ import world.WORLD;
/*     */ import world.battle.spec.WBattleSiege;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 185 */     super($anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty) {
/* 190 */     final Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */     
/* 192 */     WBattleUnit ss = new WBattleUnit()
/*     */       {
/*     */         public CharSequence name()
/*     */         {
/* 196 */           return (CharSequence)reg.info.name();
/*     */         }
/*     */ 
/*     */         
/*     */         public int men() {
/* 201 */           return (RD.MILITARY()).garrison.get(reg);
/*     */         }
/*     */ 
/*     */         
/*     */         public int lossesRetreat() {
/* 206 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int losses() {
/* 211 */           return (int)(men() * 0.5D);
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE icon() {
/* 216 */           return (SPRITE)(UI.icons()).m.building;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GUI_BOX box) {
/* 221 */           box.title(Dic.¤¤Region);
/*     */         }
/*     */ 
/*     */         
/*     */         public double defences() {
/* 226 */           return 20.0D;
/*     */         }
/*     */       };
/*     */     
/* 230 */     WBattleSiege s = new WBattleSiege()
/*     */       {
/*     */         public void retreat() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void auto() {}
/*     */       };
/* 245 */     s.besiged = reg;
/* 246 */     s.victory = RND.rBoolean();
/* 247 */     s.player = Tests.this.side(RND.rFloat(), tx, ty, null);
/* 248 */     s.enemy = Tests.this.side(RND.rFloat(), tx, ty, ss);
/* 249 */     s.fortifications = 20.0D;
/* 250 */     (VIEW.world()).UI.battle.siege(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence isPlacable(int tx, int ty) {
/* 256 */     return WORLD.REGIONS().centreTile().is(tx, ty) ? null : E;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\battle\Tests$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */