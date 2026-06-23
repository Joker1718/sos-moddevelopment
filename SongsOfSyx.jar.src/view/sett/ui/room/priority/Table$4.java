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
/* 83 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   protected void clickA() {
/* 87 */     for (Filter.FilterEntry<RoomEmployment> e : (Iterable<Filter.FilterEntry<RoomEmployment>>)fRoom.all) {
/* 88 */       if (fRoom.active(e))
/* 89 */         for (Filter.FilterEntry<WGROUP> g : (Iterable<Filter.FilterEntry<WGROUP>>)filterGroup.all) {
/* 90 */           if (filterGroup.active(g) && ((RoomEmployment)e.o).priorities.get((WGROUP)g.o) == prio)
/* 91 */             ((RoomEmployment)e.o).priorities.inc((WGROUP)g.o, -1); 
/*    */         }  
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Table$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */