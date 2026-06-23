/*     */ package settlement.room.home.house;
/*     */ 
/*     */ import init.sprite.game.Sheets;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends Sprite
/*     */ {
/*     */   null(boolean $anonymous0, boolean $anonymous1, boolean $anonymous2) {
/* 154 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 160 */     DIR dir = (DIR)DIR.ORTHO.get(data & 0x3);
/* 161 */     it.ranOffset(dir.x(), dir.y());
/* 162 */     int ran = it.ran();
/* 163 */     Sheets a = (sp()).bedBottom.get(this.house);
/* 164 */     Sprites.render1x1(ran, a, r, s, data, it, degrade);
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 170 */     HomeInstance house = (HomeInstance)(SETT.ROOMS()).HOME.getter.get(tx, ty);
/* 171 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 172 */       DIR d = (DIR)DIR.ORTHO.get(i);
/* 173 */       if (house.sprite(tx + d.x(), ty + d.y()) == Sprites.this.bedN) {
/* 174 */         return (byte)i;
/*     */       }
/*     */     } 
/* 177 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\home\house\Sprites$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */