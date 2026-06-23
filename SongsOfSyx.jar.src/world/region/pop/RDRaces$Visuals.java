/*     */ package world.region.pop;
/*     */ 
/*     */ import init.race.Race;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import view.main.VIEW;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
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
/*     */ public final class Visuals
/*     */ {
/*     */   private final INT_O.INT_OE<Region> cRace;
/*     */   private final INT_O.INT_OE<Region> cacheI;
/* 332 */   private final ArrayList<INT_O.INT_OE<Region>> vVill = new ArrayList(16);
/*     */   
/*     */   private Visuals(RD.RDInit init) {
/* 335 */     if (paramRDRaces.all.size() > 255)
/* 336 */       throw new RuntimeException("too many races"); 
/* 337 */     init.count.getClass(); this.cRace = (INT_O.INT_OE<Region>)new DataO.DataByte(init.count, "VISUALS_RACE");
/* 338 */     init.count.getClass(); this.cacheI = (INT_O.INT_OE<Region>)new DataO.DataNibble(init.count, "VISUALS_RACEI");
/* 339 */     while (this.vVill.hasRoom())
/* 340 */       this.vVill.add(new DataO.DataByte(init.count, "VISUALS_RACE?" + this.vVill.size())); 
/*     */   }
/*     */   
/*     */   public Race cRace(Region reg) {
/* 344 */     cache(reg);
/* 345 */     return ((RDRace)RDRaces.this.all.get(this.cRace.get(reg))).race;
/*     */   }
/*     */   
/*     */   public Race vRace(Region reg, int ran) {
/* 349 */     cache(reg);
/* 350 */     ran &= 0xF;
/* 351 */     return ((RDRace)RDRaces.this.all.get(((INT_O.INT_OE)this.vVill.get(ran)).get(reg))).race;
/*     */   }
/*     */   
/*     */   private void cache(Region reg) {
/* 355 */     int ri = 15 - (VIEW.RI() >> 6 & 0xF);
/* 356 */     if (this.cacheI.get(reg) == ri)
/*     */       return; 
/* 358 */     this.cacheI.set(reg, ri);
/* 359 */     RDRace biggest = null;
/* 360 */     int bb = -1;
/* 361 */     int vi = 0;
/* 362 */     for (int rri = 0; rri < RDRaces.this.all.size(); rri++) {
/* 363 */       RDRace r = (RDRace)RDRaces.this.all.get(rri);
/* 364 */       if (r.pop.get(reg) > bb) {
/* 365 */         biggest = r;
/* 366 */         bb = r.pop.get(reg);
/*     */       } 
/* 368 */       if (RDRaces.this.population.get(reg) > 0) {
/* 369 */         int vam = 16 * r.pop.get(reg) / RDRaces.this.population.get(reg);
/* 370 */         for (int i = 0; i < vam && vi < 16; i++) {
/* 371 */           ((INT_O.INT_OE)this.vVill.get(vi++)).set(reg, r.index());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 376 */     this.cRace.set(reg, biggest.index());
/*     */     
/* 378 */     for (; vi < 16; vi++)
/* 379 */       ((INT_O.INT_OE)this.vVill.get(vi)).set(reg, biggest.index()); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDRaces$Visuals.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */