/*    */ package world.map.pathing;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.PathTile;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.Coo;
/*    */ import view.main.VIEW;
/*    */ import view.subview.GameWindow;
/*    */ import view.tool.PlacableSimpleTile;
/*    */ import world.WORLD;
/*    */ 
/*    */ public class DebugPlacer
/*    */   extends PlacableSimpleTile
/*    */ {
/* 16 */   private Coo clicked = new Coo();
/*    */ 
/*    */   
/*    */   public DebugPlacer() {
/* 20 */     super("world path");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public CharSequence isPlacable(int tx, int ty) {
/* 27 */     return (WORLD.PATH()).map.is.is(tx, ty) ? null : E;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void place(int tx, int ty) {
/* 33 */     this.clicked.set(tx, ty);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderOverlay(GameWindow window) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderExtra(SPRITE_RENDERER r) {
/* 46 */     if (!(WORLD.PATH()).map.is.is((COORDINATE)this.clicked)) {
/*    */       return;
/*    */     }
/* 49 */     PathTile t = WORLD.PATH().path((COORDINATE)this.clicked, (COORDINATE)(VIEW.world()).window.tile(), WRegFinder.Treaty.DUMMY);
/*    */     
/* 51 */     GameWindow w = (VIEW.world()).window;
/*    */     
/* 53 */     while (t != null) {
/*    */       
/* 55 */       int x = (t.x() - w.tile().x()) * 64 + w.tile().rel().x();
/* 56 */       int y = (t.y() - w.tile().y()) * 64 + w.tile().rel().y();
/* 57 */       (SPRITES.cons()).BIG.line.render(r, 0, x, y);
/* 58 */       t = t.getParent();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\pathing\DebugPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */