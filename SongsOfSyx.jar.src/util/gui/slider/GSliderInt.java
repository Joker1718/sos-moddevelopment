/*     */ package util.gui.slider;
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.MButt;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.STRING_RECIEVER;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.colors.GCOLOR;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public class GSliderInt extends GuiSection {
/*     */   protected final INT.INTE in;
/*     */   private static final int midWidth = 8;
/*  28 */   private static CharSequence ¤¤setAmount = "¤Set amount";
/*  29 */   private static CharSequence ¤¤setAmountD = "¤Set amount {0}-{1}"; private final STRING_RECIEVER rec; private int RI; private boolean clicked; private double clickSpeed1; private double clickSpeed2;
/*     */   
/*     */   static {
/*  32 */     D.ts(GSliderInt.class);
/*     */   }
/*     */   
/*     */   public GSliderInt(INT.INTE in, int width, boolean input) {
/*  36 */     this(in, width, 24, input);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GSliderInt(INT.INTE in, int width, boolean buttons, boolean input) {
/*  42 */     this(in, width, 24, buttons, input);
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
/*     */   public GSliderInt(INT.INTE in, int width, int height, boolean input) {
/*     */     this(in, width, height, input, input);
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
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/*     */     activeSet((this.in.max() > 0));
/*     */     super.render(r, ds);
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
/*     */   public GSliderInt(final INT.INTE in, int width, int height, boolean buttons, boolean input) {
/* 156 */     this.rec = new STRING_RECIEVER()
/*     */       {
/*     */         public void acceptString(CharSequence string)
/*     */         {
/* 160 */           String s = String.valueOf(string);
/*     */           try {
/* 162 */             int i = Integer.parseInt(s);
/* 163 */             i = CLAMP.i(i, GSliderInt.this.in.min(), GSliderInt.this.in.max());
/* 164 */             GSliderInt.this.in.set(i);
/* 165 */           } catch (Exception exception) {}
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
/* 188 */     this.RI = -2;
/* 189 */     this.clicked = false;
/* 190 */     this.clickSpeed1 = 0.0D;
/* 191 */     this.clickSpeed2 = 0.0D; this.in = in; if (input) width -= 54;  width -= 4; height -= 4; if (width < 0) width = 0;  if (buttons) addRightC(0, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.minifier) { protected void clickA() { in.inc(-1); if ((KEYS.MAIN()).MOD.isPressed()) in.set(in.min());  } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { if (isHovered && MButt.LEFT.isDown()) { GSliderInt.this.clickSpeed1 += ds; if (GSliderInt.this.clickSpeed1 > 10.0D) GSliderInt.this.clickSpeed1 = 10.0D;  in.inc(-((int)GSliderInt.this.clickSpeed1)); } else { GSliderInt.this.clickSpeed1 = 0.0D; }  super.render(r, ds, isActive, isSelected, isHovered); } public void hoverInfoGet(GUI_BOX text) { GAllocator.hov(text); super.hoverInfoGet(text); } }
/*     */         );  addRightC(4, (RENDEROBJ)new Mid(width, height)); pad(2, 2); if (buttons) addRightC(4, (RENDEROBJ)new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.magnifier) { protected void clickA() { in.inc(1); if ((KEYS.MAIN()).MOD.isPressed()) in.set(in.max());  } protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) { if (isHovered && MButt.LEFT.isDown()) { GSliderInt.this.clickSpeed2 += (ds * 2.0F); if (GSliderInt.this.clickSpeed2 > 10.0D) GSliderInt.this.clickSpeed2 = 10.0D;  in.inc((int)GSliderInt.this.clickSpeed2); } else { GSliderInt.this.clickSpeed2 = 0.0D; }  super.render(r, ds, isActive, isSelected, isHovered); } public void hoverInfoGet(GUI_BOX text) { GAllocator.hov(text); super.hoverInfoGet(text); } }
/*     */         );  if (input) addRightC(2, (RENDEROBJ)(new GButt.ButtPanel((SPRITE)(SPRITES.icons()).s.pluses) { protected void clickA() { Str.TMP.clear().add(GSliderInt.¤¤setAmountD).insert(0, in.min()).insert(1, in.max()); (VIEW.inters()).input.requestInput(GSliderInt.this.rec, (CharSequence)Str.TMP); } }).hoverInfoSet(¤¤setAmount)); 
/* 194 */   } public void reset() { this.clickSpeed1 = 0.0D;
/* 195 */     this.clickSpeed2 = 0.0D;
/* 196 */     this.clicked = false;
/* 197 */     this.RI = -1; }
/*     */    public void hoverInfoGet(GUI_BOX text) {
/*     */     GBox b = (GBox)text;
/*     */     b.add((SPRITE)GFORMAT.i(b.text(), this.in.get()));
/*     */     hoverInfoSelf(text);
/*     */   } protected void renderMidColor(SPRITE_RENDERER r, int x1, int width, int widthFull, int y1, int y2) {
/*     */     COLOR.WHITE65.render(r, x1, x1 + width, y1, y2);
/*     */   } private class Mid extends CLICKABLE.ClickableAbs { Mid(int width, int height) {
/* 205 */       super(width, height - 4);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void clickA() {
/* 210 */       GSliderInt.this.clicked = true;
/* 211 */       double x = (VIEW.mouse().x() - body().x1()) / body().width();
/* 212 */       GSliderInt.this.in.setD(CLAMP.d(x, 0.0D, 1.0D));
/*     */     }
/*     */ 
/*     */     
/*     */     protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 217 */       GSliderInt.this.clicked &= (MButt.LEFT.isDown() && Math.abs(GSliderInt.this.RI - VIEW.RI()) <= 1) ? 1 : 0;
/* 218 */       GSliderInt.this.RI = VIEW.RI();
/* 219 */       if (GSliderInt.this.clicked) {
/* 220 */         double x = (VIEW.mouse().x() - body().x1()) / body().width();
/* 221 */         GSliderInt.this.in.setD(CLAMP.d(x, 0.0D, 1.0D));
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 226 */       GCOLOR.UI().border().render(r, (RECTANGLE)this.body, 2);
/* 227 */       GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, (RECTANGLE)this.body, 1);
/*     */ 
/*     */       
/* 230 */       int x2 = body().x1() + (int)(GSliderInt.this.in.getD() * body().width());
/*     */       
/* 232 */       int my = (isHovered || GSliderInt.this.clicked) ? 0 : 2;
/* 233 */       GSliderInt.this.renderMidColor(r, body().x1(), x2 - body().x1(), body().width(), body().y1() + my, body().y2() - my);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 238 */       int cx = (int)((this.body.x1() + 4) + (body().width() - 8) * GSliderInt.this.in.getD());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 245 */       GCOLOR.UI().border().render(r, cx - 4, cx + 4, body().y1(), body().y2());
/* 246 */       COLOR c = (isHovered || GSliderInt.this.clicked) ? (GCOLOR.T()).H1 : (GCOLOR.T()).H2;
/* 247 */       c.render(r, cx - 4 + 1, cx + 4 - 1, body().y1() + 1, body().y2() - 1);
/* 248 */       COLOR.BLACK.render(r, cx - 1, cx + 2, body().y1() + 2, body().y2() - 2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hover(COORDINATE mCoo) {
/* 255 */       if (super.hover(mCoo)) {
/* 256 */         if ((KEYS.MAIN()).MOD.isPressed() || (KEYS.MAIN()).UNDO.isPressed()) {
/* 257 */           double d = MButt.clearWheelSpin();
/* 258 */           if (d < 0.0D) {
/* 259 */             GSliderInt.this.in.inc(-1);
/* 260 */           } else if (d > 0.0D) {
/* 261 */             GSliderInt.this.in.inc(1);
/*     */           } 
/*     */         } 
/* 264 */         return true;
/*     */       } 
/* 266 */       return false;
/*     */     } }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void renderMid(SPRITE_RENDERER r, int x1, int x2, int y1, int y2, double d, boolean isActive, boolean isSelected, boolean isHovered) {
/* 275 */     GCOLOR.UI().border().render(r, x1 - 2, x2 + 2, y1 - 2, y2 + 2);
/* 276 */     GCOLOR.UI().bg(isActive, isSelected, isHovered).render(r, x1 - 1, x2 + 1, y1 - 1, y2 + 1);
/*     */     
/* 278 */     int width = x2 - x1;
/*     */     
/* 280 */     x2 = x1 + (int)(d * width);
/* 281 */     COLOR.WHITE65.render(r, x1, x2, y1, y2);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GSliderInt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */