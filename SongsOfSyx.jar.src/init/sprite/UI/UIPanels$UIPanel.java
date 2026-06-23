/*     */ package init.sprite.UI;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
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
/*     */ public class UIPanel
/*     */ {
/*     */   public final int margin;
/*     */   private final int min;
/*     */   public final int tMid;
/*     */   private final TILE_SHEET sheet;
/*     */   public static final int dim = 24;
/* 170 */   private static final int[] toBox = Alloc.ii(16);
/*     */   static {
/* 172 */     toBox[DIR.N.mask() | DIR.W.mask()] = 0;
/* 173 */     toBox[DIR.N.mask()] = 1;
/* 174 */     toBox[DIR.N.mask() | DIR.E.mask()] = 2;
/* 175 */     toBox[DIR.W.mask()] = 3;
/* 176 */     toBox[0] = 4;
/* 177 */     toBox[DIR.E.mask()] = 5;
/* 178 */     toBox[DIR.W.mask() | DIR.S.mask()] = 6;
/* 179 */     toBox[DIR.S.mask()] = 7;
/* 180 */     toBox[DIR.E.mask() | DIR.S.mask()] = 8;
/*     */   }
/*     */   
/*     */   UIPanel(final int variation, int margin, int tMid) throws IOException {
/* 184 */     this.sheet = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 188 */           s.full.setVar(variation);
/* 189 */           s.full.paste(true);
/* 190 */           return d.s24.saveGui();
/*     */         }
/* 193 */       }).get();
/* 194 */     this.tMid = tMid;
/* 195 */     this.margin = margin;
/* 196 */     this.min = 24 - margin;
/*     */   }
/*     */   
/*     */   public int dim(int dim, int margin) {
/* 200 */     return dim + margin * 2 + this.margin * 2;
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, RECTANGLE body, int margin, int dirmask) {
/* 204 */     render(r, body.x1(), body.x2(), body.y1(), body.y2(), margin, dirmask);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2, int margin, int dirmask) {
/* 210 */     X1 -= margin;
/* 211 */     int width = X2 - X1 + margin;
/* 212 */     Y1 -= margin;
/* 213 */     int height = Y2 - Y1 + margin;
/*     */     
/* 215 */     if (width < this.min) {
/* 216 */       width = this.min;
/*     */     }
/* 218 */     if (height < this.min) {
/* 219 */       height = this.min;
/*     */     }
/* 221 */     X2 = X1 + width;
/* 222 */     Y2 = Y1 + height;
/*     */     
/* 224 */     X1 -= this.margin;
/* 225 */     X2 += this.margin;
/* 226 */     Y1 -= this.margin;
/* 227 */     Y2 += this.margin;
/*     */     
/*     */     int x;
/* 230 */     for (x = X1; x < X2; x += 24) {
/* 231 */       if (x == X1) {
/* 232 */         render(r, x, Y1, DIR.W, DIR.N, dirmask);
/* 233 */       } else if (x + 24 >= X2) {
/* 234 */         render(r, X2 - 24, Y1, DIR.E, DIR.N, dirmask);
/*     */       } else {
/* 236 */         render(r, x, Y1, DIR.N, DIR.N, dirmask);
/*     */       } 
/*     */     } 
/* 239 */     Y1 += 24;
/* 240 */     while (Y1 + 24 < Y2) {
/* 241 */       for (x = X1; x < X2; x += 24) {
/* 242 */         if (x == X1) {
/* 243 */           render(r, x, Y1, DIR.W, DIR.W, dirmask);
/* 244 */         } else if (x + 24 >= X2) {
/* 245 */           render(r, X2 - 24, Y1, DIR.E, DIR.E, dirmask);
/*     */         } else {
/* 247 */           render(r, x, Y1, DIR.C, DIR.C, dirmask);
/*     */         } 
/*     */       } 
/* 250 */       Y1 += 24;
/*     */     } 
/*     */     
/* 253 */     Y1 = Y2 - 24;
/*     */     
/* 255 */     for (x = X1; x < X2; x += 24) {
/* 256 */       if (x == X1) {
/* 257 */         render(r, x, Y1, DIR.W, DIR.S, dirmask);
/* 258 */       } else if (x + 24 >= X2) {
/* 259 */         render(r, X2 - 24, Y1, DIR.E, DIR.S, dirmask);
/*     */       } else {
/* 261 */         render(r, x, Y1, DIR.S, DIR.S, dirmask);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void render(SPRITE_RENDERER r, int x, int y, DIR d1, DIR d2, int dirMask) {
/* 269 */     int m = d1.mask() & dirMask | d2.mask() & dirMask;
/* 270 */     int i = toBox[m & 0xF];
/* 271 */     this.sheet.render(r, i, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2, int margin) {
/* 276 */     render(r, X1, X2, Y1, Y2, margin, -1);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, RECTANGLE body, int margin) {
/* 280 */     render(r, body.x1(), body.x2(), body.y1(), body.y2(), margin);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, RECTANGLE body, int margin, DIR d1, DIR d2) {
/* 284 */     render(r, body.x1(), body.x2(), body.y1(), body.y2(), margin, d1.mask() | d2.mask());
/*     */   }
/*     */   
/*     */   public void renderVertical(SPRITE_RENDERER r, int x1, int y1, int height) {
/* 288 */     int y2 = y1 + height;
/* 289 */     while (y1 < y2) {
/* 290 */       if (y1 + 24 > y2)
/* 291 */         y1 = y2 - 24; 
/* 292 */       render(r, x1, y1, DIR.W, DIR.W, -1);
/* 293 */       y1 += 24;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderHorizontal(SPRITE_RENDERER r, int x1, int x2, int y1) {
/* 299 */     while (x1 <= x2 - 24) {
/* 300 */       render(r, x1, y1, DIR.N, DIR.N, -1);
/* 301 */       x1 += 24;
/*     */     } 
/* 303 */     render(r, x2 - 24, y1, DIR.N, DIR.N, -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIPanels$UIPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */