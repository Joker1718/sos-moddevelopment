/*    */ package game.events.faction;
/*    */ 
/*    */ import game.events.faction.player.EventDiplomacy;
/*    */ 
/*    */ public final class EventWorld
/*    */ {
/*  7 */   public final EventFactionExpand factionExpand = new EventFactionExpand();
/*  8 */   public final EventFactionCollapse factionBreak = new EventFactionCollapse();
/*  9 */   public final EventFactionPopup popup = new EventFactionPopup();
/* 10 */   public final EventFactionWar war = new EventFactionWar();
/* 11 */   public final EventFactionPeace warPeace = new EventFactionPeace();
/* 12 */   public final EventDiplomacy dip = new EventDiplomacy();
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\EventWorld.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */