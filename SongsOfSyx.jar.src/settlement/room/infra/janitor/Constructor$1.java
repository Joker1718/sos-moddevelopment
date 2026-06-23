/*    */ package settlement.room.infra.janitor;
/*    */ 
/*    */ import init.resources.RESOURCE;
/*    */ import init.resources.RESOURCES;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
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
/*    */ class null
/*    */   extends RoomSpriteCombo
/*    */ {
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 40 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 44 */     if ((SETT.ROOMS()).fData.candle.is(it.tile()))
/*    */       return; 
/* 46 */     JanitorInstance ins = (JanitorInstance)blue.getter.get(it.tile());
/* 47 */     if (ins != null) {
/* 48 */       int ri = (int)(ins.tableRes >> 8 * (it.tx() + it.ty()) % 8);
/* 49 */       ri &= 0xFF;
/* 50 */       if (ri != 0)
/* 51 */         ((RESOURCE)RESOURCES.ALL().get(ri - 1)).renderLaying(r, it.x(), it.y(), it.ran(), ins.bits.resAm((RESOURCE)RESOURCES.ALL().getC(ri - 1))); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\janitor\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */