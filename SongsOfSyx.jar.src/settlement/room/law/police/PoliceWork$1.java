/*    */ package settlement.room.law.police;
/*    */ 
/*    */ import init.type.CAUSE_LEAVES;
/*    */ import settlement.entity.ENTITY;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.main.ROOMA;
/*    */ import settlement.room.main.util.RoomBits;
/*    */ import snake2d.util.bit.Bits;
/*    */ import snake2d.util.datatypes.COORDINATE;
/*    */ import snake2d.util.rnd.RND;
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
/*    */ class null
/*    */   extends RoomBits
/*    */ {
/*    */   null(COORDINATE $anonymous0, Bits $anonymous1) {
/* 33 */     super($anonymous0, $anonymous1);
/*    */   }
/*    */   
/*    */   public void set(ROOMA r, int t) {
/* 37 */     if (get() > 0)
/* 38 */       PoliceWork.this.ins.prisoners--; 
/* 39 */     if (t == 0) {
/* 40 */       ENTITY e = SETT.ENTITIES().getAtTileSingle(PoliceWork.this.coo.x(), PoliceWork.this.coo.y());
/* 41 */       if (e != null && e instanceof Humanoid) {
/* 42 */         Humanoid h = (Humanoid)e;
/* 43 */         if (RND.oneIn(5))
/* 44 */           h.kill(false, CAUSE_LEAVES.PUNISHED()); 
/* 45 */         h.interrupt();
/*    */       } 
/*    */     } 
/* 48 */     super.set(r, t);
/* 49 */     if (get() > 0)
/* 50 */       PoliceWork.this.ins.prisoners++; 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\PoliceWork$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */