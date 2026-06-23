/*    */ package init.value;
/*    */ 
/*    */ import game.GameDisposable;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.royalty.Royalty;
/*    */ import init.INIT;
/*    */ import settlement.stats.Induvidual;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.data.GETTER;
/*    */ import view.interrupter.IDebugPanel;
/*    */ import view.main.VIEW;
/*    */ import view.ui.util.UIValues;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ public class GVALUES
/*    */   extends INIT.InitResource {
/*    */   public static final String KEY = "VALUE";
/* 20 */   public static final GValueCat<Induvidual> INDU = new GValueCat<>("HUMAN");
/* 21 */   public static final GValueCat<Region> REGION = new GValueCat<>("REGION");
/* 22 */   public static final GValueCat<Faction> FACTION = new GValueCat<>("FACTION");
/* 23 */   public static final GValueCat<Royalty> ROYALTY = new GValueCat<>("ROYALTY");
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
/*    */   public GVALUES(INIT init) {
/* 39 */     super(init);
/* 40 */     INDU.clear();
/* 41 */     REGION.clear();
/* 42 */     FACTION.clear();
/* 43 */     ROYALTY.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void finishSetup() {
/* 51 */     GValuesInit.init();
/* 52 */     INDU.init();
/* 53 */     REGION.init();
/* 54 */     FACTION.init();
/* 55 */     ROYALTY.init();
/* 56 */     IDebugPanel.add("values", new ACTION()
/*    */         {
/*    */           public void exe()
/*    */           {
/* 60 */             GETTER<Faction> g = new GETTER<Faction>()
/*    */               {
/*    */                 public Faction get()
/*    */                 {
/* 64 */                   return (Faction)FACTIONS.player();
/*    */                 }
/*    */               };
/*    */             
/* 68 */             (VIEW.inters()).popup.show((RENDEROBJ)new UIValues(GVALUES.FACTION, g), null);
/*    */           }
/*    */         });
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\value\GVALUES.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */