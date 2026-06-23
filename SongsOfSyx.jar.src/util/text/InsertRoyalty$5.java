/*    */ package util.text;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.royalty.Royalty;
/*    */ import util.data.GETTER_TRANS;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements GETTER_TRANS<Royalty, Faction>
/*    */ {
/*    */   public Faction get(Royalty f) {
/* 53 */     if (f == null)
/* 54 */       return null; 
/* 55 */     return (Faction)f.court.faction;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertRoyalty$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */