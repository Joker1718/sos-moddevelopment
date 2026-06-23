/*     */ package settlement.room.spirit.grave;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DOUBLE_O;
/*     */ import util.info.INFO;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GraveDataClass
/*     */ {
/* 464 */   private final double[] burr = new double[RACES.all().size()]; private final HCLASS cl; final SAVABLE saver; public DOUBLE_O<Race> burried;
/* 465 */   private final double[] fails = new double[RACES.all().size()];
/*     */   
/*     */   public DOUBLE_O<Race> failed;
/*     */   
/*     */   public DOUBLE_O<Race> value;
/*     */   
/*     */   GraveDataClass(HCLASS cl) {
/* 472 */     this.saver = new SAVABLE()
/*     */       {
/*     */         public void save(FilePutter file)
/*     */         {
/* 476 */           file.ds(GraveData.GraveDataClass.this.burr);
/* 477 */           file.ds(GraveData.GraveDataClass.this.fails);
/*     */         }
/*     */ 
/*     */         
/*     */         public void load(FileGetter file) throws IOException {
/* 482 */           file.ds(GraveData.GraveDataClass.this.burr);
/* 483 */           file.ds(GraveData.GraveDataClass.this.fails);
/*     */         }
/*     */ 
/*     */         
/*     */         public void clear() {
/* 488 */           Arrays.fill(GraveData.GraveDataClass.this.burr, 0.0D);
/* 489 */           Arrays.fill(GraveData.GraveDataClass.this.fails, 0.0D);
/*     */         }
/*     */       };
/*     */     
/* 493 */     this.burried = new DOUBLE_O<Race>()
/*     */       {
/* 495 */         private final INFO info = new INFO(GraveData.¤¤Burried, GraveData.¤¤BurriedD);
/*     */ 
/*     */         
/*     */         public double getD(Race t) {
/* 499 */           if (t == null) {
/* 500 */             double m = 0.0D;
/* 501 */             for (Race r : RACES.all()) {
/* 502 */               m += GraveData.GraveDataClass.this.burr[r.index];
/*     */             }
/* 504 */             if (m == 0.0D)
/* 505 */               return 0.0D; 
/* 506 */             return m;
/*     */           } 
/* 508 */           return GraveData.GraveDataClass.this.burr[t.index];
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 513 */           return this.info;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 518 */     this.failed = new DOUBLE_O<Race>()
/*     */       {
/* 520 */         private final INFO info = new INFO(GraveData.¤¤Corpses, GraveData.¤¤CorpsesD);
/*     */ 
/*     */         
/*     */         public double getD(Race t) {
/* 524 */           if (t == null) {
/* 525 */             double m = 0.0D;
/* 526 */             for (Race r : RACES.all()) {
/* 527 */               m += GraveData.GraveDataClass.this.fails[r.index];
/*     */             }
/* 529 */             if (m == 0.0D)
/* 530 */               return 0.0D; 
/* 531 */             return m;
/*     */           } 
/* 533 */           return GraveData.GraveDataClass.this.fails[t.index];
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 538 */           return this.info;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 543 */     this.value = new DOUBLE_O<Race>()
/*     */       {
/* 545 */         private final INFO info = new INFO(GraveData.¤¤Value, GraveData.¤¤ValueD);
/*     */ 
/*     */         
/*     */         public double getD(Race t) {
/* 549 */           if (t == null) {
/* 550 */             double m = 0.0D;
/* 551 */             for (Race r : RACES.all()) {
/* 552 */               m += GraveData.GraveDataClass.this.burr[r.index] * (STATS.POP()).POP.data(GraveData.GraveDataClass.this.cl).get(r);
/*     */             }
/* 554 */             if (m == 0.0D)
/* 555 */               return 0.0D; 
/* 556 */             return m / (STATS.POP()).POP.data(GraveData.GraveDataClass.this.cl).get(null);
/*     */           } 
/*     */           
/* 559 */           double tot = GraveData.GraveDataClass.this.burr[t.index] + GraveData.GraveDataClass.this.fails[t.index];
/* 560 */           double res = 1.0D;
/* 561 */           if (tot != 0.0D)
/* 562 */             res = 1.0D - GraveData.GraveDataClass.this.fails[t.index] / tot; 
/* 563 */           res *= 1.0D - 0.5D * GraveData.GraveDataClass.access$0(GraveData.GraveDataClass.this).blueprint().degradeAverage();
/* 564 */           res *= 0.5D + 0.5D * (GraveData.GraveDataClass.access$0(GraveData.GraveDataClass.this)).respect.getD(null);
/*     */ 
/*     */           
/* 567 */           return CLAMP.d(res, 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         public INFO info() {
/* 572 */           return this.info;
/*     */         }
/*     */       };
/*     */     this.cl = cl;
/*     */   }
/*     */   public void fail(ThingsCorpses.Corpse c, int delta) {
/* 578 */     this.fails[(c.indu().race()).index] = this.fails[(c.indu().race()).index] + delta;
/*     */   }
/*     */   
/*     */   void burry(ThingsCorpses.Corpse c) {
/* 582 */     this.burr[(c.indu().race()).index] = this.burr[(c.indu().race()).index] + 1.0D;
/*     */   }
/*     */   
/*     */   void update() {
/* 586 */     for (Race r : RACES.all()) {
/* 587 */       this.fails[r.index] = this.fails[r.index] - Math.max(this.fails[r.index] * 0.1D, 0.1D);
/* 588 */       if (this.fails[r.index] < 0.0D) {
/* 589 */         this.fails[r.index] = 0.0D;
/*     */       }
/* 591 */       this.burr[r.index] = this.burr[r.index] - Math.max(this.burr[r.index] * 0.1D, 0.1D);
/* 592 */       if (this.burr[r.index] < 0.0D)
/* 593 */         this.burr[r.index] = 0.0D; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\grave\GraveData$GraveDataClass.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */