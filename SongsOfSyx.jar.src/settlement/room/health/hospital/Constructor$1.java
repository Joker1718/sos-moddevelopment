/*    */ package settlement.room.health.hospital;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.industry.module.Industry;
/*    */ import settlement.room.industry.module.IndustryResource;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Constructor.SBedSprite
/*    */ {
/*    */   null(Constructor paramConstructor2, RoomSprite1x1 $anonymous0, Json $anonymous1, String $anonymous2, boolean $anonymous3) throws IOException {
/* 47 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*    */   }
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 50 */     if (Bed.res2(it.tx(), it.ty()))
/* 51 */       ((IndustryResource)((Industry)blue.indus.get(0)).ins().get(1)).resource.renderLaying(r, it.x(), it.y(), it.ran(), 1.0D); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\health\hospital\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */