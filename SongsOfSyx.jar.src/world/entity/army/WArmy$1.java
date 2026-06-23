/*    */ package world.entity.army;
/*    */ 
/*    */ import game.faction.diplomacy.DIP;
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
/*    */ class null
/*    */   extends WRegFinder.Treaty
/*    */ {
/*    */   public boolean can(Region origin, Region prevReg, Region to, int tx, int ty, double dist) {
/* 49 */     if (to == null)
/* 50 */       return true; 
/* 51 */     if (tx != to.cx() || ty != to.cy())
/* 52 */       return true; 
/* 53 */     if (to.faction() == WArmy.this.faction())
/* 54 */       return true; 
/* 55 */     if (to.faction() == null || WArmy.this.faction() == null)
/* 56 */       return false; 
/* 57 */     if ((DIP.get(to.faction(), WArmy.this.faction())).ally)
/* 58 */       return true; 
/* 59 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\entity\army\WArmy$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */