/*     */ package init.paths;
/*     */ 
/*     */ import java.nio.file.Files;
/*     */ import java.nio.file.Path;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.HashSet;
/*     */ import snake2d.Errors;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.file.JsonE;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PATHS_LOCAL
/*     */ {
/* 468 */   public final PATH ROOT = new VanillaOnly(Paths.get(Util.getLocal(), new String[0]), PATHS.s, true); public final PATH SETTINGS; public final PATH SCREENSHOT; public final PATH SCREENSHOT_S; public final PATH VIDEO; public final PATH LOGS;
/*     */   PATHS_LOCAL() {
/* 470 */     if (!Files.isWritable(this.ROOT.get())) {
/* 471 */       throw new Errors.GameError("No read/write access was granted. Try to enable administrator rights or read and write rights for: " + String.valueOf(this.ROOT.get().toAbsolutePath()));
/*     */     }
/* 473 */     this.SETTINGS = this.ROOT.getFolder("settings", ".txt", true);
/* 474 */     this.SCREENSHOT = this.ROOT.getFolder("screenshots", ".png", true);
/* 475 */     this.SCREENSHOT_S = this.SCREENSHOT.getFolder("super", ".jpg", true);
/* 476 */     this.VIDEO = this.SCREENSHOT.getFolder("video", ".jpg", true);
/* 477 */     this.LOGS = this.ROOT.getFolder("logs", ".txt", true);
/* 478 */     PATH SAVES = this.ROOT.getFolder("saves", true);
/* 479 */     this.MODS = getMods(this.ROOT);
/* 480 */     this.PROFILE = SAVES.getFolder("profile", ".txt", true);
/* 481 */     this.SAVE = SAVES.getFolder("saves", ".save", true);
/* 482 */     this.SAVE_CAMPAIGN = SAVES.getFolder("campaign", ".save", true);
/* 483 */     PATH cache = this.ROOT.getFolder("cache", PATHS.s, true);
/*     */ 
/*     */     
/* 486 */     this.CACHE_DATA = cache.getFolder("data", ".cachedata", true);
/* 487 */     this.CACHE_TEXTURE = cache.getFolder("texture", ".png", true);
/*     */   }
/*     */   private PATH SAVE; public final PATH MODS; public final PATH PROFILE; public final PATH SAVE_CAMPAIGN; final PATH CACHE_DATA; final PATH CACHE_TEXTURE;
/*     */   public void setCustomSaveFolder(String folder) {
/* 491 */     this.SAVE = this.ROOT.getFolder(folder, ".save", true);
/*     */   }
/*     */   
/*     */   public PATH save() {
/* 495 */     return this.SAVE;
/*     */   }
/*     */   
/*     */   private static PATH getMods(PATH ROOT) {
/* 499 */     PATH p = ROOT.getFolder("mods", true);
/* 500 */     Path steam = getSteamPath();
/* 501 */     if (steam != null) {
/* 502 */       LOG.ln("Steam mod folder found: " + String.valueOf(steam.toAbsolutePath()));
/* 503 */       ArrayList arrayList1 = new ArrayList((Object[])new Path[] { p.get().toAbsolutePath(), steam });
/* 504 */       return new Normal((LIST<Path>)arrayList1, "", PATHS.s);
/*     */     } 
/*     */     
/* 507 */     ArrayList arrayList = new ArrayList(p.get());
/* 508 */     return new Normal((LIST<Path>)arrayList, "", PATHS.s);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Path getSteamPath() {
/* 514 */     Path steam = Paths.get("", new String[0]).toAbsolutePath();
/* 515 */     if (PATHS.isDevelop()) {
/* 516 */       steam = Paths.get("C:\\Program Files (x86)\\Steam\\steamapps\\common\\Songs of Syx", new String[0]);
/* 517 */       if (!Files.exists(steam, new java.nio.file.LinkOption[0]))
/* 518 */         return null; 
/*     */     } 
/* 520 */     while (steam.getParent() != null) {
/* 521 */       steam = steam.getParent();
/* 522 */       if (String.valueOf(steam.getFileName()).contains("steamapps")) {
/*     */         
/* 524 */         Path t = steam.resolve("workshop").resolve("content").resolve("1162750");
/*     */         
/* 526 */         if (Files.exists(t, new java.nio.file.LinkOption[0]) && Files.isDirectory(t, new java.nio.file.LinkOption[0])) {
/* 527 */           return t;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 534 */     return null;
/*     */   }
/*     */   
/*     */   public HashSet<String> campaignsUnlocked() {
/* 538 */     HashSet<String> res = new HashSet<>();
/*     */     try {
/* 540 */       if (!this.PROFILE.exists("Campaigns"))
/* 541 */         this.PROFILE.create("Campaigns"); 
/* 542 */       Json j = new Json(this.PROFILE.gets("Campaigns"));
/* 543 */       String[] ss = new String[0];
/* 544 */       if (j.has("UNLOCKED"))
/* 545 */         ss = j.values("UNLOCKED");  byte b; int i;
/*     */       String[] arrayOfString1;
/* 547 */       for (i = (arrayOfString1 = ss).length, b = 0; b < i; ) { String k = arrayOfString1[b];
/* 548 */         res.add(k); b++; } 
/* 549 */     } catch (Exception e) {
/* 550 */       res.clear();
/* 551 */       e.printStackTrace();
/*     */     } 
/*     */     
/* 554 */     return res;
/*     */   }
/*     */   
/*     */   public void campaignFinish(String key) {
/* 558 */     HashSet<String> res = campaignsUnlocked();
/* 559 */     res.add(key);
/* 560 */     JsonE j = new JsonE();
/* 561 */     String[] ss = new String[res.size()];
/* 562 */     int i = 0;
/* 563 */     for (String s : res) {
/* 564 */       ss[i++] = s;
/*     */     }
/* 566 */     j.add("UNLOCKED", ss);
/* 567 */     j.save(this.PROFILE.get("Campaigns"));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\paths\PATHS$PATHS_LOCAL.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */