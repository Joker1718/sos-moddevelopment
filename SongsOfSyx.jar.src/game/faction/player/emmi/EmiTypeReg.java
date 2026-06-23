/*    */ package game.faction.player.emmi;
/*    */ 
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public abstract class EmiTypeReg
/*    */   extends EmiType<Region>
/*    */ {
/*    */   EmiTypeReg(SPRITE icon, CharSequence name, CharSequence desc) {
/* 10 */     super(icon, name, desc, 1023, 1000);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   int index(Region reg) {
/* 16 */     return reg.index();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\emmi\EmiTypeReg.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */