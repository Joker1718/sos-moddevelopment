/*    */ package settlement.room.military.artillery;
/*    */ 
/*    */ import init.sprite.game.SheetPair;
/*    */ import java.io.IOException;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSpriteXxX;
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
/*    */ class null
/*    */   extends RoomSpriteXxX
/*    */ {
/*    */   RoomSprite srot;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, int $anonymous2, Json paramJson1) throws IOException {
/* 36 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */     
/* 38 */     this.srot = (RoomSprite)new RoomSpriteXxX(paramJson1, "ARM_ROT_2X2", 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 43 */     int rot = 0;
/* 44 */     ArtilleryInstance ins = (ArtilleryInstance)blue.get(it.tx(), it.ty());
/* 45 */     if (ins != null) {
/* 46 */       rot = ins.dirCurrent().id();
/*    */     }
/*    */     
/* 49 */     data = setRot(data, rot / 2);
/*    */     
/* 51 */     if ((rot & 0x1) == 1) {
/* 52 */       return this.srot.render(r, s, data, it, degrade, isCandle);
/*    */     }
/* 54 */     return super.render(r, s, data, it, degrade, isCandle);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int frame(SheetPair a, RenderData.RenderIterator it) {
/* 60 */     ArtilleryInstance ins = (ArtilleryInstance)blue.get(it.tx(), it.ty());
/* 61 */     if (ins != null && 
/* 62 */       ins.isLoaded) {
/* 63 */       return 0;
/*    */     }
/*    */     
/* 66 */     return 1;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\artillery\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */