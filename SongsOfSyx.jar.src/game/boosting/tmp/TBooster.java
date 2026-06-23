/*     */ package game.boosting.tmp;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.battle.div.Div;
/*     */ import game.boosting.BOOSTABLE_O;
/*     */ import game.boosting.BSourceInfo;
/*     */ import game.boosting.BValue;
/*     */ import game.boosting.Boostable;
/*     */ import game.boosting.Booster;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import init.sprite.UI.UI;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import snake2d.util.sprite.SPRITE;
/*     */ import util.text.D;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ class TBooster extends Booster {
/*  22 */   private static CharSequence ¤¤name = "Other Effects";
/*     */   
/*     */   static {
/*  25 */     D.ts(TBooster.class);
/*     */   }
/*     */   
/*     */   private final double from;
/*     */   private final double to;
/*     */   private final BValue value;
/*     */   
/*     */   public TBooster(Boostable target, double min, double max, boolean isMul) {
/*  33 */     super(new BSourceInfo(String.valueOf(¤¤name) + String.valueOf(¤¤name), (SPRITE)(UI.icons()).s.question), isMul);
/*  34 */     this.from = min;
/*  35 */     this.to = max;
/*  36 */     this.value = isMul ? new VBMul(target) : new VBAdd(target);
/*  37 */     add(target);
/*     */   }
/*     */ 
/*     */   
/*     */   public double from() {
/*  42 */     return this.from;
/*     */   }
/*     */ 
/*     */   
/*     */   public double to() {
/*  47 */     return this.to;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getValue(double input) {
/*  52 */     return input;
/*     */   }
/*     */ 
/*     */   
/*     */   protected double pget(BOOSTABLE_O o) {
/*  57 */     return o.boostableValue(this.value);
/*     */   }
/*     */   
/*     */   private static class VBAdd
/*     */     implements BValue
/*     */   {
/*     */     private final Boostable target;
/*     */     
/*     */     VBAdd(Boostable target) {
/*  66 */       this.target = target;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/*  71 */       return (GAME.BOOST()).factions.add(f, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/*  76 */       return (GAME.BOOST()).factions.add(f, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE t) {
/*  81 */       if (t.cl == null || t.cl.player) {
/*  82 */         return (GAME.BOOST()).popcl.add(t, this.target) + (GAME.BOOST()).factions.add(FACTIONS.player(), this.target);
/*     */       }
/*  84 */       return (GAME.BOOST()).popcl.add(t, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/*  89 */       Faction f = div.faction();
/*  90 */       if (f == FACTIONS.player())
/*  91 */         return (GAME.BOOST()).popcl.add(HCLASS_RACE.clP(div.info.race()), this.target); 
/*  92 */       if (f != null)
/*  93 */         return (GAME.BOOST()).factions.add(f, this.target); 
/*  94 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/*  99 */       return (GAME.BOOST()).popcl.add(indu.popCL(), this.target) + (GAME.BOOST()).factions.add(FACTIONS.player(), this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 104 */       if (reg.faction() != null)
/* 105 */         return (GAME.BOOST()).regions.add(reg, this.target) + (GAME.BOOST()).factions.add(reg.faction(), this.target); 
/* 106 */       return (GAME.BOOST()).regions.add(reg, this.target);
/*     */     }
/*     */   }
/*     */   
/*     */   private static class VBMul
/*     */     implements BValue
/*     */   {
/*     */     private final Boostable target;
/*     */     
/*     */     VBMul(Boostable target) {
/* 116 */       this.target = target;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 121 */       return (GAME.BOOST()).factions.mul(f, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 126 */       return (GAME.BOOST()).factions.mul(f, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE t) {
/* 131 */       if (t.cl == null || t.cl.player) {
/* 132 */         return (GAME.BOOST()).popcl.mul(t, this.target) * (GAME.BOOST()).factions.mul(FACTIONS.player(), this.target);
/*     */       }
/* 134 */       return (GAME.BOOST()).popcl.mul(t, this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 139 */       Faction f = div.faction();
/* 140 */       if (f == FACTIONS.player())
/* 141 */         return (GAME.BOOST()).popcl.mul(HCLASS_RACE.clP(div.info.race()), this.target); 
/* 142 */       if (f != null)
/* 143 */         return (GAME.BOOST()).factions.mul(f, this.target); 
/* 144 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 149 */       return (GAME.BOOST()).popcl.mul(indu.popCL(), this.target) * (GAME.BOOST()).factions.mul(FACTIONS.player(), this.target);
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 154 */       if (reg.faction() != null)
/* 155 */         return (GAME.BOOST()).regions.mul(reg, this.target) * (GAME.BOOST()).factions.mul(reg.faction(), this.target); 
/* 156 */       return (GAME.BOOST()).regions.mul(reg, this.target);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\tmp\TBooster.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */