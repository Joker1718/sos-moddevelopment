/*    */ package view.world.ui.army;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 51 */     GFORMAT.i(text, AD.men(null).get(army.get()));
/*    */   }
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 55 */     b.title(Dic.¤¤Soldiers);
/* 56 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), AD.men(null).get(army.get()), AD.menTarget(null).get(army.get())));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\ArmyInfo$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */