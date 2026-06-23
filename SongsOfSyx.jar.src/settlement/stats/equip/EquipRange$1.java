/*    */ package settlement.stats.equip;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.div.Div;
/*    */ import game.time.TIME;
/*    */ import util.updating.IUpdater;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends IUpdater
/*    */ {
/*    */   null(int $anonymous0, double $anonymous1) {
/* 76 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   protected void update(int i, double timeSinceLast) {
/* 80 */     Div d = GAME.ARMIES().division((short)i);
/* 81 */     if (d.menNrOf() == 0) {
/* 82 */       EquipRange.this.ammoWasted[i] = 0.0D;
/*    */       
/*    */       return;
/*    */     } 
/* 86 */     int men = d.men();
/*    */     
/* 88 */     int m = men * EquipRange.this.ammoMax;
/* 89 */     if (EquipRange.this.ammoWasted[i] > m) {
/* 90 */       EquipRange.this.ammoWasted[i] = m;
/*    */     }
/*    */     
/* 93 */     if (d.player() && GAME.ARMIES().enemy().men() == 0) {
/* 94 */       EquipRange.this.ammoWasted[i] = EquipRange.this.ammoWasted[i] - men * timeSinceLast * TIME.secondsPerDayI() * TIME.hoursPerDay() / EquipRange.this.ammoReplenishHours;
/* 95 */       if (EquipRange.this.ammoWasted[i] < 0.0D)
/* 96 */         EquipRange.this.ammoWasted[i] = 0.0D; 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\equip\EquipRange$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */