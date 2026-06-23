/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.io.PrintStream;
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
/*     */ public final class GLUtil
/*     */ {
/*     */   public static Callback setupDebugMessageCallback() {
/*  29 */     return setupDebugMessageCallback(APIUtil.DEBUG_STREAM);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Callback setupDebugMessageCallback(PrintStream stream) {
/*  39 */     GLCapabilities caps = GL.getCapabilities();
/*     */     
/*  41 */     if (caps.OpenGL43) {
/*  42 */       APIUtil.apiLog("[GL] Using OpenGL 4.3 for error logging.");
/*  43 */       GLDebugMessageCallback proc = GLDebugMessageCallback.create((source, type, id, severity, length, message, userParam) -> {
/*     */             StringBuilder sb = new StringBuilder(300);
/*     */             
/*     */             sb.append("[LWJGL] OpenGL debug message\n");
/*     */             
/*     */             printDetail(sb, "ID", "0x" + Integer.toHexString(id).toUpperCase());
/*     */             printDetail(sb, "Source", getDebugSource(source));
/*     */             printDetail(sb, "Type", getDebugType(type));
/*     */             printDetail(sb, "Severity", getDebugSeverity(severity));
/*     */             printDetail(sb, "Message", GLDebugMessageCallback.getMessage(length, message));
/*     */             stream.print(sb);
/*     */           });
/*  55 */       GL43C.glDebugMessageCallback(proc, 0L);
/*  56 */       if ((GL43C.glGetInteger(33310) & 0x2) == 0) {
/*  57 */         APIUtil.apiLog("[GL] Warning: A non-debug context may not produce any debug output.");
/*  58 */         GL43C.glEnable(37600);
/*     */       } 
/*  60 */       return proc;
/*     */     } 
/*     */     
/*  63 */     if (caps.GL_KHR_debug) {
/*  64 */       APIUtil.apiLog("[GL] Using KHR_debug for error logging.");
/*  65 */       GLDebugMessageCallback proc = GLDebugMessageCallback.create((source, type, id, severity, length, message, userParam) -> {
/*     */             StringBuilder sb = new StringBuilder(300);
/*     */             
/*     */             sb.append("[LWJGL] OpenGL debug message\n");
/*     */             
/*     */             printDetail(sb, "ID", "0x" + Integer.toHexString(id).toUpperCase());
/*     */             printDetail(sb, "Source", getDebugSource(source));
/*     */             printDetail(sb, "Type", getDebugType(type));
/*     */             printDetail(sb, "Severity", getDebugSeverity(severity));
/*     */             printDetail(sb, "Message", GLDebugMessageCallback.getMessage(length, message));
/*     */             stream.print(sb);
/*     */           });
/*  77 */       KHRDebug.glDebugMessageCallback(proc, 0L);
/*  78 */       if (caps.OpenGL30 && (GL43C.glGetInteger(33310) & 0x2) == 0) {
/*  79 */         APIUtil.apiLog("[GL] Warning: A non-debug context may not produce any debug output.");
/*  80 */         GL43C.glEnable(37600);
/*     */       } 
/*  82 */       return proc;
/*     */     } 
/*     */     
/*  85 */     if (caps.GL_ARB_debug_output) {
/*  86 */       APIUtil.apiLog("[GL] Using ARB_debug_output for error logging.");
/*  87 */       GLDebugMessageARBCallback proc = GLDebugMessageARBCallback.create((source, type, id, severity, length, message, userParam) -> {
/*     */             StringBuilder sb = new StringBuilder(300);
/*     */             
/*     */             sb.append("[LWJGL] ARB_debug_output message\n");
/*     */             
/*     */             printDetail(sb, "ID", "0x" + Integer.toHexString(id).toUpperCase());
/*     */             printDetail(sb, "Source", getSourceARB(source));
/*     */             printDetail(sb, "Type", getTypeARB(type));
/*     */             printDetail(sb, "Severity", getSeverityARB(severity));
/*     */             printDetail(sb, "Message", GLDebugMessageARBCallback.getMessage(length, message));
/*     */             stream.print(sb);
/*     */           });
/*  99 */       ARBDebugOutput.glDebugMessageCallbackARB(proc, 0L);
/* 100 */       return proc;
/*     */     } 
/*     */     
/* 103 */     if (caps.GL_AMD_debug_output) {
/* 104 */       APIUtil.apiLog("[GL] Using AMD_debug_output for error logging.");
/* 105 */       GLDebugMessageAMDCallback proc = GLDebugMessageAMDCallback.create((id, category, severity, length, message, userParam) -> {
/*     */             StringBuilder sb = new StringBuilder(300);
/*     */             
/*     */             sb.append("[LWJGL] AMD_debug_output message\n");
/*     */             
/*     */             printDetail(sb, "ID", "0x" + Integer.toHexString(id).toUpperCase());
/*     */             printDetail(sb, "Category", getCategoryAMD(category));
/*     */             printDetail(sb, "Severity", getSeverityAMD(severity));
/*     */             printDetail(sb, "Message", GLDebugMessageAMDCallback.getMessage(length, message));
/*     */             stream.print(sb);
/*     */           });
/* 116 */       AMDDebugOutput.glDebugMessageCallbackAMD(proc, 0L);
/* 117 */       return proc;
/*     */     } 
/*     */     
/* 120 */     APIUtil.apiLog("[GL] No debug output implementation is available.");
/* 121 */     return null;
/*     */   }
/*     */   
/*     */   private static void printDetail(StringBuilder sb, String type, String message) {
/* 125 */     sb
/* 126 */       .append("\t")
/* 127 */       .append(type)
/* 128 */       .append(": ")
/* 129 */       .append(message)
/* 130 */       .append("\n");
/*     */   }
/*     */   
/*     */   private static String getDebugSource(int source) {
/* 134 */     switch (source) {
/*     */       case 33350:
/* 136 */         return "API";
/*     */       case 33351:
/* 138 */         return "WINDOW SYSTEM";
/*     */       case 33352:
/* 140 */         return "SHADER COMPILER";
/*     */       case 33353:
/* 142 */         return "THIRD PARTY";
/*     */       case 33354:
/* 144 */         return "APPLICATION";
/*     */       case 33355:
/* 146 */         return "OTHER";
/*     */     } 
/* 148 */     return APIUtil.apiUnknownToken(source);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getDebugType(int type) {
/* 153 */     switch (type) {
/*     */       case 33356:
/* 155 */         return "ERROR";
/*     */       case 33357:
/* 157 */         return "DEPRECATED BEHAVIOR";
/*     */       case 33358:
/* 159 */         return "UNDEFINED BEHAVIOR";
/*     */       case 33359:
/* 161 */         return "PORTABILITY";
/*     */       case 33360:
/* 163 */         return "PERFORMANCE";
/*     */       case 33361:
/* 165 */         return "OTHER";
/*     */       case 33384:
/* 167 */         return "MARKER";
/*     */     } 
/* 169 */     return APIUtil.apiUnknownToken(type);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getDebugSeverity(int severity) {
/* 174 */     switch (severity) {
/*     */       case 37190:
/* 176 */         return "HIGH";
/*     */       case 37191:
/* 178 */         return "MEDIUM";
/*     */       case 37192:
/* 180 */         return "LOW";
/*     */       case 33387:
/* 182 */         return "NOTIFICATION";
/*     */     } 
/* 184 */     return APIUtil.apiUnknownToken(severity);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSourceARB(int source) {
/* 189 */     switch (source) {
/*     */       case 33350:
/* 191 */         return "API";
/*     */       case 33351:
/* 193 */         return "WINDOW SYSTEM";
/*     */       case 33352:
/* 195 */         return "SHADER COMPILER";
/*     */       case 33353:
/* 197 */         return "THIRD PARTY";
/*     */       case 33354:
/* 199 */         return "APPLICATION";
/*     */       case 33355:
/* 201 */         return "OTHER";
/*     */     } 
/* 203 */     return APIUtil.apiUnknownToken(source);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getTypeARB(int type) {
/* 208 */     switch (type) {
/*     */       case 33356:
/* 210 */         return "ERROR";
/*     */       case 33357:
/* 212 */         return "DEPRECATED BEHAVIOR";
/*     */       case 33358:
/* 214 */         return "UNDEFINED BEHAVIOR";
/*     */       case 33359:
/* 216 */         return "PORTABILITY";
/*     */       case 33360:
/* 218 */         return "PERFORMANCE";
/*     */       case 33361:
/* 220 */         return "OTHER";
/*     */     } 
/* 222 */     return APIUtil.apiUnknownToken(type);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSeverityARB(int severity) {
/* 227 */     switch (severity) {
/*     */       case 37190:
/* 229 */         return "HIGH";
/*     */       case 37191:
/* 231 */         return "MEDIUM";
/*     */       case 37192:
/* 233 */         return "LOW";
/*     */     } 
/* 235 */     return APIUtil.apiUnknownToken(severity);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getCategoryAMD(int category) {
/* 240 */     switch (category) {
/*     */       case 37193:
/* 242 */         return "API ERROR";
/*     */       case 37194:
/* 244 */         return "WINDOW SYSTEM";
/*     */       case 37195:
/* 246 */         return "DEPRECATION";
/*     */       case 37196:
/* 248 */         return "UNDEFINED BEHAVIOR";
/*     */       case 37197:
/* 250 */         return "PERFORMANCE";
/*     */       case 37198:
/* 252 */         return "SHADER COMPILER";
/*     */       case 37199:
/* 254 */         return "APPLICATION";
/*     */       case 37200:
/* 256 */         return "OTHER";
/*     */     } 
/* 258 */     return APIUtil.apiUnknownToken(category);
/*     */   }
/*     */ 
/*     */   
/*     */   private static String getSeverityAMD(int severity) {
/* 263 */     switch (severity) {
/*     */       case 37190:
/* 265 */         return "HIGH";
/*     */       case 37191:
/* 267 */         return "MEDIUM";
/*     */       case 37192:
/* 269 */         return "LOW";
/*     */     } 
/* 271 */     return APIUtil.apiUnknownToken(severity);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */