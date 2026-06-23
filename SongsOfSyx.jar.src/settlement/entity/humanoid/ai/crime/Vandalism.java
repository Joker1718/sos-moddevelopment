/*    */ package settlement.entity.humanoid.ai.crime;
/*    */ 
/*    */ import init.resources.RBIT;
/*    */ import init.type.CRIMES;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.STATS;
/*    */ import util.text.D;
/*    */ 
/*    */ final class Vandalism extends AIPLAN.PLANRES {
/*    */   final AIModule_Crime m;
/* 17 */   private static CharSequence ¤¤verb = "¤Vandalizing"; private final AIPLAN.PLANRES.Resumer go;
/*    */   
/*    */   static {
/* 20 */     D.ts(Vandalism.class);
/*    */   }
/*    */   
/*    */   private final AIPLAN.PLANRES.Resumer next;
/*    */   
/*    */   public Vandalism(String key, AIModule_Crime m) {
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
/* 39 */           if ((SETT.PATH()).finders.maintenance.find(RBIT.ALL, a.tc(), d.path, 100))
/* 40 */             return (AI.SUBS()).walkTo.path(a, d); 
/* 41 */           if ((SETT.MAINTENANCE()).isser.is(a.tc().x(), a.tc().y())) {
/* 42 */             return (AI.SUBS()).walkTo.coo(a, d, a.tc().x(), a.tc().y());
/*    */           }
/* 44 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 49 */           return Vandalism.this.next.set(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 54 */           return true;
/*    */         }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/* 64 */     this.next = new AIPLAN.PLANRES.Resumer(this, ¤¤verb)
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 68 */           return (AI.SUBS()).single.activate(a, d, (AI.STATES()).anima.box, 2.5D);
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 73 */           Vandalism.this.m.commitCrime(a, d, true, (CRIMES.CRIME)(STATS.LAW()).prisonerType.get(a.indu()));
/* 74 */           SETT.MAINTENANCE().vandalise(d.path.destX(), d.path.destY());
/* 75 */           return null;
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 80 */           return true;
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
/* 92 */     if (e.event == HEvent.NOTIFY_CRIME)
/* 93 */       return false; 
/* 94 */     return super.event(a, d, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\crime\Vandalism.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */