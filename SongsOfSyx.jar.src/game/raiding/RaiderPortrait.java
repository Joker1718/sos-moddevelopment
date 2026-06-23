/*    */ package game.raiding;
/*    */ 
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ public class RaiderPortrait
/*    */   extends SPRITE.Imp
/*    */ {
/*    */   private Induvidual raider;
/*    */   private boolean dead;
/*    */   
/*    */   public RaiderPortrait(int scale) {
/* 15 */     super(40 * scale, 64 * scale);
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 20 */     if (raider() == null)
/*    */       return; 
/* 22 */     int scale = (X2 - X1) / 40;
/* 23 */     render(r, X1, Y1, scale, raider(), this.dead);
/*    */   }
/*    */   
/*    */   public RaiderPortrait set(Induvidual indu) {
/* 27 */     this.raider = indu;
/* 28 */     return this;
/*    */   }
/*    */   
/*    */   public RaiderPortrait set(Raider indu) {
/* 32 */     this.raider = indu.indu;
/* 33 */     return this;
/*    */   }
/*    */   
/*    */   public RaiderPortrait dead(boolean dead) {
/* 37 */     this.dead = dead;
/* 38 */     return this;
/*    */   }
/*    */   
/*    */   public static void render(SPRITE_RENDERER r, int X1, int Y1, int scale, Induvidual indu, boolean dead) {
/* 42 */     int dd = (STATS.APPEARANCE()).dead.indu().get(indu);
/* 43 */     if (dead)
/* 44 */       (STATS.APPEARANCE()).dead.indu().set(indu, 1); 
/* 45 */     STATS.APPEARANCE().portraitRender(r, indu, X1, Y1, scale);
/* 46 */     ((SPRITE)(indu.race().appearance()).crown.raiders().getC(STATS.RAN().get(indu, 9))).renderScaled(r, X1, Y1 + 8 * scale, scale);
/* 47 */     (STATS.APPEARANCE()).dead.indu().set(indu, dd);
/*    */   }
/*    */   
/*    */   protected Induvidual raider() {
/* 51 */     return this.raider;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\raiding\RaiderPortrait.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */