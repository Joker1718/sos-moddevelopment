/*     */ package menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.color.ColorShifting;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.Hoverable.HOVERABLE;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import snake2d.util.sprite.text.Text;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GText;
/*     */ import util.text.D;
/*     */ import view.menu.MenuScreen;
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class GUI
/*     */ {
/*     */   static RECTANGLE bounds;
/*     */   static RECTANGLE right;
/*     */   static RECTANGLE left;
/*     */   static int bottomMarginX;
/*     */   static int bottomY;
/*     */   static int margin;
/*  35 */   static COLOR labelColor = (COLOR)new ColorImp(127, 127, 80);
/*     */   
/*     */   static RECTANGLE inner;
/*  38 */   static CharSequence ¤¤back = "¤< back";
/*     */   
/*     */   static {
/*  41 */     D.ts(GUI.class);
/*     */   }
/*     */   
/*     */   static void init(RECTANGLE bounds) {
/*  45 */     GUI.bounds = bounds;
/*  46 */     D.t(GUI.class);
/*  47 */     float width = (bounds.width() / 4);
/*  48 */     float height = bounds.height() / 1.4F;
/*  49 */     float dist = (bounds.width() / 16);
/*  50 */     bottomMarginX = bounds.width() / 6;
/*     */     
/*  52 */     Rec l = new Rec();
/*  53 */     l.setWidth(width);
/*  54 */     l.setHeight(height);
/*  55 */     l.moveX1((bounds.x1() + width - dist / 2.0F));
/*  56 */     l.moveY1((bounds.y1() + (bounds.height() - height) / 2.0F));
/*  57 */     left = (RECTANGLE)l;
/*     */     
/*  59 */     Rec r = new Rec((RECTANGLE)l);
/*  60 */     r.moveX1((l.x2() + dist));
/*  61 */     r.moveY1((bounds.y1() + (bounds.height() - height) / 2.0F));
/*  62 */     right = (RECTANGLE)r;
/*     */ 
/*     */     
/*  65 */     margin = getSmallText("aaaaaaaaaaaaaaaaa").width();
/*     */     
/*  67 */     r = new Rec(bounds);
/*  68 */     r.incrW(-200.0D);
/*  69 */     r.incrH(-100.0D);
/*  70 */     r.centerIn(bounds);
/*     */     
/*  72 */     bottomY = bounds.y2() + 30;
/*     */     
/*  74 */     inner = (RECTANGLE)r;
/*     */   }
/*     */   
/*     */   static class COLORS
/*     */   {
/*  79 */     static COLOR normal = COLOR.WHITE100;
/*  80 */     static COLOR hover = (COLOR)new ColorShifting((COLOR)new ColorImp(127, 127, 65), 
/*  81 */         (COLOR)new ColorImp(110, 90, 45));
/*  82 */     static COLOR selected = (COLOR)new ColorImp(127, 127, 65);
/*  83 */     static COLOR hover_selected = COLOR.GREEN100;
/*  84 */     static COLOR inactive = (COLOR)new ColorImp(112, 87, 60);
/*  85 */     static COLOR menu = (COLOR)new ColorImp(230, 220, 220);
/*  86 */     static COLOR unclickable = (COLOR)new ColorImp(127, 127, 80);
/*  87 */     static COLOR copper = (COLOR)new ColorImp(127, 127, 100);
/*  88 */     static COLOR hoverable = (COLOR)new ColorImp(115, 95, 55);
/*  89 */     static COLOR label = (COLOR)new ColorImp(127, 127, 80);
/*  90 */     static COLOR portrait = (COLOR)new ColorImp(220, 220, 220);
/*  91 */     static COLOR error = (COLOR)new ColorImp(127, 90, 90);
/*     */   }
/*     */   
/*     */   static class Button
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final SPRITE s;
/*     */     
/*     */     Button(SPRITE s) {
/*  99 */       this.s = s;
/* 100 */       this.body.setWidth(s.width()).setHeight(s.height());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 106 */       if (!isActive) {
/* 107 */         GUI.COLORS.inactive.bind();
/* 108 */       } else if (isHovered && isSelected) {
/* 109 */         GUI.COLORS.hover_selected.bind();
/* 110 */       } else if (isHovered) {
/* 111 */         GUI.COLORS.hover.bind();
/* 112 */       } else if (isSelected) {
/* 113 */         GUI.COLORS.selected.bind();
/*     */       } else {
/* 115 */         GUI.COLORS.normal.bind();
/* 116 */       }  this.s.render(r, (RECTANGLE)this.body);
/* 117 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class TEXT {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static CLICKABLE getNavButt(CharSequence name) {
/* 130 */     return (CLICKABLE)new Button((UI.FONT()).H1.getText(name));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static SPRITE getSmallText(CharSequence name) {
/* 136 */     return (UI.FONT()).M.getText(name);
/*     */   }
/*     */   
/*     */   static Text getSmallText(int width) {
/* 140 */     return (UI.FONT()).M.getText(width);
/*     */   }
/*     */   
/*     */   static SPRITE getBigTexts(CharSequence name) {
/* 144 */     return (UI.FONT()).H1.getText(name);
/*     */   }
/*     */   
/*     */   static HOVERABLE getBigText(CharSequence name) {
/* 148 */     return (HOVERABLE)new HOVERABLE.Sprite((UI.FONT()).H1.getText(name), COLORS.label);
/*     */   }
/*     */   
/*     */   static CLICKABLE.ClickableAbs getSmallButt(String name) {
/* 152 */     return new Button((UI.FONT()).M.getText(name));
/*     */   }
/*     */   
/*     */   static CLICKABLE getBackArrow() {
/* 156 */     Button b = new Button((UI.FONT()).H1.getText(¤¤back));
/* 157 */     b.body().moveX2((bounds.x2() - 80));
/* 158 */     b.body().moveY2((bounds.y1() - 25));
/* 159 */     return (CLICKABLE)b;
/*     */   }
/*     */ 
/*     */   
/*     */   static void addTitleText(GuiSection s, CharSequence title) {
/* 164 */     HOVERABLE.Sprite r = new HOVERABLE.Sprite((SPRITE)(UI.FONT()).H1.getText(title).toUpper(), COLORS.label);
/* 165 */     r.body().centerIn(bounds);
/* 166 */     r.body().moveY1((left.y1() - r.body().height() - 10));
/* 167 */     s.add((RENDEROBJ)r);
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class OptionLine
/*     */     extends GuiSection
/*     */   {
/*     */     private final CLICKABLE left;
/*     */     private final CLICKABLE right;
/* 176 */     private GText value = new GText((UI.FONT()).M, 16);
/*     */ 
/*     */     
/*     */     OptionLine(final INT.INTE ii, CharSequence l) {
/* 180 */       body().setWidth(550.0D);
/* 181 */       body().setHeight(1.0D);
/*     */ 
/*     */       
/* 184 */       GText label = new GText((UI.FONT()).H2, l);
/* 185 */       label.color(GUI.COLORS.unclickable);
/* 186 */       this.left = (CLICKABLE)new GUI.Button(GUI.getBigTexts("<<"))
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */           {
/* 190 */             activeSet((ii.get() > ii.min()));
/* 191 */             super.render(r, ds, activeIs(), isSelected, isHovered);
/*     */           }
/*     */         };
/* 194 */       this.left.clickActionSet(new ACTION()
/*     */           {
/*     */             public void exe() {
/* 197 */               ii.inc(-1);
/*     */             }
/*     */           });
/*     */       
/* 201 */       add((RENDEROBJ)this.left, 275 - GUI.margin / 20 - this.left.body().width(), 0);
/*     */       
/* 203 */       this.right = (CLICKABLE)new GUI.Button(GUI.getBigTexts(">>"))
/*     */         {
/*     */           protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered)
/*     */           {
/* 207 */             activeSet((ii.get() < ii.max()));
/* 208 */             super.render(r, ds, activeIs(), isSelected, isHovered);
/*     */           }
/*     */         };
/* 211 */       this.right.clickActionSet(new ACTION()
/*     */           {
/*     */             public void exe() {
/* 214 */               ii.inc(1);
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 219 */       addRightC(GUI.margin / 10, (RENDEROBJ)this.right);
/*     */       
/* 221 */       addCentredY((SPRITE)label, this.left.body().x1() - label.width() - 7);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 227 */       super.render(r, ds);
/*     */       
/* 229 */       Str.TMP.clear();
/* 230 */       this.value.clear();
/* 231 */       setValue(this.value);
/* 232 */       this.value.renderCY(r, this.right.body().x2() + 7, body().cY());
/* 233 */       GUI.COLORS.unclickable.bind();
/*     */       
/* 235 */       COLOR.unbind();
/*     */     }
/*     */ 
/*     */     
/*     */     protected abstract void setValue(GText param1GText);
/*     */   }
/*     */ 
/*     */   
/*     */   static class CheckBox
/*     */     extends CLICKABLE.ClickableAbs
/*     */   {
/*     */     private final SPRITE ss;
/*     */     
/*     */     private final GText name;
/*     */     
/*     */     public CheckBox(CharSequence name) {
/* 251 */       this.name = new GText((UI.FONT()).M, name);
/* 252 */       this.ss = (SPRITE)new SPRITE.Imp(24)
/*     */         {
/*     */           
/*     */           public void render(SPRITE_RENDERER r, int X1, int X2, int Y1, int Y2)
/*     */           {
/* 257 */             boolean isActive = GUI.CheckBox.this.activeIs();
/* 258 */             int i = isActive & ((!GUI.CheckBox.this.selectedIs() && !GUI.CheckBox.this.hoveredIs()) ? 0 : 1);
/*     */             
/* 260 */             if (i != 0) {
/* 261 */               COLOR.WHITE100.renderFrame(r, X1, X2, Y1, Y2, 0, 2);
/*     */             } else {
/* 263 */               GUI.COLORS.inactive.renderFrame(r, X1, X2, Y1, Y2, 0, 2);
/* 264 */             }  int cx = X1 + (X2 - X1) / 2;
/* 265 */             int cy = Y1 + (Y2 - Y1) / 2;
/* 266 */             if (GUI.CheckBox.this.selectedIs()) {
/* 267 */               (GCOLOR.UI()).GOOD.hovered.bind();
/* 268 */               (UI.icons()).s.allRight.renderC(r, cx, cy);
/*     */             } else {
/* 270 */               (GCOLOR.UI()).BAD.hovered.bind();
/* 271 */               (UI.icons()).s.cancel.renderC(r, cx, cy);
/*     */             } 
/* 273 */             COLOR.unbind();
/*     */           }
/*     */         };
/*     */       
/* 277 */       this.body.setDim(250.0D, (this.ss.height() + 8));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 283 */       this.ss.renderCY(r, body().x1(), body().cY());
/*     */       
/* 285 */       int i = isActive & ((!isSelected && !isHovered) ? 0 : 1);
/*     */       
/* 287 */       if (i == 0) {
/* 288 */         this.name.color(GUI.COLORS.inactive);
/* 289 */       } else if (isHovered && isSelected) {
/* 290 */         this.name.color(GUI.COLORS.hover_selected);
/* 291 */       } else if (isHovered) {
/* 292 */         this.name.color(GUI.COLORS.hover);
/* 293 */       } else if (isSelected) {
/* 294 */         this.name.color(GUI.COLORS.selected);
/*     */       } else {
/* 296 */         this.name.color(GUI.COLORS.normal);
/*     */       } 
/* 298 */       this.name.renderCY(r, body().x1() + 8 + this.ss.width(), body().cY());
/*     */     }
/*     */   }
/*     */   
/*     */   public static class Shadower
/*     */     extends GuiSection
/*     */   {
/* 305 */     private static final Rec shadow = (new Rec(MenuScreen.bounds.width(), (MenuScreen.bounds.height() - 50))).moveC(C.DIM().cX(), C.DIM().cY());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void render(SPRITE_RENDERER r, float ds) {
/* 313 */       Background.shadow = (RECTANGLE)shadow;
/* 314 */       super.render(r, ds);
/*     */     }
/*     */     
/*     */     public static void ren(SPRITE_RENDERER r, float ds) {
/* 318 */       Background.shadow = (RECTANGLE)shadow;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\menu\GUI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */