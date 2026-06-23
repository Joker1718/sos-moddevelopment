/*     */ package world.region.pop;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
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
/*     */ class Up
/*     */   implements RD.RDUpdatable
/*     */ {
/*     */   private final RDRace race;
/*     */   
/*     */   Up(RDRace r) {
/*  90 */     this.race = r;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(Region reg, double ds) {
/*  95 */     if (reg.faction() != null && reg.capitol()) {
/*  96 */       for (RDEdicts.RDRaceEdict e : RDEdicts.this.all) {
/*  97 */         int am = 0;
/*  98 */         for (int ri = 0; ri < reg.faction().realm().regions(); ri++) {
/*  99 */           Region r = reg.faction().realm().region(ri);
/* 100 */           am += e.toggled(this.race).get(r);
/*     */         } 
/*     */         
/* 103 */         if (am > 0) {
/* 104 */           e.realm(this.race).incFraction(reg.faction(), am * 0.5D * ds * TIME.secondsPerDayI() * e.realm(this.race).max(null)); continue;
/*     */         } 
/* 106 */         e.realm(this.race).incFraction(reg.faction(), -ds * RDEdicts.dtime * e.realm(this.race).max(null));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void init(Region reg) {
/* 118 */     if (reg.faction() == FACTIONS.player()) {
/*     */       
/* 120 */       for (RDEdicts.RDRaceEdict e : RDEdicts.this.all) {
/* 121 */         e.toggled(this.race).set(reg, 0);
/* 122 */         e.realm(this.race).setD(reg.faction(), 0.0D);
/*     */       } 
/* 124 */     } else if (reg.faction() != null && reg.capitol()) {
/* 125 */       for (RDEdicts.RDRaceEdict e : RDEdicts.this.all) {
/* 126 */         e.realm(this.race).setD(reg.faction(), 0.0D);
/* 127 */         for (int ri = 0; ri < reg.faction().realm().regions(); ri++) {
/* 128 */           Region r = reg.faction().realm().region(ri);
/* 129 */           if (e.toggled(this.race).get(r) == 1)
/* 130 */             e.realm(this.race).setD(reg.faction(), 1.0D); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\pop\RDEdicts$Up.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */