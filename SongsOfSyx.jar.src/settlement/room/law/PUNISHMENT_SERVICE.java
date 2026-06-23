/*    */ package settlement.room.law;
/*    */ 
/*    */ import init.race.Race;
/*    */ import util.data.BOOLEANO;
/*    */ 
/*    */ public interface PUNISHMENT_SERVICE {
/*    */   int punishTotal();
/*    */   
/*    */   int punishUsed();
/*    */   
/*    */   default BOOLEANO.BOOLEAN_OE<Race> punishEnabled() {
/* 12 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\PUNISHMENT_SERVICE.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */