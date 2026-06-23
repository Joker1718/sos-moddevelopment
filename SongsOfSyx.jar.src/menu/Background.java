/*     */ package menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.light.AmbientLight;
/*     */ import snake2d.util.light.Fire;
/*     */ import snake2d.util.light.LIGHT_POINT;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ 
/*     */ final class Background {
/*  18 */   private float speed = 24.0F;
/*     */   
/*     */   private final int tilesX;
/*     */   private final int maxWidth;
/*     */   private final RECTANGLE bounds;
/*     */   private final Rec bgBounds;
/*     */   private final Rec fameBounds;
/*  25 */   Fire torch1 = new Fire(7.0D);
/*  26 */   Fire torch2 = new Fire(7.0D);
/*  27 */   Fire torch3 = new Fire(0.2D);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TILE_SHEET tiles;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final TILE_SHEET tilescr;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static RECTANGLE shadow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final AmbientLight s;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final AmbientLight moon;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Background(Menu menu, RECTANGLE bounds2) {
/*  69 */     this.s = new AmbientLight(0.1D, 0.05D, 0.025D, 90.0F, 20.0F);
/*  70 */     this.moon = new AmbientLight(0.1615D, 0.1615D, 0.23D, 90.0F, 35.0F); this.tiles = (menu.res.s()).background; this.tilesX = (menu.res.s()).backgroundTilesX; this.tilescr = (menu.res.s()).backgroundCr; this.maxWidth = this.tilesX * 32 * 2; this.bounds = (RECTANGLE)new Rec(0.0D, C.WIDTH(), ((C.HEIGHT() - 768) / 2), ((C.HEIGHT() - 768) / 2 + 768)); this.bgBounds = new Rec(0.0D, this.bounds.width(), 0.0D, this.bounds.height()); this.bgBounds.moveX1(RND.rInt(this.maxWidth - this.bounds.width())); this.fameBounds = new Rec(0.0D, this.bounds.width(), 0.0D, (this.bounds.height() - 1)); this.fameBounds.moveX2(this.maxWidth); this.bgBounds.moveX1(0.0D); this.torch1.flicker(1.0F); this.torch2.flicker(1.0F); double d = (this.bounds.width() / 1280); this.torch1.setRadius((int)(1300.0D * d)); this.torch1.set((this.bounds.x1() - 150), (C.HEIGHT() / 2)); this.torch1.setFalloff(2.0F); this.torch1.setFlickerFactor(20.0F); this.torch1.setZ(50); this.torch2.setFalloff(3.0F); this.torch2.setRadius((int)(1300.0D * d)); this.torch2.set((this.bounds.x2() + 150), (C.HEIGHT() / 2)); this.torch2.setFlickerFactor(20.0F); this.torch2.setZ(50); this.torch3.setFalloff(3.0F);
/*     */     this.torch3.setRadius((int)(300.0D * this.bounds.width() / 1280.0D));
/*     */     this.torch3.setFlickerFactor(11.0F);
/*  73 */     this.torch3.setZ(60); } public void render(SPRITE_RENDERER r, float ds) { this.torch1.flicker(ds);
/*  74 */     this.torch2.flicker(ds);
/*     */     
/*  76 */     byte full = -1;
/*  77 */     byte none = 0;
/*  78 */     int fadeW = 100;
/*  79 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch1, this.bounds.x1(), this.bounds.x1() + fadeW, this.bounds.y1(), this.bounds.y2(), full, full, none, none);
/*  80 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch1, this.bounds.x1() + fadeW, this.bounds.x2(), this.bounds.y1(), this.bounds.y2(), full, full, full, full);
/*     */     
/*  82 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch2, this.bounds.x2() - fadeW, this.bounds.x2(), this.bounds.y1(), this.bounds.y2(), none, none, full, full);
/*  83 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch2, this.bounds.x1(), this.bounds.x2() - fadeW, this.bounds.y1(), this.bounds.y2(), full, full, full, full);
/*     */     
/*  85 */     this.bgBounds.incrX((this.speed * ds));
/*  86 */     if (this.bgBounds.x2() >= this.maxWidth && this.speed > 0.0F) {
/*  87 */       this.bgBounds.moveX2(this.bgBounds.x2());
/*  88 */       if (this.speed > 0.0F)
/*  89 */         this.speed *= -1.0F; 
/*  90 */     } else if (this.bgBounds.x1() <= 0 && this.speed < 0.0F) {
/*  91 */       this.bgBounds.moveX1(-this.bgBounds.x1());
/*  92 */       if (this.speed < 0.0F)
/*  93 */         this.speed *= -1.0F; 
/*     */     } 
/*  95 */     this.s.setDir(180.0D);
/*  96 */     this.s.set(this.torch1.getRed() * 0.05D, this.torch1.getGreen() * 0.05D, this.torch1.getBlue() * 0.05D);
/*     */     
/*  98 */     this.moon.register(this.bounds);
/*     */ 
/*     */     
/* 101 */     render(r, this.bounds.x1(), this.bounds.y1(), (RECTANGLE)this.bgBounds, this.tiles, this.tilesX);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 107 */     if (shadow != null) {
/* 108 */       OPACITY.O50.bind();
/* 109 */       COLOR.BLACK.render(r, shadow);
/* 110 */       shadow = null;
/* 111 */       OPACITY.unbind();
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderFame(SPRITE_RENDERER r, float ds, COORDINATE mCoo, double ran) {
/* 117 */     this.torch1.flicker(ds);
/* 118 */     this.torch2.flicker(ds);
/* 119 */     byte full = -1;
/* 120 */     byte none = 0;
/* 121 */     int fadeW = 100;
/* 122 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch1, this.bounds.x1(), this.bounds.x1() + fadeW, this.bounds.y1(), this.bounds.y2(), full, full, none, none);
/* 123 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch1, this.bounds.x1() + fadeW, this.bounds.x2(), this.bounds.y1(), this.bounds.y2(), full, full, full, full);
/*     */     
/* 125 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch2, this.bounds.x2() - fadeW, this.bounds.x2(), this.bounds.y1(), this.bounds.y2(), none, none, full, full);
/* 126 */     CORE.renderer().registerLight((LIGHT_POINT)this.torch2, this.bounds.x1(), this.bounds.x2() - fadeW, this.bounds.y1(), this.bounds.y2(), full, full, full, full);
/*     */     
/* 128 */     this.torch3.set(mCoo);
/* 129 */     this.torch3.flicker(ds);
/* 130 */     this.torch3.register();
/*     */     
/* 132 */     int ww = 3072;
/*     */     
/* 134 */     this.fameBounds.moveX1(ran * (ww - this.bounds.width()));
/* 135 */     render(r, this.bounds.x1(), this.bounds.y1(), (RECTANGLE)this.fameBounds, this.tilescr, 48);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void render(SPRITE_RENDERER r, int x1, int y1, RECTANGLE bb, TILE_SHEET tiles, int tilesX) {
/* 140 */     int dx = bb.x1() % tiles.size();
/* 141 */     x1 -= dx;
/*     */     
/* 143 */     int sx = bb.x1() / tiles.size();
/*     */     
/* 145 */     int ys = (int)Math.ceil(bb.height() / tiles.size());
/* 146 */     int xs = (int)Math.ceil((bb.width() + dx) / tiles.size());
/*     */     
/* 148 */     for (int y = 0; y < ys; y++) {
/* 149 */       for (int x = 0; x < xs && x < tilesX; x++) {
/* 150 */         int t = sx + tilesX * y + x;
/* 151 */         if (t < tiles.tiles())
/*     */         {
/*     */           
/* 154 */           tiles.render(r, t, x1 + x * tiles.size(), y1 + y * tiles.size());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\Background.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */