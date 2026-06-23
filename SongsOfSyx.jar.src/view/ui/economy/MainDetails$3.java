/*    */ package view.ui.economy;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.FWorth;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.INT;
/*    */ import util.gui.misc.GBox;
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
/* 70 */     super($anonymous0, $anonymous1);
/* 71 */     this.t = (new GText((UI.FONT()).S, 48)).lablify();
/*    */   }
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 74 */     (GCOLOR.T()).H1.bind();
/* 75 */     (UI.FONT()).H2.renderCY(r, body().x1() + (UI.FONT()).S.height() * 2, body().cY(), Dic.¤¤NetWorth);
/* 76 */     this.t.clear();
/* 77 */     int i = ii.get();
/* 78 */     if (i < 0)
/* 79 */       i = (GAME.player().credits()).worth.historyRecords() - 1; 
/* 80 */     i = GAME.player().credits().creditsH().historyRecords() - i - 1;
/* 81 */     GFORMAT.i(this.t, (FACTIONS.player().credits()).worth.get(i));
/* 82 */     this.t.adjustWidth();
/* 83 */     this.t.renderCY(r, body().x2() - this.t.width(), body().cY());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 89 */     GBox b = (GBox)text;
/* 90 */     for (FWorth.WINT d : (FACTIONS.WORTH()).faction) {
/* 91 */       b.add(d.icon);
/* 92 */       b.textL(d.info.name);
/* 93 */       b.tab(6);
/* 94 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), d.player()));
/* 95 */       b.NL();
/* 96 */       b.text(d.info.desc);
/* 97 */       b.NL(5);
/*    */     } 
/* 99 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\economy\MainDetails$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */