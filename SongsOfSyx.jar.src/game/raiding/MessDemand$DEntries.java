/*     */ package game.raiding;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FWorth;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class DEntries
/*     */ {
/* 321 */   private final ArrayListGrower<MessDemand.DEntry> all = new ArrayListGrower();
/*     */   
/*     */   private final Tree<MessDemand.DEntry> rtree;
/*     */   
/*     */   DEntries() {
/* 326 */     for (TRADABLE res : TR.ALL()) {
/* 327 */       this.all.add(new MessDemand.DEntry()
/*     */           {
/*     */             int max()
/*     */             {
/* 331 */               return (int)(res.ps().playerOwned() * 0.95D);
/*     */             }
/*     */ 
/*     */             
/*     */             void add(MessDemand.Demand d, int am) {
/* 336 */               d.resources[res.index()] = d.resources[res.index()] + am;
/*     */             }
/*     */ 
/*     */             
/*     */             double value() {
/* 341 */               return FWorth.worthResource(res, 1);
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 346 */     this.rtree = new Tree<MessDemand.DEntry>(this.all.size())
/*     */       {
/*     */         protected boolean isGreaterThan(MessDemand.DEntry current, MessDemand.DEntry cmp)
/*     */         {
/* 350 */           return (current.value > cmp.value);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   void set(MessDemand.Demand d, int credits) {
/* 357 */     this.rtree.clear();
/* 358 */     for (MessDemand.DEntry e : this.all) {
/* 359 */       e.value = (int)(e.value() * e.max() * RND.rFloat1(0.5D));
/* 360 */       if (e.value > 0) {
/* 361 */         this.rtree.add(e);
/*     */       }
/*     */     } 
/* 364 */     if (FACTIONS.player().credits().getD() > 0.0D) {
/* 365 */       int cre = (int)(FACTIONS.player().credits().getD() * RND.rFloat());
/* 366 */       if (cre > credits)
/* 367 */         cre = credits; 
/* 368 */       d.credits += cre;
/* 369 */       credits -= cre;
/*     */     } 
/*     */     
/* 372 */     while (credits > 0 && this.rtree.hasMore()) {
/* 373 */       MessDemand.DEntry e = (MessDemand.DEntry)this.rtree.pollGreatest();
/*     */       
/* 375 */       int am = e.max();
/* 376 */       int v = (int)e.value();
/* 377 */       int w = e.max() * v;
/* 378 */       if (w > credits)
/* 379 */         am = (int)Math.ceil(credits / v); 
/* 380 */       e.add(d, am);
/* 381 */       credits -= am * v;
/*     */     } 
/*     */     
/* 384 */     if (credits > 0) {
/* 385 */       int am = (int)(FACTIONS.player().credits().getD() - d.credits);
/* 386 */       if (am > credits)
/* 387 */         am = credits; 
/* 388 */       if (am > 0)
/* 389 */         d.credits += am; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\MessDemand$DEntries.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */