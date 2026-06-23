/*    */ package world.overlay;
/*    */ 
/*    */ import game.boosting.BUtil;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sets.LIST;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import util.text.D;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ import world.region.RD;
/*    */ import world.region.building.RDBuilding;
/*    */ 
/*    */ class OverlayMineral
/*    */   extends WorldOverlays.OverlayTileNormal
/*    */ {
/* 20 */   private static CharSequence ¤¤name = "¤Minerals";
/* 21 */   private static CharSequence ¤¤desc = "¤Shows the location of minerals.";
/*    */   static {
/* 23 */     D.ts(OverlayMineral.class);
/*    */   }
/*    */ 
/*    */   
/*    */   OverlayMineral() {
/* 28 */     super(¤¤name, ¤¤desc, true, true);
/*    */   }
/*    */ 
/*    */   
/*    */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/* 33 */     super.renderAbove(r, s, data);
/*    */     
/* 35 */     int size = 64;
/*    */     
/* 37 */     for (Region reg : WORLD.REGIONS().active()) {
/*    */       
/* 39 */       for (DIR dir : DIR.NORTHO) {
/* 40 */         if (data.tBounds().holdsPoint((reg.cx() + dir.x() * 5), (reg.cy() + dir.y() * 5))) {
/*    */           
/* 42 */           int am = 0;
/*    */           
/* 44 */           for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 45 */             if (BUtil.value((LIST)b.baseFactors, reg) > 1.0D) {
/* 46 */               am++;
/*    */             }
/*    */           } 
/*    */ 
/*    */           
/* 51 */           int x1 = data.transformGX(reg.cx() * 64 + 32 - am * size / 2);
/* 52 */           int y1 = data.transformGY((reg.cy() + 2) * 64);
/*    */ 
/*    */ 
/*    */           
/* 56 */           for (RDBuilding b : (RD.BUILDINGS()).all) {
/* 57 */             if (BUtil.value((LIST)b.baseFactors, reg) > 1.0D) {
/* 58 */               int ss = 64;
/* 59 */               int d = (size - ss) / 2;
/* 60 */               COLOR.BLACK.bind();
/* 61 */               b.icon().render((SPRITE_RENDERER)r, x1 + d + 8, x1 + d + ss + 8, y1 + d + 8, y1 + d + ss + 8);
/* 62 */               COLOR.unbind();
/* 63 */               b.icon().render((SPRITE_RENDERER)r, x1 + d, x1 + d + ss, y1 + d, y1 + d + ss);
/*    */               
/* 65 */               x1 += size;
/*    */             } 
/*    */           } 
/*    */           break;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {}
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayMineral.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */