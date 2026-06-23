/*    */ package world.map.regions;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import init.sprite.SPRITES;
/*    */ import snake2d.CORE;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.color.ColorImp;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.misc.ACTION;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.WORLD;
/*    */ import world.overlay.WorldOverlays;
/*    */ 
/*    */ public class Gen {
/*    */   public Gen(ACTION lprinter) {
/* 20 */     (WORLD.OVERLAY()).debug = (WorldOverlays.Overlay)new WorldOverlays.OverlayTile(true, false)
/*    */       {
/*    */         protected void renderAbove(SPRITE_RENDERER r, ShadowBatch s, RenderData.RenderIterator it)
/*    */         {
/* 24 */           Region reg = (Region)(WORLD.REGIONS()).map.get(it.tile());
/* 25 */           if (reg == null)
/*    */             return; 
/* 27 */           ColorImp.TMP.set((COLOR)COLOR.UNIQUE.getC(reg.index())).setBrightnessSelf(2.0D);
/* 28 */           int m = 0;
/* 29 */           for (DIR d : DIR.ORTHO) {
/* 30 */             if ((WORLD.REGIONS()).map.get(it.tx(), it.ty(), d) == reg) {
/* 31 */               m |= d.mask();
/*    */             }
/*    */           } 
/* 34 */           ColorImp.TMP.bind();
/* 35 */           (SPRITES.cons()).BIG.outline.render((SPRITE_RENDERER)CORE.renderer(), m, it.x(), it.y());
/*    */ 
/*    */           
/* 38 */           COLOR.unbind();
/*    */         }
/*    */       };
/*    */ 
/*    */     
/* 43 */     if (!GenPlayer.gen())
/*    */       return; 
/* 45 */     lprinter.exe();
/*    */     
/* 47 */     lprinter.exe();
/*    */     
/* 49 */     lprinter.exe();
/*    */     
/* 51 */     lprinter.exe();
/*    */ 
/*    */     
/* 54 */     (WORLD.REGIONS()).player.fationSet((Faction)FACTIONS.player(), false);
/* 55 */     (WORLD.REGIONS()).player.setCapitol();
/*    */     
/* 57 */     WORLD.MINIMAP().repaint();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 66 */     while (FACTIONS.NPCs().size() > 0) {
/* 67 */       FACTIONS.remove((FactionNPC)FACTIONS.NPCs().get(0), false);
/*    */     }
/* 69 */     WORLD.REGIONS().saver().clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\map\regions\Gen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */