/*    */ package settlement.misc.placers;
/*    */ 
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import view.sett.IDebugPanelSett;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PlacableFixed;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ComplexPlacers
/*    */ {
/*    */   public final ArrayList<PLACABLE> ALL;
/*    */   public final PlacableFixed landingParty;
/*    */   
/*    */   public ComplexPlacers() {
/* 16 */     this.landingParty = (PlacableFixed)PlacerLanding.get();
/* 17 */     this.ALL = new ArrayList(this.landingParty);
/*    */     
/* 19 */     IDebugPanelSett.add("complex", (Iterable)this.ALL);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\misc\placers\ComplexPlacers.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */