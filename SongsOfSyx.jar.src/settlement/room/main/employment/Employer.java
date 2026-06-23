/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.WGROUP;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tree;
/*     */ 
/*     */ 
/*     */ final class Employer
/*     */ {
/*     */   private boolean log = false;
/*  18 */   private int state = 0;
/*     */   
/*     */   private final AA[] states;
/*     */   
/*     */   private boolean updateAll = false;
/*  23 */   private final Workers available = new Workers();
/*  24 */   private final Workers workforce = new Workers();
/*     */   
/*     */   private final Bucket[] buckets;
/*     */ 
/*     */   
/*     */   Employer(LIST<RoomEmployment> all) {
/*  30 */     this.buckets = new Bucket[all.size()];
/*  31 */     int bi = 0;
/*  32 */     for (RoomEmployment e : all) {
/*  33 */       this.buckets[bi++] = new Bucket(e);
/*     */     }
/*     */     
/*  36 */     this.states = new AA[] {
/*  37 */         new A_GInit(), 
/*  38 */         new A_Target(), 
/*  39 */         new A_Assign(), 
/*  40 */         new A_Assign_Extra(), 
/*  41 */         new A_Setter()
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void update() {
/*  56 */     if (this.updateAll) {
/*  57 */       byte b; int i; AA[] arrayOfAA; for (i = (arrayOfAA = this.states).length, b = 0; b < i; ) { AA s = arrayOfAA[b];
/*  58 */         s.clear(); b++; }
/*     */       
/*  60 */       this.state = 0;
/*  61 */       while (this.state < this.states.length) {
/*  62 */         if (!this.states[this.state].update())
/*     */         {
/*  64 */           this.state++;
/*     */         }
/*     */       } 
/*  67 */       this.state = 0;
/*  68 */       this.updateAll = false;
/*     */       
/*     */       return;
/*     */     } 
/*  72 */     if (GAME.SPEED.speed() == 0.0D) {
/*     */       return;
/*     */     }
/*  75 */     if ((GAME.updateI() & 0x7) == 0)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  81 */       if (!this.states[this.state].update()) {
/*     */         
/*  83 */         this.state++;
/*  84 */         this.state %= this.states.length;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAll() {
/*  92 */     this.updateAll = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class A_GInit
/*     */     implements AA
/*     */   {
/*     */     public boolean update() {
/* 107 */       Employer.this.available.clear();
/* 108 */       Employer.this.workforce.clear();
/* 109 */       for (WGROUP w : WGROUP.all()) {
/* 110 */         Employer.this.available.add(w, STATS.WORK().workforce(w));
/* 111 */         Employer.this.workforce.add(w, STATS.WORK().workforce(w));
/*     */       } 
/* 113 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {}
/*     */   }
/*     */ 
/*     */   
/*     */   private class A_Target
/*     */     implements AA
/*     */   {
/*     */     private ArrayList<Employer.Bucket> samePrio;
/*     */     
/*     */     private final Tree<Employer.Bucket> sort;
/*     */     private int a;
/*     */     
/*     */     private A_Target() {
/* 130 */       this.samePrio = new ArrayList(Employer.this.buckets.length);
/* 131 */       this.sort = new Tree<Employer.Bucket>(Employer.this.buckets.length)
/*     */         {
/*     */           protected boolean isGreaterThan(Employer.Bucket current, Employer.Bucket cmp) {
/* 134 */             return (current.prio * (Employer.A_Target.access$0(Employer.A_Target.this)).buckets.length + current.e.index() > cmp.prio * (Employer.A_Target.access$0(Employer.A_Target.this)).buckets.length + cmp.e.index());
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean update() {
/* 143 */       if (!this.sort.hasMore()) {
/* 144 */         this.a = Employer.this.available.tot(); byte b; int i;
/*     */         Employer.Bucket[] arrayOfBucket;
/* 146 */         for (i = (arrayOfBucket = Employer.this.buckets).length, b = 0; b < i; ) { Employer.Bucket e = arrayOfBucket[b];
/* 147 */           e.clear();
/*     */           
/* 149 */           if (e.needed > 0) {
/* 150 */             this.sort.add(e);
/* 151 */             if (Employer.this.log)
/* 152 */               LOG.ln("TARGET adding: " + (e.e.blueprint()).key + " " + e.needed); 
/*     */           } 
/*     */           b++; }
/*     */         
/* 156 */         if (!this.sort.hasMore())
/* 157 */           return false; 
/* 158 */         return true;
/*     */       } 
/* 160 */       Employer.Bucket f = (Employer.Bucket)this.sort.pollGreatest();
/* 161 */       this.samePrio.clearSloppy();
/* 162 */       this.samePrio.add(f);
/* 163 */       while (this.sort.hasMore() && ((Employer.Bucket)this.sort.greatest()).e.priority.get() == f.e.priority.get()) {
/* 164 */         this.samePrio.add(this.sort.pollGreatest());
/*     */       }
/*     */       
/* 167 */       int needed = 0;
/* 168 */       for (Employer.Bucket e : this.samePrio) {
/* 169 */         needed += e.e.neededWorkers();
/*     */       }
/*     */       
/* 172 */       double d = this.a / needed;
/* 173 */       d = CLAMP.d(d, 0.0D, 1.0D);
/*     */       
/* 175 */       if (Employer.this.log) {
/* 176 */         LOG.ln("TARGET avaliable: " + this.a + "/" + needed + " " + d + " " + this.sort.hasMore());
/*     */       }
/*     */       
/* 179 */       for (Employer.Bucket e : this.samePrio) {
/* 180 */         int t = (int)Math.ceil(e.e.neededWorkers() * d);
/* 181 */         t = CLAMP.i(t, 0, this.a);
/* 182 */         this.a -= t;
/* 183 */         e.target = t;
/* 184 */         if (Employer.this.log && t > 0) {
/* 185 */           LOG.ln("TARGET " + (e.e.blueprint()).key + " " + t);
/*     */         }
/*     */       } 
/* 188 */       return this.sort.hasMore();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 193 */       this.sort.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   private class A_Assign
/*     */     implements AA
/*     */   {
/*     */     private final ArrayList<WGROUP> same;
/*     */     private final Tree<Employer.Bucket> toBeAssigned;
/*     */     
/*     */     private A_Assign() {
/* 204 */       this.same = new ArrayList(WGROUP.all().size());
/*     */       
/* 206 */       this.toBeAssigned = new Tree<Employer.Bucket>(Employer.this.buckets.length)
/*     */         {
/*     */           protected boolean isGreaterThan(Employer.Bucket current, Employer.Bucket cmp) {
/* 209 */             return (current.prio2 * (Employer.A_Assign.access$0(Employer.A_Assign.this)).buckets.length + current.e.index() > cmp.prio2 * (Employer.A_Assign.access$0(Employer.A_Assign.this)).buckets.length + cmp.e.index());
/*     */           }
/*     */         };
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean update() {
/* 217 */       if (!this.toBeAssigned.hasMore()) {
/*     */         byte b1; int i; Employer.Bucket[] arrayOfBucket;
/* 219 */         for (i = (arrayOfBucket = Employer.this.buckets).length, b1 = 0; b1 < i; ) { Employer.Bucket bucket = arrayOfBucket[b1];
/* 220 */           if (bucket.target > 0) {
/* 221 */             int hi = 0;
/* 222 */             for (int gi = 0; gi < WGROUP.all().size(); gi++) {
/* 223 */               WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 224 */               if (Employer.this.workforce.get(g) > 0)
/* 225 */                 hi = Math.max(hi, bucket.e.priorities.get(g)); 
/*     */             } 
/* 227 */             bucket.prio2 = hi;
/* 228 */             this.toBeAssigned.add(bucket);
/*     */           }  b1++; }
/*     */         
/* 231 */         return (this.toBeAssigned.size() > 0);
/*     */       } 
/*     */       
/* 234 */       Employer.Bucket b = (Employer.Bucket)this.toBeAssigned.pollGreatest();
/*     */       
/* 236 */       if (assign(b)) {
/* 237 */         int hi = 0;
/* 238 */         for (int gi = 0; gi < WGROUP.all().size(); gi++) {
/* 239 */           WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 240 */           if (Employer.this.available.get(g) > 0)
/* 241 */             hi = Math.max(hi, b.e.priorities.get(g)); 
/*     */         } 
/* 243 */         b.prio2 = hi;
/* 244 */         this.toBeAssigned.add(b);
/*     */       } 
/*     */       
/* 247 */       return this.toBeAssigned.hasMore();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean assign(Employer.Bucket b) {
/* 253 */       if (Employer.this.log) {
/* 254 */         LOG.ln("ASSIGN assigning: " + (b.e.blueprint()).key + " " + b.prio);
/*     */       }
/*     */       
/* 257 */       if (b.tot() >= b.target) {
/* 258 */         if (Employer.this.log) {
/* 259 */           LOG.ln("ASSIGN done");
/*     */         }
/* 261 */         return false;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 266 */       int hi = 0;
/* 267 */       this.same.clearSloppy();
/*     */       int gi;
/* 269 */       for (gi = 0; gi < WGROUP.all().size(); gi++) {
/* 270 */         WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 271 */         if (Employer.this.workforce.get(g) > 0) {
/* 272 */           hi = Math.max(hi, b.e.priorities.get(g));
/*     */         }
/*     */       } 
/* 275 */       if (hi == 0) {
/* 276 */         if (Employer.this.log) {
/* 277 */           LOG.ln("no one can work here");
/*     */         }
/*     */         
/* 280 */         return false;
/*     */       } 
/*     */ 
/*     */       
/* 284 */       hi = 0;
/* 285 */       for (gi = 0; gi < WGROUP.all().size(); gi++) {
/* 286 */         WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 287 */         if (Employer.this.available.get(g) > 0) {
/* 288 */           hi = Math.max(hi, b.e.priorities.get(g));
/*     */         }
/*     */       } 
/* 291 */       if (hi == 0) {
/*     */         
/* 293 */         if (Employer.this.log) {
/* 294 */           LOG.ln("special crap");
/*     */         }
/*     */         
/* 297 */         this.same.clearSloppy();
/* 298 */         for (WGROUP g : WGROUP.all()) {
/* 299 */           if (Employer.this.workforce.get(g) > 0 && b.e.priorities.get(g) > 0) {
/* 300 */             this.same.add(g);
/* 301 */             if (Employer.this.log) {
/* 302 */               LOG.ln("  candidate -> " + g.toString());
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 307 */         for (gi = 0; gi < WGROUP.all().size(); gi++) {
/* 308 */           WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 309 */           if (Employer.this.available.get(g) > 0) {
/* 310 */             if (Employer.this.log) {
/* 311 */               LOG.ln("  pushing -> " + g.toString());
/*     */             }
/* 313 */             if (pushIn(b, g, (LIST<WGROUP>)this.same)) {
/* 314 */               if (Employer.this.log) {
/* 315 */                 LOG.ln("  pushed -> " + g.toString() + " " + b.tot() + "/" + b.target);
/*     */               }
/* 317 */               return true;
/*     */             } 
/*     */             
/* 320 */             return false;
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 325 */         return false;
/*     */       } 
/*     */       
/* 328 */       for (gi = 0; gi < WGROUP.all().size(); gi++) {
/* 329 */         WGROUP g = (WGROUP)WGROUP.all().get(gi);
/* 330 */         if (Employer.this.available.get(g) > 0 && hi == b.e.priorities.get(g)) {
/* 331 */           this.same.add(g);
/*     */         }
/*     */       } 
/* 334 */       if (Employer.this.log) {
/* 335 */         LOG.ln("ASSIGN normal allocation");
/*     */       }
/*     */       
/* 338 */       allocate(b, (LIST<WGROUP>)this.same, hi);
/* 339 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean pushIn(Employer.Bucket missingWorkplace, WGROUP toPushIn, LIST<WGROUP> candidates) {
/* 346 */       Employer.Bucket target = null;
/* 347 */       WGROUP toPushOut = null;
/* 348 */       int bestPrio = Integer.MIN_VALUE; byte b; int i;
/*     */       Employer.Bucket[] arrayOfBucket;
/* 350 */       for (i = (arrayOfBucket = Employer.this.buckets).length, b = 0; b < i; ) { Employer.Bucket bucket = arrayOfBucket[b];
/* 351 */         if (bucket != missingWorkplace) {
/*     */           
/* 353 */           int p = bucket.e.priorities.get(toPushIn);
/* 354 */           if (p != 0)
/*     */           {
/* 356 */             if (bucket.get(toPushIn) < bucket.tot())
/*     */             {
/*     */               
/* 359 */               for (WGROUP g : candidates) {
/* 360 */                 if (bucket.get(g) > 0 && g != toPushIn) {
/* 361 */                   int po = missingWorkplace.e.priorities.get(g);
/* 362 */                   if (po > 0) {
/* 363 */                     int prio = po - bucket.e.priorities.get(g);
/* 364 */                     prio += bucket.e.priorities.get(toPushOut) - p;
/* 365 */                     if (prio > bestPrio) {
/* 366 */                       target = bucket;
/* 367 */                       toPushOut = g;
/* 368 */                       bestPrio = prio;
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             }
/*     */           }
/*     */         } 
/*     */         b++; }
/*     */       
/* 378 */       if (target != null) {
/* 379 */         int am = target.get(toPushOut);
/* 380 */         am = CLAMP.i(am, 0, Employer.this.available.get(toPushIn));
/* 381 */         am = CLAMP.i(am, 0, missingWorkplace.target - missingWorkplace.tot());
/* 382 */         if (Employer.this.log) {
/* 383 */           LOG.ln("  pusham : " + am + " " + String.valueOf(toPushOut) + " " + Employer.this.available.get(toPushOut) + " -> " + String.valueOf(toPushIn));
/*     */         }
/* 385 */         target.add(toPushOut, -am);
/* 386 */         target.add(toPushIn, am);
/* 387 */         Employer.this.available.add(toPushOut, am);
/* 388 */         Employer.this.available.add(toPushIn, -am);
/* 389 */         return true;
/*     */       } 
/*     */       
/* 392 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     void allocate(Employer.Bucket e, LIST<WGROUP> same, int prio) {
/* 397 */       allocatePref(e, same);
/*     */       
/* 399 */       int toAllocate = e.target - e.tot();
/* 400 */       int av = 0;
/* 401 */       for (WGROUP g : same) {
/* 402 */         av += CLAMP.i(Employer.this.available.get(g), 0, toAllocate);
/*     */       }
/*     */       
/* 405 */       double d = toAllocate / av;
/* 406 */       d = CLAMP.d(d, 0.0D, 1.0D);
/*     */       
/* 408 */       if (Employer.this.log) {
/* 409 */         LOG.ln("ASSIGN ALLOCATING: " + (e.e.blueprint()).key + " " + e.target + " " + prio + " " + d + " " + same.size());
/*     */       }
/* 411 */       for (WGROUP g : same) {
/* 412 */         int am = (int)Math.ceil(Employer.this.available.get(g) * d);
/* 413 */         am = CLAMP.i(am, 0, e.target - e.tot());
/* 414 */         Employer.this.available.add(g, -am);
/* 415 */         e.add(g, am);
/* 416 */         if (Employer.this.log) {
/* 417 */           LOG.ln("ASSIGN A: " + String.valueOf(g.race) + " " + String.valueOf(g.type) + " " + am);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     void allocatePref(Employer.Bucket e, LIST<WGROUP> same) {
/* 423 */       double pref = 0.0D;
/* 424 */       for (WGROUP g : same) {
/* 425 */         double p = e.e.neededWorkers(g);
/* 426 */         if (p > 0.0D) {
/* 427 */           pref += p;
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 432 */       int toAllocate = e.needed - e.tot();
/* 433 */       if (Employer.this.log) {
/* 434 */         LOG.ln("ASSIGN PREF ALLOCATING: " + (e.e.blueprint()).key + " " + e.needed + " " + e.tot() + " " + toAllocate + " " + same.size() + " " + pref);
/*     */       }
/* 436 */       if (pref == 0.0D) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 441 */       for (WGROUP g : same) {
/*     */         
/* 443 */         int am = (int)Math.ceil((e.e.neededWorkers(g) * e.e.neededWorkers(g)) / pref);
/* 444 */         am -= e.get(g);
/* 445 */         if (am > Employer.this.available.get(g))
/* 446 */           am = Employer.this.available.get(g); 
/* 447 */         int needed = e.needed - e.tot();
/* 448 */         if (am > needed)
/* 449 */           am = needed; 
/* 450 */         Employer.this.available.add(g, -am);
/* 451 */         e.add(g, am);
/* 452 */         if (Employer.this.log) {
/* 453 */           LOG.ln("ASSIGN AP: " + String.valueOf(g.race) + " " + String.valueOf(g.type) + " " + am + " " + e.e.neededWorkers());
/*     */         }
/*     */       } 
/* 456 */       for (WGROUP g : same) {
/*     */         
/* 458 */         int am = e.e.neededWorkers(g);
/* 459 */         am -= e.get(g);
/* 460 */         if (am > Employer.this.available.get(g))
/* 461 */           am = Employer.this.available.get(g); 
/* 462 */         int needed = e.needed - e.tot();
/* 463 */         if (am > needed)
/* 464 */           am = needed; 
/* 465 */         if (am > 0) {
/* 466 */           Employer.this.available.add(g, -am);
/* 467 */           e.add(g, am);
/* 468 */           if (Employer.this.log) {
/* 469 */             LOG.ln("ASSIGN AP topup: " + String.valueOf(g.race) + " " + String.valueOf(g.type) + " " + am + " " + e.e.neededWorkers());
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void clear() {
/* 479 */       this.toBeAssigned.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   private class A_Assign_Extra implements AA {
/*     */     private final Tree<Employer.Bucket> toBeAssigned;
/*     */     private final ArrayList<WGROUP> same;
/*     */     
/*     */     private A_Assign_Extra() {
/* 488 */       this.toBeAssigned = new Tree<Employer.Bucket>(Employer.this.buckets.length)
/*     */         {
/*     */           protected boolean isGreaterThan(Employer.Bucket current, Employer.Bucket cmp) {
/* 491 */             return (current.prio * (Employer.A_Assign_Extra.access$0(Employer.A_Assign_Extra.this)).buckets.length + current.e.index() > cmp.prio * (Employer.A_Assign_Extra.access$0(Employer.A_Assign_Extra.this)).buckets.length + cmp.e.index());
/*     */           }
/*     */         };
/*     */       
/* 495 */       this.same = new ArrayList(WGROUP.all().size());
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean update() {
/* 500 */       if (!this.toBeAssigned.hasMore()) {
/*     */         byte b1; int i; Employer.Bucket[] arrayOfBucket;
/* 502 */         for (i = (arrayOfBucket = Employer.this.buckets).length, b1 = 0; b1 < i; ) { Employer.Bucket bucket = arrayOfBucket[b1];
/* 503 */           if (bucket.tot() < bucket.needed)
/* 504 */             this.toBeAssigned.add(bucket);  b1++; }
/*     */         
/* 506 */         if (Employer.this.log)
/* 507 */           for (WGROUP g : WGROUP.all()) {
/* 508 */             if (Employer.this.available.get(g) > 0) {
/* 509 */               LOG.ln(String.valueOf(g) + " " + String.valueOf(g));
/*     */             }
/*     */           }  
/* 512 */         return (this.toBeAssigned.size() > 0);
/*     */       } 
/*     */       
/* 515 */       Employer.Bucket b = (Employer.Bucket)this.toBeAssigned.pollGreatest();
/*     */       
/* 517 */       if (assign(b)) {
/* 518 */         this.toBeAssigned.add(b);
/*     */       }
/*     */       
/* 521 */       return this.toBeAssigned.hasMore();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean assign(Employer.Bucket b) {
/* 527 */       if (Employer.this.log) {
/* 528 */         LOG.ln("assigning: " + (b.e.blueprint()).key);
/*     */       }
/*     */       
/* 531 */       if (b.tot() >= b.needed) {
/* 532 */         if (Employer.this.log) {
/* 533 */           LOG.ln("done done");
/*     */         }
/* 535 */         return false;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 540 */       int hi = 0;
/*     */       
/* 542 */       this.same.clearSloppy();
/*     */       
/* 544 */       for (WGROUP g : WGROUP.all()) {
/* 545 */         if (Employer.this.available.get(g) > 0) {
/* 546 */           hi = Math.max(hi, b.e.priorities.get(g));
/*     */         }
/*     */       } 
/* 549 */       if (hi == 0) {
/* 550 */         if (Employer.this.log) {
/* 551 */           LOG.ln("no workers");
/*     */         }
/* 553 */         return false;
/*     */       } 
/*     */       
/* 556 */       for (WGROUP g : WGROUP.all()) {
/* 557 */         if (Employer.this.available.get(g) > 0 && hi == b.e.priorities.get(g)) {
/* 558 */           this.same.add(g);
/*     */         }
/*     */       } 
/* 561 */       if (Employer.this.log) {
/* 562 */         LOG.ln("normal allocation2");
/*     */       }
/*     */       
/* 565 */       allocate(b, (LIST<WGROUP>)this.same, hi);
/* 566 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void allocate(Employer.Bucket e, LIST<WGROUP> same, int prio) {
/* 574 */       int toAllocate = e.needed - e.tot();
/* 575 */       int av = 0;
/*     */ 
/*     */       
/* 578 */       for (WGROUP g : same) {
/* 579 */         av += CLAMP.i(Employer.this.available.get(g), 0, toAllocate);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 584 */       if (Employer.this.log) {
/* 585 */         LOG.ln("ALLOCATING: " + (e.e.blueprint()).key + " " + e.needed + " " + e.tot() + " " + toAllocate + " " + same.size() + " " + av);
/*     */       }
/* 587 */       double d = toAllocate / av;
/* 588 */       d = CLAMP.d(d, 0.0D, 1.0D);
/*     */ 
/*     */ 
/*     */       
/* 592 */       for (WGROUP g : same) {
/* 593 */         int am = (int)Math.ceil(Employer.this.available.get(g) * d);
/* 594 */         int needed = e.needed - e.tot();
/* 595 */         am = CLAMP.i(am, 0, needed);
/* 596 */         Employer.this.available.add(g, -am);
/* 597 */         e.add(g, am);
/* 598 */         if (Employer.this.log) {
/* 599 */           LOG.ln("A: " + String.valueOf(g.race) + " " + String.valueOf(g.type) + " " + am);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     public void clear() {
/* 605 */       this.toBeAssigned.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   private class A_Setter
/*     */     implements AA {
/*     */     int ei;
/*     */     
/*     */     private A_Setter() {
/* 614 */       this.ei = 0;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean update() {
/* 620 */       Employer.Bucket e = Employer.this.buckets[this.ei];
/* 621 */       e.e.target.clear();
/* 622 */       if (Employer.this.log) {
/* 623 */         LOG.ln("SET " + (e.e.blueprint()).key + " " + e.needed + " " + e.target + " " + e.tot());
/*     */       }
/* 625 */       for (WGROUP g : WGROUP.all()) {
/*     */         
/* 627 */         if (e.get(g) > 0) {
/* 628 */           e.e.target.add(g, e.get(g));
/* 629 */           if (Employer.this.log) {
/* 630 */             LOG.ln("   " + g.toString() + " -> " + e.get(g));
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 635 */       this.ei++;
/* 636 */       if (this.ei >= Employer.this.buckets.length) {
/* 637 */         this.ei = 0;
/* 638 */         return false;
/*     */       } 
/* 640 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 645 */       this.ei = 0;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Workers
/*     */   {
/* 653 */     private final int[] amount = Alloc.ii(WGROUP.all().size());
/* 654 */     private int total = 0;
/*     */     
/*     */     public void clear() {
/* 657 */       Arrays.fill(this.amount, 0);
/* 658 */       this.total = 0;
/*     */     }
/*     */     
/*     */     public void add(WGROUP w, int workforce) {
/* 662 */       this.amount[w.index()] = this.amount[w.index()] + workforce;
/* 663 */       this.total += workforce;
/*     */     }
/*     */     
/*     */     public int get(WGROUP g) {
/* 667 */       return this.amount[g.index()];
/*     */     }
/*     */     
/*     */     public int tot() {
/* 671 */       return this.total;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Bucket
/*     */     extends Workers
/*     */   {
/*     */     public final RoomEmployment e;
/* 679 */     public int target = 0;
/* 680 */     public int prio = 0;
/* 681 */     public int prio2 = 0;
/*     */     
/*     */     private int needed;
/*     */     
/*     */     Bucket(RoomEmployment e) {
/* 686 */       this.e = e;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void clear() {
/* 692 */       this.target = 0;
/* 693 */       this.prio = this.e.priority.get();
/* 694 */       this.needed = this.e.neededWorkers();
/* 695 */       super.clear();
/*     */     }
/*     */   }
/*     */   
/*     */   private static interface AA {
/*     */     boolean update();
/*     */     
/*     */     void clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\Employer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */