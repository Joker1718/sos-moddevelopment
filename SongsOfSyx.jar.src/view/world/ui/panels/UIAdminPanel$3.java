/*    */ package view.world.ui.panels;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GStat;
/*    */ import util.gui.misc.GText;
/*    */ import util.gui.table.GTableBuilder;
/*    */ import util.info.GFORMAT;
/*    */ import view.interrupter.ISidePanel;
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.main.VIEW;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
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
/*    */   extends GTableBuilder.GRowBuilder
/*    */ {
/*    */   public RENDEROBJ build(final GETTER<Integer> ier) {
/* 51 */     GuiSection s = new GuiSection()
/*    */       {
/*    */         protected void clickA() {
/* 54 */           Region r = FACTIONS.player().realm().region(((Integer)ier.get()).intValue() + 1);
/* 55 */           if (r != null) {
/* 56 */             ISidePanel pp = (VIEW.world()).UI.regions.get(r);
/* 57 */             panels.clear();
/* 58 */             panels.add(UIAdminPanel.null.access$0(UIAdminPanel.null.this), true);
/* 59 */             panels.add(pp, false);
/*    */           } 
/*    */         }
/*    */         
/*    */         public void hoverInfoGet(GUI_BOX text) {
/* 64 */           Region r = FACTIONS.player().realm().region(((Integer)ier.get()).intValue() + 1);
/* 65 */           if (r != null) {
/* 66 */             (VIEW.world()).UI.regions.hover(r, text);
/*    */           }
/*    */         }
/*    */       };
/* 70 */     s.add((RENDEROBJ)(new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 74 */             Region r = FACTIONS.player().realm().region(((Integer)ier.get()).intValue() + 1);
/* 75 */             if (r != null) {
/* 76 */               text.add((CharSequence)r.info.name());
/*    */             }
/*    */           }
/* 79 */         }).r(DIR.W));
/* 80 */     s.addRightC(180, (SPRITE)new GStat()
/*    */         {
/*    */           public void update(GText text)
/*    */           {
/* 84 */             Region r = FACTIONS.player().realm().region(((Integer)ier.get()).intValue() + 1);
/* 85 */             if (r != null)
/* 86 */               GFORMAT.iIncr(text, (RD.BUILDINGS()).costs.GOV.consumed(r)); 
/* 87 */             text.s();
/* 88 */             text.add((RD.BUILDINGS()).costs.GOV.consumed((Faction)FACTIONS.player()));
/*    */           }
/*    */         });
/*    */     
/* 92 */     s.body().setWidth(250.0D);
/* 93 */     s.pad(0, 6);
/*    */     
/* 95 */     return (RENDEROBJ)s;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\panels\UIAdminPanel$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */