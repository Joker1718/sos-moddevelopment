/*     */ package settlement.stats.muls;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.SETT_STATISTICS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.keymap.MAPPED;
/*     */ import util.keymap.RMapInt;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StatMultiplierActionImp
/*     */   extends StatsMultipliers.StatMultiplierAction
/*     */   implements StatsInit.StatUpdatableI
/*     */ {
/*     */   protected final SETT_STATISTICS.SettStatistics active;
/* 682 */   protected final RMapInt.RMapIntTwo<HCLASS, Race> selected = new RMapInt.RMapIntTwo(HCLASSES.MAP(), RACES.map());
/*     */   
/*     */   protected final INT_O.INT_OE<Induvidual> iActive;
/*     */   protected final INT_O.INT_OE<Induvidual> iActiveCount;
/*     */   protected final INT_O.INT_OE<Induvidual> iSelected;
/*     */   
/*     */   private StatMultiplierActionImp(String key, StatsInit init, LISTE<StatsMultipliers.StatMultiplier> all, SPRITE icon, HCLASS... cl) {
/* 689 */     super(key, init, all, 0, 100, icon, cl);
/* 690 */     this.active = new SETT_STATISTICS.SettStatistics("MUL_" + key, init, null);
/* 691 */     init.savers.put(key + "SEL", new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/* 695 */             StatsMultipliers.StatMultiplierActionImp.this.selected.save(file);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/* 701 */             StatsMultipliers.StatMultiplierActionImp.this.selected.load(file);
/* 702 */             StatsMultipliers.StatMultiplierActionImp.this.selected.clear();
/*     */           }
/*     */ 
/*     */           
/*     */           public void clear() {
/* 707 */             StatsMultipliers.StatMultiplierActionImp.this.selected.clear();
/*     */           }
/*     */         });
/* 710 */     this.iActive = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "MUL_" + key + "_ACTIVE");
/* 711 */     this.iActiveCount = (INT_O.INT_OE<Induvidual>)new DataO.DataCrumb(init.count, "MUL_" + key + "_ACOUNT");
/* 712 */     this.iSelected = (INT_O.INT_OE<Induvidual>)new DataO.DataBit(init.count, "MUL_" + key + "_SEL");
/*     */     
/* 714 */     init.addable.add(new StatsInit.Addable()
/*     */         {
/*     */           public void removePrivate(Induvidual i)
/*     */           {
/* 718 */             StatsMultipliers.StatMultiplierActionImp.this.selected.get((MAPPED)i.clas()).inc(i.race(), -StatsMultipliers.StatMultiplierActionImp.this.iSelected.get(i));
/* 719 */             StatsMultipliers.StatMultiplierActionImp.this.active.inc(i, -StatsMultipliers.StatMultiplierActionImp.this.iActive.get(i));
/*     */           }
/*     */ 
/*     */           
/*     */           public void addPrivate(Induvidual i) {
/* 724 */             StatsMultipliers.StatMultiplierActionImp.this.selected.get((MAPPED)i.clas()).inc(i.race(), StatsMultipliers.StatMultiplierActionImp.this.iSelected.get(i));
/* 725 */             StatsMultipliers.StatMultiplierActionImp.this.active.inc(i, StatsMultipliers.StatMultiplierActionImp.this.iActive.get(i));
/*     */           }
/*     */         });
/* 728 */     init.updatable.add(this);
/*     */   }
/*     */   
/*     */   private void remove(Induvidual i) {
/* 732 */     if (i.added()) {
/* 733 */       this.selected.get((MAPPED)i.clas()).inc(i.race(), -this.iSelected.get(i));
/* 734 */       this.active.inc(i, -this.iActive.get(i));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void add(Induvidual i) {
/* 742 */     if (i.added()) {
/* 743 */       this.selected.get((MAPPED)i.clas()).inc(i.race(), this.iSelected.get(i));
/* 744 */       this.active.inc(i, this.iActive.get(i));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void update16(Humanoid h, int updateR, boolean day, int updateI) {
/* 750 */     if ((updateI & 0xF) == 0 && this.iActive.get(h.indu()) > 0) {
/* 751 */       Induvidual i = h.indu();
/* 752 */       if (this.iActiveCount.get(i) == 0) {
/* 753 */         remove(i);
/* 754 */         this.iActive.inc(i, -1);
/* 755 */         add(i);
/*     */       } else {
/* 757 */         this.iActiveCount.inc(h.indu(), -1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean markIs(Induvidual a) {
/* 764 */     return (this.iSelected.get(a) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void consume(Humanoid a) {
/* 769 */     remove(a.indu());
/* 770 */     this.iActive.setD(a.indu(), 1.0D);
/* 771 */     this.iActiveCount.set(a.indu(), 2 + RND.rInt(1));
/* 772 */     this.iSelected.set(a.indu(), 0);
/* 773 */     add(a.indu());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean consumeIs(Induvidual a) {
/* 778 */     return (this.iActive.get(a) != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(Humanoid a, boolean set) {
/* 783 */     remove(a.indu());
/* 784 */     this.iActive.setD(a.indu(), 0.0D);
/* 785 */     this.iSelected.set(a.indu(), set ? 1 : 0);
/* 786 */     add(a.indu());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void mark(HCLASS cl, Race race, int amount) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double value(Induvidual h) {
/* 808 */     return this.iActive.get(h);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double value(HCLASS cl, Race race, int daysBack) {
/* 814 */     return this.active.data(cl).get(race, daysBack) / (1.0D + (STATS.POP()).POP.data(cl).get(race));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(double ds) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int maxAmount(HCLASS cl, Race race) {
/* 826 */     return (STATS.POP()).POP.data(cl).get(race) - this.selected.get((MAPPED)cl).get((MAPPED)race) - this.active.data(cl).get(race);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canUnmark() {
/* 831 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int unmarkable(HCLASS cl, Race race) {
/* 836 */     return this.selected.get((MAPPED)cl).get((MAPPED)race);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unmark(HCLASS cl, Race race) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int autoAmount(HCLASS cl, Race race) {
/* 855 */     return (int)(maxAmount(cl, race) * auto(cl, race).getD());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\muls\StatsMultipliers$StatMultiplierActionImp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */