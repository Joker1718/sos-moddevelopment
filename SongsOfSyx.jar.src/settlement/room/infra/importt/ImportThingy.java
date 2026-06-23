/*     */ package settlement.room.infra.importt;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import settlement.room.main.job.StorageCrate;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.GUTIL;
/*     */ 
/*     */ 
/*     */ public final class ImportThingy
/*     */ {
/*     */   private final ROOM_IMPORT b;
/*     */   private final ImportTally tally;
/*     */   
/*     */   ImportThingy(ROOM_IMPORT imp, ImportTally tally) {
/*  20 */     this.b = imp;
/*  21 */     this.tally = tally;
/*     */   }
/*     */ 
/*     */   
/*     */   public COORDINATE getReservableSpot(int sx, int sy, RESOURCE res) {
/*  26 */     if (this.tally.capacity.get(res) - this.tally.amount.get(res) < 0) {
/*  27 */       return null;
/*     */     }
/*     */ 
/*     */     
/*  31 */     ImportInstance ins = (ImportInstance)this.b.get(sx, sy);
/*  32 */     if (ins == null || ins.resource() != res || reservable(ins) <= 0) {
/*  33 */       ins = null;
/*  34 */       if (this.b.all().size() == 0)
/*  35 */         return null; 
/*  36 */       int r = RND.rInt(this.b.all().size());
/*  37 */       for (int i = 0; i < this.b.all().size(); i++) {
/*  38 */         ImportInstance ins2 = (ImportInstance)this.b.all().get((i + r) % this.b.all().size());
/*  39 */         if (ins2.resource() == res && reservable(ins2) > 0) {
/*  40 */           ins = ins2;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*  46 */     if (ins != null) {
/*  47 */       return getReservableSpot(ins, sx, sy, res);
/*     */     }
/*  49 */     return null;
/*     */   }
/*     */   
/*     */   private COORDINATE getReservableSpot(ImportInstance i, int sx, int sy, RESOURCE res) {
/*  53 */     if (!i.is(sx, sy)) {
/*  54 */       sx = i.mX();
/*  55 */       sy = i.mY();
/*     */     } 
/*  57 */     GUTIL.filler().init(this);
/*  58 */     (GUTIL.filler()).filler.set(sx, sy);
/*  59 */     DIR dir = (DIR)DIR.ORTHO.rnd();
/*  60 */     int q = 0;
/*  61 */     while (GUTIL.filler().hasMore()) {
/*  62 */       COORDINATE c = GUTIL.filler().poll();
/*  63 */       if (reservable(res, c) > 0) {
/*  64 */         GUTIL.filler().done();
/*  65 */         return c;
/*     */       } 
/*  67 */       q++;
/*  68 */       DIR d = dir;
/*  69 */       for (int k = 0; k < DIR.ORTHO.size(); k++) {
/*  70 */         if (i.is(c, d))
/*  71 */           GUTIL.filler().fill(c, d); 
/*  72 */         d = d.next(2);
/*     */       } 
/*     */     } 
/*     */     
/*  76 */     GUTIL.filler().done();
/*  77 */     GAME.Notify("oh no " + String.valueOf(res) + " " + String.valueOf(i.resource()) + " " + q + " " + i.area() + " " + i.mX() + " " + i.mY() + " " + reservable(i));
/*  78 */     return null;
/*     */   }
/*     */   
/*     */   private int reservable(ImportInstance ins) {
/*  82 */     return ins.capacity() - ins.amount() - ins.spaceReserved();
/*     */   }
/*     */   
/*     */   private StorageCrate get(RESOURCE res, COORDINATE c) {
/*  86 */     ImportInstance ins = (ImportInstance)this.b.get(c.x(), c.y());
/*  87 */     if (ins == null) {
/*  88 */       return null;
/*     */     }
/*  90 */     if (ins.resource() != res) {
/*  91 */       return null;
/*     */     }
/*  93 */     return this.b.crate.get(c.x(), c.y(), ins, ins.sdata);
/*     */   }
/*     */   
/*     */   public int reservable(RESOURCE r, COORDINATE c) {
/*  97 */     StorageCrate cr = get(r, c);
/*  98 */     if (cr == null)
/*  99 */       return 0; 
/* 100 */     return cr.storageReservable();
/*     */   }
/*     */ 
/*     */   
/*     */   public void reserve(RESOURCE r, COORDINATE c, int amount) {
/* 105 */     StorageCrate cr = get(r, c);
/* 106 */     if (cr == null)
/* 107 */       throw new RuntimeException(); 
/* 108 */     cr.storageReserve(amount);
/*     */   }
/*     */   
/*     */   public int reserved(RESOURCE r, COORDINATE c) {
/* 112 */     StorageCrate cr = get(r, c);
/* 113 */     if (cr == null)
/* 114 */       return 0; 
/* 115 */     return cr.storageReserved();
/*     */   }
/*     */   
/*     */   public void finish(RESOURCE r, COORDINATE c, int amount, TRADE_TYPE type) {
/* 119 */     StorageCrate cr = get(r, c);
/* 120 */     if (cr == null)
/* 121 */       throw new RuntimeException(); 
/* 122 */     cr.storageDeposit(amount);
/* 123 */     FACTIONS.player().res().inc(r, type.rtype, amount);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\importt\ImportThingy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */