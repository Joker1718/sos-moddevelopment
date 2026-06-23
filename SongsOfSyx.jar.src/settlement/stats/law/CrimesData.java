/*     */ package settlement.stats.law;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.race.Race;
/*     */ import init.type.CRIMES;
/*     */ import init.type.CRIME_PUNISHMENTS;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.keymap.MAPPED;
/*     */ import util.statistics.HistoryObject;
/*     */ import util.updating.IUpdater;
/*     */ 
/*     */ 
/*     */ class CrimesData
/*     */   implements SAVABLE
/*     */ {
/*  32 */   public final HistoryObject<HCLASS_RACE> crimesComitted = new HistoryObject(32, (TIMECYCLE)TIME.days(), false, HCLASS_RACE.MAP());
/*  33 */   public final HistoryObject<HCLASS_RACE> criminalsCaught = new HistoryObject(32, (TIMECYCLE)TIME.days(), false, HCLASS_RACE.MAP());
/*  34 */   public final HistoryObject<HCLASS_RACE> lawHistory = new HistoryObject(32, (TIMECYCLE)TIME.days(), false, HCLASS_RACE.MAP());
/*  35 */   private final int[] criminalsTypes = Alloc.ii(HCLASS_RACE.ALL().size());
/*     */   
/*     */   public final IUpdater upCrime;
/*     */   
/*     */   public double escapedPrisoners;
/*  40 */   public final Curfew curfew = new Curfew();
/*     */   
/*     */   public final IUpdater up;
/*     */   
/*     */   public final IUpdater upPunishment;
/*     */   
/*     */   CrimesData(StatsInit init) {
/*  47 */     init.savers.put("LAW_CRIMES_DATA", this);
/*     */     
/*  49 */     this.upCrime = new IUpdater(HCLASS_RACE.ALL().size() * CRIMES.ALL().size(), TIME.secondsPerDay())
/*     */       {
/*     */         
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/*  54 */           HCLASS_RACE cl = (HCLASS_RACE)HCLASS_RACE.ALL().get(i / CRIMES.ALL().size());
/*  55 */           CRIMES.CRIME c = (CRIMES.CRIME)CRIMES.ALL().get(i % CRIMES.ALL().size());
/*  56 */           c.stat().update(cl, timeSinceLast);
/*     */         }
/*     */       };
/*     */     
/*  60 */     this.upPunishment = new IUpdater(HCLASS_RACE.ALL().size() * CRIME_PUNISHMENTS.ALL().size(), TIME.secondsPerDay())
/*     */       {
/*     */         
/*     */         protected void update(int i, double timeSinceLast)
/*     */         {
/*  65 */           HCLASS_RACE cl = (HCLASS_RACE)HCLASS_RACE.ALL().get(i / CRIME_PUNISHMENTS.ALL().size());
/*  66 */           CRIME_PUNISHMENTS.PUNISHMENT c = (CRIME_PUNISHMENTS.PUNISHMENT)CRIME_PUNISHMENTS.ALL().get(i % CRIME_PUNISHMENTS.ALL().size());
/*  67 */           c.stat().decRate(cl);
/*     */         }
/*     */       };
/*     */     
/*  71 */     this.up = new IUpdater(HCLASS_RACE.ALL().size(), TIME.secondsPerDay())
/*     */       {
/*     */         protected void update(int cli, double ds)
/*     */         {
/*  75 */           if (cli == 0) {
/*  76 */             CrimesData.this.escapedPrisoners -= 0.5D + (STATS.POP()).POP.data().get(null) * 0.01D;
/*  77 */             CrimesData.this.escapedPrisoners = CLAMP.d(CrimesData.this.escapedPrisoners, 0.0D, (STATS.POP()).POP.data().get(null));
/*     */           } 
/*     */           
/*  80 */           CrimesData.this.lawHistory.set((MAPPED)HCLASS_RACE.ALL().get(cli), (int)(10000.0D * (BOOSTABLES.CIVICS()).LAW.get((BOOSTABLE_O)HCLASS_RACE.ALL().get(cli))));
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  85 */     init.upers.add(new StatsInit.StatUpdatable()
/*     */         {
/*     */           public void update(double ds) {
/*  88 */             CrimesData.this.upCrime.update(ds);
/*  89 */             CrimesData.this.up.update(ds);
/*  90 */             CrimesData.this.upPunishment.update(ds);
/*  91 */             CrimesData.this.curfew.update(ds);
/*     */           }
/*     */         });
/*     */     
/*  95 */     init.addable.add(new StatsInit.Addable()
/*     */         {
/*     */           public void removePrivate(Induvidual i)
/*     */           {
/*  99 */             if (i.hType() == HTYPES.PRISONER()) {
/* 100 */               ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminals[(i.race()).index] = ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminals[(i.race()).index] - 1;
/* 101 */               CrimesData.this.count(i, -1);
/* 102 */               ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminalsTot--;
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void addPrivate(Induvidual i) {
/* 110 */             if (i.hType() == HTYPES.PRISONER() && (STATS.LAW()).prisonerType.get(i) != null) {
/* 111 */               ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminals[(i.race()).index] = ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminals[(i.race()).index] + 1;
/* 112 */               CrimesData.this.count(i, 1);
/* 113 */               ((StatCrime)(STATS.LAW()).crimes.get(((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).index())).criminalsTot++;
/*     */             }
/* 115 */             else if ((STATS.LAW()).prisonerType.get(i) == null || ((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).cl != i.clas()) {
/* 116 */               long m = 0L;
/* 117 */               for (CRIMES.CRIME c : CRIMES.all(i.clas())) {
/* 118 */                 if (c.isCriminal())
/* 119 */                   m += (long)(1024.0D * c.tyrrany(i.clas(), i.race())); 
/*     */               } 
/* 121 */               m = (long)((float)m * RND.rFloat());
/* 122 */               for (CRIMES.CRIME c : CRIMES.all(i.clas())) {
/* 123 */                 if (c.isCriminal())
/* 124 */                   m -= (long)(1024.0D * c.tyrrany(i.clas(), i.race())); 
/* 125 */                 if (m <= 0L) {
/*     */                   
/* 127 */                   (STATS.LAW()).prisonerType.set(i, c);
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   void count(Induvidual i, int delta) {
/* 138 */     if (i.hType() == HTYPES.PRISONER()) {
/* 139 */       HCLASS_RACE cl = HCLASS_RACE.clP(i.race(), ((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).cl);
/* 140 */       this.criminalsTypes[cl.index] = this.criminalsTypes[cl.index] + delta;
/* 141 */       cl = HCLASS_RACE.clP(null, ((CRIMES.CRIME)(STATS.LAW()).prisonerType.get(i)).cl);
/* 142 */       this.criminalsTypes[cl.index] = this.criminalsTypes[cl.index] + delta;
/*     */     } 
/*     */   }
/*     */   
/*     */   int criminals(HCLASS cl, Race race) {
/* 147 */     HCLASS_RACE cll = HCLASS_RACE.clP(race, cl);
/* 148 */     return this.criminalsTypes[cll.index()];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 154 */     this.crimesComitted.save(file);
/* 155 */     this.criminalsCaught.save(file);
/* 156 */     this.lawHistory.save(file);
/* 157 */     this.upCrime.save(file);
/* 158 */     file.d(this.escapedPrisoners);
/* 159 */     this.curfew.saver.save(file);
/* 160 */     this.up.save(file);
/* 161 */     this.upPunishment.save(file);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 166 */     this.crimesComitted.load(file);
/* 167 */     this.criminalsCaught.load(file);
/* 168 */     this.lawHistory.load(file);
/* 169 */     this.upCrime.load(file);
/* 170 */     this.escapedPrisoners = file.d();
/* 171 */     this.curfew.saver.load(file);
/* 172 */     this.up.load(file);
/* 173 */     this.upPunishment.load(file);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clear() {
/* 179 */     this.crimesComitted.clear();
/* 180 */     this.criminalsCaught.clear();
/* 181 */     this.lawHistory.clear();
/* 182 */     this.upCrime.clear();
/* 183 */     this.escapedPrisoners = 0.0D;
/* 184 */     this.curfew.saver.clear();
/* 185 */     this.up.clear();
/* 186 */     this.upPunishment.clear();
/* 187 */     Arrays.fill(this.criminalsTypes, 0);
/*     */   }
/*     */   
/*     */   public double history(HCLASS_RACE ra, int days) {
/* 191 */     return this.lawHistory.history((MAPPED)ra).get(days) / 10000.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\CrimesData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */