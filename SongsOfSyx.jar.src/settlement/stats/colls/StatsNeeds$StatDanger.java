/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StatDanger
/*     */ {
/*     */   public final STAT DANGER;
/*     */   public final STAT COUNT;
/*     */   private final INT_O<Induvidual> count;
/*     */   
/*     */   private StatDanger(String key, StatsInit init, final INT_O.INT_OE<Induvidual> c) {
/* 236 */     INT_O.INT_OE<Induvidual> count = new INT_O.INT_OE<Induvidual>()
/*     */       {
/*     */         public void set(Induvidual t, int s) {
/* 239 */           c.set(t, s);
/* 240 */           StatsNeeds.StatDanger.this.DANGER.indu().set(t, StatsNeeds.StatDanger.this.critical(t) ? 1 : 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public int get(Induvidual t) {
/* 245 */           return c.get(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Induvidual t) {
/* 250 */           return c.min(t);
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Induvidual t) {
/* 255 */           return c.max(t);
/*     */         }
/*     */       };
/*     */     
/* 259 */     this.COUNT = (STAT)new STATData(key, "NEED_" + key, init, count);
/* 260 */     this.DANGER = (STAT)new STATData(null, init, (DataO.DataAbs)new DataO.DataBit(init.count, "NEED_DANGER_" + key), this.COUNT.info());
/* 261 */     this.count = (INT_O<Induvidual>)count;
/*     */   }
/*     */   
/*     */   public boolean inDanger(Induvidual i) {
/* 265 */     return (this.count.get(i) >= this.count.max(i) / 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean willDie(Induvidual i, double treatment) {
/* 270 */     if (inDanger(i)) {
/* 271 */       double chance = 1.0D - treatment;
/* 272 */       chance = CLAMP.d(chance, 0.0D, 1.0D);
/* 273 */       int ran = (int)(chance * 65535.0D);
/*     */ 
/*     */       
/* 276 */       return (ran >= STATS.RAN().get(i, 7, 16));
/*     */     } 
/* 278 */     return false;
/*     */   }
/*     */   
/*     */   public void setNonDanger(Induvidual i) {
/* 282 */     if (inDanger(i))
/* 283 */       this.COUNT.indu().set(i, this.count.max(i) / 2 - 2); 
/*     */   }
/*     */   
/*     */   public boolean critical(Induvidual i) {
/* 287 */     return (this.count.get(i) >= 3 * this.count.max(i) / 4);
/*     */   }
/*     */   
/*     */   boolean update(Humanoid a) {
/* 291 */     Induvidual i = a.indu();
/* 292 */     if (this.count.get(i) != 0) {
/* 293 */       if (this.count.isMax(i)) {
/* 294 */         Humanoid.HumanoidResource.dead = (a.lastLeaveCause() != null) ? a.lastLeaveCause() : CAUSE_LEAVES.getAccident();
/* 295 */         return true;
/* 296 */       }  if (inDanger(i)) {
/* 297 */         this.COUNT.indu().inc(i, 4);
/* 298 */       } else if (a.division() == null || !a.division().settings().mustering()) {
/* 299 */         this.COUNT.indu().inc(i, -((int)Math.ceil(1.0D + 15.0D * (BOOSTABLES.PHYSICS()).HEALTH.get((BOOSTABLE_O)i))));
/*     */       } 
/*     */     } 
/* 302 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsNeeds$StatDanger.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */