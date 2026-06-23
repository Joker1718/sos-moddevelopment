/*     */ package game.boosting;
/*     */ 
/*     */ import init.INIT;
/*     */ import java.io.IOException;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.LinkedList;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.keymap.RMAP;
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BOOSTING
/*     */   extends INIT.InitResource
/*     */ {
/*     */   public static final String KEY = "BOOST";
/*  18 */   private static final Map map = new Map();
/*  19 */   static final LinkedList<ACTION> waiting = new LinkedList();
/*  20 */   private static final LinkedList<ACTION> connecters = new LinkedList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean hasErrored = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static void clear() {
/*  37 */     map.clear();
/*  38 */     waiting.clear();
/*  39 */     connecters.clear();
/*  40 */     hasErrored = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public BOOSTING(INIT init) throws IOException {
/*  46 */     super(init);
/*  47 */     clear();
/*  48 */     BOOSTABLES.init();
/*  49 */     BoostableCat.init();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void finishSetup() throws IOException {
/*  54 */     for (ACTION a : waiting)
/*  55 */       a.exe(); 
/*  56 */     for (ACTION a : connecters) {
/*  57 */       a.exe();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  78 */     waiting.clear();
/*  79 */     connecters.clear();
/*  80 */     super.finishSetup();
/*     */   }
/*     */   
/*     */   public static LIST<Boostable> ALL() {
/*  84 */     return map.all();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void connecter(ACTION a) {
/*  92 */     connecters.add(a);
/*     */   }
/*     */   
/*     */   public static String available() {
/*  96 */     String s = "";
/*  97 */     for (String ss : map.map().keysSorted()) {
/*  98 */       s = s + s;
/*  99 */       s = s + "  - " + s;
/* 100 */       s = s + s;
/*     */     } 
/* 102 */     return s;
/*     */   }
/*     */   
/*     */   public static Boostable push(String key, double baseValue, CharSequence name, CharSequence desc, SPRITE icon, BoostableCat cat) {
/* 106 */     return push(key, baseValue, name, desc, icon, cat, -1.0E7D);
/*     */   }
/*     */   
/*     */   public static Boostable push(String key, double baseValue, CharSequence name, CharSequence desc, SPRITE icon, BoostableCat cat, double minValue) {
/* 110 */     if (key.charAt(0) == '_')
/* 111 */       key = key.substring(1); 
/* 112 */     key = cat.prefix + cat.prefix;
/*     */     
/* 114 */     Boostable b = new Boostable(map.all().size(), key, baseValue, name, desc, icon, cat, minValue);
/*     */     
/* 116 */     map.add(b);
/*     */     
/* 118 */     return b;
/*     */   }
/*     */   
/*     */   public static RMAP<Boostable> MAP() {
/* 122 */     return map;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class Entry
/*     */   {
/* 130 */     public final ArrayListGrower<Boostable> all = new ArrayListGrower();
/*     */     public final boolean isMaster;
/*     */     
/*     */     Entry(Boostable b, boolean isMaster) {
/* 134 */       this.all.add(b);
/* 135 */       this.isMaster = isMaster;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BOOSTING.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */