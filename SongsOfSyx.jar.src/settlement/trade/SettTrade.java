/*     */ package settlement.trade;
/*     */ 
/*     */ import game.VERSION;
/*     */ import game.debug.Profiler;
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RESOURCE;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import init.trade.TRADABLEO;
/*     */ import init.trade.TRADE_TYPE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ public class SettTrade
/*     */   extends SETT.SettResource
/*     */ {
/*  26 */   private final PBuyer[] buyers = new PBuyer[TR.ALL().size()];
/*  27 */   private final PSeller[] sellers = new PSeller[TR.ALL().size()];
/*  28 */   final int[] slavesReserved = Alloc.ii(RACES.all().size());
/*     */ 
/*     */   
/*  31 */   private final IUpdater updater = new IUpdater(TR.ALL().size(), (TIME.secondsPerDay() / 8))
/*     */     {
/*     */       protected void update(int i, double timeSinceLast)
/*     */       {
/*  35 */         SettTrade.this.buyers[i].deliver();
/*  36 */         SettTrade.this.sellers[i].extract();
/*     */       }
/*     */     };
/*     */   
/*     */   public SettTrade() {
/*  41 */     super("TRADE", false);
/*  42 */     for (TRADABLEO<RESOURCE> rr : (Iterable<TRADABLEO<RESOURCE>>)TR.RES()) {
/*  43 */       this.buyers[rr.index()] = new PBuyerRes(rr);
/*  44 */       this.sellers[rr.index()] = new PSellerRes(rr);
/*     */     } 
/*  46 */     for (TRADABLEO<Race> ss : (Iterable<TRADABLEO<Race>>)TR.SLAVES()) {
/*  47 */       this.buyers[ss.index()] = new PBuyerSlave(ss);
/*  48 */       this.sellers[ss.index()] = new PSellerSlave(ss);
/*     */     }  byte b; int i;
/*     */     PBuyer[] arrayOfPBuyer;
/*  51 */     for (i = (arrayOfPBuyer = this.buyers).length, b = 0; b < i; ) { PBuyer pBuyer = arrayOfPBuyer[b];
/*  52 */       if (pBuyer == null)
/*  53 */         throw new RuntimeException("no trade implementation of trade type"); 
/*     */       b++; }
/*     */     
/*  56 */     clear();
/*     */   }
/*     */   
/*     */   public PBuyer buyer(TRADABLE t) {
/*  60 */     return this.buyers[t.index()];
/*     */   }
/*     */   
/*     */   public PSeller seller(TRADABLE t) {
/*  64 */     return this.sellers[t.index()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler profiler) {
/*  70 */     this.updater.update(ds);
/*  71 */     super.update(ds, profiler);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  76 */     TR.MAP().saver().save((SAVABLE[])this.buyers, file);
/*  77 */     TR.MAP().saver().save((SAVABLE[])this.sellers, file);
/*  78 */     this.updater.save(file);
/*  79 */     RACES.map().saver().save(this.slavesReserved, file);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/*  84 */     TR.MAP().loader().load((SAVABLE[])this.buyers, file);
/*  85 */     TR.MAP().loader().load((SAVABLE[])this.sellers, file);
/*  86 */     this.updater.load(file);
/*  87 */     if (VERSION.versionIsBefore(71, 6)) {
/*  88 */       TradableData[] slaveAttempting = new TradableData[RACES.all().size()];
/*  89 */       for (Race r : RACES.all()) {
/*  90 */         slaveAttempting[r.index()] = new TradableData();
/*     */       }
/*  92 */       RACES.map().loader().load((SAVABLE[])slaveAttempting, file);
/*     */     } else {
/*  94 */       RACES.map().loader().load(this.slavesReserved, file, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void clear() {
/* 101 */     for (TRADABLE rr : TR.ALL()) {
/* 102 */       this.buyers[rr.index()].clear();
/* 103 */       this.sellers[rr.index()].clear();
/*     */     } 
/* 105 */     this.updater.clear();
/*     */     
/* 107 */     Arrays.fill(this.slavesReserved, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldLeave(Humanoid h) {
/* 112 */     return (seller((TRADABLE)TR.get(h.race())).promised().get(null) > this.slavesReserved[(h.race()).index]);
/*     */   }
/*     */   
/*     */   public boolean reserveLeave(Humanoid h) {
/* 116 */     if (shouldLeave(h)) {
/*     */       
/* 118 */       this.slavesReserved[(h.race()).index] = this.slavesReserved[(h.race()).index] + 1;
/* 119 */       return true;
/*     */     } 
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public void reserveLeaveCancel(Humanoid h) {
/* 125 */     this.slavesReserved[(h.race()).index] = this.slavesReserved[(h.race()).index] - 1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void leave(Humanoid h) {
/* 130 */     reserveLeaveCancel(h);
/* 131 */     PSeller ss = seller((TRADABLE)TR.get(h.race()));
/*     */     
/* 133 */     for (TRADE_TYPE t : TRADE_TYPE.all) {
/* 134 */       if (ss.promised.get(t) > 0) {
/* 135 */         ss.promised.inc(t, -1);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int tradeCredits(double price, double rate) {
/* 142 */     if (rate == 0.0D)
/* 143 */       return 10000; 
/* 144 */     return (int)(price / rate);
/*     */   }
/*     */   
/*     */   public double tradeValue(double price, double rate) {
/* 148 */     if (rate == 0.0D)
/* 149 */       return 10000.0D; 
/* 150 */     return price / rate * 400.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\trade\SettTrade.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */