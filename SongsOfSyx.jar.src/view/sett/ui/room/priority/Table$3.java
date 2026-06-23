/*    */ package view.sett.ui.room.priority;
/*    */ 
/*    */ import init.type.WGROUP;
/*    */ import settlement.room.main.employment.RoomEmployment;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GButt;
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
/*    */   extends GButt.ButtPanel
/*    */ {
/*    */   null(SPRITE $anonymous0) {
/* 61 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 65 */     for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/* 66 */       if (fRoom.active(e))
/* 67 */         for (Filter.FilterEntry<WGROUP> g : (Iterable<Filter.FilterEntry<WGROUP>>)filterGroup.all) {
/* 68 */           if (filterGroup.active(g) && ((RoomEmployment)e.o).priorities.get((WGROUP)g.o) == prio)
/* 69 */             ((RoomEmployment)e.o).priorities.inc((WGROUP)g.o, 1); 
/*    */         }  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Table$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */