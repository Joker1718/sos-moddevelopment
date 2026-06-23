/*    */ package settlement.room.infra.station;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.file.Json;
/*    */ import util.GUTIL;
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
/*    */   final RoomSprite water;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/* 73 */     super($anonymous0, $anonymous1);
/*    */     
/* 75 */     this.water = (RoomSprite)new RoomSprite1x1(paramJson1, "ANIMAL_BOTTOM_1X1");
/*    */   }
/*    */   
/*    */   public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 79 */     StationInstance ins = (StationInstance)blue.get(it.tx(), it.ty());
/* 80 */     if (ins != null && 
/* 81 */       ins.prepD() + (GUTIL.ran2().get(it.tile()) & 0xFF) * 0.00392156862745098D >= 1.0D)
/* 82 */       this.water.render(r, s, data, it, degrade, false); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\station\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */