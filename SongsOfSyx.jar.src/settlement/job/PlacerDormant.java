/*    */ package settlement.job;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ final class PlacerDormant
/*    */   extends PlacableMulti
/*    */ {
/* 15 */   private static CharSequence ¤¤name = "¤Suspend Jobs";
/* 16 */   private static CharSequence ¤¤desc = "¤Suspended jobs will not be performed. Useful for planning out your city and controlling which areas will be worked first.";
/*    */   static {
/* 18 */     D.ts(PlacerDormant.class);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PlacerDormant() {
/* 24 */     super(¤¤name, ¤¤desc, (SPRITE)(SPRITES.icons()).l.suspend);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 29 */     ROOM_JOBBER j = ROOM_JOBBER.get(tx, ty);
/* 30 */     if (j != null) {
/* 31 */       return null;
/*    */     }
/* 33 */     int i = tx + ty * SETT.TWIDTH;
/* 34 */     if ((SETT.JOBS()).getter.is(i) && !(SETT.JOBS()).state.is(i, StateManager.State.DORMANT))
/* 35 */       return null; 
/* 36 */     return "";
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 41 */     place(tx, ty);
/*    */   }
/*    */   
/*    */   static void place(int tx, int ty) {
/* 45 */     ROOM_JOBBER r = ROOM_JOBBER.get(tx, ty);
/* 46 */     if (r != null && r.jobToggleIs())
/* 47 */       r.jobToggle(false); 
/* 48 */     int i = tx + ty * SETT.TWIDTH;
/* 49 */     Job j = (Job)(SETT.JOBS()).getter.get(i);
/* 50 */     if (j == null)
/*    */       return; 
/* 52 */     (SETT.JOBS()).state.set(StateManager.State.DORMANT, j);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 58 */     return (PLACABLE)(SETT.JOBS()).tool_activate;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 63 */     ROOM_JOBBER j = ROOM_JOBBER.get(fromX, fromY);
/* 64 */     return (j != null && j.is(toX, toY));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\PlacerDormant.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */