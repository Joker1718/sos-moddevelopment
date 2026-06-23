/*     */ package view.ui.profile;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.player.PTitles;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import util.colors.GCOLOR;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends RENDEROBJ.RenderImp
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 142 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 146 */     if (!title.selected() && (!title.unlocked() || !title.race(FACTIONS.player().race())))
/* 147 */       (GCOLOR.T()).INACTIVE.bind(); 
/* 148 */     title.icon.render(r, (RECTANGLE)this.body);
/* 149 */     COLOR.unbind();
/*     */     
/* 151 */     int x1 = Titles.Butt.access$0(Titles.Butt.this).x2() - 40;
/* 152 */     int y1 = Titles.Butt.access$0(Titles.Butt.this).y1() + 16;
/*     */     
/* 154 */     for (Race ra : RACES.playable()) {
/* 155 */       if (title.race(ra)) {
/* 156 */         (ra.appearance()).icon.render(r, x1, y1);
/* 157 */         x1 -= 38;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\profile\Titles$Butt$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */