/*    */ package world.overlay;
/*    */ 
/*    */ import init.sprite.SPRITES;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.CORE;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.WORLD;
/*    */ import world.map.landmark.WorldLandmark;
/*    */ 
/*    */ public final class OverlayExplore
/*    */   extends WorldOverlays.OverlayTile
/*    */ {
/*    */   private WorldLandmark hovered;
/*    */   
/*    */   OverlayExplore() {
/* 22 */     super(true, false);
/*    */   }
/*    */   
/*    */   public void hover(WorldLandmark m) {
/* 26 */     this.hovered = m;
/*    */   }
/*    */ 
/*    */   
/*    */   public void add() {
/* 31 */     super.add();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 37 */     WorldLandmark a = (WorldLandmark)(WORLD.LANDMARKS()).setter.get(it.tile());
/*    */     
/* 39 */     if (a == null) {
/*    */       return;
/*    */     }
/* 42 */     if (a == this.hovered) {
/* 43 */       COLOR.WHITE2WHITE.bind();
/*    */       
/* 45 */       int m = 0;
/* 46 */       for (DIR d : DIR.ORTHO) {
/* 47 */         if ((WORLD.LANDMARKS()).setter.get(it.tx(), it.ty(), d) == a) {
/* 48 */           m |= d.mask();
/*    */         }
/*    */       } 
/* 51 */       if (m != 15) {
/* 52 */         (SPRITES.cons()).BIG.dashed_hollow.render(r, m, it.x(), it.y());
/*    */       
/*    */       }
/*    */     }
/* 56 */     else if (a != null && a.textSize != 0 && it.tx() == a.cx && it.ty() == a.cy) {
/* 57 */       COLOR.WHITE85.bind();
/* 58 */       Font f = (UI.FONT()).H2;
/* 59 */       int scale = 2 + CORE.renderer().getZoomout();
/* 60 */       int w = f.width((CharSequence)a.name, 0, a.name.length(), scale);
/* 61 */       s.setHeight(0).setDistance2Ground(0.0D);
/* 62 */       COLOR.WHITE100.render((SPRITE_RENDERER)s, it.x() - w / 2 - 8, it.x() + w / 2 + 8, it.y() - 8, it.y() + 8 + f.height() * scale);
/*    */       
/* 64 */       f.renderCX(r, it.x(), it.y(), (CharSequence)a.name, scale);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/* 76 */     (WORLD.OVERLAY()).minerals.renderAbove(r, s, data);
/* 77 */     super.renderAbove(r, s, data);
/* 78 */     this.hovered = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayExplore.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */