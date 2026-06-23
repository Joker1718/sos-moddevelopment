/*     */ package view.world.panel;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.emmi.Emissaries;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import init.settings.S;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.main.VIEW;
/*     */ import view.ui.UIEmissaries;
/*     */ import view.ui.top.UIPanelTop;
/*     */ import view.ui.top.UIPanelTopButtL;
/*     */ import view.ui.top.UIPanelTopButtS;
/*     */ import view.world.WorldView;
/*     */ import view.world.ui.panels.UIAdminPanel;
/*     */ import view.world.ui.panels.UICaravanList;
/*     */ import world.WORLD;
/*     */ import world.army.AD;
/*     */ import world.entity.haven.WHavenType;
/*     */ import world.map.regions.Region;
/*     */ import world.region.RD;
/*     */ import world.region.building.RDBuildPoints;
/*     */ import world.region.pop.RDRace;
/*     */ 
/*     */ public class UIPanelTopWorld {
/*  42 */   private int bi = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UIPanelTopWorld(final WorldView w, UIPanelTop top) {
/*  48 */     GuiSection bigButts = new GuiSection();
/*     */     
/*  50 */     GuiSection butts = new GuiSection();
/*     */     
/*  52 */     UIPanelTopButtL uIPanelTopButtL = new UIPanelTopButtL((SPRITE)(SPRITES.icons()).s.flag)
/*     */       {
/*  54 */         private final GAME.Cache cache = new GAME.Cache(60);
/*     */         
/*     */         private int neighs;
/*     */         private double trust;
/*     */         
/*     */         protected double valueNext() {
/*  60 */           cache();
/*  61 */           return this.trust;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/*  66 */           cache();
/*  67 */           return this.trust;
/*     */         }
/*     */         
/*     */         private void cache() {
/*  71 */           if (!this.cache.shouldAndReset()) {
/*     */             return;
/*     */           }
/*  74 */           this.trust = 10.0D;
/*  75 */           this.neighs = 0;
/*     */           
/*  77 */           for (int fi = 0; fi < FACTIONS.NPCs().size(); fi++) {
/*  78 */             FactionNPC f = (FactionNPC)FACTIONS.NPCs().get(fi);
/*  79 */             if (RD.DIST().factionHasRegionBorderingPlayer((Faction)f)) {
/*  80 */               this.trust = Math.min(ROPINION.trust().get(f), this.trust);
/*  81 */               this.neighs++;
/*     */             } 
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/*  88 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/*  93 */           cache();
/*  94 */           return this.neighs;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  99 */           selectedSet(w.UI.factions.openIs());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 104 */           w.UI.factions.open(null);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 109 */           GBox b = (GBox)text;
/* 110 */           b.title(Dic.¤¤Factions);
/* 111 */           hov(b, DIP.ALLY());
/* 112 */           hov(b, DIP.VASSAL());
/* 113 */           hov(b, DIP.PACT());
/* 114 */           hov(b, DIP.TRADE());
/* 115 */           hov(b, (DipStance)DIP.WAR());
/*     */         }
/*     */         
/*     */         private void hov(GBox b, DipStance stance) {
/* 119 */           b.textLL(stance.name);
/* 120 */           b.tab(6);
/* 121 */           b.add((SPRITE)b.text().add(stance.player().size()));
/* 122 */           b.NL();
/*     */         }
/*     */       };
/*     */     
/* 126 */     addB(bigButts, (RENDEROBJ)uIPanelTopButtL, "REGIONS");
/*     */     
/* 128 */     uIPanelTopButtL = new UIPanelTopButtL((SPRITE)(SPRITES.icons()).s.world)
/*     */       {
/* 130 */         private final GAME.Cache cache = new GAME.Cache(60);
/*     */         
/*     */         private double worst;
/*     */         private double worstTarget;
/*     */         
/*     */         protected double valueNext() {
/* 136 */           cache();
/* 137 */           return this.worstTarget;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 142 */           cache();
/* 143 */           return this.worst;
/*     */         }
/*     */         
/*     */         private void cache() {
/* 147 */           if (!this.cache.shouldAndReset())
/*     */             return; 
/* 149 */           this.worst = 1.0D;
/* 150 */           this.worstTarget = 1.0D;
/* 151 */           for (int i = 0; i < FACTIONS.player().realm().regions(); i++) {
/* 152 */             Region r = FACTIONS.player().realm().region(i);
/* 153 */             if (!r.capitol()) {
/* 154 */               for (RDRace ra : (RD.RACES()).all) {
/* 155 */                 this.worst = Math.min(ra.loyalty.get(r), this.worst);
/* 156 */                 this.worstTarget = Math.min(this.worstTarget, ra.loyaltyTarget(r));
/*     */               } 
/*     */             }
/*     */           } 
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 165 */           return (FACTIONS.player().realm().regions() > 1);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 170 */           return FACTIONS.player().realm().regions() - 1;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 175 */           selectedSet(w.panels.added(w.UI.regions.playerList));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 180 */           if (w.panels.added(w.UI.regions.playerList))
/* 181 */             w.panels.remove(w.UI.regions.playerList); 
/* 182 */           w.panels.add(w.UI.regions.playerList, true);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 187 */           GBox b = (GBox)text;
/* 188 */           b.title(Dic.¤¤Realm);
/* 189 */           b.text(Dic.¤¤RegionDesc);
/*     */           
/* 191 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 195 */     addB(bigButts, (RENDEROBJ)uIPanelTopButtL, "REGIONS");
/*     */ 
/*     */ 
/*     */     
/* 199 */     uIPanelTopButtL = new UIPanelTopButtL((SPRITE)(SPRITES.icons()).s.sword)
/*     */       {
/*     */         
/*     */         protected double valueNext()
/*     */         {
/* 204 */           return 1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 209 */           return (AD.menTarget(null).faction((Faction)FACTIONS.player()) + 1.0D) / (AD.men(null).faction((Faction)FACTIONS.player()) + 1.0D);
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 214 */           return (AD.menTarget(null).faction((Faction)FACTIONS.player()) > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 219 */           return AD.menTarget(null).faction((Faction)FACTIONS.player());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 224 */           selectedSet((VIEW.world()).UI.armies.listIsOpen((VIEW.world()).panels));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 229 */           if ((VIEW.world()).UI.armies.listIsOpen((VIEW.world()).panels))
/* 230 */             (VIEW.world()).UI.armies.close((VIEW.world()).panels); 
/* 231 */           (VIEW.world()).UI.armies.openList(null, (VIEW.world()).panels);
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 236 */           GBox b = (GBox)text;
/* 237 */           b.title(Dic.¤¤Armies);
/*     */ 
/*     */           
/* 240 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 244 */     addB(bigButts, (RENDEROBJ)uIPanelTopButtL, "ARMIES");
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 249 */     UIPanelTopButtS uIPanelTopButtS = new UIPanelTopButtS((SPRITE)(SPRITES.icons()).s.house)
/*     */       {
/*     */         
/*     */         protected double valueNext()
/*     */         {
/* 254 */           return -1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 259 */           return -1.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 265 */           return (getNumber() > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 270 */           int am = 0;
/* 271 */           for (WHavenType r : (WORLD.camps()).types)
/* 272 */             am += WORLD.camps().camps((Faction)FACTIONS.player(), r); 
/* 273 */           return am;
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 278 */           selectedSet((VIEW.world()).panels.added((ISidePanel)(VIEW.world()).UI.camps));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 283 */           if ((VIEW.world()).panels.added((ISidePanel)(VIEW.world()).UI.camps)) {
/* 284 */             (VIEW.world()).panels.remove((ISidePanel)(VIEW.world()).UI.camps);
/*     */           } else {
/* 286 */             (VIEW.world()).panels.add((ISidePanel)(VIEW.world()).UI.camps, true);
/*     */           } 
/*     */         }
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 291 */           GBox b = (GBox)text;
/* 292 */           b.add((WORLD.camps()).info);
/*     */ 
/*     */           
/* 295 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 299 */     add(butts, (RENDEROBJ)uIPanelTopButtS, "CAMPS");
/*     */     
/* 301 */     uIPanelTopButtS = new UIPanelTopButtS((SPRITE)(SPRITES.icons()).s.wheel)
/*     */       {
/* 303 */         UICaravanList li = new UICaravanList();
/*     */ 
/*     */ 
/*     */         
/*     */         protected double valueNext() {
/* 308 */           return -1.0D;
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 313 */           return -1.0D;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 319 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 324 */           return this.li.all().size();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 329 */           selectedSet((VIEW.world()).panels.added((ISidePanel)this.li));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 334 */           if ((VIEW.world()).panels.added((ISidePanel)this.li)) {
/* 335 */             (VIEW.world()).panels.remove((ISidePanel)this.li);
/*     */           } else {
/* 337 */             (VIEW.world()).panels.add((ISidePanel)this.li, true);
/*     */           } 
/*     */         }
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 342 */           GBox b = (GBox)text;
/* 343 */           b.title(Dic.¤¤Inbound);
/* 344 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 348 */     add(butts, (RENDEROBJ)uIPanelTopButtS, "CARAVANS");
/*     */     
/* 350 */     uIPanelTopButtS = new UIPanelTopButtS((SPRITE)(SPRITES.icons()).s.flags)
/*     */       {
/* 352 */         UIEmissaries li = new UIEmissaries();
/*     */ 
/*     */ 
/*     */         
/*     */         protected double valueNext() {
/* 357 */           return value();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 362 */           int v = (FACTIONS.player()).emissaries.spent();
/* 363 */           if (v == 0)
/* 364 */             return 1.0D; 
/* 365 */           return CLAMP.d((FACTIONS.player()).emissaries.penaltyMul(), 0.0D, 1.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 371 */           return !((FACTIONS.player()).emissaries.spent() <= 0 && (FACTIONS.player()).emissaries.produced() <= 0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 376 */           return (FACTIONS.player()).emissaries.available();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 381 */           selectedSet((VIEW.world()).panels.added((ISidePanel)this.li));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 386 */           if ((VIEW.world()).panels.added((ISidePanel)this.li)) {
/* 387 */             (VIEW.world()).panels.remove((ISidePanel)this.li);
/*     */           } else {
/* 389 */             (VIEW.world()).panels.add((ISidePanel)this.li, true);
/*     */           } 
/*     */         }
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 394 */           GBox b = (GBox)text;
/* 395 */           b.title(Emissaries.¤¤name);
/* 396 */           b.text(Emissaries.¤¤desc);
/* 397 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 401 */     add(butts, (RENDEROBJ)uIPanelTopButtS, "ENVOYS");
/*     */     
/* 403 */     uIPanelTopButtS = new UIPanelTopButtS((SPRITE)(SPRITES.icons()).s.capitol, w)
/*     */       {
/*     */         UIAdminPanel li;
/*     */         
/*     */         RDBuildPoints.RDBuildPoint b;
/*     */         
/*     */         protected double valueNext() {
/* 410 */           return value();
/*     */         }
/*     */ 
/*     */         
/*     */         protected double value() {
/* 415 */           return (this.b.bo.get((BOOSTABLE_O)FACTIONS.player()) + 1.0D) / (this.b.bo.added((BOOSTABLE_O)FACTIONS.player()) + 1.0D);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean isActive() {
/* 421 */           return (this.b.consumed((Faction)FACTIONS.player()) > 0);
/*     */         }
/*     */ 
/*     */         
/*     */         protected int getNumber() {
/* 426 */           return (int)this.b.bo.get((BOOSTABLE_O)FACTIONS.player());
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 431 */           selectedSet((VIEW.world()).panels.added((ISidePanel)this.li));
/*     */         }
/*     */ 
/*     */         
/*     */         protected void clickA() {
/* 436 */           if ((VIEW.world()).panels.added((ISidePanel)this.li)) {
/* 437 */             (VIEW.world()).panels.remove((ISidePanel)this.li);
/*     */           } else {
/* 439 */             (VIEW.world()).panels.add((ISidePanel)this.li, true);
/*     */           } 
/*     */         }
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 444 */           GBox bb = (GBox)text;
/* 445 */           bb.title(this.b.bo.name);
/* 446 */           bb.text(this.b.bo.desc);
/* 447 */           super.hoverInfoGet(text);
/*     */         }
/*     */       };
/*     */     
/* 451 */     add(butts, (RENDEROBJ)uIPanelTopButtS, "GOV");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 460 */     butts.addRelBody(0, DIR.E, (RENDEROBJ)(new Buttt((SPRITE)(SPRITES.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA() {
/* 463 */             (VIEW.world()).window.centererTile.set(FACTIONS.player().capitolRegion().cx(), FACTIONS.player().capitolRegion().cy());
/*     */           }
/* 465 */         }).hoverInfoSet(Dic.¤¤CapitolYou));
/*     */     
/* 467 */     if ((S.get()).developer) {
/* 468 */       butts.addRelBody(0, DIR.E, (RENDEROBJ)(new Buttt((SPRITE)(SPRITES.icons()).s.cog)
/*     */           {
/*     */             protected void clickA() {
/* 471 */               (VIEW.world()).debug.show();
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 477 */               selectedSet((VIEW.world()).debug.isActivated());
/* 478 */               super.render(r, ds, isActive, isSelected, isHovered);
/*     */             }
/* 480 */           }).hoverInfoSet("developer tools"));
/*     */     }
/*     */ 
/*     */     
/* 484 */     GuiSection s = new GuiSection();
/* 485 */     s.add((RENDEROBJ)bigButts);
/* 486 */     s.addRightC(0, (RENDEROBJ)butts);
/*     */     
/* 488 */     top.addLeft(s);
/*     */ 
/*     */     
/* 491 */     s = new GuiSection();
/* 492 */     s.addRightC(0, (RENDEROBJ)GAME.EVENT().butt());
/* 493 */     s.addRightC(0, UIPanelTop.junk());
/* 494 */     s.addRightC(0, (RENDEROBJ)UIPanelTop.messages());
/* 495 */     s.addRightC(0, UIPanelTop.vToggle());
/* 496 */     s.addRightC(0, UIPanelTop.wLog());
/* 497 */     top.addRightRight(s);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void add(GuiSection bb, RENDEROBJ o, String key) {
/* 506 */     bb.add(o, this.bi / 2 * 80, this.bi % 2 * 24);
/* 507 */     this.bi++;
/*     */   }
/*     */   
/*     */   private void addB(GuiSection bb, RENDEROBJ o, String key) {
/* 511 */     bb.addRightC(0, o);
/*     */   }
/*     */   
/*     */   private static class Buttt
/*     */     extends GButt.ButtPanel {
/*     */     public Buttt(SPRITE label) {
/* 517 */       super(label);
/* 518 */       setDim(32, 48);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\panel\UIPanelTopWorld.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */