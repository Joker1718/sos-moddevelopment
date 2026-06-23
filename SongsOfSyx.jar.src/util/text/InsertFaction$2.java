/*    */ package util.text;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
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
/*    */ class null
/*    */   extends Inserter<Faction>.II
/*    */ {
/*    */   null(Inserter paramInserter, String $anonymous0) {
/* 30 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Faction t, Str str) {
/* 34 */     if (t == FACTIONS.player()) {
/* 35 */       str.add(FACTIONS.player().rulerName());
/*    */     } else {
/* 37 */       str.add((CharSequence)(((FactionNPC)t).court().king()).name);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertFaction$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */