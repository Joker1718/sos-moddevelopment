/*     */ package settlement.stats.disease;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.type.DISEASE;
/*     */ import init.type.DISEASES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.util.color.COLOR;
/*     */ import util.statistics.HistoryInt;
/*     */ import util.text.D;
/*     */ import view.sett.IDebugPanelSett;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
/*     */ 
/*     */ public class StatsDisease extends StatCollection {
/*     */   private final Data data;
/*     */   
/*  29 */   public final HistoryInt healthHistory = new HistoryInt(32, (TIMECYCLE)TIME.days(), true)
/*     */     {
/*     */       public double getD(int fromZero)
/*     */       {
/*  33 */         return get(fromZero) / 1024.0D;
/*     */       }
/*     */ 
/*     */       
/*     */       public int get(int fromZero) {
/*  38 */         if (fromZero == 0)
/*  39 */           return (int)((BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)HCLASS_RACE.clP()) * 1024.0D); 
/*  40 */         return super.get(fromZero);
/*     */       }
/*     */     };
/*     */   
/*     */   private final Updater updater;
/*  45 */   private static CharSequence ¤¤name = "Disease"; private final Epidemic epidemic;
/*  46 */   private static CharSequence ¤¤desc = "Disease stats.";
/*  47 */   public static CharSequence ¤¤low = "The poor heath in our settlement is a serious cause for concern. Lots of people are sick, and if not improved, there will be serious outbreaks.";
/*  48 */   public static CharSequence ¤¤high = "Health in your settlement is good. There is no risk of outbreaks, but health can always be improved additionally to have less sick people to take care of.";
/*     */   
/*     */   static {
/*  51 */     D.ts(StatsDisease.class);
/*     */   }
/*     */   
/*     */   public StatsDisease(StatsInit init) {
/*  55 */     super(init, "DISEASE", ¤¤name, ¤¤desc);
/*  56 */     this.data = new Data(init);
/*  57 */     this.updater = new Updater(this.data, init);
/*  58 */     this.epidemic = new Epidemic(init);
/*     */ 
/*     */     
/*  61 */     init.upers.add(new StatsInit.StatUpdatable()
/*     */         {
/*     */           public void update(double ds)
/*     */           {
/*  65 */             StatsDisease.this.healthHistory.set((int)((BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)HCLASS_RACE.clP()) * 1024.0D));
/*     */           }
/*     */         });
/*     */     
/*  69 */     init.savers.put("D_HEALTH_HISTORY", this.healthHistory);
/*     */     
/*  71 */     IDebugPanelSett.add((PLACABLE)new PlacableSimple("Disease Infect")
/*     */         {
/*     */           public void place(int x, int y)
/*     */           {
/*  75 */             for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/*  76 */               if (e instanceof Humanoid) {
/*  77 */                 Humanoid a = (Humanoid)e;
/*  78 */                 StatsDisease.this.infect(a.indu(), DISEASES.randomRegular());
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int x, int y) {
/*  86 */             return (SETT.ENTITIES().getAtPoint(x, y) != null) ? null : E;
/*     */           }
/*     */         });
/*     */     
/*  90 */     IDebugPanelSett.add((PLACABLE)new PlacableSimple("Disease Cure")
/*     */         {
/*     */           public void place(int x, int y)
/*     */           {
/*  94 */             for (ENTITY e : SETT.ENTITIES().getAtPointL(x, y)) {
/*  95 */               if (e instanceof Humanoid) {
/*  96 */                 Humanoid a = (Humanoid)e;
/*  97 */                 StatsDisease.this.cure(a.indu(), false);
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public CharSequence isPlacable(int x, int y) {
/* 105 */             return (SETT.ENTITIES().getAtPoint(x, y) != null) ? null : E;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   public int cases(HCLASS_RACE pop, DISEASE d) {
/* 111 */     return this.data.cases(pop, d);
/*     */   }
/*     */   
/*     */   public boolean shouldHospital(Humanoid i) {
/* 115 */     if (!(STATS.SERVICE()).hospital.accessRequest(i))
/* 116 */       return false; 
/* 117 */     if (shouldDie(i))
/* 118 */       return true; 
/* 119 */     if (this.updater.time(i, 0.0D) > 1.0D)
/* 120 */       return true; 
/* 121 */     return false;
/*     */   }
/*     */   
/*     */   public boolean shouldDie(Humanoid i) {
/* 125 */     DISEASE d = this.data.get(i.indu());
/* 126 */     if (d == null)
/* 127 */       return false; 
/* 128 */     return (this.data.die.get(i.indu()) == 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean diseaseIsDone(Humanoid i, double treatment) {
/* 134 */     return this.updater.isDone(i, treatment);
/*     */   }
/*     */   
/*     */   public double diseaseTime(Humanoid i, double treatment) {
/* 138 */     return this.updater.time(i, treatment);
/*     */   }
/*     */   
/*     */   public STAT sick() {
/* 142 */     return (STAT)this.data.infected;
/*     */   }
/*     */   
/*     */   public STAT incubating() {
/* 146 */     return (STAT)this.data.incubating;
/*     */   }
/*     */   
/*     */   public DISEASE get(Induvidual i) {
/* 150 */     return this.data.get(i);
/*     */   }
/*     */   
/*     */   public DISEASE currentEpidemic() {
/* 154 */     return this.epidemic.current;
/*     */   }
/*     */   
/*     */   public DiseaseStatus status(Induvidual i) {
/* 158 */     return this.data.status(i);
/*     */   }
/*     */   
/*     */   public COLOR color(Induvidual i) {
/* 162 */     if (get(i) != null && (status(i)).active) {
/* 163 */       return (get(i)).color;
/*     */     }
/* 165 */     return null;
/*     */   }
/*     */   
/*     */   public void infect(Induvidual a, DISEASE d) {
/* 169 */     this.data.set(a, d, DiseaseStatus.ISICK);
/*     */   }
/*     */   
/*     */   public void incubate(Induvidual a, DISEASE d) {
/* 173 */     this.data.set(a, d, DiseaseStatus.INCUBATING);
/*     */   }
/*     */   
/*     */   public void cure(Induvidual a, boolean hospital) {
/* 177 */     if (get(a) != null && status(a) != DiseaseStatus.IIMMUNE) {
/* 178 */       if (hospital)
/* 179 */         (GAME.count()).CURED.inc(1); 
/* 180 */       this.data.set(a, get(a), DiseaseStatus.IIMMUNE);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean outbreak(double d, DISEASE currentStrain) {
/* 186 */     return this.epidemic.outbreak(d, currentStrain);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\StatsDisease.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */