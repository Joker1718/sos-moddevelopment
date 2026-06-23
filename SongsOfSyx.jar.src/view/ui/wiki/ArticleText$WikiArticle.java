/*     */ package view.ui.wiki;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GSliderVer;
/*     */ import view.main.Mouse;
/*     */ import view.main.VIEW;
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
/*     */ final class WikiArticle
/*     */   extends GuiSection
/*     */ {
/*     */   private static ArticleText.Special hovered;
/*     */   private int row;
/*     */   private final int max;
/*     */   private final LIST<ArticleText.Special> linkButts;
/*     */   private final ArticleText e;
/*     */   
/*     */   WikiArticle(ArticleText e, int width, LIST<Article> all) {
/* 156 */     this.e = e;
/* 157 */     Font f = (UI.FONT()).M;
/*     */     
/* 159 */     body().setWidth(width);
/*     */     
/* 161 */     int maxRows = ArticleText.HEIGHT / f.height();
/* 162 */     int rows = (UI.FONT()).M.getRowAmount(e.text, width - 32);
/*     */     
/* 164 */     int m = rows - maxRows;
/*     */     
/* 166 */     if (m < 0)
/* 167 */       m = 0; 
/* 168 */     this.max = m;
/*     */ 
/*     */     
/* 171 */     INT.INTE tar = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 175 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 180 */           return ArticleText.WikiArticle.this.max;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 185 */           return ArticleText.WikiArticle.this.row;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 190 */           ArticleText.WikiArticle.this.row = t;
/*     */         }
/*     */       };
/* 193 */     GSliderVer sl = new GSliderVer(tar, ArticleText.HEIGHT);
/* 194 */     add((RENDEROBJ)sl, body().x2() - sl.body().width(), 0);
/*     */     
/* 196 */     body().moveX1Y1(0.0D, 0.0D);
/*     */     
/* 198 */     this.linkButts = (LIST<ArticleText.Special>)e.links;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 205 */     int x = body().x1();
/* 206 */     int y = body().y1();
/* 207 */     Font f = (UI.FONT()).M;
/*     */ 
/*     */     
/* 210 */     f.renderFromRow(this.e.text, x, y, body().width() - 32, this.row, body().height() - 8);
/* 211 */     if (hoveredIs()) {
/* 212 */       double m = MButt.clearWheelSpin();
/* 213 */       if (m < 0.0D) {
/* 214 */         this.row = (int)(this.row + Math.ceil(-m));
/* 215 */       } else if (m > 0.0D) {
/* 216 */         this.row = (int)(this.row - Math.ceil(m));
/*     */       } 
/* 218 */       this.row = CLAMP.i(this.row, 0, this.max);
/*     */     } 
/* 220 */     super.render(r, ds);
/* 221 */     for (ArticleText.Special b : this.linkButts) {
/*     */ 
/*     */       
/* 224 */       COORDINATE c = f.getStartPosition(this.e.text, 0, b.position, b.text.length(), body().width() - 32, 1.0D);
/* 225 */       int offY = c.y();
/* 226 */       int offX = c.x();
/*     */       
/* 228 */       int startI = 0;
/* 229 */       int y1 = y - this.row * f.height() + offY;
/*     */ 
/*     */       
/*     */       do {
/* 233 */         int end = f.getEndIndex(b.text, startI, body().width() - offX - 32);
/* 234 */         if (y1 >= y && y1 + f.height() <= body().y2()) {
/* 235 */           int x1 = x + offX;
/* 236 */           b.render(r, (hovered == b), (CharSequence)Str.TMP.clear().add(b.text, startI, end), x1, y1);
/*     */         } 
/* 238 */         y1 += f.height();
/* 239 */         startI = Math.max(startI, f.getStartIndex(b.text, end));
/* 240 */         offX = 0;
/* 241 */       } while (startI < b.text.length());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 248 */     hovered = null;
/* 249 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 254 */     super.hover(mCoo);
/* 255 */     hovered = null;
/* 256 */     int x = body().x1();
/* 257 */     int y = body().y1();
/* 258 */     Font f = (UI.FONT()).M;
/* 259 */     for (ArticleText.Special b : this.linkButts) {
/*     */ 
/*     */       
/* 262 */       COORDINATE c = f.getStartPosition(this.e.text, 0, b.position, b.text.length(), body().width() - 32, 1.0D);
/* 263 */       int offY = c.y();
/* 264 */       int offX = c.x();
/*     */       
/* 266 */       int startI = 0;
/* 267 */       int y1 = y - this.row * f.height() + offY;
/*     */ 
/*     */       
/*     */       do {
/* 271 */         int end = f.getEndIndex(b.text, startI, body().width() - offX - 32);
/* 272 */         if (y1 >= y && y1 + f.height() <= body().y2()) {
/* 273 */           int x1 = x + offX;
/* 274 */           int x2 = x1 + f.width(b.text, startI, end, 1.0D);
/* 275 */           if (mCoo.x() >= x1 && mCoo.x() <= x2 && 
/* 276 */             mCoo.y() >= y1 && mCoo.y() <= y1 + f.height()) {
/* 277 */             hovered = b;
/* 278 */             return true;
/*     */           } 
/*     */         } 
/* 281 */         y1 += f.height();
/* 282 */         startI = Math.max(startI + 1, f.getStartIndex(b.text, end));
/* 283 */         offX = 0;
/* 284 */       } while (startI < b.text.length());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 290 */     return hoveredIs();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean click() {
/* 295 */     hovered = null;
/* 296 */     int x = body().x1();
/* 297 */     int y = body().y1();
/* 298 */     Font f = (UI.FONT()).M;
/* 299 */     Mouse mouse = VIEW.mouse();
/* 300 */     for (ArticleText.Special b : this.linkButts) {
/*     */       
/* 302 */       COORDINATE c = f.getStartPosition(this.e.text, 0, b.position, b.text.length(), body().width() - 32, 1.0D);
/* 303 */       int offY = c.y();
/* 304 */       int offX = c.x();
/*     */       
/* 306 */       int startI = 0;
/* 307 */       int y1 = y - this.row * f.height() + offY;
/*     */ 
/*     */       
/*     */       do {
/* 311 */         int end = f.getEndIndex(b.text, startI, body().width() - offX - 32);
/* 312 */         if (y1 >= y && y1 + f.height() <= body().y2()) {
/* 313 */           int x1 = x + offX;
/* 314 */           int x2 = x1 + f.width(b.text, startI, end, 1.0D);
/* 315 */           if (mouse.x() >= x1 && mouse.x() <= x2 && 
/* 316 */             mouse.y() >= y1 && mouse.y() <= y1 + f.height()) {
/* 317 */             b.click();
/* 318 */             return true;
/*     */           } 
/*     */         } 
/* 321 */         y1 += f.height();
/* 322 */         startI = Math.max(startI + 1, f.getStartIndex(b.text, end));
/* 323 */         offX = 0;
/* 324 */       } while (startI < b.text.length());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 331 */     return super.click();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\wiki\ArticleText$WikiArticle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */