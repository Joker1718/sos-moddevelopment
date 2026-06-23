/*     */ package settlement.room.sprite;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.sprite.TILE_SHEET;
/*     */ import util.rendering.RenderData;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Imp
/*     */   implements RoomSprite
/*     */ {
/*  77 */   protected int shadowDist = 3; protected int shadowHeight = 0;
/*  78 */   private int sData = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Imp setShadow(int height, int heightOverGround) {
/*  85 */     this.shadowDist = height;
/*  86 */     this.shadowHeight = heightOverGround;
/*  87 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int sData() {
/*  92 */     return this.sData;
/*     */   }
/*     */   
/*     */   public Imp sDataSet(int s) {
/*  96 */     this.sData = s;
/*  97 */     return this;
/*     */   }
/*     */   
/*     */   protected int getData2(RenderData.RenderIterator it) {
/* 101 */     return (SETT.ROOMS()).fData.spriteData2.get(it.tile());
/*     */   }
/*     */   
/*     */   public void renderDegrade(TILE_SHEET sheet, SPRITE_RENDERER r, int tile, RenderData.RenderIterator it, double degrade) {
/* 105 */     if (degrade > 0.05D) {
/* 106 */       OPACITY.O99.bind();
/* 107 */       sheet.renderTextured((SETT.ROOMS()).util.filth.texture(degrade, it.ran()), tile, it.x(), it.y());
/* 108 */       OPACITY.unbind();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\sprite\RoomSprite$Imp.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */