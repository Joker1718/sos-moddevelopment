/*    */ package view.sett.ui.standing;
/*    */ 
/*    */ import init.race.Race;
/*    */ import init.sprite.SPRITES;
/*    */ import init.type.HCLASS;
/*    */ import settlement.stats.stat.STAT;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.color.COLOR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ import util.colors.GCOLOR;
/*    */ import util.data.GETTER;
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
/*    */ class Arrow
/*    */   extends RENDEROBJ.RenderImp
/*    */ {
/*    */   private final STAT s;
/*    */   private final HCLASS cl;
/*    */   private final GETTER<Race> race;
/*    */   
/*    */   Arrow(STAT s, HCLASS cl, GETTER<Race> race) {
/* 82 */     super(16);
/* 83 */     this.s = s;
/* 84 */     this.cl = cl;
/* 85 */     this.race = race;
/*    */   }
/*    */ 
/*    */   
/*    */   public void render(SPRITE_RENDERER r, float ds) {
/* 90 */     int v = (int)(this.s.standing().getHistoric(this.cl, (Race)this.race.get(), 1) * 256.0D);
/* 91 */     int n = (int)(this.s.standing().get(this.cl, (Race)this.race.get()) * 256.0D);
/* 92 */     if (n > v) {
/* 93 */       GCOLOR.UI().goodFlash().bind();
/* 94 */       (SPRITES.icons()).s.arrow_right.render(r, (RECTANGLE)this.body);
/* 95 */     } else if (n < v) {
/* 96 */       GCOLOR.UI().badFlash().bind();
/* 97 */       (SPRITES.icons()).s.arrow_left.render(r, (RECTANGLE)this.body);
/*    */     } 
/* 99 */     COLOR.unbind();
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\StatRow$Arrow.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */