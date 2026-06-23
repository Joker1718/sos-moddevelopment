/*     */ package view.ui.family;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import view.keyboard.KEYS;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Window
/*     */ {
/* 182 */   public final Rec view = new Rec(C.WIDTH(), C.HEIGHT());
/* 183 */   public int scale = 1;
/*     */   private boolean dragging = false;
/* 185 */   private Coo clickedCoo = new Coo();
/* 186 */   private final Rec max = new Rec();
/* 187 */   private final COLOR bg = (COLOR)new ColorImp(35, 74, 80);
/*     */ 
/*     */ 
/*     */   
/*     */   void init(int ref, UIFamilyTreeRefs refs, UIFamilyTreeAligner poss) {
/* 192 */     for (int i = 0; i < refs.max(); i++) {
/* 193 */       double cx = poss.x2(i) * this.scale * 62.0D + (this.scale * 50 / 2);
/* 194 */       double cy = poss.level(i) * this.scale * 106.0D + (this.scale * 74 / 2);
/* 195 */       if (i == 0) {
/* 196 */         this.max.moveX1Y1(cx, cy);
/* 197 */         this.max.setDim(0.0D);
/*     */       } 
/* 199 */       this.max.unify((int)cx, (int)cy);
/* 200 */       if (ref == refs.get(i))
/*     */       {
/* 202 */         this.view.moveC(cx, cy);
/*     */       }
/*     */     } 
/*     */     
/* 206 */     this.max.incrX((-C.WIDTH() + 50));
/* 207 */     this.max.incrW((C.WIDTH() * 2 - 100));
/* 208 */     this.max.incrY((-C.HEIGHT() + 50));
/* 209 */     this.max.incrH((C.HEIGHT() * 2 - 100));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/* 215 */     this.dragging &= MButt.LEFT.isDown();
/*     */     
/* 217 */     double acc = 2000.0D;
/*     */     
/* 219 */     if ((KEYS.MAIN()).SCROLL_LEFT.isPressed()) {
/* 220 */       this.view.incrX(-acc * ds);
/* 221 */     } else if ((KEYS.MAIN()).SCROLL_RIGHT.isPressed()) {
/* 222 */       this.view.incrX(acc * ds);
/*     */     } 
/* 224 */     if ((KEYS.MAIN()).SCROLL_UP.isPressed()) {
/* 225 */       this.view.incrY(-acc * ds);
/* 226 */     } else if ((KEYS.MAIN()).SCROLL_DOWN.isPressed()) {
/* 227 */       this.view.incrY(acc * ds);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 232 */     if (this.dragging) {
/* 233 */       int dx = this.clickedCoo.x() - VIEW.mouse().x();
/* 234 */       int dy = this.clickedCoo.y() - VIEW.mouse().y();
/* 235 */       this.view.incr(dx, dy);
/* 236 */       this.clickedCoo.set((COORDINATE)VIEW.mouse());
/*     */     } 
/*     */ 
/*     */     
/* 240 */     if (this.view.x1() < this.max.x1()) {
/* 241 */       this.view.moveX1(this.max.x1());
/* 242 */     } else if (this.view.x2() > this.max.x2()) {
/* 243 */       this.view.moveX2(this.max.x2());
/*     */     } 
/* 245 */     if (this.view.y1() < this.max.y1()) {
/* 246 */       this.view.moveY1(this.max.y1());
/* 247 */     } else if (this.view.y2() > this.max.y2()) {
/* 248 */       this.view.moveY2(this.max.y2());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   int sx(double x) {
/* 254 */     return (int)(x * this.scale * 62.0D - this.view.x1());
/*     */   }
/*     */   
/*     */   int sy(double x) {
/* 258 */     return (int)(x * this.scale * 106.0D - this.view.y1());
/*     */   }
/*     */   
/*     */   int cx(double x) {
/* 262 */     return (int)(x * this.scale * 62.0D - this.view.x1() + (this.scale * 50 / 2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void renderBG() {
/* 269 */     int dim = 64;
/*     */     
/* 271 */     OPACITY.O25.bind();
/* 272 */     this.bg.bind();
/*     */     
/* 274 */     for (int sy = 0; sy < C.HEIGHT(); sy += dim) {
/* 275 */       for (int sx = 0; sx < C.WIDTH(); sx += dim) {
/*     */         
/* 277 */         double tx = ((sx + this.view.x1()) / 4);
/* 278 */         double ty = ((sy + this.view.y1()) / 4);
/* 279 */         CORE.renderer().renderSprite(sx, sx + dim, sy, sy + dim, (SPRITES.textures()).dis_big.get(tx, ty));
/* 280 */         tx = ((sx + this.view.x1() + 128) / 4);
/* 281 */         ty = ((sy + this.view.y1() + 128) / 4);
/* 282 */         CORE.renderer().renderSprite(sx, sx + dim, sy, sy + dim, (SPRITES.textures()).dis_low.get(tx, ty));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 287 */     OPACITY.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\family\UIFamilyTreeDrawer$Window.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */