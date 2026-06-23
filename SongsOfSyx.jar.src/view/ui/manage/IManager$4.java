/*     */ package view.ui.manage;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.faction.FACTIONS;
/*     */ import init.trade.TR;
/*     */ import init.trade.TRADABLE;
/*     */ import util.gui.misc.GStat;
/*     */ import util.gui.misc.GText;
/*     */ import util.info.GFORMAT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends GStat
/*     */ {
/* 203 */   int ri = 0;
/* 204 */   int prob = 0;
/* 205 */   int probL = 0;
/*     */ 
/*     */   
/*     */   public void update(GText text) {
/* 209 */     if ((GAME.updateI() & 0x11) == 0) {
/* 210 */       if (this.ri >= TR.ALL().size()) {
/* 211 */         this.probL = this.prob;
/* 212 */         this.prob = 0;
/* 213 */         this.ri = 0;
/*     */       } else {
/* 215 */         TRADABLE res = (TRADABLE)TR.ALL().get(this.ri);
/*     */         
/* 217 */         if (this.prob < 2) {
/* 218 */           if (FACTIONS.player().buyer(res).importing() && FACTIONS.player().buyer(res).problem() != null)
/* 219 */             this.prob = 2; 
/* 220 */           if (FACTIONS.player().seller(res).exporting() == null && FACTIONS.player().seller(res).problem() != null) {
/* 221 */             this.prob = 2;
/*     */           }
/*     */         } 
/* 224 */         if (this.prob < 1) {
/* 225 */           if (FACTIONS.player().buyer(res).importing() && FACTIONS.player().buyer(res).warning() != null)
/* 226 */             this.prob = 1; 
/* 227 */           if (FACTIONS.player().seller(res).exporting() == null && FACTIONS.player().seller(res).warning() != null)
/* 228 */             this.prob = 1; 
/*     */         } 
/* 230 */         this.ri++;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 236 */     GFORMAT.i(text, (int)FACTIONS.player().credits().credits());
/*     */     
/* 238 */     if (this.probL == 0) {
/* 239 */       text.normalify();
/* 240 */     } else if (this.probL == 1) {
/* 241 */       text.warnify();
/*     */     } else {
/* 243 */       text.errorify();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\manage\IManager$4.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */