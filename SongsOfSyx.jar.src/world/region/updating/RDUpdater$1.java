/*    */ package world.region.updating;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import util.updating.IUpdater;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 42 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 48 */     Region r = WORLD.REGIONS().getByIndex(i);
/* 49 */     if (r != null && r.active())
/*    */     {
/*    */ 
/*    */       
/* 53 */       if (r.faction() == FACTIONS.player()) {
/* 54 */         RDUpdater.this.timers[r.index()] = (float)(RDUpdater.this.timers[r.index()] + timeSinceLast);
/* 55 */         if (RDUpdater.this.timers[r.index()] > RDUpdater.this.ship) {
/* 56 */           RDUpdater.this.shipper.ship(r, RDUpdater.this.ship);
/* 57 */           RDUpdater.this.timers[r.index()] = (float)(RDUpdater.this.timers[r.index()] - RDUpdater.this.ship);
/*    */         } 
/*    */         
/* 60 */         for (RD.RDUpdatable u : RDUpdater.this.all)
/* 61 */           u.update(r, timeSinceLast); 
/*    */       } else {
/* 63 */         float next = (float)(RDUpdater.this.timers[r.index()] + timeSinceLast);
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 68 */         if ((int)(RDUpdater.this.timers[r.index()] / RDUpdater.this.upD) != (int)(next / RDUpdater.this.upD))
/* 69 */           for (RD.RDUpdatable u : RDUpdater.this.all) {
/* 70 */             u.update(r, RDUpdater.this.upD);
/*    */           } 
/* 72 */         if (next >= RDUpdater.this.build) {
/* 73 */           if (r.faction() != null)
/* 74 */             RDUpdater.this.builder.build(r); 
/* 75 */           RDUpdater.this.shipper.ship(r, RDUpdater.this.build);
/* 76 */           next = (float)(next - RDUpdater.this.build);
/*    */         } 
/*    */         
/* 79 */         RDUpdater.this.timers[r.index()] = next;
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\regio\\updating\RDUpdater$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */