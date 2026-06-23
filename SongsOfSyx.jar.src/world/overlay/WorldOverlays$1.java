/*    */ package world.overlay;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.faction.FACTIONS;
/*    */ import game.raiding.RaidingMap;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.Renderer;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import util.rendering.RenderData;
/*    */ import util.rendering.ShadowBatch;
/*    */ import world.map.regions.Region;
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
/*    */   extends OverlayRegAbs
/*    */ {
/*    */   null(CharSequence $anonymous0, CharSequence $anonymous1, boolean $anonymous2) {
/* 50 */     super($anonymous0, $anonymous1, $anonymous2);
/*    */   }
/*    */   
/*    */   public double value(Region reg) {
/* 54 */     return CLAMP.d((GAME.raiders()).entry.get(reg).security(), 0.0D, 1.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean is(Region reg) {
/* 59 */     return (reg.faction() == FACTIONS.player() && !reg.capitol());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void renderAbove(Renderer ren, ShadowBatch s, RenderData data) {
/* 65 */     super.renderAbove(ren, s, data);
/*    */     
/* 67 */     COLOR.WHITE2WHITE.bind();
/*    */     
/* 69 */     for (RaidingMap.RaidEntryPoint c : (GAME.raiders()).entry.entrySpots()) {
/* 70 */       int x = data.transformGX(c.c().x() * 64);
/* 71 */       int y = data.transformGY(c.c().y() * 64);
/*    */       
/* 73 */       (UI.icons()).s.alert.renderScaled((SPRITE_RENDERER)ren, x, y, 4);
/*    */     } 
/*    */     
/* 76 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\overlay\WorldOverlays$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */