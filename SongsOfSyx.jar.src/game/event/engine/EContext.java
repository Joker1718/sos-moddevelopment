/*     */ package game.event.engine;
/*     */ 
/*     */ import game.event.actions.EventActionContext;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.type.HTYPES;
/*     */ import init.value.Lockable;
/*     */ import java.io.IOException;
/*     */ import java.io.Serializable;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.text.INSERT;
/*     */ import util.text.Inserter;
/*     */ import world.WORLD;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class EContext
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   public double random;
/*  47 */   public int[] actionContext = Alloc.ii(16);
/*     */   
/*  49 */   public final Coo coo = new Coo(-1.0D, -1.0D);
/*     */   
/*     */   public double actionAmount;
/*  52 */   public final SelContext<Induvidual> indu = new SelIndu();
/*  53 */   public final SelContext<Region> regs = new SelReg();
/*  54 */   public final SelContext<Faction> faction = new SelFac();
/*  55 */   public final SelContext<Royalty> royalty = new SelRoy();
/*     */ 
/*     */   
/*  58 */   private final LIST<SelContext<?>> sels = (LIST<SelContext<?>>)new ArrayList((Object[])new SelContext[] { this.indu, this.regs, this.faction, this.royalty });
/*     */   
/*  60 */   public ColorImp colorinduAll = null;
/*  61 */   public ColorImp colorIndu = null;
/*     */ 
/*     */   
/*     */   public boolean init(Event abs) {
/*  65 */     this.coo.set(-1.0D, -1.0D);
/*  66 */     this.actionAmount = 0.0D;
/*  67 */     this.colorinduAll = null;
/*  68 */     this.colorIndu = null;
/*  69 */     this.random = RND.rFloat();
/*  70 */     this.actionContext = EventActionContext.makeData(abs, this.actionContext);
/*  71 */     EventActionContext.setData(abs, this);
/*     */     
/*  73 */     for (SelContext<?> c : this.sels) {
/*  74 */       if (!c.init(abs)) {
/*  75 */         return false;
/*     */       }
/*     */     } 
/*  78 */     return true;
/*     */   }
/*     */   
/*     */   public void initLight(Event abs) {
/*  82 */     this.actionContext = EventActionContext.makeData(abs, this.actionContext);
/*  83 */     EventActionContext.setData(abs, this);
/*     */   }
/*     */   
/*     */   public static EContext read(FileGetter file) throws IOException {
/*  87 */     EContext c = (EContext)file.object(true);
/*  88 */     return c;
/*     */   }
/*     */   public void write(FilePutter file) {
/*  91 */     file.object(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EContext(EContext data) {
/*  99 */     this.coo.set((COORDINATE)data.coo);
/* 100 */     this.actionAmount = data.actionAmount;
/* 101 */     this.random = data.random;
/* 102 */     this.colorinduAll = data.colorinduAll;
/* 103 */     this.colorIndu = data.colorIndu;
/* 104 */     if (data.actionContext == null) {
/* 105 */       this.actionContext = Alloc.ii(16);
/*     */     } else {
/* 107 */       this.actionContext = Arrays.copyOf(data.actionContext, data.actionContext.length);
/*     */     } 
/* 109 */     this.indu.copy(data.indu);
/* 110 */     this.regs.copy(data.regs);
/* 111 */     this.faction.copy(data.faction);
/* 112 */     this.royalty.copy(data.royalty);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/* 117 */   static final Inserter<EContext> insert = new Inserter();
/*     */   
/*     */   public String insert(CharSequence mess) {
/* 120 */     Str srt = new Str(mess);
/* 121 */     insert.set(srt, this);
/* 122 */     return String.valueOf(srt);
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 127 */     insert.join(INSERT.player, new GETTER_TRANS<EContext, Integer>()
/*     */         {
/*     */           public Integer get(EContext f)
/*     */           {
/* 131 */             return Integer.valueOf((int)(f.random * 2.147483647E9D));
/*     */           }
/*     */         });
/*     */     
/* 135 */     insert.join(new Inserter(INSERT.faction, "PLAYER_"), new GETTER_TRANS<EContext, Faction>()
/*     */         {
/*     */           public Faction get(EContext f)
/*     */           {
/* 139 */             return (Faction)FACTIONS.player();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 144 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 156 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     insert.getClass();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     insert.join(new Inserter(INSERT.indu, "SUBJECT1_"), new GETTER_TRANS<EContext, Induvidual>()
/*     */         {
/*     */           public Induvidual get(EContext f)
/*     */           {
/* 178 */             return f.indu.first();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 183 */     insert.join(new Inserter(INSERT.indu, "SUBJECT2_"), new GETTER_TRANS<EContext, Induvidual>()
/*     */         {
/*     */           public Induvidual get(EContext f)
/*     */           {
/* 187 */             return f.indu.second();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 192 */     insert.join(new Inserter(INSERT.reg, "REGION1_"), new GETTER_TRANS<EContext, Region>()
/*     */         {
/*     */           public Region get(EContext f)
/*     */           {
/* 196 */             return f.regs.first();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 201 */     insert.join(new Inserter(INSERT.reg, "REGION2_"), new GETTER_TRANS<EContext, Region>()
/*     */         {
/*     */           public Region get(EContext f)
/*     */           {
/* 205 */             return f.regs.second();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 210 */     insert.join(new Inserter(INSERT.faction, "FACTION1_"), new GETTER_TRANS<EContext, Faction>()
/*     */         {
/*     */           public Faction get(EContext f)
/*     */           {
/* 214 */             return (f.faction.first() == null) ? (Faction)FACTIONS.player() : f.faction.first();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 219 */     insert.join(new Inserter(INSERT.faction, "FACTION2_"), new GETTER_TRANS<EContext, Faction>()
/*     */         {
/*     */           public Faction get(EContext f)
/*     */           {
/* 223 */             return f.faction.second();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 228 */     insert.join(new Inserter(INSERT.royalty, "ROYALTY1_"), new GETTER_TRANS<EContext, Royalty>()
/*     */         {
/*     */           public Royalty get(EContext f)
/*     */           {
/* 232 */             return f.royalty.first();
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 237 */     insert.join(new Inserter(INSERT.royalty, "ROYALTY2_"), new GETTER_TRANS<EContext, Royalty>()
/*     */         {
/*     */           public Royalty get(EContext f)
/*     */           {
/* 241 */             return f.royalty.second();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public EContext() {}
/*     */ 
/*     */   
/*     */   public static abstract class SelContext<T>
/*     */     implements Serializable
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/* 255 */     public int am = 0;
/*     */     
/*     */     public int max;
/*     */     public int min;
/* 259 */     private static int eMark = 0;
/* 260 */     private static int eClear = 0;
/* 261 */     private static int eFilter = 0;
/*     */ 
/*     */     
/*     */     private SelContext(String name) {}
/*     */ 
/*     */     
/*     */     public abstract T first();
/*     */ 
/*     */     
/*     */     public abstract T second();
/*     */     
/*     */     boolean init(Event abs) {
/* 273 */       this.am = 0;
/* 274 */       ESelection.ESelectionType<T> ss = sel(abs);
/* 275 */       eMark = ss.mark.mark ? (abs.allIndex + 1) : 0;
/* 276 */       eClear = 0;
/* 277 */       if (ss.mark.clear != null) {
/* 278 */         for (Event e : Event.all) {
/* 279 */           if (e.key.equals(ss.mark.clear)) {
/* 280 */             eClear = e.allIndex + 1;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 285 */       eFilter = 0;
/* 286 */       if (ss.mark.filter != null) {
/* 287 */         for (Event e : Event.all) {
/* 288 */           if (e.key.equals(ss.mark.filter)) {
/* 289 */             eFilter = e.allIndex + 1;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 295 */       int maxAm = max();
/*     */       
/* 297 */       if (maxAm <= 0) {
/* 298 */         return true;
/*     */       }
/*     */       
/* 301 */       for (int ei = 0; ei < maxAm; ei++) {
/* 302 */         T e = get(ei);
/* 303 */         if (e != null) {
/* 304 */           eventSet(e, 0);
/* 305 */           if (eClear != 0 && eClear == markGet(e)) {
/* 306 */             markSet(e, 0);
/*     */           }
/*     */           
/* 309 */           for (Lockable<T> l : ss.filters) {
/* 310 */             if (l.passes(e)) {
/*     */               
/* 312 */               this.am++;
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 318 */       this.max = ss.max.am(tot(), this.am);
/* 319 */       this.min = ss.min.am(tot(), this.am);
/*     */       
/* 321 */       if (this.am < this.min) {
/* 322 */         return false;
/*     */       }
/* 324 */       this.am = 0;
/*     */       
/* 326 */       T first = null;
/* 327 */       T second = null;
/*     */       
/* 329 */       int ri = RND.rInt(maxAm);
/*     */ 
/*     */ 
/*     */       
/* 333 */       for (int ii = 0; ii < maxAm; ii++) {
/* 334 */         int i = ii + ri;
/* 335 */         i %= maxAm;
/*     */         
/* 337 */         T e = get(i);
/*     */         
/* 339 */         if (e != null)
/*     */         {
/*     */           
/* 342 */           if (eFilter == 0 || 
/* 343 */             markGet(e) == eFilter)
/*     */           {
/*     */ 
/*     */             
/* 347 */             for (Lockable<T> l : ss.filters) {
/* 348 */               if (l.passes(e)) {
/* 349 */                 if (this.am == 0) {
/* 350 */                   first = e;
/* 351 */                 } else if (this.am == 1) {
/* 352 */                   second = e;
/*     */                 } 
/* 354 */                 this.am++;
/* 355 */                 eventSet(e, 1);
/*     */                 
/* 357 */                 if (eMark != 0) {
/* 358 */                   markSet(e, eMark);
/*     */                 }
/* 360 */                 if (this.am >= this.max) {
/* 361 */                   set(first, second);
/* 362 */                   return true;
/*     */                 } 
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         }
/*     */       } 
/* 370 */       set(first, second);
/* 371 */       return true;
/*     */     }
/*     */     abstract void set(T param1T1, T param1T2);
/*     */     
/*     */     abstract int max();
/*     */     
/*     */     int tot() {
/* 378 */       return max();
/*     */     }
/*     */ 
/*     */     
/*     */     abstract T get(int param1Int);
/*     */ 
/*     */     
/*     */     abstract void markSet(T param1T, int param1Int);
/*     */ 
/*     */     
/*     */     void copy(SelContext<T> o) {
/* 389 */       this.am = o.am;
/* 390 */       this.max = o.max;
/* 391 */       this.min = o.min;
/* 392 */       set(o.first(), o.second());
/*     */     }
/*     */     
/*     */     abstract int markGet(T param1T);
/*     */     
/*     */     abstract void eventSet(T param1T, int param1Int);
/*     */     
/*     */     abstract boolean eventGet(T param1T);
/*     */     
/*     */     abstract ESelection.ESelectionType<T> sel(Event param1Event);
/*     */     
/*     */     abstract SPRITE sprite();
/*     */     
/*     */     abstract Class<?> cl(); }
/*     */   
/*     */   public static class SelIndu extends SelContext<Induvidual> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     private Induvidual i1;
/*     */     private Induvidual i2;
/*     */     
/*     */     private SelIndu() {
/* 413 */       super("indu");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     boolean init(Event abs) {
/* 419 */       fix();
/* 420 */       return super.init(abs);
/*     */     }
/*     */     
/*     */     private void fix() {
/* 424 */       if (this.i1 == null)
/* 425 */         this.i1 = new Induvidual(HTYPES.SOLDIER(), FACTIONS.player().race()); 
/* 426 */       if (this.i2 == null) {
/* 427 */         this.i2 = new Induvidual(HTYPES.SOLDIER(), FACTIONS.player().race());
/*     */       }
/*     */     }
/*     */     
/*     */     public Induvidual first() {
/* 432 */       return this.i1;
/*     */     }
/*     */ 
/*     */     
/*     */     public Induvidual second() {
/* 437 */       return this.i2;
/*     */     }
/*     */ 
/*     */     
/*     */     void copy(EContext.SelContext<Induvidual> o) {
/* 442 */       fix();
/* 443 */       super.copy(o);
/*     */     }
/*     */ 
/*     */     
/*     */     SPRITE sprite() {
/* 448 */       if (this.i1 != null) {
/* 449 */         return (SPRITE)new SPRITE.Imp(120, 192)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 452 */               STATS.APPEARANCE().portraitRender(r, EContext.SelIndu.this.i1, X1, Y1, 3);
/*     */             }
/*     */           };
/*     */       }
/*     */       
/* 457 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     ESelection.ESelectionType<Induvidual> sel(Event abs) {
/* 462 */       return abs.selection.indu;
/*     */     }
/*     */ 
/*     */     
/*     */     void set(Induvidual first, Induvidual second) {
/* 467 */       if (first != null)
/* 468 */         this.i1.copyFromHard(first); 
/* 469 */       if (second != null) {
/* 470 */         this.i2.copyFromHard(second);
/*     */       }
/*     */     }
/*     */     
/*     */     int max() {
/* 475 */       return SETT.ENTITIES().Imax();
/*     */     }
/*     */ 
/*     */     
/*     */     Induvidual get(int index) {
/* 480 */       ENTITY e = SETT.ENTITIES().getAllEnts()[index];
/* 481 */       if (e != null && e instanceof Humanoid) {
/* 482 */         return ((Humanoid)e).indu();
/*     */       }
/* 484 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     void markSet(Induvidual t, int id) {
/* 489 */       (STATS.EVENT()).mark.set(t, id);
/*     */     }
/*     */ 
/*     */     
/*     */     int markGet(Induvidual t) {
/* 494 */       return (STATS.EVENT()).mark.get(t);
/*     */     }
/*     */ 
/*     */     
/*     */     void eventSet(Induvidual t, int b) {
/* 499 */       STATS.EVENT().set(t, (b == 1));
/*     */     }
/*     */ 
/*     */     
/*     */     boolean eventGet(Induvidual t) {
/* 504 */       return STATS.EVENT().has(t);
/*     */     }
/*     */ 
/*     */     
/*     */     int tot() {
/* 509 */       return (STATS.POP()).POP.data().get(null);
/*     */     }
/*     */ 
/*     */     
/*     */     Class<?> cl() {
/* 514 */       return Induvidual.class;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class SelReg extends SelContext<Region> {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/*     */     private SelReg() {
/* 522 */       super("regs");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 529 */       this.i1 = -1;
/* 530 */       this.i2 = -1;
/*     */     }
/*     */     private int i1; private int i2;
/*     */     public Region first() {
/* 534 */       if (this.i1 < 0)
/* 535 */         return null; 
/* 536 */       return WORLD.REGIONS().getByIndex(this.i1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Region second() {
/* 541 */       if (this.i2 < 0)
/* 542 */         return null; 
/* 543 */       return WORLD.REGIONS().getByIndex(this.i2);
/*     */     }
/*     */ 
/*     */     
/*     */     SPRITE sprite() {
/* 548 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     void set(Region first, Region second) {
/* 553 */       this.i1 = (first == null) ? -1 : first.index();
/* 554 */       this.i2 = (second == null) ? -1 : second.index();
/*     */     }
/*     */ 
/*     */     
/*     */     int max() {
/* 559 */       return WORLD.REGIONS().active().size();
/*     */     }
/*     */ 
/*     */     
/*     */     Region get(int index) {
/* 564 */       return (Region)WORLD.REGIONS().active().get(index);
/*     */     }
/*     */ 
/*     */     
/*     */     void markSet(Region t, int id) {
/* 569 */       (RD.event()).mark.set(t, id);
/*     */     }
/*     */ 
/*     */     
/*     */     int markGet(Region t) {
/* 574 */       return (RD.event()).mark.get(t);
/*     */     }
/*     */ 
/*     */     
/*     */     boolean eventGet(Region t) {
/* 579 */       return ((RD.event()).ii.get(t) == 1);
/*     */     }
/*     */ 
/*     */     
/*     */     void eventSet(Region t, int b) {
/* 584 */       (RD.event()).ii.set(t, b);
/*     */     }
/*     */ 
/*     */     
/*     */     ESelection.ESelectionType<Region> sel(Event abs) {
/* 589 */       return abs.selection.reg;
/*     */     }
/*     */ 
/*     */     
/*     */     Class<?> cl() {
/* 594 */       return Region.class;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SelFac
/*     */     extends SelContext<Faction>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/* 605 */     private int i1 = -1;
/* 606 */     private int i2 = -1;
/*     */     
/*     */     private SelFac() {
/* 609 */       super("fac");
/*     */     }
/*     */ 
/*     */     
/*     */     public Faction first() {
/* 614 */       if (this.i1 < 0)
/* 615 */         return null; 
/* 616 */       return (Faction)FACTIONS.all().get(this.i1);
/*     */     }
/*     */ 
/*     */     
/*     */     public Faction second() {
/* 621 */       if (this.i2 < 0)
/* 622 */         return null; 
/* 623 */       return (Faction)FACTIONS.all().get(this.i2);
/*     */     }
/*     */ 
/*     */     
/*     */     SPRITE sprite() {
/* 628 */       if (first() != null)
/* 629 */         return (first().banner()).HUGE; 
/* 630 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     void set(Faction first, Faction second) {
/* 635 */       this.i1 = (first == null) ? -1 : first.index();
/* 636 */       this.i2 = (second == null) ? -1 : second.index();
/*     */     }
/*     */ 
/*     */     
/*     */     int max() {
/* 641 */       return FACTIONS.active().size();
/*     */     }
/*     */ 
/*     */     
/*     */     Faction get(int index) {
/* 646 */       return (Faction)FACTIONS.active().get(index);
/*     */     }
/*     */ 
/*     */     
/*     */     void markSet(Faction t, int id) {
/* 651 */       t.eventMark = (short)id;
/*     */     }
/*     */ 
/*     */     
/*     */     int markGet(Faction t) {
/* 656 */       return t.eventMark;
/*     */     }
/*     */ 
/*     */     
/*     */     void eventSet(Faction t, int b) {
/* 661 */       t.eventSet((b == 1));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     boolean eventGet(Faction t) {
/* 667 */       return t.event();
/*     */     }
/*     */ 
/*     */     
/*     */     ESelection.ESelectionType<Faction> sel(Event abs) {
/* 672 */       return abs.selection.faction;
/*     */     }
/*     */ 
/*     */     
/*     */     Class<?> cl() {
/* 677 */       return Faction.class;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class SelRoy
/*     */     extends SelContext<Royalty>
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     
/* 688 */     private int i1 = -1;
/* 689 */     private int i2 = -1;
/* 690 */     private int ii1 = -1;
/* 691 */     private int ii2 = -1;
/*     */     private Induvidual roy;
/*     */     private boolean isKing;
/*     */     
/*     */     private SelRoy() {
/* 696 */       super("roy");
/*     */     }
/*     */ 
/*     */     
/*     */     public Royalty first() {
/* 701 */       if (this.i1 < 0)
/* 702 */         return null; 
/* 703 */       FactionNPC f = (FactionNPC)FACTIONS.all().get(this.i1);
/* 704 */       if (this.ii1 < f.court().all().size())
/* 705 */         return (Royalty)f.court().all().get(this.ii1); 
/* 706 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     public Royalty second() {
/* 711 */       if (this.i2 < 0)
/* 712 */         return null; 
/* 713 */       FactionNPC f = (FactionNPC)FACTIONS.all().get(this.i2);
/* 714 */       if (this.ii2 < f.court().all().size())
/* 715 */         return (Royalty)f.court().all().get(this.ii2); 
/* 716 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     void copy(EContext.SelContext<Royalty> o) {
/* 721 */       super.copy(o);
/* 722 */       this.i1 = -1;
/* 723 */       this.i2 = -1;
/* 724 */       if (o.first() != null) {
/* 725 */         this.i1 = ((Royalty)o.first()).court.faction.index();
/* 726 */         this.ii1 = ((Royalty)o.first()).successionI();
/*     */       } 
/* 728 */       if (o.second() != null) {
/* 729 */         this.i2 = ((Royalty)o.second()).court.faction.index();
/* 730 */         this.ii2 = ((Royalty)o.second()).successionI();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     SPRITE sprite() {
/* 736 */       if (this.roy != null)
/* 737 */         return (SPRITE)new SPRITE.Imp(120, 192)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 740 */               STATS.APPEARANCE().portraitRender(r, EContext.SelRoy.this.roy, X1, Y1, 3);
/* 741 */               if (EContext.SelRoy.this.isKing) {
/* 742 */                 ((SPRITE)(EContext.SelRoy.this.roy.race().appearance()).crown.crowns().get(0)).renderScaled(r, X1, Y1 + 24, 3);
/*     */               }
/*     */             }
/*     */           }; 
/* 746 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     void set(Royalty first, Royalty second) {
/* 751 */       this.i1 = -1;
/* 752 */       this.i2 = -1;
/* 753 */       if (first != null) {
/* 754 */         this.i1 = first.court.faction.index();
/* 755 */         this.ii1 = first.successionI();
/* 756 */         if (this.roy == null)
/* 757 */           this.roy = new Induvidual(HTYPES.NOBILITY(), FACTIONS.player().race()); 
/* 758 */         this.roy.copyFromHard(first.induvidual);
/*     */       } 
/* 760 */       if (second != null) {
/* 761 */         this.i2 = second.court.faction.index();
/* 762 */         this.ii2 = second.successionI();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     int max() {
/* 769 */       return FACTIONS.NPCs().size() * 4;
/*     */     }
/*     */ 
/*     */     
/*     */     Royalty get(int index) {
/* 774 */       int fi = index / 4;
/* 775 */       if (fi < 0)
/* 776 */         return null; 
/* 777 */       Faction ff = (Faction)FACTIONS.all().get(fi);
/* 778 */       if (ff == null || !(ff instanceof FactionNPC))
/* 779 */         return null; 
/* 780 */       FactionNPC f = (FactionNPC)ff;
/* 781 */       if (!f.isActive())
/* 782 */         return null; 
/* 783 */       int ri = index % 4;
/* 784 */       if (ri < f.court().all().size())
/* 785 */         return (Royalty)f.court().all().get(ri); 
/* 786 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     void markSet(Royalty t, int id) {
/* 791 */       t.eventMark = (short)id;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     int markGet(Royalty t) {
/* 797 */       return t.eventMark;
/*     */     }
/*     */ 
/*     */     
/*     */     void eventSet(Royalty t, int b) {
/* 802 */       t.eventSet((b == 1));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     boolean eventGet(Royalty t) {
/* 808 */       return t.event();
/*     */     }
/*     */ 
/*     */     
/*     */     ESelection.ESelectionType<Royalty> sel(Event abs) {
/* 813 */       return abs.selection.royalty;
/*     */     }
/*     */ 
/*     */     
/*     */     Class<?> cl() {
/* 818 */       return Royalty.class;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\engine\EContext.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */