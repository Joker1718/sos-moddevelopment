/*    */ package util.gui.table;
/*    */ 
/*    */ import snake2d.MButt;
/*    */ import snake2d.SPRITE_RENDERER;
/*    */ import snake2d.util.datatypes.BODY_HOLDER;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.gui.clickable.CLICKABLE;
/*    */ import snake2d.util.sprite.text.Font;
/*    */ import util.data.GETTER;
/*    */ import util.data.INT;
/*    */ import util.gui.slider.GSliderVer;
/*    */ 
/*    */ public class GTextScroller
/*    */   extends CLICKABLE.ClickableAbs {
/*    */   private final Font f;
/*    */   private final GETTER<CharSequence> text;
/*    */   private final GSliderVer slider;
/* 18 */   private final INT.IntImp target = new INT.IntImp();
/*    */   
/*    */   public GTextScroller(Font f, GETTER<CharSequence> text, int width, int height) {
/* 21 */     this.f = f;
/* 22 */     this.text = text;
/* 23 */     this.body.setDim(width, height);
/* 24 */     this.slider = new GSliderVer((INT.INTE)this.target, height);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void render(SPRITE_RENDERER r, float ds, boolean isActive, boolean isSelected, boolean isHovered) {
/* 29 */     CharSequence body = (CharSequence)this.text.get();
/* 30 */     this.target.min = 0;
/* 31 */     this.slider.body().moveX2(body().x2());
/* 32 */     this.slider.body().moveY1(body().y1());
/*    */     
/* 34 */     double d = MButt.clearWheelSpin();
/* 35 */     if (d > 0.0D) {
/* 36 */       this.target.inc(-1);
/* 37 */     } else if (d < 0.0D) {
/* 38 */       this.target.inc(1);
/*    */     } 
/*    */     
/* 41 */     int width = body().width() - this.slider.body().width() - 16;
/*    */     
/* 43 */     int rows = 0;
/*    */     
/* 45 */     if (body != null && width > this.f.height()) {
/* 46 */       int ei = 0;
/* 47 */       while (ei < body.length()) {
/* 48 */         int n = this.f.getEndIndex(body, ei, width);
/* 49 */         n = this.f.getStartIndex(body, n);
/* 50 */         ei = this.f.getStartIndex(body, n);
/* 51 */         rows++;
/*    */       } 
/*    */     } 
/*    */     
/* 55 */     rows -= body().height() / this.f.height();
/* 56 */     if (rows < 0)
/* 57 */       rows = 0; 
/* 58 */     this.target.max = rows;
/* 59 */     if (this.target.i > rows) {
/* 60 */       this.target.i = rows;
/*    */     }
/* 62 */     this.slider.render(r, ds);
/*    */     
/* 64 */     if (body != null && width > this.f.height()) {
/* 65 */       int y1 = body().y1();
/* 66 */       int x1 = body().x1() + 8;
/* 67 */       int ei = 0;
/* 68 */       int ri = 0;
/* 69 */       while (ei < body.length()) {
/* 70 */         int n = this.f.getEndIndex(body, ei, width);
/* 71 */         if (ri++ >= this.target.i && y1 < body().y2() - this.f.height()) {
/* 72 */           this.f.render(r, body, x1, y1, ei, n, 1.0D);
/* 73 */           y1 += this.f.height();
/*    */         } 
/* 75 */         n = this.f.getStartIndex(body, n);
/* 76 */         ei = this.f.getStartIndex(body, n);
/* 77 */         rows++;
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean click() {
/* 86 */     return this.slider.click();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean hover(COORDINATE mCoo) {
/* 91 */     return !(!this.slider.hover(mCoo) && !mCoo.isWithinRec((BODY_HOLDER)this));
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\gui\table\GTextScroller.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */