/*    */ package snake2d;
/*    */ 
/*    */ import org.lwjgl.glfw.GLFW;
/*    */ import org.lwjgl.glfw.GLFWErrorCallback;
/*    */ import org.lwjgl.opengl.GL;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class GraphicsCardGetter
/*    */ {
/* 23 */   private String error = null;
/* 24 */   private String version = null;
/*    */ 
/*    */ 
/*    */   
/*    */   public GraphicsCardGetter() {
/*    */     try {
/* 30 */       GLFWErrorCallback.createPrint(System.out).set();
/*    */ 
/*    */       
/* 33 */       if (!GLFW.glfwInit()) {
/* 34 */         throw new IllegalStateException("Unable to initialize GLFW");
/*    */       }
/*    */       
/* 37 */       GLFW.glfwDefaultWindowHints();
/* 38 */       GLFW.glfwWindowHint(131076, 0);
/*    */ 
/*    */       
/* 41 */       long window = 0L;
/* 42 */       window = GLFW.glfwCreateWindow(300, 300, "test", 0L, 0L);
/*    */       
/* 44 */       if (window == 0L) {
/* 45 */         throw new IllegalStateException("No window returned");
/*    */       }
/*    */       
/* 48 */       GLFW.glfwMakeContextCurrent(window);
/*    */       
/* 50 */       GL.createCapabilities();
/* 51 */       this.version = String.valueOf(GL11.glGetString(7936)) + ", " + GL11.glGetString(7937) + System.lineSeparator() + 
/* 52 */         "openGL max version: " + GL11.glGetString(7938);
/* 53 */       GLFW.glfwTerminate();
/* 54 */       GLFW.glfwSetErrorCallback(null).free();
/* 55 */     } catch (Exception e) {
/* 56 */       e.printStackTrace(System.out);
/* 57 */       this.error = e.getMessage();
/*    */     } 
/*    */   }
/*    */   
/*    */   public String version() {
/* 62 */     return this.version;
/*    */   }
/*    */   
/*    */   public String error() {
/* 66 */     return this.error;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\GraphicsCardGetter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */