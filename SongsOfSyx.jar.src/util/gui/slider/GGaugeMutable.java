/*     */ package util.gui.slider;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.color.ColorImp;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.datatypes.Rec;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.DOUBLE;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.info.INFO;
/*     */ import view.main.Mouse;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class GGaugeMutable
/*     */   extends CLICKABLE.ClickableAbs {
/*  28 */   private static Font f = (UI.FONT()).M;
/*  29 */   private static GText text = new GText((UI.FONT()).S, 100);
/*     */   private boolean hideInfo;
/*  31 */   private static Rec rTmp = new Rec();
/*     */   
/*     */   private final DOUBLE.DOUBLE_MUTABLE d;
/*     */   private boolean clicked = false;
/*  35 */   private static final ColorImp col = new ColorImp();
/*     */   
/*     */   public GGaugeMutable(DOUBLE.DOUBLE_MUTABLE d, int width) {
/*  38 */     if (f != (UI.FONT()).M)
/*  39 */       text = new GText((UI.FONT()).S, 100); 
/*  40 */     this.d = d;
/*  41 */     this.body.setDim(width, 24.0D);
/*  42 */     repetativeSet(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/*  48 */     this.clicked &= MButt.LEFT.isDown();
/*     */ 
/*     */     
/*  51 */     if (isHovered) {
/*  52 */       GText t = VIEW.hoverBox().text();
/*  53 */       t.setFont((UI.FONT()).S);
/*  54 */       setInfo((DOUBLE)this.d, t);
/*  55 */       if (t.length() > 0) {
/*  56 */         VIEW.hoverBox().add((SPRITE)t);
/*  57 */         VIEW.hoverBox().NL();
/*     */       } 
/*     */     } 
/*     */     
/*  61 */     rTmp.set((RECTANGLE)body());
/*     */     
/*  63 */     if (!this.hideInfo) {
/*  64 */       text.clear();
/*  65 */       int w = setInfo((DOUBLE)this.d, text);
/*  66 */       if (w > 0) {
/*  67 */         rTmp.moveX1((rTmp.x2() - w));
/*  68 */         rTmp.setWidth(w);
/*  69 */         renderBG(r, (RECTANGLE)rTmp);
/*  70 */         text.adjustWidth();
/*  71 */         text.renderC(r, (RECTANGLE)rTmp);
/*  72 */         rTmp.moveX1(body().x1());
/*  73 */         rTmp.setWidth((body().width() - w + 1));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  79 */     boolean big = (rTmp.width() > 100);
/*  80 */     if (isActive && big) {
/*  81 */       int w = rTmp.width();
/*  82 */       rTmp.set(rTmp.x1(), (rTmp.x1() + 16), rTmp.y1(), rTmp.y2());
/*  83 */       renderBG(r, (RECTANGLE)rTmp);
/*  84 */       (SPRITES.icons()).s.minifier.renderC(r, (RECTANGLE)rTmp);
/*  85 */       rTmp.set((rTmp.x1() + w - 16), (rTmp.x1() + w), rTmp.y1(), rTmp.y2());
/*  86 */       renderBG(r, (RECTANGLE)rTmp);
/*  87 */       (SPRITES.icons()).s.magnifier.renderC(r, (RECTANGLE)rTmp);
/*  88 */       rTmp.set((RECTANGLE)body());
/*  89 */       rTmp.setWidth((w - 32));
/*  90 */       rTmp.incrX(16.0D);
/*     */     } 
/*     */ 
/*     */     
/*  94 */     if (this.clicked) {
/*  95 */       set((RECTANGLE)rTmp);
/*     */     }
/*     */     
/*  98 */     renderBG(r, (RECTANGLE)rTmp);
/*     */ 
/*     */     
/* 101 */     if (isActive && !big && leftHovered((RECTANGLE)rTmp)) {
/* 102 */       renderColor(r, (GCOLOR.UI().bgHov()).hovered, rTmp.x1(), buttonX1((RECTANGLE)rTmp) + 12);
/* 103 */       (SPRITES.icons()).s.minus.render(r, rTmp.x1(), rTmp.y1() + 4);
/*     */     } else {
/* 105 */       bad2Good(col, this.d.getD());
/* 106 */       renderColor(r, (COLOR)col, rTmp.x1(), buttonX1((RECTANGLE)rTmp) + 12);
/*     */     } 
/*     */     
/* 109 */     if (isActive && !big && rightHovered((RECTANGLE)rTmp)) {
/* 110 */       renderColor(r, (GCOLOR.UI().bgHov()).hovered, buttonX1((RECTANGLE)rTmp) + 12, rTmp.x2() - 3);
/* 111 */       (SPRITES.icons()).s.plus.render(r, rTmp.x2() - 16, rTmp.y1() + 4);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 116 */     if (!isActive) {
/*     */       return;
/*     */     }
/* 119 */     int bx1 = buttonX1((RECTANGLE)rTmp);
/* 120 */     (SPRITES.icons()).m.circle_frame.render(r, bx1, body().y1());
/*     */     
/* 122 */     bad2Good(col, this.d.getD());
/*     */ 
/*     */ 
/*     */     
/* 126 */     if (buttonIsHovered((RECTANGLE)rTmp)) {
/* 127 */       col.shadeSelf(1.4D);
/*     */     }
/*     */     
/* 130 */     col.bind();
/* 131 */     (SPRITES.icons()).m.circle_inner.render(r, bx1, body().y1());
/* 132 */     COLOR.unbind();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void bad2Good(ColorImp c, double d) {
/* 137 */     if (d < 0.0D)
/* 138 */       d = 0.0D; 
/* 139 */     if (d > 1.0D)
/* 140 */       d = 1.0D; 
/* 141 */     double r = (d > 0.5D) ? (1.0D - (d - 0.5D) * 2.0D) : 1.0D;
/* 142 */     double g = (d < 0.5D) ? (d * 2.0D) : 1.0D;
/* 143 */     c.set(30 + (int)(70.0D * r), 30 + (int)(70.0D * g), 30);
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderBG(SPRITE_RENDERER r, RECTANGLE rec) {
/* 148 */     GCOLOR.UI().border().render(r, rec, -1);
/* 149 */     GCOLOR.UI().bg().render(r, rec, -2);
/*     */   }
/*     */   
/*     */   private void renderColor(SPRITE_RENDERER r, COLOR c, int x1, int x2) {
/* 153 */     ColorImp.TMP.set(c);
/* 154 */     col.set((COLOR)ColorImp.TMP);
/* 155 */     col.shadeSelf(0.5D);
/* 156 */     col.render(r, x1 + 2, x2, body().y1() + 3, body().y2() - 3);
/* 157 */     col.set((COLOR)ColorImp.TMP);
/* 158 */     col.render(r, x1 + 2, x2, body().y1() + 4, body().y2() - 4);
/*     */   }
/*     */   
/*     */   int adjustWidth(int width, DOUBLE d) {
/* 162 */     return (int)(12.0D + (width - 24) * d.getD());
/*     */   }
/*     */   
/*     */   protected void setColor(DOUBLE d, ColorImp imp, boolean hovered) {
/* 166 */     bad2Good(imp, d.getD());
/* 167 */     if (hovered) {
/* 168 */       imp.shadeSelf(1.4D);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean hover(COORDINATE mCoo) {
/* 173 */     return super.hover(mCoo);
/*     */   }
/*     */   
/*     */   private int buttonX1(RECTANGLE body) {
/* 177 */     int w = body.width() - 24;
/* 178 */     return (int)(body.x1() + this.d.getD() * w);
/*     */   }
/*     */   
/*     */   private boolean leftHovered(RECTANGLE body) {
/* 182 */     Mouse mouse = VIEW.mouse();
/* 183 */     if (mouse.isWithinRec(body)) {
/* 184 */       return (mouse.x() < buttonX1(body));
/*     */     }
/* 186 */     return false;
/*     */   }
/*     */   
/*     */   private boolean rightHovered(RECTANGLE body) {
/* 190 */     Mouse mouse = VIEW.mouse();
/* 191 */     if (mouse.isWithinRec(body)) {
/* 192 */       return (mouse.x() > buttonX1(body) + 24);
/*     */     }
/* 194 */     return false;
/*     */   }
/*     */   
/*     */   private boolean buttonIsHovered(RECTANGLE body) {
/* 198 */     Mouse mouse = VIEW.mouse();
/* 199 */     if (mouse.isWithinRec(body)) {
/* 200 */       int x1 = buttonX1(body);
/* 201 */       return (mouse.x() > x1 && mouse.x() < x1 + 24);
/*     */     } 
/* 203 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void clickA() {
/* 208 */     rTmp.set((RECTANGLE)body());
/* 209 */     if (!this.hideInfo) {
/* 210 */       rTmp.incrW(-setInfo((DOUBLE)this.d, text));
/*     */     }
/* 212 */     if (rTmp.width() > 100) {
/* 213 */       rTmp.incrX(16.0D);
/* 214 */       rTmp.incrW(-32.0D);
/*     */     } 
/*     */     
/* 217 */     if (leftHovered((RECTANGLE)rTmp) || VIEW.mouse().x() < rTmp.x1()) {
/* 218 */       this.d.incD(-4.9E-324D);
/*     */     }
/* 220 */     else if (rightHovered((RECTANGLE)rTmp) || VIEW.mouse().x() >= rTmp.x2()) {
/* 221 */       this.d.incD(Double.MIN_VALUE);
/*     */     
/*     */     }
/* 224 */     else if (VIEW.mouse().isWithinRec((RECTANGLE)rTmp)) {
/* 225 */       this.clicked = true;
/*     */       
/* 227 */       set((RECTANGLE)rTmp);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void set(RECTANGLE body) {
/* 233 */     Mouse mouse = VIEW.mouse();
/* 234 */     double w = (body.width() - 24);
/* 235 */     double de = (mouse.x() - body.x1() - 12);
/* 236 */     de = CLAMP.d(de / w, 0.0D, 1.0D);
/* 237 */     this.d.setD(de);
/*     */   }
/*     */   
/*     */   protected int setInfo(DOUBLE d, GText text) {
/* 241 */     GFORMAT.perc(text, d.getD());
/* 242 */     return text.getFont().height() * 3;
/*     */   }
/*     */   
/*     */   public GGaugeMutable hideInfo() {
/* 246 */     this.hideInfo = true;
/* 247 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void hoverInfoGet(GUI_BOX text) {
/* 253 */     super.hoverInfoGet(text);
/*     */   }
/*     */   
/*     */   public RENDEROBJ hoverInfoSet(INFO info) {
/* 257 */     hoverInfoSet(info.desc);
/* 258 */     hoverTitleSet(info.name);
/* 259 */     return (RENDEROBJ)this;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GGaugeMutable.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */