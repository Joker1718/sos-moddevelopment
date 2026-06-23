/*    */ package settlement.room.service.hygine.bath;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import init.sprite.SPRITES;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.util.RoomInitData;
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import settlement.room.sprite.RoomSpriteCombo;
/*    */ import settlement.room.sprite.RoomSpriteTex;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.color.OpacityImp;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sprite.TextureCoords;
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
/*    */ class null
/*    */   extends RoomSpriteCombo
/*    */ {
/*    */   RoomSprite spriteFloor;
/*    */   COLOR wColor;
/*    */   double wOp;
/*    */   OpacityImp opacity;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1, Json paramJson1, RoomInitData paramRoomInitData) throws IOException {
/* 64 */     super($anonymous0, $anonymous1);
/*    */     
/* 66 */     this.spriteFloor = (RoomSprite)new RoomSpriteTex(paramJson1, "POOL_FLOOR_TEXTURE");
/* 67 */     this.wColor = (COLOR)new ColorImp(paramRoomInitData.data(), "WATER_COLOR");
/* 68 */     this.wOp = paramRoomInitData.data().d("WATER_OPACITY", 0.0D, 1.0D);
/* 69 */     this.opacity = new OpacityImp((int)(255.0D * this.wOp * 0.5D));
/*    */   }
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 73 */     this.spriteFloor.render(r, ShadowBatch.DUMMY, 0, it, degrade, isCandle);
/* 74 */     if (blue.is(it.tile())) {
/* 75 */       int i = (SETT.ROOMS()).data.get(it.tile()) & 0x1;
/* 76 */       if (i > 0) {
/* 77 */         renderB(r, s, it);
/*    */       }
/*    */     } 
/* 80 */     return super.render(r, s, data, it, degrade, isCandle);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderB(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 85 */     int x2 = it.x() + 64;
/* 86 */     int y2 = it.y() + 64;
/*    */ 
/*    */     
/* 89 */     this.wColor.bind();
/* 90 */     this.opacity.bind();
/* 91 */     TextureCoords oo = (SPRITES.textures()).dis_small.get((it.tx() * 16) + (SETT.WEATHER()).wind.time.getD() * 16.0D, (it.ty() * 16) + (SETT.WEATHER()).wind.time.getD() * 16.0D);
/* 92 */     CORE.renderer().renderSprite(it.x(), x2, it.y(), y2, oo);
/* 93 */     oo = (SPRITES.textures()).dis_small.get(((it.tx() + 1) * 16) - 8.0D * TIME.currentSecond(), ((it.ty() + 1) * 16) - 8.0D * TIME.currentSecond());
/* 94 */     CORE.renderer().renderSprite(it.x(), x2, it.y(), y2, oo);
/* 95 */     COLOR.unbind();
/* 96 */     OPACITY.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\hygine\bath\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */