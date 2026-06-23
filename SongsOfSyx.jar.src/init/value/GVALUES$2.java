/*    */ package init.value;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.data.GETTER;
/*    */ import view.main.VIEW;
/*    */ import view.ui.util.UIValues;
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
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 60 */     GETTER<Faction> g = new GETTER<Faction>()
/*    */       {
/*    */         public Faction get()
/*    */         {
/* 64 */           return (Faction)FACTIONS.player();
/*    */         }
/*    */       };
/*    */     
/* 68 */     (VIEW.inters()).popup.show((RENDEROBJ)new UIValues(GVALUES.FACTION, g), null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\GVALUES$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */