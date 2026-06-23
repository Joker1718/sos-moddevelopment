/*     */ package util.spritecomposer;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SnakeImage;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ComposerFonter
/*     */ {
/*     */   private final ComposerUtil c;
/*  19 */   private final int TRANS = 0;
/*  20 */   private final int GREEN = 16711935;
/*     */   
/*     */   ComposerFonter(ComposerUtil c) {
/*  23 */     this.c = c;
/*     */   }
/*     */ 
/*     */   
/*     */   public Font save(int x1, int y1, int trail) {
/*  28 */     FilePutter p = Resources.p;
/*     */     
/*  30 */     Source s = new Source(this.c.getSource());
/*  31 */     ComposerDests.Tile dest = getDest(s.height());
/*  32 */     Dest d = new Dest(s, dest);
/*     */ 
/*     */     
/*  35 */     Font.FontGlyph[] ggs = new Font.FontGlyph[Font.glyps()];
/*  36 */     for (int i = 0; i < ggs.length; i++) {
/*  37 */       ggs[i] = new Font.FontGlyph();
/*     */     }
/*  39 */     int maxX = dest.startX + dest.tilesX * dest.size;
/*     */     
/*  41 */     int hh = 0;
/*     */     
/*  43 */     for (int j = 0; j < Font.glyps(); j++) {
/*     */       
/*  45 */       s.set(j);
/*     */       
/*  47 */       int width = s.width();
/*     */       
/*  49 */       if (d.x1 + width >= maxX) {
/*  50 */         d.x1 = dest.startX;
/*  51 */         d.y1 += dest.size;
/*     */       } 
/*     */       
/*  54 */       (ggs[j]).width = (short)s.width();
/*  55 */       (ggs[j]).ty1 = (short)d.y1;
/*  56 */       (ggs[j]).tx1 = (short)d.x1;
/*     */       
/*  58 */       setDescent(ggs[j], s);
/*  59 */       if (Character.isLetter(Font.charset().charAt(j))) {
/*  60 */         setCorners(ggs[j], s);
/*     */       }
/*  62 */       setTrail(ggs[j], s);
/*     */       
/*  64 */       hh = Math.max(hh, s.hh);
/*     */       
/*  66 */       this.c.copy(s);
/*  67 */       this.c.paste(d);
/*  68 */       d.x1 += width;
/*     */     }  byte b;
/*     */     int m;
/*     */     Font.FontGlyph[] arrayOfFontGlyph1;
/*  72 */     for (m = (arrayOfFontGlyph1 = ggs).length, b = 0; b < m; ) { Font.FontGlyph g = arrayOfFontGlyph1[b];
/*  73 */       g.descent = (short)(g.descent - s.height - hh);
/*     */       b++; }
/*     */     
/*  76 */     int tStart = dest.x1() / dest.size;
/*  77 */     int tEnd = d.x1() / dest.size + dest.tilesX * (d.y1 - dest.y1()) / dest.size;
/*  78 */     tEnd += (d.x1() % dest.size != 0) ? 1 : 0;
/*  79 */     dest.skip(tEnd - tStart);
/*     */     
/*  81 */     p.mark("font");
/*  82 */     p.i(s.height);
/*  83 */     p.i(d.d.size);
/*  84 */     for (int k = 0; k < Font.glyps(); k++) {
/*  85 */       ggs[k].save(p);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  91 */     return new Font(ggs, s.height(), 1.0D, trail);
/*     */   }
/*     */ 
/*     */   
/*     */   private ComposerDests.Tile getDest(int h) {
/*  96 */     if (h <= Resources.dests.s16.size()) {
/*  97 */       return Resources.dests.s16;
/*     */     }
/*  99 */     if (h <= Resources.dests.s24.size()) {
/* 100 */       return Resources.dests.s24;
/*     */     }
/* 102 */     if (h <= Resources.dests.s32.size()) {
/* 103 */       return Resources.dests.s32;
/*     */     }
/* 105 */     throw new Errors.DataError("Unable to create font. Font height too big: " + h, this.c.getSourcePath());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void setDescent(Font.FontGlyph g, Source d) {
/* 111 */     int dd = 0;
/* 112 */     for (int y = 0; y < d.height(); y++) {
/* 113 */       if (d.im.rgb.get(d.x1() - 1, y + d.y1()) != 16711935) {
/* 114 */         dd++;
/*     */       }
/*     */     } 
/*     */     
/* 118 */     g.descent = (short)dd;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setTrail(Font.FontGlyph g, Source s) {
/* 125 */     for (int y = 0; y < s.height(); y++) {
/* 126 */       int rgb = s.im.rgb.get(s.x1() + s.width - 1, y + s.y1());
/* 127 */       rgb &= 0xFF;
/* 128 */       if (rgb > 32) {
/* 129 */         g.trail = (short)Math.max(g.trail, 1);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setCorners(Font.FontGlyph g, Source d) {
/* 139 */     int off = d.width / 2;
/*     */     int x;
/* 141 */     label61: for (x = 0; x < d.width; x++) {
/* 142 */       for (int y = 0; y < d.height() / 2 - g.descent; y++) {
/* 143 */         if (d.im.rgb.get(x + d.x1(), y + d.y1()) != 0) {
/* 144 */           off = x;
/*     */           break label61;
/*     */         } 
/*     */       } 
/*     */     } 
/* 149 */     g.nw = (byte)CLAMP.i(off - 1, 0, off);
/*     */ 
/*     */ 
/*     */     
/* 153 */     off = d.width / 2;
/*     */     
/* 155 */     label62: for (x = 0; x < d.width; x++) {
/* 156 */       for (int y = 0; y < d.height() / 2 - g.descent; y++) {
/* 157 */         if (d.im.rgb.get(d.x1() + d.width - 1 - x, y + d.y1()) != 0) {
/* 158 */           off = x;
/*     */           break label62;
/*     */         } 
/*     */       } 
/*     */     } 
/* 163 */     g.ne = (byte)CLAMP.i(off - 1, 0, off);
/*     */ 
/*     */ 
/*     */     
/* 167 */     off = d.width / 2;
/*     */     
/* 169 */     label63: for (x = 0; x < d.width; x++) {
/* 170 */       for (int y = 0; y < d.height() / 2; y++) {
/* 171 */         int y1 = y + d.height() / 2 + d.y1();
/* 172 */         y1 -= g.descent;
/* 173 */         if (y1 < d.y1())
/*     */           break; 
/* 175 */         if (d.im.rgb.get(x + d.x1(), y1) != 0) {
/* 176 */           off = x;
/*     */           break label63;
/*     */         } 
/*     */       } 
/*     */     } 
/* 181 */     g.sw = (byte)CLAMP.i(off - 1, 0, off);
/*     */ 
/*     */ 
/*     */     
/* 185 */     off = d.width / 2;
/*     */     
/* 187 */     label64: for (x = 0; x < d.width; x++) {
/* 188 */       for (int y = 0; y < d.height() / 2; y++) {
/* 189 */         int y1 = y + d.height() / 2 + d.y1();
/* 190 */         y1 -= g.descent;
/* 191 */         if (y1 < d.y1())
/*     */           break; 
/* 193 */         if (d.im.rgb.get(d.x1() + d.width - 1 - x, y1) != 0) {
/* 194 */           off = x;
/*     */           break label64;
/*     */         } 
/*     */       } 
/*     */     } 
/* 199 */     g.se = (byte)CLAMP.i(off - 1, 0, off);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Font get(int trail) throws IOException {
/* 206 */     FileGetter g = Resources.g;
/* 207 */     g.check("font");
/* 208 */     int h = g.i();
/* 209 */     int dy = (Optimizer.get(g.i())).startY;
/*     */     
/* 211 */     Font.FontGlyph[] ggs = new Font.FontGlyph[Font.glyps()]; int i;
/* 212 */     for (i = 0; i < ggs.length; i++)
/* 213 */       ggs[i] = new Font.FontGlyph(); 
/* 214 */     for (i = 0; i < Font.glyps(); i++) {
/*     */       
/* 216 */       ggs[i].load(g);
/* 217 */       (ggs[i]).ty1 = (short)((ggs[i]).ty1 + dy);
/*     */     } 
/*     */     
/* 220 */     return new Font(ggs, h, 1.0D, trail);
/*     */   }
/*     */   
/*     */   private final class Source
/*     */     extends ComposerSources.Source {
/* 225 */     private final Rec body = new Rec(); private int dim;
/*     */     private final int height;
/*     */     private int width;
/*     */     private int pixelX1;
/*     */     private int pixelY1;
/*     */     private final SnakeImage im;
/*     */     private int hh;
/*     */     
/*     */     Source(SnakeImage im) {
/* 234 */       this.im = im;
/* 235 */       this.dim = im.width / 128 - 2;
/* 236 */       this.height = this.dim;
/*     */     }
/*     */ 
/*     */     
/*     */     public RECTANGLE body() {
/* 241 */       return (RECTANGLE)this.body;
/*     */     }
/*     */ 
/*     */     
/*     */     int height() {
/* 246 */       return this.height;
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 251 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 256 */       return this.pixelX1;
/*     */     }
/*     */ 
/*     */     
/*     */     int y1() {
/* 261 */       return this.pixelY1;
/*     */     }
/*     */ 
/*     */     
/*     */     Source set(int cI) {
/* 266 */       this.pixelX1 = cI % 64 * (this.dim + 2) + 1;
/* 267 */       this.pixelY1 = cI / 64 * (this.dim + 2) + 1;
/* 268 */       this.width = this.dim;
/*     */       
/*     */       int x;
/*     */       
/* 272 */       label28: for (x = this.dim - 1; x >= 0; x--) {
/* 273 */         for (int i = 0; i < this.dim; i++) {
/* 274 */           if (this.im.rgb.get(this.pixelX1 + x, this.pixelY1 + i) != 0) {
/* 275 */             this.width = x + 1;
/*     */             
/*     */             break label28;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/*     */       int y;
/*     */       
/* 284 */       label29: for (y = this.dim - 1; y > 0; y--) {
/* 285 */         for (int i = 0; i < this.dim; i++) {
/* 286 */           if (this.im.rgb.get(this.pixelX1 + i, this.pixelY1 + y) != 0) {
/* 287 */             this.hh = y;
/*     */ 
/*     */             
/*     */             break label29;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 296 */       return this;
/*     */     }
/*     */   }
/*     */   
/*     */   private class Dest
/*     */     extends ComposerDests.Dest {
/*     */     private int x1;
/*     */     int y1;
/*     */     private final ComposerDests.Tile d;
/*     */     private final ComposerFonter.Source s;
/*     */     
/*     */     Dest(ComposerFonter.Source s, ComposerDests.Tile d) {
/* 308 */       this.s = s;
/* 309 */       this.d = d;
/* 310 */       this.x1 = d.x1();
/* 311 */       this.y1 = d.y1();
/*     */     }
/*     */ 
/*     */     
/*     */     int x1() {
/* 316 */       return this.x1;
/*     */     }
/*     */ 
/*     */     
/*     */     int y1() {
/* 321 */       return this.y1;
/*     */     }
/*     */ 
/*     */     
/*     */     int width() {
/* 326 */       return this.s.width();
/*     */     }
/*     */ 
/*     */     
/*     */     int height() {
/* 331 */       return this.s.height();
/*     */     }
/*     */ 
/*     */     
/*     */     public void jump(int i) {
/* 336 */       this.d.jump(i);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void dispose() {}
/*     */ 
/*     */ 
/*     */     
/*     */     int size() {
/* 347 */       return this.d.size();
/*     */     }
/*     */ 
/*     */     
/*     */     public void diffuseSet(int x, int y, int c) {
/* 352 */       this.d.diffuseSet(x, y, c);
/*     */     }
/*     */ 
/*     */     
/*     */     public int diffuseGet(int x, int y) {
/* 357 */       return this.d.diffuseGet(x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public void normalSet(int x, int y, int c) {
/* 362 */       this.d.normalSet(x, y, c);
/*     */     }
/*     */ 
/*     */     
/*     */     public int normalGet(int x, int y) {
/* 367 */       return this.d.normalGet(x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public int destWidth() {
/* 372 */       return this.d.destWidth();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\spritecomposer\ComposerFonter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */