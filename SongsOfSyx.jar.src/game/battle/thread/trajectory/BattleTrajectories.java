/*     */ package game.battle.thread.trajectory;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.thread.BattleThread;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.thing.projectiles.Trajectory;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BattleTrajectories
/*     */   extends BattleThread
/*     */ {
/*  19 */   private int divI = 0;
/*  20 */   private double currentSecond = TIME.currentSecond();
/*  21 */   private final UpdaterTraj up = new UpdaterTraj();
/*  22 */   private final UpdaterArtillery art = new UpdaterArtillery();
/*     */   
/*  24 */   private final DivTrajectory[] all = new DivTrajectory[(Config.battle()).DIVISIONS_PER_BATTLE];
/*  25 */   private final Request[] request = new Request[(Config.battle()).DIVISIONS_PER_BATTLE];
/*     */   
/*     */   public BattleTrajectories() {
/*  28 */     super(0.016666666666666666D);
/*  29 */     for (int i = 0; i < this.all.length; i++) {
/*  30 */       this.all[i] = new DivTrajectory();
/*  31 */       this.request[i] = new Request();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  37 */     file.i(this.divI); byte b; int i; DivTrajectory[] arrayOfDivTrajectory;
/*  38 */     for (i = (arrayOfDivTrajectory = this.all).length, b = 0; b < i; ) { DivTrajectory t = arrayOfDivTrajectory[b];
/*  39 */       t.save(file); b++; }
/*  40 */      Request[] arrayOfRequest; for (i = (arrayOfRequest = this.request).length, b = 0; b < i; ) { Request r = arrayOfRequest[b];
/*  41 */       r.save(file);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*  46 */   public void load(FileGetter file) throws IOException { this.divI = file.i(); byte b; int i; DivTrajectory[] arrayOfDivTrajectory;
/*  47 */     for (i = (arrayOfDivTrajectory = this.all).length, b = 0; b < i; ) { DivTrajectory t = arrayOfDivTrajectory[b];
/*  48 */       t.load(file); b++; }
/*  49 */      Request[] arrayOfRequest; for (i = (arrayOfRequest = this.request).length, b = 0; b < i; ) { Request r = arrayOfRequest[b];
/*  50 */       r.load(file);
/*     */       b++; }
/*     */      } protected void init() { byte b;
/*     */     int i;
/*     */     DivTrajectory[] arrayOfDivTrajectory;
/*  55 */     for (i = (arrayOfDivTrajectory = this.all).length, b = 0; b < i; ) { DivTrajectory t = arrayOfDivTrajectory[b];
/*  56 */       t.clear(); b++; }
/*  57 */      Request[] arrayOfRequest; for (i = (arrayOfRequest = this.request).length, b = 0; b < i; ) { Request r = arrayOfRequest[b];
/*  58 */       r.clear(); b++; }
/*  59 */      this.currentSecond = TIME.currentSecond(); }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  63 */     this.divI = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void doThreadJob() {
/*  70 */     double curr = TIME.currentSecond();
/*     */     
/*  72 */     double ds = (curr - this.currentSecond) * (Config.battle()).DIVISIONS_PER_BATTLE;
/*  73 */     if (ds > 0.0D) {
/*  74 */       int old = this.divI;
/*  75 */       while (ds > 0.0D) {
/*     */ 
/*     */         
/*  78 */         if (this.divI == (Config.battle()).DIVISIONS_PER_BATTLE) {
/*  79 */           this.art.update();
/*     */         } else {
/*  81 */           DivTrajectory n = this.up.update(this.request[this.divI], GAME.ARMIES().division((short)this.divI), this.all[this.divI]);
/*  82 */           this.all[this.divI] = n;
/*     */         } 
/*  84 */         this.divI++;
/*     */         
/*  86 */         this.divI %= (Config.battle()).DIVISIONS_PER_BATTLE + 1;
/*  87 */         if (this.divI == old)
/*     */           break; 
/*  89 */         ds--;
/*     */       } 
/*  91 */       this.currentSecond = TIME.currentSecond();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Trajectory request(Humanoid h, Div div) {
/*  96 */     int pos = div.reporter.positionSpot(h);
/*     */     
/*  98 */     if ((GAME.BATTLE_THREADS()).trajs.request[div.index()].request(pos, h, div)) {
/*  99 */       return (GAME.BATTLE_THREADS()).trajs.all[div.index()].get(pos, h);
/*     */     }
/* 101 */     return null;
/*     */   }
/*     */   
/*     */   public static void register(Humanoid h, Div div) {
/* 105 */     (GAME.BATTLE_THREADS()).trajs.request[div.index()].request(div.reporter.positionSpot(h), h, div);
/*     */   }
/*     */   
/*     */   public static int trajectories(Div div) {
/* 109 */     return ((GAME.BATTLE_THREADS()).trajs.all[div.index()]).targets;
/*     */   }
/*     */   
/*     */   public static boolean hasPotential(Div div) {
/* 113 */     return ((GAME.BATTLE_THREADS()).trajs.all[div.index()]).potential;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\trajectory\BattleTrajectories.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */