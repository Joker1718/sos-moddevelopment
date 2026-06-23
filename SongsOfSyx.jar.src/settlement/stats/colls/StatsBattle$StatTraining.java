/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoostSpec;
/*     */ import game.boosting.Booster;
/*     */ import game.boosting.BoosterValue;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.room.military.training.ROOM_M_TRAINER;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.StatInfo;
/*     */ import settlement.stats.util.StatBooster;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.keymap.MAPPED;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StatTraining
/*     */   implements MAPPED
/*     */ {
/*     */   private final INT_O.INT_OE<Induvidual> count;
/*     */   public final ROOM_M_TRAINER<?> room;
/*     */   public final int tIndex;
/*     */   public static final int MAX = 15;
/*     */   public static final double MAXI = 0.06666666666666667D;
/*     */   public final STATData stat;
/*     */   public final BValue bvalue;
/*     */   
/*     */   StatTraining(StatsInit init, final ROOM_M_TRAINER<?> room) {
/* 502 */     this.bvalue = (BValue)new StatBooster()
/*     */       {
/*     */ 
/*     */         
/*     */         public double vGet(HCLASS_RACE t)
/*     */         {
/* 508 */           return StatsBattle.StatTraining.this.bValue(StatsBattle.StatTraining.this.stat.data(t.cl).getD(t.race));
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Div div) {
/* 513 */           return StatsBattle.StatTraining.this.bValue(StatsBattle.StatTraining.this.stat.div().getD(div));
/*     */         }
/*     */ 
/*     */         
/*     */         public double vGet(Induvidual indu) {
/* 518 */           return StatsBattle.StatTraining.this.bValue(StatsBattle.StatTraining.this.stat.indu().getD(indu));
/*     */         }
/*     */       };
/*     */     this.stat = new STATData(room.key, init, (DataO.DataAbs)new DataO.DataNibble(init.count, "BATTLE_TRAINING_" + room.key), new StatInfo(room.tInfo.name, room.tInfo.desc));
/*     */     this.count = (INT_O.INT_OE<Induvidual>)new DataO.DataNibble(init.count, "BATTLE_TCOUNT_" + room.key);
/*     */     this.room = room;
/*     */     this.tIndex = room.INDEX_TRAINING;
/*     */     BOOSTING.connecter(new ACTION() {
/*     */           public void exe() {
/*     */             for (BoostSpec b : room.boosters.all()) {
/*     */               BoosterValue boosterValue = new BoosterValue(StatsBattle.StatTraining.this.bvalue, b.booster.info, b.booster.to(), b.booster.isMul);
/*     */               StatsBattle.StatTraining.this.stat.boosters.push((Booster)boosterValue, b.boostable);
/*     */             } 
/*     */           }
/*     */         });
/*     */     (this.stat.info()).icon = room.icon.resized(16);
/*     */   }
/*     */   
/*     */   public boolean shouldTrain(Induvidual a, double target, boolean training) {
/*     */     if (!(STATS.BATTLE()).basicTraining.isMax(a))
/*     */       return true; 
/*     */     double t = target;
/*     */     double i = this.stat.indu().getD(a);
/*     */     if (t > i)
/*     */       return true; 
/*     */     if (t < i)
/*     */       return false; 
/*     */     if (t > 0.0D && training && !this.count.isMax(a))
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   public void inc(Induvidual a, double am) {
/*     */     int sign = (am < 0.0D) ? -1 : 1;
/*     */     am = Math.abs(am);
/*     */     am *= (15 * this.stat.indu().max(a));
/*     */     int iam = (int)am;
/*     */     if (RND.rFloat() < am - iam)
/*     */       iam++; 
/*     */     iam *= sign;
/*     */     int c = this.count.get(a) + iam;
/*     */     while (c >= this.count.max(a)) {
/*     */       if (this.stat.indu().isMax(a)) {
/*     */         c = this.count.max(a);
/*     */         break;
/*     */       } 
/*     */       this.stat.indu().inc(a, 1);
/*     */       c -= this.count.max(a);
/*     */     } 
/*     */     while (c <= 0) {
/*     */       this.stat.indu().inc(a, -1);
/*     */       c += this.count.max(a);
/*     */     } 
/*     */     this.count.set(a, c);
/*     */   }
/*     */   
/*     */   public int index() {
/*     */     return this.tIndex;
/*     */   }
/*     */   
/*     */   public String key() {
/*     */     return this.room.key;
/*     */   }
/*     */   
/*     */   public double bValue(double d) {
/*     */     d = CLAMP.d(d, 0.0D, 1.0D);
/*     */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsBattle$StatTraining.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */