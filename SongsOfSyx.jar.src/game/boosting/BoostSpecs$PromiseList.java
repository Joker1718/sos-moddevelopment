/*     */ package game.boosting;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.util.Comparator;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PromiseList
/*     */   implements ACTION
/*     */ {
/* 409 */   public final LinkedList<Promise> all = new LinkedList();
/*     */   
/*     */   public final BoostSpecs coll;
/*     */   
/*     */   PromiseList(BoostSpecs coll) {
/* 414 */     this.coll = coll;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void exe() {
/* 420 */     for (Promise p : this.all) {
/*     */       
/* 422 */       LIST<Boostable> bos = BOOSTING.MAP().get(p.key);
/*     */ 
/*     */       
/* 425 */       if (bos.size() == 0) {
/* 426 */         String m = p.path + p.path + "no BOOSTABLE  named : " + System.lineSeparator();
/* 427 */         if (BOOSTING.hasErrored) {
/* 428 */           LOG.ln(m); continue;
/*     */         } 
/* 430 */         BOOSTING.hasErrored = true;
/* 431 */         GAME.Warn(m + m + "Available:" + System.lineSeparator() + System.lineSeparator());
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 436 */       boolean isWeak = (bos.size() > 1);
/*     */       
/* 438 */       for (Boostable bo : bos) {
/* 439 */         add(p, bo, isWeak);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 444 */     ArrayList<BoostSpec> rr = new ArrayList(this.coll.all.size());
/* 445 */     for (BoostSpec s : this.coll.all) {
/* 446 */       if (s.booster.isMul && s.booster.from() == 1.0D && s.booster.to() == 1.0D) {
/*     */         continue;
/*     */       }
/* 449 */       if (!s.booster.isMul && s.booster.from() == 0.0D && s.booster.to() == 0.0D) {
/*     */         continue;
/*     */       }
/* 452 */       rr.add(s);
/*     */     } 
/*     */     
/* 455 */     rr.sort(new Comparator<BoostSpec>()
/*     */         {
/*     */           public int compare(BoostSpec o1, BoostSpec o2)
/*     */           {
/* 459 */             int ii = String.valueOf(o1.boostable.cat.name).compareTo(String.valueOf(o2.boostable.cat.name));
/* 460 */             if (ii == 0) {
/* 461 */               return String.valueOf(o1.boostable.name).compareTo(String.valueOf(o2.boostable.name));
/*     */             }
/* 463 */             return ii;
/*     */           }
/*     */         });
/* 466 */     this.coll.all.clear();
/* 467 */     this.coll.all.add((Iterable)rr);
/* 468 */     this.coll.li = null;
/*     */   }
/*     */   
/*     */   private void add(Promise p, Boostable b, boolean isWeak) {
/* 472 */     BoostSpec boost = new BoostSpec(p.factor, b, null);
/* 473 */     for (BoostSpec bb : this.coll.all) {
/* 474 */       if (boost.isSameAs(bb)) {
/* 475 */         if (isWeak)
/*     */           return; 
/* 477 */         this.coll.remove(bb);
/* 478 */         if (this.coll.connect) {
/* 479 */           bb.boostable.removeFactor(bb);
/*     */         }
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 485 */     this.coll.push(boost);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void push(String key, Booster factor, String path, boolean isWeak) {
/* 495 */     for (Promise pp : this.all) {
/* 496 */       if (pp.key == key && pp.factor.isMul == factor.isMul) {
/* 497 */         this.all.remove(pp);
/*     */       }
/*     */     } 
/* 500 */     Promise p = new Promise(key, factor, path, isWeak);
/* 501 */     this.all.add(p);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Promise
/*     */   {
/*     */     public final String key;
/*     */     public final String path;
/*     */     public final Booster factor;
/*     */     
/*     */     Promise(String key, Booster factor, String path, boolean isWeak) {
/* 512 */       this.key = key;
/* 513 */       this.factor = factor;
/* 514 */       this.path = path;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BoostSpecs$PromiseList.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */