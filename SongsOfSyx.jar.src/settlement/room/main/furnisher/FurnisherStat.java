/*     */ package settlement.room.main.furnisher;
/*     */ 
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import settlement.room.industry.module.INDUSTRY_HASER;
/*     */ import settlement.room.industry.module.Industry;
/*     */ import settlement.room.industry.module.IndustryResource;
/*     */ import settlement.room.industry.module.RoomBoost;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.service.module.RoomService;
/*     */ import settlement.room.water.RoomIrrigated;
/*     */ import settlement.tilemap.ground.Ground;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ public abstract class FurnisherStat
/*     */   implements INDEXED, RoomBoost {
/*     */   protected final int index;
/*     */   private final CharSequence name;
/*  38 */   private static CharSequence ¤¤Services = "Services"; protected CharSequence desc; public final double min; private final INFO info;
/*  39 */   private static CharSequence ¤¤serviceDesc = "Total amount of people that can be served simultaneously. The other (number) is an estimate of how many subjects the room will be able to serve, derived from your subjects' properties.";
/*  40 */   private static CharSequence ¤¤productionD = "Estimation of daily output of resources.";
/*  41 */   private static CharSequence ¤¤Efficiency = "Efficiency";
/*  42 */   private static CharSequence ¤¤EfficiencyD = "Efficiency is increased by certain items and can increase the usefulness of the room.";
/*  43 */   private static CharSequence ¤¤employeesD = "The amount of subjects needed to operate this room. The room might require less or more workers depending on circumstances.";
/*  44 */   private static CharSequence ¤¤wdesc = "Moisture is essential to all growing things. Most land has some moisture to begin with. This can be improved by fresh water access from irrigation or natural bodies of water at a later stage.";
/*     */   static {
/*  46 */     D.ts(FurnisherStat.class);
/*     */   }
/*     */   
/*     */   public FurnisherStat(Furnisher furnisher, CharSequence name, CharSequence desc, double min) {
/*  50 */     this.index = furnisher.stats.add(this);
/*  51 */     this.name = name;
/*  52 */     this.desc = desc;
/*  53 */     this.info = new INFO(name, desc);
/*  54 */     this.min = min;
/*     */   }
/*     */   
/*     */   public FurnisherStat(Furnisher furnisher) {
/*  58 */     if (Furnisher.jsonStat.length == furnisher.stats.size()) {
/*  59 */       throw new Errors.DataError("invalid number of stats have been declared");
/*     */     }
/*     */     
/*  62 */     this.name = Furnisher.jsonStat[furnisher.stats.size()].text("NAME");
/*  63 */     this.desc = Furnisher.jsonStat[furnisher.stats.size()].text("DESC");
/*  64 */     this.index = furnisher.stats.add(this);
/*  65 */     this.info = new INFO(this.name, this.desc);
/*  66 */     this.min = 0.0D;
/*     */   }
/*     */   
/*     */   public FurnisherStat(Furnisher furnisher, double min) {
/*  70 */     if (Furnisher.jsonStat.length == furnisher.stats.size()) {
/*  71 */       throw new Errors.DataError("invalid number of stats have been declared");
/*     */     }
/*     */     
/*  74 */     this.name = Furnisher.jsonStat[furnisher.stats.size()].text("NAME");
/*  75 */     this.desc = Furnisher.jsonStat[furnisher.stats.size()].text("DESC");
/*  76 */     this.index = furnisher.stats.add(this);
/*  77 */     this.info = new INFO(this.name, this.desc);
/*  78 */     this.min = min;
/*     */   }
/*     */ 
/*     */   
/*     */   public final CharSequence name() {
/*  83 */     return this.name;
/*     */   }
/*     */   
/*     */   public final CharSequence desc() {
/*  87 */     return this.desc;
/*     */   }
/*     */ 
/*     */   
/*     */   public INFO info() {
/*  92 */     return this.info;
/*     */   }
/*     */   
/*     */   public abstract GText format(GText paramGText, double paramDouble);
/*     */   
/*     */   public double get(AREA area, double[] fromItems) {
/*  98 */     return get(area, fromItems[this.index]);
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract double get(AREA paramAREA, double paramDouble);
/*     */   
/*     */   public double get(RoomInstance r) {
/* 105 */     return r.stat(this.index);
/*     */   }
/*     */ 
/*     */   
/*     */   public final int index() {
/* 110 */     return this.index;
/*     */   }
/*     */ 
/*     */   
/*     */   public void appendPanel(GuiSection section, GGrid grid, final GETTER<? extends RoomInstance> getter, int x1, int y1) {
/* 115 */     grid.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text) {
/* 118 */             FurnisherStat.this.format(text, FurnisherStat.this.get((RoomInstance)getter.get()));
/*     */           }
/* 120 */         }).hh(this.name).hoverInfoSet(this.desc));
/*     */   }
/*     */   
/*     */   public static class FurnisherStatRelative
/*     */     extends FurnisherStat
/*     */   {
/*     */     private final FurnisherStat other;
/*     */     private final double mod;
/*     */     
/*     */     public FurnisherStatRelative(Furnisher f, FurnisherStat other) {
/* 130 */       this(f, other, 1.0D);
/*     */     }
/*     */     
/*     */     public FurnisherStatRelative(Furnisher f, FurnisherStat other, double mod) {
/* 134 */       super(f);
/* 135 */       this.other = other;
/* 136 */       this.mod = mod;
/*     */     }
/*     */ 
/*     */     
/*     */     public GText format(GText t, double d) {
/* 141 */       return GFORMAT.perc(t, d);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double get(AREA area, double[] fromItems) {
/* 147 */       double i = fromItems[this.index];
/* 148 */       double o = this.other.get(area, fromItems);
/*     */       
/* 150 */       if (o == 0.0D) {
/* 151 */         if (i == 0.0D)
/* 152 */           return 0.0D; 
/* 153 */         return 1.0D;
/*     */       } 
/*     */       
/* 156 */       return CLAMP.d(this.mod * i / o, 0.0D, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public final double get(AREA area, double acc) {
/* 161 */       return acc;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FurnisherStatEfficiency
/*     */     extends FurnisherStat {
/*     */     private final FurnisherStat other;
/*     */     protected final double mul;
/*     */     
/*     */     public FurnisherStatEfficiency(Furnisher f, FurnisherStat workers) {
/* 171 */       this(f, workers, 1.0D);
/*     */     }
/*     */     
/*     */     public FurnisherStatEfficiency(Furnisher f, FurnisherStat workers, double mul) {
/* 175 */       super(f, FurnisherStat.¤¤Efficiency, FurnisherStat.¤¤EfficiencyD, 0.0D);
/* 176 */       this.other = workers;
/* 177 */       this.mul = mul;
/*     */     }
/*     */ 
/*     */     
/*     */     public GText format(GText t, double d) {
/* 182 */       return GFORMAT.perc(t, (int)(100.0D * d) / 100.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double get(AREA area, double[] fromItems) {
/* 188 */       double i = fromItems[this.index];
/* 189 */       double o = this.other.get(area, fromItems);
/*     */       
/* 191 */       if (o == 0.0D) {
/* 192 */         if (i == 0.0D)
/* 193 */           return 0.5D; 
/* 194 */         return 1.0D;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 199 */       return CLAMP.d(0.5D + this.mul * 0.5D * i / o, 0.0D, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public final double get(AREA area, double acc) {
/* 204 */       return acc;
/*     */     }
/*     */ 
/*     */     
/*     */     public double min() {
/* 209 */       return 0.5D;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class FurnisherStatIrrigation
/*     */     extends FurnisherStat
/*     */   {
/*     */     private final boolean nop;
/*     */     private final RoomIrrigated.ROOM_IRRIGATED ii;
/*     */     
/*     */     public FurnisherStatIrrigation(Furnisher f, RoomIrrigated.ROOM_IRRIGATED ii) {
/* 221 */       super(f, Ground.¤¤moisture, FurnisherStat.¤¤wdesc, 0.0D);
/* 222 */       this.ii = ii;
/* 223 */       this.nop = false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public GText format(GText t, double d) {
/* 229 */       if (this.nop) {
/* 230 */         t.add('-').add('-');
/* 231 */         return t;
/*     */       } 
/*     */       
/* 234 */       return GFORMAT.perc(t, (int)(100.0D * d) / 100.0D);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double get(AREA area, double[] fromItems) {
/* 240 */       return this.ii.irrigation().valueProspect(area);
/*     */     }
/*     */ 
/*     */     
/*     */     public final double get(AREA area, double acc) {
/* 245 */       return acc;
/*     */     }
/*     */ 
/*     */     
/*     */     public double min() {
/* 250 */       return (this.ii.irrigation()).from;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FurnisherStatI
/*     */     extends FurnisherStat
/*     */   {
/*     */     public FurnisherStatI(Furnisher f) {
/* 258 */       super(f);
/*     */     }
/*     */     
/*     */     public FurnisherStatI(Furnisher f, int min) {
/* 262 */       super(f, min);
/*     */     }
/*     */ 
/*     */     
/*     */     public GText format(GText t, double acc) {
/* 267 */       return GFORMAT.i(t, (int)Math.ceil(acc));
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(AREA area, double acc) {
/* 272 */       return acc;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FurnisherStatEmployees
/*     */     extends FurnisherStat {
/*     */     public FurnisherStatEmployees(Furnisher f, double min) {
/* 279 */       super(f, Dic.¤¤Employees, FurnisherStat.¤¤employeesD, min);
/*     */     }
/*     */     
/*     */     public FurnisherStatEmployees(Furnisher f) {
/* 283 */       this(f, 1.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     public GText format(GText t, double acc) {
/* 288 */       return GFORMAT.f(t, acc, 2);
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(AREA area, double acc) {
/* 293 */       return acc;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FurnisherStatEmployeesR
/*     */     extends FurnisherStat {
/*     */     private final FurnisherStat services;
/*     */     private final double mul;
/*     */     
/*     */     public FurnisherStatEmployeesR(Furnisher f, FurnisherStat services, double mul) {
/* 303 */       super(f, Dic.¤¤Employees, FurnisherStat.¤¤employeesD, 0.0D);
/* 304 */       this.services = services;
/* 305 */       this.mul = mul;
/*     */     }
/*     */ 
/*     */     
/*     */     public GText format(GText t, double acc) {
/* 310 */       return GFORMAT.i(t, (int)Math.ceil(acc));
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(AREA area, double acc) {
/* 315 */       return acc;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double get(AREA area, double[] fromItems) {
/* 321 */       return fromItems[this.services.index] * this.mul;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FurnisherStatServices
/*     */     extends FurnisherStat {
/*     */     private final RoomService.ROOM_SERVICE_HASER p;
/*     */     
/*     */     public FurnisherStatServices(Furnisher f, RoomService.ROOM_SERVICE_HASER p) {
/* 330 */       this(f, p, 0);
/*     */     }
/*     */     
/*     */     public FurnisherStatServices(Furnisher f, RoomService.ROOM_SERVICE_HASER p, int min) {
/* 334 */       super(f, FurnisherStat.¤¤Services, FurnisherStat.¤¤serviceDesc, min);
/* 335 */       this.p = p;
/*     */     }
/*     */ 
/*     */     
/*     */     public GText format(GText t, double acc) {
/* 340 */       GFORMAT.i(t, (int)Math.ceil(acc));
/* 341 */       t.s();
/* 342 */       t.add('(');
/* 343 */       GFORMAT.i(t, (int)Math.ceil(acc * this.p.service().totalMultiplier()));
/* 344 */       t.add(')');
/*     */       
/* 346 */       return t;
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(AREA area, double acc) {
/* 351 */       return acc;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FurnisherStatProduction
/*     */     extends FurnisherStat {
/*     */     private final INDUSTRY_HASER p;
/*     */     private final FurnisherStat eff;
/*     */     
/*     */     public FurnisherStatProduction(Furnisher f, INDUSTRY_HASER ins, FurnisherStat efficiency) {
/* 361 */       this(f, ins, efficiency, 0);
/*     */     }
/*     */     
/*     */     public FurnisherStatProduction(Furnisher f, INDUSTRY_HASER ins, FurnisherStat efficiency, int min) {
/* 365 */       super(f, Dic.¤¤ProductionRate, FurnisherStat.¤¤productionD, min);
/* 366 */       this.p = ins;
/* 367 */       this.eff = efficiency;
/*     */     }
/*     */ 
/*     */     
/*     */     public GText format(GText t, double acc) {
/* 372 */       acc *= ((IndustryResource)((Industry)this.p.industries().get(0)).outs().get(0)).rate;
/* 373 */       GFORMAT.f(t, acc, 2);
/* 374 */       return t;
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(AREA area, double acc) {
/* 379 */       return acc;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double get(AREA area, double[] fromItems) {
/* 385 */       double i = super.get(area, fromItems);
/* 386 */       if (this.eff != null)
/* 387 */         i *= this.eff.get(area, fromItems); 
/* 388 */       return i;
/*     */     }
/*     */     
/*     */     protected double getBase() {
/* 392 */       return 1.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class FurnisherStatProduction2
/*     */     extends FurnisherStat {
/*     */     protected final INDUSTRY_HASER p;
/*     */     
/*     */     public FurnisherStatProduction2(Furnisher f, INDUSTRY_HASER ins) {
/* 401 */       this(f, ins, 0.1D);
/*     */     }
/*     */     
/*     */     public FurnisherStatProduction2(Furnisher f, INDUSTRY_HASER ins, double min) {
/* 405 */       super(f, Dic.¤¤Production, FurnisherStat.¤¤productionD, min);
/* 406 */       this.p = ins;
/*     */     }
/*     */ 
/*     */     
/*     */     public GText format(GText t, double acc) {
/* 411 */       GFORMAT.f(t, acc, 2);
/* 412 */       return t;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double get(AREA area, double acc) {
/* 418 */       double rr = 0.0D;
/* 419 */       for (IndustryResource r : ((Industry)this.p.industries().get(0)).outs())
/* 420 */         rr += r.rate; 
/* 421 */       return rr * ((Industry)this.p.industries().get(0)).bonus().get((BOOSTABLE_O)FACTIONS.player());
/*     */     }
/*     */ 
/*     */     
/*     */     public double get(AREA area, double[] fromItems) {
/* 426 */       return get(area, fromItems[this.index]) * getBase(area, fromItems);
/*     */     }
/*     */     
/*     */     protected double getBase(AREA area, double[] fromItems) {
/* 430 */       return 1.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public UIRoomModule applier(final RoomBlueprintIns<?> blue) {
/* 435 */     return new UIRoomModule()
/*     */       {
/*     */         public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1)
/*     */         {
/* 439 */           section.addRelBody(4, DIR.S, (RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text) {
/* 442 */                   FurnisherStat.null.access$0(FurnisherStat.null.this).format(text, FurnisherStat.null.access$0(FurnisherStat.null.this).get((RoomInstance)get.get()));
/*     */                 }
/* 444 */               }).hh(FurnisherStat.this.name).hoverInfoSet(FurnisherStat.this.desc));
/*     */         }
/*     */ 
/*     */         
/*     */         public void appendManageScr(GGrid icons, GGrid text, GuiSection sExtra) {
/* 449 */           icons.NL();
/* 450 */           icons.add((RENDEROBJ)(new GStat()
/*     */               {
/*     */                 public void update(GText text)
/*     */                 {
/* 454 */                   FurnisherStat.null.access$0(FurnisherStat.null.this).format(text, blue.getStat(FurnisherStat.null.access$0(FurnisherStat.null.this).index()));
/*     */                 }
/* 456 */               }).decrease().hh(FurnisherStat.this.info));
/* 457 */           super.appendManageScr(icons, text, sExtra);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hover(GBox box, Room i, int rx, int ry) {
/* 462 */           box.NL();
/* 463 */           box.text(FurnisherStat.this.name);
/* 464 */           box.add((SPRITE)FurnisherStat.this.format(box.text(), FurnisherStat.this.get((RoomInstance)i)));
/* 465 */           box.NL();
/* 466 */           super.hover(box, i, rx, ry);
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\furnisher\FurnisherStat.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */