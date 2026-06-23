/*     */ package view.tool;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GButtablePanel;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public final class ToolPlacer extends Tool {
/*     */   private boolean pressed;
/*     */   private placeFunc current;
/*     */   private placeFunc normal;
/*     */   private PLACABLE placer;
/*     */   private PLACABLE origional;
/*     */   private PLACABLE undo;
/*     */   private boolean buttonsStolen;
/*     */   private final GameWindow window;
/*     */   private GButt.Panel buttUndo;
/*     */   private GButt.Panel buttExit;
/*     */   private final ToolConfig configDefault;
/*     */   private final GButtablePanel panel;
/*     */   private final placeFunc multi;
/*     */   private final placeFunc fixed;
/*     */   private final placeFunc single2;
/*     */   private final placeFunc simple;
/*     */   private final placeFunc simpleTile;
/*     */   
/*     */   public static AREA area() {
/*  42 */     return PlacerArea.self;
/*     */   }
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
/*     */   public void addStandardButtons(LISTE<RENDEROBJ> uis, boolean exitAlso) {
/* 102 */     this.panel.clear();
/* 103 */     LIST<CLICKABLE> ps = this.normal.gui();
/*     */     
/* 105 */     int w = 0;
/* 106 */     if (this.origional.getAdditionalButt() != null) {
/* 107 */       for (CLICKABLE b : this.origional.getAdditionalButt()) {
/* 108 */         w += b.body().width();
/*     */       }
/*     */     }
/*     */     
/* 112 */     if (w > 120) {
/*     */       
/* 114 */       if (this.origional.getAdditionalButt() != null) {
/* 115 */         for (CLICKABLE b : this.origional.getAdditionalButt()) {
/* 116 */           this.panel.addButton(b);
/*     */         }
/*     */       }
/*     */       
/* 120 */       this.panel.nl();
/*     */       
/* 122 */       if (ps != null) {
/* 123 */         for (CLICKABLE b : ps) {
/* 124 */           this.panel.addButton(b);
/*     */         }
/*     */       }
/*     */       
/* 128 */       if (this.undo != null) {
/* 129 */         this.panel.addButton((CLICKABLE)this.buttUndo);
/*     */       }
/*     */     } else {
/*     */       
/* 133 */       if (ps != null) {
/* 134 */         for (CLICKABLE b : ps) {
/* 135 */           this.panel.addButton(b);
/*     */         }
/*     */       }
/*     */       
/* 139 */       if (this.undo != null) {
/* 140 */         this.panel.addButton((CLICKABLE)this.buttUndo);
/*     */       }
/* 142 */       if (this.origional.getAdditionalButt() != null) {
/* 143 */         for (CLICKABLE b : this.origional.getAdditionalButt()) {
/* 144 */           this.panel.addButton(b);
/*     */         }
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 151 */     this.panel.addTitle(this.placer.name());
/* 152 */     if (exitAlso) {
/* 153 */       this.panel.addButton((CLICKABLE)this.buttExit);
/*     */     }
/* 155 */     if (exitAlso) {
/* 156 */       this.panel.addButton((CLICKABLE)this.buttExit);
/*     */     }
/* 158 */     uis.add(this.panel);
/*     */   }
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
/*     */   ToolPlacer(ToolManager manager, GameWindow window) {
/* 176 */     super(manager); D.gInit(this); this.buttUndo = new GButt.Panel((SPRITE)(SPRITES.icons()).m.cancel) { protected void clickA() { if (ToolPlacer.this.placer != ToolPlacer.this.undo) { ToolPlacer.this.placer = ToolPlacer.this.undo; ToolPlacer.this.current = ToolPlacer.this.get(ToolPlacer.this.placer); ToolPlacer.this.current.activate(ToolPlacer.this.placer, ToolPlacer.this.window); selectedSet(true); } else { ToolPlacer.this.placer = ToolPlacer.this.origional; ToolPlacer.this.current = ToolPlacer.this.get(ToolPlacer.this.placer); ToolPlacer.this.current.activate(ToolPlacer.this.placer, ToolPlacer.this.window); selectedSet(true); }  } protected void renAction() { if (ToolPlacer.this.placer == ToolPlacer.this.undo) selectTmp();  } public void hoverInfoGet(GUI_BOX text) { text.text(ToolPlacer.this.undo.name()); text.text((KEYS.MAIN()).UNDO.repr()); } }
/* 177 */       ; this.buttExit = new GButt.Panel((SPRITE)(SPRITES.icons()).m.exit, D.g("Close")) { protected void clickA() { ToolPlacer.this.deactivate(); } }; this.configDefault = new ToolConfig() { public void addUI(LISTE<RENDEROBJ> uis) { if (!ToolPlacer.this.buttonsStolen) ToolPlacer.this.addStandardButtons(uis, true);  ToolPlacer.this.buttonsStolen = false; } }; this.panel = new GButtablePanel(); this.multi = new PlacableMultiTool(); this.fixed = new PlacableFixedTool(); this.single2 = new PlacableSingleTool(); this.simple = new PlacableSimpleTool(); this.simpleTile = new PlacableSimpleTileTool(); this.window = window;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void activate(PLACABLE placer) {
/* 184 */     this.buttUndo.selectedSet(false);
/*     */ 
/*     */     
/* 187 */     this.placer = placer;
/* 188 */     this.origional = placer;
/* 189 */     this.undo = placer.getUndo();
/*     */     
/* 191 */     this.normal = get(placer);
/* 192 */     this.normal.activate(placer, this.window);
/* 193 */     this.current = this.normal;
/*     */     
/* 195 */     this.pressed = false;
/*     */   }
/*     */ 
/*     */   
/*     */   private placeFunc get(PLACABLE placer) {
/* 200 */     if (placer instanceof PlacableFixed)
/* 201 */       return this.fixed; 
/* 202 */     if (placer instanceof PlacableSingle)
/* 203 */       return this.single2; 
/* 204 */     if (placer instanceof PlacableMulti)
/* 205 */       return this.multi; 
/* 206 */     if (placer instanceof PlacableSimple)
/* 207 */       return this.simple; 
/* 208 */     if (placer instanceof PlacableSimpleTile) {
/* 209 */       return this.simpleTile;
/*     */     }
/* 211 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void click(GameWindow window) {
/* 217 */     this.pressed = true;
/* 218 */     this.current.click(window);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateHovered(float ds, GameWindow window) {
/* 226 */     if (this.pressed && !MButt.LEFT.isDown()) {
/* 227 */       this.current.clickRelease(window);
/*     */     }
/* 229 */     update(ds, window);
/*     */     
/* 231 */     this.current.updateHovered(ds, window, this.pressed);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void update(float ds, GameWindow window) {
/* 237 */     if ((KEYS.MAIN()).UNDO.isPressed() && this.placer == this.origional && this.placer.getUndo() != null) {
/* 238 */       if (this.placer instanceof PlacableMulti && this.placer.getUndo() instanceof PlacableMulti)
/*     */       {
/*     */         
/* 241 */         ((PlacableMulti)this.placer.getUndo()).previous = ((PlacableMulti)this.placer).previous;
/*     */       }
/* 243 */       this.placer = this.placer.getUndo();
/* 244 */       if (this.placer == this.origional)
/* 245 */         throw new RuntimeException(String.valueOf(this.placer)); 
/* 246 */       this.current = get(this.placer);
/*     */       
/* 248 */       this.current.activate(this.placer, window);
/* 249 */     } else if (!this.buttUndo.selectedIs() && !(KEYS.MAIN()).UNDO.isPressed() && this.placer != this.origional) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 254 */       this.placer = this.origional;
/* 255 */       this.current = get(this.placer);
/* 256 */       this.current.activate(this.placer, window);
/*     */     } 
/*     */     
/* 259 */     if (this.placer == this.origional.getUndo()) {
/* 260 */       VIEW.mouse().setReplacement((SPRITE)(SPRITES.icons()).m.cancel);
/*     */     }
/* 262 */     this.current.update(ds, window, this.pressed);
/* 263 */     this.pressed &= MButt.LEFT.isDown();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void renderHovered(SPRITE_RENDERER r, float ds, GameWindow window, GBox box) {
/* 269 */     this.current.render(r, ds, window);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, GameWindow window) {}
/*     */ 
/*     */   
/*     */   public void stealButtons(GuiSection s) {
/* 278 */     stealButtons(s, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void stealButtons(GuiSection s, boolean undo) {
/* 283 */     this.buttonsStolen = true;
/*     */     
/* 285 */     LIST<CLICKABLE> ps = this.normal.gui();
/* 286 */     if (ps != null) {
/* 287 */       for (CLICKABLE c : ps) {
/* 288 */         s.addRightC(0, (RENDEROBJ)c);
/* 289 */         c.activeSet(true);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 294 */     if (undo && this.undo != null) {
/* 295 */       s.addRightC(0, (RENDEROBJ)this.buttUndo);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean rightClick() {
/* 307 */     if (this.pressed) {
/* 308 */       this.pressed = false;
/* 309 */       return false;
/*     */     } 
/* 311 */     return true;
/*     */   }
/*     */   
/*     */   static abstract class placeFunc {
/*     */     abstract void updateHovered(float param1Float, GameWindow param1GameWindow, boolean param1Boolean);
/*     */     
/*     */     void update(float ds, GameWindow window, boolean pressed) {}
/*     */     
/*     */     abstract void render(SPRITE_RENDERER param1SPRITE_RENDERER, float param1Float, GameWindow param1GameWindow);
/*     */     
/*     */     abstract void click(GameWindow param1GameWindow);
/*     */     
/*     */     abstract void clickRelease(GameWindow param1GameWindow);
/*     */     
/*     */     abstract void activate(PLACABLE param1PLACABLE, GameWindow param1GameWindow);
/*     */     
/*     */     abstract LIST<CLICKABLE> gui();
/*     */   }
/*     */   
/*     */   public PLACABLE getCurrent() {
/* 331 */     if (!isActivated())
/* 332 */       return null; 
/* 333 */     return this.placer;
/*     */   }
/*     */ 
/*     */   
/*     */   protected ToolConfig defaultConfig() {
/* 338 */     return this.configDefault;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\ToolPlacer.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */