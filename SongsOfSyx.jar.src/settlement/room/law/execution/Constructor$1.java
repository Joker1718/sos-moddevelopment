/*    */ package settlement.room.law.execution;
/*    */ 
/*    */ import game.time.TIME;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
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
/*    */   extends Constructor.PSprite
/*    */ {
/*    */   final int[] animi;
/*    */   
/*    */   null(Json $anonymous0, String $anonymous1) throws IOException {
/* 60 */     super($anonymous0, $anonymous1);
/*    */     
/* 62 */     this.animi = new int[] { 0, 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, -1, -2, -3, -4, -5, -6, -7, -8, -7, -6, -5, -4, -3, -2, -1 };
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 67 */     int rot = ((FurnisherItem)(SETT.ROOMS()).fData.item.get(it.tile())).rotation;
/* 68 */     if (!Constructor.this.blue.stations.deadORDying(it.tx(), it.ty())) {
/* 69 */       DIR dir = (DIR)DIR.ORTHO.get(rot);
/*    */       
/* 71 */       int ran = it.ran();
/* 72 */       int speed = 4 + (ran & 0x7);
/* 73 */       ran >>= 3;
/* 74 */       double ww = 0.5D + (ran & 0xF) / 15.0D;
/* 75 */       ran >>= 4;
/* 76 */       int i = (ran & 0xFFFF) + (int)(TIME.currentSecond() * speed);
/* 77 */       int d = this.animi[i % this.animi.length];
/*    */       
/* 79 */       it.setOff((int)((dir.x() * d) * ww), (int)((dir.y() * d) * ww));
/* 80 */       super.render(r, s, data, it, degrade, isCandle);
/* 81 */       it.setOff(0, 0);
/*    */     } 
/* 83 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\execution\Constructor$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */