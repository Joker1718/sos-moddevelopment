/*    */ package view.ui.economy;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.FACTIONS;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.INT;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends HOVERABLE.HoverableAbs
/*    */ {
/*    */   GText t;
/*    */   
/*    */   null(int $anonymous0, int $anonymous1) {
/* 52 */     super($anonymous0, $anonymous1);
/* 53 */     this.t = (new GText((UI.FONT()).S, 48)).lablify();
/*    */   }
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 56 */     (GCOLOR.T()).H1.bind();
/* 57 */     (UI.FONT()).H2.renderCY(r, body().x1() + (UI.FONT()).S.height() * 2, body().cY(), Dic.¤¤Treasury);
/* 58 */     this.t.clear();
/* 59 */     int i = ii.get();
/* 60 */     if (i < 0)
/* 61 */       i = GAME.player().credits().creditsH().historyRecords() - 1; 
/* 62 */     i = GAME.player().credits().creditsH().historyRecords() - i - 1;
/* 63 */     GFORMAT.i(this.t, FACTIONS.player().credits().creditsH().get(i));
/* 64 */     this.t.adjustWidth();
/* 65 */     this.t.renderCY(r, body().x2() - this.t.width(), body().cY());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainDetails$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */