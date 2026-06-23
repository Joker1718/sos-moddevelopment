/*     */ package settlement.recipe;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.LOG;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Data
/*     */ {
/* 220 */   double prev = -1.0D;
/* 221 */   double mul = 1.0D;
/* 222 */   int am = 1;
/*     */ 
/*     */   
/*     */   void add(Humanoid h, RoomInstance work, Industry i) {
/* 226 */     this.am++;
/* 227 */     double mul = 1.0D;
/* 228 */     if (!(work.blueprintI() instanceof settlement.room.food.pasture.ROOM_PASTURE))
/*     */     {
/*     */       
/* 231 */       mul *= IndustryUtil.roomBonus(work, (IndustryRate)i); } 
/* 232 */     mul *= work.employees().totEfficiency();
/* 233 */     mul *= i.bonus().get((BOOSTABLE_O)h.indu());
/* 234 */     this.mul += mul;
/*     */   }
/*     */ 
/*     */   
/*     */   void addD(Humanoid h, RoomInstance work, Industry i) {
/* 239 */     this.am++;
/* 240 */     double mul = 1.0D;
/* 241 */     LOG.ln((work.blueprint()).key);
/* 242 */     mul *= IndustryUtil.roomBonus(work, (IndustryRate)i);
/* 243 */     LOG.ln(Double.valueOf(mul));
/* 244 */     mul *= work.employees().totEfficiency();
/* 245 */     LOG.ln(Double.valueOf(mul));
/* 246 */     mul *= i.bonus().get((BOOSTABLE_O)h.indu());
/* 247 */     LOG.ln(Double.valueOf(mul));
/* 248 */     this.mul += mul;
/*     */   }
/*     */   
/*     */   public double get(Boostable bo) {
/* 252 */     if (this.prev < 0.0D)
/* 253 */       return bo.get((BOOSTABLE_O)HCLASS_RACE.clP()); 
/* 254 */     return this.prev;
/*     */   }
/*     */   
/*     */   void calc() {
/* 258 */     if (this.am > 0) {
/* 259 */       this.prev = this.mul / this.am;
/*     */     } else {
/* 261 */       this.prev = -1.0D;
/* 262 */     }  this.mul = 0.0D;
/* 263 */     this.am = 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\recipe\RecipeRatesPlayer$Data.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */