/*     */ package snake2d;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import org.lwjgl.opengl.AMDDebugOutput;
/*     */ import org.lwjgl.opengl.ARBDebugOutput;
/*     */ import org.lwjgl.opengl.GL;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.opengl.GL43;
/*     */ import org.lwjgl.opengl.GLCapabilities;
/*     */ import org.lwjgl.opengl.GLDebugMessageAMDCallback;
/*     */ import org.lwjgl.opengl.GLDebugMessageAMDCallbackI;
/*     */ import org.lwjgl.opengl.GLDebugMessageARBCallback;
/*     */ import org.lwjgl.opengl.GLDebugMessageARBCallbackI;
/*     */ import org.lwjgl.opengl.GLDebugMessageCallback;
/*     */ import org.lwjgl.opengl.GLDebugMessageCallbackI;
/*     */ import org.lwjgl.opengl.KHRDebug;
/*     */ import org.lwjgl.system.APIUtil;
/*     */ import org.lwjgl.system.Callback;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GlDebugger
/*     */ {
/*     */   public static Callback setupDebugMessageCallback() {
/*  80 */     return setupDebugMessageCallback(APIUtil.DEBUG_STREAM);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Callback setupDebugMessageCallback(PrintStream stream) {
/*  90 */     GLCapabilities caps = GL.getCapabilities();
/*     */     
/*  92 */     if (caps.OpenGL43) {
/*  93 */       APIUtil.apiLog("[GL] Using OpenGL 4.3 for error logging.");
/*  94 */       GLDebugMessageCallback proc = GLDebugMessageCallback.create((source, type, id, severity, length, message, userParam) -> {
/*     */             if (severity != 33387) {
/*     */               paramPrintStream.println("[LWJGL] OpenGL debug message");
/*     */               printDetail(paramPrintStream, "ID", String.format("0x%X", new Object[] { Integer.valueOf(id) }));
/*     */               printDetail(paramPrintStream, "Source", getDebugSource(source));
/*     */               printDetail(paramPrintStream, "Type", getDebugType(type));
/*     */               printDetail(paramPrintStream, "Severity", getDebugSeverity(severity));
/*     */               printDetail(paramPrintStream, "Message", GLDebugMessageCallback.getMessage(length, message));
/*     */             } 
/*     */           });
/* 104 */       GL43.glDebugMessageCallback((GLDebugMessageCallbackI)proc, 0L);
/* 105 */       if ((GL11.glGetInteger(33310) & 0x2) == 0) {
/* 106 */         APIUtil.apiLog("[GL] Warning: A non-debug context may not produce any debug output.");
/* 107 */         GL11.glEnable(37600);
/*     */       } 
/* 109 */       return (Callback)proc;
/*     */     } 
/*     */     
/* 112 */     if (caps.GL_KHR_debug) {
/* 113 */       APIUtil.apiLog("[GL] Using KHR_debug for error logging.");
/* 114 */       GLDebugMessageCallback proc = GLDebugMessageCallback.create((source, type, id, severity, length, message, userParam) -> {
/*     */             if (severity != 33387) {
/*     */               paramPrintStream.println("[LWJGL] OpenGL debug message");
/*     */               printDetail(paramPrintStream, "ID", String.format("0x%X", new Object[] { Integer.valueOf(id) }));
/*     */               printDetail(paramPrintStream, "Source", getDebugSource(source));
/*     */               printDetail(paramPrintStream, "Type", getDebugType(type));
/*     */               printDetail(paramPrintStream, "Severity", getDebugSeverity(severity));
/*     */               printDetail(paramPrintStream, "Message", GLDebugMessageCallback.getMessage(length, message));
/*     */             } 
/*     */           });
/* 124 */       KHRDebug.glDebugMessageCallback((GLDebugMessageCallbackI)proc, 0L);
/* 125 */       if (caps.OpenGL30 && (GL11.glGetInteger(33310) & 0x2) == 0) {
/* 126 */         APIUtil.apiLog("[GL] Warning: A non-debug context may not produce any debug output.");
/* 127 */         GL11.glEnable(37600);
/*     */       } 
/* 129 */       return (Callback)proc;
/*     */     } 
/*     */     
/* 132 */     if (caps.GL_ARB_debug_output) {
/* 133 */       APIUtil.apiLog("[GL] Using ARB_debug_output for error logging.");
/* 134 */       GLDebugMessageARBCallback proc = GLDebugMessageARBCallback.create((source, type, id, severity, length, message, userParam) -> {
/*     */             if (severity != 33387) {
/*     */               paramPrintStream.println("[LWJGL] ARB_debug_output message");
/*     */               
/*     */               printDetail(paramPrintStream, "ID", String.format("0x%X", new Object[] { Integer.valueOf(id) }));
/*     */               printDetail(paramPrintStream, "Source", getSourceARB(source));
/*     */               printDetail(paramPrintStream, "Type", getTypeARB(type));
/*     */               printDetail(paramPrintStream, "Severity", getSeverityARB(severity));
/*     */               printDetail(paramPrintStream, "Message", GLDebugMessageARBCallback.getMessage(length, message));
/*     */             } 
/*     */           });
/* 145 */       ARBDebugOutput.glDebugMessageCallbackARB((GLDebugMessageARBCallbackI)proc, 0L);
/* 146 */       return (Callback)proc;
/*     */     } 
/*     */     
/* 149 */     if (caps.GL_AMD_debug_output) {
/* 150 */       APIUtil.apiLog("[GL] Using AMD_debug_output for error logging.");
/* 151 */       GLDebugMessageAMDCallback proc = GLDebugMessageAMDCallback.create((id, category, severity, length, message, userParam) -> {
/*     */             if (severity != 33387) {
/*     */               paramPrintStream.println("[LWJGL] AMD_debug_output message");
/*     */               
/*     */               printDetail(paramPrintStream, "ID", String.format("0x%X", new Object[] { Integer.valueOf(id) }));
/*     */               printDetail(paramPrintStream, "Category", getCategoryAMD(category));
/*     */               printDetail(paramPrintStream, "Severity", getSeverityAMD(severity));
/*     */               printDetail(paramPrintStream, "Message", GLDebugMessageAMDCallback.getMessage(length, message));
/*     */             } 
/*     */           });
/* 161 */       AMDDebugOutput.glDebugMessageCallbackAMD((GLDebugMessageAMDCallbackI)proc, 0L);
/* 162 */       return (Callback)proc;
/*     */     } 
/*     */     
/* 165 */     APIUtil.apiLog("[GL] No debug output implementation is available.");
/* 166 */     return null;
/*     */   }
/*     */   
/*     */   private static void printDetail(PrintStream stream, String type, String message) {
/* 170 */     stream.printf("\t%s: %s\n", new Object[] { type, message });
/*     */   }
/*     */   
/*     */   private static String getDebugSource(int source) {
/* 174 */     switch (source) {
/*     */       case 33350:
/* 176 */         return "API";
/*     */       case 33351:
/* 178 */         return "WINDOW SYSTEM";
/*     */       case 33352:
/* 180 */         return "SHADER COMPILER";
/*     */       case 33353:
/* 182 */         return "THIRD PARTY";
/*     */       case 33354:
/* 184 */         return "APPLICATION";
/*     */       case 33355:
/* 186 */         return "OTHER";
/*     */     } 
/* 188 */     return APIUtil.apiUnknownToken(source);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getDebugType(int type) {
/* 193 */     switch (type) {
/*     */       case 33356:
/* 195 */         return "ERROR";
/*     */       case 33357:
/* 197 */         return "DEPRECATED BEHAVIOR";
/*     */       case 33358:
/* 199 */         return "UNDEFINED BEHAVIOR";
/*     */       case 33359:
/* 201 */         return "PORTABILITY";
/*     */       case 33360:
/* 203 */         return "PERFORMANCE";
/*     */       case 33361:
/* 205 */         return "OTHER";
/*     */       case 33384:
/* 207 */         return "MARKER";
/*     */     } 
/* 209 */     return APIUtil.apiUnknownToken(type);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getDebugSeverity(int severity) {
/* 214 */     switch (severity) {
/*     */       case 37190:
/* 216 */         return "HIGH";
/*     */       case 37191:
/* 218 */         return "MEDIUM";
/*     */       case 37192:
/* 220 */         return "LOW";
/*     */       case 33387:
/* 222 */         return "NOTIFICATION";
/*     */     } 
/* 224 */     return APIUtil.apiUnknownToken(severity);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSourceARB(int source) {
/* 229 */     switch (source) {
/*     */       case 33350:
/* 231 */         return "API";
/*     */       case 33351:
/* 233 */         return "WINDOW SYSTEM";
/*     */       case 33352:
/* 235 */         return "SHADER COMPILER";
/*     */       case 33353:
/* 237 */         return "THIRD PARTY";
/*     */       case 33354:
/* 239 */         return "APPLICATION";
/*     */       case 33355:
/* 241 */         return "OTHER";
/*     */     } 
/* 243 */     return APIUtil.apiUnknownToken(source);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getTypeARB(int type) {
/* 248 */     switch (type) {
/*     */       case 33356:
/* 250 */         return "ERROR";
/*     */       case 33357:
/* 252 */         return "DEPRECATED BEHAVIOR";
/*     */       case 33358:
/* 254 */         return "UNDEFINED BEHAVIOR";
/*     */       case 33359:
/* 256 */         return "PORTABILITY";
/*     */       case 33360:
/* 258 */         return "PERFORMANCE";
/*     */       case 33361:
/* 260 */         return "OTHER";
/*     */     } 
/* 262 */     return APIUtil.apiUnknownToken(type);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSeverityARB(int severity) {
/* 267 */     switch (severity) {
/*     */       case 37190:
/* 269 */         return "HIGH";
/*     */       case 37191:
/* 271 */         return "MEDIUM";
/*     */       case 37192:
/* 273 */         return "LOW";
/*     */     } 
/* 275 */     return APIUtil.apiUnknownToken(severity);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getCategoryAMD(int category) {
/* 280 */     switch (category) {
/*     */       case 37193:
/* 282 */         return "API ERROR";
/*     */       case 37194:
/* 284 */         return "WINDOW SYSTEM";
/*     */       case 37195:
/* 286 */         return "DEPRECATION";
/*     */       case 37196:
/* 288 */         return "UNDEFINED BEHAVIOR";
/*     */       case 37197:
/* 290 */         return "PERFORMANCE";
/*     */       case 37198:
/* 292 */         return "SHADER COMPILER";
/*     */       case 37199:
/* 294 */         return "APPLICATION";
/*     */       case 37200:
/* 296 */         return "OTHER";
/*     */     } 
/* 298 */     return APIUtil.apiUnknownToken(category);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSeverityAMD(int severity) {
/* 303 */     switch (severity) {
/*     */       case 37190:
/* 305 */         return "HIGH";
/*     */       case 37191:
/* 307 */         return "MEDIUM";
/*     */       case 37192:
/* 309 */         return "LOW";
/*     */     } 
/* 311 */     return APIUtil.apiUnknownToken(severity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\GlDebugger.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */