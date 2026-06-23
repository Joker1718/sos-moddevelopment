/*    */ package view.world.ui.faction;
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import init.sprite.UI.UI;
/*    */ import java.util.LinkedList;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.data.GETTER;
/*    */ import util.gui.misc.GButt;
/*    */ import util.gui.table.GScrollRows;
/*    */ import view.main.VIEW;
/*    */ 
/*    */ final class Debug extends GButt.ButtPanel {
/* 18 */   private final GuiSection s = new GuiSection();
/*    */   
/*    */   public Debug(final GETTER<FactionNPC> g) {
/* 21 */     super((SPRITE)(UI.icons()).s.cog);
/*    */     
/* 23 */     LinkedList<RENDEROBJ> rows = new LinkedList<>();
/*    */     
/* 25 */     rows.add(new GButt.ButtPanel("War + 1")
/*    */         {
/*    */           protected void clickA() {
/* 28 */             for (FactionNPC f : FACTIONS.NPCs()) {
/* 29 */               if (f.isActive() && f != g.get() && !DIP.WAR().is((Faction)f, (Faction)g.get())) {
/* 30 */                 DIP.WAR().set((Faction)f, (Faction)g.get());
/*    */                 return;
/*    */               } 
/*    */             } 
/* 34 */             super.clickA();
/*    */           }
/*    */         });
/*    */     
/* 38 */     rows.add(new GButt.ButtPanel("Peace + 1")
/*    */         {
/*    */           protected void clickA() {
/* 41 */             for (FactionNPC f : FACTIONS.NPCs()) {
/* 42 */               if (f.isActive() && f != g.get() && DIP.WAR().is((Faction)f, (Faction)g.get())) {
/* 43 */                 DIP.NEUTRAL().set((Faction)f, (Faction)g.get());
/*    */                 return;
/*    */               } 
/*    */             } 
/* 47 */             super.clickA();
/*    */           }
/*    */         });
/*    */     
/* 51 */     rows.add(new GButt.ButtPanel("War player")
/*    */         {
/*    */           protected void clickA() {
/* 54 */             if (((FactionNPC)g.get()).isActive()) {
/* 55 */               DIP.WAR().set((Faction)FACTIONS.player(), (Faction)g.get());
/*    */             }
/*    */           }
/*    */         });
/* 59 */     this.s.add((RENDEROBJ)(new GScrollRows(rows, 500)).view());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void clickA() {
/* 65 */     (VIEW.inters()).popup.show((RENDEROBJ)this.s, (CLICKABLE)this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\Debug.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */