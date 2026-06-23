/*     */ package view.ui.div;
/*     */ 
/*     */ import game.battle.util.DIV_SPEC;
/*     */ import game.faction.Faction;
/*     */ import init.race.Race;
/*     */ import settlement.stats.colls.StatsBattle;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   implements DIV_SPEC
/*     */ {
/*     */   public double training(StatsBattle.StatTraining tr) {
/*  80 */     return UIDivCardWorld.this.sd.target().training(tr);
/*     */   }
/*     */ 
/*     */   
/*     */   public double equip(EquipBattle e) {
/*  85 */     return UIDivCardWorld.this.sd.target().equip(e);
/*     */   }
/*     */ 
/*     */   
/*     */   public Race race() {
/*  90 */     return UIDivCardWorld.this.sd.race();
/*     */   }
/*     */ 
/*     */   
/*     */   public CharSequence name() {
/*  95 */     return UIDivCardWorld.this.sd.name();
/*     */   }
/*     */ 
/*     */   
/*     */   public int men() {
/* 100 */     return UIDivCardWorld.this.sd.menTarget();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Faction faction() {
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public double experience() {
/* 111 */     return UIDivCardWorld.this.sd.experience();
/*     */   }
/*     */ 
/*     */   
/*     */   public int bannerI() {
/* 116 */     return UIDivCardWorld.this.sd.bannerI();
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\vie\\ui\div\UIDivCardWorld$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */