/*     */ package view.menu;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.colors.GCOLOR;
/*     */ import util.text.D;
/*     */ 
/*     */ public abstract class MenuScreen extends GuiSection {
/*  20 */   static CharSequence ¤¤back = "¤< back";
/*     */   static {
/*  22 */     D.ts(MenuScreen.class);
/*     */   }
/*  24 */   public static final RECTANGLE bounds = (RECTANGLE)new Rec(1200.0D, 600.0D);
/*  25 */   public static RECTANGLE inner = (RECTANGLE)(new Rec((bounds.width() - 50), (bounds.height() - 32))).moveC(C.DIM().cX(), C.DIM().cY());
/*     */   
/*  27 */   private final GuiSection bottombutts = new GuiSection();
/*     */ 
/*     */   
/*     */   public MenuScreen(CharSequence title, COLOR color) {
/*  31 */     body().set(bounds);
/*  32 */     body().centerIn(C.DIM());
/*     */ 
/*     */     
/*  35 */     RENDEROBJ s = UI.decor().frame((RECTANGLE)body(), color);
/*  36 */     s.body().centerIn((RECTANGLE)body());
/*  37 */     add(s);
/*     */ 
/*     */ 
/*     */     
/*  41 */     s = UI.decor().decorate(title, color);
/*  42 */     s.body().centerIn(C.DIM());
/*  43 */     s.body().moveY2(getLastY1());
/*  44 */     add(s);
/*     */ 
/*     */ 
/*     */     
/*  48 */     ScreenButton b = new ScreenButton((UI.FONT()).H1.getText(¤¤back))
/*     */       {
/*     */         protected void clickA()
/*     */         {
/*  52 */           MenuScreen.this.back();
/*     */         }
/*     */       };
/*     */     
/*  56 */     b.body().moveX2((body().x2() - 20));
/*  57 */     b.body().moveY1(body().y1());
/*  58 */     add((RENDEROBJ)b);
/*  59 */     addRelBody(14, DIR.S, (RENDEROBJ)this.bottombutts);
/*     */   }
/*     */   
/*     */   public void addButt(RENDEROBJ obj) {
/*  63 */     this.bottombutts.addRightC(24, obj);
/*  64 */     this.bottombutts.body().centerX((BODY_HOLDER)this);
/*     */   }
/*     */   
/*     */   protected abstract void back();
/*     */   
/*     */   public static class ScreenButton
/*     */     extends CLICKABLE.ClickableAbs {
/*     */     private final SPRITE s;
/*     */     
/*     */     public ScreenButton(CharSequence name) {
/*  74 */       this((UI.FONT()).H1.getText(name));
/*     */     }
/*     */     
/*     */     public ScreenButton(CharSequence name, Font f) {
/*  78 */       this(f.getText(name));
/*     */     }
/*     */     
/*     */     public ScreenButton(SPRITE s) {
/*  82 */       this.s = s;
/*  83 */       this.body.setWidth(s.width()).setHeight(s.height());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  89 */       if (!isActive) {
/*  90 */         (GCOLOR.T()).INACTIVE.bind();
/*  91 */       } else if (isHovered && isSelected) {
/*  92 */         (GCOLOR.T()).HOVER_SELECTED.bind();
/*  93 */       } else if (isHovered) {
/*  94 */         (GCOLOR.T()).HOVERED.bind();
/*  95 */       } else if (isSelected) {
/*  96 */         (GCOLOR.T()).SELECTED.bind();
/*     */       } else {
/*  98 */         (GCOLOR.T()).CLICKABLE.bind();
/*  99 */       }  this.s.render(r, (RECTANGLE)this.body);
/* 100 */       COLOR.unbind();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\menu\MenuScreen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */