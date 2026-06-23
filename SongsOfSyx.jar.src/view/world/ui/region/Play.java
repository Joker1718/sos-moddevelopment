/*    */ package view.world.ui.region;
/*    */ import game.faction.Faction;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GBox;
/*    */ import util.gui.panel.GFrame;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.tool.ToolManager;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ final class Play implements RV {
/* 18 */   private GETTER.GETTER_IMP<Region> g = new GETTER.GETTER_IMP();
/*    */   
/*    */   private final ISidePanel panel;
/*    */   PlayToolAttack tool;
/*    */   private Faction ff;
/*    */   private final PlayMilitary mi;
/*    */   
/*    */   public Play(ToolManager m, final ISidePanels p) {
/* 26 */     this.tool = new PlayToolAttack(m)
/*    */       {
/*    */         boolean added()
/*    */         {
/* 30 */           return p.added(Play.this.panel);
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 35 */     GuiSection s = new GuiSection()
/*    */       {
/*    */         public void render(SPRITE_RENDERER r, float ds) {
/* 38 */           WORLD.OVERLAY().hover((Region)Play.this.g.get());
/* 39 */           if (Play.this.ff != ((Region)Play.this.g.get()).faction())
/* 40 */             Play.this.panel.last().remove(Play.this.panel); 
/* 41 */           super.render(r, ds);
/*    */         }
/*    */       };
/* 44 */     int w = 600;
/* 45 */     int sep = 580;
/* 46 */     s.body().setWidth(w);
/*    */     
/* 48 */     s.add((RENDEROBJ)new PlayInfo(this.g, w), 0, s.getLastY2());
/* 49 */     s.addRelBody(0, DIR.S, GFrame.separator(sep));
/* 50 */     this.mi = new PlayMilitary(this.g, w);
/* 51 */     s.addRelBody(0, DIR.S, (RENDEROBJ)this.mi);
/* 52 */     s.addRelBody(0, DIR.S, GFrame.separator(sep));
/*    */     
/* 54 */     s.addRelBody(0, DIR.S, (RENDEROBJ)new PlayReligion(this.g, w));
/* 55 */     s.addRelBody(0, DIR.S, GFrame.separator(sep));
/*    */     
/* 57 */     s.addRelBody(0, DIR.S, (RENDEROBJ)new PlayPop(this.g, w, (ISidePanel.HEIGHT - s.body().height()) / 3));
/* 58 */     s.addRelBody(8, DIR.S, (RENDEROBJ)new PlayOutput(this.g, w));
/* 59 */     s.add((RENDEROBJ)new PlayBuildings(this.g, w, ISidePanel.HEIGHT - s.body().height() - 8), 0, s.getLastY2() + 8);
/*    */     
/* 61 */     this.panel = new ISidePanel(s);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ISidePanel get(Region reg) {
/* 69 */     this.g.set(reg);
/* 70 */     this.tool.add((Region)this.g.get());
/* 71 */     this.ff = reg.faction();
/* 72 */     this.panel.titleSet((CharSequence)reg.info.name());
/* 73 */     return this.panel;
/*    */   }
/*    */ 
/*    */   
/*    */   public void hover(GBox box, Region reg) {
/* 78 */     PlayHov.hover(reg, (GUI_BOX)box);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean added(ISidePanels pans, Region reg) {
/* 84 */     return (pans.added(this.panel) && reg == this.g.get());
/*    */   }
/*    */ 
/*    */   
/*    */   public void hoverGarrison(GBox box, Region reg) {
/* 89 */     box.title((CharSequence)reg.info.name());
/* 90 */     this.g.set(reg);
/* 91 */     box.add((RENDEROBJ)this.mi);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\Play.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */