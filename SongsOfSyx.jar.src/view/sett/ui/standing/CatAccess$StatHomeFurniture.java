/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GAllocator;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class StatHomeFurniture
/*     */   extends GuiSection
/*     */ {
/*     */   private final int ri;
/*     */   private final HCLASS cl;
/*     */   private final LIST<RES_AMOUNT> rr;
/*     */   private final GETTER<Race> race;
/*     */   
/*     */   public StatHomeFurniture(int resource, final HCLASS cl, final GETTER<Race> race, LIST<RES_AMOUNT> rr) {
/* 205 */     this.ri = resource;
/* 206 */     this.race = race;
/* 207 */     this.cl = cl;
/* 208 */     this.rr = rr;
/* 209 */     INT.INTE tar = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 213 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 218 */           if (CatAccess.StatHomeFurniture.this.res() == null)
/* 219 */             return 1; 
/* 220 */           return CatAccess.StatHomeFurniture.this.res().amount();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 225 */           return STATS.HOME().target(cl, (Race)race.get(), CatAccess.StatHomeFurniture.this.res().resource());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 230 */           STATS.HOME().targetSet(t, cl, (Race)race.get(), CatAccess.StatHomeFurniture.this.res().resource());
/*     */         }
/*     */       };
/*     */     
/* 234 */     GAllocator al = new GAllocator(COLOR.ORANGE100, tar, 6, 16, 16);
/*     */     
/* 236 */     add((SPRITE)new SPRITE.Imp(24)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 240 */             CatAccess.StatHomeFurniture.this.res().resource().icon().render(r, X1, Y1);
/*     */           }
/* 243 */         }0, 0);
/*     */     
/* 245 */     DOUBLE d = new DOUBLE()
/*     */       {
/*     */         public double getD()
/*     */         {
/* 249 */           double tot = STATS.HOME().needed(cl, (Race)race.get(), CatAccess.StatHomeFurniture.this.ri);
/* 250 */           if (tot == 0.0D)
/* 251 */             return 0.0D; 
/* 252 */           double am = STATS.HOME().current(cl, (Race)race.get(), CatAccess.StatHomeFurniture.this.ri);
/* 253 */           return am / tot;
/*     */         }
/*     */       };
/*     */     
/* 257 */     add((SPRITE)new GMeter.GMeterSprite(GMeter.C_REDGREEN, d, 130, 16), body().x2() + 4, 0);
/*     */     
/* 259 */     add((RENDEROBJ)al, getLastX1(), getLastY2() + 2);
/*     */     
/* 261 */     pad(8, 8);
/*     */   }
/*     */ 
/*     */   
/*     */   private RES_AMOUNT res() {
/* 266 */     return res((Race)this.race.get());
/*     */   }
/*     */   
/*     */   private RES_AMOUNT res(Race race) {
/* 270 */     if (race == null) {
/* 271 */       if (this.ri >= this.rr.size())
/* 272 */         return null; 
/* 273 */       return (RES_AMOUNT)this.rr.get(this.ri);
/*     */     } 
/*     */     
/* 276 */     if (race.home().clas(this.cl).resources().size() <= this.ri) {
/* 277 */       return null;
/*     */     }
/* 279 */     return (RES_AMOUNT)race.home().clas(this.cl).resources().get(this.ri);
/*     */   }
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 284 */     activeSet((res() != null));
/* 285 */     if (activeIs()) {
/* 286 */       super.render(r, ds);
/*     */     }
/*     */   }
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 291 */     RES_AMOUNT res = res();
/* 292 */     if (res == null)
/*     */       return; 
/* 294 */     GBox b = (GBox)text;
/* 295 */     b.title((res().resource()).name);
/*     */     
/* 297 */     b.text(CatAccess.¤¤FurnitureD);
/* 298 */     b.NL(8);
/*     */ 
/*     */     
/* 301 */     int tot = STATS.HOME().needed(this.cl, (Race)this.race.get(), this.ri);
/* 302 */     int am = STATS.HOME().current(this.cl, (Race)this.race.get(), this.ri);
/* 303 */     b.add((SPRITE)GFORMAT.iofkInv(b.text(), am, tot));
/* 304 */     b.NL(8);
/*     */     
/* 306 */     b.textL(Dic.¤¤ConsumptionRate);
/* 307 */     b.NL();
/* 308 */     GText t = b.text();
/* 309 */     t.add(CatAccess.¤¤Yearly);
/* 310 */     t.insert(0, STATS.HOME().rate(this.cl, (Race)this.race.get()), 2);
/* 311 */     t.insert(1, (int)(STATS.HOME().rate(this.cl, (Race)this.race.get()) * STATS.HOME().current(this.cl, (Race)this.race.get(), this.ri)));
/* 312 */     t.insert(2, (int)(STATS.HOME().rate(this.cl, (Race)this.race.get()) * (STATS.POP()).POP.data(this.cl).get(this.race.get())) * STATS.HOME().target(this.cl, (Race)this.race.get(), res.resource()));
/* 313 */     b.add((SPRITE)t);
/*     */     
/* 315 */     if (this.race.get() == null) {
/* 316 */       b.NL(8);
/* 317 */       b.textL(Dic.¤¤Used);
/* 318 */       for (Race r : RACES.all()) {
/*     */ 
/*     */ 
/*     */         
/* 322 */         if (r.home().clas(this.cl).amount(res.resource()) > 0)
/* 323 */           b.add((SPRITE)(r.appearance()).icon); 
/*     */       } 
/* 325 */       b.NL();
/*     */     } 
/*     */     
/* 328 */     super.hoverInfoGet(text);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatAccess$StatHomeFurniture.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */