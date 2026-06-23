/*     */ package settlement.entity.humanoid.ai.subject;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import init.resources.RBIT;
/*     */ import init.resources.RESOURCE;
/*     */ import init.type.CAUSE_LEAVES;
/*     */ import settlement.entity.humanoid.Humanoid;
/*     */ import settlement.entity.humanoid.ai.main.AI;
/*     */ import settlement.entity.humanoid.ai.main.AIManager;
/*     */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*     */ import settlement.entity.humanoid.ai.main.AISUB;
/*     */ import settlement.main.SETT;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import util.text.D;
/*     */ import world.army.AD;
/*     */ import world.army.ADSupply;
/*     */ import world.entity.army.WArmy;
/*     */ 
/*     */ 
/*     */ 
/*     */ class PlanJoinArmy
/*     */   extends AIPLAN.PLANRES
/*     */ {
/*     */   private final AIPLAN.PLANRES.Resumer path;
/*     */   
/*     */   PlanJoinArmy() {
/*  28 */     super("subJoinArmy");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     D.t(this);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  48 */     this.path = new AIPLAN.PLANRES.Resumer(this, D.g("Leaving", "Leaving for the Army"))
/*     */       {
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*     */         {
/*  52 */           if ((SETT.PATH()).finders.entity.findExitNoEnemies(a, a.physics.tileC().x(), a.physics.tileC().y(), d.path, 2147483647)) {
/*  53 */             PlanJoinArmy.this.dequip(a, d);
/*  54 */             return (AI.SUBS()).walkTo.pathFull(a, d);
/*     */           } 
/*  56 */           return null;
/*     */         }
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/*  61 */           if ((STATS.BATTLE()).DIV.get(a) == null)
/*  62 */             return null; 
/*  63 */           AIManager.dead = CAUSE_LEAVES.ARMY();
/*  64 */           AD.cityDivs().add(a, (Div)(STATS.BATTLE()).DIV.get(a));
/*  65 */           return (AI.SUBS()).STAND.activate(a, d);
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/*  70 */           return (SETT.BATTLE()).info.shouldJoinArmy(a);
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         public void can(Humanoid a, AIManager d) {}
/*     */       };
/*  79 */     this.fetchGear = new AIPLAN.PLANRES.Resumer(this, "Getting Battlegear")
/*     */       {
/*  81 */         final RBIT.RBITImp bi = new RBIT.RBITImp();
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/*  85 */           this.bi.clear();
/*  86 */           Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/*  87 */           if (div == null) {
/*  88 */             return null;
/*     */           }
/*  90 */           for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/*  91 */             if (amountNeeded(a, d, e) > 0) {
/*  92 */               this.bi.or(e.resource(a.indu()));
/*     */             }
/*     */           } 
/*     */           
/*  96 */           if (this.bi.isClear()) {
/*  97 */             return null;
/*     */           }
/*  99 */           return (AI.SUBS()).walkTo.resource(a, d, (RBIT)this.bi, 2147483647);
/*     */         }
/*     */         
/*     */         private int amountNeeded(Humanoid a, AIManager d, EquipBattle e) {
/* 103 */           Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/* 104 */           if (div == null)
/* 105 */             return 0; 
/* 106 */           if (!(SETT.BATTLE()).info.shouldJoinArmy(a))
/* 107 */             return 0; 
/* 108 */           int aa = e.target(div) - e.stat().indu().get(a.indu());
/* 109 */           if (aa <= 0) {
/* 110 */             return 0;
/*     */           }
/* 112 */           WArmy army = AD.cityDivs().attachedArmy((Div)(STATS.BATTLE()).DIV.get(a));
/* 113 */           if (army == null)
/* 114 */             return 0; 
/* 115 */           int am = ((ADSupply)(AD.supplies()).equip.get(e.indexMilitary())).minimumTarget(army) - ((ADSupply)(AD.supplies()).equip.get(e.indexMilitary())).current().get(army);
/* 116 */           return Math.min(aa, am);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/*     */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 122 */           RESOURCE r = d.resourceCarried();
/* 123 */           Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/* 124 */           if (div == null) {
/* 125 */             can(a, d);
/* 126 */             return null;
/*     */           } 
/* 128 */           WArmy army = AD.cityDivs().attachedArmy((Div)(STATS.BATTLE()).DIV.get(a));
/* 129 */           if (army == null) {
/* 130 */             can(a, d);
/* 131 */             return null;
/*     */           } 
/* 133 */           for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 134 */             if (amountNeeded(a, d, e) > 0 && e.resource(a.indu()) == r) {
/* 135 */               e.inc(a.indu(), 1);
/* 136 */               d.resourceCarriedSet(null);
/* 137 */               ((ADSupply)(AD.supplies()).equip.get(e.indexMilitary())).current().inc(army, 1);
/*     */               break;
/*     */             } 
/*     */           } 
/* 141 */           d.resourceCarriedSet(null);
/* 142 */           AISUB.AISubActivation s = set(a, d);
/* 143 */           if (s == null)
/* 144 */             return PlanJoinArmy.this.path.set(a, d); 
/* 145 */           return s;
/*     */         }
/*     */ 
/*     */         
/*     */         public boolean con(Humanoid a, AIManager d) {
/* 150 */           return ((STATS.BATTLE()).DIV.get(a) != null);
/*     */         }
/*     */         
/*     */         public void can(Humanoid a, AIManager d)
/*     */         {
/* 155 */           PlanJoinArmy.this.dequip(a, d);
/*     */         }
/*     */       };
/*     */   }
/*     */   private final AIPLAN.PLANRES.Resumer fetchGear;
/*     */   private void dequip(Humanoid a, AIManager d) {
/* 161 */     for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 162 */       int am = e.get(a.indu());
/* 163 */       e.set(a.indu(), 0);
/* 164 */       if (am > 0) {
/* 165 */         WArmy army = AD.cityDivs().attachedArmy((Div)(STATS.BATTLE()).DIV.get(a));
/* 166 */         if (army != null) {
/* 167 */           int need = (int)((ADSupply)(AD.supplies()).equip.get(e.indexMilitary())).needed(army);
/* 168 */           int aa = Math.min(am, need);
/* 169 */           am -= aa;
/* 170 */           ((ADSupply)(AD.supplies()).equip.get(e.indexMilitary())).current().inc(army, aa);
/*     */         } 
/* 172 */         if (am > 0) {
/* 173 */           (SETT.THINGS()).resources.create(a.tc(), e.resource, am);
/*     */         }
/*     */       } 
/*     */       
/* 177 */       d.resourceCarriedSet(null);
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getPriority(Humanoid a) {
/*     */     return (SETT.BATTLE()).info.shouldJoinArmy(a) ? 10 : 0;
/*     */   }
/*     */   
/*     */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*     */     return this.path.set(a, d);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\subject\PlanJoinArmy.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */