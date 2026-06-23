/*     */ package settlement.room.infra.gate;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import settlement.main.SETT;
/*     */ import settlement.path.AVAILABILITY;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.TmpArea;
/*     */ import settlement.room.main.furnisher.Furnisher;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import settlement.room.main.util.RoomInit;
/*     */ import settlement.room.main.util.RoomInitData;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSpriteRot;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ import util.spritecomposer.ComposerDests;
/*     */ import util.spritecomposer.ComposerSources;
/*     */ import util.spritecomposer.ComposerThings;
/*     */ import util.spritecomposer.ComposerUtil;
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
/*     */ public class MConstructor
/*     */   extends Furnisher
/*     */ {
/*     */   private final ROOM_GATE blue;
/*     */   
/*     */   MConstructor(ROOM_GATE blue, RoomInitData init) throws IOException {
/* 199 */     super(init, 1, 0, 144, 104);
/* 200 */     this.blue = blue;
/* 201 */     makeItems(this, init);
/*     */   }
/*     */ 
/*     */   
/*     */   public void makeItems(Furnisher f, RoomInitData init) throws IOException {
/* 206 */     TILE_SHEET sheet = (new ComposerThings.ITileSheet(init.sp(), 144, 120)
/*     */       {
/*     */         protected TILE_SHEET init(ComposerUtil c, ComposerSources s, ComposerDests d)
/*     */         {
/* 210 */           s.full.init(0, 0, 1, 1, 1, 3, d.s16); int i;
/* 211 */           for (i = 0; i < 3; i++) {
/* 212 */             s.full.setSkip(1, i).paste(3, true);
/*     */           }
/* 214 */           s.full.init(s.full.body().x2(), 0, 1, 1, 2, 3, d.s16);
/* 215 */           for (i = 0; i < 6; i++) {
/* 216 */             s.full.setSkip(1, i).paste(3, true);
/*     */           }
/*     */           
/* 219 */           return d.s16.saveGame();
/*     */         }
/* 221 */       }).get();
/*     */     
/* 223 */     Sprite s1 = new Sprite(sheet, 0);
/* 224 */     Sprite s1b = new Sprite(sheet, 0, true);
/* 225 */     Sprite s2 = new Sprite(sheet, s1.tileEnd);
/* 226 */     Sprite s3 = new Sprite(sheet, s2.tileEnd);
/*     */     
/* 228 */     Sprite s1_1 = new Sprite(sheet, s3.tileEnd);
/* 229 */     Sprite s1_2 = new Sprite(sheet, s1_1.tileEnd);
/* 230 */     Sprite s1_1b = new Sprite(sheet, s3.tileEnd, true);
/* 231 */     Sprite s1_2b = new Sprite(sheet, s1_1.tileEnd, true);
/* 232 */     Sprite s2_1 = new Sprite(sheet, s1_2.tileEnd);
/* 233 */     Sprite s2_2 = new Sprite(sheet, s2_1.tileEnd);
/* 234 */     Sprite s3_1 = new Sprite(sheet, s2_2.tileEnd);
/* 235 */     Sprite s3_2 = new Sprite(sheet, s3_1.tileEnd);
/*     */ 
/*     */ 
/*     */     
/* 239 */     Tile t1 = new Tile((RoomSprite)s1);
/* 240 */     Tile t1b = new Tile((RoomSprite)s1b);
/* 241 */     Tile t2 = new Tile((RoomSprite)s2);
/* 242 */     Tile t3 = new Tile((RoomSprite)s3);
/*     */     
/* 244 */     Tile t1_1 = new Tile((RoomSprite)s1_1);
/* 245 */     Tile t1_2 = new Tile((RoomSprite)s1_2);
/* 246 */     Tile t1_1b = new Tile((RoomSprite)s1_1b);
/* 247 */     Tile t1_2b = new Tile((RoomSprite)s1_2b);
/* 248 */     Tile t2_1 = new Tile((RoomSprite)s2_1);
/* 249 */     Tile t2_2 = new Tile((RoomSprite)s2_2);
/* 250 */     Tile t3_1 = new Tile((RoomSprite)s3_1);
/* 251 */     Tile t3_2 = new Tile((RoomSprite)s3_2);
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
/* 299 */     f.flush(3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean usesArea() {
/* 305 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean mustBeIndoors() {
/* 310 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Room create(TmpArea area, RoomInit init) {
/* 315 */     return (Room)this.blue.instance.place(area);
/*     */   }
/*     */ 
/*     */   
/*     */   public RoomBlueprintImp blue() {
/* 320 */     return this.blue;
/*     */   }
/*     */ 
/*     */   
/*     */   public void putFloor(int tx, int ty, int upgrade, AREA area) {
/* 325 */     if ((SETT.FLOOR()).getter.get(tx, ty) != null)
/*     */       return; 
/* 327 */     super.putFloor(tx, ty, upgrade, area);
/*     */   }
/*     */   
/*     */   private static class Sprite
/*     */     extends RoomSpriteRot
/*     */   {
/*     */     private int off;
/*     */     
/*     */     public Sprite(TILE_SHEET sheet, int startTile) {
/* 336 */       super(sheet, startTile, 1, (SPRITES.cons()).ROT.full);
/* 337 */       this.off = 0;
/* 338 */       setShadow(16, 0);
/*     */     }
/*     */     
/*     */     public Sprite(TILE_SHEET sheet, int startTile, boolean off) {
/* 342 */       super(sheet, startTile, 1, (SPRITES.cons()).ROT.full);
/* 343 */       this.off = 2;
/* 344 */       setShadow(16, 0);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean joinsWith(RoomSprite s, boolean outof, int dir, DIR test, int rx, int ry, FurnisherItem item) {
/* 350 */       return (DIR.ORTHO.getC(dir + this.off) == test);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 356 */       super.render(SPRITE_RENDERER.DUMMY, s, data, it, degrade, false);
/* 357 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/* 367 */       super.render(r, ShadowBatch.DUMMY, data, it, degrade, false);
/*     */     }
/*     */   }
/*     */   
/*     */   private class Tile
/*     */     extends FurnisherItemTile
/*     */   {
/*     */     public Tile(RoomSprite sprite) {
/* 375 */       super(ROOM_GATE.MConstructor.this, false, sprite, AVAILABILITY.ENEMY, false);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\gate\ROOM_GATE$MConstructor.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */