/*    */ package settlement.room.law.prison;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSprite1x1;
/*    */ import settlement.room.sprite.RoomSpriteCombo;
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
/*    */   extends Constructor.SCellOther
/*    */ {
/*    */   RoomSprite1x1 full;
/*    */   
/*    */   null(RoomSpriteCombo $anonymous0, RoomSprite1x1 $anonymous1, RoomSprite $anonymous2, Json paramJson) throws IOException {
/* 60 */     super($anonymous0, $anonymous1, $anonymous2);
/* 61 */     this.full = new RoomSprite1x1(paramJson, "LATRINE_FULL_1X1");
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 66 */     if (Constructor.this.blue().is(it.tile()) && Latrine.latrineUsed((SETT.ROOMS()).data.get(it.tile())))
/* 67 */       return this.full.render(r, s, data, it, degrade, isCandle); 
/* 68 */     return super.render(r, s, data, it, degrade, isCandle);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\prison\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */