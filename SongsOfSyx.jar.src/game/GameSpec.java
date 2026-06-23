/*     */ package game;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import init.paths.ModInfo;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import init.type.HTYPES;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Path;
/*     */ import script.ScriptEngine;
/*     */ import script.ScriptLoad;
/*     */ import settlement.stats.POP;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ import world.WORLD;
/*     */ import world.region.RD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class GameSpec
/*     */ {
/*     */   public boolean fubar;
/*     */   public final int version;
/*     */   public final double playSeconds;
/*     */   public final int population;
/*     */   public final int enemies;
/*     */   public final int regions;
/*     */   public final int regPop;
/*     */   public final CharSequence race;
/*     */   public final CharSequence city;
/*     */   public final CharSequence ruler;
/*     */   public final CharSequence desc;
/*     */   public final String[] scripts;
/*     */   public final String[] mods;
/*     */   public final int wx;
/*     */   public final int wy;
/*     */   public final String races;
/*     */   public final String rooms;
/*     */   public final String resources;
/*     */   public final String industries;
/*     */   private CharSequence prob;
/*     */   private CharSequence warn;
/*     */   private boolean hasCheck;
/*     */   
/*     */   private GameSpec(String... scripts) {
/* 170 */     this.hasCheck = false; this.fubar = true; this.scripts = scripts; this.version = VERSION.VERSION; this.playSeconds = 0.0D; this.population = 0; this.regions = 0; this.regPop = 0; this.enemies = 0; this.race = "?"; this.city = "?"; this.ruler = "?"; this.desc = "?"; this.mods = mods(); this.wx = (Config.world()).WORLD_SIZE; this.wy = (Config.world()).WORLD_SIZE; this.races = getResources("race"); this.rooms = getResources("room"); this.resources = getResources("resource"); this.industries = getResourcesArray("room", "INDUSTRY"); } private GameSpec(FileGetter f, String... scripts) throws IOException { this.hasCheck = false; int pos = f.getPosition() + f.i() + 4; this.version = f.i(); this.playSeconds = f.d(); this.population = f.i(); this.enemies = f.i(); this.regions = f.i(); this.regPop = f.i(); this.wx = f.i(); this.wy = f.i(); this.race = f.chars(); this.city = f.chars(); this.ruler = f.chars(); this.desc = f.chars(); this.mods = f.charss(); String[] ss = f.charss(); this.scripts = (scripts.length > 0) ? scripts : ss; this.races = f.chars(); this.rooms = f.chars(); this.resources = f.chars(); this.industries = f.chars(); if (f.getPosition() != pos) { this.fubar = true; f.setPosition(pos); }  }
/*     */   public static void save(FilePutter f) { int pos = f.getPosition(); f.i(0); f.i(VERSION.VERSION); f.d((int)TIME.playedGame()); f.i(POP.tot(null, null)); f.i(STATS.POP().pop(HTYPES.ENEMY())); f.i(FACTIONS.player().realm().regions() - 1); f.i((RD.RACES()).population.faction().get(FACTIONS.player())); f.i(WORLD.TWIDTH()); f.i(WORLD.THEIGHT()); f.chars(String.valueOf((FACTIONS.player().race()).info.name)); f.chars(String.valueOf((FACTIONS.player()).name)); f.chars(String.valueOf((FACTIONS.player()).rulerName)); f.chars(String.valueOf((FACTIONS.player()).desc)); f.charss((CharSequence[])mods()); f.charss((CharSequence[])GAME.script().currentScripts()); f.chars(getResources("race")); f.chars(getResources("room")); f.chars(getResources("resource")); f.chars(getResourcesArray("room", "INDUSTRY")); int le = f.getPosition() - pos - 4; f.setAtPosition(pos, le); }
/* 172 */   public static GameSpec get(String... scripts) { return new GameSpec(scripts); } private static CharSequence ¤¤version = "¤Version mismatch! Save is made with major game version: {0}. Try downgrading the game to this version. The current game version is: ";
/* 173 */   public static GameSpec get(FileGetter f, String... scripts) { try { GameSpec s = new GameSpec(f, scripts); return s; } catch (Exception e) { return new GameSpec(scripts); }  } public static GameSpec get(Path path) { try { FileGetter g = new FileGetter(path, true); GameSpec s = new GameSpec(g, new String[0]); return s; } catch (Exception e) { return new GameSpec(new String[0]); }  } private static String[] mods() { String[] mods = new String[PATHS.currentMods().size()]; for (int i = 0; i < PATHS.currentMods().size(); i++) mods[i] = "'" + ((ModInfo)PATHS.currentMods().get(i)).name + "', version: " + ((ModInfo)PATHS.currentMods().get(i)).version;  return mods; } private static CharSequence ¤¤race = "¤The amount of races does not match the current configuration.";
/* 174 */   private static CharSequence ¤¤room = "¤The amount of rooms does not match the current configuration.";
/* 175 */   private static CharSequence ¤¤industries = "¤The amount of industries does not match the current configuration.";
/* 176 */   private static CharSequence ¤¤resources = "¤The amount of resources does not match the current configuration.";
/* 177 */   private static CharSequence ¤¤modOther = "¤The save can not be loaded as it was made with another mod configuration:";
/* 178 */   private static CharSequence ¤¤modNone = "¤The save can not be loaded as it was made with an un-modified game. Disable all mods in the launcher to load the game.";
/* 179 */   private static CharSequence ¤¤script = "¤The script: {0} that the game was saved with can not be found.";
/* 180 */   private static CharSequence ¤¤fubar = "The save-file is corrupt.";
/* 181 */   private static CharSequence ¤¤mod2 = "¤Try to enable the same mods, in the same order, in the launcher and reload the save.";
/* 182 */   private static CharSequence ¤¤underlaying = "¤UnderLaying problem:";
/*     */   
/* 184 */   private static CharSequence ¤¤mods = "Game was saved with other mods than those currently enabled.";
/*     */   
/*     */   static {
/* 187 */     D.ts(GameSpec.class);
/*     */   }
/*     */   
/*     */   public CharSequence warning() {
/* 191 */     if (!this.hasCheck) {
/* 192 */       this.hasCheck = true;
/* 193 */       this.warn = pwarning();
/* 194 */       this.prob = pproblem();
/*     */     } 
/* 196 */     return this.warn;
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence crashCause() {
/* 201 */     if (!this.hasCheck) {
/* 202 */       this.hasCheck = true;
/* 203 */       this.warn = pwarning();
/* 204 */       this.prob = pproblem();
/*     */     } 
/* 206 */     return this.prob;
/*     */   }
/*     */   
/*     */   public CharSequence pwarning() {
/* 210 */     if (this.fubar) {
/* 211 */       return ¤¤fubar;
/*     */     }
/* 213 */     if (VERSION.versionMajor(this.version) != 71) {
/* 214 */       return String.valueOf(Str.TMP.clear().add(¤¤version).insert(0, VERSION.versionMajor(this.version))) + " 71";
/*     */     }
/* 216 */     if (!modsEqual())
/* 217 */       return String.valueOf(Str.TMP.clear().add(¤¤mods)); 
/* 218 */     if (!this.races.equals(getResources("race"))) {
/* 219 */       return ¤¤race;
/*     */     }
/* 221 */     if (!this.rooms.equals(getResources("room"))) {
/* 222 */       modException(¤¤room);
/*     */     }
/* 224 */     if (!this.resources.equals(getResources("resource"))) {
/* 225 */       modException(¤¤resources);
/*     */     }
/* 227 */     if (this.industries != null && !this.industries.equals(getResourcesArray("room", "INDUSTRY")))
/* 228 */       return ¤¤industries; 
/* 229 */     KeyMap<String> avai = new KeyMap();
/* 230 */     for (ScriptLoad sc : ScriptEngine.getAll())
/* 231 */       avai.put(sc.key, sc.key);  byte b; int i; String[] arrayOfString;
/* 232 */     for (i = (arrayOfString = this.scripts).length, b = 0; b < i; ) { String sc = arrayOfString[b];
/* 233 */       if (!avai.containsKey(sc)) {
/* 234 */         return modException((CharSequence)Str.TMP.clear().add(¤¤script).insert(0, sc));
/*     */       }
/*     */       b++; }
/*     */     
/* 238 */     return null;
/*     */   }
/*     */   
/*     */   private boolean modsEqual() {
/* 242 */     String[] mm = mods();
/* 243 */     if (mm.length != this.mods.length)
/* 244 */       return false; 
/* 245 */     for (int i = 0; i < this.mods.length; i++) {
/* 246 */       if (!mm[i].equals(this.mods[i]))
/* 247 */         return false; 
/*     */     } 
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CharSequence pproblem() {
/* 256 */     if (this.fubar) {
/* 257 */       return ¤¤fubar;
/*     */     }
/*     */     
/* 260 */     if (VERSION.versionMajor(this.version) != 71) {
/* 261 */       return String.valueOf(Str.TMP.clear().add(¤¤version).insert(0, VERSION.versionMajor(this.version))) + " 71";
/*     */     }
/* 263 */     if (!this.races.equals(getResources("race"))) {
/* 264 */       return modException(¤¤race);
/*     */     }
/* 266 */     if (!this.rooms.equals(getResources("room"))) {
/* 267 */       return modException(¤¤room);
/*     */     }
/* 269 */     if (!this.resources.equals(getResources("resource"))) {
/* 270 */       return modException(¤¤resources);
/*     */     }
/* 272 */     if (this.industries != null && !this.industries.equals(getResourcesArray("room", "INDUSTRY"))) {
/* 273 */       return modException(¤¤industries);
/*     */     }
/* 275 */     KeyMap<String> avai = new KeyMap();
/* 276 */     for (ScriptLoad sc : ScriptEngine.getAll())
/* 277 */       avai.put(sc.key, sc.key);  byte b; int i; String[] arrayOfString;
/* 278 */     for (i = (arrayOfString = this.scripts).length, b = 0; b < i; ) { String sc = arrayOfString[b];
/* 279 */       if (!avai.containsKey(sc))
/* 280 */         return modException((CharSequence)Str.TMP.clear().add(¤¤script).insert(0, sc)); 
/*     */       b++; }
/*     */     
/* 283 */     if (!modsEqual()) {
/* 284 */       Str s = Str.TMP;
/* 285 */       if (this.mods.length == 0) {
/* 286 */         s.add(¤¤modNone);
/*     */       } else {
/* 288 */         s.add(¤¤modOther);
/* 289 */         s.NL();
/* 290 */         s.NL(); String[] arrayOfString1;
/* 291 */         for (int j = (arrayOfString1 = this.mods).length; i < j; ) { String ss = arrayOfString1[i];
/* 292 */           s.add(ss);
/* 293 */           s.NL(); i++; }
/*     */         
/* 295 */         s.NL();
/* 296 */         s.add(¤¤mod2);
/*     */       } 
/* 298 */       return String.valueOf(s);
/*     */     } 
/* 300 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private CharSequence modException(CharSequence problem) {
/* 306 */     if (!modsEqual()) {
/* 307 */       Str s = Str.TMP;
/* 308 */       s.clear();
/*     */       
/* 310 */       if (this.mods.length == 0) {
/* 311 */         s.add(¤¤modNone);
/*     */       } else {
/* 313 */         s.add(¤¤modOther);
/* 314 */         s.NL();
/* 315 */         s.NL(); byte b; int i; String[] arrayOfString;
/* 316 */         for (i = (arrayOfString = this.mods).length, b = 0; b < i; ) { String ss = arrayOfString[b];
/* 317 */           s.add(ss);
/* 318 */           s.NL(); b++; }
/*     */         
/* 320 */         s.NL();
/* 321 */         s.add(¤¤mod2);
/*     */       } 
/* 323 */       s.NL();
/* 324 */       s.NL();
/* 325 */       s.add(¤¤underlaying);
/* 326 */       s.NL();
/* 327 */       s.add(problem);
/* 328 */       return String.valueOf(s);
/*     */     } 
/* 330 */     return String.valueOf(problem);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getResourcesArray(String init, String key) {
/* 336 */     String s = "";
/* 337 */     PATH p = PATHS.INIT().getFolder(init); byte b; int i; String[] arrayOfString;
/* 338 */     for (i = (arrayOfString = p.getFiles()).length, b = 0; b < i; ) { String k = arrayOfString[b];
/* 339 */       Json j = new Json(p.gets(k));
/* 340 */       if (j.has(key) && j.jsonsIs(key))
/* 341 */         s = s + s + k;  b++; }
/*     */     
/* 343 */     return s;
/*     */   }
/*     */   
/*     */   private static String getResources(String init) {
/* 347 */     String s = ""; byte b; int i; String[] arrayOfString;
/* 348 */     for (i = (arrayOfString = PATHS.INIT().getFolder(init).getFiles()).length, b = 0; b < i; ) { String k = arrayOfString[b];
/* 349 */       s = s + s; b++; }
/* 350 */      return s;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\GameSpec.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */