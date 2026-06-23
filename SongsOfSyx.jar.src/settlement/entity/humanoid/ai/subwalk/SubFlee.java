/*     */ package settlement.entity.humanoid.ai.subwalk;
/*     */ 
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.ENTITY;
/*     */ import settlement.entity.humanoid.HEvent;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AISTATE;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import snake2d.util.datatypes.DIR;
/*     */ import snake2d.util.rnd.RND;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ final class SubFlee
/*     */   extends AISUB.Simple
/*     */ {
/*     */   public SubFlee() {
/*  22 */     super("flee");
/*     */   }
/*     */   
/*     */   AISUB.AISubActivation activate(Humanoid a, AIManager d, ENTITY other) {
/*  26 */     a.speed.turn2(other.body(), a.body());
/*  27 */     return activate(a, d);
/*     */   }
/*     */   
/*     */   AISUB.AISubActivation activate(Humanoid a, AIManager d, int iterations) {
/*  31 */     d.subPathByte = (byte)(iterations + 1);
/*  32 */     return activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d) {
/*  37 */     d.subPathByte = (byte)(2 + RND.rInt(5));
/*  38 */     d.subPathByte2 = (byte)(2 + RND.rInt(15));
/*  39 */     return super.activate(a, d);
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISTATE resume(Humanoid a, AIManager d) {
/*  44 */     a.speed.turnWithAngel(RND.rFloat0(90.0D));
/*  45 */     d.subPathByte = (short)(d.subPathByte - 1);
/*  46 */     if ((SETT.TERRAIN()).WATER.DEEP.is(a.tc())) {
/*  47 */       d.subPathByte2 = (byte)(d.subPathByte2 - 1);
/*  48 */       if (d.subPathByte2 <= 0) {
/*  49 */         Humanoid.HumanoidResource.dead = CAUSE_LEAVES.DROWNED();
/*     */       }
/*     */     } 
/*     */     
/*  53 */     if (d.subPathByte > 0) {
/*  54 */       if (RND.oneIn(3))
/*  55 */         return (AI.STATES()).jogCrazy.activate(a, d, (2.0F + RND.rFloat() * 3.0F)); 
/*  56 */       return (AI.STATES()).jog.activate(a, d, (2.0F + RND.rFloat() * 3.0F));
/*     */     } 
/*     */     
/*  59 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected AISTATE resumeInterrupted(Humanoid a, AIManager d, HEvent event) {
/*  64 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*  69 */     if (e.event == HEvent.COLLISION_UNREACHABLE)
/*  70 */     { DIR dd = a.speed.dir();
/*  71 */       if (!dd.isOrtho())
/*  72 */         dd = dd.next(1); 
/*  73 */       for (int i = 0; i < 4 && 
/*  74 */         !(SETT.PATH()).connectivity.is(a.tc(), dd); i++)
/*     */       {
/*     */         
/*  77 */         dd = dd.next(2);
/*     */       }
/*     */       
/*  80 */       if ((SETT.PATH()).connectivity.is(a.tc(), dd)) {
/*  81 */         a.speed.setRaw(dd, 0.5D);
/*     */       } }
/*  83 */     else if (e.event == HEvent.MEET_ENEMY)
/*  84 */     { a.speed.turn2(-e.norX, -e.norY);
/*  85 */       d.stateTimer = 10.0F; }
/*  86 */     else { if (e.event == HEvent.COLLISION_TILE) {
/*  87 */         double dx = e.norX;
/*  88 */         double dy = e.norY;
/*  89 */         if (RND.oneIn(4)) {
/*  90 */           for (int i = RND.rInt(4); i >= 1; i--) {
/*  91 */             double y = dy;
/*  92 */             dy = -dx;
/*  93 */             dx = y;
/*     */           } 
/*     */         }
/*  96 */         a.speed.turn2(dx, dy);
/*     */         
/*  98 */         return true;
/*  99 */       }  if (e.event == HEvent.EXHAUST)
/* 100 */         return super.event(a, d, e); 
/* 101 */       if (e.event == HEvent.COLLISION_HARD)
/* 102 */         return super.event(a, d, e);  }
/*     */     
/* 104 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subwalk\SubFlee.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */