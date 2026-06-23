/*     */ package game.save;
/*     */ 
/*     */ import game.GameSpec;
/*     */ import game.VERSION;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import java.nio.file.Path;
/*     */ import java.util.Arrays;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import util.text.DicTime;
/*     */ 
/*     */ 
/*     */ public class SaveFile
/*     */   implements Comparable<SaveFile>
/*     */ {
/*     */   public final Path path;
/*     */   public final String name;
/*     */   public final CharSequence ago;
/*     */   public final CharSequence fullName;
/*     */   public final int version;
/*     */   public final int modHash;
/*     */   public final int pop;
/*     */   public final long t;
/*  26 */   private static CharSequence ¤¤Version = "¤This save is from a previous version and will probably not load!";
/*  27 */   private static CharSequence ¤¤Mod = "¤This save is made with a different mod configuration and will probably not load!";
/*     */   
/*     */   static {
/*  30 */     D.ts(SaveFile.class);
/*     */   }
/*     */   private GameSpec spec;
/*     */   public SaveFile(Path path) {
/*  34 */     this.path = path;
/*  35 */     String f = path.getFileName().toString();
/*  36 */     if (f.lastIndexOf(".") > 0)
/*  37 */       f = f.substring(0, f.lastIndexOf(".")); 
/*  38 */     this.fullName = f;
/*  39 */     this.name = name(f);
/*  40 */     this.t = time(f);
/*  41 */     this.version = version(f);
/*  42 */     this.modHash = modHash(f);
/*  43 */     this.pop = pop(f);
/*  44 */     if (this.t > 0L && System.currentTimeMillis() - this.t > 0L) {
/*  45 */       double tt = ((System.currentTimeMillis() - this.t) / 1000L);
/*  46 */       double now = tt / 3.1536E7D;
/*     */       
/*  48 */       if (now < 1.0D) {
/*  49 */         now = tt / 86400.0D;
/*  50 */         if (now < 1.0D) {
/*  51 */           now = tt / 3600.0D;
/*  52 */           if (now < 1.0D) {
/*  53 */             now = tt / 60.0D;
/*  54 */             if (now == 0.0D) {
/*  55 */               this.ago = (CharSequence)DicTime.setSeconds(new Str(8), tt);
/*     */             } else {
/*  57 */               this.ago = (CharSequence)DicTime.setMinutes(new Str(8), now);
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/*  62 */             this.ago = (CharSequence)DicTime.setHours(new Str(8), now);
/*     */           } 
/*     */         } else {
/*     */           
/*  66 */           this.ago = (CharSequence)DicTime.setDays(new Str(8), now);
/*     */         } 
/*     */       } else {
/*  69 */         this.ago = (CharSequence)DicTime.setYears(new Str(8), now);
/*     */       } 
/*     */     } else {
/*     */       
/*  73 */       this.ago = "???";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static SaveFile[] list() {
/*  79 */     return list(PATHS.local().save());
/*     */   }
/*     */   
/*     */   public static SaveFile[] list(PATH path) {
/*  83 */     String[] ss = path.getFiles();
/*     */     
/*  85 */     SaveFile[] saves = new SaveFile[ss.length];
/*  86 */     for (int i = 0; i < ss.length; i++) {
/*  87 */       saves[i] = new SaveFile(path.get(ss[i]));
/*     */     }
/*  89 */     Arrays.sort((Object[])saves);
/*  90 */     return saves;
/*     */   }
/*     */   
/*     */   public static String name(String file) {
/*  94 */     return get(file, 4, false);
/*     */   }
/*     */   
/*     */   public static long time(String file) {
/*  98 */     String s = get(file, 3, true);
/*     */     try {
/* 100 */       return Long.parseLong(s, 16);
/* 101 */     } catch (Exception e) {
/* 102 */       return -1L;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int version(String file) {
/* 107 */     String s = get(file, 2, true);
/*     */     
/*     */     try {
/* 110 */       return (int)Long.parseLong(s, 16);
/* 111 */     } catch (Exception e) {
/* 112 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int modHash(String file) {
/* 117 */     String s = get(file, 1, true);
/*     */     try {
/* 119 */       return (int)Long.parseLong(s, 16);
/* 120 */     } catch (Exception e) {
/* 121 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static int pop(String file) {
/* 126 */     String s = get(file, 0, true);
/*     */     try {
/* 128 */       return (int)Long.parseLong(s, 16);
/* 129 */     } catch (Exception e) {
/* 130 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private static String get(String file, int part, boolean p) {
/* 135 */     while (part > 0) {
/* 136 */       int j = file.lastIndexOf('-');
/* 137 */       if (j <= 0)
/* 138 */         return "0"; 
/* 139 */       file = file.substring(0, j);
/* 140 */       part--;
/*     */     } 
/* 142 */     int i = file.lastIndexOf('-');
/* 143 */     if (i <= 0 || !p)
/* 144 */       return file; 
/* 145 */     return file.substring(i + 1, file.length());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(SaveFile arg0) {
/* 156 */     if (this.t < 0L && arg0.t >= 0L)
/* 157 */       return 1; 
/* 158 */     if (this.t >= 0L && arg0.t < 0L) {
/* 159 */       return -1;
/*     */     }
/* 161 */     long ti = arg0.t - this.t;
/* 162 */     if (ti < 0L)
/* 163 */       return -1; 
/* 164 */     if (ti > 0L)
/* 165 */       return 1; 
/* 166 */     return this.name.compareTo(arg0.name);
/*     */   }
/*     */   
/*     */   public static String stamp(CharSequence savefile) {
/* 170 */     String t = Long.toHexString(System.currentTimeMillis());
/* 171 */     String v = Integer.toHexString(VERSION.VERSION);
/* 172 */     String mods = Integer.toHexString(PATHS.modHash());
/* 173 */     String pop = Integer.toHexString(POP.tot(null, null));
/*     */ 
/*     */     
/* 176 */     String s = String.valueOf(savefile) + "-" + String.valueOf(savefile) + "-" + t + "-" + v + "-" + mods;
/* 177 */     return s;
/*     */   }
/*     */   
/*     */   public CharSequence problem() {
/* 181 */     if (71 != VERSION.versionMajor(this.version)) {
/* 182 */       return ¤¤Version;
/*     */     }
/* 184 */     if (this.modHash != PATHS.modHash()) {
/* 185 */       return ¤¤Mod;
/*     */     }
/* 187 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GameSpec spec() {
/* 193 */     if (this.spec == null) {
/* 194 */       this.spec = GameSpec.get(this.path);
/*     */     }
/* 196 */     return this.spec;
/*     */   }
/*     */   
/*     */   public boolean specReady() {
/* 200 */     return (this.spec != null);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\save\SaveFile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */