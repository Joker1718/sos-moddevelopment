/*     */ package settlement.stats.disease;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import init.type.DISEASE;
/*     */ import init.type.DISEASES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import snake2d.util.rnd.RND;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ final class Updater
/*     */   implements StatsInit.StatUpdatableI {
/*     */   private final Data data;
/*     */   
/*     */   Updater(Data data, StatsInit init) {
/*  20 */     this.data = data;
/*  21 */     init.updatable.add(this);
/*     */   }
/*     */   
/*     */   public void update16(Humanoid h, int updateR, boolean day, int updateI) {
/*     */     DISEASE d;
/*  26 */     Induvidual i = h.indu();
/*  27 */     if (VIEW.b().isActive())
/*     */       return; 
/*  29 */     DiseaseStatus st = this.data.status(i);
/*     */     
/*  31 */     switch (st) {
/*     */       case null:
/*  33 */         if (!day)
/*     */           return; 
/*  35 */         if (this.data.count.isMax(i)) {
/*  36 */           this.data.set(i, null, null);
/*     */         } else {
/*  38 */           this.data.count.inc(i, 1);
/*     */         } 
/*  40 */         regular(h);
/*     */         break;
/*     */       case INCUBATING:
/*  43 */         d = this.data.get(i);
/*  44 */         if (d == null || ((STATS.RAN().get(i, 11, 16) + TIME.seasons().bitsSinceStart() >> 7 & 0x3) == 0 && STATS.LAW().getCurfew().is())) {
/*  45 */           this.data.set(i, null, null); break;
/*  46 */         }  if (RND.oneIn(d.incubationDays * 16.0D)) {
/*  47 */           this.data.set(i, this.data.get(i), DiseaseStatus.ISICK);
/*     */         }
/*     */         break;
/*     */       case ISICK:
/*  51 */         if (!day)
/*     */           return; 
/*  53 */         this.data.count.inc(i, 1);
/*     */         break;
/*     */       case NONE:
/*  56 */         if (day) {
/*  57 */           regular(h);
/*     */         }
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void regular(Humanoid h) {
/*  68 */     Induvidual i = h.indu();
/*  69 */     if (!(i.hType().parentClass()).player)
/*     */       return; 
/*  71 */     DiseaseStatus st = this.data.status(i);
/*  72 */     if (shouldGetSickDay(h.indu())) {
/*  73 */       DISEASE d2 = DISEASES.randomRegular();
/*  74 */       if (d2 != null && (this.data.get(i) != d2 || st != DiseaseStatus.IIMMUNE))
/*     */       {
/*     */         
/*  77 */         this.data.set(i, d2, DiseaseStatus.ISICK);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean isDone(Humanoid i, double treatment) {
/*  83 */     return (time(i, treatment) <= 0.0D);
/*     */   }
/*     */   
/*     */   public double time(Humanoid h, double treatment) {
/*  87 */     Induvidual i = h.indu();
/*  88 */     DiseaseStatus st = this.data.status(i);
/*  89 */     if (!st.active)
/*  90 */       return 0.0D; 
/*  91 */     if (this.data.get(i) == null)
/*  92 */       return 0.0D; 
/*  93 */     return (this.data.get(i)).length * (1.0D - treatment) - this.data.count.get(i) + h.partOfDay();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean shouldGetSickDay(Induvidual a) {
/* 100 */     double chance = DISEASES.regularDays() * (1.0D + Math.max((BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)a), 0.0D));
/*     */     
/* 102 */     if (RND.oneIn((int)Math.ceil(chance)))
/*     */     {
/* 104 */       return true;
/*     */     }
/* 106 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\disease\Updater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */