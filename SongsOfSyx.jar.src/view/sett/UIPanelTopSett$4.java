/*     */ package view.sett;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HGROUP;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.MATH;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends UIPanelTopSett.Buttt
/*     */ {
/*     */   int hi;
/*     */   int min;
/*     */   int proc;
/*     */   
/*     */   null(SPRITE $anonymous0, ISidePanel $anonymous1) {
/* 248 */     super($anonymous0, $anonymous1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 267 */     this.hi = 0;
/* 268 */     this.min = 0;
/* 269 */     this.proc = 0;
/*     */   }
/*     */   protected double valueNext() {
/*     */     return value();
/*     */   }
/* 274 */   protected int getNumber() { if (this.hi >= HGROUP.all().size()) {
/* 275 */       this.hi = 0;
/* 276 */       if (this.proc == Integer.MAX_VALUE)
/* 277 */         this.proc = 0; 
/* 278 */       this.min = this.proc;
/* 279 */       this.proc = Integer.MAX_VALUE;
/*     */     } 
/*     */     
/* 282 */     HGROUP t = (HGROUP)HGROUP.all().get(this.hi);
/*     */     
/* 284 */     int i = (SETT.ROOMS()).HOME.total((HGROUP)HGROUP.all().get(this.hi));
/* 285 */     int p = (STATS.POP()).POP.data(t.type).get(t.race);
/* 286 */     if (p > 0) {
/* 287 */       i -= (STATS.POP()).POP.data(t.type).get(t.race);
/* 288 */       this.proc = Math.min(this.proc, i);
/*     */     } 
/*     */ 
/*     */     
/* 292 */     this.hi++;
/*     */     
/* 294 */     return this.min; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 300 */     text.title(Dic.¤¤Housing);
/* 301 */     GBox b = (GBox)text;
/*     */     
/* 303 */     b.tab(2);
/* 304 */     b.textLL(Dic.¤¤HomeLess);
/* 305 */     b.NL();
/*     */     
/* 307 */     STAT s = (STATS.HOME()).GETTER.hasSearched;
/*     */     
/* 309 */     b.NL();
/* 310 */     b.tab(6);
/* 311 */     b.textLL((HCLASSES.CITIZEN()).names);
/* 312 */     b.tab(9);
/* 313 */     b.textLL((HCLASSES.SLAVE()).names);
/* 314 */     b.tab(12);
/* 315 */     b.textLL((HCLASSES.NOBLE()).names);
/* 316 */     b.NL();
/* 317 */     for (int ri = 0; ri < RACES.all().size(); ri++) {
/* 318 */       Race r = (FACTIONS.player()).races.get(ri);
/* 319 */       b.add((SPRITE)(r.appearance()).icon);
/* 320 */       b.textL(r.info.names);
/* 321 */       b.tab(6);
/* 322 */       b.add((SPRITE)GFORMAT.i(b.text(), s.data(HCLASSES.CITIZEN()).get(r)));
/* 323 */       b.tab(9);
/* 324 */       b.add((SPRITE)GFORMAT.i(b.text(), s.data(HCLASSES.SLAVE()).get(r)));
/* 325 */       b.tab(12);
/* 326 */       b.add((SPRITE)GFORMAT.i(b.text(), s.data(HCLASSES.NOBLE()).get(r)));
/* 327 */       b.NL();
/*     */     } 
/*     */   } protected double value() { double pop = (STATS.POP()).POP.data(null).get(null); if (pop == 0.0D)
/*     */       return 1.0D;  double d = MATH.pow15.pow((pop - (STATS.HOME()).GETTER.hasSearched.data(null).get(null)) / pop);
/*     */     if (d >= 1.0D)
/*     */       d += ((SETT.ROOMS()).HOME.total(null) - (SETT.ROOMS()).HOME.used(null)) / (pop + 1.0D); 
/* 333 */     return d; } protected boolean isActive() { return true; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\sett\UIPanelTopSett$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */