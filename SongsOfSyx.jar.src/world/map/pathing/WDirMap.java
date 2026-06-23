/*     */ package world.map.pathing;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.map.MAP_BOOLEAN;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitsmap2D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ 
/*     */ 
/*     */ public final class WDirMap
/*     */ {
/*  21 */   private final Bitsmap2D m = new Bitsmap2D(0, 8, (DIMENSION)WORLD.TBOUNDS());
/*     */   
/*  23 */   final SAVABLE saver = new SAVABLE()
/*     */     {
/*     */       public void save(FilePutter file)
/*     */       {
/*  27 */         WDirMap.this.m.save(file);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void load(FileGetter file) throws IOException {
/*  33 */         WDirMap.this.m.load(file);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*     */       public void clear() {
/*  39 */         WDirMap.this.m.clear();
/*     */       }
/*     */     };
/*     */   
/*  43 */   public final MAP_BOOLEAN is = new MAP_BOOLEAN()
/*     */     {
/*     */       public boolean is(int tx, int ty)
/*     */       {
/*  47 */         return (WDirMap.this.m.get(tx, ty) != 0);
/*     */       }
/*     */ 
/*     */       
/*     */       public boolean is(int tile) {
/*  52 */         return (WDirMap.this.m.get(tile) != 0);
/*     */       }
/*     */     };
/*     */   
/*     */   public boolean can(int fromX, int fromY, DIR d) {
/*  57 */     return ((this.m.get(fromX, fromY) & d.bit) != 0);
/*     */   }
/*     */   
/*     */   public boolean can(int tile, DIR d) {
/*  61 */     return ((this.m.get(tile) & d.bit) != 0);
/*     */   }
/*     */   
/*     */   public boolean can(COORDINATE from, DIR d) {
/*  65 */     return can(from.x(), from.y(), d);
/*     */   }
/*     */   
/*     */   public boolean can(int fromX, int fromY, int di) {
/*  69 */     return can(fromX, fromY, (DIR)DIR.ALL.get(di));
/*     */   }
/*     */   
/*     */   public boolean can(COORDINATE c, int di) {
/*  73 */     return can(c.x(), c.y(), (DIR)DIR.ALL.get(di));
/*     */   }
/*     */   
/*     */   public boolean isOnly(COORDINATE c, DIR d) {
/*  77 */     int mm = d.bit | (d.perpendicular()).bit;
/*  78 */     return (this.m.get(c) == mm);
/*     */   }
/*     */   
/*     */   public boolean isOnly(int tx, int ty, DIR d) {
/*  82 */     int mm = d.bit | (d.perpendicular()).bit;
/*  83 */     return (this.m.get(tx, ty) == mm);
/*     */   }
/*     */   
/*     */   int get(PathTile t) {
/*  87 */     return this.m.get((COORDINATE)t);
/*     */   }
/*     */   
/*     */   void add(int tx, int ty, DIR d) {
/*  91 */     int s = this.m.get(tx, ty);
/*  92 */     s |= d.bit;
/*  93 */     this.m.set(tx, ty, s);
/*  94 */     if (WORLD.IN_BOUNDS(tx, ty, d)) {
/*  95 */       s = this.m.get(tx, ty, d);
/*  96 */       s |= (d.perpendicular()).bit;
/*  97 */       this.m.set(tx, ty, d, s);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void remove(int tx, int ty) {
/* 103 */     int s = this.m.get(tx, ty);
/* 104 */     for (int di = 0; di < DIR.ALL.size(); di++) {
/* 105 */       DIR d = (DIR)DIR.ALL.get(di);
/* 106 */       if ((s & d.bit) != 0) {
/* 107 */         s &= d.bit ^ 0xFFFFFFFF;
/*     */         
/* 109 */         if (WORLD.IN_BOUNDS(tx, ty, d)) {
/* 110 */           int sd = this.m.get(tx, ty, d);
/* 111 */           sd &= (d.perpendicular()).bit ^ 0xFFFFFFFF;
/* 112 */           this.m.set(tx, ty, d, sd);
/*     */         } 
/*     */       } 
/*     */     } 
/* 116 */     this.m.set(tx, ty, s);
/*     */   }
/*     */ 
/*     */   
/*     */   void add(COORDINATE c, DIR d) {
/* 121 */     add(c.x(), c.y(), d);
/*     */   }
/*     */   
/* 124 */   private static final LIST<DIR> dirs = (LIST<DIR>)new ArrayList((Iterable)DIR.ALL);
/*     */   
/*     */   public void push(PathTile t, double v) {
/* 127 */     int md = this.m.get((COORDINATE)t);
/* 128 */     for (DIR d : dirs) {
/* 129 */       if ((md & d.bit) != 0)
/* 130 */         GUTIL.flooder().pushSmaller((COORDINATE)t, d, v + d.tileDistance() * cost(t.x(), t.y(), d), t); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void pushSimple(PathTile t) {
/* 135 */     int md = this.m.get((COORDINATE)t);
/* 136 */     for (DIR d : dirs) {
/* 137 */       if ((md & d.bit) != 0)
/* 138 */         GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + d.tileDistance(), t); 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int cost(int fromX, int fromY, DIR d) {
/* 143 */     if ((WORLD.WATER()).isBig.is(fromX, fromY)) {
/* 144 */       return 1;
/*     */     }
/* 146 */     int toX = fromX + d.x();
/* 147 */     int toY = fromY + d.y();
/* 148 */     if ((WORLD.WATER()).isBig.is(toX, toY)) {
/* 149 */       return 10;
/*     */     }
/* 151 */     if (WORLD.MOUNTAIN().coversTile(fromX, fromY))
/* 152 */       return 6; 
/* 153 */     if ((WORLD.FOREST()).amount.get(fromX, fromY) == 1.0D)
/* 154 */       return 4; 
/* 155 */     return 3;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\WDirMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */