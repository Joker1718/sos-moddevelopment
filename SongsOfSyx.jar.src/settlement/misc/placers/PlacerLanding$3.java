/*    */ package settlement.misc.placers;
/*    */ 
/*    */ import game.boosting.BOOSTABLES;
/*    */ import game.boosting.BOOSTABLE_O;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.FCredits;
/*    */ import init.sprite.SPRITES;
/*    */ import init.type.HCLASS_RACE;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.sprite.SPRITE;
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
/*    */   implements Tile
/*    */ {
/*    */   public SPRITE sprite(TileGrid grid, int rx, int ry, int mask) {
/* 63 */     return (SPRITES.cons()).ICO.cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 68 */     (SETT.ROOMS()).THRONE.init.place(tx, ty, 2);
/*    */     
/* 70 */     FACTIONS.player().credits().inc((int)(5000.0D * (BOOSTABLES.CIVICS()).LANDING.get((BOOSTABLE_O)HCLASS_RACE.clP(null, null))), FCredits.CTYPE.MISC);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean placable(int tx, int ty, TileGrid grid, int rx, int ry) {
/* 76 */     return (SETT.ROOMS()).THRONE.init.placableTile(tx, ty);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\PlacerLanding$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */