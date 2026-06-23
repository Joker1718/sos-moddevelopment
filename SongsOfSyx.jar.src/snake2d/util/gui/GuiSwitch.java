/*    */ package snake2d.util.gui;
/*    */ 
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.datatypes.RECTANGLE;
/*    */ import snake2d.util.gui.renderable.RENDEROBJ;
/*    */ 
/*    */ public class GuiSwitch {
/*    */   private RENDEROBJ current;
/*    */   private final DIR dir;
/*    */   private final GuiSection section;
/*    */   
/*    */   public GuiSwitch(DIR align, RENDEROBJ... objs) {
/* 13 */     this(align, new GuiSection(), objs);
/*    */   }
/*    */ 
/*    */   
/*    */   public GuiSwitch(DIR align, GuiSection s, RENDEROBJ... objs) {
/* 18 */     this.section = s;
/* 19 */     int w = 0;
/* 20 */     int h = 0; byte b; int i; RENDEROBJ[] arrayOfRENDEROBJ;
/* 21 */     for (i = (arrayOfRENDEROBJ = objs).length, b = 0; b < i; ) { RENDEROBJ o = arrayOfRENDEROBJ[b];
/* 22 */       w = Math.max(w, o.body().width());
/* 23 */       h = Math.max(h, o.body().height()); b++; }
/*    */     
/* 25 */     s.body().setDim(w, h);
/* 26 */     this.dir = align;
/* 27 */     replace(objs[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void replace(RENDEROBJ o) {
/* 34 */     this.current = o;
/* 35 */     int w = this.section.body().width();
/* 36 */     int h = this.section.body().height();
/* 37 */     int x = this.section.body().x1();
/* 38 */     int y = this.section.body().y1();
/* 39 */     this.section.clear();
/* 40 */     this.section.body().setDim(w, h);
/* 41 */     this.section.body().moveX1Y1(x, y);
/* 42 */     o.body().centerIn((RECTANGLE)this.section.body());
/* 43 */     int dx = (w - o.body().width()) / 2;
/* 44 */     int dy = (h - o.body().height()) / 2;
/* 45 */     o.body().incr((dx * this.dir.x()), (dy * this.dir.y()));
/* 46 */     this.section.add(o);
/*    */   }
/*    */   
/*    */   public GuiSection section() {
/* 50 */     return this.section;
/*    */   }
/*    */   
/*    */   public RENDEROBJ current() {
/* 54 */     return this.current;
/*    */   }
/*    */   
/*    */   public void currentSet(RENDEROBJ c) {
/* 58 */     this.current = c;
/* 59 */     replace(c);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2\\util\gui\GuiSwitch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */