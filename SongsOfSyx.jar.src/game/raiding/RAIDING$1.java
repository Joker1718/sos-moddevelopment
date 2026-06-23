/*    */ package game.raiding;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.constant.Config;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import snake2d.util.misc.CLAMP;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 47 */     RAIDING.this.all.clearSloppy();
/*    */     
/* 49 */     double w = (Config.sett()).POP_RAIDER_WORTH * 40000.0D + 2.5E7D / (Config.sett()).POP_RAIDER_WORTH;
/*    */     
/* 51 */     for (int i = 0; i < RAIDING.this.all.max(); i++) {
/*    */       
/* 53 */       double d = i / RAIDING.this.all.max();
/* 54 */       double wealth = 300.0D * (Config.sett()).POP_RAIDER_WORTH + Math.pow(d, 2.1D) * w;
/* 55 */       (GAME.battle()).power.getClass(); double power = 5.0D + (Config.battle()).MEN_PER_ARMY * (1.0D + (5.0D - 1.0D) / 2.0D) * Math.pow(d, 2.75D);
/*    */       
/* 57 */       Raider r = new Raider(wealth, power, CLAMP.d(i / 10.0D, 0.0D, 1.0D));
/* 58 */       RAIDING.this.all.add(r);
/*    */     } 
/* 60 */     RAIDING.this.current.clear();
/* 61 */     RAIDING.this.updater.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RAIDING$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */