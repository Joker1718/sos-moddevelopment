/*     */ package world.map.regions.centre;
/*     */ 
/*     */ import snake2d.CORE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.sets.ArrayCooShort;
/*     */ import util.GUTIL;
/*     */ import world.WORLD;
/*     */ import world.WRenContext;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public final class Sprite
/*     */ {
/*  15 */   private final CSprite sprite = new CSprite();
/*     */   
/*  17 */   private final ArrayCooShort centres = new ArrayCooShort(128);
/*  18 */   private Rec tmp = new Rec();
/*  19 */   private final int from = -1;
/*  20 */   private final int to = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderGround(WRenContext data) {
/*  30 */     int last = this.centres.getI();
/*     */     
/*  32 */     for (int i = 0; i < last; i++) {
/*     */       
/*  34 */       COORDINATEE cOORDINATEE = this.centres.set(i);
/*  35 */       Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)cOORDINATEE);
/*     */       
/*  37 */       for (int dty = -1; dty <= 2; dty++) {
/*  38 */         for (int dtx = -1; dtx <= 2; dtx++) {
/*     */           
/*  40 */           int tx = cOORDINATEE.x() + dtx;
/*  41 */           int ty = cOORDINATEE.y() + dty;
/*     */           
/*  43 */           int x = data.data.transformGX(tx * 64);
/*  44 */           int y = data.data.transformGY(ty * 64);
/*  45 */           this.sprite.renderOnGround(data, dtx - -1, dty - -1, reg, GUTIL.ran1().get(tx, ty), x, y);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  53 */     this.centres.set(last);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderAbove(WRenContext data) {
/*  60 */     int last = this.centres.getI();
/*     */     int i;
/*  62 */     for (i = 0; i < last; i++) {
/*     */       
/*  64 */       COORDINATEE cOORDINATEE = this.centres.set(i);
/*  65 */       Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)cOORDINATEE);
/*  66 */       for (int dty = -1; dty <= 2; dty++) {
/*  67 */         for (int dtx = -1; dtx <= 2; dtx++) {
/*     */           
/*  69 */           int tx = cOORDINATEE.x() + dtx;
/*  70 */           int ty = cOORDINATEE.y() + dty;
/*     */           
/*  72 */           int x = data.data.transformGX(tx * 64);
/*  73 */           int y = data.data.transformGY(ty * 64);
/*     */           
/*  75 */           this.sprite.renderAboveB(data, dtx - -1, dty - -1, reg, GUTIL.ran1().get(tx, ty), x, y);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  81 */     CORE.renderer().newLayer(false, CORE.renderer().getZoomout());
/*     */     
/*  83 */     for (i = 0; i < last; i++) {
/*     */       
/*  85 */       COORDINATEE cOORDINATEE = this.centres.set(i);
/*  86 */       Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)cOORDINATEE);
/*  87 */       for (int dty = -1; dty <= 2; dty++) {
/*  88 */         for (int dtx = -1; dtx <= 2; dtx++) {
/*     */           
/*  90 */           int tx = cOORDINATEE.x() + dtx;
/*  91 */           int ty = cOORDINATEE.y() + dty;
/*     */           
/*  93 */           int x = data.data.transformGX(tx * 64);
/*  94 */           int y = data.data.transformGY(ty * 64);
/*     */           
/*  96 */           this.sprite.renderAboveA(data, dtx - -1, dty - -1, reg, GUTIL.ran1().get(tx, ty), x, y);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     this.centres.set(last);
/*     */   }
/*     */   
/*     */   public void renderAboveTerrain(WRenContext data) {
/* 108 */     this.tmp.setDim((data.data.tBounds().width() + 6 + 4), (data.data.tBounds().height() + 6 + 4));
/* 109 */     this.tmp.moveC(data.data.tBounds().cX(), data.data.tBounds().cY());
/* 110 */     this.centres.set(0);
/* 111 */     for (Region reg : WORLD.REGIONS().active()) {
/* 112 */       if (reg.cx() >= 0 && this.tmp.holdsPoint(reg.cx(), reg.cy())) {
/* 113 */         this.centres.get().set(reg.cx(), reg.cy());
/* 114 */         if (this.centres.getI() >= this.centres.size() - 1)
/*     */           continue; 
/* 116 */         this.centres.inc();
/*     */       } 
/*     */     } 
/*     */     
/* 120 */     int last = this.centres.getI();
/*     */     
/* 122 */     for (int i = 0; i < last; i++) {
/*     */       
/* 124 */       COORDINATEE cOORDINATEE = this.centres.set(i);
/* 125 */       Region reg = (Region)(WORLD.REGIONS()).map.get((COORDINATE)cOORDINATEE);
/* 126 */       for (int dty = -1; dty <= 2; dty++) {
/* 127 */         for (int dtx = -1; dtx <= 2; dtx++) {
/*     */           
/* 129 */           int tx = cOORDINATEE.x() + dtx;
/* 130 */           int ty = cOORDINATEE.y() + dty;
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 135 */           int x = data.data.transformGX(tx * 64);
/* 136 */           int y = data.data.transformGY(ty * 64);
/*     */           
/* 138 */           this.sprite.renderAboveTerrain(data, dtx - -1, dty - -1, reg, GUTIL.ran1().get(tx, ty), x, y);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 145 */     this.centres.set(last);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\centre\Sprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */