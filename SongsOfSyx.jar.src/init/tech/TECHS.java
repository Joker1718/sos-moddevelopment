/*     */ package init.tech;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.paths.PATHS;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import snake2d.Errors;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import util.info.INFO;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TECHS
/*     */ {
/*     */   private static LIST<TECH> ALL;
/*     */   private static LIST<TechCurrency> costs;
/*  26 */   public static CharSequence ¤¤name = "Technology";
/*  27 */   private static CharSequence ¤¤desc = "Technologies unlocks various boosts and rooms."; static {
/*  28 */     D.ts(TECHS.class);
/*  29 */   } private static final INFO info = new INFO(¤¤name, ¤¤desc);
/*     */   
/*     */   private static LIST<TechTree> trees;
/*     */   
/*     */   public static LIST<TechTree> TREES() {
/*  34 */     return trees;
/*     */   }
/*     */   
/*     */   public static LIST<TECH> ALL() {
/*  38 */     return ALL;
/*     */   }
/*     */   
/*     */   public static LIST<TechCurrency> COSTS() {
/*  42 */     return costs;
/*     */   }
/*     */   
/*     */   public static INFO INFO() {
/*  46 */     return info;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TECHS() throws IOException {
/*  53 */     TechCurrency.TechCurrencies cc = new TechCurrency.TechCurrencies();
/*     */ 
/*     */     
/*  56 */     KeyMap<TECH> map = new KeyMap();
/*  57 */     LinkedList<TECH> all = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     ArrayListGrower<TechTree> trees = new ArrayListGrower();
/*  64 */     PATHS.ResFolder data = new PATHS.ResFolder("tech", false); byte b; int j;
/*     */     String[] arrayOfString;
/*  66 */     for (j = (arrayOfString = data.init.getFiles()).length, b = 0; b < j; ) { String key = arrayOfString[b];
/*     */       
/*  68 */       Json dd = new Json(data.init.gets(key));
/*  69 */       Json tt = new Json(data.text.gets(key));
/*  70 */       trees.add(new TechTree(cc, key, dd, tt, (LISTE<TECH>)all));
/*     */       
/*     */       b++; }
/*     */     
/*  74 */     ArrayList<TechTree> li = new ArrayList((Iterable)trees);
/*  75 */     li.sort(new Comparator<TechTree>()
/*     */         {
/*     */           public int compare(TechTree o1, TechTree o2)
/*     */           {
/*  79 */             return o1.cat - o2.cat;
/*     */           }
/*     */         });
/*  82 */     TECHS.trees = (LIST<TechTree>)li;
/*     */ 
/*     */     
/*  85 */     costs = (LIST<TechCurrency>)cc.all;
/*     */ 
/*     */     
/*  88 */     ALL = (LIST<TECH>)new ArrayList((Iterable)all);
/*     */     
/*  90 */     for (TECH t : ALL) {
/*  91 */       if (map.containsKey(t.key)) {
/*  92 */         throw new Errors.DataError(t.key + " is more than once in the tree!");
/*     */       }
/*  94 */       map.put(t.key, t);
/*     */     } 
/*     */     
/*  97 */     for (TECH tech : ALL) {
/*     */       
/*  99 */       Json json = tech.requiresTech;
/* 100 */       tech.requiresTech = null;
/* 101 */       LinkedList<TECH.TechRequirement> needs = new LinkedList();
/* 102 */       if (json.has("REQUIRES_TECH_LEVEL")) {
/* 103 */         Json jj = json.json("REQUIRES_TECH_LEVEL");
/* 104 */         for (String k : jj.keys()) {
/* 105 */           String kk = k;
/* 106 */           if (!map.containsKey(k)) {
/* 107 */             if (tech.tree != null) {
/* 108 */               k = tech.tree.key + "_" + tech.tree.key;
/*     */             }
/* 110 */             if (!map.containsKey(k)) {
/* 111 */               GAME.Warn(jj.errorGet(k, "REQUIRES_TECH_LEVEL"));
/*     */               continue;
/*     */             } 
/*     */           } 
/* 115 */           TECH.TechRequirement t = new TECH.TechRequirement((TECH)map.get(k), jj.i(kk, 0, ((TECH)map.get(k)).levelMax));
/* 116 */           needs.add(t);
/*     */         } 
/*     */       } 
/* 119 */       tech.set((LIST<TECH.TechRequirement>)new ArrayList((Iterable)needs));
/* 120 */       tech.prune((LIST<TECH.TechRequirement>)new ArrayList((Iterable)needs));
/*     */     } 
/*     */     
/* 123 */     detectCycles();
/*     */ 
/*     */     
/* 126 */     int[] reqed = Alloc.ii(ALL.size());
/*     */     
/* 128 */     for (int i = 0; i < ALL.size(); i++) {
/* 129 */       TECH t = (TECH)ALL.get(i);
/* 130 */       Arrays.fill(reqed, 0);
/* 131 */       fillRequirements(reqed, t);
/*     */       
/* 133 */       LinkedList<TECH.TechRequirement> needs = new LinkedList();
/* 134 */       for (int ri = 0; ri < ALL.size(); ri++) {
/* 135 */         if (reqed[ri] > 0) {
/* 136 */           TECH.TechRequirement tt = new TECH.TechRequirement((TECH)ALL.get(ri), reqed[ri] - 1);
/* 137 */           needs.add(tt);
/*     */         } 
/*     */       } 
/*     */       
/* 141 */       t.set((LIST<TECH.TechRequirement>)new ArrayList((Iterable)needs));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillRequirements(int[] reqed, TECH t) {
/* 152 */     for (int i = 0; i < t.requires().size(); i++) {
/* 153 */       TECH.TechRequirement r = (TECH.TechRequirement)t.requires().get(i);
/* 154 */       reqed[r.tech.index()] = Math.max(reqed[r.tech.index()], r.level + 1);
/* 155 */       fillRequirements(reqed, r.tech);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void detectCycles() {
/* 163 */     boolean[] checked = new boolean[ALL.size()];
/*     */     
/* 165 */     for (int i = 0; i < ALL.size(); i++) {
/* 166 */       if (((TECH)ALL.get(i)).requires().size() != 0) {
/*     */         
/* 168 */         Arrays.fill(checked, false);
/* 169 */         detectCycles((TECH)ALL.get(i), checked);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void detectCycles(TECH tech, boolean[] checked) {
/* 176 */     checked[tech.index()] = true;
/*     */     int i;
/* 178 */     for (i = 0; i < tech.requires().size(); i++) {
/* 179 */       TECH t = ((TECH.TechRequirement)tech.requires().get(i)).tech;
/* 180 */       if (checked[t.index()]) {
/* 181 */         throw new Errors.DataError("tech: " + t.key + " has a cyclic requirement", "");
/*     */       }
/*     */     } 
/* 184 */     for (i = 0; i < tech.requires().size(); i++) {
/* 185 */       TECH t = ((TECH.TechRequirement)tech.requires().get(i)).tech;
/* 186 */       detectCycles(t, Arrays.copyOf(checked, checked.length));
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\init\tech\TECHS.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */