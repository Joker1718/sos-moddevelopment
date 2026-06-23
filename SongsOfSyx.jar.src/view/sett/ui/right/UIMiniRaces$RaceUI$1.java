/*     */ package view.sett.ui.right;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import view.main.VIEW;
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
/*     */ 
/*     */ class null
/*     */   extends SPRITE.Imp
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 146 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/* 150 */     Race res = (FACTIONS.player()).races.get(ri);
/* 151 */     if (POP.next(HCLASSES.CITIZEN(), res) == 0)
/* 152 */       COLOR.WHITE65.bind(); 
/* 153 */     (res.appearance()).icon.render(r, X1, Y1);
/* 154 */     COLOR.unbind();
/*     */     
/* 156 */     if (VIEW.renderSecond() - UIMiniRaces.RaceUI.this.viewI > 5.0D) {
/* 157 */       UIMiniRaces.RaceUI.this.old = UIMiniRaces.RaceUI.this.cache;
/* 158 */       UIMiniRaces.RaceUI.this.cache = SETT.ENTRY().immi().wanted(res);
/* 159 */       UIMiniRaces.RaceUI.this.viewI = VIEW.renderSecond();
/*     */     } 
/*     */     
/* 162 */     if (UIMiniRaces.RaceUI.this.cache == 0) {
/*     */       return;
/*     */     }
/* 165 */     int am = CLAMP.i(UIMiniRaces.RaceUI.this.cache / 5, 1, 4);
/*     */     
/* 167 */     COLOR.BLACK.bind(); int i;
/* 168 */     for (i = 0; i < am; i++)
/* 169 */       (SPRITES.icons()).s.arrow_right.render(r, X1 - 10 + 12 * i, Y1 - 2); 
/* 170 */     COLOR.YELLOW100.bind();
/*     */     
/* 172 */     if (UIMiniRaces.RaceUI.this.cache > UIMiniRaces.RaceUI.this.old)
/* 173 */       OPACITY.O25TO100.bind(); 
/* 174 */     for (i = 0; i < am; i++)
/* 175 */       (SPRITES.icons()).s.arrow_right.render(r, X1 - 12 + 12 * i, Y1 - 4); 
/* 176 */     COLOR.unbind();
/* 177 */     OPACITY.unbind();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniRaces$RaceUI$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */