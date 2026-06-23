/*     */ package settlement.entity.humanoid.ai.crime;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*  87 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  91 */     ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/*  92 */     if (e == null)
/*  93 */       return null; 
/*  94 */     a.speed.turn2(a.body(), e.body());
/*  95 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.sword_out, (AI.STATES()).anima.sword_out.time);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 100 */     ENTITY e = SETT.ENTITIES().getByID(d.planObject);
/* 101 */     if (e == null)
/* 102 */       return null; 
/* 103 */     if (e instanceof Humanoid) {
/* 104 */       Humanoid h = (Humanoid)e;
/* 105 */       double damage = RND.rFloat() * 0.99D;
/* 106 */       h.inflictDamage(damage, CAUSE_LEAVES.MURDER());
/* 107 */       AIModule_Crime.notify(a);
/* 108 */       if (h.isRemoved())
/* 109 */         return Murder.this.cool_down.set(a, d); 
/* 110 */       return Murder.this.chase.set(a, d);
/*     */     } 
/*     */     
/* 113 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 118 */     return true;
/*     */   }
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\Murder$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */