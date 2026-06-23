/*    */ package settlement.entity.humanoid.ai.battle;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.battle.div.Div;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.HPoll;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIEventListeners;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class InterBattle
/*    */ {
/* 16 */   public static final AIEventListeners.HEventListener listener = new AIEventListeners.HEventListener()
/*    */     {
/*    */       public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/*    */         Div div;
/* 20 */         switch (e.event) {
/*    */           case MEET_HARMLESS:
/* 22 */             return false;
/*    */           case COLLISION_SOFT:
/* 24 */             d.interrupt(a, e);
/* 25 */             d.overwrite(a, (AI.modules()).battle.subSoft.initReady(d, a, e.other, e.norX, e.norY, e.facingDot, e.momentum));
/*    */           
/*    */           case MEET_ENEMY:
/* 28 */             d.interrupt(a, e);
/* 29 */             (AI.modules()).battle.soundSword.rnd(a);
/* 30 */             d.overwrite(a, (AI.modules()).battle.subSoft.initReady(d, a, e.other, e.norX, e.norY, e.facingDot, e.momentum));
/*    */ 
/*    */           
/*    */           case CHECK_MORALE:
/* 34 */             div = a.division();
/* 35 */             if (div == null) {
/* 36 */               return AIEventListeners.def.event(a, d, e);
/*    */             }
/* 38 */             if (div.settings().mustering() && div.morale() <= 0.0D) {
/* 39 */               d.overwrite(a, (AI.modules()).battle.dessert);
/*    */             }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */           
/*    */           case null:
/* 59 */             return false;case COLLISION_TILE: if ((AI.modules()).battle.tile.shouldattackTile(d, a, e.tx, e.ty)) { d.overwrite(a, (AI.modules()).battle.tile.init(d, a, e.tx, e.ty)); } else { d.interrupt(a, e); d.overwrite(a, (AI.SUBS()).STAND.activateTime(a, d, 1)); return true; } case NOTIFY_CRIME: return false;
/*    */         } 
/*    */         return AIEventListeners.def.event(a, d, e);
/*    */       }
/*    */       public double poll(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 64 */         if (e.type == HPoll.DEFENCE_SKILL) {
/* 65 */           return (GAME.battle()).fight.valueDefenceSkill(a, e.facingDot, e.adx, e.ady);
/*    */         }
/* 67 */         if (e.type == HPoll.PARRY_SKILL) {
/* 68 */           return (GAME.battle()).fight.valueParrySkill(a, e.facingDot, e.adx, e.ady);
/*    */         }
/* 70 */         return AIEventListeners.def.poll(a, d, e);
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static double pollReady(Humanoid a, AIManager d, HPoll.HPollData e) {
/* 80 */     if (e.type == HPoll.IMPACT_DAMAGE) {
/* 81 */       if (e.isEnemy) {
/* 82 */         (GAME.battle()).fight.setImpactDamage(a, e.colli, e.damage);
/*    */       } else {
/* 84 */         e.damage.damagetileStrength = 0.0D;
/*    */       } 
/* 86 */       return 0.0D;
/*    */     } 
/* 88 */     if (e.type == HPoll.DEFENCE_SKILL) {
/* 89 */       return (GAME.battle()).fight.valueDefenceSkill(a, e.facingDot, e.adx, e.ady);
/*    */     }
/* 91 */     if (e.type == HPoll.PARRY_SKILL) {
/* 92 */       return (GAME.battle()).fight.valueParrySkill(a, e.facingDot, e.adx, e.ady);
/*    */     }
/*    */ 
/*    */     
/* 96 */     return AIEventListeners.def.poll(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\battle\InterBattle.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */