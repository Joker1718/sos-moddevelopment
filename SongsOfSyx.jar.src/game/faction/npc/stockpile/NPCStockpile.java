/*     */ package game.faction.npc.stockpile;
/*     */ 
/*     */ import game.GameDisposable;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.npc.NPCResource;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.data.DOUBLE;
/*     */ import util.keymap.MAPPED;
/*     */ import util.statistics.HistoryTradable;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
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
/*     */ public class NPCStockpile
/*     */   extends NPCResource
/*     */ {
/*     */   public static final int AVERAGE_PRICE = 400;
/*     */   public static final int GAME_THEORY = 20;
/*     */   static final double PRICE_MAX = 10.0D;
/*     */   static final double PRICE_MIN = 0.1D;
/*     */   private static final double PILE_SIZE = 9.0D;
/*     */   static Updater updater;
/*  48 */   final NPCRes[] resses = new NPCRes[TR.ALL().size()];
/*     */   final FactionNPC f;
/*     */   private final DOUBLE credits;
/*  51 */   private double workforce = 1.0D;
/*     */   
/*  53 */   public final HistoryTradable price = new HistoryTradable(16, (TIMECYCLE)TIME.seasons(), true);
/*  54 */   public final HistoryTradable forSale = new HistoryTradable(16, (TIMECYCLE)TIME.seasons(), true);
/*     */   
/*     */   public NPCStockpile(FactionNPC f, LISTE<NPCResource> all, DOUBLE credits) {
/*  57 */     super(all);
/*  58 */     this.f = f;
/*     */     
/*  60 */     if (updater == null) {
/*  61 */       updater = new Updater();
/*     */     }
/*     */ 
/*     */     
/*  65 */     this.credits = credits;
/*  66 */     for (TRADABLE res : TR.ALL()) {
/*  67 */       this.resses[res.index()] = new NPCRes(this, res);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double creditScore() {
/*  74 */     double aa = this.workforce * 400.0D * RESOURCES.ALL().size();
/*  75 */     aa = (aa + this.credits.getD()) / (aa + 1.0D);
/*  76 */     aa = CLAMP.d(aa, 0.1D, 10.0D);
/*  77 */     return aa;
/*     */   }
/*     */   
/*     */   public double credit() {
/*  81 */     return this.workforce * 400.0D * RESOURCES.ALL().size() + this.credits.getD();
/*     */   }
/*     */   
/*     */   public double workforce() {
/*  85 */     return this.workforce;
/*     */   }
/*     */ 
/*     */   
/*     */   protected SAVABLE saver() {
/*  90 */     return new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/*  94 */           TR.MAP().saver().save((SAVABLE[])NPCStockpile.this.resses, file);
/*  95 */           file.d(NPCStockpile.this.workforce);
/*  96 */           NPCStockpile.this.price.save(file);
/*  97 */           NPCStockpile.this.forSale.save(file);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 102 */           TR.MAP().loader().load((SAVABLE[])NPCStockpile.this.resses, file);
/* 103 */           NPCStockpile.this.workforce = file.d();
/* 104 */           NPCStockpile.this.price.load(file);
/* 105 */           NPCStockpile.this.forSale.load(file);
/*     */         } public void clear() {
/*     */           byte b;
/*     */           int i;
/*     */           NPCRes[] arrayOfNPCRes;
/* 110 */           for (i = (arrayOfNPCRes = NPCStockpile.this.resses).length, b = 0; b < i; ) { NPCRes r = arrayOfNPCRes[b];
/* 111 */             r.clear(); b++; }
/* 112 */            NPCStockpile.this.workforce = 1.0D;
/* 113 */           NPCStockpile.this.price.clear();
/* 114 */           NPCStockpile.this.forSale.clear();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(FactionNPC faction, double seconds) {
/* 121 */     update(faction, seconds, (RD.RACES()).population.get(faction.capitolRegion()) * 0.25D + 0.15D * (RD.RACES()).population.faction().get(faction));
/*     */   }
/*     */   
/*     */   public void update(FactionNPC faction, double seconds, double wf) {
/* 125 */     this.workforce = wf * 9.0D / TR.ALL().size();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 130 */     for (TRADABLE res : TR.ALL()) {
/* 131 */       NPCRes rr = this.resses[res.index()];
/* 132 */       rr.update(res, this.f);
/*     */     } 
/*     */ 
/*     */     
/* 136 */     updater.update(this, seconds * TIME.secondsPerDayI());
/*     */     
/* 138 */     for (TRADABLE res : TR.ALL()) {
/* 139 */       this.price.set((MAPPED)res, Math.round(res(res).priceAt(0)));
/* 140 */       this.forSale.set((MAPPED)res, (int)Math.round(res(res).amount()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void generate(RDRace race, FactionNPC faction, boolean init) {
/* 149 */     saver().clear();
/* 150 */     update(faction, 0.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public NPCRes res(TRADABLE tr) {
/* 155 */     return this.resses[tr.index()];
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\npc\stockpile\NPCStockpile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */