/*    */ package settlement.stats.service;
/*    */ import init.type.NEEDS;
/*    */ import settlement.main.SETT;
/*    */ import settlement.room.water.pool.ROOM_POOL;
/*    */ import settlement.stats.StatsInit;
/*    */ import snake2d.util.sets.LISTE;
/*    */ import snake2d.util.sprite.SPRITE;
/*    */ import util.text.D;
/*    */ 
/*    */ final class StatServiceSkinny extends StatServiceSimple {
/* 11 */   private static CharSequence ¤¤name = "Skinnydipping";
/* 12 */   private static CharSequence ¤¤desc = "When the weather allows for it, subjects might want to have a dip in a pool of water.";
/*    */   
/*    */   static {
/* 15 */     D.ts(StatServiceSkinny.class);
/*    */   }
/*    */   
/*    */   StatServiceSkinny(LISTE<StatServiceImp> all, StatsInit init) {
/* 19 */     super("MISC_SKINNYDIP", all, init, ¤¤name, ¤¤desc, (SPRITE)((ROOM_POOL)(SETT.ROOMS()).POOLS.get(0)).icon, (NEEDS.TYPES()).SKINNYDIP);
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\stats\service\StatServiceSkinny.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */