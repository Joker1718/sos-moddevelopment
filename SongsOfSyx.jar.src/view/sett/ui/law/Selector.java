/*    */ package view.sett.ui.law;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import init.sprite.UI.UI;
/*    */ import init.type.CRIMES;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sets.ArrayListGrower;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.misc.GText;
/*    */ import util.gui.table.GScrollRows;
/*    */ import util.info.GFORMAT;
/*    */ 
/*    */ class Selector
/*    */   extends GuiSection
/*    */ {
/* 25 */   private Race race = null;
/*    */   
/*    */   int am;
/*    */ 
/*    */   
/*    */   Selector(int HEIGHT, final LIST<CRIMES.CRIME> types) {
/* 31 */     ArrayListGrower<RENDEROBJ> rens = new ArrayListGrower();
/*    */     
/* 33 */     for (int ii = 0; ii < RACES.all().size(); ii++) {
/*    */ 
/*    */ 
/*    */       
/* 37 */       final int ri = ii;
/* 38 */       SPRITE.Imp imp = new SPRITE.Imp(64) {
/* 39 */           GText t = new GText((UI.FONT()).S, 8);
/*    */ 
/*    */ 
/*    */           
/*    */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 44 */             int am = 0;
/* 45 */             for (CRIMES.CRIME c : types)
/* 46 */               am += c.stat().criminals((FACTIONS.player()).races.get(ri)); 
/* 47 */             this.t.clear();
/* 48 */             GFORMAT.i(this.t, am);
/* 49 */             this.t.adjustWidth();
/* 50 */             if (am > 0)
/* 51 */               ((FACTIONS.player()).races.get(ri).appearance()).iconBig.render(r, X1, X2, Y1, Y2); 
/* 52 */             OPACITY.O50.bind();
/* 53 */             if (am <= 0)
/* 54 */               ((FACTIONS.player()).races.get(ri).appearance()).iconBig.render(r, X1, X2, Y1, Y2); 
/* 55 */             COLOR.BLACK.render(r, X1, X1 + this.t.width() + 8, Y1, Y1 + this.t.height() + 6);
/* 56 */             OPACITY.unbind();
/* 57 */             this.t.render(r, X1 + 4, Y1 + 3);
/*    */           }
/*    */         };
/*    */       
/* 61 */       GButt.ButtPanel b = new GButt.ButtPanel((SPRITE)imp)
/*    */         {
/*    */           protected void clickA() {
/* 64 */             Selector.this.race = (FACTIONS.player()).races.get(ri);
/*    */           }
/*    */ 
/*    */           
/*    */           protected void renAction() {
/* 69 */             selectedSet((Selector.this.getRace() == (FACTIONS.player()).races.get(ri)));
/*    */           }
/*    */ 
/*    */           
/*    */           public void hoverInfoGet(GUI_BOX text) {
/* 74 */             text.title(((FACTIONS.player()).races.get(ri)).info.names);
/* 75 */             super.hoverInfoGet(text);
/*    */           }
/*    */         };
/* 78 */       rens.add(b);
/*    */     } 
/*    */ 
/*    */     
/* 82 */     GScrollRows sc = new GScrollRows((Iterable)rens, ((RENDEROBJ)rens.get(0)).body().height() * HEIGHT / ((RENDEROBJ)rens.get(0)).body().height(), 0);
/* 83 */     add((RENDEROBJ)sc.view());
/*    */   }
/*    */ 
/*    */   
/*    */   public Race getRace() {
/* 88 */     if (this.race == null)
/* 89 */       this.race = FACTIONS.player().race(); 
/* 90 */     return this.race;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\law\Selector.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */