/*     */ package view.sett.ui.room.priority;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.sprite.SPRITES;
/*     */ import init.type.WGROUP;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import settlement.room.main.employment.RoomEmploymentSimple;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.slider.GGaugeMutable;
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
/*  78 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  83 */     double d = CLAMP.d(emp.target.group((WGROUP)e.o) / emp.target.get(), 0.0D, 1.0D);
/*  84 */     GMeter.render(r, GMeter.C_ORANGE, d, X1, X2, Y1, Y2);
/*     */     
/*  86 */     d = ((WGROUP)e.o).race.pref().getWork((RoomEmploymentSimple)emp);
/*  87 */     GGaugeMutable.bad2Good(ColorImp.TMP, d);
/*  88 */     ColorImp.TMP.bind();
/*  89 */     int am = (int)Math.round(d * 4.0D);
/*  90 */     am = CLAMP.i(am, 0, 4); int i;
/*  91 */     for (i = 0; i < am; i++) {
/*  92 */       (SPRITES.icons()).s.plus.render(r, X1 + 20 + i * 16 / 2, Y1);
/*     */     }
/*  94 */     COLOR.unbind();
/*  95 */     d = RACES.boosts().getNorSkill(((WGROUP)e.o).race, (RoomEmploymentSimple)emp);
/*  96 */     GGaugeMutable.bad2Good(ColorImp.TMP, d);
/*  97 */     ColorImp.TMP.bind();
/*  98 */     am = (int)Math.round(d * 4.0D);
/*  99 */     am = CLAMP.i(am, 0, 4);
/* 100 */     for (i = 0; i < am; i++) {
/* 101 */       (SPRITES.icons()).s.minus.render(r, X1 + 20 + i * 16 / 2, Y1 + 14);
/*     */     }
/* 103 */     COLOR.unbind();
/* 104 */     e.icon.render(r, X1, Y1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\priority\Row$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */