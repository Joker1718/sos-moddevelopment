/*     */ package settlement.stats.law;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.CRIMES;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class StatCrimePersecute
/*     */   extends StatCrime {
/*  26 */   private static CharSequence ¤¤recentPersecutions = "Recent Persecutions";
/*  27 */   private static CharSequence ¤¤recentPersecutionsMul = "Multiplier from recent persecutions";
/*     */   static {
/*  29 */     D.ts(StatCrimePersecute.class);
/*     */   }
/*  31 */   private final double[] active = new double[HCLASS_RACE.ALL().size()];
/*     */   
/*     */   StatCrimePersecute(StatsInit init, CRIMES.CRIME type, CrimesData data) {
/*  34 */     super(init, type, data);
/*  35 */     init.savers.put("LAW_CRIME_DATA_PERS " + String.valueOf(type.cl), new SAVABLE()
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/*  39 */             HCLASS_RACE.MAP().saver().save(StatCrimePersecute.this.active, file);
/*     */           }
/*     */ 
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/*  44 */             HCLASS_RACE.MAP().loader().load(StatCrimePersecute.this.active, file, 0.0D);
/*     */           }
/*     */ 
/*     */           
/*     */           public void clear() {
/*  49 */             Arrays.fill(StatCrimePersecute.this.active, 0.0D);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void catchh(Race race) {
/*  58 */     this.active[(HCLASS_RACE.clP(race, this.crime.cl)).index] = this.active[(HCLASS_RACE.clP(race, this.crime.cl)).index] + 1.0D;
/*  59 */     super.catchh(race);
/*     */   }
/*     */   
/*     */   public double value(HCLASS cl, Race race) {
/*  63 */     return CLAMP.d(100.0D * active(cl, race) / (1 + POP.pop(cl, race)), 0.0D, 1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   private double active(HCLASS cl, Race race) {
/*  68 */     if (race == null) {
/*  69 */       double pop = 0.0D;
/*  70 */       double res = 0.0D;
/*  71 */       for (Race r : RACES.all()) {
/*  72 */         double p = (STATS.POP()).POP.data(cl).get(r);
/*  73 */         pop += p;
/*  74 */         res += p * value(cl, r);
/*     */       } 
/*  76 */       if (pop == 0.0D) {
/*  77 */         return 0.0D;
/*     */       }
/*  79 */       return res / pop;
/*     */     } 
/*     */     
/*  82 */     HCLASS_RACE cc = HCLASS_RACE.clP(race, cl);
/*  83 */     return this.active[cc.index];
/*     */   }
/*     */ 
/*     */   
/*     */   public double lawValue(HCLASS cl, Race race) {
/*  88 */     return super.lawValue(cl, race) * value(cl, race);
/*     */   }
/*     */ 
/*     */   
/*     */   public double tyrranyValue(HCLASS cl, Race race) {
/*  93 */     return super.tyrranyValue(cl, race) * value(cl, race);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(HCLASS_RACE rr, double ds) {
/*  98 */     this.active[rr.index] = this.active[rr.index] - (0.1D + this.active[rr.index] * 0.05D) * ds * TIME.secondsPerDayI();
/*  99 */     this.active[rr.index] = CLAMP.d(this.active[rr.index], 0.0D, (STATS.POP()).POP.data().get(null));
/* 100 */     super.update(rr, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   public void hover(GUI_BOX box, HCLASS cl, Race race) {
/* 105 */     super.hover(box, cl, race);
/* 106 */     GBox b = (GBox)box;
/*     */     
/* 108 */     b.sep();
/* 109 */     b.textLL(¤¤recentPersecutions);
/* 110 */     b.tab(6);
/* 111 */     b.add((SPRITE)GFORMAT.f(b.text(), active(cl, race)), 1);
/* 112 */     b.NL();
/*     */     
/* 114 */     b.textLL(¤¤recentPersecutionsMul);
/* 115 */     b.NL();
/* 116 */     b.add((SPRITE)GFORMAT.perc(b.text(), value(cl, race)));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\law\StatCrimePersecute.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */