/*     */ package settlement.room.sprite;
/*     */ 
/*     */ import init.sprite.game.Sheet;
/*     */ import init.sprite.game.SheetPair;
/*     */ import init.sprite.game.SheetType;
/*     */ import init.sprite.game.Sheets;
/*     */ import java.io.IOException;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import settlement.room.main.furnisher.FurnisherItemTile;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.TextureCoords;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoomSpriteCombo
/*     */   extends RoomSpriteImp
/*     */ {
/*     */   public RoomSpriteCombo(Json json, String key) throws IOException {
/*  25 */     super((SheetType)SheetType.sCombo, json, key);
/*     */   }
/*     */   
/*     */   public RoomSpriteCombo(RoomSprite clone) throws IOException {
/*  29 */     super(clone);
/*     */   }
/*     */   
/*     */   public RoomSpriteCombo() throws IOException {
/*  33 */     super((SheetType)SheetType.sCombo);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  40 */     int k = data >> 4 & 0xF;
/*  41 */     SheetPair sheet = sheetPair(it, k);
/*  42 */     if (sheet == null)
/*  43 */       return false; 
/*  44 */     sheet.d.color(k).bind();
/*  45 */     int ran = it.ran();
/*     */     
/*  47 */     int tile = type().tile(sheet.s, sheet.d, data & 0xF, frame(sheet, it), 0);
/*     */     
/*  49 */     sheet.s.render(sheet.d, it.x(), it.y(), it, r, tile, ran, degrade);
/*  50 */     COLOR.unbind();
/*  51 */     if (s != null)
/*  52 */       sheet.s.renderShadow(sheet.d, it.x(), it.y(), it, s, tile, ran); 
/*  53 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public TextureCoords texture(int data, RenderData.RenderIterator it) {
/*  59 */     int k = data >> 4 & 0xF;
/*  60 */     SheetPair sheet = sheetPair(it, k);
/*  61 */     if (sheet == null) {
/*  62 */       return COLOR.WHITE100.texture();
/*     */     }
/*  64 */     int tile = type().tile(sheet.s, sheet.d, data & 0xF, frame(sheet, it), 0);
/*     */     
/*  66 */     if (sheet.s instanceof Sheet.Imp) {
/*  67 */       Sheet.Imp ii = (Sheet.Imp)sheet.s;
/*  68 */       return ii.sheet.getTexture(tile);
/*     */     } 
/*  70 */     return COLOR.WHITE100.texture();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  76 */     if (item.get(rx, ry) != null)
/*  77 */       type().renderOverlay(x, y, r, (item.get(rx, ry)).availability, 
/*  78 */           data & 0xF, 0, false); 
/*     */   }
/*     */   
/*     */   public int rotMask(int data) {
/*  82 */     return data & 0xF;
/*     */   }
/*     */   
/*     */   public SheetPair sheet(int data, RenderData.RenderIterator it) {
/*  86 */     Sheets a = sheet(it);
/*  87 */     if (a == null)
/*  88 */       return null; 
/*  89 */     int k = data >> 4 & 0xF;
/*  90 */     SheetPair sheet = a.get(k);
/*  91 */     return sheet;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  96 */     int m = 0;
/*  97 */     int ri = RND.rInt(DIR.ORTHO.size());
/*  98 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  99 */       int rr = (ri + i) % DIR.ORTHO.size();
/* 100 */       DIR d = (DIR)DIR.ORTHO.get(rr);
/* 101 */       if (joins(tx + d.x(), ty + d.y(), rx + d.x(), ry + d.y(), d, item))
/* 102 */         m |= d.mask(); 
/*     */     } 
/* 104 */     return (byte)(m | itemRan << 4);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean joins(int tx, int ty, int rx, int ry, DIR d, FurnisherItem item) {
/* 109 */     FurnisherItemTile t = item.get(rx, ry);
/* 110 */     return (t != null && t.sprite != null && t.sprite instanceof RoomSpriteCombo);
/*     */   }
/*     */ 
/*     */   
/*     */   public SheetType type() {
/* 115 */     return (SheetType)SheetType.sCombo;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSpriteCombo.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */