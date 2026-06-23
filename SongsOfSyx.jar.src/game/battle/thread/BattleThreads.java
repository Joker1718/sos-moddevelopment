/*     */ package game.battle.thread;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.general.Strategos2000;
/*     */ import game.battle.thread.order.BattleOrders;
/*     */ import game.battle.thread.position.DivCentres;
/*     */ import game.battle.thread.status.BattleStatus;
/*     */ import game.battle.thread.trajectory.BattleTrajectories;
/*     */ import game.debug.Profiler;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import view.interrupter.IDebugPanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BattleThreads
/*     */   extends GAME.GameResource
/*     */ {
/*  30 */   public final BattleStatus status = new BattleStatus();
/*  31 */   public final DivCentres centres = new DivCentres();
/*  32 */   public final BattleTrajectories trajs = new BattleTrajectories();
/*  33 */   public final BattleOrders orders = new BattleOrders();
/*  34 */   public final Strategos2000 strat = new Strategos2000();
/*  35 */   private final ArrayList<BattleThread> threads = new ArrayList((Object[])new BattleThread[] { (BattleThread)this.orders, (BattleThread)this.centres, (BattleThread)this.status, (BattleThread)this.trajs, (BattleThread)this.strat });
/*     */   private boolean started = false;
/*     */   
/*     */   public BattleThreads(GAME game) {
/*  39 */     super("BATTLE_THREADS");
/*     */     
/*  41 */     GAME.addBeforeGameStarts(new ACTION()
/*     */         {
/*     */           public void exe() {
/*  44 */             if (!BattleThreads.this.started)
/*  45 */               BattleThreads.this.unpause(true); 
/*     */           }
/*     */         });
/*  48 */     GAME.saver().onAfterLoad(new ACTION.ACTION_O<Path>()
/*     */         {
/*     */           public void exe(Path t)
/*     */           {
/*  52 */             boolean s = BattleThreads.this.started;
/*     */             
/*  54 */             BattleThreads.this.centres.init();
/*  55 */             BattleThreads.this.status.init();
/*     */             
/*  57 */             if (s) {
/*  58 */               BattleThreads.this.unpause(false);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/*  63 */     IDebugPanel.add("battle threads pause", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  67 */             BattleThreads.this.pause();
/*     */           }
/*     */         });
/*  70 */     IDebugPanel.add("battle threads unpause", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  74 */             if (BattleThreads.this.started)
/*  75 */               BattleThreads.this.pause(); 
/*  76 */             BattleThreads.this.unpause(true);
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public void initAndTeleport(LIST<Div> divs) {
/*  82 */     boolean s = this.started;
/*  83 */     pause();
/*  84 */     for (Div d : divs) {
/*  85 */       this.orders.init(d);
/*     */     }
/*  87 */     Bitmap1D map = new Bitmap1D((Config.battle()).DIVISIONS_PER_BATTLE, false);
/*  88 */     for (Div d : divs)
/*  89 */       map.set(d.index(), true);  byte b; int i;
/*     */     ENTITY[] arrayOfENTITY;
/*  91 */     for (i = (arrayOfENTITY = SETT.ENTITIES().getAllEnts()).length, b = 0; b < i; ) { ENTITY e = arrayOfENTITY[b];
/*  92 */       if (e instanceof Humanoid) {
/*  93 */         Humanoid a = (Humanoid)e;
/*  94 */         if (a.division() != null && map.get(a.division().index()))
/*  95 */           a.teleportAndInitInDiv(); 
/*     */       }  b++; }
/*     */     
/*  98 */     this.centres.init();
/*  99 */     this.status.init();
/* 100 */     this.trajs.init();
/* 101 */     this.strat.init();
/* 102 */     if (s) {
/* 103 */       unpause(false);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds, Profiler prof) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/* 116 */     boolean started = this.started;
/* 117 */     pause();
/* 118 */     for (BattleThread t : this.threads) {
/* 119 */       t.save(file);
/*     */     }
/* 121 */     file.bool(started);
/* 122 */     if (started) {
/* 123 */       unpause(false);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 129 */     for (BattleThread t : this.threads) {
/* 130 */       t.load(file);
/*     */     }
/* 132 */     this.started = file.bool();
/*     */   }
/*     */   
/*     */   public void pause() {
/* 136 */     this.started = false;
/* 137 */     for (BattleThread t : this.threads) {
/* 138 */       t.stop();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void unpause(boolean init) {
/* 144 */     this.started = true;
/* 145 */     for (BattleThread t : this.threads) {
/* 146 */       if (init)
/* 147 */         t.init(); 
/* 148 */       t.start();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void loadFail() {
/* 155 */     boolean s = this.started;
/* 156 */     pause();
/* 157 */     for (BattleThread t : this.threads) {
/* 158 */       t.init();
/*     */     }
/* 160 */     if (s)
/* 161 */       unpause(true); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\BattleThreads.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */