/*     */ package game.battle.thread.order;
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.util.Copyable;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ public class BattleOrderTask implements Copyable<BattleOrderTask> {
/*     */   private DIVTASK task;
/*     */   
/*     */   public BattleOrderTask() {
/*  15 */     this.task = DIVTASK.MOVE;
/*     */   }
/*     */   
/*     */   private int target;
/*     */   private boolean orderedWhenFighting;
/*     */   
/*  21 */   public enum DIVTASK { STOP(false, false),
/*  22 */     MOVE(true, true),
/*  23 */     ATTACK_BUILDING(false, true),
/*  24 */     ATTACK_MELEE(false, true),
/*  25 */     ATTACK_RANGED(false, true),
/*  26 */     CHARGE(false, false);
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean showDest;
/*     */ 
/*     */ 
/*     */     
/*     */     public final boolean showPath;
/*     */ 
/*     */     
/*  37 */     public static final LIST<DIVTASK> all = (LIST<DIVTASK>)new ArrayList((Object[])values());
/*     */     DIVTASK(boolean dest, boolean path) { this.showDest = dest;
/*     */       this.showPath = path; } static {  } }
/*     */    public DIVTASK task() {
/*  41 */     return this.task;
/*     */   }
/*     */   
/*     */   private void set(DIVTASK t, Div div) {
/*  45 */     this.orderedWhenFighting = div.status().isFighting();
/*  46 */     this.task = t;
/*     */   }
/*     */   
/*     */   public void move(Div div) {
/*  50 */     set(DIVTASK.MOVE, div);
/*     */   }
/*     */   
/*     */   public BattleOrderTask stop(Div div) {
/*  54 */     set(DIVTASK.STOP, div);
/*  55 */     return this;
/*     */   }
/*     */   
/*     */   public void attack(int tx, int ty, Div div) {
/*  59 */     this.target = tx | ty << 16;
/*  60 */     set(DIVTASK.ATTACK_BUILDING, div);
/*     */   }
/*     */   
/*     */   public void attackMelee(Div other, Div div) {
/*  64 */     this.target = other.index();
/*  65 */     set(DIVTASK.ATTACK_MELEE, div);
/*     */   }
/*     */   
/*     */   public void attackRanged(Div other, Div div) {
/*  69 */     this.target = other.index();
/*  70 */     set(DIVTASK.ATTACK_RANGED, div);
/*     */   }
/*     */   
/*     */   public void charge(Div div) {
/*  74 */     set(DIVTASK.CHARGE, div);
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*  79 */     file.i(this.task.ordinal());
/*  80 */     file.i(this.target);
/*  81 */     file.bool(this.orderedWhenFighting);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/*  89 */     this.task = (DIVTASK)DIVTASK.all.get(file.i());
/*  90 */     this.target = file.i();
/*  91 */     this.orderedWhenFighting = file.bool();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/*  96 */     this.task = DIVTASK.STOP;
/*  97 */     this.target = 0;
/*  98 */     this.orderedWhenFighting = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void copy(BattleOrderTask toBeCopied) {
/* 103 */     this.task = toBeCopied.task;
/* 104 */     this.target = toBeCopied.target;
/* 105 */     this.orderedWhenFighting = toBeCopied.orderedWhenFighting;
/*     */   }
/*     */   
/*     */   public Div targetDiv() {
/* 109 */     if (this.task != DIVTASK.ATTACK_MELEE && this.task != DIVTASK.ATTACK_RANGED)
/* 110 */       return null; 
/* 111 */     return GAME.ARMIES().division((short)this.target);
/*     */   }
/*     */   
/*     */   public int targetTileX() {
/* 115 */     if (this.task != DIVTASK.ATTACK_BUILDING)
/* 116 */       return -1; 
/* 117 */     return this.target & 0xFFFF;
/*     */   }
/*     */   
/*     */   public int targetTileY() {
/* 121 */     if (this.task != DIVTASK.ATTACK_BUILDING)
/* 122 */       return -1; 
/* 123 */     return this.target >> 16 & 0xFFFF;
/*     */   }
/*     */   
/*     */   public boolean orderedWhenFighting() {
/* 127 */     return this.orderedWhenFighting;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\BattleOrderTask.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */