/*     */ package settlement.room.industry.module.consumption;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.ROOM_IDATA_INSTANCE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GChart;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.sett.ui.room.ModuleIndustry;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public class ConsumptionGui<A extends RoomInstance, B extends RoomBlueprintIns<A>> extends UIRoomModule.UIRoomModuleImp<A, B> {
/*  40 */   private static CharSequence ¤¤use = "If usage is enabled, the employees produce x{0} as much.";
/*  41 */   private static CharSequence ¤¤ConsumedDay = "¤Consumed today";
/*  42 */   private static CharSequence ¤¤ConsumedNow = "¤Consumed This Year";
/*  43 */   private static CharSequence ¤¤ConsumedYEsterday = "¤Consumed Yesterday";
/*  44 */   private static CharSequence ¤¤ConsumedPrevious = "¤Consumed last year";
/*  45 */   private static CharSequence ¤¤ConsumptionD = "¤Estimation of how many resources are consumed each day.";
/*  46 */   private static CharSequence ¤¤Consumption = "¤Consumption";
/*     */   
/*  48 */   private static CharSequence ¤¤Stored = "¤Stored";
/*  49 */   private static CharSequence ¤¤Incoming = "¤Fetchers";
/*     */   
/*     */   static {
/*  52 */     D.ts(ConsumptionGui.class);
/*     */   }
/*     */   
/*     */   private final RoomConsumption cons;
/*  56 */   private final GChart chart = new GChart();
/*     */   
/*     */   public ConsumptionGui(B s, RoomConsumption cons) {
/*  59 */     super((RoomBlueprintIns)s);
/*  60 */     this.cons = cons;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<A> getter, int x1, int y1) {
/*  66 */     GuiSection t = new GuiSection();
/*     */     
/*  68 */     for (IndustryResource rr : this.cons.ins()) {
/*     */ 
/*     */       
/*  71 */       SPRITE.Imp imp = new SPRITE.Imp(48, 64) {
/*  72 */           GText t = new GText((UI.FONT()).S, 8);
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2) {
/*  75 */             this.t.clear();
/*     */             
/*  77 */             RoomInstance ins = (RoomInstance)getter.get();
/*  78 */             ROOM_IDATA_INSTANCE insi = (ROOM_IDATA_INSTANCE)getter.get();
/*     */             
/*  80 */             double am = ins.employees().employed() * IndustryUtil.calcConsumptionRate(rr.rate, ins, ConsumptionGui.this.cons);
/*  81 */             if (ConsumptionGui.this.cons.stored(rr).get(insi) <= 0) {
/*  82 */               am *= 1.0D + ConsumptionGui.this.cons.boost(rr);
/*     */             }
/*     */             
/*  85 */             GFORMAT.i(this.t, -((int)am));
/*  86 */             rr.resource.icon().renderC(r, X1, X2, Y1, Y1 + 32);
/*  87 */             this.t.adjustWidth();
/*  88 */             this.t.renderC(r, X1, X2, Y2 - 32, Y2);
/*     */             
/*  90 */             ROOM_IDATA_INSTANCE iins = (ROOM_IDATA_INSTANCE)getter.get();
/*  91 */             if (!iins.getWork().resourceReachable(rr.resource)) {
/*  92 */               (GCOLOR.T()).IBAD.bind();
/*  93 */               (UI.icons()).s.alert.render(r, X1 + 4, Y1 + 4);
/*  94 */               COLOR.unbind();
/*     */             } 
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 102 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)imp)
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 107 */             ConsumptionGui.this.cons.enabledToggle(rr, (ROOM_IDATA_INSTANCE)getter.get(), (RoomInstance)getter.get());
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 112 */             selectedSet(ConsumptionGui.this.cons.enabled(rr, (ROOM_IDATA_INSTANCE)getter.get()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 117 */             GBox b = (GBox)text;
/* 118 */             GText t = b.text();
/* 119 */             t.add(ConsumptionGui.¤¤use);
/* 120 */             t.insert(0, 1.0D + ConsumptionGui.this.cons.boost(rr), 2);
/* 121 */             b.add((SPRITE)t);
/* 122 */             b.NL();
/*     */             
/* 124 */             b.textLL(ConsumptionGui.¤¤Stored);
/* 125 */             b.tab(6);
/* 126 */             b.add((SPRITE)GFORMAT.i(b.text(), ConsumptionGui.this.cons.stored(rr).get(getter.get())));
/* 127 */             b.NL();
/* 128 */             b.textLL(ConsumptionGui.¤¤Incoming);
/* 129 */             b.tab(6);
/* 130 */             b.add((SPRITE)GFORMAT.i(b.text(), ConsumptionGui.this.cons.reseved(rr).get(getter.get())));
/* 131 */             b.NL();
/*     */ 
/*     */ 
/*     */             
/* 135 */             b.sep();
/*     */ 
/*     */ 
/*     */             
/* 139 */             ConsumptionGui.hoverConsumptionIns(text, rr, (RoomInstance)getter.get(), ConsumptionGui.this.cons);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 148 */       t.addRightC(0, (RENDEROBJ)buttPanel);
/*     */     } 
/*     */ 
/*     */     
/* 152 */     t.addRelBody(30, DIR.E, ModuleIndustry.makeFetch(getter));
/*     */     
/* 154 */     section.addRelBody(8, DIR.S, (RENDEROBJ)t);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid r, GGrid text, GuiSection sExtra) {
/* 163 */     for (IndustryResource rr : this.cons.ins()) {
/*     */       
/* 165 */       GStat s = new GStat()
/*     */         {
/*     */           public void update(GText text) {
/* 168 */             int am = rr.history().getPeriodSum(-((int)TIME.years().bitConversion((TIMECYCLE)TIME.days())), 0);
/* 169 */             GFORMAT.iIncr(text, -am);
/*     */           }
/*     */         };
/*     */       
/* 173 */       r.add((RENDEROBJ)new GHeader.HeaderHorizontal((SPRITE)rr.resource.icon(), (SPRITE)s)
/*     */           {
/*     */             public void hoverInfoGet(GUI_BOX text)
/*     */             {
/* 177 */               ConsumptionGui.hoverConsumption(text, rr, ConsumptionGui.this.cons, ConsumptionGui.this.chart);
/*     */             }
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hoverConsumptionIns(GUI_BOX text, IndustryResource i, RoomInstance ins, RoomConsumptionAbs cons) {
/* 190 */     GBox b = (GBox)text;
/* 191 */     b.title(i.resource.name);
/*     */     
/* 193 */     ROOM_IDATA_INSTANCE iins = (ROOM_IDATA_INSTANCE)ins;
/* 194 */     if (!iins.getWork().resourceReachable(i.resource)) {
/* 195 */       b.error(Dic.¤¤Unreachable);
/* 196 */       b.NL();
/*     */     } 
/*     */     
/* 199 */     ROOM_IDATA_INSTANCE p = (ROOM_IDATA_INSTANCE)ins;
/*     */ 
/*     */     
/* 202 */     b.NL(8);
/* 203 */     b.textLL(¤¤ConsumedDay);
/* 204 */     b.tab(7);
/* 205 */     b.add((SPRITE)GFORMAT.i(b.text(), (int)i.day.getD(p)));
/* 206 */     b.NL();
/*     */     
/* 208 */     b.textLL(¤¤ConsumedYEsterday);
/* 209 */     b.tab(7);
/* 210 */     b.add((SPRITE)GFORMAT.i(b.text(), i.dayPrev.get(p)));
/*     */     
/* 212 */     b.NL(0);
/* 213 */     b.textLL(¤¤ConsumedNow);
/* 214 */     b.tab(7);
/* 215 */     b.add((SPRITE)GFORMAT.i(b.text(), i.year.get(p)));
/* 216 */     b.NL();
/*     */     
/* 218 */     b.textLL(¤¤ConsumedPrevious);
/* 219 */     b.tab(7);
/* 220 */     b.add((SPRITE)GFORMAT.i(b.text(), i.yearPrev.get(p)));
/*     */     
/* 222 */     b.NL(8);
/*     */     
/* 224 */     b.textLL(¤¤ConsumptionD);
/* 225 */     b.NL();
/*     */     
/* 227 */     IndustryUtil.hoverConsumptionRate(text, i.rate, ins, cons);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void hoverConsumption(GUI_BOX text, IndustryResource rr, RoomConsumptionAbs cons, GChart chart) {
/* 232 */     GBox b = (GBox)text;
/*     */     
/* 234 */     RESOURCE res = rr.resource;
/*     */     
/* 236 */     b.title(res.name);
/* 237 */     b.add((SPRITE)text.text().add(¤¤Consumption).s().add('(').add(Dic.¤¤Total).add(')'));
/* 238 */     b.NL(4);
/*     */     
/* 240 */     b.textLL(¤¤ConsumedDay);
/* 241 */     b.tab(7);
/* 242 */     b.add((SPRITE)GFORMAT.i(b.text(), rr.history().get(0)));
/* 243 */     b.NL();
/*     */     
/* 245 */     b.textLL(¤¤ConsumedYEsterday);
/* 246 */     b.tab(7);
/* 247 */     b.add((SPRITE)GFORMAT.i(b.text(), rr.history().get(1)));
/* 248 */     b.NL();
/*     */     
/* 250 */     int yearStart = (int)(-TIME.days().bitOfYear() * TIME.years().bitConversion((TIMECYCLE)TIME.years()));
/*     */     
/* 252 */     b.textLL(¤¤ConsumedNow);
/* 253 */     b.tab(7);
/* 254 */     b.add((SPRITE)GFORMAT.i(b.text(), rr.history().getPeriodSum(-yearStart, 0)));
/* 255 */     b.NL();
/*     */ 
/*     */ 
/*     */     
/* 259 */     b.textLL(¤¤ConsumedPrevious);
/* 260 */     b.tab(7);
/* 261 */     b.add((SPRITE)GFORMAT.i(b.text(), rr.history().getPeriodSum(-((int)TIME.years().bitConversion((TIMECYCLE)TIME.days())) - yearStart, -yearStart)));
/* 262 */     b.NL();
/*     */     
/* 264 */     b.NL(8);
/* 265 */     b.textLL(DicTime.¤¤Days);
/* 266 */     chart.clear();
/* 267 */     chart.add((HISTORY)rr.history());
/* 268 */     text.NL();
/* 269 */     text.add(chart.sprite);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, A ins) {
/* 280 */     super.hover(box, (RoomInstance)ins);
/* 281 */     int t = 0;
/* 282 */     for (IndustryResource i : this.cons.ins()) {
/*     */       
/* 284 */       box.tab(t * 3);
/* 285 */       box.add((i.resource.icon()).small);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 290 */       t++;
/* 291 */       if (t == 3) {
/* 292 */         t = 0;
/* 293 */         box.NL();
/*     */       } 
/*     */     } 
/*     */     
/* 297 */     box.NL(8);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\industry\module\consumption\ConsumptionGui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */