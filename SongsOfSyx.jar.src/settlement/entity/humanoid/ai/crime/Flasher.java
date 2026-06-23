/*    */ package settlement.entity.humanoid.ai.crime;
/*    */ 
/*    */ import init.type.CRIMES;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.text.D;
/*    */ 
/*    */ final class Flasher
/*    */   extends AIPLAN.PLANRES {
/* 16 */   private static CharSequence ¤¤verb = "¤Streaking";
/*    */   
/*    */   static {
/* 19 */     D.ts(Flasher.class);
/*    */   }
/*    */   final AIModule_Crime m;
/*    */   private final AIPLAN.PLANRES.Resumer go;
/*    */   
/*    */   public Flasher(String key, AIModule_Crime m) {
/* 25 */     super(key);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 34 */     this.go = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 38 */           Flasher.this.m.commitCrime(a, d, true, (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu()));
/* 39 */           (STATS.POP()).NAKED.set(a.indu(), 1);
/* 40 */           return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 1);
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 48 */           if (!RND.oneIn(4)) {
/* 49 */             (STATS.POP()).NAKED.set(a.indu(), 0);
/* 50 */             return null;
/*    */           } 
/*    */           
/* 53 */           AIModule_Crime.notify(a);
/* 54 */           return (AI.SUBS()).walkTo.run_arround_crazy(a, d, 1);
/*    */         }
/*    */ 
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 60 */           return true;
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
/* 72 */     if (e.event == HEvent.NOTIFY_CRIME)
/* 73 */       return false; 
/* 74 */     return super.event(a, d, e);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void cancel(Humanoid a, AIManager d) {
/* 79 */     (STATS.POP()).NAKED.set(a.indu(), 0);
/* 80 */     super.cancel(a, d);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\Flasher.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */