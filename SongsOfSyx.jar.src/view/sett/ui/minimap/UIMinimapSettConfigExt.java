/*     */ package view.sett.ui.minimap;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.Savable;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.Icon;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.RoomBlueprint;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.stat.STAT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.OPACITY;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.Bitmap1D;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.data.BOOLEAN;
/*     */ import util.data.BOOLEANO;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.table.GScrollRows;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.IPopCurrent;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public final class UIMinimapSettConfigExt
/*     */   extends UIMinimapSettConfig
/*     */ {
/*  48 */   private static final COLOR good = (COLOR)new ColorImp(0, 0, 127);
/*  49 */   private static final COLOR bad = (COLOR)new ColorImp(127, 0, 0);
/*  50 */   private static final COLOR soso = (COLOR)new ColorImp(127, 127, 0);
/*     */   
/*  52 */   private final BOOLEAN.BOOLEANImp showAnimals = new BOOLEAN.BOOLEANImp(true);
/*  53 */   private final BOOLEAN.BOOLEANImp showGrowable = new BOOLEAN.BOOLEANImp(true);
/*  54 */   private final BOOLEAN.BOOLEANImp showMinerals = new BOOLEAN.BOOLEANImp(true);
/*  55 */   private final BOOLEAN.BOOLEANImp showDiv = new BOOLEAN.BOOLEANImp(true);
/*     */   
/*  57 */   private final Bitmap1D bitsHType = new Bitmap1D(HTYPES.ALL().size(), false);
/*  58 */   private final Bitmap1D bRaces = new Bitmap1D(RACES.all().size(), false);
/*  59 */   private final Bitmap1D bitsRooms = new Bitmap1D((SETT.ROOMS()).AMOUNT_OF_BLUEPRINTS, false);
/*  60 */   private final Bitmap1D bitsEmployed = new Bitmap1D((SETT.ROOMS()).AMOUNT_OF_BLUEPRINTS, false);
/*     */   public UIMinimapSettConfigExt(String key) {
/*  62 */     this.bitsHType.setAll(true);
/*  63 */     this.bitsRooms.setAll(true);
/*  64 */     this.bitsEmployed.setAll(true);
/*  65 */     this.bRaces.setAll(true);
/*     */     
/*  67 */     this.bitUnemployed = true;
/*  68 */     this.statC = null;
/*     */     
/*  70 */     this.showHuman = new BOOLEANO<Humanoid>()
/*     */       {
/*     */         public boolean is(Humanoid t)
/*     */         {
/*  74 */           if (UIMinimapSettConfigExt.this.bitsHType.get(t.indu().hType().index()) && UIMinimapSettConfigExt.this.bRaces.get(t.race().index())) {
/*  75 */             RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(t);
/*  76 */             if (ins == null)
/*  77 */               return UIMinimapSettConfigExt.this.bitUnemployed; 
/*  78 */             return UIMinimapSettConfigExt.this.bitsEmployed.get(ins.blueprint().index());
/*     */           } 
/*  80 */           return false;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  85 */     this.showRoom = new BOOLEANO<RoomBlueprintIns<?>>()
/*     */       {
/*     */         public boolean is(RoomBlueprintIns<?> b)
/*     */         {
/*  89 */           return UIMinimapSettConfigExt.this.bitsRooms.get(b.index());
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     if (key != null) {
/*  97 */       GAME.saver().add(new Savable("VIEW_MINI_SETT" + key)
/*     */           {
/*     */             protected void save(FilePutter file)
/*     */             {
/* 101 */               UIMinimapSettConfigExt.this.showAnimals.save(file);
/* 102 */               UIMinimapSettConfigExt.this.showGrowable.save(file);
/* 103 */               UIMinimapSettConfigExt.this.showMinerals.save(file);
/* 104 */               UIMinimapSettConfigExt.this.showDiv.save(file);
/* 105 */               UIMinimapSettConfigExt.this.bitsHType.save(file);
/* 106 */               UIMinimapSettConfigExt.this.bitsRooms.save(file);
/* 107 */               UIMinimapSettConfigExt.this.bitsEmployed.save(file);
/* 108 */               UIMinimapSettConfigExt.this.bRaces.save(file);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void load(FileGetter file) throws IOException {
/* 113 */               UIMinimapSettConfigExt.this.showAnimals.load(file);
/* 114 */               UIMinimapSettConfigExt.this.showGrowable.load(file);
/* 115 */               UIMinimapSettConfigExt.this.showMinerals.load(file);
/* 116 */               UIMinimapSettConfigExt.this.showDiv.load(file);
/* 117 */               UIMinimapSettConfigExt.this.bitsHType.load(file);
/* 118 */               UIMinimapSettConfigExt.this.bitsRooms.load(file);
/* 119 */               UIMinimapSettConfigExt.this.bitsEmployed.load(file);
/* 120 */               UIMinimapSettConfigExt.this.bRaces.load(file);
/*     */             }
/*     */           });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean bitUnemployed;
/*     */   private STAT statC;
/*     */   private final BOOLEANO<Humanoid> showHuman;
/*     */   private final BOOLEANO<RoomBlueprintIns<?>> showRoom;
/*     */   
/*     */   public COLOR col(ENTITY e) {
/* 133 */     boolean ani = this.showAnimals.is();
/* 134 */     if (e instanceof settlement.entity.animal.Animal) {
/* 135 */       if (!ani)
/* 136 */         return null; 
/* 137 */       return colAnimal;
/* 138 */     }  if (e instanceof Humanoid) {
/* 139 */       Humanoid h = (Humanoid)e;
/* 140 */       if (!this.showHuman.is(h)) {
/* 141 */         return null;
/*     */       }
/* 143 */       Humanoid a = (Humanoid)e;
/* 144 */       if (a.indu().hostile()) {
/* 145 */         if ((STATS.BATTLE()).ROUTING.indu().get(a.indu()) == 0)
/* 146 */           return colHostile; 
/* 147 */         return colHostileRout;
/*     */       } 
/*     */       
/* 150 */       if (this.statC != null) {
/* 151 */         double d = this.statC.indu().getD(h.indu());
/* 152 */         if (d == 0.0D)
/* 153 */           return bad; 
/* 154 */         if (d == 1.0D)
/* 155 */           return good; 
/* 156 */         return soso;
/*     */       } 
/* 158 */       return colNormal;
/*     */     } 
/*     */ 
/*     */     
/* 162 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean halfEnts() {
/* 170 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean room(RoomBlueprintIns<?> b) {
/* 175 */     return this.showRoom.is(b);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderGrowable() {
/* 180 */     return this.showGrowable.is();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderMinable() {
/* 185 */     return this.showMinerals.is();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderPack() {
/* 190 */     return this.showAnimals.is();
/*     */   }
/*     */ 
/*     */   
/*     */   public OPACITY shade() {
/* 195 */     return OPACITY.O0;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean renderDivs() {
/* 200 */     return this.showDiv.is();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addButtons(GuiSection sec, GameWindow w, UIMinimapSett s) {
/* 205 */     super.addButtons(sec, w, s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private class Butts
/*     */   {
/*     */     public Butts(GuiSection s) {
/* 216 */       CLICKABLE c = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.wildlife)
/*     */         {
/*     */           protected void clickA() {
/* 219 */             (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).showAnimals.toggle();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 224 */             selectedSet((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).showAnimals.is());
/*     */           }
/* 227 */         }).hoverInfoSet(Dic.¤¤Animals);
/* 228 */       s.addRightC(0, (RENDEROBJ)c);
/*     */ 
/*     */ 
/*     */       
/* 232 */       c = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.clear_food)
/*     */         {
/*     */           protected void clickA() {
/* 235 */             (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).showGrowable.toggle();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 240 */             selectedSet((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).showGrowable.is());
/*     */           }
/* 243 */         }).hoverInfoSet(Dic.¤¤Growth);
/* 244 */       s.addRightC(0, (RENDEROBJ)c);
/*     */       
/* 246 */       c = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.pickaxe)
/*     */         {
/*     */           protected void clickA() {
/* 249 */             (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).showMinerals.toggle();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 254 */             selectedSet((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).showMinerals.is());
/*     */           }
/* 257 */         }).hoverInfoSet(Dic.¤¤Minerals);
/* 258 */       s.addRightC(0, (RENDEROBJ)c);
/*     */       
/* 260 */       c = (new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.sword)
/*     */         {
/*     */           protected void clickA() {
/* 263 */             (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).showDiv.toggle();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 268 */             selectedSet((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).showDiv.is());
/*     */           }
/* 271 */         }).hoverInfoSet(Dic.¤¤Armies);
/* 272 */       s.addRightC(0, (RENDEROBJ)c);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 277 */       LinkedList<RENDEROBJ> bbs = new LinkedList();
/*     */       
/* 279 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.ok, Dic.¤¤All)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 283 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsRooms.setAll(true);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 288 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.cancel, Dic.¤¤None)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 292 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsRooms.setAll(false);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 297 */       LinkedList<BSearchable> all = new LinkedList();
/*     */       
/* 299 */       for (RoomBlueprint b : SETT.ROOMS().all()) {
/* 300 */         if (b instanceof RoomBlueprintIns) {
/* 301 */           final RoomBlueprintIns<?> bb = (RoomBlueprintIns)b;
/* 302 */           all.add(new BSearchable(this, bb.icon.big, bb.info.names)
/*     */               {
/*     */                 protected void clickA()
/*     */                 {
/* 306 */                   (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsRooms.toggle(bb.index());
/*     */                 }
/*     */ 
/*     */                 
/*     */                 protected void renAction() {
/* 311 */                   selectedSet((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsRooms.get(bb.index()));
/*     */                 }
/*     */               });
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 319 */       final IPopCurrent ii = bSearchList((LIST<RENDEROBJ>)bbs, (LIST<BSearchable>)all);
/*     */       
/* 321 */       CLICKABLE cLICKABLE1 = (new GButt.ButtPanel((SPRITE)(UI.icons()).m.building)
/*     */         {
/*     */           protected void clickA() {
/* 324 */             ii.show((CLICKABLE)this);
/*     */           }
/* 326 */         }).hoverTitleSet(Dic.¤¤Buildings);
/* 327 */       s.addRightC(0, (RENDEROBJ)cLICKABLE1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 333 */       bbs = new LinkedList();
/*     */       
/* 335 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.ok, Dic.¤¤All)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 339 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsHType.setAll(true);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 344 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.cancel, Dic.¤¤None)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 348 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsHType.setAll(false);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 353 */       all = new LinkedList();
/*     */       
/* 355 */       for (HTYPE t : HTYPES.ALL()) {
/* 356 */         all.add(new BSearchable(this, (SPRITE)(UI.icons()).s.human, t.names)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 360 */                 (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsHType.toggle(t.index());
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/* 365 */                 selectedSet((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsHType.get(t.index()));
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/* 371 */       ii = bSearchList((LIST<RENDEROBJ>)bbs, (LIST<BSearchable>)all);
/*     */       
/* 373 */       cLICKABLE1 = (new GButt.ButtPanel((SPRITE)(UI.icons()).m.citizen)
/*     */         {
/*     */           protected void clickA() {
/* 376 */             ii.show((CLICKABLE)this);
/*     */           }
/* 378 */         }).hoverTitleSet(Dic.¤¤Population);
/* 379 */       s.addRightC(0, (RENDEROBJ)cLICKABLE1);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 385 */       bbs = new LinkedList();
/*     */       
/* 387 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.ok, Dic.¤¤All)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 391 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsEmployed.setAll(true);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 396 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.cancel, Dic.¤¤None)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 400 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsEmployed.setAll(false);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 405 */       all = new LinkedList();
/*     */       
/* 407 */       for (RoomBlueprint b : SETT.ROOMS().all()) {
/* 408 */         if (b.employment() != null && b instanceof RoomBlueprintIns) {
/* 409 */           final RoomBlueprintIns<?> bb = (RoomBlueprintIns)b;
/* 410 */           all.add(new BSearchable(this, bb.icon.big, (bb.employment()).title)
/*     */               {
/*     */                 protected void clickA()
/*     */                 {
/* 414 */                   (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsEmployed.toggle(bb.index());
/*     */                 }
/*     */ 
/*     */                 
/*     */                 protected void renAction() {
/* 419 */                   selectedSet((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bitsEmployed.get(bb.index()));
/*     */                 }
/*     */               });
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 427 */       ii = bSearchList((LIST<RENDEROBJ>)bbs, (LIST<BSearchable>)all);
/*     */       
/* 429 */       cLICKABLE1 = (new GButt.ButtPanel((SPRITE)(UI.icons()).m.workshop)
/*     */         {
/*     */           protected void clickA() {
/* 432 */             ii.show((CLICKABLE)this);
/*     */           }
/* 434 */         }).hoverTitleSet(Dic.¤¤Employment);
/* 435 */       s.addRightC(0, (RENDEROBJ)cLICKABLE1);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 440 */       bbs = new LinkedList();
/*     */ 
/*     */ 
/*     */       
/* 444 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.ok, Dic.¤¤All)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 448 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bRaces.setAll(true);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 453 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.cancel, Dic.¤¤None)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 457 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bRaces.setAll(false);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 462 */       all = new LinkedList();
/*     */       
/* 464 */       for (Race p : RACES.all()) {
/* 465 */         Icon icon = (p.appearance()).icon;
/* 466 */         all.add(new BSearchable(this, (SPRITE)icon, p.info.names)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 470 */                 (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bRaces.toggle(p.index);
/*     */               }
/*     */ 
/*     */               
/*     */               protected void renAction() {
/* 475 */                 selectedSet((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).bRaces.get(p.index()));
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 482 */       ii = bSearchList((LIST<RENDEROBJ>)bbs, (LIST<BSearchable>)all);
/*     */       
/* 484 */       cLICKABLE1 = (new GButt.ButtPanel((SPRITE)(UI.icons()).m.descrimination)
/*     */         {
/*     */           protected void clickA() {
/* 487 */             ii.show((CLICKABLE)this);
/*     */           }
/* 489 */         }).hoverTitleSet(RACES.name());
/*     */       
/* 491 */       s.addRightC(0, (RENDEROBJ)cLICKABLE1);
/*     */ 
/*     */ 
/*     */       
/* 495 */       bbs = new LinkedList();
/*     */ 
/*     */       
/* 498 */       bbs.add(new BSearchable(this, (SPRITE)(UI.icons()).m.cancel, Dic.¤¤Clear)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 502 */               (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).statC = null;
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 507 */       all = new LinkedList();
/*     */       
/* 509 */       for (STAT p : STATS.createMatterList(true, false, null)) {
/* 510 */         Icon icon; SPRITE ico = (p.info()).icon;
/* 511 */         if (ico == null)
/* 512 */           icon = (UI.icons()).m.heart; 
/* 513 */         all.add(new BSearchable(this, (SPRITE)icon, (p.info()).name)
/*     */             {
/*     */               protected void clickA()
/*     */               {
/* 517 */                 if ((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).statC == p) {
/* 518 */                   (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).statC = null;
/*     */                 } else {
/* 520 */                   (UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).statC = p;
/*     */                 } 
/*     */               }
/*     */               
/*     */               protected void renAction() {
/* 525 */                 selectedSet(((UIMinimapSettConfigExt.Butts.access$0(UIMinimapSettConfigExt.Butts.this)).statC == p));
/*     */               }
/*     */ 
/*     */               
/*     */               public void hoverInfoGet(GUI_BOX text) {
/* 530 */                 text.text((p.info()).desc);
/*     */               }
/*     */             });
/*     */       } 
/*     */ 
/*     */       
/* 536 */       ii = bSearchList((LIST<RENDEROBJ>)bbs, (LIST<BSearchable>)all);
/*     */       
/* 538 */       cLICKABLE1 = (new GButt.ButtPanel((SPRITE)(UI.icons()).m.heart)
/*     */         {
/*     */           protected void clickA() {
/* 541 */             ii.show((CLICKABLE)this);
/*     */           }
/* 543 */         }).hoverTitleSet(Dic.¤¤Happiness);
/*     */       
/* 545 */       s.addRightC(0, (RENDEROBJ)cLICKABLE1);
/*     */     }
/*     */ 
/*     */     
/*     */     private class BSearchable
/*     */       extends GButt.ButtPanel
/*     */     {
/*     */       public final String search;
/*     */       
/*     */       public BSearchable(SPRITE icon, CharSequence label) {
/* 555 */         super(label);
/* 556 */         this.search = String.valueOf(label);
/* 557 */         icon(icon);
/* 558 */         this.body.setWidth(300.0D);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private IPopCurrent bSearchList(LIST<RENDEROBJ> pre, LIST<BSearchable> sss) {
/* 567 */       final StringInputSprite input = new StringInputSprite(10, (UI.FONT()).M);
/* 568 */       input.placeHolder(Dic.¤¤Search);
/*     */       
/* 570 */       final GInput in = new GInput(input);
/*     */       
/* 572 */       IPopCurrent pop = new IPopCurrent()
/*     */         {
/*     */           public void show(CLICKABLE trigger) {
/* 575 */             super.show(trigger);
/* 576 */             in.focus();
/*     */           }
/*     */         };
/*     */       
/* 580 */       GuiSection s = pop.expansion;
/*     */       
/* 582 */       for (RENDEROBJ r : pre) {
/* 583 */         s.addDown(0, r);
/*     */       }
/* 585 */       s.addDown(8, (RENDEROBJ)in);
/*     */       
/* 587 */       GScrollRows rr = new GScrollRows((Iterable)sss, ((BSearchable)sss.get(0)).body.height() * 10)
/*     */         {
/*     */           protected boolean passesFilter(int i, RENDEROBJ o) {
/* 590 */             if (input.text().length() == 0)
/* 591 */               return true; 
/* 592 */             UIMinimapSettConfigExt.Butts.BSearchable s = (UIMinimapSettConfigExt.Butts.BSearchable)o;
/* 593 */             return Str.containsText(s.search, (CharSequence)input.text());
/*     */           }
/*     */         };
/*     */       
/* 597 */       s.addDown(4, (RENDEROBJ)rr.view());
/*     */       
/* 599 */       return pop;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\minimap\UIMinimapSettConfigExt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */