/*     */ package view.sett.ui.room;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import game.time.TIMECYCLE;
/*     */ import init.resources.RESOURCE;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.environment.Foundation;
/*     */ import settlement.main.SETT;
/*     */ import settlement.maintenance.ROOM_DEGRADER;
/*     */ import settlement.room.main.Room;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.room.main.placement.UtilExtraCost;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.Stack;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.GETTER;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.gui.misc.GHeader;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.table.GTableSorter;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ 
/*     */ final class ModuleDegrade
/*     */   implements Modules.ModuleMaker {
/*  37 */   private static CharSequence ¤¤DEGRADE_AVE = "¤Average degradation amongst these rooms. Degradation affects a room negatively.";
/*  38 */   private static CharSequence ¤¤RoomType = "¤Room Type";
/*  39 */   private static CharSequence ¤¤Lock = "¤The technology for the room is locked, and it can't be maintained.";
/*  40 */   private static CharSequence ¤¤badIsolation = "¤Room is poorly insulated!";
/*  41 */   private static CharSequence ¤¤cost = "¤Support";
/*  42 */   private static CharSequence ¤¤maintenance = "¤Required Maintenance (year)";
/*     */   
/*     */   static {
/*  45 */     D.ts(ModuleDegrade.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModuleDegrade(Init init) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void make(RoomBlueprint p, LISTE<UIRoomModule> l) {
/*  56 */     if (p instanceof RoomBlueprintIns) {
/*  57 */       RoomBlueprintIns<?> pp = (RoomBlueprintIns)p;
/*  58 */       if (pp.degrades()) {
/*  59 */         l.add(new Hover());
/*  60 */         l.add(new I(pp));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private final class Hover
/*     */     extends UIRoomModule
/*     */   {
/*     */     public void hover(GBox box, Room room, int rx, int ry) {
/*  70 */       if (room.degrader(rx, ry) != null) {
/*  71 */         box.text(Dic.¤¤Degrade);
/*  72 */         box.add((SPRITE)GFORMAT.percInv(box.text(), room.getDegrade(rx, ry)));
/*  73 */         box.add((SPRITE)(UI.icons()).s.hammer);
/*  74 */         box.add((SPRITE)GFORMAT.i(box.text(), room.degrader(rx, ry).jobs()));
/*  75 */         box.NL(2);
/*  76 */         if (!(room.constructor().blue()).reqs.passes(FACTIONS.player())) {
/*  77 */           box.error(ModuleDegrade.¤¤Lock);
/*  78 */         } else if (room.upgrade(rx, ry) > 0 && !room.constructor().blue().upgrades().requires(room.upgrade(rx, ry)).passes(FACTIONS.player())) {
/*  79 */           box.error(ModuleDegrade.¤¤Lock);
/*  80 */         }  box.NL(2);
/*     */       } 
/*  82 */       if (room.constructor() != null && room.constructor().needsIsolation()) {
/*  83 */         box.text((SETT.ROOMS()).isolation.info.name);
/*  84 */         box.add((SPRITE)GFORMAT.perc(box.text(), room.isolation(rx, ry)));
/*  85 */         box.NL(2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void problem(Stack<Str> free, LISTE<CharSequence> errors, LISTE<CharSequence> warnings, Room room, int rx, int ry) {
/*  94 */       if (room.getDegrade(rx, ry) > 0.25D) {
/*  95 */         errors.add(Dic.¤¤Degrade);
/*     */       }
/*  97 */       if (room.constructor() != null && room.constructor().mustBeIndoors() && room.isolation(rx, ry) < 1.0D) {
/*  98 */         warnings.add(ModuleDegrade.¤¤badIsolation);
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private final class I
/*     */     extends UIRoomModule
/*     */   {
/*     */     private final RoomBlueprintIns<?> blue;
/*     */     
/*     */     I(RoomBlueprintIns<?> blue) {
/* 110 */       this.blue = blue;
/*     */     }
/*     */ 
/*     */     
/*     */     public void appendManageScr(GGrid grid, GGrid text, GuiSection extra) {
/* 115 */       grid.add((RENDEROBJ)(new GStat()
/*     */           {
/*     */             public void update(GText text)
/*     */             {
/* 119 */               GFORMAT.percInv(text, ModuleDegrade.I.this.blue.degradeAverage());
/*     */             }
/* 122 */           }).hh((SPRITE)(SPRITES.icons()).s.degrade).hoverInfoSet(ModuleDegrade.¤¤DEGRADE_AVE));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendTableFilters(LISTE<GTableSorter.GTFilter<RoomInstance>> filters, LISTE<GTableSorter.GTSort<RoomInstance>> sorts, LISTE<UIRoomBulkApplier> appliers) {
/* 128 */       sorts.add(new GTableSorter.GTSort<RoomInstance>(Dic.¤¤Degrade)
/*     */           {
/*     */             public int cmp(RoomInstance current, RoomInstance cmp)
/*     */             {
/* 132 */               return Double.compare(current.getDegrade(), cmp.getDegrade());
/*     */             }
/*     */ 
/*     */             
/*     */             public void format(RoomInstance h, GText text) {
/* 137 */               GFORMAT.perc(text, h.getDegrade());
/*     */             }
/*     */           });
/*     */       
/* 141 */       sorts.add(new GTableSorter.GTSort<RoomInstance>((SETT.ROOMS()).isolation.info.name)
/*     */           {
/*     */             public int cmp(RoomInstance current, RoomInstance cmp)
/*     */             {
/* 145 */               return Double.compare(current.isolation(current.mX(), current.mY()), cmp.isolation(cmp.mX(), cmp.mY()));
/*     */             }
/*     */ 
/*     */             
/*     */             public void format(RoomInstance h, GText text) {
/* 150 */               GFORMAT.perc(text, h.isolation(h.mX(), h.mY()));
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void appendPanelIcon(LISTE<RENDEROBJ> section, final GETTER<RoomInstance> get) {
/* 160 */       GStat s = new GStat()
/*     */         {
/*     */           public void update(GText text) {
/* 163 */             GFORMAT.percInv(text, ((RoomInstance)get.get()).getDegrade());
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GBox b) {
/* 169 */             b.title(Dic.¤¤Degrade);
/* 170 */             b.text(Dic.¤¤DegradeDesc);
/* 171 */             b.NL();
/* 172 */             b.textLL(Dic.¤¤Current);
/* 173 */             b.tab(6);
/* 174 */             b.add((SPRITE)GFORMAT.percInv(b.text(), ((RoomInstance)get.get()).getDegrade()));
/*     */             
/* 176 */             if ((S.get()).developer) {
/* 177 */               b.add((SPRITE)GFORMAT.f(b.text(), ((RoomInstance)get.get()).degrader(((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mX()).getSecret(), 4));
/*     */             }
/*     */             
/* 180 */             b.NL(4);
/*     */             
/* 182 */             if (!(((RoomInstance)get.get()).constructor().blue()).reqs.passes(FACTIONS.player())) {
/* 183 */               b.error(ModuleDegrade.¤¤Lock);
/* 184 */             } else if (((RoomInstance)get.get()).upgrade() > 0 && !((RoomInstance)get.get()).constructor().blue().upgrades().requires(((RoomInstance)get.get()).upgrade()).passes(FACTIONS.player())) {
/* 185 */               b.error(ModuleDegrade.¤¤Lock);
/*     */             } 
/* 187 */             b.sep();
/* 188 */             b.NL(8);
/*     */             
/* 190 */             RoomInstance ins = (RoomInstance)get.get();
/* 191 */             ROOM_DEGRADER deg = ((RoomInstance)get.get()).degrader(((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mY());
/* 192 */             int area = ins.area();
/* 193 */             double iso = ins.isolation(((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mY());
/* 194 */             double boost = SETT.MAINTENANCE().speed();
/*     */             
/* 196 */             double ram = 0.0D;
/* 197 */             for (int i = 0; i < deg.resSize(); i++) {
/* 198 */               ram += deg.resAmount(i);
/*     */             }
/*     */             
/* 201 */             b.textLL(ModuleDegrade.¤¤maintenance);
/* 202 */             b.NL();
/*     */             
/* 204 */             SETT.MAINTENANCE().getClass(); ModuleDegrade.I.this.col(b, Dic.¤¤Base, '*', 0.020833333333333332D * TIME.years().bitConversion((TIMECYCLE)TIME.days()));
/* 205 */             ModuleDegrade.I.this.col(b, ModuleDegrade.¤¤RoomType, '*', deg.base());
/* 206 */             ModuleDegrade.I.this.col(b, Dic.¤¤Area, '*', area);
/* 207 */             if (ModuleDegrade.I.this.blue.constructor().isHeavy()) {
/* 208 */               ModuleDegrade.I.this.col(b, Foundation.¤¤name, '*', 1.0D + UtilExtraCost.foundation((Room)get.get(), ((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mY()));
/* 209 */               ModuleDegrade.I.this.col(b, ModuleDegrade.¤¤cost, '*', deg.expenseRate() / (1.0D + UtilExtraCost.foundation((Room)get.get(), ((RoomInstance)get.get()).mX(), ((RoomInstance)get.get()).mY())));
/*     */             }
/* 211 */             else if (ModuleDegrade.I.this.blue.constructor().mustBeIndoors() && ModuleDegrade.I.this.blue.constructor().usesArea()) {
/* 212 */               ModuleDegrade.I.this.col(b, ModuleDegrade.¤¤cost, '*', deg.expenseRate());
/*     */             } 
/* 214 */             ModuleDegrade.I.this.col(b, (SETT.ROOMS()).isolation.info.name, '*', 1.0D + (1.0D - iso) * 2.0D);
/* 215 */             ModuleDegrade.I.this.col(b, Dic.¤¤Boosts, '*', boost);
/*     */             
/* 217 */             double tot = ROOM_DEGRADER.rate(boost, deg.base(), iso, ram, ins.area()) * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/* 218 */             double resr = ROOM_DEGRADER.rateResource(boost, deg.base(), iso, ram) * TIME.years().bitConversion((TIMECYCLE)TIME.days());
/*     */             
/* 220 */             b.tab(6);
/* 221 */             b.add((SPRITE)b.text().add('=').s().add((int)(tot - resr)));
/*     */ 
/*     */ 
/*     */             
/* 225 */             b.sep();
/*     */             
/* 227 */             for (int j = 0; j < deg.resSize(); j++) {
/* 228 */               if (deg.resAmount(j) > 0) {
/*     */                 
/* 230 */                 RESOURCE res = deg.res(j);
/* 231 */                 b.add((SPRITE)res.icon());
/* 232 */                 b.textL(res.name);
/* 233 */                 b.tab(6);
/* 234 */                 b.add((SPRITE)GFORMAT.f0(b.text(), -ROOM_DEGRADER.rateResource(boost, deg.base(), iso, deg.resAmount(j)) * TIME.years().bitConversion((TIMECYCLE)TIME.days())));
/* 235 */                 b.NL();
/*     */               } 
/*     */             } 
/* 238 */             b.sep();
/*     */ 
/*     */             
/* 241 */             b.NL(8);
/* 242 */             b.textLL(Dic.¤¤Total);
/* 243 */             b.tab(6);
/* 244 */             b.add((SPRITE)GFORMAT.f(b.text(), tot, 2));
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 251 */       section.add(new GHeader.HeaderHorizontal((SPRITE)(SPRITES.icons()).s.degrade, (SPRITE)s));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private void col(GBox b, CharSequence header, char append, double value) {
/* 259 */       b.textLL(header);
/* 260 */       b.tab(6);
/* 261 */       GText t = b.text();
/* 262 */       t.add(append);
/* 263 */       b.add((SPRITE)GFORMAT.f(t, value, 2));
/* 264 */       b.NL();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\room\ModuleDegrade.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */