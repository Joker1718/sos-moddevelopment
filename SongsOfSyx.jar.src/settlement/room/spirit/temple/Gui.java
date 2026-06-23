/*     */ package settlement.room.spirit.temple;
/*     */ 
/*     */ import init.type.HTYPES;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<TempleInstance, ROOM_TEMPLE> {
/*  27 */   private static CharSequence ¤¤Respect = "The respect value of this temple. It is a combination of Sacrifices, room layout and priests.";
/*  28 */   private static CharSequence ¤¤Sacrifice = "¤Sacrificing";
/*  29 */   private static CharSequence ¤¤SacrificeD = "¤Sacrificed";
/*  30 */   private static CharSequence ¤¤SacrificeYearD = "¤Sacrificed this year.";
/*  31 */   private static CharSequence ¤¤SacrificingD = "¤How well this temple is sacrificing. In order to sacrifice, the priests must have access to resources. The temple requires {0} sacrifices per day.";
/*  32 */   private static CharSequence ¤¤SacrificingHuman = "¤This temple sacrifices prisoners. Currently there is a supply of {0} prisoners.";
/*  33 */   private static CharSequence ¤¤SacrificingAnimal = "¤This temple sacrifices animals. Livestock is needed";
/*  34 */   private static CharSequence ¤¤SacrificingResource = "This temple sacrifices {0}.";
/*  35 */   private static CharSequence ¤¤NoSacrifices = "No sacrifices are available!";
/*  36 */   private static CharSequence ¤¤PriestsD = "The staffing of this temple. Has an effect on respect. Temples must be fully staffed.";
/*     */   
/*     */   static {
/*  39 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   public Gui(ROOM_TEMPLE s) {
/*  43 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<TempleInstance> getter, int x1, int y1) {
/*  49 */     ((ROOM_TEMPLE)this.blueprint).constructor.decor.appendPanel(section, grid, getter, x1, y1);
/*  50 */     ((ROOM_TEMPLE)this.blueprint).constructor.grandure.appendPanel(section, grid, getter, x1, y1);
/*  51 */     ((ROOM_TEMPLE)this.blueprint).constructor.space.appendPanel(section, grid, getter, x1, y1);
/*  52 */     grid.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text) {
/*  55 */             GFORMAT.perc(text, ((TempleInstance)getter.get()).sacrificeValue());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  61 */             GText t = b.text();
/*  62 */             t.add(Gui.¤¤SacrificingD);
/*  63 */             t.insert(0, ((TempleInstance)getter.get()).jobs.size() * (((TempleInstance)getter.get()).blueprintI()).STIME * 0.5D, 2);
/*  64 */             b.add((SPRITE)t);
/*     */             
/*  66 */             b.NL(8);
/*  67 */             if (((ROOM_TEMPLE)Gui.this.blueprint).altar instanceof TempleAltar.Resource) {
/*  68 */               t = b.text();
/*  69 */               t.add(Gui.¤¤SacrificingResource);
/*  70 */               t.insert(0, ((ROOM_TEMPLE)Gui.this.blueprint).resource.name);
/*  71 */               b.add((SPRITE)t);
/*  72 */             } else if (((ROOM_TEMPLE)Gui.this.blueprint).altar instanceof TempleAltar.Animal) {
/*  73 */               t = b.text();
/*  74 */               t.add(Gui.¤¤SacrificingAnimal);
/*  75 */               t.insert(0, ((ROOM_TEMPLE)Gui.this.blueprint).resource.name);
/*  76 */               b.add((SPRITE)t);
/*  77 */             } else if (((ROOM_TEMPLE)Gui.this.blueprint).altar instanceof TempleAltar.Prisoner) {
/*  78 */               t = b.text();
/*  79 */               t.add(Gui.¤¤SacrificingHuman);
/*  80 */               t.insert(0, STATS.POP().pop(HTYPES.PRISONER()));
/*  81 */               b.add((SPRITE)t);
/*     */             
/*     */             }
/*     */           
/*     */           }
/*  86 */         }).hh(¤¤Sacrifice));
/*     */     
/*  88 */     grid.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text) {
/*  91 */             double d = ((TempleInstance)getter.get()).employees().employed() / ((TempleInstance)getter.get()).employees().target();
/*  92 */             GFORMAT.perc(text, d);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/*  97 */             b.text(Gui.¤¤PriestsD);
/*  98 */             b.NL(8);
/*     */           }
/* 100 */         }).hh(((ROOM_TEMPLE)this.blueprint).constructor.priests.name()));
/*     */     
/* 102 */     grid.add((RENDEROBJ)(new GStat()
/*     */         {
/*     */           public void update(GText text) {
/* 105 */             GFORMAT.i(text, ((TempleInstance)getter.get()).consumed);
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 110 */             b.text(Gui.¤¤SacrificeYearD);
/* 111 */             b.NL(8);
/*     */           }
/* 113 */         }).hh(¤¤SacrificeD));
/*     */     
/* 115 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text) {
/* 118 */           GFORMAT.perc(text, ((TempleInstance)getter.get()).respect());
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GBox b) {
/* 123 */           b.text(Gui.¤¤Respect);
/* 124 */           b.NL(8);
/*     */         }
/* 126 */       }).hv(((STATS.RELIGION()).TEMPLE.QUALITY.info()).name);
/*     */     
/* 128 */     section.addRelBody(16, DIR.S, (RENDEROBJ)hOVERABLE);
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
/*     */   protected void hover(GBox box, TempleInstance i) {
/* 140 */     super.hover(box, i);
/* 141 */     box.NL(8);
/* 142 */     box.textLL(¤¤Sacrifice);
/* 143 */     box.add((SPRITE)GFORMAT.perc(box.text(), i.sacrificeValue()));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void problem(TempleInstance i, Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings) {
/* 148 */     if (!i.resHas)
/* 149 */       errors.add(¤¤NoSacrifices); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\spirit\temple\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */