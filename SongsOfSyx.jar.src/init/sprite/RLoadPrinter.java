/*     */ package init.sprite;
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.paths.PATHS;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.CORE;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.light.Fire;
/*     */ import snake2d.util.light.LIGHT_POINT;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.misc.GTextR;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class RLoadPrinter {
/*  29 */   private final GuiSection section = new GuiSection();
/*  30 */   private final RENDEROBJ.Sprite bg = new RENDEROBJ.Sprite();
/*  31 */   private final GTextR info = new GTextR((UI.FONT()).S, 200);
/*     */   
/*  33 */   private final Quote quote = new Quote();
/*     */   
/*  35 */   private final Fire torch1 = new Fire(5.0D);
/*  36 */   private final Fire torch2 = new Fire(4.0D);
/*     */   
/*  38 */   private final AmbientLight light = new AmbientLight();
/*  39 */   private long lastInit = 0L;
/*     */   
/*     */   private boolean minified = false;
/*     */   
/*  43 */   private final GText miniThing = new GText((UI.FONT()).H1, 24);
/*  44 */   private final Str regularThing = new Str(24);
/*     */   private CharSequence miniText;
/*     */   private int miniI;
/*     */   private int regularI;
/*     */   private final int miniD;
/*  49 */   private final RENDEROBJ loadingBig = UI.decor().getDecored(Dic.¤¤loading);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ShadowBatch.Real shadow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void minify(boolean minify, CharSequence title) {
/*  99 */     this.minified = minify;
/* 100 */     this.miniText = title;
/* 101 */     this.miniI = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void print(CharSequence string) {
/* 106 */     if (this.minified) {
/*     */       
/* 108 */       CORE.renderer().clear();
/* 109 */       TIME.light().applyGuiLight(0.0F, C.DIM());
/*     */       
/* 111 */       this.miniThing.set(this.miniText);
/* 112 */       int wi = this.miniThing.width();
/* 113 */       for (int j = 0; j < this.miniI / 4 % 4; j++) {
/* 114 */         this.miniThing.add('.');
/*     */       }
/* 116 */       this.miniI++;
/* 117 */       int x1 = C.DIM().cX() - wi / 2;
/*     */       
/* 119 */       (UI.PANEL()).titleBoxes[(UI.PANEL()).titleBoxes.length - 1].renderCY((SPRITE_RENDERER)CORE.renderer(), x1, C.DIM().cY(), wi + this.miniD);
/* 120 */       this.miniThing.renderCY((SPRITE_RENDERER)CORE.renderer(), x1, C.DIM().cY());
/*     */       
/* 122 */       CORE.renderer().newLayer(false, 0);
/* 123 */       VIEW.render();
/* 124 */       CORE.swapAndPoll();
/*     */       
/*     */       return;
/*     */     } 
/* 128 */     this.regularThing.clear().add(string);
/* 129 */     for (int i = 0; i < this.regularI / 4 % 4; i++) {
/* 130 */       this.regularThing.add('.');
/*     */     }
/* 132 */     this.regularI++;
/*     */     
/* 134 */     render((CharSequence)this.regularThing, false);
/*     */     
/* 136 */     CORE.swapAndPoll();
/*     */   }
/*     */ 
/*     */   
/*     */   public void printempty() {
/* 141 */     CORE.renderer().clear();
/* 142 */     CORE.renderer().shadeLight(true);
/* 143 */     CORE.renderer().shadowDepthSet((byte)0);
/* 144 */     this.shadow.init(1, 0.5D, 0.5D);
/* 145 */     this.shadow.setDistance2Ground(2.0D).setHeight(24);
/* 146 */     this.light.register(C.DIM());
/*     */     
/* 148 */     this.loadingBig.body().centerIn(C.DIM());
/* 149 */     this.loadingBig.render((SPRITE_RENDERER)this.shadow, (float)this.lastInit);
/* 150 */     this.loadingBig.render((SPRITE_RENDERER)CORE.renderer(), (float)this.lastInit);
/*     */     
/* 152 */     CORE.renderer().newLayer(false, 0);
/* 153 */     byte none = 0;
/* 154 */     byte full = -1;
/* 155 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch1, this.bg.body().x1(), this.bg.body().x1() + 100, this.bg.body().y1(), this.bg.body().y2(), full, full, none, none);
/* 156 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch1, this.bg.body().x1() + 100, this.bg.body().x2(), this.bg.body().y1(), this.bg.body().y2(), full, full, full, full);
/*     */     
/* 158 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch2, this.bg.body().x2() - 100, this.bg.body().x2(), this.bg.body().y1(), this.bg.body().y2(), none, none, full, full);
/* 159 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch2, this.bg.body().x1(), this.bg.body().x2() - 100, this.bg.body().y1(), this.bg.body().y2(), full, full, full, full);
/*     */     
/* 161 */     this.bg.render((SPRITE_RENDERER)CORE.renderer(), 0.0F);
/*     */     
/* 163 */     OPACITY.O50.bind();
/* 164 */     COLOR.BLACK.render((SPRITE_RENDERER)CORE.renderer(), (RECTANGLE)this.quote.body(), 16);
/* 165 */     OPACITY.unbind();
/* 166 */     CORE.swapAndPoll();
/*     */   }
/*     */   
/* 169 */   RLoadPrinter() { this.shadow = new ShadowBatch.Real();
/*     */     
/* 171 */     this.shadow.setDistance2GroundUI(12.0D); this.section.add(UI.decor().frame((RECTANGLE)this.quote.body())); RENDEROBJ r = UI.decor().getDecored("SONGS OF SYX"); r.body().centerX((BODY_HOLDER)this.section); r.body().moveY2(this.section.body().y1()); this.section.add(r); this.section.add((RENDEROBJ)this.quote); this.section.body().centerIn(C.DIM()); this.bg.setSprite(SPRITES.loadScreen()); this.bg.body().centerIn(C.DIM()); this.torch1.setRadius(1000); this.torch1.set((this.bg.body().x1() - 100), (C.HEIGHT() / 2)); this.torch1.setFalloff(3.0F); this.torch1.setFlickerFactor(25.0F); this.torch1.setZ(25); this.torch2.setFalloff(3.0F); this.torch2.setRadius(500); this.torch2.set((this.bg.body().x2() + 100), (C.HEIGHT() / 2)); this.torch2.setFlickerFactor(10.0F); this.torch2.setZ(25); this.torch1.flicker(1.0F); this.torch2.flicker(1.0F); this.light.setDir(220.0D); this.light.setTilt(25.0D); this.light.g(1.2999999523162842D); this.light.b(1.2999999523162842D); this.light.r(1.2999999523162842D);
/*     */     init();
/*     */     this.miniThing.lablify();
/*     */     this.miniThing.add('.').add('.').add('.');
/* 175 */     this.miniD = this.miniThing.adjustWidth().width(); } public void render(CharSequence string, boolean flash) { if (string == null) {
/*     */       return;
/*     */     }
/*     */     
/* 179 */     CORE.renderer().clear();
/* 180 */     CORE.renderer().shadeLight(true);
/* 181 */     CORE.renderer().shadowDepthSet((byte)0);
/* 182 */     this.shadow.init(1, 0.5D, 0.5D);
/* 183 */     this.shadow.setDistance2Ground(2.0D).setHeight(24);
/* 184 */     this.light.register(C.DIM());
/*     */     
/* 186 */     this.info.text().clear().set(string);
/* 187 */     this.info.body().centerX(C.DIM());
/* 188 */     this.info.body().moveY1((this.section.body().y2() + 50));
/*     */     
/* 190 */     if (flash) {
/* 191 */       this.info.text().color(COLOR.WHITE2WHITE);
/*     */     } else {
/* 193 */       this.info.text().normalify();
/* 194 */     }  this.info.render((SPRITE_RENDERER)CORE.renderer(), 0.0F);
/* 195 */     this.info.render((SPRITE_RENDERER)this.shadow, 0.0F);
/*     */     
/* 197 */     this.shadow.setDistance2Ground(2.0D).setHeight(24);
/* 198 */     this.section.render((SPRITE_RENDERER)CORE.renderer(), 0.0F);
/* 199 */     this.section.render((SPRITE_RENDERER)this.shadow, 0.0F);
/*     */     
/* 201 */     CORE.renderer().newLayer(false, 0);
/* 202 */     byte none = 0;
/* 203 */     byte full = -1;
/* 204 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch1, this.bg.body().x1(), this.bg.body().x1() + 100, this.bg.body().y1(), this.bg.body().y2(), full, full, none, none);
/* 205 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch1, this.bg.body().x1() + 100, this.bg.body().x2(), this.bg.body().y1(), this.bg.body().y2(), full, full, full, full);
/*     */     
/* 207 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch2, this.bg.body().x2() - 100, this.bg.body().x2(), this.bg.body().y1(), this.bg.body().y2(), none, none, full, full);
/* 208 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch2, this.bg.body().x1(), this.bg.body().x2() - 100, this.bg.body().y1(), this.bg.body().y2(), full, full, full, full);
/*     */     
/* 210 */     this.bg.render((SPRITE_RENDERER)CORE.renderer(), 0.0F);
/*     */     
/* 212 */     OPACITY.O50.bind();
/* 213 */     COLOR.BLACK.render((SPRITE_RENDERER)CORE.renderer(), (RECTANGLE)this.quote.body(), 16);
/* 214 */     OPACITY.unbind(); }
/*     */ 
/*     */ 
/*     */   
/*     */   public void init() {
/* 219 */     if (System.currentTimeMillis() - this.lastInit < 10000L)
/*     */       return; 
/* 221 */     this.lastInit = System.currentTimeMillis();
/* 222 */     this.quote.set();
/* 223 */     this.bg.body().centerIn(C.DIM());
/*     */   }
/*     */   
/*     */   private final class Quote
/*     */     extends RENDEROBJ.RenderImp {
/* 228 */     private final Text quote = new Text((UI.FONT()).M, 400);
/* 229 */     private final Text author = new Text((UI.FONT()).H2, 400);
/*     */     
/*     */     private final String[] quotes;
/*     */     private final String[] authors;
/*     */     
/*     */     Quote() {
/* 235 */       this.body.setWidth(853.0D);
/* 236 */       this.body.setHeight(180.0D);
/* 237 */       this.quote.setMaxWidth(this.body.width());
/* 238 */       this.author.setMaxWidth(this.body.width());
/* 239 */       Json json = new Json(PATHS.TEXT_MISC().gets("Quotes"));
/* 240 */       String[] qs = json.texts("QUOTES");
/* 241 */       if (qs.length == 0)
/* 242 */         json.error("Insufficient quotes. Need at least one", "QUOTES"); 
/* 243 */       int l = qs.length;
/* 244 */       this.quotes = new String[l];
/* 245 */       this.authors = new String[l];
/* 246 */       for (int i = 0; i < l; i++) {
/* 247 */         String[] q = qs[i].split(":::");
/* 248 */         if (q.length != 2) {
/* 249 */           q = qs[i].split("::");
/*     */         }
/* 251 */         if (q.length != 2) {
/* 252 */           q = qs[i].split("::");
/* 253 */           LOG.ln("unable to parse " + qs[i]);
/*     */           
/* 255 */           this.quotes[i] = "";
/* 256 */           this.authors[i] = "";
/*     */         } else {
/*     */           
/* 259 */           this.quotes[i] = q[0];
/*     */           
/* 261 */           this.authors[i] = q[1];
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void set() {
/* 270 */       int i = RND.rInt(this.quotes.length);
/* 271 */       this.quote.set(this.quotes[i]);
/* 272 */       this.author.set(this.authors[i]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 279 */       int x1 = this.body.x1() + (body().width() - this.quote.width()) / 2;
/* 280 */       int y1 = this.body.y1() + (this.body.height() - this.quote.height() + this.author.height() + 10) / 2;
/*     */ 
/*     */       
/* 283 */       this.quote.render(r, x1, y1);
/* 284 */       y1 += this.quote.height();
/*     */       
/* 286 */       int dx = body().width() - this.author.width();
/* 287 */       if (dx > 30) {
/* 288 */         dx -= 30;
/*     */       }
/* 290 */       x1 = this.body.x1() + dx;
/*     */       
/* 292 */       (GCOLOR.T()).H2.bind();
/* 293 */       this.author.render(r, x1, y1 + 10);
/* 294 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMini() {
/* 301 */     return this.minified;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\sprite\RLoadPrinter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */