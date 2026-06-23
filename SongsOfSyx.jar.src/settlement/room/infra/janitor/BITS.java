/*     */ package settlement.room.infra.janitor;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import java.io.Serializable;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.Bitsmap1D;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class BITS
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 2L;
/*  21 */   private Bitsmap1D resAms = new Bitsmap1D(0, 5, RESOURCES.ALL().size());
/*  22 */   private final RBIT.RBITImp bitsAvailable = new RBIT.RBITImp();
/*  23 */   private final RBIT.RBITImp bitsHaveEnough = new RBIT.RBITImp();
/*  24 */   private final RBIT.RBITImp bitsHaveAny = new RBIT.RBITImp();
/*  25 */   private final RBIT.RBITImp bitsTimedOut = new RBIT.RBITImp();
/*  26 */   private final RBIT.RBITImp bitsIsFetching = new RBIT.RBITImp();
/*  27 */   private final RBIT.RBITImp bitsMissing = new RBIT.RBITImp();
/*  28 */   Bitsmap1D fetchAms = new Bitsmap1D(0, 5, RESOURCES.ALL().size());
/*     */   
/*     */   public int resAm(RESOURCE res) {
/*  31 */     return this.resAms.get(res.index());
/*     */   }
/*     */   
/*     */   public RBIT.RBITImp resHave() {
/*  35 */     return this.bitsAvailable;
/*     */   }
/*     */ 
/*     */   
/*     */   public void resSetMissing(RBIT resourceMask) {
/*  40 */     this.bitsMissing.or(resourceMask);
/*  41 */     this.bitsTimedOut.or(resourceMask);
/*     */   }
/*     */   
/*     */   public boolean resMissing(RESOURCE res) {
/*  45 */     return (this.bitsMissing.has(res) && !this.bitsIsFetching.has(res));
/*     */   }
/*     */   
/*     */   public void resInc(JanitorInstance ins, RESOURCE res, int am) {
/*  49 */     am = CLAMP.i(this.resAms.get(res.index()) + am, 0, this.resAms.maxValue());
/*  50 */     this.resAms.set(res.index(), am);
/*     */     
/*  52 */     if (this.resAms.get(res.index()) > 0) {
/*  53 */       this.bitsAvailable.or(res);
/*  54 */       this.bitsMissing.clear(res);
/*  55 */       this.bitsTimedOut.clear(res);
/*     */     } else {
/*  57 */       this.bitsAvailable.clear(res);
/*     */     } 
/*     */     
/*  60 */     double ma = maxAm(ins, res);
/*     */     
/*  62 */     this.bitsHaveEnough.set(res, (this.resAms.get(res.index()) > ma));
/*  63 */     this.bitsHaveAny.set(res, (this.resAms.get(res.index()) > 0 && (this.resAms.get(res.index()) + this.fetchAms.get(res.index()) * 4) > ma / 2.0D));
/*  64 */     this.bitsIsFetching.set(res, ((this.resAms.get(res.index()) + this.fetchAms.get(res.index()) * 4) >= ma));
/*     */   }
/*     */   
/*     */   public int maxAm(JanitorInstance ins, RESOURCE res) {
/*  68 */     int max = ins.employees().employed();
/*  69 */     max = (int)(max * SETT.MAINTENANCE().estimateGlobal(res));
/*  70 */     return CLAMP.i(max, 4, this.resAms.maxValue() - 3);
/*     */   }
/*     */   
/*  73 */   private static final RBIT.RBITImp tmp = new RBIT.RBITImp();
/*     */   
/*     */   public RBIT.RBITImp resMaskFetcher(RoomInstance ins) {
/*  76 */     tmp.clearSet((SETT.PATH()).finders.maintenance.mask(ins.mX(), ins.mY()));
/*  77 */     tmp.xor((RBIT)this.bitsIsFetching);
/*  78 */     tmp.xor((RBIT)this.bitsHaveEnough);
/*  79 */     tmp.xor((RBIT)this.bitsTimedOut);
/*  80 */     return tmp;
/*     */   }
/*     */   
/*     */   public RBIT.RBITImp resMaskFetcherMust(RoomInstance ins) {
/*  84 */     tmp.clearSet((SETT.PATH()).finders.maintenance.mask(ins.mX(), ins.mY()));
/*  85 */     tmp.xor((RBIT)this.bitsIsFetching);
/*  86 */     tmp.xor((RBIT)this.bitsHaveEnough);
/*  87 */     tmp.xor((RBIT)this.bitsTimedOut);
/*  88 */     tmp.xor((RBIT)this.bitsHaveAny);
/*  89 */     return tmp;
/*     */   }
/*     */   
/*     */   public RBIT.RBITImp resMaskWorker(RoomInstance ins) {
/*  93 */     tmp.clearSet((SETT.PATH()).finders.maintenance.mask(ins.mX(), ins.mY()));
/*  94 */     tmp.xor((RBIT)this.bitsIsFetching);
/*  95 */     tmp.xor((RBIT)this.bitsHaveAny);
/*  96 */     tmp.xor((RBIT)this.bitsTimedOut);
/*  97 */     return tmp;
/*     */   }
/*     */   
/*     */   void update() {
/* 101 */     this.bitsTimedOut.clear();
/*     */   }
/*     */   
/*     */   public boolean resReserved(RESOURCE res) {
/* 105 */     return (this.fetchAms.get(res.index()) > 0);
/*     */   }
/*     */   
/*     */   public void resReserve(JanitorInstance ins, RESOURCE res, boolean yes) {
/* 109 */     if (yes) {
/* 110 */       this.fetchAms.inc(res.index(), 1);
/*     */     } else {
/* 112 */       this.fetchAms.inc(res.index(), -1);
/*     */     } 
/* 114 */     this.bitsIsFetching.set(res, (this.resAms.get(res.index()) + this.fetchAms.get(res.index()) * 4 >= maxAm(ins, res)));
/*     */   }
/*     */ 
/*     */   
/*     */   void hover(GBox b, RESOURCE res, RoomInstance ins) {
/* 119 */     b.text("avai");
/* 120 */     b.add((SPRITE)b.text().add(this.bitsAvailable.has(res)));
/* 121 */     b.NL();
/* 122 */     b.text("max");
/* 123 */     b.add((SPRITE)b.text().add(maxAm((JanitorInstance)ins, res)));
/* 124 */     b.NL();
/*     */     
/* 126 */     b.text("enough");
/* 127 */     b.add((SPRITE)b.text().add(this.bitsHaveEnough.has(res)));
/* 128 */     b.NL();
/* 129 */     b.text("timed");
/* 130 */     b.add((SPRITE)b.text().add(this.bitsTimedOut.has(res)));
/* 131 */     b.NL();
/* 132 */     b.text("fetchReserved");
/* 133 */     b.add((SPRITE)b.text().add(this.fetchAms.get(res.index())));
/* 134 */     b.NL();
/* 135 */     b.text("isFetching");
/* 136 */     b.add((SPRITE)b.text().add(this.bitsIsFetching.has(res)));
/* 137 */     b.NL();
/* 138 */     b.text("missing");
/* 139 */     b.add((SPRITE)b.text().add(this.bitsMissing.has(res)));
/* 140 */     b.NL();
/* 141 */     b.text("globalHas");
/* 142 */     b.add((SPRITE)b.text().add((SETT.PATH()).finders.maintenance.mask(ins.mX(), ins.mY()).has(res)));
/* 143 */     b.NL();
/* 144 */     b.text("fetch");
/* 145 */     b.add((SPRITE)b.text().add(resMaskFetcher(ins).has(res)));
/* 146 */     b.NL();
/* 147 */     b.text("fetch work");
/* 148 */     b.add((SPRITE)b.text().add(resMaskWorker(ins).has(res)));
/* 149 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\BITS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */