/*    */ package world.region;
/*    */ 
/*    */ import world.WORLD;
/*    */ import world.entity.army.WArmy;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements RD.RDUpdatable
/*    */ {
/*    */   public void update(Region reg, double time) {
/* 68 */     if (reg.faction() != null) {
/* 69 */       for (WArmy a : (WORLD.ENTITIES()).armies.fill(reg)) {
/* 70 */         if (a.raiding())
/*    */           return; 
/*    */       } 
/* 73 */       RDDevastation.this.current.incFraction(reg, -RDDevastation.this.current.max(reg) * time * RDDevastation.dTime);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(Region reg) {
/* 79 */     RDDevastation.this.current.set(reg, 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\RDDevastation$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */