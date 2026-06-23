/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.util.Copyable;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ 
/*     */ 
/*     */ public class BattleOrder
/*     */ {
/*  13 */   public final Locked<BattleOrderPath> path = new Locked<>(new BattleOrderPath());
/*  14 */   public final Locked<DivFormationImp> dest = new Locked<>(new DivFormationImp());
/*  15 */   public final Locked<BattleOrderTask> task = new Locked<>(new BattleOrderTask());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void save(FilePutter file) {
/*  22 */     this.path.save(file);
/*  23 */     this.dest.save(file);
/*  24 */     this.task.save(file);
/*     */   }
/*     */   
/*     */   void load(FileGetter file) throws IOException {
/*  28 */     this.path.load(file);
/*  29 */     this.dest.load(file);
/*  30 */     this.task.load(file);
/*     */   }
/*     */ 
/*     */   
/*     */   void clear() {
/*  35 */     this.path.clear();
/*  36 */     this.dest.clear();
/*  37 */     this.task.clear();
/*     */   }
/*     */   
/*     */   public static class Locked<T extends Copyable<T>>
/*     */     implements SAVABLE
/*     */   {
/*     */     private volatile boolean hasNew;
/*     */     private volatile boolean lock;
/*  45 */     private volatile int setI = 0;
/*     */     private final T t;
/*     */     
/*     */     Locked(T t) {
/*  49 */       this.t = t;
/*     */     } private synchronized void lock() {
/*     */       do {
/*     */       
/*  53 */       } while (this.lock);
/*     */       
/*  55 */       this.lock = true;
/*     */     }
/*     */     
/*     */     public void get(T to) {
/*  59 */       lock();
/*  60 */       to.copy(this.t);
/*  61 */       this.lock = false;
/*     */     }
/*     */     
/*     */     public void set(T from) {
/*  65 */       lock();
/*  66 */       this.t.copy(from);
/*  67 */       this.setI++;
/*  68 */       this.lock = false;
/*  69 */       this.hasNew = true;
/*     */     }
/*     */     
/*     */     public boolean consumeNew(T copyTo) {
/*  73 */       if (this.hasNew) {
/*  74 */         get(copyTo);
/*  75 */         this.hasNew = false;
/*  76 */         return true;
/*     */       } 
/*  78 */       return false;
/*     */     }
/*     */     
/*     */     public int setI() {
/*  82 */       return this.setI;
/*     */     }
/*     */     
/*     */     public boolean isNew(short i) {
/*  86 */       return ((short)(this.setI & 0xFFFF) != i);
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/*  91 */       this.t.save(file);
/*  92 */       file.i(this.setI);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/*  97 */       this.t.load(file);
/*  98 */       this.setI = file.i();
/*  99 */       this.hasNew = false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 104 */       this.t.clear();
/* 105 */       this.setI = 0;
/* 106 */       this.hasNew = false;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\BattleOrder.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */