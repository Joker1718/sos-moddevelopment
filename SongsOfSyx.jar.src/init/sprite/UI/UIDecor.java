/*     */ package init.sprite.UI;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
/*     */ import util.spritecomposer.SpriteData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UIDecor
/*     */ {
/*  33 */   public final SPRITE topDecor = new SPRITE()
/*     */     {
/*  35 */       private final TILE_SHEET sheet2 = (new ComposerThings.ITileSheet(PATHS.SPRITE_UI().get("Decor"), 664, 160)
/*     */         {
/*     */           protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */           {
/*  39 */             s.full.init(0, 0, 1, 1, 4, 1, d.s32);
/*  40 */             s.full.paste(true);
/*  41 */             return d.s32.saveGui();
/*     */           }
/*  43 */         }).get();
/*     */ 
/*     */       
/*     */       public int width() {
/*  47 */         return 128;
/*     */       }
/*     */ 
/*     */       
/*     */       public int height() {
/*  52 */         return 32;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */ 
/*     */ 
/*     */       
/*     */       public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  63 */         (GCOLOR.T()).H1.bind();
/*  64 */         for (int i = 0; i < 4; i++)
/*  65 */           this.sheet2.render(r, i, X1 + 32 * i, Y1); 
/*  66 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */   
/*  70 */   private final TILE_SHEET _borderTop = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  74 */         s.full.init(0, s.full.body().y2(), 1, 1, 10, 1, d.s32);
/*  75 */         s.full.setSkip(4, 0);
/*  76 */         s.full.paste(true);
/*  77 */         return d.s32.saveGui();
/*     */       }
/*  79 */     }).get();
/*     */   
/*  81 */   private final TILE_SHEET _borderBottom = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  85 */         s.full.setSkip(4, 4);
/*  86 */         s.full.paste(true);
/*  87 */         return d.s32.saveGui();
/*     */       }
/*  89 */     }).get();
/*     */   
/*  91 */   private final TILE_SHEET _leftRight = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/*  95 */         s.full.setSkip(2, 8);
/*  96 */         s.full.paste(true);
/*  97 */         return d.s32.saveGui();
/*     */       }
/*  99 */     }).get();
/*     */   
/* 101 */   public final TILE_SHEET slider = (new ComposerThings.ITileSheet()
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 105 */         s.full.init(0, s.full.body().y2(), 1, 1, 4, 1, d.s24);
/* 106 */         s.full.paste(true);
/* 107 */         s.full.pasteRotated(1, true);
/* 108 */         return d.s24.saveGui();
/*     */       }
/* 110 */     }).get();
/*     */   
/* 112 */   public final SPRITE mouse = ComposerThings.ISprite.gui((new ComposerThings.ISpriteData()
/*     */       {
/*     */         protected SpriteData init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 116 */           s.full.init(0, s.full.body().y2(), 1, 1, 1, 1, d.s24);
/* 117 */           s.full.setSkip(1, 0).paste(true);
/* 118 */           return d.s24.saveSprite();
/*     */         }
/* 120 */       }).get());
/*     */   
/* 122 */   public final SPRITE mouseHov = ComposerThings.ISprite.gui((new ComposerThings.ISpriteData()
/*     */       {
/*     */         protected SpriteData init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 126 */           s.full.init(s.full.body().x2(), s.full.body().y1(), 1, 1, 1, 1, d.s24);
/* 127 */           s.full.setSkip(1, 0).paste(true);
/* 128 */           return d.s24.saveSprite();
/*     */         }
/* 130 */       }).get());
/*     */   
/* 132 */   public final SPRITE up = (SPRITE)new ComposerThings.ITileSprite(32, 16, 1)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 136 */         s.full.init(s.full.body().x2(), s.full.body().y1(), 1, 1, 4, 1, d.s16);
/* 137 */         s.full.setSkip(2, 0).paste(true);
/* 138 */         return d.s16.saveGui();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 143 */   public final SPRITE down = (SPRITE)new ComposerThings.ITileSprite(32, 16, 1)
/*     */     {
/*     */       protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */       {
/* 147 */         s.full.setSkip(2, 2).paste(true);
/* 148 */         return d.s16.saveGui();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE borderTop(int width) {
/* 155 */     return new Adaptive(width, this._borderTop);
/*     */   }
/*     */   
/*     */   public SPRITE borderBottom(int width) {
/* 159 */     return new Adaptive(width, this._borderBottom);
/*     */   }
/*     */   
/*     */   public SPRITE borderTop(int width, COLOR color) {
/* 163 */     return new Adaptive(width, this._borderTop, color);
/*     */   }
/*     */   
/*     */   public SPRITE borderBottom(int width, COLOR color) {
/* 167 */     return new Adaptive(width, this._borderBottom, color);
/*     */   }
/*     */   
/*     */   public RENDEROBJ decorate(CharSequence s) {
/* 171 */     return decorate(s, (GCOLOR.T()).H1);
/*     */   }
/*     */   
/*     */   public RENDEROBJ decorate(CharSequence s, COLOR c) {
/* 175 */     GuiSection sec = new GuiSection();
/* 176 */     sec.add((RENDEROBJ)(new RENDEROBJ.Sprite(this._leftRight.makeSprite(0))).setColor(c));
/* 177 */     sec.addRightC(20, (RENDEROBJ)(new RENDEROBJ.Sprite((SPRITE)(new Text((UI.FONT()).H1, s)).toUpper())).setColor(c));
/* 178 */     sec.addRightC(20, (RENDEROBJ)(new RENDEROBJ.Sprite(this._leftRight.makeSprite(1))).setColor(c));
/* 179 */     return (RENDEROBJ)sec;
/*     */   }
/*     */   
/*     */   public RENDEROBJ getDecored(CharSequence s) {
/* 183 */     GText t = new GText((UI.FONT()).H1, s)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 186 */           (GCOLOR.T()).H1.bind();
/* 187 */           int w = (X2 - X1) / 2;
/* 188 */           w -= UIDecor.this.topDecor.width() / 2;
/* 189 */           UIDecor.this.topDecor.render(r, X1 + w, Y1 - UIDecor.this.topDecor.height());
/* 190 */           COLOR.unbind();
/* 191 */           super.render(r, X1, X2, Y1, Y2);
/*     */         }
/*     */       };
/* 194 */     t.lablify();
/* 195 */     t.toUpper();
/* 196 */     return (RENDEROBJ)t.r(DIR.C);
/*     */   }
/*     */   
/*     */   public RENDEROBJ frame(RECTANGLE bounds) {
/* 200 */     RENDEROBJ.Sprite sprite = new RENDEROBJ.Sprite(new Frame(bounds.width() + 32, bounds.height()));
/* 201 */     sprite.body().centerIn(bounds);
/* 202 */     return (RENDEROBJ)sprite;
/*     */   }
/*     */   
/*     */   public RENDEROBJ frame(RECTANGLE bounds, COLOR color) {
/* 206 */     RENDEROBJ.Sprite sprite = new RENDEROBJ.Sprite(new Frame(bounds.width() + 32, bounds.height(), color));
/* 207 */     sprite.body().centerIn(bounds);
/* 208 */     return (RENDEROBJ)sprite;
/*     */   }
/*     */   
/*     */   public GuiSection frame(int width, int height) {
/* 212 */     GuiSection s = new GuiSection();
/* 213 */     s.add(borderTop(width), 0, 0);
/* 214 */     RENDEROBJ.Sprite sprite = new RENDEROBJ.Sprite(borderBottom(width));
/* 215 */     sprite.body().moveY1(height);
/* 216 */     s.add((RENDEROBJ)sprite);
/* 217 */     return s;
/*     */   }
/*     */   
/*     */   public RENDEROBJ frame(RECTANGLE bounds, CharSequence title) {
/* 221 */     GuiSection f = frame(bounds.width(), bounds.height() + 32, title);
/* 222 */     f.body().centerX(bounds);
/* 223 */     f.body().moveY2((bounds.y2() + 32));
/* 224 */     return (RENDEROBJ)f;
/*     */   }
/*     */   
/*     */   public GuiSection frame(int width, int height, CharSequence title) {
/* 228 */     GuiSection s = frame(width, height);
/* 229 */     RENDEROBJ o = decorate(title);
/* 230 */     s.addRelBody(0, DIR.N, o);
/* 231 */     return s;
/*     */   }
/*     */   
/*     */   public GuiSection frameFancy(int width, int height, CharSequence title) {
/* 235 */     GuiSection s = frame(width, height);
/* 236 */     s.addRelBody(0, DIR.N, (RENDEROBJ)(new RENDEROBJ.Sprite((SPRITE)(new Text((UI.FONT()).H1, title)).toUpper())).setColor((GCOLOR.T()).H1));
/* 237 */     s.addRelBody(0, DIR.N, this.topDecor);
/* 238 */     return s;
/*     */   }
/*     */   
/*     */   private class Frame
/*     */     implements SPRITE {
/*     */     private final SPRITE top;
/*     */     private final SPRITE bottom;
/*     */     private final int width;
/*     */     private final int height;
/*     */     
/*     */     Frame(int width, int height) {
/* 249 */       this(width, height, (GCOLOR.T()).H1);
/*     */     }
/*     */     
/*     */     Frame(int width, int height, COLOR color) {
/* 253 */       this.width = width;
/* 254 */       this.height = height + 64;
/* 255 */       this.top = UIDecor.this.borderTop(width, color);
/* 256 */       this.bottom = UIDecor.this.borderBottom(width, color);
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 261 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 266 */       return this.height;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 271 */       this.top.render(r, X1, Y1);
/* 272 */       this.bottom.render(r, X1, Y2 - 32);
/*     */     }
/*     */ 
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */   }
/*     */ 
/*     */   
/*     */   private static class Adaptive
/*     */     implements SPRITE
/*     */   {
/*     */     private static final int size = 32;
/*     */     
/*     */     private final int width;
/*     */     
/*     */     private final TILE_SHEET sheet;
/*     */     private final COLOR color;
/*     */     
/*     */     Adaptive(int width, TILE_SHEET sheet) {
/* 291 */       this(width, sheet, (GCOLOR.T()).H1);
/*     */     }
/*     */     
/*     */     Adaptive(int width, TILE_SHEET sheet, COLOR color) {
/* 295 */       this.width = width;
/* 296 */       this.sheet = sheet;
/* 297 */       this.color = color;
/*     */     }
/*     */ 
/*     */     
/*     */     public int width() {
/* 302 */       return this.width;
/*     */     }
/*     */ 
/*     */     
/*     */     public int height() {
/* 307 */       return 32;
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 312 */       this.color.bind();
/* 313 */       int w = X2 - X1 - 96;
/* 314 */       if (w < 0)
/* 315 */         w = 0; 
/* 316 */       w /= 2;
/* 317 */       int dw = w % 32;
/* 318 */       w /= 32;
/*     */       
/* 320 */       this.sheet.render(r, 0, X1, Y1);
/* 321 */       X1 += 32; int i;
/* 322 */       for (i = 0; i < w; i++) {
/* 323 */         this.sheet.render(r, 1, X1, Y1);
/* 324 */         X1 += 32;
/*     */       } 
/* 326 */       if (dw != 0) {
/* 327 */         this.sheet.render(r, 1, X1 - 32 - dw, Y1);
/* 328 */         X1 += dw;
/*     */       } 
/* 330 */       this.sheet.render(r, 2, X1, Y1);
/* 331 */       X1 += 32;
/* 332 */       for (i = 0; i < w; i++) {
/* 333 */         this.sheet.render(r, 1, X1, Y1);
/* 334 */         X1 += 32;
/*     */       } 
/* 336 */       if (dw != 0) {
/* 337 */         this.sheet.render(r, 1, X1 - 32 - dw, Y1);
/* 338 */         X1 += dw;
/*     */       } 
/* 340 */       this.sheet.render(r, 3, X1, Y1);
/* 341 */       COLOR.unbind();
/*     */     }
/*     */     
/*     */     public void renderTextured(TextureCoords texture, int X1, int X2, int Y1, int Y2) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\UI\UIDecor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */