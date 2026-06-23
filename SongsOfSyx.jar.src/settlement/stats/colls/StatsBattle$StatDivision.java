/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.Armies;
/*     */ import game.battle.div.Div;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
/*     */ import settlement.stats.stat.STATFake;
/*     */ import settlement.stats.stat.StatObject;
/*     */ import util.data.DataO;
/*     */ import util.data.INT_O;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class StatDivision
/*     */   extends StatObject<Div>
/*     */   implements StatsInit.StatDisposable
/*     */ {
/*     */   final STAT stat;
/*     */   private final INT_O.INT_OE<Induvidual> idiv;
/*     */   private final StatsInit init;
/*     */   
/*     */   public StatDivision(StatsInit init) {
/* 174 */     super(D.g("Division"), D.g("DivisionD", "The Army Division this subject belongs to."));
/* 175 */     this.init = init;
/* 176 */     init.count.getClass(); this.idiv = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "BATTLE_DIVI");
/* 177 */     INT_O.INT_OE<Induvidual> b = new INT_O.INT_OE<Induvidual>()
/*     */       {
/*     */         public int get(Induvidual t)
/*     */         {
/* 181 */           return (StatsBattle.StatDivision.this.idiv.get(t) != 0) ? 1 : 0;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public int min(Induvidual t) {
/* 187 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Induvidual t) {
/* 192 */           return 1;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(Induvidual t, int i) {}
/*     */       };
/* 202 */     this.stat = (STAT)new STATData("SOLDIERS", "BATTLE_SOLDIERS", init, b);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 217 */     if (Armies.DIVISIONS >= 32767)
/* 218 */       throw new RuntimeException(); 
/* 219 */     init.disposable.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Div get(Induvidual i) {
/* 225 */     int di = this.idiv.get(i);
/* 226 */     if (di != 0)
/* 227 */       return GAME.ARMIES().division((short)(di - 1)); 
/* 228 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void set(Humanoid h, Div d) {
/* 233 */     Induvidual i = h.indu();
/* 234 */     if (!i.added())
/* 235 */       throw new RuntimeException(); 
/* 236 */     if (d != null)
/*     */     {
/* 238 */       StatsBattle.this.RECRUIT.set(h, (Div)null);
/*     */     }
/*     */     
/* 241 */     remove(h);
/*     */     
/* 243 */     if (d != null) {
/* 244 */       this.idiv.set(i, d.index() + 1);
/*     */     } else {
/* 246 */       this.idiv.set(i, 0);
/*     */     } 
/* 248 */     add(h);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void remove(Humanoid h) {
/* 254 */     Induvidual i = h.indu();
/*     */     
/* 256 */     for (int ai = 0; ai < this.init.addable.size(); ai++) {
/* 257 */       ((StatsInit.Addable)this.init.addable.get(ai)).removeH(i);
/*     */     }
/*     */     
/* 260 */     Div old = (Div)get(h);
/* 261 */     if (old != null) {
/* 262 */       old.reporter.returnPosition((short)StatsBattle.this.position.get(i));
/*     */     }
/*     */   }
/*     */   
/*     */   private void add(Humanoid a) {
/* 267 */     Induvidual i = a.indu();
/*     */     
/* 269 */     for (int ai = 0; ai < this.init.addable.size(); ai++) {
/* 270 */       ((StatsInit.Addable)this.init.addable.get(ai)).addH(i);
/*     */     }
/*     */     
/* 273 */     Div now = (Div)get(a);
/* 274 */     if (now != null) {
/* 275 */       StatsBattle.this.position.set(i, now.reporter.signUpAndGetPosition(a.body().cX(), a.body().cY(), i.race()));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void dispose(Humanoid h) {
/* 281 */     set(h, (Div)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public STAT stat() {
/* 287 */     return this.stat;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsBattle$StatDivision.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */