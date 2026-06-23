/*    */ package settlement.room.infra.hauler;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.file.Json;
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
/*    */ class null
/*    */   extends RoomSprite1x1
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 37 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 41 */     super.render(r, s, data, it, degrade, isCandle);
/* 42 */     HaulerInstance ins = (HaulerInstance)Constructor.this.blue().get(it.tx(), it.ty());
/* 43 */     if (ins != null && (Constructor.this.blue()).crate.get(it.tx(), it.ty(), ins, ins.sdata).resource() != null)
/*    */     {
/* 45 */       (Constructor.this.blue()).crate.resource().renderLaying(r, it.x(), it.y(), it.ran(), (Constructor.this.blue()).crate.amount());
/*    */     }
/* 47 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\hauler\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */