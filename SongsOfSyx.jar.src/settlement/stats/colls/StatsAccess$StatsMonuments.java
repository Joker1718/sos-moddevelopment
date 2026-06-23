/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.infra.monument.ROOM_MONUMENT;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DataO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StatsMonuments
/*     */   extends StatCollection
/*     */ {
/*     */   private final STAT degrade;
/* 230 */   private final ArrayList<StatsAccess.StatMonument> ALL = new ArrayList((SETT.ROOMS()).MONUMENTS.all.size());
/*     */   
/*     */   private StatsMonuments(StatsInit init) {
/* 233 */     super(init, "MONUMENTS", StatsAccess.¤¤monumentName, StatsAccess.¤¤MonumentsD);
/* 234 */     init.count.getClass(); this.degrade = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataCrumb(init.count, "MON_DEGRADE"), null);
/* 235 */     ROOM_MONUMENT[] rr = new ROOM_MONUMENT[(SETT.ROOMS()).MONUMENTS.all.size()];
/*     */     
/* 237 */     for (ROOM_MONUMENT m : (SETT.ROOMS()).MONUMENTS.all)
/* 238 */       rr[m.monumentIndex] = m;  byte b; int i;
/*     */     ROOM_MONUMENT[] arrayOfROOM_MONUMENT1;
/* 240 */     for (i = (arrayOfROOM_MONUMENT1 = rr).length, b = 0; b < i; ) { ROOM_MONUMENT m = arrayOfROOM_MONUMENT1[b];
/* 241 */       this.ALL.add(new StatsAccess.StatMonument(m, init, this.degrade));
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<StatsAccess.StatMonument> ALL() {
/* 248 */     return (LIST<StatsAccess.StatMonument>)this.ALL;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsAccess$StatsMonuments.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */