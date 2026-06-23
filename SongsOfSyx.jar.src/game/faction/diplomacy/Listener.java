/*    */ package game.faction.diplomacy;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import init.sprite.UI.UI;
/*    */ import snake2d.util.sprite.text.Str;
/*    */ import util.text.D;
/*    */ import view.ui.message.MessageText;
/*    */ import world.WORLD;
/*    */ import world.region.RD;
/*    */ 
/*    */ final class Listener
/*    */   extends DIP.DipActivityListener
/*    */ {
/* 15 */   private static CharSequence ¤¤warDeclared = "The realm of {0} has declared war on {1}.";
/* 16 */   private static CharSequence ¤¤warPeace = "{0} and {1} have agreed to a truce.";
/*    */   
/* 18 */   private static CharSequence ¤¤mTitle = "Distant war.";
/* 19 */   private static CharSequence ¤¤mBody = "One of your neighbours have gone to war. This could be an opportunity to snatch a cheap alliance, or join one of the sides to take part of the spoils.";
/*    */   
/* 21 */   private static CharSequence ¤¤trade = "{FACTION_A} and {FACTION_B} are now trade partners.";
/*    */   
/*    */   static {
/* 24 */     D.ts(Listener.class);
/*    */   }
/*    */ 
/*    */   
/*    */   public void change(Faction faction, Faction other, DipStance old, DipStance nn) {
/* 29 */     if (nn == DIP.WAR() || old == DIP.WAR()) {
/* 30 */       Str.TMP.clear().add((nn == DIP.WAR()) ? ¤¤warDeclared : ¤¤warPeace);
/* 31 */       Str.TMP.insert(0, (CharSequence)faction.name);
/* 32 */       Str.TMP.insert(1, (CharSequence)other.name);
/* 33 */       WORLD.LOG().log(faction, other, (UI.icons()).s.sword, (CharSequence)Str.TMP, other.cx(), other.cy());
/* 34 */       if ((other != FACTIONS.player() && faction != FACTIONS.player() && RD.DIST().factionHasRegionBorderingPlayer(other)) || RD.DIST().factionHasRegionBorderingPlayer(faction)) {
/* 35 */         (new MessageText(¤¤mTitle)).paragraph(¤¤mBody).send();
/*    */       }
/* 37 */     } else if (!old.trades && nn.trades) {
/* 38 */       Str.TMP.clear().add(¤¤trade);
/* 39 */       Str.TMP.insert(0, (CharSequence)faction.name);
/* 40 */       Str.TMP.insert(1, (CharSequence)other.name);
/* 41 */       if (other.capitolRegion() != null)
/* 42 */         WORLD.LOG().log(faction, other, (UI.icons()).s.trade, (CharSequence)Str.TMP, other.cx(), other.cy()); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\Listener.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */