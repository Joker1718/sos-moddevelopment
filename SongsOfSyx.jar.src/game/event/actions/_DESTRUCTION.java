/*    */ package game.event.actions;
/*    */ 
/*    */ import game.GAME;
/*    */ import game.event.engine.EContext;
/*    */ import game.event.engine.Event;
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.file.Json;
/*    */ import snake2d.util.rnd.RND;
/*    */ import snake2d.util.sets.LISTE;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class _DESTRUCTION
/*    */   extends EventActionConstructor
/*    */ {
/*    */   _DESTRUCTION() {
/* 20 */     super("DESTRUCTION");
/*    */   }
/*    */ 
/*    */   
/*    */   public EventAction action(EventActionConstructor.Data data) {
/* 25 */     return new Imp(this.key, data.json, data.all);
/*    */   }
/*    */   
/*    */   public final class Imp
/*    */     extends EventAction
/*    */   {
/*    */     public final double death;
/*    */     public final double destruction;
/*    */     public final double degrade;
/*    */     
/*    */     Imp(String key, Json data, LISTE<EventAction> all) {
/* 36 */       super(key, all);
/* 37 */       this.death = data.dTry("DEATH", 0.0D, 1000.0D, 0.0D);
/* 38 */       this.destruction = data.dTry("DESTRUCTION", 0.0D, 1000.0D, 0.0D);
/* 39 */       this.degrade = data.dTry("DEGRADE", 0.0D, 1000.0D, 0.0D);
/* 40 */       data.checkUnused();
/*    */     }
/*    */     double dacc; double kacc;
/*    */     double accd;
/*    */     
/*    */     public void setContext(Event event, EContext data) {
/* 46 */       this.dacc = 0.0D;
/* 47 */       this.kacc = 0.0D;
/* 48 */       this.accd = 0.0D;
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/*    */     public void update(Event event, EContext e, double ds, double second) {
/* 60 */       this.dacc += ds * this.destruction;
/* 61 */       while (this.dacc > 0.0D) {
/* 62 */         this.dacc--;
/* 63 */         int tx = RND.rInt(SETT.TWIDTH);
/* 64 */         int ty = RND.rInt(SETT.THEIGHT);
/* 65 */         (GAME.ARMIES()).map.breakIt(tx, ty);
/*    */       } 
/* 67 */       this.kacc += ds * this.death;
/* 68 */       while (this.kacc > 0.0D) {
/* 69 */         this.kacc--;
/* 70 */         int tx = RND.rInt(SETT.TWIDTH);
/* 71 */         int ty = RND.rInt(SETT.THEIGHT);
/*    */         
/* 73 */         for (ENTITY ent : SETT.ENTITIES().getAtTile(tx, ty)) {
/* 74 */           if (ent instanceof settlement.entity.humanoid.Humanoid) {
/* 75 */             _SUBJECTS_KILL.slap(e, ent, 1.0D, CAUSE_LEAVES.SLAYED());
/*    */           }
/*    */         } 
/*    */       } 
/* 79 */       this.accd += ds * this.degrade;
/* 80 */       while (this.accd > 0.0D) {
/* 81 */         this.accd--;
/* 82 */         int tx = RND.rInt(SETT.TWIDTH);
/* 83 */         int ty = RND.rInt(SETT.THEIGHT);
/* 84 */         SETT.MAINTENANCE().vandalise(tx, ty);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\event\actions\_DESTRUCTION.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */