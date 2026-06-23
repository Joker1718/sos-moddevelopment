/*     */ package launcher;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Cloud
/*     */   extends GUI.LSprite
/*     */ {
/*     */   private static final float ySpeed = -30.0F;
/*     */   private static final float xSpeed = 28.0F;
/*     */   private final float scale;
/*     */   private final Rec shadowBounds;
/*     */   private OpacityImp shadowOp;
/*     */   
/*     */   Cloud(float scale) {
/*  92 */     super(paramBG.sprites[RND.rInt(paramBG.sprites.length)], 0.0F, 0.0F);
/*  93 */     this.scale = scale;
/*  94 */     body().scale(scale, scale);
/*  95 */     this.shadowBounds = new Rec(0.0D, (body().width() * scale), 0.0D, (body().height() * scale));
/*  96 */     this.shadowBounds.moveX1((-paramBG.quadBounds.width() + 2 * RND.rInt(paramBG.quadBounds.width())));
/*  97 */     this.shadowBounds.moveY1(RND.rInt(paramBG.quadBounds.y2()));
/*  98 */     getOpacity().set(RND.rInt(255));
/*  99 */     this.shadowOp = new OpacityImp((int)(Byte.toUnsignedInt(getOpacity().get()) * 0.5D));
/* 100 */     update(0.0F);
/*     */   }
/*     */   
/*     */   boolean update(float ms) {
/* 104 */     this.shadowBounds.incrY((-30.0F * this.scale * ms));
/* 105 */     this.shadowBounds.incrX((28.0F * this.scale * ms));
/* 106 */     body().moveX1(this.shadowBounds.x1());
/* 107 */     body().moveY1(this.shadowBounds.y1());
/* 108 */     return this.shadowBounds.touches((RECTANGLE)BG.this.quadBounds);
/*     */   }
/*     */   
/*     */   void reIni() {
/* 112 */     this.shadowBounds.moveX1((-BG.this.quadBounds.width() + 2 * RND.rInt(BG.this.quadBounds.width())));
/*     */     
/* 114 */     this.shadowBounds.moveY1(BG.this.quadBounds.y2());
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderShadow(SPRITE_RENDERER r, float ds) {
/* 119 */     this.shadowOp.bind();
/* 120 */     COLOR.BLACK.bind();
/* 121 */     this.sprite.render(r, this.shadowBounds.x1(), this.shadowBounds.x2(), this.shadowBounds.y1(), this.shadowBounds.y2());
/* 122 */     OPACITY.unbind();
/* 123 */     COLOR.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\BG$Cloud.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */