/*    */ package util.text;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.player.PLevels;
/*    */ import snake2d.util.misc.CLAMP;
/*    */ import snake2d.util.sprite.text.Str;
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
/*    */   extends Inserter<Faction>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 42 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Faction t, Str str) {
/* 46 */     if (t == FACTIONS.player()) {
/* 47 */       str.add(FACTIONS.player().level().current().name());
/*    */     } else {
/* 49 */       double d = t.realm().regions() / 20.0D;
/* 50 */       int i = (int)(d * FACTIONS.player().level().all().size());
/* 51 */       i = CLAMP.i(i, 0, FACTIONS.player().level().all().size() - 1);
/* 52 */       str.add(((PLevels.Level)FACTIONS.player().level().all().get(i)).male);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertFaction$3.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */