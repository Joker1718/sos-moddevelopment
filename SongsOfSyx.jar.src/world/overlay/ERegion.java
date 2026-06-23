/*     */ package world.overlay;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import view.main.VIEW;
/*     */ import world.WORLD;
/*     */ import world.map.pathing.WPATHING;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.pathing.WRegSel;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ERegion
/*     */ {
/*     */   private Region hovered;
/*  33 */   private final COLOR cNone = (COLOR)new ColorImp(100, 100, 100);
/*  34 */   private final ColorImp col = new ColorImp();
/*     */   
/*     */   private double shade;
/*  37 */   private final WRegFinder fin = new WRegFinder();
/*     */   
/*     */   public void add(Region r) {
/*  40 */     if (r != null) {
/*  41 */       this.hovered = r;
/*     */     }
/*     */   }
/*     */   
/*     */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/*  46 */     if (this.hovered == null)
/*     */       return; 
/*  48 */     renderAbove(this.hovered, r, s, data);
/*  49 */     renderPath(this.hovered, r, s, data);
/*  50 */     this.hovered = null;
/*  51 */     (WORLD.OVERLAY()).things.render(r, s, data);
/*     */   }
/*     */   
/*     */   public void renderAbove(Region hovered, Renderer r, ShadowBatch s, RenderData data) {
/*  55 */     s.setHeightUI(6.0D);
/*  56 */     s.setDistance2GroundUI(10.0D);
/*  57 */     s.setHard();
/*  58 */     this.shade = VIEW.renderSecond();
/*  59 */     this.shade = MATH.mod(this.shade, 2.0D);
/*  60 */     this.shade = MATH.distanceC(this.shade, 1.0D, 2.0D);
/*  61 */     if (hovered.realm() == null) {
/*  62 */       this.col.set(this.cNone);
/*     */     } else {
/*  64 */       this.col.set((COLOR)hovered.faction().banner().colorBG());
/*  65 */     }  this.col.shadeSelf(0.5D + this.shade);
/*  66 */     this.col.bind();
/*  67 */     for (COORDINATE c : hovered.info.bounds()) {
/*  68 */       if (hovered.is(c)) {
/*  69 */         int m = 0;
/*  70 */         for (DIR d : DIR.ORTHO) {
/*  71 */           if (hovered.is(c, d) || !WORLD.IN_BOUNDS(c, d)) {
/*  72 */             m |= d.mask();
/*     */           }
/*     */         } 
/*  75 */         if (m != 15) {
/*  76 */           int x = data.transformGX(c.x() * 64);
/*  77 */           int y = data.transformGY(c.y() * 64);
/*  78 */           (SPRITES.cons()).BIG.dashed_hollow.render((SPRITE_RENDERER)r, m, x, y);
/*  79 */           (SPRITES.cons()).BIG.dashed_hollow.render((SPRITE_RENDERER)s, m, x, y);
/*     */         } 
/*     */       } 
/*     */     } 
/*  83 */     s.setPrev();
/*     */   }
/*     */ 
/*     */   
/*  87 */   private Bitmap1D cc = new Bitmap1D(1023, false);
/*     */   
/*     */   public void renderPath(Region reg, Renderer r, ShadowBatch s, RenderData data) {
/*  90 */     LIST<WRegFinder.RegDist> regs = this.fin.all(reg, WRegFinder.Treaty.REG_NEIGHS, WRegSel.DUMMY());
/*     */     
/*  92 */     this.cc.clear();
/*  93 */     for (WRegFinder.RegDist d : regs) {
/*  94 */       this.cc.set(d.reg.index(), true);
/*     */     }
/*  96 */     this.cc.set(reg.index(), true);
/*  97 */     PathUtilOnline.Flooder f = GUTIL.flooder();
/*  98 */     f.init(this);
/*  99 */     f.pushSloppy(reg.cx(), reg.cy(), 0.0D);
/* 100 */     while (f.hasMore()) {
/*     */       
/* 102 */       PathTile t = f.pollSmallest();
/* 103 */       Region rr = (Region)(WORLD.PATH()).regMap.get((COORDINATE)t);
/*     */       
/* 105 */       if (rr != null && !this.cc.get(rr.index()))
/*     */         continue; 
/* 107 */       if (rr != reg && rr != null && t.isSameAs(rr.cx(), rr.cy())) {
/* 108 */         this.cc.set(rr.index(), false);
/* 109 */         render(r, s, data, t);
/*     */         
/*     */         continue;
/*     */       } 
/* 113 */       for (DIR d : DIR.ALL) {
/* 114 */         if ((WORLD.PATH()).map.can((COORDINATE)t, d) && (rr == null || rr == reg || rr == (WORLD.PATH()).regMap.get((COORDINATE)t, d))) {
/* 115 */           GUTIL.flooder().pushSmaller((COORDINATE)t, d, t.getValue() + WPATHING.cost(t.x(), t.y(), d) * d.tileDistance(), t);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 122 */     GUTIL.flooder().done();
/* 123 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   private void render(Renderer r, ShadowBatch s, RenderData data, PathTile t) {
/* 128 */     Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)t);
/*     */ 
/*     */ 
/*     */     
/* 132 */     if (reg != null)
/* 133 */       WORLD.OVERLAY().hoverBox(reg); 
/* 134 */     if (t.getParent() == null)
/*     */       return; 
/* 136 */     PathTile prev = t;
/* 137 */     t = t.getParent();
/* 138 */     while (t.getParent() != null) {
/*     */       
/* 140 */       DIR d = DIR.get((COORDINATE)t, (COORDINATE)prev);
/* 141 */       int dd = 32;
/* 142 */       int x = data.transformGX(t.x() * 64);
/* 143 */       int y = data.transformGY(t.y() * 64);
/*     */ 
/*     */       
/* 146 */       for (int i = 0; i < 2; i++) {
/* 147 */         ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render((SPRITE_RENDERER)r, x + d.x() * dd * i, y + d.y() * dd * i);
/* 148 */         ((SPRITE)(SPRITES.cons()).ICO.arrows2.get(d.id())).render((SPRITE_RENDERER)s, x + d.x() * dd * i, y + d.y() * dd * i);
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 154 */       prev = t;
/* 155 */       t = t.getParent();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\ERegion.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */