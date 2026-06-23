/*     */ package view.sett.ui.bottom;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GGrid;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ import view.keyboard.KeyButt;
/*     */ import view.keyboard.KeyPage;
/*     */ import view.main.VIEW;
/*     */ import view.sett.ui.room.prints.UISavedPrints;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PLACER_TYPE;
/*     */ import view.tool.PlacableMulti;
/*     */ import view.tool.ToolConfig;
/*     */ 
/*     */ 
/*     */ final class Options
/*     */   extends SPanel
/*     */ {
/*  37 */   private static CharSequence ¤¤CopyArea = "Copy Area";
/*     */   
/*     */   static {
/*  40 */     D.ts(Options.class);
/*     */   }
/*     */ 
/*     */   
/*     */   Options() {
/*  45 */     D.gInit(this);
/*     */     
/*  47 */     body().setWidth(700.0D);
/*  48 */     GGrid grid = new GGrid(this, 2);
/*     */ 
/*     */     
/*  51 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  55 */           (VIEW.inters()).popup.close();
/*  56 */           (VIEW.s()).ui.copier.activate();
/*     */         }
/*     */       };
/*  59 */     BButt bButt1 = new BButt((SPRITE)(SPRITES.icons()).l.copy, ¤¤CopyArea)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  63 */           a.exe();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  68 */     CLICKABLE cLICKABLE1 = KeyButt.wrap(a, (CLICKABLE)bButt1, (KeyPage)KEYS.SETT(), "COPY_SUPER", ¤¤CopyArea, "");
/*  69 */     SearchToolPanel.add(cLICKABLE1, ¤¤CopyArea, "");
/*     */     
/*  71 */     grid.add((RENDEROBJ)cLICKABLE1);
/*     */     
/*  73 */     make("COPY_ROOM", (SETT.ROOMS()).copy.copy(), grid);
/*     */ 
/*     */     
/*  76 */     CharSequence name = D.g("Planning");
/*     */     
/*  78 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/*  82 */           (SETT.JOBS()).planMode.toggle();
/*     */         }
/*     */       };
/*     */     
/*  86 */     BButt bButt2 = new BButt((SPRITE)(UI.icons()).l.suspend.twin((SPRITE)(UI.icons()).m.cog, DIR.NW, 1), name)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  90 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         protected void renAction() {
/*  95 */           selectedSet((SETT.JOBS()).planMode.is());
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 100 */     bButt2.hoverInfoSet(D.g("PlanningD", "When enabled, placed jobs will not be performed until manually activated by your grace."));
/* 101 */     CLICKABLE cLICKABLE2 = KeyButt.wrap(aCTION1, (CLICKABLE)bButt2, (KeyPage)KEYS.SETT(), "PLANNING_MODE", name, "");
/* 102 */     SearchToolPanel.add(cLICKABLE2, name, "");
/* 103 */     grid.add((RENDEROBJ)cLICKABLE2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 111 */     make("REPAIR", (PLACABLE)(SETT.JOBS()).tool_repair, grid);
/*     */     
/* 113 */     make("ACTIVATE", (PLACABLE)(SETT.JOBS()).tool_activate, grid);
/* 114 */     make("DORMANT", (PLACABLE)(SETT.JOBS()).tool_dormant, grid);
/*     */     
/* 116 */     make("MAINTENANCE_ON", (SETT.MAINTENANCE()).enablePlacer, grid);
/* 117 */     make("MAINTENANCE_OFF", (SETT.MAINTENANCE()).enablePlacer.getUndo(), grid);
/*     */     
/* 119 */     make("DIAGONALIZE", (PLACABLE)(SETT.TERRAIN()).diagonal.placer, grid);
/* 120 */     make("SQUAREIFY", (PLACABLE)(SETT.TERRAIN()).diagonal.undo, grid);
/*     */     
/* 122 */     final PlacableMulti ppundo = new PlacableMulti("")
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 126 */           (SETT.FLOOR()).floorundernot.set(tx, ty, true);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 131 */           return !(SETT.FLOOR()).floorundernot.is(tx, ty) ? null : E;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/* 136 */           (SETT.OVERLAY()).RODIFY.add();
/* 137 */           super.updateRegardless(window, selected);
/*     */         }
/*     */       };
/*     */     
/* 141 */     PlacableMulti pp = new PlacableMulti(D.g("Roadify"), D.g("RoadifyD", "Allow buildings such as fences to visually try to match their tile to the roads around them."), (SPRITE)(SETT.FLOOR()).defaultRoad.getIcon())
/*     */       {
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 145 */           (SETT.FLOOR()).floorundernot.set(tx, ty, false);
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 150 */           return !(SETT.FLOOR()).floorundernot.is(tx, ty) ? E : null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/* 155 */           (SETT.OVERLAY()).RODIFY.add();
/* 156 */           super.updateRegardless(window, selected);
/*     */         }
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 161 */           return (PLACABLE)ppundo;
/*     */         }
/*     */       };
/*     */     
/* 165 */     make("RODIFY", (PLACABLE)pp, grid);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 177 */           (VIEW.s()).ui.prints.open();
/*     */         }
/*     */       };
/*     */     
/* 181 */     BButt bButt3 = new BButt((SPRITE)(SPRITES.icons()).l.prints, UISavedPrints.¤¤title)
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 185 */           a.exe();
/*     */         }
/*     */       };
/*     */     
/* 189 */     CharSequence desc = D.g("printsD", "Add and manage saved blueprints.");
/* 190 */     bButt3.hoverInfoSet(desc);
/* 191 */     CLICKABLE cLICKABLE3 = KeyButt.wrap(aCTION2, (CLICKABLE)bButt3, (KeyPage)KEYS.SETT(), "SAVE_PRINT", UISavedPrints.¤¤title, "");
/* 192 */     SearchToolPanel.add(cLICKABLE3, UISavedPrints.¤¤title, desc);
/* 193 */     grid.add((RENDEROBJ)cLICKABLE3);
/*     */ 
/*     */     
/* 196 */     make("UPGRADE_PLACE", (PLACABLE)new RoomUpgrader(), grid);
/*     */ 
/*     */ 
/*     */     
/* 200 */     final INT.IntImp iii = new INT.IntImp();
/* 201 */     final ArrayListGrower<CLICKABLE> li = new ArrayListGrower();
/*     */     
/* 203 */     for (int i = 0; i < (SETT.JOBS()).paintmap.max() - 1; i++) {
/* 204 */       final int k = i;
/*     */       
/* 206 */       SPRITE c = (k == 0) ? (SPRITE)COLOR.WHITE10 : ((COLOR)COLOR.UNIQUE.get(i)).makeSprite(16, 16);
/* 207 */       li.add(new GButt.ButtPanel(c)
/*     */           {
/*     */             protected void clickA()
/*     */             {
/* 211 */               iii.set(k);
/*     */             }
/*     */ 
/*     */             
/*     */             protected void renAction() {
/* 216 */               selectedSet((iii.get() == k));
/*     */             }
/*     */           });
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     pp = new PlacableMulti(D.g("Paint-tool"), D.g("PlanToolD", "Paint the map in different colors. Has no impact on game-play"), (SPRITE)(SETT.FLOOR()).defaultRoad.getIcon())
/*     */       {
/*     */         
/*     */         public void place(int tx, int ty, AREA area, PLACER_TYPE type)
/*     */         {
/* 229 */           (SETT.JOBS()).paintmap.set(tx, ty, iii.get());
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty, AREA area, PLACER_TYPE type) {
/* 234 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public void updateRegardless(GameWindow window, AREA selected) {
/* 239 */           (SETT.OVERLAY()).PAINTER.add();
/* 240 */           super.updateRegardless(window, selected);
/*     */         }
/*     */ 
/*     */         
/*     */         public PLACABLE getUndo() {
/* 245 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 250 */           return (LIST<CLICKABLE>)li;
/*     */         }
/*     */       };
/*     */     
/* 254 */     make("PLAN_PAINT", (PLACABLE)pp, grid);
/*     */ 
/*     */ 
/*     */     
/* 258 */     pad(8, 8);
/*     */   }
/*     */   
/*     */   private void make(String code, PLACABLE p, GGrid grid) {
/* 262 */     make(code, p, grid, (ToolConfig)null);
/*     */   }
/*     */   
/*     */   private void make(String code, final PLACABLE p, GGrid grid, final ToolConfig con) {
/* 266 */     final ACTION a = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 270 */           (VIEW.inters()).popup.close();
/* 271 */           if (con != null) {
/* 272 */             (VIEW.s()).tools.place(p, con);
/*     */           } else {
/* 274 */             (VIEW.s()).tools.place(p);
/*     */           }  }
/*     */       };
/* 277 */     BButt bButt = new BButt(p.getIcon(), p.name())
/*     */       {
/*     */         protected void clickA()
/*     */         {
/* 281 */           a.exe();
/*     */         }
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 286 */           p.hoverDesc((GBox)text);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 291 */     CLICKABLE cLICKABLE = KeyButt.wrap(a, (CLICKABLE)bButt, (KeyPage)KEYS.SETT(), code, p.name(), "");
/* 292 */     SearchToolPanel.add(cLICKABLE, p.name(), "");
/* 293 */     grid.add((RENDEROBJ)cLICKABLE);
/*     */   }
/*     */   
/*     */   public GuiSection ge2t() {
/* 297 */     return this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\bottom\Options.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */