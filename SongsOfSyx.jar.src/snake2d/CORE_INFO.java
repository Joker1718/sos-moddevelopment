/*     */ package snake2d;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import org.lwjgl.glfw.GLFW;
/*     */ import org.lwjgl.glfw.GLFWErrorCallback;
/*     */ import org.lwjgl.openal.ALUtil;
/*     */ import org.lwjgl.opengl.GL;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.process.Proccesser;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class CORE_INFO
/*     */ {
/*  33 */   public String error = null;
/*     */   public String SGL_VENDOR;
/*     */   public String SGL_RENDERER;
/*     */   public String SGL_VERSION;
/*  37 */   public int monitors = 0;
/*  38 */   public Displays.DisplayMode[][] displays = new Displays.DisplayMode[0][0];
/*  39 */   public Displays.DisplayMode[] currentdisplays = new Displays.DisplayMode[0];
/*     */   public String[] audioDevices;
/*     */   
/*     */   public static CORE_INFO cre2ate() {
/*  43 */     Process p = Proccesser.executeLwjgl(CORE_INFO.class, new String[0], new String[0], new String[0]); do {  }
/*  44 */     while (p.isAlive());
/*     */ 
/*     */     
/*  47 */     return new CORE_INFO(new Json((new File("Coreinfo.txt")).toPath()));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] args) {
/*  52 */     CORE_INFO f = new CORE_INFO();
/*  53 */     JsonE j = new JsonE();
/*  54 */     j.addString("ERROR", f.error);
/*  55 */     j.addString("SGL_VENDOR", f.SGL_VENDOR);
/*  56 */     j.addString("SGL_RENDERER", f.SGL_RENDERER);
/*  57 */     j.addString("SGL_VERSION", f.SGL_VERSION);
/*  58 */     j.add("MONITORS", f.monitors);
/*     */ 
/*     */     
/*  61 */     JsonE[] displays = new JsonE[f.displays.length];
/*  62 */     int i = 0; byte b; int k; Displays.DisplayMode[][] arrayOfDisplayMode;
/*  63 */     for (k = (arrayOfDisplayMode = f.displays).length, b = 0; b < k; ) { Displays.DisplayMode[] disps = arrayOfDisplayMode[b];
/*     */       
/*  65 */       int m = 0;
/*  66 */       JsonE[] res = new JsonE[disps.length]; byte b1; int n;
/*     */       Displays.DisplayMode[] arrayOfDisplayMode1;
/*  68 */       for (n = (arrayOfDisplayMode1 = disps).length, b1 = 0; b1 < n; ) { Displays.DisplayMode disp = arrayOfDisplayMode1[b1];
/*  69 */         res[m] = new JsonE();
/*  70 */         res[m].add("WI", disp.width);
/*  71 */         res[m].add("HI", disp.height);
/*  72 */         res[m].add("HZ", disp.refresh);
/*  73 */         m++;
/*     */         b1++; }
/*     */       
/*  76 */       displays[i] = new JsonE();
/*  77 */       displays[i].add("AVAILABLE", res);
/*  78 */       i++;
/*     */       b++; }
/*     */     
/*  81 */     j.add("DISPLAYS", displays);
/*     */ 
/*     */     
/*  84 */     displays = new JsonE[f.currentdisplays.length];
/*  85 */     for (i = 0; i < displays.length; i++) {
/*  86 */       displays[i] = new JsonE();
/*  87 */       displays[i].add("WI", (f.currentdisplays[i]).width);
/*  88 */       displays[i].add("HI", (f.currentdisplays[i]).height);
/*  89 */       displays[i].add("HZ", (f.currentdisplays[i]).refresh);
/*     */     } 
/*  91 */     j.add("CURRENT", displays);
/*     */ 
/*     */     
/*  94 */     j.addStrings("AUDIO_DEVICES", f.audioDevices);
/*     */     
/*  96 */     j.save((new File("")).toPath().resolve("Coreinfo.txt"));
/*     */   }
/*     */ 
/*     */   
/*     */   private CORE_INFO(Json json) {
/* 101 */     this.error = json.text("ERROR");
/* 102 */     this.SGL_VENDOR = json.text("SGL_VENDOR");
/* 103 */     this.SGL_RENDERER = json.text("SGL_RENDERER");
/* 104 */     this.SGL_VERSION = json.text("SGL_VERSION");
/* 105 */     this.monitors = json.i("MONITORS");
/* 106 */     Json[] displays = json.jsons("DISPLAYS");
/* 107 */     this.displays = new Displays.DisplayMode[displays.length][];
/* 108 */     int i = 0; byte b; int j; Json[] arrayOfJson1;
/* 109 */     for (j = (arrayOfJson1 = displays).length, b = 0; b < j; ) { Json json1 = arrayOfJson1[b];
/* 110 */       Json[] modes = json1.jsons("AVAILABLE");
/*     */       
/* 112 */       this.displays[i] = new Displays.DisplayMode[modes.length];
/* 113 */       int m = 0; byte b1; int n; Json[] arrayOfJson2;
/* 114 */       for (n = (arrayOfJson2 = modes).length, b1 = 0; b1 < n; ) { Json json2 = arrayOfJson2[b1];
/* 115 */         this.displays[i][m++] = new Displays.DisplayMode(json2.i("WI"), json2.i("HI"), json2.i("HZ"), false); b1++; }
/*     */       
/* 117 */       i++;
/*     */       b++; }
/*     */     
/* 120 */     Json[] ss = json.jsons("CURRENT");
/* 121 */     this.currentdisplays = new Displays.DisplayMode[ss.length];
/* 122 */     for (int k = 0; k < displays.length; k++) {
/* 123 */       this.currentdisplays[k] = new Displays.DisplayMode(ss[k].i("WI"), ss[k].i("HI"), ss[k].i("HZ"), false);
/*     */     }
/*     */     
/* 126 */     this.audioDevices = json.texts("AUDIO_DEVICES");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CORE_INFO() {
/*     */     try {
/* 136 */       GLFWErrorCallback.createPrint(System.err).set();
/*     */ 
/*     */       
/* 139 */       if (!GLFW.glfwInit()) {
/* 140 */         this.error = "Unable to initialize GLFW";
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 146 */       GLFW.glfwDefaultWindowHints();
/* 147 */       GLFW.glfwWindowHint(131076, 0);
/*     */ 
/*     */       
/* 150 */       long window = 0L;
/* 151 */       window = GLFW.glfwCreateWindow(300, 300, "test", 0L, 0L);
/*     */       
/* 153 */       if (window == 0L) {
/* 154 */         this.error = "Unable to create window";
/*     */         
/*     */         return;
/*     */       } 
/*     */       
/* 159 */       GLFW.glfwMakeContextCurrent(window);
/*     */       
/* 161 */       GL.createCapabilities();
/*     */ 
/*     */ 
/*     */       
/* 165 */       this.monitors = Displays.monitors();
/*     */       
/* 167 */       this.displays = new Displays.DisplayMode[this.monitors][];
/*     */       int j;
/* 169 */       for (j = 0; j < this.displays.length; j++) {
/* 170 */         this.displays[j] = new Displays.DisplayMode[Displays.available(j).size()];
/* 171 */         for (int k = 0; k < (this.displays[j]).length; k++) {
/* 172 */           this.displays[j][k] = (Displays.DisplayMode)Displays.available(j).get(k);
/*     */         }
/*     */       } 
/* 175 */       this.currentdisplays = new Displays.DisplayMode[this.monitors];
/* 176 */       for (j = 0; j < this.monitors; j++) {
/* 177 */         this.currentdisplays[j] = Displays.current(j);
/*     */       }
/*     */       
/* 180 */       this.SGL_VENDOR = GL11.glGetString(7936);
/* 181 */       this.SGL_RENDERER = GL11.glGetString(7937);
/* 182 */       this.SGL_VERSION = GL11.glGetString(7938);
/*     */       
/* 184 */       GLFW.glfwTerminate();
/* 185 */       GLFW.glfwSetErrorCallback(null).free();
/* 186 */     } catch (Exception e) {
/* 187 */       e.printStackTrace(System.err);
/* 188 */       this.error = e.getMessage();
/*     */     } 
/*     */     
/* 191 */     List<String> ss = ALUtil.getStringList(0L, 4115);
/* 192 */     if (ss.size() == 0) {
/* 193 */       this.error = "No OpenAL device could be found. Try enabling sound and or / plug in/out speakers/earphones or restart your computer.";
/*     */     }
/* 195 */     this.audioDevices = new String[ss.size()];
/* 196 */     for (int i = 0; i < ss.size(); i++)
/* 197 */       this.audioDevices[i] = ss.get(i); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\CORE_INFO.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */