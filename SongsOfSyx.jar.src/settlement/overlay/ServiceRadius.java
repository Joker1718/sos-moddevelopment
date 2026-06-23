/*     */ package settlement.overlay;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentChecker;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.service.module.RoomFinderHaser;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIMENSION;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ final class ServiceRadius extends Addable {
/*  26 */   private final SComponentChecker check = new SComponentChecker((SComponentLevel)(SETT.PATH()).comps.zero);
/*     */   private RoomFinderHaser ser;
/*  28 */   private final Rec tiles = new Rec();
/*     */   ServiceRadius() {
/*  30 */     super(null, null, null, null, true, false);
/*  31 */     this.exclusive = true;
/*     */   }
/*     */   
/*     */   public void add(RoomFinderHaser ser) {
/*  35 */     add();
/*  36 */     this.ser = ser;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initBelow(RenderData data) {
/*  42 */     this.check.init();
/*  43 */     GUTIL.flooder().init(this);
/*     */ 
/*     */     
/*  46 */     int radius = this.ser.radius();
/*     */     
/*  48 */     if (this.ser instanceof RoomBlueprintIns) {
/*  49 */       RoomBlueprintIns<?> b = (RoomBlueprintIns)this.ser;
/*  50 */       for (RoomInstance ins : b.all()) {
/*     */         
/*  52 */         for (COORDINATE c : ins.body()) {
/*  53 */           if (ins.is(c) && b.service(c.x(), c.y()) != null) {
/*  54 */             for (DIR d : DIR.ORTHO) {
/*  55 */               GUTIL.flooder().pushSloppy(c, d, 0.0D);
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } else {
/*  61 */       this.tiles.setDim((DIMENSION)data.tBounds());
/*  62 */       this.tiles.incrW((radius * 2 + 2));
/*  63 */       this.tiles.incrH((radius * 2 + 2));
/*  64 */       this.tiles.centerIn(data.tBounds());
/*     */       
/*  66 */       for (COORDINATE c : this.tiles) {
/*  67 */         if ((SETT.ROOMS()).map.blueprint.get(c) == this.ser) {
/*  68 */           for (DIR d : DIR.ORTHO) {
/*  69 */             GUTIL.flooder().pushSloppy(c, d, 0.0D);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  76 */     while (GUTIL.flooder().hasMore()) {
/*  77 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  78 */       if (t.getValue() > radius)
/*     */         continue; 
/*  80 */       SComponent c = (SComponent)(SETT.PATH()).comps.zero.get((COORDINATE)t);
/*  81 */       if (c != null) {
/*  82 */         this.check.isSetAndSet(c);
/*  83 */         SComponentEdge e = c.edgefirst();
/*  84 */         while (e != null) {
/*  85 */           GUTIL.flooder().pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + e.distance(), t);
/*  86 */           e = e.next();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/*     */     ColorImp colorImp;
/*  98 */     double radius = this.ser.radius();
/*     */     
/* 100 */     COLOR c = COLOR.WHITE10;
/* 101 */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(it.tile());
/*     */     
/* 103 */     if (sComp0 != null && this.check.is((SComponent)sComp0)) {
/* 104 */       PathTile t = GUTIL.flooder().get(sComp0.centreX(), sComp0.centreY());
/* 105 */       if (t != null) {
/* 106 */         double v = t.getValue();
/* 107 */         v /= radius;
/* 108 */         v = 1.0D - v;
/*     */         
/* 110 */         if ((this.ser.finder()).map.has(it.tx(), it.ty())) {
/* 111 */           if ((this.ser.finder()).map.fail(it.tx(), it.ty())) {
/* 112 */             colorImp = ColorImp.TMP.interpolate(COLOR.WHITE25, (GCOLOR.MAP()).OVERLAY_BAD, v);
/*     */           } else {
/* 114 */             colorImp = ColorImp.TMP.interpolate(COLOR.WHITE25, COLOR.WHITE85, v);
/*     */           } 
/*     */         } else {
/*     */           
/* 118 */           colorImp = ColorImp.TMP.interpolate(COLOR.WHITE25, COLOR.WHITE85, v);
/*     */         } 
/*     */         
/* 121 */         int tx = it.tx() - 1;
/* 122 */         int ty = it.ty() - 1;
/*     */         
/* 124 */         SComp0 sComp01 = (SETT.PATH()).comps.zero.get(tx, ty);
/* 125 */         if (sComp01 != null && this.check.is((SComponent)sComp01) && sComp01.centreX() == tx && sComp01.centreY() == ty && 
/* 126 */           (this.ser.finder()).map.fail(it.tx(), it.ty())) {
/* 127 */           colorImp = ColorImp.TMP.interpolate(COLOR.WHITE25, (GCOLOR.MAP()).OVERLAY_BAD, v);
/* 128 */           (UI.icons()).l.thumbsDown.renderCScaled((SPRITE_RENDERER)r, it.x() - 32, it.y() - 32, 4);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 135 */     renderUnder((COLOR)colorImp, r, it);
/*     */   }
/*     */   
/*     */   public void finishBelow() {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\ServiceRadius.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */