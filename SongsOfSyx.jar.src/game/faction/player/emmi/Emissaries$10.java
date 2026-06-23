/*     */ package game.faction.player.emmi;
/*     */ 
/*     */ import game.faction.royalty.NPCCourt;
/*     */ import game.faction.royalty.Royalty;
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
/*     */   extends NPCCourt.RoyaltyEventListener
/*     */ {
/*     */   public void change(int successionI, Royalty old, Royalty nn) {
/* 141 */     if (old != null)
/* 142 */       Emissaries.this.assasinate.set(old, 0); 
/* 143 */     if (successionI == 0)
/*     */       return; 
/* 145 */     if (successionI == 0 && nn != null) {
/* 146 */       int o = (old == null) ? 0 : Emissaries.this.flatter.get(old);
/* 147 */       int n = Emissaries.this.flatter.get(nn);
/* 148 */       o = Math.max(o, n);
/* 149 */       Emissaries.this.flatter.set(successionI, o);
/* 150 */       o = (old == null) ? 0 : Emissaries.this.sabotage.get(old);
/* 151 */       n = Emissaries.this.sabotage.get(nn);
/* 152 */       o = Math.max(o, n);
/* 153 */       Emissaries.this.sabotage.set(successionI, o);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\player\emmi\Emissaries$10.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */