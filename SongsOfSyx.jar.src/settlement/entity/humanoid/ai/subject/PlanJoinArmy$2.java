/*     */ package settlement.entity.humanoid.ai.subject;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends AIPLAN.PLANRES.Resumer
/*     */ {
/*     */   final RBIT.RBITImp bi;
/*     */   
/*     */   null(AIPLAN.PLANRES paramPLANRES, CharSequence $anonymous0) {
/*  79 */     super(paramPLANRES, $anonymous0);
/*     */     
/*  81 */     this.bi = new RBIT.RBITImp();
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  85 */     this.bi.clear();
/*  86 */     Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/*  87 */     if (div == null) {
/*  88 */       return null;
/*     */     }
/*  90 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/*  91 */       if (amountNeeded(a, d, e) > 0) {
/*  92 */         this.bi.or(e.resource(a.indu()));
/*     */       }
/*     */     } 
/*     */     
/*  96 */     if (this.bi.isClear()) {
/*  97 */       return null;
/*     */     }
/*  99 */     return (AI.SUBS()).walkTo.resource(a, d, (RBIT)this.bi, 2147483647);
/*     */   }
/*     */   
/*     */   private int amountNeeded(Humanoid a, AIManager d, EquipBattle e) {
/* 103 */     Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/* 104 */     if (div == null)
/* 105 */       return 0; 
/* 106 */     if (!(SETT.BATTLE()).info.shouldJoinArmy(a))
/* 107 */       return 0; 
/* 108 */     int aa = e.target(div) - e.stat().indu().get(a.indu());
/* 109 */     if (aa <= 0) {
/* 110 */       return 0;
/*     */     }
/* 112 */     WArmy army = AD.cityDivs().attachedArmy((Div)(STATS.BATTLE()).DIV.get(a));
/* 113 */     if (army == null)
/* 114 */       return 0; 
/* 115 */     int am = ((ADSupply)(AD.supplies()).equip.get(e.indexMilitary())).minimumTarget(army) - ((ADSupply)(AD.supplies()).equip.get(e.indexMilitary())).current().get(army);
/* 116 */     return Math.min(aa, am);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 122 */     RESOURCE r = d.resourceCarried();
/* 123 */     Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/* 124 */     if (div == null) {
/* 125 */       can(a, d);
/* 126 */       return null;
/*     */     } 
/* 128 */     WArmy army = AD.cityDivs().attachedArmy((Div)(STATS.BATTLE()).DIV.get(a));
/* 129 */     if (army == null) {
/* 130 */       can(a, d);
/* 131 */       return null;
/*     */     } 
/* 133 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 134 */       if (amountNeeded(a, d, e) > 0 && e.resource(a.indu()) == r) {
/* 135 */         e.inc(a.indu(), 1);
/* 136 */         d.resourceCarriedSet(null);
/* 137 */         ((ADSupply)(AD.supplies()).equip.get(e.indexMilitary())).current().inc(army, 1);
/*     */         break;
/*     */       } 
/*     */     } 
/* 141 */     d.resourceCarriedSet(null);
/* 142 */     AISUB.AISubActivation s = set(a, d);
/* 143 */     if (s == null)
/* 144 */       return PlanJoinArmy.this.path.set(a, d); 
/* 145 */     return s;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean con(Humanoid a, AIManager d) {
/* 150 */     return ((STATS.BATTLE()).DIV.get(a) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void can(Humanoid a, AIManager d) {
/* 155 */     PlanJoinArmy.this.dequip(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\PlanJoinArmy$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */