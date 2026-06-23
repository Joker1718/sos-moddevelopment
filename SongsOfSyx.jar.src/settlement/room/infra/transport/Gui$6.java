/*     */ package settlement.room.infra.transport;
/*     */ 
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.employment.RoomEmploymentIns;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStat
/*     */ {
/*     */   public void update(GText text) {
/* 240 */     TransportInstance i = (TransportInstance)g.get();
/*     */     
/* 242 */     double bonus = Gui.this.bonus(i);
/* 243 */     double workload = i.employees().efficiency();
/* 244 */     double eff = i.efficiency();
/* 245 */     double workersPerLoad = 1.0D / bonus * workload * eff;
/* 246 */     workersPerLoad += i.stationWorkers;
/* 247 */     double fetching = 1.0D - i.fetchTime;
/* 248 */     double warhousefetch = bonus * 800.0D * ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue / 100.0D;
/* 249 */     double moved = i.distance * fetching * 400.0D / workersPerLoad * 100.0D + (1.0D - fetching) * warhousefetch;
/*     */     
/* 251 */     GFORMAT.perc(text, moved / warhousefetch);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GBox b) {
/* 257 */     b.title(Gui.¤¤efficiency);
/* 258 */     b.text(Gui.¤¤efficiencyD);
/* 259 */     b.sep();
/* 260 */     TransportInstance i = (TransportInstance)g.get();
/* 261 */     int tab = 7;
/*     */     
/* 263 */     double bonus = Gui.this.bonus(i);
/* 264 */     double warhousefetch = 800.0D * bonus * ((SETT.ROOMS()).STOCKPILE.bonus()).baseValue / 100.0D;
/*     */ 
/*     */     
/* 267 */     b.textLL(((SETT.ROOMS()).STOCKPILE.bonus()).name);
/* 268 */     b.tab(tab);
/* 269 */     b.add((SPRITE)GFORMAT.perc(b.text(), bonus - 1.0D));
/* 270 */     b.NL();
/* 271 */     b.text(Gui.¤¤bonusD);
/* 272 */     b.NL(2);
/*     */     
/* 274 */     double workload = i.employees().efficiency();
/*     */     
/* 276 */     b.textLL(RoomEmploymentIns.¤¤Workload);
/* 277 */     b.tab(tab);
/* 278 */     b.add((SPRITE)GFORMAT.perc(b.text(), workload));
/* 279 */     b.NL();
/* 280 */     b.text(Gui.¤¤workloadD);
/* 281 */     b.NL(2);
/*     */     
/* 283 */     double fetching = 1.0D - i.fetchTime;
/*     */     
/* 285 */     b.textLL(Gui.¤¤Fetching);
/* 286 */     b.tab(tab);
/* 287 */     b.add((SPRITE)GFORMAT.perc(b.text(), i.fetchTime));
/* 288 */     b.NL();
/* 289 */     b.text(Gui.¤¤FetchingD);
/* 290 */     b.NL(2);
/*     */     
/* 292 */     double eff = i.efficiency();
/*     */     
/* 294 */     b.textLL(Gui.¤¤EmployeeEff);
/* 295 */     b.tab(tab);
/* 296 */     b.add((SPRITE)GFORMAT.perc(b.text(), eff));
/* 297 */     b.NL();
/* 298 */     GText t = b.text();
/* 299 */     t.add(Gui.¤¤EmployeeEffD).insert(0, 16);
/* 300 */     b.add((SPRITE)t);
/* 301 */     b.NL(2);
/*     */ 
/*     */ 
/*     */     
/* 305 */     double dist = i.distance;
/* 306 */     double stationWorkers = i.stationWorkers;
/*     */     
/* 308 */     b.textLL(Gui.¤¤Distance);
/* 309 */     b.tab(tab);
/* 310 */     b.add((SPRITE)GFORMAT.perc(b.text(), dist / 100.0D * i.stationWorkers));
/* 311 */     b.NL();
/* 312 */     GText gText1 = b.text();
/* 313 */     gText1.add(Gui.¤¤DistanceD).insert(0, (int)dist);
/* 314 */     gText1.insert(1, i.stationWorkers, 1);
/* 315 */     b.text((CharSequence)gText1);
/* 316 */     b.NL(2);
/*     */ 
/*     */     
/* 319 */     double perDayFetch = workload * warhousefetch * (1.0D - fetching);
/* 320 */     double perDayCart = workload * bonus * 400.0D * eff * fetching * dist / 100.0D;
/*     */     
/* 322 */     b.textLL(Gui.¤¤totMoved);
/* 323 */     b.tab(tab);
/* 324 */     b.add((SPRITE)GFORMAT.i(b.text(), ((int)(perDayFetch + perDayCart) * i.employees().employed())));
/* 325 */     b.NL();
/* 326 */     GText gText2 = b.text();
/* 327 */     gText2.add(Gui.¤¤totMovedD);
/* 328 */     gText2.insert(0, (int)perDayFetch * i.employees().employed());
/* 329 */     gText2.insert(1, (int)perDayCart * i.employees().employed());
/* 330 */     b.add((SPRITE)gText2);
/* 331 */     b.NL(2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 336 */     double workersPerLoad = 1.0D / bonus * workload * eff;
/* 337 */     workersPerLoad += stationWorkers;
/*     */     
/* 339 */     double moved = dist * fetching * 400.0D / workersPerLoad * 100.0D + (1.0D - fetching) * warhousefetch;
/*     */     
/* 341 */     b.textLL(Gui.¤¤Load);
/* 342 */     b.tab(tab);
/* 343 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)moved));
/* 344 */     b.NL();
/* 345 */     b.text(Gui.¤¤LoadD);
/* 346 */     b.NL(2);
/*     */ 
/*     */ 
/*     */     
/* 350 */     b.sep();
/* 351 */     b.textLL(Gui.¤¤Result);
/* 352 */     b.tab(tab);
/* 353 */     double d = moved / warhousefetch;
/* 354 */     b.add((SPRITE)GFORMAT.perc(b.text(), d));
/* 355 */     b.NL();
/* 356 */     GText gText3 = b.text();
/* 357 */     gText3.add(Gui.¤¤ResultD).insert(0, warhousefetch, 1);
/* 358 */     b.add((SPRITE)gText3);
/* 359 */     b.NL(6);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\transport\Gui$6.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */