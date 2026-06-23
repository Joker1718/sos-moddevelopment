/*     */ package settlement.room.water;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BoosterImp;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.room.main.RoomBlueprintIns;
/*     */ import settlement.room.main.RoomInstance;
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
/*     */ class null
/*     */   extends BoosterImp
/*     */ {
/*     */   private int ci;
/*     */   private double c;
/*     */   
/*     */   null(BSourceInfo $anonymous0, double $anonymous1, double $anonymous2, boolean $anonymous3) {
/*  70 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  83 */     this.ci = -120;
/*  84 */     this.c = 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/*  90 */     return vGet(HCLASS_RACE.clP());
/*     */   } public double vGet(Induvidual indu) { RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(indu);
/*     */     if (ins != null && ins.blueprint() == blue)
/*     */       return blue.pumpable(ins.mX(), ins.mY()).irrigation(ins.mX(), ins.mY()); 
/*     */     return 0.0D; } public double vGet(HCLASS_RACE popTime) {
/*  95 */     if (blue instanceof RoomBlueprintIns) {
/*  96 */       RoomBlueprintIns<?> p = (RoomBlueprintIns)blue;
/*  97 */       if (Math.abs(GAME.updateI() - this.ci) >= 120) {
/*  98 */         this.ci = GAME.updateI();
/*  99 */         this.c = 0.0D;
/* 100 */         int am = 0;
/* 101 */         for (int i = 0; i < p.instancesSize(); i++) {
/* 102 */           RoomInstance ins = p.getInstance(i);
/* 103 */           int e = ins.employees().employed();
/* 104 */           this.c += e * blue.pumpable(ins.mX(), ins.mY()).irrigation(ins.mX(), ins.mY());
/* 105 */           am += e;
/*     */         } 
/*     */         
/* 108 */         if (am != 0) {
/* 109 */           this.c /= am;
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 116 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/* 121 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(BOOSTABLE_O o) {
/* 126 */     if (o instanceof FactionNPC)
/* 127 */       return 1.0D; 
/* 128 */     return super.get(o);
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Faction f) {
/* 133 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\ROOM_WATER$2.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */