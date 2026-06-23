/*     */ package settlement.room.sprite;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.furnisher.FurnisherItem;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ import util.rendering.ShadowBatch;
/*     */ 
/*     */ 
/*     */ public interface RoomSprite
/*     */ {
/*     */   boolean render(SPRITE_RENDERER paramSPRITE_RENDERER, ShadowBatch paramShadowBatch, int paramInt, RenderData.RenderIterator paramRenderIterator, double paramDouble, boolean paramBoolean);
/*     */   
/*     */   default void renderBroken(SPRITE_RENDERER r, ShadowBatch s, int x, int y, RenderData.RenderIterator it, FurnisherItem item) {
/*  18 */     for (int i = 0; i < (item.group()).blueprint.resources(); i++) {
/*  19 */       int a = item.brokenResourceAmount(i);
/*  20 */       if (a > 0) {
/*  21 */         (item.group()).blueprint.resource(i).renderDebris(r, s, x, y, it.ran() >> i, a);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default void renderPlaceholder(SPRITE_RENDERER r, int x, int y, int data, int tx, int ty, int rx, int ry, FurnisherItem item) {
/*  30 */     (SPRITES.cons()).BIG.dashed_hollow.render(r, 0, x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   default void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {}
/*     */   
/*     */   default void renderBelow(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {}
/*     */   
/*     */   default int rotation(int data, FurnisherItem item) {
/*  39 */     if (item.group().rotations() > 2)
/*  40 */       return item.rotation + 1; 
/*  41 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   byte getData(int paramInt1, int paramInt2, int paramInt3, int paramInt4, FurnisherItem paramFurnisherItem, int paramInt5);
/*     */   
/*     */   default byte getData2(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  48 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class Dummy
/*     */     implements RoomSprite
/*     */   {
/*     */     public boolean render(SPRITE_RENDERER r, ShadowBatch shadowBatch, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  57 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public byte getData(int tx, int ty, int rx, int ry, FurnisherItem item, int itemRan) {
/*  63 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int sData() {
/*  68 */       return 0;
/*     */     } }
/*     */   
/*     */   int sData();
/*     */   
/*  73 */   public static final Dummy DUMMY = new Dummy();
/*     */   
/*     */   public static abstract class Imp
/*     */     implements RoomSprite {
/*  77 */     protected int shadowDist = 3; protected int shadowHeight = 0;
/*  78 */     private int sData = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Imp setShadow(int height, int heightOverGround) {
/*  85 */       this.shadowDist = height;
/*  86 */       this.shadowHeight = heightOverGround;
/*  87 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public int sData() {
/*  92 */       return this.sData;
/*     */     }
/*     */     
/*     */     public Imp sDataSet(int s) {
/*  96 */       this.sData = s;
/*  97 */       return this;
/*     */     }
/*     */     
/*     */     protected int getData2(RenderData.RenderIterator it) {
/* 101 */       return (SETT.ROOMS()).fData.spriteData2.get(it.tile());
/*     */     }
/*     */     
/*     */     public void renderDegrade(TILE_SHEET sheet, SPRITE_RENDERER r, int tile, RenderData.RenderIterator it, double degrade) {
/* 105 */       if (degrade > 0.05D) {
/* 106 */         OPACITY.O99.bind();
/* 107 */         sheet.renderTextured((SETT.ROOMS()).util.filth.texture(degrade, it.ran()), tile, it.x(), it.y());
/* 108 */         OPACITY.unbind();
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSprite.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */