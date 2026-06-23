/*     */ package settlement.stats.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import java.io.IOException;
/*     */ import java.util.Comparator;
/*     */ import java.util.LinkedList;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.muls.StatsMultipliers;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.StatCollection;
/*     */ import snake2d.LOG;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ 
/*     */ 
/*     */ public abstract class StatsJson
/*     */ {
/*     */   private static boolean hasErrored = false;
/*     */   
/*     */   public StatsJson(Json json) throws IOException {
/*  22 */     this("STATS", json);
/*     */   }
/*     */   
/*     */   public StatsJson(String masterkey, Json json) throws IOException {
/*  26 */     if (json.has(masterkey)) {
/*  27 */       json = json.json(masterkey);
/*     */     }
/*     */ 
/*     */     
/*  31 */     for (String k : json.keys()) {
/*     */       
/*  33 */       if (k.indexOf('*') != -1) {
/*  34 */         String kk = k.substring(0, k.indexOf('*'));
/*  35 */         for (STAT s : STATS.all()) {
/*  36 */           if (s.key() != null && Str.containsText(s.key(), kk)) {
/*  37 */             doWithTheJson(s, json, k);
/*     */           }
/*     */         } 
/*     */         
/*  41 */         for (StatsMultipliers.StatMultiplier m : STATS.MULTIPLIERS().all()) {
/*  42 */           if (m.key() != null && Str.containsText(m.key(), kk)) {
/*  43 */             doWithMultiplier(m, json, k);
/*     */           }
/*     */         } 
/*     */         
/*     */         continue;
/*     */       } 
/*  49 */       if (STATS.STAT(k) != null && STATS.STAT(k).key() != null) {
/*  50 */         doWithTheJson(STATS.STAT(k), json, k); continue;
/*  51 */       }  if ((STATS.MULTIPLIERS()).MAP.tryGet(k) != null) {
/*  52 */         StatsMultipliers.StatMultiplier m = (StatsMultipliers.StatMultiplier)(STATS.MULTIPLIERS()).MAP.tryGet(k);
/*  53 */         doWithMultiplier(m, json, k); continue;
/*     */       } 
/*  55 */       handleFault(json, k);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void doWithMultiplier(StatsMultipliers.StatMultiplier paramStatMultiplier, Json paramJson, String paramString) throws IOException;
/*     */ 
/*     */   
/*     */   public abstract void doWithTheJson(STAT paramSTAT, Json paramJson, String paramString) throws IOException;
/*     */ 
/*     */   
/*     */   public void handleFault(Json j, String key) {
/*  68 */     String p = "No stat named: " + key + "  " + j.path() + " line: " + j.line(key);
/*  69 */     if (!hasErrored) {
/*  70 */       p = p + p + "Available:" + System.lineSeparator();
/*  71 */       p = p + p;
/*  72 */       GAME.Warn(p);
/*  73 */       hasErrored = true;
/*     */     } else {
/*  75 */       LOG.ln(p);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String available() {
/*  81 */     String k = "";
/*  82 */     LinkedList<String> ss = new LinkedList<>();
/*  83 */     for (StatCollection c : STATS.COLLECTIONS())
/*  84 */       ss.add(c.key); 
/*  85 */     for (StatsMultipliers.StatMultiplier c : STATS.MULTIPLIERS().all())
/*  86 */       ss.add(c.key); 
/*  87 */     for (STAT c : STATS.all()) {
/*  88 */       if (c.key() != null)
/*  89 */         ss.add(c.key()); 
/*  90 */     }  ArrayList<String> as = new ArrayList(ss);
/*  91 */     as.sort(new Comparator<String>()
/*     */         {
/*     */           public int compare(String o1, String o2)
/*     */           {
/*  95 */             return o1.compareTo(o2);
/*     */           }
/*     */         });
/*  98 */     for (String s : as)
/*  99 */       k = k + k + s; 
/* 100 */     return k;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stat\\util\StatsJson.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */