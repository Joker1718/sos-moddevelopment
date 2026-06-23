/*     */ package view.interrupter;
/*     */ 
/*     */ import init.constant.C;
/*     */ import init.sprite.UI.UI;
/*     */ import snake2d.MButt;
/*     */ import snake2d.Renderer;
/*     */ import snake2d.SPRITE_RENDERER;
/*     */ import snake2d.util.color.COLOR;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.datatypes.RECTANGLE;
/*     */ import snake2d.util.gui.renderable.RENDEROBJ;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import util.gui.misc.GBox;
/*     */ import util.gui.misc.GButt;
/*     */ import view.keyboard.KEYS;
/*     */ 
/*     */ public class IPromtScreen extends Interrupter {
/*  19 */   private COLOR c = COLOR.WHITE100; private CharSequence message;
/*     */   
/*  21 */   private final RENDEROBJ.RenderImp text = new RENDEROBJ.RenderImp(600, 100)
/*     */     {
/*     */       public void render(SPRITE_RENDERER r, float ds)
/*     */       {
/*  25 */         IPromtScreen.this.c.bind();
/*  26 */         (UI.FONT()).H2.renderIn(r, (RECTANGLE)this.body, DIR.N, IPromtScreen.this.message);
/*  27 */         COLOR.unbind();
/*     */       }
/*     */     };
/*     */   
/*     */   private GButt[] butts;
/*     */   private GButt hovered;
/*     */   private ACTION deactivateAction;
/*     */   private final InterManager m;
/*     */   
/*     */   public IPromtScreen(InterManager manager) {
/*  37 */     pin();
/*  38 */     this.m = manager;
/*  39 */     this.text.body().centerIn(C.DIM());
/*     */   }
/*     */   
/*     */   public void activate(CharSequence message, COLOR c, ACTION deactivateAction, GButt... butts) {
/*  43 */     show(this.m);
/*  44 */     this.message = message;
/*  45 */     this.c = c;
/*  46 */     this.text.body().centerIn(C.DIM());
/*     */     
/*  48 */     this.butts = butts;
/*  49 */     this.hovered = null;
/*     */     
/*  51 */     this.deactivateAction = deactivateAction;
/*     */     
/*  53 */     if (butts.length == 0) {
/*     */       return;
/*     */     }
/*  56 */     int w = C.WIDTH() / 12;
/*  57 */     int y = this.text.body().y2() + 40;
/*  58 */     int x = C.WIDTH() / 2;
/*  59 */     x -= butts.length * w / 2; byte b; int i;
/*     */     GButt[] arrayOfGButt;
/*  61 */     for (i = (arrayOfGButt = butts).length, b = 0; b < i; ) { GButt gButt = arrayOfGButt[b];
/*  62 */       gButt.body().moveX1Y1((x - gButt.body().width() / 2), y);
/*  63 */       x += 2 * w;
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/*     */   public void deactivate() {
/*  69 */     if (this.deactivateAction != null)
/*  70 */       this.deactivateAction.exe(); 
/*  71 */     hide();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hoverTimer(GBox text) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean render(Renderer r, float ds) {
/*  82 */     this.text.render((SPRITE_RENDERER)r, ds);
/*  83 */     if (this.butts.length == 0)
/*  84 */       return false;  byte b; int i; GButt[] arrayOfGButt;
/*  85 */     for (i = (arrayOfGButt = this.butts).length, b = 0; b < i; ) { GButt gButt = arrayOfGButt[b];
/*  86 */       gButt.render((SPRITE_RENDERER)r, ds); b++; }
/*  87 */      return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void mouseClick(MButt button) {
/*  93 */     if (this.butts.length == 0) {
/*  94 */       deactivate();
/*     */     }
/*     */     
/*  97 */     if (this.hovered != null && this.hovered.hoveredIs()) {
/*  98 */       deactivate();
/*  99 */       this.hovered.click();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean hover(COORDINATE mCoo, boolean mouseHasMoved) {
/* 107 */     if (this.butts.length == 0) {
/* 108 */       return true;
/*     */     }
/* 110 */     if (this.hovered != null && this.hovered.hover(mCoo))
/* 111 */       return true;  byte b; int i;
/*     */     GButt[] arrayOfGButt;
/* 113 */     for (i = (arrayOfGButt = this.butts).length, b = 0; b < i; ) { GButt gButt = arrayOfGButt[b];
/* 114 */       if (gButt.hover(mCoo))
/* 115 */         this.hovered = gButt;  b++; }
/*     */     
/* 117 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean update(float ds) {
/* 123 */     if ((KEYS.MAIN()).ESCAPE.consumeClick() || (KEYS.MAIN()).ENTER.consumeClick())
/* 124 */       deactivate(); 
/* 125 */     KEYS.clear();
/* 126 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\view\interrupter\IPromtScreen.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */