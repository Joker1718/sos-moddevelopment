/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ public class Input
/*     */   extends CORE_RESOURCE
/*     */ {
/*     */   private final Mouse mouse;
/*     */   private final KeyBoard keyboard;
/*     */   static int inputs;
/*     */   static long nanoNow;
/*     */   private boolean hasCleared;
/*     */   
/*     */   Input(GraphicContext window, SETTINGS sett) {
/*  17 */     this.keyboard = new KeyBoard(window);
/*  18 */     this.mouse = new Mouse(window.getWindow());
/*  19 */     this.mouse.applySettings(sett);
/*  20 */     this.mouse.update();
/*  21 */     inputs = 0;
/*     */   }
/*     */   
/*     */   public Mouse getMouse() {
/*  25 */     return this.mouse;
/*     */   }
/*     */   
/*     */   public KeyBoard getKeyboard() {
/*  29 */     return this.keyboard;
/*     */   }
/*     */   
/*     */   public void clearAllInput() {
/*  33 */     this.hasCleared = true;
/*  34 */     (CORE.getInput()).keyboard.listener = null;
/*  35 */     this.mouse.clear();
/*  36 */     this.keyboard.clear();
/*  37 */     inputs = 0;
/*     */   }
/*     */   
/*     */   void poll(long nanoNow, boolean focused) {
/*  41 */     MButt.wheelDy = 0.0F;
/*     */     
/*  43 */     GLFW.glfwPollEvents();
/*  44 */     if (!focused)
/*  45 */       clearAllInput(); 
/*  46 */     Input.nanoNow = nanoNow;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void poll(CORE_STATE current) {
/*  52 */     this.mouse.poll(current);
/*  53 */     this.keyboard.poll(current, this.hasCleared);
/*  54 */     this.hasCleared = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dis() {}
/*     */ 
/*     */   
/*     */   public static abstract class CHAR_LISTENER
/*     */   {
/*     */     private final Str text;
/*     */ 
/*     */     
/*     */     public CHAR_LISTENER(int size) {
/*  68 */       this.text = new Str(size);
/*     */     }
/*     */     
/*     */     protected void acceptChar(char c) {
/*  72 */       if (text().spaceLeft() > 0 && listening()) {
/*  73 */         text().add(c);
/*  74 */         change();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     protected void enter() {}
/*     */ 
/*     */     
/*     */     protected void backspace() {
/*  83 */       if (text().length() > 0 && listening()) {
/*  84 */         text().clearLast();
/*  85 */         change();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     public void del() {
/*  91 */       text().clear();
/*  92 */       change();
/*     */     }
/*     */     
/*     */     public void set(CharSequence name) {
/*  96 */       text().clear();
/*  97 */       text().add(name);
/*  98 */       change();
/*     */     }
/*     */     
/*     */     protected abstract void change();
/*     */     
/*     */     public Str text() {
/* 104 */       return this.text;
/*     */     }
/*     */     
/*     */     public void listen() {
/* 108 */       (CORE.getInput()).keyboard.listener = this;
/*     */     }
/*     */     
/*     */     public boolean listening() {
/* 112 */       return ((CORE.getInput()).keyboard.listener == this);
/*     */     }
/*     */     
/*     */     public void left(boolean mod) {}
/*     */     
/*     */     public void right(boolean mod) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Input.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */