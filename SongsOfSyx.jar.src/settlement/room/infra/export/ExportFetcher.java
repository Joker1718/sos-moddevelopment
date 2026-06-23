/*     */ package settlement.room.infra.export;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExportFetcher
/*     */ {
/*     */   private final ROOM_EXPORT b;
/*     */   
/*     */   ExportFetcher(ROOM_EXPORT b, ExportTally tally) {
/*  20 */     this.b = b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private COORDINATE getReservableSpot(ExportInstance i, int sx, int sy, RESOURCE res) {
/*  26 */     if (!i.is(sx, sy)) {
/*  27 */       sx = i.mX();
/*  28 */       sy = i.mY();
/*     */     } 
/*  30 */     GUTIL.filler().init(this);
/*  31 */     (GUTIL.filler()).filler.set(sx, sy);
/*  32 */     DIR dir = (DIR)DIR.ORTHO.rnd();
/*     */     
/*  34 */     while (GUTIL.filler().hasMore()) {
/*  35 */       COORDINATE c = GUTIL.filler().poll();
/*  36 */       if (reservable(res, c) > 0) {
/*  37 */         GUTIL.filler().done();
/*  38 */         return c;
/*     */       } 
/*     */       
/*  41 */       DIR d = dir;
/*  42 */       for (int k = 0; k < DIR.ORTHO.size(); k++) {
/*  43 */         if (i.is(c, d))
/*  44 */           GUTIL.filler().fill(c, d); 
/*  45 */         d = d.next(2);
/*     */       } 
/*     */     } 
/*     */     
/*  49 */     GUTIL.filler().done();
/*     */     
/*  51 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE getReservableSpot(int sx, int sy, RESOURCE res) {
/*  56 */     ExportInstance ins = (ExportInstance)(SETT.ROOMS()).EXPORT.get(sx, sy);
/*     */     
/*  58 */     if (ins == null || reservable(ins, res) <= 0) {
/*  59 */       ins = null;
/*  60 */       ROOM_EXPORT room = (SETT.ROOMS()).EXPORT;
/*  61 */       if (room.all().size() == 0)
/*  62 */         return null; 
/*  63 */       int r = RND.rInt((SETT.ROOMS()).EXPORT.all().size());
/*  64 */       for (int i = 0; i < room.all().size(); i++) {
/*  65 */         ExportInstance ins2 = (ExportInstance)room.all().get((i + r) % room.all().size());
/*  66 */         if (reservable(ins2, res) > 0) {
/*  67 */           ins = ins2;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*  73 */     if (ins != null) {
/*  74 */       COORDINATE c = getReservableSpot(ins, sx, sy, res);
/*  75 */       if (c == null) {
/*  76 */         GAME.Notify("" + ins.mX() + " " + ins.mX() + " " + ins.mY());
/*     */       }
/*  78 */       return c;
/*     */     } 
/*     */     
/*  81 */     return null;
/*     */   }
/*     */   
/*     */   private int reservable(ExportInstance ins, RESOURCE res) {
/*  85 */     if (res == ins.resource())
/*  86 */       return ins.amount - ins.amountReserved; 
/*  87 */     return 0;
/*     */   }
/*     */   
/*     */   public int reserved(RESOURCE res, COORDINATE c) {
/*  91 */     Crate crate = this.b.crate(c.x(), c.y());
/*  92 */     if (crate == null || crate.resource() != res)
/*  93 */       return 0; 
/*  94 */     return crate.reserved();
/*     */   }
/*     */   
/*     */   public int reservable(RESOURCE res, COORDINATE c) {
/*  98 */     Crate crate = this.b.crate(c.x(), c.y());
/*  99 */     if (crate == null || crate.resource() != res)
/* 100 */       return 0; 
/* 101 */     return crate.amount() - crate.reserved();
/*     */   }
/*     */   
/*     */   public void reserve(RESOURCE res, COORDINATE c, int amount) {
/* 105 */     if (reservable(res, c) < amount)
/* 106 */       throw new RuntimeException(); 
/* 107 */     Crate crate = this.b.crate(c.x(), c.y());
/* 108 */     crate.reservedSet(crate.reserved() + amount);
/*     */   }
/*     */   
/*     */   public void finish(RESOURCE res, COORDINATE c, int amount, TRADE_TYPE type) {
/* 112 */     if (amount > reserved(res, c))
/* 113 */       throw new RuntimeException(); 
/* 114 */     if (amount > 0) {
/* 115 */       Crate crate = this.b.crate(c.x(), c.y());
/* 116 */       crate.reservedSet(crate.reserved() - amount);
/* 117 */       crate.amountSet(crate.amount() - amount);
/* 118 */       FACTIONS.player().res().inc(res, type.rtype, -amount);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void vacate(int tx, int ty, RESOURCE res, int amount) {
/* 125 */     (SETT.THINGS()).resources.create(tx, ty, res, amount);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\ExportFetcher.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */