/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.tilemap.terrain.Terrain;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements StatsInit.StatUpdatableI
/*     */ {
/* 154 */   private final double DY = 0.0625D;
/* 155 */   private double itime = -10.0D;
/* 156 */   private final double[] insaneRate = new double[RACES.all().size()];
/*     */ 
/*     */ 
/*     */   
/*     */   public void update16(Humanoid h, int updateI, boolean day, int ui) {
/* 161 */     Induvidual i = h.indu();
/*     */     
/* 163 */     if (StatsNeeds.this.INJURIES.update(h)) {
/*     */       return;
/*     */     }
/*     */     
/* 167 */     if (!(STATS.DISEASE().status(i)).active && i.hType() != HTYPES.TOURIST()) {
/*     */       
/* 169 */       for (StatsNeeds.StatNeedNormal n : StatsNeeds.this.SNEEDS) {
/*     */         
/* 171 */         if (RND.rFloat() < n.need.rate.get((BOOSTABLE_O)i)) {
/* 172 */           n.inc(i, 1);
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 180 */       if ((ui & 0xFF) < (BOOSTABLES.PHYSICS()).SOILING.get((BOOSTABLE_O)i) * 256.0D)
/* 181 */         StatsNeeds.this.DIRTINESS.inc(i, 1); 
/* 182 */       if (((Terrain.TerrainTile)SETT.TERRAIN().get(h.physics.tileC())).roofIs()) {
/* 183 */         if ((SETT.ROOMS()).map.is(h.physics.tileC()) && (
/* 184 */           (Room)(SETT.ROOMS()).map.get(h.physics.tileC())).blueprint().makesDudesDirty()) {
/* 185 */           StatsNeeds.this.DIRTINESS.inc(i, 1);
/*     */         }
/* 187 */       } else if ((SETT.WEATHER()).rain.getD() > 0.0D && !(SETT.WEATHER()).snow.rainIsSnow()) {
/* 188 */         StatsNeeds.this.DIRTINESS.inc(i, -1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 193 */     double insaneRate = InsaneRate(i.race());
/*     */     
/* 195 */     if (day && i.clas() == HCLASSES.CITIZEN() && i.hType() != HTYPES.DERANGED() && 
/* 196 */       2.0D * insaneRate / (1.0D + (BOOSTABLES.BEHAVIOUR()).SANITY.get((BOOSTABLE_O)i)) > RND.rFloat()) {
/* 197 */       h.HTypeSet(HTYPES.DERANGED(), CAUSE_LEAVES.INSAVITY(), null);
/*     */     }
/*     */ 
/*     */     
/* 201 */     StatsNeeds.this.EXPOSURE.update(h, insaneRate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private double InsaneRate(Race r) {
/* 208 */     if (TIME.currentSecond() - this.itime > 10.0D) {
/* 209 */       double v = StatsNeeds.insaneRate((STATS.POP()).POP.data().get(null));
/* 210 */       for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 211 */         Race race = (Race)RACES.all().get(ri);
/*     */ 
/*     */         
/* 214 */         int insane = STATS.POP().pop(race, HTYPES.DERANGED());
/* 215 */         if (insane > v * (STATS.POP()).POP.data(HCLASSES.CITIZEN()).get(race) * 5.0D) {
/* 216 */           v = 0.0D;
/*     */         }
/* 218 */         this.insaneRate[r.index()] = v * 0.0625D;
/*     */       } 
/*     */       
/* 221 */       this.itime = TIME.currentSecond();
/*     */     } 
/* 223 */     return this.insaneRate[r.index()];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsNeeds$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */