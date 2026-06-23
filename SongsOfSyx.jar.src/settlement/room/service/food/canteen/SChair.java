/*     */ package settlement.room.service.food.canteen;
/*     */ 
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ class SChair
/*     */ {
/*     */   public static final int I = 3;
/*     */   private final ROOM_CANTEEN b;
/*  18 */   private final Coo res = new Coo();
/*     */   
/*     */   SChair(ROOM_CANTEEN b) {
/*  21 */     this.b = b;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE get(int sx, int sy) {
/*  26 */     CanteenInstance ins = (CanteenInstance)this.b.getter.get(sx, sy);
/*  27 */     if (ins == null) {
/*  28 */       return null;
/*     */     }
/*     */     
/*  31 */     int tx = ins.tableX;
/*  32 */     int ty = ins.tableY;
/*     */     
/*  34 */     if (tx == -1) {
/*  35 */       return null;
/*     */     }
/*  37 */     int a = ins.body().width() * ins.body().height();
/*     */     
/*  39 */     for (int i = 0; i < a; i++) {
/*     */       
/*  41 */       if (ins.is(tx, ty))
/*     */       {
/*     */         
/*  44 */         if ((SETT.ROOMS()).fData.tileData.get(tx, ty) == 3 && 
/*  45 */           (SETT.ROOMS()).data.get(tx, ty) == 0) {
/*  46 */           ins.tableX = (short)tx;
/*  47 */           ins.tableY = (short)ty;
/*  48 */           return ret(ins, tx, ty);
/*     */         } 
/*     */       }
/*     */       
/*  52 */       tx++;
/*  53 */       if (tx >= ins.body().x2()) {
/*  54 */         tx = ins.body().x1();
/*  55 */         ty++;
/*  56 */         if (ty >= ins.body().y2()) {
/*  57 */           ty = ins.body().y1();
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  62 */     ins.tableX = -1;
/*  63 */     ins.tableY = -1;
/*  64 */     return null;
/*     */   }
/*     */   
/*     */   COORDINATE ret(CanteenInstance ins, int x, int y) {
/*  68 */     ins.tableX = (short)x;
/*  69 */     ins.tableY = (short)y;
/*  70 */     (SETT.ROOMS()).data.set((ROOMA)ins, x, y, 1);
/*  71 */     this.res.set(x, y);
/*  72 */     return (COORDINATE)this.res;
/*     */   }
/*     */   
/*     */   public DIR set(int tx, int ty, int mealData) {
/*  76 */     CanteenInstance ins = (CanteenInstance)this.b.getter.get(tx, ty);
/*  77 */     if (ins == null)
/*  78 */       return null; 
/*  79 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) != 3) {
/*  80 */       return null;
/*     */     }
/*     */     
/*  83 */     COORDINATE u = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, Coo.TMP);
/*  84 */     int ux = u.x();
/*  85 */     int uy = u.y();
/*     */     
/*  87 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/*  88 */       DIR d = (DIR)DIR.ORTHO.get(di);
/*  89 */       if (ins.is(tx, ty, d) && (SETT.ROOMS()).fData.tileData.get(tx, ty, d) != 3 && (SETT.ROOMS()).fData.tile.get(tx, ty, d) != null) {
/*  90 */         u = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, d, Coo.TMP);
/*  91 */         if (u != null && u.isSameAs(ux, uy)) {
/*  92 */           (SETT.ROOMS()).data.set((ROOMA)ins, tx, ty, d, mealData);
/*  93 */           return d;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     return null;
/*     */   }
/*     */   
/*     */   void returnTable(int tx, int ty) {
/* 102 */     CanteenInstance ins = (CanteenInstance)this.b.getter.get(tx, ty);
/* 103 */     if (ins == null)
/*     */       return; 
/* 105 */     if ((SETT.ROOMS()).fData.tileData.get(tx, ty) != 3) {
/*     */       return;
/*     */     }
/* 108 */     (SETT.ROOMS()).data.set((ROOMA)ins, tx, ty, 0);
/* 109 */     COORDINATE u = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, Coo.TMP);
/* 110 */     int ux = u.x();
/* 111 */     int uy = u.y();
/*     */     
/* 113 */     for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 114 */       DIR d = (DIR)DIR.ORTHO.get(di);
/* 115 */       if ((SETT.ROOMS()).fData.tileData.get(tx, ty, d) != 3 && (SETT.ROOMS()).fData.tile.get(tx, ty, d) != null) {
/* 116 */         u = (SETT.ROOMS()).fData.itemX1Y1(tx, ty, d, Coo.TMP);
/* 117 */         if (u != null && u.isSameAs(ux, uy)) {
/* 118 */           (SETT.ROOMS()).data.set((ROOMA)ins, tx, ty, d, 0);
/* 119 */           if (ins.tableX == -1) {
/* 120 */             ins.tableX = (short)ins.body().x1();
/* 121 */             ins.tableY = (short)ins.body().y1();
/*     */           } 
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void render(SPRITE_RENDERER r, ShadowBatch s, int rotMask, RenderData.RenderIterator it, int am, RESOURCE res) {
/* 131 */     rotMask &= 0xF;
/*     */     
/* 133 */     DIR d = DIR.N;
/* 134 */     for (int i = 0; i < DIR.ORTHO.size() && (
/* 135 */       rotMask | d.mask()) != 15; i++)
/*     */     {
/* 137 */       d = d.next(2);
/*     */     }
/*     */     
/* 140 */     int x1 = 16 * d.x();
/* 141 */     int y1 = 16 * d.y();
/*     */ 
/*     */     
/* 144 */     int dd = 0;
/*     */     
/* 146 */     while (am-- > 0) {
/* 147 */       int ddd = dd / 3;
/* 148 */       int dddd = dd % 3;
/* 149 */       int x = -d.x() * ddd + d.y() * (-1 + dddd);
/* 150 */       int y = -d.y() * ddd + d.x() * (-1 + dddd);
/* 151 */       am--;
/* 152 */       dd++;
/* 153 */       it.setOff(x1 + x * 32 / 2, y1 + y * 32 / 2);
/* 154 */       this.b.constructor.renderDish(r, s, res, it, it.ran());
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\food\canteen\SChair.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */