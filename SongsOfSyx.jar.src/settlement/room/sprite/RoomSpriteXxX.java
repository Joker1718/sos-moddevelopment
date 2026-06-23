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
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ public class RoomSpriteXxX
/*     */   extends RoomSpriteImp
/*     */ {
/*  17 */   private int rotation = 0;
/*     */   
/*     */   public RoomSpriteXxX(Json json, String key, int size) throws IOException {
/*  20 */     super((SheetType)size(size), json, key);
/*  21 */     this.type = size(size);
/*     */   }
/*     */   private final SheetType.cXxX type;
/*     */   public RoomSpriteXxX(int size) throws IOException {
/*  25 */     super((SheetType)size(size));
/*  26 */     this.type = size(size);
/*     */   }
/*     */   
/*     */   private static SheetType.cXxX size(int size) {
/*  30 */     if (size == 2)
/*  31 */       return SheetType.s2x2; 
/*  32 */     if (size == 3)
/*  33 */       return SheetType.s3x3; 
/*  34 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  41 */     int t = data & 0x3F;
/*  42 */     int rot = rot(data);
/*  43 */     int dx = this.type.dx(data);
/*  44 */     int dy = this.type.dy(data);
/*     */     
/*  46 */     it.ranOffset(-dx, -dy);
/*  47 */     int ran = it.ran();
/*  48 */     SheetPair sheet = sheetPair(it, ran);
/*  49 */     if (sheet == null) {
/*  50 */       return false;
/*     */     }
/*  52 */     sheet.d.color(ran).bind();
/*     */     
/*  54 */     if (!sheet.d.rotates) {
/*  55 */       rot = ran >> 9 & 0x3;
/*     */     }
/*     */     
/*  58 */     int tile = this.type.tile(sheet.s, sheet.d, t, frame(sheet, it), rot);
/*     */     
/*  60 */     it.ranOffset(dx, dy);
/*  61 */     sheet.s.render(sheet.d, it.x(), it.y(), it, r, tile, ran, degrade);
/*  62 */     COLOR.unbind();
/*  63 */     sheet.s.renderShadow(sheet.d, it.x(), it.y(), it, s, tile, ran);
/*     */     
/*  65 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  73 */     this.type.renderOverlay(x, y, r, (item.get(rx, ry)).availability, 
/*  74 */         data & 0x3F, this.rotates ? rot(data) : -1, false);
/*     */   }
/*     */   
/*     */   public int rot(int data) {
/*  78 */     return data >> 6 & 0x3;
/*     */   }
/*     */   
/*     */   public int setRot(int data, int rot) {
/*  82 */     data &= 0x3F;
/*  83 */     data |= (rot & 0x3) << 6;
/*  84 */     return data;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  89 */     int dx = this.type.size - 1;
/*  90 */     int dy = this.type.size - 1;
/*     */     
/*  92 */     for (int y = 0; y < this.type.size; y++) {
/*  93 */       if (!joins(tx, ty - y, rx, ry - y, (DIR)null, item)) {
/*  94 */         dy = y - 1;
/*     */         break;
/*     */       } 
/*     */     } 
/*  98 */     for (int x = 0; x < this.type.size; x++) {
/*  99 */       if (!joins(tx - x, ty, rx - x, ry, (DIR)null, item)) {
/* 100 */         dx = x - 1;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 105 */     int i = dx + this.type.size * dy;
/*     */     
/* 107 */     i |= (item.rotation + this.rotation & 0x3) << 6;
/*     */     
/* 109 */     return (byte)i;
/*     */   }
/*     */   
/*     */   public RoomSpriteXxX rotate(int rotation) {
/* 113 */     this.rotation = rotation;
/* 114 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 119 */     return (item.sprite(rx, ry) == this);
/*     */   }
/*     */ 
/*     */   
/*     */   public SheetType.cXxX type() {
/* 124 */     return this.type;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSpriteXxX.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */