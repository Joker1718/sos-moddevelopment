/*     */ package settlement.path.finders;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.TILE_STORAGE;
/*     */ import settlement.path.components.FindableDataRes;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.map.MAP_OBJECT;
/*     */ import snake2d.util.sets.Tuple;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SFinderResourceStorage
/*     */ {
/*  24 */   private final RBIT.RBITImp mask = new RBIT.RBITImp();
/*     */   
/*     */   private RESOURCE result;
/*     */   private final SFINDER fin;
/*     */   private final Tuple.TupleImp<COORDINATE, RESOURCE> fres;
/*     */   public MAP_OBJECT<TILE_STORAGE> getter;
/*     */   
/*     */   public void reportPresence(TILE_STORAGE r) {
/*  32 */     if (r.storageIsFindable())
/*  33 */       s().reportPresence(r.x(), r.y(), r.resource()); 
/*     */   }
/*     */   
/*     */   public void reportAbsence(TILE_STORAGE r) {
/*  37 */     if (r.storageIsFindable())
/*  38 */       s().reportAbsence(r.x(), r.y(), r.resource()); 
/*     */   }
/*     */   
/*     */   public boolean has(int sx, int sy, RESOURCE r) {
/*  42 */     return s().has(sx, sy, r.bit);
/*     */   }
/*     */   
/*     */   public boolean has(RESOURCE r) {
/*  46 */     return has(THRONE.coo().x(), THRONE.coo().y(), r);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean has(int sx, int sy, RBIT mask) {
/*  52 */     return s().has(sx, sy, mask);
/*     */   }
/*     */   
/*     */   public RBIT hasMask(int sx, int sy) {
/*  56 */     return s().bits(sx, sy);
/*     */   }
/*     */   
/*     */   private final FindableDataRes s() {
/*  60 */     return (SETT.PATH()).comps.data.storage;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean reserve(COORDINATE start, RESOURCE r, SPath path, int maxdistance) {
/*  71 */     return (reserve(start, r.bit, path, maxdistance) == r);
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE reserve(COORDINATE start, RBIT resMask, SPath path, int maxdistance) {
/*  76 */     if (has(start.x(), start.y(), resMask)) {
/*  77 */       this.mask.clearSet(resMask);
/*     */       
/*  79 */       if (path.request(start.x(), start.y(), this.fin, maxdistance)) {
/*  80 */         reserve(path.destX(), path.destY());
/*  81 */         return this.result;
/*     */       } 
/*     */     } 
/*  84 */     return null;
/*     */   }
/*     */   SFinderResourceStorage() {
/*  87 */     this.fin = new SFINDER()
/*     */       {
/*     */         public boolean isInComponent(SComponent c, double distance)
/*     */         {
/*  91 */           return SFinderResourceStorage.this.s().has(c, (RBIT)SFinderResourceStorage.this.mask);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean isTile(int tx, int ty, int tileNr) {
/*  96 */           Room res = (SETT.ROOMS()).map.get(tx, ty);
/*  97 */           if (res != null) {
/*  98 */             TILE_STORAGE s = res.storage(tx, ty);
/*  99 */             if (s != null && s.storageIsFindable() && s.resource() != null && s.storageReservable() > 0 && SFinderResourceStorage.this.mask.has(s.resource())) {
/* 100 */               SFinderResourceStorage.this.result = s.resource();
/* 101 */               return true;
/*     */             } 
/*     */           } 
/* 104 */           return false;
/*     */         }
/*     */       };
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
/* 119 */     this.fres = new Tuple.TupleImp();
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
/* 199 */     this.getter = new MAP_OBJECT<TILE_STORAGE>()
/*     */       {
/*     */         public TILE_STORAGE get(int tile)
/*     */         {
/* 203 */           throw new RuntimeException();
/*     */         }
/*     */ 
/*     */         
/*     */         public TILE_STORAGE get(int tx, int ty) {
/* 208 */           Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 209 */           if (r != null)
/* 210 */             return r.storage(tx, ty); 
/* 211 */           return null;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public COORDINATE reserve(COORDINATE start, RESOURCE r, int maxdistance) {
/*     */     return reserve(start.x(), start.y(), r, maxdistance);
/*     */   }
/*     */   
/*     */   public COORDINATE reserve(int sx, int sy, RESOURCE r, int maxdistance) {
/*     */     this.mask.clearSet(r.bit);
/*     */     if (reserve(sx, sy, r.bit, maxdistance) != null)
/*     */       return (COORDINATE)this.fres.a; 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public Tuple<COORDINATE, RESOURCE> reserve(int sx, int sy, RBIT r, int maxdistance) {
/*     */     if (!has(sx, sy, r))
/*     */       return null; 
/*     */     this.mask.clearSet(r);
/*     */     COORDINATE c = (SETT.PATH()).finders.finder().findDest(sx, sy, this.fin, maxdistance);
/*     */     if (c != null) {
/*     */       reserve(c.x(), c.y());
/*     */       this.fres.a = c;
/*     */       this.fres.b = this.result;
/*     */       return (Tuple<COORDINATE, RESOURCE>)this.fres;
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public boolean isReservedAndAvailable(COORDINATE reserved, RESOURCE r) {
/*     */     return isReservedAndAvailable(reserved.x(), reserved.y(), r.bIndex());
/*     */   }
/*     */   
/*     */   public boolean isReservedAndAvailable(int x, int y, short r) {
/*     */     Room res = (SETT.ROOMS()).map.get(x, y);
/*     */     if (res != null) {
/*     */       TILE_STORAGE s = res.storage(x, y);
/*     */       return (s != null && s.storageReserved() > 0 && s.resource() != null && s.resource().bIndex() == r);
/*     */     } 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public boolean isReservedAndAvailable(COORDINATE reserved, byte r) {
/*     */     return isReservedAndAvailable(reserved.x(), reserved.y(), r);
/*     */   }
/*     */   
/*     */   public void deposit(COORDINATE reserved, RESOURCE r) {
/*     */     deposit(reserved.x(), reserved.y(), r.bIndex());
/*     */   }
/*     */   
/*     */   public void deposit(int x, int y, short r) {
/*     */     Room res = (SETT.ROOMS()).map.get(x, y);
/*     */     if (res != null) {
/*     */       TILE_STORAGE s = res.storage(x, y);
/*     */       if (s != null && s.storageReserved() > 0 && s.resource().bIndex() == r)
/*     */         s.storageDeposit(1); 
/*     */     } else {
/*     */       GAME.Notify("no resource to pick up at: " + x + " " + y);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void cancelReservation(COORDINATE reserved, byte resourceIndex) {
/*     */     cancelReservation(reserved.x(), reserved.y(), resourceIndex);
/*     */   }
/*     */   
/*     */   public void cancelReservation(int x, int y, short resourceIndex) {
/*     */     Room res = (SETT.ROOMS()).map.get(x, y);
/*     */     if (res != null) {
/*     */       TILE_STORAGE s = res.storage(x, y);
/*     */       if (s != null && s.storageReserved() > 0 && s.resource().bIndex() == resourceIndex)
/*     */         s.storageUnreserve(1); 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void reserve(int tx, int ty) {
/*     */     Room res = (SETT.ROOMS()).map.get(tx, ty);
/*     */     if (res != null) {
/*     */       TILE_STORAGE s = res.storage(tx, ty);
/*     */       if (s != null && s.storageReservable() > 0 && s.resource() == this.result) {
/*     */         s.storageReserve(1);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     throw new RuntimeException();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderResourceStorage.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */