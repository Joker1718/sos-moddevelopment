/*    */ package game.battle.thread.general;
/*    */ 
/*    */ import settlement.main.ON_TOP_RENDERABLE;
/*    */ import snake2d.Renderer;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
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
/*    */   public void render(Renderer r, ShadowBatch shadowBatch, RenderData data, double ds) {
/* 39 */     RenderData.RenderIterator it = data.onScreenTiles();
/*    */     
/* 41 */     if ((Strategos2000.null.access$0(Strategos2000.null.this)).current == null) {
/*    */       return;
/*    */     }
/* 44 */     while (it.has()) {
/* 45 */       (Strategos2000.null.access$0(Strategos2000.null.this)).current.render(r, it);
/* 46 */       it.next();
/*    */     } 
/*    */     
/* 49 */     (Strategos2000.null.access$0(Strategos2000.null.this)).current.render(r, shadowBatch, data);
/*    */     
/* 51 */     if (!(Strategos2000.null.access$0(Strategos2000.null.this)).debug)
/* 52 */       remove(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\general\Strategos2000$1$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */