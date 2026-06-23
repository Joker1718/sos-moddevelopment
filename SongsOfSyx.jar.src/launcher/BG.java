/*     */ package launcher;
/*     */ 
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.color.OpacityImp;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BG
/*     */ {
/*     */   private Rec quadBounds;
/*     */   private SPRITE map;
/*     */   private final SPRITE[] sprites;
/*     */   private Cloud[] clouds;
/*     */   private BigCloud[] bigClouds;
/*     */   private float cloudTimer;
/*     */   float s;
/*     */   
/*     */   BG(RES res) {
/*  40 */     this.s = 0.0F; this.map = res.bg; this.quadBounds = new Rec(0.0D, 896.0D, 0.0D, 448.0D); this.sprites = res.clouds; this.clouds = new Cloud[15]; int i; for (i = 0; i < this.clouds.length; i++)
/*     */       this.clouds[i] = new Cloud(RND.rFloat() + 1.0F);  this.bigClouds = new BigCloud[25];
/*     */     for (i = 0; i < this.bigClouds.length; i++)
/*     */       this.bigClouds[i] = new BigCloud(RND.rFloat() * 3.0F + 3.0F); 
/*  44 */     this.cloudTimer = (RND.rInt(50) + 50); } void update(float ms) { this.s += ms; byte b;
/*     */     int i;
/*     */     Cloud[] arrayOfCloud;
/*  47 */     for (i = (arrayOfCloud = this.clouds).length, b = 0; b < i; ) { Cloud cloud = arrayOfCloud[b];
/*  48 */       if (!cloud.update(ms))
/*  49 */         cloud.reIni();  b++; }
/*     */     
/*  51 */     releaseTheClouds(ms);
/*     */     BigCloud[] arrayOfBigCloud;
/*  53 */     for (i = (arrayOfBigCloud = this.bigClouds).length, b = 0; b < i; ) { BigCloud cloud = arrayOfBigCloud[b];
/*  54 */       cloud.update(ms);
/*     */       b++; }
/*     */      }
/*     */ 
/*     */   
/*     */   void render(SPRITE_RENDERER r, float ds) {
/*  60 */     this.map.render(r, (RECTANGLE)this.quadBounds); byte b; int i;
/*     */     Cloud[] arrayOfCloud;
/*  62 */     for (i = (arrayOfCloud = this.clouds).length, b = 0; b < i; ) { Cloud cloud = arrayOfCloud[b];
/*  63 */       cloud.renderShadow(r, ds); b++; }
/*  64 */      for (i = (arrayOfCloud = this.clouds).length, b = 0; b < i; ) { Cloud cloud = arrayOfCloud[b];
/*  65 */       cloud.render(r, ds); b++; }
/*     */      } public void renderClouds(SPRITE_RENDERER r, float ds) { byte b;
/*     */     int i;
/*     */     BigCloud[] arrayOfBigCloud;
/*  69 */     for (i = (arrayOfBigCloud = this.bigClouds).length, b = 0; b < i; ) { BigCloud cloud = arrayOfBigCloud[b];
/*  70 */       cloud.render(r, ds);
/*     */       b++; }
/*     */      }
/*     */    private void releaseTheClouds(float ds) {
/*  74 */     this.cloudTimer -= ds;
/*  75 */     if (this.cloudTimer < 0.0F) {
/*  76 */       this.cloudTimer += (RND.rInt(50) + 50); byte b; int i; BigCloud[] arrayOfBigCloud;
/*  77 */       for (i = (arrayOfBigCloud = this.bigClouds).length, b = 0; b < i; ) { BigCloud c = arrayOfBigCloud[b];
/*  78 */         c.reIni();
/*     */         b++; }
/*     */     
/*     */     } 
/*     */   }
/*     */   
/*     */   class Cloud extends GUI.LSprite {
/*     */     private static final float ySpeed = -30.0F;
/*     */     private static final float xSpeed = 28.0F;
/*     */     private final float scale;
/*     */     private final Rec shadowBounds;
/*     */     private OpacityImp shadowOp;
/*     */     
/*     */     Cloud(float scale) {
/*  92 */       super(BG.this.sprites[RND.rInt(BG.this.sprites.length)], 0.0F, 0.0F);
/*  93 */       this.scale = scale;
/*  94 */       body().scale(scale, scale);
/*  95 */       this.shadowBounds = new Rec(0.0D, (body().width() * scale), 0.0D, (body().height() * scale));
/*  96 */       this.shadowBounds.moveX1((-BG.this.quadBounds.width() + 2 * RND.rInt(BG.this.quadBounds.width())));
/*  97 */       this.shadowBounds.moveY1(RND.rInt(BG.this.quadBounds.y2()));
/*  98 */       getOpacity().set(RND.rInt(255));
/*  99 */       this.shadowOp = new OpacityImp((int)(Byte.toUnsignedInt(getOpacity().get()) * 0.5D));
/* 100 */       update(0.0F);
/*     */     }
/*     */     
/*     */     boolean update(float ms) {
/* 104 */       this.shadowBounds.incrY((-30.0F * this.scale * ms));
/* 105 */       this.shadowBounds.incrX((28.0F * this.scale * ms));
/* 106 */       body().moveX1(this.shadowBounds.x1());
/* 107 */       body().moveY1(this.shadowBounds.y1());
/* 108 */       return this.shadowBounds.touches((RECTANGLE)BG.this.quadBounds);
/*     */     }
/*     */     
/*     */     void reIni() {
/* 112 */       this.shadowBounds.moveX1((-BG.this.quadBounds.width() + 2 * RND.rInt(BG.this.quadBounds.width())));
/*     */       
/* 114 */       this.shadowBounds.moveY1(BG.this.quadBounds.y2());
/*     */     }
/*     */ 
/*     */     
/*     */     private void renderShadow(SPRITE_RENDERER r, float ds) {
/* 119 */       this.shadowOp.bind();
/* 120 */       COLOR.BLACK.bind();
/* 121 */       this.sprite.render(r, this.shadowBounds.x1(), this.shadowBounds.x2(), this.shadowBounds.y1(), this.shadowBounds.y2());
/* 122 */       OPACITY.unbind();
/* 123 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */   
/*     */   class BigCloud
/*     */     extends GUI.LSprite
/*     */   {
/*     */     private static final float ySpeed = -55.0F;
/*     */     private static final float xSpeed = 38.0F;
/*     */     private final float scale;
/*     */     
/*     */     BigCloud(float scale) {
/* 135 */       super(BG.this.sprites[RND.rInt(BG.this.sprites.length)], 0.0F, 0.0F);
/* 136 */       body().scale(scale, scale);
/* 137 */       this.scale = scale;
/* 138 */       reIni();
/*     */     }
/*     */     
/*     */     void update(float ms) {
/* 142 */       body().incrY((-55.0F * this.scale * this.scale * ms));
/* 143 */       body().incrX((38.0F * this.scale * ms));
/*     */     }
/*     */     
/*     */     void reIni() {
/* 147 */       body().moveX1((-BG.this.quadBounds.width() + 2 * RND.rInt(BG.this.quadBounds.width())));
/* 148 */       body().moveY1(BG.this.quadBounds.y2());
/* 149 */       getOpacity().set(RND.rInt(255));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\BG.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */