/*    */ package settlement.path;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import util.data.BOOLEAN;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import view.sett.IDebugPanelSett;
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
/*    */   extends ON_TOP_RENDERABLE
/*    */ {
/*    */   null() {
/* 50 */     IDebugPanelSett.add("availability", (BOOLEAN.BOOLEAN_MUTABLE)new BOOLEAN.BOOLEANImp()
/*    */         {
/*    */           public BOOLEAN.BOOLEAN_MUTABLE set(boolean bool) {
/* 53 */             if (bool) {
/* 54 */               PATHING.null.this.add();
/*    */             } else {
/* 56 */               PATHING.null.this.remove();
/* 57 */             }  return super.set(bool);
/*    */           }
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           public boolean is() {
/* 64 */             return false;
/*    */           }
/*    */         });
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 72 */     RenderData.RenderIterator i = data.onScreenTiles();
/* 73 */     COLOR.WHITE65.bind();
/* 74 */     while (i.has()) {
/* 75 */       if (PATHING.this.cost.get(i.tile()) < 0.0D) {
/* 76 */         COLOR.RED100.bind();
/* 77 */       } else if (PATHING.this.cost.get(i.tile()) == 1.0D) {
/* 78 */         COLOR.BLUE100.bind();
/*    */       } else {
/* 80 */         COLOR.YELLOW100.bind();
/* 81 */       }  (SPRITES.cons()).BIG.dashed.render((SPRITE_RENDERER)r, 15, i.x(), i.y());
/* 82 */       i.next();
/*    */     } 
/* 84 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\path\PATHING$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */