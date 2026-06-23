/*    */ package world.region;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import util.data.INT_O;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends RD.RDOwnerChanger
/*    */ {
/*    */   public void change(Region reg, Faction oldOwner, Faction newOwner) {
/* 18 */     change(oldOwner);
/* 19 */     change(newOwner);
/*    */   }
/*    */   
/*    */   private void change(Faction f) {
/* 23 */     if (f != null) {
/* 24 */       RData.this.ftotal.set(f, 0);
/* 25 */       for (int i = 0; i < f.realm().regions(); i++)
/* 26 */         RData.this.ftotal.inc(f, plocal.get(f.realm().region(i))); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RData$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */