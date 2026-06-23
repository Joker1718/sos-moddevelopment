/*     */ package org.lwjgl.openal;
/*     */ 
/*     */ import java.util.Set;
/*     */ import java.util.function.IntFunction;
/*     */ import org.lwjgl.PointerBuffer;
/*     */ import org.lwjgl.system.Checks;
/*     */ import org.lwjgl.system.FunctionProviderLocal;
/*     */ import org.lwjgl.system.ThreadLocalUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ALCCapabilities
/*     */ {
/*     */   public final long alcOpenDevice;
/*     */   public final long alcCloseDevice;
/*     */   public final long alcCreateContext;
/*     */   public final long alcMakeContextCurrent;
/*     */   public final long alcProcessContext;
/*     */   public final long alcSuspendContext;
/*     */   public final long alcDestroyContext;
/*     */   public final long alcGetCurrentContext;
/*     */   public final long alcGetContextsDevice;
/*     */   public final long alcIsExtensionPresent;
/*     */   public final long alcGetProcAddress;
/*     */   public final long alcGetEnumValue;
/*     */   public final long alcGetError;
/*     */   public final long alcGetString;
/*     */   public final long alcGetIntegerv;
/*     */   public final long alcCaptureOpenDevice;
/*     */   public final long alcCaptureCloseDevice;
/*     */   public final long alcCaptureStart;
/*     */   public final long alcCaptureStop;
/*     */   public final long alcCaptureSamples;
/*     */   public final long alcGetProcAddress2;
/*     */   public final long alcSetThreadContext;
/*     */   public final long alcGetThreadContext;
/*     */   public final long alcGetInteger64vSOFT;
/*     */   public final long alcGetStringiSOFT;
/*     */   public final long alcResetDeviceSOFT;
/*     */   public final long alcLoopbackOpenDeviceSOFT;
/*     */   public final long alcIsRenderFormatSupportedSOFT;
/*     */   public final long alcRenderSamplesSOFT;
/*     */   public final long alcDevicePauseSOFT;
/*     */   public final long alcDeviceResumeSOFT;
/*     */   public final long alcReopenDeviceSOFT;
/*     */   public final long alcEventIsSupportedSOFT;
/*     */   public final long alcEventControlSOFT;
/*     */   public final long alcEventCallbackSOFT;
/*     */   public final boolean OpenALC10;
/*     */   public final boolean OpenALC11;
/*     */   public final boolean OpenALC_SOFT_loopback_bformat;
/*     */   public final boolean ALC_ENUMERATE_ALL_EXT;
/*     */   public final boolean ALC_ENUMERATION_EXT;
/*     */   public final boolean ALC_EXT_CAPTURE;
/*     */   public final boolean ALC_EXT_debug;
/*     */   public final boolean ALC_EXT_DEDICATED;
/*     */   public final boolean ALC_EXT_DEFAULT_FILTER_ORDER;
/*     */   public final boolean ALC_EXT_direct_context;
/*     */   public final boolean ALC_EXT_disconnect;
/*     */   public final boolean ALC_EXT_EFX;
/*     */   public final boolean ALC_EXT_thread_local_context;
/*     */   public final boolean ALC_LOKI_audio_channel;
/*     */   public final boolean ALC_SOFT_device_clock;
/*     */   public final boolean ALC_SOFT_HRTF;
/*     */   public final boolean ALC_SOFT_loopback;
/*     */   public final boolean ALC_SOFT_output_limiter;
/*     */   public final boolean ALC_SOFT_output_mode;
/*     */   public final boolean ALC_SOFT_pause_device;
/*     */   public final boolean ALC_SOFT_reopen_device;
/*     */   public final boolean ALC_SOFT_system_events;
/*     */   final long device;
/*     */   final PointerBuffer addresses;
/*     */   
/*     */   ALCCapabilities(FunctionProviderLocal provider, long device, Set<String> ext, IntFunction<PointerBuffer> bufferFactory) {
/* 134 */     this.device = device;
/*     */     
/* 136 */     PointerBuffer caps = bufferFactory.apply(35);
/*     */     
/* 138 */     this.OpenALC10 = check_ALC10(provider, device, caps, ext);
/* 139 */     this.OpenALC11 = check_ALC11(provider, device, caps, ext);
/* 140 */     this.OpenALC_SOFT_loopback_bformat = ext.contains("OpenALC_SOFT_loopback_bformat");
/* 141 */     this.ALC_ENUMERATE_ALL_EXT = ext.contains("ALC_ENUMERATE_ALL_EXT");
/* 142 */     this.ALC_ENUMERATION_EXT = ext.contains("ALC_ENUMERATION_EXT");
/* 143 */     this.ALC_EXT_CAPTURE = check_EXT_CAPTURE(provider, device, caps, ext);
/* 144 */     this.ALC_EXT_debug = ext.contains("ALC_EXT_debug");
/* 145 */     this.ALC_EXT_DEDICATED = ext.contains("ALC_EXT_DEDICATED");
/* 146 */     this.ALC_EXT_DEFAULT_FILTER_ORDER = ext.contains("ALC_EXT_DEFAULT_FILTER_ORDER");
/* 147 */     this.ALC_EXT_direct_context = check_EXT_direct_context(provider, device, caps, ext);
/* 148 */     this.ALC_EXT_disconnect = ext.contains("ALC_EXT_disconnect");
/* 149 */     this.ALC_EXT_EFX = ext.contains("ALC_EXT_EFX");
/* 150 */     this.ALC_EXT_thread_local_context = check_EXT_thread_local_context(provider, device, caps, ext);
/* 151 */     this.ALC_LOKI_audio_channel = ext.contains("ALC_LOKI_audio_channel");
/* 152 */     this.ALC_SOFT_device_clock = check_SOFT_device_clock(provider, device, caps, ext);
/* 153 */     this.ALC_SOFT_HRTF = check_SOFT_HRTF(provider, device, caps, ext);
/* 154 */     this.ALC_SOFT_loopback = check_SOFT_loopback(provider, device, caps, ext);
/* 155 */     this.ALC_SOFT_output_limiter = ext.contains("ALC_SOFT_output_limiter");
/* 156 */     this.ALC_SOFT_output_mode = ext.contains("ALC_SOFT_output_mode");
/* 157 */     this.ALC_SOFT_pause_device = check_SOFT_pause_device(provider, device, caps, ext);
/* 158 */     this.ALC_SOFT_reopen_device = check_SOFT_reopen_device(provider, device, caps, ext);
/* 159 */     this.ALC_SOFT_system_events = check_SOFT_system_events(provider, device, caps, ext);
/*     */     
/* 161 */     this.alcOpenDevice = caps.get(0);
/* 162 */     this.alcCloseDevice = caps.get(1);
/* 163 */     this.alcCreateContext = caps.get(2);
/* 164 */     this.alcMakeContextCurrent = caps.get(3);
/* 165 */     this.alcProcessContext = caps.get(4);
/* 166 */     this.alcSuspendContext = caps.get(5);
/* 167 */     this.alcDestroyContext = caps.get(6);
/* 168 */     this.alcGetCurrentContext = caps.get(7);
/* 169 */     this.alcGetContextsDevice = caps.get(8);
/* 170 */     this.alcIsExtensionPresent = caps.get(9);
/* 171 */     this.alcGetProcAddress = caps.get(10);
/* 172 */     this.alcGetEnumValue = caps.get(11);
/* 173 */     this.alcGetError = caps.get(12);
/* 174 */     this.alcGetString = caps.get(13);
/* 175 */     this.alcGetIntegerv = caps.get(14);
/* 176 */     this.alcCaptureOpenDevice = caps.get(15);
/* 177 */     this.alcCaptureCloseDevice = caps.get(16);
/* 178 */     this.alcCaptureStart = caps.get(17);
/* 179 */     this.alcCaptureStop = caps.get(18);
/* 180 */     this.alcCaptureSamples = caps.get(19);
/* 181 */     this.alcGetProcAddress2 = caps.get(20);
/* 182 */     this.alcSetThreadContext = caps.get(21);
/* 183 */     this.alcGetThreadContext = caps.get(22);
/* 184 */     this.alcGetInteger64vSOFT = caps.get(23);
/* 185 */     this.alcGetStringiSOFT = caps.get(24);
/* 186 */     this.alcResetDeviceSOFT = caps.get(25);
/* 187 */     this.alcLoopbackOpenDeviceSOFT = caps.get(26);
/* 188 */     this.alcIsRenderFormatSupportedSOFT = caps.get(27);
/* 189 */     this.alcRenderSamplesSOFT = caps.get(28);
/* 190 */     this.alcDevicePauseSOFT = caps.get(29);
/* 191 */     this.alcDeviceResumeSOFT = caps.get(30);
/* 192 */     this.alcReopenDeviceSOFT = caps.get(31);
/* 193 */     this.alcEventIsSupportedSOFT = caps.get(32);
/* 194 */     this.alcEventControlSOFT = caps.get(33);
/* 195 */     this.alcEventCallbackSOFT = caps.get(34);
/*     */     
/* 197 */     this.addresses = ThreadLocalUtil.setupAddressBuffer(caps);
/*     */   }
/*     */ 
/*     */   
/*     */   public PointerBuffer getAddressBuffer() {
/* 202 */     return this.addresses;
/*     */   }
/*     */   
/*     */   private static boolean check_ALC10(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 206 */     if (!ext.contains("OpenALC10")) {
/* 207 */       return false;
/*     */     }
/*     */     
/* 210 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }, new String[] { "alcOpenDevice", "alcCloseDevice", "alcCreateContext", "alcMakeContextCurrent", "alcProcessContext", "alcSuspendContext", "alcDestroyContext", "alcGetCurrentContext", "alcGetContextsDevice", "alcIsExtensionPresent", "alcGetProcAddress", "alcGetEnumValue", "alcGetError", "alcGetString", "alcGetIntegerv"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 216 */         }) || Checks.reportMissing("ALC", "OpenALC10"));
/*     */   }
/*     */   
/*     */   private static boolean check_ALC11(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 220 */     if (!ext.contains("OpenALC11")) {
/* 221 */       return false;
/*     */     }
/*     */     
/* 224 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 15, 16, 17, 18, 19 }, new String[] { "alcCaptureOpenDevice", "alcCaptureCloseDevice", "alcCaptureStart", "alcCaptureStop", "alcCaptureSamples"
/*     */ 
/*     */ 
/*     */         
/* 228 */         }) || Checks.reportMissing("ALC", "OpenALC11"));
/*     */   }
/*     */   
/*     */   private static boolean check_EXT_CAPTURE(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 232 */     if (!ext.contains("ALC_EXT_CAPTURE")) {
/* 233 */       return false;
/*     */     }
/*     */     
/* 236 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 15, 16, 17, 18, 19 }, new String[] { "alcCaptureOpenDevice", "alcCaptureCloseDevice", "alcCaptureStart", "alcCaptureStop", "alcCaptureSamples"
/*     */ 
/*     */ 
/*     */         
/* 240 */         }) || Checks.reportMissing("ALC", "ALC_EXT_CAPTURE"));
/*     */   }
/*     */   
/*     */   private static boolean check_EXT_direct_context(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 244 */     if (!ext.contains("ALC_EXT_direct_context")) {
/* 245 */       return false;
/*     */     }
/*     */     
/* 248 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 20 }, new String[] { "alcGetProcAddress2"
/*     */ 
/*     */ 
/*     */         
/* 252 */         }) || Checks.reportMissing("ALC", "ALC_EXT_direct_context"));
/*     */   }
/*     */   
/*     */   private static boolean check_EXT_thread_local_context(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 256 */     if (!ext.contains("ALC_EXT_thread_local_context")) {
/* 257 */       return false;
/*     */     }
/*     */     
/* 260 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 21, 22 }, new String[] { "alcSetThreadContext", "alcGetThreadContext"
/*     */ 
/*     */ 
/*     */         
/* 264 */         }) || Checks.reportMissing("ALC", "ALC_EXT_thread_local_context"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_device_clock(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 268 */     if (!ext.contains("ALC_SOFT_device_clock")) {
/* 269 */       return false;
/*     */     }
/*     */     
/* 272 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 23 }, new String[] { "alcGetInteger64vSOFT"
/*     */ 
/*     */ 
/*     */         
/* 276 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_device_clock"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_HRTF(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 280 */     if (!ext.contains("ALC_SOFT_HRTF")) {
/* 281 */       return false;
/*     */     }
/*     */     
/* 284 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 24, 25 }, new String[] { "alcGetStringiSOFT", "alcResetDeviceSOFT"
/*     */ 
/*     */ 
/*     */         
/* 288 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_HRTF"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_loopback(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 292 */     if (!ext.contains("ALC_SOFT_loopback")) {
/* 293 */       return false;
/*     */     }
/*     */     
/* 296 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 26, 27, 28 }, new String[] { "alcLoopbackOpenDeviceSOFT", "alcIsRenderFormatSupportedSOFT", "alcRenderSamplesSOFT"
/*     */ 
/*     */ 
/*     */         
/* 300 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_loopback"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_pause_device(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 304 */     if (!ext.contains("ALC_SOFT_pause_device")) {
/* 305 */       return false;
/*     */     }
/*     */     
/* 308 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 29, 30 }, new String[] { "alcDevicePauseSOFT", "alcDeviceResumeSOFT"
/*     */ 
/*     */ 
/*     */         
/* 312 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_pause_device"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_reopen_device(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 316 */     if (!ext.contains("ALC_SOFT_reopen_device")) {
/* 317 */       return false;
/*     */     }
/*     */     
/* 320 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 31 }, new String[] { "alcReopenDeviceSOFT"
/*     */ 
/*     */ 
/*     */         
/* 324 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_reopen_device"));
/*     */   }
/*     */   
/*     */   private static boolean check_SOFT_system_events(FunctionProviderLocal provider, long device, PointerBuffer caps, Set<String> ext) {
/* 328 */     if (!ext.contains("ALC_SOFT_system_events")) {
/* 329 */       return false;
/*     */     }
/*     */     
/* 332 */     return (Checks.checkFunctions(provider, device, caps, new int[] { 32, 33, 34 }, new String[] { "alcEventIsSupportedSOFT", "alcEventControlSOFT", "alcEventCallbackSOFT"
/*     */ 
/*     */ 
/*     */         
/* 336 */         }) || Checks.reportMissing("ALC", "ALC_SOFT_system_events"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\org\lwjgl\openal\ALCCapabilities.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */