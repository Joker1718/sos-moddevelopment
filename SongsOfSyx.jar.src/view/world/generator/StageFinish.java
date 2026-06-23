/*     */ package view.world.generator;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.CORE;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.text.D;
/*     */ import util.text.Dic;
/*     */ import view.main.VIEW;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSimple;
/*     */ import view.tool.ToolConfig;
/*     */ import world.WORLD;
/*     */ import world.map.landmark.WorldLandmark;
/*     */ import world.map.pathing.WRegFinder;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ class StageFinish {
/*  30 */   private static CharSequence ¤¤inspectRegions = "Inspect World";
/*     */   static {
/*  32 */     D.ts(StageFinish.class);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public StageFinish(final WorldViewGenerator stages) {
/*  38 */     stages.minimap.show();
/*  39 */     final LinkedList<CLICKABLE> butts = new LinkedList();
/*     */     
/*  41 */     final Coo start = new Coo(-1.0D, -1.0D);
/*     */     
/*  43 */     PlacableSimple simp = new PlacableSimple(¤¤inspectRegions)
/*     */       {
/*     */         public void place(int x, int y) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int x, int y) {
/*  55 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public LIST<CLICKABLE> getAdditionalButt() {
/*  60 */           return (LIST<CLICKABLE>)butts;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderPlaceHolder(SPRITE_RENDERER r, int cx, int cy, boolean isPlacable) {}
/*     */ 
/*     */ 
/*     */         
/*     */         public void renderAction(int cx, int cy) {
/*  70 */           if (start.x() >= 0) {
/*  71 */             int tx = cx / 64;
/*  72 */             int ty = cy / 64;
/*  73 */             (WORLD.OVERLAY()).path.add(start.x(), start.y(), tx, ty, WRegFinder.Treaty.DUMMY);
/*     */           } 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  79 */           super.renderAction(cx, cy);
/*     */         }
/*     */ 
/*     */         
/*     */         public void placeInfo(GBox b, int cx, int cy) {
/*  84 */           int tx = cx / 64;
/*  85 */           int ty = cy / 64;
/*  86 */           Region reg = (Region)(WORLD.REGIONS()).map.get(tx, ty);
/*     */           
/*  88 */           (WORLD.OVERLAY()).landmarks.add();
/*     */           
/*  90 */           if (reg != null) {
/*  91 */             WORLD.OVERLAY().hoverBox(reg);
/*     */             
/*  93 */             (WORLD.OVERLAY()).regionOutline.add(reg);
/*  94 */             if ((WORLD.REGIONS()).isCentre.is(tx, ty)) {
/*  95 */               (VIEW.world()).UI.regions.hover(reg, (GUI_BOX)b);
/*     */             
/*     */             }
/*     */           }
/*  99 */           else if ((WORLD.LANDMARKS()).setter.get(tx, ty) != null) {
/* 100 */             WorldLandmark m = (WorldLandmark)(WORLD.LANDMARKS()).setter.get(tx, ty);
/* 101 */             b.title((CharSequence)m.name);
/* 102 */             b.text((CharSequence)m.description);
/* 103 */             (WORLD.OVERLAY()).landmarks.hover((WorldLandmark)(WORLD.LANDMARKS()).setter.get(tx, ty));
/*     */           } 
/*     */           
/* 106 */           b.NL(8);
/* 107 */           b.add((SPRITE)b.text().add(tx).add(':').add(ty));
/* 108 */           b.NL();
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     butts.add((new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_left)
/*     */         {
/*     */           protected void clickA() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           protected void renAction() {}
/* 132 */         }).hoverInfoSet(Dic.¤¤Back));
/* 133 */     butts.add((new GButt.ButtPanel((SPRITE)new SPRITE.Twin((SPRITE)(SPRITES.icons()).m.terrain, (SPRITE)(SPRITES.icons()).m.rotate))
/*     */         {
/*     */           protected void clickA() {
/* 136 */             StageCapitol.regenerate();
/*     */           }
/* 138 */         }).hoverInfoSet(WorldViewGenerator.¤¤regenerate));
/*     */     
/* 140 */     butts.add((new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA() {
/* 143 */             stages.window.centerAtTile((WORLD.GEN()).playerX, (WORLD.GEN()).playerY);
/*     */           }
/* 145 */         }).hoverInfoSet(WorldViewGenerator.¤¤home));
/*     */     
/* 147 */     butts.add((new GButt.ButtPanel((SPRITE)(SPRITES.icons()).m.arrow_right)
/*     */         {
/*     */           protected void clickA() {
/* 150 */             SPRITES.loader().minify(false, Dic.¤¤Generating);
/* 151 */             GAME.factions().prime();
/* 152 */             WORLD.ARMIES().saver().generate(WorldViewGenerator.loadPrint);
/* 153 */             (WORLD.GEN()).isDone = true;
/* 154 */             (WORLD.FOW()).toggled.set(true);
/* 155 */             VIEW.world().activate();
/* 156 */             (VIEW.world()).window.centererTile.set(FACTIONS.player().capitolRegion().cx(), FACTIONS.player().capitolRegion().cy());
/* 157 */             GAME.s().CreateFromWorldMap((WORLD.GEN()).playerX - 1, (WORLD.GEN()).playerY - 1, false);
/* 158 */             GAME.saver().saveNew();
/* 159 */             CORE.getInput().clearAllInput();
/*     */           }
/* 161 */         }).hoverInfoSet(Dic.¤¤OK));
/*     */     
/* 163 */     ToolConfig fixed = new ToolConfig()
/*     */       {
/*     */         
/*     */         public boolean back()
/*     */         {
/* 168 */           return false;
/*     */         }
/*     */ 
/*     */         
/*     */         public void addUI(LISTE<RENDEROBJ> uis) {
/* 173 */           stages.tools.placer.addStandardButtons(uis, false);
/*     */         }
/*     */       };
/*     */     
/* 177 */     stages.tools.place((PLACABLE)simp, fixed);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\generator\StageFinish.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */