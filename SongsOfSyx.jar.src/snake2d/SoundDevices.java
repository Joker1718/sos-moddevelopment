/*     */ package snake2d;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import org.lwjgl.openal.AL;
/*     */ import org.lwjgl.openal.AL10;
/*     */ import org.lwjgl.openal.ALC;
/*     */ import org.lwjgl.openal.ALC10;
/*     */ import org.lwjgl.openal.ALCCapabilities;
/*     */ import org.lwjgl.openal.ALUtil;
/*     */ import org.lwjgl.openal.EXTThreadLocalContext;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SoundDevices
/*     */ {
/*  47 */   private ArrayList<String> available = new ArrayList(ALUtil.getStringList(0L, 4115));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static SoundDevices self;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<String> get() {
/*  71 */     if (self == null)
/*  72 */       self = new SoundDevices(); 
/*  73 */     return (LIST<String>)self.available;
/*     */   }
/*     */   
/*     */   public static void refresh() {
/*  77 */     self = new SoundDevices();
/*     */   }
/*     */ 
/*     */   
/*     */   public void check(String name) {
/*  82 */     Printer.ln(name);
/*     */     
/*  84 */     long device = ALC10.alcOpenDevice(name);
/*  85 */     if (device == 0L) {
/*  86 */       throw new IllegalStateException("Failed to open an OpenAL device.");
/*     */     }
/*     */     
/*  89 */     ALCCapabilities deviceCaps = ALC.createCapabilities(device);
/*     */     
/*  91 */     long context = ALC10.alcCreateContext(device, null);
/*  92 */     checkALCError(device);
/*     */     
/*  94 */     boolean useTLC = (deviceCaps.ALC_EXT_thread_local_context && EXTThreadLocalContext.alcSetThreadContext(context));
/*  95 */     if (!useTLC && 
/*  96 */       !ALC10.alcMakeContextCurrent(context)) {
/*  97 */       throw new IllegalStateException();
/*     */     }
/*     */     
/* 100 */     checkALCError(device);
/*     */     
/* 102 */     AL.createCapabilities(deviceCaps);
/*     */     
/* 104 */     printALCInfo(device, deviceCaps);
/* 105 */     printALInfo();
/*     */     
/* 107 */     ALC10.alcMakeContextCurrent(0L);
/* 108 */     if (useTLC) {
/* 109 */       AL.setCurrentThread(null);
/*     */     } else {
/* 111 */       AL.setCurrentProcess(null);
/*     */     } 
/*     */     
/* 114 */     ALC10.alcDestroyContext(context);
/* 115 */     ALC10.alcCloseDevice(device);
/*     */     
/* 117 */     Printer.ln();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void printALCInfo(long device, ALCCapabilities caps) {
/* 122 */     Printer.ln("Default capture device: " + ALC10.alcGetString(0L, 785));
/*     */     
/* 124 */     Printer.ln("ALC device specifier: " + ALC10.alcGetString(device, 4101));
/*     */     
/* 126 */     int majorVersion = ALC10.alcGetInteger(device, 4096);
/* 127 */     int minorVersion = ALC10.alcGetInteger(device, 4097);
/* 128 */     checkALCError(device);
/*     */     
/* 130 */     Printer.ln("ALC version: " + majorVersion + "." + minorVersion);
/*     */ 
/*     */     
/* 133 */     String[] extensions = ((String)Objects.<String>requireNonNull(ALC10.alcGetString(device, 4102))).split(" ");
/* 134 */     Printer.ln("ALC extensions:", extensions);
/* 135 */     checkALCError(device);
/*     */   }
/*     */   
/*     */   private static void printALInfo() {
/* 139 */     Printer.ln("OpenAL vendor string: " + AL10.alGetString(45057));
/* 140 */     Printer.ln("OpenAL renderer string: " + AL10.alGetString(45059));
/* 141 */     Printer.ln("OpenAL version string: " + AL10.alGetString(45058));
/*     */     
/* 143 */     String[] extensions = ((String)Objects.<String>requireNonNull(AL10.alGetString(45060))).split(" ");
/* 144 */     Printer.ln("AL extensions:", extensions);
/* 145 */     checkALError();
/*     */   }
/*     */   
/*     */   static void checkALCError(long device) {
/* 149 */     int err = ALC10.alcGetError(device);
/* 150 */     if (err != 0) {
/* 151 */       throw new RuntimeException(ALC10.alcGetString(device, err));
/*     */     }
/*     */   }
/*     */   
/*     */   static void checkALError() {
/* 156 */     int err = AL10.alGetError();
/* 157 */     if (err != 0)
/* 158 */       throw new RuntimeException(AL10.alGetString(err)); 
/*     */   }
/*     */   
/*     */   public static void main(String[] args) {}
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\snake2d\SoundDevices.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */