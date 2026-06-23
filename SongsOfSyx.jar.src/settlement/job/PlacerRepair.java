/*    */ package settlement.job;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.Room;
/*    */ import settlement.tilemap.TILE_FIXABLE;
/*    */ import settlement.tilemap.terrain.Terrain;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.AREA;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ import view.tool.PLACABLE;
/*    */ import view.tool.PLACER_TYPE;
/*    */ import view.tool.PlacableMessages;
/*    */ import view.tool.PlacableMulti;
/*    */ 
/*    */ 
/*    */ 
/*    */ class PlacerRepair
/*    */   extends PlacableMulti
/*    */ {
/* 22 */   private static CharSequence ¤¤name = "Repair";
/* 23 */   private static CharSequence ¤¤desc = "Repair damaged structures and rooms.";
/*    */   
/*    */   static {
/* 26 */     D.ts(PlacerRepair.class);
/*    */   }
/*    */   
/*    */   public PlacerRepair() {
/* 30 */     super(¤¤name, ¤¤desc, (SPRITE)(SPRITES.icons()).l.repair);
/*    */   }
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 35 */     if ((SETT.ROOMS()).construction.isRepair(tx, ty))
/* 36 */       return null; 
/* 37 */     Terrain.TerrainTile tt = SETT.TERRAIN().get(tx, ty);
/* 38 */     if (!(tt instanceof TILE_FIXABLE))
/* 39 */       return PlacableMessages.¤¤BROKEN_MUST; 
/* 40 */     Job j = ((TILE_FIXABLE)tt).fixJob(tx, ty);
/* 41 */     if (j == null)
/* 42 */       return PlacableMessages.¤¤BROKEN_MUST; 
/* 43 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty, AREA a, PLACER_TYPE t) {
/* 48 */     if ((SETT.ROOMS()).construction.isRepair(tx, ty)) {
/* 49 */       PlacerActivate.place(tx, ty);
/*    */     } else {
/* 51 */       Terrain.TerrainTile tt = SETT.TERRAIN().get(tx, ty);
/* 52 */       if (tt instanceof TILE_FIXABLE) { TILE_FIXABLE ttt = (TILE_FIXABLE)tt;
/* 53 */         Job j = ttt.fixJob(tx, ty);
/* 54 */         j.placer().place(tx, ty, a, t); }
/*    */     
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderPlaceHolder(SPRITE_RENDERER r, int mask, int x, int y, int tx, int ty, AREA a, PLACER_TYPE t, boolean isPlacable, boolean areaIsPlacable) {
/* 64 */     (SPRITES.cons()).ICO.repair.render(r, x, y);
/*    */   }
/*    */ 
/*    */   
/*    */   public PLACABLE getUndo() {
/* 69 */     return (PLACABLE)(SETT.JOBS()).tool_clear;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean expandsTo(int fromX, int fromY, int toX, int toY) {
/* 74 */     Room r = (SETT.ROOMS()).map.get(fromX, fromY);
/* 75 */     return ((SETT.ROOMS()).construction.isRepair(fromX, fromY) && r.isSame(fromX, fromY, toX, toY));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\job\PlacerRepair.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */