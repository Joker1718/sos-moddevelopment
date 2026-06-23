/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.race.Race;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.room.infra.elderly.ROOM_RESTHOME;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.StatObject;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class Work
/*     */   extends StatObject<RoomInstance>
/*     */   implements StatsInit.StatDisposable
/*     */ {
/*     */   private final INT_O.INT_OE<Induvidual> data;
/*     */   private final STATData stat;
/*     */   
/*     */   Work(StatsInit init) {
/* 306 */     super(StatsWork.¤¤employment, StatsWork.¤¤employmentD);
/* 307 */     init.count.getClass(); this.data = (INT_O.INT_OE<Induvidual>)new DataO.DataInt(init.count, "WORK_WORKI");
/*     */ 
/*     */     
/* 310 */     INT_O.INT_OE<Induvidual> b = new INT_O.INT_OE<Induvidual>()
/*     */       {
/*     */         public int get(Induvidual t)
/*     */         {
/* 314 */           return (t.hType() == HTYPES.GUARD() || (t.hType().isWorks() && StatsWork.Work.this.data.get(t) != 0)) ? 1 : 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Induvidual t) {
/* 319 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Induvidual t) {
/* 324 */           return 1;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(Induvidual t, int i) {}
/*     */       };
/* 334 */     this.stat = new STATData("EMPLOYED", "WORK_WORKI", init, b)
/*     */       {
/*     */         public int pdivider(HCLASS c, Race r, int daysback)
/*     */         {
/* 338 */           if (c == HCLASSES.SLAVE())
/* 339 */             return STATS.POP().pop(r, HTYPES.SLAVE(), daysback); 
/* 340 */           return STATS.POP().pop(r, HTYPES.STUDENT(), daysback) + STATS.POP().pop(r, HTYPES.RECRUIT(), daysback) + STATS.POP().pop(r, HTYPES.GUARD(), daysback) + STATS.POP().pop(r, HTYPES.SUBJECT(), daysback);
/*     */         }
/*     */ 
/*     */         
/*     */         public void addPrivate(Induvidual i) {
/* 345 */           RoomInstance ins = StatsWork.Work.this.get(i);
/*     */ 
/*     */           
/* 348 */           if (ins != null) {
/* 349 */             if (i.hType() == HTYPES.RETIREE()) {
/* 350 */               (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] + (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/*     */             } else {
/* 352 */               (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] + (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/* 353 */             }  (StatsWork.Work.access$2(StatsWork.Work.this)).health.inc(i.hType(), i.race(), (int)((ins.blueprintI().employment()).healthFactor * 256.0D), -1);
/*     */           } else {
/* 355 */             StatsWork.Work.this.data.set(i, 0);
/*     */           } 
/* 357 */           super.addPrivate(i);
/*     */         }
/*     */ 
/*     */         
/*     */         public void removePrivate(Induvidual i) {
/* 362 */           RoomInstance ins = StatsWork.Work.this.get(i);
/* 363 */           if (ins != null) {
/* 364 */             if (i.hType() == HTYPES.RETIREE()) {
/* 365 */               (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fRetvalues[i.popCL().index()] - (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/*     */             } else {
/* 367 */               (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] = (StatsWork.Work.access$2(StatsWork.Work.this)).fvalues[i.popCL().index()] - (int)(i.race().pref().getWork(ins.blueprintI().employment()) * 256.0D);
/* 368 */             }  (StatsWork.Work.access$2(StatsWork.Work.this)).health.inc(i.hType(), i.race(), -((int)((StatsWork.Work.this.get(i).blueprintI().employment()).healthFactor * 256.0D)), -1);
/*     */           } 
/*     */ 
/*     */           
/* 372 */           super.removePrivate(i);
/*     */         }
/*     */       };
/*     */     
/* 376 */     (this.stat.info()).icon = (SPRITE)(UI.icons()).m.workshop;
/*     */     
/* 378 */     init.disposable.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public RoomInstance get(Induvidual f) {
/* 384 */     int i = this.data.get(f);
/* 385 */     if (i > 0)
/* 386 */       return (RoomInstance)(SETT.ROOMS()).map.getByIndex(i - 1); 
/* 387 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose(Humanoid h) {
/* 392 */     set(h, (RoomInstance)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Humanoid h, RoomInstance t) {
/* 398 */     if (t != null && (
/* 399 */       !t.employees().active() || !t.active())) {
/* 400 */       GAME.Notify("shit!");
/*     */     }
/*     */ 
/*     */     
/* 404 */     HOME home = (STATS.HOME()).GETTER.get(h, this);
/* 405 */     (STATS.HOME()).GETTER.set(h, null);
/*     */     
/* 407 */     Induvidual f = h.indu();
/*     */     
/* 409 */     if (!f.added())
/* 410 */       throw new RuntimeException(); 
/* 411 */     this.stat.removeH(f);
/* 412 */     if (get(f) != null) {
/* 413 */       get(f).employees().fire(h);
/*     */     }
/* 415 */     if (t != null) {
/* 416 */       StatsWork.this.profession.set(f, t.blueprintI());
/* 417 */       this.data.set(f, t.index() + 1);
/* 418 */       t.employees().employ(h);
/*     */     } else {
/*     */       
/* 421 */       this.data.set(f, 0);
/*     */     } 
/*     */     
/* 424 */     this.stat.addH(f);
/*     */     
/* 426 */     setData(f, t);
/* 427 */     if (home != null) {
/*     */       
/* 429 */       if (home.canOccupy(h) && (
/* 430 */         get(f) != null || home.occupants() < home.occupantsMax())) {
/* 431 */         (STATS.HOME()).GETTER.set(h, home);
/*     */       }
/*     */     } else {
/* 434 */       (STATS.HOME()).GETTER.hasSearched.indu().set(f, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void setData(Induvidual f, RoomInstance t) {
/* 440 */     StatsWork.this.RET.RETIREMENT_HOME_ACCESS.indu().setD(f, 0.0D);
/* 441 */     StatsWork.this.RET.RETIREMENT_HOME_QUALITY.indu().setD(f, 0.0D);
/* 442 */     StatsWork.this.RET.RETIREMENT_HOME_TYPE.indu().setD(f, 0.0D);
/* 443 */     if (t == null) {
/*     */       return;
/*     */     }
/* 446 */     if (f.hType() == HTYPES.RETIREE() && t.blueprint() instanceof ROOM_RESTHOME) {
/* 447 */       StatsWork.this.RET.RETIREMENT_HOME_ACCESS.indu().setD(f, 1.0D);
/* 448 */       StatsWork.this.RET.RETIREMENT_HOME_QUALITY.indu().setD(f, ((ROOM_RESTHOME)t.blueprint()).quality(t));
/* 449 */       StatsWork.this.RET.RETIREMENT_HOME_TYPE.indu().setD(f, f.race().pref().getWork(t.blueprintI().employment()));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public STAT stat() {
/* 456 */     return (STAT)this.stat;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsWork$Work.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */