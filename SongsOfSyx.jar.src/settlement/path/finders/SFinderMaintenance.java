/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SFinderMaintenance
/*     */ {
/*  17 */   private final RBIT.RBITImp tbits = new RBIT.RBITImp();
/*  18 */   private Coo coo = new Coo();
/*     */   
/*     */   private SFINDER finder;
/*     */   
/*     */   private SFINDER finder2;
/*     */   
/*     */   public boolean has(int sx, int sy, RBIT bits) {
/*  25 */     return !(!(SETT.PATH()).comps.data.maintenanceRes.has(sx, sy, bits) && 
/*  26 */       !(SETT.PATH()).comps.data.maintenance.has(sx, sy));
/*     */   }
/*     */   
/*     */   public boolean find(RBIT bits, COORDINATE start, SPath path, int maxdistance) {
/*  30 */     return find(bits, start.x(), start.y(), path, maxdistance);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean find(RBIT bits, int sx, int sy, SPath path, int maxdistance) {
/*  35 */     if (has(sx, sy, bits)) {
/*  36 */       this.tbits.clearSet(bits);
/*  37 */       if (path.request(sx, sy, this.finder, maxdistance)) {
/*  38 */         this.coo.set(path.destX(), path.destY());
/*  39 */         return true;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  44 */     return false;
/*     */   }
/*     */   
/*     */   public COORDINATE find(RBIT bits, int sx, int sy, int maxdistance) {
/*  48 */     this.tbits.clearSet(bits);
/*  49 */     if (has(sx, sy, (RBIT)this.tbits)) {
/*     */       
/*  51 */       SPathFinder.SPathUtilResult r = (SETT.PATH()).finders.finder().find(sx, sy, this.finder, maxdistance);
/*  52 */       if (r != null) {
/*  53 */         this.coo.set(r.destX, r.destY);
/*  54 */         return (COORDINATE)this.coo;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE findWithin(RBIT bits, int sx, int sy, int maxdistance, int mx, int my) {
/*  64 */     if (sx == mx && sy == my) {
/*  65 */       return find(bits, sx, sy, maxdistance);
/*     */     }
/*  67 */     if (has(sx, sy, bits)) {
/*  68 */       this.tbits.clearSet(bits);
/*  69 */       RadiusChecker.self.check(mx, my, maxdistance);
/*  70 */       if (!RadiusChecker.self.is(sx, sy)) {
/*  71 */         sx = mx;
/*  72 */         sy = my;
/*     */       } 
/*  74 */       SPathFinder.SPathUtilResult r = (SETT.PATH()).finders.finder().find(sx, sy, this.finder2, maxdistance + 128);
/*  75 */       if (r != null) {
/*  76 */         this.coo.set(r.destX, r.destY);
/*  77 */         return (COORDINATE)this.coo;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  82 */     return null;
/*     */   }
/*     */   
/*     */   public RBIT mask(int sx, int sy) {
/*  86 */     return (SETT.PATH()).comps.data.maintenanceRes.bits(sx, sy);
/*     */   }
/*     */   
/*     */   SFinderMaintenance() {
/*  90 */     this.finder = new SFINDER()
/*     */       {
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/*  94 */           return !(!(SETT.PATH()).comps.data.maintenanceRes.has(c, (RBIT)SFinderMaintenance.this.tbits) && 
/*  95 */             (SETT.PATH()).comps.data.maintenance.get(c) <= 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty, int tileNr) {
/* 100 */           if ((SETT.MAINTENANCE()).reservable.is(tx, ty)) {
/* 101 */             RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(tx, ty);
/* 102 */             return !(res != null && !SFinderMaintenance.this.tbits.has(res));
/*     */           } 
/* 104 */           return false;
/*     */         }
/*     */       };
/*     */     
/* 108 */     this.finder2 = new SFINDER()
/*     */       {
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/* 112 */           return !(!(SETT.PATH()).comps.data.maintenanceRes.has(c, (RBIT)SFinderMaintenance.this.tbits) && 
/* 113 */             (SETT.PATH()).comps.data.maintenance.get(c) <= 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean canCross(SComponent c) {
/* 118 */           return RadiusChecker.self.is(c);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty, int tileNr) {
/* 123 */           if ((SETT.MAINTENANCE()).reservable.is(tx, ty)) {
/* 124 */             RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(tx, ty);
/* 125 */             return !(res != null && !SFinderMaintenance.this.tbits.has(res));
/*     */           } 
/* 127 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void add(int tx, int ty) {
/* 134 */     if ((SETT.MAINTENANCE()).reservable.is(tx, ty)) {
/* 135 */       RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(tx, ty);
/* 136 */       if (res != null) {
/* 137 */         (SETT.PATH()).comps.data.maintenanceRes.reportPresence(tx, ty, res);
/*     */       } else {
/* 139 */         (SETT.PATH()).comps.data.maintenance.reportPresence(tx, ty);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void remove(int tx, int ty) {
/* 146 */     if ((SETT.MAINTENANCE()).reservable.is(tx, ty)) {
/* 147 */       RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(tx, ty);
/* 148 */       if (res != null) {
/* 149 */         (SETT.PATH()).comps.data.maintenanceRes.reportAbsence(tx, ty, res);
/*     */       } else {
/* 151 */         (SETT.PATH()).comps.data.maintenance.reportAbsence(tx, ty);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderMaintenance.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */