/*     */ package view.sett.ui.room.copy;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.job.Job;
/*     */ import settlement.job.JobBuildRoad;
/*     */ import snake2d.LOG;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.gui.misc.GBox;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableFixed;
/*     */ 
/*     */ final class Second
/*     */   extends PlacableFixed {
/*     */   private final Dest dest;
/*     */   private final RoomChecker room;
/*     */   
/*     */   Second(Dest dest) {
/*  22 */     this.dest = dest;
/*  23 */     this.room = new RoomChecker(dest);
/*     */   }
/*     */ 
/*     */   
/*     */   public void init(int cx, int cy) {
/*  28 */     this.dest.init(cx, cy, rot());
/*  29 */     this.room.init();
/*     */   }
/*     */ 
/*     */   
/*     */   public int width() {
/*  34 */     return this.dest.body().width();
/*     */   }
/*     */ 
/*     */   
/*     */   public int height() {
/*  39 */     return this.dest.body().height();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence placable(int tx, int ty, int rx, int ry) {
/*  44 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void place(int tx, int ty, int rx, int ry) {
/*  50 */     if (!this.dest.is(tx, ty))
/*     */       return; 
/*  52 */     if (this.dest.sourceIs(tx, ty)) {
/*     */       return;
/*     */     }
/*  55 */     if (!this.room.place(tx, ty)) {
/*     */ 
/*     */       
/*  58 */       COORDINATE s = this.dest.transform(tx, ty);
/*  59 */       Job j = Jobs.get(s.x(), s.y());
/*  60 */       if (j != null && j instanceof JobBuildRoad && JobBuildRoad.problem(tx, ty) == null) {
/*  61 */         j.placer().place(tx, ty, null, null);
/*  62 */       } else if (j != null && j.placer().isPlacable(tx, ty, null, null) == null) {
/*  63 */         j.placer().place(tx, ty, null, null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, int rx, int ry, boolean isPlacable, boolean areaIsPlacable) {
/*  77 */     if (blocked(tx, ty)) {
/*  78 */       blockedD(tx, ty);
/*     */     }
/*     */     
/*  81 */     if (blocked(tx, ty)) {
/*  82 */       (GCOLOR.MAP()).BAD.bind();
/*  83 */     } else if (this.room.isPartOfBlocked(tx, ty)) {
/*  84 */       (GCOLOR.MAP()).SOSO.bind();
/*     */     } else {
/*  86 */       (GCOLOR.MAP()).BEST.bind();
/*     */     } 
/*  88 */     if (!this.dest.is(tx, ty))
/*     */       return; 
/*  90 */     if (this.dest.blocking(tx, ty)) {
/*  91 */       (SPRITES.cons()).BIG.filled.render(r, 0, x, y);
/*     */     } else {
/*  93 */       (SPRITES.cons()).BIG.dashed.render(r, 15, x, y);
/*     */     } 
/*  95 */     mask = 0;
/*  96 */     for (DIR d : DIR.ORTHO) {
/*  97 */       if (this.dest.is(tx, ty, d)) {
/*  98 */         mask |= d.mask();
/*     */       }
/*     */     } 
/* 101 */     if (mask != 0) {
/* 102 */       (SPRITES.cons()).BIG.outline.render(r, mask, x, y);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SPRITE getIcon() {
/* 109 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/* 114 */     return E;
/*     */   }
/*     */ 
/*     */   
/*     */   public PLACABLE getUndo() {
/* 119 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int rotations() {
/* 124 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public int sizes() {
/* 129 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CharSequence placableWhole(int tx1, int ty1) {
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean blocked(int tx, int ty) {
/* 143 */     if (this.dest.sourceIs(tx, ty)) {
/* 144 */       return true;
/*     */     }
/* 146 */     if (this.room.isBlocked(tx, ty))
/* 147 */       return true; 
/* 148 */     COORDINATE s = this.dest.transform(tx, ty);
/* 149 */     Job j = Jobs.get(s.x(), s.y());
/* 150 */     if (j != null && j.placer() == null)
/* 151 */       LOG.ln(j); 
/* 152 */     if (j != null && j.placer().isPlacable(tx, ty, null, null) != null) {
/* 153 */       return true;
/*     */     }
/* 155 */     return false;
/*     */   }
/*     */   
/*     */   private boolean blockedD(int tx, int ty) {
/* 159 */     if (this.room.isBlocked(tx, ty)) {
/* 160 */       return true;
/*     */     }
/* 162 */     COORDINATE s = this.dest.transform(tx, ty);
/* 163 */     Job j = Jobs.get(s.x(), s.y());
/* 164 */     if (j != null && j.placer() == null)
/* 165 */       LOG.ln(j); 
/* 166 */     if (j != null && j.placer().isPlacable(tx, ty, null, null) != null) {
/* 167 */       return true;
/*     */     }
/*     */     
/* 170 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void placeInfo(GBox b, int x1, int y1) {
/* 175 */     b.add((SPRITE)b.text().add((width() - 1)).add('x').add((height() - 1)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\copy\Second.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */