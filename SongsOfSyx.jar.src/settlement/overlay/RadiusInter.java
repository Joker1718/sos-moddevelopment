/*     */ package settlement.overlay;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icons;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComp0Level;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.finders.SFinderFindable;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ final class RadiusInter extends Addable {
/*     */   private RoomBlueprintIns<? extends RADIUS_INTER> blue;
/*     */   private SFinderFindable fin;
/*  24 */   private final int half = 10;
/*  25 */   private final int m = 5;
/*     */   
/*     */   private double er;
/*     */   
/*     */   RadiusInter() {
/*  30 */     super(null, null, null, null, true, true);
/*  31 */     this.exclusive = true;
/*     */   }
/*     */   private int ex; private int ey;
/*     */   public void add(RoomBlueprintIns<? extends RADIUS_INTER> blue, SFinderFindable fin, int ex, int ey, double er) {
/*  35 */     add();
/*  36 */     this.er = er;
/*  37 */     this.ex = ex;
/*  38 */     this.ey = ey;
/*  39 */     this.blue = blue;
/*  40 */     this.fin = fin;
/*     */   }
/*     */   
/*     */   public void add(RoomBlueprintIns<? extends RADIUS_INTER> blue, SFinderFindable fin) {
/*  44 */     add(blue, fin, -1, -1, -1.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private double value(int tx, int ty) {
/*  50 */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(tx, ty);
/*  51 */     if (sComp0 == null || !GUTIL.flooder().hasBeenPushed(sComp0.centreX(), sComp0.centreY())) {
/*  52 */       return 0.0D;
/*     */     }
/*  54 */     double v = GUTIL.flooder().getValue(sComp0.centreX(), sComp0.centreY());
/*  55 */     int i = (int)GUTIL.flooder().getValue2(sComp0.centreX(), sComp0.centreY());
/*     */     
/*  57 */     if (i < 0 || i >= this.blue.instancesSize())
/*  58 */       return v / this.er; 
/*  59 */     RADIUS_INTER r = (RADIUS_INTER)this.blue.getInstance(i);
/*  60 */     return v / r.radius();
/*     */   }
/*     */ 
/*     */   
/*     */   public void initBelow(RenderData data) {
/*  65 */     GUTIL.flooder().init(this);
/*  66 */     addPoint(this.ex, this.ey, this.er, -1);
/*  67 */     for (int i = 0; i < this.blue.instancesSize(); i++) {
/*  68 */       RADIUS_INTER r = (RADIUS_INTER)this.blue.getInstance(i);
/*  69 */       addPoint(r.rx(), r.ry(), r.radius(), i);
/*     */     } 
/*     */     
/*  72 */     SComp0Level comps = (SETT.PATH()).comps.zero;
/*     */     
/*  74 */     while (GUTIL.flooder().hasMore()) {
/*  75 */       PathTile t = GUTIL.flooder().pollGreatest();
/*  76 */       SComponent c = (SComponent)comps.get((COORDINATE)t);
/*  77 */       SComponentEdge e = c.edgefirst();
/*     */       
/*  79 */       while (e != null) {
/*  80 */         double v = t.getValue() - e.cost2();
/*  81 */         if (v >= 0.0D && 
/*  82 */           GUTIL.flooder().pushGreater(e.to().centreX(), e.to().centreY(), v) != null) {
/*  83 */           GUTIL.flooder().setValue2(e.to().centreX(), e.to().centreY(), t.getValue2());
/*     */         }
/*     */         
/*  86 */         e = e.next();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   private void addPoint(int tx, int ty, double radius, int value2) {
/*     */     SComponent sComponent;
/*  92 */     if (radius <= 1.0D)
/*     */       return; 
/*  94 */     SComp0Level comps = (SETT.PATH()).comps.zero;
/*  95 */     SComp0 sComp0 = comps.get(tx, ty);
/*  96 */     if (sComp0 == null)
/*  97 */       for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  98 */         DIR d = (DIR)DIR.ORTHO.get(di);
/*  99 */         sComponent = (SComponent)comps.get(tx, ty, d);
/* 100 */         if (sComponent != null) {
/*     */           break;
/*     */         }
/*     */       }  
/* 104 */     if (sComponent != null && 
/* 105 */       GUTIL.flooder().pushSloppy(sComponent.centreX(), sComponent.centreY(), radius) != null) {
/* 106 */       GUTIL.flooder().setValue2(sComponent.centreX(), sComponent.centreY(), value2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 114 */     if ((it.tx() & 0x5) != 10 || (it.ty() & 0x5) != 10) {
/* 115 */       return false;
/*     */     }
/*     */     
/* 118 */     if (this.fin.map.has(it.tx(), it.ty())) {
/* 119 */       Icons.S.IconS iconS = this.fin.map.is(it.tx(), it.ty()) ? 
/* 120 */         (SPRITES.icons()).s.alert : (SPRITES.icons()).s.allRight;
/*     */       
/* 122 */       int X1 = it.x() - 8;
/* 123 */       int Y1 = it.y() - 8;
/* 124 */       int X2 = it.x() + 64 + 16;
/* 125 */       int Y2 = it.y() + 64 + 16;
/*     */       
/* 127 */       COLOR.BLACK.bind();
/*     */       
/* 129 */       iconS.render((SPRITE_RENDERER)r, X1 + 8, X2 + 8, Y1 + 8, Y2 + 8);
/*     */       
/* 131 */       COLOR.unbind();
/*     */       
/* 133 */       iconS.render((SPRITE_RENDERER)r, X1, X2, Y1, Y2);
/*     */     } 
/*     */     
/* 136 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/* 141 */     double v = value(it.tx(), it.ty());
/* 142 */     renderUnder(v, r, it, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishBelow() {
/* 148 */     GUTIL.flooder().done();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\RadiusInter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */