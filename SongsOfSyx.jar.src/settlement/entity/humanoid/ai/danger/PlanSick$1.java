/*     */ package settlement.entity.humanoid.ai.danger;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.home.HOME;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/*  44 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  49 */     if ((STATS.RAN().get(a.indu(), 0) & 0xFF) > 200) {
/*     */       
/*  51 */       HOME h = (STATS.HOME()).GETTER.get(a, this);
/*  52 */       if (h != null) {
/*  53 */         if (!h.is(a.tc().x(), a.tc().y())) {
/*  54 */           int sx = h.serviceX();
/*  55 */           int sy = h.serviceY();
/*  56 */           return (AI.SUBS()).walkTo.cooFull(a, d, sx, sy);
/*     */         } 
/*  58 */         if (SETT.ENTITIES().hasAtTileHigher((ENTITY)a, a.tc().x(), a.tc().y())) {
/*  59 */           for (DIR dir : DIR.ORTHO) {
/*  60 */             int dx = a.tc().x() + dir.x();
/*  61 */             int dy = a.tc().y() + dir.y();
/*  62 */             if (h.is(dx, dy) && !(SETT.PATH()).solidity.is(dx, dy) && !SETT.ENTITIES().hasAtTileHigher((ENTITY)a, dx, dy)) {
/*  63 */               return (AI.SUBS()).walkTo.cooFull(a, d, dx, dy);
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  71 */     PlanSick.this.sound.rnd(a);
/*     */     
/*  73 */     return (AI.SUBS()).LAY.activateTime(a, d, 60);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  81 */     if (STATS.DISEASE().diseaseIsDone(a, 0.0D)) {
/*  82 */       if (STATS.DISEASE().shouldDie(a)) {
/*  83 */         AIManager.dead = CAUSE_LEAVES.DISEASE();
/*  84 */         AIManager.deadGore = false;
/*  85 */         return (AI.SUBS()).STAND.activate(a, d);
/*     */       } 
/*  87 */       STATS.DISEASE().cure(a.indu(), false);
/*  88 */       return null;
/*     */     } 
/*  90 */     if (STATS.DISEASE().shouldHospital(a)) {
/*  91 */       AISUB.AISubActivation s = PlanSick.this.ho.init(a, d);
/*  92 */       if (s != null) {
/*  93 */         return s;
/*     */       }
/*     */     } 
/*  96 */     return set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 101 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\danger\PlanSick$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */