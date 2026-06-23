/*    */ package settlement.job;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public interface ROOM_JOBBER
/*    */   extends AREA
/*    */ {
/*    */   void jobFinsih(int paramInt1, int paramInt2, RESOURCE paramRESOURCE, int paramInt3);
/*    */   
/*    */   void jobToggle(boolean paramBoolean);
/*    */   
/*    */   boolean jobToggleIs();
/*    */   
/*    */   default void jobSet(int tx, int ty, boolean active, RESOURCE res) {
/* 31 */     boolean dd = (SETT.JOBS()).planMode.is();
/*    */     
/* 33 */     (SETT.JOBS()).planMode.set(active);
/*    */     
/* 35 */     if (res == null) {
/* 36 */       Placer.place(tx, ty, (SETT.JOBS()).room);
/*    */     } else {
/* 38 */       Placer.place(tx, ty, (SETT.JOBS()).rooms[res.bIndex()]);
/* 39 */     }  if (!active) {
/* 40 */       PlacerDormant.place(tx, ty);
/*    */     } else {
/* 42 */       PlacerActivate.place(tx, ty);
/*    */     } 
/* 44 */     (SETT.JOBS()).planMode.set(dd);
/*    */   }
/*    */   
/*    */   static void render(Renderer r, ShadowBatch shadowBatch, RenderData.RenderIterator it, boolean repairing) {
/* 48 */     if (repairing) {
/* 49 */       it.lit();
/* 50 */       (GCOLOR.MAP()).JOB_ACTIVE.bind();
/* 51 */       (SPRITES.cons()).BIG.dashed.render((SPRITE_RENDERER)r, 15, it.x(), it.y());
/* 52 */       COLOR.unbind();
/*    */     } 
/*    */   }
/*    */   
/*    */   default void jobClear(int tx, int ty) {
/* 57 */     PlacerDelete.place(tx, ty);
/*    */   }
/*    */   
/*    */   static ROOM_JOBBER get(int tx, int ty) {
/* 61 */     Room r = (SETT.ROOMS()).map.get(tx, ty);
/* 62 */     if (r != null && r instanceof ROOM_JOBBER)
/* 63 */       return (ROOM_JOBBER)r; 
/* 64 */     return null;
/*    */   }
/*    */   
/*    */   boolean needsFertilityToBeCleared(int paramInt1, int paramInt2);
/*    */   
/*    */   default boolean needsTerrainToBeCleared(int tx, int ty) {
/* 70 */     return true;
/*    */   }
/*    */   
/*    */   boolean becomesSolid(int paramInt1, int paramInt2);
/*    */   
/*    */   int totalResourcesNeeded(int paramInt1, int paramInt2);
/*    */   
/*    */   boolean isJobActive();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\ROOM_JOBBER.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */