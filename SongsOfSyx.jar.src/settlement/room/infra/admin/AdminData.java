/*     */ package settlement.room.infra.admin;
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.BoosterValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.settings.S;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.employment.RoomEmployment;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.SAVABLE;
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
/*     */ import util.statistics.HistoryInt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public class AdminData implements SAVABLE {
/*  48 */   private static CharSequence ¤¤degradeD = "Degrade per year. Each worker can only produce and maintain so much {0}. Without worker effort, the value will start to degrade with time.";
/*  49 */   private static CharSequence ¤¤TargetD = "¤Estimation of how much {0} will be produced.";
/*     */   
/*     */   static {
/*  52 */     D.ts(AdminData.class);
/*     */   }
/*  54 */   public final HistoryInt utilizedHistory = new HistoryInt(64, (TIMECYCLE)TIME.days(), true);
/*     */   
/*     */   public final Boostable target;
/*     */   public final double knowledgePerStation;
/*     */   private final double degradeValue;
/*     */   private final double workSpeed;
/*     */   private final double workValue;
/*     */   private final RoomEmployment emps;
/*     */   final Boostable boost;
/*     */   private int stations;
/*  64 */   private double prev = 0.0D;
/*  65 */   private double dayGain = 0.0D;
/*  66 */   private int day = -1;
/*     */   
/*  68 */   public byte usedD = 0;
/*  69 */   private double progress = 0.0D;
/*  70 */   private double workProg = 1.0D;
/*     */   
/*     */   private double skill;
/*     */   private double skillAmount;
/*  74 */   private int skillUpI = -1;
/*     */ 
/*     */ 
/*     */   
/*     */   public AdminData(RoomEmployment emps, Json json, Boostable boost) {
/*  79 */     this.emps = emps;
/*  80 */     this.boost = boost;
/*  81 */     this.knowledgePerStation = json.d("VALUE_PER_WORKER", 0.0D, 100000.0D);
/*  82 */     double degrade = json.d("VALUE_DEGRADE_PER_YEAR", 0.0D, 10.0D);
/*  83 */     this.degradeValue = degrade / TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*  84 */     this.workSpeed = json.d("VALUE_WORK_SPEED", 0.0D, 1000.0D);
/*     */     
/*  86 */     double work = this.knowledgePerStation * degrade;
/*  87 */     work /= TIME.years().bitSeconds();
/*  88 */     work *= Humanoid.WORK_PER_DAYI;
/*     */     
/*  90 */     this.workValue = work;
/*     */     
/*  92 */     if (json.has((BOOSTING.MAP()).key)) {
/*  93 */       this.target = (Boostable)BOOSTING.MAP().read(json);
/*     */     } else {
/*  95 */       this.target = null;
/*     */     } 
/*     */ 
/*     */     
/*  99 */     if (this.target != null) {
/* 100 */       double max = this.knowledgePerStation * 1000000.0D;
/* 101 */       final double maxI = 1.0D / max;
/*     */       
/* 103 */       BValue.BValuePlayerOnly bValuePlayerOnly = new BValue.BValuePlayerOnly()
/*     */         {
/*     */           public double vGet(Player f)
/*     */           {
/* 107 */             return AdminData.this.value() * maxI;
/*     */           }
/*     */ 
/*     */           
/*     */           public double vGet(FactionNPC f) {
/* 112 */             return 0.0D;
/*     */           }
/*     */         };
/*     */       
/* 116 */       (new BoosterValue((BValue)bValuePlayerOnly, new BSourceInfo((emps.blueprint()).info.names, (emps.blueprint().iconBig()).small), 0.0D, max, false)).add(this.target);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/* 122 */     this.utilizedHistory.save(file);
/* 123 */     file.d(this.prev);
/* 124 */     file.d(this.dayGain);
/* 125 */     file.i(this.day);
/* 126 */     file.d(this.skill);
/* 127 */     file.d(this.skillAmount);
/* 128 */     file.i(this.skillUpI);
/* 129 */     file.i(this.stations);
/*     */   }
/*     */ 
/*     */   
/*     */   public void load(FileGetter file) throws IOException {
/* 134 */     this.utilizedHistory.load(file);
/* 135 */     this.prev = file.d();
/* 136 */     this.dayGain = file.d();
/* 137 */     this.day = file.i();
/* 138 */     this.skill = file.d();
/* 139 */     this.skillAmount = file.d();
/* 140 */     this.skillUpI = file.i();
/* 141 */     this.stations = file.i();
/* 142 */     setProgress();
/*     */   }
/*     */ 
/*     */   
/*     */   public void clear() {
/* 147 */     this.utilizedHistory.clear();
/* 148 */     this.prev = 0.0D;
/* 149 */     this.dayGain = 0.0D;
/* 150 */     this.day = 0;
/* 151 */     this.stations = 0;
/*     */   }
/*     */   
/*     */   public void incStations(int am) {
/* 155 */     this.stations += am;
/*     */   }
/*     */ 
/*     */   
/*     */   public void perform(double time, double skill) {
/* 160 */     double progSpeed = this.workProg;
/*     */     
/* 162 */     progSpeed *= this.workSpeed;
/* 163 */     double am = time * skill * progSpeed * this.workValue;
/* 164 */     this.dayGain += am;
/* 165 */     this.skill += skill * this.emps.proximity();
/*     */     
/* 167 */     this.skillAmount++;
/*     */     
/* 169 */     int emp = this.emps.employed();
/*     */     
/* 171 */     if (this.skillAmount > emp) {
/* 172 */       this.skillUpI = GAME.updateI();
/* 173 */       this.skillAmount /= 2.0D;
/* 174 */       this.skill /= 2.0D;
/*     */     } 
/*     */ 
/*     */     
/* 178 */     this.utilizedHistory.set((int)value());
/* 179 */     setProgress();
/*     */   }
/*     */ 
/*     */   
/*     */   public void inc(double am) {
/* 184 */     this.dayGain += am;
/* 185 */     this.utilizedHistory.set((int)value());
/*     */   }
/*     */   
/*     */   public void update() {
/* 189 */     if (this.day != TIME.days().bitsSinceStart()) {
/* 190 */       this.day = TIME.days().bitsSinceStart();
/* 191 */       this.prev += this.dayGain;
/* 192 */       this.prev *= 1.0D - this.degradeValue;
/* 193 */       this.dayGain = 0.0D;
/* 194 */       this.utilizedHistory.set((int)value());
/*     */     } 
/*     */   }
/*     */   
/*     */   public double value() {
/* 199 */     double vv = (this.prev + this.dayGain) * (1.0D - this.degradeValue);
/* 200 */     vv = Math.max(this.prev, vv);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 214 */     return vv;
/*     */   }
/*     */ 
/*     */   
/*     */   public double projection() {
/* 219 */     return skill() * this.emps.employed() * this.knowledgePerStation * this.emps.totEff() / this.emps.proximity();
/*     */   }
/*     */   
/*     */   public double perEmployee() {
/* 223 */     if (this.emps.employed() == 0)
/* 224 */       return this.knowledgePerStation; 
/* 225 */     return skill() * this.knowledgePerStation * this.emps.totEff() / this.emps.proximity();
/*     */   }
/*     */   
/*     */   public double skill() {
/* 229 */     if (this.skillAmount == 0.0D)
/* 230 */       return 1.0D; 
/* 231 */     return this.skill / this.skillAmount;
/*     */   }
/*     */   
/*     */   private void setProgress() {
/* 235 */     this.progress = value() / skill() * this.emps.neededWorkers() * this.knowledgePerStation;
/* 236 */     this.progress = CLAMP.d(this.progress, 0.0D, 1.0D);
/* 237 */     this.workProg = 1.0D - this.progress * this.progress;
/* 238 */     this.usedD = (byte)(int)(this.progress * 255.0D);
/*     */   }
/*     */   
/*     */   public static class Gui<A extends RoomInstance, B extends RoomBlueprintIns<A>>
/*     */     extends UIRoomModule.UIRoomModuleImp<A, B>
/*     */   {
/* 244 */     private final GChart chart = new GChart();
/*     */     private final AdminData data;
/*     */     private final IndustryRate indu;
/*     */     private final CharSequence name;
/*     */     private final CharSequence targetD;
/*     */     
/*     */     public Gui(B s, AdminData data, IndustryRate out, CharSequence name, CharSequence targetD) {
/* 251 */       super((RoomBlueprintIns)s);
/* 252 */       this.data = data;
/* 253 */       this.indu = out;
/* 254 */       this.name = name;
/* 255 */       this.targetD = targetD;
/*     */     }
/*     */     
/*     */     public Gui(B s, AdminData data, IndustryRate out) {
/* 259 */       super((RoomBlueprintIns)s);
/* 260 */       this.data = data;
/* 261 */       this.indu = out;
/* 262 */       this.name = data.target.name;
/* 263 */       this.targetD = String.valueOf(Str.TMP.clear().add(AdminData.¤¤TargetD).insert(0, this.name));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void appendPanel(GuiSection section, GGrid grid, final GETTER<A> getter, int x1, int y1) {
/* 269 */       section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 273 */               double p = ((RoomInstance)getter.get()).employees().employed() * IndustryUtil.calcProductionRate(AdminData.Gui.this.data.knowledgePerStation, AdminData.Gui.this.indu, AdminData.Gui.this.data.boost, (RoomInstance)getter.get());
/* 274 */               GFORMAT.f0(text, p);
/*     */             }
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/* 279 */               b.text(AdminData.Gui.this.targetD);
/* 280 */               b.NL(8);
/* 281 */               IndustryUtil.hoverProductionRate((GUI_BOX)b, AdminData.Gui.this.data.knowledgePerStation, AdminData.Gui.this.indu, AdminData.Gui.this.data.boost, (RoomInstance)getter.get());
/*     */             }
/* 284 */           }).hv(Dic.¤¤Target));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void hover(GBox box, A i) {
/* 296 */       super.hover(box, (RoomInstance)i);
/* 297 */       box.NL(8);
/* 298 */       box.textLL(this.name);
/* 299 */       box.add((SPRITE)GFORMAT.i(box.text(), (int)this.data.value()));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected void appendMain(GGrid r, GGrid text, GuiSection sExtra) {
/* 306 */       GuiSection ss = new GuiSection();
/*     */       
/* 308 */       ss.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 312 */               GFORMAT.f0(text, AdminData.Gui.this.data.value(), 2.0D);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/* 318 */               AdminData.Gui.this.chart.clear();
/* 319 */               AdminData.Gui.this.chart.add((HISTORY)AdminData.Gui.this.data.utilizedHistory);
/* 320 */               b.add((RENDEROBJ)AdminData.Gui.this.chart);
/*     */             }
/* 323 */           }).hh(this.name));
/* 324 */       ss.addDown(2, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 328 */               GFORMAT.perc(text, AdminData.Gui.this.data.degradeValue * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/* 335 */               GText t = b.text();
/* 336 */               t.add(AdminData.¤¤degradeD);
/* 337 */               t.insert(0, AdminData.Gui.this.name);
/* 338 */               b.add((SPRITE)t);
/*     */             }
/* 341 */           }).hh(Dic.¤¤Degrade));
/*     */       
/* 343 */       ss.addDown(2, (RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 347 */               GFORMAT.f0(text, AdminData.Gui.this.data.projection(), 2.0D);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             public void hoverInfoGet(GBox b) {
/* 353 */               b.text(AdminData.Gui.this.targetD);
/* 354 */               b.add((SPRITE)GFORMAT.i(b.text(), (int)AdminData.Gui.this.data.projection()));
/*     */             }
/* 357 */           }).hh(Dic.¤¤Target));
/*     */       
/* 359 */       if ((S.get()).developer) {
/* 360 */         ss.addDown(2, (RENDEROBJ)new GButt.ButtPanel("++")
/*     */             {
/*     */               protected void clickA() {
/* 363 */                 AdminData.Gui.this.data.cheatAdd(50);
/* 364 */                 super.clickA();
/*     */               }
/*     */             });
/* 367 */         ss.addDown(0, (RENDEROBJ)new GButt.ButtPanel("--")
/*     */             {
/*     */               protected void clickA() {
/* 370 */                 AdminData.Gui.this.data.clear();
/* 371 */                 super.clickA();
/*     */               }
/*     */             });
/*     */       } 
/*     */       
/* 376 */       ss.body().incrW(64.0D);
/* 377 */       text.add((RENDEROBJ)ss);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void cheatAdd(int baseUnits) {
/* 383 */     inc((TIME.secondsPerDay() * baseUnits) * this.workValue);
/*     */   }
/*     */   
/*     */   public static interface ROOM_ADMIN_HOLDER {
/*     */     AdminData admin();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\admin\AdminData.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */