/*     */ package util.gui.misc;
/*     */ 
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import snake2d.util.sprite.text.Font;
/*     */ import snake2d.util.sprite.text.StringInputSprite;
/*     */ import util.data.INT;
/*     */ import util.gui.slider.GAllocator;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ public class GInputInt extends GuiSection {
/*  17 */   private final StringInputSprite sp = (new StringInputSprite(10, (UI.FONT()).S)
/*     */     {
/*     */       protected void change()
/*     */       {
/*  21 */         int num = 0;
/*  22 */         int sign = 1;
/*  23 */         for (int i = 0; i < text().length(); i++) {
/*  24 */           if (i == 0 && text().charAt(i) == '-') {
/*  25 */             sign = -1;
/*     */           }
/*     */           else {
/*     */             
/*  29 */             int n = text().charAt(i) - 48;
/*  30 */             if (n >= 0 && n < 10) {
/*  31 */               if (num * 10 + n > GInputInt.this.in.max())
/*     */                 break; 
/*  33 */               num *= 10;
/*  34 */               num += n;
/*     */             } else {
/*  36 */               GInputInt.this.unfuck(); return;
/*     */             } 
/*     */           } 
/*     */         } 
/*  40 */         if (num == 0 && sign == -1 && GInputInt.this.in.min() < 0) {
/*  41 */           GInputInt.this.in.set(0);
/*  42 */           text().clear().add('-');
/*     */         } else {
/*  44 */           GInputInt.this.in.set(CLAMP.i(num * sign, GInputInt.this.in.min(), GInputInt.this.in.max()));
/*  45 */           text().clear().add(GInputInt.this.in.get());
/*     */ 
/*     */         
/*     */         }
/*     */       
/*     */       }
/*  51 */     }).placeHolder("0");
/*     */   private final INT.INTE in;
/*     */   public GInputInt(INT.INTE in) {
/*  54 */     this(in, false, false);
/*     */   }
/*     */   
/*     */   public GInputInt(final INT.INTE in, boolean butts, boolean doublebutts) {
/*  58 */     this.in = in;
/*     */     
/*  60 */     GInput inn = new GInput(this.sp);
/*     */     
/*  62 */     if (doublebutts) {
/*  63 */       GButt.ButtPanel pp = new GButt.ButtPanel((SPRITE)(UI.icons()).s.minifierBig)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  67 */             in.inc(-Math.max(1, (in.max() - in.min()) / 5));
/*  68 */             if ((KEYS.MAIN()).MOD.isPressed()) {
/*  69 */               in.set(in.min());
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/*  75 */             activeSet((in.get() > in.min()));
/*     */           }
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  80 */             GAllocator.hov(text);
/*  81 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */       
/*  85 */       pp.repetativeSet(true);
/*  86 */       pp.body().setHeight(inn.body.height());
/*  87 */       addRightC(0, (RENDEROBJ)pp);
/*     */     } 
/*     */ 
/*     */     
/*  91 */     if (butts) {
/*  92 */       GButt.ButtPanel pp = new GButt.ButtPanel((SPRITE)(UI.icons()).s.minifier)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/*  96 */             in.inc(-1);
/*  97 */             if ((KEYS.MAIN()).MOD.isPressed()) {
/*  98 */               in.set(in.min());
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 104 */             activeSet((in.get() > in.min()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 110 */             GAllocator.hov(text);
/* 111 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */       
/* 115 */       pp.repetativeSet(true);
/* 116 */       pp.body().setHeight(inn.body.height());
/* 117 */       addRightC(0, (RENDEROBJ)pp);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 122 */     addRightC(0, (RENDEROBJ)inn);
/* 123 */     if (butts) {
/* 124 */       GButt.ButtPanel pp = new GButt.ButtPanel((SPRITE)(UI.icons()).s.magnifier)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 128 */             in.inc(1);
/* 129 */             if ((KEYS.MAIN()).MOD.isPressed()) {
/* 130 */               in.set(in.max());
/*     */             }
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 135 */             activeSet((in.get() < in.max()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 141 */             GAllocator.hov(text);
/* 142 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */       
/* 146 */       pp.repetativeSet(true);
/* 147 */       pp.body().setHeight(inn.body.height());
/* 148 */       addRightC(0, (RENDEROBJ)pp);
/*     */     } 
/*     */     
/* 151 */     if (doublebutts) {
/* 152 */       GButt.ButtPanel pp = new GButt.ButtPanel((SPRITE)(UI.icons()).s.magnifierBig)
/*     */         {
/*     */           protected void clickA()
/*     */           {
/* 156 */             in.inc(Math.max(1, (in.max() - in.min()) / 5));
/* 157 */             if ((KEYS.MAIN()).MOD.isPressed()) {
/* 158 */               in.set(in.max());
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           protected void renAction() {
/* 164 */             activeSet((in.get() < in.max()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 170 */             GAllocator.hov(text);
/* 171 */             super.hoverInfoGet(text);
/*     */           }
/*     */         };
/*     */       
/* 175 */       pp.repetativeSet(true);
/* 176 */       pp.body().setHeight(inn.body.height());
/* 177 */       addRightC(0, (RENDEROBJ)pp);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void render(SPRITE_RENDERER r, float ds) {
/* 184 */     unfuck();
/* 185 */     super.render(r, ds);
/*     */   }
/*     */ 
/*     */   
/*     */   private void unfuck() {
/* 190 */     int am = this.in.get();
/* 191 */     if (am == 0 && this.sp.text().length() == 1 && this.sp.text().charAt(0) == '-' && this.in.min() < 0) {
/*     */       return;
/*     */     }
/* 194 */     this.sp.text().clear();
/* 195 */     this.sp.text().add(am);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\misc\GInputInt.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */