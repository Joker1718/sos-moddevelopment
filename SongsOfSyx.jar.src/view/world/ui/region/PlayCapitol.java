/*    */ package view.world.ui.region;
/*    */ 
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.text.Dic;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.tool.ToolManager;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ final class PlayCapitol implements RV {
/* 16 */   private GETTER.GETTER_IMP<Region> g = new GETTER.GETTER_IMP();
/*    */   
/*    */   private final ISidePanel panel;
/*    */   PlayToolAttack tool;
/*    */   
/*    */   public PlayCapitol(ToolManager m, final ISidePanels p) {
/* 22 */     this.tool = new PlayToolAttack(m)
/*    */       {
/*    */         boolean added()
/*    */         {
/* 26 */           return p.added(PlayCapitol.this.panel);
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 31 */     GuiSection s = new GuiSection()
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, float ds) {
/* 34 */           WORLD.OVERLAY().hover((Region)PlayCapitol.this.g.get());
/* 35 */           super.render(r, ds);
/*    */         }
/*    */       };
/*    */     
/* 39 */     s.add(MiscMore.garrison(this.g, 256));
/*    */ 
/*    */     
/* 42 */     this.panel = new ISidePanel(s);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ISidePanel get(Region reg) {
/* 50 */     this.g.set(reg);
/* 51 */     this.tool.add((Region)this.g.get());
/*    */     
/* 53 */     this.panel.titleSet(Dic.¤¤Capitol);
/* 54 */     return this.panel;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hover(GBox box, Region reg) {
/* 59 */     PlayHov.hover(reg, (GUI_BOX)box);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean added(ISidePanels pans, Region reg) {
/* 65 */     return (pans.added(this.panel) && reg == this.g.get());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverGarrison(GBox box, Region reg) {
/* 72 */     PlayHov.hover(reg, (GUI_BOX)box);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\PlayCapitol.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */