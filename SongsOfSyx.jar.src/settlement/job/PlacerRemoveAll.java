/*    */ package settlement.job;
/*    */ 
/*    */ import game.GAME;
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.room.main.TmpArea;
/*    */ import settlement.room.military.artillery.ArtilleryInstance;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMessages;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ public class PlacerRemoveAll extends PlacableMulti {
/* 18 */   private static CharSequence ¤¤remove = "¤Dismantle";
/* 19 */   private static CharSequence ¤¤desc = "¤Dismantles structures and rooms.";
/*    */   static {
/* 21 */     D.ts(PlacerRemoveAll.class);
/*    */   }
/*    */   
/*    */   public PlacerRemoveAll() {
/* 25 */     super(¤¤remove, ¤¤desc, (SPRITE)(SPRITES.icons()).l.demolish);
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 30 */     return (PLACABLE)(SETT.JOBS()).tool_clear;
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 35 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 36 */     if (r instanceof ArtilleryInstance) {
/* 37 */       return (((ArtilleryInstance)r).army() == GAME.ARMIES().player()) ? null : PlacableMessages.¤¤ROOM_MUST;
/*    */     }
/* 39 */     CharSequence ro = (r != null && !(SETT.ROOMS()).THRONE.is(tx, ty)) ? null : PlacableMessages.¤¤ROOM_MUST;
/* 40 */     CharSequence st = (SETT.JOBS()).clearss.structure.problem(tx, ty, false);
/* 41 */     if (ro == null || st == null)
/* 42 */       return null; 
/* 43 */     return PlacableMessages.¤¤ROOM_OR_STRUCTURE_MUST;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 49 */     if ((SETT.ROOMS()).map.is(tx, ty)) {
/* 50 */       TmpArea aa = (SETT.ROOMS()).map.get(tx, ty).remove(tx, ty, true, this, false);
/* 51 */       if (aa != null)
/* 52 */         aa.clear(); 
/*    */     } 
/* 54 */     if ((SETT.JOBS()).clearss.structure.problem(tx, ty, false) == null) {
/* 55 */       (SETT.JOBS()).clearss.structure.placer().place(tx, ty, a, t);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 60 */     Room r = (SETT.ROOMS()).map.get(fromX, fromY);
/* 61 */     if (r == null)
/* 62 */       return false; 
/* 63 */     if ((SETT.ROOMS()).THRONE.is(fromX, fromY))
/* 64 */       return false; 
/* 65 */     return r.isSame(fromX, fromY, toX, toY);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\PlacerRemoveAll.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */