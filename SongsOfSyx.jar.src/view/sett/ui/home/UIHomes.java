/*     */ package view.sett.ui.home;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.SPRITES;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.Dic;
/*     */ import view.interrupter.ISidePanel;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.keyboard.KeyPage;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.bottom.RoomUpgrader;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableMulti;
/*     */ 
/*     */ public class UIHomes extends ISidePanel {
/*     */   private final UIHomesTable table;
/*     */   
/*     */   public UIHomes() {
/*  27 */     final PlacableMulti pp = new UIHomeAssign();
/*     */     
/*  29 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  33 */           (VIEW.s()).tools.place((PLACABLE)pp);
/*     */         }
/*     */       };
/*     */     
/*  37 */     GButt.ButtPanel buttPanel1 = new GButt.ButtPanel(pp.getIcon())
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  41 */           (VIEW.s()).tools.place((PLACABLE)pp);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  46 */     buttPanel1.setDim(60, 40);
/*  47 */     CLICKABLE cc = KeyButt.wrap(a, (CLICKABLE)buttPanel1, (KeyPage)KEYS.SETT(), "SET_HOMES", pp.name(), pp.desc);
/*  48 */     this.section.add((RENDEROBJ)cc);
/*     */ 
/*     */ 
/*     */     
/*  52 */     pp = new UIHomeOdd();
/*  53 */     a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  57 */           (VIEW.inters()).popup.close();
/*  58 */           (VIEW.s()).tools.place((PLACABLE)pp);
/*     */         }
/*     */       };
/*     */     
/*  62 */     buttPanel1 = new GButt.ButtPanel(pp.getIcon())
/*     */       {
/*     */ 
/*     */         
/*     */         protected void clickA()
/*     */         {
/*  68 */           a.exe();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  73 */     buttPanel1.setDim(60, 40);
/*     */     
/*  75 */     cc = KeyButt.wrap(a, (CLICKABLE)buttPanel1, (KeyPage)KEYS.SETT(), "MOVE_HOMES", pp.name(), pp.desc);
/*  76 */     this.section.addRightC(8, (RENDEROBJ)cc);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  82 */     final RoomUpgrader pp = new RoomUpgrader();
/*  83 */     a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  87 */           (VIEW.inters()).popup.close();
/*  88 */           (VIEW.s()).tools.place((PLACABLE)pp);
/*     */         }
/*     */       };
/*     */     
/*  92 */     buttPanel1 = new GButt.ButtPanel(roomUpgrader.getIcon())
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  96 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 101 */           activeSet((SETT.ROOMS()).HOME.reqs.passes(FACTIONS.player()));
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 106 */           super.hoverInfoGet(text);
/* 107 */           text.NL(8);
/* 108 */           if (!(SETT.ROOMS()).HOME.reqs.passes(FACTIONS.player())) {
/* 109 */             (SETT.ROOMS()).HOME.reqs.hover(text, FACTIONS.player());
/*     */           }
/*     */         }
/*     */       };
/*     */     
/* 114 */     buttPanel1.setDim(60, 40);
/*     */     
/* 116 */     cc = KeyButt.wrap(a, (CLICKABLE)buttPanel1, (KeyPage)KEYS.SETT(), "UPGRADE_HOMES", roomUpgrader.name(), ((PlacableMulti)roomUpgrader).desc);
/* 117 */     this.section.addRightC(8, (RENDEROBJ)cc);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     GButt.ButtPanel c = new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.place_brush)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 126 */           UIHomes.this.overlay = !(!UIHomes.this.overlay && !(SETT.OVERLAY()).HOMELESS.added());
/* 127 */           UIHomes.this.overlay = !UIHomes.this.overlay;
/* 128 */           if (!UIHomes.this.overlay) {
/* 129 */             (VIEW.s()).overlayThing.set(null);
/*     */           }
/*     */         }
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 134 */           text.title(Dic.¤¤Overlay);
/* 135 */           text.text((SETT.OVERLAY()).HOMELESS.desc);
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/* 140 */           selectedSet(!(!UIHomes.this.overlay && !(SETT.OVERLAY()).HOMELESS.added()));
/* 141 */           if (UIHomes.this.overlay) {
/* 142 */             (SETT.OVERLAY()).HOMELESS.add();
/*     */           }
/*     */         }
/*     */       };
/* 146 */     c.setDim(60, 40);
/* 147 */     this.section.addRightC(8, (RENDEROBJ)c);
/*     */ 
/*     */     
/* 150 */     titleSet(Dic.¤¤Housing);
/*     */     
/* 152 */     this.table = new UIHomesTable(ISidePanel.HEIGHT - 400);
/* 153 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)this.table);
/* 154 */     this.section.addRelBody(8, DIR.S, (RENDEROBJ)new UIHomesFurniture(300));
/*     */   }
/*     */   private boolean overlay = true;
/*     */   
/*     */   protected void addAction() {
/* 159 */     this.table.subject = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean back() {
/* 164 */     if (this.table.subject != null) {
/* 165 */       this.table.subject = null;
/* 166 */       return true;
/*     */     } 
/* 168 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\home\UIHomes.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */