/*    */ package snake2d;
/*    */ 
/*    */ import org.lwjgl.glfw.GLFW;
/*    */ import org.lwjgl.glfw.GLFWImage;
/*    */ import snake2d.util.file.SnakeImage;
/*    */ import snake2d.util.sets.LinkedList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class _IconLoader
/*    */ {
/*    */   static void setIcon(long window, String path) {
/* 14 */     String[] extens = {
/* 15 */         "Icon16", "Icon32", "Icon48"
/*    */       };
/*    */     
/* 18 */     LinkedList<SnakeImage> all = new LinkedList();
/* 19 */     GLFWImage.Buffer icons = GLFWImage.malloc(extens.length);
/*    */     
/* 21 */     for (int i = 0; i < extens.length; i++) {
/* 22 */       SnakeImage im = new SnakeImage(String.valueOf(path) + extens[i] + ".png");
/* 23 */       all.add(im);
/* 24 */       icons.position(i);
/* 25 */       icons.width(im.width).height(im.height).pixels(im.data());
/*    */     } 
/*    */     
/* 28 */     icons.position(0);
/*    */     
/* 30 */     GLFW.glfwSetWindowIcon(window, icons);
/*    */     
/* 32 */     icons.free();
/*    */     
/* 34 */     for (SnakeImage im : all)
/* 35 */       im.dispose(); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\_IconLoader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */