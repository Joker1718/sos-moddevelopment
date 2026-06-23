/*     */ package settlement.entity.humanoid.ai.main;
/*     */ 
/*     */ import init.type.CAUSE_ARRIVE;
/*     */ import init.type.CAUSE_ARRIVES;
/*     */ import init.type.CAUSE_LEAVE;
/*     */ import init.type.HTYPE;
/*     */ import init.type.HTYPES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.battle.AIModule_Battle;
/*     */ import settlement.entity.humanoid.ai.consume.AIModule_Consumption;
/*     */ import settlement.entity.humanoid.ai.crime.AIModule_Crime;
/*     */ import settlement.entity.humanoid.ai.danger.AIModule_Danger;
/*     */ import settlement.entity.humanoid.ai.home.AIModule_Home;
/*     */ import settlement.entity.humanoid.ai.idle.AIModule_Idle;
/*     */ import settlement.entity.humanoid.ai.service.AIModule_Service;
/*     */ import settlement.entity.humanoid.ai.subject.AIModule_Subject;
/*     */ import settlement.entity.humanoid.ai.types.child.AIModule_Child;
/*     */ import settlement.entity.humanoid.ai.types.guard.AIModule_Guard;
/*     */ import settlement.entity.humanoid.ai.types.insane.AIModule_Insane;
/*     */ import settlement.entity.humanoid.ai.types.noble.AIModule_Noble;
/*     */ import settlement.entity.humanoid.ai.types.parent.AIModule_Parent;
/*     */ import settlement.entity.humanoid.ai.types.prisoner.AIModule_Prisoner;
/*     */ import settlement.entity.humanoid.ai.types.recruit.AIModule_Recruit;
/*     */ import settlement.entity.humanoid.ai.types.retired.AIModule_Retired;
/*     */ import settlement.entity.humanoid.ai.types.rioter.AIModule_Rioter;
/*     */ import settlement.entity.humanoid.ai.types.slave.AIModule_Slave;
/*     */ import settlement.entity.humanoid.ai.types.student.AIModule_Student;
/*     */ import settlement.entity.humanoid.ai.types.tourist.AIModule_Tourist;
/*     */ import settlement.entity.humanoid.ai.work.AIModule_Work;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.main.ROOMA;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATEE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.LIST;
/*     */ import snake2d.util.sets.Tree;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AIModules
/*     */ {
/*     */   private static AIDataModule data;
/*     */   public final AIModule_Idle idle;
/*     */   public final AIModule_Subject subject;
/*     */   final AIModule_Danger danger;
/*     */   public final AIModule_Work work;
/*     */   public final AIModule_Battle battle;
/*     */   final AIModule noble;
/*     */   final AIModule slave;
/*     */   final AIModule_Student student;
/*     */   private final AIModule_Crime criminal;
/*     */   public final AIModule_Prisoner prisoner;
/*     */   private final AIModule_Recruit recruit;
/*     */   private final AIModule_Guard guard;
/*     */   private final AIModule_Child child;
/*     */   private final AIModule_Rioter rioter;
/*     */   public final AIModule_Home home;
/*     */   private final AIModule_Retired retired;
/*     */   private final AIModule_Insane insane;
/*     */   private final AIModule_Tourist tourist;
/*     */   private final AIModule_Parent parent;
/*     */   public final AIModule_Service needs;
/*     */   private final AIModule_Consumption cons;
/*     */   private final LIST<AIModule> std;
/*     */   private final LIST<AIModule> pla;
/*     */   private final AIModule[][] modules;
/*     */   private final Sorter2 sorter;
/*     */   
/*     */   public COORDINATEE coo(AIManager d) {
/*  83 */     return data.coo(d); } AIModules() { data = new AIDataModule(AI.data()); this.idle = new AIModule_Idle(); this.subject = new AIModule_Subject(this.idle); this.danger = new AIModule_Danger(); this.work = new AIModule_Work(); this.battle = new AIModule_Battle(); this.noble = (AIModule)new AIModule_Noble(); this.slave = (AIModule)new AIModule_Slave(); this.student = new AIModule_Student(); this.criminal = new AIModule_Crime();
/*     */     this.prisoner = new AIModule_Prisoner();
/*     */     this.recruit = new AIModule_Recruit();
/*     */     this.guard = new AIModule_Guard();
/*     */     this.child = new AIModule_Child();
/*     */     this.rioter = new AIModule_Rioter();
/*     */     this.home = new AIModule_Home();
/*     */     this.retired = new AIModule_Retired();
/*     */     this.insane = new AIModule_Insane();
/*     */     this.tourist = new AIModule_Tourist();
/*     */     this.parent = new AIModule_Parent();
/*     */     this.needs = new AIModule_Service();
/*     */     this.cons = new AIModule_Consumption();
/*     */     this.std = (new ArrayList(0)).join((Object[])new AIModule_Service[] { this.needs }).join((LIST)this.cons).join(this.danger.all);
/*     */     this.pla = this.std.join((Object[])new AIModule[] { (AIModule)this.subject, (AIModule)this.home });
/*     */     this.modules = new AIModule[HTYPES.ALL().size()][];
/*  99 */     this.modules[HTYPES.SUBJECT().index()] = make(this.pla.join((Object[])new AIModule[] { (AIModule)this.criminal, (AIModule)this.work, (AIModule)this.battle }));
/* 100 */     this.modules[HTYPES.SLAVE().index()] = make(this.pla.join((Object[])new AIModule[] { (AIModule)this.work, this.slave, (AIModule)this.criminal }));
/* 101 */     this.modules[HTYPES.RETIREE().index()] = make(this.pla.join((Object[])new AIModule[] { (AIModule)this.criminal, (AIModule)this.retired, (AIModule)this.battle }));
/* 102 */     this.modules[HTYPES.GUARD().index()] = make(this.pla.join((Object[])new AIModule[] { (AIModule)this.guard, (AIModule)this.battle }));
/* 103 */     this.modules[HTYPES.RECRUIT().index()] = make(this.pla.join((Object[])new AIModule[] { (AIModule)this.criminal, (AIModule)this.recruit, (AIModule)this.battle }));
/* 104 */     this.modules[HTYPES.STUDENT().index()] = make(this.pla.join((Object[])new AIModule[] { (AIModule)this.criminal, (AIModule)this.student, (AIModule)this.battle }));
/* 105 */     this.modules[HTYPES.NOBILITY().index()] = make(this.pla.join((Object[])new AIModule[] { this.noble }));
/*     */     
/* 107 */     this.modules[HTYPES.TOURIST().index()] = make(this.std.join((Object[])new AIModule_Tourist[] { this.tourist }));
/*     */     
/* 109 */     (new AIModule[1])[0] = 
/* 110 */       (AIModule)this.battle;
/*     */     this.modules[HTYPES.ENEMY().index()] = new AIModule[1];
/* 112 */     (new AIModule[1])[0] = 
/* 113 */       (AIModule)this.rioter;
/*     */     this.modules[HTYPES.RIOTER().index()] = new AIModule[1];
/* 115 */     (new AIModule[1])[0] = 
/* 116 */       (AIModule)this.battle;
/*     */     
/*     */     this.modules[HTYPES.SOLDIER().index()] = new AIModule[1];
/* 119 */     (new AIModule[1])[0] = 
/* 120 */       (AIModule)this.prisoner;
/*     */     
/*     */     this.modules[HTYPES.PRISONER().index()] = new AIModule[1];
/* 123 */     this.modules[HTYPES.PARENT().index()] = make(this.pla.join((Object[])new AIModule_Parent[] { this.parent }));
/* 124 */     this.modules[HTYPES.PARENT_SLAVE().index()] = make(this.pla.join((Object[])new AIModule[] { (AIModule)this.parent, this.slave }));
/*     */     
/* 126 */     LIST<AIModule> ch = (new ArrayList(0)).join((Object[])new AIModule_Service[] { this.needs }).join((Object[])new AIModule[] { this.cons.food }).join(this.danger.all).join((Object[])new AIModule_Child[] { this.child });
/*     */     
/* 128 */     this.modules[HTYPES.CHILD().index()] = make(ch);
/* 129 */     this.modules[HTYPES.CHILD_SLAVE().index()] = make(ch);
/*     */     
/* 131 */     this.modules[HTYPES.DERANGED().index()] = make(this.danger.all.join((Object[])new AIModule_Insane[] { this.insane }));
/* 132 */     this.sorter = new Sorter2();
/*     */     
/* 134 */     for (HTYPE t : HTYPES.ALL()) {
/*     */       byte b; int i; AIModule[] arrayOfAIModule;
/* 136 */       for (i = (arrayOfAIModule = this.modules[t.index()]).length, b = 0; b < i; ) { AIModule m = arrayOfAIModule[b];
/* 137 */         m.hasType.set(t.index(), true); b++; }
/* 138 */        ((AIModule)this.idle).hasType.set(t.index(), true);
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   private AIModule[] make(LIST<AIModule> extra) {
/* 144 */     AIModule[] std = new AIModule[extra.size()];
/* 145 */     for (int i = 0; i < extra.size(); i++) {
/* 146 */       std[i] = (AIModule)extra.get(i);
/*     */     }
/* 148 */     return std;
/*     */   }
/*     */   
/*     */   public boolean isCriminal(Humanoid a) {
/* 152 */     return this.criminal.isCriminal(a);
/*     */   }
/*     */   
/*     */   public void makePrisoner(Humanoid h, AIManager m) {
/* 156 */     if (this.criminal.catchPrisoner(h))
/* 157 */       this.prisoner.makePrisoner(h, m);  } void init(Humanoid a, AIManager d, HTYPE prev, HTYPE current) {
/*     */     byte b;
/*     */     int i;
/*     */     AIModule[] arrayOfAIModule;
/* 161 */     for (i = (arrayOfAIModule = this.modules[a.indu().hType().index()]).length, b = 0; b < i; ) { AIModule m = arrayOfAIModule[b];
/* 162 */       m.init(a, d, prev, current);
/*     */       b++; }
/*     */   
/*     */   } void cancel(Humanoid a, AIManager d) {
/* 166 */     data.nextModule.set(d, 0);
/* 167 */     data.currentModule.set(d, 0);
/* 168 */     data.nextModulePrio.set(d, 0); byte b; int i; AIModule[] arrayOfAIModule;
/* 169 */     for (i = (arrayOfAIModule = this.modules[a.indu().hType().index()]).length, b = 0; b < i; ) { AIModule m = arrayOfAIModule[b];
/* 170 */       m.cancel(a, d);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   static void update(Humanoid a, AIManager d, boolean newDay, int byteDelta, int updateI) {
/* 175 */     AIModule next = null;
/* 176 */     int hprio = -1;
/*     */ 
/*     */     
/* 179 */     AIModule[] modules = AI.modules().getModules(a, d); byte b; int i;
/*     */     AIModule[] arrayOfAIModule1;
/* 181 */     for (i = (arrayOfAIModule1 = modules).length, b = 0; b < i; ) { AIModule m = arrayOfAIModule1[b];
/* 182 */       m.update(a, d, newDay, byteDelta, updateI);
/* 183 */       int prio = m.getPriority(a, d);
/* 184 */       if (prio > hprio) {
/* 185 */         next = m;
/* 186 */         hprio = prio;
/*     */       } 
/*     */       b++; }
/*     */     
/* 190 */     if (next != null) {
/* 191 */       data.nextModule.set(d, next.index);
/*     */     } else {
/* 193 */       data.nextModule.set(d, data.currentModule.get(d));
/* 194 */       hprio = 0;
/*     */     } 
/* 196 */     data.nextModulePrio.set(d, hprio);
/*     */   }
/*     */ 
/*     */   
/*     */   private AIModule[] getModules(Humanoid a, AIManager d) {
/* 201 */     return this.modules[a.indu().hType().index()];
/*     */   }
/*     */   
/*     */   AIPLAN.AiPlanActivation getNextPlan(Humanoid a, AIManager d) {
/*     */     int i;
/* 206 */     data.nextModule.set(d, 0);
/*     */ 
/*     */     
/* 209 */     AIModule current = current(d);
/* 210 */     current.finish(a, d);
/* 211 */     AIPLAN.AiPlanActivation p = untrap(a, d);
/* 212 */     if (p != null) {
/* 213 */       return p;
/*     */     }
/*     */     
/* 216 */     switchType(a, d);
/*     */     
/* 218 */     boolean hasCurrent = false;
/* 219 */     int rrr = data.timesResumed.get(d);
/* 220 */     data.timesResumed.set(d, 0);
/*     */     
/* 222 */     this.sorter.init(a, d, getModules(a, d));
/*     */     
/* 224 */     AIModule n = this.sorter.poll();
/* 225 */     while (n != null) {
/*     */       
/* 227 */       i = hasCurrent | ((n == current) ? 1 : 0);
/*     */       
/* 229 */       p = n.getPlan(a, d);
/* 230 */       if (p != null) {
/* 231 */         data.currentModule.set(d, n.index);
/* 232 */         data.nextModule.set(d, n.index);
/* 233 */         data.nextModulePrio.set(d, 0);
/* 234 */         return p;
/*     */       } 
/* 236 */       n = this.sorter.poll();
/*     */     } 
/*     */     
/* 239 */     if (current != null && i != 0) {
/* 240 */       p = current.resume(a, d, rrr);
/* 241 */       if (p != null) {
/* 242 */         data.timesResumed.set(d, CLAMP.i(rrr + 1, 0, data.timesResumed.max(d)));
/* 243 */         data.currentModule.set(d, current.index);
/* 244 */         data.nextModule.set(d, current.index);
/* 245 */         data.nextModulePrio.set(d, 0);
/* 246 */         return p;
/*     */       } 
/*     */     } 
/*     */     
/* 250 */     p = this.idle.getPlan(a, d);
/* 251 */     data.currentModule.set(d, ((AIModule)this.idle).index);
/* 252 */     data.nextModule.set(d, ((AIModule)this.idle).index);
/* 253 */     data.nextModulePrio.set(d, 0);
/* 254 */     return p;
/*     */   }
/*     */   
/*     */   private AIPLAN.AiPlanActivation untrap(Humanoid a, AIManager d) {
/* 258 */     if (!(SETT.PATH()).connectivity.is(a.physics.tileC())) {
/*     */       
/* 260 */       if ((SETT.PATH()).comps.zero.get(a.tc()) == null) {
/* 261 */         for (int di = 0; di < DIR.ORTHO.size(); di++) {
/* 262 */           DIR dd = (DIR)DIR.ORTHO.get(di);
/* 263 */           if ((SETT.PATH()).connectivity.is(a.physics.tileC(), dd)) {
/* 264 */             int x = (a.tc().x() + dd.x()) * 64 + 32;
/* 265 */             int y = (a.tc().y() + dd.y()) * 64 + 32;
/* 266 */             a.physics.body().moveC(x, y);
/* 267 */             return null;
/*     */           } 
/*     */         } 
/* 270 */         return (AI.plans()).unreachable.activate(a, d);
/*     */       } 
/*     */       
/* 273 */       if (RND.oneIn(5) && a.indu().hType() != HTYPES.ENEMY()) {
/* 274 */         return (AI.plans()).unreachable.activate(a, d);
/*     */       }
/*     */     } else {
/* 277 */       (STATS.POP()).TRAPPED.indu().set(a.indu(), 0);
/* 278 */       if (a.division() != null)
/* 279 */         (a.division()).reporter.reportReachable(a, true); 
/*     */     } 
/* 281 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void switchType(Humanoid a, AIManager d) {
/* 286 */     if ((STATS.WORK()).incap.stat.indu().get(a.indu()) == 1) {
/* 287 */       (STATS.WORK()).incap.stat.indu().set(a.indu(), 0);
/*     */     }
/* 289 */     HTYPE t = a.indu().hType();
/*     */     
/* 291 */     if (t == HTYPES.SUBJECT()) {
/* 292 */       if ((STATS.WORK()).RET.shoudRetire(a.indu())) {
/* 293 */         switchType(a, d, HTYPES.RETIREE(), null, null);
/* 294 */       } else if (this.recruit.canBecome(a, d)) {
/* 295 */         switchType(a, d, HTYPES.RECRUIT(), null, null);
/* 296 */       } else if (this.student.tryInit(a, d)) {
/* 297 */         switchType(a, d, HTYPES.STUDENT(), null, null);
/* 298 */       } else if (AIModule_Guard.shouldBe(a)) {
/* 299 */         switchType(a, d, HTYPES.GUARD(), null, null);
/*     */       } 
/* 301 */     } else if (t == HTYPES.RETIREE()) {
/* 302 */       if (!(STATS.WORK()).RET.shoudRetire(a.indu())) {
/* 303 */         switchType(a, d, HTYPES.SUBJECT(), null, null);
/*     */       }
/* 305 */     } else if (t == HTYPES.RECRUIT()) {
/* 306 */       if (!this.recruit.setEmploy(a, d)) {
/* 307 */         switchType(a, d, HTYPES.SUBJECT(), null, null);
/* 308 */       } else if ((STATS.WORK()).RET.shoudRetire(a.indu())) {
/* 309 */         switchType(a, d, HTYPES.RETIREE(), null, null);
/*     */       } 
/* 311 */     } else if (t.parent() != t) {
/* 312 */       if (AIModule_Child.shouldGrowUp(a, d)) {
/* 313 */         if (t == HTYPES.CHILD()) {
/* 314 */           switchType(a, d, HTYPES.SUBJECT(), null, CAUSE_ARRIVES.BORN());
/*     */         } else {
/* 316 */           switchType(a, d, HTYPES.SLAVE(), null, CAUSE_ARRIVES.BORN());
/*     */         } 
/*     */       }
/* 319 */     } else if (t == HTYPES.STUDENT()) {
/* 320 */       this.recruit.updateNonRecruit(a, d);
/* 321 */       if (!AIModule_Student.shouldContinue(a, d)) {
/* 322 */         switchType(a, d, HTYPES.SUBJECT(), null, null);
/*     */       }
/* 324 */     } else if (t == HTYPES.PARENT()) {
/* 325 */       if (this.parent.growChildUp(a, d))
/* 326 */         switchType(a, d, HTYPES.SUBJECT(), null, null); 
/* 327 */     } else if (t == HTYPES.PARENT_SLAVE()) {
/* 328 */       if (this.parent.growChildUp(a, d))
/* 329 */         switchType(a, d, HTYPES.SLAVE(), null, null); 
/* 330 */     } else if (t == HTYPES.GUARD()) {
/* 331 */       if (!AIModule_Guard.shouldBe(a)) {
/* 332 */         switchType(a, d, HTYPES.SUBJECT(), null, null);
/* 333 */       } else if (this.recruit.canBecome(a, d)) {
/* 334 */         switchType(a, d, HTYPES.RECRUIT(), null, null);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void switchType(Humanoid a, AIManager d, HTYPE type, CAUSE_LEAVE leave, CAUSE_ARRIVE arr) {
/* 340 */     cancel(a, d);
/* 341 */     HTYPE prev = a.indu().hType();
/*     */     
/* 343 */     a.indu().hTypeSet(a, type, leave, arr);
/* 344 */     init(a, d, prev, type);
/*     */   }
/*     */   
/*     */   public static AIDataModule data() {
/* 348 */     return data;
/*     */   }
/*     */   
/*     */   public static AIModule next(AIManager d) {
/* 352 */     return (AIModule)AIModule.all.get(data.nextModule.get(d));
/*     */   }
/*     */   
/*     */   public static int nextPrio(AIManager d) {
/* 356 */     return data.nextModulePrio.get(d);
/*     */   }
/*     */   
/*     */   public static AIModule current(AIManager d) {
/* 360 */     AIModule m = (AIModule)AIModule.all.get(data.currentModule.get(d));
/* 361 */     if (m == null)
/* 362 */       return (AIModule)(AI.modules()).idle; 
/* 363 */     return m; } public void evictFromRoom(Humanoid a, AIManager d, ROOMA r) {
/*     */     byte b;
/*     */     int i;
/*     */     AIModule[] arrayOfAIModule;
/* 367 */     for (i = (arrayOfAIModule = getModules(a, d)).length, b = 0; b < i; ) { AIModule m = arrayOfAIModule[b];
/* 368 */       m.evictFromRoom(a, d, r);
/*     */       b++; }
/*     */   
/*     */   }
/*     */   
/* 373 */   private static final class Sorter2 { private final Tree<Node> sorter = new Tree<Node>(AIModule.all.size())
/*     */       {
/*     */         
/*     */         protected boolean isGreaterThan(AIModules.Sorter2.Node current, AIModules.Sorter2.Node cmp)
/*     */         {
/* 378 */           return (current.prio < cmp.prio);
/*     */         }
/*     */       };
/*     */ 
/*     */     
/* 383 */     private final Node[] nodes = new Node[AIModule.all.size()];
/*     */     
/*     */     Sorter2() {
/* 386 */       for (int i = 0; i < this.nodes.length; i++)
/* 387 */         this.nodes[i] = new Node(); 
/*     */     }
/*     */     
/*     */     void init(Humanoid a, AIManager d, AIModule[] modules) {
/* 391 */       this.sorter.clear();
/* 392 */       int ri = RND.rInt(modules.length);
/* 393 */       for (int i = 0; i < modules.length; i++) {
/* 394 */         AIModule m = modules[(i + ri) % modules.length];
/* 395 */         int prio = m.getPriority(a, d);
/* 396 */         if (prio > 0) {
/*     */           
/* 398 */           Node n = this.nodes[i];
/* 399 */           n.m = m;
/* 400 */           n.prio = prio;
/* 401 */           this.sorter.add(n);
/*     */         } 
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     AIModule poll() {
/* 408 */       if (this.sorter.hasMore())
/* 409 */         return ((Node)this.sorter.pollSmallest()).m; 
/* 410 */       return null;
/*     */     }
/*     */ 
/*     */     
/*     */     static class Node
/*     */     {
/*     */       int prio;
/*     */       
/*     */       AIModule m;
/*     */     } }
/*     */ 
/*     */ 
/*     */   
/*     */   public class AIDataModule
/*     */   {
/*     */     private AIManager cooD;
/*     */     
/*     */     public final INT_O.INT_OE<AIManager> byte1;
/*     */     
/*     */     public final INT_O.INT_OE<AIManager> byte2;
/*     */     
/*     */     public final INT_O.INT_OE<AIManager> byte3;
/*     */     
/*     */     public final INT_O.INT_OE<AIManager> x;
/*     */     
/*     */     public final INT_O.INT_OE<AIManager> y;
/*     */     
/*     */     public final INT_O.INT_OE<AIManager> nextModule;
/*     */     
/*     */     public final INT_O.INT_OE<AIManager> currentModule;
/*     */     
/*     */     private final INT_O.INT_OE<AIManager> nextModulePrio;
/*     */     
/*     */     private final INT_O.INT_OE<AIManager> timesResumed;
/*     */     
/*     */     private final COORDINATEE coo;
/*     */     
/*     */     private AIDataModule(AIData data) {
/* 448 */       this.coo = (COORDINATEE)new COORDINATEE.Abs()
/*     */         {
/*     */           public int y()
/*     */           {
/* 452 */             return (short)AIModules.AIDataModule.this.y.get(AIModules.AIDataModule.this.cooD);
/*     */           }
/*     */ 
/*     */           
/*     */           public int x() {
/* 457 */             return (short)AIModules.AIDataModule.this.x.get(AIModules.AIDataModule.this.cooD);
/*     */           }
/*     */ 
/*     */           
/*     */           public void ySet(double dy) {
/* 462 */             AIModules.AIDataModule.this.y.set(AIModules.AIDataModule.this.cooD, (int)dy & 0xFFFF);
/*     */           }
/*     */ 
/*     */           
/*     */           public void xSet(double dx) {
/* 467 */             AIModules.AIDataModule.this.x.set(AIModules.AIDataModule.this.cooD, (int)dx & 0xFFFF); } }; data.getClass(); this.byte1 = (INT_O.INT_OE<AIManager>)new DataO.DataByte(data, "ModuleB1"); data.getClass(); this.byte2 = (INT_O.INT_OE<AIManager>)new DataO.DataByte(data, "ModuleB2"); data.getClass(); this.byte3 = (INT_O.INT_OE<AIManager>)new DataO.DataByte(data, "ModuleB3"); data.getClass(); this.x = (INT_O.INT_OE<AIManager>)new DataO.DataShort(data, "moduleX"); data.getClass(); this.y = (INT_O.INT_OE<AIManager>)new DataO.DataShort(data, "moduleY"); data.getClass(); this.nextModule = (INT_O.INT_OE<AIManager>)new DataO.DataByte(data, "ModuleNext"); data.getClass();
/*     */       this.currentModule = (INT_O.INT_OE<AIManager>)new DataO.DataByte(data, "ModuleCurrent");
/*     */       data.getClass();
/*     */       this.nextModulePrio = (INT_O.INT_OE<AIManager>)new DataO.DataByte(data, "ModulePrio");
/*     */       data.getClass();
/* 472 */       this.timesResumed = (INT_O.INT_OE<AIManager>)new DataO.DataNibble(data, "ModuleTimes"); } public COORDINATEE coo(AIManager d) { this.cooD = d;
/* 473 */       return this.coo; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public LIST<AIModule> ALL() {
/* 479 */     return (LIST<AIModule>)AIModule.all;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\main\AIModules.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */