/*     */ package settlement.tilemap;
/*     */ 
/*     */ import game.GAME;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.TextureHolder;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayListShort;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.rendering.Minimap;
/*     */ 
/*     */ 
/*     */ final class MinimapColorGetter
/*     */ {
/*  17 */   private final ColorImp col = new ColorImp();
/*  18 */   private DIR[] dirNorth = new DIR[] { DIR.W, DIR.NW, DIR.N, DIR.NE };
/*  19 */   private DIR[] dirShade = new DIR[] { DIR.E, DIR.SE, DIR.S, DIR.SW };
/*     */   
/*  21 */   private final int qs = 8;
/*  22 */   private final int sc = Integer.numberOfTrailingZeros(8);
/*  23 */   private final int ww = SETT.TWIDTH >> this.sc;
/*     */   
/*  25 */   private Bitmap1D bits = new Bitmap1D(SETT.TWIDTH * SETT.THEIGHT / 64, false);
/*  26 */   private ArrayListShort queue = new ArrayListShort(SETT.TWIDTH * SETT.THEIGHT / 64);
/*  27 */   private final TextureHolder.TextureHolderChunk chunk = new TextureHolder.TextureHolderChunk(8, 8);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public COLOR get(int x, int y) {
/*  33 */     TileMap.SMinimapGetter r = miniR(x, y);
/*  34 */     COLOR c = r.miniC(x, y);
/*  35 */     boolean n = false;
/*  36 */     boolean s = false; byte b; int i;
/*     */     DIR[] arrayOfDIR;
/*  38 */     for (i = (arrayOfDIR = this.dirNorth).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/*  39 */       int dx = x + d.x();
/*  40 */       int dy = y + d.y();
/*  41 */       if (SETT.IN_BOUNDS(dx, dy)) {
/*  42 */         TileMap.SMinimapGetter r2 = miniR(dx, dy);
/*  43 */         if (r2 == null || r != r2) {
/*  44 */           n = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/*  50 */     for (i = (arrayOfDIR = this.dirShade).length, b = 0; b < i; ) { DIR d = arrayOfDIR[b];
/*  51 */       int dx = x + d.x();
/*  52 */       int dy = y + d.y();
/*  53 */       if (SETT.IN_BOUNDS(dx, dy)) {
/*  54 */         TileMap.SMinimapGetter r2 = miniR(dx, dy);
/*  55 */         if (r2 == null || r != r2) {
/*  56 */           s = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       b++; }
/*     */     
/*  63 */     this.col.set(c);
/*     */     
/*  65 */     return r.miniColorPimped(this.col, x, y, n, s);
/*     */   }
/*     */ 
/*     */   
/*     */   private TileMap.SMinimapGetter miniR(int x, int y) {
/*  70 */     if (!SETT.IN_BOUNDS(x, y))
/*  71 */       return null; 
/*  72 */     COLOR c = (SETT.ROOMS()).miniC.miniC(x, y);
/*  73 */     if (c != null)
/*  74 */       return (SETT.ROOMS()).miniC; 
/*  75 */     c = SETT.TERRAIN().get(x, y).miniC(x, y);
/*  76 */     if (c != null)
/*  77 */       return (TileMap.SMinimapGetter)SETT.TERRAIN().get(x, y); 
/*  78 */     c = (SETT.FLOOR()).minimap.miniC(x, y);
/*  79 */     if (c != null)
/*  80 */       return (SETT.FLOOR()).minimap; 
/*  81 */     return (SETT.GROUND()).minimap;
/*     */   }
/*     */   
/*     */   public void update(int tx, int ty) {
/*  85 */     for (int di = 0; di < DIR.ALLC.size(); di++) {
/*  86 */       DIR dir = (DIR)DIR.ALLC.get(di);
/*  87 */       int dx = tx + dir.x();
/*  88 */       int dy = ty + dir.y();
/*  89 */       if (SETT.IN_BOUNDS(dx, dy)) {
/*  90 */         dx >>= this.sc;
/*  91 */         dy >>= this.sc;
/*  92 */         int i = dx + dy * this.ww;
/*  93 */         if (!this.bits.get(i)) {
/*  94 */           this.queue.add(i);
/*  95 */           this.bits.setTrue(i);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void clear() {
/* 104 */     this.queue.clear();
/* 105 */     this.bits.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   void update() {
/* 110 */     if (this.queue.size() > 0) {
/* 111 */       int q = this.queue.remove(this.queue.size() - 1);
/* 112 */       this.bits.setFalse(q);
/* 113 */       int tx = q % this.ww;
/* 114 */       int ty = q / this.ww;
/* 115 */       tx <<= this.sc;
/* 116 */       ty <<= this.sc;
/*     */       
/* 118 */       int i = 0;
/* 119 */       for (int dy = 0; dy < 8; dy++) {
/* 120 */         for (int dx = 0; dx < 8; dx++) {
/* 121 */           COLOR cOLOR = get(tx + dx, ty + dy);
/*     */           
/* 123 */           this.chunk.put(i++, Minimap.getC(cOLOR.red()), Minimap.getC(cOLOR.green()), Minimap.getC(cOLOR.blue()), (byte)-1);
/*     */         } 
/*     */       } 
/*     */       
/* 127 */       TextureCoords c = SETT.MINIMAP().texture(tx, ty, this.chunk.width, this.chunk.height);
/*     */       
/* 129 */       GAME.texture().addChunk(c.x1, c.y1, this.chunk.width, this.chunk.width * this.chunk.height, this.chunk);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\MinimapColorGetter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */