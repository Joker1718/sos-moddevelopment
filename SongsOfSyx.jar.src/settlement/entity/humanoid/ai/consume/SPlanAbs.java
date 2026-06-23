/*    */ package settlement.entity.humanoid.ai.consume;
/*    */ import init.settings.S;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.misc.util.FSERVICE;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import settlement.room.service.module.RoomServiceAccess;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ 
/*    */ abstract class SPlanAbs<T extends RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER> extends AIPLAN.PLANRES {
/*    */   public final LIST<T> services;
/*    */   
/*    */   public SPlanAbs(String key, LIST<T> services, boolean include) {
/* 21 */     super("SPlan_" + key);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 31 */     this.walk = new AIPLAN.PLANRES.Resumer(this, "Walk")
/*    */       {
/*    */         protected AISUB.AISubActivation setAction(Humanoid a, AIManager d)
/*    */         {
/* 35 */           AISUB.AISubActivation s = null;
/*    */           
/* 37 */           if (SPlanAbs.this.include) {
/* 38 */             s = (AI.SUBS()).walkTo.serviceInclude(a, d, (RoomService)SPlanAbs.this.blue(d).service(), ((STATS.FOOD()).STARVATION.indu().get(a.indu()) > 0) ? Integer.MAX_VALUE : (SPlanAbs.this.blue(d).service()).radius);
/*    */           } else {
/* 40 */             s = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(SPlanAbs.this.blue(d).service()).finder, ((STATS.FOOD()).STARVATION.indu().get(a.indu()) > 0) ? Integer.MAX_VALUE : (SPlanAbs.this.blue(d).service()).radius);
/* 41 */           }  if (s == null)
/* 42 */             return null; 
/* 43 */           d.planTile.set(d.path.destX(), d.path.destY());
/* 44 */           SPlanAbs.this.blue(d).service().reportDistance(a);
/* 45 */           SPlanAbs.this.blue(d).service().reportAccess(a, (COORDINATE)d.planTile);
/* 46 */           return s;
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 51 */           return SPlanAbs.this.arrive(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 56 */           return true;
/*    */         }
/*    */         public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */     this.services = services;
/*    */     this.include = include;
/*    */   }
/*    */   private final boolean include; private final AIPLAN.PLANRES.Resumer walk;
/*    */   protected AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.walk.set(a, d);
/*    */   }
/*    */   protected T blue(AIManager d) {
/* 68 */     return (T)this.services.get(d.planByte3);
/*    */   }
/*    */   
/*    */   protected abstract AISUB.AISubActivation arrive(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */   
/*    */   protected void name(Humanoid a, AIManager d, Str string) {
/* 74 */     string.add((blue(d).service()).verb);
/* 75 */     if ((S.get()).debug) {
/* 76 */       string.s().add('(');
/* 77 */       super.name(a, d, string);
/* 78 */       string.add(')');
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void cancel(Humanoid a, AIManager d) {
/* 85 */     super.cancel(a, d);
/*    */   }
/*    */   
/*    */   protected FSERVICE get(Humanoid a, AIManager d) {
/* 89 */     T blue = blue(d);
/* 90 */     if (blue != null)
/* 91 */       return blue.service().service(d.planTile.x(), d.planTile.y()); 
/* 92 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\consume\SPlanAbs.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */