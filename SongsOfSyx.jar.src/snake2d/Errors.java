/*     */ package snake2d;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.nio.file.FileSystems;
/*     */ import java.nio.file.Path;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import snake2d.util.misc.ERROR_HANDLER;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Errors
/*     */ {
/*     */   private static Errors i;
/*     */   private static ERROR_HANDLER h;
/*  17 */   private final Logger out = new Logger(System.out, null);
/*  18 */   private final Logger err = new Logger(System.err, null);
/*     */   
/*     */   public static void init(ERROR_HANDLER handler) {
/*  21 */     if (i != null) {
/*  22 */       throw new RuntimeException("handler already setup");
/*     */     }
/*  24 */     i = new Errors(handler);
/*     */   }
/*     */   
/*     */   private Errors(ERROR_HANDLER handler) {
/*  28 */     h = handler;
/*     */     try {
/*  30 */       System.setOut(new PrintStream(this.out));
/*  31 */       System.setErr(new PrintStream(this.err));
/*  32 */     } catch (Exception e) {
/*  33 */       e.printStackTrace();
/*  34 */       throw new RuntimeException("can't set stdOut");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void handle(Throwable e) {
/*  41 */     if (e == null) {
/*  42 */       check();
/*     */       
/*     */       return;
/*     */     } 
/*  46 */     e.printStackTrace();
/*  47 */     diagnozeMem();
/*  48 */     if (h == null) {
/*     */       return;
/*     */     }
/*  51 */     String dump = getDumpFile();
/*     */     
/*  53 */     if (e instanceof DataError) {
/*  54 */       h.handle((DataError)e, dump);
/*  55 */     } else if (e instanceof GameError) {
/*  56 */       h.handle((GameError)e, dump);
/*     */     } else {
/*  58 */       h.handle(e, dump);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void check() {
/*  65 */     if (hasDump()) {
/*  66 */       String dd = i.err.data.toString();
/*  67 */       String dump = getDumpFile();
/*  68 */       if (dump != null && h != null) {
/*  69 */         h.handle(dd, dump);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean hasDump() {
/*  77 */     return (i.err.data.length() != 0);
/*     */   }
/*     */   
/*     */   private static String getDumpFile() {
/*  81 */     if (i.err.data.length() != 0) {
/*     */       
/*  83 */       String n = System.getProperty("line.separator");
/*  84 */       String fin = i.out.data.toString();
/*  85 */       String err = i.err.data.toString();
/*     */       
/*  87 */       fin = fin.replaceAll("\"", "'");
/*  88 */       err = err.replaceAll("\"", "'");
/*     */       
/*  90 */       String d = 
/*  91 */         n + "|-------------------|" + 
/*  92 */         n + "|     ERROR LOG     |" + 
/*  93 */         n + "|-------------------|" + 
/*  94 */         n + err + 
/*  95 */         n + 
/*  96 */         n + "|-------------------|" + 
/*  97 */         n + "|      STD OUT      |" + 
/*  98 */         n + "|-------------------|" + 
/*  99 */         n + fin;
/*     */ 
/*     */ 
/*     */       
/* 103 */       i.err.data = new StringBuffer();
/* 104 */       i.out.data = new StringBuffer();
/* 105 */       return d;
/*     */     } 
/*     */     
/* 108 */     i.err.data = new StringBuffer();
/* 109 */     i.out.data = new StringBuffer();
/* 110 */     return null;
/*     */   }
/*     */   
/*     */   public static class DataError
/*     */     extends RuntimeException {
/*     */     private static final long serialVersionUID = 1L;
/*     */     public final String error;
/*     */     public final String path;
/*     */     
/*     */     public DataError(String error, String path) {
/* 120 */       super(String.valueOf(error) + " path: " + path);
/* 121 */       this.error = error;
/* 122 */       this.path = path;
/*     */     }
/*     */     
/*     */     public DataError(String error, Path sourcePath) {
/* 126 */       this(error, path(sourcePath));
/*     */     }
/*     */     
/*     */     private static String path(Path sourcePath) {
/* 130 */       if (sourcePath.getFileSystem() != FileSystems.getDefault()) {
/* 131 */         return sourcePath.getFileSystem() + "->" + sourcePath.toAbsolutePath();
/*     */       }
/* 133 */       return (String)sourcePath.toAbsolutePath();
/*     */     }
/*     */     
/*     */     public DataError(String error) {
/* 137 */       this(error, "");
/*     */     }
/*     */   }
/*     */   
/*     */   public static class GameError
/*     */     extends RuntimeException
/*     */   {
/*     */     private static final long serialVersionUID = 1L;
/*     */     public final String error;
/*     */     
/*     */     public GameError(String error) {
/* 148 */       super(error);
/* 149 */       this.error = error;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class Logger
/*     */     extends OutputStream
/*     */   {
/* 156 */     private StringBuffer data = new StringBuffer();
/*     */     private final PrintStream out;
/*     */     
/*     */     private Logger(PrintStream out) {
/* 160 */       this.out = out;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public synchronized void write(int b) throws IOException {
/* 166 */       this.out.write(b);
/* 167 */       if (this.data.length() > 250000)
/* 168 */         this.data.setLength(0); 
/* 169 */       this.data.append((char)b);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void diagnozeMem() {
/* 177 */     int mb = 1038336;
/*     */     try {
/* 179 */       System.err.println("Time until crash: " + ((CORE.getUpdateInfo() == null) ? 0.0D : CORE.getUpdateInfo().getSecondsSinceFirstUpdate()));
/* 180 */       System.err.println("MEM DIAGNOSE");
/* 181 */       Runtime run = Runtime.getRuntime();
/*     */       
/* 183 */       System.err.println("--JRE Memory");
/* 184 */       System.err.println("--JRE Total: " + (run.totalMemory() / mb));
/* 185 */       System.err.println("--JRE Free: " + (run.freeMemory() / mb));
/* 186 */       System.err.println("--JRE Used: " + ((
/* 187 */           run.totalMemory() - run.freeMemory()) / mb));
/* 188 */       System.err.println("--JRE Max: " + (run.maxMemory() / mb));
/* 189 */       System.gc();
/* 190 */       System.err.println("--JRE Memory After GC");
/* 191 */       System.err.println("--JRE Total: " + (run.totalMemory() / mb));
/* 192 */       System.err.println("--JRE Free: " + (run.freeMemory() / mb));
/* 193 */       System.err.println("--JRE Used: " + ((
/* 194 */           run.totalMemory() - run.freeMemory()) / mb));
/* 195 */       System.err.println("--JRE Max: " + (run.maxMemory() / mb));
/*     */       
/* 197 */       System.err.println("NVIDIA: ");
/* 198 */       int i = GL11.glGetInteger(36935);
/* 199 */       System.err.println("--GPU Dedicated: " + i);
/* 200 */       i = GL11.glGetInteger(36936);
/* 201 */       System.err.println("--GPU Total Available: " + i);
/* 202 */       i = GL11.glGetInteger(36937);
/* 203 */       System.err.println("--GPU Current Available: " + i);
/* 204 */       i = GL11.glGetInteger(36938);
/* 205 */       System.err.println("--GPU Evictions: " + i);
/* 206 */       i = GL11.glGetInteger(36939);
/* 207 */       System.err.println("--GPU Evicted: " + i);
/*     */       
/* 209 */       System.err.println("ATI: ");
/* 210 */       i = GL11.glGetInteger(34813);
/* 211 */       System.err.println("--Renderbuffer Free: " + i);
/* 212 */       i = GL11.glGetInteger(34812);
/* 213 */       System.err.println("--Texture Free: " + i);
/* 214 */       i = GL11.glGetInteger(34811);
/* 215 */       System.err.println("--Vbo Free: " + i);
/* 216 */       GL11.glGetError();
/* 217 */     } catch (Exception e) {
/* 218 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\Errors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */