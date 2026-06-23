/*     */ package util.gui.slider;
/*     */ 
/*     */ import init.sprite.SPRITES;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.gui.GUI_BOX;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.INT;
/*     */ import util.gui.misc.GButt;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ import util.text.D;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ public class GTarget
/*     */   extends GuiSection
/*     */ {
/*  21 */   private static CharSequence ¤¤Prev5 = "Previous (5)";
/*  22 */   private static CharSequence ¤¤Prev = "Previous";
/*  23 */   private static CharSequence ¤¤Next5 = "Next (5)";
/*  24 */   private static CharSequence ¤¤Next = "Next";
/*     */   
/*     */   static {
/*  27 */     D.ts(GTarget.class);
/*     */   }
/*     */   
/*     */   public GTarget(int width, boolean doubleNext, boolean horizontal, GStat stat, INT.INTE target) {
/*  31 */     this(width, (RENDEROBJ)null, doubleNext, horizontal, (RENDEROBJ)stat.r(DIR.C), target);
/*     */   }
/*     */   
/*     */   public GTarget(int width, boolean doubleNext, boolean horizontal, RENDEROBJ stat, INT.INTE target) {
/*  35 */     this(width, (RENDEROBJ)null, doubleNext, horizontal, stat, target);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GTarget(int width, boolean doubleNext, boolean horizontal, INT.INTE target) {
/*  45 */     this(width, (RENDEROBJ)null, doubleNext, horizontal, (RENDEROBJ)(new GStat(target) { public void update(GText text) { GFORMAT.i(text, target.get()); } }).r(DIR.C), target);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GTarget(int width, SPRITE label, boolean doubleNext, boolean horizontal, INT.INTE target) {
/*  55 */     this(width, (RENDEROBJ)new RENDEROBJ.Sprite(label), doubleNext, horizontal, (RENDEROBJ)(new GStat(target) { public void update(GText text) { GFORMAT.i(text, target.get()); } }).r(DIR.C), target);
/*     */   }
/*     */   
/*     */   public GTarget(int width, SPRITE label, boolean doubleNext, boolean horizontal, GStat stat, INT.INTE target) {
/*  59 */     this(width, (RENDEROBJ)new RENDEROBJ.Sprite(label), doubleNext, horizontal, (RENDEROBJ)stat.r(DIR.C), target);
/*     */   }
/*     */   
/*     */   public GTarget(int width, RENDEROBJ label, boolean doubleNext, boolean horizontal, GStat stat, INT.INTE target) {
/*  63 */     this(width, label, doubleNext, horizontal, (RENDEROBJ)stat.r(DIR.C), target);
/*     */   }
/*     */ 
/*     */   
/*     */   public GTarget(int width, RENDEROBJ label, boolean doubleNext, boolean horizontal, RENDEROBJ stat, final INT.INTE target) {
/*  68 */     if (doubleNext) {
/*  69 */       CLICKABLE cLICKABLE = (new GButt.Glow((SPRITE)(SPRITES.icons()).s.minifierBig)
/*     */         {
/*     */           protected void clickA() {
/*  72 */             target.inc(-5);
/*  73 */             if ((KEYS.MAIN()).MOD.isPressed()) {
/*  74 */               target.set(target.min());
/*     */             }
/*     */           }
/*     */           
/*     */           protected void renAction() {
/*  79 */             activeSet((GTarget.this.activeIs() && target.get() > target.min()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/*  85 */             super.hoverInfoGet(text);
/*  86 */             text.NL();
/*  87 */             GAllocator.hov(text);
/*     */           }
/*  90 */         }).repetativeSet(true).hoverInfoSet(¤¤Prev5);
/*  91 */       addRightC(0, (RENDEROBJ)cLICKABLE);
/*     */     } 
/*  93 */     CLICKABLE c = (new GButt.Glow((SPRITE)(SPRITES.icons()).s.minifier)
/*     */       {
/*     */         protected void clickA() {
/*  96 */           target.inc(-1);
/*  97 */           if ((KEYS.MAIN()).MOD.isPressed()) {
/*  98 */             target.set(target.min());
/*     */           }
/*     */         }
/*     */         
/*     */         protected void renAction() {
/* 103 */           activeSet((GTarget.this.activeIs() && target.get() > target.min()));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 109 */           super.hoverInfoGet(text);
/* 110 */           text.NL();
/* 111 */           GAllocator.hov(text);
/*     */         }
/* 114 */       }).repetativeSet(true).hoverInfoSet(¤¤Prev);
/* 115 */     addRightC(0, (RENDEROBJ)c);
/*     */     
/* 117 */     addRightC(width / 2, stat);
/*     */     
/* 119 */     body().incrW((width / 2));
/* 120 */     c = (new GButt.Glow((SPRITE)(SPRITES.icons()).s.magnifier)
/*     */       {
/*     */         protected void clickA() {
/* 123 */           target.inc(1);
/* 124 */           if ((KEYS.MAIN()).MOD.isPressed()) {
/* 125 */             target.set(target.max());
/*     */           }
/*     */         }
/*     */         
/*     */         protected void renAction() {
/* 130 */           activeSet((GTarget.this.activeIs() && target.get() < target.max()));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void hoverInfoGet(GUI_BOX text) {
/* 136 */           super.hoverInfoGet(text);
/* 137 */           text.NL();
/* 138 */           GAllocator.hov(text);
/*     */         }
/* 141 */       }).repetativeSet(true).hoverInfoSet(¤¤Next);
/* 142 */     c.body().moveX1(body().x2()).moveCY(body().cY());
/* 143 */     add((RENDEROBJ)c);
/*     */     
/* 145 */     if (doubleNext) {
/* 146 */       c = (new GButt.Glow((SPRITE)(SPRITES.icons()).s.magnifierBig)
/*     */         {
/*     */           protected void clickA() {
/* 149 */             target.inc(5);
/* 150 */             if ((KEYS.MAIN()).MOD.isPressed()) {
/* 151 */               target.set(target.max());
/*     */             }
/*     */           }
/*     */           
/*     */           protected void renAction() {
/* 156 */             activeSet((GTarget.this.activeIs() && target.get() < target.max()));
/*     */           }
/*     */ 
/*     */ 
/*     */           
/*     */           public void hoverInfoGet(GUI_BOX text) {
/* 162 */             super.hoverInfoGet(text);
/* 163 */             text.NL();
/* 164 */             GAllocator.hov(text);
/*     */           }
/* 167 */         }).repetativeSet(true).hoverInfoSet(¤¤Next5);
/* 168 */       addRightC(0, (RENDEROBJ)c);
/*     */     } 
/*     */     
/* 171 */     if (label != null) {
/* 172 */       if (horizontal) {
/* 173 */         label.body().moveX1((-label.body().width() - 8));
/* 174 */         label.body().moveCY(body().cY());
/*     */       } else {
/*     */         
/* 177 */         label.body().moveCX(body().cX());
/* 178 */         label.body().moveY2((body().y1() - 2));
/*     */       } 
/*     */ 
/*     */       
/* 182 */       add(label);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\slider\GTarget.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */