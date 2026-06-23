/*     */ package settlement.path.finders;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import util.GUTIL;
/*     */ 
/*     */ public class RadiusChecker
/*     */ {
/*  16 */   public static RadiusChecker self = new RadiusChecker();
/*     */   
/*  18 */   private byte ri = 0;
/*     */   private int[] levelStarts;
/*     */   private int[] sizes;
/*  21 */   private byte[] ids = Alloc.bb(0);
/*     */ 
/*     */   
/*     */   public void check(int sx, int sy, int radius) {
/*  25 */     if (needsSizeFix()) {
/*  26 */       this.levelStarts = Alloc.ii((SETT.PATH()).comps.all.size());
/*  27 */       this.sizes = Alloc.ii((SETT.PATH()).comps.all.size());
/*  28 */       int start = 0;
/*  29 */       for (int l = 0; l < this.levelStarts.length; l++) {
/*  30 */         int size = ((SComponentLevel)(SETT.PATH()).comps.all.get(l)).componentsMax();
/*  31 */         this.sizes[l] = size;
/*     */ 
/*     */         
/*  34 */         this.levelStarts[l] = start;
/*  35 */         start += size;
/*     */       } 
/*     */       
/*  38 */       this.ids = Alloc.bb(start + 64);
/*  39 */       this.ri = 0;
/*  40 */     } else if (this.ri == -1) {
/*  41 */       Arrays.fill(this.ids, (byte)0);
/*  42 */       this.ri = 0;
/*     */     } 
/*     */     
/*  45 */     this.ri = (byte)(this.ri + 1);
/*     */     
/*  47 */     GUTIL.flooder().init(this);
/*  48 */     GUTIL.flooder().pushSloppy(sx, sy, 0.0D);
/*     */     
/*  50 */     while (GUTIL.flooder().hasMore()) {
/*  51 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  52 */       check((COORDINATE)t);
/*  53 */       if (t.getValue() > radius) {
/*     */         break;
/*     */       }
/*  56 */       SComponent c = (SComponent)(SETT.PATH()).comps.zero.get((COORDINATE)t);
/*  57 */       SComponentEdge e = c.edgefirst();
/*  58 */       while (e != null) {
/*  59 */         GUTIL.flooder().pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + e.distance());
/*  60 */         e = e.next();
/*     */       } 
/*     */     } 
/*  63 */     this.ri = (byte)(this.ri - 1);
/*  64 */     while (GUTIL.flooder().hasMore()) {
/*  65 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  66 */       check((COORDINATE)t);
/*     */     } 
/*     */     
/*  69 */     this.ri = (byte)(this.ri + 1);
/*  70 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void check(COORDINATE c) {
/*  76 */     SComponent start = (SComponent)(SETT.PATH()).comps.zero.get(c);
/*  77 */     int s = 0;
/*  78 */     while (start != null) {
/*  79 */       int id = start.index() + this.levelStarts[s];
/*  80 */       if (id < this.ids.length)
/*  81 */         this.ids[id] = this.ri; 
/*  82 */       start = start.superComp();
/*  83 */       s++;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean is(SComponent c) {
/*  88 */     int id = c.index() + this.levelStarts[c.level().level()];
/*  89 */     if (id >= this.ids.length)
/*  90 */       return false; 
/*  91 */     return (this.ids[id] == this.ri);
/*     */   }
/*     */   
/*     */   public boolean is(int tx, int ty) {
/*  95 */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(tx, ty);
/*  96 */     if (sComp0 == null)
/*  97 */       return false; 
/*  98 */     int id = sComp0.index() + this.levelStarts[sComp0.level().level()];
/*  99 */     if (id >= this.ids.length)
/* 100 */       return false; 
/* 101 */     return (this.ids[id] == this.ri);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean needsSizeFix() {
/* 107 */     if (this.levelStarts == null) {
/* 108 */       return true;
/*     */     }
/* 110 */     int start = 0;
/*     */     
/* 112 */     for (int l = 0; l < this.sizes.length; l++) {
/* 113 */       start += ((SComponentLevel)(SETT.PATH()).comps.all.get(l)).componentsMax();
/*     */     }
/*     */     
/* 116 */     return (start >= this.ids.length);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\RadiusChecker.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */