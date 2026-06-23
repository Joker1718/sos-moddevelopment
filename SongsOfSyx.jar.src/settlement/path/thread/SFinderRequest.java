/*     */ package settlement.path.thread;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.path.SPath;
/*     */ import snake2d.PathTile;
/*     */ import snake2d.PathUtilOnline;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SFinderRequest
/*     */ {
/*  22 */   protected final FinderThread.ThreadPathJob job = new FinderThread.ThreadPathJob()
/*     */     {
/*     */       public boolean doJob(PathUtilOnline p, SPathFinderThread fin, FinderThread.ThreadPath pp)
/*     */       {
/*  26 */         PathTile t = SFinderRequest.this.find(pp.sx, pp.sy, p);
/*  27 */         if (t != null) {
/*     */           
/*  29 */           pp.path.set(t);
/*  30 */           pp.destX = (short)t.x();
/*  31 */           pp.destY = (short)t.y();
/*  32 */           return true;
/*     */         } 
/*  34 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public boolean checkAndSetRequest(int sx, int sy, SPath path) {
/*  40 */     if (path.thread.isProcessed(sx, sy, 0, 0)) {
/*  41 */       path.clear();
/*  42 */       if (path.thread.isSuccess()) {
/*  43 */         path.copy(path.thread.path, path.thread.destX, path.thread.destY, true);
/*     */       }
/*  45 */       return true;
/*  46 */     }  if (path.thread.isBeingProcessed()) {
/*  47 */       return false;
/*     */     }
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   protected abstract PathTile find(int paramInt1, int paramInt2, PathUtilOnline paramPathUtilOnline);
/*     */   
/*     */   public static final class FinderIdle
/*     */     extends SFinderRequest {
/*     */     private final ArrayList<DIR> dirs;
/*     */     
/*     */     public FinderIdle() {
/*  59 */       this.dirs = new ArrayList((Iterable)DIR.ALL);
/*     */     } public boolean shouldFind(ENTITY e) {
/*  61 */       if (isGoodTileToStandOn(e.tc().x(), e.tc().y(), 1)) {
/*  62 */         return false;
/*     */       }
/*  64 */       return true;
/*     */     }
/*     */     
/*     */     public void request(Humanoid h, SPath path) {
/*  68 */       (SETT.PATH()).thread.prep(path, this.job, h.tc().x(), h.tc().y(), 0, 0, true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public final PathTile find(int sx, int sy, PathUtilOnline p) {
/*  75 */       p.getFlooder().init(null);
/*  76 */       PathTile t = p.getFlooder().pushSloppy(sx, sy, 0.0D, null);
/*     */       
/*  78 */       while (p.getFlooder().hasMore()) {
/*     */         
/*  80 */         t = p.getFlooder().pollSmallest();
/*     */         
/*  82 */         if (isGoodTileToStandOn(t.x(), t.y(), 0)) {
/*  83 */           p.getFlooder().done();
/*     */           
/*  85 */           return t;
/*     */         } 
/*     */         
/*  88 */         for (DIR d : this.dirs) {
/*     */           
/*  90 */           int dx = d.x() + t.x();
/*  91 */           int dy = d.y() + t.y();
/*  92 */           if (!SETT.IN_BOUNDS(dx, dy))
/*     */             continue; 
/*  94 */           if (!(SETT.PATH()).connectivity.is(dx, dy)) {
/*     */             continue;
/*     */           }
/*  97 */           double v = (SETT.PATH()).huristics.getCost(t.x(), t.y(), dx, dy);
/*  98 */           if (v < 0.0D)
/*     */             continue; 
/* 100 */           v *= d.tileDistance();
/* 101 */           v += t.getValue();
/* 102 */           if (v <= 40.0D)
/* 103 */             p.getFlooder().pushSmaller(dx, dy, v, t); 
/*     */         } 
/*     */       } 
/* 106 */       p.getFlooder().done();
/* 107 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     private boolean isGoodTileToStandOn(int tx, int ty, int max) {
/* 112 */       if (((SETT.PATH()).availability.get(tx, ty)).player < 0.0D)
/* 113 */         return false; 
/* 114 */       if (((SETT.PATH()).availability.get(tx, ty)).player >= 2.0D)
/* 115 */         return false; 
/* 116 */       if ((SETT.JOBS()).getter.is(tx, ty))
/* 117 */         return false; 
/* 118 */       if (SETT.THINGS().getFirst(tx, ty) != null)
/* 119 */         return false; 
/* 120 */       if (SETT.ENTITIES().amountAtTile(tx, ty) > max)
/* 121 */         return false; 
/* 122 */       if ((SETT.PATH()).huristics.getter.get(tx, ty) > 0.1D)
/* 123 */         return false; 
/* 124 */       if ((SETT.ROOMS()).map.is(tx, ty))
/* 125 */         return false; 
/* 126 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\thread\SFinderRequest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */