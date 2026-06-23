/*    */ package settlement.room.home.house;
/*    */ 
/*    */ import init.sprite.game.SheetType;
/*    */ import init.sprite.game.Sheets;
/*    */ import java.io.IOException;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.furnisher.FurnisherItem;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
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
/*    */ class null
/*    */   extends Sprite
/*    */ {
/*    */   private final Sheets sheets;
/*    */   
/*    */   null(Json paramJson) throws IOException {
/* 42 */     this.sheets = new Sheets((SheetType)SheetType.s1x1, paramJson.json("UP_1X1"));
/*    */ 
/*    */     
/* 45 */     sDataSet(1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 52 */     if (this.house.upgrade() < 2)
/* 53 */       return false; 
/* 54 */     int ran = it.ran();
/* 55 */     Sprites.render1x1(ran, this.sheets, r, s, data, it, degrade);
/*    */     
/* 57 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 63 */     HomeInstance room = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/* 64 */     int r = RND.rInt(4);
/*    */     int i;
/* 66 */     for (i = 0; i < DIR.ORTHO.size(); i++) {
/* 67 */       DIR d = (DIR)DIR.ORTHO.getC(i + r);
/* 68 */       if (room.serviceX() == tx + d.x() && room.serviceY() == ty + d.y() && !room.isSame(tx, ty, tx - d.x(), ty - d.y())) {
/* 69 */         return (byte)d.orthoID();
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 75 */     for (i = 0; i < DIR.ORTHO.size(); i++) {
/* 76 */       DIR d = (DIR)DIR.ORTHO.getC(i + r);
/* 77 */       if (room.sprite(tx + d.x(), ty + d.y()) == null && room.isSame(tx, ty, tx + d.x(), ty + d.y())) {
/* 78 */         return (byte)d.orthoID();
/*    */       }
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 84 */     for (i = 0; i < DIR.ORTHO.size(); i++) {
/* 85 */       DIR d = (DIR)DIR.ORTHO.getC(i + r);
/* 86 */       if (!room.isSame(tx, ty, tx + d.x(), ty + d.y())) {
/* 87 */         return (byte)d.orthoID();
/*    */       }
/*    */     } 
/*    */     
/* 91 */     return (byte)RND.rInt(4);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\Sprites$12.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */