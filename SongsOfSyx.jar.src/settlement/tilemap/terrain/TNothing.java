/*    */ package settlement.tilemap.terrain;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.path.AVAILABILITY;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.gui.misc.GBox;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class TNothing
/*    */   extends Terrain.TerrainTile
/*    */ {
/*    */   protected TNothing(Terrain shared) {
/* 18 */     super("NOTHING", shared, "clear", (SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.terrain, (SPRITE)(SPRITES.icons()).m.cancel), null);
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean place(int x, int y) {
/* 23 */     placeRaw(x, y);
/* 24 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 29 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator i, int data) {
/* 34 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isPlacable(int tx, int ty) {
/* 39 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public AVAILABILITY getAvailability(int tx, int ty) {
/* 44 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void hoverInfo(GBox box, int tx, int ty) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int miniDepth() {
/* 54 */     return 0;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\tilemap\terrain\TNothing.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */