/*     */ package settlement.room.food.pasture;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
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
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<PastureInstance, ROOM_PASTURE> {
/*  34 */   static CharSequence ¤¤Animals = "¤Animals";
/*  35 */   static CharSequence ¤¤Adults = "¤Adult Animals";
/*  36 */   static CharSequence ¤¤Tending = "¤Tending";
/*  37 */   static CharSequence ¤¤Skill = "¤Skill";
/*  38 */   static CharSequence ¤¤SkillD = "¤Skill that gets put into the tending, multiplying the output.";
/*  39 */   static CharSequence ¤¤BaseRate = "¤Base Rate";
/*     */ 
/*     */   
/*  42 */   static CharSequence ¤¤DailyWork = "¤Daily Tending";
/*  43 */   static CharSequence ¤¤DailyWorkD = "¤Daily Tending is the amount of work needed to keep this pasture functioning. The amount of work needed depends on the amount of animals. If the workers fail to do the tending, animals will start to die. Resets each day.";
/*  44 */   static CharSequence ¤¤SlaughterAll = "¤Slaughter all";
/*  45 */   static CharSequence ¤¤SlaughterAllDesc = "¤Slaughter all animals and immediately receive some produce?";
/*     */   
/*  47 */   static CharSequence ¤¤ProdExp = "¤Production of the current day is based on the work of the previous day. The workers must tend to the animals each day. Failing to tend to the animals for one day will result in lower produce. Failing two days in a row results in livestock dying.";
/*     */   
/*     */   static {
/*  50 */     D.ts(Gui.class);
/*     */   }
/*     */ 
/*     */   
/*     */   Gui(ROOM_PASTURE s) {
/*  55 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hover(GBox box, PastureInstance i) {
/*  62 */     super.hover(box, i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<PastureInstance> getter, int x1, int y1) {
/*  69 */     GuiSection s = new GuiSection();
/*     */     
/*  71 */     s.addRightC(32, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  75 */             GFORMAT.iofkInv(text, ((PastureInstance)getter.get()).animalsCurrent, ((PastureInstance)getter.get()).animalsMax);
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  81 */             b.textLL(Gui.¤¤Adults);
/*  82 */             b.tab(6);
/*  83 */             b.add((SPRITE)GFORMAT.i(b.text(), (((PastureInstance)getter.get()).animalsCurrent - ((PastureInstance)getter.get()).animalsCubs)));
/*     */           }
/*  86 */         }).hv(¤¤Animals));
/*     */     
/*  88 */     s.addRightC(32, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  92 */             GFORMAT.iofkInv(text, CLAMP.i(((PastureInstance)getter.get()).work, 0, ((PastureInstance)getter.get()).workMax), ((PastureInstance)getter.get()).neededWork(((PastureInstance)getter.get()).animalsCurrent()));
/*     */           }
/*  96 */         }).hv(¤¤DailyWork, ¤¤DailyWorkD));
/*     */     
/*  98 */     s.addRightC(32, (RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 102 */             GFORMAT.perc(text, ((PastureInstance)getter.get()).skill());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 108 */             b.title(Gui.¤¤Skill);
/* 109 */             b.text(Gui.¤¤SkillD);
/* 110 */             b.NL(8);
/* 111 */             IndustryUtil.hoverBoosts((GUI_BOX)b, 1.0D, null, ((Industry)(((PastureInstance)getter.get()).blueprintI()).indus.get(0)).bonus(), (RoomInstance)getter.get(), 1.0D);
/*     */           }
/* 114 */         }).hv(¤¤Skill));
/*     */     
/* 116 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */     
/* 118 */     CLICKABLE cLICKABLE = (new GButt.ButtPanel(¤¤SlaughterAll) {
/* 119 */         private final ACTION yes = new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/* 123 */               ((PastureInstance)getter.get()).slaughterAll();
/*     */             }
/*     */           };
/*     */         
/*     */         protected void clickA() {
/* 128 */           (VIEW.inters()).yesNo.activate(Gui.¤¤SlaughterAllDesc, this.yes, ACTION.NOP, true);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 133 */           GBox b = (GBox)text;
/* 134 */           double produce = ((ROOM_PASTURE)Gui.this.blueprint).slaughterAmount(false, ((PastureInstance)getter.get()).industry()) * (((PastureInstance)getter.get()).animalsCurrent - ((PastureInstance)getter.get()).animalsCubs);
/* 135 */           produce += ((ROOM_PASTURE)Gui.this.blueprint).slaughterAmount(true, ((PastureInstance)getter.get()).industry()) * ((PastureInstance)getter.get()).animalsCubs;
/*     */           
/* 137 */           for (IndustryResource r : ((PastureInstance)getter.get()).industry().outs()) {
/* 138 */             if (r.resource == RESOURCES.LIVESTOCK())
/*     */               continue; 
/* 140 */             double am = produce * r.rate;
/*     */             
/* 142 */             b.add((SPRITE)r.resource.icon());
/* 143 */             b.text(r.resource.name);
/* 144 */             b.tab(7);
/* 145 */             b.add((SPRITE)GFORMAT.f0(b.text(), am));
/* 146 */             b.NL();
/*     */           }
/*     */         
/*     */         }
/* 150 */       }).hoverInfoSet(¤¤SlaughterAllDesc);
/*     */     
/* 152 */     section.addRelBody(8, DIR.S, (RENDEROBJ)cLICKABLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void problem(PastureInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 163 */     super.problem(i, free, errors, warnings);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public static void industryHoverProductionRate(GBox b, IndustryResource i, RoomInstance ins) {
/* 173 */     PastureInstance ii = (PastureInstance)ins;
/* 174 */     b.NL(8);
/* 175 */     b.text(¤¤ProdExp);
/* 176 */     b.NL(8);
/* 177 */     b.textLL(Dic.¤¤Multipliers);
/* 178 */     b.NL();
/*     */     
/* 180 */     b.text(¤¤BaseRate);
/* 181 */     b.tab(6);
/* 182 */     b.add((SPRITE)GFORMAT.f(b.text(), i.rate));
/* 183 */     b.NL();
/*     */     
/* 185 */     double prod = i.rate;
/*     */     
/* 187 */     for (RoomBoost bb : ((Industry)(ii.blueprintI()).indus.get(0)).boosts()) {
/* 188 */       b.text((bb.info()).name);
/* 189 */       b.tab(6);
/* 190 */       b.add((SPRITE)GFORMAT.f1(b.text(), bb.get(ii)));
/* 191 */       b.NL();
/* 192 */       prod *= bb.get(ii);
/*     */     } 
/*     */     
/* 195 */     b.NL(8);
/*     */ 
/*     */     
/* 198 */     b.textL(Dic.¤¤Total);
/* 199 */     b.tab(6);
/* 200 */     b.add((SPRITE)GFORMAT.f(b.text(), prod));
/* 201 */     b.NL();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\food\pasture\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */