/*    */ package settlement.room.infra.export;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import init.resources.RESOURCE;
/*    */ import init.trade.TR;
/*    */ import init.trade.TRADABLE;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import util.data.GETTER;
/*    */ import util.gui.common.UIPickerRes;
/*    */ import util.gui.misc.GBox;
/*    */ import view.main.VIEW;
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
/*    */   extends UIPickerRes
/*    */ {
/*    */   null(boolean $anonymous0) {
/* 77 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void select(RESOURCE r, int li) {
/* 81 */     ((ExportInstance)g.get()).resourceSet(r);
/* 82 */     (VIEW.inters()).popup.close();
/*    */   }
/*    */ 
/*    */   
/*    */   protected RESOURCE getResource() {
/* 87 */     return ((ExportInstance)g.get()).resource();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void hoverResource(RESOURCE res, GBox b) {
/* 93 */     FACTIONS.player().seller((TRADABLE)TR.get(res)).hover((GUI_BOX)b);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\export\Gui$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */