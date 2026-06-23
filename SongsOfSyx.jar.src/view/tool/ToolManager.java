/*     */ package view.tool;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import util.gui.misc.GBox;
/*     */ import view.interrupter.InterManager;
/*     */ import view.interrupter.Interrupter;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ 
/*     */ public final class ToolManager extends Interrupter {
/*     */   private ToolConfig config;
/*     */   private Tool current;
/*     */   private Tool def;
/*     */   private boolean hovered;
/*     */   public final ToolPlacer placer;
/*     */   private final GameWindow window;
/*  24 */   private final ToolConfig configDummy = new ToolConfig() {  }
/*     */   ;
/*  26 */   private ArrayList<RENDEROBJ> rens = new ArrayList(16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Interrupter added;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GameWindow window() {
/*  41 */     return this.window;
/*     */   }
/*     */   
/*     */   public ToolManager setDefault(Tool def) {
/*  45 */     this.def = def;
/*  46 */     if (this.current == null)
/*  47 */       set(def, def.defaultConfig(), true); 
/*  48 */     return this;
/*     */   }
/*     */   
/*     */   public void setHovered(boolean hovered) {
/*  52 */     this.hovered = hovered;
/*     */   }
/*     */   
/*     */   public boolean isHovered() {
/*  56 */     return this.hovered;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean update(float ds) {
/*  64 */     this.window.update(ds);
/*  65 */     if (this.current == null) {
/*  66 */       return true;
/*     */     }
/*  68 */     this.config.update(!this.hovered);
/*  69 */     if (this.current != null) {
/*  70 */       if (this.hovered) {
/*  71 */         this.current.updateHovered(ds, this.window);
/*     */       } else {
/*  73 */         this.current.update(ds, this.window);
/*     */       } 
/*     */     }
/*     */     
/*  77 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void place(PLACABLE placer, ToolConfig config) {
/*  82 */     if (placer == null) {
/*  83 */       set((Tool)null, (ToolConfig)null, true);
/*     */       return;
/*     */     } 
/*  86 */     this.placer.activate(placer);
/*  87 */     set(this.placer, config, true);
/*     */   }
/*     */   
/*     */   public void place(PLACABLE placer, ToolConfig config, boolean disturb) {
/*  91 */     if (placer == null) {
/*  92 */       set((Tool)null, (ToolConfig)null, disturb);
/*     */       return;
/*     */     } 
/*  95 */     this.placer.activate(placer);
/*  96 */     set(this.placer, config, disturb);
/*     */   }
/*     */   
/*     */   public void place(PLACABLE placer) {
/* 100 */     if (placer == null) {
/* 101 */       set((Tool)null, (ToolConfig)null, true);
/*     */       return;
/*     */     } 
/* 104 */     this.placer.activate(placer);
/* 105 */     set(this.placer, (ToolConfig)null, true);
/*     */   }
/*     */   
/*     */   public void set(Tool t) {
/* 109 */     if (this.placer == null) {
/* 110 */       set((Tool)null, (ToolConfig)null, true);
/*     */       return;
/*     */     } 
/* 113 */     set(t, t.defaultConfig(), true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Tool t, ToolConfig config, boolean disturb) {
/* 120 */     this.rens.clear();
/* 121 */     if (config != null) {
/* 122 */       config.addUI((LISTE<RENDEROBJ>)this.rens);
/*     */     }
/* 124 */     if (t == this.current && this.config == config) {
/*     */       return;
/*     */     }
/* 127 */     ToolConfig old = this.config;
/*     */ 
/*     */ 
/*     */     
/* 131 */     if (t == null) {
/* 132 */       t = this.def;
/*     */     }
/*     */     
/* 135 */     this.config = config;
/* 136 */     if (this.config == null && t != null) {
/* 137 */       this.config = t.defaultConfig();
/*     */     }
/* 139 */     if (this.config == null) {
/* 140 */       this.config = this.configDummy;
/*     */     }
/* 142 */     this.config.activateAction();
/*     */ 
/*     */     
/* 145 */     this.current = t;
/* 146 */     if (disturb)
/* 147 */       manager().disturb(); 
/* 148 */     if (this.added.isActivated())
/* 149 */       manager().remove(this.added); 
/* 150 */     manager().add(this.added);
/*     */     
/* 152 */     if (old != null)
/* 153 */       old.deactivateAction(); 
/*     */   }
/*     */   
/*     */   public boolean is(PLACABLE t) {
/* 157 */     return (isActivated() && this.current == this.placer && this.placer.getCurrent() == t);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 162 */     this.hovered = true;
/*     */     
/* 164 */     for (RENDEROBJ r : this.rens) {
/* 165 */       if (r instanceof HOVERABLE && (
/* 166 */         (HOVERABLE)r).hover(mCoo))
/*     */       {
/* 168 */         this.hovered = false;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 173 */     if (this.hovered) {
/* 174 */       this.window.hover();
/*     */     }
/* 176 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/* 181 */     if (button == MButt.LEFT) {
/* 182 */       for (RENDEROBJ r : this.rens) {
/* 183 */         if (r instanceof CLICKABLE && (
/* 184 */           (CLICKABLE)r).hoveredIs()) {
/* 185 */           ((CLICKABLE)r).click();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 190 */       if (this.hovered && this.current != null)
/* 191 */         this.current.click(this.window); 
/*     */     } else {
/* 193 */       otherClick(button);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected boolean otherClick(MButt button) {
/* 198 */     if (button == MButt.RIGHT) {
/* 199 */       if (this.current != null && this.current.rightClick() && 
/* 200 */         this.config.back()) {
/* 201 */         set((Tool)null, (ToolConfig)null, false);
/*     */       }
/* 203 */       return true;
/*     */     } 
/* 205 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {
/* 210 */     for (RENDEROBJ r : this.rens) {
/* 211 */       if (r instanceof HOVERABLE && (
/* 212 */         (HOVERABLE)r).hoveredIs()) {
/* 213 */         ((HOVERABLE)r).hoverInfoGet((GUI_BOX)text);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/* 222 */     if (this.rens.size() > 0) {
/* 223 */       for (RENDEROBJ re : this.rens) {
/* 224 */         re.render((SPRITE_RENDERER)r, ds);
/*     */       }
/*     */     }
/*     */     
/* 228 */     r.newLayer(true, this.window.zoomout());
/*     */ 
/*     */     
/* 231 */     if (this.current == null)
/* 232 */       return true; 
/* 233 */     if (this.hovered) {
/* 234 */       this.current.renderHovered((SPRITE_RENDERER)r, ds, this.window, VIEW.hoverBox());
/*     */     } else {
/* 236 */       this.current.render((SPRITE_RENDERER)r, ds, this.window);
/*     */     } 
/* 238 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void afterTick() {
/* 243 */     this.rens.clear();
/* 244 */     if (this.current != null)
/* 245 */       this.config.addUI((LISTE<RENDEROBJ>)this.rens); 
/* 246 */     this.hovered = false;
/*     */   }
/*     */   
/*     */   public Tool current() {
/* 250 */     return this.current;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ToolManager(InterManager manager, GameWindow window) {
/* 257 */     this.added = new Interrupter()
/*     */       {
/*     */         protected boolean update(float ds)
/*     */         {
/* 261 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         protected boolean render(Renderer r, float ds) {
/* 266 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected void mouseClick(MButt button) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean otherClick(MButt button) {
/* 276 */           if (ToolManager.this.current != null && ToolManager.this.current != ToolManager.this.def)
/* 277 */             return ToolManager.this.otherClick(button); 
/* 278 */           hide();
/* 279 */           return false;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         protected void hoverTimer(GBox text) {}
/*     */ 
/*     */ 
/*     */         
/*     */         protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 290 */           return false; } }; this.window = window;
/*     */     this.placer = new ToolPlacer(this, window);
/*     */     lastSet();
/*     */     pin();
/*     */     persistantSet();
/* 295 */     show(manager); } public ToolConfig configCurrent() { return this.config; }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\tool\ToolManager.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */