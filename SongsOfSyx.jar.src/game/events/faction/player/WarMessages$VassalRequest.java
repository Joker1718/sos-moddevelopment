/*     */ package game.events.faction.player;
/*     */ 
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.opinion.ROPINION;
/*     */ import view.ui.diplomacy.UIDipMessAction;
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
/*     */ class VassalRequest
/*     */   extends UIDipMessAction
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*     */   
/*     */   public VassalRequest(FactionNPC f) {
/* 111 */     super(WarMessages.¤¤breakTitle, ((f.king()).induvidual.race().kingMessage()).THREAT_VASSAL.get(f), WarMessages.¤¤breakBody, f, f, 1.0D, -1.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void accept(FactionNPC f, FactionNPC o) {
/* 116 */     DIP.PACT().set(f);
/* 117 */     ROPINION.OTHER().liberate(f);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean valid(FactionNPC f, FactionNPC o) {
/* 122 */     return DIP.VASSAL().is(f);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\events\faction\player\WarMessages$VassalRequest.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */