/*     */ package settlement.battle.invasion;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.diplomacy.DipStance;
/*     */ import game.faction.npc.FactionNPC;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class null
/*     */   extends DIP.DipActivityListener
/*     */ {
/*     */   public void change(Faction faction, Faction other, DipStance old, DipStance nn) {
/*  91 */     if (old == DIP.WAR() && nn != DIP.WAR()) {
/*  92 */       FactionNPC o = null;
/*  93 */       if (faction == FACTIONS.player()) {
/*  94 */         o = (FactionNPC)other;
/*     */       } else {
/*  96 */         o = (FactionNPC)faction;
/*     */       } 
/*  98 */       for (int i = 0; i < Invador.this.active.size(); i++) {
/*  99 */         if (((Invasion)Invador.this.active.get(i)).spec.fi == o.index())
/* 100 */           Invador.this.cancel(((Invasion)Invador.this.active.get(i)).spec.ref); 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\battle\invasion\Invador$5.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */