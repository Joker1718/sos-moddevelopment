/*     */ package view.world.ui.region;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends HOVERABLE.HoverableAbs
/*     */ {
/*     */   null(int $anonymous0, int $anonymous1) {
/* 306 */     super($anonymous0, $anonymous1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isHovered) {
/* 311 */     COLOR.WHITE25.render(r, (RECTANGLE)this.body);
/* 312 */     double maxPop = 3.0D * RD.RACES().maxPop((Region)g.get());
/* 313 */     int maxAm = wi / 8 * YS;
/* 314 */     int m = (this.body.width() - wi) / 2;
/* 315 */     int x1 = this.body.x1() + m;
/* 316 */     int y1 = this.body.y1() + 4;
/*     */ 
/*     */ 
/*     */     
/* 320 */     double d = maxPop / (3 * (RD.RACES()).population.get((Region)g.get()));
/* 321 */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */     
/* 323 */     int dx = (int)(24.0D * d);
/* 324 */     dx = CLAMP.i(dx, 1, 24);
/*     */     
/* 326 */     int i = 0;
/*     */     
/* 328 */     int lineMax = (int)Math.ceil((wi - 20) / dx);
/*     */     
/* 330 */     for (RDRace ra : (RD.RACES()).all) {
/* 331 */       int am = (int)Math.ceil((maxAm * ra.pop.get((Region)g.get())) / maxPop);
/*     */       
/* 333 */       while (am > 0) {
/* 334 */         am--;
/*     */         
/* 336 */         int x = dx * i % lineMax;
/* 337 */         int y = i / lineMax;
/* 338 */         i++;
/* 339 */         if (y >= YS) {
/*     */           break;
/*     */         }
/* 342 */         (ra.race.appearance()).icon.render(r, x1 + x, y1 + y * 24);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 351 */     GBox b = (GBox)text;
/* 352 */     b.title(Dic.¤¤Population);
/*     */     
/* 354 */     b.tab(6);
/* 355 */     b.textL(Dic.¤¤Population);
/* 356 */     b.tab(9);
/* 357 */     b.textL(Dic.¤¤Biome);
/* 358 */     b.NL();
/*     */     
/* 360 */     for (RDRace ra : (RD.RACES()).all) {
/*     */       
/* 362 */       double v = ra.pop.base((Region)g.get());
/* 363 */       b.add((SPRITE)(ra.race.appearance()).iconBig);
/* 364 */       b.text(ra.race.info.names);
/* 365 */       b.tab(6);
/*     */       
/* 367 */       b.add((SPRITE)GFORMAT.i(b.text(), ra.pop.get((Region)g.get())));
/* 368 */       b.tab(9);
/* 369 */       b.add((SPRITE)GFORMAT.perc(b.text(), v));
/* 370 */       b.NL();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 376 */     b.textLL(Dic.¤¤Total);
/* 377 */     b.tab(6);
/* 378 */     b.add((SPRITE)GFORMAT.iBig(b.text(), (RD.RACES()).population.get((Region)g.get())));
/* 379 */     b.add((SPRITE)(UI.icons()).s.arrow_right);
/* 380 */     b.add((SPRITE)GFORMAT.iBig(b.text(), (int)(RD.RACES()).popTarget.getD(g.get())));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\worl\\ui\region\MiscBasics$11.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */