/*     */ package settlement.stats.colls;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import init.constant.Config;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.StatsInit;
/*     */ import settlement.stats.stat.STAT;
/*     */ import settlement.stats.stat.STATData;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class StatProspect
/*     */   extends StatObject<Div>
/*     */   implements StatsInit.StatDisposable
/*     */ {
/*     */   private final STATData stat;
/*     */   private final INT_O.INT_OE<Induvidual> idiv;
/* 296 */   private final short[] divs = new short[(Config.battle()).DIVISIONS_PER_ARMY * 2];
/*     */ 
/*     */   
/*     */   public StatProspect(StatsInit init) {
/* 300 */     super(D.g("Recruit"), D.g("RecruitD", "The Army Division this subject will join when training is complete."));
/* 301 */     init.count.getClass(); this.idiv = (INT_O.INT_OE<Induvidual>)new DataO.DataByte(init.count, "BATTLE_RECI");
/* 302 */     INT_O.INT_OE<Induvidual> b = new INT_O.INT_OE<Induvidual>()
/*     */       {
/*     */         public int get(Induvidual t)
/*     */         {
/* 306 */           return (StatsBattle.StatProspect.this.idiv.get(t) != 0) ? 1 : 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int min(Induvidual t) {
/* 311 */           return 0;
/*     */         }
/*     */ 
/*     */         
/*     */         public int max(Induvidual t) {
/* 316 */           return 1;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void set(Induvidual t, int i) {}
/*     */       };
/* 325 */     this.stat = new STATData("RECRUITS", "BATTLE_RECI", init, b)
/*     */       {
/*     */         public void removeH(Induvidual i)
/*     */         {
/* 329 */           if (StatsBattle.StatProspect.this.get(i) != null)
/* 330 */             StatsBattle.StatProspect.this.divs[StatsBattle.StatProspect.this.get(i).index()] = (short)(StatsBattle.StatProspect.this.divs[StatsBattle.StatProspect.this.get(i).index()] - 1); 
/* 331 */           super.removeH(i);
/*     */         }
/*     */ 
/*     */         
/*     */         public void addH(Induvidual i) {
/* 336 */           if (StatsBattle.StatProspect.this.get(i) != null)
/* 337 */             StatsBattle.StatProspect.this.divs[StatsBattle.StatProspect.this.get(i).index()] = (short)(StatsBattle.StatProspect.this.divs[StatsBattle.StatProspect.this.get(i).index()] + 1); 
/* 338 */           super.addH(i);
/*     */         }
/*     */       };
/*     */ 
/*     */ 
/*     */     
/* 344 */     init.disposable.add(new StatsInit.StatDisposable()
/*     */         {
/*     */           public void dispose(Humanoid h)
/*     */           {
/* 348 */             StatsBattle.StatProspect.this.set(h, (Div)null);
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(Humanoid h, Div d) {
/* 357 */     Induvidual i = h.indu();
/* 358 */     if (!i.added())
/* 359 */       throw new RuntimeException(); 
/* 360 */     this.stat.removeH(h.indu());
/*     */ 
/*     */     
/* 363 */     if (d != null) {
/* 364 */       this.idiv.set(i, d.index() + 1);
/*     */     } else {
/* 366 */       this.idiv.set(i, 0);
/*     */     } 
/* 368 */     this.stat.addH(h.indu());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void dispose(Humanoid h) {
/* 374 */     set(h, (Div)null);
/*     */   }
/*     */   
/*     */   public int inDiv(Div div) {
/* 378 */     return this.divs[div.index()];
/*     */   }
/*     */ 
/*     */   
/*     */   public Div get(Induvidual i) {
/* 383 */     if (this.idiv.get(i) != 0)
/* 384 */       return GAME.ARMIES().division((short)(this.idiv.get(i) - 1)); 
/* 385 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public STAT stat() {
/* 390 */     return (STAT)this.stat;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\colls\StatsBattle$StatProspect.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */