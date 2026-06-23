/*    */ package settlement.room.industry.workshop;
/*    */ 
/*    */ import init.sprite.UI.Icon;
/*    */ import java.io.IOException;
/*    */ import settlement.room.industry.module.IndustryResource;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.OPACITY;
/*    */ import snake2d.util.file.Json;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   extends Constructor.STable
/*    */ {
/*    */   null(Json $anonymous0) throws IOException {
/* 82 */     super($anonymous0);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean render(SPRITE_RENDERER r, ShadowBatch s, int data, RenderData.RenderIterator it, double degrade, boolean isCandle) {
/* 87 */     super.render(r, s, data, it, degrade, isCandle);
/* 88 */     WorkshopInstance ins = (WorkshopInstance)blue.get(it.tx(), it.ty());
/* 89 */     if (!isCandle && ins != null) {
/* 90 */       Icon icon = ((IndustryResource)ins.industry().outs().get(0)).resource.icon();
/* 91 */       OPACITY.O99.bind();
/* 92 */       icon.render(r, it.x() + 8, it.x() + 64 - 8, it.y() + 8, it.y() + 64 - 8);
/* 93 */       OPACITY.unbind();
/*    */     } 
/* 95 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\workshop\Constructor$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */