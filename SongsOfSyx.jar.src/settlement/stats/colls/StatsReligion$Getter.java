/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DataO;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Getter
/*     */   implements GETTER_TRANS.GETTER_TRANSE<Induvidual, StatsReligion.StatReligion>, StatsInit.Addable
/*     */ {
/*     */   private final INT_O.INT_OE<Induvidual> ii;
/* 341 */   private final INFO info = new INFO(StatsReligion.¤¤religion, StatsReligion.¤¤religionD);
/*     */   
/*     */   Getter(StatsInit init) {
/* 344 */     init.count.getClass(); this.ii = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "REL_ID");
/* 345 */     init.addable.add(this);
/* 346 */     init.onConstruct.add(new StatsInit.StatInitable()
/*     */         {
/*     */           
/*     */           public void init(Induvidual h)
/*     */           {
/* 351 */             double d = 0.0D;
/* 352 */             for (StatsReligion.StatReligion re : (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).ALL) {
/* 353 */               d += re.religion.conversionCity.get((BOOSTABLE_O)h);
/*     */             }
/* 355 */             d *= RND.rFloat();
/* 356 */             for (StatsReligion.StatReligion re : (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).ALL) {
/* 357 */               d -= re.religion.conversionCity.get((BOOSTABLE_O)h);
/* 358 */               if (d <= 0.0D) {
/* 359 */                 (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).getter.set(h, re);
/*     */                 return;
/*     */               } 
/*     */             } 
/* 363 */             (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).getter.set(h, (StatsReligion.Getter.access$2(StatsReligion.Getter.this)).ALL.get((StatsReligion.Getter.access$2(StatsReligion.Getter.this)).ALL.size() - 1));
/*     */           }
/*     */         });
/*     */     
/* 367 */     init.copier.add(new INT_O.INT_OE<Induvidual>()
/*     */         {
/*     */           public int get(Induvidual t)
/*     */           {
/* 371 */             return StatsReligion.Getter.this.ii.get(t);
/*     */           }
/*     */ 
/*     */           
/*     */           public int min(Induvidual t) {
/* 376 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max(Induvidual t) {
/* 381 */             return 127;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(Induvidual t, int i) {
/* 386 */             StatsReligion.Getter.this.set(t, (StatsReligion.StatReligion)(StatsReligion.Getter.access$2(StatsReligion.Getter.this)).religions.get(i));
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StatsReligion.StatReligion get(Induvidual f) {
/* 394 */     return (StatsReligion.StatReligion)StatsReligion.this.religions.get(this.ii.get(f));
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Induvidual f, StatsReligion.StatReligion t) {
/* 399 */     if (this.ii.get(f) == t.index())
/*     */       return; 
/* 401 */     StatsReligion.this.TEMPLE.clearAccess(f);
/* 402 */     StatsReligion.this.SHRINE.clearAccess(f);
/* 403 */     removeH(f);
/* 404 */     this.ii.set(f, t.index());
/* 405 */     addH(f);
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/* 410 */     return this.info;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addPrivate(Induvidual i) {
/* 415 */     StatsReligion.StatReligion r = get(i);
/* 416 */     r.followers.inc(i, 1);
/* 417 */     StatsReligion.this.TEMPLE.access(r.religion).inc(i, StatsReligion.this.TEMPLE.ACCESS.indu().get(i));
/* 418 */     StatsReligion.this.TEMPLE.quality(r.religion).inc(i, StatsReligion.this.TEMPLE.QUALITY.indu().get(i));
/* 419 */     StatsReligion.this.SHRINE.access(r.religion).inc(i, StatsReligion.this.SHRINE.ACCESS.indu().get(i));
/* 420 */     StatsReligion.this.SHRINE.quality(r.religion).inc(i, StatsReligion.this.SHRINE.QUALITY.indu().get(i));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void removePrivate(Induvidual i) {
/* 426 */     StatsReligion.StatReligion r = get(i);
/* 427 */     r.followers.inc(i, -1);
/* 428 */     StatsReligion.this.TEMPLE.access(r.religion).inc(i, -StatsReligion.this.TEMPLE.ACCESS.indu().get(i));
/* 429 */     StatsReligion.this.TEMPLE.quality(r.religion).inc(i, -StatsReligion.this.TEMPLE.QUALITY.indu().get(i));
/* 430 */     StatsReligion.this.SHRINE.access(r.religion).inc(i, -StatsReligion.this.SHRINE.ACCESS.indu().get(i));
/* 431 */     StatsReligion.this.SHRINE.quality(r.religion).inc(i, -StatsReligion.this.SHRINE.QUALITY.indu().get(i));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsReligion$Getter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */