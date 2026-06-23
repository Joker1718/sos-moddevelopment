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
/*     */ import snake2d.util.datatypes.AREA;
/*     */ import snake2d.util.misc.CLAMP;
/*     */ 
/*     */ 
/*     */ 
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
/*  36 */     super($anonymous0, $anonymous1, $anonymous2, $anonymous3);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  49 */     this.ci = -120;
/*  50 */     this.c = 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/*  56 */     return vGet(HCLASS_RACE.clP());
/*     */   } public double vGet(Induvidual indu) { RoomInstance ins = (RoomInstance)(STATS.WORK()).EMPLOYED.get(indu);
/*     */     if (ins != null && ins.blueprint() == blue)
/*     */       return CLAMP.d(RoomIrrigated.this.irrigation(ins) / RoomIrrigated.this.needed((AREA)ins), 0.0D, 1.0D); 
/*     */     return 1.0D; } public double vGet(HCLASS_RACE popTime) {
/*  61 */     if (blue instanceof RoomBlueprintIns) {
/*  62 */       RoomBlueprintIns<?> p = (RoomBlueprintIns)blue;
/*  63 */       if (Math.abs(GAME.updateI() - this.ci) >= 120) {
/*  64 */         this.ci = GAME.updateI();
/*  65 */         this.c = 0.0D;
/*  66 */         int am = 0;
/*  67 */         for (int i = 0; i < p.instancesSize(); i++) {
/*  68 */           RoomInstance ins = p.getInstance(i);
/*  69 */           int e = ins.employees().employed();
/*  70 */           this.c += e * CLAMP.d(RoomIrrigated.this.irrigation(ins) / RoomIrrigated.this.needed((AREA)ins), 0.0D, 1.0D);
/*  71 */           am += e;
/*     */         } 
/*     */         
/*  74 */         if (am != 0) {
/*  75 */           this.c /= am;
/*     */         } else {
/*  77 */           this.c = 1.0D;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  84 */     return this.c;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/*  89 */     return 1.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(Faction f) {
/*  95 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double get(BOOSTABLE_O o) {
/* 100 */     if (o instanceof FactionNPC)
/* 101 */       return 1.0D; 
/* 102 */     return super.get(o);
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\water\RoomIrrigated$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */