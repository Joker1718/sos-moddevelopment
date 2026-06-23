/*    */ package view.world.ui.army;
/*    */ 
/*    */ import snake2d.util.gui.GUI_BOX;
/*    */ import view.interrupter.ISidePanels;
/*    */ import view.main.VIEW;
/*    */ import world.entity.army.WArmy;
/*    */ 
/*    */ public final class UIArmies
/*    */ {
/* 10 */   private final List list = new List();
/* 11 */   final Army army = new Army();
/* 12 */   private final Hoverer hoverer = new Hoverer();
/*    */   
/*    */   public void openList(WArmy f) {
/* 15 */     openList(f, (VIEW.world()).panels);
/*    */   }
/*    */   
/*    */   public void open(WArmy f) {
/* 19 */     (VIEW.world()).panels.add(this.army.get(f), true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void openList(WArmy f, ISidePanels m) {
/* 24 */     m.add(this.list, true);
/* 25 */     if (f != null) {
/* 26 */       this.list.set(f);
/* 27 */       m.add(this.army.get(f), false);
/* 28 */       (VIEW.world()).window.centerer.set(f.body().cX(), f.body().cY());
/*    */     } else {
/* 30 */       m.add(this.list, true);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean listIsOpen(ISidePanels m) {
/* 36 */     return m.added(this.list);
/*    */   }
/*    */   
/*    */   public void close(ISidePanels m) {
/* 40 */     m.remove(this.list);
/*    */   }
/*    */   
/*    */   public void hover(GUI_BOX box, WArmy a) {
/* 44 */     this.hoverer.hover(box, a);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\army\UIArmies.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */