/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.equip.WearableResource;
/*     */ import settlement.stats.stat.STATData;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StatFurniture
/*     */   implements WearableResource
/*     */ {
/*     */   private final int resI;
/*     */   public final STATData current;
/*     */   private final INT_O.INT_OE<Induvidual> counter;
/*     */   
/*     */   StatFurniture(int resI, StatsInit init) {
/* 332 */     this.resI = resI;
/* 333 */     this.current = new STATData(null, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "HOME_FURNITURE" + resI));
/* 334 */     this.counter = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "HOME_FCOUNTER" + resI);
/*     */   }
/*     */   
/*     */   void update(Induvidual i) {
/* 338 */     int am = this.current.indu().get(i) - (this.counter.get(i) >> 4);
/* 339 */     if (am > 0) {
/* 340 */       this.counter.inc(i, am);
/*     */     }
/*     */   }
/*     */   
/*     */   public RESOURCE resource(Induvidual i) {
/* 345 */     LIST<RES_AMOUNT> li = i.race().home().clas(i.clas()).resources();
/* 346 */     if (this.resI >= li.size())
/* 347 */       return null; 
/* 348 */     return ((RES_AMOUNT)li.get(this.resI)).resource();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void wearOut(Induvidual i) {
/* 354 */     int c = this.counter.get(i);
/* 355 */     int am = c >> 4;
/* 356 */     c &= 0xF;
/* 357 */     this.counter.set(i, c);
/* 358 */     if (am == 0) {
/*     */       return;
/*     */     }
/* 361 */     am = CLAMP.i(am, 0, this.current.indu().get(i));
/* 362 */     this.current.indu().inc(i, -am);
/*     */   }
/*     */ 
/*     */   
/*     */   public int max(Induvidual i) {
/* 367 */     LIST<RES_AMOUNT> li = i.race().home().clas(i.clas()).resources();
/* 368 */     if (this.resI >= li.size())
/* 369 */       return 0; 
/* 370 */     return ((RES_AMOUNT)li.get(this.resI)).amount();
/*     */   }
/*     */ 
/*     */   
/*     */   public int target(Induvidual i) {
/* 375 */     if (!StatsHome.this.GETTER.has(i))
/* 376 */       return 0; 
/* 377 */     RESOURCE res = resource(i);
/* 378 */     if (res == null)
/* 379 */       return 0; 
/* 380 */     return StatsHome.this.target(i.clas(), i.race(), res);
/*     */   }
/*     */ 
/*     */   
/*     */   public double wearPerYear(Induvidual i) {
/* 385 */     return CLAMP.d(0.5D / (BOOSTABLES.CIVICS()).FURNITURE.get((BOOSTABLE_O)i), 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Induvidual i, int am) {
/* 390 */     int old = this.current.indu().get(i);
/* 391 */     if (am != old) {
/*     */       
/* 393 */       this.current.indu().set(i, CLAMP.i(am, 0, max(i)));
/* 394 */       if (i.player() && i.added()) {
/* 395 */         FACTIONS.player().res().inc(resource(i), FResources.RTYPE.FURNISH, old - this.current.indu().get(i));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int needed(Induvidual i) {
/* 403 */     int am = target(i) - get(i) + (this.counter.get(i) >> 4);
/* 404 */     if (am < 0) {
/* 405 */       wearOut(i);
/* 406 */       am = target(i) - get(i);
/* 407 */       if (am < 0) {
/* 408 */         int c = this.counter.get(i) & 0xF;
/* 409 */         if (RND.rInt(16) < c)
/* 410 */           this.current.indu().inc(i, -1); 
/* 411 */         this.counter.set(i, 0);
/* 412 */         return target(i) - get(i);
/*     */       } 
/*     */     } 
/* 415 */     return am;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int get(Induvidual i) {
/* 421 */     return this.current.indu().get(i);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsHome$StatFurniture.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */