/*     */ package view.world.ui.region;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.boosting.tmp.TmpBoostSpec;
/*     */ import init.resources.RESOURCES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
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
/*     */ class null
/*     */   extends GButt.ButtPanel
/*     */ {
/*     */   TmpBoostSpec s;
/*     */   
/*     */   null(CharSequence $anonymous0) {
/* 136 */     super($anonymous0);
/*     */     
/* 138 */     this.s = new TmpBoostSpec("_DEBUG", "PlayDebug", "PlayDebug", (SPRITE)(UI.icons()).s.alert);
/*     */     
/* 140 */     this.s.spec.push((Booster)new BoosterValue(BValue.VALUE1, new BSourceInfo("", (SPRITE)(UI.icons()).s.alert), 100.0D, false), (RD.OUTPUT().get(RESOURCES.WOOD().tr())).boost);
/* 141 */     this.s.spec.push((Booster)new BoosterValue(BValue.VALUE1, new BSourceInfo("", (SPRITE)(UI.icons()).s.alert), 4.0D, true), (RD.OUTPUT().get(RESOURCES.WOOD().tr())).boost);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void clickA() {
/* 146 */     (GAME.BOOST()).regions.toggle((INDEXED)PlayDebug.this.reg, this.s);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayDebug$7.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */