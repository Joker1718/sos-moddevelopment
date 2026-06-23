/*    */ package world.log;
/*    */ 
/*    */ import game.faction.Faction;
/*    */ import game.faction.diplomacy.DIP;
/*    */ import game.faction.diplomacy.DipStance;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import world.WORLD;
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
/*    */   extends DIP.DipActivityListener
/*    */ {
/*    */   public void change(Faction faction, Faction other, DipStance old, DipStance nn) {
/* 33 */     if (nn == DIP.WAR()) {
/* 34 */       Str.TMP.clear();
/* 35 */       Str.TMP.add(WorldLog.¤¤war);
/* 36 */       Str.TMP.insert(0, (CharSequence)faction.name);
/* 37 */       Str.TMP.insert(1, (CharSequence)other.name);
/* 38 */       WORLD.LOG().log(faction, other, (UI.icons()).s.sword, (CharSequence)Str.TMP, faction.cx(), faction.cy());
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\world\log\WorldLog$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */