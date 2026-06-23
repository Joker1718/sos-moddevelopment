/*     */ package game.boosting;
/*     */ 
/*     */ import game.battle.div.Div;
/*     */ import game.faction.FACTIONS;
/*     */ import game.faction.Faction;
/*     */ import game.faction.npc.FactionNPC;
/*     */ import game.faction.player.Player;
/*     */ import game.faction.royalty.Royalty;
/*     */ import init.type.HCLASSES;
/*     */ import init.type.HCLASS_RACE;
/*     */ import settlement.stats.Induvidual;
/*     */ import world.map.regions.Region;
/*     */ 
/*     */ public interface BValue
/*     */ {
/*     */   default double vGet(Royalty roy) {
/*  17 */     return vGet(roy.induvidual);
/*     */   }
/*     */   
/*     */   double vGet(Region paramRegion);
/*     */   
/*     */   double vGet(Induvidual paramInduvidual);
/*     */   
/*     */   double vGet(Div paramDiv);
/*     */   
/*     */   double vGet(HCLASS_RACE paramHCLASS_RACE);
/*     */   
/*     */   double vGet(Player paramPlayer);
/*     */   
/*     */   double vGet(FactionNPC paramFactionNPC);
/*     */   
/*     */   default double vGet(Faction f) {
/*  33 */     if (f == null)
/*  34 */       return 0.0D; 
/*  35 */     if (f instanceof FactionNPC) {
/*  36 */       return vGet((FactionNPC)f);
/*     */     }
/*  38 */     return vGet(FACTIONS.player());
/*     */   }
/*     */   
/*     */   public static class BValueNone
/*     */     implements BValue
/*     */   {
/*     */     public double vGet(Region reg) {
/*  45 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/*  50 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/*  55 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Faction f) {
/*  60 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE reg) {
/*  65 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/*  70 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/*  75 */       return 0.0D;
/*     */     }
/*     */   }
/*     */   
/*     */   public static class BValueSome
/*     */     implements BValue {
/*     */     private final double v;
/*     */     
/*     */     public BValueSome(double v) {
/*  84 */       this.v = v;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/*  89 */       return this.v;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/*  94 */       return this.v;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/*  99 */       return this.v;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Faction f) {
/* 104 */       return this.v;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE reg) {
/* 109 */       return this.v;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 114 */       return this.v;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 119 */       return this.v;
/*     */     }
/*     */   }
/*     */   
/* 123 */   public static final BValue VALUE1 = new BValueSome(1.0D);
/*     */   
/* 125 */   public static final BValue VALUE0 = new BValueNone();
/*     */   
/*     */   public static abstract class BValueAll
/*     */     implements BValue
/*     */   {
/*     */     public double vGet(Region reg) {
/* 131 */       return get();
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 136 */       return get();
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 141 */       return get();
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Faction f) {
/* 146 */       return get();
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 151 */       return get();
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 156 */       return get();
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE reg) {
/* 161 */       return get();
/*     */     }
/*     */     
/*     */     public abstract double get();
/*     */   }
/*     */   
/*     */   public static abstract class BValueFaction
/*     */     implements BValue
/*     */   {
/*     */     private final Boostable bb;
/*     */     
/*     */     public BValueFaction(Boostable bo) {
/* 173 */       this.bb = bo;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 178 */       return vGet(reg.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 183 */       return vGet(indu.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 188 */       return vGet(div.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE reg) {
/* 193 */       return vGet(FACTIONS.player());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 198 */       return f.bonus.getD(this.bb);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static interface BValuePlayerOnly
/*     */     extends BValue
/*     */   {
/*     */     default double vGet(Region reg) {
/* 210 */       return vGet(reg.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     default double vGet(Induvidual indu) {
/* 215 */       return vGet(indu.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     default double vGet(Div div) {
/* 220 */       return vGet(div.faction());
/*     */     }
/*     */ 
/*     */     
/*     */     default double vGet(HCLASS_RACE reg) {
/* 225 */       return vGet(FACTIONS.player());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class BValueInduOnly
/*     */     implements BValue
/*     */   {
/*     */     public double vGet(Region reg) {
/* 241 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(FactionNPC f) {
/* 246 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 251 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(HCLASS_RACE reg) {
/* 256 */       return 0.0D;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class BValuePop
/*     */     implements BValue
/*     */   {
/*     */     public double vGet(FactionNPC f) {
/* 271 */       return 0.0D;
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Player f) {
/* 276 */       return vGet(HCLASS_RACE.clP());
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public double vGet(Div div) {
/* 282 */       return vGet(HCLASS_RACE.clP(div.race(), HCLASSES.CITIZEN()));
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Induvidual indu) {
/* 287 */       return vGet(indu.popCL());
/*     */     }
/*     */ 
/*     */     
/*     */     public double vGet(Region reg) {
/* 292 */       return 0.0D;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\boosting\BValue.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */