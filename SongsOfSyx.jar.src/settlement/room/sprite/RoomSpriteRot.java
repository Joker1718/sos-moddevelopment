/*     */ package settlement.room.sprite;
/*     */ 
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RoomSpriteRot
/*     */   extends RoomSprite.Imp
/*     */ {
/*     */   private static final int ROT = 4;
/*     */   public final int tileEnd;
/*     */   public final int tilestart;
/*     */   private final LIST<SPRITE> blue;
/*     */   private final TILE_SHEET sheet;
/*     */   
/*     */   public RoomSpriteRot(TILE_SHEET sheet, int startTile, int variations, LIST<SPRITE> blueprint) {
/*  27 */     this.sheet = sheet;
/*  28 */     this.blue = blueprint;
/*  29 */     this.tileEnd = startTile + variations * 4;
/*  30 */     this.tilestart = startTile;
/*  31 */     this.shadowDist = 3;
/*  32 */     this.shadowHeight = 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  37 */     int x = it.x();
/*  38 */     int y = it.y();
/*  39 */     return render(r, s, data, x, y, it.ran(), it, degrade, isCandle);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean renderRandom(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it, double degrade, boolean off) {
/*  45 */     int x = it.x();
/*  46 */     int y = it.y();
/*  47 */     int ran = it.ran() & Integer.MAX_VALUE;
/*  48 */     if (off) {
/*  49 */       x += -8 + (ran & Integer.MAX_VALUE) % 16;
/*  50 */       ran >>= 4;
/*  51 */       y += -8 + (ran & Integer.MAX_VALUE) % 16;
/*  52 */       ran >>= 4;
/*     */     } 
/*     */     
/*  55 */     int data = ran & 0x3;
/*  56 */     ran >>= 2;
/*     */     
/*  58 */     return render(r, s, data, x, y, ran, it, degrade, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, int x, int y, int ran, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  66 */     ran &= Integer.MAX_VALUE;
/*  67 */     int variations = (this.tileEnd - this.tilestart) / 4;
/*  68 */     int tile = ran % variations;
/*  69 */     tile += (data & 0x3) * variations;
/*  70 */     tile += this.tilestart;
/*  71 */     tile += getTileOffset(it, data);
/*  72 */     this.sheet.render(r, tile, x, y);
/*  73 */     ran >>= 4;
/*  74 */     renderDegrade(this.sheet, r, tile, it, degrade);
/*     */     
/*  76 */     if (s != null && (this.shadowHeight > 0 || this.shadowDist > 0)) {
/*  77 */       s.setDistance2Ground(this.shadowHeight).setHeight(this.shadowDist);
/*  78 */       this.sheet.render((SPRITE_RENDERER)s, tile, x, y);
/*     */     } 
/*     */     
/*  81 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected static int getRot(int data) {
/*  87 */     return data & 0x3;
/*     */   }
/*     */   
/*     */   protected int getTileOffset(RenderData.RenderIterator it, int data) {
/*  91 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  97 */     int tile = data & 0x3;
/*  98 */     ((SPRITE)this.blue.get(tile)).render(r, x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/* 104 */     int r = 0;
/*     */     
/* 106 */     for (int i = 0; i < DIR.ORTHO.size(); i++) {
/* 107 */       DIR d = (DIR)DIR.ORTHO.get(i);
/*     */       
/* 109 */       int dx = rx + d.x();
/* 110 */       int dy = ry + d.y();
/*     */       
/* 112 */       if (dy < 0 || dy >= item.height()) {
/* 113 */         if (joinsWith((RoomSprite)null, true, item.rotation, d, rx, ry, item)) {
/* 114 */           r = i;
/*     */           break;
/*     */         } 
/* 117 */       } else if ((dx < 0 || dx >= item.width()) && joinsWith((RoomSprite)null, true, item.rotation, d, rx, ry, item)) {
/* 118 */         if (joinsWith((RoomSprite)null, true, item.rotation, d, rx, ry, item)) {
/* 119 */           r = i;
/*     */           break;
/*     */         } 
/* 122 */       } else if (joinsWith(item.sprite(dx, dy), false, item.rotation, d, rx, ry, item)) {
/* 123 */         r = i;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 128 */     return (byte)r;
/*     */   }
/*     */   
/*     */   protected boolean joinsWith(RoomSprite s, boolean outof, int dir, DIR test, int rx, int ry, FurnisherItem item) {
/* 132 */     return (test == DIR.ORTHO.get(dir));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSpriteRot.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */