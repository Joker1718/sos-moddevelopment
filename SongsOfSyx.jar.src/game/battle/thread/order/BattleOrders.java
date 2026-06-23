/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.thread.BattleThread;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ public final class BattleOrders
/*     */   extends BattleThread
/*     */ {
/*  16 */   private final BattleOrder[] orders = new BattleOrder[(Config.battle()).DIVISIONS_PER_ARMY * 2];
/*  17 */   private final DivFormationImp[] nexts = new DivFormationImp[(Config.battle()).DIVISIONS_PER_ARMY * 2];
/*  18 */   private final BattleOrderUpdater plans = new BattleOrderUpdater();
/*  19 */   private DivFormationImp tmp = new DivFormationImp();
/*     */ 
/*     */   
/*     */   public BattleOrders() {
/*  23 */     super(0.016666666666666666D);
/*  24 */     for (int i = 0; i < this.orders.length; i++) {
/*  25 */       this.orders[i] = new BattleOrder();
/*  26 */       this.nexts[i] = new DivFormationImp();
/*     */     } 
/*     */   } protected void save(FilePutter file) {
/*     */     byte b;
/*     */     int i;
/*     */     BattleOrder[] arrayOfBattleOrder;
/*  32 */     for (i = (arrayOfBattleOrder = this.orders).length, b = 0; b < i; ) { BattleOrder o = arrayOfBattleOrder[b];
/*  33 */       o.save(file); b++; }
/*  34 */      DivFormationImp[] arrayOfDivFormationImp; for (i = (arrayOfDivFormationImp = this.nexts).length, b = 0; b < i; ) { DivFormationImp f = arrayOfDivFormationImp[b];
/*  35 */       f.save(file); b++; }
/*  36 */      this.plans.save(file);
/*     */   }
/*     */   protected void load(FileGetter file) throws IOException {
/*     */     byte b;
/*     */     int i;
/*     */     BattleOrder[] arrayOfBattleOrder;
/*  42 */     for (i = (arrayOfBattleOrder = this.orders).length, b = 0; b < i; ) { BattleOrder o = arrayOfBattleOrder[b];
/*  43 */       o.load(file); b++; }
/*  44 */      DivFormationImp[] arrayOfDivFormationImp; for (i = (arrayOfDivFormationImp = this.nexts).length, b = 0; b < i; ) { DivFormationImp f = arrayOfDivFormationImp[b];
/*  45 */       f.load(file); b++; }
/*  46 */      this.plans.load(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init() {
/*  52 */     this.plans.clear(); short di;
/*  53 */     for (di = 0; di < this.orders.length; di = (short)(di + 1)) {
/*  54 */       this.orders[di].clear();
/*     */     }
/*  56 */     for (di = 0; di < this.orders.length; di = (short)(di + 1)) {
/*  57 */       update(GAME.ARMIES().division(di));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void doThreadJob() {
/*  63 */     for (short di = 0; di < this.orders.length && 
/*  64 */       this.thread.working(); di = (short)(di + 1))
/*     */     {
/*  66 */       update(GAME.ARMIES().division(di));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void update(Div div) {
/*  72 */     DivFormationImp f = this.plans.update(div, this.orders[div.index()], this.nexts[div.index()]);
/*  73 */     if (f != null) {
/*  74 */       this.tmp.copy(f);
/*  75 */       DivFormationImp oo = this.nexts[div.index()];
/*  76 */       this.nexts[div.index()] = this.tmp;
/*  77 */       this.tmp = oo;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static BattleOrder get(Div div) {
/*  82 */     return (GAME.BATTLE_THREADS()).orders.orders[div.index()];
/*     */   }
/*     */   
/*     */   public static DivFormationImp next(Div div) {
/*  86 */     return (GAME.BATTLE_THREADS()).orders.nexts[div.index()];
/*     */   }
/*     */   
/*     */   public void init(Div div) {
/*  90 */     boolean started = this.thread.working();
/*     */     
/*  92 */     stop();
/*  93 */     (this.orders[div.index()]).dest.get(this.nexts[div.index()]);
/*     */     
/*  95 */     (this.orders[div.index()]).task.set((new BattleOrderTask()).stop(div));
/*  96 */     if (started)
/*  97 */       start(); 
/*     */   }
/*     */   
/*     */   public static void debug(Div div, Str text) {
/* 101 */     BattleOrders s = (GAME.BATTLE_THREADS()).orders;
/* 102 */     s.plans.debug(div, text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\BattleOrders.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */