/*     */ package settlement.path.finders;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.GameDisposable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.path.components.FindableDataSingle;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.thing.ThingFindable;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public abstract class SFinderFindable
/*     */   implements SFINDER {
/*  17 */   public static ArrayList<SFinderFindable> all = new ArrayList(256);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  25 */   public final short index = (short)all.add(this);
/*     */   protected FINDABLE result;
/*     */   private double distance;
/*     */   public final CharSequence name;
/*  29 */   public final SFinderFindableMap map = new SFinderFindableMap();
/*     */   
/*     */   public SFinderFindable(CharSequence name) {
/*  32 */     this.name = name;
/*     */   }
/*     */   
/*     */   public double getDistance() {
/*  36 */     return this.distance;
/*     */   }
/*     */   
/*     */   public static LIST<SFinderFindable> all() {
/*  40 */     return (LIST<SFinderFindable>)all;
/*     */   }
/*     */   
/*     */   public static SFinderFindable get(short index) {
/*  44 */     return (SFinderFindable)all.get(index & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInComponent(SComponent c, double distance) {
/*  49 */     if (fin().get(c) > 0) {
/*  50 */       this.distance = distance;
/*  51 */       return true;
/*     */     } 
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTile(int tx, int ty, int tileNr) {
/*  58 */     this.result = getReservable(tx, ty);
/*  59 */     if (this.result != null) {
/*  60 */       return true;
/*     */     }
/*  62 */     return false;
/*     */   }
/*     */   
/*     */   public final boolean has(int sx, int sy) {
/*  66 */     return fin().has(sx, sy);
/*     */   }
/*     */   
/*     */   public final boolean has(COORDINATE c) {
/*  70 */     return fin().has(c.x(), c.y());
/*     */   }
/*     */   
/*     */   private FindableDataSingle fin() {
/*  74 */     return (FindableDataSingle)(SETT.PATH()).comps.data.SINGLES.get(this.index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract FINDABLE getReservable(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract FINDABLE getReserved(int paramInt1, int paramInt2);
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean reserve(COORDINATE start, SPath path, int maxdistance) {
/*  89 */     if (path.request(start.x(), start.y(), this, maxdistance)) {
/*  90 */       this.result.findableReserve();
/*  91 */       this.map.report(start, true);
/*  92 */       return true;
/*     */     } 
/*  94 */     this.map.report(start, false);
/*  95 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE reserve(COORDINATE start, int maxdistance) {
/* 105 */     if ((SETT.PATH()).finders.finder().findDest(start.x(), start.y(), this, maxdistance) != null) {
/* 106 */       this.result.findableReserve();
/* 107 */       this.map.report(start, true);
/* 108 */       return (COORDINATE)this.result;
/*     */     } 
/* 110 */     if (this == (SETT.ROOMS()).BENCH.finder())
/* 111 */       GAME.Notify("here"); 
/* 112 */     this.map.report(start, false);
/* 113 */     return null;
/*     */   }
/*     */   
/*     */   public COORDINATE reserve(int sx, int sy, int maxdistance) {
/* 117 */     if (has(sx, sy) && (SETT.PATH()).finders.finder().findDest(sx, sy, this, maxdistance) != null) {
/*     */       
/* 119 */       this.result.findableReserve();
/* 120 */       this.map.report(sx, sy, true);
/* 121 */       return (COORDINATE)this.result;
/*     */     } 
/* 123 */     this.map.report(sx, sy, false);
/* 124 */     return null;
/*     */   }
/*     */   
/*     */   public final void report(FINDABLE coo, int delta) {
/* 128 */     report(coo.x(), coo.y(), delta);
/*     */   }
/*     */   
/*     */   public final void report(int x, int y, int delta) {
/* 132 */     if (delta == 1) {
/* 133 */       fin().reportPresence(x, y);
/* 134 */     } else if (delta == -1) {
/* 135 */       fin().reportAbsence(x, y);
/*     */     } else {
/* 137 */       throw new RuntimeException("" + delta);
/*     */     } 
/*     */   }
/*     */   
/*     */   public static abstract class FinderThing<T extends ThingFindable> extends SFinderFindable {
/*     */     FinderThing(String name) {
/* 143 */       super(name);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public T getResult() {
/* 152 */       return (T)this.result;
/*     */     }
/*     */     
/*     */     public abstract T getReservable(int param1Int1, int param1Int2);
/*     */     
/*     */     public abstract T getReserved(int param1Int1, int param1Int2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderFindable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */