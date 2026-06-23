/*     */ package settlement.room.law.guard;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FINDABLE;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.util.bit.Bit;
/*     */ import snake2d.util.bit.Bits;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public final class GuardInstance extends RoomInstance {
/*     */   private static final long serialVersionUID = 1L;
/*  22 */   static final Bits standOccupied = new Bits(15);
/*  23 */   static final Bit standReserved = new Bit(1);
/*     */   
/*     */   private boolean search = true;
/*  26 */   float eff = 0.0F;
/*     */   
/*     */   int[] cdata;
/*     */   
/*     */   protected GuardInstance(ROOM_GUARD b, TmpArea area, RoomInit init) {
/*  31 */     super(b, area, init);
/*     */     
/*  33 */     for (COORDINATE c : body()) {
/*  34 */       if (!is(c))
/*     */         continue; 
/*  36 */       if ((SETT.ROOMS()).fData.tileData.get(c) == 3) {
/*  37 */         int off = ((SETT.ROOMS()).fData.tileData.get(c.x() + 1, c.y()) == 3) ? 31 : 0;
/*  38 */         SETT.LIGHTS().torchBig(c.x(), c.y(), off);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  44 */     employees().maxSet((int)b.constructor.guards.get(this));
/*  45 */     employees().neededSet((int)b.constructor.guards.get(this));
/*     */     
/*  47 */     activate();
/*     */     
/*  49 */     (blueprintI()).finder.report((FINDABLE)(blueprintI()).service.get(this), 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it) {
/*  55 */     it.lit();
/*  56 */     return super.render(r, shadowBatch, it);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void activateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void deactivateAction() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void dispose() {
/*  71 */     if ((blueprintI()).reporter.available(this)) {
/*  72 */       (blueprintI()).finder.report((FINDABLE)(blueprintI()).service.get(this), -1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ROOM_GUARD blueprintI() {
/*  78 */     return (ROOM_GUARD)blueprint();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void updateAction(double updateInterval, boolean day) {
/*  83 */     if (day)
/*  84 */       this.search = true; 
/*  85 */     float eff = (float)eff();
/*  86 */     if (Math.abs(eff - this.eff) > 0.1D) {
/*  87 */       this.eff = eff;
/*  88 */       for (COORDINATE c : body()) {
/*  89 */         if (is(c)) {
/*  90 */           (SETT.ENV()).map.setChanged(c.x(), c.y());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     super.updateAction(updateInterval, day);
/*     */   }
/*     */   
/*     */   public boolean guardSpot(COORDINATEE planTile, COORDINATE current) {
/*  99 */     if (!this.search)
/* 100 */       return false; 
/* 101 */     if (is(current.x(), current.y()) && (SETT.ROOMS()).fData.tileData.is(current.x(), current.y(), 4)) {
/* 102 */       int d = (SETT.ROOMS()).data.get(current.x(), current.y());
/* 103 */       if (!standReserved.is(d)) {
/* 104 */         d = standReserved.set(d);
/* 105 */         (SETT.ROOMS()).data.set((ROOMA)this, current.x(), current.y(), d);
/* 106 */         planTile.set(current);
/* 107 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 111 */     int a = body().width() * body().height();
/* 112 */     int tx = body().x1() + RND.rInt(body().width());
/* 113 */     int ty = body().y1() + RND.rInt(body().height());
/* 114 */     while (a-- >= 0) {
/* 115 */       if (is(tx, ty) && (SETT.ROOMS()).fData.tileData.is(tx, ty, 4)) {
/*     */         
/* 117 */         int d = (SETT.ROOMS()).data.get(tx, ty);
/* 118 */         if (!standReserved.is(d)) {
/* 119 */           d = standReserved.set(d);
/* 120 */           (SETT.ROOMS()).data.set((ROOMA)this, tx, ty, d);
/* 121 */           planTile.set(tx, ty);
/* 122 */           return true;
/*     */         } 
/*     */       } 
/* 125 */       tx++;
/* 126 */       if (tx >= body().x2()) {
/* 127 */         tx = body().x1();
/* 128 */         ty++;
/* 129 */         if (ty >= body().y2()) {
/* 130 */           ty = body().y1();
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 136 */     this.search = false;
/* 137 */     return false;
/*     */   }
/*     */   
/*     */   public boolean hasPotentialSpots() {
/* 141 */     return this.search;
/*     */   }
/*     */   
/*     */   public void guardSpotReturn(int tx, int ty) {
/* 145 */     this.search = true;
/* 146 */     if (!is(tx, ty) || !(SETT.ROOMS()).fData.tileData.is(tx, ty, 4)) {
/* 147 */       throw new RuntimeException("" + is(tx, ty) + " " + is(tx, ty));
/*     */     }
/* 149 */     int d = (SETT.ROOMS()).data.get(tx, ty);
/* 150 */     d = standReserved.clear(d);
/* 151 */     (SETT.ROOMS()).data.set((ROOMA)this, tx, ty, d);
/*     */   }
/*     */   
/*     */   public DIR guardDir(int tx, int ty) {
/* 155 */     return (blueprintI()).constructor.gaurdDir(tx, ty);
/*     */   }
/*     */   
/*     */   public double eff() {
/* 159 */     return (1.0D - getDegrade() * 0.5D) * employees().employed() / employees().max();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\guard\GuardInstance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */