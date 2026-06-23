/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.FResources;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.resources.RESOURCES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.WearableResource;
/*     */ import util.text.D;
/*     */ 
/*     */ final class M_PlanReturn
/*     */   extends AIPLAN.PLANRES {
/*  22 */   private static CharSequence ¤¤sName = "Returning equipment"; private final RBIT.RBITImp bits;
/*     */   
/*     */   static {
/*  25 */     D.ts(M_PlanReturn.class);
/*     */   }
/*     */   final AIPLAN.PLANRES.Resumer walk;
/*     */   public M_PlanReturn() {
/*  29 */     super("SerEquip");
/*     */ 
/*     */ 
/*     */     
/*  33 */     this.bits = new RBIT.RBITImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  64 */     this.walk = new AIPLAN.PLANRES.Resumer(this, ¤¤sName)
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  68 */           return (AI.SUBS()).walkTo.depositInited(a, d, (RESOURCE)RESOURCES.ALL().get(d.planByte1));
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  73 */           if (AIModules.current(d).moduleCanContinue(a, d)) {
/*  74 */             return M_PlanReturn.this.init(a, d);
/*     */           }
/*  76 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  81 */           return true;
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d)
/*     */         {
/*  86 */           FACTIONS.player().res().inc((RESOURCE)RESOURCES.ALL().get(d.planByte1), FResources.RTYPE.EQUIPPED, 1);
/*  87 */           (SETT.THINGS()).resources.create(a.physics.tileC(), (RESOURCE)RESOURCES.ALL().get(d.planByte1), 1);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private void remOne(Humanoid a, AIManager d, RESOURCE res) {
/*  93 */     for (WearableResource e : STATS.EQUIP().allE()) {
/*  94 */       if (e.needed(a.indu()) < 0 && e.resource(a.indu()) == res) {
/*  95 */         e.inc(a.indu(), -1);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void dump(Humanoid a, AIManager d) {
/* 102 */     Induvidual i = a.indu();
/*     */     
/* 104 */     for (WearableResource e : STATS.EQUIP().allE()) {
/* 105 */       int toDump = -e.needed(a.indu());
/* 106 */       if (toDump > 0) {
/* 107 */         e.inc(i, -toDump);
/* 108 */         FACTIONS.player().res().inc(e.resource(i), FResources.RTYPE.EQUIPPED, toDump);
/* 109 */         (SETT.THINGS()).resources.create(a.physics.tileC(), e.resource(i), toDump);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     Induvidual i = a.indu();
/*     */     this.bits.clear();
/*     */     for (WearableResource e : STATS.EQUIP().allE()) {
/*     */       if (e.needed(a.indu()) < 0)
/*     */         this.bits.or(e.resource(i)); 
/*     */     } 
/*     */     if (this.bits.isClear())
/*     */       return null; 
/*     */     RESOURCE res = (SETT.PATH()).finders.storage.reserve(a.tc(), (RBIT)this.bits, d.path, 512);
/*     */     if (res == null) {
/*     */       dump(a, d);
/*     */       return null;
/*     */     } 
/*     */     d.planByte1 = res.bIndex();
/*     */     remOne(a, d, res);
/*     */     return this.walk.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\M_PlanReturn.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */