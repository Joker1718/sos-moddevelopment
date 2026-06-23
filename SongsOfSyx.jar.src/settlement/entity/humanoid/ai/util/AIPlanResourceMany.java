/*     */ package settlement.entity.humanoid.ai.util;
/*     */ 
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import util.text.D;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class AIPlanResourceMany
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer get;
/*  19 */   private static CharSequence ¤¤fetch = "Fetching Resources";
/*     */   
/*     */   static {
/*  22 */     D.ts(AIPlanResourceMany.class);
/*     */   }
/*     */   
/*     */   public AIPlanResourceMany(AIPLAN.PLANRES p, final int extraDistance) {
/*  26 */     p.getClass(); this.get = new AIPLAN.PLANRES.Resumer(p, ¤¤fetch)
/*     */       {
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  31 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  36 */           int am = (SETT.PATH()).finders.resource.pickup(AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), d.planByte2);
/*     */           
/*  38 */           if (d.resourceCarried() != AIPlanResourceMany.this.resource(a, d)) {
/*  39 */             d.resourceDrop(a);
/*  40 */             d.resourceCarriedSet(AIPlanResourceMany.this.resource(a, d));
/*  41 */             if (am > 0)
/*  42 */               am--; 
/*     */           } 
/*  44 */           d.resourceAInc(am);
/*  45 */           d.planByte2 = 0;
/*  46 */           int more = AIPlanResourceMany.this.target(a, d) - d.resourceA();
/*     */           
/*  48 */           if (more == 0) {
/*  49 */             return AIPlanResourceMany.this.next(a, d);
/*     */           }
/*     */ 
/*     */           
/*  53 */           int dist = extraDistance - extraDistance * d.resourceA() / AIPlanResourceMany.this.target(a, d);
/*     */           
/*  55 */           if ((SETT.PATH()).finders.resource.find((AIPlanResourceMany.this.resource(a, d)).bit, AIPlanResourceMany.this.stored(d) ? (AIPlanResourceMany.this.resource(a, d)).bit : RBIT.NONE, AIPlanResourceMany.this.prio(d) ? (AIPlanResourceMany.this.resource(a, d)).bit : RBIT.NONE, a.tc(), d.path, dist) == null) {
/*  56 */             return AIPlanResourceMany.this.next(a, d);
/*     */           }
/*  58 */           d.planByte2 = 1;
/*  59 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.path(a, d);
/*  60 */           if (s == null) {
/*  61 */             (SETT.PATH()).finders.resource.unreserve(AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), 1);
/*  62 */             return AIPlanResourceMany.this.next(a, d);
/*     */           } 
/*     */           
/*  65 */           int extra = AIPlanResourceMany.this.target(a, d) - d.resourceA() - d.planByte2;
/*  66 */           extra = (SETT.PATH()).finders.resource.reserveExtra(AIPlanResourceMany.this.stored(d), AIPlanResourceMany.this.prio(d), AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), extra);
/*  67 */           d.planByte2 = (byte)(d.planByte2 + extra);
/*     */           
/*  69 */           return s;
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  76 */           int am = AIPlanResourceMany.this.target(a, d) - d.resourceA() - d.planByte2;
/*  77 */           if (am > 0) {
/*  78 */             d.planByte2 = (byte)(d.planByte2 + (byte)(SETT.PATH()).finders.resource.reserveExtra(AIPlanResourceMany.this.stored(d), AIPlanResourceMany.this.prio(d), AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), am));
/*     */           }
/*     */           
/*  81 */           return !(d.resourceCarried() != AIPlanResourceMany.this.resource(a, d) && !(SETT.PATH()).finders.resource.isReservedAndAvailable(AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY()));
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  86 */           (SETT.PATH()).finders.resource.unreserve(AIPlanResourceMany.this.resource(a, d), d.path.destX(), d.path.destY(), d.planByte2);
/*  87 */           d.resourceDrop(a);
/*  88 */           AIPlanResourceMany.this.cancel(a, d);
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public RESOURCE resource(Humanoid a, AIManager d) {
/*  95 */     return (RESOURCE)RESOURCES.ALL().get(d.planByte4);
/*     */   }
/*     */   
/*     */   public int target(Humanoid a, AIManager d) {
/*  99 */     return d.planByte3 & 0x3F;
/*     */   }
/*     */   
/*     */   private boolean stored(AIManager d) {
/* 103 */     return ((d.planByte3 & 0x40) != 0);
/*     */   }
/*     */   
/*     */   private boolean prio(AIManager d) {
/* 107 */     return ((d.planByte3 & 0x80) != 0);
/*     */   }
/*     */   
/*     */   private void init(AIManager d, int target, boolean stored, boolean prio) {
/* 111 */     d.planByte2 = 0;
/* 112 */     d.planByte3 = (byte)target;
/* 113 */     if (d.planByte3 <= 0 || d.planByte3 > 63) {
/* 114 */       throw new RuntimeException("" + target);
/*     */     }
/* 116 */     if (stored) {
/* 117 */       d.planByte3 = (byte)(d.planByte3 | 0x40);
/*     */     }
/* 119 */     if (prio) {
/* 120 */       d.planByte3 = (byte)(d.planByte3 | 0x80);
/*     */     }
/*     */   }
/*     */   
/*     */   public AISUB.AISubActivation activate(Humanoid a, AIManager d, RBIT res, int target, int distance, boolean stored, boolean prio) {
/* 125 */     RESOURCE r = (SETT.PATH()).finders.resource.find(res, stored ? res : RBIT.NONE, prio ? res : RBIT.NONE, a.tc(), d.path, distance);
/* 126 */     if (r != null)
/* 127 */       return activateFound(a, d, r, target, stored, prio); 
/* 128 */     init(d, target, stored, prio);
/* 129 */     d.resourceDrop(a);
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public AISUB.AISubActivation activateFound(Humanoid a, AIManager d, RESOURCE res, int target, boolean stored, boolean prio) {
/* 135 */     init(d, target, stored, prio);
/* 136 */     d.resourceDrop(a);
/* 137 */     d.planByte4 = res.bIndex();
/* 138 */     AISUB.AISubActivation s = (AI.SUBS()).walkTo.path(a, d);
/* 139 */     if (s == null) {
/* 140 */       (SETT.PATH()).finders.resource.unreserve(res, d.path.destX(), d.path.destY(), 1);
/* 141 */       return null;
/*     */     } 
/* 143 */     d.planByte2 = 1;
/* 144 */     target--;
/* 145 */     if (target > 0) {
/* 146 */       d.planByte2 = (byte)(d.planByte2 + (SETT.PATH()).finders.resource.reserveExtra(stored(d), prio(d), res, d.path.destX(), d.path.destY(), target));
/*     */     }
/* 148 */     this.get.set(a, d);
/*     */     
/* 150 */     return s;
/*     */   }
/*     */   
/*     */   public abstract void cancel(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */   
/*     */   public abstract AISUB.AISubActivation next(Humanoid paramHumanoid, AIManager paramAIManager);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\a\\util\AIPlanResourceMany.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */