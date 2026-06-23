/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.UI.UI;
/*     */ import java.util.Arrays;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintImp;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ 
/*     */ final class ModuleUpgradable
/*     */   implements Modules.ModuleMaker
/*     */ {
/*  39 */   private final CharSequence ¤¤UPGRADE_ALL = "¤Upgrade all";
/*  40 */   private final CharSequence ¤¤UPGRADE_ALL_DESC = "¤Upgrade all rooms once. Upgrading a room significantly increases performance. It costs a lot of resources initially that will be deducted from warehouses, and also in maintenance over time.";
/*  41 */   private final CharSequence ¤¤UPGRADABLE = "¤Upgradable:";
/*  42 */   private final CharSequence ¤¤UPGRADE = "¤Upgrade";
/*  43 */   private final CharSequence ¤¤UPGRADE_MAX_REACHED = "¤Maximally Upgraded.";
/*     */   
/*  45 */   private final CharSequence ¤¤DOWNGRADED = "¤Downgrade this room. All resources will be lost.";
/*     */   
/*     */   ModuleUpgradable(Init init) {
/*  48 */     D.t(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void make(RoomBlueprint p, LISTE<UIRoomModule> l) {
/*  54 */     if (p instanceof RoomBlueprintIns) {
/*  55 */       RoomBlueprintIns<?> pi = (RoomBlueprintIns)p;
/*  56 */       if (pi.upgrades().max() > 0) {
/*  57 */         l.add(new I(pi));
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private class I
/*     */     extends UIRoomModule
/*     */   {
/*     */     private final RoomBlueprintIns<?> blueprint;
/*     */     
/*     */     I(RoomBlueprintIns<?> blue) {
/*  68 */       this.blueprint = blue;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendManageScr(GGrid grid, GGrid text, GuiSection sExta) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/*  82 */       appliers.add(new UIRoomBulkApplier((CharSequence)new Str(ModuleUpgradable.this.¤¤UPGRADE_ALL))
/*     */           {
/*  84 */             private final int[] res = Alloc.ii(16);
/*     */ 
/*     */             
/*     */             protected void apply(RoomInstance ii) {
/*     */               int i;
/*  89 */               if (ii.upgrade() >= ModuleUpgradable.I.this.blueprint.upgrades().max() || !ii.blueprintI().upgrades().requires(ii.upgrade() + 1).passes(FACTIONS.player()))
/*     */                 return; 
/*  91 */               boolean okk = true; int ri;
/*  92 */               for (ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/*  93 */                 int am = ii.resAmount(ri, ii.upgrade() + 1) - ii.resAmount(ri, ii.upgrade());
/*  94 */                 i = okk & ((((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(ri)) >= am) ? 1 : 0);
/*     */               } 
/*     */               
/*  97 */               if (i != 0) {
/*  98 */                 for (ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/*  99 */                   int am = ii.resAmount(ri, ii.upgrade() + 1) - ii.resAmount(ri, ii.upgrade());
/* 100 */                   ModuleUpgradable.I.this.blueprint.constructor().resource(ri).remove(am, FResources.RTYPE.CONSTRUCTION);
/*     */                 } 
/* 102 */                 ii.upgradeSet(ii.upgrade() + 1);
/*     */               } 
/*     */             }
/*     */ 
/*     */             
/*     */             protected void hover(GBox b) {
/* 108 */               b.title((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADE_ALL);
/* 109 */               b.text((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADE_ALL_DESC);
/* 110 */               b.NL(8);
/*     */               
/* 112 */               Arrays.fill(this.res, 0);
/*     */               
/* 114 */               int ok = 0;
/* 115 */               for (int i = 0; i < ModuleUpgradable.I.this.blueprint.instancesSize(); i++) {
/* 116 */                 RoomInstance ii = ModuleUpgradable.I.this.blueprint.getInstance(i);
/*     */                 
/* 118 */                 if (ii.upgrade() < ModuleUpgradable.I.this.blueprint.upgrades().max() && ii.blueprintI().upgrades().requires(ii.upgrade() + 1).passes(FACTIONS.player())) {
/* 119 */                   boolean okk = true; int j;
/* 120 */                   for (j = 0; j < ModuleUpgradable.I.this.blueprint.constructor().resources(); j++) {
/* 121 */                     int am = ii.resAmount(j, ii.upgrade() + 1) - ii.resAmount(j, ii.upgrade());
/* 122 */                     if (((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(j)) < this.res[j] + am)
/*     */                     {
/*     */                       
/* 125 */                       okk = false;
/*     */                     }
/*     */                   } 
/*     */                   
/* 129 */                   if (okk) {
/* 130 */                     ok++;
/* 131 */                     for (j = 0; j < ModuleUpgradable.I.this.blueprint.constructor().resources(); j++) {
/* 132 */                       int am = ii.resAmount(j, ii.upgrade() + 1) - ii.resAmount(j, ii.upgrade());
/* 133 */                       this.res[j] = this.res[j] + am;
/*     */                     } 
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */ 
/*     */               
/* 140 */               for (int ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/* 141 */                 if (this.res[ri] > 0) {
/* 142 */                   b.add((SPRITE)ModuleUpgradable.I.this.blueprint.constructor().resource(ri).icon());
/* 143 */                   b.add((SPRITE)GFORMAT.iIncr(b.text(), -this.res[ri]));
/* 144 */                   b.NL();
/*     */                 } 
/*     */               } 
/*     */               
/* 148 */               b.NL(8);
/*     */               
/* 150 */               b.textL((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADABLE);
/* 151 */               b.add((SPRITE)GFORMAT.iofkInv(b.text(), ok, ModuleUpgradable.I.this.blueprint.instancesSize()));
/*     */             }
/*     */           });
/*     */     }
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
/*     */     public void appendButt(GuiSection s, GETTER<RoomInstance> get) {}
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
/*     */     public void hover(GBox box, Room room, int rx, int ry) {
/* 189 */       box.NL(4);
/* 190 */       box.add((SPRITE)(UI.icons()).s.arrowUp);
/* 191 */       box.textL(Dic.¤¤Upgrade);
/* 192 */       box.tab(6);
/* 193 */       RoomBlueprintImp b = (RoomBlueprintImp)room.blueprint();
/* 194 */       box.add((SPRITE)GFORMAT.iofk(box.text(), room.upgrade(rx, ry), b.upgrades().max()));
/* 195 */       box.NL();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendPanel(GuiSection section, final GETTER<RoomInstance> get, int x1, int y1) {
/* 201 */       GButt.ButtPanel buttPanel = new GButt.ButtPanel((SPRITE)(UI.icons()).m.arrow_down)
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text)
/*     */           {
/* 205 */             text.text((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤DOWNGRADED);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 210 */             ModuleUpgradable.I.access$0(ModuleUpgradable.I.this).downGrade(ModuleUpgradable.I.this.g(get));
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 215 */             activeSet((ModuleUpgradable.I.this.g(get).upgrade() > 0));
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 220 */       GButt.BSection b = new GButt.BSection()
/*     */         {
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 223 */             GBox b = (GBox)text;
/* 224 */             text.title((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADE);
/*     */             
/* 226 */             RoomInstance i = (RoomInstance)get.get();
/* 227 */             if (i.upgrade() == ModuleUpgradable.I.this.blueprint.upgrades().max()) {
/* 228 */               text.text((ModuleUpgradable.I.access$0(ModuleUpgradable.I.this)).¤¤UPGRADE_MAX_REACHED);
/*     */               
/*     */               return;
/*     */             } 
/* 232 */             if (ModuleUpgradable.I.this.blueprint.upgrades().desc(ModuleUpgradable.I.this.g(get).upgrade() + 1) != null) {
/* 233 */               b.text(ModuleUpgradable.I.this.blueprint.upgrades().desc(ModuleUpgradable.I.this.g(get).upgrade() + 1));
/* 234 */             } else if (i instanceof settlement.room.service.module.ROOM_SERVICER) {
/* 235 */               b.textLL(Dic.¤¤Quality);
/* 236 */               double d = 1.0D / (i.blueprintI().upgrades().max() + 1.0D);
/* 237 */               b.add((SPRITE)GFORMAT.percInc(b.text(), d));
/* 238 */             } else if (ModuleUpgradable.I.this.blueprint.bonus() != null) {
/* 239 */               b.textLL((ModuleUpgradable.I.this.blueprint.bonus()).name);
/* 240 */               b.add((SPRITE)GFORMAT.f0(b.text(), ModuleUpgradable.I.this.blueprint.upgrades().boost(ModuleUpgradable.I.this.g(get).upgrade() + 1) - ModuleUpgradable.I.this.blueprint.upgrades().boost(ModuleUpgradable.I.this.g(get).upgrade())));
/*     */             } 
/*     */             
/* 243 */             b.NL(8);
/*     */             
/* 245 */             ModuleUpgradable.I.this.g(get).blueprintI().upgrades().requires(ModuleUpgradable.I.this.g(get).upgrade() + 1).hover(text, FACTIONS.player());
/*     */             
/* 247 */             b.NL(8);
/*     */             
/* 249 */             for (int ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/* 250 */               int am = ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade() + 1) - ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade());
/* 251 */               if (am > 0) {
/* 252 */                 b.add((SPRITE)ModuleUpgradable.I.this.blueprint.constructor().resource(ri).icon());
/* 253 */                 GText t = b.text();
/* 254 */                 GFORMAT.iIncr(t, -am);
/* 255 */                 if (am > ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(ri))) {
/* 256 */                   t.errorify();
/*     */                 } else {
/* 258 */                   t.normalify();
/* 259 */                 }  b.add((SPRITE)t);
/*     */                 
/* 261 */                 t = b.text();
/* 262 */                 t.add('(');
/* 263 */                 GFORMAT.i(t, ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(ri)));
/* 264 */                 t.add(')');
/* 265 */                 b.add((SPRITE)t);
/* 266 */                 b.NL();
/*     */               } 
/*     */             } 
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           protected void clickA() {
/* 274 */             if (ModuleUpgradable.I.this.g(get).upgrade() >= ModuleUpgradable.I.this.blueprint.upgrades().max()) {
/*     */               return;
/*     */             }
/* 277 */             for (int ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/* 278 */               int am = ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade() + 1) - ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade());
/* 279 */               if (am > 0) {
/* 280 */                 ModuleUpgradable.I.this.blueprint.constructor().resource(ri).remove(am, FResources.RTYPE.CONSTRUCTION);
/*     */               }
/*     */             } 
/*     */             
/* 284 */             ModuleUpgradable.I.this.g(get).upgradeSet(ModuleUpgradable.I.this.g(get).upgrade() + 1);
/* 285 */             super.clickA();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 290 */             activeSet(true);
/*     */             
/* 292 */             if (ModuleUpgradable.I.this.g(get).upgrade() >= ModuleUpgradable.I.this.blueprint.upgrades().max()) {
/* 293 */               activeSet(false);
/*     */               return;
/*     */             } 
/* 296 */             if ((S.get()).developer)
/*     */               return; 
/* 298 */             if (!ModuleUpgradable.I.this.g(get).blueprintI().upgrades().requires(ModuleUpgradable.I.this.g(get).upgrade() + 1).passes(FACTIONS.player())) {
/* 299 */               activeSet(false);
/*     */             }
/*     */             
/* 302 */             for (int ri = 0; ri < ModuleUpgradable.I.this.blueprint.constructor().resources(); ri++) {
/* 303 */               int am = ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade() + 1) - ModuleUpgradable.I.this.g(get).resAmount(ri, ModuleUpgradable.I.this.g(get).upgrade());
/* 304 */               if (am > ((SETT.ROOMS()).STOCKPILE.tally()).amountReservable.get(ModuleUpgradable.I.this.blueprint.constructor().resource(ri))) {
/* 305 */                 activeSet(false);
/*     */                 break;
/*     */               } 
/*     */             } 
/*     */           }
/*     */         };
/* 311 */       b.body().setHeight(((GButt)buttPanel).body.height());
/* 312 */       b.body().incrW(8.0D);
/* 313 */       b.addCentredY((SPRITE)(new GText((UI.FONT()).S, ModuleUpgradable.this.¤¤UPGRADE)).lablifySub(), 8);
/* 314 */       b.addRightC(10, (SPRITE)new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 318 */               GFORMAT.iofk(text, ModuleUpgradable.I.this.g(get).upgrade(), ModuleUpgradable.I.this.blueprint.upgrades().max());
/* 319 */               text.lablify();
/*     */             }
/*     */           });
/*     */       
/* 323 */       b.body().incrW(64.0D);
/*     */       
/* 325 */       GuiSection s = new GuiSection();
/* 326 */       s.add((RENDEROBJ)b);
/*     */ 
/*     */       
/* 329 */       s.addRight(0, (RENDEROBJ)buttPanel);
/*     */       
/* 331 */       section.addRelBody(8, DIR.S, (RENDEROBJ)s);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private RoomInstance g(GETTER<RoomInstance> g) {
/* 338 */       return (RoomInstance)g.get();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void downGrade(RoomInstance ins) {
/* 346 */     if (ins.upgrade() <= 0)
/*     */       return; 
/* 348 */     ins.upgradeSet(ins.upgrade() - 1);
/*     */     
/* 350 */     for (COORDINATE c : ins.body()) {
/* 351 */       if (ins.is(c) && (SETT.MAINTENANCE()).isser.is(c)) {
/* 352 */         RESOURCE res = (RESOURCE)(SETT.MAINTENANCE()).resource.get(c);
/* 353 */         if (res != null && !hasRes(ins, res)) {
/* 354 */           SETT.MAINTENANCE().maintain(c.x(), c.y());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean hasRes(RoomInstance ins, RESOURCE res) {
/* 362 */     for (int ri = 0; ri < ins.blueprintI().constructor().resources(); ri++) {
/* 363 */       if (ins.blueprintI().constructor().resource(ri) == res) {
/* 364 */         return ins.blueprintI().constructor().resourceHas(ri, ins.upgrade());
/*     */       }
/*     */     } 
/* 367 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleUpgradable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */