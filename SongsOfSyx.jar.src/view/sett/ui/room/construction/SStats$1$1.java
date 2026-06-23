/*    */ package view.sett.ui.room.construction;
/*    */ 
/*    */ import settlement.tilemap.terrain.TBuilding;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.info.GFORMAT;
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
/*    */   extends GStat
/*    */ {
/*    */   public void update(GText text) {
/* 53 */     int am = s.placement.placer.structure.roofs() * ((TBuilding)s.placement.placer.structure.get()).structure.resAmount;
/* 54 */     am += s.placement.placer.structure.walls() * ((TBuilding)s.placement.placer.structure.get()).structure.resAmount;
/* 55 */     GFORMAT.i(text, am);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\construction\SStats$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */