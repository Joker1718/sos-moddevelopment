/*     */ package settlement.environment;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.GUTIL;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends EUpdater
/*     */ {
/*     */   public void update(SettEnvMap.SettEnv s, RECTANGLE bounds, RECTANGLE area) {
/*  45 */     for (COORDINATE c : area) {
/*  46 */       if (SETT.IN_BOUNDS(c)) {
/*  47 */         s.map.set(c.x() + c.y() * SETT.TWIDTH, 0);
/*  48 */         GUTIL.flooder().setValue2(c, 0.0D);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  53 */     for (COORDINATE c : bounds) {
/*  54 */       if (EUpdater.tracetest(area, s, c)) {
/*  55 */         EUpdater.trace(c.x(), c.y(), s, area);
/*     */       }
/*     */     } 
/*     */     
/*  59 */     for (COORDINATE c : area) {
/*  60 */       int v = (int)Math.ceil(GUTIL.flooder().getValue2(c.x(), c.y()));
/*  61 */       v = CLAMP.i(v, 0, s.max);
/*     */       
/*  63 */       s.map.set(c.x() + c.y() * SETT.TWIDTH, v);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addExtraView(RECTANGLE area, PathUtilOnline.Flooder f, SettEnvMap.SettEnv thing, double value, double radius, int tx, int ty, int approvedDirs) {
/*  73 */     if (EUpdater.aI != VIEW.RI()) {
/*  74 */       EUpdater.aI = VIEW.RI();
/*  75 */       for (COORDINATE c : area) {
/*  76 */         if (SETT.IN_BOUNDS(c))
/*  77 */           GUTIL.flooder().setValue2(c, 0.0D); 
/*     */       } 
/*  79 */       EUpdater.eArea.set(area);
/*     */     } else {
/*  81 */       EUpdater.eArea2.set((RECTANGLE)EUpdater.eArea);
/*  82 */       EUpdater.eArea.unify(area);
/*  83 */       for (COORDINATE c : EUpdater.eArea) {
/*  84 */         if (SETT.IN_BOUNDS(c) && !EUpdater.eArea2.holdsPoint(c))
/*  85 */           GUTIL.flooder().setValue2(c, 0.0D); 
/*     */       } 
/*     */     } 
/*  88 */     if (SETT.IN_BOUNDS(tx, ty)) {
/*  89 */       EUpdater.trace(tx, ty, thing, value, radius, area, approvedDirs);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getExtraValue(SettEnvMap.SettEnv s, double g, int tx, int ty) {
/* 148 */     if (EUpdater.aI != VIEW.RI())
/* 149 */       return g; 
/* 150 */     if (!EUpdater.eArea.holdsPoint(tx, ty)) {
/* 151 */       return g;
/*     */     }
/*     */     
/* 154 */     double d = Math.ceil(g * s.max + Math.ceil(GUTIL.flooder().getValue2(tx, ty))) * s.maxI;
/* 155 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\environment\EUpdater$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */