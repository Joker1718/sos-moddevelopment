/*     */ package settlement.room.infra.importt;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.Dictionary;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.GETTER;
/*     */ import util.gui.common.UIPickerRes;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GMeter;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.UIRoomBulkApplier;
/*     */ import view.sett.ui.room.UIRoomModule;
/*     */ import view.ui.goods.UIGoodsImport;
/*     */ 
/*     */ class Gui extends UIRoomModule.UIRoomModuleImp<ImportInstance, ROOM_IMPORT> {
/*  43 */   private static CharSequence ¤¤TotalSpace = "¤Total Space";
/*  44 */   private static CharSequence ¤¤UsedSpace = "¤Used Space";
/*  45 */   private static CharSequence ¤¤Incoming = "¤Incoming Wares";
/*  46 */   private static CharSequence ¤¤Accepting = "¤Accepting";
/*     */   
/*     */   static {
/*  49 */     D.ts(Gui.class);
/*     */   }
/*     */   
/*     */   Gui(ROOM_IMPORT s) {
/*  53 */     super(s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendPanel(GuiSection section, GGrid grid, final GETTER<ImportInstance> g, int x1, int y1) {
/*  59 */     RENDEROBJ r = null;
/*     */     
/*  61 */     grid = new GGrid(section, section.body().width() + 100, 2, 0, section.getLastY2() + 8);
/*     */     
/*  63 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  67 */           GFORMAT.i(text, ((ImportInstance)g.get()).capacity());
/*     */         }
/*  69 */       }).hh(¤¤TotalSpace);
/*  70 */     grid.add((RENDEROBJ)hOVERABLE);
/*     */     
/*  72 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  76 */           int am = ((ImportInstance)g.get()).amount();
/*  77 */           GFORMAT.i(text, am);
/*     */         }
/*  79 */       }).hh(¤¤UsedSpace);
/*  80 */     grid.add((RENDEROBJ)hOVERABLE);
/*     */     
/*  82 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/*  86 */           GFORMAT.i(text, ((ImportInstance)g.get()).spaceReserved());
/*     */         }
/*  88 */       }).hh(¤¤Incoming);
/*  89 */     grid.add((RENDEROBJ)hOVERABLE);
/*     */     
/*  91 */     if ((S.get()).developer) {
/*  92 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/*  96 */             ImportInstance i = (ImportInstance)g.get();
/*  97 */             int res = 0;
/*  98 */             for (COORDINATE c : i.body()) {
/*  99 */               if (i.is(c)) {
/* 100 */                 res += ((ROOM_IMPORT)Gui.this.blueprint).UNLOADER.reserved(i.resource(), c);
/*     */               }
/*     */             } 
/*     */             
/* 104 */             GFORMAT.iBig(text, res);
/*     */           }
/* 106 */         }).hh("reserved crates");
/* 107 */       grid.add((RENDEROBJ)hOVERABLE);
/*     */       
/* 109 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 113 */             ImportInstance i = (ImportInstance)g.get();
/* 114 */             RESOURCE r = i.resource();
/* 115 */             if (r != null) {
/* 116 */               GFORMAT.iBig(text, ((ROOM_IMPORT)Gui.this.blueprint).tally.amount.get(r));
/*     */             }
/*     */           }
/* 119 */         }).hh("t amount");
/* 120 */       grid.add((RENDEROBJ)hOVERABLE);
/*     */       
/* 122 */       hOVERABLE = (new GStat()
/*     */         {
/*     */           public void update(GText text)
/*     */           {
/* 126 */             ImportInstance i = (ImportInstance)g.get();
/* 127 */             RESOURCE r = i.resource();
/* 128 */             if (r != null) {
/* 129 */               GFORMAT.iBig(text, ((ROOM_IMPORT)Gui.this.blueprint).tally.capacity.get(r));
/*     */             }
/*     */           }
/* 132 */         }).hh("t capacity");
/* 133 */       grid.add((RENDEROBJ)hOVERABLE);
/*     */     } 
/*     */ 
/*     */     
/* 137 */     section.body().incrW(48.0D);
/*     */     
/* 139 */     section.addRelBody(8, DIR.S, (RENDEROBJ)new GHeader(¤¤Accepting));
/*     */     
/* 141 */     final UIPickerRes pop = new UIPickerRes(true)
/*     */       {
/*     */         protected void select(RESOURCE r, int li)
/*     */         {
/* 145 */           ((ImportInstance)g.get()).allocate(r);
/* 146 */           (VIEW.inters()).popup.close();
/*     */         }
/*     */ 
/*     */         
/*     */         protected RESOURCE getResource() {
/* 151 */           return ((ImportInstance)g.get()).resource();
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void hoverResource(RESOURCE res, GBox b) {
/* 157 */           FACTIONS.player().buyer((TRADABLE)TR.get(res)).hover((GUI_BOX)b);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 162 */     SPRITE.Imp imp = new SPRITE.Imp(24)
/*     */       {
/*     */         public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */         {
/* 166 */           if (((ImportInstance)g.get()).resource() != null) {
/* 167 */             ((ImportInstance)g.get()).resource().icon().render(r, X1, X2, Y1, Y2);
/*     */           } else {
/* 169 */             (SPRITES.icons()).m.questionmark.render(r, X1, X2, Y1, Y2);
/*     */           } 
/*     */         }
/*     */       };
/* 173 */     section.addRelBody(2, DIR.S, (RENDEROBJ)new GButt.ButtPanel((SPRITE)imp)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 177 */             (VIEW.inters()).popup.show((RENDEROBJ)pop, (CLICKABLE)this, true);
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 186 */     final UIGoodsImport ex = new UIGoodsImport();
/* 187 */     CLICKABLE.ClickWrap s = new CLICKABLE.ClickWrap((RENDEROBJ)ex)
/*     */       {
/*     */         protected RENDEROBJ pget()
/*     */         {
/* 191 */           if (((ImportInstance)g.get()).resource() == null)
/* 192 */             return null; 
/* 193 */           ex.res.set(((ImportInstance)g.get()).resource().tr());
/* 194 */           return (RENDEROBJ)ex;
/*     */         }
/*     */       };
/*     */     
/* 198 */     section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendMain(GGrid grid, GGrid text, GuiSection sExtra) {
/* 209 */     RENDEROBJ r = null;
/*     */     
/* 211 */     HOVERABLE hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 215 */           int am = 0;
/* 216 */           for (RESOURCE r : RESOURCES.ALL())
/* 217 */             am += ((ROOM_IMPORT)Gui.this.blueprint).tally.capacity.get(r); 
/* 218 */           GFORMAT.i(text, am);
/*     */         }
/* 220 */       }).hh(¤¤TotalSpace);
/* 221 */     text.add((RENDEROBJ)hOVERABLE);
/*     */     
/* 223 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 227 */           int am = 0;
/* 228 */           for (RESOURCE r : RESOURCES.ALL())
/* 229 */             am += ((ROOM_IMPORT)Gui.this.blueprint).tally.amount.get(r); 
/* 230 */           GFORMAT.i(text, am);
/*     */         }
/* 232 */       }).hh(¤¤UsedSpace);
/* 233 */     text.add((RENDEROBJ)hOVERABLE);
/*     */     
/* 235 */     hOVERABLE = (new GStat()
/*     */       {
/*     */         public void update(GText text)
/*     */         {
/* 239 */           int am = 0;
/* 240 */           for (RESOURCE r : RESOURCES.ALL())
/* 241 */             am += (SETT.HALFENTS()).caravans.deliveries(r, null); 
/* 242 */           GFORMAT.i(text, am);
/*     */         }
/* 244 */       }).hh(¤¤Incoming);
/* 245 */     text.add((RENDEROBJ)hOVERABLE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableButt(GuiSection s, final GETTER<RoomInstance> ins) {
/* 252 */     s.add((SPRITE)new SPRITE.Imp(16)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 256 */             RESOURCE ro = ((ImportInstance)ins.get()).resource();
/* 257 */             SPRITE s = (ro == null) ? (SPRITE)(SPRITES.icons()).s.cancel : (ro.icon()).small;
/* 258 */             s.render(r, X1, Y1);
/*     */           }
/* 260 */         }0, s.body().y2());
/*     */     
/* 262 */     s.addRightC(8, (SPRITE)new SPRITE.Imp(s.body().width() - 8 - s.getLastX2(), 12)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 266 */             ImportInstance in = (ImportInstance)ins.get();
/*     */             
/* 268 */             double t = in.capacity();
/* 269 */             double n = in.amount();
/* 270 */             double i = in.spaceReserved();
/* 271 */             GMeter.renderDelta(r, n / t, (n + i) / 2.0D, X1, X2, Y1, Y2);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hover(GBox box, ImportInstance i) {
/* 279 */     super.hover(box, i);
/* 280 */     if (i.resource() != null) {
/* 281 */       box.setResource(i.resource(), i.amount(), i.capacity());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/* 288 */     final CharSequence none = "--";
/* 289 */     GTableSorter.GTSort<RoomInstance> s = new GTableSorter.GTSort<RoomInstance>(Dic.¤¤Resource)
/*     */       {
/*     */         public int cmp(RoomInstance current, RoomInstance cmp)
/*     */         {
/* 293 */           return Dictionary.compare(name(current), name(cmp));
/*     */         }
/*     */ 
/*     */         
/*     */         public void format(RoomInstance h, GText text) {
/* 298 */           text.add(name(h));
/*     */         }
/*     */         
/*     */         private CharSequence name(RoomInstance ins) {
/* 302 */           if (ins != null && ins instanceof ImportInstance) {
/* 303 */             ImportInstance i = (ImportInstance)ins;
/* 304 */             if (i.resource() == null)
/* 305 */               return none; 
/* 306 */             return (i.resource()).name;
/*     */           } 
/* 308 */           return none;
/*     */         }
/*     */       };
/*     */     
/* 312 */     sorts.add(s);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\infra\importt\Gui.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */