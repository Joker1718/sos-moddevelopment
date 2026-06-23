/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.path.components.FindableDatas;
/*     */ import settlement.path.components.SCompNLevel;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.components.SComponentLevel;
/*     */ import settlement.path.components.finder.SCompFinder;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.room.main.Room;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ 
/*     */ 
/*     */ public final class SFinderResourceStore
/*     */ {
/*  21 */   private Coo result = new Coo();
/*  22 */   private final Updater updater = new Updater();
/*     */ 
/*     */ 
/*     */   
/*     */   final RBIT.RBITImp resMask;
/*     */ 
/*     */ 
/*     */   
/*     */   final RBIT.RBITImp storeMask;
/*     */ 
/*     */   
/*     */   private final SCompFinder.SCompPatherExister wierd;
/*     */ 
/*     */   
/*     */   private SFINDER fin;
/*     */ 
/*     */ 
/*     */   
/*     */   void update(double ds) {
/*  41 */     this.updater.update(ds);
/*     */   }
/*     */   SFinderResourceStore() {
/*  44 */     this.resMask = new RBIT.RBITImp();
/*  45 */     this.storeMask = new RBIT.RBITImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  51 */     this.wierd = new SCompFinder.SCompPatherExister()
/*     */       {
/*     */ 
/*     */         
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/*  57 */           SFinderResourceStore.this.storeMask.or((SFinderResourceStore.this.d()).storage.bits(c));
/*  58 */           SFinderResourceStore.this.resMask.or((SFinderResourceStore.this.d()).resScattered.bits(c));
/*     */           
/*  60 */           return SFinderResourceStore.this.storeMask.has((RBIT)SFinderResourceStore.this.resMask);
/*     */         }
/*     */ 
/*     */         
/*     */         public void init(SComponentLevel l) {
/*  65 */           SFinderResourceStore.this.resMask.clear();
/*  66 */           SFinderResourceStore.this.storeMask.clear();
/*     */         }
/*     */       };
/*     */     
/*  70 */     this.fin = new SFINDER()
/*     */       {
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/*  74 */           return SFinderResourceStore.this.resMask.has((SFinderResourceStore.this.d()).storage.bits(c));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty, int tileNr) {
/*  79 */           Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  80 */           if (r != null) {
/*     */             
/*  82 */             TILE_STORAGE result = r.storage(tx, ty);
/*  83 */             if (result != null && result.storageIsFindable() && result.storageReservable() > 0 && result.resource() != null && SFinderResourceStore.this.resMask.has(result.resource())) {
/*  84 */               SFinderResourceStore.this.result.set((COORDINATE)result);
/*  85 */               return true;
/*     */             } 
/*     */           } 
/*  88 */           return false;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private FindableDatas d() {
/*     */     return (SETT.PATH()).comps.data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_STORAGE findAny(int sx, int sy, int maxDistance) {
/* 105 */     if (maxDistance == Integer.MAX_VALUE) {
/* 106 */       this.resMask.clearSet((d()).resScattered.bits(sx, sy));
/* 107 */       COORDINATE c = (SETT.PATH()).finders.finder().findDest(sx, sy, this.fin, maxDistance);
/* 108 */       if (c != null) {
/* 109 */         return ((Room)(SETT.ROOMS()).map.get((COORDINATE)this.result)).storage(this.result.x(), this.result.y());
/*     */       }
/* 111 */       return null;
/*     */     } 
/*     */     
/* 114 */     if ((SETT.PATH()).comps.pather.exists(sx, sy, this.wierd, maxDistance) && 
/* 115 */       (SETT.PATH()).finders.finder().findDest(sx, sy, this.fin, maxDistance) != null) {
/* 116 */       return ((Room)(SETT.ROOMS()).map.get((COORDINATE)this.result)).storage(this.result.x(), this.result.y());
/*     */     }
/* 118 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TILE_STORAGE find(int sx, int sy) {
/* 125 */     if (!has(sx, sy)) {
/* 126 */       return null;
/*     */     }
/* 128 */     TILE_STORAGE ss = findAny(sx, sy, 100);
/* 129 */     if (ss == null)
/* 130 */       this.updater.failShort(sx, sy); 
/* 131 */     return ss;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean has(int sx, int sy) {
/* 138 */     if (!hasAny(sx, sy)) {
/* 139 */       return false;
/*     */     }
/* 141 */     return this.updater.tryShort(sx, sy);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasAny(int sx, int sy) {
/* 146 */     SComponent s = (SComponent)(SETT.PATH()).comps.superComp.get(sx, sy);
/* 147 */     if (s == null) {
/* 148 */       return false;
/*     */     }
/* 150 */     return (d()).resScattered.bits(s).has((d()).storage.bits(s));
/*     */   }
/*     */ 
/*     */   
/*     */   static final class Updater
/*     */   {
/* 156 */     private final Bitmap1D tryShort = new Bitmap1D(32767, false);
/*     */     
/* 158 */     private final double speed = 0.015625D;
/* 159 */     double ci = 0.0D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void update(double ds) {
/* 166 */       int old = (int)this.ci;
/* 167 */       int max = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).componentsMax();
/* 168 */       if (max <= 0)
/*     */         return; 
/* 170 */       this.ci += ds * max * 0.015625D;
/* 171 */       int now = (int)this.ci;
/* 172 */       int delt = old - now;
/*     */       
/* 174 */       if (this.ci >= max) {
/* 175 */         this.ci -= max;
/*     */       }
/*     */       
/* 178 */       for (int k = 0; k <= delt; k++) {
/* 179 */         int i = k + old;
/* 180 */         i %= max;
/* 181 */         this.tryShort.set(i, false);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean tryShort(int tx, int ty) {
/* 187 */       SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 188 */       if (c == null)
/* 189 */         return false; 
/* 190 */       if (this.tryShort.get(c.index()))
/* 191 */         return false; 
/* 192 */       return true;
/*     */     }
/*     */     
/*     */     public void failShort(int tx, int ty) {
/* 196 */       SComponent c = ((SCompNLevel)(SETT.PATH()).comps.levels.get(0)).get(tx, ty);
/* 197 */       if (c == null)
/*     */         return; 
/* 199 */       this.tryShort.set(c.index(), true);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResourceStore.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */