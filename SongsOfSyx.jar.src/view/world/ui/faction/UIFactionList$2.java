/*    */ package view.world.ui.faction;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.gui.GuiSection;
/*    */ import world.WORLD;
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
/*    */   extends GuiSection
/*    */ {
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 83 */     UIFactionList.this.sorted.clear();
/* 84 */     for (FactionNPC f : FACTIONS.NPCs())
/* 85 */       UIFactionList.this.sorter.add(f); 
/* 86 */     while (UIFactionList.this.sorter.hasMore()) {
/* 87 */       FactionNPC f = (FactionNPC)UIFactionList.this.sorter.pollSmallest();
/* 88 */       if (UIFactionList.this.filter.text().length() > 0) {
/* 89 */         if (f.name.containsText((CharSequence)UIFactionList.this.filter.text()))
/* 90 */           UIFactionList.this.sorted.add(f);  continue;
/*    */       } 
/* 92 */       UIFactionList.this.sorted.add(f);
/*    */     } 
/* 94 */     (WORLD.OVERLAY()).factions.add();
/*    */     
/* 96 */     super.render(r, ds);
/* 97 */     UIFactionList.this.hovered = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\faction\UIFactionList$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */