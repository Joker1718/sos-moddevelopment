/*     */ package settlement.entity.humanoid.ai.subject;
/*     */ 
/*     */ import init.type.HCLASS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.misc.util.FSERVICE;
/*     */ import settlement.room.spirit.dump.ROOM_DUMP;
/*     */ import settlement.stats.colls.StatsBurial;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 161 */     super(paramPLANRES, $anonymous0);
/*     */     
/* 163 */     this.dump = (SETT.ROOMS()).DUMP;
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 167 */     ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 168 */     return (AI.SUBS()).walkTo.drag(a, d, (SETT.THINGS()).corpses.draggable, c.index(), (COORDINATE)d.planTile);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 173 */     ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 174 */     if (c != null) {
/* 175 */       this.dump.burry(c, d.planTile.x(), d.planTile.y());
/* 176 */       HCLASS cl = c.indu().hType().parentClass();
/* 177 */       for (StatsBurial.StatGrave g : (c.indu().race().service()).GRAVES.get(cl.index())) {
/* 178 */         if (g.grave().permission().get(cl, c.indu().race())) {
/* 179 */           g.grave().get(cl).fail(c, 1);
/*     */         }
/*     */       } 
/* 182 */       c.remove();
/*     */     } else {
/* 184 */       can(a, d);
/*     */     } 
/* 186 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 191 */     return (this.dump.service().service(d.planTile.x(), d.planTile.y()) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 196 */     FSERVICE s = this.dump.service().service(d.planTile.x(), d.planTile.y());
/* 197 */     if (s != null)
/* 198 */       s.findableReserveCancel(); 
/* 199 */     ThingsCorpses.Corpse c = (SETT.THINGS()).corpses.getByIndex((short)d.planObject);
/* 200 */     if (c != null)
/* 201 */       c.findableReserveCancel(); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\PlanBuryCorpse$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */