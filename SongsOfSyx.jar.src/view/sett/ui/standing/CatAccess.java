/*     */ package view.sett.ui.standing;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.resources.RES_AMOUNT;
/*     */ import init.type.HCLASS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsFood;
/*     */ import settlement.stats.colls.StatsHome;
/*     */ import settlement.stats.equip.EquipCivic;
/*     */ import settlement.stats.equip.StatsEquip;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GAllocator;
/*     */ import util.gui.slider.GTarget;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ class CatAccess
/*     */   extends Cats.Cat
/*     */ {
/*  45 */   private static CharSequence ¤¤PreferedBy = "¤Preferred By:";
/*  46 */   private static CharSequence ¤¤Allowed = "¤Allowed to consume";
/*  47 */   private static CharSequence ¤¤AllowedNot = "¤Not allowed to consume";
/*  48 */   private static CharSequence ¤¤Yearly = "¤{0} per item per year. Estimation: -{1} with current furnishing, and -{2} if the target is fulfilled.";
/*  49 */   private static CharSequence ¤¤FurnitureD = "The amount allowed to furnish a subject's home. More allowed and available will increase happiness from furnishing.";
/*  50 */   private static CharSequence ¤¤desc = "¤Stats and settings related to consumable resources";
/*     */   static {
/*  52 */     D.ts(CatAccess.class);
/*     */   }
/*     */ 
/*     */   
/*     */   CatAccess(final HCLASS c, final GETTER<Race> race) {
/*  57 */     super(new StatCollection[] { (StatCollection)STATS.FOOD(), (StatCollection)STATS.EQUIP(), (StatCollection)STATS.HOME() });
/*     */     
/*  59 */     titleSet(Dic.¤¤Access);
/*  60 */     this.name = Dic.¤¤Access;
/*  61 */     this.desc = ¤¤desc;
/*  62 */     LinkedList<RENDEROBJ> rens = new LinkedList();
/*     */ 
/*     */     
/*  65 */     final StatsFood s = STATS.FOOD();
/*     */     
/*  67 */     rens.add(new StatRow.Title(statsFood.info));
/*     */     
/*  69 */     for (STAT st : statsFood.all()) {
/*  70 */       rens.add(new StatRow(st, c, race));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  75 */     GuiSection ss = new GuiSection();
/*     */ 
/*     */     
/*  78 */     int ww = 7;
/*     */     
/*  80 */     LIST<RESOURCE> ll = RESOURCES.EDI().res().join(RESOURCES.DRINKS().res());
/*  81 */     RBIT.RBITImp bbb = new RBIT.RBITImp();
/*  82 */     for (int i = 0; i < ll.size(); i++) {
/*  83 */       final RESOURCE e = (RESOURCE)ll.get(i);
/*  84 */       if (!bbb.has(e)) {
/*     */         
/*  86 */         bbb.or(e);
/*  87 */         final int k = i;
/*  88 */         GButt.Checkbox cl = new GButt.Checkbox((SPRITE)e.icon())
/*     */           {
/*     */             protected void clickA()
/*     */             {
/*  92 */               s.allowed(k).toggle(c, (Race)race.get());
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/*  97 */               selectedSet(s.allowed(k).get(c, (Race)race.get()));
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 103 */               if (race.get() != null && (((Race)race.get()).pref()).foodMask.has(e)) {
/* 104 */                 COLOR.WHITE100.render(r, (RECTANGLE)this.body, 1);
/* 105 */                 COLOR.WHITE15.render(r, (RECTANGLE)this.body, 0);
/*     */               } 
/* 107 */               super.render(r, ds, isActive, isSelected, isHovered);
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GUI_BOX text) {
/* 114 */               GBox b = (GBox)text;
/* 115 */               text.title(e.name);
/* 116 */               if (selectedIs()) {
/* 117 */                 b.text(CatAccess.¤¤Allowed);
/*     */               } else {
/* 119 */                 b.error(CatAccess.¤¤AllowedNot);
/* 120 */               }  b.NL(4);
/* 121 */               b.textLL(CatAccess.¤¤PreferedBy);
/* 122 */               b.NL();
/* 123 */               if (RESOURCES.EDI().is(e)) {
/* 124 */                 for (Race r : RACES.all()) {
/* 125 */                   if ((r.pref()).food.contains(RESOURCES.EDI().get(e))) {
/* 126 */                     b.add((SPRITE)(r.appearance()).iconBig);
/*     */                   }
/*     */                 } 
/*     */               }
/* 130 */               if (RESOURCES.DRINKS().is(e)) {
/* 131 */                 for (Race r : RACES.all()) {
/* 132 */                   if ((r.pref()).drink.contains(RESOURCES.DRINKS().get(e))) {
/* 133 */                     b.add((SPRITE)(r.appearance()).iconBig);
/*     */                   }
/*     */                 } 
/*     */               }
/*     */             }
/*     */           };
/*     */ 
/*     */ 
/*     */         
/* 142 */         cl.hoverTitleSet(e.name);
/* 143 */         cl.pad(8, 2);
/*     */         
/* 145 */         ss.add((RENDEROBJ)cl, cl.body().width() * i % ww, i / ww * cl.body().height());
/*     */       } 
/*     */     } 
/* 148 */     rens.add(ss);
/*     */ 
/*     */ 
/*     */     
/* 152 */     StatsEquip s = STATS.EQUIP();
/* 153 */     rens.add(new StatRow.Title(s.info));
/*     */     
/* 155 */     for (EquipCivic equipCivic : s.civics()) {
/* 156 */       rens.add(new StatRowEquip(equipCivic, c, race));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     LIST<RES_AMOUNT> rr = RACES.res().homeResMax(c);
/*     */ 
/*     */     
/* 165 */     StatsHome statsHome = STATS.HOME();
/* 166 */     rens.add(new StatRow.Title(statsHome.info));
/*     */     
/* 168 */     for (STAT st : statsHome.all()) {
/* 169 */       if (st.key() != null) {
/* 170 */         rens.add(new StatRow(st, c, race));
/*     */       }
/*     */     } 
/*     */     
/* 174 */     GuiSection guiSection1 = null;
/* 175 */     for (int ri = 0; ri < rr.size(); ri++) {
/* 176 */       if (ri % 3 == 0) {
/* 177 */         guiSection1 = new GuiSection();
/* 178 */         rens.add(guiSection1);
/*     */       } 
/* 180 */       guiSection1.add((RENDEROBJ)new StatHomeFurniture(ri, c, race, rr), ri % 3 * 170, 0);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     this.section.add((RENDEROBJ)(new GScrollRows((Iterable)rens, HEIGHT, 0)).view());
/*     */   }
/*     */   
/*     */   private static class StatHomeFurniture
/*     */     extends GuiSection
/*     */   {
/*     */     private final int ri;
/*     */     private final HCLASS cl;
/*     */     private final LIST<RES_AMOUNT> rr;
/*     */     private final GETTER<Race> race;
/*     */     
/*     */     public StatHomeFurniture(int resource, final HCLASS cl, final GETTER<Race> race, LIST<RES_AMOUNT> rr) {
/* 205 */       this.ri = resource;
/* 206 */       this.race = race;
/* 207 */       this.cl = cl;
/* 208 */       this.rr = rr;
/* 209 */       INT.INTE tar = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 213 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 218 */             if (CatAccess.StatHomeFurniture.this.res() == null)
/* 219 */               return 1; 
/* 220 */             return CatAccess.StatHomeFurniture.this.res().amount();
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 225 */             return STATS.HOME().target(cl, (Race)race.get(), CatAccess.StatHomeFurniture.this.res().resource());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 230 */             STATS.HOME().targetSet(t, cl, (Race)race.get(), CatAccess.StatHomeFurniture.this.res().resource());
/*     */           }
/*     */         };
/*     */       
/* 234 */       GAllocator al = new GAllocator(COLOR.ORANGE100, tar, 6, 16, 16);
/*     */       
/* 236 */       add((SPRITE)new SPRITE.Imp(24)
/*     */           {
/*     */             public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */             {
/* 240 */               CatAccess.StatHomeFurniture.this.res().resource().icon().render(r, X1, Y1);
/*     */             }
/* 243 */           }0, 0);
/*     */       
/* 245 */       DOUBLE d = new DOUBLE()
/*     */         {
/*     */           public double getD()
/*     */           {
/* 249 */             double tot = STATS.HOME().needed(cl, (Race)race.get(), CatAccess.StatHomeFurniture.this.ri);
/* 250 */             if (tot == 0.0D)
/* 251 */               return 0.0D; 
/* 252 */             double am = STATS.HOME().current(cl, (Race)race.get(), CatAccess.StatHomeFurniture.this.ri);
/* 253 */             return am / tot;
/*     */           }
/*     */         };
/*     */       
/* 257 */       add((SPRITE)new GMeter.GMeterSprite(GMeter.C_REDGREEN, d, 130, 16), body().x2() + 4, 0);
/*     */       
/* 259 */       add((RENDEROBJ)al, getLastX1(), getLastY2() + 2);
/*     */       
/* 261 */       pad(8, 8);
/*     */     }
/*     */ 
/*     */     
/*     */     private RES_AMOUNT res() {
/* 266 */       return res((Race)this.race.get());
/*     */     }
/*     */     
/*     */     private RES_AMOUNT res(Race race) {
/* 270 */       if (race == null) {
/* 271 */         if (this.ri >= this.rr.size())
/* 272 */           return null; 
/* 273 */         return (RES_AMOUNT)this.rr.get(this.ri);
/*     */       } 
/*     */       
/* 276 */       if (race.home().clas(this.cl).resources().size() <= this.ri) {
/* 277 */         return null;
/*     */       }
/* 279 */       return (RES_AMOUNT)race.home().clas(this.cl).resources().get(this.ri);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 284 */       activeSet((res() != null));
/* 285 */       if (activeIs()) {
/* 286 */         super.render(r, ds);
/*     */       }
/*     */     }
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 291 */       RES_AMOUNT res = res();
/* 292 */       if (res == null)
/*     */         return; 
/* 294 */       GBox b = (GBox)text;
/* 295 */       b.title((res().resource()).name);
/*     */       
/* 297 */       b.text(CatAccess.¤¤FurnitureD);
/* 298 */       b.NL(8);
/*     */ 
/*     */       
/* 301 */       int tot = STATS.HOME().needed(this.cl, (Race)this.race.get(), this.ri);
/* 302 */       int am = STATS.HOME().current(this.cl, (Race)this.race.get(), this.ri);
/* 303 */       b.add((SPRITE)GFORMAT.iofkInv(b.text(), am, tot));
/* 304 */       b.NL(8);
/*     */       
/* 306 */       b.textL(Dic.¤¤ConsumptionRate);
/* 307 */       b.NL();
/* 308 */       GText t = b.text();
/* 309 */       t.add(CatAccess.¤¤Yearly);
/* 310 */       t.insert(0, STATS.HOME().rate(this.cl, (Race)this.race.get()), 2);
/* 311 */       t.insert(1, (int)(STATS.HOME().rate(this.cl, (Race)this.race.get()) * STATS.HOME().current(this.cl, (Race)this.race.get(), this.ri)));
/* 312 */       t.insert(2, (int)(STATS.HOME().rate(this.cl, (Race)this.race.get()) * (STATS.POP()).POP.data(this.cl).get(this.race.get())) * STATS.HOME().target(this.cl, (Race)this.race.get(), res.resource()));
/* 313 */       b.add((SPRITE)t);
/*     */       
/* 315 */       if (this.race.get() == null) {
/* 316 */         b.NL(8);
/* 317 */         b.textL(Dic.¤¤Used);
/* 318 */         for (Race r : RACES.all()) {
/*     */ 
/*     */ 
/*     */           
/* 322 */           if (r.home().clas(this.cl).amount(res.resource()) > 0)
/* 323 */             b.add((SPRITE)(r.appearance()).icon); 
/*     */         } 
/* 325 */         b.NL();
/*     */       } 
/*     */       
/* 328 */       super.hoverInfoGet(text);
/*     */     }
/*     */   }
/*     */   
/*     */   static class StatRowEquip
/*     */     extends GuiSection
/*     */   {
/*     */     private final EquipCivic ss;
/*     */     private final HCLASS cl;
/*     */     private final GETTER<Race> race;
/*     */     
/*     */     public StatRowEquip(final EquipCivic ss, final HCLASS cl, final GETTER<Race> race) {
/* 340 */       this.ss = ss;
/* 341 */       this.cl = cl;
/* 342 */       this.race = race;
/* 343 */       add((RENDEROBJ)new StatRow.Arrow(ss.stat(), cl, race));
/* 344 */       addRightC(4, (SPRITE)ss.resource.icon());
/*     */       
/* 346 */       final EquipCivic s = ss;
/* 347 */       INT.INTE in = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 351 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 356 */             return s.max();
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 361 */             return s.target(cl, (Race)race.get());
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 366 */             s.targetSet(t, cl, (Race)race.get());
/*     */           }
/*     */         };
/*     */       
/* 370 */       addRightC(16, (RENDEROBJ)(new GTarget(40, false, true, in)).hoverInfoSet(ss.sTarget));
/*     */       
/* 372 */       add((SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 376 */               StatRow.format(text, ss.stat(), ss.stat().data(cl).getD(race.get()), cl, (Race)race.get());
/*     */             }
/* 378 */           }230, 0);
/*     */ 
/*     */ 
/*     */       
/* 382 */       add((RENDEROBJ)new StatRow.Meter(ss.stat(), cl, race), 320, 0);
/* 383 */       pad(2, 4);
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 388 */       if (!isHoveringAHoverElement()) {
/*     */         
/* 390 */         this.ss.hover(text, this.cl, (Race)this.race.get());
/* 391 */         text.NL();
/* 392 */         this.ss.stat().hover(text, this.cl, (Race)this.race.get());
/*     */       } else {
/* 394 */         super.hoverInfoGet(text);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 400 */       super.render(r, ds);
/* 401 */       GCOLOR.UI().border().render(r, body().x1(), body().x2(), body().y2() - 1, body().y2());
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\standing\CatAccess.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */