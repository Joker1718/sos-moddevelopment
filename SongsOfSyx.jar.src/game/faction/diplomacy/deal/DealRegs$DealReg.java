/*     */ package game.faction.diplomacy.deal;
/*     */ 
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.diplomacy.DIP;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import util.data.BOOLEAN;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class DealReg
/*     */   implements BOOLEAN.BOOLEAN_MUTABLE
/*     */ {
/*     */   private Region reg;
/*     */   
/*     */   public Region reg() {
/* 246 */     return this.reg;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean is() {
/* 251 */     return DealRegs.this.selected(this.reg);
/*     */   }
/*     */ 
/*     */   
/*     */   public BOOLEAN.BOOLEAN_MUTABLE set(boolean b) {
/* 256 */     DealRegs.this.data.selected.set(this.reg.index(), b);
/* 257 */     DealRegs.this.dirty = true;
/* 258 */     return this;
/*     */   }
/*     */   
/*     */   public double value() {
/* 262 */     if (DealRegs.this.reciever instanceof FactionNPC && this.reg.faction() == FACTIONS.player() && DIP.WAR().is((FactionNPC)DealRegs.this.reciever) && !DealRegs.this.deal.bools.PEACE.is())
/* 263 */       return 0.0D; 
/* 264 */     return DealRegs.this.data.values[this.reg.index()];
/*     */   }
/*     */   
/*     */   public boolean canSelect() {
/* 268 */     if (DealRegs.this.deal.bools.ABSORB.is())
/* 269 */       return false; 
/* 270 */     return DealRegs.this.data.canSelect.get(this.reg.index());
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\diplomacy\deal\DealRegs$DealReg.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */