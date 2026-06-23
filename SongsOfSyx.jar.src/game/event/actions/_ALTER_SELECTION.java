/*    */ package game.event.actions;
/*    */ 
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.stats.Induvidual;
/*    */ import settlement.stats.STATS;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ final class _ALTER_SELECTION
/*    */   extends EventActionConstructor {
/*    */   _ALTER_SELECTION() {
/* 16 */     super("ALTER_SELECTION");
/*    */   }
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 21 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction {
/*    */     private final String name;
/*    */     private final int gender;
/*    */     private double age;
/*    */     private double dirtiness;
/*    */     
/*    */     Imp(String key, Json data, LISTE<EventAction> all) {
/* 32 */       super(key, all);
/* 33 */       this.name = data.text("NAME", null);
/* 34 */       this.gender = data.i("GENDER", 0, 2147483647, -1);
/* 35 */       this.dirtiness = data.dTry("DIRTINESS", 0.0D, 1.0D, -1.0D);
/* 36 */       data.checkUnused();
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void exe(Event event, EContext data) {
/* 45 */       ENTITY[] ee = SETT.ENTITIES().getAllEnts();
/*    */       
/* 47 */       for (int ie = 0; ie < ee.length; ie++) {
/* 48 */         ENTITY e = ee[ie];
/* 49 */         if (e instanceof Humanoid) {
/*    */ 
/*    */           
/* 52 */           Humanoid a = (Humanoid)e;
/* 53 */           if (STATS.EVENT().has(a.indu())) {
/* 54 */             Induvidual indu = a.indu();
/* 55 */             if (this.name != null)
/* 56 */               STATS.APPEARANCE().setCustomName(indu, "Hotam Greattusk"); 
/* 57 */             if (this.gender >= 0)
/* 58 */               (STATS.APPEARANCE()).gender.set(indu, Math.min(this.gender, (STATS.APPEARANCE()).gender.max(indu))); 
/* 59 */             if (this.age >= 0.0D)
/* 60 */               (STATS.POP()).age.dage.setD(indu, this.age); 
/* 61 */             if (this.dirtiness >= 0.0D)
/* 62 */               (STATS.NEEDS()).DIRTINESS.setD(indu, this.dirtiness); 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_ALTER_SELECTION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */