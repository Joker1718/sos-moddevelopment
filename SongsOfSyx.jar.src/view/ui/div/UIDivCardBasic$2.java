/*    */ package view.ui.div;
/*    */ 
/*    */ import settlement.stats.equip.EquipBattle;
/*    */ import snake2d.util.color.COLOR;
/*    */ import util.gui.misc.GStat;
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
/* 65 */     if (UIDivCardBasic.this.current.equip(e) == 0.0D) {
/* 66 */       text.color(COLOR.WHITE50).add('-');
/*    */     } else {
/* 68 */       GFORMAT.f(text, 10.0D * UIDivCardBasic.this.current.equip(e) * e.equipMax / 10.0D, 1);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardBasic$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */