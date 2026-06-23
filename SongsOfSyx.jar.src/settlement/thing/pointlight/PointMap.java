/*     */ package settlement.thing.pointlight;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ class PointMap
/*     */   implements SAVABLE
/*     */ {
/*     */   private final PointMapQuadrant[][] quadrants;
/*     */   private final int qMaxX;
/*     */   private final int qMaxY;
/*  21 */   private final int gridSize = 32;
/*  22 */   private Rec rec = new Rec();
/*  23 */   private final long[] tmp = new long[3072];
/*     */ 
/*     */   
/*     */   PointMap(int mapSizeX, int mapSizeY) {
/*  27 */     this.qMaxX = mapSizeX / 32;
/*  28 */     this.qMaxY = mapSizeY / 32;
/*     */     
/*  30 */     this.quadrants = new PointMapQuadrant[this.qMaxX][this.qMaxY];
/*     */     
/*  32 */     for (int y = 0; y < this.quadrants.length; y++) {
/*  33 */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/*  34 */         this.quadrants[y][x] = new PointMapQuadrant();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(int tx, int ty, int offX, int offY, LightModel model) {
/*  42 */     int qx = tx / 32;
/*  43 */     int qy = ty / 32;
/*  44 */     this.quadrants[qy][qx].add(Light.make(tx, ty, offX, offY, model, true));
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(int tx, int ty) {
/*  49 */     int qx = tx / 32;
/*  50 */     int qy = ty / 32;
/*     */     
/*  52 */     this.quadrants[qy][qx].remove(tx, ty);
/*     */   }
/*     */   
/*     */   public void hide(int tx, int ty, boolean hide) {
/*  56 */     int qx = tx / 32;
/*  57 */     int qy = ty / 32;
/*     */     
/*  59 */     for (int i = 0; i < this.quadrants[qy][qx].last(); i++) {
/*  60 */       Light l = Light.init(this.quadrants[qy][qx].get(i));
/*  61 */       if (l.tx() == tx && l.ty() == ty) {
/*  62 */         long d = l.hide(hide);
/*  63 */         this.quadrants[qy][qx].set(i, d);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/*  72 */     for (int y = 0; y < this.quadrants.length; y++) {
/*  73 */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/*  74 */         this.quadrants[y][x].clear();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  81 */     for (int y = 0; y < this.quadrants.length; y++) {
/*  82 */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/*  83 */         this.quadrants[y][x].save(file);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  90 */     for (int y = 0; y < this.quadrants.length; y++) {
/*  91 */       for (int x = 0; x < (this.quadrants[0]).length; x++) {
/*  92 */         this.quadrants[y][x].load(file);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private int fill(int x1, int x2, int y1, int y2) {
/*  99 */     x1 >>= 6;
/* 100 */     y1 >>= 6;
/* 101 */     x2 >>= 6;
/* 102 */     y2 >>= 6;
/*     */ 
/*     */     
/* 105 */     int start = 0;
/*     */ 
/*     */     
/* 108 */     int qx1 = (x1 - 32) / 32;
/* 109 */     if (qx1 < 0)
/* 110 */       qx1 = 0; 
/* 111 */     int qy1 = (y1 - 32) / 32;
/* 112 */     if (qy1 < 0)
/* 113 */       qy1 = 0; 
/* 114 */     int qx2 = (x2 + 32) / 32;
/* 115 */     if (qx2 >= this.qMaxX)
/* 116 */       qx2 = this.qMaxX - 1; 
/* 117 */     int qy2 = (y2 + 32) / 32;
/* 118 */     if (qy2 >= this.qMaxY) {
/* 119 */       qy2 = this.qMaxY - 1;
/*     */     }
/* 121 */     int min = 16;
/* 122 */     this.rec.set((x1 - min), (x2 + min), (y1 - min), (y2 + min));
/* 123 */     for (int y = qy1; y <= qy2; y++) {
/* 124 */       for (int x = qx1; x <= qx2; x++) {
/* 125 */         PointMapQuadrant qq = this.quadrants[y][x];
/* 126 */         for (int i = 0; i < qq.last(); i++) {
/*     */           
/* 128 */           Light p = Light.init(qq.get(i));
/*     */ 
/*     */           
/* 131 */           if (this.rec.holdsPoint(p.tx(), p.ty())) {
/* 132 */             Room r = (SETT.ROOMS()).map.get(p.tx(), p.ty());
/* 133 */             if (r == null || r.degrader(p.tx(), p.ty()) == null || r.degrader(p.tx(), p.ty()).get() <= 0.5D) {
/*     */               
/* 135 */               if (start >= this.tmp.length)
/* 136 */                 return start; 
/* 137 */               this.tmp[start] = qq.get(i);
/* 138 */               start++;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 144 */     return start;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch s, float ds, RECTANGLE renWindow, int offX, int offY) {
/* 150 */     int start = fill(renWindow.x1(), renWindow.x2(), renWindow.y1(), renWindow.y2());
/*     */ 
/*     */     
/* 153 */     offX -= renWindow.x1();
/* 154 */     offY -= renWindow.y1();
/*     */     int i;
/* 156 */     for (i = 0; i < start; i++) {
/* 157 */       Light.init(this.tmp[i]).render(r, s, ds, offX, offY);
/*     */     }
/*     */     
/* 160 */     r.newLayer(true, r.getZoomout());
/*     */     
/* 162 */     for (i = 0; i < start; i++) {
/* 163 */       Light.init(this.tmp[i]).renderBelow(r, s, ds, offX, offY);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean is(int tx, int ty) {
/* 170 */     int qx = tx / 32;
/* 171 */     int qy = ty / 32;
/*     */     
/* 173 */     return this.quadrants[qy][qx].is(tx, ty);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\thing\pointlight\PointMap.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */