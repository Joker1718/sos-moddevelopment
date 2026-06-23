/*     */ package settlement.room.military.artillery;
/*     */ 
/*     */ import init.sprite.game.SheetPair;
/*     */ import java.io.IOException;
/*     */ import settlement.room.sprite.RoomSprite;
/*     */ import settlement.room.sprite.RoomSpriteXxX;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.file.Json;
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
/*     */ class null
/*     */   extends RoomSpriteXxX
/*     */ {
/*     */   RoomSprite srot;
/*     */   
/*     */   null(Json $anonymous0, String $anonymous1, int $anonymous2, Json paramJson1) throws IOException {
/*  71 */     super($anonymous0, $anonymous1, $anonymous2);
/*     */     
/*  73 */     this.srot = (RoomSprite)new RoomSpriteXxX(paramJson1, "BASE_ROT_2X2", 2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/*  78 */     int rot = 0;
/*  79 */     ArtilleryInstance ins = (ArtilleryInstance)blue.get(it.tx(), it.ty());
/*  80 */     if (ins != null) {
/*  81 */       rot = ins.dirCurrent().id();
/*     */     }
/*     */     
/*  84 */     data = setRot(data, rot / 2);
/*     */     
/*  86 */     if ((rot & 0x1) == 1) {
/*  87 */       this.srot.render(r, s, data, it, degrade, isCandle);
/*     */     } else {
/*  89 */       super.render(r, s, data, it, degrade, isCandle);
/*     */     } 
/*  91 */     sArm.render(r, s, data, it, degrade, isCandle);
/*  92 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int frame(SheetPair a, RenderData.RenderIterator it) {
/*  97 */     ArtilleryInstance ins = (ArtilleryInstance)blue.get(it.tx(), it.ty());
/*  98 */     if (ins != null) {
/*  99 */       return (int)(ins.progress() * 32.0D) & 0x1;
/*     */     }
/* 101 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\artillery\Constructor$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */