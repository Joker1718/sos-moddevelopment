/*    */ package view.ui.diplomacy;
/*    */ 
/*    */ import game.faction.FACTIONS;
/*    */ import game.faction.Faction;
/*    */ import game.faction.npc.FactionNPC;
/*    */ import java.io.Serializable;
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
/*    */ class MessFaction
/*    */   implements Serializable
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   private final int fi;
/*    */   private final int fii;
/*    */   
/*    */   MessFaction(FactionNPC f) {
/* 56 */     this.fi = f.index();
/* 57 */     this.fii = f.iteration();
/*    */   }
/*    */   
/*    */   public FactionNPC faction() {
/* 61 */     Faction f = FACTIONS.getByIndex(this.fi);
/* 62 */     if (f == null || !f.isActive() || !(f instanceof FactionNPC))
/* 63 */       return null; 
/* 64 */     FactionNPC npc = (FactionNPC)f;
/* 65 */     if (npc.iteration() != this.fii)
/* 66 */       return null; 
/* 67 */     return npc;
/*    */   }
/*    */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\diplomacy\UIDipMess$MessFaction.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */