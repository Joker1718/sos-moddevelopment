/*     */ package settlement.room.food.orchard;
/*     */ import game.GAME;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
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
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<Instance, ROOM_ORCHARD> {
/*  35 */   static CharSequence ¤¤Trees = "¤Trees";
/*  36 */   static CharSequence ¤¤TreesD = "¤Amount of fully grown trees. Only when trees are fully grown will they start producing. Neglected trees will die.";
/*  37 */   private static CharSequence ¤¤TreeNext = "¤Next tree will be grown in:";
/*     */ 
/*     */   
/*  40 */   private static CharSequence ¤¤estimated = "¤Estimated Harvest (year)";
/*  41 */   private static CharSequence ¤¤daysToHarvest = "¤Days until harvest";
/*  42 */   private static CharSequence ¤¤baseValue = "¤Capacity";
/*     */   
/*  44 */   private static CharSequence ¤¤HarvestYear = "¤This Year";
/*  45 */   private static CharSequence ¤¤HarvestPrev = "¤Last Year";
/*     */   
/*  47 */   private static CharSequence ¤¤skill = "¤Worker Skill";
/*  48 */   private static CharSequence ¤¤skillD = "¤The average bonus accumulated during the year. This determines the output of the harvest and the growth rate of the trees.";
/*  49 */   private static CharSequence ¤¤skillCurrent = "¤Bonus (current)";
/*  50 */   private static CharSequence ¤¤skillCurrentD = "¤The bonus that is currently being added to the Orchard.";
/*     */   
/*  52 */   private static CharSequence ¤¤chop = "¤Chop";
/*  53 */   private static CharSequence ¤¤chopD = "¤Reset all progress by chopping down the trees and instantly get {0} {1}."; final Cache cache;
/*     */   
/*     */   Gui(ROOM_ORCHARD s) {
/*  56 */     super(s);
/*     */ 
/*     */ 
/*     */     
/*  60 */     this.cache = new Cache();
/*     */     D.t(this);
/*     */   }
/*     */   public void hover(GBox box, Instance i) {
/*  64 */     super.hover(box, i);
/*  65 */     box.NL();
/*  66 */     if (!(i.blueprintI()).constructor.isIndoors) {
/*  67 */       box.text(((ROOM_ORCHARD)this.blueprint).constructor.fertility.name());
/*  68 */       box.add((SPRITE)GFORMAT.perc(box.text(), ((ROOM_ORCHARD)this.blueprint).constructor.fertility.get(i)));
/*     */       
/*  70 */       box.NL();
/*     */     } 
/*  72 */     box.text(¤¤estimated);
/*  73 */     box.add((SPRITE)GFORMAT.i(box.text(), (int)this.cache.output(i)));
/*     */     
/*  75 */     box.space();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid icons, GGrid text, GuiSection sExtra) {
/*  83 */     final IndustryResource res = (IndustryResource)((Industry)((ROOM_ORCHARD)this.blueprint).industries().get(0)).outs().get(0);
/*     */     
/*  85 */     text.add((RENDEROBJ)new GHeader(Dic.¤¤Production));
/*     */     
/*  87 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/*  91 */           text.title(Gui.¤¤estimated);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/*  97 */     s.add((SPRITE)res.resource.icon(), 0, 0);
/*     */     
/*  99 */     s.addRightC(4, (SPRITE)new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 103 */             int am = 0;
/* 104 */             for (int i = 0; i < ((ROOM_ORCHARD)Gui.this.blueprint).instancesSize(); i++) {
/* 105 */               Instance ins = (Instance)((ROOM_ORCHARD)Gui.this.blueprint).getInstance(i);
/* 106 */               am = (int)(am + Gui.this.cache.output(ins));
/*     */             } 
/* 108 */             GFORMAT.i(text, am);
/*     */           }
/*     */         });
/*     */     
/* 112 */     text.add((RENDEROBJ)s);
/*     */     
/* 114 */     GStaples st = new GStaples(res.history().historyRecords())
/*     */       {
/*     */         protected void hover(GBox box, int stapleI)
/*     */         {
/* 118 */           int i = res.history().historyRecords() - 1 - stapleI;
/* 119 */           int am = res.history().get(i);
/* 120 */           GText t = box.text();
/* 121 */           DicTime.setDaysAgo((Str)t, i);
/* 122 */           box.add((SPRITE)t);
/* 123 */           box.NL(2);
/* 124 */           box.add((SPRITE)GFORMAT.i(box.text(), am));
/*     */         }
/*     */ 
/*     */         
/*     */         protected double getValue(int stapleI) {
/* 129 */           return res.history().get(res.history().historyRecords() - 1 - stapleI);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 134 */     st.body().setWidth(180.0D).setHeight(64.0D);
/* 135 */     text.add((RENDEROBJ)st);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<Instance> getter, int x1, int y1) {
/* 142 */     GuiSection s = new GuiSection();
/*     */     
/* 144 */     s.add(prod(getter));
/*     */     
/* 146 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text) {
/* 149 */           int i = Gui.this.cache.daysTillNextTree((Instance)getter.get());
/* 150 */           if (i < Integer.MAX_VALUE) {
/* 151 */             int r = ((ROOM_ORCHARD)Gui.this.blueprint).time.ripeDay - (TIME.days().bitsSinceStart() + i) % (((ROOM_ORCHARD)Gui.this.blueprint).time.ripeDay + 1);
/* 152 */             DicTime.setDays((Str)text, (i + r));
/*     */           } else {
/*     */             
/* 155 */             DicTime.setDays((Str)text, ((ROOM_ORCHARD)Gui.this.blueprint).time.daysTillHarvest());
/*     */           }  }
/* 157 */       }).hh((SPRITE)(SPRITES.icons()).s.clock).hoverInfoSet(¤¤daysToHarvest);
/* 158 */     s.addRightC(32, (RENDEROBJ)hOVERABLE);
/* 159 */     s.body().incrW(64.0D);
/*     */     
/* 161 */     s.addRelBody(4, DIR.N, (RENDEROBJ)new GHeader(Dic.¤¤Production));
/* 162 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */     
/* 165 */     s = new GuiSection();
/*     */     
/* 167 */     int tab = 180;
/*     */ 
/*     */     
/* 170 */     s.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 174 */             Instance ins = (Instance)getter.get();
/* 175 */             GFORMAT.iofkInv(text, Gui.this.cache.trees(ins), Gui.this.cache.treesTotal(ins));
/*     */             
/* 177 */             if (Gui.this.cache.daysTillNextTree(ins) < Integer.MAX_VALUE) {
/* 178 */               text.s().add('(').s();
/* 179 */               DicTime.setDays((Str)text, Gui.this.cache.daysTillNextTree(ins));
/* 180 */               text.s().add(')');
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 187 */             b.title(Gui.¤¤Trees);
/* 188 */             b.text(Gui.¤¤TreesD);
/* 189 */             b.NL(8);
/*     */             
/* 191 */             if (Gui.this.cache.daysTillNextTree((Instance)getter.get()) < Integer.MAX_VALUE) {
/* 192 */               b.textL(Gui.¤¤TreeNext);
/* 193 */               GText t = b.text();
/* 194 */               DicTime.setDays((Str)t, Gui.this.cache.daysTillNextTree((Instance)getter.get()));
/* 195 */               b.add((SPRITE)t);
/*     */             }
/*     */           
/*     */           }
/* 199 */         }).hh(¤¤Trees, tab).increaseWidth(100));
/*     */     
/* 201 */     s.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 205 */             GFORMAT.f1(text, ((Instance)getter.get()).skill());
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 210 */             b.title(Gui.¤¤skill);
/* 211 */             b.text(Gui.¤¤skillD);
/* 212 */             b.NL(8);
/* 213 */             b.textLL(Dic.¤¤Value);
/* 214 */             b.tab(6);
/* 215 */             b.add((SPRITE)GFORMAT.f1(b.text(), ((Instance)getter.get()).skill()));
/*     */             
/* 217 */             b.sep();
/* 218 */             b.textLL(Gui.¤¤skillCurrent);
/* 219 */             b.NL();
/* 220 */             b.text(Gui.¤¤skillCurrentD);
/* 221 */             b.NL();
/* 222 */             IndustryUtil.hoverBoosts((GUI_BOX)b, 1.0D, (IndustryRate)((Instance)getter.get()).industry(), ((Instance)getter.get()).industry().bonus(), (RoomInstance)getter.get(), 1.0D);
/*     */           }
/* 227 */         }).hh(¤¤skill, tab).increaseWidth(100));
/*     */     
/* 229 */     section.add((RENDEROBJ)s, section.body().x1(), section.body().y2() + 16);
/*     */ 
/*     */     
/* 232 */     GButt.ButtPanel buttPanel = (new GButt.ButtPanel(¤¤chop)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 236 */           activeSet((Gui.this.cache.wood > 0));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 242 */           Instance ins = (Instance)getter.get();
/*     */           
/* 244 */           for (COORDINATE c : ins.body()) {
/* 245 */             if (!ins.is(c))
/*     */               continue; 
/* 247 */             OTile t = ((ROOM_ORCHARD)Gui.this.blueprint).tile.getM(c.x(), c.y());
/* 248 */             if (t != null) {
/* 249 */               t.chop();
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 256 */           GBox b = (GBox)text;
/* 257 */           GText t = b.text();
/* 258 */           t.add(Gui.¤¤chopD);
/* 259 */           t.insert(0, Gui.this.cache.wood);
/* 260 */           t.insert(1, (((ROOM_ORCHARD)Gui.this.blueprint).auxRes.resource()).names);
/* 261 */           b.add((SPRITE)t);
/*     */         }
/* 264 */       }).pad(8, 4);
/*     */     
/* 266 */     section.addRelBody(16, DIR.S, (RENDEROBJ)buttPanel);
/*     */   }
/*     */ 
/*     */   
/*     */   private RENDEROBJ prod(final GETTER<Instance> getter) {
/* 271 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 275 */           GBox b = (GBox)text;
/* 276 */           Instance ins = (Instance)getter.get();
/*     */           
/* 278 */           b.textL(Gui.¤¤baseValue);
/* 279 */           b.tab(6);
/* 280 */           b.add((SPRITE)GFORMAT.f(b.text(), ins.base));
/* 281 */           b.NL();
/*     */           
/* 283 */           b.textL(Dic.¤¤ProductionRate);
/* 284 */           b.tab(6);
/* 285 */           b.add((SPRITE)GFORMAT.f(b.text(), ((IndustryResource)((ROOM_ORCHARD)Gui.this.blueprint).productionData.outs().get(0)).rate));
/* 286 */           b.NL();
/*     */           
/* 288 */           b.textL(Gui.¤¤skill);
/* 289 */           b.tab(6);
/* 290 */           b.add((SPRITE)GFORMAT.f(b.text(), ins.skill()));
/* 291 */           b.NL();
/*     */           
/* 293 */           b.textLL(Dic.¤¤Total);
/* 294 */           b.tab(6);
/* 295 */           b.add((SPRITE)GFORMAT.f1(b.text(), ins.base * ((IndustryResource)((ROOM_ORCHARD)Gui.this.blueprint).productionData.outs().get(0)).rate * ins.skill()));
/* 296 */           b.NL();
/*     */           
/* 298 */           b.textL(Gui.¤¤Trees);
/* 299 */           b.tab(6);
/* 300 */           b.add((SPRITE)GFORMAT.f(b.text(), ins.trees / ins.treesTotal));
/* 301 */           b.NL();
/*     */           
/* 303 */           b.textLL(Gui.¤¤estimated);
/* 304 */           b.tab(6);
/* 305 */           b.add((SPRITE)GFORMAT.f1(b.text(), Gui.this.cache.output(ins)));
/* 306 */           b.NL();
/*     */           
/* 308 */           b.NL(4);
/*     */ 
/*     */ 
/*     */           
/* 312 */           b.NL(16);
/* 313 */           b.textL(Gui.¤¤HarvestYear);
/* 314 */           b.tab(6);
/* 315 */           b.add((SPRITE)GFORMAT.i(b.text(), ((IndustryResource)((Industry)(ins.blueprintI()).indus.get(0)).outs().get(0)).year.get(ins)));
/* 316 */           b.NL();
/*     */           
/* 318 */           b.NL(2);
/* 319 */           b.textL(Gui.¤¤HarvestPrev);
/* 320 */           b.tab(6);
/* 321 */           b.add((SPRITE)GFORMAT.i(b.text(), ((IndustryResource)((Industry)(ins.blueprintI()).indus.get(0)).outs().get(0)).yearPrev.get(ins)));
/* 322 */           b.NL();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 328 */     s.add((SPRITE)((IndustryResource)((ROOM_ORCHARD)this.blueprint).productionData.outs().get(0)).resource.icon(), 0, 0);
/* 329 */     GStat stat = new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 333 */           double am = Gui.this.cache.output((Instance)getter.get()) / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 334 */           GFORMAT.f0(text, am);
/*     */         }
/*     */       };
/*     */     
/* 338 */     s.addRightC(6, (SPRITE)stat);
/*     */     
/* 340 */     s.body().incrW(64.0D);
/* 341 */     return (RENDEROBJ)s;
/*     */   }
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */   
/*     */   private class Cache { private int upI;
/*     */     private int treesTotal;
/*     */     private int trees;
/*     */     
/*     */     private Cache() {
/* 351 */       this.upI = -1;
/*     */     }
/*     */ 
/*     */     
/*     */     private int daysTillNextTree;
/*     */     
/*     */     private int wood;
/*     */     private double output;
/*     */     private Instance ins;
/*     */     
/*     */     public int treesTotal(Instance ins) {
/* 362 */       up(ins);
/* 363 */       return this.treesTotal;
/*     */     }
/*     */     
/*     */     public int trees(Instance ins) {
/* 367 */       up(ins);
/* 368 */       return this.trees;
/*     */     }
/*     */     
/*     */     public int daysTillNextTree(Instance ins) {
/* 372 */       up(ins);
/* 373 */       return this.daysTillNextTree;
/*     */     }
/*     */     
/*     */     public double output(Instance ins) {
/* 377 */       up(ins);
/* 378 */       return this.output;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void up(Instance ins) {
/* 385 */       if (this.upI == GAME.updateI() && this.ins == ins)
/*     */         return; 
/* 387 */       this.ins = ins;
/* 388 */       this.upI = GAME.updateI();
/*     */       
/* 390 */       this.wood = 0;
/*     */       
/* 392 */       this.treesTotal = 0;
/* 393 */       this.trees = 0;
/* 394 */       this.daysTillNextTree = Integer.MAX_VALUE;
/*     */       
/* 396 */       for (COORDINATE c : ins.body()) {
/* 397 */         if (!ins.is(c)) {
/*     */           continue;
/*     */         }
/* 400 */         OTile t = ((ROOM_ORCHARD)Gui.this.blueprint).tile.getM(c.x(), c.y());
/* 401 */         if (t != null) {
/* 402 */           this.treesTotal++;
/* 403 */           if (t.state() == t.IBIG) {
/* 404 */             this.trees++;
/*     */           } else {
/* 406 */             int d = t.state().daysTillGrown();
/* 407 */             if (d < this.daysTillNextTree)
/*     */             {
/* 409 */               this.daysTillNextTree = d;
/*     */             }
/*     */           } 
/* 412 */           if (t.state() == t.ISMALL) {
/* 413 */             this.wood += ((ROOM_ORCHARD)Gui.this.blueprint).auxRes.amount() / 2; continue;
/* 414 */           }  if (t.state() == t.IBIG || t.state() == t.IDEAD) {
/* 415 */             this.wood += ((ROOM_ORCHARD)Gui.this.blueprint).auxRes.amount();
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 420 */       this.output = ((ROOM_ORCHARD)Gui.this.blueprint).time.days * ins.skill() * ins.base * ((IndustryResource)ins.industry().outs().get(0)).rate * ins.trees / ins.treesTotal;
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\orchard\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */