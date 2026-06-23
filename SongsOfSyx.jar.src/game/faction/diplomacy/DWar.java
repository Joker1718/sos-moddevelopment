/*    */ package game.faction.diplomacy;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ 
/*    */ public final class DWar
/*    */   extends DipStance {
/* 12 */   private static CharSequence ¤¤name = "Enemies";
/* 13 */   private static CharSequence ¤¤desc = "Enemies are at war and bent on destroying one another.";
/*    */   
/*    */   static {
/* 16 */     D.ts(DWar.class);
/*    */   }
/*    */   
/*    */   DWar(LISTE<DipStance> all) {
/* 20 */     super(all, "WAR", 0.0D, 0.0D, 0.8D, false, false, false, ¤¤name, ¤¤desc, (SPRITE)(UI.icons()).s.sword.createColored(COLOR.REDISH));
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(Faction faction, Faction other) {
/* 25 */     if (faction == other)
/* 26 */       return false; 
/* 27 */     if (faction == null || other == null)
/* 28 */       return true; 
/* 29 */     return super.is(faction, other);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\DWar.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */