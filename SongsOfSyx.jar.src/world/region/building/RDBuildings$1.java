/*    */ package world.region.building;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.sprite.UI.Icon;
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.TFortification;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ import world.region.RDBoostCache;
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
/*    */   extends RDBoostCache
/*    */ {
/*    */   null(RD.RDInit $anonymous0, String $anonymous1, CharSequence $anonymous2, CharSequence $anonymous3, Icon $anonymous4) {
/* 49 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3, $anonymous4);
/*    */   }
/*    */   protected double pget(Region reg) {
/* 52 */     if (reg == FACTIONS.player().capitolRegion()) {
/* 53 */       double am = 0.0D;
/* 54 */       for (TFortification f : (SETT.TERRAIN()).FORTIFICATIONS.all()) {
/* 55 */         am += f.tile.count();
/*    */       }
/* 57 */       return CLAMP.d(am / SETT.TWIDTH * 4.0D, 0.0D, 1.0D);
/*    */     } 
/* 59 */     return super.pget(reg);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\region\building\RDBuildings$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */