/*    */ package view.ui.profile;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import util.gui.misc.GText;
/*    */ import util.gui.misc.GTextR;
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
/*    */   extends GTextR
/*    */ {
/*    */   null(GText $anonymous0) {
/* 39 */     super($anonymous0);
/*    */   }
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 42 */     text().clear();
/* 43 */     text().add(Level.this.¤¤Title);
/* 44 */     text().insert(0, FACTIONS.player().level().current().name());
/* 45 */     text().insert(1, FACTIONS.player().rulerName());
/* 46 */     text().insert(2, (CharSequence)(FACTIONS.player()).name);
/* 47 */     text().adjustWidth();
/* 48 */     super.render(r, ds, isHovered);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\Level$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */