/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
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
/* 84 */     GFORMAT.i(text, d.amount.get(event, data));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfoGet(GBox b) {
/* 90 */     b.title((CharSequence)b.text().add(d.t.info.names).s().add('(').add(_SUBJECTS_ADD.Imp.this.immType.names).add(')'));
/* 91 */     b.add((SPRITE)GFORMAT.iIncr(b.text(), d.amount.get(event, data)));
/* 92 */     b.NL();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_SUBJECTS_ADD$Imp$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */