/*    */ package game.faction.diplomacy.deal;
/*    */ 
/*    */ import world.map.pathing.WRegFinder;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends WRegFinder.Treaty
/*    */ {
/*    */   public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist) {
/* 50 */     if (to == null)
/* 51 */       return true; 
/* 52 */     if (prevReg == null)
/* 53 */       return false; 
/* 54 */     if (prevReg.faction() == DealRegs.this.reciever)
/* 55 */       return true; 
/* 56 */     if (prevReg == to)
/* 57 */       return true; 
/* 58 */     return (to.faction() == DealRegs.this.giver);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealRegs$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */