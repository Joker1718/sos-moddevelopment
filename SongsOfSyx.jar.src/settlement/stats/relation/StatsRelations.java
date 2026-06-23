/*     */ package settlement.stats.relation;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.IntegerStack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ import world.army.AD;
/*     */ 
/*     */ public class StatsRelations
/*     */ {
/*     */   private final INT_O.INT_OE<Induvidual> ref;
/*  38 */   private IntegerStack free = new IntegerStack(40000);
/*     */   
/*  40 */   private long[] datas = new long[40000];
/*  41 */   private int[] parents = Alloc.ii(40000);
/*  42 */   private int[] names = Alloc.ii(40000);
/*     */   
/*  44 */   private final Bits b_id = new Bits(4294967295L);
/*  45 */   private final Bits b_gender = new Bits(15L);
/*  46 */   private final Bits b_race = new Bits(4080L);
/*  47 */   private final Bits b_type = new Bits(1044480L);
/*  48 */   private final Bits b_cause = new Bits(267386880L);
/*  49 */   private final Bits b_deathYear = new Bits(17591917608960L);
/*  50 */   private final Bits b_deathAge = new Bits(1152903912420802560L);
/*  51 */   private final Bits b_idType = new Bits(-1152921504606846976L);
/*     */   
/*     */   private static final int THuman = 1;
/*     */   
/*     */   private static final int TDead = 2;
/*     */   private static final int TSoldier = 3;
/*     */   
/*     */   public StatsRelations(StatsInit init) {
/*  59 */     init.count.getClass(); this.ref = (INT_O.INT_OE<Induvidual>)new DataO<Induvidual>.DataInt(init.count, "RELATION_DATA")
/*     */       {
/*     */         public void set(Induvidual t, int s) {
/*  62 */           int ref = get(t);
/*  63 */           if (ref != s && ref > 0 && ref < StatsRelations.this.datas.length) {
/*  64 */             StatsRelations.this.datas[ref] = 0L;
/*  65 */             StatsRelations.this.parents[ref] = 0;
/*  66 */             StatsRelations.this.names[ref] = 0;
/*  67 */             StatsRelations.this.free.push(ref);
/*     */           } 
/*  69 */           super.set(t, s);
/*     */         }
/*     */       };
/*  72 */     for (int i = 1; i < this.datas.length; i++) {
/*  73 */       this.free.push(i);
/*     */     }
/*  75 */     if (this.b_race.mask < RACES.all().size())
/*  76 */       throw new RuntimeException(); 
/*  77 */     if (this.b_type.mask < HTYPES.ALL().size())
/*  78 */       throw new RuntimeException(); 
/*  79 */     if (this.b_cause.mask < CAUSE_LEAVES.ALL().size()) {
/*  80 */       throw new RuntimeException();
/*     */     }
/*  82 */     init.savers.put("RELATIONS", new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/*  86 */             file.i(StatsRelations.this.datas.length);
/*  87 */             file.ls(StatsRelations.this.datas);
/*  88 */             file.is(StatsRelations.this.parents);
/*  89 */             file.is(StatsRelations.this.names);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/*  94 */             int am = file.i();
/*  95 */             StatsRelations.this.datas = new long[am];
/*  96 */             StatsRelations.this.parents = Alloc.ii(am);
/*  97 */             StatsRelations.this.names = Alloc.ii(am);
/*  98 */             file.ls(StatsRelations.this.datas);
/*  99 */             file.is(StatsRelations.this.parents);
/* 100 */             file.is(StatsRelations.this.names);
/* 101 */             StatsRelations.this.free = new IntegerStack(am);
/*     */             
/* 103 */             for (int i = 1; i < am; i++) {
/* 104 */               if (StatsRelations.this.b_idType.get(i) == 0) {
/* 105 */                 StatsRelations.this.free.push(i);
/*     */               }
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void clear() {
/* 113 */             StatsRelations.this.free = new IntegerStack(40000);
/* 114 */             StatsRelations.this.datas = new long[40000];
/* 115 */             StatsRelations.this.parents = Alloc.ii(40000);
/* 116 */             StatsRelations.this.names = Alloc.ii(40000);
/* 117 */             for (int i = 1; i < StatsRelations.this.datas.length; i++) {
/* 118 */               StatsRelations.this.free.push(i);
/*     */             }
/*     */           }
/*     */         });
/* 122 */     init.copier.add(this.ref);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int createReference(Induvidual indu) {
/* 131 */     if (this.ref.get(indu) > 0 && this.ref.get(indu) < this.datas.length) {
/* 132 */       return this.ref.get(indu);
/*     */     }
/*     */     
/* 135 */     while (!this.free.isEmpty()) {
/* 136 */       int ref = this.free.pop();
/* 137 */       if (ref != 0) {
/* 138 */         return makeNewRef(ref, indu);
/*     */       }
/*     */     } 
/*     */     
/* 142 */     if (this.datas.length < 320000) {
/*     */       
/* 144 */       int length = this.datas.length + 40000;
/*     */       
/* 146 */       long[] nd = new long[length];
/* 147 */       int[] np = Alloc.ii(length);
/* 148 */       int[] ny = Alloc.ii(length);
/*     */       
/*     */       int i;
/*     */       
/* 152 */       for (i = 0; i < this.datas.length; i++) {
/* 153 */         nd[i] = this.datas[i];
/* 154 */         np[i] = this.parents[i];
/* 155 */         ny[i] = this.names[i];
/*     */       } 
/*     */       
/* 158 */       this.datas = nd;
/* 159 */       this.parents = np;
/* 160 */       this.names = ny;
/* 161 */       this.free = new IntegerStack(length);
/* 162 */       for (i = 1; i < length; i++) {
/* 163 */         if (this.b_idType.get(i) == 0) {
/* 164 */           this.free.push(i);
/*     */         }
/*     */       } 
/* 167 */       return makeNewRef(this.free.pop(), indu);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 172 */     prune();
/*     */ 
/*     */     
/* 175 */     while (!this.free.isEmpty()) {
/* 176 */       int ref = this.free.pop();
/* 177 */       if (ref != 0) {
/* 178 */         return makeNewRef(ref, indu);
/*     */       }
/*     */     } 
/* 181 */     throw new RuntimeException("No more references available even after pruning");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void prune() {
/* 188 */     int aliveOnes = 0;
/*     */     
/* 190 */     for (int i = 1; i < this.datas.length; i++) {
/* 191 */       if (indu(i) != null) {
/* 192 */         aliveOnes++;
/*     */       }
/*     */     } 
/*     */     
/* 196 */     int depth = 160000 / aliveOnes;
/*     */     
/* 198 */     Bitmap1D keepAlive = new Bitmap1D(this.datas.length, false);
/*     */     int j;
/* 200 */     for (j = 1; j < this.datas.length; j++) {
/* 201 */       if (indu(j) != null) {
/* 202 */         keepAlive.set(j, true);
/*     */       }
/* 204 */       int pi = 0;
/* 205 */       int ref = j;
/* 206 */       while (pi < depth && hasParent(ref)) {
/* 207 */         pi++;
/* 208 */         ref = parentRef(ref);
/* 209 */         if (keepAlive.get(ref))
/*     */           break; 
/* 211 */         keepAlive.set(ref, true);
/*     */       } 
/*     */     } 
/*     */     
/* 215 */     for (j = 1; j < this.datas.length; j++) {
/* 216 */       if (!keepAlive.get(j)) {
/*     */ 
/*     */         
/* 219 */         this.datas[j] = 0L;
/* 220 */         this.parents[j] = 0;
/* 221 */         this.names[j] = 0;
/* 222 */         this.free.push(j);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private int makeNewRef(int ref, Induvidual i) {
/* 228 */     if (ref == 0)
/* 229 */       throw new RuntimeException(); 
/* 230 */     this.datas[ref] = 0L;
/* 231 */     this.parents[ref] = 0;
/* 232 */     this.names[ref] = 0;
/* 233 */     this.ref.set(i, ref);
/* 234 */     return ref;
/*     */   }
/*     */   
/*     */   public int reference(Induvidual indu) {
/* 238 */     return this.ref.get(indu);
/*     */   }
/*     */   
/*     */   public boolean hasParent(Induvidual indu) {
/* 242 */     return hasParent(reference(indu));
/*     */   }
/*     */   
/*     */   public int parentRef(Induvidual indu) {
/* 246 */     return parentRef(reference(indu));
/*     */   }
/*     */   
/*     */   public boolean hasParent(int ref) {
/* 250 */     if (ref <= 0 || ref >= this.datas.length)
/* 251 */       return false; 
/* 252 */     ref = this.parents[ref];
/* 253 */     if (ref <= 0 || ref >= this.datas.length)
/* 254 */       return false; 
/* 255 */     return true;
/*     */   }
/*     */   
/*     */   public int parentRef(int ref) {
/* 259 */     if (ref <= 0 || ref >= this.datas.length)
/* 260 */       return 0; 
/* 261 */     return this.parents[ref];
/*     */   }
/*     */ 
/*     */   
/*     */   public int superParentRef(int ref) {
/* 266 */     for (int i = 0; i < 1000 && hasParent(ref); i++)
/* 267 */       ref = parentRef(ref); 
/* 268 */     return ref;
/*     */   }
/*     */   
/*     */   public Humanoid humanParent(Humanoid h) {
/* 272 */     int ref = reference(h.indu());
/* 273 */     if (!hasParent(ref))
/* 274 */       return null; 
/* 275 */     return human(parentRef(ref));
/*     */   }
/*     */ 
/*     */   
/*     */   public Humanoid human(int ref) {
/* 280 */     if (this.b_idType.get(ref) == 1) {
/* 281 */       return phuman(ref);
/*     */     }
/* 283 */     return null;
/*     */   }
/*     */   
/*     */   private Humanoid phuman(int ref) {
/* 287 */     ENTITY e = SETT.ENTITIES().getByID(this.b_id.get(ref));
/* 288 */     if (e != null && e instanceof Humanoid) {
/* 289 */       return (Humanoid)e;
/*     */     }
/* 291 */     return null;
/*     */   }
/*     */   
/*     */   public Induvidual indu(int ref) {
/* 295 */     if (this.b_idType.get(ref) == 1) {
/* 296 */       Humanoid h = phuman(ref);
/* 297 */       if (h != null)
/* 298 */         return h.indu(); 
/* 299 */     } else if (this.b_idType.get(ref) == 3) {
/* 300 */       return AD.cityDivs().getSoldier(this.b_id.get(ref));
/*     */     } 
/* 302 */     return null;
/*     */   }
/*     */   
/*     */   public boolean hasIndu(int ref) {
/* 306 */     if (this.b_idType.get(ref) == 1)
/* 307 */       return true; 
/* 308 */     if (this.b_idType.get(ref) == 3) {
/* 309 */       return true;
/*     */     }
/* 311 */     return false;
/*     */   }
/*     */   
/*     */   public CharSequence name(int ref) {
/* 315 */     if (hasIndu(ref)) {
/* 316 */       Induvidual i = indu(ref);
/* 317 */       if (i != null) {
/* 318 */         return STATS.APPEARANCE().name(i);
/*     */       }
/* 320 */       return "error " + this.b_idType.get(ref);
/*     */     } 
/*     */     
/* 323 */     return STATS.APPEARANCE().name(race(ref), type(ref), this.b_gender.get(ref), this.names[ref]);
/*     */   }
/*     */   
/*     */   public Race race(int ref) {
/* 327 */     if (hasIndu(ref)) {
/* 328 */       Induvidual i = indu(ref);
/* 329 */       if (i != null) {
/* 330 */         return i.race();
/*     */       }
/* 332 */       return (Race)RACES.all().last();
/*     */     } 
/*     */     
/* 335 */     return (Race)RACES.all().get(this.b_race.get(ref));
/*     */   }
/*     */   
/*     */   public HTYPE type(int ref) {
/* 339 */     if (hasIndu(ref)) {
/* 340 */       Induvidual i = indu(ref);
/* 341 */       if (i != null) {
/* 342 */         return i.hType();
/*     */       }
/* 344 */       return HTYPES.PRISONER();
/*     */     } 
/*     */     
/* 347 */     return (HTYPE)HTYPES.ALL().getC(this.b_type.get(ref));
/*     */   }
/*     */   
/*     */   public int gender(int ref) {
/* 351 */     if (hasIndu(ref)) {
/* 352 */       Induvidual i = indu(ref);
/* 353 */       if (i != null) {
/* 354 */         return (STATS.APPEARANCE()).gender.get(i);
/*     */       }
/* 356 */       return 0;
/*     */     } 
/*     */     
/* 359 */     return this.b_gender.get(ref);
/*     */   }
/*     */   
/*     */   public CAUSE_LEAVE death(int ref) {
/* 363 */     if (this.b_idType.get(ref) == 2) {
/* 364 */       return (CAUSE_LEAVE)CAUSE_LEAVES.ALL().get(this.b_cause.get(ref));
/*     */     }
/* 366 */     return null;
/*     */   }
/*     */   
/*     */   public int age(int ref) {
/* 370 */     if (hasIndu(ref)) {
/* 371 */       Induvidual i = indu(ref);
/* 372 */       if (i != null) {
/* 373 */         return (int)(STATS.POP()).age.years.getD(i);
/*     */       }
/* 375 */       return -1;
/*     */     } 
/*     */     
/* 378 */     return this.b_deathAge.get(ref);
/*     */   }
/*     */   
/*     */   public int birthYear(int ref) {
/* 382 */     if (hasIndu(ref)) {
/* 383 */       Induvidual i = indu(ref);
/* 384 */       if (i != null) {
/* 385 */         return TIME.years().bitsSinceStart() - (int)(STATS.POP()).age.years.getD(i);
/*     */       }
/* 387 */       return 999;
/*     */     } 
/*     */     
/* 390 */     return this.b_deathYear.get(ref) - age(ref);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParent(Induvidual child, Induvidual parent) {
/* 396 */     setParent(child, this.ref.get(parent));
/*     */   }
/*     */ 
/*     */   
/*     */   public void setParent(Induvidual child, int parent) {
/* 401 */     if (!isRef(this.ref.get(child)) || !isRef(parent)) {
/*     */       return;
/*     */     }
/*     */     
/* 405 */     if (this.ref.get(child) == parent) {
/*     */       return;
/*     */     }
/* 408 */     this.parents[this.ref.get(child)] = parent;
/* 409 */     if (indu(parent) != null) {
/* 410 */       (STATS.APPEARANCE()).nameLast.copy(child, (STATS.APPEARANCE()).nameData.get(indu(parent)));
/*     */     } else {
/* 412 */       (STATS.APPEARANCE()).nameLast.copy(child, this.names[parent]);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDeath(Induvidual i, CAUSE_LEAVE causel) {
/* 417 */     int ref = createReference(i);
/* 418 */     if (ref == 0) {
/*     */       return;
/*     */     }
/* 421 */     this.datas[ref] = 0L;
/* 422 */     this.b_idType.set(ref, 2L);
/* 423 */     this.b_gender.set(ref, (STATS.APPEARANCE()).gender.get(i));
/* 424 */     this.names[ref] = (STATS.APPEARANCE()).nameData.get(i);
/* 425 */     this.b_type.set(ref, i.hType().index());
/* 426 */     this.b_race.set(ref, (i.race()).index);
/* 427 */     this.b_cause.set(ref, causel.index());
/*     */     
/* 429 */     this.b_deathYear.set(ref, TIME.years().bitsSinceStart() & this.b_deathYear.mask);
/*     */     
/* 431 */     int a = (int)Math.round((STATS.POP()).age.years.getD(i));
/* 432 */     a = CLAMP.i(a, 0, (int)this.b_deathAge.mask);
/* 433 */     this.b_deathAge.set(ref, a);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSoldier(Induvidual i, int storedId) {
/* 439 */     int ref = createReference(i);
/* 440 */     if (ref == 0)
/*     */       return; 
/* 442 */     this.datas[ref] = 0L;
/* 443 */     this.b_idType.set(ref, 3L);
/* 444 */     this.b_id.set(ref, storedId);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setHumanoid(Humanoid h) {
/* 449 */     int ref = createReference(h.indu());
/* 450 */     if (ref == 0)
/*     */       return; 
/* 452 */     this.datas[ref] = 0L;
/* 453 */     this.b_idType.set(ref, 1L);
/* 454 */     this.b_id.set(ref, h.id());
/*     */   }
/*     */ 
/*     */   
/*     */   public int references() {
/* 459 */     return this.datas.length;
/*     */   }
/*     */   
/*     */   public boolean isRef(int i) {
/* 463 */     return (i > 0 && i < this.datas.length && this.b_idType.get(i) != 0);
/*     */   }
/*     */   
/*     */   private final class Bits
/*     */   {
/*     */     public final int scroll;
/*     */     public final long mask;
/*     */     
/*     */     public Bits(long mask) {
/* 472 */       this.scroll = Long.numberOfTrailingZeros(mask);
/* 473 */       long m = mask;
/* 474 */       m >>>= this.scroll;
/*     */       
/* 476 */       this.mask = m;
/*     */     }
/*     */     
/*     */     public void set(int ref, long value) {
/* 480 */       if (ref < 0 || ref >= StatsRelations.this.datas.length) {
/*     */         return;
/*     */       }
/* 483 */       long data = StatsRelations.this.datas[ref];
/* 484 */       if (value < 0L || value > this.mask) {
/* 485 */         throw new RuntimeException("" + value);
/*     */       }
/* 487 */       value <<= this.scroll;
/* 488 */       data &= this.mask << this.scroll ^ 0xFFFFFFFFFFFFFFFFL;
/* 489 */       data |= value;
/* 490 */       StatsRelations.this.datas[ref] = data;
/*     */     }
/*     */     
/*     */     public int get(int ref) {
/* 494 */       if (ref < 0 || ref >= StatsRelations.this.datas.length) {
/* 495 */         return 0;
/*     */       }
/* 497 */       long data = StatsRelations.this.datas[ref];
/* 498 */       return (int)(data >>> this.scroll & this.mask);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeRef(int hoverRef) {
/* 504 */     if (!isRef(hoverRef)) {
/*     */       return;
/*     */     }
/*     */     
/* 508 */     for (int r = 1; r < references(); r++) {
/* 509 */       if (isRef(r) && parentRef(r) == hoverRef) {
/* 510 */         this.parents[r] = 0;
/*     */       }
/*     */     } 
/*     */     
/* 514 */     if (indu(hoverRef) != null) {
/* 515 */       this.ref.set(indu(hoverRef), 0);
/*     */     }
/* 517 */     this.datas[hoverRef] = 0L;
/* 518 */     this.free.push(hoverRef);
/*     */   }
/*     */ 
/*     */   
/*     */   public void debugPopulate() {
/* 523 */     int amount = 0;
/* 524 */     for (int r = 0; r < references(); r++) {
/* 525 */       if (isRef(r)) {
/* 526 */         amount++;
/*     */       }
/*     */     } 
/*     */     
/* 530 */     int[] refs = Alloc.ii(amount);
/* 531 */     amount = 0; int i;
/* 532 */     for (i = 0; i < references(); i++) {
/* 533 */       if (isRef(i))
/* 534 */         refs[amount++] = i; 
/*     */     }  byte b;
/*     */     int j, arrayOfInt1[];
/* 537 */     for (j = (arrayOfInt1 = refs).length, b = 0; b < j; ) { i = arrayOfInt1[b];
/* 538 */       int am = 1 + RND.rInt(3);
/* 539 */       for (int k = 0; k < am; k++) {
/* 540 */         Induvidual child = new Induvidual(HTYPES.SUBJECT(), (Race)RACES.all().rnd());
/* 541 */         setDeath(child, (CAUSE_LEAVE)CAUSE_LEAVES.ALL().rnd());
/* 542 */         setParent(child, i);
/*     */       } 
/*     */       b++; }
/*     */   
/*     */   }
/*     */   public void debugPrune() {
/* 548 */     prune();
/*     */   }
/*     */   
/* 551 */   private static CharSequence ¤¤childOfSomeone = "{0} of {1}";
/* 552 */   private static CharSequence ¤¤soldier = "Serving in the armed forces";
/* 553 */   private static CharSequence ¤¤yearsOld = "{0} years of age";
/* 554 */   private static CharSequence ¤¤deathCauseYearsAgoAge = "{0} {1} years ago, at {2} years of age.";
/*     */   
/*     */   static {
/* 557 */     D.ts(StatsRelations.class);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, int ref) {
/* 562 */     if (!isRef(ref)) {
/*     */       return;
/*     */     }
/* 565 */     GBox b = (GBox)box;
/*     */     
/* 567 */     b.title(name(ref));
/* 568 */     int type = this.b_idType.get(ref);
/* 569 */     b.text((race(ref)).info.namePosessive);
/* 570 */     b.text((type(ref)).name);
/*     */ 
/*     */     
/* 573 */     b.NL(2);
/*     */     
/* 575 */     if (type == 3) {
/* 576 */       GText t = b.text();
/* 577 */       t.add(¤¤yearsOld);
/* 578 */       t.insert(0, age(ref));
/* 579 */       b.add((SPRITE)t);
/* 580 */       b.NL();
/* 581 */       b.text(¤¤soldier);
/* 582 */     } else if (type == 1) {
/* 583 */       GText t = b.text();
/* 584 */       t.add(¤¤yearsOld);
/* 585 */       t.insert(0, age(ref));
/* 586 */       b.add((SPRITE)t);
/* 587 */       b.NL();
/* 588 */     } else if (type == 2) {
/* 589 */       GText t = b.text();
/* 590 */       t.add(¤¤deathCauseYearsAgoAge);
/* 591 */       t.insert(0, (death(ref)).name);
/*     */       
/* 593 */       int currentYear = TIME.years().bitsSinceStart();
/* 594 */       int storedDeath = this.b_deathYear.get(ref);
/* 595 */       long modulus = this.b_deathYear.mask + 1L;
/*     */       
/* 597 */       int diff = currentYear - storedDeath;
/*     */ 
/*     */       
/* 600 */       if (diff < 0) {
/* 601 */         diff = (int)(diff + modulus);
/*     */       }
/*     */       
/* 604 */       if (diff >= this.b_deathYear.mask) {
/* 605 */         Str.TMP.add('+');
/*     */       }
/* 607 */       Str.TMP.clear().add(diff);
/* 608 */       t.insert(1, (CharSequence)Str.TMP);
/*     */       
/* 610 */       Str.TMP.clear().add(age(ref));
/* 611 */       if (age(ref) >= 65535) {
/* 612 */         Str.TMP.add('+');
/*     */       }
/* 614 */       t.insert(2, (CharSequence)Str.TMP);
/* 615 */       b.add((SPRITE)t);
/* 616 */       b.NL();
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 621 */     b.NL(16);
/*     */     
/* 623 */     if (hasParent(ref)) {
/* 624 */       GText t = b.text();
/* 625 */       t.add(¤¤childOfSomeone);
/* 626 */       t.insert(0, (race(ref)).info.pCHILD.get(gender(ref), true));
/* 627 */       t.insert(1, name(parentRef(ref)));
/* 628 */       b.textLL((CharSequence)t);
/*     */     } 
/* 630 */     b.NL(4);
/* 631 */     b.textLL((CharSequence)Str.TMP.clear().add((race(ref)).info.sChildren[ref % (race(ref)).info.sChildren.length]).add(':'));
/* 632 */     b.NL();
/*     */     
/* 634 */     for (int i = 0; i < references(); i++) {
/* 635 */       if (isRef(i) && parentRef(i) == ref) {
/* 636 */         GText t = b.text();
/* 637 */         t.add(name(i));
/* 638 */         t.add(',');
/* 639 */         t.s();
/* 640 */         t.add(age(i));
/* 641 */         b.add((SPRITE)t);
/* 642 */         b.NL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\relation\StatsRelations.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */