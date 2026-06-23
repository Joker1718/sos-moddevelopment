/*     */ package settlement.path.finders;
/*     */ 
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HGROUP;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.components.SComponent;
/*     */ import settlement.path.path.SPath;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.home.house.HomeInstance;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.throne.THRONE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ 
/*     */ public final class SFinderHome
/*     */   implements SFINDER
/*     */ {
/*  20 */   private Coo current = new Coo();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private HGROUP type;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean findHome(Humanoid h, SPath path) {
/*  31 */     if (h.indu().clas() != HCLASSES.NOBLE() && (STATS.WORK()).EMPLOYED.get(h) == null) {
/*  32 */       HOME hOME = (STATS.HOME()).GETTER.get(h, this);
/*  33 */       if (hOME != null) {
/*  34 */         int i = hOME.serviceX();
/*  35 */         int j = hOME.serviceY();
/*  36 */         return path.requestFull(h.tc(), i, j);
/*     */       } 
/*  38 */       HomeInstance homeInstance = (SETT.ROOMS()).HOME.odd.get(h, this);
/*  39 */       if (homeInstance == null)
/*  40 */         return false; 
/*  41 */       (STATS.HOME()).GETTER.set(h, (HOME)homeInstance);
/*  42 */       int sx = homeInstance.serviceX();
/*  43 */       int sy = homeInstance.serviceY();
/*  44 */       return path.requestFull(h.tc(), sx, sy);
/*     */     } 
/*     */ 
/*     */     
/*  48 */     HOME home = (STATS.HOME()).GETTER.get(h, this);
/*  49 */     if (home != null) {
/*  50 */       if (home.is(h.tc().x(), h.tc().y())) {
/*  51 */         return path.requestFull(h.tc(), h.tc());
/*     */       }
/*  53 */       int sx = home.serviceX();
/*  54 */       int sy = home.serviceY();
/*  55 */       if ((STATS.WORK()).EMPLOYED.get(h) == null) {
/*  56 */         return path.requestFull(h.tc(), sx, sy);
/*     */       }
/*  58 */       this.current.set(sx, sy);
/*     */     } else {
/*     */       
/*  61 */       this.current.set(-1.0D, -1.0D);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  67 */     this.type = HGROUP.get(h);
/*     */     
/*  69 */     if (findP(h, path)) {
/*  70 */       HOME old = (STATS.HOME()).GETTER.get(h, this);
/*  71 */       HOME n = (HOME)(SETT.ROOMS()).HOME.service.get(path.destX(), path.destY());
/*  72 */       if (old != null) {
/*     */         
/*  74 */         if (path.destX() == old.serviceX() && path.destY() == old.serviceY()) {
/*  75 */           return true;
/*     */         }
/*  77 */         (STATS.HOME()).GETTER.set(h, n);
/*     */       }
/*     */       else {
/*     */         
/*  81 */         (STATS.HOME()).GETTER.set(h, n);
/*     */       } 
/*  83 */       return true;
/*     */     } 
/*     */     
/*  86 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean findP(Humanoid h, SPath path) {
/*  91 */     RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(h);
/*  92 */     if (ins == null) {
/*  93 */       if (h.indu().clas() == HCLASSES.NOBLE()) {
/*  94 */         return path.request(THRONE.coo().x(), THRONE.coo().y(), this, 2147483647);
/*     */       }
/*  96 */       return path.request(h.tc().x(), h.tc().y(), this, 2147483647);
/*     */     } 
/*  98 */     COORDINATE c = (SETT.PATH()).finders.finder().findDest(ins, this, 200);
/*  99 */     if (c != null) {
/* 100 */       return path.requestFull(h.tc(), c);
/*     */     }
/* 102 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInComponent(SComponent c, double distance) {
/* 108 */     if ((SETT.PATH()).comps.data.home.has(c, this.type))
/* 109 */       return true; 
/* 110 */     if (c.is((COORDINATE)this.current))
/* 111 */       return true; 
/* 112 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTile(int tx, int ty, int tileNr) {
/* 117 */     if (this.current.isSameAs(tx, ty)) {
/* 118 */       return true;
/*     */     }
/* 120 */     HomeInstance home = (HomeInstance)(SETT.ROOMS()).HOME.service.get(tx, ty);
/* 121 */     if (home == null)
/* 122 */       return false; 
/* 123 */     HGROUP.HTypeBits s = home.availability();
/* 124 */     if (s != null && s.is(this.type))
/* 125 */       return true; 
/* 126 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\finders\SFinderHome.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */