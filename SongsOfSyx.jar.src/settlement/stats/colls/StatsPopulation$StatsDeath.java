/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DataO;
/*     */ import util.data.GETTER_TRANS;
/*     */ import util.data.INT_O;
/*     */ import util.info.INFO;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapD;
/*     */ import util.statistics.HISTORY_COLLECTION;
/*     */ import util.statistics.HistoryRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StatsDeath
/*     */ {
/*     */   private final LIST<PopData> deaths;
/*     */   private final LIST<PopData> enters;
/* 561 */   private double newEntries = 0.0D;
/* 562 */   private double timer = 0.0D;
/*     */   
/*     */   public final GETTER_TRANS.GETTER_TRANSE<Induvidual, CAUSE_ARRIVE> arrive;
/* 565 */   private final RMapD.RMapDTwo<HCLASS, Race> wrongful = new RMapD.RMapDTwo(HCLASSES.MAP(), RACES.map());
/*     */ 
/*     */   
/*     */   StatsDeath(StatsInit init) {
/* 569 */     ArrayList<PopData> deaths = new ArrayList(CAUSE_LEAVES.ALL().size());
/* 570 */     for (CAUSE_LEAVE l : CAUSE_LEAVES.ALL()) {
/* 571 */       deaths.add(new PopData("L_" + l.key, (INFO)l, init, true));
/*     */     }
/*     */     
/* 574 */     this.deaths = (LIST<PopData>)deaths;
/*     */     
/* 576 */     ArrayList<PopData> enters = new ArrayList(CAUSE_ARRIVES.ALL().size());
/* 577 */     for (CAUSE_ARRIVE l : CAUSE_ARRIVES.ALL()) {
/* 578 */       enters.add(new PopData("A_" + l.index(), (INFO)l, init, true));
/*     */     }
/* 580 */     this.enters = (LIST<PopData>)enters;
/*     */     
/* 582 */     if (CAUSE_ARRIVES.ALL().size() > 16) {
/* 583 */       throw new RuntimeException("Change to bigger data");
/*     */     }
/* 585 */     init.count.getClass(); final DataO.DataNibble data = new DataO.DataNibble(init.count, "POP_ARRIVE");
/*     */     
/* 587 */     this.arrive = new GETTER_TRANS.GETTER_TRANSE<Induvidual, CAUSE_ARRIVE>()
/*     */       {
/*     */         public CAUSE_ARRIVE get(Induvidual f)
/*     */         {
/* 591 */           return (CAUSE_ARRIVE)CAUSE_ARRIVES.ALL().get(data.get(f));
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(Induvidual f, CAUSE_ARRIVE t) {
/* 596 */           data.set(f, t.index());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 601 */     init.savers.put("WRONG_DEATH_DATA", this.wrongful);
/*     */     
/* 603 */     init.savers.put("DEATH_MISC", new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/* 607 */             file.d(StatsPopulation.StatsDeath.this.timer);
/* 608 */             file.d(StatsPopulation.StatsDeath.this.newEntries);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 613 */             StatsPopulation.StatsDeath.this.timer = file.d();
/* 614 */             StatsPopulation.StatsDeath.this.newEntries = file.d();
/*     */           }
/*     */ 
/*     */           
/*     */           public void clear() {
/* 619 */             StatsPopulation.StatsDeath.this.timer = 0.0D;
/* 620 */             StatsPopulation.StatsDeath.this.newEntries = 0.0D;
/*     */           }
/*     */         });
/*     */     
/* 624 */     init.upers.add(new StatsInit.StatUpdatable()
/*     */         {
/*     */           
/*     */           public void update(double ds)
/*     */           {
/* 629 */             double d = StatsPopulation.StatsDeath.this.newEntries / 128.0D;
/* 630 */             if (d < 1.0D)
/* 631 */               d = 1.0D; 
/* 632 */             StatsPopulation.StatsDeath.this.newEntries -= d * ds;
/* 633 */             StatsPopulation.StatsDeath.this.newEntries = CLAMP.d(StatsPopulation.StatsDeath.this.newEntries, 0.0D, Double.MAX_VALUE);
/*     */             
/* 635 */             StatsPopulation.StatsDeath.this.timer += ds;
/* 636 */             if (StatsPopulation.StatsDeath.this.timer < TIME.secondsPerDay()) {
/*     */               return;
/*     */             }
/*     */             
/* 640 */             StatsPopulation.StatsDeath.this.timer -= TIME.secondsPerDay();
/* 641 */             for (int ci = 0; ci < HCLASSES.ALL().size(); ci++) {
/* 642 */               HCLASS cc = (HCLASS)HCLASSES.ALL().get(ci);
/* 643 */               for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 644 */                 double c = StatsPopulation.StatsDeath.this.wrongful.get((MAPPED)cc).getD((MAPPED)RACES.all().get(ri));
/*     */                 
/* 646 */                 double d1 = c * 0.1D;
/* 647 */                 if (d1 - (int)d1 > RND.rFloat())
/* 648 */                   d1 = ((int)d1 + 1); 
/* 649 */                 if (d1 < 1.0D)
/* 650 */                   d1 = 1.0D; 
/* 651 */                 c -= d1;
/* 652 */                 c = CLAMP.d(c, 0.0D, c);
/* 653 */                 StatsPopulation.StatsDeath.this.wrongful.get((MAPPED)cc).setD((MAPPED)RACES.all().get(ri), c);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double newEntries() {
/* 664 */     return this.newEntries / 128.0D;
/*     */   }
/*     */   
/*     */   public LIST<PopData> leaves() {
/* 668 */     return this.deaths;
/*     */   }
/*     */   
/*     */   public LIST<PopData> enters() {
/* 672 */     return this.enters;
/*     */   }
/*     */   
/*     */   public void reg(Induvidual i, CAUSE_ARRIVE c) {
/* 676 */     if (c != null) {
/* 677 */       this.arrive.set(i, c);
/* 678 */       ((PopData)this.enters.get(c.index())).inc(i);
/* 679 */       if (c.fromoutside && i.player())
/* 680 */         this.newEntries++; 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void reg(Induvidual i, CAUSE_LEAVE c) {
/* 685 */     if (c != null) {
/* 686 */       ((PopData)this.deaths.get(c.index())).inc(i);
/* 687 */       if (!c.natural) {
/* 688 */         this.wrongful.get((MAPPED)i.hType().parentClass()).incD(i.race(), c.defaultStanding());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class PopData
/*     */   {
/* 695 */     private final HistoryRace[] data = new HistoryRace[HCLASSES.ALL().size()];
/* 696 */     private final HistoryRace total = new HistoryRace(32, (TIMECYCLE)TIME.days(), false);
/*     */     private final INFO info;
/*     */     
/*     */     PopData(String key, INFO info, StatsInit init, boolean save) {
/* 700 */       this.info = info;
/* 701 */       for (int i = 0; i < this.data.length; i++) {
/* 702 */         this.data[i] = new HistoryRace(32, (TIMECYCLE)TIME.days(), false);
/*     */       }
/*     */       
/* 705 */       init.savers.put("POPDATA_" + key, new SAVABLE()
/*     */           {
/*     */             public void save(FilePutter file)
/*     */             {
/* 709 */               HCLASSES.MAP().saver().save((SAVABLE[])StatsPopulation.StatsDeath.PopData.this.data, file);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void load(FileGetter file) throws IOException {
/* 715 */               HCLASSES.MAP().loader().load((SAVABLE[])StatsPopulation.StatsDeath.PopData.this.data, file);
/*     */             } public void clear() {
/*     */               byte b;
/*     */               int i;
/*     */               HistoryRace[] arrayOfHistoryRace;
/* 720 */               for (i = (arrayOfHistoryRace = StatsPopulation.StatsDeath.PopData.this.data).length, b = 0; b < i; ) { HistoryRace r = arrayOfHistoryRace[b];
/* 721 */                 r.clear();
/*     */                 b++; }
/*     */             
/*     */             }
/*     */           });
/*     */     }
/*     */     public HISTORY_COLLECTION<Race> statistics(HCLASS c) {
/* 728 */       if (c == null)
/* 729 */         return (HISTORY_COLLECTION<Race>)this.total; 
/* 730 */       return (HISTORY_COLLECTION<Race>)this.data[c.index()];
/*     */     }
/*     */     
/*     */     void inc(Induvidual i) {
/* 734 */       if (i.player()) {
/* 735 */         this.total.inc(i.race(), 1);
/*     */       }
/* 737 */       this.data[i.clas().index()].inc(i.race(), 1);
/*     */     }
/*     */     
/*     */     public INFO info() {
/* 741 */       return this.info;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsPopulation$StatsDeath.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */