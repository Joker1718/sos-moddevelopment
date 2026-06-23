/*     */ package settlement.room.military.training;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.room.industry.module.IndustryUtil;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GGaugeMutable;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.info.GFORMAT;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ final class Gui extends UIRoomModule {
/*  25 */   private static CharSequence ¤¤Limit = "¤Recruits limit";
/*  26 */   private static CharSequence ¤¤LimitD = "¤The number of recruits that you allow to train simultaneously.";
/*     */   
/*  28 */   private static CharSequence ¤¤speed = "¤Training Speed";
/*  29 */   private static CharSequence ¤¤speedD = "¤The speed at which subjects are trained.";
/*  30 */   private static CharSequence ¤¤maxLevel = "¤Days to reach max level: "; private final ROOM_M_TRAINER<?> blueprint;
/*     */   
/*     */   static {
/*  33 */     D.ts(Gui.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Gui(ROOM_M_TRAINER<?> blueprint) {
/*  39 */     this.blueprint = blueprint;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void appendPanel(GuiSection section, final GETTER<RoomInstance> getter, int x1, int y1) {
/*  45 */     final INT.INTE t = new INT.INTE()
/*     */       {
/*     */         
/*     */         public int min()
/*     */         {
/*  50 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/*  55 */           return ((RoomInstance)getter.get()).employees().max();
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/*  60 */           return ((RoomInstance)getter.get()).employees().target();
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/*  65 */           ((RoomInstance)getter.get()).employees().neededSet(t);
/*     */         }
/*     */       };
/*     */     
/*  69 */     GGaugeMutable m = new GGaugeMutable((DOUBLE.DOUBLE_MUTABLE)t, 220)
/*     */       {
/*     */         protected int setInfo(DOUBLE d, GText text) {
/*  72 */           GFORMAT.i(text, t.get());
/*  73 */           return 48;
/*     */         }
/*     */       };
/*  76 */     m.hoverInfoSet(¤¤LimitD);
/*     */     
/*  78 */     section.addRelBody(8, DIR.S, (RENDEROBJ)(new GHeader(¤¤Limit)).hoverInfoSet(¤¤LimitD));
/*  79 */     section.addRelBody(4, DIR.S, (RENDEROBJ)m);
/*     */     
/*  81 */     GStat ss = new GStat()
/*     */       {
/*     */         
/*     */         public void update(GText text)
/*     */         {
/*  86 */           GFORMAT.perc(text, get());
/*     */         }
/*     */         
/*     */         double get() {
/*  90 */           return IndustryUtil.calcProductionRate(1.0D, null, Gui.this.blueprint.bonus(), (RoomInstance)getter.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/*  95 */           b.title(Gui.¤¤speed);
/*  96 */           b.text(Gui.¤¤speedD);
/*     */           
/*  98 */           IndustryUtil.hoverProductionRate((GUI_BOX)b, 1.0D, null, Gui.this.blueprint.bonus(), (RoomInstance)getter.get());
/*     */           
/* 100 */           b.NL(8);
/* 101 */           b.textLL(Gui.¤¤maxLevel);
/*     */           
/* 103 */           double d = get();
/* 104 */           int am = (int)Math.ceil(Gui.this.blueprint.TRAINING_DAYS / d);
/*     */           
/* 106 */           b.add((SPRITE)GFORMAT.i(b.text(), am));
/*     */         }
/*     */       };
/*     */     
/* 110 */     section.addRelBody(8, DIR.S, (RENDEROBJ)ss.hv(¤¤speed));
/*     */   }
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
/*     */   public void appendManageScr(GGrid icons, GGrid text, GuiSection extra) {
/* 129 */     GuiSection s = new GuiSection();
/*     */     
/* 131 */     INT.INTE t = new INT.INTE()
/*     */       {
/*     */         public int min()
/*     */         {
/* 135 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max() {
/* 140 */           return 40000;
/*     */         }
/*     */ 
/*     */         
/*     */         public int get() {
/* 145 */           return Gui.this.blueprint.trainingLimit;
/*     */         }
/*     */ 
/*     */         
/*     */         public void set(int t) {
/* 150 */           Gui.this.blueprint.trainingLimit = t;
/*     */         }
/*     */       };
/*     */     
/* 154 */     s.addRelBody(0, DIR.S, (RENDEROBJ)(new GHeader(¤¤Limit)).hoverInfoSet(¤¤LimitD));
/* 155 */     s.addRelBody(0, DIR.S, (RENDEROBJ)new GSliderInt(t, 200, true));
/*     */     
/* 157 */     GStat ss = new GStat()
/*     */       {
/*     */         
/*     */         public void update(GText text)
/*     */         {
/* 162 */           GFORMAT.perc(text, get());
/*     */         }
/*     */         
/*     */         double get() {
/* 166 */           double d = Gui.this.blueprint.bonus().get((BOOSTABLE_O)HCLASS_RACE.clP(null, null));
/* 167 */           return d;
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 172 */           b.title(Gui.¤¤speed);
/* 173 */           b.text(Gui.¤¤speedD);
/* 174 */           b.NL(4);
/* 175 */           Gui.this.blueprint.bonus().hover((GUI_BOX)b, (BOOSTABLE_O)HCLASS_RACE.clP(null, null), true);
/*     */ 
/*     */           
/* 178 */           b.NL(8);
/* 179 */           b.textLL(Gui.¤¤maxLevel);
/*     */           
/* 181 */           double d = get();
/* 182 */           int am = (int)Math.ceil(Gui.this.blueprint.TRAINING_DAYS / d);
/*     */           
/* 184 */           b.add((SPRITE)GFORMAT.i(b.text(), am));
/*     */         }
/*     */       };
/*     */     
/* 188 */     s.addRelBody(8, DIR.S, (RENDEROBJ)ss.hv(¤¤speed));
/*     */     
/* 190 */     text.section.addRelBody(0, DIR.S, (RENDEROBJ)s);
/*     */     
/* 192 */     super.appendManageScr(icons, text, extra);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\military\training\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */