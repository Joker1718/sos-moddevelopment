/*     */ package settlement.stats.disease;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.type.DISEASE;
/*     */ import init.type.DISEASES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.EntityIterator;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.rnd.RND;
/*     */ import view.sett.IDebugPanelSett;
/*     */ 
/*     */ 
/*     */ class Epidemic
/*     */   implements StatsInit.StatUpdatable, SAVABLE
/*     */ {
/*     */   public DISEASE current;
/*     */   public double duration;
/*     */   
/*     */   public Epidemic(StatsInit init) {
/*  31 */     init.upers.add(this);
/*  32 */     init.savers.put("EPIDEMIC_UPDATER", this);
/*     */     
/*  34 */     IDebugPanelSett.add("disease: epidemic", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  38 */             Epidemic.this.outbreak(0.1D + RND.rFloat() * 0.5D, DISEASES.randomEpidemic(RND.rFloat()));
/*     */           }
/*     */         });
/*     */     
/*  42 */     IDebugPanelSett.add("disease: CURE ALL", new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/*  46 */             (new EntityIterator.Humans()
/*     */               {
/*     */                 protected boolean processAndShouldBreakH(Humanoid h, int ie)
/*     */                 {
/*  50 */                   STATS.DISEASE().cure(h.indu(), false);
/*  51 */                   return false;
/*     */                 }
/*  53 */               }).iterate();
/*  54 */             Epidemic.this.current = null;
/*  55 */             Epidemic.this.duration = 0.0D;
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void update(double ds) {
/*  63 */     this.duration -= ds;
/*  64 */     if (this.duration < 0.0D) {
/*  65 */       this.current = null;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean outbreak(double spread, DISEASE strain) {
/*  71 */     int am = 0;
/*  72 */     double aveHealth = (BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null));
/*  73 */     Humanoid patienZero = null;
/*     */     
/*  75 */     ENTITY[] ee = SETT.ENTITIES().getAllEnts();
/*  76 */     for (int i = 0; i < ee.length; i++) {
/*  77 */       if (ee[i] != null && ee[i] instanceof Humanoid) {
/*  78 */         Humanoid a = (Humanoid)ee[i];
/*  79 */         if (a.indu().player()) {
/*  80 */           double c = spread * (BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)a.indu()) / aveHealth;
/*  81 */           if (RND.rFloat() < c) {
/*  82 */             STATS.DISEASE().incubate(a.indu(), strain);
/*  83 */             am++;
/*  84 */             if (RND.oneIn(am)) {
/*  85 */               patienZero = a;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     if (am > 1) {
/*  93 */       this.current = strain;
/*  94 */       this.duration = TIME.secondsPerDay() * (strain.incubationDays + strain.length);
/*  95 */       STATS.DISEASE().infect(patienZero.indu(), strain);
/*  96 */       return true;
/*     */     } 
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 103 */     file.d(this.duration);
/* 104 */     file.i((this.current == null) ? -1 : this.current.index());
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 109 */     this.duration = file.d();
/* 110 */     int ci = file.i();
/* 111 */     this.current = (ci < 0) ? null : (DISEASE)DISEASES.all().getC(ci);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 116 */     this.duration = 0.0D;
/* 117 */     this.current = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\Epidemic.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */