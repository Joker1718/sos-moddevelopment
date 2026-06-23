/*    */ package settlement.job;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.tilemap.terrain.TGrowable;
/*    */ import settlement.tilemap.terrain.Terrain;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMessages;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ 
/*    */ final class PlacerDelete
/*    */   extends PlacableMulti
/*    */ {
/* 18 */   private static CharSequence ¤¤name = "Cancel Jobs";
/* 19 */   private static CharSequence ¤¤desc = "Cancels all jobs and room plans.";
/*    */   static {
/* 21 */     D.ts(PlacerDelete.class);
/*    */   }
/*    */   
/*    */   public PlacerDelete() {
/* 25 */     super(¤¤name, ¤¤desc, (SPRITE)(SPRITES.icons()).m.cancel);
/*    */   }
/*    */ 
/*    */   
/*    */   static void place(int tx, int ty) {
/* 30 */     if ((SETT.JOBS()).getter.is(tx, ty)) {
/* 31 */       (SETT.JOBS()).state.clear(tx, ty);
/*    */     }
/* 33 */     Terrain.TerrainTile t = SETT.TERRAIN().get(tx, ty);
/* 34 */     if (t instanceof TGrowable) {
/* 35 */       TGrowable b = (TGrowable)t;
/* 36 */       b.job.set(tx, ty, false);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 43 */     if ((SETT.ROOMS()).construction.isser.is(fromX, fromY)) {
/* 44 */       return (SETT.ROOMS()).map.get(fromX, fromY).isSame(fromX, fromY, toX, toY);
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 52 */     if ((SETT.JOBS()).clearss.huntundo.isPlacable(tx, ty, a, t) == null) {
/* 53 */       return null;
/*    */     }
/*    */     
/* 56 */     if ((SETT.ROOMS()).construction.isser.is(tx, ty))
/* 57 */       return null; 
/* 58 */     ROOM_JOBBER j = ROOM_JOBBER.get(tx, ty);
/* 59 */     if (j != null)
/* 60 */       return PlacableMessages.¤¤JOB_MUST; 
/* 61 */     if (!(SETT.JOBS()).getter.is(tx, ty) && 
/* 62 */       !((TGrowable)(SETT.TERRAIN()).GROWABLES.get(0)).job.is(tx, ty)) {
/* 63 */       return PlacableMessages.¤¤JOB_MUST;
/*    */     }
/* 65 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 72 */     if ((SETT.JOBS()).clearss.huntundo.isPlacable(tx, ty, a, t) == null) {
/* 73 */       (SETT.JOBS()).clearss.huntundo.place(tx, ty, a, t);
/*    */     }
/*    */     
/* 76 */     if ((SETT.ROOMS()).construction.isser.is(tx, ty)) {
/* 77 */       (SETT.ROOMS()).map.get(tx, ty).remove(tx, ty, true, this, false).clear();
/*    */     }
/* 79 */     Job j = (Job)(SETT.JOBS()).getter.get(tx, ty);
/* 80 */     if (j != null)
/* 81 */       j.cancel(tx, ty); 
/* 82 */     place(tx, ty);
/* 83 */     if (((TGrowable)(SETT.TERRAIN()).GROWABLES.get(0)).job.is(tx, ty)) {
/* 84 */       ((TGrowable)(SETT.TERRAIN()).GROWABLES.get(0)).job.set(tx, ty, false);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean canBePlacedAs(PLACER_TYPE t) {
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\PlacerDelete.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */