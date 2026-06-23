/*     */ package settlement.room.sprite;
/*     */ 
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import util.GUTIL;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public class RoomSprite1x1
/*     */   extends RoomSpriteImp
/*     */ {
/*     */   public RoomSprite1x1(Json json, String key) throws IOException {
/*  20 */     super((SheetType)SheetType.s1x1, json, key);
/*     */   }
/*     */   
/*     */   public RoomSprite1x1(RoomSprite other) throws IOException {
/*  24 */     super(other);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  31 */     int ran = it.ran();
/*  32 */     SheetPair sheet = sheetPair(it, ran);
/*  33 */     if (sheet == null)
/*  34 */       return false; 
/*  35 */     sheet.d.color(ran).bind();
/*  36 */     ran >>= 4;
/*     */     
/*  38 */     int tile = type().tile(sheet.s, sheet.d, 0, frame(sheet, it), this.rotates ? (data & 0x3) : (ran & 0x3));
/*     */     
/*  40 */     sheet.s.render(sheet.d, it.x(), it.y(), it, r, tile, ran, degrade);
/*  41 */     COLOR.unbind();
/*  42 */     if (s != null)
/*  43 */       sheet.s.renderShadow(sheet.d, it.x(), it.y(), it, s, tile, ran); 
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderRandom(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, int ran, double degrade) {
/*  51 */     SheetPair sheet = sheetPair(it, ran);
/*  52 */     if (sheet == null)
/*     */       return; 
/*  54 */     sheet.d.color(ran).bind();
/*     */     
/*  56 */     int tile = type().tile(sheet.s, sheet.d, 0, frame(sheet, it), -1);
/*     */ 
/*     */     
/*  59 */     sheet.s.render(sheet.d, it.x(), it.y(), it, r, tile, ran, degrade);
/*  60 */     COLOR.unbind();
/*  61 */     sheet.s.renderShadow(sheet.d, it.x(), it.y(), it, s, tile, ran);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderRandom(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, int ran, double degrade, COLOR col) {
/*  67 */     SheetPair sheet = sheetPair(it, ran);
/*  68 */     if (sheet == null)
/*     */       return; 
/*  70 */     col.bind();
/*     */     
/*  72 */     int tile = type().tile(sheet.s, sheet.d, 0, frame(sheet, it), -1);
/*     */ 
/*     */     
/*  75 */     sheet.s.render(sheet.d, it.x(), it.y(), it, r, tile, ran, degrade);
/*  76 */     COLOR.unbind();
/*  77 */     sheet.s.renderShadow(sheet.d, it.x(), it.y(), it, s, tile, ran);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  83 */     SheetType.s1x1.renderOverlay(
/*  84 */         x, y, r, (item.get(rx, ry)).availability, 
/*  85 */         0, this.rotates ? data : -1, (item.width() == 1 && item.height() == 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  90 */     int ri = GUTIL.ran2().get(tx, ty) & 0x3;
/*  91 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  92 */       int rr = (ri + i) % DIR.ORTHO.size();
/*  93 */       DIR d = (DIR)DIR.ORTHO.get(rr);
/*  94 */       if (joins(tx + d.x(), ty + d.y(), rx + d.x(), ry + d.y(), d, item))
/*  95 */         return (byte)rr; 
/*     */     } 
/*  97 */     return (byte)item.rotation;
/*     */   }
/*     */   
/*     */   public int getRot(int data) {
/* 101 */     return data & 0x3;
/*     */   }
/*     */   
/*     */   public DIR rot(int data) {
/* 105 */     return (DIR)DIR.ORTHO.get(data & 0x3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 110 */     return (DIR.ORTHO.get(item.rotation) == d);
/*     */   }
/*     */ 
/*     */   
/*     */   public SheetType.c1X1 type() {
/* 115 */     return SheetType.s1x1;
/*     */   }
/*     */ 
/*     */   
/*     */   public int rotation(int data, FurnisherItem item) {
/* 120 */     if (this.rotates)
/* 121 */       return getRot(data) + 1; 
/* 122 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSprite1x1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */