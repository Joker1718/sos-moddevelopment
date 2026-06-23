/*     */ package settlement.room.knowledge.school;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.Boostable;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.colls.StatsEducation;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class RoomEducationHelper
/*     */ {
/*  50 */   private static CharSequence ¤¤daysToEducate = "¤Days to Educate";
/*  51 */   private static CharSequence ¤¤boost = "¤Species Boost";
/*     */   static {
/*  53 */     D.ts(RoomEducationHelper.class);
/*     */   }
/*     */   
/*     */   private final Boostable bonus;
/*     */   private final IndustryRate rate;
/*     */   private final RoomBlueprintIns<?> blue;
/*     */   private final HCLASS cl;
/*     */   
/*     */   public RoomEducationHelper(HCLASS cl, RoomBlueprintIns<?> blue, RoomBoost... boosts) {
/*  62 */     this.bonus = blue.bonus();
/*  63 */     this.blue = blue;
/*  64 */     this.cl = cl;
/*     */     
/*  66 */     RoomBoost deg = new RoomBoost()
/*     */       {
/*  68 */         INFO info = new INFO(Dic.¤¤Degrade, Dic.¤¤DegradeDesc);
/*     */ 
/*     */         
/*     */         public INFO info() {
/*  72 */           return this.info;
/*     */         }
/*     */ 
/*     */         
/*     */         public double get(RoomInstance r) {
/*  77 */           return 1.0D - r.getDegrade();
/*     */         }
/*     */       };
/*     */     
/*  81 */     this.rate = new IndustryRate(boosts, deg)
/*     */       {
/*     */         private final LIST<RoomBoost> boos;
/*     */ 
/*     */         
/*     */         public LIST<RoomBoost> boosts() {
/*  87 */           return this.boos;
/*     */         }
/*     */ 
/*     */         
/*     */         public Boostable bonus() {
/*  92 */           return RoomEducationHelper.this.bonus;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   public abstract StatsEducation.AgeType type();
/*     */   
/*     */   public void appendView(LISTE<UIRoomModule> mm) {
/* 100 */     mm.add(new UIRoomModule()
/*     */         {
/*     */ 
/*     */ 
/*     */           
/*     */           public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1)
/*     */           {
/* 107 */             section.addRelBody(8, DIR.S, (RENDEROBJ)(new GStat()
/*     */                 {
/*     */                   public void update(GText text)
/*     */                   {
/* 111 */                     GFORMAT.f0(text, RoomEducationHelper.null.access$0(RoomEducationHelper.null.this).learningSpeed((RoomInstance)get.get()));
/*     */                   }
/*     */ 
/*     */                   
/*     */                   public void hoverInfoGet(GBox b) {
/* 116 */                     b.title((RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).bonus.name);
/* 117 */                     b.text((RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).bonus.desc);
/* 118 */                     b.NL();
/*     */                     
/* 120 */                     IndustryUtil.hoverProductionRate((GUI_BOX)b, 1.0D, (RoomEducationHelper.null.access$0(RoomEducationHelper.null.this)).rate, (RoomInstance)get.get());
/*     */                   }
/* 135 */                 }).hh((SPRITE)RoomEducationHelper.this.bonus.icon));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/* 141 */             LinkedList<RENDEROBJ> rows = new LinkedList();
/*     */             
/* 143 */             for (HCLASS_RACE rr : HCLASS_RACE.ALL()) {
/* 144 */               if (rr.race == null)
/*     */                 continue; 
/* 146 */               if (rr.race.bvalue(RoomEducationHelper.this.bonus) == 0.0D)
/*     */                 continue; 
/* 148 */               if (rr.cl == HCLASSES.CITIZEN()) {
/* 149 */                 rows.add(new RoomEducationHelper.RaceRow(HCLASS_RACE.clP(rr.race, RoomEducationHelper.this.cl), RoomEducationHelper.this.bonus, RoomEducationHelper.this.type()));
/*     */               }
/*     */             } 
/* 152 */             text.add((RENDEROBJ)(new GScrollRows((Iterable)rows, ((RENDEROBJ)rows.get(0)).body().height() * 5)).view());
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void appendButt(GuiSection s, GETTER<RoomInstance> get) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hover(GBox box, Room room, int rx, int ry) {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class RaceRow
/*     */     extends GuiSection
/*     */   {
/*     */     RaceRow(final HCLASS_RACE race, final Boostable bonus, final StatsEducation.AgeType type) {
/* 184 */       GuiSection s = new GuiSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 187 */             GBox b = (GBox)text;
/*     */             
/* 189 */             b.textLL(race.race.info.names);
/* 190 */             b.textL(race.cl.names);
/* 191 */             b.NL();
/*     */             
/* 193 */             type.hoverLimit(text, race);
/* 194 */             b.NL(8);
/*     */             
/* 196 */             b.textLL(RoomEducationHelper.¤¤boost);
/* 197 */             b.tab(6);
/* 198 */             double am = race.race.bvalue(bonus);
/* 199 */             b.add((SPRITE)GFORMAT.f(b.text(), am));
/* 200 */             b.NL();
/*     */             
/* 202 */             b.textLL(RoomEducationHelper.¤¤daysToEducate);
/* 203 */             b.tab(6);
/* 204 */             am = type.limit(race) / bonus.get((BOOSTABLE_O)race) * type.limitSpeed(race);
/* 205 */             b.add((SPRITE)GFORMAT.f(b.text(), am));
/* 206 */             b.NL();
/*     */           }
/*     */         };
/*     */       
/* 210 */       s.addRightC(0, (SPRITE)(race.race.appearance()).icon);
/* 211 */       s.addRightC(-8, (SPRITE)race.cl.iconSmall());
/* 212 */       s.addRightC(4, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 216 */               GFORMAT.i(text, (long)Math.ceil(type.limit(race) / bonus.get((BOOSTABLE_O)race) * type.limitSpeed(race)));
/*     */             }
/*     */           });
/*     */       
/* 220 */       INT.INTE ii = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 224 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 229 */             return 100;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 234 */             return type.limit(race);
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 239 */             type.limitSet(race, t);
/*     */           }
/*     */         };
/*     */       
/* 243 */       s.addRightC(60, (RENDEROBJ)new GSliderInt(ii, 120, true, false));
/* 244 */       add((RENDEROBJ)s);
/* 245 */       body().incrW(16.0D);
/*     */       
/* 247 */       for (StatsEducation.StatEducation ss : (STATS.EDUCATION()).all) {
/* 248 */         addRightC(8, (RENDEROBJ)new GButt.ButtPanel((ss.total.info()).icon.resized(16))
/*     */             {
/*     */               protected void renAction()
/*     */               {
/* 252 */                 selectedSet((STATS.EDUCATION().policy(race) == ss));
/*     */               }
/*     */ 
/*     */               
/*     */               protected void clickA() {
/* 257 */                 STATS.EDUCATION().policySet(race, ss);
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 262 */                 ss.total.hover(text, race.cl, race.race);
/*     */               }
/*     */             });
/*     */       } 
/*     */       
/* 267 */       pad(4, 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double learningSpeed(Humanoid student, int tx, int ty) {
/* 273 */     RoomInstance ins = this.blue.get(tx, ty);
/* 274 */     if (ins == null)
/* 275 */       return 0.0D; 
/* 276 */     return learningSpeed(ins, (BOOSTABLE_O)student.indu());
/*     */   }
/*     */ 
/*     */   
/*     */   public double learningSpeed(RoomInstance ins, BOOSTABLE_O h) {
/* 281 */     double d = 1.0D;
/* 282 */     for (RoomBoost rr : this.rate.boosts()) {
/* 283 */       d *= rr.get(ins);
/*     */     }
/*     */     
/* 286 */     return this.bonus.get(h) * d;
/*     */   }
/*     */   
/*     */   public double learningSpeed(RoomInstance ins) {
/* 290 */     double ee = ins.employees().employed();
/* 291 */     if (ee == 0.0D)
/* 292 */       return this.bonus.get((BOOSTABLE_O)HCLASS_RACE.clP()); 
/* 293 */     return IndustryUtil.calcProductionRate(1.0D, this.rate, ins);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\knowledge\school\RoomEducationHelper.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */