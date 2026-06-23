/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import init.type.WGROUP;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class A_Assign_Extra
/*     */   implements Employer.AA
/*     */ {
/*     */   private final Tree<Employer.Bucket> toBeAssigned;
/*     */   private final ArrayList<WGROUP> same;
/*     */   
/*     */   private A_Assign_Extra() {
/* 488 */     this.toBeAssigned = new Tree<Employer.Bucket>(paramEmployer.buckets.length)
/*     */       {
/*     */         protected boolean isGreaterThan(Employer.Bucket current, Employer.Bucket cmp) {
/* 491 */           return (current.prio * (Employer.A_Assign_Extra.access$0(Employer.A_Assign_Extra.this)).buckets.length + current.e.index() > cmp.prio * (Employer.A_Assign_Extra.access$0(Employer.A_Assign_Extra.this)).buckets.length + cmp.e.index());
/*     */         }
/*     */       };
/*     */     
/* 495 */     this.same = new ArrayList(WGROUP.all().size());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean update() {
/* 500 */     if (!this.toBeAssigned.hasMore()) {
/*     */       byte b1; int i; Employer.Bucket[] arrayOfBucket;
/* 502 */       for (i = (arrayOfBucket = Employer.this.buckets).length, b1 = 0; b1 < i; ) { Employer.Bucket bucket = arrayOfBucket[b1];
/* 503 */         if (bucket.tot() < bucket.needed)
/* 504 */           this.toBeAssigned.add(bucket);  b1++; }
/*     */       
/* 506 */       if (Employer.this.log)
/* 507 */         for (WGROUP g : WGROUP.all()) {
/* 508 */           if (Employer.this.available.get(g) > 0) {
/* 509 */             LOG.ln(String.valueOf(g) + " " + String.valueOf(g));
/*     */           }
/*     */         }  
/* 512 */       return (this.toBeAssigned.size() > 0);
/*     */     } 
/*     */     
/* 515 */     Employer.Bucket b = (Employer.Bucket)this.toBeAssigned.pollGreatest();
/*     */     
/* 517 */     if (assign(b)) {
/* 518 */       this.toBeAssigned.add(b);
/*     */     }
/*     */     
/* 521 */     return this.toBeAssigned.hasMore();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean assign(Employer.Bucket b) {
/* 527 */     if (Employer.this.log) {
/* 528 */       LOG.ln("assigning: " + (b.e.blueprint()).key);
/*     */     }
/*     */     
/* 531 */     if (b.tot() >= b.needed) {
/* 532 */       if (Employer.this.log) {
/* 533 */         LOG.ln("done done");
/*     */       }
/* 535 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 540 */     int hi = 0;
/*     */     
/* 542 */     this.same.clearSloppy();
/*     */     
/* 544 */     for (WGROUP g : WGROUP.all()) {
/* 545 */       if (Employer.this.available.get(g) > 0) {
/* 546 */         hi = Math.max(hi, b.e.priorities.get(g));
/*     */       }
/*     */     } 
/* 549 */     if (hi == 0) {
/* 550 */       if (Employer.this.log) {
/* 551 */         LOG.ln("no workers");
/*     */       }
/* 553 */       return false;
/*     */     } 
/*     */     
/* 556 */     for (WGROUP g : WGROUP.all()) {
/* 557 */       if (Employer.this.available.get(g) > 0 && hi == b.e.priorities.get(g)) {
/* 558 */         this.same.add(g);
/*     */       }
/*     */     } 
/* 561 */     if (Employer.this.log) {
/* 562 */       LOG.ln("normal allocation2");
/*     */     }
/*     */     
/* 565 */     allocate(b, (LIST<WGROUP>)this.same, hi);
/* 566 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void allocate(Employer.Bucket e, LIST<WGROUP> same, int prio) {
/* 574 */     int toAllocate = e.needed - e.tot();
/* 575 */     int av = 0;
/*     */ 
/*     */     
/* 578 */     for (WGROUP g : same) {
/* 579 */       av += CLAMP.i(Employer.this.available.get(g), 0, toAllocate);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 584 */     if (Employer.this.log) {
/* 585 */       LOG.ln("ALLOCATING: " + (e.e.blueprint()).key + " " + e.needed + " " + e.tot() + " " + toAllocate + " " + same.size() + " " + av);
/*     */     }
/* 587 */     double d = toAllocate / av;
/* 588 */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */ 
/*     */ 
/*     */     
/* 592 */     for (WGROUP g : same) {
/* 593 */       int am = (int)Math.ceil(Employer.this.available.get(g) * d);
/* 594 */       int needed = e.needed - e.tot();
/* 595 */       am = CLAMP.i(am, 0, needed);
/* 596 */       Employer.this.available.add(g, -am);
/* 597 */       e.add(g, am);
/* 598 */       if (Employer.this.log) {
/* 599 */         LOG.ln("A: " + String.valueOf(g.race) + " " + String.valueOf(g.type) + " " + am);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void clear() {
/* 605 */     this.toBeAssigned.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\Employer$A_Assign_Extra.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */