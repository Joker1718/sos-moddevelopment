/*    */ package util.text;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import game.faction.player.PTitles;
/*    */ import init.type.TRAIT;
/*    */ import snake2d.util.sets.ArrayListGrower;
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
/* 72 */     super($anonymous0);
/*    */   }
/*    */   
/*    */   public void set(Faction ff, Str str) {
/* 76 */     if (ff == FACTIONS.player()) {
/* 77 */       for (PTitles.PTitle t : (FACTIONS.player()).titles.all()) {
/* 78 */         if (t.selected()) {
/* 79 */           str.add(t.name);
/* 80 */           str.add(',').s();
/*    */         } 
/*    */       } 
/*    */     } else {
/*    */       
/* 85 */       FactionNPC t = (FactionNPC)ff;
/* 86 */       ArrayListGrower arrayListGrower = (t.court().king().roy()).traits;
/* 87 */       for (int i = 0; i < arrayListGrower.size(); i++) {
/* 88 */         str.add(((TRAIT)arrayListGrower.get(i)).rTitle);
/* 89 */         if (i < arrayListGrower.size() - 1)
/* 90 */           str.add(',').s(); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar\\util\text\InsertFaction$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */