/*     */ package snake2d;
/*     */ 
/*     */ import java.nio.DoubleBuffer;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWMouseButtonCallback;
/*     */ import org.lwjgl.glfw.GLFWMouseButtonCallbackI;
/*     */ import org.lwjgl.glfw.GLFWScrollCallback;
/*     */ import org.lwjgl.glfw.GLFWScrollCallbackI;
/*     */ import snake2d.util.datatypes.Coo;
/*     */ import snake2d.util.gui.clickable.CLICKABLE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Mouse
/*     */ {
/*  18 */   public static CLICKABLE currentClicked = null;
/*     */   
/*     */   private float mXC;
/*     */   private float mYC;
/*  22 */   private final DoubleBuffer mX = BufferUtils.createDoubleBuffer(1);
/*  23 */   private final DoubleBuffer mY = BufferUtils.createDoubleBuffer(1);
/*  24 */   private final Coo MOUSE_COO = new Coo();
/*     */   
/*  26 */   private final int clickMax = 100;
/*  27 */   private final MButt[] clicks = new MButt[100];
/*  28 */   private volatile int clickCurrent = 0;
/*     */   
/*     */   private final long window;
/*     */   
/*     */   private final GLFWMouseButtonCallback callback;
/*     */   
/*     */   private final GLFWScrollCallback sCallback;
/*     */ 
/*     */   
/*     */   Mouse(long window) {
/*  38 */     this.window = window;
/*     */     
/*  40 */     this.callback = new GLFWMouseButtonCallback()
/*     */       {
/*     */         public void invoke(long window, int button, int action, int mods)
/*     */         {
/*  44 */           if (button > 2) {
/*     */             return;
/*     */           }
/*  47 */           if (((MButt)MButt.ALL.get(button)).isDown = (action == 1)) {
/*     */             
/*  49 */             long nanoOld = ((MButt)MButt.ALL.get(button)).nanoNow;
/*  50 */             ((MButt)MButt.ALL.get(button)).nanoNow = Input.nanoNow;
/*     */             
/*  52 */             if (Input.nanoNow - nanoOld < 250000000L && Mouse.this.clickCurrent < 100) {
/*  53 */               ((MButt)MButt.ALL.get(button)).isDouble = true;
/*     */             }
/*  55 */             if (Mouse.this.clickCurrent < 100) {
/*  56 */               Mouse.this.clickCurrent = Mouse.this.clickCurrent + 1; Mouse.this.clicks[Mouse.this.clickCurrent] = (MButt)MButt.ALL.get(button);
/*     */             } 
/*     */           } 
/*     */         }
/*     */       };
/*  61 */     GLFW.glfwSetMouseButtonCallback(window, (GLFWMouseButtonCallbackI)this.callback);
/*     */     
/*  63 */     this.sCallback = new GLFWScrollCallback()
/*     */       {
/*     */         public void invoke(long window, double xoffset, double yoffset)
/*     */         {
/*  67 */           MButt.delta += yoffset;
/*  68 */           MButt.wheelDy += (int)MButt.delta;
/*  69 */           MButt.delta -= (int)MButt.delta;
/*     */ 
/*     */           
/*  72 */           if ((int)MButt.wheelDy != 0 && Mouse.this.clickCurrent < 100) {
/*  73 */             Mouse.this.clickCurrent = Mouse.this.clickCurrent + 1; Mouse.this.clicks[Mouse.this.clickCurrent] = MButt.WHEEL_SPIN;
/*     */           } 
/*     */         }
/*     */       };
/*  77 */     GLFW.glfwSetScrollCallback(window, (GLFWScrollCallbackI)this.sCallback);
/*     */   }
/*     */ 
/*     */   
/*     */   void applySettings(SETTINGS sett) {
/*  82 */     this.mXC = sett.getNativeWidth() / (CORE.getGraphics()).mouseWindow.x();
/*  83 */     this.mYC = sett.getNativeHeight() / (CORE.getGraphics()).mouseWindow.y();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean update() {
/*  89 */     if (!CORE.getGraphics().isFocused()) {
/*  90 */       return false;
/*     */     }
/*  92 */     GLFW.glfwGetCursorPos(this.window, this.mX, this.mY);
/*  93 */     float newX = (float)Math.ceil(this.mX.get() * this.mXC);
/*  94 */     float newY = (float)Math.ceil(this.mY.get() * this.mYC);
/*  95 */     boolean ret = false;
/*     */     
/*  97 */     if (newX >= 0.0F && newX <= (CORE.getGraphics()).nativeWidth && newY >= 0.0F && newY <= (CORE.getGraphics()).nativeHeight && (
/*  98 */       newY != this.MOUSE_COO.y() || newX != this.MOUSE_COO.x())) {
/*  99 */       ret = true;
/* 100 */       this.MOUSE_COO.ySet(newY);
/* 101 */       this.MOUSE_COO.xSet(newX);
/*     */     } 
/*     */     
/* 104 */     this.mX.clear();
/* 105 */     this.mY.clear();
/* 106 */     return ret;
/*     */   }
/*     */   
/*     */   void poll(CORE_STATE current) {
/* 110 */     update();
/* 111 */     for (MButt b : MButt.ALL)
/* 112 */       b.clicks = 0; 
/* 113 */     if (this.clickCurrent > 0)
/* 114 */       currentClicked = null; 
/* 115 */     for (int i = 0; i < this.clickCurrent; i++) {
/* 116 */       (this.clicks[i]).clicks++;
/* 117 */       current.mouseClick(this.clicks[i]);
/*     */     } 
/* 119 */     for (MButt b : MButt.ALL)
/* 120 */       b.isDouble = false; 
/* 121 */     this.clickCurrent = 0;
/*     */   }
/*     */   
/*     */   void clear() {
/* 125 */     this.clickCurrent = 0;
/* 126 */     MButt.wheelDy = 0.0F;
/* 127 */     for (MButt b : MButt.ALL) {
/* 128 */       b.isDouble = false;
/* 129 */       b.isDown = false;
/* 130 */       b.clicks = 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void showCusor(boolean yes) {
/* 135 */     GLFW.glfwSetInputMode(this.window, 208897, 
/* 136 */         yes ? 212993 : 212994);
/*     */   }
/*     */   
/*     */   public Coo getCoo() {
/* 140 */     return this.MOUSE_COO;
/*     */   }
/*     */   
/*     */   public void setMousePoss(float x, float y) {
/* 144 */     GLFW.glfwSetCursorPos(this.window, x, y);
/*     */   }
/*     */   
/*     */   void release() {
/* 148 */     this.callback.close();
/* 149 */     this.sCallback.close();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Mouse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */