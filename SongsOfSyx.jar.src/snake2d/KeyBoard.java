/*     */ package snake2d;
/*     */ 
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWCharCallback;
/*     */ import org.lwjgl.glfw.GLFWCharCallbackI;
/*     */ import org.lwjgl.glfw.GLFWKeyCallback;
/*     */ import org.lwjgl.glfw.GLFWKeyCallbackI;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KeyBoard
/*     */ {
/*     */   private final GLFWKeyCallback callback;
/*     */   private final GLFWCharCallback charCallback;
/*  19 */   private final char[] chars = new char[128];
/*  20 */   private final int[] keys = Alloc.ii(384);
/*     */   
/*  22 */   private volatile int charsI = 0;
/*  23 */   private volatile int keysI = 0;
/*     */   
/*     */   Input.CHAR_LISTENER listener;
/*     */   private boolean listening = false;
/*  27 */   private final ArrayList<KeyEvent> pollsA = new ArrayList(128);
/*  28 */   private final ArrayList<KeyEvent> polls = new ArrayList(128);
/*     */   
/*     */   public enum KEYACTION
/*     */   {
/*  32 */     RELEASE, PRESS, REPEAT; static {
/*     */     
/*  34 */     } public static final LIST<KEYACTION> ALL = (LIST<KEYACTION>)new ArrayList((Object[])values());
/*     */   }
/*     */ 
/*     */   
/*     */   KeyBoard(final GraphicContext w) {
/*  39 */     while (this.pollsA.hasRoom()) {
/*  40 */       this.pollsA.add(new KeyEvent(null));
/*     */     }
/*     */     
/*  43 */     this.callback = new GLFWKeyCallback()
/*     */       {
/*     */         
/*     */         public void invoke(long window, int key, int scancode, int action, int mods)
/*     */         {
/*  48 */           if (KeyBoard.this.keysI >= KeyBoard.this.keys.length - 1) {
/*     */             return;
/*     */           }
/*  51 */           if (KEYCODES.exists(key)) {
/*  52 */             if (key == 283) {
/*  53 */               if (action == 1) {
/*  54 */                 w.takeScreenShot();
/*     */               }
/*     */               return;
/*     */             } 
/*  58 */             KeyBoard.this.keys[KeyBoard.this.keysI] = key;
/*  59 */             KeyBoard.this.keys[KeyBoard.this.keysI + 1] = action;
/*  60 */             KeyBoard.this.keys[KeyBoard.this.keysI + 2] = mods;
/*     */ 
/*     */             
/*  63 */             KeyBoard.this.keysI = KeyBoard.this.keysI + 3;
/*     */           } 
/*     */         }
/*     */       };
/*     */     
/*  68 */     GLFW.glfwSetKeyCallback(w.getWindow(), (GLFWKeyCallbackI)this.callback);
/*     */     
/*  70 */     this.charCallback = new GLFWCharCallback()
/*     */       {
/*     */         public void invoke(long window, int codepoint) {
/*  73 */           if (KeyBoard.this.charsI >= KeyBoard.this.chars.length)
/*     */             return; 
/*  75 */           KeyBoard.this.chars[KeyBoard.this.charsI] = (char)codepoint;
/*  76 */           KeyBoard.this.charsI = KeyBoard.this.charsI + 1;
/*     */         }
/*     */       };
/*     */ 
/*     */     
/*  81 */     GLFW.glfwSetCharCallback(w.getWindow(), (GLFWCharCallbackI)this.charCallback);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void poll(CORE_STATE current, boolean cleared) {
/*  89 */     int pi = 0; int i;
/*  90 */     for (i = 0; i < this.keysI; i += 3) {
/*  91 */       KEYACTION a = (KEYACTION)KEYACTION.ALL.get(this.keys[i + 1]);
/*  92 */       int c = this.keys[i];
/*  93 */       if (this.listener != null && c != 256) {
/*  94 */         if (this.listener != null && (a == KEYACTION.PRESS || a == KEYACTION.REPEAT)) {
/*  95 */           if (c == 257)
/*  96 */             this.listener.enter(); 
/*  97 */           if (c == 259)
/*  98 */             this.listener.backspace(); 
/*  99 */           if (c == 263)
/* 100 */             this.listener.left((GLFW.glfwGetKey(CORE.getGraphics().getWindow(), 340) == 1)); 
/* 101 */           if (c == 262)
/* 102 */             this.listener.right((GLFW.glfwGetKey(CORE.getGraphics().getWindow(), 340) == 1)); 
/* 103 */           if (c == 261)
/* 104 */             this.listener.del(); 
/*     */         } 
/* 106 */         if (c == 257)
/*     */         {
/* 108 */           this.polls.add(((KeyEvent)this.pollsA.get(pi++)).assign(this.keys[i], (KEYACTION)KEYACTION.ALL.get(this.keys[i + 1]), this.keys[i + 2]));
/*     */         }
/*     */       } else {
/*     */         
/* 112 */         this.polls.add(((KeyEvent)this.pollsA.get(pi++)).assign(this.keys[i], (KEYACTION)KEYACTION.ALL.get(this.keys[i + 1]), this.keys[i + 2]));
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 117 */     current.keyPush((LIST<KeyEvent>)this.polls, cleared);
/*     */     
/* 119 */     if (this.listener != null) {
/* 120 */       for (i = 0; i < this.charsI; i++) {
/* 121 */         this.listener.acceptChar(this.chars[i]);
/*     */       }
/* 123 */       this.listening = true;
/*     */     } else {
/* 125 */       this.listening = false;
/*     */     } 
/* 127 */     clear();
/*     */   }
/*     */   
/*     */   void clear() {
/* 131 */     this.keysI = 0;
/* 132 */     this.charsI = 0;
/* 133 */     this.polls.clear();
/* 134 */     this.listener = null;
/*     */   }
/*     */   
/*     */   void release() {
/* 138 */     this.callback.close();
/* 139 */     this.charCallback.close();
/*     */   }
/*     */   
/*     */   public boolean isPressed(int code) {
/* 143 */     return (CORE.getGraphics().focused() && this.listener == null && !this.listening && GLFW.glfwGetKey(CORE.getGraphics().getWindow(), code) == 1);
/*     */   }
/*     */   
/*     */   public String translate(int code) {
/* 147 */     return GLFW.glfwGetKeyName(code, -1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class KeyEvent
/*     */   {
/*     */     private int code;
/*     */     
/*     */     private KeyBoard.KEYACTION action;
/*     */     private int mod;
/*     */     
/*     */     private KeyEvent() {}
/*     */     
/*     */     KeyEvent assign(int code, KeyBoard.KEYACTION action, int mod) {
/* 161 */       this.code = code;
/* 162 */       this.action = action;
/* 163 */       this.mod = mod;
/* 164 */       return this;
/*     */     }
/*     */     
/*     */     public int code() {
/* 168 */       return this.code;
/*     */     }
/*     */     
/*     */     public KeyBoard.KEYACTION action() {
/* 172 */       return this.action;
/*     */     }
/*     */     
/*     */     public int mod() {
/* 176 */       return this.mod;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\KeyBoard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */