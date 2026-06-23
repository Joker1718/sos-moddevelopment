/*     */ package settlement.room.food.farm;
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GStaples;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<FarmInstance, ROOM_FARM> {
/*  40 */   private static CharSequence ¤¤estimated = "¤Estimated Harvest (year)";
/*  41 */   private static CharSequence ¤¤daysToHarvest = "¤Days until harvest";
/*  42 */   private static CharSequence ¤¤baseValue = "¤Base Value";
/*  43 */   private static CharSequence ¤¤workValue = "¤Work Value";
/*  44 */   private static CharSequence ¤¤workValueD = "¤Each day of the year a farm needs tending to. Workers failing to tend to all the tiles will lead to low yields.";
/*     */   
/*  46 */   private static CharSequence ¤¤HarvestYear = "¤This Year";
/*  47 */   private static CharSequence ¤¤HarvestPrev = "¤Last Year";
/*     */   
/*  49 */   private static CharSequence ¤¤skill = "¤Bonus";
/*  50 */   private static CharSequence ¤¤skillD = "¤The average bonus accumulated during the year. This determines the output of the harvest.";
/*     */   
/*  52 */   private static CharSequence ¤¤skillCurrent = "¤Bonus (current)";
/*  53 */   private static CharSequence ¤¤skillCurrentD = "¤The bonus that is currently being added to the Farm.";
/*     */   
/*  55 */   private static CharSequence ¤¤cycle = "¤Cycle";
/*  56 */   private static CharSequence ¤¤reseed = "¤reseed";
/*  57 */   private static CharSequence ¤¤reseedD = "¤Reseed the farm with another crop. New farm must still be constructed.";
/*     */   
/*  59 */   private static CharSequence ¤¤Farmer = "¤Farmers have no storage nearby to store their harvest."; private GuiSection rebuilds;
/*     */   
/*     */   static {
/*  62 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_FARM s) {
/*  66 */     super(s);
/*     */ 
/*     */     
/*  69 */     this.rebuilds = new GuiSection();
/*     */   }
/*     */   
/*     */   public void hover(GBox box, FarmInstance i) {
/*  73 */     super.hover(box, i);
/*  74 */     box.NL();
/*  75 */     box.text(((ROOM_FARM)this.blueprint).constructor.fertility.name());
/*  76 */     box.add((SPRITE)GFORMAT.perc(box.text(), ((ROOM_FARM)this.blueprint).constructor.fertility.get(i)));
/*     */     
/*  78 */     box.NL();
/*  79 */     box.text(¤¤estimated);
/*  80 */     box.add((SPRITE)GFORMAT.i(box.text(), (int)Math.ceil(Util.prospect(i))));
/*     */     
/*  82 */     box.space();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void problem(FarmInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/*  87 */     if (i.tData.shouldStore() && i.storeTimeout) {
/*  88 */       warnings.add(¤¤Farmer);
/*     */     }
/*  90 */     super.problem(i, free, errors, warnings);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid icons, GGrid text, GuiSection sExtra) {
/*  96 */     final IndustryResource res = (IndustryResource)((Industry)((ROOM_FARM)this.blueprint).industries().get(0)).outs().get(0);
/*     */     
/*  98 */     text.add((RENDEROBJ)new GHeader(Dic.¤¤Production));
/*     */     
/* 100 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 104 */           text.title(Gui.¤¤estimated);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 110 */     s.add((SPRITE)res.resource.icon(), 0, 0);
/*     */     
/* 112 */     s.addRightC(4, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 116 */             int am = 0;
/* 117 */             for (int i = 0; i < ((ROOM_FARM)Gui.this.blueprint).instancesSize(); i++) {
/* 118 */               FarmInstance ins = (FarmInstance)((ROOM_FARM)Gui.this.blueprint).getInstance(i);
/* 119 */               am = (int)(am + Util.prospect(ins));
/*     */             } 
/* 121 */             GFORMAT.i(text, am);
/*     */           }
/*     */         });
/*     */     
/* 125 */     s.addRightC(64, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 129 */             int prev = 0;
/* 130 */             int am = 0;
/* 131 */             for (int i = 0; i < ((ROOM_FARM)Gui.this.blueprint).instancesSize(); i++) {
/* 132 */               FarmInstance ins = (FarmInstance)((ROOM_FARM)Gui.this.blueprint).getInstance(i);
/* 133 */               prev += Util.prevHarvest(ins);
/* 134 */               am = (int)(am + Util.prospect(ins));
/*     */             } 
/* 136 */             GFORMAT.iIncr(text, (am - prev));
/*     */           }
/*     */         });
/*     */     
/* 140 */     text.add((RENDEROBJ)s);
/*     */     
/* 142 */     GStaples st = new GStaples(res.history().historyRecords())
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 146 */           int i = res.history().historyRecords() - 1 - stapleI;
/* 147 */           int am = res.history().get(i);
/* 148 */           GText t = box.text();
/* 149 */           DicTime.setDaysAgo((Str)t, i);
/* 150 */           box.add((SPRITE)t);
/* 151 */           box.NL(2);
/* 152 */           box.add((SPRITE)GFORMAT.i(box.text(), am));
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 157 */           return res.history().get(res.history().historyRecords() - 1 - stapleI);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 162 */     st.body().setWidth(180.0D).setHeight(64.0D);
/* 163 */     text.add((RENDEROBJ)st);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<FarmInstance> getter, int x1, int y1) {
/* 170 */     GuiSection s = new GuiSection();
/*     */     
/* 172 */     s.add(prod(getter));
/*     */     
/* 174 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text) {
/* 177 */           DicTime.setDays((Str)text, ((ROOM_FARM)Gui.this.blueprint).time.daysToHarvest());
/*     */         }
/* 179 */       }).hh((SPRITE)(SPRITES.icons()).s.clock).hoverInfoSet(¤¤daysToHarvest);
/* 180 */     s.addRightC(32, (RENDEROBJ)hOVERABLE);
/* 181 */     s.body().incrW(64.0D);
/*     */     
/* 183 */     s.addRelBody(4, DIR.N, (RENDEROBJ)new GHeader(Dic.¤¤Production));
/*     */     
/* 185 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */     
/* 187 */     s = new GuiSection();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 198 */     s.addRightC(32, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 202 */             GFORMAT.perc(text, ((FarmInstance)getter.get()).tData.work());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 207 */             b.title(Gui.¤¤workValue);
/* 208 */             b.text(Gui.¤¤workValueD);
/* 209 */             b.NL();
/* 210 */             b.textLL(DicTime.¤¤Today);
/* 211 */             b.tab(4);
/* 212 */             b.add((SPRITE)GFORMAT.perc(b.text(), CLAMP.d(((FarmInstance)getter.get()).tData.workday(), 0.0D, 1.0D)));
/*     */           }
/* 215 */         }).hv(¤¤workValue));
/*     */     
/* 217 */     s.addRightC(32, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 221 */             GFORMAT.f1(text, ((FarmInstance)getter.get()).tData.skill());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 226 */             b.title(Gui.¤¤skill);
/* 227 */             b.text(Gui.¤¤skillD);
/* 228 */             b.NL(8);
/* 229 */             b.textLL(Dic.¤¤Value);
/* 230 */             b.tab(6);
/* 231 */             b.add((SPRITE)GFORMAT.f1(b.text(), ((FarmInstance)getter.get()).tData.skill()));
/*     */             
/* 233 */             b.sep();
/* 234 */             b.textLL(Gui.¤¤skillCurrent);
/* 235 */             b.NL();
/* 236 */             b.text(Gui.¤¤skillCurrentD);
/* 237 */             b.NL();
/* 238 */             IndustryUtil.hoverBoosts((GUI_BOX)b, 1.0D, (IndustryRate)((FarmInstance)getter.get()).industry(), ((FarmInstance)getter.get()).industry().bonus(), (RoomInstance)getter.get(), 1.0D);
/*     */           }
/* 242 */         }).hv(¤¤skill));
/*     */     
/* 244 */     section.addRelBody(16, DIR.S, (RENDEROBJ)s);
/* 245 */     s = new GuiSection();
/*     */ 
/*     */     
/* 248 */     s.addRightC(32, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 252 */             text.add(((FarmInstance)getter.get()).tData.cName());
/*     */           }
/* 254 */         }).hv(¤¤cycle));
/* 255 */     section.addRelBody(4, DIR.S, (RENDEROBJ)s);
/*     */     
/* 257 */     ACTION rebuild = new ACTION()
/*     */       {
/*     */         public void exe() {
/* 260 */           Gui.this.rebuilds = new GuiSection();
/* 261 */           int i = 0;
/* 262 */           for (ROOM_FARM f : (SETT.ROOMS()).FARMS) {
/* 263 */             if (f.isAvailable(SETT.ENV().climate())) {
/* 264 */               GButt gButt = (new GButt.ButtPanel((SPRITE)f.iconBig())
/*     */                 {
/*     */                   protected void clickA()
/*     */                   {
/* 268 */                     if (f.reqs.passes(FACTIONS.player()) && f != ((FarmInstance)getter.get()).blueprintI()) {
/* 269 */                       (VIEW.inters()).popup.close();
/* 270 */                       ((FarmInstance)getter.get()).changeTo(f);
/*     */                     } 
/*     */                   }
/*     */ 
/*     */ 
/*     */ 
/*     */                   
/*     */                   protected void renAction() {
/* 278 */                     activeSet((f.reqs.passes(FACTIONS.player()) && f != ((FarmInstance)getter.get()).blueprintI() && f.constructor.isIndoors == (((FarmInstance)getter.get()).blueprintI()).constructor.isIndoors));
/*     */                   }
/* 281 */                 }).hoverSet(f.info);
/* 282 */               Gui.this.rebuilds.add((RENDEROBJ)gButt, i % 6 * gButt.body().width(), i / 6 * gButt.body().height());
/* 283 */               i++;
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 290 */     rebuild.exe();
/* 291 */     SETT.addGeneratorHook(rebuild);
/*     */ 
/*     */     
/* 294 */     CLICKABLE c = (new GButt.ButtPanel(¤¤reseed)
/*     */       {
/*     */         protected void clickA() {
/* 297 */           (VIEW.inters()).popup.show((RENDEROBJ)Gui.this.rebuilds, (CLICKABLE)this);
/* 298 */           super.clickA();
/*     */         }
/* 300 */       }).pad(8, 4).hoverInfoSet(¤¤reseedD);
/*     */     
/* 302 */     section.addRelBody(16, DIR.S, (RENDEROBJ)c);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private RENDEROBJ prod(final GETTER<FarmInstance> getter) {
/* 309 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 313 */           GBox b = (GBox)text;
/* 314 */           FarmInstance ins = (FarmInstance)getter.get();
/*     */           
/* 316 */           b.textL(Gui.¤¤baseValue);
/* 317 */           b.tab(6);
/* 318 */           b.add((SPRITE)GFORMAT.f(b.text(), Util.base(ins)));
/* 319 */           b.NL();
/*     */           
/* 321 */           b.textL(Dic.¤¤ProductionRate);
/* 322 */           b.tab(6);
/* 323 */           b.add((SPRITE)GFORMAT.f(b.text(), ((IndustryResource)((ROOM_FARM)Gui.this.blueprint).productionData.outs().get(0)).rate));
/* 324 */           b.NL();
/*     */           
/* 326 */           b.textL(Gui.¤¤workValue);
/* 327 */           b.tab(6);
/* 328 */           b.add((SPRITE)GFORMAT.f1(b.text(), ins.tData.work()));
/* 329 */           b.NL();
/*     */           
/* 331 */           b.textL(Gui.¤¤skill);
/* 332 */           b.tab(6);
/* 333 */           b.add((SPRITE)GFORMAT.f1(b.text(), ins.tData.skill()));
/* 334 */           b.NL();
/*     */ 
/*     */           
/* 337 */           b.NL(4);
/*     */           
/* 339 */           b.textLL(Gui.¤¤estimated);
/* 340 */           b.tab(6);
/* 341 */           b.add((SPRITE)GFORMAT.f1(b.text(), Util.prospect(ins)));
/* 342 */           b.NL();
/*     */           
/* 344 */           b.NL(16);
/* 345 */           b.textL(Gui.¤¤HarvestYear);
/* 346 */           b.tab(6);
/* 347 */           b.add((SPRITE)GFORMAT.i(b.text(), ((IndustryResource)((Industry)(ins.blueprintI()).indus.get(0)).outs().get(0)).year.get(ins)));
/* 348 */           b.NL();
/*     */           
/* 350 */           b.NL(2);
/* 351 */           b.textL(Gui.¤¤HarvestPrev);
/* 352 */           b.tab(6);
/* 353 */           b.add((SPRITE)GFORMAT.i(b.text(), ((IndustryResource)((Industry)(ins.blueprintI()).indus.get(0)).outs().get(0)).yearPrev.get(ins)));
/* 354 */           b.NL();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 360 */     s.add((SPRITE)((ROOM_FARM)this.blueprint).crop.resource.icon(), 0, 0);
/* 361 */     GStat stat = new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 365 */           double am = Util.prospect((FarmInstance)getter.get()) / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 366 */           GFORMAT.f0(text, am);
/*     */         }
/*     */       };
/*     */     
/* 370 */     s.addRightC(6, (SPRITE)stat);
/*     */     
/* 372 */     s.body().incrW(64.0D);
/* 373 */     return (RENDEROBJ)s;
/*     */   }
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\farm\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */