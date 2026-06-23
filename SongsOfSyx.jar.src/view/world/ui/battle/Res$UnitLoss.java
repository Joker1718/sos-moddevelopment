/*     */ package view.world.ui.battle;
/*     */ 
/*     */ import init.constant.Config;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.battle.spec.WBattleUnit;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class UnitLoss
/*     */   extends GuiSection
/*     */ {
/* 164 */   private static int width = 250;
/*     */   private final WBattleUnit u;
/*     */   
/*     */   public UnitLoss(final WBattleUnit u) {
/* 168 */     this.u = u;
/*     */     
/* 170 */     addRightC(8, (SPRITE)new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 174 */             u.icon().render(r, X1, X2, Y1, Y2);
/*     */           }
/*     */         });
/*     */     
/* 178 */     addRightC(8, (SPRITE)new SPRITE.Imp(200, 16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 182 */             double dmen = Math.sqrt(u.men() / (Config.battle()).MEN_PER_ARMY);
/* 183 */             X2 = (int)(X1 + (X2 - X1) * dmen);
/*     */             
/* 185 */             double d = (u.men() - u.losses()) / u.men();
/* 186 */             GMeter.render(r, GMeter.C_ORANGE, d, X1, X2, Y1, Y2);
/*     */           }
/*     */         });
/*     */     
/* 190 */     body().setWidth(width);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 196 */     this.u.hover(text);
/* 197 */     GBox b = (GBox)text;
/* 198 */     b.NL(16);
/* 199 */     b.text(Dic.¤¤Losses);
/* 200 */     b.add((SPRITE)GFORMAT.iofk(b.text(), this.u.losses(), this.u.men()));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\battle\Res$UnitLoss.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */