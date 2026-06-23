/*     */ package settlement.room.main.employment;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.type.WGROUP;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.IntegerStack;
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
/*     */ class RaceGroup
/*     */   implements SAVABLE
/*     */ {
/*     */   int target;
/*     */   int current;
/*     */   final IntegerStack possibles;
/*     */   private final RoomEmployments es;
/*     */   private WGROUP group;
/*     */   
/*     */   public RaceGroup(WGROUP group, RoomEmployments es) {
/* 312 */     this.es = es;
/* 313 */     this.possibles = new IntegerStack(es.all.size());
/* 314 */     this.group = group;
/*     */   }
/*     */   
/*     */   void change(int current) {
/* 318 */     this.current += current;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean setWork(Humanoid i, int[] searchI) {
/* 325 */     RoomInstance old = (RoomInstance)(STATS.WORK()).EMPLOYED.get(i);
/*     */     
/* 327 */     if (old != null && old.blueprintI().employment() instanceof RoomEmployment) {
/* 328 */       RoomEmployment ee = (RoomEmployment)old.blueprintI().employment();
/* 329 */       if (ee.employed(this.group) > ee.target.group(this.group)) {
/* 330 */         (STATS.WORK()).EMPLOYED.set(i, null);
/*     */       }
/* 332 */       else if (old.employees().isOverstaffed()) {
/* 333 */         (STATS.WORK()).EMPLOYED.set(i, null);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 339 */     if ((STATS.WORK()).EMPLOYED.get(i) != null) {
/* 340 */       return true;
/*     */     }
/* 342 */     if (this.current >= this.target) {
/* 343 */       return false;
/*     */     }
/*     */     
/* 346 */     while (!this.possibles.isEmpty()) {
/* 347 */       RoomEmployment e = (RoomEmployment)this.es.all.get(this.possibles.pop());
/* 348 */       if (e.employed() < e.neededWorkers() && e.employed(this.group) < e.target.group(this.group)) {
/* 349 */         this.possibles.push(e.index());
/* 350 */         return setWork(i, e, searchI);
/*     */       } 
/*     */     } 
/*     */     
/* 354 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   boolean hasWork(Humanoid i) {
/* 359 */     return (this.current < this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean setWork(Humanoid i, RoomEmployment e, int[] searchI) {
/* 364 */     int am = e.blueprint().instancesSize();
/*     */     
/* 366 */     for (int k = 0; k < am; k++) {
/* 367 */       if (searchI[e.index()] >= am)
/* 368 */         searchI[e.index()] = 0; 
/* 369 */       RoomInstance ins = e.blueprint().getInstance(searchI[e.index()]);
/* 370 */       if (ins.active() && ins.employees().employed() < ins.employees().target()) {
/* 371 */         (STATS.WORK()).EMPLOYED.set(i, ins);
/* 372 */         return true;
/*     */       } 
/* 374 */       searchI[e.index()] = searchI[e.index()] + 1;
/*     */     } 
/*     */ 
/*     */     
/* 378 */     GAME.Notify("oh no!" + String.valueOf((e.blueprint()).info.name) + " " + String.valueOf((i.race()).info.name) + " " + e.target.group(this.group) + " " + e.employed(this.group) + " " + e.employed() + " " + e.neededWorkers());
/* 379 */     for (int ii = 0; ii < am; ii++) {
/* 380 */       RoomInstance ins = e.blueprint().getInstance(ii);
/* 381 */       LOG.ln("" + ins.employees().employed() + "  " + ins.employees().employed());
/*     */     } 
/*     */     
/* 384 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void update() {
/* 389 */     this.possibles.clear();
/* 390 */     for (RoomEmployment p : (SETT.ROOMS()).employment.all) {
/* 391 */       if (p.employed() < p.neededWorkers() && p.employed(this.group) < p.target.group(this.group)) {
/* 392 */         this.possibles.push(p.index());
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 399 */     file.i(this.current);
/* 400 */     file.i(this.target);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 405 */     this.current = file.i();
/* 406 */     this.target = file.i();
/* 407 */     this.possibles.clear();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 412 */     this.current = 0;
/* 413 */     this.target = 0;
/* 414 */     this.possibles.clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\employment\RoomEmployments$RaceGroup.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */