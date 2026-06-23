/*     */ package org.lwjgl.opengl;
/*     */ 
/*     */ import java.util.Set;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProvider;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GLXCapabilities
/*     */ {
/*     */   public final long glXQueryExtensionsString;
/*     */   public final long glXGetClientString;
/*     */   public final long glXQueryServerString;
/*     */   public final long glXGetCurrentDisplay;
/*     */   public final long glXGetFBConfigs;
/*     */   public final long glXChooseFBConfig;
/*     */   public final long glXGetFBConfigAttrib;
/*     */   public final long glXGetVisualFromFBConfig;
/*     */   public final long glXCreateWindow;
/*     */   public final long glXCreatePixmap;
/*     */   public final long glXDestroyPixmap;
/*     */   public final long glXCreatePbuffer;
/*     */   public final long glXDestroyPbuffer;
/*     */   public final long glXQueryDrawable;
/*     */   public final long glXCreateNewContext;
/*     */   public final long glXMakeContextCurrent;
/*     */   public final long glXGetCurrentReadDrawable;
/*     */   public final long glXQueryContext;
/*     */   public final long glXSelectEvent;
/*     */   public final long glXGetSelectedEvent;
/*     */   public final long glXGetProcAddress;
/*     */   public final long glXBlitContextFramebufferAMD;
/*     */   public final long glXCreateAssociatedContextAMD;
/*     */   public final long glXCreateAssociatedContextAttribsAMD;
/*     */   public final long glXDeleteAssociatedContextAMD;
/*     */   public final long glXGetContextGPUIDAMD;
/*     */   public final long glXGetCurrentAssociatedContextAMD;
/*     */   public final long glXGetGPUIDsAMD;
/*     */   public final long glXGetGPUInfoAMD;
/*     */   public final long glXMakeAssociatedContextCurrentAMD;
/*     */   public final long glXCreateContextAttribsARB;
/*     */   public final long glXGetProcAddressARB;
/*     */   public final long glXGetCurrentDisplayEXT;
/*     */   public final long glXQueryContextInfoEXT;
/*     */   public final long glXGetContextIDEXT;
/*     */   public final long glXImportContextEXT;
/*     */   public final long glXFreeContextEXT;
/*     */   public final long glXSwapIntervalEXT;
/*     */   public final long glXBindTexImageEXT;
/*     */   public final long glXReleaseTexImageEXT;
/*     */   public final long glXCopyBufferSubDataNV;
/*     */   public final long glXNamedCopyBufferSubDataNV;
/*     */   public final long glXCopyImageSubDataNV;
/*     */   public final long glXDelayBeforeSwapNV;
/*     */   public final long glXJoinSwapGroupNV;
/*     */   public final long glXBindSwapBarrierNV;
/*     */   public final long glXQuerySwapGroupNV;
/*     */   public final long glXQueryMaxSwapGroupsNV;
/*     */   public final long glXQueryFrameCountNV;
/*     */   public final long glXResetFrameCountNV;
/*     */   public final long glXMakeCurrentReadSGI;
/*     */   public final long glXGetCurrentReadDrawableSGI;
/*     */   public final long glXSwapIntervalSGI;
/*     */   public final long glXGetVideoSyncSGI;
/*     */   public final long glXWaitVideoSyncSGI;
/*     */   public final long glXGetFBConfigAttribSGIX;
/*     */   public final long glXChooseFBConfigSGIX;
/*     */   public final long glXCreateGLXPixmapWithConfigSGIX;
/*     */   public final long glXCreateContextWithConfigSGIX;
/*     */   public final long glXGetVisualFromFBConfigSGIX;
/*     */   public final long glXGetFBConfigFromVisualSGIX;
/*     */   public final long glXCreateGLXPbufferSGIX;
/*     */   public final long glXDestroyGLXPbufferSGIX;
/*     */   public final long glXQueryGLXPbufferSGIX;
/*     */   public final long glXSelectEventSGIX;
/*     */   public final long glXGetSelectedEventSGIX;
/*     */   public final long glXBindSwapBarrierSGIX;
/*     */   public final long glXQueryMaxSwapBarriersSGIX;
/*     */   public final long glXJoinSwapGroupSGIX;
/*     */   public final boolean GLX11;
/*     */   public final boolean GLX12;
/*     */   public final boolean GLX13;
/*     */   public final boolean GLX14;
/*     */   public final boolean GLX_AMD_gpu_association;
/*     */   public final boolean GLX_ARB_context_flush_control;
/*     */   public final boolean GLX_ARB_create_context;
/*     */   public final boolean GLX_ARB_create_context_no_error;
/*     */   public final boolean GLX_ARB_create_context_profile;
/*     */   public final boolean GLX_ARB_create_context_robustness;
/*     */   public final boolean GLX_ARB_fbconfig_float;
/*     */   public final boolean GLX_ARB_framebuffer_sRGB;
/*     */   public final boolean GLX_ARB_get_proc_address;
/*     */   public final boolean GLX_ARB_multisample;
/*     */   public final boolean GLX_ARB_robustness_application_isolation;
/*     */   public final boolean GLX_ARB_robustness_share_group_isolation;
/*     */   public final boolean GLX_ARB_vertex_buffer_object;
/*     */   public final boolean GLX_EXT_buffer_age;
/*     */   public final boolean GLX_EXT_context_priority;
/*     */   public final boolean GLX_EXT_create_context_es2_profile;
/*     */   public final boolean GLX_EXT_create_context_es_profile;
/*     */   public final boolean GLX_EXT_fbconfig_packed_float;
/*     */   public final boolean GLX_EXT_framebuffer_sRGB;
/*     */   public final boolean GLX_EXT_get_drawable_type;
/*     */   public final boolean GLX_EXT_import_context;
/*     */   public final boolean GLX_EXT_no_config_context;
/*     */   public final boolean GLX_EXT_stereo_tree;
/*     */   public final boolean GLX_EXT_swap_control;
/*     */   public final boolean GLX_EXT_swap_control_tear;
/*     */   public final boolean GLX_EXT_texture_from_pixmap;
/*     */   public final boolean GLX_EXT_visual_info;
/*     */   public final boolean GLX_EXT_visual_rating;
/*     */   public final boolean GLX_INTEL_swap_event;
/*     */   public final boolean GLX_NV_copy_buffer;
/*     */   public final boolean GLX_NV_copy_image;
/*     */   public final boolean GLX_NV_delay_before_swap;
/*     */   public final boolean GLX_NV_float_buffer;
/*     */   public final boolean GLX_NV_multigpu_context;
/*     */   public final boolean GLX_NV_multisample_coverage;
/*     */   public final boolean GLX_NV_robustness_video_memory_purge;
/*     */   public final boolean GLX_NV_swap_group;
/*     */   public final boolean GLX_SGI_make_current_read;
/*     */   public final boolean GLX_SGI_swap_control;
/*     */   public final boolean GLX_SGI_video_sync;
/*     */   public final boolean GLX_SGIX_fbconfig;
/*     */   public final boolean GLX_SGIX_pbuffer;
/*     */   public final boolean GLX_SGIX_swap_barrier;
/*     */   public final boolean GLX_SGIX_swap_group;
/*     */   
/*     */   GLXCapabilities(FunctionProvider provider, Set<String> ext) {
/* 246 */     long[] caps = new long[69];
/*     */     
/* 248 */     this.GLX11 = check_GLX11(provider, caps, ext);
/* 249 */     this.GLX12 = check_GLX12(provider, caps, ext);
/* 250 */     this.GLX13 = check_GLX13(provider, caps, ext);
/* 251 */     this.GLX14 = check_GLX14(provider, caps, ext);
/* 252 */     this.GLX_AMD_gpu_association = check_GLX_AMD_gpu_association(provider, caps, ext);
/* 253 */     this.GLX_ARB_context_flush_control = ext.contains("GLX_ARB_context_flush_control");
/* 254 */     this.GLX_ARB_create_context = check_GLX_ARB_create_context(provider, caps, ext);
/* 255 */     this.GLX_ARB_create_context_no_error = ext.contains("GLX_ARB_create_context_no_error");
/* 256 */     this.GLX_ARB_create_context_profile = ext.contains("GLX_ARB_create_context_profile");
/* 257 */     this.GLX_ARB_create_context_robustness = ext.contains("GLX_ARB_create_context_robustness");
/* 258 */     this.GLX_ARB_fbconfig_float = ext.contains("GLX_ARB_fbconfig_float");
/* 259 */     this.GLX_ARB_framebuffer_sRGB = ext.contains("GLX_ARB_framebuffer_sRGB");
/* 260 */     this.GLX_ARB_get_proc_address = check_GLX_ARB_get_proc_address(provider, caps, ext);
/* 261 */     this.GLX_ARB_multisample = ext.contains("GLX_ARB_multisample");
/* 262 */     this.GLX_ARB_robustness_application_isolation = ext.contains("GLX_ARB_robustness_application_isolation");
/* 263 */     this.GLX_ARB_robustness_share_group_isolation = ext.contains("GLX_ARB_robustness_share_group_isolation");
/* 264 */     this.GLX_ARB_vertex_buffer_object = ext.contains("GLX_ARB_vertex_buffer_object");
/* 265 */     this.GLX_EXT_buffer_age = ext.contains("GLX_EXT_buffer_age");
/* 266 */     this.GLX_EXT_context_priority = ext.contains("GLX_EXT_context_priority");
/* 267 */     this.GLX_EXT_create_context_es2_profile = ext.contains("GLX_EXT_create_context_es2_profile");
/* 268 */     this.GLX_EXT_create_context_es_profile = ext.contains("GLX_EXT_create_context_es_profile");
/* 269 */     this.GLX_EXT_fbconfig_packed_float = ext.contains("GLX_EXT_fbconfig_packed_float");
/* 270 */     this.GLX_EXT_framebuffer_sRGB = ext.contains("GLX_EXT_framebuffer_sRGB");
/* 271 */     this.GLX_EXT_get_drawable_type = ext.contains("GLX_EXT_get_drawable_type");
/* 272 */     this.GLX_EXT_import_context = check_GLX_EXT_import_context(provider, caps, ext);
/* 273 */     this.GLX_EXT_no_config_context = ext.contains("GLX_EXT_no_config_context");
/* 274 */     this.GLX_EXT_stereo_tree = ext.contains("GLX_EXT_stereo_tree");
/* 275 */     this.GLX_EXT_swap_control = check_GLX_EXT_swap_control(provider, caps, ext);
/* 276 */     this.GLX_EXT_swap_control_tear = ext.contains("GLX_EXT_swap_control_tear");
/* 277 */     this.GLX_EXT_texture_from_pixmap = check_GLX_EXT_texture_from_pixmap(provider, caps, ext);
/* 278 */     this.GLX_EXT_visual_info = ext.contains("GLX_EXT_visual_info");
/* 279 */     this.GLX_EXT_visual_rating = ext.contains("GLX_EXT_visual_rating");
/* 280 */     this.GLX_INTEL_swap_event = ext.contains("GLX_INTEL_swap_event");
/* 281 */     this.GLX_NV_copy_buffer = check_GLX_NV_copy_buffer(provider, caps, ext);
/* 282 */     this.GLX_NV_copy_image = check_GLX_NV_copy_image(provider, caps, ext);
/* 283 */     this.GLX_NV_delay_before_swap = check_GLX_NV_delay_before_swap(provider, caps, ext);
/* 284 */     this.GLX_NV_float_buffer = ext.contains("GLX_NV_float_buffer");
/* 285 */     this.GLX_NV_multigpu_context = ext.contains("GLX_NV_multigpu_context");
/* 286 */     this.GLX_NV_multisample_coverage = ext.contains("GLX_NV_multisample_coverage");
/* 287 */     this.GLX_NV_robustness_video_memory_purge = ext.contains("GLX_NV_robustness_video_memory_purge");
/* 288 */     this.GLX_NV_swap_group = check_GLX_NV_swap_group(provider, caps, ext);
/* 289 */     this.GLX_SGI_make_current_read = check_GLX_SGI_make_current_read(provider, caps, ext);
/* 290 */     this.GLX_SGI_swap_control = check_GLX_SGI_swap_control(provider, caps, ext);
/* 291 */     this.GLX_SGI_video_sync = check_GLX_SGI_video_sync(provider, caps, ext);
/* 292 */     this.GLX_SGIX_fbconfig = check_GLX_SGIX_fbconfig(provider, caps, ext);
/* 293 */     this.GLX_SGIX_pbuffer = check_GLX_SGIX_pbuffer(provider, caps, ext);
/* 294 */     this.GLX_SGIX_swap_barrier = check_GLX_SGIX_swap_barrier(provider, caps, ext);
/* 295 */     this.GLX_SGIX_swap_group = check_GLX_SGIX_swap_group(provider, caps, ext);
/*     */     
/* 297 */     this.glXQueryExtensionsString = caps[0];
/* 298 */     this.glXGetClientString = caps[1];
/* 299 */     this.glXQueryServerString = caps[2];
/* 300 */     this.glXGetCurrentDisplay = caps[3];
/* 301 */     this.glXGetFBConfigs = caps[4];
/* 302 */     this.glXChooseFBConfig = caps[5];
/* 303 */     this.glXGetFBConfigAttrib = caps[6];
/* 304 */     this.glXGetVisualFromFBConfig = caps[7];
/* 305 */     this.glXCreateWindow = caps[8];
/* 306 */     this.glXCreatePixmap = caps[9];
/* 307 */     this.glXDestroyPixmap = caps[10];
/* 308 */     this.glXCreatePbuffer = caps[11];
/* 309 */     this.glXDestroyPbuffer = caps[12];
/* 310 */     this.glXQueryDrawable = caps[13];
/* 311 */     this.glXCreateNewContext = caps[14];
/* 312 */     this.glXMakeContextCurrent = caps[15];
/* 313 */     this.glXGetCurrentReadDrawable = caps[16];
/* 314 */     this.glXQueryContext = caps[17];
/* 315 */     this.glXSelectEvent = caps[18];
/* 316 */     this.glXGetSelectedEvent = caps[19];
/* 317 */     this.glXGetProcAddress = caps[20];
/* 318 */     this.glXBlitContextFramebufferAMD = caps[21];
/* 319 */     this.glXCreateAssociatedContextAMD = caps[22];
/* 320 */     this.glXCreateAssociatedContextAttribsAMD = caps[23];
/* 321 */     this.glXDeleteAssociatedContextAMD = caps[24];
/* 322 */     this.glXGetContextGPUIDAMD = caps[25];
/* 323 */     this.glXGetCurrentAssociatedContextAMD = caps[26];
/* 324 */     this.glXGetGPUIDsAMD = caps[27];
/* 325 */     this.glXGetGPUInfoAMD = caps[28];
/* 326 */     this.glXMakeAssociatedContextCurrentAMD = caps[29];
/* 327 */     this.glXCreateContextAttribsARB = caps[30];
/* 328 */     this.glXGetProcAddressARB = caps[31];
/* 329 */     this.glXGetCurrentDisplayEXT = caps[32];
/* 330 */     this.glXQueryContextInfoEXT = caps[33];
/* 331 */     this.glXGetContextIDEXT = caps[34];
/* 332 */     this.glXImportContextEXT = caps[35];
/* 333 */     this.glXFreeContextEXT = caps[36];
/* 334 */     this.glXSwapIntervalEXT = caps[37];
/* 335 */     this.glXBindTexImageEXT = caps[38];
/* 336 */     this.glXReleaseTexImageEXT = caps[39];
/* 337 */     this.glXCopyBufferSubDataNV = caps[40];
/* 338 */     this.glXNamedCopyBufferSubDataNV = caps[41];
/* 339 */     this.glXCopyImageSubDataNV = caps[42];
/* 340 */     this.glXDelayBeforeSwapNV = caps[43];
/* 341 */     this.glXJoinSwapGroupNV = caps[44];
/* 342 */     this.glXBindSwapBarrierNV = caps[45];
/* 343 */     this.glXQuerySwapGroupNV = caps[46];
/* 344 */     this.glXQueryMaxSwapGroupsNV = caps[47];
/* 345 */     this.glXQueryFrameCountNV = caps[48];
/* 346 */     this.glXResetFrameCountNV = caps[49];
/* 347 */     this.glXMakeCurrentReadSGI = caps[50];
/* 348 */     this.glXGetCurrentReadDrawableSGI = caps[51];
/* 349 */     this.glXSwapIntervalSGI = caps[52];
/* 350 */     this.glXGetVideoSyncSGI = caps[53];
/* 351 */     this.glXWaitVideoSyncSGI = caps[54];
/* 352 */     this.glXGetFBConfigAttribSGIX = caps[55];
/* 353 */     this.glXChooseFBConfigSGIX = caps[56];
/* 354 */     this.glXCreateGLXPixmapWithConfigSGIX = caps[57];
/* 355 */     this.glXCreateContextWithConfigSGIX = caps[58];
/* 356 */     this.glXGetVisualFromFBConfigSGIX = caps[59];
/* 357 */     this.glXGetFBConfigFromVisualSGIX = caps[60];
/* 358 */     this.glXCreateGLXPbufferSGIX = caps[61];
/* 359 */     this.glXDestroyGLXPbufferSGIX = caps[62];
/* 360 */     this.glXQueryGLXPbufferSGIX = caps[63];
/* 361 */     this.glXSelectEventSGIX = caps[64];
/* 362 */     this.glXGetSelectedEventSGIX = caps[65];
/* 363 */     this.glXBindSwapBarrierSGIX = caps[66];
/* 364 */     this.glXQueryMaxSwapBarriersSGIX = caps[67];
/* 365 */     this.glXJoinSwapGroupSGIX = caps[68];
/*     */   }
/*     */   
/*     */   private static boolean check_GLX11(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 369 */     if (!ext.contains("GLX11")) {
/* 370 */       return false;
/*     */     }
/*     */     
/* 373 */     return (Checks.checkFunctions(provider, caps, new int[] { 0, 1, 2 }, new String[] { "glXQueryExtensionsString", "glXGetClientString", "glXQueryServerString"
/*     */ 
/*     */ 
/*     */         
/* 377 */         }) || Checks.reportMissing("GLX", "GLX11"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX12(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 381 */     if (!ext.contains("GLX12")) {
/* 382 */       return false;
/*     */     }
/*     */     
/* 385 */     return (Checks.checkFunctions(provider, caps, new int[] { 3 }, new String[] { "glXGetCurrentDisplay"
/*     */ 
/*     */ 
/*     */         
/* 389 */         }) || Checks.reportMissing("GLX", "GLX12"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX13(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 393 */     if (!ext.contains("GLX13")) {
/* 394 */       return false;
/*     */     }
/*     */     
/* 397 */     return (Checks.checkFunctions(provider, caps, new int[] { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 }, new String[] { "glXGetFBConfigs", "glXChooseFBConfig", "glXGetFBConfigAttrib", "glXGetVisualFromFBConfig", "glXCreateWindow", "glXCreatePixmap", "glXDestroyPixmap", "glXCreatePbuffer", "glXDestroyPbuffer", "glXQueryDrawable", "glXCreateNewContext", "glXMakeContextCurrent", "glXGetCurrentReadDrawable", "glXQueryContext", "glXSelectEvent", "glXGetSelectedEvent"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 403 */         }) || Checks.reportMissing("GLX", "GLX13"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX14(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 407 */     if (!ext.contains("GLX14")) {
/* 408 */       return false;
/*     */     }
/*     */     
/* 411 */     return (Checks.checkFunctions(provider, caps, new int[] { 20 }, new String[] { "glXGetProcAddress"
/*     */ 
/*     */ 
/*     */         
/* 415 */         }) || Checks.reportMissing("GLX", "GLX14"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_AMD_gpu_association(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 419 */     if (!ext.contains("GLX_AMD_gpu_association")) {
/* 420 */       return false;
/*     */     }
/*     */     
/* 423 */     return (Checks.checkFunctions(provider, caps, new int[] { 21, 22, 23, 24, 25, 26, 27, 28, 29 }, new String[] { "glXBlitContextFramebufferAMD", "glXCreateAssociatedContextAMD", "glXCreateAssociatedContextAttribsAMD", "glXDeleteAssociatedContextAMD", "glXGetContextGPUIDAMD", "glXGetCurrentAssociatedContextAMD", "glXGetGPUIDsAMD", "glXGetGPUInfoAMD", "glXMakeAssociatedContextCurrentAMD"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 428 */         }) || Checks.reportMissing("GLX", "GLX_AMD_gpu_association"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_ARB_create_context(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 432 */     if (!ext.contains("GLX_ARB_create_context")) {
/* 433 */       return false;
/*     */     }
/*     */     
/* 436 */     return (Checks.checkFunctions(provider, caps, new int[] { 30 }, new String[] { "glXCreateContextAttribsARB"
/*     */ 
/*     */ 
/*     */         
/* 440 */         }) || Checks.reportMissing("GLX", "GLX_ARB_create_context"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_ARB_get_proc_address(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 444 */     if (!ext.contains("GLX_ARB_get_proc_address")) {
/* 445 */       return false;
/*     */     }
/*     */     
/* 448 */     return (Checks.checkFunctions(provider, caps, new int[] { 31 }, new String[] { "glXGetProcAddressARB"
/*     */ 
/*     */ 
/*     */         
/* 452 */         }) || Checks.reportMissing("GLX", "GLX_ARB_get_proc_address"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_EXT_import_context(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 456 */     if (!ext.contains("GLX_EXT_import_context")) {
/* 457 */       return false;
/*     */     }
/*     */     
/* 460 */     return (Checks.checkFunctions(provider, caps, new int[] { 32, 33, 34, 35, 36 }, new String[] { "glXGetCurrentDisplayEXT", "glXQueryContextInfoEXT", "glXGetContextIDEXT", "glXImportContextEXT", "glXFreeContextEXT"
/*     */ 
/*     */ 
/*     */         
/* 464 */         }) || Checks.reportMissing("GLX", "GLX_EXT_import_context"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_EXT_swap_control(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 468 */     if (!ext.contains("GLX_EXT_swap_control")) {
/* 469 */       return false;
/*     */     }
/*     */     
/* 472 */     return (Checks.checkFunctions(provider, caps, new int[] { 37 }, new String[] { "glXSwapIntervalEXT"
/*     */ 
/*     */ 
/*     */         
/* 476 */         }) || Checks.reportMissing("GLX", "GLX_EXT_swap_control"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_EXT_texture_from_pixmap(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 480 */     if (!ext.contains("GLX_EXT_texture_from_pixmap")) {
/* 481 */       return false;
/*     */     }
/*     */     
/* 484 */     return (Checks.checkFunctions(provider, caps, new int[] { 38, 39 }, new String[] { "glXBindTexImageEXT", "glXReleaseTexImageEXT"
/*     */ 
/*     */ 
/*     */         
/* 488 */         }) || Checks.reportMissing("GLX", "GLX_EXT_texture_from_pixmap"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_NV_copy_buffer(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 492 */     if (!ext.contains("GLX_NV_copy_buffer")) {
/* 493 */       return false;
/*     */     }
/*     */     
/* 496 */     return (Checks.checkFunctions(provider, caps, new int[] { 40, 41 }, new String[] { "glXCopyBufferSubDataNV", "glXNamedCopyBufferSubDataNV"
/*     */ 
/*     */ 
/*     */         
/* 500 */         }) || Checks.reportMissing("GLX", "GLX_NV_copy_buffer"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_NV_copy_image(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 504 */     if (!ext.contains("GLX_NV_copy_image")) {
/* 505 */       return false;
/*     */     }
/*     */     
/* 508 */     return (Checks.checkFunctions(provider, caps, new int[] { 42 }, new String[] { "glXCopyImageSubDataNV"
/*     */ 
/*     */ 
/*     */         
/* 512 */         }) || Checks.reportMissing("GLX", "GLX_NV_copy_image"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_NV_delay_before_swap(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 516 */     if (!ext.contains("GLX_NV_delay_before_swap")) {
/* 517 */       return false;
/*     */     }
/*     */     
/* 520 */     return (Checks.checkFunctions(provider, caps, new int[] { 43 }, new String[] { "glXDelayBeforeSwapNV"
/*     */ 
/*     */ 
/*     */         
/* 524 */         }) || Checks.reportMissing("GLX", "GLX_NV_delay_before_swap"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_NV_swap_group(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 528 */     if (!ext.contains("GLX_NV_swap_group")) {
/* 529 */       return false;
/*     */     }
/*     */     
/* 532 */     return (Checks.checkFunctions(provider, caps, new int[] { 44, 45, 46, 47, 48, 49 }, new String[] { "glXJoinSwapGroupNV", "glXBindSwapBarrierNV", "glXQuerySwapGroupNV", "glXQueryMaxSwapGroupsNV", "glXQueryFrameCountNV", "glXResetFrameCountNV"
/*     */ 
/*     */ 
/*     */         
/* 536 */         }) || Checks.reportMissing("GLX", "GLX_NV_swap_group"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_SGI_make_current_read(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 540 */     if (!ext.contains("GLX_SGI_make_current_read")) {
/* 541 */       return false;
/*     */     }
/*     */     
/* 544 */     return (Checks.checkFunctions(provider, caps, new int[] { 50, 51 }, new String[] { "glXMakeCurrentReadSGI", "glXGetCurrentReadDrawableSGI"
/*     */ 
/*     */ 
/*     */         
/* 548 */         }) || Checks.reportMissing("GLX", "GLX_SGI_make_current_read"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_SGI_swap_control(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 552 */     if (!ext.contains("GLX_SGI_swap_control")) {
/* 553 */       return false;
/*     */     }
/*     */     
/* 556 */     return (Checks.checkFunctions(provider, caps, new int[] { 52 }, new String[] { "glXSwapIntervalSGI"
/*     */ 
/*     */ 
/*     */         
/* 560 */         }) || Checks.reportMissing("GLX", "GLX_SGI_swap_control"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_SGI_video_sync(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 564 */     if (!ext.contains("GLX_SGI_video_sync")) {
/* 565 */       return false;
/*     */     }
/*     */     
/* 568 */     return (Checks.checkFunctions(provider, caps, new int[] { 53, 54 }, new String[] { "glXGetVideoSyncSGI", "glXWaitVideoSyncSGI"
/*     */ 
/*     */ 
/*     */         
/* 572 */         }) || Checks.reportMissing("GLX", "GLX_SGI_video_sync"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_SGIX_fbconfig(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 576 */     if (!ext.contains("GLX_SGIX_fbconfig")) {
/* 577 */       return false;
/*     */     }
/*     */     
/* 580 */     return (Checks.checkFunctions(provider, caps, new int[] { 55, 56, 57, 58, 59, 60 }, new String[] { "glXGetFBConfigAttribSGIX", "glXChooseFBConfigSGIX", "glXCreateGLXPixmapWithConfigSGIX", "glXCreateContextWithConfigSGIX", "glXGetVisualFromFBConfigSGIX", "glXGetFBConfigFromVisualSGIX"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 585 */         }) || Checks.reportMissing("GLX", "GLX_SGIX_fbconfig"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_SGIX_pbuffer(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 589 */     if (!ext.contains("GLX_SGIX_pbuffer")) {
/* 590 */       return false;
/*     */     }
/*     */     
/* 593 */     return (Checks.checkFunctions(provider, caps, new int[] { 61, 62, 63, 64, 65 }, new String[] { "glXCreateGLXPbufferSGIX", "glXDestroyGLXPbufferSGIX", "glXQueryGLXPbufferSGIX", "glXSelectEventSGIX", "glXGetSelectedEventSGIX"
/*     */ 
/*     */ 
/*     */         
/* 597 */         }) || Checks.reportMissing("GLX", "GLX_SGIX_pbuffer"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_SGIX_swap_barrier(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 601 */     if (!ext.contains("GLX_SGIX_swap_barrier")) {
/* 602 */       return false;
/*     */     }
/*     */     
/* 605 */     return (Checks.checkFunctions(provider, caps, new int[] { 66, 67 }, new String[] { "glXBindSwapBarrierSGIX", "glXQueryMaxSwapBarriersSGIX"
/*     */ 
/*     */ 
/*     */         
/* 609 */         }) || Checks.reportMissing("GLX", "GLX_SGIX_swap_barrier"));
/*     */   }
/*     */   
/*     */   private static boolean check_GLX_SGIX_swap_group(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 613 */     if (!ext.contains("GLX_SGIX_swap_group")) {
/* 614 */       return false;
/*     */     }
/*     */     
/* 617 */     return (Checks.checkFunctions(provider, caps, new int[] { 68 }, new String[] { "glXJoinSwapGroupSGIX"
/*     */ 
/*     */ 
/*     */         
/* 621 */         }) || Checks.reportMissing("GLX", "GLX_SGIX_swap_group"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\GLXCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */