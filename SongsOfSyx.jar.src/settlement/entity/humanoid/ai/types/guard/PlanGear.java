/*    */ package settlement.entity.humanoid.ai.types.guard;
/*    */ 
/*    */ import game.battle.div.Div;
/*    */ import init.resources.RBIT;
/*    */ import init.resources.RESOURCE;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
/*    */ import settlement.stats.equip.Equip;
/*    */ import settlement.stats.equip.EquipBattle;
/*    */ import util.text.D;
/*    */ 
/*    */ final class PlanGear
/*    */   extends AIPLAN.PLANRES {
/*    */   private final AIPLAN.PLANRES.Resumer fetchGear;
/* 20 */   private static CharSequence ¤¤name = "Getting Gear";
/*    */   static {
/* 22 */     D.ts(PlanGear.class);
/*    */   }
/*    */   protected PlanGear() {
/* 25 */     super("GUARD_GEAR");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 33 */     this.fetchGear = new AIPLAN.PLANRES.Resumer(this, ¤¤name)
/*    */       {
/* 35 */         final RBIT.RBITImp bi = new RBIT.RBITImp();
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d) {
/* 39 */           this.bi.clear();
/* 40 */           Div div = (Div)(STATS.BATTLE()).DIV.get(a);
/* 41 */           if (div == null) {
/* 42 */             return null;
/*    */           }
/* 44 */           for (Equip e : STATS.EQUIP().BATTLE_ALL()) {
/*    */             
/* 46 */             if (e.needed(a.indu()) > 0) {
/* 47 */               this.bi.or(e.resource(a.indu()));
/*    */             }
/*    */           } 
/*    */           
/* 51 */           if (this.bi.isClear()) {
/* 52 */             return null;
/*    */           }
/* 54 */           AISUB.AISubActivation s = (AI.SUBS()).walkTo.resource(a, d, (RBIT)this.bi, 2147483647);
/* 55 */           if (s == null) {
/* 56 */             for (Equip e : STATS.EQUIP().BATTLE_ALL()) {
/* 57 */               e.wearOut(a.indu());
/*    */             }
/*    */           }
/* 60 */           return s;
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 65 */           RESOURCE r = d.resourceCarried();
/* 66 */           for (EquipBattle e : STATS.EQUIP().BATTLE_ALL()) {
/* 67 */             if (r == e.resource && e.needed(a.indu()) > 0) {
/* 68 */               e.wearOut(a.indu());
/* 69 */               e.inc(a.indu(), 1);
/* 70 */               d.resourceCarriedSet(null);
/*    */               break;
/*    */             } 
/*    */           } 
/* 74 */           AISUB.AISubActivation s = set(a, d);
/* 75 */           return s;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 80 */           return ((STATS.BATTLE()).DIV.get(a) != null);
/*    */         }
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.fetchGear.set(a, d);
/*    */   }
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 92 */     if (e.event == HEvent.NOTIFY_CRIME && 
/* 93 */       e.other instanceof Humanoid) {
/* 94 */       d.overwrite(a, AI.listeners().catchCriminal((Humanoid)e.other));
/* 95 */       return true;
/*    */     } 
/*    */     
/* 98 */     return super.event(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\types\guard\PlanGear.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */