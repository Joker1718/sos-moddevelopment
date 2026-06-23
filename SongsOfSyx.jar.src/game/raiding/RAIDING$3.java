/*    */ package game.raiding;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.LIST;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 84 */     LIST<RaidingMap.RaidRegion> rr = RAIDING.this.entry.entryRegions();
/* 85 */     if (rr.size() == 0) {
/*    */       return;
/*    */     }
/* 88 */     Region reg = ((RaidingMap.RaidRegion)rr.rnd()).r();
/* 89 */     double power = RAIDING.this.util.defences(reg);
/* 90 */     power *= (1.0F + RND.rFloat(1.0D));
/* 91 */     Raider raider = new Raider(FACTIONS.WORTH().raider(), power, RND.rFloat());
/* 92 */     raider.text.set(raider, true);
/* 93 */     RAIDING.this.current.raid(raider);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RAIDING$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */