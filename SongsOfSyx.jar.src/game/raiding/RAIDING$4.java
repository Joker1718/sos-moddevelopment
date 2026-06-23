/*     */ package game.raiding;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   implements ACTION
/*     */ {
/*     */   public void exe() {
/* 102 */     LIST<RaidingMap.RaidRegion> rr = RAIDING.this.entry.entryRegions();
/* 103 */     if (rr.size() == 0) {
/*     */       return;
/*     */     }
/* 106 */     Region reg = ((RaidingMap.RaidRegion)rr.rnd()).r();
/* 107 */     double power = RAIDING.this.util.defences(reg);
/* 108 */     power *= (1.0F + RND.rFloat(0.5D));
/* 109 */     Raider raider = new Raider(FACTIONS.WORTH().raider(), power, RND.rFloat());
/* 110 */     raider.text.set(raider, true);
/* 111 */     if (!RAIDING.this.current.appear(raider))
/* 112 */       LOG.ln("nope"); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RAIDING$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */