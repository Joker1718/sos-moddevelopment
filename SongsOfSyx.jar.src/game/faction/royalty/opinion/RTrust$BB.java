/*     */ package game.faction.royalty.opinion;
/*     */ 
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.superb.SuperBoostableObj;
/*     */ import game.boosting.superb.SuperSpec;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.royalty.Royalty;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class BB
/*     */   extends SuperSpec<Royalty>
/*     */ {
/*     */   public BB(CharSequence name, SPRITE icon, double from, double to, boolean isMul) {
/* 130 */     super(RTrust.BOOST(), new BSourceInfo(name, icon), "", from, to, isMul);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double secondsRemaining(Royalty bo) {
/* 137 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double increase(Royalty bo) {
/* 143 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(Royalty o) {
/* 148 */     if (o == null) {
/* 149 */       return 0.0D;
/*     */     }
/* 151 */     return vGet(o.court.faction);
/*     */   }
/*     */   
/*     */   protected abstract double vGet(FactionNPC paramFactionNPC);
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\faction\royalty\opinion\RTrust$BB.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */