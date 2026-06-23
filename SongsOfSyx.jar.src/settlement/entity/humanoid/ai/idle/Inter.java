/*    */ package settlement.entity.humanoid.ai.idle;
/*    */ 
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.HEvent;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.entity.humanoid.ai.main.AI;
/*    */ import settlement.entity.humanoid.ai.main.AIEventListeners;
/*    */ import settlement.entity.humanoid.ai.main.AIManager;
/*    */ import settlement.entity.humanoid.ai.main.AISTATE;
/*    */ import settlement.entity.humanoid.ai.main.AISUB;
/*    */ import settlement.main.SETT;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.datatypes.DIR;
/*    */ import snake2d.util.rnd.RND;
/*    */ import util.text.D;
/*    */ 
/*    */ class Inter
/*    */   implements AIEventListeners.Default
/*    */ {
/* 20 */   private static CharSequence ¤¤MoveAway = "¤making way";
/*    */   
/*    */   static {
/* 23 */     D.ts(Inter.class);
/*    */   }
/*    */   
/* 26 */   private final AISUB sub = (AISUB)new AISUB.Simple("IdleMoveAway", ¤¤MoveAway)
/*    */     {
/*    */       protected AISTATE resume(Humanoid a, AIManager d)
/*    */       {
/* 30 */         d.subByte = (byte)(d.subByte + 1);
/* 31 */         switch (d.subByte) { case 1:
/* 32 */             return (AI.STATES()).STOP.instant(a, d);
/* 33 */           case 2: return (AI.STATES()).WALK2.cTile(a, d);
/* 34 */           case 3: return (AI.STATES()).STAND.activate(a, d, 0.5D);
/*    */           case 4:
/* 36 */             if (d.subPathByte >= DIR.ALL.size() || d.subPathByte < 0)
/* 37 */               return (AI.STATES()).STOP.activate(a, d); 
/* 38 */             a.speed.setDirCurrent((DIR)DIR.ALL.get(d.subPathByte));
/* 39 */             return (AI.STATES()).WALK2.dirTile(a, d, a.speed.dir());
/* 40 */           case 5: a.speed.magnitudeInit(0.0D); return (AI.STATES()).STOP.activate(a, d);
/* 41 */           case 6: return (AI.STATES()).STAND.activate(a, d, (3.0F + RND.rFloat(3.0D)));
/* 42 */           case 7: return (AI.STATES()).STOP.instant(a, d);
/* 43 */           case 8: return null; }
/*    */         
/* 45 */         return null;
/*    */       }
/*    */     };
/*    */ 
/*    */   
/* 50 */   private final AISUB subMoveaway = (AISUB)new AISUB.Simple("IdleMoveAway2", ¤¤MoveAway)
/*    */     {
/*    */       protected AISTATE resume(Humanoid a, AIManager d)
/*    */       {
/* 54 */         d.subByte = (byte)(d.subByte + 1);
/* 55 */         switch (d.subByte) {
/*    */           case 1:
/* 57 */             (SETT.PATH()).finders.getOutofWay.request(a, d.path);
/* 58 */             return (AI.STATES()).STOP.instant(a, d);
/* 59 */           case 2: return (AI.STATES()).STAND.activate(a, d, 1.5D);
/*    */           case 3:
/* 61 */             if ((SETT.PATH()).finders.getOutofWay.checkAndSetRequest(a.tc().x(), a.tc().y(), d.path) && 
/* 62 */               d.path.isSuccessful()) {
/* 63 */               d.overwrite(a, (AI.SUBS()).walkTo.path(a, d));
/*    */             }
/*    */           case 4:
/* 66 */             return (AI.STATES()).STOP.activate(a, d);
/* 67 */           case 5: return (AI.STATES()).STAND.activate(a, d, (3.0F + RND.rFloat(3.0D)));
/*    */         } 
/* 69 */         return null;
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean event(Humanoid a, AIManager ai, HEvent.HEventData e) {
/* 76 */     if (e.event == HEvent.MEET_HARMLESS) {
/* 77 */       COORDINATE c = a.physics.tileC();
/* 78 */       DIR d = e.other.speed.dir();
/* 79 */       int dd = RND.rBoolean() ? 1 : -1;
/* 80 */       d = d.next(-2 * dd);
/* 81 */       for (int i = 0; i < 5; i++) {
/* 82 */         if ((SETT.PATH()).coster.player.getCost(c.x(), c.y(), c.x() + d.x(), c.y() + d.y()) > 0.0D && (SETT.PATH()).finders.isGoodTileToStandOn(c.x() + d.x(), c.y() + d.y(), (ENTITY)a)) {
/* 83 */           a.speed.setDirCurrent(d);
/*    */           
/* 85 */           ai.interrupt(a, e);
/* 86 */           ai.subPathByte = (byte)d.id();
/* 87 */           ai.overwrite(a, this.sub.activate(a, ai));
/*    */           
/* 89 */           return false;
/*    */         } 
/* 91 */         d = d.next(-dd);
/*    */       } 
/* 93 */       ai.interrupt(a, e);
/* 94 */       ai.overwrite(a, this.subMoveaway.activate(a, ai));
/*    */     } 
/* 96 */     return super.event(a, ai, e);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\entity\humanoid\ai\idle\Inter.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */