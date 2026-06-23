/*    */ package world.army;
/*    */ import game.GAME;
/*    */ import game.battle.DivisionBanners;
/*    */ import game.battle.util.DIV_SETTING;
/*    */ import game.battle.util.DIV_SPEC;
/*    */ import game.battle.util.DivGeneration;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ public interface WDIV extends DIV_SPEC {
/*    */   void resolve(Induvidual[] paramArrayOfInduvidual);
/*    */   
/*    */   void resolve(int paramInt, double paramDouble);
/*    */   
/*    */   default void resolve(int survivors) {
/* 18 */     double xp = 0.0D;
/*    */     
/* 20 */     if (survivors > 0) {
/* 21 */       xp = 0.1D * men() / survivors;
/* 22 */       xp += experience();
/* 23 */       xp = CLAMP.d(xp, 0.0D, 1.0D);
/*    */     } 
/* 25 */     resolve(survivors, xp);
/*    */   }
/*    */   
/*    */   DivGeneration generate();
/*    */   
/*    */   default int provess() {
/* 31 */     return (int)(GAME.battle()).power.get(this);
/*    */   }
/*    */   int daysUntilMenArrives();
/*    */   
/*    */   boolean needSupplies();
/*    */   
/*    */   default DivisionBanners.DivisionBanner banner() {
/* 38 */     return (GAME.ARMIES()).banners.get(bannerI());
/*    */   }
/*    */   
/*    */   void bannerSet(int paramInt);
/*    */   
/*    */   default int costPerMan() {
/* 44 */     return 0;
/*    */   }
/*    */   int menTarget();
/*    */   default boolean needConscripts() {
/* 48 */     return false;
/*    */   }
/*    */   
/*    */   WArmy army();
/*    */   
/*    */   COLOR color();
/*    */   
/*    */   DIV_SETTING target();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\army\WDIV.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */