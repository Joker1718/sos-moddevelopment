/*    */ package world.overlay;
/*    */ 
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import util.text.D;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ class OverlayFaction
/*    */   extends WorldOverlays.OverlayTileNormal
/*    */ {
/* 17 */   private static CharSequence ¤¤name = "¤Factions";
/* 18 */   private static CharSequence ¤¤desc = "¤Shows a clear view of factions.";
/*    */   static {
/* 20 */     D.ts(OverlayFaction.class);
/*    */   }
/*    */ 
/*    */   
/*    */   OverlayFaction() {
/* 25 */     super(¤¤name, ¤¤desc, true, true);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/* 30 */     int m = 15;
/* 31 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 32 */     if (WORLD.REGIONS().border().is(it.tile())) {
/* 33 */       m = 0;
/* 34 */       for (DIR d : DIR.ORTHO) {
/* 35 */         if (!WORLD.IN_BOUNDS(it.tx(), it.ty(), d) || reg == (WORLD.REGIONS()).map.get(it.tx(), it.ty(), d)) {
/* 36 */           m |= d.mask();
/*    */         }
/*    */       } 
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 43 */     COLOR c = (reg == null || reg.faction() == null) ? (GCOLOR.MAP()).F_REBEL : (COLOR)reg.faction().banner().colorBG();
/* 44 */     c.bind();
/* 45 */     renderUnder(m, r, it);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/* 51 */     (WORLD.OVERLAY()).regNames.renderAbove(r, s, data);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayFaction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */