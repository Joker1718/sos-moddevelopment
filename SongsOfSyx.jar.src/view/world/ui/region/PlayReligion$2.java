/*    */ package view.world.ui.region;
/*    */ 
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import init.religion.RELIGIONS;
/*    */ import init.religion.Religion;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ import world.region.RDReligions;
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
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends GuiSection
/*    */ {
/*    */   public void hoverInfoGet(GUI_BOX text) {
/* 67 */     rel.religion.info.hover(text);
/* 68 */     GBox b = (GBox)text;
/* 69 */     b.sep();
/* 70 */     rel.boost.hover((GUI_BOX)b, (BOOSTABLE_O)PlayReligion.this.g.get(), Dic.¤¤Spread, false);
/* 71 */     b.sep();
/*    */ 
/*    */     
/* 74 */     rel.boosts.hover(text, (BOOSTABLE_O)PlayReligion.this.g.get());
/*    */     
/* 76 */     b.sep();
/* 77 */     b.textSLL(((STATS.RELIGION()).OPPOSITION.info()).name);
/* 78 */     b.NL();
/* 79 */     int tab = 0;
/* 80 */     for (Religion o : RELIGIONS.ALL()) {
/* 81 */       b.tab(tab);
/* 82 */       b.text(o.info.name);
/* 83 */       b.tab(tab + 6);
/* 84 */       b.add((SPRITE)GFORMAT.percInv(b.text(), rel.religion.opposition(o)));
/* 85 */       tab += 8;
/* 86 */       if (tab > 8) {
/* 87 */         b.NL();
/* 88 */         tab = 0;
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 93 */     super.hoverInfoGet(text);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayReligion$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */