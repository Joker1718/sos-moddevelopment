/*     */ package view.ui.wiki;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GSliderVer;
/*     */ import view.main.Mouse;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ class ArticleText extends Article {
/*     */   private final CharSequence text;
/*  26 */   private final ArrayListGrower<Special> links = new ArrayListGrower();
/*     */   
/*     */   ArticleText(Json json, KeyMap<Article> amap) {
/*  29 */     super(json.text("NAME"), json.text("CATEGORY"));
/*  30 */     if (json.has("LINK_KEY")) {
/*  31 */       String k = json.value("LINK_KEY");
/*  32 */       if (amap.containsKey(k))
/*  33 */         json.error("this link key already exists", k); 
/*  34 */       amap.put(k, this);
/*     */     } 
/*  36 */     String t = json.text("TEXT");
/*     */     
/*  38 */     StringBuilder bu = new StringBuilder();
/*     */     
/*  40 */     for (int ci = 0; ci < t.length(); ci++) {
/*     */ 
/*     */ 
/*     */       
/*  44 */       if (t.charAt(ci) == '<') {
/*  45 */         int ei = ci;
/*  46 */         ci++;
/*  47 */         String error = "either <a LINK_KEY TEXT> (wiki link), <c RRR_GGG_BBB TEXT> (colored text) or <u TEXT> (underscore)";
/*     */         
/*  49 */         if (ci >= t.length())
/*  50 */         { err(json, t, error, ei);
/*     */           
/*     */            }
/*     */         
/*  54 */         else if (t.charAt(ci) == 'a')
/*  55 */         { error = "Expecting: <a LINK_KEY TEXT> where LINK_KEY is another wiki entry's link, and TEXT is the text for the link.";
/*  56 */           ci = next(t, ci, ' ') + 1;
/*  57 */           if (ci < 0)
/*  58 */           { err(json, t, error, ei); }
/*     */           else
/*     */           
/*  61 */           { int ni = next(t, ci, ' ');
/*  62 */             if (ni < 0)
/*  63 */             { err(json, t, error, ei); }
/*     */             else
/*     */             
/*  66 */             { String key = t.substring(ci, ni);
/*  67 */               ci = ni + 1;
/*  68 */               ni = next(t, ci, '>');
/*  69 */               if (ni < 0)
/*  70 */               { err(json, t, error, ei); }
/*     */               else
/*     */               
/*  73 */               { String content = t.substring(ci, ni);
/*  74 */                 int pos = bu.length();
/*  75 */                 bu.append(content);
/*  76 */                 this.links.add(new LinkButt(pos, bu, content, key));
/*  77 */                 ci = ni; }  }  }  }
/*  78 */         else if (t.charAt(ci) == 'c')
/*  79 */         { error = "Expecting: <c RRR_GGG_BBB TEXT> where RRR_GGG_BBB is a color, and TEXT is the text for the link.";
/*  80 */           ci = next(t, ci, ' ') + 1;
/*  81 */           if (ci < 0) {
/*  82 */             err(json, t, error, ei);
/*     */           } else {
/*     */             
/*  85 */             int ni = next(t, ci, ' ');
/*  86 */             if (ni < 0)
/*  87 */             { err(json, t, error, ei); }
/*     */             else
/*     */             { ColorImp colorImp;
/*  90 */               String key = t.substring(ci, ni);
/*  91 */               COLOR col = COLOR.WHITE100;
/*     */               try {
/*  93 */                 colorImp = (new ColorImp()).set(key, json);
/*  94 */               } catch (Throwable e) {
/*  95 */                 err(json, t, error, ei);
/*  96 */                 e.printStackTrace();
/*     */               } 
/*     */ 
/*     */               
/* 100 */               ci = ni + 1;
/* 101 */               ni = next(t, ci, '>');
/* 102 */               if (ni < 0)
/* 103 */               { err(json, t, error, ei); }
/*     */               else
/*     */               
/* 106 */               { String content = t.substring(ci, ni);
/* 107 */                 int pos = bu.length();
/* 108 */                 bu.append(content);
/* 109 */                 this.links.add(new ColButt(pos, bu, content, (COLOR)colorImp));
/* 110 */                 ci = ni; }  } 
/*     */           }  }
/* 112 */         else { err(json, t, error, ei); }
/*     */ 
/*     */       
/*     */       } else {
/*     */         
/* 117 */         bu.append(t.charAt(ci));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 123 */     this.text = bu.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private int next(String t, int ci, char c) {
/* 128 */     for (; ci < t.length(); ci++) {
/* 129 */       if (t.charAt(ci) == c)
/* 130 */         return ci; 
/*     */     } 
/* 132 */     return -10;
/*     */   }
/*     */   
/*     */   private void err(Json json, String t, String error, int ci) {
/* 136 */     GAME.Warn(json.errorGet("TEXT", "Error in wiki entry. " + error + " Around: '" + t.substring(Math.max(ci - 8, 0), Math.min(ci + 32, t.length() - 1)) + "'"));
/*     */   }
/*     */ 
/*     */   
/*     */   GuiSection makeSection(LIST<Article> all, int width) {
/* 141 */     return new WikiArticle(this, width, all);
/*     */   }
/*     */ 
/*     */   
/*     */   static final class WikiArticle
/*     */     extends GuiSection
/*     */   {
/*     */     private static ArticleText.Special hovered;
/*     */     
/*     */     private int row;
/*     */     private final int max;
/*     */     private final LIST<ArticleText.Special> linkButts;
/*     */     private final ArticleText e;
/*     */     
/*     */     WikiArticle(ArticleText e, int width, LIST<Article> all) {
/* 156 */       this.e = e;
/* 157 */       Font f = (UI.FONT()).M;
/*     */       
/* 159 */       body().setWidth(width);
/*     */       
/* 161 */       int maxRows = ArticleText.HEIGHT / f.height();
/* 162 */       int rows = (UI.FONT()).M.getRowAmount(e.text, width - 32);
/*     */       
/* 164 */       int m = rows - maxRows;
/*     */       
/* 166 */       if (m < 0)
/* 167 */         m = 0; 
/* 168 */       this.max = m;
/*     */ 
/*     */       
/* 171 */       INT.INTE tar = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 175 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 180 */             return ArticleText.WikiArticle.this.max;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 185 */             return ArticleText.WikiArticle.this.row;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 190 */             ArticleText.WikiArticle.this.row = t;
/*     */           }
/*     */         };
/* 193 */       GSliderVer sl = new GSliderVer(tar, ArticleText.HEIGHT);
/* 194 */       add((RENDEROBJ)sl, body().x2() - sl.body().width(), 0);
/*     */       
/* 196 */       body().moveX1Y1(0.0D, 0.0D);
/*     */       
/* 198 */       this.linkButts = (LIST<ArticleText.Special>)e.links;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 205 */       int x = body().x1();
/* 206 */       int y = body().y1();
/* 207 */       Font f = (UI.FONT()).M;
/*     */ 
/*     */       
/* 210 */       f.renderFromRow(this.e.text, x, y, body().width() - 32, this.row, body().height() - 8);
/* 211 */       if (hoveredIs()) {
/* 212 */         double m = MButt.clearWheelSpin();
/* 213 */         if (m < 0.0D) {
/* 214 */           this.row = (int)(this.row + Math.ceil(-m));
/* 215 */         } else if (m > 0.0D) {
/* 216 */           this.row = (int)(this.row - Math.ceil(m));
/*     */         } 
/* 218 */         this.row = CLAMP.i(this.row, 0, this.max);
/*     */       } 
/* 220 */       super.render(r, ds);
/* 221 */       for (ArticleText.Special b : this.linkButts) {
/*     */ 
/*     */         
/* 224 */         COORDINATE c = f.getStartPosition(this.e.text, 0, b.position, b.text.length(), body().width() - 32, 1.0D);
/* 225 */         int offY = c.y();
/* 226 */         int offX = c.x();
/*     */         
/* 228 */         int startI = 0;
/* 229 */         int y1 = y - this.row * f.height() + offY;
/*     */ 
/*     */         
/*     */         do {
/* 233 */           int end = f.getEndIndex(b.text, startI, body().width() - offX - 32);
/* 234 */           if (y1 >= y && y1 + f.height() <= body().y2()) {
/* 235 */             int x1 = x + offX;
/* 236 */             b.render(r, (hovered == b), (CharSequence)Str.TMP.clear().add(b.text, startI, end), x1, y1);
/*     */           } 
/* 238 */           y1 += f.height();
/* 239 */           startI = Math.max(startI, f.getStartIndex(b.text, end));
/* 240 */           offX = 0;
/* 241 */         } while (startI < b.text.length());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 248 */       hovered = null;
/* 249 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 254 */       super.hover(mCoo);
/* 255 */       hovered = null;
/* 256 */       int x = body().x1();
/* 257 */       int y = body().y1();
/* 258 */       Font f = (UI.FONT()).M;
/* 259 */       for (ArticleText.Special b : this.linkButts) {
/*     */ 
/*     */         
/* 262 */         COORDINATE c = f.getStartPosition(this.e.text, 0, b.position, b.text.length(), body().width() - 32, 1.0D);
/* 263 */         int offY = c.y();
/* 264 */         int offX = c.x();
/*     */         
/* 266 */         int startI = 0;
/* 267 */         int y1 = y - this.row * f.height() + offY;
/*     */ 
/*     */         
/*     */         do {
/* 271 */           int end = f.getEndIndex(b.text, startI, body().width() - offX - 32);
/* 272 */           if (y1 >= y && y1 + f.height() <= body().y2()) {
/* 273 */             int x1 = x + offX;
/* 274 */             int x2 = x1 + f.width(b.text, startI, end, 1.0D);
/* 275 */             if (mCoo.x() >= x1 && mCoo.x() <= x2 && 
/* 276 */               mCoo.y() >= y1 && mCoo.y() <= y1 + f.height()) {
/* 277 */               hovered = b;
/* 278 */               return true;
/*     */             } 
/*     */           } 
/* 281 */           y1 += f.height();
/* 282 */           startI = Math.max(startI + 1, f.getStartIndex(b.text, end));
/* 283 */           offX = 0;
/* 284 */         } while (startI < b.text.length());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 290 */       return hoveredIs();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean click() {
/* 295 */       hovered = null;
/* 296 */       int x = body().x1();
/* 297 */       int y = body().y1();
/* 298 */       Font f = (UI.FONT()).M;
/* 299 */       Mouse mouse = VIEW.mouse();
/* 300 */       for (ArticleText.Special b : this.linkButts) {
/*     */         
/* 302 */         COORDINATE c = f.getStartPosition(this.e.text, 0, b.position, b.text.length(), body().width() - 32, 1.0D);
/* 303 */         int offY = c.y();
/* 304 */         int offX = c.x();
/*     */         
/* 306 */         int startI = 0;
/* 307 */         int y1 = y - this.row * f.height() + offY;
/*     */ 
/*     */         
/*     */         do {
/* 311 */           int end = f.getEndIndex(b.text, startI, body().width() - offX - 32);
/* 312 */           if (y1 >= y && y1 + f.height() <= body().y2()) {
/* 313 */             int x1 = x + offX;
/* 314 */             int x2 = x1 + f.width(b.text, startI, end, 1.0D);
/* 315 */             if (mouse.x() >= x1 && mouse.x() <= x2 && 
/* 316 */               mouse.y() >= y1 && mouse.y() <= y1 + f.height()) {
/* 317 */               b.click();
/* 318 */               return true;
/*     */             } 
/*     */           } 
/* 321 */           y1 += f.height();
/* 322 */           startI = Math.max(startI + 1, f.getStartIndex(b.text, end));
/* 323 */           offX = 0;
/* 324 */         } while (startI < b.text.length());
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 331 */       return super.click();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static abstract class Special
/*     */   {
/*     */     public final int position;
/*     */     
/*     */     public final CharSequence text;
/*     */     
/*     */     public abstract void render(SPRITE_RENDERER param1SPRITE_RENDERER, boolean param1Boolean, CharSequence param1CharSequence, int param1Int1, int param1Int2);
/*     */     
/*     */     public abstract void click();
/*     */     
/*     */     Special(int position, CharSequence all, CharSequence text) {
/* 347 */       this.text = text;
/* 348 */       this.position = position;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class LinkButt
/*     */     extends Special
/*     */   {
/*     */     private final String key;
/*     */     
/*     */     LinkButt(int position, CharSequence all, CharSequence text, String key) {
/* 359 */       super(position, all, text);
/* 360 */       this.key = key;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, boolean hovered, CharSequence text, int x1, int y1) {
/* 366 */       Article entry = (Article)WIKI.links.get(this.key);
/*     */       
/* 368 */       if (hovered) {
/* 369 */         COLOR.WHITE100.bind();
/* 370 */       } else if (entry == null) {
/* 371 */         (GCOLOR.T()).IBAD.bind();
/*     */       } else {
/* 373 */         (GCOLOR.T()).IGOOD.bind();
/* 374 */       }  (UI.FONT()).M.render(r, text, x1, y1);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void click() {
/* 380 */       Article entry = (Article)WIKI.links.get(this.key);
/* 381 */       if (entry != null) {
/* 382 */         (VIEW.UI()).wiki.set(entry);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static class ColButt
/*     */     extends Special
/*     */   {
/*     */     private final COLOR col;
/*     */     
/*     */     ColButt(int position, CharSequence all, CharSequence text, COLOR color) {
/* 394 */       super(position, all, text);
/* 395 */       this.col = color;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, boolean hovered, CharSequence text, int x1, int y1) {
/* 401 */       this.col.bind();
/* 402 */       (UI.FONT()).M.render(r, text, x1, y1);
/*     */     }
/*     */     
/*     */     public void click() {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\ArticleText.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */