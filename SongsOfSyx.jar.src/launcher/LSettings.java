/*     */ package launcher;
/*     */ 
/*     */ import game.VERSION;
/*     */ import init.paths.PATHS;
/*     */ import snake2d.Displays;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.misc.OS;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.data.DOUBLE;
/*     */ import util.data.GETTER;
/*     */ import util.data.INT;
/*     */ 
/*     */ 
/*     */ public final class LSettings
/*     */ {
/*  19 */   private final ArrayListGrower<LSetting> all = new ArrayListGrower();
/*  20 */   public final LSettingInt otherJVM = new LSettingInt("JVM", 0, 1);
/*  21 */   public final LSettingInt debug = new LSettingInt("DEBUG", 0, 1);
/*  22 */   public final LSettingInt developer = new LSettingInt("DEVELOPER", 0, 1);
/*  23 */   public final LSettingInt rpc = new LSettingInt("RPC", (PATHS.isSteam() && OS.get() != OS.MAC) ? 1 : 0, 1);
/*  24 */   public final LSettingInt linear = new LSettingInt("LINEAR", 1, 1);
/*  25 */   public final LSettingInt shading = new LSettingInt("SHADING", 1, 1);
/*  26 */   public final LSettingInt vsync = new LSettingInt("VSYNC", 0, 1);
/*  27 */   public final LSettingInt vsyncadapt = new LSettingInt("VSYNC_ADAPTIVE", 0, 1);
/*  28 */   public final LSettingInt easy = new LSettingInt("EASY_FONT", 0, 1);
/*  29 */   public final LSettingInt version = new LSettingInt("VERSION", -1, 2147483646);
/*  30 */   public final LSettingInt monitor = new LSettingInt(this, "MONITOR", 0, 2147483646)
/*     */     {
/*     */       public int max()
/*     */       {
/*  34 */         return Displays.monitors() - 1;
/*     */       }
/*     */     };
/*     */   
/*  38 */   public final LSettingInt screenMode = new LSettingInt("SCREEN_MODE", 0, 2);
/*  39 */   public final LSettingInt FPS = new LSettingInt("FPS_CAP", 0, 100);
/*     */   public static final int screenModeBorderLess = 0;
/*     */   public static final int screenModeFull = 1;
/*     */   public static final int screenModeWindowed = 2;
/*     */   
/*  44 */   public final LSettingInt fullScreenDisplay = new LSettingInt(this, "FULL_DISPLAY", 0, 2147483646)
/*     */     {
/*     */       public int max()
/*     */       {
/*  48 */         LIST<Displays.DisplayMode> dis = Displays.available(LSettings.this.monitor.get());
/*  49 */         if (dis == null || dis.size() == 0)
/*  50 */           return 0; 
/*  51 */         return dis.size() - 1;
/*     */       }
/*     */     };
/*     */   
/*  55 */   public final LSettingInt windowWidth = new LSettingInt(this, "WINDOW_WIDTH", 15, 20)
/*     */     {
/*     */       public int min() {
/*  58 */         return (int)(max() * 1280.0D / (Displays.current(LSettings.this.monitor.get())).width);
/*     */       }
/*     */     };
/*  61 */   public final LSettingInt windowHeight = new LSettingInt(this, "WIDOW_HEIGHT", 15, 20)
/*     */     {
/*     */       public int min() {
/*  64 */         return (int)(max() * 768.0D / (Displays.current(LSettings.this.monitor.get())).height);
/*     */       }
/*     */     };
/*     */   
/*  68 */   public final LSettingInt windowBorderLessScale = new LSettingInt(this, "WIDOW_SCALE", 0, 100)
/*     */     {
/*     */       
/*     */       public int max()
/*     */       {
/*  73 */         double dh = (Displays.current(LSettings.this.monitor.get())).height / 768.0D;
/*  74 */         double dv = (Displays.current(LSettings.this.monitor.get())).width / 1280.0D;
/*  75 */         double d = Math.min(dh, dv);
/*  76 */         d--;
/*  77 */         return (int)CLAMP.d(d / 0.05D, 0.0D, 100.0D);
/*     */       }
/*     */ 
/*     */       
/*     */       public double getD() {
/*  82 */         return get() * 0.05D;
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*  87 */   public final LSettingInt decorated = new LSettingInt("WINDOW_DECORATE", 1, 1);
/*  88 */   public final LSettingInt forcedHD = new LSettingInt("WINDOW_FORCE_HD", 0, 1);
/*     */ 
/*     */   
/*  91 */   public final LSettingInt shadows = new LSettingInt("SHADOWS", 2, 2);
/*  92 */   public final LSettingInt particles = new LSettingInt("PARICLES", 2, 2);
/*  93 */   public final LSettingInt gore = new LSettingInt("GORE", 2, 2);
/*  94 */   public final LSettingInt volumeMaster = new LSettingInt("VOLUME_MASTER", 70, 100);
/*  95 */   public final LSettingInt volumeSound = new LSettingInt("VOLUME_SOUND", 100, 100);
/*  96 */   public final LSettingInt volumeMusic = new LSettingInt("VOLUME_MUSIC", 70, 100);
/*  97 */   public final LSettingInt volumeAmbience = new LSettingInt("VOLUME_AMBIENCE", 70, 100);
/*  98 */   public final LSettingInt focusMute = new LSettingInt("FOCUS_MUTE", 1, 1);
/*  99 */   public final LSettingInt brightness = new LSettingInt("BRIGHTNESS22", 50, 100);
/* 100 */   public final LSettingInt autoSaveInterval = new LSettingInt("AUTO_SAVE_TIME", 9, 10);
/* 101 */   public final LSettingInt autoSaveFiles = new LSettingInt("AUTO_SAVE_FILES", 5, 10);
/* 102 */   public final LSettingInt edgeScroll = new LSettingInt("EDGE_SCROLL", 0, 1);
/* 103 */   public final LSettingInt detail = new LSettingInt("GRAPHIC_DETAIL", 1, 1);
/* 104 */   public final LSettingInt lightCycle = new LSettingInt("LIGHT_CYCLE", 1, 1);
/* 105 */   public final LSettingInt uiLightCycle = new LSettingInt("UI_LIGHT_CYCLE", 1, 1);
/* 106 */   public final LSettingInt downpour = new LSettingInt("DOWNPOUR", 1, 1);
/* 107 */   public final LSettingInt winIconi = new LSettingInt("WIN_AUTO_ICONIFY", 1, 1);
/* 108 */   public final LSettingInt winFoat = new LSettingInt("WINDOW_FLOAT", 0, 1);
/* 109 */   public final LSettingInt winFullFull = new LSettingInt("WINDOW_FULL_FULL", 0, 1);
/* 110 */   public final SString alternateJVM = new SString("PATH_JAVA", "");
/* 111 */   public final SString lang = new SString("LANGUAGE", "");
/* 112 */   public final SString audiodevice = new SString("OPENAL", "");
/* 113 */   public final SStrings mods = new SStrings("MODS", new String[0]);
/* 114 */   public final SStrings jvmArguments = new SStrings("JVM_ARGS2", new String[] {
/* 115 */         "-Xms512m", 
/* 116 */         "-Xmx4096m", 
/* 117 */         "-XX:+UseCompressedOops", 
/* 118 */         "-Dfile.encoding=UTF-8", 
/* 119 */         "-server", 
/* 120 */         "-Dfml.earlyprogresswindow=false", 
/* 121 */         "-XX:+UseSerialGC"
/*     */       });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefault() {
/* 131 */     for (LSetting s : this.all)
/* 132 */       s.setDefault(); 
/*     */   }
/*     */   
/*     */   public LSettings() {
/*     */     try {
/* 137 */       Json json = new Json((PATHS.local()).SETTINGS.gets("LauncherSettings"));
/* 138 */       for (LSetting s : this.all) {
/* 139 */         if (json.has(s.key)) {
/* 140 */           s.read(json); continue;
/*     */         } 
/* 142 */         s.setDefault();
/*     */       }
/*     */     
/* 145 */     } catch (Exception e) {
/* 146 */       e.printStackTrace(System.out);
/* 147 */       setDefault();
/* 148 */       save();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   boolean check() {
/* 154 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void save() {
/*     */     try {
/* 160 */       JsonE json = new JsonE();
/* 161 */       this.version.v = VERSION.VERSION;
/* 162 */       for (LSetting s : this.all) {
/* 163 */         s.write(json);
/*     */       }
/* 165 */       json.save((PATHS.local()).SETTINGS.create("LauncherSettings"));
/*     */     
/*     */     }
/* 168 */     catch (Exception e) {
/* 169 */       e.printStackTrace(System.out);
/* 170 */       setDefault();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract class LSetting
/*     */   {
/*     */     public final String key;
/*     */     
/*     */     private LSetting(String key) {
/* 180 */       this.key = key;
/* 181 */       LSettings.this.all.add(this);
/*     */     }
/*     */     
/*     */     protected abstract void setDefault();
/*     */     
/*     */     protected abstract void read(Json param1Json);
/*     */     
/*     */     protected abstract void write(JsonE param1JsonE);
/*     */   }
/*     */   
/*     */   public class LSettingInt
/*     */     extends LSetting implements INT.INTE {
/*     */     protected int v;
/*     */     public final int defaultValue;
/*     */     private final int max;
/*     */     
/*     */     private LSettingInt(String key, int defaultValue, int max) {
/* 198 */       super(key);
/* 199 */       this.defaultValue = defaultValue;
/* 200 */       this.max = max;
/*     */     }
/*     */ 
/*     */     
/*     */     public int get() {
/* 205 */       return CLAMP.i(this.v, 0, max());
/*     */     }
/*     */ 
/*     */     
/*     */     public int min() {
/* 210 */       return 0;
/*     */     }
/*     */ 
/*     */     
/*     */     public int max() {
/* 215 */       return this.max;
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(int t) {
/* 220 */       this.v = CLAMP.i(t, 0, max());
/* 221 */       LSettings.this.save();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void setDefault() {
/* 227 */       this.v = this.defaultValue;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void read(Json json) {
/* 232 */       this.v = json.i(this.key, -2147483647, 2147483647, this.defaultValue);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void write(JsonE json) {
/* 237 */       json.add(this.key, this.v);
/*     */     }
/*     */   }
/*     */   
/*     */   public final class SString
/*     */     extends LSetting
/*     */     implements GETTER.GETTERE<String>
/*     */   {
/*     */     public final String def;
/*     */     public String current;
/*     */     
/*     */     SString(String key, String def) {
/* 249 */       super(key);
/* 250 */       this.def = def;
/*     */     }
/*     */ 
/*     */     
/*     */     public String get() {
/* 255 */       return this.current;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void setDefault() {
/* 260 */       this.current = this.def;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void read(Json json) {
/* 265 */       this.current = json.text(this.key);
/* 266 */       if (this.current.equals("null")) {
/* 267 */         this.current = null;
/*     */       }
/*     */     }
/*     */     
/*     */     protected void write(JsonE json) {
/* 272 */       json.addString(this.key, (this.current == null) ? "null" : this.current);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(String t) {
/* 277 */       this.current = t;
/*     */     }
/*     */   }
/*     */   
/*     */   public final class SStrings
/*     */     extends LSetting
/*     */     implements GETTER.GETTERE<String[]> {
/*     */     public final String key;
/*     */     public final String[] def;
/*     */     public String[] current;
/*     */     
/*     */     SStrings(String key, String[] def) {
/* 289 */       super(key);
/* 290 */       this.key = key;
/* 291 */       this.def = def;
/*     */     }
/*     */ 
/*     */     
/*     */     public String[] get() {
/* 296 */       if (this.current == null)
/* 297 */         return this.def; 
/* 298 */       return this.current;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void setDefault() {
/* 303 */       this.current = this.def;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void read(Json json) {
/* 308 */       this.current = json.texts(this.key);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     protected void write(JsonE json) {
/* 314 */       json.addStrings(this.key, this.current);
/*     */     }
/*     */ 
/*     */     
/*     */     public void set(String[] t) {
/* 319 */       this.current = t;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\launcher\LSettings.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */