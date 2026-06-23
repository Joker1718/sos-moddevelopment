/*    */ package settlement.room.health.asylum;
/*    */ 
/*    */ import util.data.GETTER;
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
/*    */ class null
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 38 */     GFORMAT.iofkNoColor(text, ((AsylumInstance)g.get()).prisoners(), ((AsylumInstance)g.get()).prisonersMax());
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\asylum\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */