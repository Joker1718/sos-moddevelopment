/*     */ package game.save;
/*     */ 
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ public final class PROP
/*     */   extends Savable
/*     */ {
/*     */   private static PROP s;
/*     */   private boolean dirty;
/*  16 */   private final KeyMap<String> profileMap = new KeyMap();
/*  17 */   private final KeyMap<String> gameMap = new KeyMap();
/*     */   private static final String fn = "Properties";
/*     */   
/*     */   PROP(GameSaver s) {
/*  21 */     super("PROP");
/*  22 */     PROP.s = this;
/*  23 */     read();
/*     */   }
/*     */   
/*     */   public static PropGame game(String prefix) {
/*  27 */     return new PropGame(prefix);
/*     */   }
/*     */   
/*     */   public static String prop(String key) {
/*  31 */     if (s.profileMap.containsKey(key))
/*  32 */       return (String)s.profileMap.get(key); 
/*  33 */     return null;
/*     */   }
/*     */   
/*     */   public static void propSet(String key, String value) {
/*  37 */     if (value.equals(prop(key)))
/*     */       return; 
/*  39 */     s.dirty = true;
/*  40 */     s.profileMap.putReplace(key, value);
/*     */   }
/*     */   
/*     */   public static int propI(String key, int fallback) {
/*  44 */     String kk = prop(key);
/*  45 */     if (kk == null)
/*  46 */       return fallback; 
/*     */     try {
/*  48 */       int r = Integer.parseInt(kk);
/*  49 */       return r;
/*  50 */     } catch (NumberFormatException e) {
/*  51 */       return fallback;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void propISet(String key, int i) {
/*  56 */     propSet(key, "" + i);
/*     */   }
/*     */   
/*     */   private static void read() {
/*     */     try {
/*  61 */       s.profileMap.clear();
/*  62 */       Json json = new Json((PATHS.local()).PROFILE.gets("Properties"));
/*  63 */       for (String ss : json.keys()) {
/*  64 */         s.profileMap.put(ss, json.value(ss));
/*     */       }
/*     */     }
/*  67 */     catch (Exception e) {
/*  68 */       e.printStackTrace(System.out);
/*  69 */       s.profileMap.clear();
/*     */       try {
/*  71 */         if (!(PATHS.local()).PROFILE.exists("Properties"))
/*  72 */           (PATHS.local()).PROFILE.create("Properties"); 
/*  73 */       } catch (Exception ee) {
/*  74 */         ee.printStackTrace();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void flush() {
/*  80 */     if (!s.dirty)
/*     */       return; 
/*  82 */     s.dirty = false;
/*     */     try {
/*  84 */       JsonE j = new JsonE();
/*  85 */       for (String ss : s.profileMap.keysSorted()) {
/*  86 */         j.add(ss, (String)s.profileMap.get(ss));
/*     */       }
/*     */       
/*  89 */       if (!(PATHS.local()).PROFILE.exists("Properties"))
/*  90 */         (PATHS.local()).PROFILE.create("Properties"); 
/*  91 */       j.save((PATHS.local()).PROFILE.get("Properties"));
/*  92 */     } catch (Exception e) {
/*  93 */       e.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void save(FilePutter file) {
/*  99 */     file.i(this.gameMap.size());
/* 100 */     for (String s : this.gameMap.keys()) {
/* 101 */       file.chars(s);
/* 102 */       file.chars((CharSequence)this.gameMap.get(s));
/*     */     } 
/* 104 */     flush();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void load(FileGetter file) throws IOException {
/* 109 */     this.gameMap.clear();
/* 110 */     int am = file.i();
/* 111 */     for (int i = 0; i < am; i++) {
/* 112 */       String k = file.chars();
/* 113 */       String v = file.chars();
/* 114 */       this.gameMap.put(k, v);
/*     */     } 
/* 116 */     read();
/*     */   }
/*     */   
/*     */   public static final class PropGame
/*     */   {
/*     */     private final String prefix;
/*     */     
/*     */     PropGame(String prefix) {
/* 124 */       this.prefix = prefix;
/*     */     }
/*     */     
/*     */     public int i(String key, int fallback) {
/* 128 */       String kk = chars(this.prefix + "_" + this.prefix);
/* 129 */       if (kk == null)
/* 130 */         return fallback; 
/*     */       try {
/* 132 */         int r = Integer.parseInt(kk);
/* 133 */         return r;
/* 134 */       } catch (NumberFormatException e) {
/* 135 */         return fallback;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void setI(String key, int i) {
/* 140 */       charsSet(this.prefix + "_" + this.prefix, "" + i);
/*     */     }
/*     */     
/*     */     public String chars(String key) {
/* 144 */       if (PROP.s.gameMap.containsKey(key))
/* 145 */         return (String)PROP.s.gameMap.get(key); 
/* 146 */       return null;
/*     */     }
/*     */     
/*     */     public void charsSet(String key, String value) {
/* 150 */       PROP.s.gameMap.putReplace(key, value);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\save\PROP.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */