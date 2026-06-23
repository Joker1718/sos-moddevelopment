/*    */ package view.sett.ui.law;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.CRIMES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
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
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   GText t;
/*    */   
/*    */   null(int $anonymous0) {
/* 38 */     super($anonymous0);
/* 39 */     this.t = new GText((UI.FONT()).S, 8);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 44 */     int am = 0;
/* 45 */     for (CRIMES.CRIME c : types)
/* 46 */       am += c.stat().criminals((FACTIONS.player()).races.get(ri)); 
/* 47 */     this.t.clear();
/* 48 */     GFORMAT.i(this.t, am);
/* 49 */     this.t.adjustWidth();
/* 50 */     if (am > 0)
/* 51 */       ((FACTIONS.player()).races.get(ri).appearance()).iconBig.render(r, X1, X2, Y1, Y2); 
/* 52 */     OPACITY.O50.bind();
/* 53 */     if (am <= 0)
/* 54 */       ((FACTIONS.player()).races.get(ri).appearance()).iconBig.render(r, X1, X2, Y1, Y2); 
/* 55 */     COLOR.BLACK.render(r, X1, X1 + this.t.width() + 8, Y1, Y1 + this.t.height() + 6);
/* 56 */     OPACITY.unbind();
/* 57 */     this.t.render(r, X1 + 4, Y1 + 3);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\Selector$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */