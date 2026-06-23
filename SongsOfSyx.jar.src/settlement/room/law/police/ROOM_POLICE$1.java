/*     */ package settlement.room.law.police;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BValue;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.race.RACES;
/*     */ import init.race.Race;
/*     */ import init.type.HCLASS;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import settlement.stats.POP;
/*     */ import snake2d.util.file.Alloc;
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
/*     */ class null
/*     */   implements BValue
/*     */ {
/*  57 */   private int[] upIs = Alloc.ii(HCLASS_RACE.ALL().size());
/*  58 */   private double[] vv = new double[HCLASS_RACE.ALL().size()];
/*     */ 
/*     */   
/*     */   public double vGet(FactionNPC f) {
/*  62 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Player f) {
/*  67 */     return vGet(HCLASS_RACE.clP());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double vGet(HCLASS_RACE cl) {
/*  74 */     if (this.upIs[cl.index] != GAME.updateI()) {
/*  75 */       this.upIs[cl.index] = GAME.updateI();
/*  76 */       if (cl.cl == null) {
/*  77 */         double pop = 0.0D;
/*  78 */         double v = 0.0D;
/*  79 */         for (int ci = 0; ci < HCLASSES.ALLP().size(); ci++) {
/*  80 */           double p = POP.pop((HCLASS)HCLASSES.ALLP().get(ci), cl.race);
/*  81 */           pop += p;
/*  82 */           v += p * vGet(HCLASS_RACE.clP(cl.race, (HCLASS)HCLASSES.ALLP().get(ci)));
/*     */         } 
/*  84 */         if (pop == 0.0D)
/*  85 */         { this.vv[cl.index] = 0.0D; }
/*     */         else
/*  87 */         { this.vv[cl.index] = v / pop; } 
/*  88 */       } else if (cl.race == null) {
/*  89 */         double pop = 0.0D;
/*  90 */         double v = 0.0D;
/*  91 */         for (int ri = 0; ri < RACES.all().size(); ri++) {
/*  92 */           double p = POP.pop(cl.cl, (Race)RACES.all().get(ri));
/*  93 */           pop += p;
/*  94 */           v += p * vGet(HCLASS_RACE.clP((Race)RACES.all().get(ri), cl.cl));
/*     */         } 
/*  96 */         if (pop == 0.0D) {
/*  97 */           this.vv[cl.index] = 0.0D;
/*     */         } else {
/*  99 */           this.vv[cl.index] = v / pop;
/*     */         } 
/* 101 */       } else if (!((BOOLEAN.BOOLEANImp)ROOM_POLICE.this.access.get(cl.index())).is()) {
/* 102 */         this.vv[cl.index] = 0.0D;
/*     */       } else {
/* 104 */         this.vv[cl.index()] = ROOM_POLICE.this.value();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 112 */     return this.vv[cl.index];
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Div div) {
/* 117 */     return vGet(HCLASS_RACE.clP(div.race(), HCLASSES.CITIZEN()));
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Induvidual indu) {
/* 122 */     return vGet(indu.popCL());
/*     */   }
/*     */ 
/*     */   
/*     */   public double vGet(Region reg) {
/* 127 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\settlement\room\law\police\ROOM_POLICE$1.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */