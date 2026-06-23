/*    */ package game.tourism;
/*    */ 
/*    */ import init.race.Race;
/*    */ import settlement.entity.humanoid.Humanoid;
/*    */ import settlement.room.main.RoomBlueprintIns;
/*    */ import snake2d.LOG;
/*    */ import snake2d.util.misc.ACTION;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements ACTION
/*    */ {
/*    */   public void exe() {
/* 68 */     Race r = Updater.this.getRace();
/* 69 */     Humanoid h = Updater.this.pspawn(r, (RoomBlueprintIns)(r.tourism()).attractions.rnd());
/* 70 */     if (h == null) {
/* 71 */       LOG.ln("nope");
/*    */     } else {
/* 73 */       Updater.this.mess(h);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\tourism\Updater$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */