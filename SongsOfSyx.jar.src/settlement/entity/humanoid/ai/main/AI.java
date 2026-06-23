/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.save.Savable;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import snake2d.util.file.Alloc;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.KeyMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AI
/*     */ {
/*     */   private static AI s;
/*     */   private final AISTATES STATES;
/*     */   private final AIEventListeners listeners;
/*     */   private final AISUBS SUBS;
/*     */   private final AIPlans plans;
/*     */   private final AIModules modules;
/*     */   private final AIPLAN first;
/*  26 */   private final AIData data = new AIData();
/*  27 */   private final KeyMap<AIElement> map = new KeyMap();
/*  28 */   private final ArrayListGrower<AIElement> all = new ArrayListGrower();
/*  29 */   private int[] loadOrder = null;
/*     */   
/*     */   private AI() {
/*  32 */     s = this;
/*  33 */     this.STATES = new AISTATES();
/*  34 */     this.listeners = new AIEventListeners();
/*  35 */     this.SUBS = new AISUBS();
/*  36 */     this.plans = new AIPlans();
/*  37 */     this.modules = new AIModules();
/*  38 */     this.first = new AIPLAN.PLANRES("planFirst")
/*     */       {
/*     */         protected AISUB.AISubActivation init(Humanoid a, AIManager d)
/*     */         {
/*  42 */           return this.resumer.set(a, d);
/*     */         }
/*     */         
/*  45 */         private final AIPLAN.PLANRES.Resumer resumer = new AIPLAN.PLANRES.Resumer(this, "standing")
/*     */           {
/*     */             protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */             {
/*  49 */               return (AI.SUBS()).STAND.activateTime(a, d, 1);
/*     */             }
/*     */ 
/*     */ 
/*     */             
/*     */             protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  55 */               return null;
/*     */             }
/*     */ 
/*     */             
/*     */             public boolean con(Humanoid a, AIManager d) {
/*  60 */               return true;
/*     */             }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*     */             public void can(Humanoid a, AIManager d) {}
/*     */           };
/*     */       };
/*  71 */     GAME.saver().addSpecialSaver(new Savable("HAI")
/*     */         {
/*     */           public void save(FilePutter file)
/*     */           {
/*  75 */             file.i(AI.this.all.size());
/*  76 */             for (AI.AIElement e : AI.this.all) {
/*  77 */               file.chars(e.key);
/*     */             }
/*     */           }
/*     */           
/*     */           public void load(FileGetter file) throws IOException {
/*  82 */             int am = file.i();
/*  83 */             AI.this.loadOrder = Alloc.ii(am);
/*  84 */             Arrays.fill(AI.this.loadOrder, -1);
/*  85 */             for (int i = 0; i < am; i++) {
/*  86 */               String k = file.chars();
/*  87 */               if (AI.this.map.containsKey(k)) {
/*  88 */                 AI.this.loadOrder[i] = ((AI.AIElement)AI.this.map.get(k)).index;
/*     */               }
/*     */             } 
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static AIElement load(int i) {
/*  99 */     if (i < 0 || i >= s.loadOrder.length || s.loadOrder[i] == -1)
/* 100 */       return null; 
/* 101 */     return (AIElement)s.all.get(s.loadOrder[i]);
/*     */   }
/*     */   
/*     */   static int save(AIElement e) {
/* 105 */     return (e != null) ? e.index : -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final AISTATES STATES() {
/* 115 */     return s.STATES;
/*     */   }
/*     */   
/*     */   public static final AISUBS SUBS() {
/* 119 */     return s.SUBS;
/*     */   }
/*     */   public static final AIPlans plans() {
/* 122 */     return s.plans;
/*     */   }
/*     */   public static final AIModules modules() {
/* 125 */     return s.modules;
/*     */   }
/*     */   public static final AIEventListeners listeners() {
/* 128 */     return s.listeners;
/*     */   }
/*     */ 
/*     */   
/*     */   public static final AIPLAN first() {
/* 133 */     return s.first;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void init() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static AIData data() {
/* 146 */     return s.data;
/*     */   }
/*     */   
/*     */   public static AIData.AIDataSuspender suspender(String key) {
/* 150 */     s.data.getClass(); return new AIData.AIDataSuspender(s.data, key);
/*     */   }
/*     */   
/*     */   public static AIData.AIDataBit bit(String key) {
/* 154 */     s.data.getClass(); return new AIData.AIDataBit(s.data, key);
/*     */   }
/*     */   
/*     */   public static class AIElement {
/*     */     public final String className;
/*     */     final int index;
/*     */     public final String key;
/*     */     
/*     */     protected AIElement(String key) {
/* 163 */       String cn = getClass().getName();
/* 164 */       String[] ss = cn.split("\\.");
/*     */       
/* 166 */       String match = ss[ss.length - 1]; byte b; int i; StackTraceElement[] arrayOfStackTraceElement;
/* 167 */       for (i = (arrayOfStackTraceElement = (new Throwable()).getStackTrace()).length, b = 0; b < i; ) { StackTraceElement e = arrayOfStackTraceElement[b];
/* 168 */         if (e.toString().contains("." + match))
/* 169 */           match = match + "_" + match; 
/*     */         b++; }
/*     */       
/* 172 */       this.className = match;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 177 */       AI.s.map.put(key, this);
/* 178 */       this.index = AI.s.all.add(this);
/* 179 */       this.key = key;
/*     */     }
/*     */ 
/*     */     
/*     */     protected String getClassLine(Humanoid a, AIManager d) {
/* 184 */       String ss = getClass().toString();
/* 185 */       return ss;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AI.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */