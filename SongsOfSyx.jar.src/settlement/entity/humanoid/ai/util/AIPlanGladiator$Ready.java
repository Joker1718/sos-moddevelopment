/*     */ package settlement.entity.humanoid.ai.util;
/*     */ 
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Ready
/*     */   extends AIPlanGladiator.ResFigher
/*     */ {
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 164 */     d.planByte1 = 8;
/* 165 */     d.otherEntitySet(null);
/* 166 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.sword, (4 + RND.rInt(4)));
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 171 */     if (!AIPlanGladiator.this.shouldFight(a, d)) {
/* 172 */       AIPlanGladiator.access$0(AIPlanGladiator.this, a, d);
/* 173 */       return null;
/*     */     } 
/* 175 */     if (AIPlanGladiator.this.isFighter((ENTITY)d.otherEntity()))
/* 176 */       return AIPlanGladiator.this.fight.set(a, d); 
/* 177 */     d.planByte1 = (byte)(d.planByte1 - 1);
/* 178 */     if (d.planByte1 < 0)
/* 179 */       return null; 
/* 180 */     Humanoid other = other(a, d);
/* 181 */     if (other != null) {
/*     */       
/* 183 */       d.otherEntitySet(other);
/* 184 */       AIPlanGladiator.this.w(a, d).gladiatorDrawMakeSheer((COORDINATE)d.planTile);
/* 185 */       return AIPlanGladiator.this.fight.set(a, d);
/*     */     } 
/* 187 */     a.speed.setDirCurrent((DIR)DIR.ALL.rnd());
/* 188 */     return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.sword, (4 + RND.rInt(4)));
/*     */   }
/*     */   
/*     */   private Humanoid other(Humanoid a, AIManager d) {
/* 192 */     RECTANGLE rec = AIPlanGladiator.this.w(a, d).gladiatorArea(d.planTile.x(), d.planTile.y());
/* 193 */     LIST<ENTITY> ents = SETT.ENTITIES().fillTiles(rec);
/* 194 */     if (ents.size() < 1)
/* 195 */       return null; 
/* 196 */     int k = RND.rInt(ents.size());
/* 197 */     for (int i = 0; i < ents.size(); i++) {
/* 198 */       ENTITY e = (ENTITY)ents.getC(i + k);
/* 199 */       if (e != a)
/*     */       {
/* 201 */         if (AIPlanGladiator.this.isFighter(e)) {
/* 202 */           Humanoid a2 = (Humanoid)e;
/* 203 */           AIManager d2 = (AIManager)a2.ai();
/* 204 */           if (!AIPlanGladiator.this.isFighter((ENTITY)d2.otherEntity())) {
/* 205 */             d2.otherEntitySet(a);
/*     */           }
/* 207 */           return a2;
/*     */         } 
/*     */       }
/*     */     } 
/* 211 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\a\\util\AIPlanGladiator$Ready.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */