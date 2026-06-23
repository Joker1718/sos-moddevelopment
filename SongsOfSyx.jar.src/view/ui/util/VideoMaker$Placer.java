/*     */ package view.ui.util;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Placer
/*     */   extends Interrupter
/*     */ {
/*     */   public final String name;
/* 197 */   private final Rec rec = new Rec();
/* 198 */   private final Rec tmp = new Rec();
/* 199 */   public final INT.IntImp x1 = new INT.IntImp();
/* 200 */   public final INT.IntImp y1 = new INT.IntImp();
/* 201 */   public final INT.IntImp w = new INT.IntImp();
/* 202 */   public final INT.IntImp h = new INT.IntImp();
/*     */   private boolean clicked = false;
/* 204 */   private Coo start = new Coo();
/*     */   
/*     */   public Placer(String name) {
/* 207 */     this.name = name;
/*     */   }
/*     */   
/*     */   void set() {
/* 211 */     this.clicked = false;
/* 212 */     (VIEW.inters()).manager.add(this);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 222 */     if (button == MButt.LEFT && !this.clicked) {
/* 223 */       this.clicked = true;
/* 224 */       this.start.set(VideoMaker.this.current.window().pixel().x(), VideoMaker.this.current.window().pixel().y());
/*     */     } else {
/*     */       
/* 227 */       hide();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 239 */     if (!this.clicked) {
/* 240 */       return true;
/*     */     }
/* 242 */     GameWindow w = VideoMaker.this.current.window();
/*     */ 
/*     */     
/* 245 */     int x1 = this.rec.x1();
/* 246 */     int y1 = this.rec.y1();
/*     */     
/* 248 */     x1 -= w.pixels().x1();
/* 249 */     y1 -= w.pixels().y1();
/*     */     
/* 251 */     x1 >>= w.zoomout();
/* 252 */     y1 >>= w.zoomout();
/*     */     
/* 254 */     x1 += w.viewWindow().x1();
/* 255 */     y1 += w.viewWindow().y1();
/*     */     
/* 257 */     this.tmp.moveX1Y1(x1, y1);
/* 258 */     this.tmp.setDim((this.rec.width() >> w.zoomout()), (this.rec.height() >> w.zoomout()));
/*     */     
/* 260 */     COLOR.GREEN100.renderFrame((SPRITE_RENDERER)r, (RECTANGLE)this.tmp, 0, 3);
/*     */     
/* 262 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 267 */     if (this.clicked) {
/* 268 */       this.rec.setDim(1.0D);
/* 269 */       this.rec.moveX1Y1((COORDINATE)this.start);
/* 270 */       this.rec.unify(VideoMaker.this.current.window().pixel().x(), VideoMaker.this.current.window().pixel().y());
/*     */       
/* 272 */       int cs = this.rec.cX();
/* 273 */       int cy = this.rec.cY();
/*     */       
/* 275 */       double d = (CORE.getGraphics()).nativeHeight / (CORE.getGraphics()).nativeWidth;
/* 276 */       this.rec.setHeight(this.rec.width() * d);
/*     */       
/* 278 */       this.rec.moveC(cs, cy);
/*     */       
/* 280 */       if (!MButt.LEFT.isDown()) {
/* 281 */         this.clicked = false;
/*     */         
/* 283 */         this.x1.set(this.rec.x1());
/* 284 */         this.y1.set(this.rec.y1());
/* 285 */         this.w.set(this.rec.width());
/* 286 */         this.h.set(this.rec.height());
/*     */ 
/*     */         
/* 289 */         hide();
/* 290 */         (VIEW.inters()).popup.show((RENDEROBJ)VideoMaker.this.s, null);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 298 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\u\\util\VideoMaker$Placer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */