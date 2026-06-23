/*    */ package settlement.entity.humanoid.ai.service;
/*    */ import init.settings.S;
/*    */ import init.type.NEED;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AIPLAN;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.path.finders.SFinderFindable;
/*    */ import settlement.room.service.module.RoomService;
/*    */ import settlement.room.service.module.RoomServiceAccess;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.sets.LIST;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ 
/*    */ public abstract class MPlan<T extends RoomServiceAccess.ROOM_SERVICE_ACCESS_HASER> extends AIPLAN.PLANRES {
/*    */   static int dist;
/*    */   public final LIST<T> services;
/*    */   
/*    */   public MPlan(String key, LIST<T> services, boolean include) {
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
/* 37 */           if (MPlan.this.include) {
/* 38 */             s = (AI.SUBS()).walkTo.serviceInclude(a, d, (RoomService)MPlan.this.blue(d).service(), MPlan.dist);
/*    */           } else {
/* 40 */             s = (AI.SUBS()).walkTo.service(a, d, (SFinderFindable)(MPlan.this.blue(d).service()).finder, MPlan.dist);
/* 41 */           }  if (s == null)
/* 42 */             return null; 
/* 43 */           d.planTile.set(d.path.destX(), d.path.destY());
/* 44 */           MPlan.this.blue(d).service().reportAccess(a, (COORDINATE)d.planTile);
/* 45 */           MPlan.this.blue(d).service().reportDistance(a);
/* 46 */           MPlan.this.blue(d).service().reportAccess(a, (COORDINATE)d.planTile);
/* 47 */           return s;
/*    */         }
/*    */ 
/*    */         
/*    */         protected AISUB.AISubActivation res(Humanoid a, AIManager d) {
/* 52 */           return MPlan.this.arrive(a, d);
/*    */         }
/*    */ 
/*    */         
/*    */         public boolean con(Humanoid a, AIManager d) {
/* 57 */           return true;
/*    */         } public void can(Humanoid a, AIManager d) {}
/*    */       };
/*    */     this.services = services;
/*    */     this.include = include;
/*    */   }
/*    */   private final boolean include; private final AIPLAN.PLANRES.Resumer walk;
/*    */   protected final AISUB.AISubActivation init(Humanoid a, AIManager d) {
/*    */     return this.walk.set(a, d);
/*    */   }
/*    */   protected abstract AISUB.AISubActivation arrive(Humanoid paramHumanoid, AIManager paramAIManager);
/*    */   protected T blue(AIManager d) {
/* 69 */     return (T)this.services.get(d.planByte3);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void name(Humanoid a, AIManager d, Str string) {
/* 75 */     string.add((blue(d).service()).verb);
/* 76 */     if ((S.get()).debug) {
/* 77 */       string.s().add('(');
/* 78 */       super.name(a, d, string);
/* 79 */       string.add(')');
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void cancel(Humanoid a, AIManager d) {
/* 86 */     super.cancel(a, d);
/*    */   }
/*    */   
/*    */   protected FSERVICE get(Humanoid a, AIManager d) {
/* 90 */     T blue = blue(d);
/* 91 */     if (blue != null)
/* 92 */       return blue.service().service(d.planTile.x(), d.planTile.y()); 
/* 93 */     return null;
/*    */   }
/*    */   
/*    */   public NEED need(AIManager d) {
/* 97 */     return (blue(d).service()).need;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\service\MPlan.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */