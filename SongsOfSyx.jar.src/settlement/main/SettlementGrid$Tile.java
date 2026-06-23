/*     */ package settlement.main;
/*     */ 
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.ArrayListResize;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Tile
/*     */ {
/*     */   public final RECTANGLE bounds;
/*  66 */   private final COORDINATE[][] coos = new COORDINATE[SettlementGrid.TILES][SettlementGrid.TILES];
/*     */   
/*  68 */   private final COORDINATE[] coosInner = new COORDINATE[DIR.ALL.size()];
/*     */   private final COORDINATE coosInnerC;
/*  70 */   private final ArrayListResize<DIR> dirs = new ArrayListResize(4, 9);
/*     */   
/*     */   private Tile(int quadX, int quadY) {
/*  73 */     this.bounds = (RECTANGLE)new Rec((quadX * SettlementGrid.QUAD_SIZE), (quadX * SettlementGrid.QUAD_SIZE + SettlementGrid.QUAD_SIZE), (quadY * SettlementGrid.QUAD_SIZE), (
/*  74 */         quadY * SettlementGrid.QUAD_SIZE + SettlementGrid.QUAD_SIZE));
/*     */     
/*  76 */     this.dirs.add(DIR.E);
/*  77 */     this.dirs.add(DIR.SE);
/*  78 */     this.dirs.add(DIR.S);
/*  79 */     this.dirs.add(DIR.C);
/*  80 */     if (quadX == 0) {
/*  81 */       this.dirs.add(DIR.W);
/*  82 */       this.dirs.add(DIR.SW);
/*     */     } 
/*  84 */     if (quadY == 0) {
/*  85 */       this.dirs.add(DIR.NE);
/*  86 */       this.dirs.add(DIR.N);
/*  87 */       if (quadX == 0) {
/*  88 */         this.dirs.add(DIR.NW);
/*     */       }
/*     */     } 
/*  91 */     this.dirs.trim();
/*     */     
/*  93 */     for (int y = 0; y < SettlementGrid.TILES; y++) {
/*  94 */       for (int x = 0; x < SettlementGrid.TILES; x++) {
/*  95 */         int qx = this.bounds.x1() + x * SettlementGrid.QUAD_HALF;
/*  96 */         int qy = this.bounds.y1() + y * SettlementGrid.QUAD_HALF;
/*     */         
/*  98 */         if (qx >= SETT.TWIDTH)
/*  99 */           qx = SETT.TWIDTH - 1; 
/* 100 */         if (qy >= SETT.THEIGHT) {
/* 101 */           qy = SETT.THEIGHT - 1;
/*     */         }
/* 103 */         this.coos[y][x] = (COORDINATE)new Coo(qx, qy);
/*     */       } 
/*     */     } 
/*     */     
/* 107 */     for (DIR d : DIR.ALL) {
/* 108 */       int qx = this.bounds.cX() + d.x() * (SettlementGrid.QUAD_QUATER + SettlementGrid.QUAD_EIGHTH);
/* 109 */       int qy = this.bounds.cY() + d.y() * (SettlementGrid.QUAD_QUATER + SettlementGrid.QUAD_EIGHTH);
/* 110 */       this.coosInner[d.id()] = (COORDINATE)new Coo(qx, qy);
/*     */     } 
/*     */     
/* 113 */     this.coosInnerC = (COORDINATE)new Coo(this.bounds.cX(), this.bounds.cY());
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<DIR> getDirs() {
/* 118 */     return (LIST<DIR>)this.dirs;
/*     */   }
/*     */   
/*     */   public COORDINATE cooInner(DIR d) {
/* 122 */     if (d == DIR.C)
/* 123 */       return this.coosInnerC; 
/* 124 */     return this.coosInner[d.id()];
/*     */   }
/*     */   
/*     */   public COORDINATE coo(DIR d) {
/* 128 */     return this.coos[d.y() + 1][d.x() + 1];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\main\SettlementGrid$Tile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */