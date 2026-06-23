/*     */ package settlement.entity.humanoid.ai.consume;
/*     */ 
/*     */ import init.race.RACES;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.NEEDS;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIModules;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.entity.humanoid.ai.util.AIPlanResourceMany;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.equip.WearableResource;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ import snake2d.util.sprite.text.Str;
/*     */ import util.text.D;
/*     */ 
/*     */ final class M_PlanEquip
/*     */   extends AIPLAN.PLANRES {
/*  22 */   private static CharSequence ¤¤name = "Getting equipment";
/*     */   static {
/*  24 */     D.ts(M_PlanEquip.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  35 */     D.ts(M_PlanEquip.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final RBIT.RBITImp bits = new RBIT.RBITImp();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final AIPlanResourceMany fetch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public M_PlanEquip() {
/*     */     super("serEquip");
/*  82 */     this.fetch = new AIPlanResourceMany(this, 64)
/*     */       {
/*     */         public AISUB.AISubActivation next(Humanoid a, AIManager d)
/*     */         {
/*  86 */           RESOURCE res = d.resourceCarried();
/*  87 */           int am = d.resourceA();
/*  88 */           Induvidual i = a.indu();
/*     */           
/*  90 */           if (res == null || am <= 0) {
/*  91 */             return null;
/*     */           }
/*  93 */           for (WearableResource r : RACES.res().get(i.popCL(), res)) {
/*  94 */             r.wearOut(i);
/*  95 */             int dam = CLAMP.i(am, 0, r.needed(a.indu()));
/*  96 */             r.inc(i, dam);
/*  97 */             am -= dam;
/*  98 */             d.resourceAInc(-dam);
/*  99 */             if (am <= 0) {
/*     */               break;
/*     */             }
/*     */           } 
/* 103 */           if (AIModules.current(d).moduleCanContinue(a, d))
/* 104 */             return M_PlanEquip.this.init(a, d); 
/* 105 */           return null;
/*     */         }
/*     */         
/*     */         public void cancel(Humanoid a, AIManager d) {}
/*     */       };
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     this.bits.clear();
/*     */     for (WearableResource e : RACES.res().all(a.indu().popCL())) {
/*     */       int needed = e.needed(a.indu());
/*     */       if (needed > 0)
/*     */         this.bits.or(e.resource(a.indu())); 
/*     */     } 
/*     */     if (!this.bits.isClear()) {
/*     */       RESOURCE res = (SETT.PATH()).finders.resource.find((RBIT)this.bits, a.tc().x(), a.tc().y(), d.path, 100);
/*     */       if (res != null) {
/*     */         int nn = 0;
/*     */         for (WearableResource rr : RACES.res().get(a.indu().popCL(), res)) {
/*     */           if (rr.resource(a.indu()) == res) {
/*     */             int n = rr.needed(a.indu());
/*     */             if (n > 0)
/*     */               nn += n; 
/*     */           } 
/*     */         } 
/*     */         if (nn <= 0)
/*     */           throw new RuntimeException(String.valueOf(res) + " " + String.valueOf(res)); 
/*     */         AISUB.AISubActivation s = this.fetch.activateFound(a, d, res, nn, true, true);
/*     */         return s;
/*     */       } 
/*     */     } 
/*     */     (NEEDS.TYPES()).SHOPPING.stat().fixMax(a.indu());
/*     */     for (WearableResource e : RACES.res().all(a.indu().popCL()))
/*     */       e.wearOut(a.indu()); 
/*     */     return null;
/*     */   }
/*     */   
/*     */   protected void name(Humanoid a, AIManager d, Str string) {
/*     */     string.add(¤¤name);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\M_PlanEquip.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */