/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.VectorImp;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends SubFight.ResumerB
/*     */ {
/*     */   private final VectorImp vec;
/*     */   
/*     */   null(SubFight paramSubFight2) {
/* 176 */     this.vec = new VectorImp();
/*     */   }
/*     */ 
/*     */   
/*     */   public AISTATE setAction(Humanoid a, AIManager d) {
/* 181 */     if (!BattleUtil.shouldMoveIntoDivPosition(a, d)) {
/* 182 */       return null;
/*     */     }
/* 184 */     if (!(a.division()).reporter.posHas(a)) {
/* 185 */       return null;
/*     */     }
/* 187 */     double m = this.vec.set(a.body().cX(), a.body().cY(), (a.division()).reporter.getPixel(a));
/* 188 */     if (m > 128.0D) {
/* 189 */       return (AI.STATES()).STAND_SWORD.activate(a, d, 0.1D);
/*     */     }
/* 191 */     boolean can = true;
/* 192 */     if (m > 64.0D) {
/* 193 */       for (int i = 1; i < 3 && m > 0.0D; i++) {
/* 194 */         int j = (int)(a.body().cX() + this.vec.nX() * 64.0D * i) >> 6;
/* 195 */         int k = (int)(a.body().cY() + this.vec.nY() * 64.0D * i) >> 6;
/* 196 */         if (!SETT.IN_BOUNDS(j, k) || (SETT.PATH().finders()).entity.getEnemies(a, j, k) > 0) {
/* 197 */           can = false;
/*     */           break;
/*     */         } 
/* 200 */         m -= 64.0D;
/*     */       } 
/*     */     }
/* 203 */     if (can) {
/*     */       
/* 205 */       AISTATE s = (AI.STATES()).WALK2_SWORD.free(a, d, (int)(a.body().cX() + this.vec.nX() * 64.0D * 2.0D), (int)(a.body().cY() + this.vec.nY() * 64.0D * 2.0D));
/* 206 */       a.speed.setPrevDir();
/* 207 */       return s;
/*     */     } 
/*     */     
/* 210 */     Humanoid ene = d.otherEntity();
/* 211 */     if (ene == null) {
/* 212 */       return null;
/*     */     }
/* 214 */     this.vec.set(ene.body().cX(), ene.body().cY(), a.body().cX(), a.body().cY());
/* 215 */     int tx = (int)(a.body().cX() + this.vec.nX() * 64.0D) >> 6;
/* 216 */     int ty = (int)(a.body().cY() + this.vec.nY() * 64.0D) >> 6;
/* 217 */     if (SETT.IN_BOUNDS(tx, ty) && (SETT.PATH().finders()).entity.getEnemies(a, tx, ty) <= 0) {
/* 218 */       AISTATE s = (AI.STATES()).WALK2_SWORD.free(a, d, (int)(a.body().cX() + this.vec.nX() * 64.0D * 2.0D), (int)(a.body().cY() + this.vec.nY() * 64.0D * 2.0D));
/* 219 */       a.speed.setPrevDir();
/* 220 */       return s;
/*     */     } 
/*     */     
/* 223 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 229 */     boolean ret = super.event(a, d, e);
/* 230 */     if (e.speedHasChanged && d.subByte == this.index && d.plansub() == SubFight.this) {
/* 231 */       d.otherEntitySet(null);
/* 232 */       a.speed.setPrevDir();
/*     */       
/* 234 */       float dx = d.X - a.body().cX();
/* 235 */       float dy = d.Y - a.body().cY();
/*     */       
/* 237 */       if (dx * a.speed.nX() < 0.0D || dy * a.speed.nY() < 0.0D) {
/* 238 */         a.speed.turn2((BODY_HOLDER)a, d.X, d.Y).magnitudeTargetSet(0.4D + RND.rFloat(0.05D));
/* 239 */         return false;
/*     */       } 
/* 241 */       d.overwrite(a, (AI.STATES()).STAND_SWORD.activate(a, d, 0.1D));
/*     */       
/* 243 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 247 */     return ret;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AISTATE res(Humanoid a, AIManager d) {
/* 254 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\SubFight$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */