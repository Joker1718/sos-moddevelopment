/*     */ package init.paths;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.nio.file.FileSystems;
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import snake2d.Errors;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PATHS
/*     */ {
/*     */   static PATHS i;
/*  34 */   static final String s = FileSystems.getDefault().getSeparator();
/*     */   
/*     */   final LIST<Path> paths;
/*     */   
/*     */   private final LIST<ModInfo> mods;
/*     */   
/*     */   final int modHash;
/*     */   
/*     */   final int textureSize;
/*     */   
/*     */   static PATHS_LOCAL local;
/*     */   
/*     */   private final PATHS_MISC misc;
/*     */   
/*     */   private final PATHS_BASE BASE;
/*     */   
/*     */   private final PATH INIT;
/*     */   
/*     */   private final ResFolder SETTLEMENT;
/*     */   private final ResFolder PLAYER;
/*     */   private final PATH INIT_SETTLEMENT;
/*     */   private final PATH INIT_WORLD;
/*     */   private final ResFolder WORLD;
/*     */   private final ResFolder CONFIG;
/*     */   private final PATHS_AUDIO AUDIO;
/*     */   private final PATH TEXT;
/*     */   private final PATH TEXT_MISC;
/*     */   private final PATH TEXT_NAMES;
/*     */   private final PATH TEXT_SETTLEMENT;
/*     */   private final ResFolder RACE;
/*     */   private final ResFolder EVENT;
/*     */   private final PATH TEXT_WORLD;
/*     */   private final PATH DICTIONARY;
/*     */   private final PATH SPRITE;
/*     */   private final PATH SPRITE_SETTLEMENT;
/*     */   private final PATH SPRITE_SETTLEMENT_MAP;
/*     */   private final PATH SPRITE_WORLD;
/*     */   private final PATH SPRITE_WORLD_MAP;
/*     */   private final PATH SPRITE_GAME;
/*     */   private final PATH SPRITE_UI;
/*     */   private final ResFolder STATS;
/*     */   private final Script SCRIPT;
/*     */   
/*     */   private PATHS(String[] mm, String lang, boolean easy) {
/*  78 */     Path root = FileSystems.getDefault().getPath("", new String[0]);
/*  79 */     Path base = Util.checkHard(root, "base");
/*  80 */     Path res = null;
/*  81 */     if (!Files.exists(root.resolve("zipdata"), new java.nio.file.LinkOption[0])) {
/*  82 */       res = getFromZip("data");
/*     */     } else {
/*  84 */       res = Util.checkHard(root, "zipdata");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  90 */     PATHS.i = this;
/*  91 */     LinkedList<Path> paths = new LinkedList();
/*  92 */     LinkedList<ModInfo> mods = new LinkedList();
/*     */     
/*  94 */     LOG.ln("INITING PATHS");
/*     */ 
/*     */     
/*  97 */     int tz = 4096;
/*  98 */     LOG.ln("MODS");
/*  99 */     String sss = ""; byte b; int i; String[] arrayOfString;
/* 100 */     for (i = (arrayOfString = mm).length, b = 0; b < i; ) { String m = arrayOfString[b];
/*     */       
/*     */       try {
/* 103 */         ModInfo modInfo = new ModInfo(m);
/* 104 */         mods.add(modInfo);
/* 105 */         sss = sss + sss + modInfo.name;
/* 106 */         tz = Math.max(modInfo.TEXTURE_CACHE_SIZE, tz);
/* 107 */         LOG.ln(modInfo.name + " " + modInfo.name + " " + modInfo.majorVersion);
/* 108 */         paths.add(modInfo.getModFolder());
/* 109 */       } catch (ModInfoException e) {
/* 110 */         LOG.err("Shitty mod: " + m + " " + System.lineSeparator() + " " + e.getMessage());
/*     */       } 
/*     */       
/* 113 */       if (lang != null) {
/* 114 */         for (Path p : paths) {
/* 115 */           PATH path = new VanillaOnly(p, s, false);
/* 116 */           if (path.existsFolder("langs")) {
/* 117 */             path = path.getFolder("langs");
/* 118 */             if (path.existsFolder(lang)) {
/* 119 */               paths.add(path.getFolder("lang").get());
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }
/*     */       
/*     */       b++; }
/*     */ 
/*     */     
/* 128 */     this.modHash = sss.hashCode();
/* 129 */     this.textureSize = tz;
/* 130 */     LOG.ln("hash: " + this.modHash);
/* 131 */     LOG.ln("texture cache: " + tz);
/*     */     
/* 133 */     this.BASE = new PATHS_BASE(root, base, res);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     if (lang != null) {
/* 139 */       Path zip = getFromZip("locale");
/* 140 */       PATH path = new VanillaOnly(zip, s, false);
/* 141 */       PATH p = path.getFolder("langs");
/*     */       
/* 143 */       if (p.exists(lang)) {
/* 144 */         p = p.getFolder(lang);
/* 145 */         Json j = new Json(p.gets("_Info.txt"));
/* 146 */         String fi = j.text("CHARSET");
/* 147 */         int tzz = j.has("TEXTURE_CACHE_SIZE") ? j.i("TEXTURE_CACHE_SIZE") : 0;
/* 148 */         if (tzz > tz)
/* 149 */           tzz = tz; 
/* 150 */         Path pFont = path.getFolder("chars").getFolder(fi).get();
/* 151 */         Path pLang = p.get();
/*     */         
/* 153 */         paths.add(pLang);
/* 154 */         paths.add(pFont);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 160 */     if (lang == null && easy) {
/* 161 */       paths.add(this.BASE.MODS.getFolder("easy").get());
/*     */     }
/*     */     
/* 164 */     Path data = Util.checkHard(res, "data");
/*     */     
/* 166 */     paths.add(data);
/*     */ 
/*     */ 
/*     */     
/* 170 */     this.paths = (LIST<Path>)new ArrayList((Iterable)paths);
/* 171 */     this.mods = (LIST<ModInfo>)new ArrayList((Iterable)mods);
/* 172 */     LOG.ln("PATHS");
/* 173 */     for (Path p : paths)
/* 174 */       LOG.ln(p.toAbsolutePath()); 
/* 175 */     LOG.ln();
/*     */     
/* 177 */     this.misc = new PATHS_MISC();
/*     */     
/* 179 */     PATH A = new Normal("assets", s);
/*     */ 
/*     */ 
/*     */     
/* 183 */     this.INIT = A.getFolder("init", ".txt");
/*     */     
/* 185 */     this.INIT_SETTLEMENT = this.INIT.getFolder("settlement");
/* 186 */     this.INIT_WORLD = this.INIT.getFolder("world");
/* 187 */     this.AUDIO = new PATHS_AUDIO();
/*     */     
/* 189 */     this.TEXT = A.getFolder("text", ".txt");
/* 190 */     this.TEXT_MISC = this.TEXT.getFolder("misc");
/* 191 */     this.DICTIONARY = this.TEXT.getFolder("dictionary");
/* 192 */     this.TEXT_NAMES = this.TEXT.getFolder("names");
/* 193 */     this.TEXT_SETTLEMENT = this.TEXT.getFolder("settlement");
/*     */     
/* 195 */     this.TEXT_WORLD = this.TEXT.getFolder("world");
/* 196 */     this.SPRITE = A.getFolder("sprite", ".png");
/* 197 */     this.SETTLEMENT = new ResFolder("settlement", true);
/* 198 */     this.PLAYER = new ResFolder("player", false);
/* 199 */     this.SPRITE_SETTLEMENT = this.SPRITE.getFolder("settlement");
/* 200 */     this.CONFIG = new ResFolder("config", false);
/* 201 */     this.SPRITE_SETTLEMENT_MAP = this.SPRITE_SETTLEMENT.getFolder("map");
/* 202 */     this.SPRITE_WORLD = this.SPRITE.getFolder("world");
/* 203 */     this.SPRITE_WORLD_MAP = this.SPRITE_WORLD.getFolder("map");
/* 204 */     this.SPRITE_UI = this.SPRITE.getFolder("ui");
/* 205 */     this.SPRITE_GAME = this.SPRITE.getFolder("game");
/*     */     
/* 207 */     this.SCRIPT = new Script(base);
/*     */     
/* 209 */     this.WORLD = new ResFolder("world", true);
/* 210 */     this.RACE = new ResFolder("race", true);
/* 211 */     this.STATS = new ResFolder("stats", false);
/* 212 */     this.EVENT = new ResFolder("event", false);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean inited() {
/* 217 */     return (i != null);
/*     */   }
/*     */   
/* 220 */   private static KeyMap<Path> zips = new KeyMap();
/*     */   
/*     */   private static Path getFromZip(String file) {
/* 223 */     if (zips.containsKey(file))
/* 224 */       return (Path)zips.get(file); 
/* 225 */     Path root = FileSystems.getDefault().getPath("", new String[0]);
/* 226 */     Path base = Util.checkHard(root, "base");
/*     */     
/* 228 */     Path zip = Util.checkHard(base, file + ".zip");
/* 229 */     Map<String, String> env = new HashMap<>();
/* 230 */     env.put("read", "true");
/* 231 */     URI uri = zip.toUri();
/* 232 */     String path = "jar:" + String.valueOf(uri);
/*     */ 
/*     */     
/*     */     try {
/* 236 */       Path res = FileSystems.newFileSystem(URI.create(path), env).getRootDirectories().iterator().next();
/* 237 */       Util.checkHard(res, "");
/* 238 */       zips.put(file, res);
/* 239 */       return res;
/* 240 */     } catch (Exception e) {
/* 241 */       System.err.println("Game resources are corrupted. Reinstall the game.");
/* 242 */       e.printStackTrace();
/* 243 */       Util.abort(String.valueOf(zip));
/*     */       
/* 245 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getSavePath(Path pp) {
/* 251 */     String path = (new File(String.valueOf(pp.toAbsolutePath()))).getAbsolutePath();
/* 252 */     String sd = s + "assets" + s;
/* 253 */     if (path.contains(sd)) {
/* 254 */       return path.substring(path.lastIndexOf(sd) + sd.length(), path.length());
/*     */     }
/* 256 */     LOG.ln(path + " no 'assets' " + path + " " + FileSystems.getDefault().getSeparator());
/* 257 */     return path;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void init(String[] mods, String lang, boolean easy) {}
/*     */ 
/*     */   
/*     */   public static int textureSize() {
/* 265 */     return i.textureSize;
/*     */   }
/*     */   
/*     */   public static PATHS_LOCAL local() {
/* 269 */     if (local == null)
/* 270 */       local = new PATHS_LOCAL(); 
/* 271 */     return local;
/*     */   }
/*     */   
/*     */   public static PATHS_BASE BASE() {
/* 275 */     return i.BASE;
/*     */   }
/*     */   
/*     */   public static PATHS_MISC MISC() {
/* 279 */     return i.misc;
/*     */   }
/*     */   
/*     */   public static PATH INIT() {
/* 283 */     return i.INIT;
/*     */   }
/*     */   
/*     */   public static PATH INIT_SETTLEMENT() {
/* 287 */     return i.INIT_SETTLEMENT;
/*     */   }
/*     */   
/*     */   public static ResFolder SETT() {
/* 291 */     return i.SETTLEMENT;
/*     */   }
/*     */   
/*     */   public static ResFolder PLAYER() {
/* 295 */     return i.PLAYER;
/*     */   }
/*     */   
/*     */   public static ResFolder WORLD() {
/* 299 */     return i.WORLD;
/*     */   }
/*     */   
/*     */   public static ResFolder EVENT() {
/* 303 */     return i.EVENT;
/*     */   }
/*     */   
/*     */   public static PATH INIT_WORLD() {
/* 307 */     return i.INIT_WORLD;
/*     */   }
/*     */   
/*     */   public static PATH SPRITE_WORLD() {
/* 311 */     return i.SPRITE_WORLD;
/*     */   }
/*     */   
/*     */   public static PATH SPRITE_WORLD_MAP() {
/* 315 */     return i.SPRITE_WORLD_MAP;
/*     */   }
/*     */   
/*     */   public static PATH TEXT_WORLD() {
/* 319 */     return i.TEXT_WORLD;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ResFolder CONFIG() {
/* 324 */     return i.CONFIG;
/*     */   }
/*     */   
/*     */   public static PATHS_AUDIO AUDIO() {
/* 328 */     return i.AUDIO;
/*     */   }
/*     */   
/*     */   public static PATH TEXT() {
/* 332 */     return i.TEXT;
/*     */   }
/*     */   
/*     */   public static PATH TEXT_MISC() {
/* 336 */     return i.TEXT_MISC;
/*     */   }
/*     */   
/*     */   public static PATH TEXT_SETTLEMENT() {
/* 340 */     return i.TEXT_SETTLEMENT;
/*     */   }
/*     */   
/*     */   public static ResFolder RACE() {
/* 344 */     return i.RACE;
/*     */   }
/*     */   
/*     */   public static ResFolder STATS() {
/* 348 */     return i.STATS;
/*     */   }
/*     */   
/*     */   public static PATH SPRITE() {
/* 352 */     return i.SPRITE;
/*     */   }
/*     */   
/*     */   public static PATH SPRITE_UI() {
/* 356 */     return i.SPRITE_UI;
/*     */   }
/*     */   
/*     */   public static int modHash() {
/* 360 */     return i.modHash;
/*     */   }
/*     */ 
/*     */   
/*     */   public static PATH SPRITE_SETTLEMENT() {
/* 365 */     return i.SPRITE_SETTLEMENT;
/*     */   }
/*     */   
/*     */   public static PATH SPRITE_SETTLEMENT_MAP() {
/* 369 */     return i.SPRITE_SETTLEMENT_MAP;
/*     */   }
/*     */ 
/*     */   
/*     */   public static PATH SPRITE_GAME() {
/* 374 */     return i.SPRITE_GAME;
/*     */   }
/*     */   
/*     */   public static PATH DICTIONARY() {
/* 378 */     return i.DICTIONARY;
/*     */   }
/*     */   
/*     */   public static PATH NAMES() {
/* 382 */     return i.TEXT_NAMES;
/*     */   }
/*     */   
/*     */   public static PATH CACHE_DATA() {
/* 386 */     return local.CACHE_DATA;
/*     */   }
/*     */   
/*     */   public static PATH CACHE_TEXTURE() {
/* 390 */     return local.CACHE_TEXTURE;
/*     */   }
/*     */   
/*     */   public static Script SCRIPT() {
/* 394 */     return i.SCRIPT;
/*     */   }
/*     */   
/*     */   public static final class PATHS_AUDIO
/*     */   {
/* 399 */     private final PATH sound = new Normal("assets" + PATHS.s + "audio", PATHS.s);
/* 400 */     public final PATH mono = this.sound.getFolder("mono", ".wav");
/* 401 */     public final PATH music = this.sound.getFolder("music", ".ogg");
/* 402 */     public final PATH ambience = this.sound.getFolder("ambience", ".ogg");
/* 403 */     public final PATH config = this.sound.getFolder("config", ".txt");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class PATHS_BASE
/*     */   {
/*     */     public final PATH DATA;
/*     */ 
/*     */     
/*     */     public final PATH TXT;
/*     */ 
/*     */     
/*     */     public final PATH LAUNCHER;
/*     */ 
/*     */     
/*     */     public final PATH MODS;
/*     */ 
/*     */     
/* 423 */     public static final String FOLDER = (new File("")).getAbsolutePath() + (new File("")).getAbsolutePath() + "base" + File.separator;
/* 424 */     public static final String ICON_FOLDER = FOLDER + "icons" + FOLDER;
/* 425 */     public static final String PRELOADER = FOLDER + "PreLoader.png";
/*     */ 
/*     */ 
/*     */     
/*     */     PATHS_BASE(Path root, Path base, Path res) {
/* 430 */       PATH ROOT = new VanillaOnly(res.resolve("base"), PATHS.s, false);
/* 431 */       this.DATA = ROOT.getFolder("data", ".txt", false);
/* 432 */       this.LAUNCHER = ROOT.getFolder("launcher", ".png", false);
/* 433 */       this.MODS = new VanillaOnly(res.resolve("mods"), PATHS.s, false);
/* 434 */       this.TXT = ROOT.getFolder("txt", ".txt", false);
/*     */     }
/*     */     
/*     */     public static PATH langs() {
/* 438 */       Path zip = PATHS.getFromZip("locale");
/* 439 */       PATH path = new VanillaOnly(zip, PATHS.s, false);
/* 440 */       return path.getFolder("langs", ".txt");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static final class PATHS_LOCAL
/*     */   {
/*     */     public final PATH ROOT;
/*     */     
/*     */     public final PATH SETTINGS;
/*     */     
/*     */     public final PATH SCREENSHOT;
/*     */     
/*     */     public final PATH SCREENSHOT_S;
/*     */     
/*     */     public final PATH VIDEO;
/*     */     
/*     */     public final PATH LOGS;
/*     */     
/*     */     private PATH SAVE;
/*     */     
/*     */     public final PATH MODS;
/*     */     public final PATH PROFILE;
/*     */     public final PATH SAVE_CAMPAIGN;
/*     */     final PATH CACHE_DATA;
/*     */     final PATH CACHE_TEXTURE;
/*     */     
/*     */     PATHS_LOCAL() {
/* 468 */       this.ROOT = new VanillaOnly(Paths.get(Util.getLocal(), new String[0]), PATHS.s, true);
/*     */       
/* 470 */       if (!Files.isWritable(this.ROOT.get())) {
/* 471 */         throw new Errors.GameError("No read/write access was granted. Try to enable administrator rights or read and write rights for: " + String.valueOf(this.ROOT.get().toAbsolutePath()));
/*     */       }
/* 473 */       this.SETTINGS = this.ROOT.getFolder("settings", ".txt", true);
/* 474 */       this.SCREENSHOT = this.ROOT.getFolder("screenshots", ".png", true);
/* 475 */       this.SCREENSHOT_S = this.SCREENSHOT.getFolder("super", ".jpg", true);
/* 476 */       this.VIDEO = this.SCREENSHOT.getFolder("video", ".jpg", true);
/* 477 */       this.LOGS = this.ROOT.getFolder("logs", ".txt", true);
/* 478 */       PATH SAVES = this.ROOT.getFolder("saves", true);
/* 479 */       this.MODS = getMods(this.ROOT);
/* 480 */       this.PROFILE = SAVES.getFolder("profile", ".txt", true);
/* 481 */       this.SAVE = SAVES.getFolder("saves", ".save", true);
/* 482 */       this.SAVE_CAMPAIGN = SAVES.getFolder("campaign", ".save", true);
/* 483 */       PATH cache = this.ROOT.getFolder("cache", PATHS.s, true);
/*     */ 
/*     */       
/* 486 */       this.CACHE_DATA = cache.getFolder("data", ".cachedata", true);
/* 487 */       this.CACHE_TEXTURE = cache.getFolder("texture", ".png", true);
/*     */     }
/*     */     
/*     */     public void setCustomSaveFolder(String folder) {
/* 491 */       this.SAVE = this.ROOT.getFolder(folder, ".save", true);
/*     */     }
/*     */     
/*     */     public PATH save() {
/* 495 */       return this.SAVE;
/*     */     }
/*     */     
/*     */     private static PATH getMods(PATH ROOT) {
/* 499 */       PATH p = ROOT.getFolder("mods", true);
/* 500 */       Path steam = getSteamPath();
/* 501 */       if (steam != null) {
/* 502 */         LOG.ln("Steam mod folder found: " + String.valueOf(steam.toAbsolutePath()));
/* 503 */         ArrayList arrayList1 = new ArrayList((Object[])new Path[] { p.get().toAbsolutePath(), steam });
/* 504 */         return new Normal((LIST<Path>)arrayList1, "", PATHS.s);
/*     */       } 
/*     */       
/* 507 */       ArrayList arrayList = new ArrayList(p.get());
/* 508 */       return new Normal((LIST<Path>)arrayList, "", PATHS.s);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     private static Path getSteamPath() {
/* 514 */       Path steam = Paths.get("", new String[0]).toAbsolutePath();
/* 515 */       if (PATHS.isDevelop()) {
/* 516 */         steam = Paths.get("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Songs of Syx", new String[0]);
/* 517 */         if (!Files.exists(steam, new java.nio.file.LinkOption[0]))
/* 518 */           return null; 
/*     */       } 
/* 520 */       while (steam.getParent() != null) {
/* 521 */         steam = steam.getParent();
/* 522 */         if (String.valueOf(steam.getFileName()).contains("steamapps")) {
/*     */           
/* 524 */           Path t = steam.resolve("workshop").resolve("content").resolve("1162750");
/*     */           
/* 526 */           if (Files.exists(t, new java.nio.file.LinkOption[0]) && Files.isDirectory(t, new java.nio.file.LinkOption[0])) {
/* 527 */             return t;
/*     */           }
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 534 */       return null;
/*     */     }
/*     */     
/*     */     public HashSet<String> campaignsUnlocked() {
/* 538 */       HashSet<String> res = new HashSet<>();
/*     */       try {
/* 540 */         if (!this.PROFILE.exists("Campaigns"))
/* 541 */           this.PROFILE.create("Campaigns"); 
/* 542 */         Json j = new Json(this.PROFILE.gets("Campaigns"));
/* 543 */         String[] ss = new String[0];
/* 544 */         if (j.has("UNLOCKED"))
/* 545 */           ss = j.values("UNLOCKED");  byte b; int i;
/*     */         String[] arrayOfString1;
/* 547 */         for (i = (arrayOfString1 = ss).length, b = 0; b < i; ) { String k = arrayOfString1[b];
/* 548 */           res.add(k); b++; } 
/* 549 */       } catch (Exception e) {
/* 550 */         res.clear();
/* 551 */         e.printStackTrace();
/*     */       } 
/*     */       
/* 554 */       return res;
/*     */     }
/*     */     
/*     */     public void campaignFinish(String key) {
/* 558 */       HashSet<String> res = campaignsUnlocked();
/* 559 */       res.add(key);
/* 560 */       JsonE j = new JsonE();
/* 561 */       String[] ss = new String[res.size()];
/* 562 */       int i = 0;
/* 563 */       for (String s : res) {
/* 564 */         ss[i++] = s;
/*     */       }
/* 566 */       j.add("UNLOCKED", ss);
/* 567 */       j.save(this.PROFILE.get("Campaigns"));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isDevelop() {
/* 573 */     Path steam = Paths.get("", new String[0]).toAbsolutePath();
/* 574 */     return Files.exists(steam.resolve("zipdata"), new java.nio.file.LinkOption[0]);
/*     */   }
/*     */   
/*     */   public static boolean isSteam() {
/* 578 */     Path steam = Paths.get("", new String[0]).toAbsolutePath();
/* 579 */     return String.valueOf(steam).contains("steamapps");
/*     */   }
/*     */   
/*     */   public static final class PATHS_MISC
/*     */   {
/* 584 */     public final PATH CAMPAIGNS = new ModOnly("campaigns", ".txt", true);
/* 585 */     public final PATH SAVES = new ModOnly("saves", PATHS.s, true);
/* 586 */     public final PATH EXAMPLES = this.SAVES.getFolder("examples", ".save", true);
/* 587 */     public final PATH CUSTOM = this.SAVES.getFolder("custom", ".save", true);
/* 588 */     public final PATH BATTLE = this.SAVES.getFolder("battles", ".save", true);
/* 589 */     public final PATH SAVES_CAMPAIGN = this.SAVES.getFolder("campaign", ".save", true);
/*     */     public final boolean hasTutorial;
/*     */     
/*     */     PATHS_MISC() {
/* 593 */       this.hasTutorial = this.SAVES.exists("_Tutorial");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class Script
/*     */   {
/*     */     public final PATH jar;
/*     */ 
/*     */     
/* 604 */     public final PATHS.ResFolder path = new PATHS.ResFolder("script", false);
/*     */     public final String bb;
/*     */     
/*     */     Script(Path base) {
/* 608 */       ArrayListGrower<Path> paths = new ArrayListGrower();
/* 609 */       paths.add(base);
/*     */       
/* 611 */       this.bb = String.valueOf(base.toAbsolutePath());
/* 612 */       for (int i = 0; i < PATHS.i.paths.size(); i++) {
/* 613 */         paths.add(PATHS.i.paths.get(i));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 618 */       VirtualFolder f = new VirtualFolder((LIST<Path>)paths, "script" + PATHS.s);
/*     */ 
/*     */       
/* 621 */       this.jar = new Normal(f, ".jar");
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public LIST<String> modClasspaths() {
/* 627 */       LinkedList<String> mm = new LinkedList(); byte b; int i; String[] arrayOfString;
/* 628 */       for (i = (arrayOfString = this.jar.getFilesOrdered()).length, b = 0; b < i; ) { String m = arrayOfString[b];
/*     */         
/* 630 */         mm.add(this.jar.get(m).toAbsolutePath().toString()); b++; }
/*     */       
/* 632 */       return (LIST<String>)mm;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean hasExternal(String[] paths) {
/* 637 */       return (external(paths).size() > 0);
/*     */     }
/*     */     
/*     */     public LIST<String> external(String[] paths) {
/* 641 */       LinkedList<String> mm = new LinkedList(); byte b; int i; String[] arrayOfString;
/* 642 */       for (i = (arrayOfString = paths).length, b = 0; b < i; ) { String ss = arrayOfString[b];
/*     */         try {
/* 644 */           ModInfo info = new ModInfo(ss);
/*     */           
/* 646 */           if (info.absolutePath.indexOf(this.bb) < 0) {
/* 647 */             File f = new File(info.absolutePath + info.absolutePath + "V" + PATHS.s + info.majorVersion + "script" + PATHS.s);
/*     */             
/* 649 */             LOG.ln(info.absolutePath + " " + info.absolutePath + " " + f.getAbsolutePath());
/* 650 */             if (f.exists() && Util.listFiles(f.toPath()).size() > 0) {
/* 651 */               mm.add(f.getAbsolutePath());
/*     */             }
/*     */           } 
/* 654 */         } catch (ModInfoException e) {
/*     */           
/* 656 */           e.printStackTrace();
/*     */         } 
/*     */         
/*     */         b++; }
/*     */       
/* 661 */       return (LIST<String>)mm;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static LIST<ModInfo> currentMods() {
/* 668 */     return i.mods;
/*     */   }
/*     */   
/*     */   public static class ResFolder
/*     */   {
/*     */     public final PATH init;
/*     */     public final PATH text;
/*     */     public final PATH sprite;
/*     */     
/*     */     public ResFolder(String key, boolean spirte) {
/* 678 */       this.init = PATHS.INIT().getFolder(key);
/* 679 */       this.text = PATHS.TEXT().getFolder(key);
/* 680 */       this.sprite = spirte ? PATHS.SPRITE().getFolder(key) : null;
/*     */     }
/*     */     
/*     */     private ResFolder(PATH init, PATH text, PATH sprite) {
/* 684 */       this.init = init;
/* 685 */       this.text = text;
/* 686 */       this.sprite = sprite;
/*     */     }
/*     */     
/*     */     public ResFolder folder(String name) {
/* 690 */       PATH init = (this.init != null && this.init.existsFolder(name)) ? this.init.getFolder(name) : null;
/* 691 */       PATH text = (this.text != null && this.text.existsFolder(name)) ? this.text.getFolder(name) : null;
/* 692 */       PATH sprite = (this.sprite != null && this.sprite.existsFolder(name)) ? this.sprite.getFolder(name) : null;
/* 693 */       return new ResFolder(init, text, sprite);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\PATHS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */