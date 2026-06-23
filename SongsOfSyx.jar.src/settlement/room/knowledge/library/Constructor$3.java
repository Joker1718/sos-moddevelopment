/*     */ package settlement.room.knowledge.library;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.sprite.RoomSprite1x1;
/*     */ import settlement.room.sprite.RoomSpriteCombo;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends RoomSpriteCombo
/*     */ {
/*     */   private final RoomSprite1x1 available;
/*     */   private final RoomSprite1x1 dec;
/*     */   
/*     */   null(Json $anonymous0, String $anonymous1, Json paramJson1) throws IOException {
/*  79 */     super($anonymous0, $anonymous1);
/*     */     
/*  81 */     this.available = new RoomSprite1x1(paramJson1, "WORK_UNUSED_1x1");
/*  82 */     this.dec = new RoomSprite1x1(paramJson1, "TABLE_DECOR_1x1");
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade) {
/*  87 */     if (blue.is(it.tile())) {
/*  88 */       it.ranOffset(1, 0);
/*  89 */       RoomSprite1x1 sp = null;
/*  90 */       if (blue.job.used(it.tx(), it.ty())) {
/*  91 */         sp = sUsed;
/*  92 */       } else if (blue.consumption().ins().size() > 0 && blue.consumption().stored((IndustryResource)blue.consumption().ins().get(0)).get(blue.get(it.tx(), it.ty())) > 0) {
/*  93 */         sp = this.available;
/*     */       } 
/*     */       
/*  96 */       for (int i = 0; i < DIR.ORTHO.size(); i++) {
/*  97 */         if ((SETT.ROOMS()).fData.sprite.is(it.tx(), it.ty(), (DIR)DIR.ORTHO.get(i), Constructor.this.sStool)) {
/*  98 */           if (sp != null)
/*  99 */             sp.render(r, s, i, it, degrade, false); 
/* 100 */           if ((it.ran() & 0x3) == 1) {
/* 101 */             it.ranOffset(1, 0);
/* 102 */             this.dec.render(r, s, (i + 2) % 4, it, degrade, false);
/*     */           } 
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\library\Constructor$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */