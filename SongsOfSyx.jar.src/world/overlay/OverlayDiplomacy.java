/*    */ package world.overlay;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.royalty.opinion.ROPINION;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import util.colors.GCOLOR;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import util.text.D;
/*    */ import world.WORLD;
/*    */ import world.map.regions.Region;
/*    */ 
/*    */ class OverlayDiplomacy
/*    */   extends WorldOverlays.OverlayTileNormal
/*    */ {
/* 21 */   private static CharSequence ¤¤name = "¤Diplomacy";
/* 22 */   private static CharSequence ¤¤desc = "¤Shows a clear view of factions and their loyalty towards you.";
/*    */   static {
/* 24 */     D.ts(OverlayDiplomacy.class);
/*    */   }
/*    */ 
/*    */   
/*    */   OverlayDiplomacy() {
/* 29 */     super(¤¤name, ¤¤desc, true, true);
/*    */   }
/*    */   
/*    */   protected void renderBelow(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it) {
/*    */     ColorImp colorImp;
/* 34 */     int m = 15;
/* 35 */     Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 36 */     if (WORLD.REGIONS().border().is(it.tile())) {
/* 37 */       m = 0;
/* 38 */       for (DIR d : DIR.ORTHO) {
/* 39 */         if (!WORLD.IN_BOUNDS(it.tx(), it.ty(), d) || reg == (WORLD.REGIONS()).map.get(it.tx(), it.ty(), d)) {
/* 40 */           m |= d.mask();
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 45 */     COLOR c = (GCOLOR.MAP()).F_REBEL;
/* 46 */     if (reg != null && reg.faction() != null && reg.faction() != FACTIONS.player()) {
/* 47 */       ColorImp col = ColorImp.TMP;
/* 48 */       GCOLOR.UI().badToGood(col, ROPINION.get(((FactionNPC)reg.faction()).court().king().roy()));
/* 49 */       colorImp = col;
/*    */     } 
/*    */     
/* 52 */     colorImp.bind();
/* 53 */     renderUnder(m, r, it);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAbove(Renderer r, ShadowBatch s, RenderData data) {
/* 59 */     (WORLD.OVERLAY()).regNames.renderAbove(r, s, data);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\OverlayDiplomacy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */