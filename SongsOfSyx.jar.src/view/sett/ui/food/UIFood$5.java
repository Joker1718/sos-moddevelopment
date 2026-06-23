/*     */ package view.sett.ui.food;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.ResG;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStaples
/*     */ {
/*     */   null(int $anonymous0) {
/* 258 */     super($anonymous0);
/*     */   }
/*     */   
/*     */   protected void hover(GBox box, int stapleI) {
/* 262 */     int ii = 8 - stapleI - 1;
/* 263 */     box.title(((STATS.FOOD()).FOOD_DAYS.info()).name);
/*     */ 
/*     */     
/* 266 */     GText tt = box.text();
/* 267 */     DicTime.setDaysAgo((Str)tt, (ii * 4));
/* 268 */     box.textLL((CharSequence)tt);
/* 269 */     box.NL(4);
/*     */ 
/*     */ 
/*     */     
/* 273 */     box.textLL(((STATS.FOOD()).FOOD_DAYS.info()).name);
/* 274 */     box.tab(7);
/* 275 */     box.add((SPRITE)GFORMAT.f(box.text(), (STATS.FOOD()).FOOD_DAYS.data(null).getD(null, ii * 4) * (STATS.FOOD()).FOOD_DAYS.dataDivider()));
/* 276 */     box.NL();
/*     */ 
/*     */ 
/*     */     
/* 280 */     box.textLL(Dic.¤¤Population);
/* 281 */     box.tab(7);
/* 282 */     box.add((SPRITE)GFORMAT.i(box.text(), POP.physical(null, null)));
/* 283 */     box.NL();
/*     */ 
/*     */ 
/*     */     
/* 287 */     box.textLL(Dic.¤¤Stored);
/* 288 */     box.tab(7);
/* 289 */     int st = 0;
/* 290 */     for (ResG rr : RESOURCES.EDI().all()) {
/* 291 */       st += ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(rr.resource);
/*     */     }
/* 293 */     box.add((SPRITE)GFORMAT.i(box.text(), st));
/* 294 */     box.NL();
/*     */ 
/*     */     
/* 297 */     box.sep();
/*     */ 
/*     */     
/* 300 */     int net = 0;
/*     */     
/* 302 */     for (FResources.RTYPE t : FResources.RTYPE.all) {
/* 303 */       box.text(t.name);
/* 304 */       box.tab(7);
/* 305 */       int in = 0;
/* 306 */       int out = 0;
/* 307 */       for (ResG rr : RESOURCES.EDI().all()) {
/* 308 */         in += FACTIONS.player().res().in(t).history(rr.resource.tr()).get(ii);
/* 309 */         out += FACTIONS.player().res().out(t).history(rr.resource.tr()).get(ii);
/*     */       } 
/* 311 */       net += in;
/* 312 */       net -= out;
/* 313 */       box.add((SPRITE)GFORMAT.iIncr(box.text(), in));
/* 314 */       box.tab(9);
/* 315 */       box.add((SPRITE)GFORMAT.iIncr(box.text(), -out));
/* 316 */       box.NL();
/*     */     } 
/*     */     
/* 319 */     box.textL(Dic.¤¤Net);
/* 320 */     box.tab(7);
/* 321 */     box.add((SPRITE)GFORMAT.iIncr(box.text(), net));
/* 322 */     box.NL();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected double getValue(int stapleI) {
/* 332 */     int ii = 8 - stapleI - 1;
/* 333 */     return (STATS.FOOD()).FOOD_DAYS.data(null).getD(null, ii * 4) * (STATS.FOOD()).FOOD_DAYS.dataDivider();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\food\UIFood$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */