/*     */ package game.battle.thread.order;
/*     */ 
/*     */ import game.battle.Army;
/*     */ import game.battle.div.Div;
/*     */ import game.battle.formation.DivFormationImp;
/*     */ import game.battle.formation.DivPositionCopyable;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.INDEXED;
/*     */ import snake2d.util.sets.LISTE;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.data.DataOSimple;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class Plan
/*     */   implements INDEXED
/*     */ {
/*     */   public final Tools t;
/*     */   private final int index;
/*     */   public final BattleOrderTask.DIVTASK divtask;
/*     */   public static BattleOrderUpdater.PlanData m;
/*     */   public static BattleOrder order;
/*     */   public static Div div;
/*     */   public static int men;
/*     */   public static int unreachable;
/*     */   public static Army a;
/* 215 */   public static final DivPositionCopyable current = new DivPositionCopyable();
/* 216 */   public static final DivFormationImp dest = new DivFormationImp();
/* 217 */   public static final BattleOrderTask task = new BattleOrderTask();
/* 218 */   public static final BattleOrderPath path = new BattleOrderPath();
/* 219 */   public static final DivFormationImp prev = new DivFormationImp();
/*     */   
/*     */   public static DivFormationImp nextPos;
/*     */   
/*     */   public static boolean charging;
/*     */   
/*     */   public static boolean shouldBreak;
/*     */   public static boolean chargeSpeed;
/*     */   private final INT_O.INT_OE<BattleOrderUpdater.PlanData> stateI;
/* 228 */   private final ArrayListGrower<STATE> states = new ArrayListGrower();
/*     */   
/*     */   public Plan(Tools tools, LISTE<Plan> all, BattleOrderUpdater.Data data, BattleOrderTask.DIVTASK task) {
/* 231 */     this.t = tools;
/* 232 */     this.index = all.add(this);
/* 233 */     data.getClass(); this.stateI = (INT_O.INT_OE<BattleOrderUpdater.PlanData>)new DataOSimple.DataByte(data);
/* 234 */     this.divtask = task;
/*     */   }
/*     */ 
/*     */   
/*     */   public int index() {
/* 239 */     return this.index;
/*     */   }
/*     */   abstract void init();
/*     */   
/*     */   abstract void update(int paramInt);
/*     */   
/*     */   abstract boolean continueWhenFighting();
/*     */   
/*     */   protected STATE state(BattleOrderUpdater.PlanData m) {
/* 248 */     return (STATE)this.states.get(this.stateI.get(m));
/*     */   }
/*     */   
/*     */   abstract class STATE
/*     */   {
/* 253 */     final int index = BattleOrderUpdater.Plan.this.states.add(this);
/*     */     public final String name;
/*     */     
/*     */     STATE(String name) {
/* 257 */       this.name = name;
/*     */     }
/*     */     
/*     */     boolean set() {
/* 261 */       BattleOrderUpdater.Plan.this.stateI.set(BattleOrderUpdater.Plan.m, this.index);
/* 262 */       return setAction();
/*     */     }
/*     */     
/*     */     abstract boolean setAction();
/*     */     
/*     */     abstract void update(int param2Int);
/*     */     
/*     */     void debugInfo(Div div, BattleOrderUpdater.PlanData m, Str text) {}
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battle\thread\order\BattleOrderUpdater$Plan.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */