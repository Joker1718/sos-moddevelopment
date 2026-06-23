/*    */ package settlement.job;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.UI;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class PlacerActivate
/*    */   extends PlacableMulti
/*    */ {
/* 19 */   private static CharSequence ¤¤name = "¤Activate Job";
/* 20 */   private static CharSequence ¤¤desc = "¤Activates suspended jobs.";
/*    */   static {
/* 22 */     D.ts(PlacerActivate.class);
/*    */   }
/*    */   
/*    */   public PlacerActivate() {
/* 26 */     super(¤¤name, ¤¤desc, (SPRITE)(SPRITES.icons()).l.suspend.twin((SPRITE)(UI.icons()).m.anti, DIR.C, 1));
/*    */   }
/*    */   
/*    */   static void place(int tx, int ty) {
/* 30 */     int i = tx + ty * SETT.TWIDTH;
/* 31 */     if ((SETT.JOBS()).getter.is(i)) {
/* 32 */       (SETT.JOBS()).state.activate(i, (Job)(SETT.JOBS()).getter.get(i));
/*    */     }
/* 34 */     ROOM_JOBBER j = ROOM_JOBBER.get(tx, ty);
/* 35 */     if (j != null && !j.jobToggleIs()) {
/* 36 */       j.jobToggle(true);
/*    */     }
/*    */   }
/*    */   
/*    */   public PLACABLE getUndo() {
/* 41 */     return (PLACABLE)(SETT.JOBS()).tool_dormant;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 46 */     ROOM_JOBBER j = ROOM_JOBBER.get(fromX, fromY);
/* 47 */     return (j != null && j.is(toX, toY));
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 52 */     int i = tx + ty * SETT.TWIDTH;
/*    */     
/* 54 */     ROOM_JOBBER j = ROOM_JOBBER.get(tx, ty);
/*    */     
/* 56 */     if ((SETT.ROOMS()).map.is(i)) {
/*    */       
/* 58 */       if (j != null)
/* 59 */         return null; 
/* 60 */     } else if ((SETT.JOBS()).getter.is(i) && 
/* 61 */       (SETT.JOBS()).state.is(i, StateManager.State.DORMANT)) {
/* 62 */       return null;
/*    */     } 
/* 64 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 69 */     int i = tx + ty * SETT.TWIDTH;
/* 70 */     if ((SETT.JOBS()).getter.is(i)) {
/* 71 */       (SETT.JOBS()).state.activate(i, (Job)(SETT.JOBS()).getter.get(i));
/*    */     }
/* 73 */     ROOM_JOBBER j = ROOM_JOBBER.get(tx, ty);
/* 74 */     if (j != null && !j.jobToggleIs())
/* 75 */       j.jobToggle(true); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\PlacerActivate.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */