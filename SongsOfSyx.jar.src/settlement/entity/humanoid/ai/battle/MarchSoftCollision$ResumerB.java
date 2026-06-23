/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.time.TIME;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.stats.STATS;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class ResumerB
/*     */   extends AISUB.Resumable.Resumer
/*     */ {
/*     */   private ResumerB() {
/* 172 */     super(paramMarchSoftCollision);
/*     */   }
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*     */     AISUB.Resumable.Resumer ss;
/* 176 */     switch (e.event) {
/*     */       
/*     */       case COLLISION_SOFT:
/* 179 */         a.speed.setPrevDir();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 184 */         ss = MarchSoftCollision.this.gg(a, d);
/* 185 */         if (MarchSoftCollision.access$0(MarchSoftCollision.this, a, d) != MarchSoftCollision.this.push && ss != MarchSoftCollision.this.push) {
/* 186 */           d.overwrite(a, ss.set(a, d));
/* 187 */         } else if (a.division() != null) {
/* 188 */           a.speed.setDirCurrent(a.division().dir());
/*     */         } else {
/* 190 */           a.speed.setPrevDir();
/*     */         } 
/* 192 */         return true;
/*     */       case EXHAUST:
/* 194 */         if (RND.oneIn((BOOSTABLES.PHYSICS()).STAMINA.get((BOOSTABLE_O)a.indu()) * 8.0D))
/*     */         {
/* 196 */           (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), 1);
/*     */         }
/* 198 */         return false;
/*     */       case MEET_ENEMY:
/* 200 */         a.speed.setPrevDir();
/* 201 */         d.otherEntitySet((Humanoid)e.other);
/* 202 */         ss = MarchSoftCollision.this.gg(a, d);
/* 203 */         if (MarchSoftCollision.access$0(MarchSoftCollision.this, a, d) != MarchSoftCollision.this.push && ss != MarchSoftCollision.this.push) {
/* 204 */           d.overwrite(a, ss.set(a, d));
/* 205 */         } else if (a.division() != null) {
/* 206 */           a.speed.setDirCurrent(a.division().dir());
/*     */         } else {
/* 208 */           a.speed.setPrevDir();
/*     */         } 
/* 210 */         return false;
/*     */       
/*     */       case MEET_HARMLESS:
/* 213 */         return false;
/*     */     } 
/*     */     
/* 216 */     return InterBattle.listener.event(a, d, e);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 223 */     switch (e.type) {
/*     */       case COLLIDES:
/* 225 */         return 1.0D;
/*     */       case WILL_COLLIDE_WITH:
/* 227 */         if (e.other instanceof Humanoid && ((Humanoid)e.other).indu().hostile() != a.indu().hostile()) {
/* 228 */           return 1.0D;
/*     */         }
/* 230 */         if (TIME.currentSecond() - d.lastCollision < 3.0D) {
/* 231 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/* 235 */         return 0.0D;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 240 */     return InterBattle.listener.poll(a, d, e);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\MarchSoftCollision$ResumerB.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */