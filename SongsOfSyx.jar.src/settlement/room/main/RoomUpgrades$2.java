/*     */ package settlement.room.main;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.STATS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   extends BoosterImp
/*     */ {
/*     */   private int ci;
/*     */   private double c;
/*     */   
/*     */   null(BSourceInfo $anonymous0, double $anonymous1, double $anonymous2, boolean $anonymous3) {
/* 150 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 174 */     this.ci = -120;
/* 175 */     this.c = 0.0D;
/*     */   } public double get(BOOSTABLE_O o) {
/*     */     if (o instanceof FactionNPC)
/*     */       return 0.0D; 
/*     */     return o.boostableValue((BValue)this);
/*     */   } public double vGet(Player f) {
/* 181 */     return vGet(HCLASS_RACE.clP());
/*     */   } public double vGet(Induvidual indu) {
/*     */     return get((RoomInstance)(STATS.WORK()).EMPLOYED.get(indu));
/*     */   } private double get(RoomInstance ins) {
/* 185 */     if (ins != null && ins.blueprint() == blue) {
/* 186 */       return ins.blueprintI().upgrades().boost(ins.upgrade());
/*     */     }
/* 188 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE popTime) {
/* 193 */     if (Math.abs(GAME.updateI() - this.ci) >= 120) {
/* 194 */       this.ci = GAME.updateI();
/* 195 */       this.c = 0.0D;
/* 196 */       int am = 0;
/* 197 */       for (int i = 0; i < blue.instancesSize(); i++) {
/* 198 */         RoomInstance ins = blue.getInstance(i);
/* 199 */         int e = ins.employees().employed();
/* 200 */         this.c += e * get(ins);
/* 201 */         am += e;
/*     */       } 
/*     */       
/* 204 */       if (am != 0) {
/* 205 */         this.c /= am;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 210 */     return this.c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 219 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(Faction f) {
/* 225 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\main\RoomUpgrades$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */