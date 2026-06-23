/*     */ package view.world.editor;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.SaveFile;
/*     */ import game.time.TIME;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GSliderInt;
/*     */ import util.text.Dic;
/*     */ import util.text.DicTime;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.world.generator.WorldViewGenerator;
/*     */ import view.world.generator.tools.UIWorldGenerateTerrain;
/*     */ import view.world.panel.UIMinimapW;
/*     */ import world.WORLD;
/*     */ 
/*     */ final class TopPanel
/*     */   extends Interrupter
/*     */ {
/*  44 */   private final GuiSection section = new GuiSection();
/*     */   private final GuiSection map;
/*     */   private final WorldViewEditor w;
/*  47 */   private final CLICKABLE.ClickSwitch current = new CLICKABLE.ClickSwitch(1200, 48);
/*     */   
/*     */   public TopPanel(WorldViewEditor w) {
/*  50 */     pin();
/*  51 */     this.current.setD(DIR.N);
/*  52 */     this.section.body().setDim(C.WIDTH(), 89.0D);
/*  53 */     this.section.body().moveX2(C.WIDTH());
/*  54 */     this.section.body().moveY2(C.HEIGHT());
/*  55 */     this.map = new IMinimap(w.window);
/*  56 */     this.map.body().moveY1(0.0D);
/*  57 */     this.w = w;
/*     */     
/*  59 */     GuiSection buttons = new GuiSection();
/*     */ 
/*     */     
/*  62 */     G g = new G(this, (WORLD.WorldResource)WORLD.TERRAIN())
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  66 */           UIWorldGenerateTerrain uIWorldGenerateTerrain = new UIWorldGenerateTerrain(WORLD.GEN());
/*  67 */           uIWorldGenerateTerrain.addRelBody(8, DIR.S, (RENDEROBJ)new GButt.ButtPanel(Dic.¤¤Generate)
/*     */               {
/*     */                 protected void clickA() {
/*  70 */                   WORLD.TERRAIN().saver().generate(WorldViewGenerator.loadPrint);
/*     */                 }
/*     */               });
/*  73 */           (VIEW.inters()).popup.show((RENDEROBJ)uIWorldGenerateTerrain, (CLICKABLE)this);
/*     */         }
/*     */       };
/*     */     
/*  77 */     buttons.addRightC(0, (RENDEROBJ)topButt((WORLD.WorldResource)WORLD.TERRAIN(), (CLICKABLE)g, new CLICKABLE[0]));
/*     */ 
/*     */     
/*  80 */     buttons.addRightC(0, (RENDEROBJ)topButt((WORLD.WorldResource)WORLD.LANDMARKS(), (CLICKABLE)null, new CLICKABLE[0]));
/*  81 */     buttons.addRightC(0, (RENDEROBJ)topButt((WORLD.WorldResource)WORLD.BUILDINGS(), (CLICKABLE)null, new CLICKABLE[0]));
/*  82 */     buttons.addRightC(0, (RENDEROBJ)topButt((WORLD.WorldResource)WORLD.REGIONS(), (CLICKABLE)null, new CLICKABLE[0]));
/*  83 */     buttons.addRightC(0, (RENDEROBJ)topButt((WORLD.WorldResource)WORLD.ENTITIES(), (CLICKABLE)null, new CLICKABLE[0]));
/*  84 */     buttons.addRightC(0, (RENDEROBJ)topButt((WORLD.WorldResource)WORLD.ROADS(), (CLICKABLE)null, new CLICKABLE[0]));
/*  85 */     buttons.addRightC(0, (RENDEROBJ)topButt((WORLD.WorldResource)WORLD.PATH(), (CLICKABLE)null, new CLICKABLE[0]));
/*     */     
/*  87 */     CLICKABLE prime = (new GButt.ButtPanel((SPRITE)new SPRITE.Resized((SPRITE)(UI.icons()).m.arrow_up, 32))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  91 */           WORLD.RD().prime();
/*     */         }
/*  94 */       }).hoverInfoSet("grow and build regions and factions");
/*     */     
/*  96 */     buttons.addRightC(0, (RENDEROBJ)topButt((WORLD.WorldResource)WORLD.RD(), (CLICKABLE)null, new CLICKABLE[] { prime }));
/*     */ 
/*     */ 
/*     */     
/* 100 */     buttons.addRelBody(4, DIR.S, (RENDEROBJ)this.current);
/*     */     
/* 102 */     buttons.addRelBody(32, DIR.E, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)new SPRITE.Resized((SPRITE)(UI.icons()).m.crossair, 32))
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 107 */             if ((WORLD.REGIONS()).player.active()) {
/* 108 */               (VIEW.world()).editor.window.centererTile.set((WORLD.REGIONS()).player.cx(), (WORLD.REGIONS()).player.cy());
/*     */             }
/*     */           }
/* 111 */         }).hoverInfoSet("go to player capitol"));
/*     */ 
/*     */     
/* 114 */     buttons.addRelBody(32, DIR.E, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)new SPRITE.Resized((SPRITE)(UI.icons()).m.time, 32))
/*     */         {
/*     */           INT.IntImp tt;
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
/*     */           INT.IntImp th;
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
/*     */           GuiSection s;
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
/*     */           protected void clickA() {
/* 167 */             (VIEW.inters()).popup.show((RENDEROBJ)this.s, (CLICKABLE)this);
/*     */           }
/* 170 */         }).hoverInfoSet("set time"));
/*     */ 
/*     */     
/* 173 */     buttons.addRelBody(0, DIR.E, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)new SPRITE.Resized((SPRITE)(UI.icons()).m.arrow_right, 32))
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 178 */             WORLD.WorldError e = new WORLD.WorldError();
/*     */ 
/*     */             
/* 181 */             for (int ri = 0; ri < WORLD.RESOURCES().size(); ri++) {
/* 182 */               WORLD.WorldResource r = (WORLD.WorldResource)WORLD.RESOURCES().get(ri);
/* 183 */               WorldViewGenerator.loadPrint.exe();
/* 184 */               r.saver().validateInit(e);
/* 185 */               if (e.problem != null) {
/*     */                 
/* 187 */                 (VIEW.inters()).yesNo.activate("ERROR: " + String.valueOf(e.problem), ACTION.NOP, null, true);
/* 188 */                 (VIEW.world()).editor.window.centererTile.set((COORDINATE)e.coo);
/*     */                 
/*     */                 return;
/*     */               } 
/*     */             } 
/*     */             
/* 194 */             if (e.warning != null) {
/* 195 */               (VIEW.inters()).yesNo.activate("WARNING: " + String.valueOf(e.warning), ACTION.NOP, null, true);
/* 196 */               (VIEW.world()).editor.window.centererTile.set((COORDINATE)e.coo);
/*     */             }
/*     */           
/*     */           }
/* 200 */         }).hoverInfoSet("validate"));
/*     */     
/* 202 */     buttons.addRelBody(0, DIR.E, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)new SPRITE.Resized((SPRITE)(UI.icons()).m.menu2, 32))
/*     */         {
/*     */           
/*     */           protected void clickA()
/*     */           {
/* 207 */             WORLD.WorldError e = new WORLD.WorldError();
/*     */             
/* 209 */             (WORLD.GEN()).playerX = -1;
/* 210 */             (WORLD.GEN()).hasGeneratedTerrain = false;
/*     */             
/* 212 */             for (int ri = 0; ri < WORLD.RESOURCES().size(); ri++) {
/* 213 */               WORLD.WorldResource r = (WORLD.WorldResource)WORLD.RESOURCES().get(ri);
/* 214 */               WorldViewGenerator.loadPrint.exe();
/* 215 */               r.saver().validateInit(e);
/*     */               
/* 217 */               if (e.problem != null) {
/*     */                 break;
/*     */               }
/*     */ 
/*     */               
/* 222 */               if (r == WORLD.TERRAIN()) {
/* 223 */                 (WORLD.GEN()).hasGeneratedTerrain = true;
/*     */               }
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 229 */             if (e.problem != null) {
/* 230 */               if ((WORLD.GEN()).hasGeneratedTerrain) {
/* 231 */                 STRING_RECIEVER ss = new STRING_RECIEVER()
/*     */                   {
/*     */                     public void acceptString(CharSequence string)
/*     */                     {
/* 235 */                       if (string != null) {
/* 236 */                         string = SaveFile.stamp(string);
/* 237 */                         (WORLD.GEN()).isEditing = false;
/* 238 */                         GAME.saver().save(String.valueOf(string));
/* 239 */                         (WORLD.GEN()).isEditing = true;
/* 240 */                         (VIEW.inters()).yesNo.activate("The world terrain was saved. The other layers were invalid, so could not be saved.", ACTION.NOP, null, true);
/*     */                       } 
/*     */                     }
/*     */                   };
/*     */                 
/* 245 */                 (VIEW.inters()).input.requestInput(ss, "name save");
/*     */               } else {
/* 247 */                 (VIEW.inters()).yesNo.activate("can't save: " + String.valueOf(e.problem), ACTION.NOP, null, true);
/* 248 */                 (VIEW.world()).editor.window.centererTile.set((COORDINATE)e.coo);
/*     */               
/*     */               }
/*     */             
/*     */             }
/*     */             else {
/*     */               
/* 255 */               (WORLD.GEN()).playerX = (WORLD.REGIONS()).player.cx();
/* 256 */               (WORLD.GEN()).playerY = (WORLD.REGIONS()).player.cy();
/* 257 */               STRING_RECIEVER ss = new STRING_RECIEVER()
/*     */                 {
/*     */                   public void acceptString(CharSequence string)
/*     */                   {
/* 261 */                     if (string != null) {
/* 262 */                       string = SaveFile.stamp(string);
/* 263 */                       (WORLD.GEN()).isEditing = false;
/* 264 */                       GAME.saver().save(String.valueOf(string));
/* 265 */                       (WORLD.GEN()).isEditing = true;
/* 266 */                       (VIEW.inters()).yesNo.activate("Save was a stunning success.", ACTION.NOP, null, true);
/*     */                     } 
/*     */                   }
/*     */                 };
/*     */               
/* 271 */               (VIEW.inters()).input.requestInput(ss, "name save");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             }
/*     */           
/*     */           }
/* 281 */         }).hoverInfoSet("save as playable map"));
/*     */     
/* 283 */     buttons.body().centerIn((BODY_HOLDER)this.section);
/* 284 */     this.section.add((RENDEROBJ)buttons);
/*     */ 
/*     */     
/* 287 */     show(w.uiManager);
/*     */   }
/*     */   
/*     */   private class G extends GButt.ButtPanel {
/*     */     WORLD.WorldResource res;
/*     */     final ACTION a;
/*     */     
/*     */     G(WORLD.WorldResource res) {
/* 295 */       super((UI.icons()).m.rotate.resized(32));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 300 */       this.a = new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 304 */             TopPanel.G.this.res.saver().clear();
/* 305 */             TopPanel.G.this.res.saver().generate(WorldViewGenerator.loadPrint);
/*     */           }
/*     */         };
/*     */       hoverTitleSet("Generate: " + String.valueOf(res.name));
/*     */       this.res = res;
/*     */     }
/*     */     protected void clickA() {
/* 312 */       (VIEW.inters()).yesNo.activate("Are you sure you wish to remove progress and randomly generate layer?", this.a, ACTION.NOP, true);
/*     */     }
/*     */   }
/*     */   
/*     */   private class V
/*     */     extends GButt.ButtPanel
/*     */   {
/*     */     WORLD.WorldResource res;
/*     */     
/*     */     V(WORLD.WorldResource res) {
/* 322 */       super((UI.icons()).m.arrow_right.resized(32));
/* 323 */       hoverTitleSet("validate: " + String.valueOf(res.name));
/* 324 */       this.res = res;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 330 */       WORLD.WorldError e = new WORLD.WorldError();
/*     */       
/* 332 */       this.res.saver().validateInit(e);
/*     */       
/* 334 */       if (e.problem != null) {
/* 335 */         TopPanel.this.error(e);
/* 336 */       } else if (e.warning != null) {
/* 337 */         (VIEW.inters()).yesNo.activate("WARNING: " + String.valueOf(e.warning), ACTION.NOP, ACTION.NOP, true);
/*     */       } else {
/*     */         
/* 340 */         (VIEW.inters()).yesNo.activate(String.valueOf(this.res.name) + " is OK!", ACTION.NOP, ACTION.NOP, true);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void error(WORLD.WorldError e) {
/* 347 */     if (e.problem != null) {
/* 348 */       (VIEW.inters()).yesNo.activate("ERROR: " + String.valueOf(e.problem), ACTION.NOP, null, true);
/* 349 */       (VIEW.world()).editor.window.centererTile.set((COORDINATE)e.coo);
/*     */     } 
/*     */   }
/*     */   
/*     */   private class Clear extends GButt.ButtPanel {
/*     */     WORLD.WorldResource res;
/*     */     final ACTION a;
/*     */     
/*     */     Clear(WORLD.WorldResource res) {
/* 358 */       super((UI.icons()).m.cancel.resized(32));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 363 */       this.a = new ACTION()
/*     */         {
/*     */           public void exe()
/*     */           {
/* 367 */             TopPanel.Clear.this.res.saver().clear();
/*     */           }
/*     */         };
/*     */       hoverTitleSet("clear everything: " + String.valueOf(res.name));
/*     */       this.res = res;
/*     */     }
/*     */     protected void clickA() {
/* 374 */       (VIEW.inters()).yesNo.activate("Are you sure you wish to completely clear this layer?", this.a, ACTION.NOP, true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class B
/*     */     extends GButt.ButtPanel
/*     */   {
/*     */     private final PLACABLE p;
/*     */     
/*     */     B(PLACABLE p) {
/* 385 */       super(p.getIcon().resized(32));
/* 386 */       this.p = p;
/*     */     }
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 391 */       text.title(this.p.name());
/*     */     }
/*     */ 
/*     */     
/*     */     protected void renAction() {
/* 396 */       selectedSet((TopPanel.this.w.tools.placer.isActivated() && TopPanel.this.w.tools.placer.getCurrent() == this.p));
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 401 */       TopPanel.this.w.tools.place(this.p);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private CLICKABLE topButt(final WORLD.WorldResource res, CLICKABLE gen, CLICKABLE... extra) {
/*     */     G g;
/* 408 */     final GuiSection row = new GuiSection();
/*     */ 
/*     */     
/* 411 */     PLACABLE pfirst = null;
/* 412 */     for (PLACABLE p : res.saver().makePlacers(this.w.tools)) {
/* 413 */       if (pfirst == null)
/* 414 */         pfirst = p; 
/* 415 */       row.addRightC(0, (RENDEROBJ)new B(p));
/*     */     } 
/*     */     
/* 418 */     if (gen == null) {
/* 419 */       g = new G(res);
/*     */     }
/*     */     
/* 422 */     row.addRightC(16, (RENDEROBJ)g);
/*     */     
/* 424 */     row.addRightC(0, (RENDEROBJ)new V(res));
/* 425 */     row.addRightC(0, (RENDEROBJ)new Clear(res));
/*     */     
/* 427 */     if (this.current.current() == null)
/* 428 */       this.current.set((RENDEROBJ)row); 
/* 429 */     final PLACABLE pp = pfirst;
/* 430 */     return (CLICKABLE)new GButt.ButtPanel(res.name)
/*     */       {
/*     */         protected void renAction()
/*     */         {
/* 434 */           selectedSet((TopPanel.this.current.current() == row));
/* 435 */           if (selectedIs()) {
/* 436 */             res.saver().addDebugView();
/*     */           }
/*     */         }
/*     */         
/*     */         protected void clickA() {
/* 441 */           TopPanel.this.current.set((RENDEROBJ)row);
/* 442 */           (VIEW.world()).editor.tools.place(pp);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean render(Renderer r, float ds) {
/* 453 */     if (manager().viewPort().y2() >= C.HEIGHT() - this.section.body().height()) {
/* 454 */       manager().viewPort().setHeight((C.HEIGHT() - this.section.body().height()));
/*     */     }
/*     */     
/* 457 */     this.map.render((SPRITE_RENDERER)r, ds);
/* 458 */     (GCOLOR.UI()).panBG.render((SPRITE_RENDERER)r, (RECTANGLE)this.section.body());
/* 459 */     this.section.render((SPRITE_RENDERER)r, ds);
/*     */     
/* 461 */     GCOLOR.UI().border((SPRITE_RENDERER)r, 0, C.WIDTH(), this.section.body().y1(), this.section.body().y1() + 3);
/* 462 */     return true;
/*     */   }
/*     */   
/*     */   public void hide(boolean yes) {
/* 466 */     this.section.visableSet(yes);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 471 */     return !((this.section.hover(mCoo) | this.map.hover(mCoo)) == 0 && !mCoo.touchesRec((BODY_HOLDER)this.section));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 476 */     if (button == MButt.LEFT) {
/* 477 */       this.section.click();
/* 478 */       this.map.click();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 484 */     this.section.hoverInfoGet((GUI_BOX)text);
/* 485 */     this.map.hoverInfoGet((GUI_BOX)text);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 491 */     return true;
/*     */   }
/*     */   
/*     */   public static int y2() {
/* 495 */     return 46;
/*     */   }
/*     */   
/*     */   private static class IMinimap
/*     */     extends GuiSection {
/*     */     private final UIMinimapW map;
/* 501 */     private final GuiSection buttons = new GuiSection();
/*     */ 
/*     */     
/*     */     public IMinimap(final GameWindow w) {
/* 505 */       this.map = new UIMinimapW(w);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 513 */       GButt.Panel panel = new GButt.Panel((SPRITE)(SPRITES.icons()).m.plus)
/*     */         {
/*     */           protected void clickA() {
/* 516 */             if (w.zoomout() > 0) {
/* 517 */               w.setZoomout(w.zoomout() - 1);
/*     */             }
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 522 */             activeSet((w.zoomout() > 0));
/*     */           }
/*     */         };
/* 525 */       this.buttons.addRightC(32, (RENDEROBJ)panel);
/*     */       
/* 527 */       panel = new GButt.Panel((SPRITE)(SPRITES.icons()).m.minus)
/*     */         {
/*     */           protected void clickA() {
/* 530 */             if (w.zoomout() < 3) {
/* 531 */               w.setZoomout(w.zoomout() + 1);
/*     */             }
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 536 */             activeSet((w.zoomout() < 3));
/*     */           }
/*     */         };
/* 539 */       this.buttons.addRightC(0, (RENDEROBJ)panel);
/*     */       
/* 541 */       RENDEROBJ.RenderImp renderImp = new RENDEROBJ.RenderImp(this.map.body().width(), 32)
/*     */         {
/*     */           public void render(SPRITE_RENDERER r, float ds)
/*     */           {
/* 545 */             (UI.PANEL()).butt.render(r, (RECTANGLE)this.body, 0, DIR.S, DIR.W);
/*     */           }
/*     */         };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 554 */       this.buttons.body().moveX2((C.WIDTH() - 4));
/* 555 */       this.buttons.body().moveY1(0.0D);
/* 556 */       renderImp.body().moveX2(C.WIDTH());
/* 557 */       this.buttons.add((RENDEROBJ)renderImp);
/* 558 */       this.buttons.moveLastToBack();
/*     */       
/* 560 */       add((RENDEROBJ)this.buttons);
/*     */       
/* 562 */       this.map.body().moveY1(this.buttons.body().y2());
/* 563 */       this.map.body().moveX2(C.DIM().width());
/* 564 */       add((RENDEROBJ)this.map);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\world\editor\TopPanel.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */