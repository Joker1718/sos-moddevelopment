/*     */ package init.sprite.UI;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
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
/*     */ public final class UIPanels
/*     */ {
/*  39 */   public final UIPanel thin = new UIPanel(0, 5, 3);
/*  40 */   public final UIPanel butt = new UIPanel(1, 3, 1);
/*  41 */   public final UIPanel big = new UIPanel(2, 12, 9);
/*     */   public TILE_SHEET panelClose;
/*  43 */   public final TitleBox[] titleBoxes = new TitleBox[3];
/*     */   
/*     */   UIPanels() throws IOException {
/*  46 */     TILE_SHEET s = (new ComposerThings.ITileSheet(PATHS.SPRITE_UI().get("TitleBox"), 312, 140)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  50 */           s.full.init(0, 0, 1, 1, 3, 1, d.s24);
/*  51 */           s.full.paste(true);
/*  52 */           return d.s24.saveGui();
/*     */         }
/*  54 */       }).get();
/*  55 */     this.titleBoxes[0] = new TitleBoxN(24, s);
/*     */     
/*  57 */     this.panelClose = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  61 */           s.full.init(s.full.body().x2(), 0, 1, 1, 2, 1, d.s24);
/*  62 */           s.full.paste(true);
/*  63 */           return d.s24.saveGui();
/*     */         }
/*  65 */       }).get();
/*     */     
/*  67 */     s = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  71 */           s.full.init(0, s.full.body().y2(), 1, 1, 3, 1, d.s32);
/*  72 */           s.full.paste(true);
/*  73 */           return d.s32.saveGui();
/*     */         }
/*  75 */       }).get();
/*  76 */     this.titleBoxes[1] = new TitleBoxN(32, s);
/*     */     
/*  78 */     final TILE_SHEET ss = (new ComposerThings.ITileSheet()
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/*  82 */           s.full.init(0, s.full.body().y2(), 1, 1, 6, 2, d.s24);
/*  83 */           s.full.paste(true);
/*  84 */           return d.s24.saveGui();
/*     */         }
/*  86 */       }).get();
/*     */     
/*  88 */     this.titleBoxes[2] = new TitleBox(48)
/*     */       {
/*     */         
/*     */         public void render(SPRITE_RENDERER r, int x1, int y1, int width)
/*     */         {
/*  93 */           renderP(r, 0, x1 - this.height, y1);
/*  94 */           for (int w = 0; w + this.height < width; w++) {
/*  95 */             renderP(r, 1, x1 + w, y1);
/*     */           }
/*  97 */           renderP(r, 1, x1 + width - this.height, y1);
/*  98 */           renderP(r, 2, x1 + width, y1);
/*     */         }
/*     */ 
/*     */         
/*     */         private void renderP(SPRITE_RENDERER r, int t, int x1, int y1) {
/* 103 */           ss.render(r, t * 2, x1, y1);
/* 104 */           ss.render(r, t * 2 + 1, x1 + 24, y1);
/* 105 */           ss.render(r, t * 2 + 6, x1, y1 + 24);
/* 106 */           ss.render(r, t * 2 + 7, x1 + 24, y1 + 24);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TitleBox titleBox(int height) {
/*     */     byte b;
/*     */     int i;
/*     */     TitleBox[] arrayOfTitleBox;
/* 118 */     for (i = (arrayOfTitleBox = this.titleBoxes).length, b = 0; b < i; ) { TitleBox titleBox = arrayOfTitleBox[b];
/* 119 */       if (height <= titleBox.height - 8)
/* 120 */         return titleBox;  b++; }
/*     */     
/* 122 */     return this.titleBoxes[this.titleBoxes.length - 1];
/*     */   }
/*     */   
/*     */   public static abstract class TitleBox
/*     */   {
/*     */     public int height;
/*     */     
/*     */     protected TitleBox(int height) {
/* 130 */       this.height = height;
/*     */     }
/*     */     public abstract void render(SPRITE_RENDERER param1SPRITE_RENDERER, int param1Int1, int param1Int2, int param1Int3);
/*     */     
/*     */     public void renderCY(SPRITE_RENDERER r, int x1, int cy, int width) {
/* 135 */       render(r, x1, cy - this.height / 2, width);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class TitleBoxN
/*     */     extends TitleBox {
/*     */     private final TILE_SHEET sheet;
/*     */     
/*     */     private TitleBoxN(int height, TILE_SHEET sheet) {
/* 144 */       super(height);
/* 145 */       this.sheet = sheet;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int x1, int y1, int width) {
/* 151 */       this.sheet.render(r, 0, x1 - this.height, y1);
/* 152 */       for (int w = 0; w + this.height < width; w++) {
/* 153 */         this.sheet.render(r, 1, x1 + w, y1);
/*     */       }
/* 155 */       this.sheet.render(r, 1, x1 + width - this.height, y1);
/* 156 */       this.sheet.render(r, 2, x1 + width, y1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class UIPanel
/*     */   {
/*     */     public final int margin;
/*     */     
/*     */     private final int min;
/*     */     
/*     */     public final int tMid;
/*     */     private final TILE_SHEET sheet;
/*     */     public static final int dim = 24;
/* 170 */     private static final int[] toBox = Alloc.ii(16);
/*     */     static {
/* 172 */       toBox[DIR.N.mask() | DIR.W.mask()] = 0;
/* 173 */       toBox[DIR.N.mask()] = 1;
/* 174 */       toBox[DIR.N.mask() | DIR.E.mask()] = 2;
/* 175 */       toBox[DIR.W.mask()] = 3;
/* 176 */       toBox[0] = 4;
/* 177 */       toBox[DIR.E.mask()] = 5;
/* 178 */       toBox[DIR.W.mask() | DIR.S.mask()] = 6;
/* 179 */       toBox[DIR.S.mask()] = 7;
/* 180 */       toBox[DIR.E.mask() | DIR.S.mask()] = 8;
/*     */     }
/*     */     
/*     */     UIPanel(final int variation, int margin, int tMid) throws IOException {
/* 184 */       this.sheet = (new ComposerThings.ITileSheet()
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/* 188 */             s.full.setVar(variation);
/* 189 */             s.full.paste(true);
/* 190 */             return d.s24.saveGui();
/*     */           }
/* 193 */         }).get();
/* 194 */       this.tMid = tMid;
/* 195 */       this.margin = margin;
/* 196 */       this.min = 24 - margin;
/*     */     }
/*     */     
/*     */     public int dim(int dim, int margin) {
/* 200 */       return dim + margin * 2 + this.margin * 2;
/*     */     }
/*     */     
/*     */     public void render(SPRITE_RENDERER r, RECTANGLE body, int margin, int dirmask) {
/* 204 */       render(r, body.x1(), body.x2(), body.y1(), body.y2(), margin, dirmask);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2, int margin, int dirmask) {
/* 210 */       X1 -= margin;
/* 211 */       int width = X2 - X1 + margin;
/* 212 */       Y1 -= margin;
/* 213 */       int height = Y2 - Y1 + margin;
/*     */       
/* 215 */       if (width < this.min) {
/* 216 */         width = this.min;
/*     */       }
/* 218 */       if (height < this.min) {
/* 219 */         height = this.min;
/*     */       }
/* 221 */       X2 = X1 + width;
/* 222 */       Y2 = Y1 + height;
/*     */       
/* 224 */       X1 -= this.margin;
/* 225 */       X2 += this.margin;
/* 226 */       Y1 -= this.margin;
/* 227 */       Y2 += this.margin;
/*     */       
/*     */       int x;
/* 230 */       for (x = X1; x < X2; x += 24) {
/* 231 */         if (x == X1) {
/* 232 */           render(r, x, Y1, DIR.W, DIR.N, dirmask);
/* 233 */         } else if (x + 24 >= X2) {
/* 234 */           render(r, X2 - 24, Y1, DIR.E, DIR.N, dirmask);
/*     */         } else {
/* 236 */           render(r, x, Y1, DIR.N, DIR.N, dirmask);
/*     */         } 
/*     */       } 
/* 239 */       Y1 += 24;
/* 240 */       while (Y1 + 24 < Y2) {
/* 241 */         for (x = X1; x < X2; x += 24) {
/* 242 */           if (x == X1) {
/* 243 */             render(r, x, Y1, DIR.W, DIR.W, dirmask);
/* 244 */           } else if (x + 24 >= X2) {
/* 245 */             render(r, X2 - 24, Y1, DIR.E, DIR.E, dirmask);
/*     */           } else {
/* 247 */             render(r, x, Y1, DIR.C, DIR.C, dirmask);
/*     */           } 
/*     */         } 
/* 250 */         Y1 += 24;
/*     */       } 
/*     */       
/* 253 */       Y1 = Y2 - 24;
/*     */       
/* 255 */       for (x = X1; x < X2; x += 24) {
/* 256 */         if (x == X1) {
/* 257 */           render(r, x, Y1, DIR.W, DIR.S, dirmask);
/* 258 */         } else if (x + 24 >= X2) {
/* 259 */           render(r, X2 - 24, Y1, DIR.E, DIR.S, dirmask);
/*     */         } else {
/* 261 */           render(r, x, Y1, DIR.S, DIR.S, dirmask);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private void render(SPRITE_RENDERER r, int x, int y, DIR d1, DIR d2, int dirMask) {
/* 269 */       int m = d1.mask() & dirMask | d2.mask() & dirMask;
/* 270 */       int i = toBox[m & 0xF];
/* 271 */       this.sheet.render(r, i, x, y);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2, int margin) {
/* 276 */       render(r, X1, X2, Y1, Y2, margin, -1);
/*     */     }
/*     */     
/*     */     public void render(SPRITE_RENDERER r, RECTANGLE body, int margin) {
/* 280 */       render(r, body.x1(), body.x2(), body.y1(), body.y2(), margin);
/*     */     }
/*     */     
/*     */     public void render(SPRITE_RENDERER r, RECTANGLE body, int margin, DIR d1, DIR d2) {
/* 284 */       render(r, body.x1(), body.x2(), body.y1(), body.y2(), margin, d1.mask() | d2.mask());
/*     */     }
/*     */     
/*     */     public void renderVertical(SPRITE_RENDERER r, int x1, int y1, int height) {
/* 288 */       int y2 = y1 + height;
/* 289 */       while (y1 < y2) {
/* 290 */         if (y1 + 24 > y2)
/* 291 */           y1 = y2 - 24; 
/* 292 */         render(r, x1, y1, DIR.W, DIR.W, -1);
/* 293 */         y1 += 24;
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderHorizontal(SPRITE_RENDERER r, int x1, int x2, int y1) {
/* 299 */       while (x1 <= x2 - 24) {
/* 300 */         render(r, x1, y1, DIR.N, DIR.N, -1);
/* 301 */         x1 += 24;
/*     */       } 
/* 303 */       render(r, x2 - 24, y1, DIR.N, DIR.N, -1);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIPanels.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */