/*     */ package view.main;
/*     */ 
/*     */ import init.constant.C;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ public class IMouseMessage {
/*  11 */   private final GBox timed = new GBox();
/*  12 */   private final GBox normal = new GBox();
/*  13 */   private double timer = 0.0D;
/*  14 */   private final Coo clickCoo = new Coo();
/*  15 */   private int distance = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean above;
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(Renderer r, float ds) {
/*  24 */     GBox box = this.timed;
/*     */     
/*  26 */     if (this.timer < 0.0D) {
/*  27 */       this.timed.clear();
/*  28 */       box = this.normal;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  33 */     this.timer -= ds;
/*     */     
/*  35 */     if (!box.emptyIs()) {
/*  36 */       COORDINATE mCoo = VIEW.mouse();
/*     */       
/*  38 */       int M = 48 + this.distance;
/*     */       
/*  40 */       int y1 = mCoo.y() + M;
/*  41 */       if (this.above || mCoo.y() + M + box.height() > C.HEIGHT()) {
/*  42 */         y1 = mCoo.y() - M - box.height();
/*     */       }
/*     */       
/*  45 */       int x1 = mCoo.x() - box.width() / 2;
/*  46 */       if (x1 < M) {
/*  47 */         x1 = M;
/*  48 */       } else if (x1 + box.width() + M > C.WIDTH()) {
/*  49 */         x1 = C.WIDTH() - box.width() - M;
/*     */       } 
/*     */       
/*  52 */       if (y1 < M) {
/*  53 */         y1 = M;
/*  54 */         x1 = (mCoo.x() <= C.DIM().cX()) ? (mCoo.x() + M) : (mCoo.x() - M - box.width());
/*  55 */       } else if (y1 + box.height() > C.DIM().height()) {
/*  56 */         y1 = C.DIM().height() - box.height() - M;
/*  57 */         x1 = (mCoo.x() <= C.DIM().cX()) ? (mCoo.x() + M) : (mCoo.x() - M - box.width());
/*     */       } 
/*     */       
/*  60 */       box.render((SPRITE_RENDERER)r, x1, y1);
/*     */     } 
/*     */     
/*  63 */     this.normal.clear();
/*  64 */     this.distance = 0;
/*  65 */     this.above = false;
/*     */   }
/*     */   
/*     */   public void setAbove() {
/*  69 */     this.above = true;
/*     */   }
/*     */   
/*     */   GBox init(COORDINATE mCoo, boolean time) {
/*  73 */     this.clickCoo.set(mCoo);
/*  74 */     if (time) {
/*  75 */       this.timed.clear();
/*  76 */       this.timer = 5.0D;
/*  77 */       return this.timed;
/*     */     } 
/*  79 */     return this.normal;
/*     */   }
/*     */   
/*     */   public GBox get() {
/*  83 */     if (this.timer > 0.0D)
/*  84 */       return this.timed; 
/*  85 */     return this.normal;
/*     */   }
/*     */   
/*     */   void update(COORDINATE mCoo) {
/*  89 */     if (mCoo.tileDistanceTo((COORDINATE)this.clickCoo) > 50.0D) {
/*  90 */       this.timer = -1.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   boolean isOn() {
/*  95 */     return (this.timer >= 0.0D && !this.timed.emptyIs());
/*     */   }
/*     */   
/*     */   boolean close() {
/*  99 */     if (this.timer > 0.0D) {
/* 100 */       this.timer = 0.0D;
/* 101 */       return true;
/*     */     } 
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public void setDistance(int max) {
/* 107 */     this.distance = max;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\main\IMouseMessage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */