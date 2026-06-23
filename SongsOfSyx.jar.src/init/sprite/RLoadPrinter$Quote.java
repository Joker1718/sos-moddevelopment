/*     */ package init.sprite;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Quote
/*     */   extends RENDEROBJ.RenderImp
/*     */ {
/* 228 */   private final Text quote = new Text((UI.FONT()).M, 400);
/* 229 */   private final Text author = new Text((UI.FONT()).H2, 400);
/*     */   
/*     */   private final String[] quotes;
/*     */   private final String[] authors;
/*     */   
/*     */   Quote() {
/* 235 */     this.body.setWidth(853.0D);
/* 236 */     this.body.setHeight(180.0D);
/* 237 */     this.quote.setMaxWidth(this.body.width());
/* 238 */     this.author.setMaxWidth(this.body.width());
/* 239 */     Json json = new Json(PATHS.TEXT_MISC().gets("Quotes"));
/* 240 */     String[] qs = json.texts("QUOTES");
/* 241 */     if (qs.length == 0)
/* 242 */       json.error("Insufficient quotes. Need at least one", "QUOTES"); 
/* 243 */     int l = qs.length;
/* 244 */     this.quotes = new String[l];
/* 245 */     this.authors = new String[l];
/* 246 */     for (int i = 0; i < l; i++) {
/* 247 */       String[] q = qs[i].split(":::");
/* 248 */       if (q.length != 2) {
/* 249 */         q = qs[i].split("::");
/*     */       }
/* 251 */       if (q.length != 2) {
/* 252 */         q = qs[i].split("::");
/* 253 */         LOG.ln("unable to parse " + qs[i]);
/*     */         
/* 255 */         this.quotes[i] = "";
/* 256 */         this.authors[i] = "";
/*     */       } else {
/*     */         
/* 259 */         this.quotes[i] = q[0];
/*     */         
/* 261 */         this.authors[i] = q[1];
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void set() {
/* 270 */     int i = RND.rInt(this.quotes.length);
/* 271 */     this.quote.set(this.quotes[i]);
/* 272 */     this.author.set(this.authors[i]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 279 */     int x1 = this.body.x1() + (body().width() - this.quote.width()) / 2;
/* 280 */     int y1 = this.body.y1() + (this.body.height() - this.quote.height() + this.author.height() + 10) / 2;
/*     */ 
/*     */     
/* 283 */     this.quote.render(r, x1, y1);
/* 284 */     y1 += this.quote.height();
/*     */     
/* 286 */     int dx = body().width() - this.author.width();
/* 287 */     if (dx > 30) {
/* 288 */       dx -= 30;
/*     */     }
/* 290 */     x1 = this.body.x1() + dx;
/*     */     
/* 292 */     (GCOLOR.T()).H2.bind();
/* 293 */     this.author.render(r, x1, y1 + 10);
/* 294 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\RLoadPrinter$Quote.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */