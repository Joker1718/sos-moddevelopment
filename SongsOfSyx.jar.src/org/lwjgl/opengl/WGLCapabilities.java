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
/*     */ public final class WGLCapabilities
/*     */ {
/*     */   public final long wglGetGPUIDsAMD;
/*     */   public final long wglGetGPUInfoAMD;
/*     */   public final long wglGetContextGPUIDAMD;
/*     */   public final long wglCreateAssociatedContextAMD;
/*     */   public final long wglCreateAssociatedContextAttribsAMD;
/*     */   public final long wglDeleteAssociatedContextAMD;
/*     */   public final long wglMakeAssociatedContextCurrentAMD;
/*     */   public final long wglGetCurrentAssociatedContextAMD;
/*     */   public final long wglBlitContextFramebufferAMD;
/*     */   public final long wglCreateBufferRegionARB;
/*     */   public final long wglDeleteBufferRegionARB;
/*     */   public final long wglSaveBufferRegionARB;
/*     */   public final long wglRestoreBufferRegionARB;
/*     */   public final long wglCreateContextAttribsARB;
/*     */   public final long wglGetExtensionsStringARB;
/*     */   public final long wglMakeContextCurrentARB;
/*     */   public final long wglGetCurrentReadDCARB;
/*     */   public final long wglCreatePbufferARB;
/*     */   public final long wglGetPbufferDCARB;
/*     */   public final long wglReleasePbufferDCARB;
/*     */   public final long wglDestroyPbufferARB;
/*     */   public final long wglQueryPbufferARB;
/*     */   public final long wglGetPixelFormatAttribivARB;
/*     */   public final long wglGetPixelFormatAttribfvARB;
/*     */   public final long wglChoosePixelFormatARB;
/*     */   public final long wglBindTexImageARB;
/*     */   public final long wglReleaseTexImageARB;
/*     */   public final long wglSetPbufferAttribARB;
/*     */   public final long wglGetExtensionsStringEXT;
/*     */   public final long wglSwapIntervalEXT;
/*     */   public final long wglGetSwapIntervalEXT;
/*     */   public final long wglCopyImageSubDataNV;
/*     */   public final long wglDelayBeforeSwapNV;
/*     */   public final long wglDXSetResourceShareHandleNV;
/*     */   public final long wglDXOpenDeviceNV;
/*     */   public final long wglDXCloseDeviceNV;
/*     */   public final long wglDXRegisterObjectNV;
/*     */   public final long wglDXUnregisterObjectNV;
/*     */   public final long wglDXObjectAccessNV;
/*     */   public final long wglDXLockObjectsNV;
/*     */   public final long wglDXUnlockObjectsNV;
/*     */   public final long wglEnumGpusNV;
/*     */   public final long wglEnumGpuDevicesNV;
/*     */   public final long wglCreateAffinityDCNV;
/*     */   public final long wglEnumGpusFromAffinityDCNV;
/*     */   public final long wglDeleteDCNV;
/*     */   public final long wglJoinSwapGroupNV;
/*     */   public final long wglBindSwapBarrierNV;
/*     */   public final long wglQuerySwapGroupNV;
/*     */   public final long wglQueryMaxSwapGroupsNV;
/*     */   public final long wglQueryFrameCountNV;
/*     */   public final long wglResetFrameCountNV;
/*     */   public final long wglAllocateMemoryNV;
/*     */   public final long wglFreeMemoryNV;
/*     */   public final boolean WGL_AMD_gpu_association;
/*     */   public final boolean WGL_ARB_buffer_region;
/*     */   public final boolean WGL_ARB_context_flush_control;
/*     */   public final boolean WGL_ARB_create_context;
/*     */   public final boolean WGL_ARB_create_context_no_error;
/*     */   public final boolean WGL_ARB_create_context_profile;
/*     */   public final boolean WGL_ARB_create_context_robustness;
/*     */   public final boolean WGL_ARB_extensions_string;
/*     */   public final boolean WGL_ARB_framebuffer_sRGB;
/*     */   public final boolean WGL_ARB_make_current_read;
/*     */   public final boolean WGL_ARB_multisample;
/*     */   public final boolean WGL_ARB_pbuffer;
/*     */   public final boolean WGL_ARB_pixel_format;
/*     */   public final boolean WGL_ARB_pixel_format_float;
/*     */   public final boolean WGL_ARB_render_texture;
/*     */   public final boolean WGL_ARB_robustness_application_isolation;
/*     */   public final boolean WGL_ARB_robustness_share_group_isolation;
/*     */   public final boolean WGL_ATI_pixel_format_float;
/*     */   public final boolean WGL_ATI_render_texture_rectangle;
/*     */   public final boolean WGL_EXT_colorspace;
/*     */   public final boolean WGL_EXT_create_context_es2_profile;
/*     */   public final boolean WGL_EXT_create_context_es_profile;
/*     */   public final boolean WGL_EXT_depth_float;
/*     */   public final boolean WGL_EXT_extensions_string;
/*     */   public final boolean WGL_EXT_framebuffer_sRGB;
/*     */   public final boolean WGL_EXT_pixel_format_packed_float;
/*     */   public final boolean WGL_EXT_swap_control;
/*     */   public final boolean WGL_EXT_swap_control_tear;
/*     */   public final boolean WGL_NV_copy_image;
/*     */   public final boolean WGL_NV_delay_before_swap;
/*     */   public final boolean WGL_NV_DX_interop;
/*     */   public final boolean WGL_NV_DX_interop2;
/*     */   public final boolean WGL_NV_float_buffer;
/*     */   public final boolean WGL_NV_gpu_affinity;
/*     */   public final boolean WGL_NV_multigpu_context;
/*     */   public final boolean WGL_NV_multisample_coverage;
/*     */   public final boolean WGL_NV_render_depth_texture;
/*     */   public final boolean WGL_NV_render_texture_rectangle;
/*     */   public final boolean WGL_NV_swap_group;
/*     */   public final boolean WGL_NV_vertex_array_range;
/*     */   
/*     */   WGLCapabilities(FunctionProvider provider, Set<String> ext) {
/* 200 */     long[] caps = new long[54];
/*     */     
/* 202 */     this.WGL_AMD_gpu_association = check_WGL_AMD_gpu_association(provider, caps, ext);
/* 203 */     this.WGL_ARB_buffer_region = check_WGL_ARB_buffer_region(provider, caps, ext);
/* 204 */     this.WGL_ARB_context_flush_control = ext.contains("WGL_ARB_context_flush_control");
/* 205 */     this.WGL_ARB_create_context = check_WGL_ARB_create_context(provider, caps, ext);
/* 206 */     this.WGL_ARB_create_context_no_error = ext.contains("WGL_ARB_create_context_no_error");
/* 207 */     this.WGL_ARB_create_context_profile = ext.contains("WGL_ARB_create_context_profile");
/* 208 */     this.WGL_ARB_create_context_robustness = ext.contains("WGL_ARB_create_context_robustness");
/* 209 */     this.WGL_ARB_extensions_string = check_WGL_ARB_extensions_string(provider, caps, ext);
/* 210 */     this.WGL_ARB_framebuffer_sRGB = ext.contains("WGL_ARB_framebuffer_sRGB");
/* 211 */     this.WGL_ARB_make_current_read = check_WGL_ARB_make_current_read(provider, caps, ext);
/* 212 */     this.WGL_ARB_multisample = ext.contains("WGL_ARB_multisample");
/* 213 */     this.WGL_ARB_pbuffer = check_WGL_ARB_pbuffer(provider, caps, ext);
/* 214 */     this.WGL_ARB_pixel_format = check_WGL_ARB_pixel_format(provider, caps, ext);
/* 215 */     this.WGL_ARB_pixel_format_float = ext.contains("WGL_ARB_pixel_format_float");
/* 216 */     this.WGL_ARB_render_texture = check_WGL_ARB_render_texture(provider, caps, ext);
/* 217 */     this.WGL_ARB_robustness_application_isolation = ext.contains("WGL_ARB_robustness_application_isolation");
/* 218 */     this.WGL_ARB_robustness_share_group_isolation = ext.contains("WGL_ARB_robustness_share_group_isolation");
/* 219 */     this.WGL_ATI_pixel_format_float = ext.contains("WGL_ATI_pixel_format_float");
/* 220 */     this.WGL_ATI_render_texture_rectangle = ext.contains("WGL_ATI_render_texture_rectangle");
/* 221 */     this.WGL_EXT_colorspace = ext.contains("WGL_EXT_colorspace");
/* 222 */     this.WGL_EXT_create_context_es2_profile = ext.contains("WGL_EXT_create_context_es2_profile");
/* 223 */     this.WGL_EXT_create_context_es_profile = ext.contains("WGL_EXT_create_context_es_profile");
/* 224 */     this.WGL_EXT_depth_float = ext.contains("WGL_EXT_depth_float");
/* 225 */     this.WGL_EXT_extensions_string = check_WGL_EXT_extensions_string(provider, caps, ext);
/* 226 */     this.WGL_EXT_framebuffer_sRGB = ext.contains("WGL_EXT_framebuffer_sRGB");
/* 227 */     this.WGL_EXT_pixel_format_packed_float = ext.contains("WGL_EXT_pixel_format_packed_float");
/* 228 */     this.WGL_EXT_swap_control = check_WGL_EXT_swap_control(provider, caps, ext);
/* 229 */     this.WGL_EXT_swap_control_tear = ext.contains("WGL_EXT_swap_control_tear");
/* 230 */     this.WGL_NV_copy_image = check_WGL_NV_copy_image(provider, caps, ext);
/* 231 */     this.WGL_NV_delay_before_swap = check_WGL_NV_delay_before_swap(provider, caps, ext);
/* 232 */     this.WGL_NV_DX_interop = check_WGL_NV_DX_interop(provider, caps, ext);
/* 233 */     this.WGL_NV_DX_interop2 = ext.contains("WGL_NV_DX_interop2");
/* 234 */     this.WGL_NV_float_buffer = ext.contains("WGL_NV_float_buffer");
/* 235 */     this.WGL_NV_gpu_affinity = check_WGL_NV_gpu_affinity(provider, caps, ext);
/* 236 */     this.WGL_NV_multigpu_context = ext.contains("WGL_NV_multigpu_context");
/* 237 */     this.WGL_NV_multisample_coverage = ext.contains("WGL_NV_multisample_coverage");
/* 238 */     this.WGL_NV_render_depth_texture = ext.contains("WGL_NV_render_depth_texture");
/* 239 */     this.WGL_NV_render_texture_rectangle = ext.contains("WGL_NV_render_texture_rectangle");
/* 240 */     this.WGL_NV_swap_group = check_WGL_NV_swap_group(provider, caps, ext);
/* 241 */     this.WGL_NV_vertex_array_range = check_WGL_NV_vertex_array_range(provider, caps, ext);
/*     */     
/* 243 */     this.wglGetGPUIDsAMD = caps[0];
/* 244 */     this.wglGetGPUInfoAMD = caps[1];
/* 245 */     this.wglGetContextGPUIDAMD = caps[2];
/* 246 */     this.wglCreateAssociatedContextAMD = caps[3];
/* 247 */     this.wglCreateAssociatedContextAttribsAMD = caps[4];
/* 248 */     this.wglDeleteAssociatedContextAMD = caps[5];
/* 249 */     this.wglMakeAssociatedContextCurrentAMD = caps[6];
/* 250 */     this.wglGetCurrentAssociatedContextAMD = caps[7];
/* 251 */     this.wglBlitContextFramebufferAMD = caps[8];
/* 252 */     this.wglCreateBufferRegionARB = caps[9];
/* 253 */     this.wglDeleteBufferRegionARB = caps[10];
/* 254 */     this.wglSaveBufferRegionARB = caps[11];
/* 255 */     this.wglRestoreBufferRegionARB = caps[12];
/* 256 */     this.wglCreateContextAttribsARB = caps[13];
/* 257 */     this.wglGetExtensionsStringARB = caps[14];
/* 258 */     this.wglMakeContextCurrentARB = caps[15];
/* 259 */     this.wglGetCurrentReadDCARB = caps[16];
/* 260 */     this.wglCreatePbufferARB = caps[17];
/* 261 */     this.wglGetPbufferDCARB = caps[18];
/* 262 */     this.wglReleasePbufferDCARB = caps[19];
/* 263 */     this.wglDestroyPbufferARB = caps[20];
/* 264 */     this.wglQueryPbufferARB = caps[21];
/* 265 */     this.wglGetPixelFormatAttribivARB = caps[22];
/* 266 */     this.wglGetPixelFormatAttribfvARB = caps[23];
/* 267 */     this.wglChoosePixelFormatARB = caps[24];
/* 268 */     this.wglBindTexImageARB = caps[25];
/* 269 */     this.wglReleaseTexImageARB = caps[26];
/* 270 */     this.wglSetPbufferAttribARB = caps[27];
/* 271 */     this.wglGetExtensionsStringEXT = caps[28];
/* 272 */     this.wglSwapIntervalEXT = caps[29];
/* 273 */     this.wglGetSwapIntervalEXT = caps[30];
/* 274 */     this.wglCopyImageSubDataNV = caps[31];
/* 275 */     this.wglDelayBeforeSwapNV = caps[32];
/* 276 */     this.wglDXSetResourceShareHandleNV = caps[33];
/* 277 */     this.wglDXOpenDeviceNV = caps[34];
/* 278 */     this.wglDXCloseDeviceNV = caps[35];
/* 279 */     this.wglDXRegisterObjectNV = caps[36];
/* 280 */     this.wglDXUnregisterObjectNV = caps[37];
/* 281 */     this.wglDXObjectAccessNV = caps[38];
/* 282 */     this.wglDXLockObjectsNV = caps[39];
/* 283 */     this.wglDXUnlockObjectsNV = caps[40];
/* 284 */     this.wglEnumGpusNV = caps[41];
/* 285 */     this.wglEnumGpuDevicesNV = caps[42];
/* 286 */     this.wglCreateAffinityDCNV = caps[43];
/* 287 */     this.wglEnumGpusFromAffinityDCNV = caps[44];
/* 288 */     this.wglDeleteDCNV = caps[45];
/* 289 */     this.wglJoinSwapGroupNV = caps[46];
/* 290 */     this.wglBindSwapBarrierNV = caps[47];
/* 291 */     this.wglQuerySwapGroupNV = caps[48];
/* 292 */     this.wglQueryMaxSwapGroupsNV = caps[49];
/* 293 */     this.wglQueryFrameCountNV = caps[50];
/* 294 */     this.wglResetFrameCountNV = caps[51];
/* 295 */     this.wglAllocateMemoryNV = caps[52];
/* 296 */     this.wglFreeMemoryNV = caps[53];
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_AMD_gpu_association(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 300 */     if (!ext.contains("WGL_AMD_gpu_association")) {
/* 301 */       return false;
/*     */     }
/*     */     
/* 304 */     return (Checks.checkFunctions(provider, caps, new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }, new String[] { "wglGetGPUIDsAMD", "wglGetGPUInfoAMD", "wglGetContextGPUIDAMD", "wglCreateAssociatedContextAMD", "wglCreateAssociatedContextAttribsAMD", "wglDeleteAssociatedContextAMD", "wglMakeAssociatedContextCurrentAMD", "wglGetCurrentAssociatedContextAMD"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 309 */         }) || Checks.reportMissing("WGL", "WGL_AMD_gpu_association"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_ARB_buffer_region(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 313 */     if (!ext.contains("WGL_ARB_buffer_region")) {
/* 314 */       return false;
/*     */     }
/*     */     
/* 317 */     return (Checks.checkFunctions(provider, caps, new int[] { 9, 10, 11, 12 }, new String[] { "wglCreateBufferRegionARB", "wglDeleteBufferRegionARB", "wglSaveBufferRegionARB", "wglRestoreBufferRegionARB"
/*     */ 
/*     */ 
/*     */         
/* 321 */         }) || Checks.reportMissing("WGL", "WGL_ARB_buffer_region"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_ARB_create_context(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 325 */     if (!ext.contains("WGL_ARB_create_context")) {
/* 326 */       return false;
/*     */     }
/*     */     
/* 329 */     return (Checks.checkFunctions(provider, caps, new int[] { 13 }, new String[] { "wglCreateContextAttribsARB"
/*     */ 
/*     */ 
/*     */         
/* 333 */         }) || Checks.reportMissing("WGL", "WGL_ARB_create_context"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_ARB_extensions_string(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 337 */     if (!ext.contains("WGL_ARB_extensions_string")) {
/* 338 */       return false;
/*     */     }
/*     */     
/* 341 */     return (Checks.checkFunctions(provider, caps, new int[] { 14 }, new String[] { "wglGetExtensionsStringARB"
/*     */ 
/*     */ 
/*     */         
/* 345 */         }) || Checks.reportMissing("WGL", "WGL_ARB_extensions_string"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_ARB_make_current_read(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 349 */     if (!ext.contains("WGL_ARB_make_current_read")) {
/* 350 */       return false;
/*     */     }
/*     */     
/* 353 */     return (Checks.checkFunctions(provider, caps, new int[] { 15, 16 }, new String[] { "wglMakeContextCurrentARB", "wglGetCurrentReadDCARB"
/*     */ 
/*     */ 
/*     */         
/* 357 */         }) || Checks.reportMissing("WGL", "WGL_ARB_make_current_read"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_ARB_pbuffer(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 361 */     if (!ext.contains("WGL_ARB_pbuffer")) {
/* 362 */       return false;
/*     */     }
/*     */     
/* 365 */     return (Checks.checkFunctions(provider, caps, new int[] { 17, 18, 19, 20, 21 }, new String[] { "wglCreatePbufferARB", "wglGetPbufferDCARB", "wglReleasePbufferDCARB", "wglDestroyPbufferARB", "wglQueryPbufferARB"
/*     */ 
/*     */ 
/*     */         
/* 369 */         }) || Checks.reportMissing("WGL", "WGL_ARB_pbuffer"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_ARB_pixel_format(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 373 */     if (!ext.contains("WGL_ARB_pixel_format")) {
/* 374 */       return false;
/*     */     }
/*     */     
/* 377 */     return (Checks.checkFunctions(provider, caps, new int[] { 22, 23, 24 }, new String[] { "wglGetPixelFormatAttribivARB", "wglGetPixelFormatAttribfvARB", "wglChoosePixelFormatARB"
/*     */ 
/*     */ 
/*     */         
/* 381 */         }) || Checks.reportMissing("WGL", "WGL_ARB_pixel_format"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_ARB_render_texture(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 385 */     if (!ext.contains("WGL_ARB_render_texture")) {
/* 386 */       return false;
/*     */     }
/*     */     
/* 389 */     return (Checks.checkFunctions(provider, caps, new int[] { 25, 26, 27 }, new String[] { "wglBindTexImageARB", "wglReleaseTexImageARB", "wglSetPbufferAttribARB"
/*     */ 
/*     */ 
/*     */         
/* 393 */         }) || Checks.reportMissing("WGL", "WGL_ARB_render_texture"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_EXT_extensions_string(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 397 */     if (!ext.contains("WGL_EXT_extensions_string")) {
/* 398 */       return false;
/*     */     }
/*     */     
/* 401 */     return (Checks.checkFunctions(provider, caps, new int[] { 28 }, new String[] { "wglGetExtensionsStringEXT"
/*     */ 
/*     */ 
/*     */         
/* 405 */         }) || Checks.reportMissing("WGL", "WGL_EXT_extensions_string"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_EXT_swap_control(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 409 */     if (!ext.contains("WGL_EXT_swap_control")) {
/* 410 */       return false;
/*     */     }
/*     */     
/* 413 */     return (Checks.checkFunctions(provider, caps, new int[] { 29, 30 }, new String[] { "wglSwapIntervalEXT", "wglGetSwapIntervalEXT"
/*     */ 
/*     */ 
/*     */         
/* 417 */         }) || Checks.reportMissing("WGL", "WGL_EXT_swap_control"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_NV_copy_image(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 421 */     if (!ext.contains("WGL_NV_copy_image")) {
/* 422 */       return false;
/*     */     }
/*     */     
/* 425 */     return (Checks.checkFunctions(provider, caps, new int[] { 31 }, new String[] { "wglCopyImageSubDataNV"
/*     */ 
/*     */ 
/*     */         
/* 429 */         }) || Checks.reportMissing("WGL", "WGL_NV_copy_image"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_NV_delay_before_swap(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 433 */     if (!ext.contains("WGL_NV_delay_before_swap")) {
/* 434 */       return false;
/*     */     }
/*     */     
/* 437 */     return (Checks.checkFunctions(provider, caps, new int[] { 32 }, new String[] { "wglDelayBeforeSwapNV"
/*     */ 
/*     */ 
/*     */         
/* 441 */         }) || Checks.reportMissing("WGL", "WGL_NV_delay_before_swap"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_NV_DX_interop(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 445 */     if (!ext.contains("WGL_NV_DX_interop")) {
/* 446 */       return false;
/*     */     }
/*     */     
/* 449 */     return (Checks.checkFunctions(provider, caps, new int[] { 33, 34, 35, 36, 37, 38, 39, 40 }, new String[] { "wglDXSetResourceShareHandleNV", "wglDXOpenDeviceNV", "wglDXCloseDeviceNV", "wglDXRegisterObjectNV", "wglDXUnregisterObjectNV", "wglDXObjectAccessNV", "wglDXLockObjectsNV", "wglDXUnlockObjectsNV"
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 454 */         }) || Checks.reportMissing("WGL", "WGL_NV_DX_interop"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_NV_gpu_affinity(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 458 */     if (!ext.contains("WGL_NV_gpu_affinity")) {
/* 459 */       return false;
/*     */     }
/*     */     
/* 462 */     return (Checks.checkFunctions(provider, caps, new int[] { 41, 42, 43, 44, 45 }, new String[] { "wglEnumGpusNV", "wglEnumGpuDevicesNV", "wglCreateAffinityDCNV", "wglEnumGpusFromAffinityDCNV", "wglDeleteDCNV"
/*     */ 
/*     */ 
/*     */         
/* 466 */         }) || Checks.reportMissing("WGL", "WGL_NV_gpu_affinity"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_NV_swap_group(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 470 */     if (!ext.contains("WGL_NV_swap_group")) {
/* 471 */       return false;
/*     */     }
/*     */     
/* 474 */     return (Checks.checkFunctions(provider, caps, new int[] { 46, 47, 48, 49, 50, 51 }, new String[] { "wglJoinSwapGroupNV", "wglBindSwapBarrierNV", "wglQuerySwapGroupNV", "wglQueryMaxSwapGroupsNV", "wglQueryFrameCountNV", "wglResetFrameCountNV"
/*     */ 
/*     */ 
/*     */         
/* 478 */         }) || Checks.reportMissing("WGL", "WGL_NV_swap_group"));
/*     */   }
/*     */   
/*     */   private static boolean check_WGL_NV_vertex_array_range(FunctionProvider provider, long[] caps, Set<String> ext) {
/* 482 */     if (!ext.contains("WGL_NV_vertex_array_range")) {
/* 483 */       return false;
/*     */     }
/*     */     
/* 486 */     return (Checks.checkFunctions(provider, caps, new int[] { 52, 53 }, new String[] { "wglAllocateMemoryNV", "wglFreeMemoryNV"
/*     */ 
/*     */ 
/*     */         
/* 490 */         }) || Checks.reportMissing("WGL", "WGL_NV_vertex_array_range"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\opengl\WGLCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */