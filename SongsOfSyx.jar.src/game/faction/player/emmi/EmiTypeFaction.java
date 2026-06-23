/*    */ package game.faction.player.emmi;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ 
/*    */ public abstract class EmiTypeFaction
/*    */   extends EmiType<FactionNPC> {
/*    */   EmiTypeFaction(SPRITE icon, CharSequence name, CharSequence desc) {
/* 10 */     super(icon, name, desc, FACTIONS.MAX(), 1000);
/*    */   }
/*    */ 
/*    */   
/*    */   int index(FactionNPC t) {
/* 15 */     return t.index();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\emmi\EmiTypeFaction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */