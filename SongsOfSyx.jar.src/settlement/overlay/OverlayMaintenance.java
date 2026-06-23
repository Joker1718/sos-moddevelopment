/*     */ package settlement.overlay;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentChecker;
/*     */ import settlement.path.components.SComponentEdge;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.GUTIL;
/*     */ import util.colors.GCOLOR;
/*     */ import util.rendering.RenderData;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ public final class OverlayMaintenance extends Addable {
/*  27 */   private final SComponentChecker check = new SComponentChecker((SComponentLevel)(SETT.PATH()).comps.zero);
/*  28 */   private Bitmap1D checkS = new Bitmap1D(1024, false);
/*     */   private RoomInstance special;
/*  30 */   private static CharSequence ¤¤desc = "Highlights which tiles need maintenance.";
/*     */   
/*     */   static {
/*  33 */     D.ts(OverlayMaintenance.class);
/*     */   }
/*     */   
/*     */   OverlayMaintenance() {
/*  37 */     super((SPRITE)(UI.icons()).s.degrade, "MAINTENANCE", Dic.¤¤Maintenance, ¤¤desc, true, true);
/*  38 */     this.exclusive = true;
/*     */   }
/*     */   
/*     */   public void add(RoomInstance ins) {
/*  42 */     super.add();
/*  43 */     this.special = ins;
/*     */   }
/*     */ 
/*     */   
/*     */   public void add() {
/*  48 */     this.special = null;
/*  49 */     super.add();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void initBelow(RenderData data) {
/*  55 */     this.check.init();
/*  56 */     GUTIL.flooder().init(this);
/*     */     
/*  58 */     int radius = 150;
/*     */     
/*  60 */     for (RoomInstance ins : (SETT.ROOMS()).JANITOR.all()) {
/*     */       
/*  62 */       if (ins.active()) {
/*  63 */         GUTIL.flooder().pushSloppy(ins.mX(), ins.mY(), 0.0D);
/*     */       }
/*     */     } 
/*     */     
/*  67 */     while (GUTIL.flooder().hasMore()) {
/*  68 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  69 */       if (t.getValue() > radius)
/*     */         continue; 
/*  71 */       SComponent c = (SComponent)(SETT.PATH()).comps.zero.get((COORDINATE)t);
/*  72 */       if (c != null) {
/*  73 */         this.check.isSetAndSet(c);
/*  74 */         SComponentEdge e = c.edgefirst();
/*  75 */         while (e != null) {
/*  76 */           GUTIL.flooder().pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + e.distance(), t);
/*  77 */           GUTIL.flooder().setValue2(e.to().centreX(), e.to().centreY(), 0.0D);
/*  78 */           e = e.next();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  83 */     GUTIL.flooder().done();
/*     */     
/*  85 */     if (this.special == null) {
/*     */       return;
/*     */     }
/*  88 */     if (this.checkS.size() < (SETT.PATH()).comps.zero.componentsMax())
/*  89 */       this.checkS = new Bitmap1D((SETT.PATH()).comps.zero.componentsMax(), false); 
/*  90 */     this.checkS.clear();
/*  91 */     GUTIL.flooder().init(this);
/*  92 */     GUTIL.flooder().pushSloppy(this.special.mX(), this.special.mY(), 0.0D);
/*     */     
/*  94 */     while (GUTIL.flooder().hasMore()) {
/*  95 */       PathTile t = GUTIL.flooder().pollSmallest();
/*  96 */       if (t.getValue() > radius)
/*     */         continue; 
/*  98 */       SComponent c = (SComponent)(SETT.PATH()).comps.zero.get((COORDINATE)t);
/*  99 */       if (c != null) {
/* 100 */         this.checkS.set(c.index(), true);
/* 101 */         SComponentEdge e = c.edgefirst();
/* 102 */         while (e != null) {
/* 103 */           GUTIL.flooder().pushSmaller(e.to().centreX(), e.to().centreY(), t.getValue() + e.distance(), t);
/* 104 */           GUTIL.flooder().setValue2(e.to().centreX(), e.to().centreY(), 0.0D);
/* 105 */           e = e.next();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     GUTIL.flooder().done();
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderBelow(Renderer r, RenderData.RenderIterator it) {
/*     */     ColorImp colorImp;
/* 116 */     COLOR c = COLOR.WHITE10;
/*     */     
/* 118 */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(it.tile());
/* 119 */     if (sComp0 != null) {
/*     */ 
/*     */       
/* 122 */       if ((SETT.MAINTENANCE()).disabled.is(it.tile())) {
/* 123 */         c = (GCOLOR.MAP()).SOSO;
/* 124 */       } else if (!(SETT.MAINTENANCE()).needs.is(it.tx(), it.ty())) {
/* 125 */         c = COLOR.WHITE50;
/* 126 */       } else if ((SETT.MAINTENANCE()).degrade.get(it.tx(), it.ty()) > 0.0D) {
/* 127 */         ColorImp colorImp1 = ColorImp.TMP.interpolate((GCOLOR.MAP()).OVERLAY_GOOD, (GCOLOR.MAP()).OVERLAY_BAD, (SETT.MAINTENANCE()).degrade.get(it.tx(), it.ty()));
/*     */       } else {
/* 129 */         c = (GCOLOR.MAP()).OVERLAY_GOOD;
/*     */       } 
/*     */       
/* 132 */       ColorImp.TMP.set(c);
/* 133 */       if (this.checkS != null && this.checkS.get(sComp0.index())) {
/* 134 */         ColorImp.TMP.shadeSelf(1.25D);
/* 135 */       } else if (!this.check.is((SComponent)sComp0)) {
/* 136 */         ColorImp.TMP.shadeSelf(0.75D);
/* 137 */       }  colorImp = ColorImp.TMP;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     renderUnder((COLOR)colorImp, r, it);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(Renderer r, RenderData.RenderIterator it) {
/* 151 */     if ((SETT.MAINTENANCE()).isser.is(it.tile())) {
/* 152 */       COLOR c = (GCOLOR.MAP()).BAD;
/* 153 */       if ((SETT.MAINTENANCE()).disabled.is(it.tile())) {
/* 154 */         c = COLOR.WHITE50;
/* 155 */       } else if ((SETT.MAINTENANCE()).reserved.is(it.tx(), it.ty())) {
/* 156 */         c = (GCOLOR.MAP()).BEST_DARK;
/* 157 */       } else if ((SETT.MAINTENANCE()).degrade.get(it.tx(), it.ty()) > 0.0D) {
/* 158 */         c = (GCOLOR.MAP()).BAD;
/*     */       } else {
/* 160 */         c = (GCOLOR.MAP()).SOSO;
/*     */       } 
/*     */       
/* 163 */       c.bind();
/* 164 */       (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)r, 0, it.x(), it.y());
/* 165 */       COLOR.unbind();
/* 166 */       RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(it.tx(), it.ty());
/* 167 */       if (res != null) {
/* 168 */         res.icon().renderScaled((SPRITE_RENDERER)r, it.x() + 8, it.y() + 8, 2);
/*     */       }
/* 170 */       return true;
/*     */     } 
/* 172 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void finishBelow() {
/* 177 */     this.special = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\overlay\OverlayMaintenance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */