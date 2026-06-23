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
/*     */ class A_Assign
/*     */   implements Employer.AA
/*     */ {
/*     */   private final ArrayList<WGROUP> same;
/*     */   private final Tree<Employer.Bucket> toBeAssigned;
/*     */   
/*     */   private A_Assign() {
/* 204 */     this.same = new ArrayList(WGROUP.all().size());
/*     */     
/* 206 */     this.toBeAssigned = new Tree<Employer.Bucket>(paramEmployer.buckets.length)
/*     */       {
/*     */         protected boolean isGreaterThan(Employer.Bucket current, Employer.Bucket cmp) {
/* 209 */           return (current.prio2 * (Employer.A_Assign.access$0(Employer.A_Assign.this)).buckets.length + current.e.index() > cmp.prio2 * (Employer.A_Assign.access$0(Employer.A_Assign.this)).buckets.length + cmp.e.index());
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update() {
/* 217 */     if (!this.toBeAssigned.hasMore()) {
/*     */       byte b1; int i; Employer.Bucket[] arrayOfBucket;
/* 219 */       for (i = (arrayOfBucket = Employer.this.buckets).length, b1 = 0; b1 < i; ) { Employer.Bucket bucket = arrayOfBucket[b1];
/* 220 */         if (bucket.target > 0) {
/* 221 */           int hi = 0;
/* 222 */           for (int gi = 0; gi < WGROUP.all().size(); gi++) {
/* 223 */             WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 224 */             if (Employer.this.workforce.get(g) > 0)
/* 225 */               hi = Math.max(hi, bucket.e.priorities.get(g)); 
/*     */           } 
/* 227 */           bucket.prio2 = hi;
/* 228 */           this.toBeAssigned.add(bucket);
/*     */         }  b1++; }
/*     */       
/* 231 */       return (this.toBeAssigned.size() > 0);
/*     */     } 
/*     */     
/* 234 */     Employer.Bucket b = (Employer.Bucket)this.toBeAssigned.pollGreatest();
/*     */     
/* 236 */     if (assign(b)) {
/* 237 */       int hi = 0;
/* 238 */       for (int gi = 0; gi < WGROUP.all().size(); gi++) {
/* 239 */         WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 240 */         if (Employer.this.available.get(g) > 0)
/* 241 */           hi = Math.max(hi, b.e.priorities.get(g)); 
/*     */       } 
/* 243 */       b.prio2 = hi;
/* 244 */       this.toBeAssigned.add(b);
/*     */     } 
/*     */     
/* 247 */     return this.toBeAssigned.hasMore();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean assign(Employer.Bucket b) {
/* 253 */     if (Employer.this.log) {
/* 254 */       LOG.ln("ASSIGN assigning: " + (b.e.blueprint()).key + " " + b.prio);
/*     */     }
/*     */     
/* 257 */     if (b.tot() >= b.target) {
/* 258 */       if (Employer.this.log) {
/* 259 */         LOG.ln("ASSIGN done");
/*     */       }
/* 261 */       return false;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 266 */     int hi = 0;
/* 267 */     this.same.clearSloppy();
/*     */     int gi;
/* 269 */     for (gi = 0; gi < WGROUP.all().size(); gi++) {
/* 270 */       WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 271 */       if (Employer.this.workforce.get(g) > 0) {
/* 272 */         hi = Math.max(hi, b.e.priorities.get(g));
/*     */       }
/*     */     } 
/* 275 */     if (hi == 0) {
/* 276 */       if (Employer.this.log) {
/* 277 */         LOG.ln("no one can work here");
/*     */       }
/*     */       
/* 280 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 284 */     hi = 0;
/* 285 */     for (gi = 0; gi < WGROUP.all().size(); gi++) {
/* 286 */       WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 287 */       if (Employer.this.available.get(g) > 0) {
/* 288 */         hi = Math.max(hi, b.e.priorities.get(g));
/*     */       }
/*     */     } 
/* 291 */     if (hi == 0) {
/*     */       
/* 293 */       if (Employer.this.log) {
/* 294 */         LOG.ln("special crap");
/*     */       }
/*     */       
/* 297 */       this.same.clearSloppy();
/* 298 */       for (WGROUP g : WGROUP.all()) {
/* 299 */         if (Employer.this.workforce.get(g) > 0 && b.e.priorities.get(g) > 0) {
/* 300 */           this.same.add(g);
/* 301 */           if (Employer.this.log) {
/* 302 */             LOG.ln("  candidate -> " + g.toString());
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 307 */       for (gi = 0; gi < WGROUP.all().size(); gi++) {
/* 308 */         WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 309 */         if (Employer.this.available.get(g) > 0) {
/* 310 */           if (Employer.this.log) {
/* 311 */             LOG.ln("  pushing -> " + g.toString());
/*     */           }
/* 313 */           if (pushIn(b, g, (LIST<WGROUP>)this.same)) {
/* 314 */             if (Employer.this.log) {
/* 315 */               LOG.ln("  pushed -> " + g.toString() + " " + b.tot() + "/" + b.target);
/*     */             }
/* 317 */             return true;
/*     */           } 
/*     */           
/* 320 */           return false;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 325 */       return false;
/*     */     } 
/*     */     
/* 328 */     for (gi = 0; gi < WGROUP.all().size(); gi++) {
/* 329 */       WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 330 */       if (Employer.this.available.get(g) > 0 && hi == b.e.priorities.get(g)) {
/* 331 */         this.same.add(g);
/*     */       }
/*     */     } 
/* 334 */     if (Employer.this.log) {
/* 335 */       LOG.ln("ASSIGN normal allocation");
/*     */     }
/*     */     
/* 338 */     allocate(b, (LIST<WGROUP>)this.same, hi);
/* 339 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean pushIn(Employer.Bucket missingWorkplace, WGROUP toPushIn, LIST<WGROUP> candidates) {
/* 346 */     Employer.Bucket target = null;
/* 347 */     WGROUP toPushOut = null;
/* 348 */     int bestPrio = Integer.MIN_VALUE; byte b; int i;
/*     */     Employer.Bucket[] arrayOfBucket;
/* 350 */     for (i = (arrayOfBucket = Employer.this.buckets).length, b = 0; b < i; ) { Employer.Bucket bucket = arrayOfBucket[b];
/* 351 */       if (bucket != missingWorkplace) {
/*     */         
/* 353 */         int p = bucket.e.priorities.get(toPushIn);
/* 354 */         if (p != 0)
/*     */         {
/* 356 */           if (bucket.get(toPushIn) < bucket.tot())
/*     */           {
/*     */             
/* 359 */             for (WGROUP g : candidates) {
/* 360 */               if (bucket.get(g) > 0 && g != toPushIn) {
/* 361 */                 int po = missingWorkplace.e.priorities.get(g);
/* 362 */                 if (po > 0) {
/* 363 */                   int prio = po - bucket.e.priorities.get(g);
/* 364 */                   prio += bucket.e.priorities.get(toPushOut) - p;
/* 365 */                   if (prio > bestPrio) {
/* 366 */                     target = bucket;
/* 367 */                     toPushOut = g;
/* 368 */                     bestPrio = prio;
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */       } 
/*     */       b++; }
/*     */     
/* 378 */     if (target != null) {
/* 379 */       int am = target.get(toPushOut);
/* 380 */       am = CLAMP.i(am, 0, Employer.this.available.get(toPushIn));
/* 381 */       am = CLAMP.i(am, 0, missingWorkplace.target - missingWorkplace.tot());
/* 382 */       if (Employer.this.log) {
/* 383 */         LOG.ln("  pusham : " + am + " " + String.valueOf(toPushOut) + " " + Employer.this.available.get(toPushOut) + " -> " + String.valueOf(toPushIn));
/*     */       }
/* 385 */       target.add(toPushOut, -am);
/* 386 */       target.add(toPushIn, am);
/* 387 */       Employer.this.available.add(toPushOut, am);
/* 388 */       Employer.this.available.add(toPushIn, -am);
/* 389 */       return true;
/*     */     } 
/*     */     
/* 392 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void allocate(Employer.Bucket e, LIST<WGROUP> same, int prio) {
/* 397 */     allocatePref(e, same);
/*     */     
/* 399 */     int toAllocate = e.target - e.tot();
/* 400 */     int av = 0;
/* 401 */     for (WGROUP g : same) {
/* 402 */       av += CLAMP.i(Employer.this.available.get(g), 0, toAllocate);
/*     */     }
/*     */     
/* 405 */     double d = toAllocate / av;
/* 406 */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */     
/* 408 */     if (Employer.this.log) {
/* 409 */       LOG.ln("ASSIGN ALLOCATING: " + (e.e.blueprint()).key + " " + e.target + " " + prio + " " + d + " " + same.size());
/*     */     }
/* 411 */     for (WGROUP g : same) {
/* 412 */       int am = (int)Math.ceil(Employer.this.available.get(g) * d);
/* 413 */       am = CLAMP.i(am, 0, e.target - e.tot());
/* 414 */       Employer.this.available.add(g, -am);
/* 415 */       e.add(g, am);
/* 416 */       if (Employer.this.log) {
/* 417 */         LOG.ln("ASSIGN A: " + String.valueOf(g.race) + " " + String.valueOf(g.type) + " " + am);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   void allocatePref(Employer.Bucket e, LIST<WGROUP> same) {
/* 423 */     double pref = 0.0D;
/* 424 */     for (WGROUP g : same) {
/* 425 */       double p = e.e.neededWorkers(g);
/* 426 */       if (p > 0.0D) {
/* 427 */         pref += p;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 432 */     int toAllocate = e.needed - e.tot();
/* 433 */     if (Employer.this.log) {
/* 434 */       LOG.ln("ASSIGN PREF ALLOCATING: " + (e.e.blueprint()).key + " " + e.needed + " " + e.tot() + " " + toAllocate + " " + same.size() + " " + pref);
/*     */     }
/* 436 */     if (pref == 0.0D) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 441 */     for (WGROUP g : same) {
/*     */       
/* 443 */       int am = (int)Math.ceil((e.e.neededWorkers(g) * e.e.neededWorkers(g)) / pref);
/* 444 */       am -= e.get(g);
/* 445 */       if (am > Employer.this.available.get(g))
/* 446 */         am = Employer.this.available.get(g); 
/* 447 */       int needed = e.needed - e.tot();
/* 448 */       if (am > needed)
/* 449 */         am = needed; 
/* 450 */       Employer.this.available.add(g, -am);
/* 451 */       e.add(g, am);
/* 452 */       if (Employer.this.log) {
/* 453 */         LOG.ln("ASSIGN AP: " + String.valueOf(g.race) + " " + String.valueOf(g.type) + " " + am + " " + e.e.neededWorkers());
/*     */       }
/*     */     } 
/* 456 */     for (WGROUP g : same) {
/*     */       
/* 458 */       int am = e.e.neededWorkers(g);
/* 459 */       am -= e.get(g);
/* 460 */       if (am > Employer.this.available.get(g))
/* 461 */         am = Employer.this.available.get(g); 
/* 462 */       int needed = e.needed - e.tot();
/* 463 */       if (am > needed)
/* 464 */         am = needed; 
/* 465 */       if (am > 0) {
/* 466 */         Employer.this.available.add(g, -am);
/* 467 */         e.add(g, am);
/* 468 */         if (Employer.this.log) {
/* 469 */           LOG.ln("ASSIGN AP topup: " + String.valueOf(g.race) + " " + String.valueOf(g.type) + " " + am + " " + e.e.neededWorkers());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 479 */     this.toBeAssigned.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\Employer$A_Assign.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */