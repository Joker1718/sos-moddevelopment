/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPosition;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import game.time.TIME;
/*     */ import init.constant.Config;
/*     */ import java.io.IOException;
/*     */ import java.util.Arrays;
/*     */ import snake2d.util.file.FileGetter;
/*     */ import snake2d.util.file.FilePutter;
/*     */ import snake2d.util.file.SAVABLE;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataOSimple;
/*     */ import util.data.INT_O;
/*     */ 
/*     */ 
/*     */ 
/*     */ class BattleOrderUpdater
/*     */   implements SAVABLE
/*     */ {
/*  27 */   private final PlanData[] datas = new PlanData[(Config.battle()).DIVISIONS_PER_BATTLE];
/*  28 */   private final Tools tools = new Tools(this.datas);
/*     */   
/*  30 */   public final ArrayListGrower<Plan> all = new ArrayListGrower();
/*     */   
/*     */   public final PlanWalkToDest walk_to_dest;
/*     */   public final PlanAttackDiv attack;
/*     */   public final PlanAttackTile attackTile;
/*     */   public final PlanCharge charge;
/*     */   public final PlanFireDiv range;
/*     */   public final PlanStop stop;
/*  38 */   public final Plan[] planmap = new Plan[BattleOrderTask.DIVTASK.all.size()];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int inter;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int iii;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String prevState;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void save(FilePutter file) {
/*     */     byte b;
/*     */     int i;
/*     */     PlanData[] arrayOfPlanData;
/*  94 */     for (i = (arrayOfPlanData = this.datas).length, b = 0; b < i; ) { PlanData d = arrayOfPlanData[b];
/*  95 */       d.save(file);
/*     */       b++; }
/*     */   
/*     */   } public void load(FileGetter file) throws IOException { byte b;
/*     */     int i;
/*     */     PlanData[] arrayOfPlanData;
/* 101 */     for (i = (arrayOfPlanData = this.datas).length, b = 0; b < i; ) { PlanData d = arrayOfPlanData[b];
/* 102 */       d.load(file);
/*     */       b++; }
/*     */      } public void clear() { byte b;
/*     */     int i;
/*     */     PlanData[] arrayOfPlanData;
/* 107 */     for (i = (arrayOfPlanData = this.datas).length, b = 0; b < i; ) { PlanData d = arrayOfPlanData[b];
/* 108 */       d.clear();
/*     */       b++; }
/*     */      }
/*     */ 
/*     */ 
/*     */   
/*     */   public DivFormationImp update(Div div, BattleOrder o, DivFormationImp prev) {
/* 115 */     if (div.index() == 0) {
/* 116 */       PlanWalkAbs.amountOfPaths = 0;
/*     */     }
/* 118 */     o.dest.get(Plan.dest);
/* 119 */     if (!div.active()) {
/* 120 */       if (Plan.dest.deployed() == 0) {
/* 121 */         Plan.task.stop(div);
/* 122 */         o.task.set(Plan.task);
/* 123 */         Plan.dest.clear();
/* 124 */         return Plan.dest;
/*     */       } 
/* 126 */       Plan.task.move(div);
/* 127 */       o.task.set(Plan.task);
/* 128 */       return Plan.dest;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 134 */     Plan.m = this.datas[div.index()];
/* 135 */     Plan.order = o;
/* 136 */     Plan.div = div;
/* 137 */     Plan.men = div.menNrOf();
/* 138 */     Plan.unreachable = div.reporter.unreachable();
/* 139 */     Plan.a = div.army();
/*     */     
/* 141 */     Plan.current.copyposition((DivPosition)div.current());
/* 142 */     o.path.get(Plan.path);
/* 143 */     o.task.get(Plan.task);
/* 144 */     Plan.prev.copy(prev);
/* 145 */     Plan.nextPos = null;
/* 146 */     Plan.charging = false;
/* 147 */     Plan.shouldBreak = false;
/* 148 */     Plan.chargeSpeed = false;
/*     */     
/* 150 */     Plan p = plan(Plan.m);
/*     */ 
/*     */     
/* 153 */     if (p != Plan.m.plan()) {
/* 154 */       p.init();
/* 155 */       Plan.m.planI = p.index();
/*     */     } 
/*     */ 
/*     */     
/* 159 */     long now = (long)(TIME.currentSecond() * 1000.0D);
/* 160 */     now &= 0xFFFFFFFL;
/* 161 */     int millis = (int)(now - Plan.m.lastUpdate);
/*     */ 
/*     */ 
/*     */     
/* 165 */     Plan.m.lastUpdate = (int)now;
/* 166 */     p.update(millis);
/*     */ 
/*     */     
/* 169 */     (div.settings()).charging = Plan.charging;
/* 170 */     (div.settings()).shouldbreak = Plan.shouldBreak;
/* 171 */     (div.settings()).chargeSpeed = Plan.chargeSpeed;
/* 172 */     inter++;
/*     */ 
/*     */ 
/*     */     
/* 176 */     return Plan.nextPos;
/*     */   }
/*     */ 
/*     */   
/*     */   private Plan plan(PlanData d) {
/* 181 */     if (Plan.div.status().isFighting() && this.tools.div.isCloseToFighting() && !Plan.task.orderedWhenFighting() && 
/* 182 */       !this.planmap[Plan.task.task().ordinal()].continueWhenFighting()) {
/* 183 */       Plan.task.stop(Plan.div);
/* 184 */       Plan.order.task.set(Plan.task);
/*     */     } 
/*     */ 
/*     */     
/* 188 */     return this.planmap[Plan.task.task().ordinal()];
/*     */   }
/*     */ 
/*     */   
/*     */   static class Data
/*     */     extends DataOSimple<PlanData>
/*     */   {
/*     */     protected long[] data(BattleOrderUpdater.PlanData t) {
/* 196 */       return t.data;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static abstract class Plan
/*     */     implements INDEXED
/*     */   {
/*     */     public final Tools t;
/*     */     
/*     */     private final int index;
/*     */     
/*     */     public final BattleOrderTask.DIVTASK divtask;
/*     */     public static BattleOrderUpdater.PlanData m;
/*     */     public static BattleOrder order;
/*     */     public static Div div;
/*     */     public static int men;
/*     */     public static int unreachable;
/*     */     public static Army a;
/* 215 */     public static final DivPositionCopyable current = new DivPositionCopyable();
/* 216 */     public static final DivFormationImp dest = new DivFormationImp();
/* 217 */     public static final BattleOrderTask task = new BattleOrderTask();
/* 218 */     public static final BattleOrderPath path = new BattleOrderPath();
/* 219 */     public static final DivFormationImp prev = new DivFormationImp();
/*     */     
/*     */     public static DivFormationImp nextPos;
/*     */     
/*     */     public static boolean charging;
/*     */     
/*     */     public static boolean shouldBreak;
/*     */     public static boolean chargeSpeed;
/*     */     private final INT_O.INT_OE<BattleOrderUpdater.PlanData> stateI;
/* 228 */     private final ArrayListGrower<STATE> states = new ArrayListGrower();
/*     */     
/*     */     public Plan(Tools tools, LISTE<Plan> all, BattleOrderUpdater.Data data, BattleOrderTask.DIVTASK task) {
/* 231 */       this.t = tools;
/* 232 */       this.index = all.add(this);
/* 233 */       data.getClass(); this.stateI = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataByte(data);
/* 234 */       this.divtask = task;
/*     */     }
/*     */ 
/*     */     
/*     */     public int index() {
/* 239 */       return this.index;
/*     */     }
/*     */     abstract void init();
/*     */     
/*     */     abstract void update(int param1Int);
/*     */     
/*     */     abstract boolean continueWhenFighting();
/*     */     
/*     */     protected STATE state(BattleOrderUpdater.PlanData m) {
/* 248 */       return (STATE)this.states.get(this.stateI.get(m));
/*     */     }
/*     */     
/*     */     abstract class STATE
/*     */     {
/* 253 */       final int index = BattleOrderUpdater.Plan.this.states.add(this);
/*     */       public final String name;
/*     */       
/*     */       STATE(String name) {
/* 257 */         this.name = name;
/*     */       }
/*     */       
/*     */       boolean set() {
/* 261 */         BattleOrderUpdater.Plan.this.stateI.set(BattleOrderUpdater.Plan.m, this.index);
/* 262 */         return setAction(); } abstract boolean setAction(); abstract void update(int param2Int); void debugInfo(Div div, BattleOrderUpdater.PlanData m, Str text) {} } } abstract class STATE { final int index = ((BattleOrderUpdater.Plan)BattleOrderUpdater.this).states.add(this); public final String name; STATE(String name) { this.name = name; } boolean set() { this.this$1.stateI.set(BattleOrderUpdater.Plan.m, this.index); return setAction(); }
/*     */ 
/*     */ 
/*     */     
/*     */     abstract boolean setAction();
/*     */ 
/*     */     
/*     */     abstract void update(int param1Int);
/*     */ 
/*     */     
/*     */     void debugInfo(Div div, BattleOrderUpdater.PlanData m, Str text) {} }
/*     */ 
/*     */ 
/*     */   
/*     */   final class PlanData
/*     */     implements SAVABLE
/*     */   {
/*     */     final long[] data;
/* 280 */     private int planI = -1;
/*     */     private int lastUpdate;
/*     */     
/*     */     PlanData(int size) {
/* 284 */       this.data = new long[size];
/*     */     }
/*     */     
/*     */     public BattleOrderUpdater.Plan plan() {
/* 288 */       if (this.planI == -1)
/* 289 */         return null; 
/* 290 */       return (BattleOrderUpdater.Plan)BattleOrderUpdater.this.all.get(this.planI);
/*     */     }
/*     */ 
/*     */     
/*     */     public void save(FilePutter file) {
/* 295 */       file.i(this.planI);
/* 296 */       file.lsE(this.data);
/* 297 */       file.i(this.lastUpdate);
/*     */     }
/*     */ 
/*     */     
/*     */     public void load(FileGetter file) throws IOException {
/* 302 */       this.planI = file.i();
/* 303 */       file.lsE(this.data);
/* 304 */       this.lastUpdate = file.i();
/*     */     }
/*     */ 
/*     */     
/*     */     public void clear() {
/* 309 */       Arrays.fill(this.data, 0L);
/* 310 */       this.planI = -1;
/* 311 */       this.lastUpdate = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   BattleOrderUpdater() {
/* 316 */     this.iii = 0; Data d = null; int lc = 0; d = new Data(); this.walk_to_dest = new PlanWalkToDest(this.tools, (LISTE<Plan>)this.all, d); if (d.longCount() > lc) lc = d.longCount();  d = new Data(); this.attack = new PlanAttackDiv(this.tools, (LISTE<Plan>)this.all, d); if (d.longCount() > lc) lc = d.longCount();  d = new Data(); this.range = new PlanFireDiv(this.tools, (LISTE<Plan>)this.all, d); if (d.longCount() > lc) lc = d.longCount();  d = new Data(); this.stop = new PlanStop(this.tools, (LISTE<Plan>)this.all, d); if (d.longCount() > lc) lc = d.longCount();  d = new Data(); this.attackTile = new PlanAttackTile(this.tools, (LISTE<Plan>)this.all, d); if (d.longCount() > lc) lc = d.longCount();  d = new Data(); this.charge = new PlanCharge(this.tools, (LISTE<Plan>)this.all, d); if (d.longCount() > lc) lc = d.longCount();  for (int i = 0; i < this.datas.length; i++)
/*     */       this.datas[i] = new PlanData(lc);  for (Plan p : this.all) { if (this.planmap[p.divtask.ordinal()] != null)
/*     */         throw new RuntimeException();  this.planmap[p.divtask.ordinal()] = p; }  byte b; int j; Plan[] arrayOfPlan; for (j = (arrayOfPlan = this.planmap).length, b = 0; b < j; ) { Plan p = arrayOfPlan[b]; if (p == null)
/* 319 */         throw new RuntimeException();  b++; }  } public void debug(Div div, Str text) { PlanData d = this.datas[div.index()];
/* 320 */     Plan p = d.plan();
/* 321 */     if (p == null)
/*     */       return; 
/* 323 */     text.add(d.plan().getClass().getSimpleName());
/* 324 */     text.s();
/* 325 */     text.add('>');
/* 326 */     text.s();
/* 327 */     if (this.iii++ > 60 || this.prevState == null) {
/* 328 */       this.prevState = (d.plan().state(d)).name;
/* 329 */       this.iii = 0;
/*     */     } 
/* 331 */     text.add(this.prevState);
/* 332 */     text.s();
/* 333 */     text.add((d.plan().state(d)).name);
/*     */ 
/*     */     
/* 336 */     text.NL();
/* 337 */     d.plan().state(d).debugInfo(div, d, text); }
/*     */ 
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\BattleOrderUpdater.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */