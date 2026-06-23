/*     */ package settlement.room.infra.admin;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.settings.S;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GChart;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.statistics.HISTORY;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Gui<A extends RoomInstance, B extends RoomBlueprintIns<A>>
/*     */   extends UIRoomModule.UIRoomModuleImp<A, B>
/*     */ {
/* 244 */   private final GChart chart = new GChart();
/*     */   private final AdminData data;
/*     */   private final IndustryRate indu;
/*     */   private final CharSequence name;
/*     */   private final CharSequence targetD;
/*     */   
/*     */   public Gui(B s, AdminData data, IndustryRate out, CharSequence name, CharSequence targetD) {
/* 251 */     super((RoomBlueprintIns)s);
/* 252 */     this.data = data;
/* 253 */     this.indu = out;
/* 254 */     this.name = name;
/* 255 */     this.targetD = targetD;
/*     */   }
/*     */   
/*     */   public Gui(B s, AdminData data, IndustryRate out) {
/* 259 */     super((RoomBlueprintIns)s);
/* 260 */     this.data = data;
/* 261 */     this.indu = out;
/* 262 */     this.name = data.target.name;
/* 263 */     this.targetD = String.valueOf(Str.TMP.clear().add(AdminData.¤¤TargetD).insert(0, this.name));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<A> getter, int x1, int y1) {
/* 269 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 273 */             double p = ((RoomInstance)getter.get()).employees().employed() * IndustryUtil.calcProductionRate(AdminData.Gui.this.data.knowledgePerStation, AdminData.Gui.this.indu, AdminData.Gui.this.data.boost, (RoomInstance)getter.get());
/* 274 */             GFORMAT.f0(text, p);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 279 */             b.text(AdminData.Gui.this.targetD);
/* 280 */             b.NL(8);
/* 281 */             IndustryUtil.hoverProductionRate((GUI_BOX)b, AdminData.Gui.this.data.knowledgePerStation, AdminData.Gui.this.indu, AdminData.Gui.this.data.boost, (RoomInstance)getter.get());
/*     */           }
/* 284 */         }).hv(Dic.¤¤Target));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, A i) {
/* 296 */     super.hover(box, (RoomInstance)i);
/* 297 */     box.NL(8);
/* 298 */     box.textLL(this.name);
/* 299 */     box.add((SPRITE)GFORMAT.i(box.text(), (int)this.data.value()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid r, GGrid text, GuiSection sExtra) {
/* 306 */     GuiSection ss = new GuiSection();
/*     */     
/* 308 */     ss.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 312 */             GFORMAT.f0(text, AdminData.Gui.this.data.value(), 2.0D);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 318 */             AdminData.Gui.this.chart.clear();
/* 319 */             AdminData.Gui.this.chart.add((HISTORY)AdminData.Gui.this.data.utilizedHistory);
/* 320 */             b.add((RENDEROBJ)AdminData.Gui.this.chart);
/*     */           }
/* 323 */         }).hh(this.name));
/* 324 */     ss.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 328 */             GFORMAT.perc(text, AdminData.Gui.this.data.degradeValue * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 335 */             GText t = b.text();
/* 336 */             t.add(AdminData.¤¤degradeD);
/* 337 */             t.insert(0, AdminData.Gui.this.name);
/* 338 */             b.add((SPRITE)t);
/*     */           }
/* 341 */         }).hh(Dic.¤¤Degrade));
/*     */     
/* 343 */     ss.addDown(2, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 347 */             GFORMAT.f0(text, AdminData.Gui.this.data.projection(), 2.0D);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 353 */             b.text(AdminData.Gui.this.targetD);
/* 354 */             b.add((SPRITE)GFORMAT.i(b.text(), (int)AdminData.Gui.this.data.projection()));
/*     */           }
/* 357 */         }).hh(Dic.¤¤Target));
/*     */     
/* 359 */     if ((S.get()).developer) {
/* 360 */       ss.addDown(2, (RENDEROBJ)new GButt.ButtPanel("++")
/*     */           {
/*     */             protected void clickA() {
/* 363 */               AdminData.Gui.this.data.cheatAdd(50);
/* 364 */               super.clickA();
/*     */             }
/*     */           });
/* 367 */       ss.addDown(0, (RENDEROBJ)new GButt.ButtPanel("--")
/*     */           {
/*     */             protected void clickA() {
/* 370 */               AdminData.Gui.this.data.clear();
/* 371 */               super.clickA();
/*     */             }
/*     */           });
/*     */     } 
/*     */     
/* 376 */     ss.body().incrW(64.0D);
/* 377 */     text.add((RENDEROBJ)ss);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\admin\AdminData$Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */