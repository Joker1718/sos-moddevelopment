/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.thing.THINGS;
/*     */ import settlement.thing.ThingFindable;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends SFinderFindable.FinderThing<ThingsCorpses.Corpse>
/*     */ {
/*     */   null(String $anonymous0) {
/* 109 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   public ThingsCorpses.Corpse getReservable(int tx, int ty) {
/* 113 */     for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/* 114 */       if (t instanceof ThingsCorpses.Corpse) {
/* 115 */         ThingsCorpses.Corpse c = (ThingsCorpses.Corpse)t;
/* 116 */         if (c.findableReservedCanBe())
/* 117 */           return c; 
/*     */       } 
/* 119 */     }  return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public ThingsCorpses.Corpse getReserved(int tx, int ty) {
/* 124 */     for (THINGS.Thing t : SETT.THINGS().get(tx, ty)) {
/* 125 */       if (t instanceof ThingsCorpses.Corpse) {
/* 126 */         ThingsCorpses.Corpse c = (ThingsCorpses.Corpse)t;
/* 127 */         if (c.findableReservedIs())
/* 128 */           return c; 
/*     */       } 
/* 130 */     }  return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFINDERS$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */