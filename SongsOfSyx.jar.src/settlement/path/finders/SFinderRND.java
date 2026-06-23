/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.GUTIL;
/*     */ import util.data.DOUBLE_O;
/*     */ 
/*     */ public class SFinderRND {
/*     */   private final ArrayCooShort cs;
/*     */   
/*     */   public SFinderRND() {
/*  17 */     this.cs = GUTIL.coos();
/*     */   }
/*  19 */   public static final DOUBLE_O<SComponent> value = new DOUBLE_O<SComponent>()
/*     */     {
/*     */       public double getD(SComponent t)
/*     */       {
/*  23 */         return 1.0D;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  28 */   public static final DOUBLE_O<SComponent> otherPeople = new DOUBLE_O<SComponent>()
/*     */     {
/*     */       public double getD(SComponent t)
/*     */       {
/*  32 */         return ((SETT.PATH()).comps.data.people(true).get(t) > 0) ? 1.0D : 0.5D;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  37 */   public static final DOUBLE_O<SComponent> noPeople = new DOUBLE_O<SComponent>()
/*     */     {
/*     */       public double getD(SComponent t)
/*     */       {
/*  41 */         return ((SETT.PATH()).comps.data.people(true).get(t) > 0) ? 0.5D : 1.0D;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean find(int sx, int sy, SPath path, int distance) {
/*  48 */     return find(sx, sy, path, distance, value);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean find(int sx, int sy, SPath path, int distance, DOUBLE_O<SComponent> value) {
/*  54 */     COORDINATE c = get(sx, sy, distance, value);
/*  55 */     if (c != null)
/*  56 */       return path.request(sx, sy, c); 
/*  57 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COORDINATE get(int sx, int sy, int distance, DOUBLE_O<SComponent> value) {
/*  66 */     SCompFinder.SCompPath p = (SETT.PATH()).comps.pather.fill(sx, sy, distance);
/*     */     
/*  68 */     if (p == null || p.path().size() == 0) {
/*  69 */       return null;
/*     */     }
/*  71 */     this.cs.set(0);
/*  72 */     double vv = 0.0D;
/*  73 */     for (SComponent sComponent : p.path()) {
/*  74 */       vv = Math.max(vv, value.getD(sComponent));
/*     */     }
/*  76 */     for (int i = 0; i < p.path().size() && this.cs.getI() < this.cs.size(); i++) {
/*  77 */       SComponent sComponent = (SComponent)p.path().get(i);
/*  78 */       if (value.getD(sComponent) >= vv) {
/*  79 */         this.cs.get().set(sComponent.centreX(), sComponent.centreY());
/*  80 */         this.cs.inc();
/*     */       } 
/*     */     } 
/*     */     
/*  84 */     this.cs.set(RND.rInt(this.cs.getI()));
/*  85 */     SComponent c = (SComponent)(SETT.PATH()).comps.zero.get((COORDINATE)this.cs.get());
/*     */     
/*  87 */     int dim = c.level().size();
/*  88 */     int x1 = c.centreX() & (dim - 1 ^ 0xFFFFFFFF);
/*  89 */     int y1 = c.centreY() & (dim - 1 ^ 0xFFFFFFFF);
/*     */     
/*  91 */     this.cs.set(0); int y;
/*  92 */     for (y = 0; y < dim; y++) {
/*  93 */       for (int x = 0; x < dim; x++) {
/*  94 */         int dx = x1 + x;
/*  95 */         int dy = y1 + y;
/*  96 */         if (c.is(dx, dy) && (SETT.PATH()).finders.isGoodTileToStandOn(dx, dy, null)) {
/*  97 */           this.cs.get().set(dx, dy);
/*  98 */           this.cs.inc();
/*     */         } 
/*     */       } 
/*     */     } 
/* 102 */     if (this.cs.getI() == 0) {
/* 103 */       for (y = 0; y < dim; y++) {
/* 104 */         for (int x = 0; x < dim; x++) {
/* 105 */           int dx = x1 + x;
/* 106 */           int dy = y1 + y;
/* 107 */           if (c.is(dx, dy)) {
/* 108 */             this.cs.get().set(dx, dy);
/* 109 */             this.cs.inc();
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 115 */     this.cs.set(RND.rInt(this.cs.getI()));
/* 116 */     return (COORDINATE)this.cs.get();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderRND.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */