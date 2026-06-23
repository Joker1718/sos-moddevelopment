/*     */ package settlement.entity.humanoid.ai.service;
/*     */ 
/*     */ import game.time.TIME;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HTYPE;
/*     */ import init.type.NEED;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModule;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.service.StatService;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ 
/*     */ public final class AIModule_Service extends AIModule {
/*  21 */   final S_Plans plans = new S_Plans();
/*     */   private final INT_O.INT_OE<AIManager> remaining;
/*  23 */   private static CharSequence ¤¤name = "Service";
/*  24 */   private static CharSequence ¤¤desc = "Do an activity that is on offer in your city.";
/*     */   static {
/*  26 */     D.ts(AIModule_Service.class);
/*     */   }
/*     */   
/*     */   public AIModule_Service() {
/*  30 */     super((SPRITE)(UI.icons()).s.trade, ¤¤name, ¤¤desc);
/*  31 */     AI.data().getClass(); this.remaining = (INT_O.INT_OE<AIManager>)new DataO.DataNibble((DataO)AI.data(), "SERVICE_REM");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation get(Humanoid a, AIManager d, NEED need, int dist) {
/*  38 */     for (S_Plan p : this.plans.needMap.get(need.index())) {
/*  39 */       AIPLAN.AiPlanActivation pp = p.getPlan(a, d, dist);
/*  40 */       if (p != null) {
/*  41 */         return pp;
/*     */       }
/*     */     } 
/*  44 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation plan(Humanoid a, AIManager d, NEED need, double ran) {
/*  49 */     S_Plan s = pservice(a.indu(), need, ran);
/*  50 */     if (s != null)
/*  51 */       return s.getPlan(a, d); 
/*  52 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public StatService service(Induvidual a, NEED need, double ran) {
/*  57 */     S_Plan s = pservice(a, need, ran);
/*  58 */     if (s != null)
/*  59 */       return s.service; 
/*  60 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private S_Plan pservice(Induvidual a, NEED need, double ran) {
/*  66 */     if (need == null) {
/*  67 */       return null;
/*     */     }
/*  69 */     double pm = 0.0D;
/*     */     
/*  71 */     for (S_Plan p : this.plans.needMap.get(need.index())) {
/*  72 */       pm += p.usage;
/*     */     }
/*     */     
/*  75 */     pm *= ran;
/*     */     
/*  77 */     for (S_Plan p : this.plans.needMap.get(need.index())) {
/*  78 */       pm -= p.usage;
/*  79 */       if (pm <= 0.0D) {
/*  80 */         return p;
/*     */       }
/*     */     } 
/*  83 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AIPLAN.AiPlanActivation getPlan(Humanoid a, AIManager d) {
/*  90 */     if (this.remaining.get(d) <= 0) {
/*  91 */       this.remaining.set(d, 1);
/*     */     }
/*  93 */     while (this.remaining.get(d) > 0) {
/*  94 */       this.remaining.inc(d, -1);
/*  95 */       AIPLAN.AiPlanActivation p = this.plans.getPlan(a, d);
/*  96 */       if (p != null) {
/*  97 */         return p;
/*     */       }
/*     */     } 
/* 100 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateOfDay) {
/* 105 */     if (newDay) {
/* 106 */       reset(a, d);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/* 113 */     reset(a, d);
/*     */   }
/*     */   
/*     */   private void reset(Humanoid a, AIManager d) {
/* 117 */     int am = this.remaining.get(d);
/* 118 */     int n = RND.rInt(TIME.servicePerDay());
/* 119 */     am += n;
/* 120 */     if (am > TIME.servicePerDay() * 2)
/* 121 */       am = TIME.servicePerDay() * 2; 
/* 122 */     this.remaining.set(d, am);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getPriority(Humanoid a, AIManager d) {
/* 127 */     if (this.remaining.get(d) > 0)
/* 128 */       return 3; 
/* 129 */     return 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\AIModule_Service.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */