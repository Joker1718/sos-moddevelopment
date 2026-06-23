/*     */ package view.battle;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.ON_TOP_RENDERABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.military.artillery.ArtilleryInstance;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ final class BattlePlacerRenderer
/*     */   extends ON_TOP_RENDERABLE
/*     */ {
/*     */   private final BattlePlacer b;
/*  26 */   private final double[] xs = new double[(Config.battle()).DIVISIONS_PER_ARMY];
/*  27 */   private final double[] ys = new double[(Config.battle()).DIVISIONS_PER_ARMY];
/*  28 */   private final double[] ranges = new double[(Config.battle()).DIVISIONS_PER_ARMY];
/*     */   
/*     */   private int ri;
/*     */   private boolean hovered;
/*     */   
/*     */   public BattlePlacerRenderer(BattlePlacer b) {
/*  34 */     this.b = b;
/*     */   }
/*     */   
/*     */   void add(boolean hovered) {
/*  38 */     this.hovered = hovered;
/*  39 */     add();
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/*  44 */     remove();
/*     */ 
/*     */     
/*  47 */     if (VIEW.b().state() != null && VIEW.b().state().deploying()) {
/*  48 */       RenderData.RenderIterator it = data.onScreenTiles();
/*  49 */       (GCOLOR.MAP()).OK.bind();
/*  50 */       while (it.has()) {
/*  51 */         if (VIEW.b().state().deploymentBounds().isOnEdge(it.tx(), it.ty())) {
/*  52 */           int m = 0;
/*     */           
/*  54 */           for (DIR d : DIR.ORTHO) {
/*  55 */             if (VIEW.b().state().deploymentBounds().holdsPoint(it.tx(), it.ty(), d)) {
/*  56 */               m |= d.mask();
/*     */             }
/*     */           } 
/*  59 */           if (m != 15) {
/*  60 */             (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)r, m, it.x(), it.y());
/*     */           }
/*     */         } 
/*     */         
/*  64 */         it.next();
/*     */       } 
/*     */       
/*  67 */       COLOR.unbind();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     this.ri = 0;
/*  74 */     for (Div d : this.b.s.selection()) {
/*  75 */       if (this.ri >= this.ranges.length)
/*     */         break; 
/*  77 */       if (d.settings().ammo() != null) {
/*  78 */         this.xs[this.ri] = (d.centre().cUnitX() >> 6);
/*  79 */         this.ys[this.ri] = (d.centre().cUnitY() >> 6);
/*  80 */         double ref = d.settings().ammo().ref(d);
/*  81 */         this.ranges[this.ri] = Trajectory.range(SETT.TERRAIN().get((int)this.xs[this.ri], (int)this.ys[this.ri]).heightEnd((int)this.xs[this.ri], (int)this.ys[this.ri]), (d.settings().ammo()).projectile.maxAngle(ref), (d.settings().ammo()).projectile.velocity(ref));
/*  82 */         this.ranges[this.ri] = ((int)this.ranges[this.ri] / 64);
/*     */ 
/*     */         
/*  85 */         this.ri++;
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     if (this.ri > 0) {
/*     */       
/*  91 */       (GCOLOR.MAP()).OK.bind();
/*  92 */       RenderData.RenderIterator it = data.onScreenTiles();
/*  93 */       while (it.has()) {
/*  94 */         renderRange(it, r);
/*     */         
/*  96 */         it.next();
/*     */       } 
/*     */       
/*  99 */       COLOR.unbind();
/*     */     } 
/*     */ 
/*     */     
/* 103 */     renderArtillery(r, shadowBatch, data);
/*     */ 
/*     */ 
/*     */     
/* 107 */     if (this.hovered) {
/* 108 */       this.b.current.render(r, shadowBatch, data, ds);
/*     */     }
/*     */   }
/*     */   
/*     */   private void renderRange(RenderData.RenderIterator it, Renderer r) {
/* 113 */     for (int i = 0; i < this.ri; i++) {
/* 114 */       double x = Math.abs(this.xs[i] - it.tx());
/* 115 */       double y = Math.abs(this.ys[i] - it.ty());
/* 116 */       int l = (int)Math.sqrt(x * x + y * y);
/* 117 */       if (l == this.ranges[i]) {
/* 118 */         (SPRITES.cons()).BIG.dots.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderArtillery(Renderer r, ShadowBatch shadowBatch, RenderData data) {
/* 125 */     for (ArtilleryInstance ins : this.b.s.artillery.selection()) {
/* 126 */       COORDINATE c = ins.centre();
/* 127 */       int sx = c.x();
/* 128 */       int sy = c.y();
/* 129 */       int rangeMin = ins.rangeMin();
/* 130 */       int rangeMax = ins.rangeMax();
/*     */       
/* 132 */       for (int di = -1; di <= 1; di++) {
/* 133 */         DIR d = ins.dir().next(di);
/* 134 */         boolean in = false;
/* 135 */         int min = (int)(rangeMin / d.tileDistance());
/* 136 */         int max = (int)(rangeMax / d.tileDistance());
/* 137 */         for (int i = min; i <= max; i += 64) {
/* 138 */           int tx = sx + i * d.x() >> 6;
/* 139 */           int ty = sy + i * d.y() >> 6;
/* 140 */           if (data.tBounds().holdsPoint(tx, ty)) {
/* 141 */             in = true;
/* 142 */             ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render((SPRITE_RENDERER)r, tx * 64 - data.offX1(), ty * 64 - data.offY1());
/* 143 */           } else if (in) {
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\battle\BattlePlacerRenderer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */