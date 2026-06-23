/*     */ package view.sett.ui.right;
/*     */ import init.constant.C;
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import settlement.main.SETT;
/*     */ import settlement.tilemap.SettMarks;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GColorPicker;
/*     */ import util.gui.misc.GInput;
/*     */ import util.gui.misc.GText;
/*     */ import util.gui.slider.GTarget;
/*     */ import util.text.D;
/*     */ import view.main.VIEW;
/*     */ import view.subview.GameWindow;
/*     */ import view.tool.PLACABLE;
/*     */ import view.tool.PlacableSingle;
/*     */ 
/*     */ final class UIMiniHotSpots extends UIPanelRightSett.Expansion {
/*  37 */   private final int width = 36;
/*  38 */   private final GText text = new GText((UI.FONT()).S, 20);
/*  39 */   private final ColorImp colorImp = new ColorImp();
/*     */ 
/*     */   
/*     */   private final GameWindow window;
/*     */   
/*  44 */   private final Panel panel = new Panel();
/*  45 */   private static CharSequence ¤¤order = "¤ORDER";
/*  46 */   private static CharSequence ¤¤set = "¤Set Hotspot";
/*  47 */   private static CharSequence ¤¤setLong = "¤Sets a hotspot that can easily be navigated to with a single click.";
/*  48 */   private static CharSequence ¤¤setExp = "¤Left click to go to hotspot. Right click to edit."; private final PlacableSingle placer;
/*     */   
/*     */   static {
/*  51 */     D.ts(UIMiniHotSpots.class);
/*     */   }
/*     */   
/*     */   protected UIMiniHotSpots(int index, int y1, GameWindow window) {
/*  55 */     super(index);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     this.placer = new PlacableSingle(¤¤set)
/*     */       {
/*     */         public void placeFirst(int tx, int ty)
/*     */         {
/*  68 */           SettMarks.SettMark d = (SETT.TILE_MAP()).marks.make();
/*  69 */           if (d != null)
/*  70 */             d.set(tx, ty); 
/*  71 */           (VIEW.s()).tools.placer.deactivate();
/*     */         }
/*     */ 
/*     */         
/*     */         public CharSequence isPlacable(int tx, int ty) {
/*  76 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public SPRITE getIcon() {
/*  81 */           return (SPRITE)(SPRITES.icons()).m.crossair;
/*     */         }
/*     */       };
/*     */     this.window = window;
/*     */     add((RENDEROBJ)new View(y1));
/*     */   }
/*     */   
/*     */   private final class Button extends CLICKABLE.ClickableAbs { private SettMarks.SettMark d;
/*     */     
/*     */     Button(int i) {
/*  91 */       this.body.setWidth(36.0D).setHeight(32.0D);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  96 */       COLOR.WHITE25.render(r, body().x1(), this.body.x2(), body().y1(), this.body.y1() + 1);
/*  97 */       UIMiniHotSpots.this.colorImp.set((COLOR)this.d.color);
/*  98 */       if (isHovered || isSelected)
/*  99 */         UIMiniHotSpots.this.colorImp.shadeSelf(1.5D); 
/* 100 */       UIMiniHotSpots.this.colorImp.render(r, body().x1(), this.body.x2(), body().y1(), this.body.y2() - 1);
/* 101 */       COLOR.WHITE25.render(r, body().x1(), this.body.x2(), body().y2() - 1, this.body.y2());
/*     */       
/* 103 */       if (isHovered || isSelected) {
/* 104 */         COLOR.WHITE15.render(r, body().x1(), body().x2(), body().y1() + 6, body().y2() - 6);
/*     */       } else {
/* 106 */         COLOR.WHITE10.render(r, body().x1(), body().x2(), body().y1() + 6, body().y2() - 6);
/*     */       } 
/* 108 */       if (this.d.name.length() > 0) {
/* 109 */         UIMiniHotSpots.this.text.clear();
/* 110 */         UIMiniHotSpots.this.text.add((CharSequence)this.d.name, 0, 2);
/* 111 */         UIMiniHotSpots.this.text.adjustWidth();
/* 112 */         UIMiniHotSpots.this.text.renderC(r, (RECTANGLE)this.body);
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     void set(SettMarks.SettMark d) {
/* 118 */       this.d = d;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 123 */       if (MButt.RIGHT.isDown()) {
/* 124 */         UIMiniHotSpots.this.panel.init(this.d);
/* 125 */         (VIEW.inters()).popup.show((RENDEROBJ)UIMiniHotSpots.this.panel, (CLICKABLE)this);
/*     */       } 
/* 127 */       UIMiniHotSpots.this.window.centererTile.set((COORDINATE)this.d.tile);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void hoverInfoGet(GUI_BOX text) {
/* 133 */       GBox b = (GBox)text;
/* 134 */       b.textLL((CharSequence)this.d.name);
/* 135 */       b.text(UIMiniHotSpots.¤¤setExp);
/* 136 */       super.hoverInfoGet(text);
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CLICKABLE get(int y1) {
/* 144 */     return (CLICKABLE)new View(y1);
/*     */   }
/*     */   
/*     */   private class View
/*     */     extends GuiSection {
/* 149 */     private final GuiSection section = new GuiSection();
/*     */     private final CLICKABLE toggle;
/* 151 */     private int bi = 0;
/*     */     private final UIMiniHotSpots.Button[] buttons;
/*     */     
/*     */     View(int y1) {
/* 155 */       (SETT.TILE_MAP()).marks.getClass(); this.buttons = new UIMiniHotSpots.Button[32];
/* 156 */       int i = 0; (SETT.TILE_MAP()).marks.getClass(); for (; i < 32; i++) {
/* 157 */         this.buttons[i] = new UIMiniHotSpots.Button(i);
/*     */       }
/* 159 */       body().setWidth(42.0D).setHeight((C.HEIGHT() - y1));
/* 160 */       body().moveX2(C.WIDTH());
/* 161 */       body().moveY1(y1);
/*     */ 
/*     */       
/* 164 */       this.section.merge(this.section);
/*     */       
/* 166 */       this.toggle = (new GButt.Panel((SPRITE)(SPRITES.icons()).m.crossair)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 170 */             (SETT.TILE_MAP()).marks.getClass(); if ((SETT.TILE_MAP()).marks.active().size() < 32) {
/* 171 */               (VIEW.s()).tools.place((PLACABLE)(UIMiniHotSpots.View.access$0(UIMiniHotSpots.View.this)).placer);
/*     */               return;
/*     */             } 
/*     */           }
/* 175 */         }).hoverInfoSet(UIMiniHotSpots.¤¤setLong);
/*     */       
/* 177 */       this.toggle.body().moveY1((body().y1() + 10));
/* 178 */       this.toggle.body().centerX((BODY_HOLDER)this);
/* 179 */       add((RENDEROBJ)this.toggle);
/* 180 */       this.section.body().moveY1(this.toggle.body().y1());
/* 181 */       this.section.body().centerX((RECTANGLE)body());
/* 182 */       add((RENDEROBJ)this.section);
/*     */     }
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 187 */       if (this.bi != (SETT.TILE_MAP()).marks.state()) {
/* 188 */         this.section.clear();
/* 189 */         int i = 0;
/* 190 */         for (SettMarks.SettMark b : (SETT.TILE_MAP()).marks.active()) {
/* 191 */           if (b.active) {
/* 192 */             this.buttons[i].set(b);
/* 193 */             this.section.addDownC(0, (RENDEROBJ)this.buttons[i]);
/* 194 */             i++;
/*     */           } 
/*     */         } 
/* 197 */         this.section.body().centerX((BODY_HOLDER)this.toggle);
/* 198 */         this.section.body().moveY1((this.toggle.body().y2() + 8));
/* 199 */         this.bi = (SETT.TILE_MAP()).marks.state();
/*     */       } 
/* 201 */       if (visableIs()) {
/* 202 */         (GCOLOR.UI()).panBG.render(r, (RECTANGLE)body());
/* 203 */         super.render(r, ds);
/* 204 */         GCOLOR.UI().borderH(r, (RECTANGLE)body(), 0);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private class Panel
/*     */     extends GuiSection
/*     */   {
/*     */     GInput name;
/*     */     
/*     */     private SettMarks.SettMark data;
/*     */ 
/*     */     
/*     */     void init(SettMarks.SettMark data) {
/* 219 */       this.data = data;
/* 220 */       this.name.text().clear().add((CharSequence)data.name);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     Panel() {
/* 226 */       this.name = new GInput(new StringInputSprite(20, (UI.FONT()).M)
/*     */           {
/*     */             protected void change()
/*     */             {
/* 230 */               UIMiniHotSpots.Panel.this.data.name.clear().add((CharSequence)text());
/*     */             }
/*     */           });
/* 233 */       add((RENDEROBJ)this.name, 0, 0);
/*     */       
/* 235 */       addRightC(20, (RENDEROBJ)new GButt.Panel((SPRITE)(SPRITES.icons()).m.trash)
/*     */           {
/*     */             protected void clickA() {
/* 238 */               UIMiniHotSpots.Panel.this.data.remove();
/* 239 */               (VIEW.inters()).popup.close();
/*     */             }
/*     */           });
/*     */       
/* 243 */       addRelBody(8, DIR.S, (RENDEROBJ)new GColorPicker(false)
/*     */           {
/*     */             public ColorImp color()
/*     */             {
/* 247 */               return UIMiniHotSpots.Panel.this.data.color;
/*     */             }
/*     */           });
/*     */       
/* 251 */       INT.INTE order = new INT.INTE()
/*     */         {
/*     */           public int min()
/*     */           {
/* 255 */             return 0;
/*     */           }
/*     */ 
/*     */           
/*     */           public int max() {
/* 260 */             int i = 0;
/* 261 */             for (SettMarks.SettMark d : (SETT.TILE_MAP()).marks.active()) {
/* 262 */               if (d.active)
/* 263 */                 i++; 
/*     */             } 
/* 265 */             return i - 1;
/*     */           }
/*     */ 
/*     */           
/*     */           public int get() {
/* 270 */             int i = 0;
/* 271 */             for (SettMarks.SettMark d : (SETT.TILE_MAP()).marks.active()) {
/* 272 */               if (d == UIMiniHotSpots.Panel.this.data)
/* 273 */                 return i; 
/* 274 */               if (d.active)
/* 275 */                 i++; 
/*     */             } 
/* 277 */             return -1;
/*     */           }
/*     */ 
/*     */           
/*     */           public void set(int t) {
/* 282 */             UIMiniHotSpots.Panel.this.data.setPosition(t);
/* 283 */             for (SettMarks.SettMark d : (SETT.TILE_MAP()).marks.active()) {
/* 284 */               if (t == 0 && d.active) {
/* 285 */                 UIMiniHotSpots.Panel.this.init(d);
/*     */                 break;
/*     */               } 
/* 288 */               if (d.active) {
/* 289 */                 t--;
/*     */               }
/*     */             } 
/*     */           }
/*     */         };
/* 294 */       GTarget t = new GTarget(40, false, true, order);
/*     */       
/* 296 */       addRelBody(8, DIR.S, (SPRITE)(new GText((UI.FONT()).H2, UIMiniHotSpots.¤¤order)).toUpper().lablify());
/* 297 */       addRelBody(2, DIR.S, (RENDEROBJ)t);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\set\\ui\right\UIMiniHotSpots.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */