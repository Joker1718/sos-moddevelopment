/*     */ package settlement.entity.humanoid.ai.types.slave;
/*     */ 
/*     */ import game.GAME;
/*     */ import init.resources.RBIT;
/*     */ import settlement.entity.humanoid.HPoll;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.Equip;
/*     */ import snake2d.util.datatypes.COORDINATE;
/*     */ import util.text.D;
/*     */ 
/*     */ final class PlanUprise
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   public PlanUprise() {
/*  20 */     super("slaveUprise");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  38 */     this.steal = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  42 */           int i = (GAME.events()).uprising.spots.signUpUpriserPositionByte(a);
/*  43 */           if (i < 0)
/*  44 */             return null; 
/*  45 */           d.planByte3 = (byte)i;
/*     */           
/*  47 */           return res(a, d);
/*     */         }
/*     */ 
/*     */         
/*  51 */         final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  55 */           if (d.resourceCarried() != null) {
/*  56 */             for (Equip e : STATS.EQUIP().allE()) {
/*  57 */               if (e.resource() == d.resourceCarried()) {
/*  58 */                 e.stat().indu().inc(a.indu(), 1);
/*     */               }
/*     */             } 
/*  61 */             d.resourceCarriedSet(null);
/*     */           } 
/*     */           
/*  64 */           this.bits.clear();
/*  65 */           for (Equip e : STATS.EQUIP().BATTLE_ALL()) {
/*  66 */             if (e.stat().indu().getD(a.indu()) < 0.3D) {
/*  67 */               this.bits.or(e.resource());
/*     */             }
/*     */           } 
/*  70 */           if (!this.bits.isClear()) {
/*  71 */             AISUB.AISubActivation s = (AI.SUBS()).walkTo.resource(a, d, (RBIT)this.bits);
/*  72 */             if (s != null) {
/*  73 */               return s;
/*     */             }
/*     */           } 
/*  76 */           return PlanUprise.this.path.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  81 */           return (GAME.events()).uprising.spots.confirmUpriser(d.planByte3);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/*  86 */           (GAME.events()).uprising.spots.cancelUpriser(a, d.planByte3, false);
/*     */         }
/*     */       };
/*     */     
/*  90 */     this.path = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  94 */           COORDINATE c = (GAME.events()).uprising.spots.getUpriserTile(d.planByte3);
/*  95 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.around(a, d, c.x(), c.y(), 0, 20);
/*  96 */           if (s != null)
/*  97 */             return s; 
/*  98 */           GAME.Notify("" + c.x() + " " + c.x());
/*  99 */           can(a, d);
/* 100 */           return null;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 106 */           return PlanUprise.this.wait.set(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 111 */           return (GAME.events()).uprising.spots.confirmUpriser(d.planByte3);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 116 */           (GAME.events()).uprising.spots.cancelUpriser(a, d.planByte3, false);
/*     */         }
/*     */       };
/*     */     
/* 120 */     this.wait = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/* 124 */           (GAME.events()).uprising.spots.reportUpriserInPosition(d.planByte3);
/* 125 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 130 */           return (AI.SUBS()).STAND.activateRndDir(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 135 */           return (GAME.events()).uprising.spots.confirmUpriser(d.planByte3);
/*     */         }
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {
/* 140 */           (GAME.events()).uprising.spots.cancelUpriser(a, d.planByte3, true);
/*     */         }
/*     */ 
/*     */         
/*     */         public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 145 */           if (e.type == HPoll.IS_SLAVE_READY_FOR_UPRISING)
/* 146 */             return d.planByte3; 
/* 147 */           return super.poll(a, d, e);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static CharSequence ¤¤verb = "¤Minding own business!";
/*     */   private final AIPLAN.PLANRES.Resumer steal;
/*     */   private final AIPLAN.PLANRES.Resumer path;
/*     */   private final AIPLAN.PLANRES.Resumer wait;
/*     */   
/*     */   static {
/*     */     D.ts(PlanUprise.class);
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.steal.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\slave\PlanUprise.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */