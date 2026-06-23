/*     */ package settlement.entity.humanoid.ai.types.prisoner;
/*     */ 
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.room.spirit.temple.ROOM_TEMPLE;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ 
/*     */ class ExecuteTemple extends AIPLAN.PLANRES {
/*     */   private final CharSequence ¤¤name;
/*     */   private final ArrayList<ROOM_TEMPLE> temples;
/*     */   private final AIPLAN.PLANRES.Resumer walk;
/*     */   private final AIPLAN.PLANRES.Resumer ready;
/*     */   
/*  20 */   public ExecuteTemple() { super("prisTemple");
/*     */ 
/*     */ 
/*     */     
/*  24 */     this.¤¤name = "¤Being Sacrificed";
/*     */     
/*  26 */     this.temples = new ArrayList((SETT.ROOMS()).TEMPLES.ALL.size());
/*     */ 
/*     */     
/*  29 */     for (ROOM_TEMPLE t : (SETT.ROOMS()).TEMPLES.ALL) {
/*  30 */       if (t.sacrifices())
/*  31 */         this.temples.add(t); 
/*  32 */     }  D.t(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  50 */     this.walk = new AIPLAN.PLANRES.Resumer(this, this.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  54 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.cooFull(a, d, (COORDINATE)d.planTile);
/*  55 */           if (s != null)
/*  56 */             return s; 
/*  57 */           ExecuteTemple.this.cancel(a, d);
/*  58 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  63 */           return ExecuteTemple.this.ready.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  68 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  78 */     this.ready = new AIPLAN.PLANRES.Resumer(this, this.¤¤name)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  82 */           a.speed.setDirCurrent((DIR)DIR.ALL.rnd());
/*  83 */           ExecuteTemple.this.temple(a, d).sacrificeSetReady((COORDINATE)d.planTile);
/*  84 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  89 */           double k = ExecuteTemple.this.temple(a, d).sacrificeKillAmount((COORDINATE)d.planTile);
/*  90 */           if (k == 1.0D)
/*  91 */             AIManager.dead = CAUSE_LEAVES.SACRIFICED(); 
/*  92 */           (STATS.NEEDS()).INJURIES.COUNT.indu().setD(a.indu(), k);
/*  93 */           return (AI.SUBS()).LAY.activateTime(a, d, 1);
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/*  98 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       }; }
/*     */ 
/*     */ 
/*     */   
/*     */   private ROOM_TEMPLE temple(Humanoid a, AIManager d) {
/* 109 */     return (ROOM_TEMPLE)this.temples.get(d.planByte1);
/*     */   } protected AISUB.AISubActivation init(Humanoid a, AIManager d) { for (int ti = 0; ti < this.temples.size(); ) {
/*     */       ROOM_TEMPLE t = (ROOM_TEMPLE)this.temples.get(ti); COORDINATE c = t.sacrificeReserve(a.race()); if (c == null) {
/*     */         ti++; continue;
/*     */       }  d.planByte1 = (byte)ti; d.planTile.set(c); return this.walk.set(a, d);
/* 114 */     }  return null; } protected void cancel(Humanoid a, AIManager d) { temple(a, d).sacrificeUnreserve((COORDINATE)d.planTile);
/* 115 */     super.cancel(a, d); }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean shouldContinue(Humanoid a, AIManager d) {
/* 120 */     return (temple(a, d).sacrificeReserved((COORDINATE)d.planTile) && super.shouldContinue(a, d));
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\prisoner\ExecuteTemple.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */