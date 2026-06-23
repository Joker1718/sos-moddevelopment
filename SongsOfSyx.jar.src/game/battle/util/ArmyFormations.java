/*     */ package game.battle.util;
/*     */ 
/*     */ import game.GAME;
/*     */ import game.boosting.BOOSTING;
/*     */ import game.boosting.Boostable;
/*     */ import init.paths.PATH;
/*     */ import init.paths.PATHS;
/*     */ import settlement.stats.STATS;
/*     */ import settlement.stats.equip.EquipBattle;
/*     */ import snake2d.util.file.Json;
/*     */ import snake2d.util.misc.ACTION;
/*     */ import snake2d.util.sets.ArrayList;
/*     */ import snake2d.util.sets.ArrayListGrower;
/*     */ import snake2d.util.sets.LIST;
/*     */ import util.keymap.RMAP;
/*     */ 
/*     */ public class ArmyFormations
/*     */ {
/*  19 */   public final ArrayListGrower<ArmyFormation> all = new ArrayListGrower();
/*     */   public final ArmyFormation player;
/*     */   
/*     */   ArmyFormations() {
/*  23 */     PATH p = PATHS.INIT().getFolder("battle").getFolder("formation");
/*  24 */     this.player = new ArmyFormation(new Json(p.gets("_player"))); byte b; int i; String[] arrayOfString;
/*  25 */     for (i = (arrayOfString = p.getFiles()).length, b = 0; b < i; ) { String f = arrayOfString[b];
/*  26 */       this.all.add(new ArmyFormation(new Json(p.gets(f))));
/*     */       b++; }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ArmyFormation
/*     */   {
/*     */     private final LIST<ArmyFormations.Pair> CENTRE;
/*     */     
/*     */     private final LIST<ArmyFormations.Pair> FLANK;
/*     */     
/*     */     private final LIST<ArmyFormations.Pair> FRONT;
/*     */     
/*     */     private final LIST<ArmyFormations.Pair> REAR;
/*     */     private final LIST<ArmyFormations.PairE> CENTRE_E;
/*     */     private final LIST<ArmyFormations.PairE> FLANK_E;
/*     */     private final LIST<ArmyFormations.PairE> FRONT_E;
/*     */     private final LIST<ArmyFormations.PairE> REAR_E;
/*     */     
/*     */     ArmyFormation(Json json) {
/*  47 */       this.CENTRE = boost("PRIORITY_CENTRE", json);
/*  48 */       this.FLANK = boost("PRIORITY_FLANK", json);
/*  49 */       this.FRONT = boost("PRIORITY_FRONT", json);
/*  50 */       this.REAR = boost("PRIORITY_REAR", json);
/*     */       
/*  52 */       this.CENTRE_E = boostE("PRIORITY_CENTRE_E", json);
/*  53 */       this.FLANK_E = boostE("PRIORITY_FLANK_E", json);
/*  54 */       this.FRONT_E = boostE("PRIORITY_FRONT_E", json);
/*  55 */       this.REAR_E = boostE("PRIORITY_REAR_E", json);
/*     */     }
/*     */ 
/*     */     
/*     */     private LIST<ArmyFormations.Pair> boost(final String key, final Json json) {
/*  60 */       final ArrayListGrower<ArmyFormations.Pair> boosts = new ArrayListGrower();
/*  61 */       BOOSTING.connecter(new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/*  65 */               BOOSTING.MAP().getClass();
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  83 */       return (LIST<ArmyFormations.Pair>)boosts;
/*     */     }
/*     */ 
/*     */     
/*     */     private LIST<ArmyFormations.PairE> boostE(final String key, final Json json) {
/*  88 */       final ArrayListGrower<ArmyFormations.PairE> boosts = new ArrayListGrower();
/*  89 */       BOOSTING.connecter(new ACTION()
/*     */           {
/*     */             public void exe()
/*     */             {
/*  93 */               (STATS.EQUIP()).militaryColl.getClass();
/*     */             }
/*     */           });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 111 */       return (LIST<ArmyFormations.PairE>)boosts;
/*     */     }
/*     */ 
/*     */     
/*     */     public ArrayList<ArmyFormations.ArmyFormationDiv> getFirstRow(LIST<DivGeneration> all) {
/* 116 */       ArrayList<ArmyFormations.ArmyFormationDiv> li = new ArrayList(all.size());
/*     */       
/* 118 */       int di = 0;
/* 119 */       for (DivGeneration g : all) {
/*     */         
/* 121 */         DIV_SPEC.DIV_SPECImp s = g.makeSpec();
/* 122 */         ArmyFormations.ArmyFormationDiv d = new ArmyFormations.ArmyFormationDiv(g, di);
/*     */         
/* 124 */         for (ArmyFormations.Pair p : this.CENTRE) {
/* 125 */           d.centre += p.value * GAME.battle().boost(s, p.bo) / (1.0D + p.bo.baseValue);
/*     */         }
/* 127 */         for (ArmyFormations.Pair p : this.FLANK)
/*     */         {
/* 129 */           d.flank += p.value * GAME.battle().boost(s, p.bo) / (1.0D + p.bo.baseValue);
/*     */         }
/* 131 */         for (ArmyFormations.Pair p : this.FRONT) {
/* 132 */           d.front += p.value * GAME.battle().boost(s, p.bo) / (1.0D + p.bo.baseValue);
/*     */         }
/* 134 */         for (ArmyFormations.Pair p : this.REAR) {
/* 135 */           d.rear += p.value * GAME.battle().boost(s, p.bo) / (1.0D + p.bo.baseValue);
/*     */         }
/*     */         
/* 138 */         for (ArmyFormations.PairE p : this.CENTRE_E) {
/* 139 */           d.centre += p.value * s.equip(p.bo);
/*     */         }
/* 141 */         for (ArmyFormations.PairE p : this.FLANK_E) {
/* 142 */           d.flank += p.value * s.equip(p.bo);
/*     */         }
/* 144 */         for (ArmyFormations.PairE p : this.FRONT_E) {
/* 145 */           d.front += p.value * s.equip(p.bo);
/*     */         }
/* 147 */         for (ArmyFormations.PairE p : this.REAR_E) {
/* 148 */           d.rear += p.value * s.equip(p.bo);
/*     */         }
/*     */ 
/*     */         
/* 152 */         li.add(d);
/* 153 */         di++;
/*     */       } 
/* 155 */       return li;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public ArmyFormations.ArmyFormationDiv get(LIST<ArmyFormations.ArmyFormationDiv> all, double centre, double flank, double front, double rear) {
/* 161 */       ArmyFormations.ArmyFormationDiv res = null;
/* 162 */       double value = Double.MIN_VALUE;
/*     */       
/* 164 */       for (ArmyFormations.ArmyFormationDiv d : all) {
/*     */ 
/*     */         
/* 167 */         double v = d.value(centre, flank, front, rear);
/* 168 */         if (res == null || v > value) {
/* 169 */           res = d;
/* 170 */           value = v;
/*     */         } 
/*     */       } 
/*     */       
/* 174 */       return res;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Pair
/*     */   {
/*     */     public final Boostable bo;
/*     */ 
/*     */     
/*     */     public double value;
/*     */ 
/*     */     
/*     */     public Pair(Boostable bo) {
/* 189 */       this.bo = bo;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PairE
/*     */   {
/*     */     public final EquipBattle bo;
/*     */     public double value;
/*     */     
/*     */     public PairE(EquipBattle bo) {
/* 199 */       this.bo = bo;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ArmyFormationDiv
/*     */   {
/*     */     public double centre;
/*     */     
/*     */     public double flank;
/*     */     public double front;
/*     */     public double rear;
/*     */     public DivGeneration g;
/*     */     public final int divID;
/*     */     
/*     */     ArmyFormationDiv(DivGeneration g, int divID) {
/* 215 */       this.g = g;
/* 216 */       this.divID = divID;
/*     */     }
/*     */     
/*     */     public double value(double centre, double flank, double front, double rear) {
/* 220 */       return this.centre * centre + this.flank * flank + this.front * front + this.rear * rear;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Administrator\Documents\Tasks\Works.Dump\SongsOfSyx\mods_development\SongsOfSyx.jar!\game\battl\\util\ArmyFormations.class
 * Java compiler version: 16 (60.0)
 * JD-Core Version:       1.1.3
 */