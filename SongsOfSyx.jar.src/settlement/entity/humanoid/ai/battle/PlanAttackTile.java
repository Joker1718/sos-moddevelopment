/*     */ package settlement.entity.humanoid.ai.battle;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLES;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.stats.STATS;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ import util.text.D;
/*     */ 
/*     */ final class PlanAttackTile
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   public PlanAttackTile(String key) {
/*  24 */     super(key);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     this.stop = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*     */       {
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  68 */           return (AI.SUBS()).STAND.activateTime(a, d, 0);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  73 */           return PlanAttackTile.this.moveToEdge.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  78 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  89 */     this.moveToEdge = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  94 */           if (!PlanAttackTile.this.shouldattackTile(d, a, d.planTile.x(), d.planTile.y()))
/*  95 */             return null; 
/*  96 */           int x = (d.planTile.x() << 6) + 32;
/*  97 */           int y = (d.planTile.y() << 6) + 32;
/*  98 */           DIR dir = DIR.get(a.body().cX(), a.body().cY(), x, y);
/*  99 */           x = (a.tc().x() << 6) + 32;
/* 100 */           y = (a.tc().y() << 6) + 32;
/*     */           
/* 102 */           int dist = (64 - a.body().width() - 1) / 2;
/*     */           
/* 104 */           x += dir.x() * dist;
/* 105 */           y += dir.y() * dist;
/*     */           
/* 107 */           AISTATE s = (AI.STATES()).WALK2_SWORD.free(a, d, x, y);
/* 108 */           a.speed.setDirCurrent(dir);
/* 109 */           return (AI.SUBS()).single.activate(a, d, s);
/*     */         }
/*     */ 
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 114 */           return PlanAttackTile.this.wait.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 119 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 130 */     this.wait = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 135 */           return PlanAttackTile.this.attack.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 140 */           int tx = (d.planTile.x() << 6) + 32;
/* 141 */           int ty = (d.planTile.y() << 6) + 32;
/* 142 */           DIR dir = DIR.get(a.body().cX(), a.body().cY(), tx, ty);
/* 143 */           a.speed.setDirCurrent(dir);
/* 144 */           a.speed.magnitudeInit(0.0D);
/* 145 */           a.speed.magnitudeTargetSet(0.0D);
/* 146 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.sword.activate(a, d, (2.0F + RND.rFloat() * 2.0F)));
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 151 */           return true;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/* 161 */     this.attack = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*     */       {
/*     */         
/*     */         public AISUB.AISubActivation res(Humanoid a, AIManager d)
/*     */         {
/* 166 */           if (!PlanAttackTile.this.shouldattackTile(d, a, d.planTile.x(), d.planTile.y())) {
/* 167 */             return null;
/*     */           }
/* 169 */           double mom = 64.0D * (BOOSTABLES.BATTLE()).BLUNT_ATTACK.get((BOOSTABLE_O)a.indu());
/*     */           
/* 171 */           double str = (GAME.ARMIES()).map.strength.get((COORDINATE)d.planTile);
/*     */ 
/*     */ 
/*     */           
/* 175 */           while (mom > 0.0D) {
/* 176 */             if (mom > RND.rFloat() * str)
/* 177 */               d.planByte1 = (byte)(d.planByte1 + 1); 
/* 178 */             mom -= str;
/*     */           } 
/*     */ 
/*     */           
/* 182 */           if (d.planByte1 >= 4) {
/* 183 */             (GAME.ARMIES()).map.breakIt(d.planTile.x(), d.planTile.y());
/* 184 */             return null;
/*     */           } 
/*     */           
/* 187 */           return PlanAttackTile.this.wait.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 192 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.stab.activate(a, d));
/*     */         }
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d)
/*     */         {
/* 197 */           return true;
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   private static CharSequence ¤¤name = "¤attacking terrain";
/*     */   private static int tx;
/*     */   
/*     */   public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 209 */     if (e.type == HPoll.COLLIDES)
/* 210 */       return 1.0D; 
/* 211 */     if (e.type == HPoll.WILL_COLLIDE_WITH)
/* 212 */       return 0.0D; 
/* 213 */     return InterBattle.listener.poll(a, d, e);
/*     */   }
/*     */   private static int ty; private final AIPLAN.PLANRES.Resumer stop; private final AIPLAN.PLANRES.Resumer moveToEdge;
/*     */   private final AIPLAN.PLANRES.Resumer wait;
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 219 */     switch (e.event) {
/*     */ 
/*     */       
/*     */       case COLLISION_TILE:
/* 223 */         if (shouldattackTile(d, a, e.tx, e.ty)) {
/* 224 */           if (!d.planTile.isSameAs(e.tx, e.ty)) {
/* 225 */             d.planTile.set(e.tx, e.ty);
/* 226 */             d.planByte1 = 0;
/*     */           } 
/* 228 */           d.overwrite(a, this.stop.set(a, d));
/* 229 */           a.speed.setPrevDir();
/*     */         } 
/* 231 */         return false;
/*     */       case EXHAUST:
/* 233 */         if (RND.oneIn((BOOSTABLES.PHYSICS()).STAMINA.get((BOOSTABLE_O)a.indu()) * 8.0D)) {
/* 234 */           (STATS.NEEDS()).EXHASTION.indu().inc(a.indu(), 1);
/*     */         }
/* 236 */         return false;
/*     */       case COLLISION_SOFT:
/* 238 */         if (shouldattackTile(d, a, e.tx, e.ty)) {
/* 239 */           d.overwrite(a, this.stop.set(a, d));
/* 240 */           a.speed.setPrevDir();
/*     */         } 
/*     */         break;
/*     */     } 
/* 244 */     return InterBattle.listener.event(a, d, e);
/*     */   }
/*     */   
/*     */   private final AIPLAN.PLANRES.Resumer attack;
/*     */   
/*     */   static {
/*     */     D.ts(PlanAttackTile.class);
/*     */   }
/*     */   
/*     */   AIPLAN init(AIManager d, Humanoid a, int tx, int ty) {
/*     */     PlanAttackTile.tx = tx;
/*     */     PlanAttackTile.ty = ty;
/*     */     return (AIPLAN)this;
/*     */   }
/*     */   
/*     */   public boolean shouldattackTile(AIManager d, Humanoid a, int tx, int ty) {
/*     */     if (!(GAME.ARMIES()).map.attackableI.is(tx, ty, a.indu()))
/*     */       return false; 
/*     */     if (a.division() == null)
/*     */       return true; 
/*     */     if (!(a.division()).reporter.posHas(a))
/*     */       return true; 
/*     */     if (!a.division().settings().mustering() || a.division().settings().moppingUp())
/*     */       return true; 
/*     */     if (COORDINATE.tileDistance((a.division()).reporter.getTile(a), tx, ty) < 2.0D)
/*     */       return true; 
/*     */     return false;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     d.planByte1 = 0;
/*     */     d.planTile.set(tx, ty);
/*     */     return this.stop.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\PlanAttackTile.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */