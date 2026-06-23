/*    */ package view.world.ui.army;
/*    */ 
/*    */ import init.race.RACES;
/*    */ import init.race.Race;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
/*    */ import util.text.Dic;
/*    */ import world.army.AD;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 61 */     GFORMAT.iIncr(text, AD.conscripts().available(null).get(List.this.f));
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 66 */     b.title(Dic.¤¤Conscriptable);
/* 67 */     b.text(Dic.¤¤ConscriptsD);
/* 68 */     b.NL(8);
/*    */     
/* 70 */     for (Race r : RACES.all()) {
/* 71 */       if ((r.population()).max == 0.0D)
/*    */         continue; 
/* 73 */       b.add((SPRITE)(r.appearance()).icon);
/* 74 */       b.add((SPRITE)GFORMAT.iIncr(b.text(), AD.conscripts().available(r).get(List.this.f)));
/* 75 */       b.NL();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\List$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */