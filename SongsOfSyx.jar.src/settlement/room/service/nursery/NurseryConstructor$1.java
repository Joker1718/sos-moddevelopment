/*    */ package settlement.room.service.nursery;
/*    */ 
/*    */ import settlement.room.sprite.RoomSprite;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
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
/*    */   extends RoomSprite.Dummy
/*    */ {
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 54 */     if (!isCandle) {
/* 55 */       long rr = it.bigRan();
/* 56 */       for (int i = 0; i < blue.ss.stuff(it.tx(), it.ty()); i++) {
/* 57 */         it.ranOffset(((DIR)DIR.ORTHO.get(i)).x(), ((DIR)DIR.ORTHO.get(i)).y());
/* 58 */         DIR dd = (DIR)DIR.ALL.getC((int)(rr & 0x111L));
/* 59 */         it.setOff((int)(dd.xN() * 32.0D / 2.0D), (int)(dd.yN() * 32.0D / 2.0D));
/* 60 */         rr >>= 3L;
/* 61 */         int data2 = (int)(rr & 0xFL);
/* 62 */         rr >>= 4L;
/* 63 */         sStuff.render(r, s, data2, it, degrade, false);
/*    */       } 
/*    */     } 
/*    */     
/* 67 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\nursery\NurseryConstructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */