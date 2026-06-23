/*     */ package settlement.path.finders;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.animal.Animal;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.FindableDataSingle;
/*     */ import settlement.path.components.FindableDatas;
/*     */ import settlement.path.components.SComp0;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import view.sett.IDebugPanelSett;
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
/*     */ public final class SFinderEntity
/*     */ {
/*     */   private FindableDataSingle enemies;
/*     */   private final SFINDER findSafety;
/*     */   private final SFINDER rout;
/*     */   
/*     */   SFinderEntity() {
/* 133 */     this.findSafety = new SFINDER()
/*     */       {
/*     */         private int tx;
/*     */         private int ty;
/*     */         
/*     */         public boolean isInComponent(SComponent c, double distance) {
/* 139 */           if (SFinderEntity.this.enemies.get(c) == 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 146 */             COORDINATE coo = c.rndCoo();
/* 147 */             this.tx = coo.x();
/* 148 */             this.ty = coo.y();
/* 149 */             return true;
/*     */           } 
/* 151 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty, int tileNr) {
/* 156 */           return (tx == this.tx && ty == this.ty);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean canCross(SComponent c) {
/* 161 */           return (SFinderEntity.this.enemies.get(c) == 0);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 166 */     this.rout = new SFINDER()
/*     */       {
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/* 170 */           return c.hasEdge();
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty, int tileNr) {
/* 175 */           if (tx == 0 || tx == SETT.TWIDTH - 1 || ty == 0 || ty == SETT.THEIGHT - 1)
/* 176 */             return !(SETT.PATH()).solidity.is(tx, ty); 
/* 177 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean canCross(SComponent c) {
/* 182 */           return (SFinderEntity.this.enemies.get(c) == 0);
/*     */         }
/*     */       };
/*     */     IDebugPanelSett.add("find safety", new ACTION() {
/*     */           public void exe() {
/*     */             long n = System.currentTimeMillis();
/*     */             int sx = RND.rInt(SETT.TWIDTH);
/*     */             int sy = RND.rInt(SETT.THEIGHT);
/*     */             int max = 100;
/*     */             SFinderEntity.this.enemies = SFinderEntity.this.s().people(true);
/*     */             SComponent s = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/*     */             if (s != null) {
/*     */               SCompFinder.SCompPath p = (SETT.PATH()).comps.pather.find(sx, sy, SFinderEntity.this.findSafety, max, 16);
/*     */               if (p != null) {
/*     */                 SPathFinder.SPathUtilResult r = (SETT.PATH()).finders.finder().find(sx, sy, SFinderEntity.this.findSafety, max, p);
/*     */                 if (r != null)
/*     */                   LOG.ln("yay " + sx + " " + sy + " " + r.destX + " " + r.destY); 
/*     */               } 
/*     */             } 
/*     */             LOG.ln("" + System.currentTimeMillis() - n);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void report(ENTITY e, int delta) {
/*     */     if (e instanceof Humanoid) {
/*     */       FindableDataSingle s = s().people(!((Humanoid)e).indu().hostile());
/*     */       if (delta > 0) {
/*     */         s.reportPresence(e.ssx(), e.ssy());
/*     */       } else {
/*     */         s.reportAbsence(e.ssx(), e.ssy());
/*     */       } 
/*     */     } else if (e instanceof Animal) {
/*     */       if (((Animal)e).huntReservable())
/*     */         if (delta == 1) {
/*     */           (s()).reservableAnimals.reportPresence(e.ssx(), e.ssy());
/*     */         } else {
/*     */           (s()).reservableAnimals.reportAbsence(e.ssx(), e.ssy());
/*     */         }  
/*     */     } 
/*     */   }
/*     */   
/*     */   private final FindableDatas s() {
/*     */     return (SETT.PATH()).comps.data;
/*     */   }
/*     */   
/*     */   public int getEnemies(Humanoid asker, int tx, int ty) {
/*     */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(tx, ty);
/*     */     if (sComp0 == null)
/*     */       return 0; 
/*     */     return s().people(asker.indu().hostile()).get((SComponent)sComp0);
/*     */   }
/*     */   
/*     */   public int getFriendlies(Humanoid asker, int tx, int ty) {
/*     */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(tx, ty);
/*     */     if (sComp0 == null)
/*     */       return 0; 
/*     */     return s().people(!asker.indu().hostile()).get((SComponent)sComp0);
/*     */   }
/*     */   
/*     */   public int getAny(int tx, int ty) {
/*     */     SComp0 sComp0 = (SETT.PATH()).comps.zero.get(tx, ty);
/*     */     if (sComp0 == null)
/*     */       return 0; 
/*     */     return s().people(true).get((SComponent)sComp0) + s().people(false).get((SComponent)sComp0);
/*     */   }
/*     */   
/*     */   public boolean findExitNoEnemies(Humanoid asker, int sx, int sy, SPath path, int max) {
/*     */     this.enemies = s().people(asker.indu().hostile());
/*     */     SComponent s = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/*     */     if (s != null && s.hasEdge()) {
/*     */       SCompFinder.SCompPath p = (SETT.PATH()).comps.pather.find(sx, sy, this.rout, max, 16);
/*     */       if (p != null) {
/*     */         SPathFinder.SPathUtilResult r = (SETT.PATH()).finders.finder().find(sx, sy, this.rout, max, p);
/*     */         if (r != null) {
/*     */           path.setDirect(sx, sy, r.destX, r.destY, r.t, false);
/*     */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean findSafety(Humanoid asker, int sx, int sy, SPath path, int max) {
/*     */     this.enemies = s().people(asker.indu().hostile());
/*     */     SComponent s = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/*     */     if (s != null) {
/*     */       SCompFinder.SCompPath p = (SETT.PATH()).comps.pather.find(sx, sy, this.findSafety, max, 16);
/*     */       if (p != null) {
/*     */         SPathFinder.SPathUtilResult r = (SETT.PATH()).finders.finder().find(sx, sy, this.findSafety, max, p);
/*     */         if (r != null) {
/*     */           path.setDirect(sx, sy, r.destX, r.destY, r.t, false);
/*     */           return true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderEntity.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */