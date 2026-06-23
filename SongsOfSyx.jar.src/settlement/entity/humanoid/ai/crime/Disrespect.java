/*    */ package settlement.entity.humanoid.ai.crime;
/*    */ 
/*    */ import init.type.CRIMES;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.room.main.throne.THRONE;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.text.D;
/*    */ 
/*    */ final class Disrespect
/*    */   extends AIPLAN.PLANRES {
/* 17 */   private static CharSequence ¤¤verb = "¤Disrespecting the ruler!";
/*    */   
/*    */   static {
/* 20 */     D.ts(Disrespect.class);
/*    */   }
/*    */   final AIModule_Crime m;
/*    */   private final AIPLAN.PLANRES.Resumer go;
/*    */   
/*    */   public Disrespect(String key, AIModule_Crime m) {
/* 26 */     super(key);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 35 */     this.go = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 39 */           d.planByte1 = (byte)(1 + RND.rInt(16));
/* 40 */           d.planByte2 = 0;
/* 41 */           return res(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 46 */           d.planByte2 = (byte)(d.planByte2 + 1);
/* 47 */           if (d.planByte2 == 1)
/* 48 */             Disrespect.this.m.commitCrime(a, d, false, (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu())); 
/* 49 */           d.planByte1 = (byte)(d.planByte1 - 1); if (d.planByte1 >= 0) {
/* 50 */             a.speed.turn2(a.tc().x(), a.tc().y(), THRONE.coo().x(), THRONE.coo().y());
/* 51 */             return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.fist.activate(a, d));
/*    */           } 
/* 53 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 58 */           return true;
/*    */         }
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */     this.m = m;
/*    */   }
/*    */   
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.go.set(a, d);
/*    */   }
/*    */   
/*    */   public boolean event(Humanoid a, AIManager d, HEvent.HEventData e) {
/* 70 */     if (e.event == HEvent.NOTIFY_CRIME) {
/* 71 */       return false;
/*    */     }
/* 73 */     return super.event(a, d, e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void cancel(Humanoid a, AIManager d) {
/* 78 */     super.cancel(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\Disrespect.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */