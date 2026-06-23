/*     */ package settlement.entity.humanoid.ai.work;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 107 */     super(paramPLANRES, $anonymous0);
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 111 */     return (AI.SUBS()).WORK_HANDS.activate(a, d, 3.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 116 */     WorkCannibal.this.b.cage(d.path.destX(), d.path.destY()).grabCancel();
/*     */     
/* 118 */     ThingsCorpses.Corpse c = victim(d);
/* 119 */     if (c == null) {
/* 120 */       can(a, d);
/* 121 */       return null;
/*     */     } 
/* 123 */     c.findableReserve();
/* 124 */     d.planObject = c.index();
/* 125 */     WorkCannibal.this.b.setRace(d.planTile.x(), d.planTile.y(), c.race());
/*     */ 
/*     */ 
/*     */     
/* 129 */     return WorkCannibal.this.drag_back2.set(a, d);
/*     */   }
/*     */   
/*     */   private ThingsCorpses.Corpse victim(AIManager d) {
/* 133 */     ENTITY e = SETT.ENTITIES().getAtTileSingle(d.path.destX(), d.path.destY());
/* 134 */     if (e == null) {
/* 135 */       return null;
/*     */     }
/* 137 */     if (e instanceof Humanoid) {
/* 138 */       Humanoid a = (Humanoid)e;
/* 139 */       if (a.indu().hType() != HTYPES.PRISONER()) {
/* 140 */         return null;
/*     */       }
/* 142 */       a.kill(false, CAUSE_LEAVES.EXECUTED());
/*     */       
/* 144 */       return (ThingsCorpses.Corpse)(SETT.PATH()).finders.corpses.getReservable(d.path.destX(), d.path.destY());
/*     */     } 
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 151 */     return WorkCannibal.this.fetch1.con(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 156 */     WorkCannibal.this.fetch1.can(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\work\WorkCannibal$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */