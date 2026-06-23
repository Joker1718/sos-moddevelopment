/*     */ package settlement.entity.humanoid.ai.subject;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.spirit.dump.ROOM_DUMP;
/*     */ import settlement.thing.ThingsCorpses;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private ROOM_DUMP dump;
/*     */   
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/* 117 */     super(paramPLANRES, $anonymous0);
/*     */     
/* 119 */     this.dump = (SETT.ROOMS()).DUMP;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 123 */     COORDINATE coo = (this.dump.service()).finder.reserve(a.tc(), 2147483647);
/* 124 */     if (coo != null) {
/* 125 */       d.planTile.set(coo);
/* 126 */       ThingsCorpses.Corpse corpse = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 127 */       AISUB.AISubActivation s = (AI.SUBS()).walkTo.coo(a, d, (COORDINATE)corpse);
/* 128 */       if (s != null) {
/* 129 */         return s;
/*     */       }
/* 131 */       can(a, d);
/*     */     } 
/* 133 */     ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 134 */     if (c != null)
/* 135 */       c.findableReserveCancel(); 
/* 136 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 142 */     return PlanBuryCorpse.this.dumpRet.set(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 147 */     return ((SETT.THINGS()).corpses.getByIndex((short)d.planObject) != null && (SETT.THINGS()).corpses.getByIndex((short)d.planObject).canBeDragged());
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 152 */     FSERVICE s = this.dump.service().service(d.planTile.x(), d.planTile.y());
/* 153 */     if (s != null)
/* 154 */       s.findableReserveCancel(); 
/* 155 */     ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 156 */     if (c != null)
/* 157 */       c.findableReserveCancel(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\PlanBuryCorpse$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */