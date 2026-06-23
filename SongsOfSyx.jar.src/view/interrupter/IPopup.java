/*     */ package view.interrupter;
/*     */ import init.constant.C;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.datatypes.BODY_HOLDER;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.gui.GuiSection;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.panel.GPanel;
/*     */ import view.main.VIEW;
/*     */ 
/*     */ public final class IPopup {
/*  17 */   private final GuiSection s = new GuiSection();
/*  18 */   private final Inter inter = new Inter(this.s); private final InterManager m;
/*     */   private CLICKABLE trigger;
/*     */   RENDEROBJ old;
/*     */   CLICKABLE oldC;
/*     */   
/*     */   public IPopup(InterManager manager) {
/*  24 */     this.m = manager;
/*     */   }
/*     */ 
/*     */   
/*     */   public void show(RENDEROBJ s, CLICKABLE trigger) {
/*  29 */     show(s, trigger, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public void show(RENDEROBJ s, CLICKABLE trigger, boolean centreAtMouse) {
/*  34 */     this.old = null;
/*  35 */     this.s.clear();
/*  36 */     this.s.add(s);
/*  37 */     this.trigger = trigger;
/*  38 */     if (trigger != null) {
/*  39 */       showP(trigger.body().cX(), trigger.body().cY(), centreAtMouse);
/*     */     } else {
/*  41 */       int x1 = C.WIDTH() / 2 - s.body().width() / 2;
/*  42 */       int y1 = C.HEIGHT() / 2 - s.body().height() / 2;
/*  43 */       showP(x1, y1, centreAtMouse);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void push(RENDEROBJ s, CLICKABLE trigger) {
/*  52 */     RENDEROBJ old = null;
/*  53 */     this.oldC = this.trigger;
/*  54 */     if (this.inter.isActivated()) {
/*  55 */       old = (RENDEROBJ)this.s.elements().get(0);
/*     */     }
/*  57 */     show(s, trigger);
/*  58 */     this.old = old;
/*     */   }
/*     */   
/*     */   public void pop() {
/*  62 */     if (this.inter.isActivated() && this.old != null) {
/*  63 */       show(this.old, this.oldC);
/*     */     } else {
/*  65 */       close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public GuiSection section() {
/*  70 */     return this.s;
/*     */   }
/*     */   
/*     */   public void close() {
/*  74 */     this.inter.hide();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean showing() {
/*  79 */     return this.inter.isActivated();
/*     */   }
/*     */   
/*     */   public RENDEROBJ current() {
/*  83 */     return this.inter.isActivated() ? (RENDEROBJ)this.s.elements().get(0) : null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void showP(int x, int y, boolean centre) {
/*  88 */     int M = 32;
/*     */     
/*  90 */     if (centre) {
/*  91 */       this.s.body().moveC((COORDINATE)VIEW.mouse());
/*  92 */       if (!this.inter.isActivated()) {
/*  93 */         this.m.add(this.inter);
/*     */       }
/*     */     } else {
/*  96 */       this.s.body().moveCX(x);
/*  97 */       if (y > C.HEIGHT() / 2) {
/*  98 */         this.s.body().moveY2((y - M));
/*     */       } else {
/* 100 */         this.s.body().moveY1((y + M));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 106 */     if (this.s.body().x2() + M >= C.WIDTH()) {
/* 107 */       this.s.body().moveX2((C.WIDTH() - M));
/*     */     }
/*     */     
/* 110 */     if (this.s.body().x1() - M < 0) {
/* 111 */       this.s.body().moveX1((x + M));
/*     */     }
/*     */     
/* 114 */     if (this.s.body().y2() + M >= C.HEIGHT()) {
/* 115 */       this.s.body().moveY2((C.HEIGHT() - M));
/*     */     }
/*     */     
/* 118 */     if (this.s.body().y1() - M < 0) {
/* 119 */       this.s.body().moveY1(M);
/*     */     }
/*     */     
/* 122 */     this.inter.hidden = true;
/*     */     
/* 124 */     if (!this.inter.isActivated())
/* 125 */       this.m.add(this.inter); 
/*     */   }
/*     */   
/*     */   private class Inter
/*     */     extends Interrupter {
/*     */     private boolean hidden = true;
/*     */     private final GPanel box;
/*     */     
/* 133 */     ACTION exit = new ACTION()
/*     */       {
/*     */         public void exe()
/*     */         {
/* 137 */           if (IPopup.Inter.this.hidden)
/*     */             return; 
/* 139 */           IPopup.Inter.this.hide();
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*     */     Inter(GuiSection s) {
/* 145 */       this.box = new GPanel();
/* 146 */       this.box.setButt();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void hoverTimer(GBox text) {
/* 151 */       IPopup.this.s.hoverInfoGet((GUI_BOX)text);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void mouseClick(MButt button) {
/* 156 */       if (button == MButt.RIGHT) {
/* 157 */         hide();
/* 158 */       } else if (button == MButt.LEFT && 
/* 159 */         !IPopup.this.s.click()) {
/* 160 */         this.box.click();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void hide() {
/* 166 */       if (IPopup.this.old != null) {
/* 167 */         IPopup.this.show(IPopup.this.old, IPopup.this.oldC);
/*     */       } else {
/* 169 */         super.hide();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean otherClick(MButt butt) {
/* 175 */       hide();
/* 176 */       if (butt == MButt.RIGHT)
/* 177 */         return true; 
/* 178 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void otherAdd(Interrupter other) {
/* 183 */       hide();
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 188 */       return !(!IPopup.this.s.hover(mCoo) && !this.box.hover(mCoo));
/*     */     }
/*     */ 
/*     */     
/*     */     protected boolean render(Renderer r, float ds) {
/* 193 */       this.hidden = false;
/* 194 */       this.box.inner().set((BODY_HOLDER)IPopup.this.s);
/* 195 */       this.box.clickActionSet(this.exit);
/* 196 */       this.box.render((SPRITE_RENDERER)r, ds);
/*     */       
/* 198 */       IPopup.this.s.render((SPRITE_RENDERER)r, ds);
/* 199 */       if (IPopup.this.trigger != null) {
/* 200 */         IPopup.this.trigger.selectTmp();
/*     */       }
/* 202 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     protected boolean update(float ds) {
/* 210 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IPopup.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */