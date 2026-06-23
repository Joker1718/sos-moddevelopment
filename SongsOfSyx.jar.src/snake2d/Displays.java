/*    */ package snake2d;
/*    */ 
/*    */ import org.lwjgl.PointerBuffer;
/*    */ import org.lwjgl.glfw.GLFW;
/*    */ import org.lwjgl.glfw.GLFWVidMode;
/*    */ import snake2d.util.sets.ArrayList;
/*    */ import snake2d.util.sets.LIST;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Displays
/*    */ {
/*    */   private static Displays self;
/*    */   private final DisplayMode[] currentDisplay;
/*    */   private final LIST<LIST<DisplayMode>> supported;
/* 18 */   private static final LIST<DisplayMode> ssupported = (LIST<DisplayMode>)new ArrayList(0);
/*    */   private final long[] monitors;
/*    */   
/*    */   Displays() {
/* 22 */     self = this;
/*    */     
/* 24 */     Printer.ln("DISPLAYS");
/*    */     
/* 26 */     PointerBuffer mBuffer = GLFW.glfwGetMonitors();
/*    */     
/* 28 */     if (mBuffer.capacity() == 0) {
/* 29 */       throw new IllegalStateException("No monitors are avalible!");
/*    */     }
/*    */     
/* 32 */     this.monitors = new long[mBuffer.capacity()];
/*    */     
/* 34 */     ArrayList<LIST<DisplayMode>> tmp = new ArrayList(mBuffer.capacity());
/* 35 */     this.currentDisplay = new DisplayMode[mBuffer.capacity()];
/*    */     
/* 37 */     for (int mi = 0; mi < mBuffer.capacity(); mi++) {
/* 38 */       this.monitors[mi] = mBuffer.get();
/*    */       
/* 40 */       GLFWVidMode vmode = GLFW.glfwGetVideoMode(this.monitors[mi]);
/* 41 */       this.currentDisplay[mi] = new DisplayMode(vmode.width(), vmode.height(), vmode.refreshRate(), false);
/* 42 */       GLFWVidMode.Buffer vModes = GLFW.glfwGetVideoModes(this.monitors[mi]);
/* 43 */       Printer.ln("DISPLAY " + mi + " ( " + this.currentDisplay[mi].toString() + " ) : ");
/* 44 */       ArrayList<DisplayMode> supp = new ArrayList(vModes.capacity());
/*    */       
/* 46 */       for (int i = 0; i < vModes.capacity(); i++) {
/* 47 */         supp.add(new DisplayMode(vModes.width(), vModes.height(), vModes.refreshRate(), true));
/* 48 */         Printer.pr(" | " + ((DisplayMode)supp.get(i)).toString());
/* 49 */         vModes.position(vModes.position() + 1);
/*    */       } 
/* 51 */       Printer.ln();
/*    */       
/* 53 */       tmp.add(supp);
/*    */     } 
/* 55 */     Printer.fin();
/*    */     
/* 57 */     this.supported = (LIST<LIST<DisplayMode>>)tmp;
/*    */   }
/*    */   
/*    */   public static int monitors() {
/* 61 */     if (self == null)
/* 62 */       return 0; 
/* 63 */     return self.supported.size();
/*    */   }
/*    */   
/*    */   static long pointer(int monitor) {
/* 67 */     return self.monitors[monitor];
/*    */   }
/*    */   
/*    */   public static LIST<DisplayMode> available(int monitor) {
/* 71 */     if (self == null)
/* 72 */       return ssupported; 
/* 73 */     return (LIST<DisplayMode>)self.supported.get(monitor);
/*    */   }
/*    */   
/*    */   public static DisplayMode current(int monitor) {
/* 77 */     if (self == null)
/* 78 */       return null; 
/* 79 */     return self.currentDisplay[monitor];
/*    */   }
/*    */ 
/*    */   
/*    */   public static class DisplayMode
/*    */   {
/*    */     public final int width;
/*    */     public final int height;
/*    */     public final int refresh;
/*    */     public final boolean fullScreen;
/*    */     
/*    */     public DisplayMode(int width, int height, int refresh, boolean fullScreen) {
/* 91 */       this.width = width;
/* 92 */       this.height = height;
/* 93 */       this.refresh = refresh;
/* 94 */       this.fullScreen = fullScreen;
/*    */     }
/*    */ 
/*    */     
/*    */     public String toString() {
/* 99 */       return String.valueOf(this.width) + "x" + this.height + "@" + this.refresh + "Hz";
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Displays.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */