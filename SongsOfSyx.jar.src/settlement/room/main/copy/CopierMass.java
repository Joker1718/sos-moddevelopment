/*     */ package settlement.room.main.copy;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.construction.ConstructionInit;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.placement.PLACEMENT;
/*     */ import settlement.room.main.util.RoomAreaWrapper;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CopierMass
/*     */ {
/*  24 */   private static RoomAreaWrapper wrap = new RoomAreaWrapper();
/*     */ 
/*     */   
/*     */   public boolean isPlacable(int sx, int sy, int dx, int dy) {
/*  28 */     Room r = (SETT.ROOMS()).map.get(sx, sy);
/*  29 */     if (r == null) {
/*  30 */       return false;
/*     */     }
/*  32 */     if (!canCopy(sx, sy)) {
/*  33 */       return false;
/*     */     }
/*  35 */     Furnisher c = r.constructor();
/*     */     
/*  37 */     if (c.placable(dx, dy, (FurnisherItem)(SETT.ROOMS()).fData.item.get(sx, sy), (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(sx, sy)) != null) {
/*  38 */       return false;
/*     */     }
/*  40 */     if (PLACEMENT.placable(dx, dy, c.blue(), true) != null) {
/*  41 */       return false;
/*     */     }
/*  43 */     FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(sx, sy);
/*     */     
/*  45 */     if (it == null) {
/*  46 */       return true;
/*     */     }
/*  48 */     FurnisherItemTile tile = (FurnisherItemTile)(SETT.ROOMS()).fData.tile.get(sx, sy);
/*     */     
/*  50 */     if (tile.mustBeReachable) {
/*  51 */       int bi = 0;
/*  52 */       for (DIR d : DIR.ORTHO) {
/*  53 */         if ((SETT.PLACA()).solidityWill.is(dx, dy, d))
/*  54 */           bi++; 
/*     */       } 
/*  56 */       if (bi == 4) {
/*  57 */         return false;
/*     */       }
/*     */     } 
/*     */     
/*  61 */     return true;
/*     */   }
/*     */   
/*     */   public boolean canCopy(int tx, int ty) {
/*  65 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/*  66 */     if (r == null)
/*  67 */       return false; 
/*  68 */     if (r.blueprint() == (SETT.ROOMS()).THRONE)
/*  69 */       return false; 
/*  70 */     if (r.constructor() == null)
/*  71 */       return false; 
/*  72 */     if (!(r.constructor().blue()).reqs.passes(FACTIONS.player()))
/*  73 */       return false; 
/*  74 */     return r.constructor().canBeCopied();
/*     */   }
/*     */ 
/*     */   
/*     */   public void copy(int rx, int ry, int destCX, int destCY, int rot) {
/*  79 */     Room room = (SETT.ROOMS()).map.get(rx, ry);
/*     */     
/*  81 */     if (room == null || room.constructor() == null || room.constructor().blue() == null) {
/*     */       return;
/*     */     }
/*  84 */     wrap.done();
/*  85 */     ROOMA r = wrap.init(room, rx, ry);
/*     */     
/*  87 */     for (COORDINATE c : r.body()) {
/*  88 */       if (r.is(c)) {
/*  89 */         int dx = c.x() - r.body().cX();
/*  90 */         int dy = c.y() - r.body().cY();
/*  91 */         for (int i = 0; i < rot; i++) {
/*  92 */           int k = dx;
/*  93 */           dx = -dy;
/*  94 */           dy = k;
/*     */         } 
/*  96 */         int x = destCX + dx;
/*  97 */         int y = destCY + dy;
/*  98 */         if (!isPlacable(c.x(), c.y(), x, y)) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 105 */     TmpArea tmp = SETT.ROOMS().tmpArea(this);
/*     */     
/* 107 */     for (COORDINATE c : r.body()) {
/* 108 */       if (r.is(c)) {
/* 109 */         int dx = c.x() - r.body().cX();
/* 110 */         int dy = c.y() - r.body().cY();
/* 111 */         for (int i = 0; i < rot; i++) {
/* 112 */           int k = dx;
/* 113 */           dx = -dy;
/* 114 */           dy = k;
/*     */         } 
/* 116 */         int x = destCX + dx;
/* 117 */         int y = destCY + dy;
/* 118 */         tmp.set(x, y);
/*     */       } 
/*     */     } 
/*     */     
/* 122 */     for (COORDINATE c : r.body()) {
/* 123 */       if (r.is(c)) {
/* 124 */         FurnisherItem it = (FurnisherItem)(SETT.ROOMS()).fData.item.get(c);
/* 125 */         if (it == null)
/*     */           continue; 
/* 127 */         if (!(SETT.ROOMS()).fData.isMaster.is(c)) {
/*     */           continue;
/*     */         }
/* 130 */         COORDINATE ul = (SETT.ROOMS()).fData.itemX1Y1(c.x(), c.y(), Coo.TMP);
/* 131 */         int scx = ul.x() + it.width() / 2;
/* 132 */         int scy = ul.y() + it.height() / 2;
/*     */         
/* 134 */         int dx = scx - r.body().cX();
/* 135 */         int dy = scy - r.body().cY();
/*     */         
/* 137 */         for (int i = 0; i < rot; i++) {
/* 138 */           int k = dx;
/* 139 */           dx = -dy;
/* 140 */           dy = k;
/*     */         } 
/*     */         
/* 143 */         it = it.group.item(it.variation(), (rot + it.rotation) % it.group.rotations());
/* 144 */         int x = destCX + dx - it.width() / 2;
/* 145 */         int y = destCY + dy - it.height() / 2;
/*     */ 
/*     */ 
/*     */         
/* 149 */         (SETT.ROOMS()).fData.itemSet(x + deltaX(it, rot), y + deltaY(it, rot), it, tmp.room());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 154 */     ConstructionInit init = new ConstructionInit(room, r.mX(), r.mY(), false);
/*     */ 
/*     */     
/* 157 */     (SETT.ROOMS()).construction.createClean(tmp, init);
/*     */   }
/*     */   
/*     */   private int deltaX(FurnisherItem it, int rot) {
/* 161 */     if ((it.width() & 0x1) == 0) {
/* 162 */       if (rot == 1)
/* 163 */         return 1; 
/* 164 */       if (rot == 2)
/* 165 */         return 1; 
/*     */     } 
/* 167 */     return 0;
/*     */   }
/*     */   
/*     */   private int deltaY(FurnisherItem it, int rot) {
/* 171 */     if ((it.height() & 0x1) == 0) {
/* 172 */       if (rot == 2)
/* 173 */         return 1; 
/* 174 */       if (rot == 3)
/* 175 */         return 1; 
/*     */     } 
/* 177 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\copy\CopierMass.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */