/*     */ package settlement.room.service.breeder;
/*     */ import init.type.HCLASSES;
/*     */ import settlement.room.industry.module.IndustryRate;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<BreederInstance, ROOM_BREEDER> {
/*  31 */   private static CharSequence ¤¤limitGlobal = "Global limit";
/*  32 */   private static CharSequence ¤¤limit = "Class limit";
/*     */   
/*  34 */   private static CharSequence ¤¤limitGlobalD = "A limit for when to stop producing children, based on total population of all classes and species.";
/*  35 */   private static CharSequence ¤¤limitD = "A limit for when to stop producing children, based on population of current class and species.";
/*     */   
/*  37 */   private static CharSequence ¤¤limitGlobalProb = "Your total population of all races exceeds the limit set.";
/*  38 */   private static CharSequence ¤¤limitProb = "Your population of citizens of the current species exceeds the limit set.";
/*     */   
/*  40 */   private static CharSequence ¤¤population = "Population";
/*  41 */   private static CharSequence ¤¤incoming = "Incoming";
/*  42 */   private static CharSequence ¤¤total = "Total";
/*  43 */   private static CharSequence ¤¤toBreed = "To Breed";
/*     */   static {
/*  45 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_BREEDER s) {
/*  49 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<BreederInstance> getter, int x1, int y1) {
/*  55 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  59 */           double n = IndustryUtil.calcProductionRate(((ROOM_BREEDER)Gui.this.blueprint).PRODUCTION_SPEED_DAY, (IndustryRate)((ROOM_BREEDER)Gui.this.blueprint).productionData, (RoomInstance)getter.get());
/*  60 */           GFORMAT.fRel(text, n * ((BreederInstance)getter.get()).employees().totEfficiency(), ((ROOM_BREEDER)Gui.this.blueprint).PRODUCTION_SPEED_DAY);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/*  65 */           IndustryUtil.hoverProductionRate((GUI_BOX)b, ((ROOM_BREEDER)Gui.this.blueprint).PRODUCTION_SPEED_DAY, (IndustryRate)((ROOM_BREEDER)Gui.this.blueprint).productionData, (RoomInstance)getter.get());
/*     */         }
/*  68 */       }).hh((SPRITE)(((ROOM_BREEDER)this.blueprint).race.appearance()).iconBig);
/*     */     
/*  70 */     section.addRelBody(8, DIR.S, (RENDEROBJ)hOVERABLE);
/*     */     
/*  72 */     GButt.ButtPanel buttPanel = new GButt.ButtPanel((STATS.MULTIPLIERS()).PROSECUTION.name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  76 */           ((ROOM_BREEDER)Gui.this.blueprint).prosecute = !((ROOM_BREEDER)Gui.this.blueprint).prosecute;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  81 */           selectedSet(((ROOM_BREEDER)Gui.this.blueprint).prosecute);
/*  82 */           super.renAction();
/*     */         }
/*     */       };
/*     */     
/*  86 */     section.addRelBody(8, DIR.S, (RENDEROBJ)buttPanel);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid icons, GGrid r, GuiSection sExtra) {
/*  95 */     GuiSection s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/*  99 */           GBox b = (GBox)text;
/* 100 */           b.title(Gui.¤¤limitGlobal);
/* 101 */           b.text(Gui.¤¤limitGlobalD);
/* 102 */           b.NL(8);
/*     */           
/* 104 */           b.textLL(Gui.¤¤population);
/* 105 */           b.tab(7);
/* 106 */           b.add((SPRITE)GFORMAT.i(b.text(), POP.tot()));
/* 107 */           b.NL();
/*     */           
/* 109 */           b.textLL(Gui.¤¤incoming);
/* 110 */           b.tab(7);
/* 111 */           b.add((SPRITE)GFORMAT.i(b.text(), (POP.next() - POP.tot())));
/* 112 */           b.NL();
/*     */           
/* 114 */           b.textLL(Gui.¤¤total);
/* 115 */           b.tab(7);
/* 116 */           b.add((SPRITE)GFORMAT.i(b.text(), POP.next()));
/* 117 */           b.NL();
/*     */           
/* 119 */           b.textLL(Gui.¤¤toBreed);
/* 120 */           b.tab(7);
/* 121 */           b.add((SPRITE)GFORMAT.i(b.text(), (((ROOM_BREEDER)Gui.this.blueprint).limitTotal - POP.next())));
/* 122 */           b.NL();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 128 */     s.add((RENDEROBJ)new GHeader(¤¤limitGlobal));
/*     */     
/* 130 */     INT.INTE in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 134 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 139 */           return 40000;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 144 */           return CLAMP.i(((ROOM_BREEDER)Gui.this.blueprint).limitTotal, min(), max());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 149 */           CLAMP.i(t, min(), max());
/* 150 */           ((ROOM_BREEDER)Gui.this.blueprint).limitTotal = t;
/*     */         }
/*     */       };
/* 153 */     s.addRelBody(2, DIR.S, (RENDEROBJ)new GSliderInt(in, 200, true));
/*     */     
/* 155 */     r.section.addRelBody(0, DIR.S, (RENDEROBJ)s);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     s = new GuiSection()
/*     */       {
/*     */         public void hoverInfoGet(GUI_BOX text)
/*     */         {
/* 164 */           GBox b = (GBox)text;
/* 165 */           b.title(Gui.¤¤limit);
/* 166 */           b.text(Gui.¤¤limitD);
/* 167 */           b.NL(8);
/*     */           
/* 169 */           b.textLL(Gui.¤¤population);
/* 170 */           b.tab(7);
/* 171 */           b.add((SPRITE)GFORMAT.i(b.text(), POP.tot(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.this.blueprint).race)));
/* 172 */           b.NL();
/*     */           
/* 174 */           b.textLL(Gui.¤¤incoming);
/* 175 */           b.tab(7);
/* 176 */           b.add((SPRITE)GFORMAT.i(b.text(), (POP.next(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.this.blueprint).race) - POP.tot(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.this.blueprint).race))));
/* 177 */           b.NL();
/*     */           
/* 179 */           b.textLL(Gui.¤¤total);
/* 180 */           b.tab(7);
/* 181 */           b.add((SPRITE)GFORMAT.i(b.text(), POP.next(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.this.blueprint).race)));
/* 182 */           b.NL();
/*     */           
/* 184 */           b.textLL(Gui.¤¤toBreed);
/* 185 */           b.tab(7);
/* 186 */           b.add((SPRITE)GFORMAT.i(b.text(), (((ROOM_BREEDER)Gui.this.blueprint).limitSpecies - POP.next(HCLASSES.CITIZEN(), ((ROOM_BREEDER)Gui.this.blueprint).race))));
/* 187 */           b.NL();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 193 */     s.add((RENDEROBJ)new GHeader(¤¤limit));
/*     */     
/* 195 */     in = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 199 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 204 */           return 40000;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 209 */           return CLAMP.i(((ROOM_BREEDER)Gui.this.blueprint).limitSpecies, min(), max());
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 214 */           CLAMP.i(t, min(), max());
/* 215 */           ((ROOM_BREEDER)Gui.this.blueprint).limitSpecies = t;
/*     */         }
/*     */       };
/* 218 */     s.addRelBody(2, DIR.S, (RENDEROBJ)new GSliderInt(in, 200, true));
/*     */     
/* 220 */     r.section.addRelBody(0, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, BreederInstance i) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void problem(BreederInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 238 */     if (POP.next(HCLASSES.CITIZEN(), ((ROOM_BREEDER)this.blueprint).race) > ((ROOM_BREEDER)this.blueprint).limitSpecies) {
/* 239 */       errors.add(¤¤limitProb);
/*     */     }
/*     */     
/* 242 */     if (POP.next(null, null) > ((ROOM_BREEDER)this.blueprint).limitTotal) {
/* 243 */       errors.add(¤¤limitGlobalProb);
/*     */     }
/*     */     
/* 246 */     super.problem(i, free, errors, warnings);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\service\breeder\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */