/*     */ package view.world.generator;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.panel.GPanel;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableFixedImp;
/*     */ import view.tool.ToolConfig;
/*     */ import view.world.generator.tools.UIWorldToolCapitolPlaceInfo;
/*     */ import world.WORLD;
/*     */ import world.map.regions.centre.WorldCentrePlacablity;
/*     */ 
/*     */ class StageCapitol
/*     */ {
/*  29 */   private static CharSequence ¤¤name = "Place Capital";
/*  30 */   static CharSequence ¤¤none = "¤Settling in this location is not possible.";
/*     */   static {
/*  32 */     D.ts(StageCapitol.class);
/*     */   }
/*     */   
/*     */   public StageCapitol(final WorldViewGenerator stages, boolean clear) {
/*  36 */     if (clear) {
/*  37 */       WorldViewGenerator.loadPrint.exe();
/*  38 */       clear();
/*  39 */       WORLD.MINIMAP().repaint();
/*     */     } 
/*  41 */     stages.minimap.show();
/*     */ 
/*     */     
/*  44 */     final GuiSection butts = new GuiSection();
/*     */     
/*  46 */     butts.add((RENDEROBJ)(new GButt.ButtPanel((SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.terrain, (SPRITE)(SPRITES.icons()).m.rotate))
/*     */         {
/*     */           protected void clickA() {
/*  49 */             (WORLD.GEN()).seed = RND.rInt(2147483647);
/*  50 */             WORLD.TERRAIN().saver().generate(WorldViewGenerator.loadPrint);
/*  51 */             WORLD.LANDMARKS().saver().generate(WorldViewGenerator.loadPrint);
/*  52 */             WorldViewGenerator.loadPrint.exe();
/*  53 */             WORLD.MINIMAP().repaint();
/*  54 */             WorldViewGenerator.loadPrint.exe();
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  59 */             (WORLD.OVERLAY()).landmarks.add();
/*     */           }
/*  62 */         }).hoverInfoSet(WorldViewGenerator.¤¤regenerate));
/*  63 */     butts.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.admin)
/*     */         {
/*     */           protected void clickA() {}
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  71 */             text.title(StageEdit.¤¤name);
/*     */           }
/*  74 */         }).hoverInfoSet(Dic.¤¤Terrain));
/*  75 */     if ((WORLD.GEN()).playerX > -1) {
/*  76 */       butts.addRightC(0, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */           {
/*     */             protected void clickA() {
/*  79 */               stages.set();
/*     */             }
/*  81 */           }).hoverInfoSet(Dic.¤¤Next));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*  86 */     PlacableFixedImp t = new PlacableFixedImp(¤¤name, 1, 1)
/*     */       {
/*  88 */         final UIWorldToolCapitolPlaceInfo info = new UIWorldToolCapitolPlaceInfo();
/*     */ 
/*     */         
/*     */         public int width() {
/*  92 */           return 3;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void place(int tx, int ty, int rx, int ry) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void afterPlaced(int tx1, int ty1) {
/* 103 */           int cx = tx1 + 1;
/* 104 */           int cy = ty1 + 1;
/* 105 */           stages.reset();
/* 106 */           StageCapitol.this.generate(cx, cy);
/* 107 */           stages.set();
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence placableWhole(int tx1, int ty1) {
/* 112 */           CharSequence p = WorldCentrePlacablity.terrain(tx1, ty1);
/* 113 */           if (p != null)
/* 114 */             return p; 
/* 115 */           return null;
/*     */         }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public int height() {
/* 159 */           return 3;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/* 164 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence placable(int tx, int ty, int rx, int ry) {
/* 170 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void placeInfo(GBox b, int x1, int y1) {
/* 179 */           this.info.placeInfo(b, x1, y1, FACTIONS.player().race());
/*     */         }
/*     */       };
/*     */     
/* 183 */     GPanel p = (new GPanel(260, butts.body().height())).setButt();
/* 184 */     p.setTitle(¤¤name);
/* 185 */     p.inner().set((BODY_HOLDER)butts);
/* 186 */     butts.add((RENDEROBJ)p);
/* 187 */     butts.moveLastToBack();
/* 188 */     butts.body().moveY1(64.0D).centerX(C.DIM());
/*     */     
/* 190 */     ToolConfig fixed = new ToolConfig()
/*     */       {
/*     */         public boolean back()
/*     */         {
/* 194 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void addUI(LISTE<RENDEROBJ> uis) {
/* 199 */           uis.add(butts);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 205 */     stages.tools.place((PLACABLE)t, fixed);
/*     */   }
/*     */ 
/*     */   
/*     */   private void generate(int cx, int cy) {
/* 210 */     (WORLD.GEN()).playerX = cx;
/* 211 */     (WORLD.GEN()).playerY = cy;
/* 212 */     generate();
/*     */   }
/*     */   
/*     */   static void regenerate() {
/* 216 */     WorldViewGenerator.loadPrint.exe();
/* 217 */     int px = (WORLD.GEN()).playerX;
/* 218 */     int py = (WORLD.GEN()).playerY;
/* 219 */     clear();
/* 220 */     (WORLD.GEN()).playerX = px;
/* 221 */     (WORLD.GEN()).playerY = py;
/* 222 */     generate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void generate() {
/* 228 */     (WORLD.OVERLAY()).regNames.active.set(false);
/* 229 */     WorldViewGenerator.loadPrint.exe();
/* 230 */     WORLD.BUILDINGS().saver().generate(WorldViewGenerator.loadPrint);
/* 231 */     WorldViewGenerator.loadPrint.exe();
/*     */ 
/*     */     
/* 234 */     WORLD.REGIONS().saver().generate(WorldViewGenerator.loadPrint);
/* 235 */     WORLD.ROADS().saver().generate(WorldViewGenerator.loadPrint);
/* 236 */     WORLD.PATH().saver().generate(WorldViewGenerator.loadPrint);
/* 237 */     WORLD.ENTITIES().saver().generate(WorldViewGenerator.loadPrint);
/* 238 */     WORLD.RD().saver().generate(WorldViewGenerator.loadPrint);
/*     */ 
/*     */     
/* 241 */     WorldViewGenerator.loadPrint.exe();
/* 242 */     WORLD.MINIMAP().repaint();
/* 243 */     WORLD.initBeforePlay();
/* 244 */     (WORLD.OVERLAY()).regNames.active.set(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void clear() {
/* 250 */     WorldViewGenerator.loadPrint.exe();
/* 251 */     (WORLD.GEN()).playerX = -1;
/* 252 */     (WORLD.GEN()).playerY = -1;
/* 253 */     WORLD.BUILDINGS().saver().clear();
/* 254 */     WORLD.ROADS().saver().clear();
/* 255 */     WORLD.PATH().saver().clear();
/* 256 */     WORLD.ENTITIES().saver().clear();
/* 257 */     WORLD.REGIONS().saver().clear();
/* 258 */     WORLD.RD().saver().clear();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageCapitol.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */